package com.tencent.mm.modelvideo;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public final class u
  implements com.tencent.mm.y.d
{
  public u()
  {
    GMTrace.i(331517788160L, 2470);
    GMTrace.o(331517788160L, 2470);
  }
  
  public final d.b b(d.a arg1)
  {
    GMTrace.i(331652005888L, 2471);
    Object localObject5 = ???.hsc;
    if (localObject5 == null)
    {
      v.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      GMTrace.o(331652005888L, 2471);
      return null;
    }
    final String str1 = (String)com.tencent.mm.kernel.h.vI().vr().get(2, "");
    Object localObject1 = n.a(((bu)localObject5).tdy);
    Object localObject3 = n.a(((bu)localObject5).tdx);
    boolean bool1;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wZ().has((String)localObject3)) || (str1.equals(localObject3)))
    {
      bool1 = true;
      v.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", new Object[] { localObject3, localObject1, str1, Boolean.valueOf(bool1) });
      localObject6 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ();
      if (!str1.equals(localObject3)) {
        break label380;
      }
    }
    label380:
    for (Object localObject4 = localObject1;; localObject4 = localObject3)
    {
      localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.a.c)localObject6).x((String)localObject4, ((bu)localObject5).tdE);
      v.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", new Object[] { Long.valueOf(((bu)localObject5).tdE), Long.valueOf(((ce)localObject4).field_msgId), Integer.valueOf(((ce)localObject4).field_flag), Long.valueOf(((ce)localObject4).field_msgSeq), ??? });
      if ((((ce)localObject4).field_msgId != 0L) && (((ce)localObject4).field_createTime + 604800000L < ay.i((String)localObject3, ((bu)localObject5).ofk)))
      {
        v.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(((bu)localObject5).tdE), Long.valueOf(((ce)localObject4).field_msgId) });
        ay.L(((ce)localObject4).field_msgId);
        ((au)localObject4).x(0L);
      }
      if (((ce)localObject4).field_msgId == 0L) {
        break label387;
      }
      v.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", new Object[] { Long.valueOf(((bu)localObject5).tdE) });
      GMTrace.o(331652005888L, 2471);
      return null;
      bool1 = false;
      break;
    }
    label387:
    final Object localObject6 = n.a(((bu)localObject5).tdz);
    localObject4 = new r();
    if (bool1) {
      localObject3 = localObject1;
    }
    ((r)localObject4).fRV = ((String)localObject3);
    ((r)localObject4).hZS = ((bu)localObject5).ofk;
    ((r)localObject4).fTG = ((bu)localObject5).tdE;
    ((r)localObject4).iab = ((bu)localObject5).tdz.tXF;
    v.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", new Object[] { localObject6, ((bu)localObject5).tdC });
    Object localObject7 = bg.q((String)localObject6, "msg");
    if (localObject7 == null)
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 216L, 1L, false);
      GMTrace.o(331652005888L, 2471);
      return null;
    }
    localObject3 = new au();
    ((au)localObject3).cN(((bu)localObject5).tdC);
    ((au)localObject3).cO(ay.gn(((bu)localObject5).tdC));
    final int j;
    int i;
    for (;;)
    {
      try
      {
        ((r)localObject4).hrb = bf.getInt((String)((Map)localObject7).get(".msg.videomsg.$length"), 0);
        ((r)localObject4).hZV = bf.getInt((String)((Map)localObject7).get(".msg.videomsg.$playlength"), 0);
        v.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", new Object[] { Integer.valueOf(((r)localObject4).hrb), Integer.valueOf(((r)localObject4).hZV) });
        ((r)localObject4).hZN = ((String)((Map)localObject7).get(".msg.videomsg.$fromusername"));
        if (str1.equals(((r)localObject4).Lg())) {
          ((r)localObject4).hZN = ((String)localObject1);
        }
        ((r)localObject4).fUO = ((String)((Map)localObject7).get(".msg.statextstr"));
        localObject1 = (String)((Map)localObject7).get(".msg.videomsg.$cdnthumbaeskey");
        str1 = (String)((Map)localObject7).get(".msg.videomsg.$cdnthumburl");
        j = bf.getInt((String)((Map)localObject7).get(".msg.videomsg.$cdnthumblength"), 0);
        int k = bf.getInt((String)((Map)localObject7).get(".msg.videomsg.$type"), 0);
        v.d("MicroMsg.VideoMsgExtension", "video msg exportType :" + k);
        if (k == 44)
        {
          i = 1;
          ((r)localObject4).hZZ = i;
          if (62 == ((bu)localObject5).mrC)
          {
            ((r)localObject4).iac = 3;
            String str2 = bf.ap((String)((Map)localObject7).get(".msg.streamvideo.streamvideourl"), "");
            i = bf.getInt((String)((Map)localObject7).get(".msg.streamvideo.streamvideototaltime"), 0);
            String str3 = bf.ap((String)((Map)localObject7).get(".msg.streamvideo.streamvideotitle"), "");
            String str4 = bf.ap((String)((Map)localObject7).get(".msg.streamvideo.streamvideowording"), "");
            String str5 = bf.ap((String)((Map)localObject7).get(".msg.streamvideo.streamvideoweburl"), "");
            String str6 = bf.ap((String)((Map)localObject7).get(".msg.streamvideo.streamvideoaduxinfo"), "");
            String str7 = bf.ap((String)((Map)localObject7).get(".msg.streamvideo.streamvideopublishid"), "");
            if (((r)localObject4).iae == null) {
              ((r)localObject4).iae = new bdq();
            }
            ((r)localObject4).iae.hjv = str3;
            ((r)localObject4).iae.txr = i;
            ((r)localObject4).iae.hjt = str2;
            ((r)localObject4).iae.hjw = str4;
            ((r)localObject4).iae.hjx = str5;
            ((r)localObject4).iae.hjz = str6;
            ((r)localObject4).iae.hjA = str7;
            boolean bool2 = ((r)localObject4).Lg().equals((String)com.tencent.mm.kernel.h.vI().vr().get(2, ""));
            if (!bool2) {
              break;
            }
            GMTrace.o(331652005888L, 2471);
            return null;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        if (k > 0) {
          ((r)localObject4).iac = 2;
        } else {
          ((r)localObject4).iac = 1;
        }
      }
      catch (Exception ???)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 216L, 1L, false);
        v.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
        v.e("MicroMsg.VideoMsgExtension", "exception:%s", new Object[] { bf.g(???) });
        GMTrace.o(331652005888L, 2471);
        return null;
      }
    }
    localObject7 = (String)((Map)localObject7).get(".msg.commenturl");
    localObject6 = bg.q((String)localObject6, "msgoperation");
    if (localObject6 != null)
    {
      ((au)localObject3).cP((String)((Map)localObject6).get(".msgoperation.expinfo.expidstr"));
      ((au)localObject3).dK(bf.getInt((String)((Map)localObject6).get(".msgoperation.sightmsg.downloadcontroltype"), 0));
      v.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { ((ce)localObject3).gxE, Integer.valueOf(((ce)localObject3).gxF) });
    }
    localObject6 = s.lv(((r)localObject4).Lg());
    ((r)localObject4).fyw = ((String)localObject6);
    ((au)localObject3).y(((r)localObject4).fTG);
    ((au)localObject3).cI(((r)localObject4).getFileName());
    ((au)localObject3).z(ay.i(((r)localObject4).Lf(), ((r)localObject4).hZS));
    ((au)localObject3).cH(((r)localObject4).Lf());
    ((au)localObject3).dv(((bu)localObject5).jLP);
    if (bool1)
    {
      i = 1;
      ((au)localObject3).dw(i);
      if (((bu)localObject5).mrC != 62) {
        break label1473;
      }
      ((au)localObject3).setType(62);
    }
    final long l1;
    for (;;)
    {
      ((au)localObject3).setContent(p.b(((r)localObject4).Lg(), 0L, false));
      ((au)localObject3).cM((String)localObject7);
      ((au)localObject3).cN(((bu)localObject5).tdC);
      ay.a((au)localObject3, ???);
      l1 = ay.i((au)localObject3);
      if (l1 > 0L) {
        break label1483;
      }
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 215L, 1L, false);
      v.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", new Object[] { Long.valueOf(l1), Long.valueOf(((r)localObject4).fTG) });
      GMTrace.o(331652005888L, 2471);
      return null;
      i = 0;
      break;
      label1473:
      ((au)localObject3).setType(43);
    }
    label1483:
    ((r)localObject4).hZW = ((int)l1);
    ((r)localObject4).hZT = bf.Nz();
    ((r)localObject4).hZX = 0;
    ((r)localObject4).status = 111;
    v.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + ((r)localObject4).getFileName() + "] size:" + ((r)localObject4).hrb + " svrid:" + ((r)localObject4).fTG + " timelen:" + ((r)localObject4).hZV + " user:" + ((r)localObject4).Lf() + " human:" + ((r)localObject4).Lg());
    if (!o.KW().a((r)localObject4))
    {
      v.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + ((r)localObject4).getFileName());
      GMTrace.o(331652005888L, 2471);
      return null;
    }
    o.KW();
    localObject6 = s.lx((String)localObject6);
    ??? = n.a(((bu)localObject5).tdB);
    v.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", new Object[] { Integer.valueOf(bf.bn(???)) });
    if (com.tencent.mm.platformtools.r.iiI)
    {
      v.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      ??? = null;
    }
    if (!bf.bm(???)) {
      s.a((String)localObject6, 0, ???);
    }
    for (;;)
    {
      if (((au)localObject3).bMc())
      {
        com.tencent.mm.modelcontrol.c.Es();
        if (((ce)localObject3).gxF != 1) {
          break label2182;
        }
        i = 1;
        label1752:
        if (i != 0)
        {
          t.lE(((ce)localObject3).field_imgPath);
          com.tencent.mm.modelcdntran.g.Em().hxZ.add("video_" + ((ce)localObject3).field_msgId);
        }
      }
      i = 1;
      j = 0;
      if (com.tencent.mm.u.o.dH(((r)localObject4).Lf()))
      {
        j = j.eC(((r)localObject4).Lf());
        if ((com.tencent.mm.u.o.fJ(((r)localObject4).Lf())) || (!com.tencent.mm.u.o.fI(((r)localObject4).Lf()))) {
          i = 2;
        }
      }
      else
      {
        com.tencent.mm.plugin.report.service.g.oSF.i(14388, new Object[] { Long.valueOf(((ce)localObject3).field_msgSvrId), Integer.valueOf(i), "", Integer.valueOf(j) });
        localObject1 = o.KY();
      }
      synchronized (((i)localObject1).hYN)
      {
        ((i)localObject1).hYN.offerFirst(localObject3);
        ((i)localObject1).KQ();
        ??? = new d.b((au)localObject3, true);
        GMTrace.o(331652005888L, 2471);
        return (d.b)???;
        l1 = ((r)localObject4).fTG;
        v.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), ((r)localObject4).Lf(), str1, localObject6 });
        final long l2 = bf.NA();
        ??? = (String)localObject6 + ".tmp";
        localObject5 = new com.tencent.mm.modelcdntran.h();
        ((com.tencent.mm.modelcdntran.h)localObject5).field_mediaId = com.tencent.mm.modelcdntran.d.a("downvideothumb", ((r)localObject4).hZS, ((r)localObject4).Lf(), String.valueOf(l1));
        ((com.tencent.mm.modelcdntran.h)localObject5).field_fullpath = ???;
        ((com.tencent.mm.modelcdntran.h)localObject5).field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
        ((com.tencent.mm.modelcdntran.h)localObject5).field_totalLen = j;
        ((com.tencent.mm.modelcdntran.h)localObject5).field_aesKey = ((String)localObject1);
        ((com.tencent.mm.modelcdntran.h)localObject5).field_fileId = str1;
        ((com.tencent.mm.modelcdntran.h)localObject5).field_priority = com.tencent.mm.modelcdntran.b.hxu;
        if (com.tencent.mm.u.o.dH(((r)localObject4).Lf())) {}
        for (i = 1;; i = 0)
        {
          ((com.tencent.mm.modelcdntran.h)localObject5).field_chattype = i;
          v.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.modelcdntran.h)localObject5).field_chattype), ((r)localObject4).Lf() });
          ((com.tencent.mm.modelcdntran.h)localObject5).hyM = new h.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
            {
              GMTrace.i(341047246848L, 2541);
              if (paramAnonymousInt != 0)
              {
                v.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(l1), str1.Lf(), localObject6, l2 });
                com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(j), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(this.hFN), "" });
                GMTrace.o(341047246848L, 2541);
                return paramAnonymousInt;
              }
              if (paramAnonymouskeep_SceneResult == null)
              {
                GMTrace.o(341047246848L, 2541);
                return 0;
              }
              com.tencent.mm.plugin.report.service.g localg;
              label253:
              long l1;
              long l2;
              int i;
              int j;
              int k;
              if (paramAnonymouskeep_SceneResult.field_retCode != 0)
              {
                v.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Long.valueOf(l1), str1.Lf(), localObject6, l2 });
                localg = com.tencent.mm.plugin.report.service.g.oSF;
                if (paramAnonymouskeep_SceneResult != null) {
                  break label868;
                }
                paramAnonymousInt = -1;
                l1 = j;
                l2 = bf.NA();
                i = com.tencent.mm.modelcdntran.d.aU(aa.getContext());
                j = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                k = this.hFN;
                if (paramAnonymouskeep_SceneResult != null) {
                  break label877;
                }
                paramAnonymousString = "";
                label291:
                if (paramAnonymouskeep_SceneResult != null) {
                  break label886;
                }
                paramAnonymouskeep_ProgressInfo = "";
                label299:
                localg.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
                if ((paramAnonymouskeep_SceneResult != null) && (paramAnonymouskeep_SceneResult.field_retCode != 0))
                {
                  localg = com.tencent.mm.plugin.report.service.g.oSF;
                  if (paramAnonymouskeep_SceneResult != null) {
                    break label895;
                  }
                  paramAnonymousInt = -1;
                  label444:
                  l1 = j;
                  l2 = bf.NA();
                  i = com.tencent.mm.modelcdntran.d.aU(aa.getContext());
                  j = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                  k = this.hFN;
                  if (paramAnonymouskeep_SceneResult != null) {
                    break label904;
                  }
                  paramAnonymousString = "";
                  label482:
                  if (paramAnonymouskeep_SceneResult != null) {
                    break label913;
                  }
                }
              }
              label868:
              label877:
              label886:
              label895:
              label904:
              label913:
              for (paramAnonymouskeep_ProgressInfo = "";; paramAnonymouskeep_ProgressInfo = paramAnonymouskeep_SceneResult.report_Part2)
              {
                localg.i(13937, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
                o.KW().b(str1);
                GMTrace.o(341047246848L, 2541);
                return 0;
                paramAnonymousString = new File(l2);
                new File(this.hFO).renameTo(paramAnonymousString);
                v.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), str1.Lf(), localObject6, l2 });
                if (str1.iac == 3)
                {
                  com.tencent.mm.plugin.report.service.g.oSF.a(198L, 6L, this.hFN, false);
                  com.tencent.mm.plugin.report.service.g.oSF.a(198L, 7L, 1L, false);
                  paramAnonymousString = com.tencent.mm.plugin.report.service.g.oSF;
                  if (com.tencent.mm.u.o.dH(str1.Lf())) {}
                  for (l1 = 9L;; l1 = 8L)
                  {
                    paramAnonymousString.a(198L, l1, 1L, false);
                    break;
                  }
                }
                com.tencent.mm.plugin.report.service.g.oSF.a(198L, 11L, this.hFN, false);
                com.tencent.mm.plugin.report.service.g.oSF.a(198L, 12L, 1L, false);
                paramAnonymousString = com.tencent.mm.plugin.report.service.g.oSF;
                if (com.tencent.mm.u.o.dH(str1.Lf())) {}
                for (l1 = 14L;; l1 = 13L)
                {
                  paramAnonymousString.a(198L, l1, 1L, false);
                  break;
                }
                paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
                break label253;
                paramAnonymousString = paramAnonymouskeep_SceneResult.field_transInfo;
                break label291;
                paramAnonymouskeep_ProgressInfo = paramAnonymouskeep_SceneResult.report_Part2;
                break label299;
                paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
                break label444;
                paramAnonymousString = paramAnonymouskeep_SceneResult.field_transInfo;
                break label482;
              }
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
            {
              GMTrace.i(341181464576L, 2542);
              GMTrace.o(341181464576L, 2542);
            }
            
            public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              GMTrace.i(341315682304L, 2543);
              GMTrace.o(341315682304L, 2543);
              return null;
            }
          };
          com.tencent.mm.modelcdntran.g.Em().b((com.tencent.mm.modelcdntran.h)localObject5, -1);
          break;
        }
        label2182:
        if (((ce)localObject3).gxF == 2)
        {
          i = 0;
          break label1752;
        }
        if (!com.tencent.mm.modelcontrol.c.m((au)localObject3))
        {
          v.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
          i = 0;
          break label1752;
        }
        ??? = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("C2CSightNotAutoDownloadTimeRange");
        v.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: " + ???);
        if (com.tencent.mm.modelcontrol.b.iU(???))
        {
          v.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
          i = 0;
          break label1752;
        }
        ??? = ((ce)localObject3).field_talker;
        v.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: " + ???);
        i = bf.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("SIGHTSessionAutoLoadNetwork"), 1);
        if (i == 3)
        {
          v.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", new Object[] { Long.valueOf(((ce)localObject3).field_msgId), Long.valueOf(((ce)localObject3).field_msgSvrId) });
          i = 0;
          break label1752;
        }
        if (al.isWifi(aa.getContext()))
        {
          v.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ce)localObject3).field_msgId), Long.valueOf(((ce)localObject3).field_msgSvrId), ((ce)localObject3).field_imgPath });
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(???);
          if ((localObject1 != null) && ((int)((com.tencent.mm.j.a)localObject1).gTG > 0) && (((???.endsWith("@chatroom")) && (((af)localObject1).gkp == 0)) || (((x)localObject1).tD()))) {
            break label2872;
          }
          i = 1;
          break label1752;
        }
        if (al.is2G(aa.getContext()))
        {
          v.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ce)localObject3).field_msgId), Long.valueOf(((ce)localObject3).field_msgSvrId), ((ce)localObject3).field_imgPath });
          i = 0;
          break label1752;
        }
        ??? = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(((ce)localObject3).field_talker);
        if (com.tencent.mm.u.o.dH(((ce)localObject3).field_talker))
        {
          if (???.gkp == 0)
          {
            v.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ce)localObject3).field_msgId), Long.valueOf(((ce)localObject3).field_msgSvrId), ((ce)localObject3).field_imgPath });
            i = 0;
            break label1752;
          }
          if (((al.is3G(aa.getContext())) || (al.is4G(aa.getContext()))) && (i == 1))
          {
            v.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ce)localObject3).field_msgId), Long.valueOf(((ce)localObject3).field_msgSvrId), ((ce)localObject3).field_imgPath });
            i = 1;
            break label1752;
          }
          v.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
          i = 0;
          break label1752;
        }
        if (???.tD())
        {
          v.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ce)localObject3).field_msgId), Long.valueOf(((ce)localObject3).field_msgSvrId), ((ce)localObject3).field_imgPath });
          i = 0;
          break label1752;
        }
        if (((al.is3G(aa.getContext())) || (al.is4G(aa.getContext()))) && (i == 1))
        {
          v.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", new Object[] { Long.valueOf(((ce)localObject3).field_msgId), Long.valueOf(((ce)localObject3).field_msgSvrId), ((ce)localObject3).field_imgPath });
          i = 1;
          break label1752;
        }
        v.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
        i = 0;
        break label1752;
        label2872:
        v.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
        i = 0;
        break label1752;
        i = 3;
      }
    }
  }
  
  public final void h(au paramau)
  {
    GMTrace.i(331786223616L, 2472);
    if (paramau == null)
    {
      GMTrace.o(331786223616L, 2472);
      return;
    }
    paramau = paramau.field_imgPath;
    if ((!bf.mA(paramau)) && (o.KW().lu(paramau))) {
      try
      {
        o.KW();
        new File(s.lx(paramau)).delete();
        o.KW();
        new File(s.lw(paramau)).delete();
        GMTrace.o(331786223616L, 2472);
        return;
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + com.tencent.mm.compatible.util.g.sd() + " file:" + paramau + " msg:" + localException.getMessage());
      }
    }
    GMTrace.o(331786223616L, 2472);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */