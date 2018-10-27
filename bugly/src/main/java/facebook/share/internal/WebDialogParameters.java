/*     */ package com.facebook.share.internal;
/*     */ 
/*     */ import android.net.Uri;
/*     */ import android.os.Bundle;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Utility.Mapper;
/*     */ import com.facebook.share.model.AppGroupCreationContent;
/*     */ import com.facebook.share.model.AppGroupCreationContent.AppGroupPrivacy;
/*     */ import com.facebook.share.model.GameRequestContent;
/*     */ import com.facebook.share.model.GameRequestContent.ActionType;
/*     */ import com.facebook.share.model.GameRequestContent.Filters;
/*     */ import com.facebook.share.model.ShareContent;
/*     */ import com.facebook.share.model.ShareHashtag;
/*     */ import com.facebook.share.model.ShareLinkContent;
/*     */ import com.facebook.share.model.ShareOpenGraphAction;
/*     */ import com.facebook.share.model.ShareOpenGraphContent;
/*     */ import com.facebook.share.model.SharePhoto;
/*     */ import com.facebook.share.model.SharePhotoContent;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
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
/*     */ public class WebDialogParameters
/*     */ {
/*     */   public static Bundle create(AppGroupCreationContent appGroupCreationContent)
/*     */   {
/*  49 */     Bundle webParams = new Bundle();
/*     */     
/*  51 */     Utility.putNonEmptyString(webParams, "name", appGroupCreationContent
/*     */     
/*     */ 
/*  54 */       .getName());
/*     */     
/*  56 */     Utility.putNonEmptyString(webParams, "description", appGroupCreationContent
/*     */     
/*     */ 
/*  59 */       .getDescription());
/*     */     
/*     */ 
/*  62 */     AppGroupPrivacy privacy = appGroupCreationContent.getAppGroupPrivacy();
/*  63 */     if (privacy != null) {
/*  64 */       Utility.putNonEmptyString(webParams, "privacy", privacy
/*     */       
/*     */ 
/*  67 */         .toString().toLowerCase(Locale.ENGLISH));
/*     */     }
/*     */     
/*  70 */     return webParams;
/*     */   }
/*     */   
/*     */   public static Bundle create(GameRequestContent gameRequestContent) {
/*  74 */     Bundle webParams = new Bundle();
/*     */     
/*  76 */     Utility.putNonEmptyString(webParams, "message", gameRequestContent
/*     */     
/*     */ 
/*  79 */       .getMessage());
/*  80 */     Utility.putCommaSeparatedStringList(webParams, "to", gameRequestContent
/*     */     
/*     */ 
/*  83 */       .getRecipients());
/*  84 */     Utility.putNonEmptyString(webParams, "title", gameRequestContent
/*     */     
/*     */ 
/*  87 */       .getTitle());
/*  88 */     Utility.putNonEmptyString(webParams, "data", gameRequestContent
/*     */     
/*     */ 
/*  91 */       .getData());
/*  92 */     if (gameRequestContent.getActionType() != null) {
/*  93 */       Utility.putNonEmptyString(webParams, "action_type", gameRequestContent
/*     */       
/*     */ 
/*  96 */         .getActionType().toString().toLowerCase(Locale.ENGLISH));
/*     */     }
/*  98 */     Utility.putNonEmptyString(webParams, "object_id", gameRequestContent
/*     */     
/*     */ 
/* 101 */       .getObjectId());
/* 102 */     if (gameRequestContent.getFilters() != null) {
/* 103 */       Utility.putNonEmptyString(webParams, "filters", gameRequestContent
/*     */       
/*     */ 
/* 106 */         .getFilters().toString().toLowerCase(Locale.ENGLISH));
/*     */     }
/* 108 */     Utility.putCommaSeparatedStringList(webParams, "suggestions", gameRequestContent
/*     */     
/*     */ 
/* 111 */       .getSuggestions());
/* 112 */     return webParams;
/*     */   }
/*     */   
/*     */   public static Bundle create(ShareLinkContent shareLinkContent) {
/* 116 */     Bundle params = createBaseParameters(shareLinkContent);
/* 117 */     Utility.putUri(params, "href", shareLinkContent
/*     */     
/*     */ 
/* 120 */       .getContentUrl());
/*     */     
/* 122 */     Utility.putNonEmptyString(params, "quote", shareLinkContent
/*     */     
/*     */ 
/* 125 */       .getQuote());
/*     */     
/* 127 */     return params;
/*     */   }
/*     */   
/*     */   public static Bundle create(ShareOpenGraphContent shareOpenGraphContent) {
/* 131 */     Bundle params = createBaseParameters(shareOpenGraphContent);
/*     */     
/* 133 */     Utility.putNonEmptyString(params, "action_type", shareOpenGraphContent
/*     */     
/*     */ 
/* 136 */       .getAction().getActionType());
/*     */     try
/*     */     {
/* 139 */       JSONObject ogJSON = ShareInternalUtility.toJSONObjectForWeb(shareOpenGraphContent);
/* 140 */       ogJSON = ShareInternalUtility.removeNamespacesFromOGJsonObject(ogJSON, false);
/* 141 */       if (ogJSON != null) {
/* 142 */         Utility.putNonEmptyString(params, "action_properties", ogJSON
/*     */         
/*     */ 
/* 145 */           .toString());
/*     */       }
/*     */     } catch (JSONException e) {
/* 148 */       throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", e);
/*     */     }
/*     */     
/* 151 */     return params;
/*     */   }
/*     */   
/*     */   public static Bundle create(SharePhotoContent sharePhotoContent) {
/* 155 */     Bundle params = createBaseParameters(sharePhotoContent);
/*     */     
/* 157 */     String[] urls = new String[sharePhotoContent.getPhotos().size()];
/* 158 */     Utility.map(sharePhotoContent
/* 159 */       .getPhotos(), new Utility.Mapper()
/*     */       {
/*     */ 
/*     */         public String apply(SharePhoto item) {
/* 163 */           return item.getImageUrl().toString(); } })
/*     */       
/* 165 */       .toArray(urls);
/*     */     
/* 167 */     params.putStringArray("media", urls);
/*     */     
/* 169 */     return params;
/*     */   }
/*     */   
/*     */   public static Bundle createBaseParameters(ShareContent shareContent) {
/* 173 */     Bundle params = new Bundle();
/*     */     
/* 175 */     ShareHashtag shareHashtag = shareContent.getShareHashtag();
/* 176 */     if (shareHashtag != null) {
/* 177 */       Utility.putNonEmptyString(params, "hashtag", shareHashtag
/*     */       
/*     */ 
/* 180 */         .getHashtag());
/*     */     }
/*     */     
/* 183 */     return params;
/*     */   }
/*     */   
/*     */   public static Bundle createForFeed(ShareLinkContent shareLinkContent) {
/* 187 */     Bundle webParams = new Bundle();
/*     */     
/* 189 */     Utility.putNonEmptyString(webParams, "name", shareLinkContent
/*     */     
/*     */ 
/* 192 */       .getContentTitle());
/*     */     
/* 194 */     Utility.putNonEmptyString(webParams, "description", shareLinkContent
/*     */     
/*     */ 
/* 197 */       .getContentDescription());
/*     */     
/* 199 */     Utility.putNonEmptyString(webParams, "link", 
/*     */     
/*     */ 
/* 202 */       Utility.getUriString(shareLinkContent.getContentUrl()));
/*     */     
/* 204 */     Utility.putNonEmptyString(webParams, "picture", 
/*     */     
/*     */ 
/* 207 */       Utility.getUriString(shareLinkContent.getImageUrl()));
/*     */     
/* 209 */     Utility.putNonEmptyString(webParams, "quote", shareLinkContent
/*     */     
/*     */ 
/* 212 */       .getQuote());
/*     */     
/* 214 */     ShareHashtag shareHashtag = shareLinkContent.getShareHashtag();
/* 215 */     if (shareHashtag != null) {
/* 216 */       Utility.putNonEmptyString(webParams, "hashtag", shareLinkContent
/*     */       
/*     */ 
/* 219 */         .getShareHashtag().getHashtag());
/*     */     }
/* 221 */     return webParams;
/*     */   }
/*     */   
/*     */   public static Bundle createForFeed(ShareFeedContent shareFeedContent) {
/* 225 */     Bundle webParams = new Bundle();
/*     */     
/* 227 */     Utility.putNonEmptyString(webParams, "to", shareFeedContent
/*     */     
/*     */ 
/* 230 */       .getToId());
/*     */     
/* 232 */     Utility.putNonEmptyString(webParams, "link", shareFeedContent
/*     */     
/*     */ 
/* 235 */       .getLink());
/*     */     
/* 237 */     Utility.putNonEmptyString(webParams, "picture", shareFeedContent
/*     */     
/*     */ 
/* 240 */       .getPicture());
/*     */     
/* 242 */     Utility.putNonEmptyString(webParams, "source", shareFeedContent
/*     */     
/*     */ 
/* 245 */       .getMediaSource());
/*     */     
/* 247 */     Utility.putNonEmptyString(webParams, "name", shareFeedContent
/*     */     
/*     */ 
/* 250 */       .getLinkName());
/*     */     
/* 252 */     Utility.putNonEmptyString(webParams, "caption", shareFeedContent
/*     */     
/*     */ 
/* 255 */       .getLinkCaption());
/*     */     
/* 257 */     Utility.putNonEmptyString(webParams, "description", shareFeedContent
/*     */     
/*     */ 
/* 260 */       .getLinkDescription());
/*     */     
/* 262 */     return webParams;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/WebDialogParameters.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */