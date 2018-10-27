/*     */ package com.facebook.appevents.internal;
/*     */ 
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.SharedPreferences.Editor;
/*     */ import android.preference.PreferenceManager;
/*     */ import com.facebook.FacebookSdk;
/*     */ import java.util.UUID;
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
/*     */ class SessionInfo
/*     */ {
/*     */   private static final String LAST_SESSION_INFO_START_KEY = "com.facebook.appevents.SessionInfo.sessionStartTime";
/*     */   private static final String LAST_SESSION_INFO_END_KEY = "com.facebook.appevents.SessionInfo.sessionEndTime";
/*     */   private static final String INTERRUPTION_COUNT_KEY = "com.facebook.appevents.SessionInfo.interruptionCount";
/*     */   private static final String SESSION_ID_KEY = "com.facebook.appevents.SessionInfo.sessionId";
/*     */   private Long sessionStartTime;
/*     */   private Long sessionLastEventTime;
/*     */   private int interruptionCount;
/*     */   private Long diskRestoreTime;
/*     */   private SourceApplicationInfo sourceApplicationInfo;
/*     */   private UUID sessionId;
/*     */   
/*     */   public SessionInfo(Long sessionStartTime, Long sessionLastEventTime)
/*     */   {
/*  48 */     this(sessionStartTime, sessionLastEventTime, UUID.randomUUID());
/*     */   }
/*     */   
/*     */   public SessionInfo(Long sessionStartTime, Long sessionLastEventTime, UUID sessionId) {
/*  52 */     this.sessionStartTime = sessionStartTime;
/*  53 */     this.sessionLastEventTime = sessionLastEventTime;
/*  54 */     this.sessionId = sessionId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SessionInfo getStoredSessionInfo()
/*     */   {
/*  63 */     SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
/*  64 */       FacebookSdk.getApplicationContext());
/*     */     
/*  66 */     long startTime = sharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0L);
/*  67 */     long endTime = sharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0L);
/*  68 */     String sessionIDStr = sharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", null);
/*     */     
/*  70 */     if ((startTime == 0L) || (endTime == 0L) || (sessionIDStr == null)) {
/*  71 */       return null;
/*     */     }
/*     */     
/*  74 */     SessionInfo sessionInfo = new SessionInfo(Long.valueOf(startTime), Long.valueOf(endTime));
/*  75 */     sessionInfo.interruptionCount = sharedPreferences.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
/*  76 */     sessionInfo.sourceApplicationInfo = SourceApplicationInfo.getStoredSourceApplicatioInfo();
/*  77 */     sessionInfo.diskRestoreTime = Long.valueOf(System.currentTimeMillis());
/*  78 */     sessionInfo.sessionId = UUID.fromString(sessionIDStr);
/*  79 */     return sessionInfo;
/*     */   }
/*     */   
/*     */   public static void clearSavedSessionFromDisk()
/*     */   {
/*  84 */     SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
/*  85 */       FacebookSdk.getApplicationContext());
/*  86 */     Editor editor = sharedPreferences.edit();
/*  87 */     editor.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
/*  88 */     editor.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
/*  89 */     editor.remove("com.facebook.appevents.SessionInfo.interruptionCount");
/*  90 */     editor.remove("com.facebook.appevents.SessionInfo.sessionId");
/*  91 */     editor.apply();
/*     */     
/*  93 */     SourceApplicationInfo.clearSavedSourceApplicationInfoFromDisk();
/*     */   }
/*     */   
/*     */   public Long getSessionStartTime() {
/*  97 */     return this.sessionStartTime;
/*     */   }
/*     */   
/*     */   public Long getSessionLastEventTime() {
/* 101 */     return this.sessionLastEventTime;
/*     */   }
/*     */   
/*     */   public void setSessionStartTime(Long sessionStartTime) {
/* 105 */     this.sessionStartTime = sessionStartTime;
/*     */   }
/*     */   
/*     */   public void setSessionLastEventTime(Long essionLastEventTime) {
/* 109 */     this.sessionLastEventTime = essionLastEventTime;
/*     */   }
/*     */   
/*     */   public int getInterruptionCount() {
/* 113 */     return this.interruptionCount;
/*     */   }
/*     */   
/*     */   public void incrementInterruptionCount() {
/* 117 */     this.interruptionCount += 1;
/*     */   }
/*     */   
/*     */   public long getDiskRestoreTime() {
/* 121 */     return this.diskRestoreTime == null ? 0L : this.diskRestoreTime.longValue();
/*     */   }
/*     */   
/*     */   public UUID getSessionId() {
/* 125 */     return this.sessionId;
/*     */   }
/*     */   
/*     */   public long getSessionLength() {
/* 129 */     if ((this.sessionStartTime == null) || (this.sessionLastEventTime == null)) {
/* 130 */       return 0L;
/*     */     }
/*     */     
/* 133 */     return this.sessionLastEventTime.longValue() - this.sessionStartTime.longValue();
/*     */   }
/*     */   
/*     */   public SourceApplicationInfo getSourceApplicationInfo() {
/* 137 */     return this.sourceApplicationInfo;
/*     */   }
/*     */   
/*     */   public void setSourceApplicationInfo(SourceApplicationInfo sourceApplicationInfo) {
/* 141 */     this.sourceApplicationInfo = sourceApplicationInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void writeSessionToDisk()
/*     */   {
/* 149 */     SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
/* 150 */       FacebookSdk.getApplicationContext());
/* 151 */     Editor editor = sharedPreferences.edit();
/* 152 */     editor.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", this.sessionStartTime.longValue());
/* 153 */     editor.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", this.sessionLastEventTime.longValue());
/* 154 */     editor.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.interruptionCount);
/* 155 */     editor.putString("com.facebook.appevents.SessionInfo.sessionId", this.sessionId.toString());
/* 156 */     editor.apply();
/*     */     
/* 158 */     if (this.sourceApplicationInfo != null) {
/* 159 */       this.sourceApplicationInfo.writeSourceApplicationInfoToDisk();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/internal/SessionInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */