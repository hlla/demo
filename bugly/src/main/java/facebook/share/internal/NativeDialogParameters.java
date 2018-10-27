/*     */ package com.facebook.share.internal;
/*     */ 
/*     */ import android.os.Bundle;
/*     */ import android.util.Pair;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Validate;
/*     */ import com.facebook.share.model.ShareContent;
/*     */ import com.facebook.share.model.ShareHashtag;
/*     */ import com.facebook.share.model.ShareLinkContent;
/*     */ import com.facebook.share.model.ShareMediaContent;
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
/*     */ public class NativeDialogParameters
/*     */ {
/*     */   public static Bundle create(UUID callId, ShareContent shareContent, boolean shouldFailOnDataError)
/*     */   {
/*  54 */     Validate.notNull(shareContent, "shareContent");
/*  55 */     Validate.notNull(callId, "callId");
/*     */     
/*  57 */     Bundle nativeParams = null;
/*  58 */     if ((shareContent instanceof ShareLinkContent)) {
/*  59 */       ShareLinkContent linkContent = (ShareLinkContent)shareContent;
/*  60 */       nativeParams = create(linkContent, shouldFailOnDataError);
/*  61 */     } else if ((shareContent instanceof SharePhotoContent)) {
/*  62 */       SharePhotoContent photoContent = (SharePhotoContent)shareContent;
/*  63 */       List<String> photoUrls = ShareInternalUtility.getPhotoUrls(photoContent, callId);
/*     */       
/*     */ 
/*     */ 
/*  67 */       nativeParams = create(photoContent, photoUrls, shouldFailOnDataError);
/*  68 */     } else if ((shareContent instanceof ShareVideoContent)) {
/*  69 */       ShareVideoContent videoContent = (ShareVideoContent)shareContent;
/*  70 */       String videoUrl = ShareInternalUtility.getVideoUrl(videoContent, callId);
/*     */       
/*  72 */       nativeParams = create(videoContent, videoUrl, shouldFailOnDataError);
/*  73 */     } else if ((shareContent instanceof ShareOpenGraphContent)) {
/*  74 */       ShareOpenGraphContent openGraphContent = (ShareOpenGraphContent)shareContent;
/*     */       try {
/*  76 */         JSONObject openGraphActionJSON = ShareInternalUtility.toJSONObjectForCall(callId, openGraphContent);
/*     */         
/*  78 */         openGraphActionJSON = ShareInternalUtility.removeNamespacesFromOGJsonObject(openGraphActionJSON, false);
/*     */         
/*  80 */         nativeParams = create(openGraphContent, openGraphActionJSON, shouldFailOnDataError);
/*     */       }
/*     */       catch (JSONException e)
/*     */       {
/*  84 */         throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e.getMessage());
/*     */       }
/*  86 */     } else if ((shareContent instanceof ShareMediaContent)) {
/*  87 */       ShareMediaContent mediaContent = (ShareMediaContent)shareContent;
/*  88 */       List<Bundle> mediaInfos = ShareInternalUtility.getMediaInfos(mediaContent, callId);
/*     */       
/*     */ 
/*     */ 
/*  92 */       nativeParams = create(mediaContent, mediaInfos, shouldFailOnDataError);
/*     */     }
/*     */     
/*  95 */     return nativeParams;
/*     */   }
/*     */   
/*     */   private static Bundle create(ShareLinkContent linkContent, boolean dataErrorsFatal) {
/*  99 */     Bundle params = createBaseParameters(linkContent, dataErrorsFatal);
/*     */     
/* 101 */     Utility.putNonEmptyString(params, "TITLE", linkContent.getContentTitle());
/* 102 */     Utility.putNonEmptyString(params, "DESCRIPTION", linkContent
/* 103 */       .getContentDescription());
/* 104 */     Utility.putUri(params, "IMAGE", linkContent.getImageUrl());
/* 105 */     Utility.putNonEmptyString(params, "QUOTE", linkContent.getQuote());
/*     */     
/* 107 */     return params;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static Bundle create(SharePhotoContent photoContent, List<String> imageUrls, boolean dataErrorsFatal)
/*     */   {
/* 114 */     Bundle params = createBaseParameters(photoContent, dataErrorsFatal);
/*     */     
/* 116 */     params.putStringArrayList("PHOTOS", new ArrayList(imageUrls));
/*     */     
/* 118 */     return params;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static Bundle create(ShareVideoContent videoContent, String videoUrl, boolean dataErrorsFatal)
/*     */   {
/* 125 */     Bundle params = createBaseParameters(videoContent, dataErrorsFatal);
/*     */     
/* 127 */     Utility.putNonEmptyString(params, "TITLE", videoContent.getContentTitle());
/* 128 */     Utility.putNonEmptyString(params, "DESCRIPTION", videoContent
/* 129 */       .getContentDescription());
/* 130 */     Utility.putNonEmptyString(params, "VIDEO", videoUrl);
/*     */     
/* 132 */     return params;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static Bundle create(ShareMediaContent mediaContent, List<Bundle> mediaInfos, boolean dataErrorsFatal)
/*     */   {
/* 139 */     Bundle params = createBaseParameters(mediaContent, dataErrorsFatal);
/*     */     
/* 141 */     params.putParcelableArrayList("MEDIA", new ArrayList(mediaInfos));
/*     */     
/* 143 */     return params;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static Bundle create(ShareOpenGraphContent openGraphContent, JSONObject openGraphActionJSON, boolean dataErrorsFatal)
/*     */   {
/* 150 */     Bundle params = createBaseParameters(openGraphContent, dataErrorsFatal);
/*     */     
/*     */ 
/* 153 */     String previewProperty = (String)ShareInternalUtility.getFieldNameAndNamespaceFromFullName(openGraphContent
/* 154 */       .getPreviewPropertyName()).second;
/*     */     
/* 156 */     Utility.putNonEmptyString(params, "PREVIEW_PROPERTY_NAME", previewProperty);
/*     */     
/*     */ 
/*     */ 
/* 160 */     Utility.putNonEmptyString(params, "ACTION_TYPE", openGraphContent
/*     */     
/*     */ 
/* 163 */       .getAction().getActionType());
/*     */     
/* 165 */     Utility.putNonEmptyString(params, "ACTION", openGraphActionJSON
/*     */     
/*     */ 
/* 168 */       .toString());
/*     */     
/* 170 */     return params;
/*     */   }
/*     */   
/*     */   private static Bundle createBaseParameters(ShareContent content, boolean dataErrorsFatal) {
/* 174 */     Bundle params = new Bundle();
/*     */     
/* 176 */     Utility.putUri(params, "LINK", content.getContentUrl());
/* 177 */     Utility.putNonEmptyString(params, "PLACE", content.getPlaceId());
/* 178 */     Utility.putNonEmptyString(params, "REF", content.getRef());
/*     */     
/* 180 */     params.putBoolean("DATA_FAILURES_FATAL", dataErrorsFatal);
/*     */     
/* 182 */     List<String> peopleIds = content.getPeopleIds();
/* 183 */     if (!Utility.isNullOrEmpty(peopleIds)) {
/* 184 */       params.putStringArrayList("FRIENDS", new ArrayList(peopleIds));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 189 */     ShareHashtag shareHashtag = content.getShareHashtag();
/* 190 */     if (shareHashtag != null) {
/* 191 */       Utility.putNonEmptyString(params, "HASHTAG", shareHashtag.getHashtag());
/*     */     }
/*     */     
/* 194 */     return params;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/NativeDialogParameters.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */