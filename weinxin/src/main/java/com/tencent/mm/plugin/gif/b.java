package com.tencent.mm.plugin.gif;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.b;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;

public class b
{
  private static b mIm;
  public f<String, WeakReference<c>> mIn;
  f<String, WeakReference<a>> mIo;
  
  public b()
  {
    GMTrace.i(12890136379392L, 96039);
    this.mIn = new f(10);
    this.mIo = new f(10, new f.b() {});
    GMTrace.o(12890136379392L, 96039);
  }
  
  /* Error */
  public static b aCO()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc2_w 48
    //   6: ldc 50
    //   8: invokestatic 26	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: getstatic 52	com/tencent/mm/plugin/gif/b:mIm	Lcom/tencent/mm/plugin/gif/b;
    //   14: ifnonnull +25 -> 39
    //   17: ldc 2
    //   19: monitorenter
    //   20: getstatic 52	com/tencent/mm/plugin/gif/b:mIm	Lcom/tencent/mm/plugin/gif/b;
    //   23: ifnonnull +13 -> 36
    //   26: new 2	com/tencent/mm/plugin/gif/b
    //   29: dup
    //   30: invokespecial 53	com/tencent/mm/plugin/gif/b:<init>	()V
    //   33: putstatic 52	com/tencent/mm/plugin/gif/b:mIm	Lcom/tencent/mm/plugin/gif/b;
    //   36: ldc 2
    //   38: monitorexit
    //   39: getstatic 52	com/tencent/mm/plugin/gif/b:mIm	Lcom/tencent/mm/plugin/gif/b;
    //   42: astore_0
    //   43: ldc2_w 48
    //   46: ldc 50
    //   48: invokestatic 44	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_0
    //   55: areturn
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	13	0	localb	b
    //   56	5	0	localObject1	Object
    //   62	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	36	56	finally
    //   36	39	56	finally
    //   57	60	56	finally
    //   3	20	62	finally
    //   39	51	62	finally
    //   60	62	62	finally
  }
  
  public final a cr(String paramString1, String paramString2)
  {
    GMTrace.i(12890539032576L, 96042);
    a locala1 = null;
    if (this.mIo.get(paramString1) != null) {
      locala1 = (a)((WeakReference)this.mIo.get(paramString1)).get();
    }
    a locala2 = locala1;
    if (locala1 == null)
    {
      long l = System.currentTimeMillis();
      locala2 = new a(paramString2);
      v.d("MicroMsg.GIF.MMGIFDrawableCacheMgr", "new MMGIFDrawable use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      this.mIo.put(paramString1, new WeakReference(locala2));
    }
    GMTrace.o(12890539032576L, 96042);
    return locala2;
  }
  
  public final a o(String paramString, byte[] paramArrayOfByte)
  {
    a locala1 = null;
    GMTrace.i(12890673250304L, 96043);
    if (paramArrayOfByte == null)
    {
      GMTrace.o(12890673250304L, 96043);
      return null;
    }
    if (this.mIo.get(paramString) != null) {
      locala1 = (a)((WeakReference)this.mIo.get(paramString)).get();
    }
    a locala2 = locala1;
    if (locala1 == null)
    {
      locala2 = new a(paramArrayOfByte);
      this.mIo.put(paramString, new WeakReference(locala2));
    }
    if (!locala2.isRunning())
    {
      locala2.mHK = false;
      locala2.lp = true;
      com.tencent.mm.af.a.a(locala2.mIi, 300L);
    }
    GMTrace.o(12890673250304L, 96043);
    return locala2;
  }
  
  public final a yf(String paramString)
  {
    GMTrace.i(12890404814848L, 96041);
    a locala = null;
    if (this.mIo.get(paramString) != null) {
      locala = (a)((WeakReference)this.mIo.get(paramString)).get();
    }
    GMTrace.o(12890404814848L, 96041);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/gif/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */