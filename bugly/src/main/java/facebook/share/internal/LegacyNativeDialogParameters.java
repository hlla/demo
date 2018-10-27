/*     */ package com.facebook.share.internal;
/*     */ 
/*     */ import android.os.Bundle;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Validate;
/*     */ import com.facebook.share.model.ShareContent;
/*     */ import com.facebook.share.model.ShareLinkContent;
/*     */ import com.facebook.share.model.ShareOpenGraphAction;
/*     */ import com.facebook.share.model.ShareOpenGraphContent;
/*     */ import com.facebook.share.model.SharePhotoContent;
/*     */ import com.facebook.share.model.ShareVideoContent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
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
/*     */ public class LegacyNativeDialogParameters
/*     */ {
/*     */   public static Bundle create(UUID callId, ShareContent shareContent, boolean shouldFailOnDataError)
/*     */   {
/*  52 */     Validate.notNull(shareContent, "shareContent");
/*  53 */     Validate.notNull(callId, "callId");
/*     */     
/*  55 */     Bundle nativeParams = null;
/*  56 */     if ((shareContent instanceof ShareLinkContent)) {
/*  57 */       ShareLinkContent linkContent = (ShareLinkContent)shareContent;
/*  58 */       nativeParams = create(linkContent, shouldFailOnDataError);
/*  59 */     } else if ((shareContent instanceof SharePhotoContent)) {
/*  60 */       SharePhotoContent photoContent = (SharePhotoContent)shareContent;
/*  61 */       List<String> photoUrls = ShareInternalUtility.getPhotoUrls(photoContent, callId);
/*     */       
/*     */ 
/*     */ 
/*  65 */       nativeParams = create(photoContent, photoUrls, shouldFailOnDataError);
/*  66 */     } else if ((shareContent instanceof ShareVideoContent)) {
/*  67 */       ShareVideoContent videoContent = (ShareVideoContent)shareContent;
/*  68 */       nativeParams = create(videoContent, shouldFailOnDataError);
/*  69 */     } else if ((shareContent instanceof ShareOpenGraphContent)) {
/*  70 */       ShareOpenGraphContent openGraphContent = (ShareOpenGraphContent)shareContent;
/*     */       try {
/*  72 */         JSONObject openGraphActionJSON = ShareInternalUtility.toJSONObjectForCall(callId, openGraphContent);
/*     */         
/*     */ 
/*  75 */         nativeParams = create(openGraphContent, openGraphActionJSON, shouldFailOnDataError);
/*     */       }
/*     */       catch (JSONException e)
/*     */       {
/*  79 */         throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e.getMessage());
/*     */       }
/*     */     }
/*     */     
/*  83 */     return nativeParams;
/*     */   }
/*     */   
/*     */   private static Bundle create(ShareLinkContent linkContent, boolean dataErrorsFatal) {
/*  87 */     Bundle params = createBaseParameters(linkContent, dataErrorsFatal);
/*     */     
/*  89 */     Utility.putNonEmptyString(params, "com.facebook.platform.extra.TITLE", linkContent
/*  90 */       .getContentTitle());
/*  91 */     Utility.putNonEmptyString(params, "com.facebook.platform.extra.DESCRIPTION", linkContent
/*  92 */       .getContentDescription());
/*  93 */     Utility.putUri(params, "com.facebook.platform.extra.IMAGE", linkContent.getImageUrl());
/*     */     
/*  95 */     return params;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static Bundle create(SharePhotoContent photoContent, List<String> imageUrls, boolean dataErrorsFatal)
/*     */   {
/* 102 */     Bundle params = createBaseParameters(photoContent, dataErrorsFatal);
/*     */     
/* 104 */     params.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList(imageUrls));
/*     */     
/* 106 */     return params;
/*     */   }
/*     */   
/*     */   private static Bundle create(ShareVideoContent videoContent, boolean dataErrorsFatal)
/*     */   {
/* 111 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static Bundle create(ShareOpenGraphContent openGraphContent, JSONObject openGraphActionJSON, boolean dataErrorsFatal)
/*     */   {
/* 118 */     Bundle params = createBaseParameters(openGraphContent, dataErrorsFatal);
/*     */     
/* 120 */     Utility.putNonEmptyString(params, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", openGraphContent
/*     */     
/*     */ 
/* 123 */       .getPreviewPropertyName());
/* 124 */     Utility.putNonEmptyString(params, "com.facebook.platform.extra.ACTION_TYPE", openGraphContent
/*     */     
/*     */ 
/* 127 */       .getAction().getActionType());
/*     */     
/* 129 */     Utility.putNonEmptyString(params, "com.facebook.platform.extra.ACTION", openGraphActionJSON
/*     */     
/*     */ 
/* 132 */       .toString());
/*     */     
/* 134 */     return params;
/*     */   }
/*     */   
/*     */   private static Bundle createBaseParameters(ShareContent content, boolean dataErrorsFatal) {
/* 138 */     Bundle params = new Bundle();
/*     */     
/* 140 */     Utility.putUri(params, "com.facebook.platform.extra.LINK", content.getContentUrl());
/* 141 */     Utility.putNonEmptyString(params, "com.facebook.platform.extra.PLACE", content.getPlaceId());
/* 142 */     Utility.putNonEmptyString(params, "com.facebook.platform.extra.REF", content.getRef());
/*     */     
/* 144 */     params.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", dataErrorsFatal);
/*     */     
/* 146 */     List<String> peopleIds = content.getPeopleIds();
/* 147 */     if (!Utility.isNullOrEmpty(peopleIds)) {
/* 148 */       params.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList(peopleIds));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 153 */     return params;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/LegacyNativeDialogParameters.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */