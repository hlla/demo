/*     */ package com.facebook.share.internal;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import com.facebook.share.model.ShareContent;
/*     */ import com.facebook.share.model.ShareContent.Builder;
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
/*     */ public class ShareFeedContent
/*     */   extends ShareContent<ShareFeedContent, Builder>
/*     */ {
/*     */   private final String toId;
/*     */   private final String link;
/*     */   private final String linkName;
/*     */   private final String linkCaption;
/*     */   private final String linkDescription;
/*     */   private final String picture;
/*     */   private final String mediaSource;
/*     */   
/*     */   private ShareFeedContent(Builder builder)
/*     */   {
/*  41 */     super(builder);
/*  42 */     this.toId = builder.toId;
/*  43 */     this.link = builder.link;
/*  44 */     this.linkName = builder.linkName;
/*  45 */     this.linkCaption = builder.linkCaption;
/*  46 */     this.linkDescription = builder.linkDescription;
/*  47 */     this.picture = builder.picture;
/*  48 */     this.mediaSource = builder.mediaSource;
/*     */   }
/*     */   
/*     */   ShareFeedContent(Parcel in) {
/*  52 */     super(in);
/*  53 */     this.toId = in.readString();
/*  54 */     this.link = in.readString();
/*  55 */     this.linkName = in.readString();
/*  56 */     this.linkCaption = in.readString();
/*  57 */     this.linkDescription = in.readString();
/*  58 */     this.picture = in.readString();
/*  59 */     this.mediaSource = in.readString();
/*     */   }
/*     */   
/*     */   public String getToId() {
/*  63 */     return this.toId;
/*     */   }
/*     */   
/*     */   public String getLink() {
/*  67 */     return this.link;
/*     */   }
/*     */   
/*     */   public String getLinkName() {
/*  71 */     return this.linkName;
/*     */   }
/*     */   
/*     */   public String getLinkCaption() {
/*  75 */     return this.linkCaption;
/*     */   }
/*     */   
/*     */   public String getLinkDescription() {
/*  79 */     return this.linkDescription;
/*     */   }
/*     */   
/*     */   public String getPicture() {
/*  83 */     return this.picture;
/*     */   }
/*     */   
/*     */   public String getMediaSource() {
/*  87 */     return this.mediaSource;
/*     */   }
/*     */   
/*     */   public int describeContents() {
/*  91 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/*  95 */     super.writeToParcel(out, flags);
/*  96 */     out.writeString(this.toId);
/*  97 */     out.writeString(this.link);
/*  98 */     out.writeString(this.linkName);
/*  99 */     out.writeString(this.linkCaption);
/* 100 */     out.writeString(this.linkDescription);
/* 101 */     out.writeString(this.picture);
/* 102 */     out.writeString(this.mediaSource);
/*     */   }
/*     */   
/*     */ 
/* 106 */   public static final Parcelable.Creator<ShareFeedContent> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public ShareFeedContent createFromParcel(Parcel in) {
/* 109 */       return new ShareFeedContent(in);
/*     */     }
/*     */     
/*     */     public ShareFeedContent[] newArray(int size) {
/* 113 */       return new ShareFeedContent[size];
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */   public static final class Builder
/*     */     extends ShareContent.Builder<ShareFeedContent, Builder>
/*     */   {
/*     */     private String toId;
/*     */     private String link;
/*     */     private String linkName;
/*     */     private String linkCaption;
/*     */     private String linkDescription;
/*     */     private String picture;
/*     */     private String mediaSource;
/*     */     
/*     */     public Builder setToId(String toId)
/*     */     {
/* 131 */       this.toId = toId;
/* 132 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setLink(String link) {
/* 136 */       this.link = link;
/* 137 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setLinkName(String linkName) {
/* 141 */       this.linkName = linkName;
/* 142 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setLinkCaption(String linkCaption) {
/* 146 */       this.linkCaption = linkCaption;
/* 147 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setLinkDescription(String linkDescription) {
/* 151 */       this.linkDescription = linkDescription;
/* 152 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setPicture(String picture) {
/* 156 */       this.picture = picture;
/* 157 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setMediaSource(String mediaSource) {
/* 161 */       this.mediaSource = mediaSource;
/* 162 */       return this;
/*     */     }
/*     */     
/*     */     public ShareFeedContent build()
/*     */     {
/* 167 */       return new ShareFeedContent(this, null);
/*     */     }
/*     */     
/*     */     public Builder readFrom(ShareFeedContent model)
/*     */     {
/* 172 */       if (model == null) {
/* 173 */         return this;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 183 */       return ((Builder)super.readFrom(model)).setToId(model.getToId()).setLink(model.getLink()).setLinkName(model.getLinkName()).setLinkCaption(model.getLinkCaption()).setLinkDescription(model.getLinkDescription()).setPicture(model.getPicture()).setMediaSource(model.getMediaSource());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/ShareFeedContent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */