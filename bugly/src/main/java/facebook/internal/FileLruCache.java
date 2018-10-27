/*     */ package com.facebook.internal;
/*     */ 
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.LoggingBehavior;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FilenameFilter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.security.InvalidParameterException;
/*     */ import java.util.Date;
/*     */ import java.util.PriorityQueue;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ import org.json.JSONTokener;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FileLruCache
/*     */ {
/*  68 */   static final String TAG = FileLruCache.class.getSimpleName();
/*     */   
/*     */   private static final String HEADER_CACHEKEY_KEY = "key";
/*     */   private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
/*  72 */   private static final AtomicLong bufferIndex = new AtomicLong();
/*     */   
/*     */   private final String tag;
/*     */   private final Limits limits;
/*     */   private final File directory;
/*     */   private boolean isTrimPending;
/*     */   private boolean isTrimInProgress;
/*     */   private final Object lock;
/*  80 */   private AtomicLong lastClearCacheTime = new AtomicLong(0L);
/*     */   
/*     */   public FileLruCache(String tag, Limits limits)
/*     */   {
/*  84 */     this.tag = tag;
/*  85 */     this.limits = limits;
/*  86 */     this.directory = new File(FacebookSdk.getCacheDir(), tag);
/*  87 */     this.lock = new Object();
/*     */     
/*     */ 
/*  90 */     if ((this.directory.mkdirs()) || (this.directory.isDirectory()))
/*     */     {
/*  92 */       BufferFile.deleteAll(this.directory);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long sizeInBytesForTest()
/*     */   {
/* 103 */     synchronized (this.lock) {
/* 104 */       while ((this.isTrimPending) || (this.isTrimInProgress)) {
/*     */         try {
/* 106 */           this.lock.wait();
/*     */         }
/*     */         catch (InterruptedException localInterruptedException) {}
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 113 */     File[] files = this.directory.listFiles();
/* 114 */     long total = 0L;
/* 115 */     if (files != null) {
/* 116 */       for (File file : files) {
/* 117 */         total += file.length();
/*     */       }
/*     */     }
/* 120 */     return total;
/*     */   }
/*     */   
/*     */   public InputStream get(String key) throws IOException {
/* 124 */     return get(key, null);
/*     */   }
/*     */   
/*     */   public InputStream get(String key, String contentTag) throws IOException {
/* 128 */     File file = new File(this.directory, Utility.md5hash(key));
/*     */     
/*     */     try
/*     */     {
/* 132 */       input = new FileInputStream(file);
/*     */     } catch (IOException e) { FileInputStream input;
/* 134 */       return null;
/*     */     }
/*     */     FileInputStream input;
/* 137 */     BufferedInputStream buffered = new BufferedInputStream(input, 8192);
/*     */     
/* 139 */     boolean success = false;
/*     */     try
/*     */     {
/* 142 */       JSONObject header = StreamHeader.readHeader(buffered);
/* 143 */       if (header == null) {
/* 144 */         return null;
/*     */       }
/*     */       
/* 147 */       String foundKey = header.optString("key");
/* 148 */       if ((foundKey == null) || (!foundKey.equals(key))) {
/* 149 */         return null;
/*     */       }
/*     */       
/* 152 */       String headerContentTag = header.optString("tag", null);
/*     */       
/* 154 */       if (((contentTag == null) && (headerContentTag != null)) || ((contentTag != null) && 
/* 155 */         (!contentTag.equals(headerContentTag)))) {
/* 156 */         return null;
/*     */       }
/*     */       
/* 159 */       long accessTime = new Date().getTime();
/* 160 */       Logger.log(LoggingBehavior.CACHE, TAG, "Setting lastModified to " + 
/*     */       
/*     */ 
/* 163 */         Long.valueOf(accessTime) + " for " + file
/* 164 */         .getName());
/* 165 */       file.setLastModified(accessTime);
/*     */       
/* 167 */       success = true;
/* 168 */       return buffered;
/*     */     } finally {
/* 170 */       if (!success) {
/* 171 */         buffered.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OutputStream openPutStream(String key) throws IOException {
/* 177 */     return openPutStream(key, null);
/*     */   }
/*     */   
/*     */   public OutputStream openPutStream(final String key, String contentTag) throws IOException {
/* 181 */     File buffer = BufferFile.newFile(this.directory);
/* 182 */     buffer.delete();
/* 183 */     if (!buffer.createNewFile()) {
/* 184 */       throw new IOException("Could not create file at " + buffer.getAbsolutePath());
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 189 */       file = new FileOutputStream(buffer);
/*     */     } catch (FileNotFoundException e) { FileOutputStream file;
/* 191 */       Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating buffer output stream: " + e);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 196 */       throw new IOException(e.getMessage());
/*     */     }
/*     */     FileOutputStream file;
/* 199 */     final long bufferFileCreateTime = System.currentTimeMillis();
/* 200 */     StreamCloseCallback renameToTargetCallback = new StreamCloseCallback()
/*     */     {
/*     */ 
/*     */       public void onClose()
/*     */       {
/* 205 */         if (bufferFileCreateTime < FileLruCache.this.lastClearCacheTime.get()) {
/* 206 */           key.delete();
/*     */         } else {
/* 208 */           FileLruCache.this.renameToTargetAndTrim(this.val$key, key);
/*     */         }
/*     */         
/*     */       }
/* 212 */     };
/* 213 */     CloseCallbackOutputStream cleanup = new CloseCallbackOutputStream(file, renameToTargetCallback);
/*     */     
/* 215 */     BufferedOutputStream buffered = new BufferedOutputStream(cleanup, 8192);
/*     */     
/* 217 */     boolean success = false;
/*     */     
/*     */     try
/*     */     {
/* 221 */       JSONObject header = new JSONObject();
/* 222 */       header.put("key", key);
/* 223 */       if (!Utility.isNullOrEmpty(contentTag)) {
/* 224 */         header.put("tag", contentTag);
/*     */       }
/*     */       
/* 227 */       StreamHeader.writeHeader(buffered, header);
/*     */       
/* 229 */       success = true;
/* 230 */       return buffered;
/*     */     }
/*     */     catch (JSONException e) {
/* 233 */       Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating JSON header for cache file: " + e);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 238 */       throw new IOException(e.getMessage());
/*     */     } finally {
/* 240 */       if (!success) {
/* 241 */         buffered.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void clearCache()
/*     */   {
/* 248 */     final File[] filesToDelete = this.directory.listFiles(BufferFile.excludeBufferFiles());
/* 249 */     this.lastClearCacheTime.set(System.currentTimeMillis());
/* 250 */     if (filesToDelete != null) {
/* 251 */       FacebookSdk.getExecutor().execute(new Runnable()
/*     */       {
/*     */         public void run() {
/* 254 */           for (File file : filesToDelete) {
/* 255 */             file.delete();
/*     */           }
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLocation()
/*     */   {
/* 267 */     return this.directory.getPath();
/*     */   }
/*     */   
/*     */   private void renameToTargetAndTrim(String key, File buffer) {
/* 271 */     File target = new File(this.directory, Utility.md5hash(key));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 279 */     if (!buffer.renameTo(target)) {
/* 280 */       buffer.delete();
/*     */     }
/*     */     
/* 283 */     postTrim();
/*     */   }
/*     */   
/*     */ 
/*     */   public InputStream interceptAndPut(String key, InputStream input)
/*     */     throws IOException
/*     */   {
/* 290 */     OutputStream output = openPutStream(key);
/* 291 */     return new CopyingInputStream(input, output);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 295 */     return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
/*     */   }
/*     */   
/*     */   private void postTrim() {
/* 299 */     synchronized (this.lock) {
/* 300 */       if (!this.isTrimPending) {
/* 301 */         this.isTrimPending = true;
/* 302 */         FacebookSdk.getExecutor().execute(new Runnable()
/*     */         {
/*     */           public void run() {
/* 305 */             FileLruCache.this.trim();
/*     */           }
/*     */         });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void trim() {
/* 313 */     synchronized (this.lock) {
/* 314 */       this.isTrimPending = false;
/* 315 */       this.isTrimInProgress = true;
/*     */     }
/*     */     try {
/* 318 */       Logger.log(LoggingBehavior.CACHE, TAG, "trim started");
/* 319 */       PriorityQueue<ModifiedFile> heap = new PriorityQueue();
/* 320 */       long size = 0L;
/* 321 */       long count = 0L;
/* 322 */       File[] filesToTrim = this.directory.listFiles(BufferFile.excludeBufferFiles());
/* 323 */       if (filesToTrim != null) {
/* 324 */         for (File file : filesToTrim) {
/* 325 */           ModifiedFile modified = new ModifiedFile(file);
/* 326 */           heap.add(modified);
/* 327 */           Logger.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + 
/*     */           
/*     */ 
/* 330 */             Long.valueOf(modified.getModified()) + " name=" + modified
/* 331 */             .getFile().getName());
/*     */           
/* 333 */           size += file.length();
/* 334 */           count += 1L;
/*     */         }
/*     */       }
/*     */       
/* 338 */       while ((size > this.limits.getByteCount()) || (count > this.limits.getFileCount())) {
/* 339 */         File file = ((ModifiedFile)heap.remove()).getFile();
/* 340 */         Logger.log(LoggingBehavior.CACHE, TAG, "  trim removing " + file.getName());
/* 341 */         size -= file.length();
/* 342 */         count -= 1L;
/* 343 */         file.delete();
/*     */       }
/*     */     } finally {
/* 346 */       synchronized (this.lock) {
/* 347 */         this.isTrimInProgress = false;
/* 348 */         this.lock.notifyAll();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BufferFile {
/*     */     private static final String FILE_NAME_PREFIX = "buffer";
/* 355 */     private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter()
/*     */     {
/*     */       public boolean accept(File dir, String filename) {
/* 358 */         return !filename.startsWith("buffer");
/*     */       }
/*     */     };
/* 361 */     private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter()
/*     */     {
/*     */       public boolean accept(File dir, String filename) {
/* 364 */         return filename.startsWith("buffer");
/*     */       }
/*     */     };
/*     */     
/*     */     static void deleteAll(File root) {
/* 369 */       File[] filesToDelete = root.listFiles(excludeNonBufferFiles());
/* 370 */       if (filesToDelete != null) {
/* 371 */         for (File file : filesToDelete) {
/* 372 */           file.delete();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     static FilenameFilter excludeBufferFiles() {
/* 378 */       return filterExcludeBufferFiles;
/*     */     }
/*     */     
/*     */     static FilenameFilter excludeNonBufferFiles() {
/* 382 */       return filterExcludeNonBufferFiles;
/*     */     }
/*     */     
/*     */     static File newFile(File root) {
/* 386 */       String name = "buffer" + Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString();
/* 387 */       return new File(root, name);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final class StreamHeader
/*     */   {
/*     */     private static final int HEADER_VERSION = 0;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     static void writeHeader(OutputStream stream, JSONObject header)
/*     */       throws IOException
/*     */     {
/* 405 */       String headerString = header.toString();
/* 406 */       byte[] headerBytes = headerString.getBytes();
/*     */       
/*     */ 
/* 409 */       stream.write(0);
/* 410 */       stream.write(headerBytes.length >> 16 & 0xFF);
/* 411 */       stream.write(headerBytes.length >> 8 & 0xFF);
/* 412 */       stream.write(headerBytes.length >> 0 & 0xFF);
/*     */       
/* 414 */       stream.write(headerBytes);
/*     */     }
/*     */     
/*     */     static JSONObject readHeader(InputStream stream) throws IOException {
/* 418 */       int version = stream.read();
/* 419 */       if (version != 0) {
/* 420 */         return null;
/*     */       }
/*     */       
/* 423 */       int headerSize = 0;
/* 424 */       for (int i = 0; i < 3; i++) {
/* 425 */         int b = stream.read();
/* 426 */         if (b == -1) {
/* 427 */           Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
/*     */           
/* 429 */           return null;
/*     */         }
/* 431 */         headerSize <<= 8;
/* 432 */         headerSize += (b & 0xFF);
/*     */       }
/*     */       
/* 435 */       byte[] headerBytes = new byte[headerSize];
/* 436 */       int count = 0;
/* 437 */       while (count < headerBytes.length) {
/* 438 */         int readCount = stream.read(headerBytes, count, headerBytes.length - count);
/* 439 */         if (readCount < 1) {
/* 440 */           Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read stopped at " + 
/*     */           
/*     */ 
/* 443 */             Integer.valueOf(count) + " when expected " + headerBytes.length);
/*     */           
/* 445 */           return null;
/*     */         }
/* 447 */         count += readCount;
/*     */       }
/*     */       
/* 450 */       String headerString = new String(headerBytes);
/*     */       
/* 452 */       JSONTokener tokener = new JSONTokener(headerString);
/*     */       try {
/* 454 */         Object parsed = tokener.nextValue();
/* 455 */         if (!(parsed instanceof JSONObject)) {
/* 456 */           Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: expected JSONObject, got " + parsed
/*     */           
/*     */ 
/*     */ 
/* 460 */             .getClass().getCanonicalName());
/* 461 */           return null;
/*     */         }
/* 463 */         header = (JSONObject)parsed;
/*     */       } catch (JSONException e) { JSONObject header;
/* 465 */         throw new IOException(e.getMessage());
/*     */       }
/*     */       JSONObject header;
/* 468 */       return header;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class CloseCallbackOutputStream extends OutputStream {
/*     */     final OutputStream innerStream;
/*     */     final StreamCloseCallback callback;
/*     */     
/*     */     CloseCallbackOutputStream(OutputStream innerStream, StreamCloseCallback callback) {
/* 477 */       this.innerStream = innerStream;
/* 478 */       this.callback = callback;
/*     */     }
/*     */     
/*     */     /* Error */
/*     */     public void close()
/*     */       throws IOException
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: getfield 2	com/facebook/internal/FileLruCache$CloseCallbackOutputStream:innerStream	Ljava/io/OutputStream;
/*     */       //   4: invokevirtual 4	java/io/OutputStream:close	()V
/*     */       //   7: aload_0
/*     */       //   8: getfield 3	com/facebook/internal/FileLruCache$CloseCallbackOutputStream:callback	Lcom/facebook/internal/FileLruCache$StreamCloseCallback;
/*     */       //   11: invokeinterface 5 1 0
/*     */       //   16: goto +15 -> 31
/*     */       //   19: astore_1
/*     */       //   20: aload_0
/*     */       //   21: getfield 3	com/facebook/internal/FileLruCache$CloseCallbackOutputStream:callback	Lcom/facebook/internal/FileLruCache$StreamCloseCallback;
/*     */       //   24: invokeinterface 5 1 0
/*     */       //   29: aload_1
/*     */       //   30: athrow
/*     */       //   31: return
/*     */       // Line number table:
/*     */       //   Java source line #484	-> byte code offset #0
/*     */       //   Java source line #486	-> byte code offset #7
/*     */       //   Java source line #487	-> byte code offset #16
/*     */       //   Java source line #486	-> byte code offset #19
/*     */       //   Java source line #488	-> byte code offset #31
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	signature
/*     */       //   0	32	0	this	CloseCallbackOutputStream
/*     */       //   19	11	1	localObject	Object
/*     */       // Exception table:
/*     */       //   from	to	target	type
/*     */       //   0	7	19	finally
/*     */     }
/*     */     
/*     */     public void flush()
/*     */       throws IOException
/*     */     {
/* 492 */       this.innerStream.flush();
/*     */     }
/*     */     
/*     */     public void write(byte[] buffer, int offset, int count) throws IOException
/*     */     {
/* 497 */       this.innerStream.write(buffer, offset, count);
/*     */     }
/*     */     
/*     */     public void write(byte[] buffer) throws IOException
/*     */     {
/* 502 */       this.innerStream.write(buffer);
/*     */     }
/*     */     
/*     */     public void write(int oneByte) throws IOException
/*     */     {
/* 507 */       this.innerStream.write(oneByte);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class CopyingInputStream extends InputStream {
/*     */     final InputStream input;
/*     */     final OutputStream output;
/*     */     
/*     */     CopyingInputStream(InputStream input, OutputStream output) {
/* 516 */       this.input = input;
/* 517 */       this.output = output;
/*     */     }
/*     */     
/*     */     public int available() throws IOException
/*     */     {
/* 522 */       return this.input.available();
/*     */     }
/*     */     
/*     */     /* Error */
/*     */     public void close()
/*     */       throws IOException
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: getfield 2	com/facebook/internal/FileLruCache$CopyingInputStream:input	Ljava/io/InputStream;
/*     */       //   4: invokevirtual 5	java/io/InputStream:close	()V
/*     */       //   7: aload_0
/*     */       //   8: getfield 3	com/facebook/internal/FileLruCache$CopyingInputStream:output	Ljava/io/OutputStream;
/*     */       //   11: invokevirtual 6	java/io/OutputStream:close	()V
/*     */       //   14: goto +13 -> 27
/*     */       //   17: astore_1
/*     */       //   18: aload_0
/*     */       //   19: getfield 3	com/facebook/internal/FileLruCache$CopyingInputStream:output	Ljava/io/OutputStream;
/*     */       //   22: invokevirtual 6	java/io/OutputStream:close	()V
/*     */       //   25: aload_1
/*     */       //   26: athrow
/*     */       //   27: return
/*     */       // Line number table:
/*     */       //   Java source line #535	-> byte code offset #0
/*     */       //   Java source line #537	-> byte code offset #7
/*     */       //   Java source line #538	-> byte code offset #14
/*     */       //   Java source line #537	-> byte code offset #17
/*     */       //   Java source line #539	-> byte code offset #27
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	signature
/*     */       //   0	28	0	this	CopyingInputStream
/*     */       //   17	9	1	localObject	Object
/*     */       // Exception table:
/*     */       //   from	to	target	type
/*     */       //   0	7	17	finally
/*     */     }
/*     */     
/*     */     public void mark(int readlimit)
/*     */     {
/* 543 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean markSupported()
/*     */     {
/* 548 */       return false;
/*     */     }
/*     */     
/*     */     public int read(byte[] buffer) throws IOException
/*     */     {
/* 553 */       int count = this.input.read(buffer);
/* 554 */       if (count > 0) {
/* 555 */         this.output.write(buffer, 0, count);
/*     */       }
/* 557 */       return count;
/*     */     }
/*     */     
/*     */     public int read() throws IOException
/*     */     {
/* 562 */       int b = this.input.read();
/* 563 */       if (b >= 0) {
/* 564 */         this.output.write(b);
/*     */       }
/* 566 */       return b;
/*     */     }
/*     */     
/*     */     public int read(byte[] buffer, int offset, int length) throws IOException
/*     */     {
/* 571 */       int count = this.input.read(buffer, offset, length);
/* 572 */       if (count > 0) {
/* 573 */         this.output.write(buffer, offset, count);
/*     */       }
/* 575 */       return count;
/*     */     }
/*     */     
/*     */     public synchronized void reset()
/*     */     {
/* 580 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public long skip(long byteCount) throws IOException
/*     */     {
/* 585 */       byte[] buffer = new byte['Ѐ'];
/* 586 */       long total = 0L;
/* 587 */       while (total < byteCount) {
/* 588 */         int count = read(buffer, 0, (int)Math.min(byteCount - total, buffer.length));
/* 589 */         if (count < 0) {
/* 590 */           return total;
/*     */         }
/* 592 */         total += count;
/*     */       }
/* 594 */       return total;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static final class Limits
/*     */   {
/*     */     private int byteCount;
/*     */     
/*     */ 
/*     */     private int fileCount;
/*     */     
/*     */ 
/*     */     public Limits()
/*     */     {
/* 610 */       this.fileCount = 1024;
/* 611 */       this.byteCount = 1048576;
/*     */     }
/*     */     
/*     */     int getByteCount() {
/* 615 */       return this.byteCount;
/*     */     }
/*     */     
/*     */     int getFileCount() {
/* 619 */       return this.fileCount;
/*     */     }
/*     */     
/*     */     void setByteCount(int n) {
/* 623 */       if (n < 0) {
/* 624 */         throw new InvalidParameterException("Cache byte-count limit must be >= 0");
/*     */       }
/* 626 */       this.byteCount = n;
/*     */     }
/*     */     
/*     */     void setFileCount(int n) {
/* 630 */       if (n < 0) {
/* 631 */         throw new InvalidParameterException("Cache file count limit must be >= 0");
/*     */       }
/* 633 */       this.fileCount = n;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class ModifiedFile implements Comparable<ModifiedFile>
/*     */   {
/*     */     private static final int HASH_SEED = 29;
/*     */     private static final int HASH_MULTIPLIER = 37;
/*     */     private final File file;
/*     */     private final long modified;
/*     */     
/*     */     ModifiedFile(File file)
/*     */     {
/* 646 */       this.file = file;
/* 647 */       this.modified = file.lastModified();
/*     */     }
/*     */     
/*     */     File getFile() {
/* 651 */       return this.file;
/*     */     }
/*     */     
/*     */     long getModified() {
/* 655 */       return this.modified;
/*     */     }
/*     */     
/*     */     public int compareTo(ModifiedFile another)
/*     */     {
/* 660 */       if (getModified() < another.getModified())
/* 661 */         return -1;
/* 662 */       if (getModified() > another.getModified()) {
/* 663 */         return 1;
/*     */       }
/* 665 */       return getFile().compareTo(another.getFile());
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object another)
/*     */     {
/* 671 */       if ((another instanceof ModifiedFile)) {}
/*     */       
/* 673 */       return compareTo((ModifiedFile)another) == 0;
/*     */     }
/*     */     
/*     */     public int hashCode()
/*     */     {
/* 678 */       int result = 29;
/*     */       
/* 680 */       result = result * 37 + this.file.hashCode();
/* 681 */       result = result * 37 + (int)(this.modified % 2147483647L);
/*     */       
/* 683 */       return result;
/*     */     }
/*     */   }
/*     */   
/*     */   private static abstract interface StreamCloseCallback
/*     */   {
/*     */     public abstract void onClose();
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/FileLruCache.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */