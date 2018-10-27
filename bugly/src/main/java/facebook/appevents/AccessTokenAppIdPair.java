/*    */ package com.facebook.appevents;
/*    */ 
/*    */ import com.facebook.AccessToken;
/*    */ import com.facebook.FacebookSdk;
/*    */ import com.facebook.internal.Utility;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class AccessTokenAppIdPair
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final String accessTokenString;
/*    */   private final String applicationId;
/*    */   
/*    */   public AccessTokenAppIdPair(AccessToken accessToken)
/*    */   {
/* 35 */     this(accessToken.getToken(), FacebookSdk.getApplicationId());
/*    */   }
/*    */   
/*    */   public AccessTokenAppIdPair(String accessTokenString, String applicationId) {
/* 39 */     this.accessTokenString = (Utility.isNullOrEmpty(accessTokenString) ? null : accessTokenString);
/*    */     
/*    */ 
/* 42 */     this.applicationId = applicationId;
/*    */   }
/*    */   
/*    */   public String getAccessTokenString() {
/* 46 */     return this.accessTokenString;
/*    */   }
/*    */   
/*    */   public String getApplicationId() {
/* 50 */     return this.applicationId;
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 56 */     return (this.accessTokenString == null ? 0 : this.accessTokenString.hashCode()) ^ (this.applicationId == null ? 0 : this.applicationId.hashCode());
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 61 */     if (!(o instanceof AccessTokenAppIdPair)) {
/* 62 */       return false;
/*    */     }
/* 64 */     AccessTokenAppIdPair p = (AccessTokenAppIdPair)o;
/*    */     
/* 66 */     return (Utility.areObjectsEqual(p.accessTokenString, this.accessTokenString)) && (Utility.areObjectsEqual(p.applicationId, this.applicationId));
/*    */   }
/*    */   
/*    */   static class SerializationProxyV1 implements Serializable {
/*    */     private static final long serialVersionUID = -2488473066578201069L;
/*    */     private final String accessTokenString;
/*    */     private final String appId;
/*    */     
/*    */     private SerializationProxyV1(String accessTokenString, String appId) {
/* 75 */       this.accessTokenString = accessTokenString;
/* 76 */       this.appId = appId;
/*    */     }
/*    */     
/*    */     private Object readResolve() {
/* 80 */       return new AccessTokenAppIdPair(this.accessTokenString, this.appId);
/*    */     }
/*    */   }
/*    */   
/*    */   private Object writeReplace() {
/* 85 */     return new SerializationProxyV1(this.accessTokenString, this.applicationId, null);
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/AccessTokenAppIdPair.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */