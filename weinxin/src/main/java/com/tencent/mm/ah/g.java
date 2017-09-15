package com.tencent.mm.ah;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.e;
import com.tencent.mm.u.o;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class g
  extends e
{
  public g()
  {
    GMTrace.i(3516370255872L, 26199);
    GMTrace.o(3516370255872L, 26199);
  }
  
  protected final au a(bu parambu, String paramString1, final String paramString2, final String paramString3)
  {
    GMTrace.i(3516504473600L, 26200);
    final Object localObject1 = n.GT();
    paramString3 = super.a(parambu, paramString1, paramString2, paramString3);
    if (paramString3.field_msgId != 0L)
    {
      GMTrace.o(3516504473600L, 26200);
      return paramString3;
    }
    final long l1 = parambu.tdE;
    paramString2 = ((f)localObject1).ai(l1);
    if (paramString2.fTG == l1)
    {
      FileOp.deleteFile(((f)localObject1).m(paramString2.hEH, "", ""));
      FileOp.deleteFile(((f)localObject1).m(paramString2.hEJ, "", ""));
      FileOp.deleteFile(((f)localObject1).m(paramString2.hEJ, "", "") + "hd");
      ((f)localObject1).hnp.delete("ImgInfo2", "msgSvrId=?", new String[] { String.valueOf(l1) });
      if (paramString2.GC())
      {
        paramString2 = ((f)localObject1).fT(paramString2.hEQ);
        if (paramString2 != null)
        {
          FileOp.deleteFile(((f)localObject1).m(paramString2.hEH, "", ""));
          FileOp.deleteFile(((f)localObject1).m(paramString2.hEJ, "", ""));
          FileOp.deleteFile(((f)localObject1).m(paramString2.hEJ, "", "") + "hd");
          ((f)localObject1).hnp.delete("ImgInfo2", "id=?", new String[] { paramString2.hEG });
        }
      }
    }
    if (parambu.tdA != 2)
    {
      v.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
      GMTrace.o(3516504473600L, 26200);
      return paramString3;
    }
    paramString2 = com.tencent.mm.platformtools.n.a(parambu.tdB);
    if (r.iiI)
    {
      v.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
      paramString2 = null;
    }
    for (;;)
    {
      Object localObject2 = bg.q(paramString3.field_content, "msg");
      l1 = -1L;
      int i;
      if (!bf.mA(paramString3.field_content))
      {
        v.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", new Object[] { paramString3.field_content });
        if (localObject2 == null) {
          com.tencent.mm.plugin.report.service.g.oSF.a(111L, 190L, 1L, false);
        }
        if ((localObject2 == null) || (bf.getInt((String)((Map)localObject2).get(".msg.img.$hdlength"), 0) <= 0)) {
          break label1039;
        }
        i = parambu.tdA;
      }
      label1033:
      label1039:
      for (l1 = ((f)localObject1).a(paramString2, parambu.tdE, true, paramString3.field_content, new PString(), new PInt(), new PInt());; l1 = -1L)
      {
        Object localObject3 = bg.q(paramString3.field_content, "msgoperation");
        if (localObject3 != null)
        {
          paramString3.cP((String)((Map)localObject3).get(".msgoperation.expinfo.expidstr"));
          paramString3.dK(bf.getInt((String)((Map)localObject3).get(".msgoperation.imagemsg.downloadcontroltype"), 0));
          v.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[] { paramString3.gxE, Integer.valueOf(paramString3.gxF) });
        }
        localObject3 = new PString();
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        i = parambu.tdA;
        final long l2 = ((f)localObject1).a(paramString2, parambu.tdE, false, paramString3.field_content, (PString)localObject3, localPInt1, localPInt2);
        if (l2 > 0L)
        {
          paramString3.cI(((PString)localObject3).value);
          paramString3.dH(localPInt1.value);
          paramString3.dI(localPInt2.value);
          if (l1 > 0L)
          {
            parambu = n.GT().b(Long.valueOf(l2));
            parambu.fP((int)l1);
            n.GT().a(Long.valueOf(l2), parambu);
          }
        }
        final int j;
        if ((bf.bm(paramString2)) && (localObject2 != null))
        {
          parambu = (String)((Map)localObject2).get(".msg.img.$cdnthumbaeskey");
          paramString2 = (String)((Map)localObject2).get(".msg.img.$cdnthumburl");
          j = bf.getInt((String)((Map)localObject2).get(".msg.img.$cdnthumblength"), 0);
          localObject1 = ((f)localObject1).m(com.tencent.mm.a.g.n(("SERVERID://" + paramString3.field_msgSvrId).getBytes()), "th_", "");
          l1 = paramString3.field_msgSvrId;
          v.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Long.valueOf(l1), paramString1, paramString2, localObject1 });
          l2 = bf.NA();
          localObject2 = (String)localObject1 + ".tmp";
          localObject3 = new com.tencent.mm.modelcdntran.h();
          ((com.tencent.mm.modelcdntran.h)localObject3).field_mediaId = com.tencent.mm.modelcdntran.d.a("downimgthumb", paramString3.field_createTime, paramString1, String.valueOf(l1));
          ((com.tencent.mm.modelcdntran.h)localObject3).field_fullpath = ((String)localObject2);
          ((com.tencent.mm.modelcdntran.h)localObject3).field_fileType = b.MediaType_THUMBIMAGE;
          ((com.tencent.mm.modelcdntran.h)localObject3).field_totalLen = j;
          ((com.tencent.mm.modelcdntran.h)localObject3).field_aesKey = parambu;
          ((com.tencent.mm.modelcdntran.h)localObject3).field_fileId = paramString2;
          ((com.tencent.mm.modelcdntran.h)localObject3).field_priority = b.hxu;
          if (!o.dH(paramString1)) {
            break label1033;
          }
        }
        for (i = 1;; i = 0)
        {
          ((com.tencent.mm.modelcdntran.h)localObject3).field_chattype = i;
          v.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", new Object[] { Integer.valueOf(((com.tencent.mm.modelcdntran.h)localObject3).field_chattype), paramString1 });
          ((com.tencent.mm.modelcdntran.h)localObject3).hyM = new h.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
            {
              GMTrace.i(3535160737792L, 26339);
              if (paramAnonymousInt != 0)
              {
                v.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(l1), paramString2, localObject1, paramString3 });
                l2.dv(5);
                ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().b(l2.field_msgSvrId, l2);
                com.tencent.mm.plugin.report.service.g.oSF.i(10421, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(j), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(aa.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(this.hFN), "" });
                com.tencent.mm.plugin.report.service.g.oSF.i(13937, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(j), Long.valueOf(bf.NA()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(aa.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(this.hFN), "" });
                n.GT().doNotify();
                GMTrace.o(3535160737792L, 26339);
                return 0;
              }
              if (paramAnonymouskeep_SceneResult == null)
              {
                GMTrace.o(3535160737792L, 26339);
                return 0;
              }
              com.tencent.mm.plugin.report.service.g localg;
              int i;
              label426:
              long l1;
              long l2;
              int j;
              int k;
              if (paramAnonymouskeep_SceneResult.field_retCode != 0)
              {
                v.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Long.valueOf(l1), paramString2, localObject1, paramString3 });
                l2.dv(5);
                if (!bf.mA(l2.field_talker)) {
                  ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().b(l2.field_msgSvrId, l2);
                }
                localg = com.tencent.mm.plugin.report.service.g.oSF;
                if (paramAnonymouskeep_SceneResult != null) {
                  break label1071;
                }
                i = paramAnonymousInt;
                l1 = j;
                l2 = bf.NA();
                j = com.tencent.mm.modelcdntran.d.aU(aa.getContext());
                k = b.MediaType_THUMBIMAGE;
                int m = this.hFN;
                if (paramAnonymouskeep_SceneResult != null) {
                  break label1081;
                }
                paramAnonymousString = "";
                label464:
                if (paramAnonymouskeep_SceneResult != null) {
                  break label1090;
                }
                paramAnonymouskeep_ProgressInfo = "";
                label472:
                localg.i(10421, new Object[] { Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
                if ((paramAnonymouskeep_SceneResult != null) && (paramAnonymouskeep_SceneResult.field_retCode != 0))
                {
                  localg = com.tencent.mm.plugin.report.service.g.oSF;
                  if (paramAnonymouskeep_SceneResult != null) {
                    break label1099;
                  }
                  label616:
                  l1 = j;
                  l2 = bf.NA();
                  i = com.tencent.mm.modelcdntran.d.aU(aa.getContext());
                  j = b.MediaType_THUMBIMAGE;
                  k = this.hFN;
                  if (paramAnonymouskeep_SceneResult != null) {
                    break label1108;
                  }
                  paramAnonymousString = "";
                  label654:
                  if (paramAnonymouskeep_SceneResult != null) {
                    break label1117;
                  }
                }
              }
              label1071:
              label1081:
              label1090:
              label1099:
              label1108:
              label1117:
              for (paramAnonymouskeep_ProgressInfo = "";; paramAnonymouskeep_ProgressInfo = paramAnonymouskeep_SceneResult.report_Part2)
              {
                localg.i(13937, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymouskeep_ProgressInfo });
                n.GT().doNotify();
                GMTrace.o(3535160737792L, 26339);
                return 0;
                paramAnonymousString = new File(paramString3);
                new File(this.hFO).renameTo(paramAnonymousString);
                l2.dv(6);
                paramAnonymousString = new PInt();
                paramAnonymouskeep_ProgressInfo = new PInt();
                com.tencent.mm.sdk.platformtools.d.c(paramString3, paramAnonymousString, paramAnonymouskeep_ProgressInfo);
                l2.dH(paramAnonymousString.value);
                l2.dI(paramAnonymouskeep_ProgressInfo.value);
                v.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Long.valueOf(l1), paramString2, Integer.valueOf(paramAnonymousString.value), Integer.valueOf(paramAnonymouskeep_ProgressInfo.value), localObject1, paramString3 });
                if (!bf.mA(l2.field_talker)) {
                  ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().b(l2.field_msgSvrId, l2);
                }
                com.tencent.mm.plugin.report.service.g.oSF.a(198L, 1L, this.hFN, false);
                com.tencent.mm.plugin.report.service.g.oSF.a(198L, 2L, 1L, false);
                paramAnonymousString = com.tencent.mm.plugin.report.service.g.oSF;
                if (o.dH(paramString2)) {}
                for (l1 = 4L;; l1 = 3L)
                {
                  paramAnonymousString.a(198L, l1, 1L, false);
                  break;
                }
                i = paramAnonymouskeep_SceneResult.field_retCode;
                break label426;
                paramAnonymousString = paramAnonymouskeep_SceneResult.field_transInfo;
                break label464;
                paramAnonymouskeep_ProgressInfo = paramAnonymouskeep_SceneResult.report_Part2;
                break label472;
                paramAnonymousInt = paramAnonymouskeep_SceneResult.field_retCode;
                break label616;
                paramAnonymousString = paramAnonymouskeep_SceneResult.field_transInfo;
                break label654;
              }
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
            {
              GMTrace.i(3535294955520L, 26340);
              GMTrace.o(3535294955520L, 26340);
            }
            
            public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              GMTrace.i(3535429173248L, 26341);
              GMTrace.o(3535429173248L, 26341);
              return null;
            }
          };
          paramString3.dv(4);
          com.tencent.mm.modelcdntran.g.Em().b((com.tencent.mm.modelcdntran.h)localObject3, -1);
          GMTrace.o(3516504473600L, 26200);
          return paramString3;
        }
      }
    }
  }
  
  public final void h(au paramau)
  {
    GMTrace.i(3516638691328L, 26201);
    n.GT().o(paramau);
    GMTrace.o(3516638691328L, 26201);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */