package android.support.v4.content;

final class q
  extends w
{
  q(o paramo) {}
  
  /* Error */
  public final Object call()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	android/support/v4/content/q:a	Landroid/support/v4/content/o;
    //   4: getfield 22	android/support/v4/content/o:f	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   7: iconst_1
    //   8: invokevirtual 28	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   11: bipush 10
    //   13: invokestatic 34	android/os/Process:setThreadPriority	(I)V
    //   16: aload_0
    //   17: getfield 10	android/support/v4/content/q:a	Landroid/support/v4/content/o;
    //   20: invokevirtual 36	android/support/v4/content/o:a	()Ljava/lang/Object;
    //   23: astore_1
    //   24: invokestatic 41	android/os/Binder:flushPendingCommands	()V
    //   27: aload_0
    //   28: getfield 10	android/support/v4/content/q:a	Landroid/support/v4/content/o;
    //   31: aload_1
    //   32: invokevirtual 45	android/support/v4/content/o:d	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: aload_1
    //   37: areturn
    //   38: astore_2
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_0
    //   42: getfield 10	android/support/v4/content/q:a	Landroid/support/v4/content/o;
    //   45: getfield 48	android/support/v4/content/o:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   48: iconst_1
    //   49: invokevirtual 28	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   52: aload_2
    //   53: athrow
    //   54: astore_2
    //   55: aload_0
    //   56: getfield 10	android/support/v4/content/q:a	Landroid/support/v4/content/o;
    //   59: aload_1
    //   60: invokevirtual 45	android/support/v4/content/o:d	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: aload_2
    //   65: athrow
    //   66: astore_2
    //   67: goto -26 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	q
    //   23	37	1	localObject1	Object
    //   38	15	2	localObject2	Object
    //   54	11	2	localObject3	Object
    //   66	1	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   11	24	38	finally
    //   41	54	54	finally
    //   24	27	66	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */