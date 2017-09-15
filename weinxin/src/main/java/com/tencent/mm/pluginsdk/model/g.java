package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.d;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.cb.a;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.lz.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.ry;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.protocal.c.se;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.t.f.a;
import com.tencent.mm.t.k;
import com.tencent.mm.t.l;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import com.tencent.mm.u.m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  private static final SimpleDateFormat rZv;
  
  static
  {
    GMTrace.i(770409758720L, 5740);
    rZv = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    GMTrace.o(770409758720L, 5740);
  }
  
  private static rv LP(String paramString)
  {
    GMTrace.i(769067581440L, 5730);
    rv localrv = new rv();
    localrv.OC(paramString);
    localrv.ye(1);
    localrv.ep(bf.NA());
    localrv.OE("");
    GMTrace.o(769067581440L, 5730);
    return localrv;
  }
  
  private static rn T(au paramau)
  {
    GMTrace.i(769201799168L, 5731);
    rn localrn = new rn();
    if ((paramau.field_isSend == 1) || (paramau.field_content.startsWith("<msg>")))
    {
      localrn.Ol(m.xL());
      localrn.Om(paramau.field_talker);
      if (com.tencent.mm.u.o.dH(paramau.field_talker)) {
        localrn.Oo(localrn.fOl);
      }
    }
    do
    {
      if (com.tencent.mm.modelbiz.e.dr(paramau.field_talker))
      {
        String str2 = paramau.field_bizChatUserId;
        str1 = str2;
        if (str2 == null) {
          str1 = ay.gm(paramau.gxv).userId;
        }
        localrn.Oo(str1);
      }
      localrn.xZ(1);
      localrn.em(paramau.field_createTime);
      localrn.Op(paramau.field_msgSvrId);
      if (paramau.field_msgSvrId > 0L) {
        localrn.On(paramau.field_msgSvrId);
      }
      GMTrace.o(769201799168L, 5731);
      return localrn;
      localrn.Ol(paramau.field_talker);
      localrn.Om(m.xL());
    } while (!com.tencent.mm.u.o.dH(paramau.field_talker));
    if (paramau.field_content != null) {}
    for (String str1 = paramau.field_content.substring(0, Math.max(0, paramau.field_content.indexOf(':')));; str1 = "")
    {
      localrn.Oo(str1);
      if ((bf.mA(localrn.txi)) || (paramau.bLP())) {
        break;
      }
      paramau.setContent(paramau.field_content.substring(localrn.txi.length() + 1));
      if ((paramau.field_content.length() > 0) && ('\n' == paramau.field_content.charAt(0))) {
        paramau.setContent(paramau.field_content.substring(1));
      }
      if (!paramau.bMi()) {
        break;
      }
      paramau.cK(paramau.field_transContent.substring(localrn.txi.length() + 1));
      if ((paramau.field_transContent.length() <= 0) || ('\n' != paramau.field_transContent.charAt(0))) {
        break;
      }
      paramau.cK(paramau.field_transContent.substring(1));
      break;
    }
  }
  
  private static String U(au paramau)
  {
    GMTrace.i(769604452352L, 5734);
    if (paramau.field_isSend == 1)
    {
      if ((com.tencent.mm.u.o.dH(paramau.field_talker)) || (paramau.field_talker.equals("filehelper")))
      {
        paramau = String.format("%d", new Object[] { Long.valueOf(paramau.field_msgSvrId) });
        GMTrace.o(769604452352L, 5734);
        return paramau;
      }
      paramau = String.format("%s#%d", new Object[] { paramau.field_talker, Long.valueOf(paramau.field_msgSvrId) });
      GMTrace.o(769604452352L, 5734);
      return paramau;
    }
    long l = paramau.field_msgSvrId;
    GMTrace.o(769604452352L, 5734);
    return String.valueOf(l);
  }
  
  private static rl a(au paramau, f.a parama, int paramInt)
  {
    GMTrace.i(770007105536L, 5737);
    rl localrl = new rl();
    localrl.Oc(U(paramau));
    localrl.NR(parama.hhx);
    localrl.NS(parama.hhy);
    localrl.NQ(parama.url);
    localrl.jG(true);
    paramau = new File(bf.ap(com.tencent.mm.ah.n.GT().v(paramau.field_imgPath, true), ""));
    if (paramau.exists()) {
      localrl.NZ(paramau.getAbsolutePath());
    }
    for (;;)
    {
      localrl.NK(parama.title);
      localrl.NL(parama.description);
      localrl.xW(paramInt);
      localrl.Oj(parama.canvasPageXml);
      GMTrace.o(770007105536L, 5737);
      return localrl;
      localrl.jH(true);
    }
  }
  
  private static rl a(au paramau, String paramString, rm paramrm)
  {
    GMTrace.i(770141323264L, 5738);
    rl localrl = new rl();
    localrl.Oc(U(paramau));
    localrl.xW(1);
    localrl.NL(paramString);
    localrl.jH(true);
    localrl.jG(true);
    localrl.a(paramrm);
    localrl.Of(a(paramrm.twM));
    localrl.Og(b(paramrm.twM));
    GMTrace.o(770141323264L, 5738);
    return localrl;
  }
  
  private static String a(rn paramrn)
  {
    GMTrace.i(769336016896L, 5732);
    String str2 = paramrn.txi;
    String str1 = str2;
    if (bf.mA(str2)) {
      str1 = paramrn.fOl;
    }
    if (com.tencent.mm.modelbiz.a.e.is(str1))
    {
      paramrn = com.tencent.mm.modelbiz.a.e.iu(str1);
      GMTrace.o(769336016896L, 5732);
      return paramrn;
    }
    paramrn = com.tencent.mm.u.n.eJ(str1);
    GMTrace.o(769336016896L, 5732);
    return paramrn;
  }
  
  private static boolean a(Context paramContext, cb paramcb, au paramau, int paramInt)
  {
    GMTrace.i(768933363712L, 5729);
    rm localrm = new rm();
    localrm.c(T(paramau));
    String str = null;
    if (paramInt == 1) {
      str = paramContext.getString(R.l.dGD);
    }
    for (;;)
    {
      paramContext = a(paramau, str, localrm);
      paramcb.fFr.fFt.txF.add(paramContext);
      GMTrace.o(768933363712L, 5729);
      return true;
      if (paramInt == 2) {
        str = paramContext.getString(R.l.dHN);
      } else if (paramInt == 3) {
        str = paramContext.getString(R.l.dIB);
      }
    }
  }
  
  private static boolean a(Context paramContext, cb paramcb, au paramau, boolean paramBoolean)
  {
    GMTrace.i(768799145984L, 5728);
    if ((paramcb == null) || (paramau == null))
    {
      v.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
      if (paramcb != null) {
        paramcb.fFr.fFx = R.l.ehT;
      }
      GMTrace.o(768799145984L, 5728);
      return false;
    }
    au localau = au.Y(paramau);
    boolean bool = false;
    if (localau.bMa())
    {
      paramContext = new rm();
      paramContext.c(T(localau));
      paramau = new rl();
      paramau.Oc(U(localau));
      paramau.xW(1);
      if (!localau.bMm())
      {
        paramau.NL(localau.field_content);
        paramau.jH(true);
        paramau.jG(true);
        paramau.a(paramContext);
        paramau.Of(a(paramContext.twM));
        paramau.Og(b(paramContext.twM));
        paramcb.fFr.fFt.txF.add(paramau);
        paramContext = paramcb.fFr.fFu;
        paramContext.txQ += 1;
        bool = true;
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        c.a(localau, paramcb, bool);
      }
      GMTrace.o(768799145984L, 5728);
      return bool;
      paramau.NL(localau.field_content + "\n\n" + localau.field_transContent);
      break;
      Object localObject1;
      if (localau.bLP())
      {
        paramau = new rm();
        paramau.c(T(localau));
        localObject1 = new rl();
        ((rl)localObject1).Oc(U(localau));
        ((rl)localObject1).xW(3);
        if (paramBoolean)
        {
          ((rl)localObject1).jH(true);
          ((rl)localObject1).jG(true);
        }
        for (;;)
        {
          ((rl)localObject1).a(paramau);
          ((rl)localObject1).Of(a(paramau.twM));
          ((rl)localObject1).Og(b(paramau.twM));
          paramcb.fFr.fFt.txF.add(localObject1);
          paramContext = paramcb.fFr.fFu;
          paramContext.txS += 1;
          bool = true;
          break;
          if (com.tencent.mm.u.o.fq(localau.field_talker))
          {
            paramContext = localau.field_imgPath;
            ap.yY();
            paramContext = com.tencent.mm.sdk.platformtools.h.a(com.tencent.mm.u.c.xg(), "recbiz_", paramContext, ".rec", 2);
            if (bf.mA(paramContext))
            {
              paramContext = null;
              label460:
              ((rl)localObject1).NY(paramContext);
            }
          }
          for (;;)
          {
            ((rl)localObject1).jH(true);
            paramContext = q.lW(localau.field_imgPath);
            if (paramContext != null) {
              break label525;
            }
            bool = false;
            break;
            new File(paramContext).exists();
            break label460;
            ((rl)localObject1).NY(q.jt(localau.field_imgPath));
          }
          label525:
          ((rl)localObject1).NU(e.wQ(paramContext.getFormat()));
          ((rl)localObject1).xV((int)new com.tencent.mm.modelvoice.n(localau.field_content).time);
        }
      }
      if (localau.bLZ())
      {
        bool = b(paramcb, localau);
      }
      else
      {
        Object localObject2;
        int i;
        if (localau.bLX())
        {
          paramau = null;
          if (localau.field_msgId > 0L) {
            paramau = com.tencent.mm.ah.n.GT().aj((int)localau.field_msgId);
          }
          if (paramau != null)
          {
            paramContext = paramau;
            if (paramau.hEG > 0L) {}
          }
          else
          {
            paramContext = paramau;
            if (localau.field_msgSvrId > 0L) {
              paramContext = com.tencent.mm.ah.n.GT().ai(localau.field_msgSvrId);
            }
          }
          if (paramContext == null)
          {
            v.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
            paramcb.fFr.fFx = R.l.ehZ;
            bool = false;
          }
          else
          {
            paramau = new rm();
            paramau.c(T(localau));
            localObject1 = new rl();
            ((rl)localObject1).Oc(U(localau));
            ((rl)localObject1).xW(2);
            ((rl)localObject1).NY(com.tencent.mm.ah.n.GT().m(com.tencent.mm.ah.e.c(paramContext), "", ""));
            if (paramContext.GC())
            {
              localObject2 = com.tencent.mm.ah.n.GT().fT(paramContext.hEQ);
              if (((d)localObject2).hrb > ((d)localObject2).offset) {
                ((rl)localObject1).NY(com.tencent.mm.ah.n.GT().m("SERVERID://" + localau.field_msgSvrId, "", ""));
              }
            }
            ((rl)localObject1).NZ(com.tencent.mm.ah.n.GT().v(localau.field_imgPath, true));
            ((rl)localObject1).a(paramau);
            ((rl)localObject1).Of(a(paramau.twM));
            ((rl)localObject1).Og(b(paramau.twM));
            ((rl)localObject1).el(localau.field_msgId);
            if (paramBoolean)
            {
              paramau = paramContext;
              if (paramContext.GC())
              {
                paramau = paramContext;
                if (paramContext.hrb == 0) {
                  paramau = com.tencent.mm.ah.n.GT().fT(paramContext.hEQ);
                }
              }
              if (localau.field_isSend != 1) {
                break label1060;
              }
              if (!paramau.GC()) {
                break label1054;
              }
              i = 1;
              label934:
              paramContext = bg.q(paramau.hER, "msg");
              if (paramContext == null) {
                break label1110;
              }
              if (i == 1)
              {
                ((rl)localObject1).NO((String)paramContext.get(".msg.img.$cdnbigimgurl"));
                ((rl)localObject1).ej(bf.getInt((String)paramContext.get(".msg.img.$length"), 0));
                ((rl)localObject1).NP((String)paramContext.get(".msg.img.$aeskey"));
              }
            }
            for (;;)
            {
              paramcb.fFr.fFt.txF.add(localObject1);
              paramContext = paramcb.fFr.fFu;
              paramContext.txR += 1;
              bool = true;
              break;
              label1054:
              i = 0;
              break label934;
              label1060:
              if (!paramau.GC())
              {
                i = 0;
                break label934;
              }
              paramContext = com.tencent.mm.ah.e.a(paramau);
              if (!com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GT().m(paramContext.hEH, "", "")))
              {
                i = 0;
                break label934;
              }
              i = 1;
              break label934;
              label1110:
              v.i("MicroMsg.GetFavRecordDataSource", "parse cdnInfo failed. [%s]", new Object[] { paramau.hER });
            }
          }
        }
        else if (localau.bMb())
        {
          bool = a(paramcb, localau, paramBoolean);
        }
        else if (localau.bMc())
        {
          bool = a(paramcb, localau, paramBoolean);
        }
        else
        {
          if ((paramBoolean) && (localau.field_type == 318767153))
          {
            paramBoolean = a(paramContext, paramcb, localau, 3);
            GMTrace.o(768799145984L, 5728);
            return paramBoolean;
          }
          if ((localau.bLN()) || (localau.bLO()))
          {
            bool = c(paramcb, localau);
          }
          else if ((paramBoolean) && ((localau.bMd()) || (localau.bMe())))
          {
            bool = a(paramContext, paramcb, localau, 1);
          }
          else if ((paramBoolean) && (localau.field_type == 419430449))
          {
            bool = a(paramContext, paramcb, localau, 2);
          }
          else
          {
            if (localau.bLY())
            {
              ap.yY();
              localObject1 = com.tencent.mm.u.c.wT().At(localau.field_content);
              paramau = new rm();
              paramau.c(T(localau));
              if ((localObject1 != null) && (com.tencent.mm.u.o.eW(((au.a)localObject1).rUD)))
              {
                paramContext = new rl();
                paramContext.Oc(U(localau));
                paramContext.xW(16);
                paramContext.NL(localau.field_content);
                paramContext.jH(true);
                paramContext.jG(true);
                paramContext.a(paramau);
                paramContext.Of(a(paramau.twM));
                paramContext.Og(b(paramau.twM));
              }
              for (;;)
              {
                paramcb.fFr.fFt.txF.add(paramContext);
                paramContext = paramcb.fFr.fFu;
                paramContext.tye += 1;
                bool = true;
                break;
                paramContext = a(localau, paramContext.getString(R.l.dHl), paramau);
              }
            }
            if (localau.axH())
            {
              if (localau.bMe())
              {
                paramcb.fFr.fFx = R.l.eib;
              }
              else
              {
                paramau = new rm();
                paramau.c(T(localau));
                localObject1 = localau.field_content;
                if (localObject1 == null)
                {
                  paramcb.fFr.fFx = R.l.eic;
                  bool = false;
                }
                else
                {
                  localObject1 = f.a.ek((String)localObject1);
                  if (localObject1 == null)
                  {
                    paramcb.fFr.fFx = R.l.eic;
                    bool = false;
                  }
                  else
                  {
                    paramau.twM.Oq(((f.a)localObject1).appId);
                    paramau.twM.Os(((f.a)localObject1).fUH);
                    localObject2 = com.tencent.mm.pluginsdk.model.app.g.aJ(((f.a)localObject1).appId, true);
                    if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject2).bCM()) && (paramBoolean))
                    {
                      paramContext = a(localau, paramContext.getString(R.l.dHm), paramau);
                      paramcb.fFr.fFt.txF.add(paramContext);
                      bool = true;
                    }
                    else
                    {
                      switch (((f.a)localObject1).type)
                      {
                      }
                      for (;;)
                      {
                        if (paramBoolean)
                        {
                          paramContext = a(localau, paramContext.getString(R.l.dIB), paramau);
                          paramcb.fFr.fFt.txF.add(paramContext);
                          bool = true;
                          break;
                          paramContext = new rl();
                          paramContext.Oc(U(localau));
                          paramContext.xW(1);
                          paramContext.NL(((f.a)localObject1).title);
                          paramContext.jH(true);
                          paramContext.jG(true);
                          paramContext.a(paramau);
                          paramContext.Of(a(paramau.twM));
                          paramContext.Og(b(paramau.twM));
                          paramcb.fFr.fFt.txF.add(paramContext);
                          paramContext = paramcb.fFr.fFu;
                          paramContext.txQ += 1;
                          bool = true;
                          break;
                          ap.yY();
                          if (!com.tencent.mm.u.c.isSDCardAvailable())
                          {
                            paramcb.fFr.fFx = R.l.eii;
                            bool = false;
                            break;
                          }
                          localObject2 = an.abF().LV(((f.a)localObject1).fCN);
                          paramContext = new rl();
                          paramContext.Oc(U(localau));
                          if (localObject2 != null) {
                            paramContext.NY(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
                          }
                          localObject2 = com.tencent.mm.ah.n.GT().v(localau.field_imgPath, true);
                          if (com.tencent.mm.a.e.aO((String)localObject2)) {
                            paramContext.NZ((String)localObject2);
                          }
                          paramContext.xW(2);
                          paramContext.NK(((f.a)localObject1).title);
                          paramContext.NL(((f.a)localObject1).description);
                          paramContext.a(paramau);
                          paramContext.Of(a(paramau.twM));
                          paramContext.Og(b(paramau.twM));
                          paramContext.el(localau.field_msgId);
                          paramcb.fFr.fFt.txF.add(paramContext);
                          paramContext = paramcb.fFr.fFu;
                          paramContext.txR += 1;
                          bool = true;
                          break;
                          paramContext = a(localau, (f.a)localObject1, 7);
                          paramContext.a(paramau);
                          paramContext.Of(a(paramau.twM));
                          paramContext.Og(b(paramau.twM));
                          paramcb.fFr.fFt.txF.add(paramContext);
                          paramContext = paramcb.fFr.fFu;
                          paramContext.txW += 1;
                          bool = true;
                          break;
                          paramContext = a(localau, (f.a)localObject1, 4);
                          paramContext.a(paramau);
                          paramContext.Of(a(paramau.twM));
                          paramContext.Og(b(paramau.twM));
                          paramContext.el(localau.field_msgId);
                          paramcb.fFr.fFt.txF.add(paramContext);
                          paramContext = paramcb.fFr.fFu;
                          paramContext.txT += 1;
                          bool = true;
                          break;
                          if ((((f.a)localObject1).url != null) && (!((f.a)localObject1).url.equals("")))
                          {
                            paramau.twM.Or(((f.a)localObject1).url);
                            paramContext = a(localau, (f.a)localObject1, 5);
                            paramContext.a(paramau);
                            paramContext.Of(a(paramau.twM));
                            paramContext.Og(b(paramau.twM));
                            localObject2 = new se();
                            if (!bf.mA(((f.a)localObject1).title)) {
                              ((se)localObject2).OP(((f.a)localObject1).title);
                            }
                            if (!bf.mA(((f.a)localObject1).description)) {
                              ((se)localObject2).OQ(((f.a)localObject1).description);
                            }
                            if (!bf.mA(((f.a)localObject1).thumburl)) {
                              ((se)localObject2).OS(((f.a)localObject1).thumburl);
                            }
                            if (!bf.mA(((f.a)localObject1).canvasPageXml)) {
                              ((se)localObject2).OT(((f.a)localObject1).canvasPageXml);
                            }
                            if (((se)localObject2).aUd() > 0)
                            {
                              ((se)localObject2).yf(1);
                              paramau.a((se)localObject2);
                            }
                            paramcb.fFr.fFt.txF.add(paramContext);
                            paramContext = paramcb.fFr.fFu;
                            paramContext.txU += 1;
                            bool = true;
                            break;
                          }
                          paramcb.fFr.fFx = R.l.ehX;
                          if (paramBoolean)
                          {
                            paramContext = a(localau, paramContext.getString(R.l.dIB), paramau);
                            paramcb.fFr.fFt.txF.add(paramContext);
                            bool = true;
                            break;
                          }
                          bool = false;
                          break;
                          ap.yY();
                          if (!com.tencent.mm.u.c.isSDCardAvailable())
                          {
                            paramcb.fFr.fFx = R.l.eii;
                            bool = false;
                            break;
                          }
                          localObject2 = an.abF().LV(((f.a)localObject1).fCN);
                          paramContext = new rl();
                          if (localObject2 != null) {
                            paramContext.NY(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
                          }
                          paramContext.Oc(U(localau));
                          paramContext.xW(8);
                          paramContext.NU(((f.a)localObject1).hhh);
                          localObject2 = com.tencent.mm.ah.n.GT().v(localau.field_imgPath, true);
                          if (bf.mA((String)localObject2)) {
                            paramContext.jH(true);
                          }
                          if (com.tencent.mm.a.e.aO((String)localObject2)) {
                            paramContext.NZ((String)localObject2);
                          }
                          paramContext.NK(((f.a)localObject1).title);
                          paramContext.NL(((f.a)localObject1).description);
                          paramContext.a(paramau);
                          paramContext.Of(a(paramau.twM));
                          paramContext.Og(b(paramau.twM));
                          paramContext.el(localau.field_msgId);
                          if (paramBoolean)
                          {
                            paramContext.NO(((f.a)localObject1).hhn);
                            paramContext.NP(((f.a)localObject1).hhu);
                          }
                          paramcb.fFr.fFt.txF.add(paramContext);
                          paramContext = paramcb.fFr.fFu;
                          paramContext.txX += 1;
                          bool = true;
                          break;
                          if ((((f.a)localObject1).fCN == null) || (((f.a)localObject1).fCN.length() == 0)) {
                            paramcb.fFr.fFx = R.l.ehU;
                          }
                          do
                          {
                            paramcb.fFr.fFx = R.l.eib;
                            bool = false;
                            break;
                            ap.yY();
                          } while (com.tencent.mm.u.c.isSDCardAvailable());
                          paramcb.fFr.fFx = R.l.eii;
                          bool = false;
                          break;
                          paramContext = new rt();
                          paramContext.Ov(((f.a)localObject1).title);
                          paramContext.Ow(((f.a)localObject1).description);
                          paramContext.yb(((f.a)localObject1).hhB);
                          paramContext.Oy(((f.a)localObject1).hhC);
                          paramContext.Ox(((f.a)localObject1).thumburl);
                          paramau.a(paramContext);
                          paramContext = new rl();
                          paramContext.Oc(U(localau));
                          paramContext.xW(10);
                          paramContext.jH(true);
                          paramContext.jG(true);
                          paramContext.a(paramau);
                          paramContext.Of(a(paramau.twM));
                          paramContext.Og(b(paramau.twM));
                          paramcb.fFr.fFt.txF.add(paramContext);
                          paramContext = paramcb.fFr.fFu;
                          paramContext.txZ += 1;
                          bool = true;
                          break;
                          paramContext = new ry();
                          paramContext.OL(((f.a)localObject1).title);
                          paramContext.OM(((f.a)localObject1).description);
                          paramContext.OO(((f.a)localObject1).hhF);
                          paramContext.ON(((f.a)localObject1).thumburl);
                          paramau.a(paramContext);
                          paramContext = new rl();
                          paramContext.Oc(U(localau));
                          paramContext.xW(14);
                          paramContext.jH(true);
                          paramContext.jG(true);
                          paramContext.a(paramau);
                          paramContext.Of(a(paramau.twM));
                          paramContext.Og(b(paramau.twM));
                          paramcb.fFr.fFt.txF.add(paramContext);
                          paramContext = paramcb.fFr.fFu;
                          paramContext.tyd += 1;
                          bool = true;
                          break;
                          paramContext = new rt();
                          paramContext.Ov(((f.a)localObject1).title);
                          paramContext.Ow(((f.a)localObject1).description);
                          paramContext.yb(((f.a)localObject1).hhH);
                          paramContext.Oy(((f.a)localObject1).hhI);
                          paramContext.Ox(((f.a)localObject1).thumburl);
                          paramau.a(paramContext);
                          paramContext = new rl();
                          paramContext.Oc(U(localau));
                          paramContext.xW(11);
                          paramContext.jH(true);
                          paramContext.jG(true);
                          paramContext.a(paramau);
                          paramContext.Of(a(paramau.twM));
                          paramContext.Og(b(paramau.twM));
                          paramcb.fFr.fFt.txF.add(paramContext);
                          paramContext = paramcb.fFr.fFu;
                          paramContext.tya += 1;
                          bool = true;
                          break;
                          if ((((f.a)localObject1).hhG != null) && (((f.a)localObject1).hhG.contains("<recordxml>"))) {}
                          for (i = 1;; i = 0)
                          {
                            if (i != 0) {
                              break label3668;
                            }
                            localObject2 = new rl();
                            ((rl)localObject2).Oc(U(localau));
                            ((rl)localObject2).xW(17);
                            ((rl)localObject2).jH(true);
                            ((rl)localObject2).NK(((f.a)localObject1).title);
                            ((rl)localObject2).Ok(((f.a)localObject1).hhG);
                            paramContext = ((f.a)localObject1).description;
                            lz locallz = new lz();
                            locallz.fSV.type = 0;
                            locallz.fSV.fSX = ((f.a)localObject1).hhG;
                            com.tencent.mm.sdk.b.a.uql.m(locallz);
                            localObject1 = locallz.fSW.fTf;
                            if (localObject1 != null) {
                              paramContext = ((com.tencent.mm.protocal.b.a.c)localObject1).desc;
                            }
                            ((rl)localObject2).NL(paramContext);
                            ((rl)localObject2).a(paramau);
                            ((rl)localObject2).Of(a(paramau.twM));
                            ((rl)localObject2).Og(b(paramau.twM));
                            ((rl)localObject2).el(localau.field_msgId);
                            paramcb.fFr.fFt.txF.add(localObject2);
                            bool = true;
                            break;
                          }
                          label3668:
                          if (paramBoolean)
                          {
                            paramContext = a(localau, paramContext.getString(R.l.ejJ), paramau);
                            paramcb.fFr.fFt.txF.add(paramContext);
                            bool = true;
                            break;
                          }
                          if (paramBoolean)
                          {
                            paramContext = a(localau, paramContext.getString(R.l.dIe), paramau);
                            paramcb.fFr.fFt.txF.add(paramContext);
                            bool = true;
                            break;
                          }
                        }
                      }
                      paramcb.fFr.fFx = R.l.eib;
                      bool = false;
                    }
                  }
                }
              }
            }
            else
            {
              paramcb.fFr.fFx = R.l.eib;
              if (paramBoolean) {
                bool = a(paramContext, paramcb, localau, 3);
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, cb paramcb, String paramString, List<au> paramList, boolean paramBoolean)
  {
    GMTrace.i(768664928256L, 5727);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      v.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
      paramcb.fFr.fFx = R.l.ehT;
      GMTrace.o(768664928256L, 5727);
      return false;
    }
    boolean bool = com.tencent.mm.modelbiz.e.dr(paramString);
    Object localObject;
    if (paramList.size() == 1)
    {
      paramList = (au)paramList.get(0);
      if ((paramList.bLN()) || (paramList.bLO()))
      {
        localObject = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).rR(paramList.field_content);
        if ((((k)localObject).hkc != null) && (((k)localObject).hkc.size() == 1))
        {
          paramBoolean = e.a(paramcb, paramList);
          GMTrace.o(768664928256L, 5727);
          return paramBoolean;
        }
        paramcb.fFr.fFt = new ru();
        paramcb.fFr.fFu = new sd();
        paramcb.fFr.fFt.a(LP(paramString));
        paramcb.fFr.type = 14;
        paramBoolean = a(paramContext, paramcb, paramList, paramBoolean);
        GMTrace.o(768664928256L, 5727);
        return paramBoolean;
      }
      paramBoolean = e.a(paramcb, paramList);
      GMTrace.o(768664928256L, 5727);
      return paramBoolean;
    }
    paramcb.fFr.fFt = new ru();
    paramcb.fFr.fFu = new sd();
    int i;
    if (paramContext != null)
    {
      if (!bool) {
        break label470;
      }
      localObject = com.tencent.mm.modelbiz.a.e.ad(((au)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.modelbiz.a.e.it((String)localObject))
      {
        paramcb.fFr.fFt.OA(paramContext.getString(R.l.eIx));
        v.d("MicroMsg.GetFavRecordDataSource", "title %s", new Object[] { paramcb.fFr.fFt.title });
      }
    }
    else
    {
      paramcb.fFr.fFt.a(LP(paramString));
      paramcb.fFr.type = 14;
      paramString = paramList.iterator();
      i = 0;
      bool = true;
    }
    for (;;)
    {
      if (!paramString.hasNext()) {
        break label589;
      }
      if (a(paramContext, paramcb, (au)paramString.next(), paramBoolean))
      {
        i = 1;
        continue;
        j localj = com.tencent.mm.modelbiz.a.e.iw(paramString);
        paramcb.fFr.fFt.OA(paramContext.getString(R.l.eiT, new Object[] { localj.field_userName, com.tencent.mm.modelbiz.a.e.iu((String)localObject) }));
        break;
        label470:
        if (com.tencent.mm.u.o.dH(paramString))
        {
          paramcb.fFr.fFt.OA(paramContext.getString(R.l.eIx));
          break;
        }
        localObject = m.xN();
        if (((String)localObject).equals(com.tencent.mm.u.n.eJ(paramString)))
        {
          paramcb.fFr.fFt.OA(paramContext.getString(R.l.eiU, new Object[] { localObject }));
          break;
        }
        paramcb.fFr.fFt.OA(paramContext.getString(R.l.eiT, new Object[] { m.xN(), com.tencent.mm.u.n.eJ(paramString) }));
        break;
      }
      bool = false;
    }
    label589:
    if ((i != 0) && (paramcb.fFr.fFx > 0)) {
      paramcb.fFr.fFx = 0;
    }
    GMTrace.o(768664928256L, 5727);
    return bool;
  }
  
  private static boolean a(cb paramcb, au paramau, boolean paramBoolean)
  {
    GMTrace.i(15697702813696L, 116957);
    Object localObject = new rm();
    ((rm)localObject).c(T(paramau));
    rl localrl = new rl();
    localrl.Oc(U(paramau));
    com.tencent.mm.modelvideo.o.KW();
    localrl.NY(com.tencent.mm.modelvideo.s.lw(paramau.field_imgPath));
    com.tencent.mm.modelvideo.o.KW();
    localrl.NZ(com.tencent.mm.modelvideo.s.lx(paramau.field_imgPath));
    localrl.NU(com.tencent.mm.a.e.aQ(localrl.tvY));
    if (paramau.bMc()) {
      localrl.xW(15);
    }
    r localr;
    for (;;)
    {
      localr = t.lI(paramau.field_imgPath);
      v.i("MicroMsg.GetFavRecordDataSource", "video length is %d", new Object[] { Integer.valueOf(localr.hrb) });
      if (localr.hrb <= com.tencent.mm.i.b.sD()) {
        break;
      }
      paramcb.fFr.fFx = R.l.ejz;
      GMTrace.o(15697702813696L, 116957);
      return false;
      localrl.xW(4);
    }
    if ((paramau.bMc()) && (t.lK(localr.getFileName())))
    {
      paramcb.fFr.fFx = R.l.ehS;
      GMTrace.o(15697702813696L, 116957);
      return false;
    }
    localrl.xV(localr.hZV);
    localrl.a((rm)localObject);
    localrl.Of(a(((rm)localObject).twM));
    localrl.Og(b(((rm)localObject).twM));
    localrl.el(paramau.field_msgId);
    localrl.ej(localr.hrb);
    if (paramBoolean)
    {
      localObject = bg.q(localr.Li(), "msg");
      if (localObject == null) {
        break label495;
      }
      localrl.NO((String)((Map)localObject).get(".msg.videomsg.$cdnvideourl"));
      localrl.NP((String)((Map)localObject).get(".msg.videomsg.$aeskey"));
    }
    for (;;)
    {
      paramcb.fFr.fFt.txF.add(localrl);
      paramcb = paramcb.fFr.fFu;
      paramcb.txT += 1;
      paramcb = t.lI(paramau.field_imgPath);
      localrl.Oi(paramcb.fUO);
      paramcb = paramcb.iae;
      if ((paramcb != null) && (!bf.mA(paramcb.hjz)))
      {
        paramau = new ro();
        paramau.hjt = paramcb.hjt;
        paramau.txr = paramcb.txr;
        paramau.hjw = paramcb.hjw;
        paramau.hjx = paramcb.hjx;
        paramau.hjv = paramcb.hjv;
        paramau.hjy = paramcb.hjy;
        paramau.hjz = paramcb.hjz;
        paramau.hjA = paramcb.hjA;
        localrl.a(paramau);
      }
      GMTrace.o(15697702813696L, 116957);
      return true;
      label495:
      v.i("MicroMsg.GetFavRecordDataSource", "cdntra parse video recv xml failed");
    }
  }
  
  private static String b(rn paramrn)
  {
    GMTrace.i(769470234624L, 5733);
    paramrn = rZv.format(new Date(paramrn.hZS));
    GMTrace.o(769470234624L, 5733);
    return paramrn;
  }
  
  private static boolean b(cb paramcb, au paramau)
  {
    GMTrace.i(769738670080L, 5735);
    rm localrm = new rm();
    localrm.c(T(paramau));
    Object localObject = bg.q(paramau.field_content, "msg");
    if (localObject != null) {
      try
      {
        rr localrr = new rr();
        localrr.Ot((String)((Map)localObject).get(".msg.location.$label"));
        localrr.m(Double.parseDouble((String)((Map)localObject).get(".msg.location.$x")));
        localrr.l(Double.parseDouble((String)((Map)localObject).get(".msg.location.$y")));
        localrr.ya(Integer.valueOf((String)((Map)localObject).get(".msg.location.$scale")).intValue());
        localrr.Ou((String)((Map)localObject).get(".msg.location.$poiname"));
        localrm.a(localrr);
        localObject = new rl();
        ((rl)localObject).Oc(U(paramau));
        ((rl)localObject).xW(6);
        ((rl)localObject).jH(true);
        ((rl)localObject).jG(true);
        ((rl)localObject).a(localrm);
        ((rl)localObject).Of(a(localrm.twM));
        ((rl)localObject).Og(b(localrm.twM));
        paramcb.fFr.fFt.txF.add(localObject);
        paramau = paramcb.fFr.fFu;
        paramau.txV += 1;
        GMTrace.o(769738670080L, 5735);
        return true;
      }
      catch (Exception paramau)
      {
        v.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", new Object[] { paramau.getStackTrace().toString() });
      }
    }
    paramcb.fFr.fFx = R.l.eic;
    GMTrace.o(769738670080L, 5735);
    return false;
  }
  
  private static boolean c(cb paramcb, au paramau)
  {
    GMTrace.i(770275540992L, 5739);
    for (;;)
    {
      try
      {
        k localk = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).rR(paramau.field_content);
        localObject = localk.hkc;
        if (localObject != null)
        {
          Iterator localIterator = ((List)localObject).iterator();
          int i = 0;
          if (!localIterator.hasNext()) {
            break label465;
          }
          l locall = (l)localIterator.next();
          rm localrm = new rm();
          localrm.c(T(paramau));
          localrm.twM.Os(localk.fUH);
          localrm.twM.Or(locall.url);
          rl localrl = new rl();
          localrl.NK(locall.title);
          localrl.NL(locall.hkk);
          localrl.Oc(U(paramau));
          if (!bf.mA(locall.hki))
          {
            String str = locall.hki;
            int j = paramau.field_type;
            if (i != 0) {
              break label476;
            }
            localObject = "@T";
            localrl.NZ(s.n(str, j, (String)localObject));
            localrl.jG(true);
            localObject = new se();
            if (!bf.mA(locall.title)) {
              ((se)localObject).OP(locall.title);
            }
            if (!bf.mA(locall.hkk)) {
              ((se)localObject).OQ(locall.hkk);
            }
            if (!bf.mA(locall.hki)) {
              ((se)localObject).OS(locall.hki);
            }
            if (((se)localObject).aUd() > 0)
            {
              ((se)localObject).yf(1);
              localrm.a((se)localObject);
            }
            localrl.xW(5);
            localrl.a(localrm);
            localrl.Of(a(localrm.twM));
            localrl.Og(b(localrm.twM));
            paramcb.fFr.fFt.txF.add(localrl);
            localObject = paramcb.fFr.fFu;
            ((sd)localObject).txU += 1;
            i += 1;
            continue;
          }
          localrl.jH(true);
          continue;
        }
        GMTrace.o(770275540992L, 5739);
      }
      catch (Exception paramau)
      {
        v.printErrStackTrace("MicroMsg.GetFavRecordDataSource", paramau, "", new Object[0]);
        v.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", new Object[] { paramau.getLocalizedMessage() });
        paramcb.fFr.fFx = R.l.eic;
        GMTrace.o(770275540992L, 5739);
        return false;
      }
      label465:
      return true;
      label476:
      Object localObject = "@S";
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */