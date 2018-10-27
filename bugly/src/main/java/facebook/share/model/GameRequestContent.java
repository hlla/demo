/*     */ package com.facebook.share.model;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.text.TextUtils;
/*     */ import java.util.Arrays;
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
/*     */ public final class GameRequestContent
/*     */   implements ShareModel
/*     */ {
/*     */   private final String message;
/*     */   private final List<String> recipients;
/*     */   private final String title;
/*     */   private final String data;
/*     */   private final ActionType actionType;
/*     */   private final String objectId;
/*     */   private final Filters filters;
/*     */   private final List<String> suggestions;
/*     */   
/*     */   public static enum ActionType
/*     */   {
/*  34 */     SEND, 
/*  35 */     ASKFOR, 
/*  36 */     TURN;
/*     */     
/*     */     private ActionType() {} }
/*     */   
/*  40 */   public static enum Filters { APP_USERS, 
/*  41 */     APP_NON_USERS;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private Filters() {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private GameRequestContent(Builder builder)
/*     */   {
/*  55 */     this.message = builder.message;
/*  56 */     this.recipients = builder.recipients;
/*  57 */     this.title = builder.title;
/*  58 */     this.data = builder.data;
/*  59 */     this.actionType = builder.actionType;
/*  60 */     this.objectId = builder.objectId;
/*  61 */     this.filters = builder.filters;
/*  62 */     this.suggestions = builder.suggestions;
/*     */   }
/*     */   
/*     */   GameRequestContent(Parcel in) {
/*  66 */     this.message = in.readString();
/*  67 */     this.recipients = in.createStringArrayList();
/*  68 */     this.title = in.readString();
/*  69 */     this.data = in.readString();
/*  70 */     this.actionType = ((ActionType)in.readSerializable());
/*  71 */     this.objectId = in.readString();
/*  72 */     this.filters = ((Filters)in.readSerializable());
/*  73 */     this.suggestions = in.createStringArrayList();
/*  74 */     in.readStringList(this.suggestions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getMessage()
/*     */   {
/*  81 */     return this.message;
/*     */   }
/*     */   
/*     */ 
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   public String getTo()
/*     */   {
/*  90 */     return getRecipients() != null ? TextUtils.join(",", getRecipients()) : null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<String> getRecipients()
/*     */   {
/*  97 */     return this.recipients;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getTitle()
/*     */   {
/* 104 */     return this.title;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getData()
/*     */   {
/* 111 */     return this.data;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ActionType getActionType()
/*     */   {
/* 118 */     return this.actionType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getObjectId()
/*     */   {
/* 125 */     return this.objectId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Filters getFilters()
/*     */   {
/* 132 */     return this.filters;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<String> getSuggestions()
/*     */   {
/* 139 */     return this.suggestions;
/*     */   }
/*     */   
/*     */   public int describeContents() {
/* 143 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/* 147 */     out.writeString(this.message);
/* 148 */     out.writeStringList(this.recipients);
/* 149 */     out.writeString(this.title);
/* 150 */     out.writeString(this.data);
/* 151 */     out.writeSerializable(this.actionType);
/* 152 */     out.writeString(this.objectId);
/* 153 */     out.writeSerializable(this.filters);
/* 154 */     out.writeStringList(this.suggestions);
/*     */   }
/*     */   
/*     */ 
/* 158 */   public static final Parcelable.Creator<GameRequestContent> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public GameRequestContent createFromParcel(Parcel in) {
/* 161 */       return new GameRequestContent(in);
/*     */     }
/*     */     
/*     */     public GameRequestContent[] newArray(int size) {
/* 165 */       return new GameRequestContent[size];
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */   public static class Builder
/*     */     implements ShareModelBuilder<GameRequestContent, Builder>
/*     */   {
/*     */     private String message;
/*     */     
/*     */     private List<String> recipients;
/*     */     
/*     */     private String data;
/*     */     
/*     */     private String title;
/*     */     
/*     */     private ActionType actionType;
/*     */     
/*     */     private String objectId;
/*     */     
/*     */     private Filters filters;
/*     */     
/*     */     private List<String> suggestions;
/*     */     
/*     */     public Builder setMessage(String message)
/*     */     {
/* 191 */       this.message = message;
/* 192 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     /**
/*     */      * @deprecated
/*     */      */
/*     */     public Builder setTo(String to)
/*     */     {
/* 205 */       if (to != null) {
/* 206 */         String[] recipientsArray = to.split(",");
/* 207 */         this.recipients = Arrays.asList(recipientsArray);
/*     */       }
/*     */       
/* 210 */       return this;
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
/*     */     public Builder setRecipients(List<String> recipients)
/*     */     {
/* 224 */       this.recipients = recipients;
/* 225 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setData(String data)
/*     */     {
/* 236 */       this.data = data;
/* 237 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setTitle(String title)
/*     */     {
/* 247 */       this.title = title;
/* 248 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Builder setActionType(ActionType actionType)
/*     */     {
/* 255 */       this.actionType = actionType;
/* 256 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setObjectId(String objectId)
/*     */     {
/* 264 */       this.objectId = objectId;
/* 265 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Builder setFilters(Filters filters)
/*     */     {
/* 272 */       this.filters = filters;
/* 273 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Builder setSuggestions(List<String> suggestions)
/*     */     {
/* 280 */       this.suggestions = suggestions;
/* 281 */       return this;
/*     */     }
/*     */     
/*     */     public GameRequestContent build()
/*     */     {
/* 286 */       return new GameRequestContent(this, null);
/*     */     }
/*     */     
/*     */     public Builder readFrom(GameRequestContent content)
/*     */     {
/* 291 */       if (content == null) {
/* 292 */         return this;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 302 */       return setMessage(content.getMessage()).setRecipients(content.getRecipients()).setTitle(content.getTitle()).setData(content.getData()).setActionType(content.getActionType()).setObjectId(content.getObjectId()).setFilters(content.getFilters()).setSuggestions(content.getSuggestions());
/*     */     }
/*     */     
/*     */     Builder readFrom(Parcel parcel) {
/* 306 */       return readFrom(
/* 307 */         (GameRequestContent)parcel.readParcelable(GameRequestContent.class
/* 308 */         .getClassLoader()));
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/GameRequestContent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */