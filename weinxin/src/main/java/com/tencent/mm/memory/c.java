package com.tencent.mm.memory;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class c
  extends a<Bitmap>
{
  private static int hgo;
  public static final c hgp;
  
  static
  {
    GMTrace.i(1277618552832L, 9519);
    hgo = 20971520;
    hgp = new c();
    GMTrace.o(1277618552832L, 9519);
  }
  
  private c()
  {
    GMTrace.i(1275471069184L, 9503);
    int i = ((ActivityManager)aa.getContext().getSystemService("activity")).getLargeMemoryClass();
    v.i("MicroMsg.BitmapPool", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i > 256) {}
    for (hgo = 20971520;; hgo = 10485760)
    {
      wn();
      GMTrace.o(1275471069184L, 9503);
      return;
    }
  }
  
  private static Integer d(Bitmap paramBitmap)
  {
    GMTrace.i(1276142157824L, 9508);
    if (paramBitmap == null)
    {
      GMTrace.o(1276142157824L, 9508);
      return Integer.valueOf(0);
    }
    if (d.ep(19)) {}
    for (int i = paramBitmap.getByteCount();; i = paramBitmap.getAllocationByteCount())
    {
      GMTrace.o(1276142157824L, 9508);
      return Integer.valueOf(i);
    }
  }
  
  protected static Integer d(Integer paramInteger)
  {
    GMTrace.i(1275605286912L, 9504);
    int i = paramInteger.intValue();
    GMTrace.o(1275605286912L, 9504);
    return Integer.valueOf(i * 4);
  }
  
  /* Error */
  public final Bitmap e(Integer paramInteger)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 159
    //   5: sipush 9507
    //   8: invokestatic 19	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial 162	com/tencent/mm/memory/a:b	(Ljava/lang/Integer;)Ljava/lang/Object;
    //   16: checkcast 87	android/graphics/Bitmap
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +17 -> 38
    //   24: aload_2
    //   25: invokevirtual 166	android/graphics/Bitmap:isRecycled	()Z
    //   28: ifne +10 -> 38
    //   31: aload_2
    //   32: invokevirtual 169	android/graphics/Bitmap:isMutable	()Z
    //   35: ifne +18 -> 53
    //   38: aconst_null
    //   39: astore_1
    //   40: ldc2_w 159
    //   43: sipush 9507
    //   46: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: ldc 56
    //   55: ldc -85
    //   57: iconst_5
    //   58: anewarray 60	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_2
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: aload_2
    //   68: invokevirtual 174	android/graphics/Bitmap:getWidth	()I
    //   71: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: aload_2
    //   78: invokevirtual 177	android/graphics/Bitmap:getHeight	()I
    //   81: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aastore
    //   85: dup
    //   86: iconst_3
    //   87: aload_2
    //   88: invokestatic 128	com/tencent/mm/memory/c:d	(Landroid/graphics/Bitmap;)Ljava/lang/Integer;
    //   91: aastore
    //   92: dup
    //   93: iconst_4
    //   94: aload_1
    //   95: aastore
    //   96: invokestatic 179	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: ldc2_w 159
    //   102: sipush 9507
    //   105: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   108: aload_2
    //   109: astore_1
    //   110: goto -61 -> 49
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	c
    //   0	118	1	paramInteger	Integer
    //   19	90	2	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   2	20	113	finally
    //   24	38	113	finally
    //   40	49	113	finally
    //   53	108	113	finally
  }
  
  public final void e(Bitmap paramBitmap)
  {
    try
    {
      GMTrace.i(1276276375552L, 9509);
      if ((paramBitmap != null) && (paramBitmap.isMutable()) && (!paramBitmap.isRecycled()))
      {
        v.i("MicroMsg.BitmapPool", "release: %s", new Object[] { paramBitmap });
        super.as(paramBitmap);
      }
      GMTrace.o(1276276375552L, 9509);
      return;
    }
    finally {}
  }
  
  protected final long wj()
  {
    GMTrace.i(1275739504640L, 9505);
    long l = hgo;
    GMTrace.o(1275739504640L, 9505);
    return l;
  }
  
  protected final long wk()
  {
    GMTrace.i(1275873722368L, 9506);
    GMTrace.o(1275873722368L, 9506);
    return 1048576L;
  }
  
  public final void wl()
  {
    GMTrace.i(1276410593280L, 9510);
    super.wl();
    GMTrace.o(1276410593280L, 9510);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/memory/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */