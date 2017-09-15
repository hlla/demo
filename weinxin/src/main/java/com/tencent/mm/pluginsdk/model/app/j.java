package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.e.a.ai;
import com.tencent.mm.e.a.ai.a;
import com.tencent.mm.e.a.bq;
import com.tencent.mm.e.a.lq;
import com.tencent.mm.e.a.lt;
import com.tencent.mm.e.a.rn;
import com.tencent.mm.e.a.ro;
import com.tencent.mm.e.a.sp;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.t.f.a.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j
  implements com.tencent.mm.y.d
{
  a sBM;
  
  public j()
  {
    GMTrace.i(789468676096L, 5882);
    this.sBM = null;
    GMTrace.o(789468676096L, 5882);
  }
  
  private d.b a(d.a parama, String paramString, f.a parama1)
  {
    GMTrace.i(790139764736L, 5887);
    localbu = parama.hsc;
    ap.yY();
    localc = com.tencent.mm.u.c.wT();
    ap.yY();
    localObject1 = com.tencent.mm.u.c.wZ();
    Object localObject2 = m.xL();
    final Object localObject3 = com.tencent.mm.platformtools.n.a(localbu.tdx);
    String str1 = com.tencent.mm.platformtools.n.a(localbu.tdy);
    int i;
    label92:
    label341:
    final int j;
    label419:
    final boolean bool;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.a.f)localObject1).has((String)localObject3)) || (((String)localObject2).equals(localObject3)))
    {
      i = 1;
      if (i == 0) {
        break label1466;
      }
      localObject1 = str1;
      localObject2 = localc.x((String)localObject1, localbu.tdE);
      v.d("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", new Object[] { Long.valueOf(localbu.tdE), Long.valueOf(((ce)localObject2).field_msgId) });
      if ((((ce)localObject2).field_msgId != 0L) && (((ce)localObject2).field_createTime + 604800000L < ay.i((String)localObject3, localbu.ofk)))
      {
        v.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localbu.tdE), Long.valueOf(((ce)localObject2).field_msgId) });
        ay.L(((ce)localObject2).field_msgId);
        ((au)localObject2).x(0L);
      }
      localObject1 = localObject2;
      if (((ce)localObject2).field_msgId == 0L)
      {
        localObject1 = new au();
        ((au)localObject1).y(localbu.tdE);
        ((au)localObject1).z(ay.i((String)localObject3, localbu.ofk));
      }
      if (parama1.hhd != null)
      {
        ((au)localObject1).cP(parama1.hhd.gxE);
        v.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", new Object[] { ((ce)localObject1).gxE });
      }
      ((au)localObject1).setType(l.d(parama1));
      if ((!((au)localObject1).bLN()) && (!((au)localObject1).bLO())) {
        break label1473;
      }
      localObject2 = parama1.content;
      ((au)localObject1).setContent((String)localObject2);
      if (((au)localObject1).bLN()) {
        ((au)localObject1).cM(parama1.gxt);
      }
      if ((localbu.tdA != 2) || (((ce)localObject1).field_msgId != 0L)) {
        break label1990;
      }
      switch (((ce)localObject1).field_type)
      {
      default: 
        j = 0;
        if (j == 0) {
          if (parama1.type == 2)
          {
            bool = true;
            label435:
            localObject2 = com.tencent.mm.platformtools.n.a(localbu.tdB);
            if (com.tencent.mm.platformtools.r.iiI)
            {
              v.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
              localObject2 = null;
            }
            if (bf.bm((byte[])localObject2)) {
              break label1508;
            }
            if ((parama1.type != 33) && (parama1.type != 36)) {
              break label1491;
            }
            localObject2 = com.tencent.mm.ah.n.GT().a((byte[])localObject2, Bitmap.CompressFormat.PNG);
            label500:
            if (bf.mA((String)localObject2)) {
              v.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", new Object[] { ((ce)localObject1).field_content });
            }
            if (!bf.mA((String)localObject2))
            {
              ((au)localObject1).cI((String)localObject2);
              v.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path" + (String)localObject2);
            }
            label566:
            if (i == 0) {
              break label2149;
            }
            ((au)localObject1).dw(1);
            ((au)localObject1).cH(str1);
            i = localbu.jLP;
            label591:
            ((au)localObject1).dv(i);
            if ((parama1.type == 2001) && (parama1.showType == 1))
            {
              if ((TextUtils.isEmpty(parama1.hiP)) || (TextUtils.isEmpty(parama1.hiQ)) || (parama1.hiR <= 0)) {
                break label2187;
              }
              v.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
              localObject2 = new ai();
              ((ai)localObject2).fDw = new ai.a();
              ((ai)localObject2).fDw.fDy = parama1.hiQ;
              ((ai)localObject2).fDw.fDx = parama1.hiP;
              ((ai)localObject2).fDw.fDz = parama1.hiR;
              com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (parama1.type == 2001) {}
      try
      {
        if (!bf.bV(parama1.hjb))
        {
          localObject2 = parama1.hjb.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((String)((Iterator)localObject2).next()).split(",");
            if ((localObject3 != null) && (localObject3.length > 0))
            {
              localObject3 = localObject3[0];
              if ((!bf.mA((String)localObject3)) && (((String)localObject3).equals(m.xL())))
              {
                ((au)localObject1).dF(((ce)localObject1).field_flag | 0x8);
                v.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          final long l1;
          final long l2;
          final String str2;
          int m;
          final Object localObject4;
          Object localObject5;
          int k;
          c.a locala;
          v.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", new Object[] { localException.getMessage() });
          continue;
          localc.b(localbu.tdE, (au)localObject1);
          parama = new d.b((au)localObject1, false);
        }
      }
      ((au)localObject1).cN(localbu.tdC);
      localObject2 = ay.gm(localbu.tdC);
      if (localObject2 != null)
      {
        ((au)localObject1).cO(((ay.b)localObject2).hmy);
        ((au)localObject1).cL(((ay.b)localObject2).hmx);
      }
      ay.a((au)localObject1, parama);
      if (((ce)localObject1).field_msgId != 0L) {
        break label2223;
      }
      ((au)localObject1).x(ay.i((au)localObject1));
      parama = new com.tencent.mm.e.a.t();
      parama.fCP.fCQ = ((au)localObject1);
      parama.fCP.fCR = parama1;
      com.tencent.mm.sdk.b.a.uql.m(parama);
      parama = new d.b((au)localObject1, true);
      if ((((ce)localObject1).field_type == 301989937) && (o.fy(((ce)localObject1).field_talker))) {
        ((au)localObject1).x(0L);
      }
      if ((((au)localObject1).bLV()) && ("notifymessage".equals(((ce)localObject1).field_talker)))
      {
        localObject2 = bg.q(((ce)localObject1).field_content, "msg");
        if (localObject2 != null)
        {
          localObject2 = bf.mz((String)((Map)localObject2).get(".msg.fromusername"));
          if (x.em((String)localObject2))
          {
            localObject3 = new com.tencent.mm.e.a.r();
            ((com.tencent.mm.e.a.r)localObject3).fCL.fCA = ((String)localObject2);
            v.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", new Object[] { localObject2 });
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject3);
          }
        }
      }
      if ((!bf.mA(parama1.hiU)) && (((ce)localObject1).field_type == 436207665))
      {
        localObject2 = new lq();
        ((lq)localObject2).fSD.fSE = ((ce)localObject1).field_msgId;
        ((lq)localObject2).fSD.fSi = paramString;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
      }
      if ((parama1.type == 2000) && (!bf.mA(parama1.hil)))
      {
        paramString = new lt();
        paramString.fSI.fSJ = parama1.hil;
        paramString.fSI.fGD = ((ce)localObject1).field_msgId;
        paramString.fSI.fSK = parama1;
        com.tencent.mm.sdk.b.a.uql.m(paramString);
      }
      parama1 = parama1.hjP;
      paramString = bf.ap((String)parama1.get(".msg.appmsg.ext_pay_info.pay_type"), "");
      if (((paramString.equals("wx_f2f")) || (paramString.equals("wx_md"))) && (parama.hsg))
      {
        l1 = ((ce)localObject1).field_createTime;
        l2 = System.currentTimeMillis();
        v.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
        if (l2 - l1 <= 60000L)
        {
          localObject1 = new bq();
          i = bf.getInt((String)parama1.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
          localObject2 = bf.mz((String)parama1.get(".msg.appmsg.ext_pay_info.pay_feetype"));
          parama1 = bf.mz((String)parama1.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
          if ((i > 0) && (!bf.mA((String)localObject2)) && (!bf.mA(parama1)))
          {
            ((bq)localObject1).fET.bPh = i;
            ((bq)localObject1).fET.fEU = ((String)localObject2);
            ((bq)localObject1).fET.fEV = parama1;
            ((bq)localObject1).fET.fEW = paramString;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
          }
        }
      }
      GMTrace.o(790139764736L, 5887);
      return parama;
      i = 0;
      break;
      label1466:
      localObject1 = localObject3;
      break label92;
      label1473:
      localObject2 = paramString;
      break label341;
      j = 1;
      break label419;
      bool = false;
      break label435;
      label1491:
      localObject2 = a((byte[])localObject2, bool, ((au)localObject1).bMe());
      break label500;
      label1508:
      if ((!bf.mA(parama1.hho)) && (!bf.mA(parama1.hhv)))
      {
        l1 = ((ce)localObject1).field_msgSvrId;
        localObject2 = parama1.hhv;
        str2 = parama1.hho;
        m = parama1.hhp;
        v.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", new Object[] { Long.valueOf(((ce)localObject1).field_msgSvrId), localObject2, Integer.valueOf(m), str2, localObject3, Boolean.valueOf(bool) });
        l2 = bf.NA();
        if (parama1 != null)
        {
          j = parama1.type;
          label1623:
          localObject4 = com.tencent.mm.ah.n.GT().m(bf.NA(), "", "");
          localObject5 = new com.tencent.mm.modelcdntran.h();
          ((com.tencent.mm.modelcdntran.h)localObject5).field_mediaId = com.tencent.mm.modelcdntran.d.a("downappthumb", ((ce)localObject1).field_createTime, (String)localObject3, String.valueOf(l1));
          ((com.tencent.mm.modelcdntran.h)localObject5).field_fullpath = ((String)localObject4);
          ((com.tencent.mm.modelcdntran.h)localObject5).field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
          ((com.tencent.mm.modelcdntran.h)localObject5).field_totalLen = m;
          ((com.tencent.mm.modelcdntran.h)localObject5).field_aesKey = ((String)localObject2);
          ((com.tencent.mm.modelcdntran.h)localObject5).field_fileId = str2;
          ((com.tencent.mm.modelcdntran.h)localObject5).field_priority = com.tencent.mm.modelcdntran.b.hxu;
          if (!o.dH((String)localObject3)) {
            break label1825;
          }
        }
        label1825:
        for (k = 1;; k = 0)
        {
          ((com.tencent.mm.modelcdntran.h)localObject5).field_chattype = k;
          v.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.modelcdntran.h)localObject5).field_chattype), localObject3 });
          ((com.tencent.mm.modelcdntran.h)localObject5).hyM = new h.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
            {
              GMTrace.i(816178003968L, 6081);
              if (paramAnonymousInt != 0)
              {
                v.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", new Object[] { Long.valueOf(localObject1.field_msgSvrId), Integer.valueOf(paramAnonymousInt), str2 });
                com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l2), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(localObject4), "" });
                GMTrace.o(816178003968L, 6081);
                return paramAnonymousInt;
              }
              if (paramAnonymouskeep_SceneResult == null)
              {
                GMTrace.o(816178003968L, 6081);
                return 0;
              }
              com.tencent.mm.plugin.report.service.g localg;
              label225:
              long l1;
              long l2;
              int i;
              int j;
              int k;
              if (paramAnonymouskeep_SceneResult.field_retCode != 0)
              {
                v.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Long.valueOf(localObject1.field_msgSvrId), Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), str2 });
                localg = com.tencent.mm.plugin.report.service.g.oSF;
                if (paramAnonymouskeep_SceneResult != null) {
                  break label807;
                }
                paramAnonymousInt = -1;
                l1 = l2;
                l2 = bf.NA();
                i = com.tencent.mm.modelcdntran.d.aU(aa.getContext());
                j = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                k = localObject4;
                if (paramAnonymouskeep_SceneResult != null) {
                  break label816;
                }
                paramAnonymousString = "";
                label263:
                if (paramAnonymouskeep_SceneResult != null) {
                  break label825;
                }
                paramAnonymouskeep_ProgressInfo = "";
                label271:
                localg.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
                if ((paramAnonymouskeep_SceneResult != null) && (paramAnonymouskeep_SceneResult.field_retCode != 0))
                {
                  localg = com.tencent.mm.plugin.report.service.g.oSF;
                  if (paramAnonymouskeep_SceneResult != null) {
                    break label834;
                  }
                  paramAnonymousInt = -1;
                  label416:
                  l1 = l2;
                  l2 = bf.NA();
                  i = com.tencent.mm.modelcdntran.d.aU(aa.getContext());
                  j = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                  k = localObject4;
                  if (paramAnonymouskeep_SceneResult != null) {
                    break label843;
                  }
                  paramAnonymousString = "";
                  label454:
                  if (paramAnonymouskeep_SceneResult != null) {
                    break label852;
                  }
                }
              }
              label638:
              label799:
              label807:
              label816:
              label825:
              label834:
              label843:
              label852:
              for (paramAnonymouskeep_ProgressInfo = "";; paramAnonymouskeep_ProgressInfo = paramAnonymouskeep_SceneResult.report_Part2)
              {
                localg.i(13937, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
                com.tencent.mm.ah.n.GT().doNotify();
                GMTrace.o(816178003968L, 6081);
                return 0;
                paramAnonymousString = e.c(j, 0, -1);
                if ((bool == 33) || (bool == 36))
                {
                  paramAnonymousString = com.tencent.mm.ah.n.GT().a(paramAnonymousString, Bitmap.CompressFormat.PNG);
                  if (!bf.mA(paramAnonymousString))
                  {
                    localObject1.cI(paramAnonymousString);
                    ap.yY();
                    com.tencent.mm.u.c.wT().b(localObject1.field_msgSvrId, localObject1);
                  }
                  v.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", new Object[] { Long.valueOf(localObject3), this.gTs, str2, paramAnonymousString });
                  com.tencent.mm.plugin.report.service.g.oSF.a(198L, 16L, localObject4, false);
                  com.tencent.mm.plugin.report.service.g.oSF.a(198L, 17L, 1L, false);
                  paramAnonymousString = com.tencent.mm.plugin.report.service.g.oSF;
                  if (!o.dH(this.gTs)) {
                    break label799;
                  }
                }
                for (l1 = 19L;; l1 = 18L)
                {
                  paramAnonymousString.a(198L, l1, 1L, false);
                  break;
                  paramAnonymousString = j.a(paramAnonymousString, l1, localObject1.bMe());
                  break label638;
                }
                paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
                break label225;
                paramAnonymousString = paramAnonymouskeep_SceneResult.field_transInfo;
                break label263;
                paramAnonymouskeep_ProgressInfo = paramAnonymouskeep_SceneResult.report_Part2;
                break label271;
                paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
                break label416;
                paramAnonymousString = paramAnonymouskeep_SceneResult.field_transInfo;
                break label454;
              }
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
            {
              GMTrace.i(816312221696L, 6082);
              GMTrace.o(816312221696L, 6082);
            }
            
            public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              GMTrace.i(816446439424L, 6083);
              GMTrace.o(816446439424L, 6083);
              return null;
            }
          };
          com.tencent.mm.modelcdntran.g.Em().b((com.tencent.mm.modelcdntran.h)localObject5, -1);
          break;
          j = 0;
          break label1623;
        }
      }
      if (bf.mA(parama1.thumburl)) {
        break label566;
      }
      v.d("MicroMsg.AppMessageExtension", "get cdn image " + parama1.thumburl);
      str2 = com.tencent.mm.a.g.n(bf.NA().getBytes());
      localObject2 = com.tencent.mm.ah.n.GT().jt(str2);
      com.tencent.mm.ah.n.GT();
      str2 = com.tencent.mm.ah.f.ju(str2);
      localObject4 = com.tencent.mm.ah.n.GX();
      localObject5 = parama1.thumburl;
      locala = new c.a();
      locala.hIv = ((String)localObject2);
      locala.hIt = true;
      ((com.tencent.mm.ah.a.a)localObject4).a((String)localObject5, null, locala.Hh());
      ((au)localObject1).cI(str2);
      v.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + (String)localObject2);
      break label566;
      label1990:
      if (bf.mA(parama1.thumburl)) {
        break label566;
      }
      v.d("MicroMsg.AppMessageExtension", "get cdn image " + parama1.thumburl);
      str2 = com.tencent.mm.a.g.n(bf.NA().getBytes());
      localObject2 = com.tencent.mm.ah.n.GT().jt(str2);
      com.tencent.mm.ah.n.GT();
      str2 = com.tencent.mm.ah.f.ju(str2);
      localObject4 = com.tencent.mm.ah.n.GX();
      localObject5 = parama1.thumburl;
      locala = new c.a();
      locala.hIv = ((String)localObject2);
      locala.hIt = true;
      ((com.tencent.mm.ah.a.a)localObject4).a((String)localObject5, null, locala.Hh());
      ((au)localObject1).cI(str2);
      v.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + (String)localObject2);
      break label566;
      label2149:
      ((au)localObject1).dw(0);
      ((au)localObject1).cH((String)localObject3);
      if (localbu.jLP > 3)
      {
        i = localbu.jLP;
        break label591;
      }
      i = 3;
      break label591;
      label2187:
      v.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
    }
  }
  
  public static String a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(790005547008L, 5886);
    paramArrayOfByte = com.tencent.mm.ah.n.GT().a(9, paramArrayOfByte, paramBoolean1, Bitmap.CompressFormat.PNG, paramBoolean2);
    GMTrace.o(790005547008L, 5886);
    return paramArrayOfByte;
  }
  
  public static String c(bu parambu)
  {
    GMTrace.i(789602893824L, 5883);
    String str1 = com.tencent.mm.platformtools.n.a(parambu.tdx);
    String str2 = com.tencent.mm.platformtools.n.a(parambu.tdy);
    if ((bf.mA(str1)) || (bf.mA(str2)))
    {
      v.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
      GMTrace.o(789602893824L, 5883);
      return null;
    }
    parambu = el(str1, com.tencent.mm.platformtools.n.a(parambu.tdz));
    GMTrace.o(789602893824L, 5883);
    return parambu;
  }
  
  public static String el(String paramString1, String paramString2)
  {
    GMTrace.i(789737111552L, 5884);
    if (bf.mA(paramString2))
    {
      GMTrace.o(789737111552L, 5884);
      return null;
    }
    String str = paramString2;
    if (o.dH(paramString1))
    {
      int i = ay.gh(paramString2);
      str = paramString2;
      if (i != -1) {
        str = (paramString2 + " ").substring(i + 2).trim();
      }
    }
    paramString1 = bf.PW(str);
    GMTrace.o(789737111552L, 5884);
    return paramString1;
  }
  
  public final boolean a(final a parama, String paramString1, long paramLong, String paramString2, final String paramString3, int paramInt, String paramString4)
  {
    GMTrace.i(790408200192L, 5889);
    String str = com.tencent.mm.ah.n.GT().m("Note_" + paramString1, "", "");
    if (FileOp.aO(str))
    {
      GMTrace.o(790408200192L, 5889);
      return false;
    }
    this.sBM = parama;
    com.tencent.mm.modelcdntran.h localh = new com.tencent.mm.modelcdntran.h();
    localh.field_mediaId = com.tencent.mm.modelcdntran.d.a("downappthumb", paramLong, paramString4, paramString1);
    localh.field_fullpath = str;
    localh.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
    localh.field_totalLen = paramInt;
    localh.field_aesKey = paramString2;
    localh.field_fileId = paramString3;
    localh.field_priority = com.tencent.mm.modelcdntran.b.hxu;
    if (o.dH(paramString4)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localh.field_chattype = paramInt;
      v.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(localh.field_chattype), paramString4 });
      localh.hyM = new h.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
        {
          GMTrace.i(821278277632L, 6119);
          v.i("MicroMsg.AppMessageExtension", "getThumbByCdn start callback: field_mediaId:%s thumbUrl:%s", new Object[] { paramAnonymousString, paramString3 });
          if (paramAnonymousInt != 0)
          {
            v.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: startRet:%d thumbUrl:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramString3 });
            GMTrace.o(821278277632L, 6119);
            return paramAnonymousInt;
          }
          if (paramAnonymouskeep_SceneResult == null)
          {
            GMTrace.o(821278277632L, 6119);
            return 0;
          }
          if (paramAnonymouskeep_SceneResult.field_retCode != 0) {
            v.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), paramString3 });
          }
          for (;;)
          {
            com.tencent.mm.ah.n.GT().doNotify();
            if (parama != null) {
              parama.bCV();
            }
            GMTrace.o(821278277632L, 6119);
            return 0;
            v.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished thumbUrl:%s", new Object[] { paramString3 });
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
        {
          GMTrace.i(821412495360L, 6120);
          GMTrace.o(821412495360L, 6120);
        }
        
        public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          GMTrace.i(821546713088L, 6121);
          GMTrace.o(821546713088L, 6121);
          return null;
        }
      };
      com.tencent.mm.modelcdntran.g.Em().b(localh, -1);
      GMTrace.o(790408200192L, 5889);
      return true;
    }
  }
  
  public final d.b b(d.a parama)
  {
    GMTrace.i(789871329280L, 5885);
    v.d("MicroMsg.AppMessageExtension", "process add app message");
    Object localObject3 = parama.hsc;
    Object localObject2 = c((bu)localObject3);
    f.a locala = f.a.ek((String)localObject2);
    if (locala == null)
    {
      v.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
      GMTrace.o(789871329280L, 5885);
      return null;
    }
    if (locala.hiS)
    {
      ap.yY();
      com.tencent.mm.u.c.vr().set(352273, localObject2);
      ap.yY();
      com.tencent.mm.u.c.vr().set(352274, Long.valueOf(System.currentTimeMillis()));
      new a((String)localObject2).bCL();
      GMTrace.o(789871329280L, 5885);
      return null;
    }
    f localf = an.aRk().Md(locala.appId);
    String str = locala.appId;
    int i = locala.fWv;
    if (localf == null) {}
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(localf.field_appVersion))
    {
      v.i("MicroMsg.AppMessageExtension", "check version appid:%s, msgVer:%d, appVer:%s", new Object[] { str, Integer.valueOf(i), localObject1 });
      if ((localf == null) || (localf.field_appVersion < locala.fWv)) {
        an.aRj().Mb(locala.appId);
      }
      parama = a(parama, com.tencent.mm.platformtools.n.a(((bu)localObject3).tdz), locala);
      if (parama.fCQ != null) {
        break;
      }
      GMTrace.o(789871329280L, 5885);
      return null;
    }
    localObject1 = parama.fCQ;
    if ((((au)localObject1).bLN()) || (((au)localObject1).bLO()))
    {
      if (!bf.mA(locala.hjM))
      {
        localObject1 = new sp();
        ((sp)localObject1).gaf.fQO = locala.hjM;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
      }
      GMTrace.o(789871329280L, 5885);
      return parama;
    }
    if (((ce)localObject1).field_type == 301989937)
    {
      GMTrace.o(789871329280L, 5885);
      return parama;
    }
    if (((ce)localObject1).field_type == -1879048190)
    {
      localObject3 = new ro();
      ((ro)localObject3).fYq.fQO = ((String)localObject2);
      ((ro)localObject3).fYq.description = locala.description;
      ((ro)localObject3).fYq.fCQ = ((au)localObject1);
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject3);
    }
    if ((((ce)localObject1).field_type == 49) && (!bf.mA(locala.canvasPageXml)))
    {
      localObject3 = new com.tencent.mm.e.a.g();
      ((com.tencent.mm.e.a.g)localObject3).fCh.fCi = locala.canvasPageXml;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject3);
    }
    localObject3 = new com.tencent.mm.t.f();
    locala.a((com.tencent.mm.t.f)localObject3);
    ((com.tencent.mm.t.f)localObject3).field_msgId = ((ce)localObject1).field_msgId;
    if (an.bDc().b((com.tencent.mm.sdk.e.c)localObject3))
    {
      if (locala.type == 40)
      {
        localObject3 = an.abF().eb(((ce)localObject1).field_msgId);
        localObject2 = com.tencent.mm.t.j.eo((String)localObject2);
        if (localObject3 == null) {
          l.a(null, ((ce)localObject1).field_msgId, 0, null, null, ((com.tencent.mm.t.j)localObject2).hke, locala.type, 0);
        }
        localObject1 = new ab(((ce)localObject1).field_msgId, ((ce)localObject1).field_msgSvrId, null);
        ap.vd().a((com.tencent.mm.y.k)localObject1, 0);
      }
      GMTrace.o(789871329280L, 5885);
      return parama;
    }
    GMTrace.o(789871329280L, 5885);
    return null;
  }
  
  public final void h(au paramau)
  {
    GMTrace.i(790273982464L, 5888);
    v.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + paramau.field_imgPath);
    rn localrn = new rn();
    localrn.fYp.path = paramau.field_imgPath;
    com.tencent.mm.sdk.b.a.uql.m(localrn);
    GMTrace.o(790273982464L, 5888);
  }
  
  public static abstract interface a
  {
    public abstract void bCV();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */