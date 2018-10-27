/*     */ package com.facebook;
/*     */ 
/*     */ import android.os.Bundle;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import com.facebook.internal.Utility;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.json.JSONArray;
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
/*     */ public class TestUserManager
/*     */ {
/*     */   private static final String LOG_TAG = "TestUserManager";
/*     */   private String testApplicationSecret;
/*     */   private String testApplicationId;
/*     */   private Map<String, JSONObject> appTestAccounts;
/*     */   
/*     */   private static enum Mode
/*     */   {
/*  46 */     PRIVATE, 
/*  47 */     SHARED;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private Mode() {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public TestUserManager(String testApplicationSecret, String testApplicationId)
/*     */   {
/*  61 */     if ((Utility.isNullOrEmpty(testApplicationId)) || 
/*  62 */       (Utility.isNullOrEmpty(testApplicationSecret))) {
/*  63 */       throw new FacebookException("Must provide app ID and secret");
/*     */     }
/*     */     
/*  66 */     this.testApplicationSecret = testApplicationSecret;
/*  67 */     this.testApplicationId = testApplicationId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AccessToken getAccessTokenForPrivateUser(List<String> permissions)
/*     */   {
/*  78 */     return getAccessTokenForUser(permissions, Mode.PRIVATE, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AccessToken getAccessTokenForSharedUser(List<String> permissions)
/*     */   {
/*  89 */     return getAccessTokenForSharedUser(permissions, null);
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
/*     */ 
/*     */   public AccessToken getAccessTokenForSharedUser(List<String> permissions, String uniqueUserTag)
/*     */   {
/* 103 */     return getAccessTokenForUser(permissions, Mode.SHARED, uniqueUserTag);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized String getTestApplicationId()
/*     */   {
/* 112 */     return this.testApplicationId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized String getTestApplicationSecret()
/*     */   {
/* 121 */     return this.testApplicationSecret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private AccessToken getAccessTokenForUser(List<String> permissions, Mode mode, String uniqueUserTag)
/*     */   {
/* 129 */     retrieveTestAccountsForAppIfNeeded();
/*     */     
/* 131 */     if (Utility.isNullOrEmpty(permissions)) {
/* 132 */       permissions = Arrays.asList(new String[] { "email", "publish_actions" });
/*     */     }
/*     */     
/* 135 */     JSONObject testAccount = null;
/* 136 */     if (mode == Mode.PRIVATE) {
/* 137 */       testAccount = createTestAccount(permissions, mode, uniqueUserTag);
/*     */     } else {
/* 139 */       testAccount = findOrCreateSharedTestAccount(permissions, mode, uniqueUserTag);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 145 */     return new AccessToken(testAccount.optString("access_token"), this.testApplicationId, testAccount.optString("id"), permissions, null, AccessTokenSource.TEST_USER, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private synchronized void retrieveTestAccountsForAppIfNeeded()
/*     */   {
/* 154 */     if (this.appTestAccounts != null) {
/* 155 */       return;
/*     */     }
/*     */     
/* 158 */     this.appTestAccounts = new HashMap();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */     GraphRequest.setDefaultBatchApplicationId(this.testApplicationId);
/*     */     
/* 166 */     Bundle parameters = new Bundle();
/* 167 */     parameters.putString("access_token", getAppAccessToken());
/*     */     
/* 169 */     GraphRequest requestTestUsers = new GraphRequest(null, "app/accounts/test-users", parameters, null);
/*     */     
/* 171 */     requestTestUsers.setBatchEntryName("testUsers");
/* 172 */     requestTestUsers.setBatchEntryOmitResultOnSuccess(false);
/*     */     
/* 174 */     Bundle testUserNamesParam = new Bundle();
/* 175 */     testUserNamesParam.putString("access_token", getAppAccessToken());
/* 176 */     testUserNamesParam.putString("ids", "{result=testUsers:$.data.*.id}");
/* 177 */     testUserNamesParam.putString("fields", "name");
/*     */     
/* 179 */     GraphRequest requestTestUserNames = new GraphRequest(null, "", testUserNamesParam, null);
/* 180 */     requestTestUserNames.setBatchEntryDependsOn("testUsers");
/*     */     
/* 182 */     List<GraphResponse> responses = GraphRequest.executeBatchAndWait(new GraphRequest[] { requestTestUsers, requestTestUserNames });
/*     */     
/* 184 */     if ((responses == null) || (responses.size() != 2)) {
/* 185 */       throw new FacebookException("Unexpected number of results from TestUsers batch query");
/*     */     }
/*     */     
/* 188 */     JSONObject testAccountsResponse = ((GraphResponse)responses.get(0)).getJSONObject();
/* 189 */     JSONArray testAccounts = testAccountsResponse.optJSONArray("data");
/*     */     
/*     */ 
/* 192 */     JSONObject userAccountsMap = ((GraphResponse)responses.get(1)).getJSONObject();
/*     */     
/* 194 */     populateTestAccounts(testAccounts, userAccountsMap);
/*     */   }
/*     */   
/*     */ 
/*     */   private synchronized void populateTestAccounts(JSONArray testAccounts, JSONObject userAccountsMap)
/*     */   {
/* 200 */     for (int i = 0; i < testAccounts.length(); i++) {
/* 201 */       JSONObject testAccount = testAccounts.optJSONObject(i);
/* 202 */       JSONObject testUser = userAccountsMap.optJSONObject(testAccount.optString("id"));
/*     */       try {
/* 204 */         testAccount.put("name", testUser.optString("name"));
/*     */       } catch (JSONException e) {
/* 206 */         Log.e("TestUserManager", "Could not set name", e);
/*     */       }
/* 208 */       storeTestAccount(testAccount);
/*     */     }
/*     */   }
/*     */   
/*     */   private synchronized void storeTestAccount(JSONObject testAccount) {
/* 213 */     this.appTestAccounts.put(testAccount.optString("id"), testAccount);
/*     */   }
/*     */   
/*     */   private synchronized JSONObject findTestAccountMatchingIdentifier(String identifier) {
/* 217 */     for (JSONObject testAccount : this.appTestAccounts.values()) {
/* 218 */       if (testAccount.optString("name").contains(identifier)) {
/* 219 */         return testAccount;
/*     */       }
/*     */     }
/* 222 */     return null;
/*     */   }
/*     */   
/*     */   final String getAppAccessToken() {
/* 226 */     return this.testApplicationId + "|" + this.testApplicationSecret;
/*     */   }
/*     */   
/*     */ 
/*     */   private JSONObject findOrCreateSharedTestAccount(List<String> permissions, Mode mode, String uniqueUserTag)
/*     */   {
/* 232 */     JSONObject testAccount = findTestAccountMatchingIdentifier(
/* 233 */       getSharedTestAccountIdentifier(permissions, uniqueUserTag));
/* 234 */     if (testAccount != null) {
/* 235 */       return testAccount;
/*     */     }
/* 237 */     return createTestAccount(permissions, mode, uniqueUserTag);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String getSharedTestAccountIdentifier(List<String> permissions, String uniqueUserTag)
/*     */   {
/* 245 */     long permissionsHash = getPermissionsString(permissions).hashCode() & 0xFFFFFFFF;
/*     */     
/* 247 */     long userTagHash = uniqueUserTag != null ? uniqueUserTag.hashCode() & 0xFFFFFFFF : 0L;
/*     */     
/*     */ 
/* 250 */     long combinedHash = permissionsHash ^ userTagHash;
/* 251 */     return validNameStringFromInteger(combinedHash);
/*     */   }
/*     */   
/*     */   private String validNameStringFromInteger(long i) {
/* 255 */     String s = Long.toString(i);
/* 256 */     StringBuilder result = new StringBuilder("Perm");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 261 */     char lastChar = '\000';
/* 262 */     for (char c : s.toCharArray()) {
/* 263 */       if (c == lastChar) {
/* 264 */         c = (char)(c + '\n');
/*     */       }
/* 266 */       result.append((char)(c + 'a' - 48));
/* 267 */       lastChar = c;
/*     */     }
/*     */     
/* 270 */     return result.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private JSONObject createTestAccount(List<String> permissions, Mode mode, String uniqueUserTag)
/*     */   {
/* 277 */     Bundle parameters = new Bundle();
/* 278 */     parameters.putString("installed", "true");
/* 279 */     parameters.putString("permissions", getPermissionsString(permissions));
/* 280 */     parameters.putString("access_token", getAppAccessToken());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 285 */     if (mode == Mode.SHARED) {
/* 286 */       parameters.putString("name", String.format("Shared %s Testuser", new Object[] {
/* 287 */         getSharedTestAccountIdentifier(permissions, uniqueUserTag) }));
/*     */     }
/*     */     
/* 290 */     String graphPath = String.format("%s/accounts/test-users", new Object[] { this.testApplicationId });
/* 291 */     GraphRequest createUserRequest = new GraphRequest(null, graphPath, parameters, HttpMethod.POST);
/*     */     
/* 293 */     GraphResponse response = createUserRequest.executeAndWait();
/*     */     
/* 295 */     FacebookRequestError error = response.getError();
/* 296 */     JSONObject testAccount = response.getJSONObject();
/* 297 */     if (error != null) {
/* 298 */       return null;
/*     */     }
/* 300 */     assert (testAccount != null);
/*     */     
/*     */ 
/*     */ 
/* 304 */     if (mode == Mode.SHARED)
/*     */     {
/*     */       try
/*     */       {
/* 308 */         testAccount.put("name", parameters.getString("name"));
/*     */       } catch (JSONException e) {
/* 310 */         Log.e("TestUserManager", "Could not set name", e);
/*     */       }
/* 312 */       storeTestAccount(testAccount);
/*     */     }
/*     */     
/* 315 */     return testAccount;
/*     */   }
/*     */   
/*     */   private String getPermissionsString(List<String> permissions)
/*     */   {
/* 320 */     return TextUtils.join(",", permissions);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/TestUserManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */