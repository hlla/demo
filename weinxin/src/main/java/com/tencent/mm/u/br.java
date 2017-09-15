package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.Set;

public final class br
{
  public boolean aJi;
  public Set<a> hnX;
  
  public br()
  {
    GMTrace.i(13477473157120L, 100415);
    this.aJi = false;
    this.hnX = new HashSet();
    GMTrace.o(13477473157120L, 100415);
  }
  
  public final boolean a(a parama)
  {
    GMTrace.i(13477607374848L, 100416);
    if (this.aJi)
    {
      v.e("MicroMsg.UninitForUEH", "add , is running , forbid add");
      GMTrace.o(13477607374848L, 100416);
      return false;
    }
    boolean bool = this.hnX.add(parama);
    GMTrace.o(13477607374848L, 100416);
    return bool;
  }
  
  public final boolean b(a parama)
  {
    GMTrace.i(13477741592576L, 100417);
    if (this.aJi)
    {
      v.e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
      GMTrace.o(13477741592576L, 100417);
      return false;
    }
    boolean bool = this.hnX.remove(parama);
    GMTrace.o(13477741592576L, 100417);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean Aa();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */