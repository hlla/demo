/*     */ package com.facebook;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.os.Parcelable.Creator;
/*     */ import com.facebook.internal.FacebookRequestErrorClassification;
/*     */ import com.facebook.internal.FetchedAppSettings;
/*     */ import com.facebook.internal.FetchedAppSettingsManager;
/*     */ import com.facebook.internal.Utility;
/*     */ import java.net.HttpURLConnection;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FacebookRequestError
/*     */   implements Parcelable
/*     */ {
/*     */   public static final int INVALID_ERROR_CODE = -1;
/*     */   public static final int INVALID_HTTP_STATUS_CODE = -1;
/*     */   private static final String CODE_KEY = "code";
/*     */   private static final String BODY_KEY = "body";
/*     */   private static final String ERROR_KEY = "error";
/*     */   private static final String ERROR_TYPE_FIELD_KEY = "type";
/*     */   private static final String ERROR_CODE_FIELD_KEY = "code";
/*     */   private static final String ERROR_MESSAGE_FIELD_KEY = "message";
/*     */   private static final String ERROR_CODE_KEY = "error_code";
/*     */   private static final String ERROR_SUB_CODE_KEY = "error_subcode";
/*     */   private static final String ERROR_MSG_KEY = "error_msg";
/*     */   private static final String ERROR_REASON_KEY = "error_reason";
/*     */   private static final String ERROR_USER_TITLE_KEY = "error_user_title";
/*     */   private static final String ERROR_USER_MSG_KEY = "error_user_msg";
/*     */   private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
/*     */   
/*     */   private static class Range
/*     */   {
/*     */     private final int start;
/*     */     private final int end;
/*     */     
/*     */     private Range(int start, int end)
/*     */     {
/*  75 */       this.start = start;
/*  76 */       this.end = end;
/*     */     }
/*     */     
/*     */     boolean contains(int value) {
/*  80 */       return (this.start <= value) && (value <= this.end);
/*     */     }
/*     */   }
/*     */   
/*  84 */   static final Range HTTP_RANGE_SUCCESS = new Range(200, 299, null);
/*     */   
/*     */   private final Category category;
/*     */   
/*     */   private final int requestStatusCode;
/*     */   
/*     */   private final int errorCode;
/*     */   
/*     */   private final int subErrorCode;
/*     */   
/*     */   private final String errorType;
/*     */   
/*     */   private final String errorMessage;
/*     */   
/*     */   private final String errorUserTitle;
/*     */   
/*     */   private final String errorUserMessage;
/*     */   
/*     */   private final String errorRecoveryMessage;
/*     */   
/*     */   private final JSONObject requestResult;
/*     */   
/*     */   private final JSONObject requestResultBody;
/*     */   
/*     */   private final Object batchRequestResult;
/*     */   
/*     */   private final HttpURLConnection connection;
/*     */   private final FacebookException exception;
/*     */   
/*     */   private FacebookRequestError(int requestStatusCode, int errorCode, int subErrorCode, String errorType, String errorMessage, String errorUserTitle, String errorUserMessage, boolean errorIsTransient, JSONObject requestResultBody, JSONObject requestResult, Object batchRequestResult, HttpURLConnection connection, FacebookException exception)
/*     */   {
/* 115 */     this.requestStatusCode = requestStatusCode;
/* 116 */     this.errorCode = errorCode;
/* 117 */     this.subErrorCode = subErrorCode;
/* 118 */     this.errorType = errorType;
/* 119 */     this.errorMessage = errorMessage;
/* 120 */     this.requestResultBody = requestResultBody;
/* 121 */     this.requestResult = requestResult;
/* 122 */     this.batchRequestResult = batchRequestResult;
/* 123 */     this.connection = connection;
/* 124 */     this.errorUserTitle = errorUserTitle;
/* 125 */     this.errorUserMessage = errorUserMessage;
/*     */     
/* 127 */     boolean isLocalException = false;
/* 128 */     if (exception != null) {
/* 129 */       this.exception = exception;
/* 130 */       isLocalException = true;
/*     */     } else {
/* 132 */       this.exception = new FacebookServiceException(this, errorMessage);
/*     */     }
/*     */     
/* 135 */     FacebookRequestErrorClassification errorClassification = getErrorClassification();
/*     */     
/*     */ 
/* 138 */     this.category = (isLocalException ? Category.OTHER : errorClassification.classify(errorCode, subErrorCode, errorIsTransient));
/* 139 */     this.errorRecoveryMessage = errorClassification.getRecoveryMessage(this.category);
/*     */   }
/*     */   
/*     */   FacebookRequestError(HttpURLConnection connection, Exception exception) {
/* 143 */     this(-1, -1, -1, null, null, null, null, false, null, null, null, connection, (exception instanceof FacebookException) ? (FacebookException)exception : new FacebookException(exception));
/*     */   }
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
/*     */   public FacebookRequestError(int errorCode, String errorType, String errorMessage)
/*     */   {
/* 161 */     this(-1, errorCode, -1, errorType, errorMessage, null, null, false, null, null, null, null, null);
/*     */   }
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
/*     */   public Category getCategory()
/*     */   {
/* 185 */     return this.category;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRequestStatusCode()
/*     */   {
/* 194 */     return this.requestStatusCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getErrorCode()
/*     */   {
/* 203 */     return this.errorCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSubErrorCode()
/*     */   {
/* 212 */     return this.subErrorCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getErrorType()
/*     */   {
/* 223 */     return this.errorType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getErrorMessage()
/*     */   {
/* 232 */     if (this.errorMessage != null) {
/* 233 */       return this.errorMessage;
/*     */     }
/* 235 */     return this.exception.getLocalizedMessage();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getErrorRecoveryMessage()
/*     */   {
/* 244 */     return this.errorRecoveryMessage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getErrorUserMessage()
/*     */   {
/* 256 */     return this.errorUserMessage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getErrorUserTitle()
/*     */   {
/* 267 */     return this.errorUserTitle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public JSONObject getRequestResultBody()
/*     */   {
/* 276 */     return this.requestResultBody;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public JSONObject getRequestResult()
/*     */   {
/* 288 */     return this.requestResult;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Object getBatchRequestResult()
/*     */   {
/* 301 */     return this.batchRequestResult;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HttpURLConnection getConnection()
/*     */   {
/* 310 */     return this.connection;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public FacebookException getException()
/*     */   {
/* 319 */     return this.exception;
/*     */   }
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
/*     */   public String toString()
/*     */   {
/* 333 */     return "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
/*     */   }
/*     */   
/*     */ 
/*     */   static FacebookRequestError checkResponseAndCreateError(JSONObject singleResult, Object batchResult, HttpURLConnection connection)
/*     */   {
/*     */     try
/*     */     {
/* 341 */       if (singleResult.has("code")) {
/* 342 */         int responseCode = singleResult.getInt("code");
/* 343 */         Object body = Utility.getStringPropertyAsJSON(singleResult, "body", "FACEBOOK_NON_JSON_RESULT");
/*     */         
/*     */ 
/* 346 */         if ((body != null) && ((body instanceof JSONObject))) {
/* 347 */           JSONObject jsonBody = (JSONObject)body;
/*     */           
/*     */ 
/*     */ 
/* 351 */           String errorType = null;
/* 352 */           String errorMessage = null;
/* 353 */           String errorUserMessage = null;
/* 354 */           String errorUserTitle = null;
/* 355 */           boolean errorIsTransient = false;
/* 356 */           int errorCode = -1;
/* 357 */           int errorSubCode = -1;
/*     */           
/* 359 */           boolean hasError = false;
/* 360 */           if (jsonBody.has("error"))
/*     */           {
/*     */ 
/* 363 */             JSONObject error = (JSONObject)Utility.getStringPropertyAsJSON(jsonBody, "error", null);
/*     */             
/* 365 */             errorType = error.optString("type", null);
/* 366 */             errorMessage = error.optString("message", null);
/* 367 */             errorCode = error.optInt("code", -1);
/* 368 */             errorSubCode = error.optInt("error_subcode", -1);
/* 369 */             errorUserMessage = error.optString("error_user_msg", null);
/* 370 */             errorUserTitle = error.optString("error_user_title", null);
/* 371 */             errorIsTransient = error.optBoolean("is_transient", false);
/* 372 */             hasError = true;
/* 373 */           } else if ((jsonBody.has("error_code")) || (jsonBody.has("error_msg")) || 
/* 374 */             (jsonBody.has("error_reason"))) {
/* 375 */             errorType = jsonBody.optString("error_reason", null);
/* 376 */             errorMessage = jsonBody.optString("error_msg", null);
/* 377 */             errorCode = jsonBody.optInt("error_code", -1);
/* 378 */             errorSubCode = jsonBody.optInt("error_subcode", -1);
/* 379 */             hasError = true;
/*     */           }
/*     */           
/* 382 */           if (hasError) {
/* 383 */             return new FacebookRequestError(responseCode, errorCode, errorSubCode, errorType, errorMessage, errorUserTitle, errorUserMessage, errorIsTransient, jsonBody, singleResult, batchResult, connection, null);
/*     */           }
/*     */         }
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
/* 402 */         if (!HTTP_RANGE_SUCCESS.contains(responseCode))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 413 */           return new FacebookRequestError(responseCode, -1, -1, null, null, null, null, false, singleResult.has("body") ? (JSONObject)Utility.getStringPropertyAsJSON(singleResult, "body", "FACEBOOK_NON_JSON_RESULT") : null, singleResult, batchResult, connection, null);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 426 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   static synchronized FacebookRequestErrorClassification getErrorClassification()
/*     */   {
/* 432 */     FetchedAppSettings appSettings = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
/* 433 */     if (appSettings == null) {
/* 434 */       return FacebookRequestErrorClassification.getDefaultErrorClassification();
/*     */     }
/* 436 */     return appSettings.getErrorClassification();
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/* 440 */     out.writeInt(this.requestStatusCode);
/* 441 */     out.writeInt(this.errorCode);
/* 442 */     out.writeInt(this.subErrorCode);
/* 443 */     out.writeString(this.errorType);
/* 444 */     out.writeString(this.errorMessage);
/* 445 */     out.writeString(this.errorUserTitle);
/* 446 */     out.writeString(this.errorUserMessage);
/*     */   }
/*     */   
/* 449 */   public static final Creator<FacebookRequestError> CREATOR = new Creator()
/*     */   {
/*     */     public FacebookRequestError createFromParcel(Parcel in) {
/* 452 */       return new FacebookRequestError(in, null);
/*     */     }
/*     */     
/*     */     public FacebookRequestError[] newArray(int size) {
/* 456 */       return new FacebookRequestError[size];
/*     */     }
/*     */   };
/*     */   
/*     */   private FacebookRequestError(Parcel in) {
/* 461 */     this(in
/* 462 */       .readInt(), in
/* 463 */       .readInt(), in
/* 464 */       .readInt(), in
/* 465 */       .readString(), in
/* 466 */       .readString(), in
/* 467 */       .readString(), in
/* 468 */       .readString(), false, null, null, null, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int describeContents()
/*     */   {
/* 479 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum Category
/*     */   {
/* 492 */     LOGIN_RECOVERABLE, 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 497 */     OTHER, 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 502 */     TRANSIENT;
/*     */     
/*     */     private Category() {}
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookRequestError.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */