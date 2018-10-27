/*    */ package com.facebook.internal;
/*    */ 
/*    */ import com.facebook.FacebookSdk;
/*    */ import java.util.concurrent.Callable;
/*    */ import java.util.concurrent.CountDownLatch;
/*    */ import java.util.concurrent.Executor;
/*    */ import java.util.concurrent.FutureTask;
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
/*    */ public class LockOnGetVariable<T>
/*    */ {
/*    */   private T value;
/*    */   private CountDownLatch initLatch;
/*    */   
/*    */   public LockOnGetVariable(T value)
/*    */   {
/* 34 */     this.value = value;
/*    */   }
/*    */   
/*    */   public LockOnGetVariable(final Callable<T> callable) {
/* 38 */     this.initLatch = new CountDownLatch(1);
/* 39 */     FacebookSdk.getExecutor().execute(new FutureTask(new Callable()
/*    */     {
/*    */       /* Error */
/*    */       public Void call()
/*    */         throws Exception
/*    */       {
/*    */         // Byte code:
/*    */         //   0: aload_0
/*    */         //   1: getfield 1	com/facebook/internal/LockOnGetVariable$1:this$0	Lcom/facebook/internal/LockOnGetVariable;
/*    */         //   4: aload_0
/*    */         //   5: getfield 2	com/facebook/internal/LockOnGetVariable$1:val$callable	Ljava/util/concurrent/Callable;
/*    */         //   8: invokeinterface 4 1 0
/*    */         //   13: invokestatic 5	com/facebook/internal/LockOnGetVariable:access$002	(Lcom/facebook/internal/LockOnGetVariable;Ljava/lang/Object;)Ljava/lang/Object;
/*    */         //   16: pop
/*    */         //   17: aload_0
/*    */         //   18: getfield 1	com/facebook/internal/LockOnGetVariable$1:this$0	Lcom/facebook/internal/LockOnGetVariable;
/*    */         //   21: invokestatic 6	com/facebook/internal/LockOnGetVariable:access$100	(Lcom/facebook/internal/LockOnGetVariable;)Ljava/util/concurrent/CountDownLatch;
/*    */         //   24: invokevirtual 7	java/util/concurrent/CountDownLatch:countDown	()V
/*    */         //   27: goto +16 -> 43
/*    */         //   30: astore_1
/*    */         //   31: aload_0
/*    */         //   32: getfield 1	com/facebook/internal/LockOnGetVariable$1:this$0	Lcom/facebook/internal/LockOnGetVariable;
/*    */         //   35: invokestatic 6	com/facebook/internal/LockOnGetVariable:access$100	(Lcom/facebook/internal/LockOnGetVariable;)Ljava/util/concurrent/CountDownLatch;
/*    */         //   38: invokevirtual 7	java/util/concurrent/CountDownLatch:countDown	()V
/*    */         //   41: aload_1
/*    */         //   42: athrow
/*    */         //   43: aconst_null
/*    */         //   44: areturn
/*    */         // Line number table:
/*    */         //   Java source line #44	-> byte code offset #0
/*    */         //   Java source line #46	-> byte code offset #17
/*    */         //   Java source line #47	-> byte code offset #27
/*    */         //   Java source line #46	-> byte code offset #30
/*    */         //   Java source line #48	-> byte code offset #43
/*    */         // Local variable table:
/*    */         //   start	length	slot	name	signature
/*    */         //   0	45	0	this	1
/*    */         //   30	12	1	localObject	Object
/*    */         // Exception table:
/*    */         //   from	to	target	type
/*    */         //   0	17	30	finally
/*    */       }
/*    */     }));
/*    */   }
/*    */   
/*    */   public T getValue()
/*    */   {
/* 54 */     waitOnInit();
/* 55 */     return (T)this.value;
/*    */   }
/*    */   
/*    */   private void waitOnInit() {
/* 59 */     if (this.initLatch == null) {
/* 60 */       return;
/*    */     }
/*    */     try
/*    */     {
/* 64 */       this.initLatch.await();
/*    */     }
/*    */     catch (InterruptedException localInterruptedException) {}
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/LockOnGetVariable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */