package com.tencent.mm.q;

import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.am;
import java.util.ArrayList;
import java.util.HashMap;

public final class c
  implements am
{
  private static c gUW;
  private a gUX;
  
  private c()
  {
    GMTrace.i(1425794924544L, 10623);
    if (a.gUB == null) {
      a.gUB = new a();
    }
    this.gUX = a.gUB;
    GMTrace.o(1425794924544L, 10623);
  }
  
  public static a uk()
  {
    GMTrace.i(14594164654080L, 108735);
    h.vG().uQ();
    if (gUW == null)
    {
      localObject = new c();
      gUW = (c)localObject;
      ((c)localObject).gUX.init();
    }
    Object localObject = gUW.gUX;
    GMTrace.o(14594164654080L, 108735);
    return (a)localObject;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(1426197577728L, 10626);
    this.gUX.init();
    GMTrace.o(1426197577728L, 10626);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(1426331795456L, 10627);
    GMTrace.o(1426331795456L, 10627);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(1426063360000L, 10625);
    GMTrace.o(1426063360000L, 10625);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(1425929142272L, 10624);
    a locala = this.gUX;
    locala.gUD.clear();
    b localb = locala.gUC;
    v.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
    localb.gUM.clear();
    localb.gUO.clear();
    localb.gUN.clear();
    localb.gUP.clear();
    locala.gUE = false;
    GMTrace.o(1425929142272L, 10624);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(1426466013184L, 10628);
    GMTrace.o(1426466013184L, 10628);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/q/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */