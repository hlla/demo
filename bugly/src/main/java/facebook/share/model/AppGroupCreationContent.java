/*     */ package com.facebook.share.model;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
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
/*     */ public final class AppGroupCreationContent
/*     */   implements ShareModel
/*     */ {
/*     */   private final String name;
/*     */   private final String description;
/*     */   private AppGroupPrivacy privacy;
/*     */   
/*     */   private AppGroupCreationContent(Builder builder)
/*     */   {
/*  34 */     this.name = builder.name;
/*  35 */     this.description = builder.description;
/*  36 */     this.privacy = builder.privacy;
/*     */   }
/*     */   
/*     */   AppGroupCreationContent(Parcel in) {
/*  40 */     this.name = in.readString();
/*  41 */     this.description = in.readString();
/*  42 */     this.privacy = ((AppGroupPrivacy)in.readSerializable());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/*  51 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDescription()
/*     */   {
/*  60 */     return this.description;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AppGroupPrivacy getAppGroupPrivacy()
/*     */   {
/*  69 */     return this.privacy;
/*     */   }
/*     */   
/*     */   public int describeContents() {
/*  73 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/*  77 */     out.writeString(this.name);
/*  78 */     out.writeString(this.description);
/*  79 */     out.writeSerializable(this.privacy);
/*     */   }
/*     */   
/*     */ 
/*  83 */   public static final Parcelable.Creator<AppGroupCreationContent> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public AppGroupCreationContent createFromParcel(Parcel in) {
/*  86 */       return new AppGroupCreationContent(in);
/*     */     }
/*     */     
/*     */     public AppGroupCreationContent[] newArray(int size) {
/*  90 */       return new AppGroupCreationContent[size];
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum AppGroupPrivacy
/*     */   {
/* 101 */     Open, 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 106 */     Closed;
/*     */     
/*     */ 
/*     */     private AppGroupPrivacy() {}
/*     */   }
/*     */   
/*     */ 
/*     */   public static class Builder
/*     */     implements ShareModelBuilder<AppGroupCreationContent, Builder>
/*     */   {
/*     */     private String name;
/*     */     
/*     */     private String description;
/*     */     
/*     */     private AppGroupPrivacy privacy;
/*     */     
/*     */ 
/*     */     public Builder setName(String name)
/*     */     {
/* 125 */       this.name = name;
/* 126 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setDescription(String description)
/*     */     {
/* 136 */       this.description = description;
/* 137 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setAppGroupPrivacy(AppGroupPrivacy privacy)
/*     */     {
/* 147 */       this.privacy = privacy;
/* 148 */       return this;
/*     */     }
/*     */     
/*     */     public AppGroupCreationContent build()
/*     */     {
/* 153 */       return new AppGroupCreationContent(this, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public Builder readFrom(AppGroupCreationContent content)
/*     */     {
/* 159 */       if (content == null) {
/* 160 */         return this;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 165 */       return setName(content.getName()).setDescription(content.getDescription()).setAppGroupPrivacy(content.getAppGroupPrivacy());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/AppGroupCreationContent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */