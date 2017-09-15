package com.c.a.a;

import android.net.wifi.ScanResult;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.List;

abstract class b
  extends a
{
  private z aJe;
  
  b()
  {
    super(new d[] { ab.nJ(), r.np(), u.nD(), k.nl() });
  }
  
  private void b(p paramp)
  {
    if (this.aJe != null) {}
    try
    {
      this.aJe.execute(new a(this, paramp));
      return;
    }
    catch (Exception paramp) {}
  }
  
  k.a a(d.a parama)
  {
    if (parama == null) {
      return null;
    }
    return new k.a(Math.max(parama.aJl, 10000L));
  }
  
  abstract void a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, long paramLong1, long paramLong2);
  
  abstract void a(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, long paramLong);
  
  abstract void a(int paramInt, String paramString, long paramLong1, long paramLong2);
  
  void a(Handler paramHandler, d.a parama)
  {
    if (paramHandler == null) {
      try
      {
        throw new Exception("CoreAssembly: master thread handler must be specified and cannot be null");
      }
      finally {}
    }
    this.aJe = z.b(paramHandler);
    super.a(paramHandler, parama);
  }
  
  final void a(Handler paramHandler, Handler[] paramArrayOfHandler)
  {
    paramArrayOfHandler[0] = paramHandler;
    paramArrayOfHandler[1] = null;
    paramArrayOfHandler[2] = paramHandler;
    paramArrayOfHandler[3] = paramHandler;
  }
  
  final void a(d.a parama, d.a[] paramArrayOfa)
  {
    paramArrayOfa[0] = parama;
    paramArrayOfa[1] = null;
    paramArrayOfa[2] = null;
    paramArrayOfa[3] = a(parama);
  }
  
  public void a(p paramp)
  {
    switch (paramp.what)
    {
    default: 
      return;
    case 101: 
      a(((ab.a)paramp).aPL, paramp.aMa, paramp.aMb);
      return;
    case 201: 
      b(paramp);
      return;
    case 202: 
      b(paramp);
      return;
    case 301: 
      paramp = (u.e)paramp;
      a(paramp.x, paramp.y, paramp.aOD, paramp.aOB, paramp.aOC, paramp.aLi, paramp.aMb);
      return;
    }
    paramp = (k.b)paramp;
    a(paramp.lat, paramp.lng, Double.valueOf(paramp.aLg).intValue(), Math.round(paramp.aLh), Math.round(paramp.aLi), paramp.aLk, paramp.aLl, paramp.aLj, paramp.aLm, paramp.aMb);
  }
  
  abstract void a(x paramx, long paramLong1, long paramLong2);
  
  abstract void a(List<ScanResult> paramList, long paramLong1, long paramLong2);
  
  private static final class a
    implements Runnable
  {
    private final WeakReference<b> aJf;
    private final p aJg;
    
    public a(b paramb, p paramp)
    {
      if ((paramb == null) || (paramp == null)) {
        throw new Exception("CoreAssembly: HandleMsgTask: null arg");
      }
      this.aJf = new WeakReference(paramb);
      this.aJg = paramp;
    }
    
    public final void run()
    {
      b localb = (b)this.aJf.get();
      if (localb != null) {}
      switch (this.aJg.what)
      {
      default: 
        return;
      }
      r.f localf = (r.f)this.aJg;
      if (localf.aMA == 1)
      {
        localb.a(localf.aMB, localf.aMa, localf.aMb);
        return;
      }
      localb.a(localf.aMA, localf.message, localf.aMa, localf.aMb);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */