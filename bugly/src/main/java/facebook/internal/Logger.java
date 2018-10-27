/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.util.Log;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.LoggingBehavior;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
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
/*     */ public class Logger
/*     */ {
/*     */   public static final String LOG_TAG_BASE = "FacebookSDK.";
/*  38 */   private static final HashMap<String, String> stringsToReplace = new HashMap();
/*     */   
/*     */   private final LoggingBehavior behavior;
/*     */   private final String tag;
/*     */   private StringBuilder contents;
/*  43 */   private int priority = 3;
/*     */   
/*     */ 
/*     */   public static synchronized void registerStringToReplace(String original, String replace)
/*     */   {
/*  48 */     stringsToReplace.put(original, replace);
/*     */   }
/*     */   
/*     */   public static synchronized void registerAccessToken(String accessToken) {
/*  52 */     if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
/*  53 */       registerStringToReplace(accessToken, "ACCESS_TOKEN_REMOVED");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void log(LoggingBehavior behavior, String tag, String string) {
/*  58 */     log(behavior, 3, tag, string);
/*     */   }
/*     */   
/*     */   public static void log(LoggingBehavior behavior, String tag, String format, Object... args)
/*     */   {
/*  63 */     if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
/*  64 */       String string = String.format(format, args);
/*  65 */       log(behavior, 3, tag, string);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void log(LoggingBehavior behavior, int priority, String tag, String format, Object... args)
/*     */   {
/*  75 */     if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
/*  76 */       String string = String.format(format, args);
/*  77 */       log(behavior, priority, tag, string);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void log(LoggingBehavior behavior, int priority, String tag, String string) {
/*  82 */     if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
/*  83 */       string = replaceStrings(string);
/*  84 */       if (!tag.startsWith("FacebookSDK.")) {
/*  85 */         tag = "FacebookSDK." + tag;
/*     */       }
/*  87 */       Log.println(priority, tag, string);
/*     */       
/*     */ 
/*     */ 
/*  91 */       if (behavior == LoggingBehavior.DEVELOPER_ERRORS) {
/*  92 */         new Exception().printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static synchronized String replaceStrings(String string) {
/*  98 */     for (Map.Entry<String, String> entry : stringsToReplace.entrySet()) {
/*  99 */       string = string.replace((CharSequence)entry.getKey(), (CharSequence)entry.getValue());
/*     */     }
/* 101 */     return string;
/*     */   }
/*     */   
/*     */   public Logger(LoggingBehavior behavior, String tag) {
/* 105 */     Validate.notNullOrEmpty(tag, "tag");
/*     */     
/* 107 */     this.behavior = behavior;
/* 108 */     this.tag = ("FacebookSDK." + tag);
/* 109 */     this.contents = new StringBuilder();
/*     */   }
/*     */   
/*     */   public int getPriority() {
/* 113 */     return this.priority;
/*     */   }
/*     */   
/*     */   public void setPriority(int value) {
/* 117 */     Validate.oneOf(
/* 118 */       Integer.valueOf(value), "value", new Object[] { Integer.valueOf(7), Integer.valueOf(3), Integer.valueOf(6), Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(5) });
/*     */     
/* 120 */     this.priority = value;
/*     */   }
/*     */   
/*     */   public String getContents() {
/* 124 */     return replaceStrings(this.contents.toString());
/*     */   }
/*     */   
/*     */   public void log()
/*     */   {
/* 129 */     logString(this.contents.toString());
/* 130 */     this.contents = new StringBuilder();
/*     */   }
/*     */   
/*     */   public void logString(String string)
/*     */   {
/* 135 */     log(this.behavior, this.priority, this.tag, string);
/*     */   }
/*     */   
/*     */   public void append(StringBuilder stringBuilder) {
/* 139 */     if (shouldLog()) {
/* 140 */       this.contents.append(stringBuilder);
/*     */     }
/*     */   }
/*     */   
/*     */   public void append(String string) {
/* 145 */     if (shouldLog()) {
/* 146 */       this.contents.append(string);
/*     */     }
/*     */   }
/*     */   
/*     */   public void append(String format, Object... args) {
/* 151 */     if (shouldLog()) {
/* 152 */       this.contents.append(String.format(format, args));
/*     */     }
/*     */   }
/*     */   
/*     */   public void appendKeyValue(String key, Object value) {
/* 157 */     append("  %s:\t%s\n", new Object[] { key, value });
/*     */   }
/*     */   
/*     */   private boolean shouldLog() {
/* 161 */     return FacebookSdk.isLoggingBehaviorEnabled(this.behavior);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/Logger.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */