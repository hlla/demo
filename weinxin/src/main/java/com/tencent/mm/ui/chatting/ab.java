package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.lz.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.t.k;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.q;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.x.i;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ab
{
  public static a vzl;
  
  static
  {
    GMTrace.i(2512555868160L, 18720);
    vzl = new a();
    GMTrace.o(2512555868160L, 18720);
  }
  
  public static void a(final Context paramContext, List<au> paramList, final boolean paramBoolean, final String paramString, final dx paramdx)
  {
    GMTrace.i(2511213690880L, 18710);
    bTR();
    if (paramContext == null)
    {
      v.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
      GMTrace.o(2511213690880L, 18710);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      v.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
      GMTrace.o(2511213690880L, 18710);
      return;
    }
    if (((paramdx != null) && (paramdx.bUv())) || ((paramList.size() == 1) && (!aa.a(paramList, paramdx))))
    {
      com.tencent.mm.ui.base.g.b(paramContext, paramContext.getString(R.l.esB), "", paramContext.getString(R.l.dIs), paramContext.getString(R.l.dGk), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2178622160896L, 16232);
          paramAnonymousDialogInterface = this.vzm;
          if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.isEmpty())) {
            v.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
          }
          label34:
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            if (paramAnonymousInt == 0) {
              break label181;
            }
            v.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
            if (paramdx != null) {
              paramdx.b(dx.a.vLr);
            }
            GMTrace.o(2178622160896L, 16232);
            return;
            paramAnonymousDialogInterface = paramAnonymousDialogInterface.iterator();
            if (!paramAnonymousDialogInterface.hasNext()) {
              break label34;
            }
            au localau = (au)paramAnonymousDialogInterface.next();
            if (aa.ah(localau)) {
              break label34;
            }
            if ((localau.bLP()) || (aa.ac(localau)) || (aa.ae(localau)) || (aa.al(localau)) || (aa.af(localau)) || (localau.field_type == -1879048186) || (aa.ak(localau)) || (aa.ag(localau)) || (localau.field_type == 318767153)) {
              break;
            }
          }
          label181:
          ab.b(paramContext, this.vzm, paramBoolean, paramString, paramdx);
          GMTrace.o(2178622160896L, 16232);
        }
      }, null);
      GMTrace.o(2511213690880L, 18710);
      return;
    }
    label169:
    int i;
    Iterator localIterator;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      v.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      break label253;
      i = 1;
      if (i == 0) {
        break label575;
      }
      v.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
      if ((paramdx == null) || ((!paramdx.bUv()) && (paramList.size() != 1))) {
        break label584;
      }
      com.tencent.mm.ui.base.g.a(paramContext, paramContext.getString(R.l.egF), paramContext.getString(R.l.dIG), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2399678758912L, 17879);
          GMTrace.o(2399678758912L, 17879);
        }
      });
      GMTrace.o(2511213690880L, 18710);
    }
    else
    {
      localIterator = paramList.iterator();
    }
    label253:
    label392:
    label569:
    label573:
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label169;
      }
      au localau = (au)localIterator.next();
      Object localObject3 = null;
      if (localau.bMj()) {
        break;
      }
      Object localObject1;
      Object localObject2;
      if (localau.bLX())
      {
        localObject1 = null;
        if (localau.field_msgId > 0L) {
          localObject1 = com.tencent.mm.ah.n.GT().aj(localau.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.ah.d)localObject1).hEG > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (localau.field_msgSvrId > 0L) {
            localObject2 = com.tencent.mm.ah.n.GT().ai(localau.field_msgSvrId);
          }
        }
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = com.tencent.mm.ah.n.GT().m(com.tencent.mm.ah.e.c((com.tencent.mm.ah.d)localObject2), "", "");
        }
        if ((localau.bLX()) || (localau.bMb()) || (localau.bMc()) || (aa.an(localau))) {
          if ((System.currentTimeMillis() - localau.field_createTime <= 259200000L) || ((!bf.mA((String)localObject1)) && (com.tencent.mm.a.e.aO((String)localObject1)))) {
            break label569;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label573;
        }
        i = 0;
        break;
        if ((localau.bMc()) || (localau.bMb()))
        {
          com.tencent.mm.modelvideo.o.KW();
          localObject1 = s.lw(localau.field_imgPath);
          break label392;
        }
        if (localau.axH())
        {
          localObject2 = f.a.ek(localau.field_content);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label392;
          }
          localObject2 = com.tencent.mm.pluginsdk.model.app.l.Mg(((f.a)localObject2).fCN);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label392;
          }
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath;
          break label392;
        }
        localObject1 = localau.field_imgPath;
        break label392;
      }
    }
    label575:
    b(paramContext, paramList, paramBoolean, paramString, paramdx);
    label584:
    GMTrace.o(2511213690880L, 18710);
  }
  
  public static void b(Context paramContext, List<au> paramList, boolean paramBoolean, String paramString, dx paramdx)
  {
    GMTrace.i(2511347908608L, 18711);
    if (aa.cx(paramList))
    {
      com.tencent.mm.ui.base.g.a(paramContext, paramContext.getString(R.l.eaz), "", paramContext.getString(R.l.dAD), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2218887479296L, 16532);
          if (this.vzn != null)
          {
            paramAnonymousDialogInterface = this.vzn;
            dx.a locala = dx.a.vLr;
            paramAnonymousDialogInterface.bUu();
          }
          GMTrace.o(2218887479296L, 16532);
        }
      });
      GMTrace.o(2511347908608L, 18711);
      return;
    }
    vzl.vzr = new LinkedList(paramList);
    vzl.vvA = paramBoolean;
    vzl.vzk = paramdx;
    vzl.fTc = paramString;
    int j = 2;
    Intent localIntent = new Intent(paramContext, MsgRetransmitUI.class);
    au localau;
    int i;
    if (paramList.size() == 1)
    {
      localau = (au)paramList.get(0);
      if ((localau.axH()) || (localau.bLN()) || (localau.bLO()))
      {
        paramList = q.fQ(localau.field_msgSvrId);
        paramString = q.yC().n(paramList, true);
        paramString.l("prePublishId", "msg_" + localau.field_msgSvrId);
        paramString.l("preUsername", ag.a(localau, paramBoolean, false));
        paramString.l("preChatName", localau.field_talker);
        paramString.l("preMsgIndex", Integer.valueOf(0));
        paramString.l("sendAppMsgScene", Integer.valueOf(1));
        paramString.l("moreRetrAction", Boolean.valueOf(true));
        if (paramBoolean)
        {
          paramString.l("fromScene", Integer.valueOf(2));
          ((com.tencent.mm.plugin.sns.b.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.sns.b.h.class)).a("adExtStr", paramString, localau);
          localIntent.putExtra("reportSessionId", paramList);
        }
      }
      else
      {
        paramList = localau.field_content;
        j = 12;
        if (!localau.bLZ()) {
          break label454;
        }
        i = 9;
        label346:
        if (!localau.bLN()) {
          break label940;
        }
      }
    }
    label454:
    label813:
    label820:
    label940:
    for (j = 1;; j = 2)
    {
      localIntent.putExtra("Retr_Msg_Type", i);
      localIntent.putExtra("Retr_Msg_Id", localau.field_msgId);
      localIntent.putExtra("Retr_Msg_content", paramList);
      localIntent.putExtra("Edit_Mode_Sigle_Msg", true);
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromScene", j);
        localIntent.putExtra("Retr_show_success_tips", true);
        paramContext.startActivity(localIntent);
        GMTrace.o(2511347908608L, 18711);
        return;
        paramString.l("fromScene", Integer.valueOf(1));
        break;
        if (localau.bMd())
        {
          i = 5;
          localIntent.putExtra("Retr_File_Name", localau.field_imgPath);
          break label346;
        }
        if (localau.bLY())
        {
          i = 8;
          break label346;
        }
        if (localau.bMa())
        {
          i = 4;
          j = i;
          if (!paramBoolean) {
            break label813;
          }
          j = i;
          if (localau.field_isSend != 0) {
            break label813;
          }
          paramList = ay.gj(paramList);
          break label346;
        }
        if (localau.bLX())
        {
          paramString = null;
          if (localau.field_msgId > 0L) {
            paramString = com.tencent.mm.ah.n.GT().aj(localau.field_msgId);
          }
          if (paramString != null)
          {
            paramdx = paramString;
            if (paramString.hEG > 0L) {}
          }
          else
          {
            paramdx = paramString;
            if (localau.field_msgSvrId > 0L) {
              paramdx = com.tencent.mm.ah.n.GT().ai(localau.field_msgSvrId);
            }
          }
          localIntent.putExtra("Retr_File_Name", com.tencent.mm.ah.n.GT().m(com.tencent.mm.ah.e.c(paramdx), "", ""));
          i = 0;
          break label346;
        }
        if (localau.bMc())
        {
          paramString = t.lI(localau.field_imgPath);
          if (paramString != null) {
            localIntent.putExtra("Retr_length", paramString.hZV);
          }
          i = 11;
          localIntent.putExtra("Retr_File_Name", localau.field_imgPath);
          break label346;
        }
        if (localau.bMb())
        {
          paramString = t.lI(localau.field_imgPath);
          if (paramString != null) {
            localIntent.putExtra("Retr_length", paramString.hZV);
          }
          i = 1;
          localIntent.putExtra("Retr_File_Name", localau.field_imgPath);
          break label346;
        }
        if (localau.axH())
        {
          paramString = f.a.ek(paramList);
          if ((paramString == null) || (19 != paramString.type)) {
            break label820;
          }
          i = 10;
        }
        for (;;)
        {
          if (!localau.bLN())
          {
            j = i;
            if (!localau.bLO()) {}
          }
          else
          {
            localIntent.putExtra("is_group_chat", paramBoolean);
            j = i;
          }
          i = j;
          break;
          if ((paramString != null) && (24 == paramString.type)) {
            i = 10;
          } else if ((paramString != null) && (16 == paramString.type)) {
            i = 14;
          } else {
            i = 2;
          }
        }
        if (((paramdx != null) && (paramdx.bUv())) || ((com.tencent.mm.u.o.eV(paramString)) && (!com.tencent.mm.modelbiz.e.dr(paramString))) || (com.tencent.mm.u.o.fF(paramString)))
        {
          localIntent.putExtra("Retr_Msg_Type", 12);
        }
        else
        {
          localIntent.putExtra("Retr_Msg_Type", 13);
          localIntent.putExtra("Retr_Multi_Msg_List_from", paramString);
        }
      }
    }
  }
  
  public static void bTR()
  {
    GMTrace.i(2512018997248L, 18716);
    vzl.vzr = null;
    vzl.vvA = false;
    vzl.vzk = null;
    vzl.fTc = null;
    vzl.fSz = null;
    vzl.vzs = null;
    GMTrace.o(2512018997248L, 18716);
  }
  
  public static void d(Context paramContext, String paramString, au paramau, boolean paramBoolean)
  {
    GMTrace.i(16018885836800L, 119350);
    v.i("MicroMsg.ChattingEditModeRetransmitMsg", "retransmitSingleMsg %s", new Object[] { Long.valueOf(paramau.field_msgId) });
    if ((aa.af(paramau)) || (aa.ag(paramau)))
    {
      GMTrace.o(16018885836800L, 119350);
      return;
    }
    if ((com.tencent.mm.modelbiz.e.dr(paramString)) && (!paramau.bLX()) && (!paramau.bMa()) && (!paramau.bLP()))
    {
      v.i("MicroMsg.ChattingEditModeRetransmitMsg", "not bizChatSupport msg:type:%d", new Object[] { Integer.valueOf(paramau.field_type) });
      GMTrace.o(16018885836800L, 119350);
      return;
    }
    if (paramau.bLX())
    {
      aa.b(paramContext, paramString, paramau);
      GMTrace.o(16018885836800L, 119350);
      return;
    }
    if (paramau.bMb())
    {
      aa.c(paramContext, paramString, paramau);
      GMTrace.o(16018885836800L, 119350);
      return;
    }
    Object localObject1;
    int i;
    if (paramau.bMc())
    {
      aa.c(paramContext, paramString, paramau);
      paramBoolean = com.tencent.mm.u.o.dH(paramString);
      if (paramBoolean)
      {
        paramContext = a.c.vvq;
        localObject1 = a.d.vvt;
        if (!paramBoolean) {
          break label228;
        }
      }
      label228:
      for (i = j.eC(paramString);; i = 0)
      {
        a.a(paramContext, (a.d)localObject1, paramau, i);
        GMTrace.o(16018885836800L, 119350);
        return;
        paramContext = a.c.vvp;
        break;
      }
    }
    if (paramau.bMa())
    {
      aa.a(paramContext, paramString, paramau, paramBoolean);
      GMTrace.o(16018885836800L, 119350);
      return;
    }
    Object localObject2;
    if ((paramau.bLS()) || (paramau.axH()))
    {
      boolean bool = com.tencent.mm.u.o.dH(paramString);
      if (bool)
      {
        localObject1 = a.c.vvq;
        localObject2 = a.d.vvt;
        if (!bool) {
          break label424;
        }
        i = j.eC(paramString);
        label304:
        a.a((a.c)localObject1, (a.d)localObject2, paramau, i);
        if (!paramau.bMe()) {
          break label523;
        }
        if (!aa.a(paramContext, paramString, paramau, "appEmoji")) {
          break label513;
        }
        localObject1 = aj.RC(paramau.field_content);
        paramContext = f.a.B(paramau.field_content, paramau.field_reserved);
        if (paramContext != null) {
          break label1262;
        }
        paramContext = new f.a();
        paramContext.hhi = ((aj)localObject1).fFN;
      }
    }
    label424:
    label513:
    label523:
    label1262:
    for (;;)
    {
      if ((bf.mA(paramContext.hhi)) || (paramContext.hhi.equalsIgnoreCase("-1")))
      {
        v.e("MicroMsg.ChattingEditModeLogic", "emoji md5 is null. ignore resend");
        GMTrace.o(16018885836800L, 119350);
        return;
        localObject1 = a.c.vvp;
        break;
        i = 0;
        break label304;
      }
      v.d("MicroMsg.ChattingEditModeLogic", "jacks send App Emoji: %s, %s", new Object[] { paramString, paramContext.hhi });
      paramContext = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(paramContext.hhi);
      if (paramContext != null)
      {
        aa.b(paramContext, paramString);
        GMTrace.o(16018885836800L, 119350);
        return;
      }
      v.i("MicroMsg.ChattingEditModeLogic", "emoji is null. content:%s", new Object[] { localObject1 });
      GMTrace.o(16018885836800L, 119350);
      return;
      f.a locala;
      if ((paramau.bLN()) || (paramau.bLO()))
      {
        try
        {
          localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).rR(paramau.field_content);
          localObject2 = ((k)localObject1).hkc;
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = (com.tencent.mm.t.l)((Iterator)localObject2).next();
              locala = new f.a();
              locala.title = ((com.tencent.mm.t.l)localObject3).title;
              locala.description = ((com.tencent.mm.t.l)localObject3).hkk;
              locala.action = "view";
              locala.type = 5;
              locala.url = ((com.tencent.mm.t.l)localObject3).url;
              locala.fUH = ((k)localObject1).fUH;
              locala.fUI = ((k)localObject1).fUI;
              locala.gxt = ((k)localObject1).gxt;
              locala.thumburl = ((com.tencent.mm.t.l)localObject3).hki;
              if (bf.mA(locala.thumburl))
              {
                localObject3 = com.tencent.mm.x.n.Bm().hs(paramau.field_talker);
                if (localObject3 != null) {
                  locala.thumburl = ((com.tencent.mm.x.h)localObject3).Bs();
                }
              }
              aa.a(paramContext, paramString, f.a.a(locala, null, null), paramau.field_isSend, paramBoolean);
            }
          }
          GMTrace.o(16018885836800L, 119350);
        }
        catch (Exception paramContext)
        {
          v.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
          v.e("MicroMsg.ChattingEditModeLogic", "[oneliang]retransmit multi app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
          GMTrace.o(16018885836800L, 119350);
          return;
        }
        return;
      }
      if (paramau.field_isSend == 0) {}
      for (localObject1 = ay.gj(paramau.field_content);; localObject1 = paramau.field_content)
      {
        locala = f.a.ek((String)localObject1);
        if (locala != null) {
          break;
        }
        v.e("MicroMsg.ChattingEditModeRetransmitMsg", "parse app message content fail");
        GMTrace.o(16018885836800L, 119350);
        return;
      }
      localObject1 = com.tencent.mm.pluginsdk.model.app.g.aJ(locala.appId, false);
      if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject1).bCM()))
      {
        v.w("MicroMsg.ChattingEditModeRetransmitMsg", "do not forward game msg");
        GMTrace.o(16018885836800L, 119350);
        return;
      }
      if (locala.type == 19)
      {
        paramContext = new lz();
        paramContext.fSV.type = 4;
        paramContext.fSV.fTa = paramau;
        paramContext.fSV.toUser = paramString;
        com.tencent.mm.sdk.b.a.uql.m(paramContext);
        GMTrace.o(16018885836800L, 119350);
        return;
      }
      if ((locala.type == 5) && (!bf.mA(locala.url))) {
        localObject1 = "";
      }
      try
      {
        localObject2 = URLEncoder.encode(locala.url, "UTF-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          long l;
          v.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
      l = bf.Nz();
      v.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), locala.url, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1) });
      com.tencent.mm.plugin.report.service.g.oSF.i(13378, new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1) });
      aa.b(paramContext, paramString, paramau, paramBoolean);
      GMTrace.o(16018885836800L, 119350);
      return;
      if (paramau.bLY())
      {
        if (aa.a(paramContext, paramString, paramau, "friendcard"))
        {
          paramContext = aa.q(paramau.field_content, paramau.field_isSend, paramBoolean);
          com.tencent.mm.plugin.messenger.a.d.aJP().A(paramString, paramContext, 42);
        }
        GMTrace.o(16018885836800L, 119350);
        return;
      }
      if ((paramau.bMd()) || (paramau.bMe()))
      {
        if (!aa.ac(paramau))
        {
          aa.a(paramContext, paramString, paramau);
          GMTrace.o(16018885836800L, 119350);
        }
      }
      else if (paramau.bLZ()) {
        aa.c(paramContext, paramString, paramau, paramBoolean);
      }
      GMTrace.o(16018885836800L, 119350);
      return;
    }
  }
  
  public static lz eS(Context paramContext)
  {
    GMTrace.i(2511750561792L, 18714);
    lz locallz = new lz();
    locallz.fSV.type = 6;
    locallz.fSV.fTb = vzl.vzr;
    locallz.fSV.fTc = vzl.fTc;
    locallz.fSV.context = paramContext;
    com.tencent.mm.sdk.b.a.uql.m(locallz);
    vzl.fSz = locallz.fSW.fSz;
    vzl.vzs = locallz.fSW.fTe;
    GMTrace.o(2511750561792L, 18714);
    return locallz;
  }
  
  public static void k(Context paramContext, String paramString, boolean paramBoolean)
  {
    GMTrace.i(2511482126336L, 18712);
    Object localObject = new lz();
    ((lz)localObject).fSV.type = 5;
    ((lz)localObject).fSV.fTb = vzl.vzr;
    ((lz)localObject).fSV.toUser = paramString;
    ((lz)localObject).fSV.fTc = vzl.fTc;
    ((lz)localObject).fSV.context = paramContext;
    ((lz)localObject).fSV.fSz = vzl.fSz;
    ((lz)localObject).fSV.fTe = vzl.vzs;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    long l;
    f.a locala;
    if (vzl.vzr != null)
    {
      com.tencent.mm.plugin.report.service.g.oSF.i(10811, new Object[] { Integer.valueOf(8), Integer.valueOf(vzl.vzr.size()), Integer.valueOf(vzl.vzr.size() - aa.cv(vzl.vzr)) });
      localObject = vzl.vzr.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramContext = (au)((Iterator)localObject).next();
        l = bf.Nz();
        locala = f.a.ek(bf.PW(paramContext.field_content));
        if ((locala != null) && (locala.type == 5) && (!bf.mA(locala.url))) {
          if (!paramContext.bLN()) {
            break label447;
          }
        }
      }
    }
    label447:
    for (int i = 1;; i = 2)
    {
      paramContext = "";
      try
      {
        paramString = URLEncoder.encode(locala.url, "UTF-8");
        paramContext = paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", paramString, "", new Object[0]);
        }
      }
      v.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), locala.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      com.tencent.mm.plugin.report.service.g.oSF.i(13378, new Object[] { paramContext, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      break;
      if ((paramBoolean) && (vzl.vzk != null)) {
        vzl.vzk.b(dx.a.vLr);
      }
      GMTrace.o(2511482126336L, 18712);
      return;
    }
  }
  
  public static void l(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    GMTrace.i(2511884779520L, 18715);
    if (paramContext == null)
    {
      v.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, context is null");
      GMTrace.o(2511884779520L, 18715);
      return;
    }
    if (bf.mA(paramString))
    {
      v.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
      GMTrace.o(2511884779520L, 18715);
      return;
    }
    if ((vzl.vzr == null) || (vzl.vzr.isEmpty()))
    {
      v.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
      GMTrace.o(2511884779520L, 18715);
      return;
    }
    v.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", new Object[] { paramString });
    da.vEf.c(new aq.a()
    {
      public final boolean Bn()
      {
        GMTrace.i(2181977604096L, 16257);
        if (ab.vzl.vzr == null)
        {
          GMTrace.o(2181977604096L, 16257);
          return false;
        }
        Iterator localIterator = ab.vzl.vzr.iterator();
        while (localIterator.hasNext())
        {
          au localau = (au)localIterator.next();
          ab.d(this.val$context, paramString, localau, ab.vzl.vvA);
        }
        GMTrace.o(2181977604096L, 16257);
        return true;
      }
      
      public final boolean Bo()
      {
        GMTrace.i(2182111821824L, 16258);
        if (ab.vzl.vzr != null) {
          com.tencent.mm.plugin.report.service.g.oSF.i(10811, new Object[] { Integer.valueOf(5), Integer.valueOf(ab.vzl.vzr.size()), Integer.valueOf(ab.vzl.vzr.size() - aa.cv(ab.vzl.vzr)) });
        }
        if (paramBoolean)
        {
          if (this.laE != null)
          {
            v.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
            this.laE.run();
          }
          if (ab.vzl.vzk != null) {
            ab.vzl.vzk.b(dx.a.vLr);
          }
          ab.bTR();
        }
        GMTrace.o(2182111821824L, 16258);
        return true;
      }
    });
    GMTrace.o(2511884779520L, 18715);
  }
  
  public static void lc(boolean paramBoolean)
  {
    GMTrace.i(2511616344064L, 18713);
    if ((paramBoolean) && (vzl.vzk != null)) {
      vzl.vzk.b(dx.a.vLr);
    }
    GMTrace.o(2511616344064L, 18713);
  }
  
  private static final class a
  {
    cb fSz;
    String fTc;
    boolean vvA;
    dx vzk;
    List<au> vzr;
    com.tencent.mm.protocal.b.a.d vzs;
    
    public a()
    {
      GMTrace.i(2494168039424L, 18583);
      GMTrace.o(2494168039424L, 18583);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */