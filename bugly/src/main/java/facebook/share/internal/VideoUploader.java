/*     */ package com.facebook.share.internal;
/*     */ 
/*     */ import android.content.ContentResolver;
/*     */ import android.content.Context;
/*     */ import android.net.Uri;
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import android.os.ParcelFileDescriptor;
/*     */ import android.os.ParcelFileDescriptor.AutoCloseInputStream;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.AccessTokenTracker;
/*     */ import com.facebook.FacebookCallback;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookGraphResponseException;
/*     */ import com.facebook.FacebookRequestError;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.GraphRequest;
/*     */ import com.facebook.GraphResponse;
/*     */ import com.facebook.HttpMethod;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Validate;
/*     */ import com.facebook.internal.WorkQueue;
/*     */ import com.facebook.internal.WorkQueue.WorkItem;
/*     */ import com.facebook.share.Sharer.Result;
/*     */ import com.facebook.share.model.ShareVideo;
/*     */ import com.facebook.share.model.ShareVideoContent;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.HashSet;
/*     */ import java.util.Locale;
/*     */ import java.util.Set;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VideoUploader
/*     */ {
/*     */   private static final String TAG = "VideoUploader";
/*     */   private static final String PARAM_UPLOAD_PHASE = "upload_phase";
/*     */   private static final String PARAM_VALUE_UPLOAD_START_PHASE = "start";
/*     */   private static final String PARAM_VALUE_UPLOAD_TRANSFER_PHASE = "transfer";
/*     */   private static final String PARAM_VALUE_UPLOAD_FINISH_PHASE = "finish";
/*     */   private static final String PARAM_TITLE = "title";
/*     */   private static final String PARAM_DESCRIPTION = "description";
/*     */   private static final String PARAM_REF = "ref";
/*     */   private static final String PARAM_FILE_SIZE = "file_size";
/*     */   private static final String PARAM_SESSION_ID = "upload_session_id";
/*     */   private static final String PARAM_VIDEO_ID = "video_id";
/*     */   private static final String PARAM_START_OFFSET = "start_offset";
/*     */   private static final String PARAM_END_OFFSET = "end_offset";
/*     */   private static final String PARAM_VIDEO_FILE_CHUNK = "video_file_chunk";
/*     */   private static final String ERROR_UPLOAD = "Video upload failed";
/*     */   private static final String ERROR_BAD_SERVER_RESPONSE = "Unexpected error in server response";
/*     */   private static final int UPLOAD_QUEUE_MAX_CONCURRENT = 8;
/*     */   private static final int MAX_RETRIES_PER_PHASE = 2;
/*     */   private static final int RETRY_DELAY_UNIT_MS = 5000;
/*     */   private static final int RETRY_DELAY_BACK_OFF_FACTOR = 3;
/*     */   private static boolean initialized;
/*     */   private static Handler handler;
/*  95 */   private static WorkQueue uploadQueue = new WorkQueue(8);
/*     */   
/*  97 */   private static Set<UploadContext> pendingUploads = new HashSet();
/*     */   
/*     */   private static AccessTokenTracker accessTokenTracker;
/*     */   
/*     */ 
/*     */   public static synchronized void uploadAsync(ShareVideoContent videoContent, FacebookCallback<Sharer.Result> callback)
/*     */     throws FileNotFoundException
/*     */   {
/* 105 */     uploadAsync(videoContent, "me", callback);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static synchronized void uploadAsync(ShareVideoContent videoContent, String graphNode, FacebookCallback<Sharer.Result> callback)
/*     */     throws FileNotFoundException
/*     */   {
/* 113 */     if (!initialized) {
/* 114 */       registerAccessTokenTracker();
/* 115 */       initialized = true;
/*     */     }
/*     */     
/* 118 */     Validate.notNull(videoContent, "videoContent");
/* 119 */     Validate.notNull(graphNode, "graphNode");
/* 120 */     ShareVideo video = videoContent.getVideo();
/* 121 */     Validate.notNull(video, "videoContent.video");
/* 122 */     Uri videoUri = video.getLocalUrl();
/* 123 */     Validate.notNull(videoUri, "videoContent.video.localUrl");
/*     */     
/* 125 */     UploadContext uploadContext = new UploadContext(videoContent, graphNode, callback, null);
/* 126 */     uploadContext.initialize();
/*     */     
/* 128 */     pendingUploads.add(uploadContext);
/*     */     
/* 130 */     enqueueUploadStart(uploadContext, 0);
/*     */   }
/*     */   
/*     */ 
/*     */   private static synchronized void cancelAllRequests()
/*     */   {
/* 136 */     for (UploadContext uploadContext : pendingUploads) {
/* 137 */       uploadContext.isCanceled = true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static synchronized void removePendingUpload(UploadContext uploadContext)
/*     */   {
/* 143 */     pendingUploads.remove(uploadContext);
/*     */   }
/*     */   
/*     */   private static synchronized Handler getHandler() {
/* 147 */     if (handler == null) {
/* 148 */       handler = new Handler(Looper.getMainLooper());
/*     */     }
/* 150 */     return handler;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void issueResponse(UploadContext uploadContext, FacebookException error, String videoId)
/*     */   {
/* 159 */     removePendingUpload(uploadContext);
/*     */     
/* 161 */     Utility.closeQuietly(uploadContext.videoStream);
/*     */     
/* 163 */     if (uploadContext.callback != null) {
/* 164 */       if (error != null) {
/* 165 */         ShareInternalUtility.invokeOnErrorCallback(uploadContext.callback, error);
/* 166 */       } else if (uploadContext.isCanceled) {
/* 167 */         ShareInternalUtility.invokeOnCancelCallback(uploadContext.callback);
/*     */       } else {
/* 169 */         ShareInternalUtility.invokeOnSuccessCallback(uploadContext.callback, videoId);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void enqueueUploadStart(UploadContext uploadContext, int completedRetries) {
/* 175 */     enqueueRequest(uploadContext, new StartUploadWorkItem(uploadContext, completedRetries));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void enqueueUploadChunk(UploadContext uploadContext, String chunkStart, String chunkEnd, int completedRetries)
/*     */   {
/* 187 */     enqueueRequest(uploadContext, new TransferChunkWorkItem(uploadContext, chunkStart, chunkEnd, completedRetries));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void enqueueUploadFinish(UploadContext uploadContext, int completedRetries)
/*     */   {
/* 197 */     enqueueRequest(uploadContext, new FinishUploadWorkItem(uploadContext, completedRetries));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static synchronized void enqueueRequest(UploadContext uploadContext, Runnable workItem)
/*     */   {
/* 207 */     uploadContext.workItem = uploadQueue.addActiveWorkItem(workItem);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static byte[] getChunk(UploadContext uploadContext, String chunkStart, String chunkEnd)
/*     */     throws IOException
/*     */   {
/* 215 */     if (!Utility.areObjectsEqual(chunkStart, uploadContext.chunkStart))
/*     */     {
/* 217 */       logError(null, "Error reading video chunk. Expected chunk '%s'. Requested chunk '%s'.", new Object[] { uploadContext.chunkStart, chunkStart });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 222 */       return null;
/*     */     }
/*     */     
/* 225 */     long chunkStartLong = Long.parseLong(chunkStart);
/* 226 */     long chunkEndLong = Long.parseLong(chunkEnd);
/* 227 */     int chunkSize = (int)(chunkEndLong - chunkStartLong);
/*     */     
/* 229 */     ByteArrayOutputStream byteBufferStream = new ByteArrayOutputStream();
/* 230 */     int bufferSize = Math.min(8192, chunkSize);
/* 231 */     byte[] buffer = new byte[bufferSize];
/*     */     
/*     */     int len;
/* 234 */     while ((len = uploadContext.videoStream.read(buffer)) != -1) {
/* 235 */       byteBufferStream.write(buffer, 0, len);
/*     */       
/* 237 */       chunkSize -= len;
/* 238 */       if (chunkSize != 0)
/*     */       {
/*     */ 
/* 241 */         if (chunkSize < 0)
/*     */         {
/* 243 */           logError(null, "Error reading video chunk. Expected buffer length - '%d'. Actual - '%d'.", new Object[] {
/*     */           
/*     */ 
/* 246 */             Integer.valueOf(chunkSize + len), 
/* 247 */             Integer.valueOf(len) });
/* 248 */           return null;
/*     */         }
/*     */       }
/*     */     }
/* 252 */     uploadContext.chunkStart = chunkEnd;
/*     */     
/* 254 */     return byteBufferStream.toByteArray();
/*     */   }
/*     */   
/*     */   private static void registerAccessTokenTracker() {
/* 258 */     accessTokenTracker = new AccessTokenTracker()
/*     */     {
/*     */ 
/*     */       protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken)
/*     */       {
/* 263 */         if (oldAccessToken == null)
/*     */         {
/* 265 */           return;
/*     */         }
/*     */         
/* 268 */         if ((currentAccessToken == null) || 
/* 269 */           (!Utility.areObjectsEqual(currentAccessToken
/* 270 */           .getUserId(), oldAccessToken
/* 271 */           .getUserId())))
/*     */         {
/* 273 */           VideoUploader.access$200();
/*     */         }
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void logError(Exception e, String format, Object... args)
/*     */   {
/* 283 */     Log.e("VideoUploader", String.format(Locale.ROOT, format, args), e);
/*     */   }
/*     */   
/*     */ 
/*     */   private static class UploadContext
/*     */   {
/*     */     public final Uri videoUri;
/*     */     
/*     */     public final String title;
/*     */     public final String description;
/*     */     public final String ref;
/*     */     public final String graphNode;
/*     */     public final AccessToken accessToken;
/*     */     public final FacebookCallback<Sharer.Result> callback;
/*     */     public String sessionId;
/*     */     public String videoId;
/*     */     public InputStream videoStream;
/*     */     public long videoSize;
/* 301 */     public String chunkStart = "0";
/*     */     
/*     */ 
/*     */     public boolean isCanceled;
/*     */     
/*     */     public WorkQueue.WorkItem workItem;
/*     */     
/*     */     public Bundle params;
/*     */     
/*     */ 
/*     */     private UploadContext(ShareVideoContent videoContent, String graphNode, FacebookCallback<Sharer.Result> callback)
/*     */     {
/* 313 */       this.accessToken = AccessToken.getCurrentAccessToken();
/* 314 */       this.videoUri = videoContent.getVideo().getLocalUrl();
/* 315 */       this.title = videoContent.getContentTitle();
/* 316 */       this.description = videoContent.getContentDescription();
/* 317 */       this.ref = videoContent.getRef();
/* 318 */       this.graphNode = graphNode;
/* 319 */       this.callback = callback;
/* 320 */       this.params = videoContent.getVideo().getParameters();
/* 321 */       if (!Utility.isNullOrEmpty(videoContent.getPeopleIds())) {
/* 322 */         this.params.putString("tags", TextUtils.join(", ", videoContent.getPeopleIds()));
/*     */       }
/*     */       
/* 325 */       if (!Utility.isNullOrEmpty(videoContent.getPlaceId())) {
/* 326 */         this.params.putString("place", videoContent.getPlaceId());
/*     */       }
/*     */       
/* 329 */       if (!Utility.isNullOrEmpty(videoContent.getRef())) {
/* 330 */         this.params.putString("ref", videoContent.getRef());
/*     */       }
/*     */     }
/*     */     
/*     */     private void initialize() throws FileNotFoundException
/*     */     {
/*     */       try
/*     */       {
/* 338 */         if (Utility.isFileUri(this.videoUri)) {
/* 339 */           ParcelFileDescriptor fileDescriptor = ParcelFileDescriptor.open(new File(this.videoUri
/* 340 */             .getPath()), 268435456);
/*     */           
/* 342 */           this.videoSize = fileDescriptor.getStatSize();
/* 343 */           this.videoStream = new AutoCloseInputStream(fileDescriptor);
/* 344 */         } else if (Utility.isContentUri(this.videoUri)) {
/* 345 */           this.videoSize = Utility.getContentSize(this.videoUri);
/*     */           
/*     */ 
/*     */ 
/* 349 */           this.videoStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(this.videoUri);
/*     */         } else {
/* 351 */           throw new FacebookException("Uri must be a content:// or file:// uri");
/*     */         }
/*     */       } catch (FileNotFoundException e) {
/* 354 */         Utility.closeQuietly(this.videoStream);
/*     */         
/* 356 */         throw e;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static class StartUploadWorkItem extends UploadWorkItemBase {
/* 362 */     static final Set<Integer> transientErrorCodes = new HashSet() {};
/*     */     
/*     */ 
/*     */     public StartUploadWorkItem(UploadContext uploadContext, int completedRetries)
/*     */     {
/* 367 */       super(completedRetries);
/*     */     }
/*     */     
/*     */     public Bundle getParameters()
/*     */     {
/* 372 */       Bundle parameters = new Bundle();
/* 373 */       parameters.putString("upload_phase", "start");
/* 374 */       parameters.putLong("file_size", this.uploadContext.videoSize);
/*     */       
/* 376 */       return parameters;
/*     */     }
/*     */     
/*     */     protected void handleSuccess(JSONObject jsonObject)
/*     */       throws JSONException
/*     */     {
/* 382 */       this.uploadContext.sessionId = jsonObject.getString("upload_session_id");
/* 383 */       this.uploadContext.videoId = jsonObject.getString("video_id");
/* 384 */       String startOffset = jsonObject.getString("start_offset");
/* 385 */       String endOffset = jsonObject.getString("end_offset");
/*     */       
/* 387 */       VideoUploader.enqueueUploadChunk(this.uploadContext, startOffset, endOffset, 0);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     protected void handleError(FacebookException error)
/*     */     {
/* 396 */       VideoUploader.logError(error, "Error starting video upload", new Object[0]);
/* 397 */       endUploadWithFailure(error);
/*     */     }
/*     */     
/*     */     protected Set<Integer> getTransientErrorCodes()
/*     */     {
/* 402 */       return transientErrorCodes;
/*     */     }
/*     */     
/*     */     protected void enqueueRetry(int retriesCompleted)
/*     */     {
/* 407 */       VideoUploader.enqueueUploadStart(this.uploadContext, retriesCompleted);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class TransferChunkWorkItem extends UploadWorkItemBase {
/* 412 */     static final Set<Integer> transientErrorCodes = new HashSet() {};
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private String chunkStart;
/*     */     
/*     */ 
/*     */ 
/*     */     private String chunkEnd;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public TransferChunkWorkItem(UploadContext uploadContext, String chunkStart, String chunkEnd, int completedRetries)
/*     */     {
/* 428 */       super(completedRetries);
/* 429 */       this.chunkStart = chunkStart;
/* 430 */       this.chunkEnd = chunkEnd;
/*     */     }
/*     */     
/*     */     public Bundle getParameters()
/*     */       throws IOException
/*     */     {
/* 436 */       Bundle parameters = new Bundle();
/* 437 */       parameters.putString("upload_phase", "transfer");
/* 438 */       parameters.putString("upload_session_id", this.uploadContext.sessionId);
/* 439 */       parameters.putString("start_offset", this.chunkStart);
/*     */       
/* 441 */       byte[] chunk = VideoUploader.getChunk(this.uploadContext, this.chunkStart, this.chunkEnd);
/* 442 */       if (chunk != null) {
/* 443 */         parameters.putByteArray("video_file_chunk", chunk);
/*     */       } else {
/* 445 */         throw new FacebookException("Error reading video");
/*     */       }
/*     */       
/* 448 */       return parameters;
/*     */     }
/*     */     
/*     */     protected void handleSuccess(JSONObject jsonObject)
/*     */       throws JSONException
/*     */     {
/* 454 */       String startOffset = jsonObject.getString("start_offset");
/* 455 */       String endOffset = jsonObject.getString("end_offset");
/*     */       
/* 457 */       if (Utility.areObjectsEqual(startOffset, endOffset)) {
/* 458 */         VideoUploader.enqueueUploadFinish(this.uploadContext, 0);
/*     */       }
/*     */       else
/*     */       {
/* 462 */         VideoUploader.enqueueUploadChunk(this.uploadContext, startOffset, endOffset, 0);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     protected void handleError(FacebookException error)
/*     */     {
/* 472 */       VideoUploader.logError(error, "Error uploading video '%s'", new Object[] { this.uploadContext.videoId });
/* 473 */       endUploadWithFailure(error);
/*     */     }
/*     */     
/*     */     protected Set<Integer> getTransientErrorCodes()
/*     */     {
/* 478 */       return transientErrorCodes;
/*     */     }
/*     */     
/*     */     protected void enqueueRetry(int retriesCompleted)
/*     */     {
/* 483 */       VideoUploader.enqueueUploadChunk(this.uploadContext, this.chunkStart, this.chunkEnd, retriesCompleted);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class FinishUploadWorkItem extends UploadWorkItemBase {
/* 488 */     static final Set<Integer> transientErrorCodes = new HashSet() {};
/*     */     
/*     */ 
/*     */     public FinishUploadWorkItem(UploadContext uploadContext, int completedRetries)
/*     */     {
/* 493 */       super(completedRetries);
/*     */     }
/*     */     
/*     */     public Bundle getParameters()
/*     */     {
/* 498 */       Bundle parameters = new Bundle();
/* 499 */       if (this.uploadContext.params != null) {
/* 500 */         parameters.putAll(this.uploadContext.params);
/*     */       }
/* 502 */       parameters.putString("upload_phase", "finish");
/* 503 */       parameters.putString("upload_session_id", this.uploadContext.sessionId);
/* 504 */       Utility.putNonEmptyString(parameters, "title", this.uploadContext.title);
/* 505 */       Utility.putNonEmptyString(parameters, "description", this.uploadContext.description);
/* 506 */       Utility.putNonEmptyString(parameters, "ref", this.uploadContext.ref);
/*     */       
/* 508 */       return parameters;
/*     */     }
/*     */     
/*     */     protected void handleSuccess(JSONObject jsonObject)
/*     */       throws JSONException
/*     */     {
/* 514 */       if (jsonObject.getBoolean("success")) {
/* 515 */         issueResponseOnMainThread(null, this.uploadContext.videoId);
/*     */       } else {
/* 517 */         handleError(new FacebookException("Unexpected error in server response"));
/*     */       }
/*     */     }
/*     */     
/*     */     protected void handleError(FacebookException error)
/*     */     {
/* 523 */       VideoUploader.logError(error, "Video '%s' failed to finish uploading", new Object[] { this.uploadContext.videoId });
/* 524 */       endUploadWithFailure(error);
/*     */     }
/*     */     
/*     */     protected Set<Integer> getTransientErrorCodes()
/*     */     {
/* 529 */       return transientErrorCodes;
/*     */     }
/*     */     
/*     */     protected void enqueueRetry(int retriesCompleted)
/*     */     {
/* 534 */       VideoUploader.enqueueUploadFinish(this.uploadContext, retriesCompleted);
/*     */     }
/*     */   }
/*     */   
/*     */   private static abstract class UploadWorkItemBase implements Runnable
/*     */   {
/*     */     protected UploadContext uploadContext;
/*     */     protected int completedRetries;
/*     */     
/*     */     protected UploadWorkItemBase(UploadContext uploadContext, int completedRetries)
/*     */     {
/* 545 */       this.uploadContext = uploadContext;
/* 546 */       this.completedRetries = completedRetries;
/*     */     }
/*     */     
/*     */     public void run()
/*     */     {
/* 551 */       if (!this.uploadContext.isCanceled) {
/*     */         try {
/* 553 */           executeGraphRequestSynchronously(getParameters());
/*     */         } catch (FacebookException fe) {
/* 555 */           endUploadWithFailure(fe);
/*     */         } catch (Exception e) {
/* 557 */           endUploadWithFailure(new FacebookException("Video upload failed", e));
/*     */         }
/*     */         
/*     */       } else {
/* 561 */         endUploadWithFailure(null);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     protected void executeGraphRequestSynchronously(Bundle parameters)
/*     */     {
/* 568 */       GraphRequest request = new GraphRequest(this.uploadContext.accessToken, String.format(Locale.ROOT, "%s/videos", new Object[] { this.uploadContext.graphNode }), parameters, HttpMethod.POST, null);
/*     */       
/*     */ 
/*     */ 
/* 572 */       GraphResponse response = request.executeAndWait();
/*     */       
/* 574 */       if (response != null) {
/* 575 */         FacebookRequestError error = response.getError();
/* 576 */         JSONObject responseJSON = response.getJSONObject();
/* 577 */         if (error != null) {
/* 578 */           if (!attemptRetry(error.getSubErrorCode())) {
/* 579 */             handleError(new FacebookGraphResponseException(response, "Video upload failed"));
/*     */           }
/* 581 */         } else if (responseJSON != null) {
/*     */           try {
/* 583 */             handleSuccess(responseJSON);
/*     */           } catch (JSONException e) {
/* 585 */             endUploadWithFailure(new FacebookException("Unexpected error in server response", e));
/*     */           }
/*     */         } else {
/* 588 */           handleError(new FacebookException("Unexpected error in server response"));
/*     */         }
/*     */       } else {
/* 591 */         handleError(new FacebookException("Unexpected error in server response"));
/*     */       }
/*     */     }
/*     */     
/*     */     private boolean attemptRetry(int errorCode) {
/* 596 */       if ((this.completedRetries < 2) && 
/* 597 */         (getTransientErrorCodes().contains(Integer.valueOf(errorCode)))) {
/* 598 */         int delay = 5000 * (int)Math.pow(3.0D, this.completedRetries);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 603 */         VideoUploader.access$800().postDelayed(new Runnable()
/*     */         {
/*     */ 
/* 606 */           public void run() { UploadWorkItemBase.this.enqueueRetry(UploadWorkItemBase.this.completedRetries + 1); } }, delay);
/*     */         
/*     */ 
/*     */ 
/* 610 */         return true;
/*     */       }
/* 612 */       return false;
/*     */     }
/*     */     
/*     */     protected void endUploadWithFailure(FacebookException error)
/*     */     {
/* 617 */       issueResponseOnMainThread(error, null);
/*     */     }
/*     */     
/*     */ 
/*     */     protected void issueResponseOnMainThread(final FacebookException error, final String videoId)
/*     */     {
/* 623 */       VideoUploader.access$800().post(new Runnable()
/*     */       {
/*     */         public void run() {
/* 626 */           VideoUploader.issueResponse(UploadWorkItemBase.this.uploadContext, error, videoId);
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*     */     protected abstract Bundle getParameters()
/*     */       throws Exception;
/*     */     
/*     */     protected abstract void handleSuccess(JSONObject paramJSONObject)
/*     */       throws JSONException;
/*     */     
/*     */     protected abstract void handleError(FacebookException paramFacebookException);
/*     */     
/*     */     protected abstract Set<Integer> getTransientErrorCodes();
/*     */     
/*     */     protected abstract void enqueueRetry(int paramInt);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/VideoUploader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */