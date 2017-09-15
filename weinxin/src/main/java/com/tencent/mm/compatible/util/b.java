package com.tencent.mm.compatible.util;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.compatible.a.a.a;

public final class b
{
  public b gSf;
  private final String gSg;
  public Context mContext;
  
  public b(Context paramContext)
  {
    GMTrace.i(13788052979712L, 102729);
    this.mContext = null;
    this.gSf = null;
    this.gSg = "audio_lock";
    this.mContext = paramContext;
    a.a(8, new a.a()
    {
      public final void run()
      {
        GMTrace.i(13787247673344L, 102723);
        b.this.gSf = new c(b.this.mContext);
        GMTrace.o(13787247673344L, 102723);
      }
    });
    GMTrace.o(13788052979712L, 102729);
  }
  
  public final void a(a parama)
  {
    GMTrace.i(17561450184704L, 130843);
    if (this.gSf != null) {
      this.gSf.a(parama);
    }
    GMTrace.o(17561450184704L, 130843);
  }
  
  public final boolean rY()
  {
    GMTrace.i(13788321415168L, 102731);
    try
    {
      if (this.gSf == null)
      {
        GMTrace.o(13788321415168L, 102731);
        return false;
      }
      boolean bool = this.gSf.rY();
      GMTrace.o(13788321415168L, 102731);
      return bool;
    }
    finally {}
  }
  
  public final boolean requestFocus()
  {
    GMTrace.i(13788187197440L, 102730);
    try
    {
      if (this.gSf == null)
      {
        GMTrace.o(13788187197440L, 102730);
        return false;
      }
      boolean bool = this.gSf.requestFocus();
      GMTrace.o(13788187197440L, 102730);
      return bool;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void cX(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void a(b.a parama);
    
    public abstract boolean rY();
    
    public abstract boolean requestFocus();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */