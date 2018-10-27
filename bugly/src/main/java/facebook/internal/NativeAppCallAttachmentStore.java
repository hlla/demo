/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.content.ContentResolver;
/*     */ import android.content.Context;
/*     */ import android.graphics.Bitmap;
/*     */ import android.net.Uri;
/*     */ import android.util.Log;
/*     */ import com.facebook.FacebookContentProvider;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookSdk;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public final class NativeAppCallAttachmentStore
/*     */ {
/*  49 */   private static final String TAG = NativeAppCallAttachmentStore.class.getName();
/*     */   
/*     */   static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
/*     */   private static File attachmentsDirectory;
/*     */   
/*     */   public static Attachment createAttachment(UUID callId, Bitmap attachmentBitmap)
/*     */   {
/*  56 */     Validate.notNull(callId, "callId");
/*  57 */     Validate.notNull(attachmentBitmap, "attachmentBitmap");
/*     */     
/*  59 */     return new Attachment(callId, attachmentBitmap, null, null);
/*     */   }
/*     */   
/*     */   public static Attachment createAttachment(UUID callId, Uri attachmentUri) {
/*  63 */     Validate.notNull(callId, "callId");
/*  64 */     Validate.notNull(attachmentUri, "attachmentUri");
/*     */     
/*  66 */     return new Attachment(callId, null, attachmentUri, null);
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private static void processAttachmentBitmap(Bitmap bitmap, File outputFile)
/*     */     throws IOException
/*     */   {
/*     */     // Byte code:
/*     */     //   0: new 8	java/io/FileOutputStream
/*     */     //   3: dup
/*     */     //   4: aload_1
/*     */     //   5: invokespecial 9	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
/*     */     //   8: astore_2
/*     */     //   9: aload_0
/*     */     //   10: getstatic 10	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
/*     */     //   13: bipush 100
/*     */     //   15: aload_2
/*     */     //   16: invokevirtual 11	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
/*     */     //   19: pop
/*     */     //   20: aload_2
/*     */     //   21: invokestatic 12	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
/*     */     //   24: goto +10 -> 34
/*     */     //   27: astore_3
/*     */     //   28: aload_2
/*     */     //   29: invokestatic 12	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
/*     */     //   32: aload_3
/*     */     //   33: athrow
/*     */     //   34: return
/*     */     // Line number table:
/*     */     //   Java source line #70	-> byte code offset #0
/*     */     //   Java source line #72	-> byte code offset #9
/*     */     //   Java source line #74	-> byte code offset #20
/*     */     //   Java source line #75	-> byte code offset #24
/*     */     //   Java source line #74	-> byte code offset #27
/*     */     //   Java source line #76	-> byte code offset #34
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	35	0	bitmap	Bitmap
/*     */     //   0	35	1	outputFile	File
/*     */     //   8	21	2	outputStream	FileOutputStream
/*     */     //   27	6	3	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   9	20	27	finally
/*     */   }
/*     */   
/*     */   private static void processAttachmentFile(Uri imageUri, boolean isContentUri, File outputFile)
/*     */     throws IOException
/*     */   {
/*  82 */     FileOutputStream outputStream = new FileOutputStream(outputFile);
/*     */     try { InputStream inputStream;
/*     */       InputStream inputStream;
/*  85 */       if (!isContentUri) {
/*  86 */         inputStream = new FileInputStream(imageUri.getPath());
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  91 */         inputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(imageUri);
/*     */       }
/*     */       
/*  94 */       Utility.copyAndCloseInputStream(inputStream, outputStream);
/*     */     } finally {
/*  96 */       Utility.closeQuietly(outputStream);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void addAttachments(Collection<Attachment> attachments) {
/* 101 */     if ((attachments == null) || (attachments.size() == 0)) {
/* 102 */       return;
/*     */     }
/*     */     
/*     */ 
/* 106 */     if (attachmentsDirectory == null) {
/* 107 */       cleanupAllAttachments();
/*     */     }
/*     */     
/* 110 */     ensureAttachmentsDirectoryExists();
/*     */     
/* 112 */     List<File> filesToCleanup = new ArrayList();
/*     */     try
/*     */     {
/* 115 */       for (localIterator = attachments.iterator(); localIterator.hasNext();) { attachment = (Attachment)localIterator.next();
/* 116 */         if (attachment.shouldCreateFile)
/*     */         {
/*     */ 
/*     */ 
/* 120 */           File file = getAttachmentFile(
/* 121 */             attachment.callId, 
/* 122 */             attachment.attachmentName, true);
/*     */           
/* 124 */           filesToCleanup.add(file);
/*     */           
/* 126 */           if (attachment.bitmap != null) {
/* 127 */             processAttachmentBitmap(attachment.bitmap, file);
/* 128 */           } else if (attachment.originalUri != null)
/* 129 */             processAttachmentFile(
/* 130 */               attachment.originalUri, 
/* 131 */               attachment.isContentUri, file);
/*     */         }
/*     */       }
/*     */     } catch (IOException exception) { Iterator localIterator;
/*     */       Attachment attachment;
/* 136 */       Log.e(TAG, "Got unexpected exception:" + exception);
/* 137 */       for (File file : filesToCleanup) {
/*     */         try {
/* 139 */           file.delete();
/*     */         }
/*     */         catch (Exception localException) {}
/*     */       }
/*     */       
/* 144 */       throw new FacebookException(exception);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void cleanupAttachmentsForCall(UUID callId)
/*     */   {
/* 154 */     File dir = getAttachmentsDirectoryForCall(callId, false);
/* 155 */     if (dir != null) {
/* 156 */       Utility.deleteDirectory(dir);
/*     */     }
/*     */   }
/*     */   
/*     */   public static File openAttachment(UUID callId, String attachmentName) throws FileNotFoundException
/*     */   {
/* 162 */     if ((Utility.isNullOrEmpty(attachmentName)) || (callId == null))
/*     */     {
/* 164 */       throw new FileNotFoundException();
/*     */     }
/*     */     try
/*     */     {
/* 168 */       return getAttachmentFile(callId, attachmentName, false);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 172 */       throw new FileNotFoundException();
/*     */     }
/*     */   }
/*     */   
/*     */   static synchronized File getAttachmentsDirectory() {
/* 177 */     if (attachmentsDirectory == null)
/*     */     {
/* 179 */       attachmentsDirectory = new File(FacebookSdk.getApplicationContext().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
/*     */     }
/*     */     
/* 182 */     return attachmentsDirectory;
/*     */   }
/*     */   
/*     */   static File ensureAttachmentsDirectoryExists() {
/* 186 */     File dir = getAttachmentsDirectory();
/* 187 */     dir.mkdirs();
/* 188 */     return dir;
/*     */   }
/*     */   
/*     */   static File getAttachmentsDirectoryForCall(UUID callId, boolean create) {
/* 192 */     if (attachmentsDirectory == null) {
/* 193 */       return null;
/*     */     }
/*     */     
/* 196 */     File dir = new File(attachmentsDirectory, callId.toString());
/* 197 */     if ((create) && (!dir.exists())) {
/* 198 */       dir.mkdirs();
/*     */     }
/* 200 */     return dir;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static File getAttachmentFile(UUID callId, String attachmentName, boolean createDirs)
/*     */     throws IOException
/*     */   {
/* 208 */     File dir = getAttachmentsDirectoryForCall(callId, createDirs);
/* 209 */     if (dir == null) {
/* 210 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 214 */       return new File(dir, URLEncoder.encode(attachmentName, "UTF-8"));
/*     */     } catch (UnsupportedEncodingException e) {}
/* 216 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void cleanupAllAttachments()
/*     */   {
/* 223 */     File dir = getAttachmentsDirectory();
/* 224 */     Utility.deleteDirectory(dir);
/*     */   }
/*     */   
/*     */   public static final class Attachment
/*     */   {
/*     */     private final UUID callId;
/*     */     private final String attachmentUrl;
/*     */     private final String attachmentName;
/*     */     private Bitmap bitmap;
/*     */     private Uri originalUri;
/*     */     private boolean isContentUri;
/*     */     private boolean shouldCreateFile;
/*     */     
/*     */     private Attachment(UUID callId, Bitmap bitmap, Uri uri)
/*     */     {
/* 239 */       this.callId = callId;
/* 240 */       this.bitmap = bitmap;
/* 241 */       this.originalUri = uri;
/*     */       
/* 243 */       if (uri != null) {
/* 244 */         String scheme = uri.getScheme();
/* 245 */         if ("content".equalsIgnoreCase(scheme)) {
/* 246 */           this.isContentUri = true;
/*     */           
/* 248 */           this.shouldCreateFile = ((uri.getAuthority() != null) && (!uri.getAuthority().startsWith("media")));
/* 249 */         } else if ("file".equalsIgnoreCase(uri.getScheme())) {
/* 250 */           this.shouldCreateFile = true;
/* 251 */         } else if (!Utility.isWebUri(uri)) {
/* 252 */           throw new FacebookException("Unsupported scheme for media Uri : " + scheme);
/*     */         }
/* 254 */       } else if (bitmap != null) {
/* 255 */         this.shouldCreateFile = true;
/*     */       } else {
/* 257 */         throw new FacebookException("Cannot share media without a bitmap or Uri set");
/*     */       }
/*     */       
/* 260 */       this.attachmentName = (!this.shouldCreateFile ? null : UUID.randomUUID().toString());
/*     */       
/*     */ 
/* 263 */       this.attachmentUrl = (!this.shouldCreateFile ? this.originalUri.toString() : FacebookContentProvider.getAttachmentUrl(
/* 264 */         FacebookSdk.getApplicationId(), callId, this.attachmentName));
/*     */     }
/*     */     
/*     */ 
/*     */     public String getAttachmentUrl()
/*     */     {
/* 270 */       return this.attachmentUrl;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/NativeAppCallAttachmentStore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */