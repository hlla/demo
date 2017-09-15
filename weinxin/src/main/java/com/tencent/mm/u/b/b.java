package com.tencent.mm.u.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b
{
  private boolean hor;
  public ArrayList<a> mListeners;
  
  public b()
  {
    GMTrace.i(16261014618112L, 121154);
    this.mListeners = new ArrayList();
    this.hor = false;
    GMTrace.o(16261014618112L, 121154);
  }
  
  public static String Ah()
  {
    GMTrace.i(16261148835840L, 121155);
    ap.yY();
    String str = (String)c.vr().get(w.a.uGf, "");
    GMTrace.o(16261148835840L, 121155);
    return str;
  }
  
  public static String Ai()
  {
    GMTrace.i(16261283053568L, 121156);
    ap.yY();
    String str = (String)c.vr().get(w.a.uGg, "");
    GMTrace.o(16261283053568L, 121156);
    return str;
  }
  
  public static boolean Aj()
  {
    GMTrace.i(16261417271296L, 121157);
    ap.yY();
    boolean bool = ((Boolean)c.vr().get(w.a.uGi, Boolean.valueOf(false))).booleanValue();
    GMTrace.o(16261417271296L, 121157);
    return bool;
  }
  
  public static String Ak()
  {
    GMTrace.i(16261551489024L, 121158);
    ap.yY();
    String str = (String)c.vr().get(w.a.uFZ, "");
    GMTrace.o(16261551489024L, 121158);
    return str;
  }
  
  public static String Al()
  {
    GMTrace.i(16261685706752L, 121159);
    ap.yY();
    String str = (String)c.vr().get(w.a.uGa, "");
    GMTrace.o(16261685706752L, 121159);
    return str;
  }
  
  public static boolean Am()
  {
    GMTrace.i(16261819924480L, 121160);
    ap.yY();
    boolean bool = ((Boolean)c.vr().get(w.a.uGi, Boolean.valueOf(false))).booleanValue();
    GMTrace.o(16261819924480L, 121160);
    return bool;
  }
  
  public static boolean An()
  {
    GMTrace.i(17812974206976L, 132717);
    ap.yY();
    boolean bool = ((Boolean)c.vr().get(w.a.uGd, Boolean.valueOf(false))).booleanValue();
    GMTrace.o(17812974206976L, 132717);
    return bool;
  }
  
  private static boolean Ao()
  {
    GMTrace.i(16261954142208L, 121161);
    ap.yY();
    boolean bool = ((Boolean)c.vr().get(w.a.uGm, Boolean.valueOf(false))).booleanValue();
    GMTrace.o(16261954142208L, 121161);
    return bool;
  }
  
  public static boolean a(b paramb)
  {
    GMTrace.i(16262222577664L, 121163);
    v.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", new Object[] { paramb });
    long l2 = bf.Nz();
    ap.yY();
    long l3 = ((Long)c.vr().get(w.a.uGl, Long.valueOf(-1L))).longValue();
    long l1;
    boolean bool2;
    boolean bool1;
    if (paramb == b.hot)
    {
      ap.yY();
      l1 = ((Long)c.vr().get(w.a.uGb, Long.valueOf(0L))).longValue();
      ap.yY();
      bool2 = ((Boolean)c.vr().get(w.a.uGe, Boolean.valueOf(false))).booleanValue();
      bool1 = An();
    }
    for (paramb = Ak(); bf.mA(paramb); paramb = Ah())
    {
      v.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
      GMTrace.o(16262222577664L, 121163);
      return false;
      ap.yY();
      l1 = ((Long)c.vr().get(w.a.uGh, Long.valueOf(0L))).longValue();
      ap.yY();
      bool2 = ((Boolean)c.vr().get(w.a.uGk, Boolean.valueOf(false))).booleanValue();
      ap.yY();
      bool1 = ((Boolean)c.vr().get(w.a.uGj, Boolean.valueOf(false))).booleanValue();
    }
    if (bool2)
    {
      v.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
      GMTrace.o(16262222577664L, 121163);
      return false;
    }
    if (l3 < 0L)
    {
      v.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
      GMTrace.o(16262222577664L, 121163);
      return false;
    }
    if ((bool1) && (!Ao()))
    {
      v.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
      GMTrace.o(16262222577664L, 121163);
      return false;
    }
    if (l1 == -1L)
    {
      v.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
      GMTrace.o(16262222577664L, 121163);
      return true;
    }
    if (l3 + l1 > l2)
    {
      v.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
      GMTrace.o(16262222577664L, 121163);
      return true;
    }
    v.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
    GMTrace.o(16262222577664L, 121163);
    return false;
  }
  
  public final void Ap()
  {
    GMTrace.i(16262356795392L, 121164);
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).Ar();
      }
    }
    finally {}
    GMTrace.o(16262356795392L, 121164);
  }
  
  public final void Aq()
  {
    GMTrace.i(16262491013120L, 121165);
    if (Ao() != true)
    {
      v.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
      ap.yY();
      c.vr().a(w.a.uGl, Long.valueOf(bf.Nz()));
      ap.yY();
      c.vr().a(w.a.uGm, Boolean.valueOf(true));
      Ap();
    }
    GMTrace.o(16262491013120L, 121165);
  }
  
  public final void b(b paramb)
  {
    GMTrace.i(17813108424704L, 132718);
    if (paramb == b.hos)
    {
      ap.yY();
      c.vr().a(w.a.uGk, Boolean.valueOf(false));
    }
    for (;;)
    {
      Ap();
      GMTrace.o(17813108424704L, 132718);
      return;
      ap.yY();
      c.vr().a(w.a.uGe, Boolean.valueOf(false));
    }
  }
  
  public final void k(Map<String, String> paramMap)
  {
    GMTrace.i(16262088359936L, 121162);
    if (paramMap == null)
    {
      GMTrace.o(16262088359936L, 121162);
      return;
    }
    g.oSF.a(633L, 3L, 1L, false);
    String str1 = (String)paramMap.get(".sysmsg.banner.monitorbanner_n.mainframe.url");
    String str2 = (String)paramMap.get(".sysmsg.banner.monitorbanner_n.mainframe.wording");
    long l1 = bf.getLong((String)paramMap.get(".sysmsg.banner.monitorbanner_n.mainframe.duration"), 0L);
    boolean bool1;
    boolean bool2;
    label126:
    String str3;
    String str4;
    long l2;
    boolean bool3;
    if (bf.getInt((String)paramMap.get(".sysmsg.banner.monitorbanner_n.mainframe.autotrigger"), 0) == 1)
    {
      bool1 = true;
      if (bf.getInt((String)paramMap.get(".sysmsg.banner.monitorbanner_n.mainframe.closable"), 0) != 1) {
        break label490;
      }
      bool2 = true;
      str3 = (String)paramMap.get(".sysmsg.banner.monitorbanner_n.chatting.url");
      str4 = (String)paramMap.get(".sysmsg.banner.monitorbanner_n.chatting.wording");
      l2 = bf.getLong((String)paramMap.get(".sysmsg.banner.monitorbanner_n.chatting.duration"), 0L);
      if (bf.getInt((String)paramMap.get(".sysmsg.banner.monitorbanner_n.chatting.autotrigger"), 0) != 1) {
        break label496;
      }
      bool3 = true;
      label195:
      if (bf.getInt((String)paramMap.get(".sysmsg.banner.monitorbanner_n.chatting.closable"), 0) != 1) {
        break label502;
      }
    }
    label490:
    label496:
    label502:
    for (boolean bool4 = true;; bool4 = false)
    {
      if ((!bf.mA(str2)) || (!bf.mA(str4)))
      {
        ap.yY();
        c.vr().a(w.a.uFZ, str4);
        ap.yY();
        c.vr().a(w.a.uGa, str3);
        ap.yY();
        c.vr().a(w.a.uGb, Long.valueOf(l2));
        ap.yY();
        c.vr().a(w.a.uGc, Boolean.valueOf(bool4));
        ap.yY();
        c.vr().a(w.a.uGd, Boolean.valueOf(bool3));
        ap.yY();
        c.vr().a(w.a.uGf, str2);
        ap.yY();
        c.vr().a(w.a.uGg, str1);
        ap.yY();
        c.vr().a(w.a.uGh, Long.valueOf(l1));
        ap.yY();
        c.vr().a(w.a.uGi, Boolean.valueOf(bool2));
        ap.yY();
        c.vr().a(w.a.uGj, Boolean.valueOf(bool1));
        ap.yY();
        c.vr().a(w.a.uGl, Long.valueOf(bf.Nz()));
        ap.yY();
        c.vr().a(w.a.uGe, Boolean.valueOf(false));
        ap.yY();
        c.vr().a(w.a.uGk, Boolean.valueOf(false));
        ap.yY();
        c.vr().a(w.a.uGm, Boolean.valueOf(false));
        Ap();
      }
      GMTrace.o(16262088359936L, 121162);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label126;
      bool3 = false;
      break label195;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Ar();
  }
  
  public static enum b
  {
    static
    {
      GMTrace.i(16260746182656L, 121152);
      hos = new b("Main", 0);
      hot = new b("Chatting", 1);
      hou = new b[] { hos, hot };
      GMTrace.o(16260746182656L, 121152);
    }
    
    private b()
    {
      GMTrace.i(16260611964928L, 121151);
      GMTrace.o(16260611964928L, 121151);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */