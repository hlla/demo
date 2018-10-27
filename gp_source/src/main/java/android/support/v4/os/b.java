package android.support.v4.os;

public final class b
{
  public Object a;
  public boolean b;
  
  /* Error */
  public final Object a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	android/support/v4/os/b:a	Ljava/lang/Object;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 16	android/support/v4/os/b:a	Ljava/lang/Object;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: new 18	android/os/CancellationSignal
    //   22: dup
    //   23: invokespecial 19	android/os/CancellationSignal:<init>	()V
    //   26: putfield 16	android/support/v4/os/b:a	Ljava/lang/Object;
    //   29: aload_0
    //   30: getfield 21	android/support/v4/os/b:b	Z
    //   33: ifeq -24 -> 9
    //   36: aload_0
    //   37: getfield 16	android/support/v4/os/b:a	Ljava/lang/Object;
    //   40: checkcast 18	android/os/CancellationSignal
    //   43: invokevirtual 24	android/os/CancellationSignal:cancel	()V
    //   46: goto -37 -> 9
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	b
    //   13	4	1	localObject1	Object
    //   49	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	49	finally
    //   9	16	49	finally
    //   18	46	49	finally
    //   50	52	49	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/os/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */