package com.google.android.finsky.bm;

import com.google.android.finsky.utils.i;
import java.util.ArrayList;

public final class a
{
  private long a = 0L;
  private final ArrayList b = new ArrayList();
  
  /* Error */
  public final boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 14	com/google/android/finsky/bm/a:a	J
    //   6: lstore_1
    //   7: getstatic 27	com/google/android/finsky/ag/d:cZ	Lcom/google/android/play/utils/b/a;
    //   10: invokevirtual 32	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   13: checkcast 34	java/lang/Long
    //   16: invokevirtual 38	java/lang/Long:longValue	()J
    //   19: lstore_3
    //   20: invokestatic 42	com/google/android/finsky/utils/i:a	()J
    //   23: lstore 5
    //   25: lload_3
    //   26: lload_1
    //   27: ladd
    //   28: lload 5
    //   30: lcmp
    //   31: ifle +11 -> 42
    //   34: iconst_1
    //   35: istore 7
    //   37: aload_0
    //   38: monitorexit
    //   39: iload 7
    //   41: ireturn
    //   42: iconst_0
    //   43: istore 7
    //   45: goto -8 -> 37
    //   48: astore 8
    //   50: aload_0
    //   51: monitorexit
    //   52: aload 8
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	a
    //   6	21	1	l1	long
    //   19	7	3	l2	long
    //   23	6	5	l3	long
    //   35	9	7	bool	boolean
    //   48	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	48	finally
  }
  
  public final void b()
  {
    try
    {
      this.a = i.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void c()
  {
    try
    {
      this.a = 0L;
      ArrayList localArrayList = this.b;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((Runnable)localArrayList.get(i)).run();
        i += 1;
      }
      this.b.clear();
      return;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bm/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */