/*     */ package com.facebook.share.internal;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.Dialog;
/*     */ import android.content.DialogInterface;
/*     */ import android.content.Intent;
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.support.v4.app.DialogFragment;
/*     */ import android.support.v4.app.FragmentActivity;
/*     */ import android.support.v4.app.FragmentManager;
/*     */ import android.support.v4.app.FragmentTransaction;
/*     */ import android.text.Html;
/*     */ import android.view.LayoutInflater;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import android.view.ViewGroup;
/*     */ import android.widget.Button;
/*     */ import android.widget.ProgressBar;
/*     */ import android.widget.TextView;
/*     */ import com.facebook.FacebookRequestError;
/*     */ import com.facebook.GraphRequest;
/*     */ import com.facebook.GraphRequest.Callback;
/*     */ import com.facebook.GraphResponse;
/*     */ import com.facebook.HttpMethod;
/*     */ import com.facebook.R.id;
/*     */ import com.facebook.R.layout;
/*     */ import com.facebook.R.string;
/*     */ import com.facebook.R.style;
/*     */ import com.facebook.devicerequests.internal.DeviceRequestsHelper;
/*     */ import com.facebook.internal.Validate;
/*     */ import com.facebook.share.model.ShareContent;
/*     */ import com.facebook.share.model.ShareLinkContent;
/*     */ import com.facebook.share.model.ShareOpenGraphContent;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.ScheduledThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ public class DeviceShareDialogFragment
/*     */   extends DialogFragment
/*     */ {
/*     */   public static final String TAG = "DeviceShareDialogFragment";
/*     */   private static final String DEVICE_SHARE_ENDPOINT = "device/share";
/*     */   private static final String REQUEST_STATE_KEY = "request_state";
/*     */   private ProgressBar progressBar;
/*     */   private TextView confirmationCode;
/*     */   private Dialog dialog;
/*     */   private volatile RequestState currentRequestState;
/*     */   private volatile ScheduledFuture codeExpiredFuture;
/*     */   private static ScheduledThreadPoolExecutor backgroundExecutor;
/*     */   private ShareContent shareContent;
/*     */   
/*     */   @Nullable
/*     */   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
/*     */   {
/*  82 */     View view = super.onCreateView(inflater, container, savedInstanceState);
/*  83 */     if (savedInstanceState != null) {
/*  84 */       RequestState requestState = (RequestState)savedInstanceState.getParcelable("request_state");
/*  85 */       if (requestState != null) {
/*  86 */         setCurrentRequestState(requestState);
/*     */       }
/*     */     }
/*  89 */     return view;
/*     */   }
/*     */   
/*     */   @NonNull
/*     */   public Dialog onCreateDialog(Bundle savedInstanceState)
/*     */   {
/*  95 */     this.dialog = new Dialog(getActivity(), R.style.com_facebook_auth_dialog);
/*  96 */     LayoutInflater inflater = getActivity().getLayoutInflater();
/*  97 */     View view = inflater.inflate(R.layout.com_facebook_device_auth_dialog_fragment, null);
/*  98 */     this.progressBar = ((ProgressBar)view.findViewById(R.id.progress_bar));
/*  99 */     this.confirmationCode = ((TextView)view.findViewById(R.id.confirmation_code));
/*     */     
/* 101 */     Button cancelButton = (Button)view.findViewById(R.id.cancel_button);
/* 102 */     cancelButton.setOnClickListener(new OnClickListener()
/*     */     {
/*     */       public void onClick(View v) {
/* 105 */         DeviceShareDialogFragment.this.dialog.dismiss();
/*     */       }
/*     */       
/* 108 */     });
/* 109 */     TextView instructions = (TextView)view.findViewById(R.id.com_facebook_device_auth_instructions);
/*     */     
/* 111 */     instructions.setText(
/* 112 */       Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
/*     */     
/* 114 */     this.dialog.setContentView(view);
/*     */     
/* 116 */     startShare();
/* 117 */     return this.dialog;
/*     */   }
/*     */   
/*     */   public void onDismiss(DialogInterface dialog)
/*     */   {
/* 122 */     super.onDismiss(dialog);
/* 123 */     if (this.codeExpiredFuture != null) {
/* 124 */       this.codeExpiredFuture.cancel(true);
/*     */     }
/* 126 */     Intent resultIntent = new Intent();
/* 127 */     finishActivity(-1, resultIntent);
/*     */   }
/*     */   
/*     */   public void onSaveInstanceState(Bundle outState)
/*     */   {
/* 132 */     super.onSaveInstanceState(outState);
/* 133 */     if (this.currentRequestState != null) {
/* 134 */       outState.putParcelable("request_state", this.currentRequestState);
/*     */     }
/*     */   }
/*     */   
/*     */   private void finishActivity(int resultCode, Intent data) {
/* 139 */     DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
/*     */     
/* 141 */     if (isAdded()) {
/* 142 */       Activity activity = getActivity();
/* 143 */       activity.setResult(resultCode, data);
/* 144 */       activity.finish();
/*     */     }
/*     */   }
/*     */   
/*     */   private void detach() {
/* 149 */     if (isAdded()) {
/* 150 */       getFragmentManager().beginTransaction().remove(this).commit();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setShareContent(ShareContent shareContent) {
/* 155 */     this.shareContent = shareContent;
/*     */   }
/*     */   
/*     */   private Bundle getGraphParametersForShareContent() {
/* 159 */     ShareContent content = this.shareContent;
/* 160 */     if (content == null) {
/* 161 */       return null;
/*     */     }
/* 163 */     if ((content instanceof ShareLinkContent))
/* 164 */       return WebDialogParameters.create((ShareLinkContent)content);
/* 165 */     if ((content instanceof ShareOpenGraphContent)) {
/* 166 */       return WebDialogParameters.create((ShareOpenGraphContent)content);
/*     */     }
/* 168 */     return null;
/*     */   }
/*     */   
/*     */   private void startShare() {
/* 172 */     Bundle parameters = getGraphParametersForShareContent();
/* 173 */     if ((parameters == null) || (parameters.size() == 0)) {
/* 174 */       finishActivityWithError(new FacebookRequestError(0, "", "Failed to get share content"));
/*     */     }
/*     */     
/*     */ 
/* 178 */     String accessToken = Validate.hasAppID() + "|" + Validate.hasClientToken();
/* 179 */     parameters.putString("access_token", accessToken);
/* 180 */     parameters.putString("device_info", 
/* 181 */       DeviceRequestsHelper.getDeviceInfo());
/*     */     
/* 183 */     GraphRequest graphRequest = new GraphRequest(null, "device/share", parameters, HttpMethod.POST, new GraphRequest.Callback()
/*     */     {
/*     */ 
/*     */ 
/*     */       public void onCompleted(GraphResponse response)
/*     */       {
/*     */ 
/*     */ 
/* 191 */         FacebookRequestError error = response.getError();
/* 192 */         if (error != null) {
/* 193 */           DeviceShareDialogFragment.this.finishActivityWithError(error);
/* 194 */           return;
/*     */         }
/*     */         
/* 197 */         JSONObject jsonObject = response.getJSONObject();
/* 198 */         RequestState requestState = new RequestState();
/*     */         try {
/* 200 */           requestState.setUserCode(jsonObject.getString("user_code"));
/* 201 */           requestState.setExpiresIn(jsonObject.getLong("expires_in"));
/*     */         } catch (JSONException ex) {
/* 203 */           DeviceShareDialogFragment.this.finishActivityWithError(new FacebookRequestError(0, "", "Malformed server response"));
/*     */           
/* 205 */           return;
/*     */         }
/*     */         
/* 208 */         DeviceShareDialogFragment.this.setCurrentRequestState(requestState);
/*     */       }
/* 210 */     });
/* 211 */     graphRequest.executeAsync();
/*     */   }
/*     */   
/*     */   private void finishActivityWithError(FacebookRequestError error)
/*     */   {
/* 216 */     detach();
/* 217 */     Intent intent = new Intent();
/* 218 */     intent.putExtra("error", error);
/* 219 */     finishActivity(-1, intent);
/*     */   }
/*     */   
/*     */   private static synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
/* 223 */     if (backgroundExecutor == null) {
/* 224 */       backgroundExecutor = new ScheduledThreadPoolExecutor(1);
/*     */     }
/* 226 */     return backgroundExecutor;
/*     */   }
/*     */   
/*     */   private void setCurrentRequestState(RequestState currentRequestState) {
/* 230 */     this.currentRequestState = currentRequestState;
/* 231 */     this.confirmationCode.setText(currentRequestState.getUserCode());
/* 232 */     this.confirmationCode.setVisibility(0);
/* 233 */     this.progressBar.setVisibility(8);
/*     */     
/* 235 */     this.codeExpiredFuture = getBackgroundExecutor().schedule(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 239 */         DeviceShareDialogFragment.this.dialog.dismiss();
/*     */       }
/*     */       
/* 242 */     }, currentRequestState.getExpiresIn(), TimeUnit.SECONDS);
/*     */   }
/*     */   
/*     */   private static class RequestState implements Parcelable
/*     */   {
/*     */     private String userCode;
/*     */     private long expiresIn;
/*     */     
/*     */     RequestState() {}
/*     */     
/*     */     public String getUserCode() {
/* 253 */       return this.userCode;
/*     */     }
/*     */     
/*     */     public void setUserCode(String userCode) {
/* 257 */       this.userCode = userCode;
/*     */     }
/*     */     
/*     */     public long getExpiresIn() {
/* 261 */       return this.expiresIn;
/*     */     }
/*     */     
/*     */     public void setExpiresIn(long expiresIn) {
/* 265 */       this.expiresIn = expiresIn;
/*     */     }
/*     */     
/*     */     protected RequestState(Parcel in)
/*     */     {
/* 270 */       this.userCode = in.readString();
/* 271 */       this.expiresIn = in.readLong();
/*     */     }
/*     */     
/*     */     public int describeContents()
/*     */     {
/* 276 */       return 0;
/*     */     }
/*     */     
/*     */     public void writeToParcel(Parcel dest, int flags)
/*     */     {
/* 281 */       dest.writeString(this.userCode);
/* 282 */       dest.writeLong(this.expiresIn);
/*     */     }
/*     */     
/*     */ 
/* 286 */     public static final Creator<RequestState> CREATOR = new Creator()
/*     */     {
/*     */       public RequestState createFromParcel(Parcel in)
/*     */       {
/* 290 */         return new RequestState(in);
/*     */       }
/*     */       
/*     */       public RequestState[] newArray(int size)
/*     */       {
/* 295 */         return new RequestState[size];
/*     */       }
/*     */     };
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/DeviceShareDialogFragment.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */