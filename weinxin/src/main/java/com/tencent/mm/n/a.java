package com.tencent.mm.n;

import android.content.Context;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.ja;
import com.tencent.mm.e.a.ja.b;
import com.tencent.mm.e.a.rq;
import com.tencent.mm.e.a.rq.a;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.y;

public final class a
{
  private static y fwX;
  
  public static boolean aH(Context paramContext)
  {
    GMTrace.i(18720822919168L, 139481);
    if (tQ())
    {
      v.i("MicroMsg.DeviceOccupy", "isMultiTalking");
      Toast.makeText(paramContext, a.g.kDc, 0).show();
      GMTrace.o(18720822919168L, 139481);
      return true;
    }
    GMTrace.o(18720822919168L, 139481);
    return false;
  }
  
  public static boolean aI(Context paramContext)
  {
    GMTrace.i(18721091354624L, 139483);
    rq localrq = new rq();
    com.tencent.mm.sdk.b.a.uql.m(localrq);
    if (localrq.fYu.fYw)
    {
      v.i("MicroMsg.DeviceOccupy", "isCameraUsing");
      Toast.makeText(paramContext, d(paramContext, localrq.fYu.fYv), 0).show();
    }
    boolean bool = localrq.fYu.fYw;
    GMTrace.o(18721091354624L, 139483);
    return bool;
  }
  
  public static boolean aJ(Context paramContext)
  {
    GMTrace.i(18721225572352L, 139484);
    rq localrq = new rq();
    com.tencent.mm.sdk.b.a.uql.m(localrq);
    if (localrq.fYu.fYx)
    {
      v.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
      Toast.makeText(paramContext, d(paramContext, localrq.fYu.fYv), 0).show();
    }
    boolean bool = localrq.fYu.fYx;
    GMTrace.o(18721225572352L, 139484);
    return bool;
  }
  
  private static String d(Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(18721359790080L, 139485);
    if (paramBoolean)
    {
      paramContext = paramContext.getString(a.g.kCo);
      GMTrace.o(18721359790080L, 139485);
      return paramContext;
    }
    paramContext = paramContext.getString(a.g.kCp);
    GMTrace.o(18721359790080L, 139485);
    return paramContext;
  }
  
  public static y oH()
  {
    GMTrace.i(18721494007808L, 139486);
    if (fwX == null) {
      fwX = com.tencent.mm.booter.a.pQ();
    }
    y localy = fwX;
    GMTrace.o(18721494007808L, 139486);
    return localy;
  }
  
  public static boolean tQ()
  {
    GMTrace.i(18720957136896L, 139482);
    ja localja = new ja();
    localja.fOK.action = 1;
    com.tencent.mm.sdk.b.a.uql.m(localja);
    boolean bool = localja.fOL.fOM;
    GMTrace.o(18720957136896L, 139482);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/n/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */