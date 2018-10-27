package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.q.a.a;

@a
public final class af
{
  private boolean a = false;
  private float b = 1.0F;
  
  public static float a(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramContext != null)
    {
      int i = paramContext.getStreamMaxVolume(3);
      int j = paramContext.getStreamVolume(3);
      if (i != 0) {
        return j / i;
      }
      return 0.0F;
    }
    return 0.0F;
  }
  
  /* Error */
  private final boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/google/android/gms/ads/internal/util/af:b	F
    //   6: fstore_1
    //   7: fload_1
    //   8: fconst_0
    //   9: fcmpl
    //   10: iflt +9 -> 19
    //   13: iconst_1
    //   14: istore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_2
    //   18: ireturn
    //   19: iconst_0
    //   20: istore_2
    //   21: goto -6 -> 15
    //   24: astore_3
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_3
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	af
    //   6	2	1	f	float
    //   14	7	2	bool	boolean
    //   24	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	24	finally
  }
  
  /* Error */
  public final float a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 41	com/google/android/gms/ads/internal/util/af:c	()Z
    //   6: ifeq +12 -> 18
    //   9: aload_0
    //   10: getfield 17	com/google/android/gms/ads/internal/util/af:b	F
    //   13: fstore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: fload_1
    //   17: freturn
    //   18: fconst_1
    //   19: fstore_1
    //   20: goto -6 -> 14
    //   23: astore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	af
    //   13	7	1	f	float
    //   23	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	23	finally
  }
  
  public final void a(float paramFloat)
  {
    try
    {
      this.b = paramFloat;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.a = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */