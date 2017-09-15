package com.tencent.mm.booter;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.ma;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.y;
import com.tencent.mm.u.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements y
{
  private static a gJk;
  private ao gJi;
  private ao.a gJj;
  private List<z> gJl;
  private c gJm;
  
  private a()
  {
    GMTrace.i(502242738176L, 3742);
    this.gJl = new ArrayList();
    this.gJi = new ao();
    this.gJj = new ao.a()
    {
      public final void dL(int paramAnonymousInt)
      {
        GMTrace.i(495129198592L, 3689);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          GMTrace.o(495129198592L, 3689);
          return;
          v.v("MicroMsg.BackgroundPlayer", "call end");
          a.this.pR();
          GMTrace.o(495129198592L, 3689);
          return;
          v.v("MicroMsg.BackgroundPlayer", "call start");
          a.this.pS();
        }
      }
    };
    this.gJi.a(this.gJj);
    this.gJi.ek(aa.getContext());
    if (this.gJm == null) {
      this.gJm = new c() {};
    }
    com.tencent.mm.sdk.b.a.uql.b(this.gJm);
    GMTrace.o(502242738176L, 3742);
  }
  
  public static a pQ()
  {
    GMTrace.i(18725923192832L, 139519);
    if (gJk == null) {}
    try
    {
      if (gJk == null) {
        gJk = new a();
      }
      a locala = gJk;
      GMTrace.o(18725923192832L, 139519);
      return locala;
    }
    finally {}
  }
  
  public final void a(z paramz)
  {
    GMTrace.i(502376955904L, 3743);
    if (paramz != null)
    {
      v.d("MicroMsg.BackgroundPlayer", "add callback : %s", new Object[] { paramz.toString() });
      this.gJl.add(paramz);
    }
    GMTrace.o(502376955904L, 3743);
  }
  
  public final void b(z paramz)
  {
    GMTrace.i(502511173632L, 3744);
    if (paramz != null) {
      this.gJl.remove(paramz);
    }
    GMTrace.o(502511173632L, 3744);
  }
  
  public final void pR()
  {
    GMTrace.i(502645391360L, 3745);
    if (this.gJl == null)
    {
      GMTrace.o(502645391360L, 3745);
      return;
    }
    Iterator localIterator = this.gJl.iterator();
    while (localIterator.hasNext()) {
      ((z)localIterator.next()).yG();
    }
    GMTrace.o(502645391360L, 3745);
  }
  
  public final void pS()
  {
    GMTrace.i(502779609088L, 3746);
    if (this.gJl == null)
    {
      GMTrace.o(502779609088L, 3746);
      return;
    }
    Iterator localIterator = this.gJl.iterator();
    while (localIterator.hasNext()) {
      ((z)localIterator.next()).yH();
    }
    GMTrace.o(502779609088L, 3746);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */