/*      */ package com.facebook;
/*      */ 
/*      */ import android.content.ContentResolver;
/*      */ import android.content.Context;
/*      */ import android.graphics.Bitmap;
/*      */ import android.graphics.Bitmap.CompressFormat;
/*      */ import android.location.Location;
/*      */ import android.net.Uri;
/*      */ import android.net.Uri.Builder;
/*      */ import android.os.Bundle;
/*      */ import android.os.Handler;
/*      */ import android.os.Parcel;
/*      */ import android.os.ParcelFileDescriptor;
/*      */ import android.os.ParcelFileDescriptor.AutoCloseInputStream;
/*      */ import android.os.Parcelable;
/*      */ import android.os.Parcelable.Creator;
/*      */ import android.text.TextUtils;
/*      */ import android.util.Log;
/*      */ import android.util.Pair;
/*      */ import com.facebook.internal.AttributionIdentifiers;
/*      */ import com.facebook.internal.InternalSettings;
/*      */ import com.facebook.internal.Logger;
/*      */ import com.facebook.internal.ServerProtocol;
/*      */ import com.facebook.internal.Utility;
/*      */ import com.facebook.internal.Validate;
/*      */ import com.facebook.share.internal.OpenGraphJSONUtility;
/*      */ import com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor;
/*      */ import com.facebook.share.model.ShareOpenGraphObject;
/*      */ import com.facebook.share.model.SharePhoto;
/*      */ import java.io.BufferedOutputStream;
/*      */ import java.io.File;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.net.HttpURLConnection;
/*      */ import java.net.MalformedURLException;
/*      */ import java.net.URL;
/*      */ import java.net.URLEncoder;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ import java.util.zip.GZIPOutputStream;
/*      */ import org.json.JSONArray;
/*      */ import org.json.JSONException;
/*      */ import org.json.JSONObject;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GraphRequest
/*      */ {
/*      */   public static final int MAXIMUM_BATCH_SIZE = 50;
/*   83 */   public static final String TAG = GraphRequest.class.getSimpleName();
/*      */   
/*      */   private static final String VIDEOS_SUFFIX = "/videos";
/*      */   
/*      */   private static final String ME = "me";
/*      */   
/*      */   private static final String MY_FRIENDS = "me/friends";
/*      */   
/*      */   private static final String MY_PHOTOS = "me/photos";
/*      */   
/*      */   private static final String SEARCH = "search";
/*      */   
/*      */   private static final String USER_AGENT_BASE = "FBAndroidSDK";
/*      */   
/*      */   private static final String USER_AGENT_HEADER = "User-Agent";
/*      */   
/*      */   private static final String CONTENT_TYPE_HEADER = "Content-Type";
/*      */   
/*      */   private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
/*      */   private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
/*      */   private static final String FORMAT_PARAM = "format";
/*      */   private static final String FORMAT_JSON = "json";
/*      */   private static final String SDK_PARAM = "sdk";
/*      */   private static final String SDK_ANDROID = "android";
/*      */   public static final String ACCESS_TOKEN_PARAM = "access_token";
/*      */   private static final String BATCH_ENTRY_NAME_PARAM = "name";
/*      */   private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
/*      */   private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
/*      */   private static final String BATCH_APP_ID_PARAM = "batch_app_id";
/*      */   private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
/*      */   private static final String BATCH_BODY_PARAM = "body";
/*      */   private static final String BATCH_METHOD_PARAM = "method";
/*      */   private static final String BATCH_PARAM = "batch";
/*      */   private static final String ATTACHMENT_FILENAME_PREFIX = "file";
/*      */   private static final String ATTACHED_FILES_PARAM = "attached_files";
/*      */   private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
/*      */   private static final String DEBUG_PARAM = "debug";
/*      */   private static final String DEBUG_SEVERITY_INFO = "info";
/*      */   private static final String DEBUG_SEVERITY_WARNING = "warning";
/*      */   private static final String DEBUG_KEY = "__debug__";
/*      */   private static final String DEBUG_MESSAGES_KEY = "messages";
/*      */   private static final String DEBUG_MESSAGE_KEY = "message";
/*      */   private static final String DEBUG_MESSAGE_TYPE_KEY = "type";
/*      */   private static final String DEBUG_MESSAGE_LINK_KEY = "link";
/*      */   private static final String PICTURE_PARAM = "picture";
/*      */   private static final String CAPTION_PARAM = "caption";
/*      */   public static final String FIELDS_PARAM = "fields";
/*      */   private static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
/*      */   private static final String GRAPH_PATH_FORMAT = "%s/%s";
/*      */   private static String defaultBatchApplicationId;
/*  133 */   private static Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
/*      */   
/*      */   private AccessToken accessToken;
/*      */   private HttpMethod httpMethod;
/*      */   private String graphPath;
/*      */   private JSONObject graphObject;
/*      */   private String batchEntryName;
/*      */   private String batchEntryDependsOn;
/*  141 */   private boolean batchEntryOmitResultOnSuccess = true;
/*      */   private Bundle parameters;
/*      */   private Callback callback;
/*      */   private String overriddenURL;
/*      */   private Object tag;
/*      */   private String version;
/*  147 */   private boolean skipClientToken = false;
/*      */   
/*      */   private static volatile String userAgent;
/*      */   
/*      */   public GraphRequest()
/*      */   {
/*  153 */     this(null, null, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public GraphRequest(AccessToken accessToken, String graphPath)
/*      */   {
/*  166 */     this(accessToken, graphPath, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public GraphRequest(AccessToken accessToken, String graphPath, Bundle parameters, HttpMethod httpMethod)
/*      */   {
/*  190 */     this(accessToken, graphPath, parameters, httpMethod, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public GraphRequest(AccessToken accessToken, String graphPath, Bundle parameters, HttpMethod httpMethod, Callback callback)
/*      */   {
/*  217 */     this(accessToken, graphPath, parameters, httpMethod, callback, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public GraphRequest(AccessToken accessToken, String graphPath, Bundle parameters, HttpMethod httpMethod, Callback callback, String version)
/*      */   {
/*  246 */     this.accessToken = accessToken;
/*  247 */     this.graphPath = graphPath;
/*  248 */     this.version = version;
/*      */     
/*  250 */     setCallback(callback);
/*  251 */     setHttpMethod(httpMethod);
/*      */     
/*  253 */     if (parameters != null) {
/*  254 */       this.parameters = new Bundle(parameters);
/*      */     } else {
/*  256 */       this.parameters = new Bundle();
/*      */     }
/*      */     
/*  259 */     if (this.version == null) {
/*  260 */       this.version = FacebookSdk.getGraphApiVersion();
/*      */     }
/*      */   }
/*      */   
/*      */   GraphRequest(AccessToken accessToken, URL overriddenURL) {
/*  265 */     this.accessToken = accessToken;
/*  266 */     this.overriddenURL = overriddenURL.toString();
/*      */     
/*  268 */     setHttpMethod(HttpMethod.GET);
/*      */     
/*  270 */     this.parameters = new Bundle();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequest newDeleteObjectRequest(AccessToken accessToken, String id, Callback callback)
/*      */   {
/*  286 */     return new GraphRequest(accessToken, id, null, HttpMethod.DELETE, callback);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequest newMeRequest(AccessToken accessToken, GraphJSONObjectCallback callback)
/*      */   {
/*  300 */     Callback wrapper = new Callback()
/*      */     {
/*      */       public void onCompleted(GraphResponse response) {
/*  303 */         if (this.val$callback != null) {
/*  304 */           this.val$callback.onCompleted(response.getJSONObject(), response);
/*      */         }
/*      */       }
/*  307 */     };
/*  308 */     return new GraphRequest(accessToken, "me", null, null, wrapper);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequest newPostRequest(AccessToken accessToken, String graphPath, JSONObject graphObject, Callback callback)
/*      */   {
/*  327 */     GraphRequest request = new GraphRequest(accessToken, graphPath, null, HttpMethod.POST, callback);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  333 */     request.setGraphObject(graphObject);
/*  334 */     return request;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequest newMyFriendsRequest(AccessToken accessToken, GraphJSONArrayCallback callback)
/*      */   {
/*  348 */     Callback wrapper = new Callback()
/*      */     {
/*      */       public void onCompleted(GraphResponse response) {
/*  351 */         if (this.val$callback != null) {
/*  352 */           JSONObject result = response.getJSONObject();
/*  353 */           JSONArray data = result != null ? result.optJSONArray("data") : null;
/*  354 */           this.val$callback.onCompleted(data, response);
/*      */         }
/*      */       }
/*  357 */     };
/*  358 */     return new GraphRequest(accessToken, "me/friends", null, null, wrapper);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequest newGraphPathRequest(AccessToken accessToken, String graphPath, Callback callback)
/*      */   {
/*  374 */     return new GraphRequest(accessToken, graphPath, null, null, callback);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequest newPlacesSearchRequest(AccessToken accessToken, Location location, int radiusInMeters, int resultsLimit, String searchText, GraphJSONArrayCallback callback)
/*      */   {
/*  400 */     if ((location == null) && (Utility.isNullOrEmpty(searchText))) {
/*  401 */       throw new FacebookException("Either location or searchText must be specified.");
/*      */     }
/*      */     
/*  404 */     Bundle parameters = new Bundle(5);
/*  405 */     parameters.putString("type", "place");
/*  406 */     parameters.putInt("limit", resultsLimit);
/*  407 */     if (location != null) {
/*  408 */       parameters.putString("center", 
/*  409 */         String.format(Locale.US, "%f,%f", new Object[] {
/*      */         
/*      */ 
/*  412 */         Double.valueOf(location.getLatitude()), 
/*  413 */         Double.valueOf(location.getLongitude()) }));
/*  414 */       parameters.putInt("distance", radiusInMeters);
/*      */     }
/*  416 */     if (!Utility.isNullOrEmpty(searchText)) {
/*  417 */       parameters.putString("q", searchText);
/*      */     }
/*      */     
/*  420 */     Callback wrapper = new Callback()
/*      */     {
/*      */       public void onCompleted(GraphResponse response) {
/*  423 */         if (this.val$callback != null) {
/*  424 */           JSONObject result = response.getJSONObject();
/*  425 */           JSONArray data = result != null ? result.optJSONArray("data") : null;
/*  426 */           this.val$callback.onCompleted(data, response);
/*      */         }
/*      */         
/*      */       }
/*  430 */     };
/*  431 */     return new GraphRequest(accessToken, "search", parameters, HttpMethod.GET, wrapper);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequest newUploadPhotoRequest(AccessToken accessToken, String graphPath, Bitmap image, String caption, Bundle params, Callback callback)
/*      */   {
/*  454 */     graphPath = getDefaultPhotoPathIfNull(graphPath);
/*  455 */     Bundle parameters = new Bundle();
/*  456 */     if (params != null) {
/*  457 */       parameters.putAll(params);
/*      */     }
/*  459 */     parameters.putParcelable("picture", image);
/*  460 */     if ((caption != null) && (!caption.isEmpty())) {
/*  461 */       parameters.putString("caption", caption);
/*      */     }
/*      */     
/*  464 */     return new GraphRequest(accessToken, graphPath, parameters, HttpMethod.POST, callback);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequest newUploadPhotoRequest(AccessToken accessToken, String graphPath, File file, String caption, Bundle params, Callback callback)
/*      */     throws FileNotFoundException
/*      */   {
/*  489 */     graphPath = getDefaultPhotoPathIfNull(graphPath);
/*      */     
/*  491 */     ParcelFileDescriptor descriptor = ParcelFileDescriptor.open(file, 268435456);
/*  492 */     Bundle parameters = new Bundle();
/*  493 */     if (params != null) {
/*  494 */       parameters.putAll(params);
/*      */     }
/*  496 */     parameters.putParcelable("picture", descriptor);
/*  497 */     if ((caption != null) && (!caption.isEmpty())) {
/*  498 */       parameters.putString("caption", caption);
/*      */     }
/*      */     
/*  501 */     return new GraphRequest(accessToken, graphPath, parameters, HttpMethod.POST, callback);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequest newUploadPhotoRequest(AccessToken accessToken, String graphPath, Uri photoUri, String caption, Bundle params, Callback callback)
/*      */     throws FileNotFoundException
/*      */   {
/*  526 */     graphPath = getDefaultPhotoPathIfNull(graphPath);
/*  527 */     if (Utility.isFileUri(photoUri)) {
/*  528 */       return newUploadPhotoRequest(accessToken, graphPath, new File(photoUri
/*      */       
/*      */ 
/*  531 */         .getPath()), caption, params, callback);
/*      */     }
/*      */     
/*      */ 
/*  535 */     if (!Utility.isContentUri(photoUri)) {
/*  536 */       throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
/*      */     }
/*      */     
/*  539 */     Bundle parameters = new Bundle();
/*  540 */     if (params != null) {
/*  541 */       parameters.putAll(params);
/*      */     }
/*  543 */     parameters.putParcelable("picture", photoUri);
/*      */     
/*  545 */     if ((caption != null) && (!caption.isEmpty())) {
/*  546 */       parameters.putString("caption", caption);
/*      */     }
/*      */     
/*  549 */     return new GraphRequest(accessToken, graphPath, parameters, HttpMethod.POST, callback);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, String applicationId, Callback callback)
/*      */   {
/*  593 */     if ((applicationId == null) && (accessToken != null)) {
/*  594 */       applicationId = accessToken.getApplicationId();
/*      */     }
/*      */     
/*  597 */     if (applicationId == null) {
/*  598 */       applicationId = Utility.getMetadataApplicationId(context);
/*      */     }
/*      */     
/*  601 */     if (applicationId == null) {
/*  602 */       throw new FacebookException("Facebook App ID cannot be determined");
/*      */     }
/*      */     
/*  605 */     String endpoint = applicationId + "/custom_audience_third_party_id";
/*      */     
/*  607 */     AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
/*  608 */     Bundle parameters = new Bundle();
/*      */     
/*  610 */     if (accessToken == null) {
/*  611 */       if (attributionIdentifiers == null) {
/*  612 */         throw new FacebookException("There is no access token and attribution identifiers could not be retrieved");
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  621 */       String udid = attributionIdentifiers.getAttributionId() != null ? attributionIdentifiers.getAttributionId() : attributionIdentifiers.getAndroidAdvertiserId();
/*  622 */       if (attributionIdentifiers.getAttributionId() != null) {
/*  623 */         parameters.putString("udid", udid);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  629 */     if ((FacebookSdk.getLimitEventAndDataUsage(context)) || ((attributionIdentifiers != null) && 
/*  630 */       (attributionIdentifiers.isTrackingLimited()))) {
/*  631 */       parameters.putString("limit_event_usage", "1");
/*      */     }
/*      */     
/*  634 */     return new GraphRequest(accessToken, endpoint, parameters, HttpMethod.GET, callback);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, Callback callback)
/*      */   {
/*  673 */     return newCustomAudienceThirdPartyIdRequest(accessToken, context, null, callback);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final JSONObject getGraphObject()
/*      */   {
/*  682 */     return this.graphObject;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void setGraphObject(JSONObject graphObject)
/*      */   {
/*  692 */     this.graphObject = graphObject;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final String getGraphPath()
/*      */   {
/*  701 */     return this.graphPath;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void setGraphPath(String graphPath)
/*      */   {
/*  710 */     this.graphPath = graphPath;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final HttpMethod getHttpMethod()
/*      */   {
/*  719 */     return this.httpMethod;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void setHttpMethod(HttpMethod httpMethod)
/*      */   {
/*  728 */     if ((this.overriddenURL != null) && (httpMethod != HttpMethod.GET)) {
/*  729 */       throw new FacebookException("Can't change HTTP method on request with overridden URL.");
/*      */     }
/*  731 */     this.httpMethod = (httpMethod != null ? httpMethod : HttpMethod.GET);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final String getVersion()
/*      */   {
/*  741 */     return this.version;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void setVersion(String version)
/*      */   {
/*  751 */     this.version = version;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public final void setSkipClientToken(boolean skipClientToken)
/*      */   {
/*  758 */     this.skipClientToken = skipClientToken;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final Bundle getParameters()
/*      */   {
/*  767 */     return this.parameters;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void setParameters(Bundle parameters)
/*      */   {
/*  776 */     this.parameters = parameters;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final AccessToken getAccessToken()
/*      */   {
/*  785 */     return this.accessToken;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void setAccessToken(AccessToken accessToken)
/*      */   {
/*  794 */     this.accessToken = accessToken;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final String getBatchEntryName()
/*      */   {
/*  803 */     return this.batchEntryName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void setBatchEntryName(String batchEntryName)
/*      */   {
/*  817 */     this.batchEntryName = batchEntryName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final String getBatchEntryDependsOn()
/*      */   {
/*  827 */     return this.batchEntryDependsOn;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void setBatchEntryDependsOn(String batchEntryDependsOn)
/*      */   {
/*  841 */     this.batchEntryDependsOn = batchEntryDependsOn;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final boolean getBatchEntryOmitResultOnSuccess()
/*      */   {
/*  852 */     return this.batchEntryOmitResultOnSuccess;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void setBatchEntryOmitResultOnSuccess(boolean batchEntryOmitResultOnSuccess)
/*      */   {
/*  865 */     this.batchEntryOmitResultOnSuccess = batchEntryOmitResultOnSuccess;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static final String getDefaultBatchApplicationId()
/*      */   {
/*  876 */     return defaultBatchApplicationId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static final void setDefaultBatchApplicationId(String applicationId)
/*      */   {
/*  889 */     defaultBatchApplicationId = applicationId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final Callback getCallback()
/*      */   {
/*  898 */     return this.callback;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void setCallback(final Callback callback)
/*      */   {
/*  908 */     if ((FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) || 
/*  909 */       (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING))) {
/*  910 */       Callback wrapper = new Callback()
/*      */       {
/*      */         public void onCompleted(GraphResponse response) {
/*  913 */           JSONObject responseObject = response.getJSONObject();
/*      */           
/*  915 */           JSONObject debug = responseObject != null ? responseObject.optJSONObject("__debug__") : null;
/*      */           
/*  917 */           JSONArray debugMessages = debug != null ? debug.optJSONArray("messages") : null;
/*  918 */           if (debugMessages != null) {
/*  919 */             for (int i = 0; i < debugMessages.length(); i++) {
/*  920 */               JSONObject debugMessageObject = debugMessages.optJSONObject(i);
/*      */               
/*  922 */               String debugMessage = debugMessageObject != null ? debugMessageObject.optString("message") : null;
/*      */               
/*      */ 
/*  925 */               String debugMessageType = debugMessageObject != null ? debugMessageObject.optString("type") : null;
/*      */               
/*      */ 
/*  928 */               String debugMessageLink = debugMessageObject != null ? debugMessageObject.optString("link") : null;
/*      */               
/*  930 */               if ((debugMessage != null) && (debugMessageType != null)) {
/*  931 */                 LoggingBehavior behavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
/*  932 */                 if (debugMessageType.equals("warning")) {
/*  933 */                   behavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
/*      */                 }
/*  935 */                 if (!Utility.isNullOrEmpty(debugMessageLink)) {
/*  936 */                   debugMessage = debugMessage + " Link: " + debugMessageLink;
/*      */                 }
/*  938 */                 Logger.log(behavior, GraphRequest.TAG, debugMessage);
/*      */               }
/*      */             }
/*      */           }
/*  942 */           if (callback != null) {
/*  943 */             callback.onCompleted(response);
/*      */           }
/*      */         }
/*  946 */       };
/*  947 */       this.callback = wrapper;
/*      */     } else {
/*  949 */       this.callback = callback;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void setTag(Object tag)
/*      */   {
/*  962 */     this.tag = tag;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final Object getTag()
/*      */   {
/*  973 */     return this.tag;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final GraphResponse executeAndWait()
/*      */   {
/*  987 */     return executeAndWait(this);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final GraphRequestAsyncTask executeAsync()
/*      */   {
/* 1002 */     return executeBatchAsync(new GraphRequest[] { this });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static HttpURLConnection toHttpConnection(GraphRequest... requests)
/*      */   {
/* 1017 */     return toHttpConnection(Arrays.asList(requests));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static HttpURLConnection toHttpConnection(Collection<GraphRequest> requests)
/*      */   {
/* 1032 */     Validate.notEmptyAndContainsNoNulls(requests, "requests");
/*      */     
/* 1034 */     return toHttpConnection(new GraphRequestBatch(requests));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static HttpURLConnection toHttpConnection(GraphRequestBatch requests)
/*      */   {
/* 1049 */     validateFieldsParamForGetRequests(requests);
/*      */     try
/*      */     {
/*      */       URL url;
/* 1053 */       if (requests.size() == 1)
/*      */       {
/* 1055 */         GraphRequest request = requests.get(0);
/*      */         
/*      */ 
/* 1058 */         url = new URL(request.getUrlForSingleRequest());
/*      */       }
/*      */       else
/*      */       {
/* 1062 */         url = new URL(ServerProtocol.getGraphUrlBase());
/*      */       }
/*      */     } catch (MalformedURLException e) { URL url;
/* 1065 */       throw new FacebookException("could not construct URL for request", e);
/*      */     }
/*      */     URL url;
/* 1068 */     HttpURLConnection connection = null;
/*      */     try {
/* 1070 */       connection = createConnection(url);
/*      */       
/* 1072 */       serializeToUrlConnection(requests, connection);
/*      */     } catch (IOException|JSONException e) {
/* 1074 */       Utility.disconnectQuietly(connection);
/*      */       
/* 1076 */       throw new FacebookException("could not construct request body", e);
/*      */     }
/*      */     
/* 1079 */     return connection;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphResponse executeAndWait(GraphRequest request)
/*      */   {
/* 1093 */     List<GraphResponse> responses = executeBatchAndWait(new GraphRequest[] { request });
/*      */     
/* 1095 */     if ((responses == null) || (responses.size() != 1)) {
/* 1096 */       throw new FacebookException("invalid state: expected a single response");
/*      */     }
/*      */     
/* 1099 */     return (GraphResponse)responses.get(0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<GraphResponse> executeBatchAndWait(GraphRequest... requests)
/*      */   {
/* 1116 */     Validate.notNull(requests, "requests");
/*      */     
/* 1118 */     return executeBatchAndWait(Arrays.asList(requests));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> requests)
/*      */   {
/* 1134 */     return executeBatchAndWait(new GraphRequestBatch(requests));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<GraphResponse> executeBatchAndWait(GraphRequestBatch requests)
/*      */   {
/* 1153 */     Validate.notEmptyAndContainsNoNulls(requests, "requests");
/*      */     
/* 1155 */     HttpURLConnection connection = null;
/*      */     try {
/*      */       List<GraphResponse> responses;
/* 1158 */       try { connection = toHttpConnection(requests);
/*      */       } catch (Exception ex) {
/* 1160 */         responses = GraphResponse.constructErrorResponses(requests
/* 1161 */           .getRequests(), null, new FacebookException(ex));
/*      */         
/*      */ 
/* 1164 */         runCallbacks(requests, responses);
/* 1165 */         return responses;
/*      */       }
/*      */       
/* 1168 */       List<GraphResponse> responses = executeConnectionAndWait(connection, requests);
/*      */       
/* 1170 */       return responses;
/*      */     } finally {
/* 1172 */       Utility.disconnectQuietly(connection);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequestAsyncTask executeBatchAsync(GraphRequest... requests)
/*      */   {
/* 1189 */     Validate.notNull(requests, "requests");
/*      */     
/* 1191 */     return executeBatchAsync(Arrays.asList(requests));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> requests)
/*      */   {
/* 1208 */     return executeBatchAsync(new GraphRequestBatch(requests));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch requests)
/*      */   {
/* 1226 */     Validate.notEmptyAndContainsNoNulls(requests, "requests");
/*      */     
/* 1228 */     GraphRequestAsyncTask asyncTask = new GraphRequestAsyncTask(requests);
/* 1229 */     asyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
/* 1230 */     return asyncTask;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection connection, Collection<GraphRequest> requests)
/*      */   {
/* 1250 */     return executeConnectionAndWait(connection, new GraphRequestBatch(requests));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection connection, GraphRequestBatch requests)
/*      */   {
/* 1270 */     List<GraphResponse> responses = GraphResponse.fromHttpConnection(connection, requests);
/*      */     
/* 1272 */     Utility.disconnectQuietly(connection);
/*      */     
/* 1274 */     int numRequests = requests.size();
/* 1275 */     if (numRequests != responses.size())
/*      */     {
/* 1277 */       throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", new Object[] {
/*      */       
/* 1279 */         Integer.valueOf(responses.size()), 
/* 1280 */         Integer.valueOf(numRequests) }));
/*      */     }
/*      */     
/* 1283 */     runCallbacks(requests, responses);
/*      */     
/*      */ 
/* 1286 */     AccessTokenManager.getInstance().extendAccessTokenIfNeeded();
/*      */     
/* 1288 */     return responses;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection connection, GraphRequestBatch requests)
/*      */   {
/* 1309 */     return executeConnectionAsync(null, connection, requests);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequestAsyncTask executeConnectionAsync(Handler callbackHandler, HttpURLConnection connection, GraphRequestBatch requests)
/*      */   {
/* 1334 */     Validate.notNull(connection, "connection");
/*      */     
/* 1336 */     GraphRequestAsyncTask asyncTask = new GraphRequestAsyncTask(connection, requests);
/* 1337 */     requests.setCallbackHandler(callbackHandler);
/* 1338 */     asyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
/* 1339 */     return asyncTask;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1362 */     return "{Request: " + " accessToken: " + (this.accessToken == null ? "null" : this.accessToken) + ", graphPath: " + this.graphPath + ", graphObject: " + this.graphObject + ", httpMethod: " + this.httpMethod + ", parameters: " + this.parameters + "}";
/*      */   }
/*      */   
/*      */   static void runCallbacks(final GraphRequestBatch requests, List<GraphResponse> responses) {
/* 1366 */     int numRequests = requests.size();
/*      */     
/*      */ 
/*      */ 
/* 1370 */     ArrayList<Pair<Callback, GraphResponse>> callbacks = new ArrayList();
/* 1371 */     for (int i = 0; i < numRequests; i++) {
/* 1372 */       GraphRequest request = requests.get(i);
/* 1373 */       if (request.callback != null) {
/* 1374 */         callbacks.add(new Pair(request.callback, responses
/* 1375 */           .get(i)));
/*      */       }
/*      */     }
/*      */     
/* 1379 */     if (callbacks.size() > 0) {
/* 1380 */       Runnable runnable = new Runnable() {
/*      */         public void run() {
/* 1382 */           for (Iterator localIterator = this.val$callbacks.iterator(); localIterator.hasNext();) { pair = (Pair)localIterator.next();
/* 1383 */             ((Callback)pair.first).onCompleted((GraphResponse)pair.second);
/*      */           }
/*      */           Pair<Callback, GraphResponse> pair;
/* 1386 */           Object batchCallbacks = requests.getCallbacks();
/* 1387 */           for (GraphRequestBatch.Callback batchCallback : (List)batchCallbacks) {
/* 1388 */             batchCallback.onBatchCompleted(requests);
/*      */           }
/*      */           
/*      */         }
/* 1392 */       };
/* 1393 */       Handler callbackHandler = requests.getCallbackHandler();
/* 1394 */       if (callbackHandler == null)
/*      */       {
/* 1396 */         runnable.run();
/*      */       }
/*      */       else {
/* 1399 */         callbackHandler.post(runnable);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private static String getDefaultPhotoPathIfNull(String graphPath) {
/* 1405 */     return graphPath == null ? "me/photos" : graphPath;
/*      */   }
/*      */   
/*      */   private static HttpURLConnection createConnection(URL url) throws IOException
/*      */   {
/* 1410 */     HttpURLConnection connection = (HttpURLConnection)url.openConnection();
/*      */     
/* 1412 */     connection.setRequestProperty("User-Agent", getUserAgent());
/* 1413 */     connection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
/*      */     
/* 1415 */     connection.setChunkedStreamingMode(0);
/* 1416 */     return connection;
/*      */   }
/*      */   
/*      */   private void addCommonParameters()
/*      */   {
/* 1421 */     if (this.accessToken != null) {
/* 1422 */       if (!this.parameters.containsKey("access_token")) {
/* 1423 */         String token = this.accessToken.getToken();
/* 1424 */         Logger.registerAccessToken(token);
/* 1425 */         this.parameters.putString("access_token", token);
/*      */       }
/* 1427 */     } else if ((!this.skipClientToken) && (!this.parameters.containsKey("access_token"))) {
/* 1428 */       String appID = FacebookSdk.getApplicationId();
/* 1429 */       String clientToken = FacebookSdk.getClientToken();
/* 1430 */       if ((!Utility.isNullOrEmpty(appID)) && (!Utility.isNullOrEmpty(clientToken))) {
/* 1431 */         String accessToken = appID + "|" + clientToken;
/* 1432 */         this.parameters.putString("access_token", accessToken);
/*      */       } else {
/* 1434 */         Log.d(TAG, "Warning: Request without access token missing application ID or client token.");
/*      */       }
/*      */     }
/*      */     
/* 1438 */     this.parameters.putString("sdk", "android");
/* 1439 */     this.parameters.putString("format", "json");
/*      */     
/* 1441 */     if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
/* 1442 */       this.parameters.putString("debug", "info");
/* 1443 */     } else if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
/* 1444 */       this.parameters.putString("debug", "warning");
/*      */     }
/*      */   }
/*      */   
/*      */   private String appendParametersToBaseUrl(String baseUrl) {
/* 1449 */     Builder uriBuilder = Uri.parse(baseUrl).buildUpon();
/*      */     
/* 1451 */     Set<String> keys = this.parameters.keySet();
/* 1452 */     for (String key : keys) {
/* 1453 */       Object value = this.parameters.get(key);
/*      */       
/* 1455 */       if (value == null) {
/* 1456 */         value = "";
/*      */       }
/*      */       
/* 1459 */       if (isSupportedParameterType(value)) {
/* 1460 */         value = parameterToString(value);
/*      */       } else {
/* 1462 */         if (this.httpMethod != HttpMethod.GET)
/*      */           continue;
/* 1464 */         throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[] {value
/*      */         
/*      */ 
/* 1467 */           .getClass().getSimpleName() }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 1472 */       uriBuilder.appendQueryParameter(key, value.toString());
/*      */     }
/*      */     
/* 1475 */     return uriBuilder.toString();
/*      */   }
/*      */   
/*      */   final String getRelativeUrlForBatchedRequest() {
/* 1479 */     if (this.overriddenURL != null) {
/* 1480 */       throw new FacebookException("Can't override URL for a batch request");
/*      */     }
/*      */     
/*      */ 
/* 1484 */     String baseUrl = String.format("%s/%s", new Object[] { ServerProtocol.getGraphUrlBase(), getGraphPathWithVersion() });
/* 1485 */     addCommonParameters();
/* 1486 */     String fullUrl = appendParametersToBaseUrl(baseUrl);
/* 1487 */     Uri uri = Uri.parse(fullUrl);
/* 1488 */     String relativeUrl = String.format("%s?%s", new Object[] { uri.getPath(), uri.getQuery() });
/* 1489 */     return relativeUrl;
/*      */   }
/*      */   
/*      */   final String getUrlForSingleRequest() {
/* 1493 */     if (this.overriddenURL != null) {
/* 1494 */       return this.overriddenURL.toString();
/*      */     }
/*      */     
/*      */ 
/* 1498 */     if ((getHttpMethod() == HttpMethod.POST) && (this.graphPath != null))
/*      */     {
/* 1500 */       if (this.graphPath.endsWith("/videos")) {
/* 1501 */         String graphBaseUrlBase = ServerProtocol.getGraphVideoUrlBase();
/*      */         break label55; } }
/* 1503 */     String graphBaseUrlBase = ServerProtocol.getGraphUrlBase();
/*      */     label55:
/* 1505 */     String baseUrl = String.format("%s/%s", new Object[] { graphBaseUrlBase, getGraphPathWithVersion() });
/*      */     
/* 1507 */     addCommonParameters();
/* 1508 */     return appendParametersToBaseUrl(baseUrl);
/*      */   }
/*      */   
/*      */   private String getGraphPathWithVersion() {
/* 1512 */     Matcher matcher = versionPattern.matcher(this.graphPath);
/* 1513 */     if (matcher.matches()) {
/* 1514 */       return this.graphPath;
/*      */     }
/* 1516 */     return String.format("%s/%s", new Object[] { this.version, this.graphPath });
/*      */   }
/*      */   
/*      */   private static class Attachment {
/*      */     private final GraphRequest request;
/*      */     private final Object value;
/*      */     
/*      */     public Attachment(GraphRequest request, Object value) {
/* 1524 */       this.request = request;
/* 1525 */       this.value = value;
/*      */     }
/*      */     
/*      */     public GraphRequest getRequest() {
/* 1529 */       return this.request;
/*      */     }
/*      */     
/*      */     public Object getValue() {
/* 1533 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void serializeToBatch(JSONArray batch, Map<String, Attachment> attachments)
/*      */     throws JSONException, IOException
/*      */   {
/* 1541 */     JSONObject batchEntry = new JSONObject();
/*      */     
/* 1543 */     if (this.batchEntryName != null) {
/* 1544 */       batchEntry.put("name", this.batchEntryName);
/* 1545 */       batchEntry.put("omit_response_on_success", this.batchEntryOmitResultOnSuccess);
/*      */     }
/*      */     
/*      */ 
/* 1549 */     if (this.batchEntryDependsOn != null) {
/* 1550 */       batchEntry.put("depends_on", this.batchEntryDependsOn);
/*      */     }
/*      */     
/* 1553 */     String relativeURL = getRelativeUrlForBatchedRequest();
/* 1554 */     batchEntry.put("relative_url", relativeURL);
/* 1555 */     batchEntry.put("method", this.httpMethod);
/* 1556 */     if (this.accessToken != null) {
/* 1557 */       String token = this.accessToken.getToken();
/* 1558 */       Logger.registerAccessToken(token);
/*      */     }
/*      */     
/*      */ 
/* 1562 */     ArrayList<String> attachmentNames = new ArrayList();
/* 1563 */     Set<String> keys = this.parameters.keySet();
/* 1564 */     for (String key : keys) {
/* 1565 */       Object value = this.parameters.get(key);
/* 1566 */       if (isSupportedAttachmentType(value))
/*      */       {
/* 1568 */         String name = String.format(Locale.ROOT, "%s%d", new Object[] { "file", 
/*      */         
/*      */ 
/*      */ 
/* 1572 */           Integer.valueOf(attachments.size()) });
/* 1573 */         attachmentNames.add(name);
/* 1574 */         attachments.put(name, new Attachment(this, value));
/*      */       }
/*      */     }
/*      */     
/* 1578 */     if (!attachmentNames.isEmpty()) {
/* 1579 */       String attachmentNamesString = TextUtils.join(",", attachmentNames);
/* 1580 */       batchEntry.put("attached_files", attachmentNamesString);
/*      */     }
/*      */     
/* 1583 */     if (this.graphObject != null)
/*      */     {
/* 1585 */       final Object keysAndValues = new ArrayList();
/* 1586 */       processGraphObject(this.graphObject, relativeURL, new KeyValueSerializer()
/*      */       {
/*      */         public void writeString(String key, String value) throws IOException {
/* 1589 */           keysAndValues.add(String.format(Locale.US, "%s=%s", new Object[] { key, 
/*      */           
/*      */ 
/*      */ 
/* 1593 */             URLEncoder.encode(value, "UTF-8") }));
/*      */         }
/* 1595 */       });
/* 1596 */       String bodyValue = TextUtils.join("&", (Iterable)keysAndValues);
/* 1597 */       batchEntry.put("body", bodyValue);
/*      */     }
/*      */     
/* 1600 */     batch.put(batchEntry);
/*      */   }
/*      */   
/*      */   private static boolean hasOnProgressCallbacks(GraphRequestBatch requests) {
/* 1604 */     for (GraphRequestBatch.Callback callback : requests.getCallbacks()) {
/* 1605 */       if ((callback instanceof GraphRequestBatch.OnProgressCallback)) {
/* 1606 */         return true;
/*      */       }
/*      */     }
/*      */     
/* 1610 */     for (GraphRequest request : requests) {
/* 1611 */       if ((request.getCallback() instanceof OnProgressCallback)) {
/* 1612 */         return true;
/*      */       }
/*      */     }
/*      */     
/* 1616 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   private static void setConnectionContentType(HttpURLConnection connection, boolean shouldUseGzip)
/*      */   {
/* 1622 */     if (shouldUseGzip) {
/* 1623 */       connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
/* 1624 */       connection.setRequestProperty("Content-Encoding", "gzip");
/*      */     } else {
/* 1626 */       connection.setRequestProperty("Content-Type", getMimeContentType());
/*      */     }
/*      */   }
/*      */   
/*      */   private static boolean isGzipCompressible(GraphRequestBatch requests) {
/* 1631 */     for (Iterator localIterator1 = requests.iterator(); localIterator1.hasNext();) { request = (GraphRequest)localIterator1.next();
/* 1632 */       for (String key : request.parameters.keySet()) {
/* 1633 */         Object value = request.parameters.get(key);
/* 1634 */         if (isSupportedAttachmentType(value))
/* 1635 */           return false;
/*      */       }
/*      */     }
/*      */     GraphRequest request;
/* 1639 */     return true;
/*      */   }
/*      */   
/*      */   static final boolean shouldWarnOnMissingFieldsParam(GraphRequest request) {
/* 1643 */     String version = request.getVersion();
/* 1644 */     if (Utility.isNullOrEmpty(version))
/*      */     {
/* 1646 */       return true;
/*      */     }
/* 1648 */     if (version.startsWith("v")) {
/* 1649 */       version = version.substring(1);
/*      */     }
/* 1651 */     String[] versionParts = version.split("\\.");
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1656 */     return ((versionParts.length >= 2) && (Integer.parseInt(versionParts[0]) > 2)) || ((Integer.parseInt(versionParts[0]) >= 2) && (Integer.parseInt(versionParts[1]) >= 4));
/*      */   }
/*      */   
/*      */   static final void validateFieldsParamForGetRequests(GraphRequestBatch requests)
/*      */   {
/* 1661 */     for (GraphRequest request : requests) {
/* 1662 */       if ((HttpMethod.GET.equals(request.getHttpMethod())) && 
/* 1663 */         (shouldWarnOnMissingFieldsParam(request))) {
/* 1664 */         Bundle params = request.getParameters();
/* 1665 */         if ((!params.containsKey("fields")) || 
/* 1666 */           (Utility.isNullOrEmpty(params.getString("fields")))) {
/* 1667 */           Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", new Object[] {request
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1673 */             .getGraphPath() });
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static final void serializeToUrlConnection(GraphRequestBatch requests, HttpURLConnection connection)
/*      */     throws IOException, JSONException
/*      */   {
/* 1684 */     Logger logger = new Logger(LoggingBehavior.REQUESTS, "Request");
/*      */     
/* 1686 */     int numRequests = requests.size();
/* 1687 */     boolean shouldUseGzip = isGzipCompressible(requests);
/*      */     
/*      */ 
/* 1690 */     HttpMethod connectionHttpMethod = numRequests == 1 ? requests.get(0).httpMethod : HttpMethod.POST;
/* 1691 */     connection.setRequestMethod(connectionHttpMethod.name());
/* 1692 */     setConnectionContentType(connection, shouldUseGzip);
/*      */     
/* 1694 */     URL url = connection.getURL();
/* 1695 */     logger.append("Request:\n");
/* 1696 */     logger.appendKeyValue("Id", requests.getId());
/* 1697 */     logger.appendKeyValue("URL", url);
/* 1698 */     logger.appendKeyValue("Method", connection.getRequestMethod());
/* 1699 */     logger.appendKeyValue("User-Agent", connection.getRequestProperty("User-Agent"));
/* 1700 */     logger.appendKeyValue("Content-Type", connection.getRequestProperty("Content-Type"));
/*      */     
/* 1702 */     connection.setConnectTimeout(requests.getTimeout());
/* 1703 */     connection.setReadTimeout(requests.getTimeout());
/*      */     
/*      */ 
/*      */ 
/* 1707 */     boolean isPost = connectionHttpMethod == HttpMethod.POST;
/* 1708 */     if (!isPost) {
/* 1709 */       logger.log();
/* 1710 */       return;
/*      */     }
/*      */     
/* 1713 */     connection.setDoOutput(true);
/*      */     
/* 1715 */     OutputStream outputStream = null;
/*      */     try {
/* 1717 */       outputStream = new BufferedOutputStream(connection.getOutputStream());
/* 1718 */       if (shouldUseGzip) {
/* 1719 */         outputStream = new GZIPOutputStream(outputStream);
/*      */       }
/*      */       
/* 1722 */       if (hasOnProgressCallbacks(requests)) {
/* 1723 */         ProgressNoopOutputStream countingStream = null;
/* 1724 */         countingStream = new ProgressNoopOutputStream(requests.getCallbackHandler());
/* 1725 */         processRequest(requests, null, numRequests, url, countingStream, shouldUseGzip);
/*      */         
/* 1727 */         int max = countingStream.getMaxProgress();
/* 1728 */         Map<GraphRequest, RequestProgress> progressMap = countingStream.getProgressMap();
/*      */         
/* 1730 */         outputStream = new ProgressOutputStream(outputStream, requests, progressMap, max);
/*      */       }
/*      */       
/* 1733 */       processRequest(requests, logger, numRequests, url, outputStream, shouldUseGzip);
/*      */     } finally {
/* 1735 */       if (outputStream != null) {
/* 1736 */         outputStream.close();
/*      */       }
/*      */     }
/*      */     
/* 1740 */     logger.log();
/*      */   }
/*      */   
/*      */   private static void processRequest(GraphRequestBatch requests, Logger logger, int numRequests, URL url, OutputStream outputStream, boolean shouldUseGzip)
/*      */     throws IOException, JSONException
/*      */   {
/* 1746 */     Serializer serializer = new Serializer(outputStream, logger, shouldUseGzip);
/*      */     
/* 1748 */     if (numRequests == 1) {
/* 1749 */       GraphRequest request = requests.get(0);
/*      */       
/* 1751 */       Map<String, Attachment> attachments = new HashMap();
/* 1752 */       for (String key : request.parameters.keySet()) {
/* 1753 */         Object value = request.parameters.get(key);
/* 1754 */         if (isSupportedAttachmentType(value)) {
/* 1755 */           attachments.put(key, new Attachment(request, value));
/*      */         }
/*      */       }
/*      */       
/* 1759 */       if (logger != null) {
/* 1760 */         logger.append("  Parameters:\n");
/*      */       }
/* 1762 */       serializeParameters(request.parameters, serializer, request);
/*      */       
/* 1764 */       if (logger != null) {
/* 1765 */         logger.append("  Attachments:\n");
/*      */       }
/* 1767 */       serializeAttachments(attachments, serializer);
/*      */       
/* 1769 */       if (request.graphObject != null) {
/* 1770 */         processGraphObject(request.graphObject, url.getPath(), serializer);
/*      */       }
/*      */     } else {
/* 1773 */       String batchAppID = getBatchAppId(requests);
/* 1774 */       if (Utility.isNullOrEmpty(batchAppID)) {
/* 1775 */         throw new FacebookException("App ID was not specified at the request or Settings.");
/*      */       }
/*      */       
/*      */ 
/* 1779 */       serializer.writeString("batch_app_id", batchAppID);
/*      */       
/*      */ 
/*      */ 
/* 1783 */       Map<String, Attachment> attachments = new HashMap();
/* 1784 */       serializeRequestsAsJSON(serializer, requests, attachments);
/*      */       
/* 1786 */       if (logger != null) {
/* 1787 */         logger.append("  Attachments:\n");
/*      */       }
/* 1789 */       serializeAttachments(attachments, serializer);
/*      */     }
/*      */   }
/*      */   
/*      */   private static boolean isMeRequest(String path) {
/* 1794 */     Matcher matcher = versionPattern.matcher(path);
/* 1795 */     if (matcher.matches())
/*      */     {
/* 1797 */       path = matcher.group(1);
/*      */     }
/* 1799 */     if ((path.startsWith("me/")) || (path.startsWith("/me/"))) {
/* 1800 */       return true;
/*      */     }
/* 1802 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void processGraphObject(JSONObject graphObject, String path, KeyValueSerializer serializer)
/*      */     throws IOException
/*      */   {
/* 1816 */     boolean isOGAction = false;
/* 1817 */     if (isMeRequest(path)) {
/* 1818 */       int colonLocation = path.indexOf(":");
/* 1819 */       int questionMarkLocation = path.indexOf("?");
/* 1820 */       isOGAction = (colonLocation > 3) && ((questionMarkLocation == -1) || (colonLocation < questionMarkLocation));
/*      */     }
/*      */     
/*      */ 
/* 1824 */     Iterator<String> keyIterator = graphObject.keys();
/* 1825 */     while (keyIterator.hasNext()) {
/* 1826 */       String key = (String)keyIterator.next();
/* 1827 */       Object value = graphObject.opt(key);
/* 1828 */       boolean passByValue = (isOGAction) && (key.equalsIgnoreCase("image"));
/* 1829 */       processGraphObjectProperty(key, value, serializer, passByValue);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static GraphRequest createOpenGraphObject(ShareOpenGraphObject openGraphObject)
/*      */     throws FacebookException
/*      */   {
/* 1848 */     String type = openGraphObject.getString("type");
/* 1849 */     if (type == null) {
/* 1850 */       type = openGraphObject.getString("og:type");
/*      */     }
/*      */     
/* 1853 */     if (type == null) {
/* 1854 */       throw new FacebookException("Open graph object type cannot be null");
/*      */     }
/*      */     try {
/* 1857 */       JSONObject stagedObject = (JSONObject)OpenGraphJSONUtility.toJSONValue(openGraphObject, new PhotoJSONProcessor()
/*      */       {
/*      */ 
/*      */         public JSONObject toJSONObject(SharePhoto photo)
/*      */         {
/* 1862 */           Uri photoUri = photo.getImageUrl();
/* 1863 */           JSONObject photoJSONObject = new JSONObject();
/*      */           try {
/* 1865 */             photoJSONObject.put("url", photoUri
/* 1866 */               .toString());
/*      */           } catch (Exception e) {
/* 1868 */             throw new FacebookException("Unable to attach images", e);
/*      */           }
/* 1870 */           return photoJSONObject;
/*      */         }
/* 1872 */       });
/* 1873 */       String ogType = type;
/* 1874 */       Bundle parameters = new Bundle();
/* 1875 */       parameters.putString("object", stagedObject.toString());
/*      */       
/* 1877 */       String graphPath = String.format(Locale.ROOT, "%s/%s", new Object[] { "me", "objects/" + ogType });
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1882 */       return new GraphRequest(AccessToken.getCurrentAccessToken(), graphPath, parameters, HttpMethod.POST);
/*      */ 
/*      */     }
/*      */     catch (JSONException e)
/*      */     {
/*      */ 
/* 1888 */       throw new FacebookException(e.getMessage());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void processGraphObjectProperty(String key, Object value, KeyValueSerializer serializer, boolean passByValue)
/*      */     throws IOException
/*      */   {
/* 1898 */     Class<?> valueClass = value.getClass();
/*      */     
/* 1900 */     if (JSONObject.class.isAssignableFrom(valueClass)) {
/* 1901 */       JSONObject jsonObject = (JSONObject)value;
/* 1902 */       if (passByValue)
/*      */       {
/*      */ 
/* 1905 */         Iterator<String> keys = jsonObject.keys();
/* 1906 */         while (keys.hasNext()) {
/* 1907 */           String propertyName = (String)keys.next();
/* 1908 */           String subKey = String.format("%s[%s]", new Object[] { key, propertyName });
/* 1909 */           processGraphObjectProperty(subKey, jsonObject
/*      */           
/* 1911 */             .opt(propertyName), serializer, passByValue);
/*      */ 
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */       }
/* 1918 */       else if (jsonObject.has("id")) {
/* 1919 */         processGraphObjectProperty(key, jsonObject
/*      */         
/* 1921 */           .optString("id"), serializer, passByValue);
/*      */ 
/*      */       }
/* 1924 */       else if (jsonObject.has("url")) {
/* 1925 */         processGraphObjectProperty(key, jsonObject
/*      */         
/* 1927 */           .optString("url"), serializer, passByValue);
/*      */ 
/*      */       }
/* 1930 */       else if (jsonObject.has("fbsdk:create_object")) {
/* 1931 */         processGraphObjectProperty(key, jsonObject.toString(), serializer, passByValue);
/*      */       }
/*      */     }
/* 1934 */     else if (JSONArray.class.isAssignableFrom(valueClass)) {
/* 1935 */       JSONArray jsonArray = (JSONArray)value;
/* 1936 */       int length = jsonArray.length();
/* 1937 */       for (int i = 0; i < length; i++) {
/* 1938 */         String subKey = String.format(Locale.ROOT, "%s[%d]", new Object[] { key, Integer.valueOf(i) });
/* 1939 */         processGraphObjectProperty(subKey, jsonArray.opt(i), serializer, passByValue);
/*      */       }
/* 1941 */     } else if ((String.class.isAssignableFrom(valueClass)) || 
/* 1942 */       (Number.class.isAssignableFrom(valueClass)) || 
/* 1943 */       (Boolean.class.isAssignableFrom(valueClass))) {
/* 1944 */       serializer.writeString(key, value.toString());
/* 1945 */     } else if (Date.class.isAssignableFrom(valueClass)) {
/* 1946 */       Date date = (Date)value;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1953 */       SimpleDateFormat iso8601DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
/*      */       
/*      */ 
/* 1956 */       serializer.writeString(key, iso8601DateFormat.format(date));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void serializeParameters(Bundle bundle, Serializer serializer, GraphRequest request)
/*      */     throws IOException
/*      */   {
/* 1965 */     Set<String> keys = bundle.keySet();
/*      */     
/* 1967 */     for (String key : keys) {
/* 1968 */       Object value = bundle.get(key);
/* 1969 */       if (isSupportedParameterType(value)) {
/* 1970 */         serializer.writeObject(key, value, request);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static void serializeAttachments(Map<String, Attachment> attachments, Serializer serializer)
/*      */     throws IOException
/*      */   {
/* 1979 */     Set<String> keys = attachments.keySet();
/*      */     
/* 1981 */     for (String key : keys) {
/* 1982 */       Attachment attachment = (Attachment)attachments.get(key);
/* 1983 */       if (isSupportedAttachmentType(attachment.getValue())) {
/* 1984 */         serializer.writeObject(key, attachment.getValue(), attachment.getRequest());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void serializeRequestsAsJSON(Serializer serializer, Collection<GraphRequest> requests, Map<String, Attachment> attachments)
/*      */     throws JSONException, IOException
/*      */   {
/* 1994 */     JSONArray batch = new JSONArray();
/* 1995 */     for (GraphRequest request : requests) {
/* 1996 */       request.serializeToBatch(batch, attachments);
/*      */     }
/*      */     
/* 1999 */     serializer.writeRequestsAsJson("batch", batch, requests);
/*      */   }
/*      */   
/*      */   private static String getMimeContentType() {
/* 2003 */     return String.format("multipart/form-data; boundary=%s", new Object[] { "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" });
/*      */   }
/*      */   
/*      */ 
/*      */   private static String getUserAgent()
/*      */   {
/* 2009 */     if (userAgent == null) {
/* 2010 */       userAgent = String.format("%s.%s", new Object[] { "FBAndroidSDK", "4.17.0" });
/*      */       
/*      */ 
/* 2013 */       String customUserAgent = InternalSettings.getCustomUserAgent();
/* 2014 */       if (!Utility.isNullOrEmpty(customUserAgent)) {
/* 2015 */         userAgent = String.format(Locale.ROOT, "%s/%s", new Object[] { userAgent, customUserAgent });
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2023 */     return userAgent;
/*      */   }
/*      */   
/*      */   private static String getBatchAppId(GraphRequestBatch batch) {
/* 2027 */     if (!Utility.isNullOrEmpty(batch.getBatchApplicationId())) {
/* 2028 */       return batch.getBatchApplicationId();
/*      */     }
/*      */     
/* 2031 */     for (GraphRequest request : batch) {
/* 2032 */       AccessToken accessToken = request.accessToken;
/* 2033 */       if (accessToken != null) {
/* 2034 */         String applicationId = accessToken.getApplicationId();
/* 2035 */         if (applicationId != null) {
/* 2036 */           return applicationId;
/*      */         }
/*      */       }
/*      */     }
/* 2040 */     if (!Utility.isNullOrEmpty(defaultBatchApplicationId)) {
/* 2041 */       return defaultBatchApplicationId;
/*      */     }
/* 2043 */     return FacebookSdk.getApplicationId();
/*      */   }
/*      */   
/*      */   private static boolean isSupportedAttachmentType(Object value) {
/* 2047 */     return ((value instanceof Bitmap)) || ((value instanceof byte[])) || ((value instanceof Uri)) || ((value instanceof ParcelFileDescriptor)) || ((value instanceof ParcelableResourceWithMimeType));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean isSupportedParameterType(Object value)
/*      */   {
/* 2055 */     return ((value instanceof String)) || ((value instanceof Boolean)) || ((value instanceof Number)) || ((value instanceof Date));
/*      */   }
/*      */   
/*      */   private static String parameterToString(Object value)
/*      */   {
/* 2060 */     if ((value instanceof String))
/* 2061 */       return (String)value;
/* 2062 */     if (((value instanceof Boolean)) || ((value instanceof Number)))
/* 2063 */       return value.toString();
/* 2064 */     if ((value instanceof Date)) {
/* 2065 */       SimpleDateFormat iso8601DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
/*      */       
/* 2067 */       return iso8601DateFormat.format(value);
/*      */     }
/* 2069 */     throw new IllegalArgumentException("Unsupported parameter type.");
/*      */   }
/*      */   
/*      */   private static abstract interface KeyValueSerializer {
/*      */     public abstract void writeString(String paramString1, String paramString2) throws IOException;
/*      */   }
/*      */   
/*      */   private static class Serializer implements KeyValueSerializer {
/*      */     private final OutputStream outputStream;
/*      */     private final Logger logger;
/* 2079 */     private boolean firstWrite = true;
/* 2080 */     private boolean useUrlEncode = false;
/*      */     
/*      */     public Serializer(OutputStream outputStream, Logger logger, boolean useUrlEncode) {
/* 2083 */       this.outputStream = outputStream;
/* 2084 */       this.logger = logger;
/* 2085 */       this.useUrlEncode = useUrlEncode;
/*      */     }
/*      */     
/*      */     public void writeObject(String key, Object value, GraphRequest request) throws IOException {
/* 2089 */       if ((this.outputStream instanceof RequestOutputStream)) {
/* 2090 */         ((RequestOutputStream)this.outputStream).setCurrentRequest(request);
/*      */       }
/*      */       
/* 2093 */       if (GraphRequest.isSupportedParameterType(value)) {
/* 2094 */         writeString(key, GraphRequest.parameterToString(value));
/* 2095 */       } else if ((value instanceof Bitmap)) {
/* 2096 */         writeBitmap(key, (Bitmap)value);
/* 2097 */       } else if ((value instanceof byte[])) {
/* 2098 */         writeBytes(key, (byte[])value);
/* 2099 */       } else if ((value instanceof Uri)) {
/* 2100 */         writeContentUri(key, (Uri)value, null);
/* 2101 */       } else if ((value instanceof ParcelFileDescriptor)) {
/* 2102 */         writeFile(key, (ParcelFileDescriptor)value, null);
/* 2103 */       } else if ((value instanceof ParcelableResourceWithMimeType)) {
/* 2104 */         ParcelableResourceWithMimeType resourceWithMimeType = (ParcelableResourceWithMimeType)value;
/*      */         
/* 2106 */         Parcelable resource = resourceWithMimeType.getResource();
/* 2107 */         String mimeType = resourceWithMimeType.getMimeType();
/* 2108 */         if ((resource instanceof ParcelFileDescriptor)) {
/* 2109 */           writeFile(key, (ParcelFileDescriptor)resource, mimeType);
/* 2110 */         } else if ((resource instanceof Uri)) {
/* 2111 */           writeContentUri(key, (Uri)resource, mimeType);
/*      */         } else {
/* 2113 */           throw getInvalidTypeError();
/*      */         }
/*      */       } else {
/* 2116 */         throw getInvalidTypeError();
/*      */       }
/*      */     }
/*      */     
/*      */     private RuntimeException getInvalidTypeError() {
/* 2121 */       return new IllegalArgumentException("value is not a supported type.");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void writeRequestsAsJson(String key, JSONArray requestJsonArray, Collection<GraphRequest> requests)
/*      */       throws IOException, JSONException
/*      */     {
/* 2129 */       if (!(this.outputStream instanceof RequestOutputStream)) {
/* 2130 */         writeString(key, requestJsonArray.toString());
/* 2131 */         return;
/*      */       }
/*      */       
/* 2134 */       RequestOutputStream requestOutputStream = (RequestOutputStream)this.outputStream;
/* 2135 */       writeContentDisposition(key, null, null);
/* 2136 */       write("[", new Object[0]);
/* 2137 */       int i = 0;
/* 2138 */       for (GraphRequest request : requests) {
/* 2139 */         JSONObject requestJson = requestJsonArray.getJSONObject(i);
/* 2140 */         requestOutputStream.setCurrentRequest(request);
/* 2141 */         if (i > 0) {
/* 2142 */           write(",%s", new Object[] { requestJson.toString() });
/*      */         } else {
/* 2144 */           write("%s", new Object[] { requestJson.toString() });
/*      */         }
/* 2146 */         i++;
/*      */       }
/* 2148 */       write("]", new Object[0]);
/* 2149 */       if (this.logger != null) {
/* 2150 */         this.logger.appendKeyValue("    " + key, requestJsonArray.toString());
/*      */       }
/*      */     }
/*      */     
/*      */     public void writeString(String key, String value) throws IOException {
/* 2155 */       writeContentDisposition(key, null, null);
/* 2156 */       writeLine("%s", new Object[] { value });
/* 2157 */       writeRecordBoundary();
/* 2158 */       if (this.logger != null) {
/* 2159 */         this.logger.appendKeyValue("    " + key, value);
/*      */       }
/*      */     }
/*      */     
/*      */     public void writeBitmap(String key, Bitmap bitmap) throws IOException {
/* 2164 */       writeContentDisposition(key, key, "image/png");
/*      */       
/* 2166 */       bitmap.compress(CompressFormat.PNG, 100, this.outputStream);
/* 2167 */       writeLine("", new Object[0]);
/* 2168 */       writeRecordBoundary();
/* 2169 */       if (this.logger != null) {
/* 2170 */         this.logger.appendKeyValue("    " + key, "<Image>");
/*      */       }
/*      */     }
/*      */     
/*      */     public void writeBytes(String key, byte[] bytes) throws IOException {
/* 2175 */       writeContentDisposition(key, key, "content/unknown");
/* 2176 */       this.outputStream.write(bytes);
/* 2177 */       writeLine("", new Object[0]);
/* 2178 */       writeRecordBoundary();
/* 2179 */       if (this.logger != null) {
/* 2180 */         this.logger.appendKeyValue("    " + key, 
/*      */         
/* 2182 */           String.format(Locale.ROOT, "<Data: %d>", new Object[] {Integer.valueOf(bytes.length) }));
/*      */       }
/*      */     }
/*      */     
/*      */     public void writeContentUri(String key, Uri contentUri, String mimeType) throws IOException
/*      */     {
/* 2188 */       if (mimeType == null) {
/* 2189 */         mimeType = "content/unknown";
/*      */       }
/* 2191 */       writeContentDisposition(key, key, mimeType);
/*      */       
/* 2193 */       int totalBytes = 0;
/* 2194 */       if ((this.outputStream instanceof ProgressNoopOutputStream))
/*      */       {
/* 2196 */         long contentSize = Utility.getContentSize(contentUri);
/*      */         
/* 2198 */         ((ProgressNoopOutputStream)this.outputStream).addProgress(contentSize);
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 2203 */         InputStream inputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(contentUri);
/* 2204 */         totalBytes += Utility.copyAndCloseInputStream(inputStream, this.outputStream);
/*      */       }
/*      */       
/* 2207 */       writeLine("", new Object[0]);
/* 2208 */       writeRecordBoundary();
/* 2209 */       if (this.logger != null) {
/* 2210 */         this.logger.appendKeyValue("    " + key, 
/*      */         
/* 2212 */           String.format(Locale.ROOT, "<Data: %d>", new Object[] {Integer.valueOf(totalBytes) }));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void writeFile(String key, ParcelFileDescriptor descriptor, String mimeType)
/*      */       throws IOException
/*      */     {
/* 2221 */       if (mimeType == null) {
/* 2222 */         mimeType = "content/unknown";
/*      */       }
/* 2224 */       writeContentDisposition(key, key, mimeType);
/*      */       
/* 2226 */       int totalBytes = 0;
/*      */       
/* 2228 */       if ((this.outputStream instanceof ProgressNoopOutputStream))
/*      */       {
/* 2230 */         ((ProgressNoopOutputStream)this.outputStream).addProgress(descriptor.getStatSize());
/*      */       } else {
/* 2232 */         AutoCloseInputStream inputStream = new AutoCloseInputStream(descriptor);
/*      */         
/* 2234 */         totalBytes += Utility.copyAndCloseInputStream(inputStream, this.outputStream);
/*      */       }
/* 2236 */       writeLine("", new Object[0]);
/* 2237 */       writeRecordBoundary();
/* 2238 */       if (this.logger != null) {
/* 2239 */         this.logger.appendKeyValue("    " + key, 
/*      */         
/* 2241 */           String.format(Locale.ROOT, "<Data: %d>", new Object[] {Integer.valueOf(totalBytes) }));
/*      */       }
/*      */     }
/*      */     
/*      */     public void writeRecordBoundary() throws IOException {
/* 2246 */       if (!this.useUrlEncode) {
/* 2247 */         writeLine("--%s", new Object[] { "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" });
/*      */       } else {
/* 2249 */         this.outputStream.write("&".getBytes());
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void writeContentDisposition(String name, String filename, String contentType)
/*      */       throws IOException
/*      */     {
/* 2258 */       if (!this.useUrlEncode) {
/* 2259 */         write("Content-Disposition: form-data; name=\"%s\"", new Object[] { name });
/* 2260 */         if (filename != null) {
/* 2261 */           write("; filename=\"%s\"", new Object[] { filename });
/*      */         }
/* 2263 */         writeLine("", new Object[0]);
/* 2264 */         if (contentType != null) {
/* 2265 */           writeLine("%s: %s", new Object[] { "Content-Type", contentType });
/*      */         }
/* 2267 */         writeLine("", new Object[0]);
/*      */       } else {
/* 2269 */         this.outputStream.write(String.format("%s=", new Object[] { name }).getBytes());
/*      */       }
/*      */     }
/*      */     
/*      */     public void write(String format, Object... args) throws IOException {
/* 2274 */       if (!this.useUrlEncode) {
/* 2275 */         if (this.firstWrite)
/*      */         {
/* 2277 */           this.outputStream.write("--".getBytes());
/* 2278 */           this.outputStream.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
/* 2279 */           this.outputStream.write("\r\n".getBytes());
/* 2280 */           this.firstWrite = false;
/*      */         }
/* 2282 */         this.outputStream.write(String.format(format, args).getBytes());
/*      */       } else {
/* 2284 */         this.outputStream.write(
/* 2285 */           URLEncoder.encode(
/* 2286 */           String.format(Locale.US, format, args), "UTF-8").getBytes());
/*      */       }
/*      */     }
/*      */     
/*      */     public void writeLine(String format, Object... args) throws IOException {
/* 2291 */       write(format, args);
/* 2292 */       if (!this.useUrlEncode) {
/* 2293 */         write("\r\n", new Object[0]);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static abstract interface Callback
/*      */   {
/*      */     public abstract void onCompleted(GraphResponse paramGraphResponse);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static abstract interface OnProgressCallback
/*      */     extends Callback
/*      */   {
/*      */     public abstract void onProgress(long paramLong1, long paramLong2);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static abstract interface GraphJSONArrayCallback
/*      */   {
/*      */     public abstract void onCompleted(JSONArray paramJSONArray, GraphResponse
        paramGraphResponse);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static abstract interface GraphJSONObjectCallback
/*      */   {
/*      */     public abstract void onCompleted(JSONObject paramJSONObject, GraphResponse paramGraphResponse);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable>
/*      */     implements Parcelable
/*      */   {
/*      */     private final String mimeType;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     private final RESOURCE resource;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public String getMimeType()
/*      */     {
/* 2366 */       return this.mimeType;
/*      */     }
/*      */     
/*      */     public RESOURCE getResource() {
/* 2370 */       return this.resource;
/*      */     }
/*      */     
/*      */     public int describeContents() {
/* 2374 */       return 1;
/*      */     }
/*      */     
/*      */     public void writeToParcel(Parcel out, int flags) {
/* 2378 */       out.writeString(this.mimeType);
/* 2379 */       out.writeParcelable(this.resource, flags);
/*      */     }
/*      */     
/*      */ 
/* 2383 */     public static final Creator<ParcelableResourceWithMimeType> CREATOR = new Creator()
/*      */     {
/*      */       public ParcelableResourceWithMimeType createFromParcel(Parcel in) {
/* 2386 */         return new ParcelableResourceWithMimeType(in, null);
/*      */       }
/*      */       
/*      */       public ParcelableResourceWithMimeType[] newArray(int size) {
/* 2390 */         return new ParcelableResourceWithMimeType[size];
/*      */       }
/*      */     };
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public ParcelableResourceWithMimeType(RESOURCE resource, String mimeType)
/*      */     {
/* 2403 */       this.mimeType = mimeType;
/* 2404 */       this.resource = resource;
/*      */     }
/*      */     
/*      */     private ParcelableResourceWithMimeType(Parcel in) {
/* 2408 */       this.mimeType = in.readString();
/* 2409 */       this.resource = in.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
/*      */     }
/*      */   }
/*      */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/GraphRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */