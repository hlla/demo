/*     */ package com.facebook.share.model;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.text.TextUtils;
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
/*     */ public final class AppInviteContent
/*     */   implements ShareModel
/*     */ {
/*     */   private final String applinkUrl;
/*     */   private final String previewImageUrl;
/*     */   private final String promoCode;
/*     */   private final String promoText;
/*     */   private final Builder.Destination destination;
/*     */   
/*     */   private AppInviteContent(Builder builder)
/*     */   {
/*  37 */     this.applinkUrl = builder.applinkUrl;
/*  38 */     this.previewImageUrl = builder.previewImageUrl;
/*  39 */     this.promoCode = builder.promoCode;
/*  40 */     this.promoText = builder.promoText;
/*  41 */     this.destination = builder.destination;
/*     */   }
/*     */   
/*     */   AppInviteContent(Parcel in) {
/*  45 */     this.applinkUrl = in.readString();
/*  46 */     this.previewImageUrl = in.readString();
/*  47 */     this.promoText = in.readString();
/*  48 */     this.promoCode = in.readString();
/*     */     
/*  50 */     String destinationString = in.readString();
/*  51 */     if (destinationString.length() > 0) {
/*  52 */       this.destination = Builder.Destination.valueOf(destinationString);
/*     */     }
/*     */     else {
/*  55 */       this.destination = Builder.Destination.FACEBOOK;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getApplinkUrl()
/*     */   {
/*  64 */     return this.applinkUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPreviewImageUrl()
/*     */   {
/*  72 */     return this.previewImageUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPromotionCode()
/*     */   {
/*  80 */     return this.promoCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPromotionText()
/*     */   {
/*  88 */     return this.promoText;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Builder.Destination getDestination()
/*     */   {
/*  96 */     if (this.destination != null) {
/*  97 */       return this.destination;
/*     */     }
/*  99 */     return Builder.Destination.FACEBOOK;
/*     */   }
/*     */   
/*     */   public int describeContents()
/*     */   {
/* 104 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/* 108 */     out.writeString(this.applinkUrl);
/* 109 */     out.writeString(this.previewImageUrl);
/* 110 */     out.writeString(this.promoText);
/* 111 */     out.writeString(this.promoCode);
/* 112 */     out.writeString(this.destination.toString());
/*     */   }
/*     */   
/*     */ 
/* 116 */   public static final Parcelable.Creator<AppInviteContent> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public AppInviteContent createFromParcel(Parcel in) {
/* 119 */       return new AppInviteContent(in);
/*     */     }
/*     */     
/*     */     public AppInviteContent[] newArray(int size) {
/* 123 */       return new AppInviteContent[size];
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */   public static class Builder
/*     */     implements ShareModelBuilder<AppInviteContent, Builder>
/*     */   {
/*     */     private String applinkUrl;
/*     */     
/*     */     private String previewImageUrl;
/*     */     private String promoCode;
/*     */     private String promoText;
/*     */     private Destination destination;
/*     */     
/*     */     public static enum Destination
/*     */     {
/* 140 */       FACEBOOK("facebook"), 
/* 141 */       MESSENGER("messenger");
/*     */       
/*     */       private final String name;
/*     */       
/*     */       private Destination(String s) {
/* 146 */         this.name = s;
/*     */       }
/*     */       
/*     */       public boolean equalsName(String otherName) {
/* 150 */         return otherName == null ? false : this.name.equals(otherName);
/*     */       }
/*     */       
/*     */       public String toString() {
/* 154 */         return this.name;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setApplinkUrl(String applinkUrl)
/*     */     {
/* 165 */       this.applinkUrl = applinkUrl;
/* 166 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setPreviewImageUrl(String previewImageUrl)
/*     */     {
/* 176 */       this.previewImageUrl = previewImageUrl;
/* 177 */       return this;
/*     */     }
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
/*     */     public Builder setPromotionDetails(String promotionText, String promotionCode)
/*     */     {
/* 193 */       if (!TextUtils.isEmpty(promotionText)) {
/* 194 */         if (promotionText.length() > 80) {
/* 195 */           throw new IllegalArgumentException("Invalid promotion text, promotionText needs to be between1 and 80 characters long");
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 200 */         if (!isAlphanumericWithSpaces(promotionText)) {
/* 201 */           throw new IllegalArgumentException("Invalid promotion text, promotionText can only contain alphanumericcharacters and spaces.");
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 206 */         if (!TextUtils.isEmpty(promotionCode))
/*     */         {
/* 208 */           if (promotionCode.length() > 10) {
/* 209 */             throw new IllegalArgumentException("Invalid promotion code, promotionCode can be between1 and 10 characters long");
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 214 */           if (!isAlphanumericWithSpaces(promotionCode)) {
/* 215 */             throw new IllegalArgumentException("Invalid promotion code, promotionCode can only contain alphanumeric characters and spaces.");
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 220 */       else if (!TextUtils.isEmpty(promotionCode)) {
/* 221 */         throw new IllegalArgumentException("promotionCode cannot be specified without a valid promotionText");
/*     */       }
/*     */       
/*     */ 
/* 225 */       this.promoCode = promotionCode;
/* 226 */       this.promoText = promotionText;
/* 227 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setDestination(Destination destination) {
/* 231 */       this.destination = destination;
/* 232 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public AppInviteContent build()
/*     */     {
/* 238 */       return new AppInviteContent(this, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public Builder readFrom(AppInviteContent content)
/*     */     {
/* 244 */       if (content == null) {
/* 245 */         return this;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 251 */       return setApplinkUrl(content.getApplinkUrl()).setPreviewImageUrl(content.getPreviewImageUrl()).setPromotionDetails(content.getPromotionText(), content.getPromotionCode()).setDestination(content.getDestination());
/*     */     }
/*     */     
/*     */     private boolean isAlphanumericWithSpaces(String str) {
/* 255 */       for (int i = 0; i < str.length(); i++) {
/* 256 */         char c = str.charAt(i);
/* 257 */         if ((!Character.isDigit(c)) && (!Character.isLetter(c)) && (!Character.isSpaceChar(c))) {
/* 258 */           return false;
/*     */         }
/*     */       }
/* 261 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/AppInviteContent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */