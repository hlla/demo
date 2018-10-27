package com.google.android.finsky.bo.a;

import com.google.android.finsky.accounts.a;
import com.google.android.finsky.bo.g;

public final class f
  extends c
{
  private static final long[] a = { 12603301L, 12603516L, 12607073L };
  
  public f(String paramString, a parama, g... paramVarArgs)
  {
    super(paramString, parama, paramVarArgs);
  }
  
  /* Error */
  public final boolean a(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: getstatic 16	com/google/android/finsky/bo/a/f:a	[J
    //   10: astore 6
    //   12: aload 6
    //   14: arraylength
    //   15: istore 4
    //   17: iload_3
    //   18: iload 4
    //   20: if_icmpge +40 -> 60
    //   23: lload_1
    //   24: aload 6
    //   26: iload_3
    //   27: laload
    //   28: lcmp
    //   29: ifne +24 -> 53
    //   32: ldc 24
    //   34: iconst_1
    //   35: anewarray 26	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: lload_1
    //   41: invokestatic 32	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   44: aastore
    //   45: invokestatic 37	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: aload_0
    //   49: monitorexit
    //   50: iload 5
    //   52: ireturn
    //   53: iload_3
    //   54: iconst_1
    //   55: iadd
    //   56: istore_3
    //   57: goto -40 -> 17
    //   60: aload_0
    //   61: lload_1
    //   62: invokespecial 39	com/google/android/finsky/bo/a/c:a	(J)Z
    //   65: istore 5
    //   67: goto -19 -> 48
    //   70: astore 6
    //   72: aload_0
    //   73: monitorexit
    //   74: aload 6
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	f
    //   0	77	1	paramLong	long
    //   4	53	3	i	int
    //   15	6	4	j	int
    //   1	65	5	bool	boolean
    //   10	15	6	arrayOfLong	long[]
    //   70	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	17	70	finally
    //   32	48	70	finally
    //   60	67	70	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bo/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */