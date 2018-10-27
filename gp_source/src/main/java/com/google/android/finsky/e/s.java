package com.google.android.finsky.e;

import java.lang.reflect.Array;

final class s
{
  private final Object[] a;
  private int b;
  private final t c;
  private int d;
  private final int e;
  
  public s(Class paramClass, int paramInt, t paramt)
  {
    this.e = paramInt;
    this.b = 0;
    this.d = 0;
    this.a = ((Object[])Array.newInstance(paramClass, paramInt));
    this.c = paramt;
  }
  
  public final Object a()
  {
    try
    {
      int i = this.b;
      if (i > 0)
      {
        this.b = (i - 1);
        Object[] arrayOfObject = this.a;
        i = this.b;
        Object localObject2 = arrayOfObject[i];
        arrayOfObject[i] = null;
        return localObject2;
      }
      return this.c.a();
    }
    finally {}
  }
  
  /* Error */
  public final void a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/google/android/finsky/e/s:b	I
    //   6: istore_2
    //   7: iload_2
    //   8: aload_0
    //   9: getfield 19	com/google/android/finsky/e/s:e	I
    //   12: if_icmpge +30 -> 42
    //   15: aload_0
    //   16: getfield 32	com/google/android/finsky/e/s:a	[Ljava/lang/Object;
    //   19: iload_2
    //   20: aload_1
    //   21: aastore
    //   22: aload_0
    //   23: iload_2
    //   24: iconst_1
    //   25: iadd
    //   26: putfield 21	com/google/android/finsky/e/s:b	I
    //   29: aload_0
    //   30: getfield 21	com/google/android/finsky/e/s:b	I
    //   33: istore_2
    //   34: iload_2
    //   35: aload_0
    //   36: getfield 23	com/google/android/finsky/e/s:d	I
    //   39: if_icmpgt +6 -> 45
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: iload_2
    //   47: putfield 23	com/google/android/finsky/e/s:d	I
    //   50: goto -8 -> 42
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	s
    //   0	58	1	paramObject	Object
    //   6	41	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	42	53	finally
    //   42	44	53	finally
    //   45	50	53	finally
    //   54	56	53	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */