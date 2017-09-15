package com.tencent.mm.modelstat;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;

public final class a
{
  public static void a(au paramau, a parama)
  {
    GMTrace.i(1382174162944L, 10298);
    if (bf.mA(paramau.gxE))
    {
      GMTrace.o(1382174162944L, 10298);
      return;
    }
    d locald = new d();
    locald.n("20ExpIdStr", paramau.gxE + ",");
    locald.n("21OpType", parama.value + ",");
    locald.n("22msgId", paramau.field_msgSvrId + ",");
    locald.n("23MessageType", paramau.field_type + ",");
    int i;
    if (paramau.axH())
    {
      parama = f.a.B(paramau.field_content, paramau.field_reserved);
      if (parama == null) {
        i = 0;
      }
    }
    for (;;)
    {
      parama = paramau.field_talker;
      locald.n("24AppMsgInnerType", i + ",");
      locald.n("25curUsername", parama + ",");
      String str = "";
      if (paramau.field_isSend == 1) {
        parama = m.xL();
      }
      for (;;)
      {
        locald.n("26msgPostUserName", parama + ",");
        locald.n("27MediaState", paramau.gxF + ",");
        v.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + locald.JH());
        g.oSF.i(13564, new Object[] { locald });
        GMTrace.o(1382174162944L, 10298);
        return;
        i = parama.type;
        break;
        if ((parama != null) && (parama.endsWith("@chatroom")))
        {
          parama = str;
          if (paramau.field_content != null)
          {
            i = ay.gh(paramau.field_content);
            parama = str;
            if (i != -1) {
              parama = paramau.field_content.substring(0, i).trim();
            }
          }
        }
      }
      i = 0;
    }
  }
  
  public static enum a
  {
    public int value;
    
    static
    {
      GMTrace.i(1386737565696L, 10332);
      hTR = new a("Expose", 0, 1);
      hTS = new a("Click", 1, 2);
      hTT = new a[] { hTR, hTS };
      GMTrace.o(1386737565696L, 10332);
    }
    
    private a(int paramInt)
    {
      GMTrace.i(1386603347968L, 10331);
      this.value = 0;
      this.value = paramInt;
      GMTrace.o(1386603347968L, 10331);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelstat/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */