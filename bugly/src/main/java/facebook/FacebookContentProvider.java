/*     */ package com.facebook;
/*     */ 
/*     */ import android.content.ContentProvider;
/*     */ import android.content.ContentValues;
/*     */ import android.database.Cursor;
/*     */ import android.net.Uri;
/*     */ import android.os.ParcelFileDescriptor;
/*     */ import android.util.Log;
/*     */ import android.util.Pair;
/*     */ import com.facebook.internal.NativeAppCallAttachmentStore;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
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
/*     */ public class FacebookContentProvider
/*     */   extends ContentProvider
/*     */ {
/*  56 */   private static final String TAG = FacebookContentProvider.class.getName();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final String ATTACHMENT_URL_BASE = "content://com.facebook.app.FacebookContentProvider";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getAttachmentUrl(String applicationId, UUID callId, String attachmentName)
/*     */   {
/*  72 */     return String.format("%s%s/%s/%s", new Object[] { "content://com.facebook.app.FacebookContentProvider", applicationId, callId
/*     */     
/*     */ 
/*     */ 
/*  76 */       .toString(), attachmentName });
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onCreate()
/*     */   {
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   public Cursor query(Uri uri, String[] strings, String s, String[] strings2, String s2)
/*     */   {
/*  87 */     return null;
/*     */   }
/*     */   
/*     */   public String getType(Uri uri)
/*     */   {
/*  92 */     return null;
/*     */   }
/*     */   
/*     */   public Uri insert(Uri uri, ContentValues contentValues)
/*     */   {
/*  97 */     return null;
/*     */   }
/*     */   
/*     */   public int delete(Uri uri, String s, String[] strings)
/*     */   {
/* 102 */     return 0;
/*     */   }
/*     */   
/*     */   public int update(Uri uri, ContentValues contentValues, String s, String[] strings)
/*     */   {
/* 107 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public ParcelFileDescriptor openFile(Uri uri, String mode)
/*     */     throws FileNotFoundException
/*     */   {
/* 114 */     Pair<UUID, String> callIdAndAttachmentName = parseCallIdAndAttachmentName(uri);
/* 115 */     if (callIdAndAttachmentName == null) {
/* 116 */       throw new FileNotFoundException();
/*     */     }
/*     */     try
/*     */     {
/* 120 */       File file = NativeAppCallAttachmentStore.openAttachment((UUID)callIdAndAttachmentName.first, (String)callIdAndAttachmentName.second);
/*     */       
/*     */ 
/*     */ 
/* 124 */       return ParcelFileDescriptor.open(file, 268435456);
/*     */     } catch (FileNotFoundException exception) {
/* 126 */       Log.e(TAG, "Got unexpected exception:" + exception);
/* 127 */       throw exception;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   Pair<UUID, String> parseCallIdAndAttachmentName(Uri uri)
/*     */   {
/*     */     try
/*     */     {
/* 136 */       String callIdAndAttachmentName = uri.getPath().substring(1);
/* 137 */       String[] parts = callIdAndAttachmentName.split("/");
/*     */       
/* 139 */       String callIdString = parts[0];
/* 140 */       String attachmentName = parts[1];
/* 141 */       UUID callId = UUID.fromString(callIdString);
/*     */       
/* 143 */       return new Pair(callId, attachmentName);
/*     */     } catch (Exception exception) {}
/* 145 */     return null;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookContentProvider.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */