package com.tencent.mm.ui.chatting;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.q;
import java.lang.ref.WeakReference;

final class cu
  implements En_5b8fbb1e.b
{
  private WeakReference<En_5b8fbb1e.a> vCS;
  
  cu()
  {
    GMTrace.i(17592186044416L, 131072);
    GMTrace.o(17592186044416L, 131072);
  }
  
  final void b(En_5b8fbb1e.a parama)
  {
    GMTrace.i(17592320262144L, 131073);
    this.vCS = new WeakReference(parama);
    parama.a(this);
    GMTrace.o(17592320262144L, 131073);
  }
  
  public final void bUh()
  {
    GMTrace.i(17592454479872L, 131074);
    if (this.vCS == null)
    {
      GMTrace.o(17592454479872L, 131074);
      return;
    }
    En_5b8fbb1e.a locala = (En_5b8fbb1e.a)this.vCS.get();
    if (locala != null) {
      ((e)h.h(e.class)).AM().gJ(b.aM(locala));
    }
    GMTrace.o(17592454479872L, 131074);
  }
  
  public final void bUi()
  {
    GMTrace.i(17592588697600L, 131075);
    if (this.vCS == null)
    {
      GMTrace.o(17592588697600L, 131075);
      return;
    }
    En_5b8fbb1e.a locala = (En_5b8fbb1e.a)this.vCS.get();
    if (locala != null) {
      ((e)h.h(e.class)).AM().gK(b.aM(locala));
    }
    GMTrace.o(17592588697600L, 131075);
  }
  
  public final void bUj()
  {
    GMTrace.i(17592722915328L, 131076);
    v.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExit, then detach DynamicPageView.");
    if (this.vCS == null)
    {
      GMTrace.o(17592722915328L, 131076);
      return;
    }
    En_5b8fbb1e.a locala = (En_5b8fbb1e.a)this.vCS.get();
    if (locala != null)
    {
      q.yC().fP(b.aM(locala));
      locala.b(this);
      ((e)h.h(e.class)).gL(b.aM(locala));
    }
    GMTrace.o(17592722915328L, 131076);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */