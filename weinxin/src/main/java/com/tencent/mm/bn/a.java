package com.tencent.mm.bn;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.h.f;
import java.util.Iterator;
import java.util.LinkedList;

public class a<_Callback>
  extends com.tencent.mm.vending.b.a<_Callback>
{
  public a()
  {
    super(new d());
    GMTrace.i(13615046328320L, 101440);
    GMTrace.o(13615046328320L, 101440);
  }
  
  public a(com.tencent.mm.vending.h.d paramd)
  {
    super(paramd);
    GMTrace.i(13615314763776L, 101442);
    GMTrace.o(13615314763776L, 101442);
  }
  
  public final void a(final a<_Callback> parama)
  {
    GMTrace.i(13615448981504L, 101443);
    Iterator localIterator = cbn().iterator();
    while (localIterator.hasNext())
    {
      final b localb = (b)localIterator.next();
      if (localb != null) {
        if (localb.fwq != null)
        {
          this.wAr.b(localb.fwq);
          this.wAr.a(new com.tencent.mm.vending.c.a() {}, com.tencent.mm.vending.c.a.wAy, true);
        }
        else
        {
          parama.ao(localb.wAt);
        }
      }
    }
    GMTrace.o(13615448981504L, 101443);
  }
  
  public final b<_Callback> bI(_Callback param_Callback)
  {
    GMTrace.i(13615583199232L, 101444);
    param_Callback = super.a(new b(param_Callback, this));
    GMTrace.o(13615583199232L, 101444);
    return param_Callback;
  }
  
  public final void remove(_Callback param_Callback)
  {
    GMTrace.i(13615717416960L, 101445);
    super.b(new b(param_Callback, this));
    GMTrace.o(13615717416960L, 101445);
  }
  
  public static abstract interface a<_Callback>
  {
    public abstract void ao(_Callback param_Callback);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bn/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */