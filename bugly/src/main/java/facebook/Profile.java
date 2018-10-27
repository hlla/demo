/*     */ package com.facebook;
/*     */ 
/*     */ import android.net.Uri;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.support.annotation.Nullable;
/*     */ import com.facebook.internal.ImageRequest;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
/*     */ import com.facebook.internal.Validate;
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
/*     */ public final class Profile
/*     */   implements Parcelable
/*     */ {
/*     */   private static final String ID_KEY = "id";
/*     */   private static final String FIRST_NAME_KEY = "first_name";
/*     */   private static final String MIDDLE_NAME_KEY = "middle_name";
/*     */   private static final String LAST_NAME_KEY = "last_name";
/*     */   private static final String NAME_KEY = "name";
/*     */   private static final String LINK_URI_KEY = "link_uri";
/*     */   private final String id;
/*     */   private final String firstName;
/*     */   private final String middleName;
/*     */   private final String lastName;
/*     */   private final String name;
/*     */   private final Uri linkUri;
/*     */   
/*     */   public static Profile getCurrentProfile()
/*     */   {
/*  59 */     return ProfileManager.getInstance().getCurrentProfile();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setCurrentProfile(Profile profile)
/*     */   {
/*  70 */     ProfileManager.getInstance().setCurrentProfile(profile);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void fetchProfileForCurrentAccessToken()
/*     */   {
/*  79 */     AccessToken accessToken = AccessToken.getCurrentAccessToken();
/*  80 */     if (accessToken == null) {
/*  81 */       setCurrentProfile(null);
/*  82 */       return;
/*     */     }
/*     */     
/*  85 */     Utility.getGraphMeRequestWithCacheAsync(accessToken.getToken(), new GraphMeRequestWithCacheCallback()
/*     */     {
/*     */       public void onSuccess(JSONObject userInfo)
/*     */       {
/*  89 */         String id = userInfo.optString("id");
/*  90 */         if (id == null) {
/*  91 */           return;
/*     */         }
/*  93 */         String link = userInfo.optString("link");
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 100 */         Profile profile = new Profile(id, userInfo.optString("first_name"), userInfo.optString("middle_name"), userInfo.optString("last_name"), userInfo.optString("name"), link != null ? Uri.parse(link) : null);
/*     */         
/* 102 */         Profile.setCurrentProfile(profile);
/*     */       }
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
/*     */       public void onFailure(FacebookException error) {}
/*     */     });
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
/*     */ 
/*     */ 
/*     */   public Profile(String id, @Nullable String firstName, @Nullable String middleName, @Nullable String lastName, @Nullable String name, @Nullable Uri linkUri)
/*     */   {
/* 133 */     Validate.notNullOrEmpty(id, "id");
/*     */     
/* 135 */     this.id = id;
/* 136 */     this.firstName = firstName;
/* 137 */     this.middleName = middleName;
/* 138 */     this.lastName = lastName;
/* 139 */     this.name = name;
/* 140 */     this.linkUri = linkUri;
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
/*     */   public Uri getProfilePictureUri(int width, int height)
/*     */   {
/* 153 */     return ImageRequest.getProfilePictureUri(this.id, width, height);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getId()
/*     */   {
/* 161 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFirstName()
/*     */   {
/* 169 */     return this.firstName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMiddleName()
/*     */   {
/* 177 */     return this.middleName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLastName()
/*     */   {
/* 185 */     return this.lastName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 193 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Uri getLinkUri()
/*     */   {
/* 201 */     return this.linkUri;
/*     */   }
/*     */   
/*     */   public boolean equals(Object other)
/*     */   {
/* 206 */     if (this == other) {
/* 207 */       return true;
/*     */     }
/*     */     
/* 210 */     if (!(other instanceof Profile)) {
/* 211 */       return false;
/*     */     }
/*     */     
/* 214 */     Profile o = (Profile)other;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 221 */     return (this.name.equals(o.name)) && (this.linkUri == null) ? false : o.linkUri == null ? true : (this.lastName.equals(o.lastName)) && (this.name == null) ? false : o.name == null ? true : (this.middleName.equals(o.middleName)) && (this.lastName == null) ? false : o.lastName == null ? true : (this.firstName.equals(o.firstName)) && (this.middleName == null) ? false : o.middleName == null ? true : (this.id.equals(o.id)) && (this.firstName == null) ? false : o.firstName == null ? true : this.linkUri.equals(o.linkUri);
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 226 */     int result = 17;
/*     */     
/* 228 */     result = result * 31 + this.id.hashCode();
/* 229 */     if (this.firstName != null) {
/* 230 */       result = result * 31 + this.firstName.hashCode();
/*     */     }
/* 232 */     if (this.middleName != null) {
/* 233 */       result = result * 31 + this.middleName.hashCode();
/*     */     }
/* 235 */     if (this.lastName != null) {
/* 236 */       result = result * 31 + this.lastName.hashCode();
/*     */     }
/* 238 */     if (this.name != null) {
/* 239 */       result = result * 31 + this.name.hashCode();
/*     */     }
/* 241 */     if (this.linkUri != null) {
/* 242 */       result = result * 31 + this.linkUri.hashCode();
/*     */     }
/*     */     
/* 245 */     return result;
/*     */   }
/*     */   
/*     */   JSONObject toJSONObject() {
/* 249 */     JSONObject jsonObject = new JSONObject();
/*     */     try {
/* 251 */       jsonObject.put("id", this.id);
/* 252 */       jsonObject.put("first_name", this.firstName);
/* 253 */       jsonObject.put("middle_name", this.middleName);
/* 254 */       jsonObject.put("last_name", this.lastName);
/* 255 */       jsonObject.put("name", this.name);
/* 256 */       if (this.linkUri != null) {
/* 257 */         jsonObject.put("link_uri", this.linkUri.toString());
/*     */       }
/*     */     } catch (JSONException object) {
/* 260 */       jsonObject = null;
/*     */     }
/* 262 */     return jsonObject;
/*     */   }
/*     */   
/*     */   Profile(JSONObject jsonObject) {
/* 266 */     this.id = jsonObject.optString("id", null);
/* 267 */     this.firstName = jsonObject.optString("first_name", null);
/* 268 */     this.middleName = jsonObject.optString("middle_name", null);
/* 269 */     this.lastName = jsonObject.optString("last_name", null);
/* 270 */     this.name = jsonObject.optString("name", null);
/* 271 */     String linkUriString = jsonObject.optString("link_uri", null);
/* 272 */     this.linkUri = (linkUriString == null ? null : Uri.parse(linkUriString));
/*     */   }
/*     */   
/*     */   private Profile(Parcel source) {
/* 276 */     this.id = source.readString();
/* 277 */     this.firstName = source.readString();
/* 278 */     this.middleName = source.readString();
/* 279 */     this.lastName = source.readString();
/* 280 */     this.name = source.readString();
/* 281 */     String linkUriString = source.readString();
/* 282 */     this.linkUri = (linkUriString == null ? null : Uri.parse(linkUriString));
/*     */   }
/*     */   
/*     */   public int describeContents()
/*     */   {
/* 287 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel dest, int flags)
/*     */   {
/* 292 */     dest.writeString(this.id);
/* 293 */     dest.writeString(this.firstName);
/* 294 */     dest.writeString(this.middleName);
/* 295 */     dest.writeString(this.lastName);
/* 296 */     dest.writeString(this.name);
/* 297 */     dest.writeString(this.linkUri == null ? null : this.linkUri.toString());
/*     */   }
/*     */   
/* 300 */   public static final Creator<Profile> CREATOR = new Creator()
/*     */   {
/*     */     public Profile createFromParcel(Parcel source)
/*     */     {
/* 304 */       return new Profile(source, null);
/*     */     }
/*     */     
/*     */     public Profile[] newArray(int size)
/*     */     {
/* 309 */       return new Profile[size];
/*     */     }
/*     */   };
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/Profile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */