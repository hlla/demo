package com.tencent.mm.kernel;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bn.a;
import com.tencent.mm.bn.a.a;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.vending.g.d.b;
import junit.framework.Assert;

public final class i<_Profile extends e>
{
  private static i gYR;
  private c gYS;
  private d<_Profile> gYT;
  public byte[] gYU;
  public volatile boolean gYV;
  public a gYW;
  
  private i(_Profile param_Profile)
  {
    GMTrace.i(18794776887296L, 140032);
    this.gYU = new byte[0];
    this.gYV = false;
    this.gYW = new a();
    this.gYS = new c();
    this.gYT = new d(param_Profile);
    GMTrace.o(18794776887296L, 140032);
  }
  
  /* Error */
  public static <_Profile extends e> i<_Profile> b(_Profile param_Profile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc2_w 68
    //   6: ldc 70
    //   8: invokestatic 41	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: getstatic 72	com/tencent/mm/kernel/i:gYR	Lcom/tencent/mm/kernel/i;
    //   14: ifnull +31 -> 45
    //   17: ldc 74
    //   19: ldc 76
    //   21: iconst_0
    //   22: anewarray 5	java/lang/Object
    //   25: invokestatic 81	com/tencent/mm/kernel/j:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: getstatic 72	com/tencent/mm/kernel/i:gYR	Lcom/tencent/mm/kernel/i;
    //   31: astore_0
    //   32: ldc2_w 68
    //   35: ldc 70
    //   37: invokestatic 62	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_0
    //   44: areturn
    //   45: ldc 74
    //   47: ldc 83
    //   49: iconst_0
    //   50: anewarray 5	java/lang/Object
    //   53: invokestatic 81	com/tencent/mm/kernel/j:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: new 2	com/tencent/mm/kernel/i
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 84	com/tencent/mm/kernel/i:<init>	(Lcom/tencent/mm/kernel/b/e;)V
    //   64: astore_0
    //   65: aload_0
    //   66: putstatic 72	com/tencent/mm/kernel/i:gYR	Lcom/tencent/mm/kernel/i;
    //   69: ldc2_w 68
    //   72: ldc 70
    //   74: invokestatic 62	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   77: goto -37 -> 40
    //   80: astore_0
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_0
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	param_Profile	_Profile
    // Exception table:
    //   from	to	target	type
    //   3	40	80	finally
    //   45	77	80	finally
  }
  
  public static c vE()
  {
    GMTrace.i(18794911105024L, 140033);
    Assert.assertNotNull("mCorePlugins not initialized!", vN().gYS);
    c localc = vN().gYS;
    GMTrace.o(18794911105024L, 140033);
    return localc;
  }
  
  public static <_Profile extends e> i<_Profile> vN()
  {
    GMTrace.i(18795179540480L, 140035);
    Assert.assertNotNull("Skeleton not initialized!", gYR);
    i locali = gYR;
    GMTrace.o(18795179540480L, 140035);
    return locali;
  }
  
  public final void a(h paramh)
  {
    GMTrace.i(18795313758208L, 140036);
    int i = 0;
    synchronized (this.gYU)
    {
      if (this.gYV) {
        i = 1;
      }
      if (i != 0)
      {
        paramh.oh();
        GMTrace.o(18795313758208L, 140036);
        return;
      }
    }
    this.gYW.bI(paramh);
    GMTrace.o(18795313758208L, 140036);
  }
  
  public final void b(h paramh)
  {
    GMTrace.i(18795447975936L, 140037);
    this.gYW.remove(paramh);
    GMTrace.o(18795447975936L, 140037);
  }
  
  public final d<_Profile> vF()
  {
    GMTrace.i(18795045322752L, 140034);
    Assert.assertNotNull("mCoreProcess not initialized!", vN().gYT);
    d locald = this.gYT;
    GMTrace.o(18795045322752L, 140034);
    return locald;
  }
  
  private static final class a
    extends a<h>
    implements h
  {
    public a()
    {
      super();
      GMTrace.i(18792897839104L, 140018);
      GMTrace.o(18792897839104L, 140018);
    }
    
    public final void ak(final boolean paramBoolean)
    {
      GMTrace.i(18793166274560L, 140020);
      a(new a.a() {});
      GMTrace.o(18793166274560L, 140020);
    }
    
    public final void oh()
    {
      GMTrace.i(18793032056832L, 140019);
      a(new a.a() {});
      GMTrace.o(18793032056832L, 140019);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kernel/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */