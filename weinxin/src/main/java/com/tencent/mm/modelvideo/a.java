package com.tencent.mm.modelvideo;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class a
{
  public static void a(r paramr, int paramInt)
  {
    GMTrace.i(16387179282432L, 122094);
    if (paramr == null)
    {
      v.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
      GMTrace.o(16387179282432L, 122094);
      return;
    }
    long l3 = bf.NB();
    o.KW();
    String str = s.lw(paramr.getFileName());
    long l2 = 0L;
    long l1 = 0L;
    if (c.mD(str))
    {
      b localb = new b();
      l2 = localb.mC(str);
      if (localb.iln != null) {
        l1 = localb.iln.ilj;
      }
    }
    for (int i = 1;; i = 0)
    {
      long l4 = paramr.fTG;
      str = r.ls(paramr.Li());
      long l5 = paramr.hrb;
      paramr = new StringBuilder();
      paramr.append(l4).append(";").append(str).append(";");
      paramr.append(l5).append(";");
      paramr.append(i).append(";").append(l2).append(";");
      paramr.append(l1).append(";").append(paramInt);
      paramr = paramr.toString();
      v.d("MicroMsg.AtomStatUtil", "report moov content : " + paramr + " cost time: " + bf.aB(l3));
      g.oSF.i(11098, new Object[] { Integer.valueOf(8000), paramr });
      GMTrace.o(16387179282432L, 122094);
      return;
      l1 = 0L;
      break;
      v.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */