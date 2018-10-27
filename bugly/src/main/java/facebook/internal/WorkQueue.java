/*     */ package com.facebook.internal;
/*     */ 
/*     */ import com.facebook.FacebookSdk;
/*     */ import java.util.concurrent.Executor;
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
/*     */ public class WorkQueue
/*     */ {
/*     */   public static final int DEFAULT_MAX_CONCURRENT = 8;
/*  35 */   private final Object workLock = new Object();
/*     */   
/*     */   private WorkNode pendingJobs;
/*     */   
/*     */   private final int maxConcurrent;
/*     */   private final Executor executor;
/*  41 */   private WorkNode runningJobs = null;
/*  42 */   private int runningCount = 0;
/*     */   
/*     */   public WorkQueue() {
/*  45 */     this(8);
/*     */   }
/*     */   
/*     */   public WorkQueue(int maxConcurrent) {
/*  49 */     this(maxConcurrent, FacebookSdk.getExecutor());
/*     */   }
/*     */   
/*     */   public WorkQueue(int maxConcurrent, Executor executor) {
/*  53 */     this.maxConcurrent = maxConcurrent;
/*  54 */     this.executor = executor;
/*     */   }
/*     */   
/*     */   public WorkItem addActiveWorkItem(Runnable callback) {
/*  58 */     return addActiveWorkItem(callback, true);
/*     */   }
/*     */   
/*     */   public WorkItem addActiveWorkItem(Runnable callback, boolean addToFront) {
/*  62 */     WorkNode node = new WorkNode(callback);
/*  63 */     synchronized (this.workLock) {
/*  64 */       this.pendingJobs = node.addToList(this.pendingJobs, addToFront);
/*     */     }
/*     */     
/*  67 */     startItem();
/*  68 */     return node;
/*     */   }
/*     */   
/*     */   public void validate() {
/*  72 */     synchronized (this.workLock)
/*     */     {
/*  74 */       int count = 0;
/*     */       
/*  76 */       if (this.runningJobs != null) {
/*  77 */         WorkNode walk = this.runningJobs;
/*     */         do {
/*  79 */           walk.verify(true);
/*  80 */           count++;
/*  81 */           walk = walk.getNext();
/*  82 */         } while (walk != this.runningJobs);
/*     */       }
/*     */       
/*  85 */       if ((!$assertionsDisabled) && (this.runningCount != count)) throw new AssertionError();
/*     */     }
/*     */   }
/*     */   
/*     */   private void startItem() {
/*  90 */     finishItemAndStartNew(null);
/*     */   }
/*     */   
/*     */   private void finishItemAndStartNew(WorkNode finished) {
/*  94 */     WorkNode ready = null;
/*     */     
/*  96 */     synchronized (this.workLock) {
/*  97 */       if (finished != null) {
/*  98 */         this.runningJobs = finished.removeFromList(this.runningJobs);
/*  99 */         this.runningCount -= 1;
/*     */       }
/*     */       
/* 102 */       if (this.runningCount < this.maxConcurrent) {
/* 103 */         ready = this.pendingJobs;
/* 104 */         if (ready != null)
/*     */         {
/*     */ 
/*     */ 
/* 108 */           this.pendingJobs = ready.removeFromList(this.pendingJobs);
/* 109 */           this.runningJobs = ready.addToList(this.runningJobs, false);
/* 110 */           this.runningCount += 1;
/*     */           
/* 112 */           ready.setIsRunning(true);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 117 */     if (ready != null) {
/* 118 */       execute(ready);
/*     */     }
/*     */   }
/*     */   
/*     */   private void execute(final WorkNode node) {
/* 123 */     this.executor.execute(new Runnable()
/*     */     {
/*     */       /* Error */
/*     */       public void run()
/*     */       {
/*     */         // Byte code:
/*     */         //   0: aload_0
/*     */         //   1: getfield 2	com/facebook/internal/WorkQueue$1:val$node	Lcom/facebook/internal/WorkQueue$WorkNode;
/*     */         //   4: invokevirtual 4	com/facebook/internal/WorkQueue$WorkNode:getCallback	()Ljava/lang/Runnable;
/*     */         //   7: invokeinterface 5 1 0
/*     */         //   12: aload_0
/*     */         //   13: getfield 1	com/facebook/internal/WorkQueue$1:this$0	Lcom/facebook/internal/WorkQueue;
/*     */         //   16: aload_0
/*     */         //   17: getfield 2	com/facebook/internal/WorkQueue$1:val$node	Lcom/facebook/internal/WorkQueue$WorkNode;
/*     */         //   20: invokestatic 6	com/facebook/internal/WorkQueue:access$000	(Lcom/facebook/internal/WorkQueue;Lcom/facebook/internal/WorkQueue$WorkNode;)V
/*     */         //   23: goto +17 -> 40
/*     */         //   26: astore_1
/*     */         //   27: aload_0
/*     */         //   28: getfield 1	com/facebook/internal/WorkQueue$1:this$0	Lcom/facebook/internal/WorkQueue;
/*     */         //   31: aload_0
/*     */         //   32: getfield 2	com/facebook/internal/WorkQueue$1:val$node	Lcom/facebook/internal/WorkQueue$WorkNode;
/*     */         //   35: invokestatic 6	com/facebook/internal/WorkQueue:access$000	(Lcom/facebook/internal/WorkQueue;Lcom/facebook/internal/WorkQueue$WorkNode;)V
/*     */         //   38: aload_1
/*     */         //   39: athrow
/*     */         //   40: return
/*     */         // Line number table:
/*     */         //   Java source line #127	-> byte code offset #0
/*     */         //   Java source line #129	-> byte code offset #12
/*     */         //   Java source line #130	-> byte code offset #23
/*     */         //   Java source line #129	-> byte code offset #26
/*     */         //   Java source line #131	-> byte code offset #40
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	41	0	this	1
/*     */         //   26	13	1	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   0	12	26	finally
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static abstract interface WorkItem
/*     */   {
/*     */     public abstract boolean cancel();
/*     */     
/*     */     public abstract boolean isRunning();
/*     */     
/*     */     public abstract void moveToFront();
/*     */   }
/*     */   
/*     */   private class WorkNode
/*     */     implements WorkItem
/*     */   {
/*     */     private final Runnable callback;
/*     */     private WorkNode next;
/*     */     private WorkNode prev;
/*     */     private boolean isRunning;
/*     */     
/*     */     WorkNode(Runnable callback)
/*     */     {
/* 142 */       this.callback = callback;
/*     */     }
/*     */     
/*     */     public boolean cancel()
/*     */     {
/* 147 */       synchronized (WorkQueue.this.workLock) {
/* 148 */         if (!isRunning()) {
/* 149 */           WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
/* 150 */           return true;
/*     */         }
/*     */       }
/*     */       
/* 154 */       return false;
/*     */     }
/*     */     
/*     */     public void moveToFront()
/*     */     {
/* 159 */       synchronized (WorkQueue.this.workLock) {
/* 160 */         if (!isRunning()) {
/* 161 */           WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
/* 162 */           WorkQueue.this.pendingJobs = addToList(WorkQueue.this.pendingJobs, true);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean isRunning()
/*     */     {
/* 169 */       return this.isRunning;
/*     */     }
/*     */     
/*     */     Runnable getCallback() {
/* 173 */       return this.callback;
/*     */     }
/*     */     
/*     */     WorkNode getNext() {
/* 177 */       return this.next;
/*     */     }
/*     */     
/*     */     void setIsRunning(boolean isRunning) {
/* 181 */       this.isRunning = isRunning;
/*     */     }
/*     */     
/*     */     WorkNode addToList(WorkNode list, boolean addToFront) {
/* 185 */       assert (this.next == null);
/* 186 */       assert (this.prev == null);
/*     */       
/* 188 */       if (list == null) {
/* 189 */         this.prev = this;this.next = this;list = this;
/*     */       } else {
/* 191 */         this.next = list;
/* 192 */         this.prev = list.prev;
/* 193 */         this.prev.next = this;this.next.prev = this;
/*     */       }
/*     */       
/* 196 */       return addToFront ? this : list;
/*     */     }
/*     */     
/*     */     WorkNode removeFromList(WorkNode list) {
/* 200 */       assert (this.next != null);
/* 201 */       assert (this.prev != null);
/*     */       
/* 203 */       if (list == this) {
/* 204 */         if (this.next == this) {
/* 205 */           list = null;
/*     */         } else {
/* 207 */           list = this.next;
/*     */         }
/*     */       }
/*     */       
/* 211 */       this.next.prev = this.prev;
/* 212 */       this.prev.next = this.next;
/* 213 */       this.next = (this.prev = null);
/*     */       
/* 215 */       return list;
/*     */     }
/*     */     
/*     */     void verify(boolean shouldBeRunning) {
/* 219 */       assert (this.prev.next == this);
/* 220 */       assert (this.next.prev == this);
/* 221 */       assert (isRunning() == shouldBeRunning);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/WorkQueue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */