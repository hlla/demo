package com.tencent.mm.sdk.e;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;

public abstract class m
  implements g
{
  private final k<b, a> uvv;
  
  public m()
  {
    GMTrace.i(13976628887552L, 104134);
    this.uvv = new k() {};
    GMTrace.o(13976628887552L, 104134);
  }
  
  public abstract boolean Fd();
  
  public final void a(b paramb)
  {
    GMTrace.i(13976763105280L, 104135);
    if (paramb != null) {
      this.uvv.a(paramb, Looper.getMainLooper());
    }
    GMTrace.o(13976763105280L, 104135);
  }
  
  public final void b(int paramInt, m paramm, Object paramObject)
  {
    GMTrace.i(13977031540736L, 104137);
    this.uvv.by(new a(paramInt, paramm, paramObject));
    this.uvv.doNotify();
    GMTrace.o(13977031540736L, 104137);
  }
  
  public final void b(b paramb)
  {
    GMTrace.i(13976897323008L, 104136);
    if (paramb != null) {
      this.uvv.remove(paramb);
    }
    GMTrace.o(13976897323008L, 104136);
  }
  
  private final class a
  {
    int fKR;
    Object obj;
    m uvH;
    
    a(int paramInt, m paramm, Object paramObject)
    {
      GMTrace.i(13965757251584L, 104053);
      this.fKR = paramInt;
      this.obj = paramObject;
      this.uvH = paramm;
      GMTrace.o(13965757251584L, 104053);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, m paramm, Object paramObject);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/e/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */