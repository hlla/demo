/*     */ package com.facebook.share.model;
/*     */ 
/*     */ import android.net.Uri;
/*     */ import android.os.Parcel;
/*     */ import android.support.annotation.Nullable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
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
/*     */ public abstract class ShareContent<P extends ShareContent, E extends Builder>
/*     */   implements ShareModel
/*     */ {
/*     */   private final Uri contentUrl;
/*     */   private final List<String> peopleIds;
/*     */   private final String placeId;
/*     */   private final String ref;
/*     */   private final ShareHashtag hashtag;
/*     */   
/*     */   protected ShareContent(Builder builder)
/*     */   {
/*  45 */     this.contentUrl = builder.contentUrl;
/*  46 */     this.peopleIds = builder.peopleIds;
/*  47 */     this.placeId = builder.placeId;
/*  48 */     this.ref = builder.ref;
/*  49 */     this.hashtag = builder.hashtag;
/*     */   }
/*     */   
/*     */   protected ShareContent(Parcel in) {
/*  53 */     this.contentUrl = ((Uri)in.readParcelable(Uri.class.getClassLoader()));
/*  54 */     this.peopleIds = readUnmodifiableStringList(in);
/*  55 */     this.placeId = in.readString();
/*  56 */     this.ref = in.readString();
/*  57 */     this.hashtag = new ShareHashtag.Builder().readFrom(in).build();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public Uri getContentUrl()
/*     */   {
/*  70 */     return this.contentUrl;
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
/*     */   @Nullable
/*     */   public List<String> getPeopleIds()
/*     */   {
/*  84 */     return this.peopleIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public String getPlaceId()
/*     */   {
/*  94 */     return this.placeId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public String getRef()
/*     */   {
/* 105 */     return this.ref;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public ShareHashtag getShareHashtag()
/*     */   {
/* 115 */     return this.hashtag;
/*     */   }
/*     */   
/*     */   public int describeContents() {
/* 119 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/* 123 */     out.writeParcelable(this.contentUrl, 0);
/* 124 */     out.writeStringList(this.peopleIds);
/* 125 */     out.writeString(this.placeId);
/* 126 */     out.writeString(this.ref);
/* 127 */     out.writeParcelable(this.hashtag, 0);
/*     */   }
/*     */   
/*     */   private List<String> readUnmodifiableStringList(Parcel in) {
/* 131 */     List<String> list = new ArrayList();
/* 132 */     in.readStringList(list);
/* 133 */     return list.size() == 0 ? null : Collections.unmodifiableList(list);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static abstract class Builder<P extends ShareContent, E extends Builder>
/*     */     implements ShareModelBuilder<P, E>
/*     */   {
/*     */     private Uri contentUrl;
/*     */     
/*     */     private List<String> peopleIds;
/*     */     
/*     */     private String placeId;
/*     */     
/*     */     private String ref;
/*     */     
/*     */     private ShareHashtag hashtag;
/*     */     
/*     */ 
/*     */     public E setContentUrl(@Nullable Uri contentUrl)
/*     */     {
/* 154 */       this.contentUrl = contentUrl;
/* 155 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E setPeopleIds(@Nullable List<String> peopleIds)
/*     */     {
/* 165 */       this.peopleIds = (peopleIds == null ? null : Collections.unmodifiableList(peopleIds));
/* 166 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E setPlaceId(@Nullable String placeId)
/*     */     {
/* 176 */       this.placeId = placeId;
/* 177 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E setRef(@Nullable String ref)
/*     */     {
/* 188 */       this.ref = ref;
/* 189 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E setShareHashtag(@Nullable ShareHashtag shareHashtag)
/*     */     {
/* 199 */       this.hashtag = shareHashtag;
/* 200 */       return this;
/*     */     }
/*     */     
/*     */     public E readFrom(P content)
/*     */     {
/* 205 */       if (content == null) {
/* 206 */         return this;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 212 */       return setContentUrl(content.getContentUrl()).setPeopleIds(content.getPeopleIds()).setPlaceId(content.getPlaceId()).setRef(content.getRef());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/ShareContent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */