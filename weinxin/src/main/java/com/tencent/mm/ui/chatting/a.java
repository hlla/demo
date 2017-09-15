package com.tencent.mm.ui.chatting;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;

public final class a
{
  public static void a(a parama, au paramau)
  {
    GMTrace.i(2249354903552L, 16759);
    PString localPString1 = new PString();
    PString localPString2 = new PString();
    if (a(paramau, localPString1, localPString2)) {
      a(parama, paramau, localPString1.value, localPString2.value);
    }
    GMTrace.o(2249354903552L, 16759);
  }
  
  public static void a(a parama, au paramau, String paramString1, String paramString2)
  {
    GMTrace.i(2249489121280L, 16760);
    String str2 = paramau.field_talker;
    boolean bool = str2.endsWith("@chatroom");
    String str1;
    d locald;
    if (paramau.field_isSend == 1)
    {
      str1 = m.xL();
      locald = new d();
      locald.n("20source_publishid", paramString1 + ",");
      locald.n("21uxinfo", paramString2 + ",");
      locald.n("22clienttime", bf.NA() + ",");
      locald.n("23video_statu", ",");
      paramString1 = new StringBuilder();
      if (paramau.field_type != 62) {
        break label497;
      }
      i = 1;
      label155:
      locald.n("24source_type", i + ",");
      paramString1 = new StringBuilder();
      if (!bool) {
        break label503;
      }
      i = 4;
      label192:
      locald.n("25scene", i + ",");
      locald.n("26action_type", a.a(parama) + ",");
      locald.n("27scene_chatname", str2 + ",");
      locald.n("28scene_username", str1 + ",");
      locald.n("29curr_publishid", ",");
      locald.n("30curr_msgid", paramau.field_msgSvrId + ",");
      locald.n("31curr_favid", "0,");
      locald.n("32elapsed_time", "0,");
      locald.n("33load_time", "0,");
      locald.n("34is_load_complete", "0,");
      locald.n("35destination", "0,");
      parama = new StringBuilder();
      if (!bool) {
        break label509;
      }
    }
    label497:
    label503:
    label509:
    for (int i = j.eC(str2);; i = 0)
    {
      locald.n("36chatroom_membercount", i + ",");
      v.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + locald.JH());
      g.oSF.i(12990, new Object[] { locald });
      GMTrace.o(2249489121280L, 16760);
      return;
      if (bool)
      {
        str1 = ay.gi(paramau.field_content);
        break;
      }
      str1 = str2;
      break;
      i = 2;
      break label155;
      i = 3;
      break label192;
    }
  }
  
  public static void a(c paramc, d paramd, au paramau, int paramInt)
  {
    GMTrace.i(2249623339008L, 16761);
    Object localObject2 = new PString();
    Object localObject1 = new PString();
    boolean bool;
    d locald;
    if (a(paramau, (PString)localObject2, (PString)localObject1))
    {
      String str1 = ((PString)localObject2).value;
      String str2 = ((PString)localObject1).value;
      localObject2 = paramau.field_talker;
      bool = ((String)localObject2).endsWith("@chatroom");
      if (paramau.field_isSend != 1) {
        break label528;
      }
      localObject1 = m.xL();
      locald = new d();
      locald.n("20source_publishid", str1 + ",");
      locald.n("21uxinfo", str2 + ",");
      locald.n("22clienttime", bf.NA() + ",");
      locald.n("23video_statu", d.a(paramd) + ",");
      paramd = new StringBuilder();
      if (paramau.field_type != 62) {
        break label552;
      }
      i = 1;
      label220:
      locald.n("24source_type", i + ",");
      paramd = new StringBuilder();
      if (!bool) {
        break label558;
      }
      i = 4;
      label257:
      locald.n("25scene", i + ",");
      locald.n("26action_type", c.a(paramc) + ",");
      locald.n("27scene_chatname", (String)localObject2 + ",");
      locald.n("28scene_username", (String)localObject1 + ",");
      locald.n("29curr_publishid", ",");
      locald.n("30curr_msgid", paramau.field_msgSvrId + ",");
      locald.n("31curr_favid", "0,");
      paramc = new StringBuilder();
      if (!bool) {
        break label564;
      }
    }
    label528:
    label552:
    label558:
    label564:
    for (int i = j.eC((String)localObject2);; i = 0)
    {
      locald.n("32chatroom_membercount", i + ",");
      locald.n("33chatroom_toMemberCount", paramInt + ",");
      v.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + locald.JH());
      g.oSF.i(12991, new Object[] { locald });
      GMTrace.o(2249623339008L, 16761);
      return;
      if (bool)
      {
        localObject1 = ay.gi(paramau.field_content);
        break;
      }
      localObject1 = localObject2;
      break;
      i = 2;
      break label220;
      i = 3;
      break label257;
    }
  }
  
  static boolean a(au paramau, PString paramPString1, PString paramPString2)
  {
    GMTrace.i(2249757556736L, 16762);
    if (paramau.field_type == 62)
    {
      paramau = t.lI(paramau.field_imgPath);
      if (paramau == null)
      {
        GMTrace.o(2249757556736L, 16762);
        return false;
      }
      paramau = paramau.iae;
      if ((paramau == null) || (bf.mA(paramau.hjz)))
      {
        GMTrace.o(2249757556736L, 16762);
        return false;
      }
      paramPString1.value = paramau.hjA;
      paramPString2.value = paramau.hjz;
      GMTrace.o(2249757556736L, 16762);
      return true;
    }
    if (paramau.field_type == 49)
    {
      boolean bool = o.dH(paramau.field_talker);
      String str2 = paramau.field_content;
      String str1 = str2;
      if (bool)
      {
        str1 = str2;
        if (paramau.field_content != null)
        {
          str1 = str2;
          if (paramau.field_isSend == 0) {
            str1 = ay.gj(paramau.field_content);
          }
        }
      }
      paramau = f.a.ek(str1);
      if ((paramau == null) || (paramau.type != 4) || (bf.mA(paramau.hjt)))
      {
        GMTrace.o(2249757556736L, 16762);
        return false;
      }
      paramPString1.value = paramau.hjA;
      paramPString2.value = paramau.hjz;
      GMTrace.o(2249757556736L, 16762);
      return true;
    }
    GMTrace.o(2249757556736L, 16762);
    return false;
  }
  
  public static enum a
  {
    private int value;
    
    static
    {
      GMTrace.i(2268548038656L, 16902);
      vva = new a("PlayIcon", 0, 1);
      vvb = new a("EnterFullScreen", 1, 2);
      vvc = new a("EnterCompleteVideo", 2, 3);
      vvd = new a("DetailInVideo", 3, 4);
      vve = new a("LeavelFullScreen", 4, 5);
      vvf = new a("LeaveCompleteVideo", 5, 6);
      vvg = new a("SightLoaded", 6, 7);
      vvh = new a[] { vva, vvb, vvc, vvd, vve, vvf, vvg };
      GMTrace.o(2268548038656L, 16902);
    }
    
    private a(int paramInt)
    {
      GMTrace.i(2268279603200L, 16900);
      this.value = 0;
      this.value = paramInt;
      GMTrace.o(2268279603200L, 16900);
    }
  }
  
  public static enum b
  {
    public int value;
    
    static
    {
      GMTrace.i(2387196510208L, 17786);
      vvi = new b("Sight", 0, 1);
      vvj = new b("AdUrl", 1, 2);
      vvk = new b("Chat", 2, 3);
      vvl = new b("TalkChat", 3, 4);
      vvm = new b("Fav", 4, 5);
      vvn = new b[] { vvi, vvj, vvk, vvl, vvm };
      GMTrace.o(2387196510208L, 17786);
    }
    
    private b(int paramInt)
    {
      GMTrace.i(2387062292480L, 17785);
      this.value = 0;
      this.value = paramInt;
      GMTrace.o(2387062292480L, 17785);
    }
  }
  
  public static enum c
  {
    private int value;
    
    static
    {
      GMTrace.i(2128558948352L, 15859);
      vvo = new c("Fav", 0, 1);
      vvp = new c("Chat", 1, 2);
      vvq = new c("Chatroom", 2, 3);
      vvr = new c("Sns", 3, 4);
      vvs = new c[] { vvo, vvp, vvq, vvr };
      GMTrace.o(2128558948352L, 15859);
    }
    
    private c(int paramInt)
    {
      GMTrace.i(2128290512896L, 15857);
      this.value = 0;
      this.value = paramInt;
      GMTrace.o(2128290512896L, 15857);
    }
  }
  
  public static enum d
  {
    private int value;
    
    static
    {
      GMTrace.i(2232309252096L, 16632);
      vvt = new d("Samll", 0, 1);
      vvu = new d("Full", 1, 2);
      vvv = new d("Complete", 2, 3);
      vvw = new d[] { vvt, vvu, vvv };
      GMTrace.o(2232309252096L, 16632);
    }
    
    private d(int paramInt)
    {
      GMTrace.i(2232040816640L, 16630);
      this.value = 0;
      this.value = paramInt;
      GMTrace.o(2232040816640L, 16630);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */