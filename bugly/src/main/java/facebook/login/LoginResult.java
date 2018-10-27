/*    */ package com.facebook.login;
/*    */ 
/*    */ import com.facebook.AccessToken;
/*    */ import java.util.Set;
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
/*    */ public class LoginResult
/*    */ {
/*    */   private final AccessToken accessToken;
/*    */   private final Set<String> recentlyGrantedPermissions;
/*    */   private final Set<String> recentlyDeniedPermissions;
/*    */   
/*    */   public LoginResult(AccessToken accessToken, Set<String> recentlyGrantedPermissions, Set<String> recentlyDeniedPermissions)
/*    */   {
/* 46 */     this.accessToken = accessToken;
/* 47 */     this.recentlyGrantedPermissions = recentlyGrantedPermissions;
/* 48 */     this.recentlyDeniedPermissions = recentlyDeniedPermissions;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public AccessToken getAccessToken()
/*    */   {
/* 56 */     return this.accessToken;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Set<String> getRecentlyGrantedPermissions()
/*    */   {
/* 64 */     return this.recentlyGrantedPermissions;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Set<String> getRecentlyDeniedPermissions()
/*    */   {
/* 72 */     return this.recentlyDeniedPermissions;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/LoginResult.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */