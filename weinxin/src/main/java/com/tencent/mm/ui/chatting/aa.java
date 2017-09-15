package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.t.f.a;
import com.tencent.mm.t.k;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.q;
import com.tencent.mm.u.q.b;
import com.tencent.mm.x.i;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class aa
{
  public static void a(Context paramContext, String paramString, au paramau)
  {
    GMTrace.i(2509468860416L, 18697);
    if (!a(paramContext, paramString, paramau, "emoji"))
    {
      GMTrace.o(2509468860416L, 18697);
      return;
    }
    String str = aj.RC(paramau.field_content).fFN;
    if ((str == null) || (str.endsWith("-1"))) {}
    for (paramau = paramau.field_imgPath;; paramau = str)
    {
      if (paramau == null)
      {
        v.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
        GMTrace.o(2509468860416L, 18697);
        return;
      }
      ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().l(paramContext, paramString, paramau);
      GMTrace.o(2509468860416L, 18697);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, au paramau, boolean paramBoolean)
  {
    GMTrace.i(2509871513600L, 18700);
    if (!a(paramContext, paramString, paramau, "text"))
    {
      GMTrace.o(2509871513600L, 18700);
      return;
    }
    String str = q(paramau.field_content, paramau.field_isSend, paramBoolean);
    paramContext = str;
    if (paramau.bMm())
    {
      paramContext = q(paramau.field_transContent, paramau.field_isSend, paramBoolean);
      paramContext = str + "\n\n" + paramContext;
    }
    if ((paramContext == null) || (paramContext.equals("")))
    {
      v.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
      GMTrace.o(2509871513600L, 18700);
      return;
    }
    com.tencent.mm.plugin.messenger.a.d.aJP().A(paramString, paramContext, com.tencent.mm.u.o.fG(paramString));
    GMTrace.o(2509871513600L, 18700);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(2510274166784L, 18703);
    try
    {
      au localau = new au();
      localau.setContent(paramString2);
      localau.dw(paramInt);
      paramInt = paramString2.indexOf("<msg>");
      String str = paramString2;
      if (paramInt > 0)
      {
        str = paramString2;
        if (paramInt < paramString2.length()) {
          str = paramString2.substring(paramInt).trim();
        }
      }
      paramString2 = bg.q(str, "msg");
      if ((paramString2 != null) && (paramString2.size() > 0)) {
        localau.cJ(av.ae(paramString2));
      }
      b(paramContext, paramString1, localau, paramBoolean);
      GMTrace.o(2510274166784L, 18703);
      return;
    }
    catch (Exception paramContext)
    {
      v.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
      v.e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
      GMTrace.o(2510274166784L, 18703);
    }
  }
  
  static boolean a(Context paramContext, String paramString1, au paramau, String paramString2)
  {
    GMTrace.i(2509334642688L, 18696);
    if (paramContext == null)
    {
      v.w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", new Object[] { paramString2 });
      GMTrace.o(2509334642688L, 18696);
      return false;
    }
    if (bf.mA(paramString1))
    {
      v.w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", new Object[] { paramString2 });
      GMTrace.o(2509334642688L, 18696);
      return false;
    }
    if (paramau == null)
    {
      v.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", new Object[] { paramString2 });
      GMTrace.o(2509334642688L, 18696);
      return false;
    }
    GMTrace.o(2509334642688L, 18696);
    return true;
  }
  
  public static boolean a(List<au> paramList, dx paramdx)
  {
    GMTrace.i(14965947760640L, 111505);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      v.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      GMTrace.o(14965947760640L, 111505);
      return false;
    }
    if (paramList.size() == 1)
    {
      paramList = (au)paramList.get(0);
      if ((al(paramList)) || (paramList.bLP()) || (ac(paramList)) || (ae(paramList)) || (af(paramList)) || (paramList.field_type == -1879048186) || (paramList.field_type == 318767153) || (ak(paramList)) || (ag(paramList)) || (am(paramList)) || (aj(paramList)) || (ah(paramList)))
      {
        GMTrace.o(14965947760640L, 111505);
        return false;
      }
      GMTrace.o(14965947760640L, 111505);
      return true;
    }
    paramList = paramList.iterator();
    boolean bool = true;
    int i;
    if (paramList.hasNext())
    {
      au localau = (au)paramList.next();
      if ((!localau.bLP()) && (!ac(localau)) && (!ae(localau)) && (!af(localau)) && (localau.field_type != -1879048186) && (!ak(localau)) && (!ag(localau)))
      {
        if (localau == null) {
          break label436;
        }
        f.a locala = f.a.ek(localau.field_content);
        if ((locala == null) || (locala.type != 19)) {
          break label436;
        }
        if ((locala.hhG == null) || (!locala.hhG.contains("<recordxml>"))) {
          break label431;
        }
        i = 1;
        label311:
        if ((i == 0) || ((paramdx != null) && (paramdx.bUv())))
        {
          if (localau == null) {
            break label441;
          }
          locala = f.a.ek(localau.field_content);
          if ((locala == null) || (locala.type != 24)) {
            break label441;
          }
          i = 1;
          label360:
          if (((i == 0) || ((paramdx != null) && (paramdx.bUv()))) && (localau.field_type != 318767153) && (!al(localau)) && (!am(localau)) && (!aj(localau)) && (!ah(localau))) {
            break label456;
          }
        }
      }
      paramList.remove();
      bool = false;
    }
    label431:
    label436:
    label441:
    label456:
    for (;;)
    {
      break;
      i = 0;
      break label311;
      i = 0;
      break label311;
      i = 0;
      break label360;
      GMTrace.o(14965947760640L, 111505);
      return bool;
    }
  }
  
  public static boolean ac(au paramau)
  {
    GMTrace.i(2506918723584L, 18678);
    if (paramau == null)
    {
      v.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
      GMTrace.o(2506918723584L, 18678);
      return true;
    }
    if (paramau.bMe())
    {
      aj localaj = new aj(paramau.field_content);
      paramau = f.a.B(paramau.field_content, paramau.field_reserved);
      if (paramau != null) {
        break label225;
      }
      paramau = new f.a();
      paramau.hhi = localaj.fFN;
    }
    label225:
    for (;;)
    {
      for (paramau = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(paramau.hhi); (paramau != null) && ((paramau.field_catalog == com.tencent.mm.storage.a.c.uJj) || ((!bf.mA(paramau.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(paramau.field_groupId)))); paramau = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(paramau.field_imgPath))
      {
        GMTrace.o(2506918723584L, 18678);
        return false;
      }
      if ((paramau != null) && (paramau.bNl()))
      {
        GMTrace.o(2506918723584L, 18678);
        return true;
      }
      GMTrace.o(2506918723584L, 18678);
      return false;
    }
  }
  
  public static boolean ad(au paramau)
  {
    GMTrace.i(2507052941312L, 18679);
    if (paramau.bMe())
    {
      aj localaj = new aj(paramau.field_content);
      paramau = f.a.B(paramau.field_content, paramau.field_reserved);
      if (paramau != null) {
        break label107;
      }
      paramau = new f.a();
      paramau.hhi = localaj.fFN;
    }
    label107:
    for (;;)
    {
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(paramau.hhi) == null)
      {
        GMTrace.o(2507052941312L, 18679);
        return false;
      }
      GMTrace.o(2507052941312L, 18679);
      return true;
    }
  }
  
  public static boolean ae(au paramau)
  {
    GMTrace.i(2507187159040L, 18680);
    if (paramau == null)
    {
      v.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
      GMTrace.o(2507187159040L, 18680);
      return true;
    }
    if (paramau.field_isSend == 0) {}
    for (paramau = ay.gj(paramau.field_content);; paramau = paramau.field_content)
    {
      paramau = f.a.ek(paramau);
      if (paramau != null) {
        break;
      }
      v.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
      GMTrace.o(2507187159040L, 18680);
      return false;
    }
    paramau = g.aJ(paramau.appId, false);
    if ((paramau != null) && (paramau.bCM()))
    {
      GMTrace.o(2507187159040L, 18680);
      return true;
    }
    GMTrace.o(2507187159040L, 18680);
    return false;
  }
  
  public static boolean af(au paramau)
  {
    GMTrace.i(2507321376768L, 18681);
    if (paramau.field_type == 419430449)
    {
      GMTrace.o(2507321376768L, 18681);
      return true;
    }
    GMTrace.o(2507321376768L, 18681);
    return false;
  }
  
  public static boolean ag(au paramau)
  {
    GMTrace.i(2507455594496L, 18682);
    if ((paramau.field_type == 436207665) || (paramau.field_type == 469762097))
    {
      GMTrace.o(2507455594496L, 18682);
      return true;
    }
    GMTrace.o(2507455594496L, 18682);
    return false;
  }
  
  public static boolean ah(au paramau)
  {
    GMTrace.i(14305328103424L, 106583);
    if (paramau == null)
    {
      v.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
      GMTrace.o(14305328103424L, 106583);
      return true;
    }
    if (paramau.field_isSend == 0) {}
    for (paramau = ay.gj(paramau.field_content);; paramau = paramau.field_content)
    {
      paramau = f.a.ek(paramau);
      if (paramau != null) {
        break;
      }
      v.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
      GMTrace.o(14305328103424L, 106583);
      return false;
    }
    if ((paramau.type == 33) && (paramau.hjE == 3))
    {
      GMTrace.o(14305328103424L, 106583);
      return true;
    }
    GMTrace.o(14305328103424L, 106583);
    return false;
  }
  
  public static boolean ai(au paramau)
  {
    GMTrace.i(2507858247680L, 18685);
    if (paramau != null)
    {
      paramau = f.a.ek(paramau.field_content);
      if (paramau == null)
      {
        GMTrace.o(2507858247680L, 18685);
        return false;
      }
      if ((paramau.type == 6) || (paramau.type == 5) || (paramau.type == 19))
      {
        GMTrace.o(2507858247680L, 18685);
        return true;
      }
    }
    GMTrace.o(2507858247680L, 18685);
    return false;
  }
  
  public static boolean aj(au paramau)
  {
    GMTrace.i(2507992465408L, 18686);
    if ((paramau == null) || ((!paramau.bLN()) && (!paramau.bLO())))
    {
      GMTrace.o(2507992465408L, 18686);
      return false;
    }
    paramau = ((a)com.tencent.mm.kernel.h.h(a.class)).rR(paramau.field_content);
    if (paramau == null)
    {
      v.w("MicroMsg.ChattingEditModeLogic", "isBizMsgForbidForward reader is null");
      GMTrace.o(2507992465408L, 18686);
      return false;
    }
    if (paramau.hkd == 1)
    {
      GMTrace.o(2507992465408L, 18686);
      return true;
    }
    GMTrace.o(2507992465408L, 18686);
    return false;
  }
  
  static boolean ak(au paramau)
  {
    GMTrace.i(2508126683136L, 18687);
    if (paramau != null)
    {
      paramau = f.a.ek(paramau.field_content);
      if ((paramau != null) && (paramau.type == 16))
      {
        GMTrace.o(2508126683136L, 18687);
        return true;
      }
      if ((paramau != null) && (paramau.type == 34))
      {
        GMTrace.o(2508126683136L, 18687);
        return true;
      }
    }
    GMTrace.o(2508126683136L, 18687);
    return false;
  }
  
  static boolean al(au paramau)
  {
    GMTrace.i(2508260900864L, 18688);
    if (!paramau.bLY())
    {
      GMTrace.o(2508260900864L, 18688);
      return false;
    }
    ap.yY();
    paramau = com.tencent.mm.u.c.wT().At(paramau.field_content);
    if ((paramau == null) || (bf.mA(paramau.rTh)))
    {
      GMTrace.o(2508260900864L, 18688);
      return true;
    }
    if (com.tencent.mm.u.o.eV(paramau.rTh))
    {
      GMTrace.o(2508260900864L, 18688);
      return false;
    }
    GMTrace.o(2508260900864L, 18688);
    return true;
  }
  
  private static boolean am(au paramau)
  {
    GMTrace.i(2508395118592L, 18689);
    if ((paramau != null) && (paramau.axH()))
    {
      paramau = f.a.ek(paramau.field_content);
      if ((paramau != null) && (paramau.type == 6) && ((paramau.hhk != 0) || (paramau.hhg > 26214400)))
      {
        GMTrace.o(2508395118592L, 18689);
        return true;
      }
    }
    GMTrace.o(2508395118592L, 18689);
    return false;
  }
  
  public static boolean an(au paramau)
  {
    GMTrace.i(16267322851328L, 121201);
    if ((paramau != null) && (paramau.axH()))
    {
      paramau = f.a.ek(paramau.field_content);
      if ((paramau != null) && (paramau.type == 6))
      {
        GMTrace.o(16267322851328L, 121201);
        return true;
      }
    }
    GMTrace.o(16267322851328L, 121201);
    return false;
  }
  
  public static void b(Context paramContext, String paramString, au paramau)
  {
    GMTrace.i(2509603078144L, 18698);
    if (!a(paramContext, paramString, paramau, "image"))
    {
      GMTrace.o(2509603078144L, 18698);
      return;
    }
    Object localObject = null;
    if (paramau.field_msgId > 0L) {
      localObject = com.tencent.mm.ah.n.GT().aj(paramau.field_msgId);
    }
    if (((localObject == null) || (((com.tencent.mm.ah.d)localObject).hEG <= 0L)) && (paramau.field_msgSvrId > 0L)) {}
    for (paramau = com.tencent.mm.ah.n.GT().ai(paramau.field_msgSvrId);; paramau = (au)localObject)
    {
      if (paramau == null)
      {
        GMTrace.o(2509603078144L, 18698);
        return;
      }
      int j = 0;
      int i = j;
      if (paramau.GC())
      {
        i = j;
        if (!com.tencent.mm.ah.e.a(paramau).hEH.startsWith("SERVERID://")) {
          i = 1;
        }
      }
      localObject = com.tencent.mm.ah.n.GT().m(com.tencent.mm.ah.e.c(paramau), "", "");
      String str = com.tencent.mm.ah.n.GT().m(paramau.hEJ, "th_", "");
      if (!bf.mA((String)localObject)) {
        com.tencent.mm.plugin.messenger.a.d.aJP().b(paramContext, paramString, (String)localObject, i, paramau.hER, str);
      }
      GMTrace.o(2509603078144L, 18698);
      return;
    }
  }
  
  public static void b(Context paramContext, String paramString, au paramau, boolean paramBoolean)
  {
    GMTrace.i(2510005731328L, 18701);
    if (!a(paramContext, paramString, paramau, "appmsg"))
    {
      GMTrace.o(2510005731328L, 18701);
      return;
    }
    if (paramContext == null)
    {
      v.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
      GMTrace.o(2510005731328L, 18701);
      return;
    }
    if (paramau == null)
    {
      v.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
      GMTrace.o(2510005731328L, 18701);
      return;
    }
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      GMTrace.o(2510005731328L, 18701);
      return;
    }
    paramContext = com.tencent.mm.ah.n.GT().b(paramau.field_imgPath, false, false);
    if ((!u.mA(paramContext)) && (!paramContext.endsWith("hd")) && (FileOp.aO(paramContext + "hd"))) {
      paramContext = paramContext + "hd";
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = ((a)com.tencent.mm.kernel.h.h(a.class)).rR(paramau.field_content);
        localObject2 = ((k)localObject1).hkc;
        if ((localObject2 == null) || (((List)localObject2).size() <= 0))
        {
          localObject2 = null;
          localObject1 = localObject2;
          if (paramau != null) {
            if ((!paramau.axH()) && (!paramau.bLN()))
            {
              localObject1 = localObject2;
              if (!paramau.bLO()) {}
            }
            else
            {
              localObject1 = q.fQ(paramau.field_msgSvrId);
              localObject2 = q.yC().n((String)localObject1, true);
              ((q.b)localObject2).l("prePublishId", "msg_" + paramau.field_msgSvrId);
              ((q.b)localObject2).l("preUsername", ag.a(paramau, paramBoolean, false));
              ((q.b)localObject2).l("preChatName", paramau.field_talker);
              ((q.b)localObject2).l("preMsgIndex", Integer.valueOf(0));
              ((q.b)localObject2).l("sendAppMsgScene", Integer.valueOf(1));
              ((com.tencent.mm.plugin.sns.b.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.sns.b.h.class)).a("adExtStr", (q.b)localObject2, paramau);
            }
          }
          com.tencent.mm.plugin.messenger.a.d.aJP().a(paramString, bf.readFromFile(paramContext), bf.PW(paramau.field_content), (String)localObject1);
          GMTrace.o(2510005731328L, 18701);
          return;
        }
      }
      catch (Exception paramContext)
      {
        v.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
        v.e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
        GMTrace.o(2510005731328L, 18701);
        return;
      }
      paramau = ((List)localObject2).iterator();
      while (paramau.hasNext())
      {
        Object localObject3 = (com.tencent.mm.t.l)paramau.next();
        localObject2 = new f.a();
        ((f.a)localObject2).title = ((com.tencent.mm.t.l)localObject3).title;
        ((f.a)localObject2).description = ((com.tencent.mm.t.l)localObject3).hkk;
        ((f.a)localObject2).action = "view";
        ((f.a)localObject2).type = 5;
        ((f.a)localObject2).url = ((com.tencent.mm.t.l)localObject3).url;
        ((f.a)localObject2).fUH = ((k)localObject1).fUH;
        ((f.a)localObject2).fUI = ((k)localObject1).fUI;
        ((f.a)localObject2).gxt = ((k)localObject1).gxt;
        ((f.a)localObject2).thumburl = ((com.tencent.mm.t.l)localObject3).hki;
        if ((bf.mA(((f.a)localObject2).thumburl)) && (!bf.mA(((f.a)localObject2).fUH)))
        {
          localObject3 = com.tencent.mm.x.n.Bm().hs(((f.a)localObject2).fUH);
          if (localObject3 != null) {
            ((f.a)localObject2).thumburl = ((com.tencent.mm.x.h)localObject3).Bs();
          }
        }
        localObject2 = f.a.a((f.a)localObject2, null, null);
        com.tencent.mm.plugin.messenger.a.d.aJP().a(paramString, bf.readFromFile(paramContext), bf.PW((String)localObject2), null);
      }
      GMTrace.o(2510005731328L, 18701);
      return;
    }
  }
  
  public static void b(com.tencent.mm.storage.a.c paramc, String paramString)
  {
    GMTrace.i(2510408384512L, 18704);
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    Object localObject = new StringBuilder();
    ap.yY();
    localObject = com.tencent.mm.u.c.xi() + paramc.EQ();
    if (com.tencent.mm.a.e.aN((String)localObject + "_thumb") > 0)
    {
      int i = com.tencent.mm.a.e.aN((String)localObject + "_thumb");
      localWXMediaMessage.thumbData = com.tencent.mm.a.e.c((String)localObject + "_thumb", 0, i);
    }
    for (;;)
    {
      localWXMediaMessage.mediaObject = new WXEmojiObject((String)localObject);
      com.tencent.mm.pluginsdk.model.app.l.a(localWXMediaMessage, paramc.field_app_id, null, paramString, 1, paramc.EQ());
      GMTrace.o(2510408384512L, 18704);
      return;
      try
      {
        FileInputStream localFileInputStream = new FileInputStream((String)localObject);
        localWXMediaMessage.setThumbImage(BackwardSupportUtil.b.a(localFileInputStream, 1.0F));
        localFileInputStream.close();
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.ChattingEditModeLogic", localException, "", new Object[0]);
        v.e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
      }
    }
  }
  
  public static List<String> bTP()
  {
    GMTrace.i(2509200424960L, 18695);
    Object localObject1 = w.DH().fw(25);
    Object localObject2 = w.DH();
    Object localObject3 = new ArrayList();
    Object localObject4 = new StringBuilder();
    com.tencent.mm.modelbiz.d.a((StringBuilder)localObject4);
    com.tencent.mm.modelbiz.d.c((StringBuilder)localObject4);
    com.tencent.mm.modelbiz.d.d((StringBuilder)localObject4);
    com.tencent.mm.modelbiz.d.a((StringBuilder)localObject4, true);
    ((StringBuilder)localObject4).append(" order by ");
    ((StringBuilder)localObject4).append(com.tencent.mm.modelbiz.d.Dk());
    localObject4 = ((StringBuilder)localObject4).toString();
    v.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", new Object[] { localObject4 });
    localObject2 = ((com.tencent.mm.modelbiz.d)localObject2).rawQuery((String)localObject4, new String[0]);
    if (localObject2 != null)
    {
      if (((Cursor)localObject2).moveToFirst()) {
        do
        {
          ((ArrayList)localObject3).add(((Cursor)localObject2).getString(0));
        } while (((Cursor)localObject2).moveToNext());
      }
      ((Cursor)localObject2).close();
    }
    localObject2 = new HashMap();
    localObject3 = ((List)localObject3).iterator();
    String str;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      str = com.tencent.mm.modelbiz.e.hW((String)localObject4).CO();
      if (!bf.mA(str)) {
        ((HashMap)localObject2).put(str, localObject4);
      }
    }
    localObject3 = new LinkedList();
    localObject4 = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      str = (String)((Iterator)localObject1).next();
      if (com.tencent.mm.modelbiz.e.hZ(str))
      {
        if (com.tencent.mm.modelbiz.e.ie(str))
        {
          str = com.tencent.mm.modelbiz.e.hW(str).field_enterpriseFather;
          if ((!((List)localObject4).contains(str)) && (com.tencent.mm.modelbiz.e.ib(str)))
          {
            ((List)localObject4).add(str);
            str = (String)((HashMap)localObject2).get(str);
            if (!bf.mA(str)) {
              ((List)localObject4).add(str);
            }
          }
        }
      }
      else {
        ((List)localObject3).add(str);
      }
    }
    localObject1 = ((HashMap)localObject2).values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if ((!bf.mA((String)localObject2)) && (!((List)localObject4).contains(localObject2))) {
        ((List)localObject4).add(localObject2);
      }
    }
    ((List)localObject3).addAll((Collection)localObject4);
    v.d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
    GMTrace.o(2509200424960L, 18695);
    return (List<String>)localObject3;
  }
  
  public static List<String> bTQ()
  {
    GMTrace.i(14663421001728L, 109251);
    Object localObject = w.DH().fw(25);
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!com.tencent.mm.modelbiz.e.hZ(str)) {
        localLinkedList.add(str);
      }
    }
    v.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    GMTrace.o(14663421001728L, 109251);
    return localLinkedList;
  }
  
  public static void c(Context paramContext, String paramString, au paramau)
  {
    GMTrace.i(2509737295872L, 18699);
    if ((!a(paramContext, paramString, paramau, "video")) || (paramau == null))
    {
      GMTrace.o(2509737295872L, 18699);
      return;
    }
    if ((paramau != null) && (paramau.bMc()) && (t.lK(paramau.field_imgPath)))
    {
      GMTrace.o(2509737295872L, 18699);
      return;
    }
    paramContext = t.lI(paramau.field_imgPath);
    String str1 = paramau.field_imgPath;
    int i = paramContext.hZZ;
    int j = paramContext.hZV;
    paramContext = paramContext.Li();
    int k = paramau.field_type;
    v.d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", new Object[] { str1, paramString, Integer.valueOf(i), Integer.valueOf(j) });
    paramau = s.lv(m.xL());
    com.tencent.mm.modelvideo.o.KW();
    String str2 = s.lw(str1);
    String str3 = s.lw(paramau);
    str1 = s.lx(str1);
    String str4 = s.lx(paramau);
    v.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", new Object[] { str2, str3, str1, str4 });
    com.tencent.mm.sdk.platformtools.j.p(str2, str3, false);
    com.tencent.mm.sdk.platformtools.j.p(str1, str4, false);
    t.a(paramau, j, paramString, null, i, paramContext, k);
    t.lD(paramau);
    GMTrace.o(2509737295872L, 18699);
  }
  
  public static void c(Context paramContext, String paramString, au paramau, boolean paramBoolean)
  {
    GMTrace.i(2510139949056L, 18702);
    if (!a(paramContext, paramString, paramau, "location"))
    {
      GMTrace.o(2510139949056L, 18702);
      return;
    }
    paramContext = q(paramau.field_content, paramau.field_isSend, paramBoolean);
    com.tencent.mm.plugin.messenger.a.d.aJP().A(paramString, paramContext, 48);
    GMTrace.o(2510139949056L, 18702);
  }
  
  public static boolean cu(List<au> paramList)
  {
    GMTrace.i(2507589812224L, 18683);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      v.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to brand msg error, selected item empty");
      GMTrace.o(2507589812224L, 18683);
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      au localau = (au)paramList.next();
      if ((localau.bLP()) || (ac(localau)) || (localau.bLY()) || (ae(localau)) || (af(localau)) || (localau.field_type == -1879048186) || (ak(localau)) || (ag(localau)) || (aj(localau)) || (ah(localau)) || (an(localau)))
      {
        GMTrace.o(2507589812224L, 18683);
        return true;
      }
    }
    GMTrace.o(2507589812224L, 18683);
    return false;
  }
  
  public static int cv(List<au> paramList)
  {
    GMTrace.i(2508529336320L, 18690);
    if (paramList == null)
    {
      v.w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
      GMTrace.o(2508529336320L, 18690);
      return 0;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      au localau = (au)paramList.next();
      if ((!localau.bLP()) && (!ac(localau)) && (!localau.bLZ()) && (!ae(localau)) && (!af(localau)) && (!ag(localau))) {
        break label120;
      }
      i += 1;
    }
    label120:
    for (;;)
    {
      break;
      GMTrace.o(2508529336320L, 18690);
      return i;
    }
  }
  
  public static boolean cw(List<au> paramList)
  {
    GMTrace.i(2508663554048L, 18691);
    if (paramList == null)
    {
      v.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
      GMTrace.o(2508663554048L, 18691);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    label414:
    label415:
    for (;;)
    {
      au localau;
      if (localIterator.hasNext())
      {
        localau = (au)localIterator.next();
        if ((localau.bLX()) || (localau.bMf()))
        {
          paramList = null;
          if (localau.field_msgId > 0L) {
            paramList = com.tencent.mm.ah.n.GT().aj(localau.field_msgId);
          }
          if (((paramList != null) && (paramList.hEG > 0L)) || (localau.field_msgSvrId <= 0L)) {
            break label414;
          }
          paramList = com.tencent.mm.ah.n.GT().ai(localau.field_msgSvrId);
        }
      }
      for (;;)
      {
        if ((paramList == null) || ((paramList.offset >= paramList.hrb) && (paramList.hrb != 0))) {
          break label415;
        }
        GMTrace.o(2508663554048L, 18691);
        return true;
        if (localau.bMb())
        {
          paramList = com.tencent.mm.modelvideo.o.KW().lt(localau.field_imgPath);
          if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
            break;
          }
          GMTrace.o(2508663554048L, 18691);
          return true;
        }
        if (localau.bMe())
        {
          if (ad(localau)) {
            break;
          }
          GMTrace.o(2508663554048L, 18691);
          return true;
        }
        if (localau.axH())
        {
          paramList = f.a.B(localau.field_content, localau.field_content);
          if (paramList == null)
          {
            GMTrace.o(2508663554048L, 18691);
            return true;
          }
          switch (paramList.type)
          {
          default: 
            break;
          case 6: 
            paramList = an.abF().LV(paramList.fCN);
            if (paramList == null)
            {
              GMTrace.o(2508663554048L, 18691);
              return true;
            }
            if (new File(paramList.field_fileFullPath).exists()) {
              break;
            }
            GMTrace.o(2508663554048L, 18691);
            return true;
          }
        }
        if (!localau.bMc()) {
          break;
        }
        paramList = t.lI(localau.field_imgPath);
        if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
          break;
        }
        GMTrace.o(2508663554048L, 18691);
        return true;
        GMTrace.o(2508663554048L, 18691);
        return false;
      }
    }
  }
  
  public static boolean cx(List<au> paramList)
  {
    GMTrace.i(2508797771776L, 18692);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      GMTrace.o(2508797771776L, 18692);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      au localau = (au)paramList.next();
      if ((localau.bMb()) && (com.tencent.mm.pluginsdk.model.j.LR(localau.field_imgPath)))
      {
        GMTrace.o(2508797771776L, 18692);
        return true;
      }
    }
    GMTrace.o(2508797771776L, 18692);
    return false;
  }
  
  public static boolean cy(List<au> paramList)
  {
    GMTrace.i(2508931989504L, 18693);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      GMTrace.o(2508931989504L, 18693);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((au)paramList.next()).bMc())
      {
        GMTrace.o(2508931989504L, 18693);
        return true;
      }
    }
    GMTrace.o(2508931989504L, 18693);
    return false;
  }
  
  public static String q(String paramString, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(2509066207232L, 18694);
    String str = paramString;
    if (paramBoolean)
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = ay.gj(paramString);
        }
      }
    }
    GMTrace.o(2509066207232L, 18694);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */