package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.qy;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public final class l
{
  private static ab sBR;
  
  public static boolean Me(String paramString)
  {
    GMTrace.i(829868212224L, 6183);
    if (bf.mA(paramString))
    {
      GMTrace.o(829868212224L, 6183);
      return false;
    }
    if (paramString.equals("0:0"))
    {
      GMTrace.o(829868212224L, 6183);
      return false;
    }
    GMTrace.o(829868212224L, 6183);
    return true;
  }
  
  public static int Mf(String paramString)
  {
    GMTrace.i(830270865408L, 6186);
    f.a locala = f.a.ek(paramString);
    if (locala == null)
    {
      GMTrace.o(830270865408L, 6186);
      return -1;
    }
    if (!Me(locala.fCN))
    {
      GMTrace.o(830270865408L, 6186);
      return -1;
    }
    b localb = new b();
    long l = bf.getLong(locala.fCN, -1L);
    if (l != -1L)
    {
      an.abF().b(l, localb);
      paramString = localb;
      if (localb.uvp != l)
      {
        localb = an.abF().LV(locala.fCN);
        if (localb != null)
        {
          paramString = localb;
          if (localb.field_mediaSvrId.equals(locala.fCN)) {}
        }
        else
        {
          GMTrace.o(830270865408L, 6186);
          return -1;
        }
      }
    }
    else
    {
      localb = an.abF().LV(locala.fCN);
      if (localb != null)
      {
        paramString = localb;
        if (localb.field_mediaSvrId.equals(locala.fCN)) {}
      }
      else
      {
        GMTrace.o(830270865408L, 6186);
        return -1;
      }
    }
    if (paramString.field_totalLen == 0L)
    {
      GMTrace.o(830270865408L, 6186);
      return -1;
    }
    int i = (int)(paramString.field_offset * 100L / paramString.field_totalLen);
    GMTrace.o(830270865408L, 6186);
    return i;
  }
  
  public static b Mg(String paramString)
  {
    GMTrace.i(832552566784L, 6203);
    b localb2 = new b();
    if (bf.mA(paramString))
    {
      GMTrace.o(832552566784L, 6203);
      return null;
    }
    v.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", new Object[] { paramString });
    long l = bf.getLong(paramString, -1L);
    b localb1;
    if (l != -1L)
    {
      an.abF().b(l, localb2);
      localb1 = localb2;
      if (localb2.uvp != l)
      {
        localb2 = an.abF().LV(paramString);
        if (localb2 != null)
        {
          localb1 = localb2;
          if (localb2.field_mediaSvrId.equals(paramString)) {}
        }
        else
        {
          v.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
          localb1 = null;
        }
      }
    }
    for (;;)
    {
      v.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", new Object[] { paramString, Long.valueOf(l) });
      GMTrace.o(832552566784L, 6203);
      return localb1;
      localb2 = an.abF().LV(paramString);
      if (localb2 != null)
      {
        localb1 = localb2;
        if (localb2.field_mediaSvrId.equals(paramString)) {}
      }
      else
      {
        v.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
        localb1 = null;
      }
    }
  }
  
  public static void V(au paramau)
  {
    GMTrace.i(832686784512L, 6204);
    Object localObject5 = f.a.ek(paramau.field_content);
    if (localObject5 == null)
    {
      v.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
      GMTrace.o(832686784512L, 6204);
      return;
    }
    Object localObject4 = Mg(((f.a)localObject5).fCN);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localObject4 != null)
    {
      localObject1 = localObject2;
      if (((b)localObject4).field_fileFullPath != null)
      {
        localObject1 = localObject2;
        if (!((b)localObject4).field_fileFullPath.equals(""))
        {
          ap.yY();
          localObject1 = W(com.tencent.mm.u.c.xn(), ((f.a)localObject5).title, ((f.a)localObject5).hhh);
          j.p(((b)localObject4).field_fileFullPath, (String)localObject1, false);
        }
      }
    }
    localObject4 = null;
    localObject2 = localObject4;
    if (paramau.field_imgPath != null)
    {
      localObject2 = localObject4;
      if (!paramau.field_imgPath.equals("")) {
        localObject2 = com.tencent.mm.ah.n.GT().v(paramau.field_imgPath, true);
      }
    }
    try
    {
      localObject2 = com.tencent.mm.a.e.c((String)localObject2, 0, com.tencent.mm.a.e.aN((String)localObject2));
      f.a locala = f.a.a((f.a)localObject5);
      localObject4 = ((f.a)localObject5).appId;
      localObject5 = ((f.a)localObject5).appName;
      localObject4 = System.currentTimeMillis();
      if (!bf.mA((String)localObject1))
      {
        localObject4 = a((String)localObject4, locala, (String)localObject1);
        localObject1 = localObject4;
        if (localObject4 == null)
        {
          com.tencent.mm.compatible.util.g.sb();
          GMTrace.o(832686784512L, 6204);
        }
      }
      else
      {
        localObject1 = null;
      }
      localObject4 = new au();
      if ((localObject2 != null) && (localObject2.length > 0)) {
        if (locala.type != 2) {
          break label602;
        }
      }
      long l;
      label602:
      for (boolean bool = true;; bool = false)
      {
        localObject2 = com.tencent.mm.ah.n.GT().a(6, (byte[])localObject2, bool, Bitmap.CompressFormat.PNG);
        v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " thumbData MsgInfo path:" + (String)localObject2);
        if (!bf.mA((String)localObject2))
        {
          ((au)localObject4).cI((String)localObject2);
          v.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + (String)localObject2);
        }
        if (localObject1 != null) {
          locala.fCN = ((b)localObject1).uvp;
        }
        ((au)localObject4).setContent(f.a.a(locala, null, null));
        ((au)localObject4).dv(1);
        ((au)localObject4).cH(paramau.field_talker);
        ((au)localObject4).z(ay.gk(paramau.field_talker));
        ((au)localObject4).dw(1);
        ((au)localObject4).setType(d(locala));
        if (com.tencent.mm.modelbiz.e.dr(((ce)localObject4).field_talker))
        {
          ((au)localObject4).cN(com.tencent.mm.modelbiz.a.e.zz());
          v.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { ((ce)localObject4).gxv });
        }
        ap.yY();
        l = com.tencent.mm.u.c.wT().L((au)localObject4);
        v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break;
        }
        v.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + "insert msg failed :" + l);
        com.tencent.mm.compatible.util.g.sb();
        GMTrace.o(832686784512L, 6204);
        return;
      }
      v.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sb() + " new msg inserted to db , local id = " + l);
      ((au)localObject4).x(l);
      localObject2 = new qy();
      ((qy)localObject2).fXL.fXM = paramau.field_msgId;
      ((qy)localObject2).fXL.fXN = l;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
      paramau = new com.tencent.mm.t.f();
      paramau.field_xml = ((ce)localObject4).field_content;
      paramau.field_title = locala.title;
      paramau.field_type = locala.type;
      paramau.field_description = locala.description;
      paramau.field_msgId = l;
      paramau.field_source = ((String)localObject5);
      an.bDc().b(paramau);
      if (localObject1 != null)
      {
        ((b)localObject1).field_msgInfoId = l;
        ((b)localObject1).field_status = 101L;
        an.abF().c((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
        an.bDe().run();
        GMTrace.o(832686784512L, 6204);
        return;
      }
      an.bDe();
      am.a.eg(l);
      GMTrace.o(832686784512L, 6204);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3 = localObject4;
      }
    }
  }
  
  public static String W(String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(16090558103552L, 119884);
    Object localObject;
    if (bf.mA(paramString2)) {
      localObject = paramString1 + "da_" + bf.NA();
    }
    for (;;)
    {
      paramString1 = (String)localObject;
      if (!bf.mA(paramString3))
      {
        paramString1 = (String)localObject;
        if (!((String)localObject).endsWith(paramString3)) {
          paramString1 = (String)localObject + "." + paramString3;
        }
      }
      GMTrace.o(16090558103552L, 119884);
      return paramString1;
      String str = paramString1 + paramString2;
      localObject = str;
      if (com.tencent.mm.a.e.aO(str))
      {
        paramString1 = new File(paramString1 + "/" + bf.NA());
        if ((!paramString1.exists()) || (!paramString1.isDirectory())) {
          paramString1.mkdirs();
        }
        localObject = paramString1.getAbsolutePath() + "/" + paramString2;
      }
    }
  }
  
  public static b Y(String paramString, long paramLong)
  {
    GMTrace.i(830807736320L, 6190);
    b localb = Mg(paramString);
    paramString = localb;
    if (localb == null) {
      paramString = an.abF().eb(paramLong);
    }
    if (paramString != null) {
      v.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { paramString, Long.valueOf(paramString.uvp), Boolean.valueOf(paramString.field_isUpload), paramString.field_fileFullPath, Long.valueOf(paramString.field_totalLen), Long.valueOf(paramString.field_offset), paramString.field_mediaSvrId, paramString.field_mediaId, Long.valueOf(paramString.field_msgInfoId), Long.valueOf(paramString.field_type), u.ND() });
    }
    for (;;)
    {
      GMTrace.o(830807736320L, 6190);
      return paramString;
      v.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", new Object[] { u.ND() });
    }
  }
  
  public static int a(long paramLong, String paramString, keep_SceneResult paramkeep_SceneResult)
  {
    GMTrace.i(14628658610176L, 108992);
    ap.yY();
    au localau = com.tencent.mm.u.c.wT().cA(paramLong);
    int i;
    if (localau.field_msgId != paramLong)
    {
      v.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(14628658610176L, 108992);
      return 0 - i;
    }
    f.a locala = f.a.ek(localau.field_content);
    if (locala == null)
    {
      v.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(14628658610176L, 108992);
      return 0 - i;
    }
    locala.fCN = paramString;
    localau.setContent(f.a.a(locala, locala.fCN, paramkeep_SceneResult));
    ap.yY();
    com.tencent.mm.u.c.wT().a(localau.field_msgId, localau);
    paramkeep_SceneResult = an.bDc().ec(paramLong);
    paramkeep_SceneResult.field_xml = localau.field_content;
    an.bDc().c(paramkeep_SceneResult, new String[] { "msgId" });
    paramkeep_SceneResult = an.abF().eb(paramLong);
    paramkeep_SceneResult.field_mediaSvrId = paramString;
    paramkeep_SceneResult.field_offset = paramkeep_SceneResult.field_totalLen;
    an.abF().c(paramkeep_SceneResult, new String[0]);
    GMTrace.o(14628658610176L, 108992);
    return 0;
  }
  
  public static int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    GMTrace.i(831881478144L, 6198);
    paramInt = a(paramWXMediaMessage, paramString1, paramString2, paramString3, paramInt, paramString4, null);
    GMTrace.o(831881478144L, 6198);
    return paramInt;
  }
  
  public static int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    GMTrace.i(832015695872L, 6199);
    f.a locala = new f.a();
    locala.appId = paramString1;
    locala.appName = paramString2;
    locala.hhj = paramInt;
    paramInt = a(locala, paramWXMediaMessage, paramString3, paramString4, paramString5);
    GMTrace.o(832015695872L, 6199);
    return paramInt;
  }
  
  public static int a(f.a parama, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    GMTrace.i(17956184522752L, 133784);
    int i = a(parama, paramWXMediaMessage, paramString, null, null);
    GMTrace.o(17956184522752L, 133784);
    return i;
  }
  
  private static int a(f.a parama, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(832149913600L, 6200);
    Object localObject2 = b(parama, paramWXMediaMessage, paramString2);
    v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + "summerbig content url:" + parama.url + " lowUrl:" + parama.hhf + " attachlen:" + parama.hhg + " attachid:" + parama.fCN + " attach file:" + (String)localObject2);
    Object localObject1 = System.currentTimeMillis();
    int i;
    if (!bf.mA((String)localObject2))
    {
      localObject1 = a((String)localObject1, parama, (String)localObject2);
      if (localObject1 == null)
      {
        i = com.tencent.mm.compatible.util.g.sb();
        GMTrace.o(832149913600L, 6200);
        return 0 - i;
      }
      localObject2 = d.Pd((String)localObject2);
      if (localObject2 != null)
      {
        parama.hht = ((BitmapFactory.Options)localObject2).outWidth;
        parama.hhs = ((BitmapFactory.Options)localObject2).outHeight;
      }
    }
    for (;;)
    {
      au localau = new au();
      boolean bool;
      if ((paramWXMediaMessage.thumbData != null) && (paramWXMediaMessage.thumbData.length > 0))
      {
        if ((paramWXMediaMessage.thumbData.length <= 32768) || (paramWXMediaMessage.getType() == 36)) {
          break label528;
        }
        if (parama.type != 2) {
          break label522;
        }
        bool = true;
        localObject2 = com.tencent.mm.ah.n.GT().a(6, paramWXMediaMessage.thumbData, bool, Bitmap.CompressFormat.JPEG);
        label265:
        v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " summerbig thumbData MsgInfo path:" + (String)localObject2);
        if (!bf.mA((String)localObject2)) {
          localau.cI((String)localObject2);
        }
      }
      if (localObject1 != null) {
        parama.fCN = ((b)localObject1).uvp;
      }
      paramString1 = bf.f(paramString1.split(",")).iterator();
      for (;;)
      {
        if (!paramString1.hasNext()) {
          break label834;
        }
        localObject2 = (String)paramString1.next();
        parama.hhi = paramString2;
        localau.setContent(f.a.a(parama, null, null));
        localau.dv(1);
        localau.cH((String)localObject2);
        localau.z(ay.gk((String)localObject2));
        localau.dw(1);
        localau.setType(d(parama));
        if (com.tencent.mm.modelbiz.e.dr(localau.field_talker)) {
          localau.cN(com.tencent.mm.modelbiz.a.e.zz());
        }
        ap.yY();
        long l = com.tencent.mm.u.c.wT().L(localau);
        if (l < 0L)
        {
          v.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " summerbig insert msg failed :" + l);
          i = com.tencent.mm.compatible.util.g.sb();
          GMTrace.o(832149913600L, 6200);
          return 0 - i;
          label522:
          bool = false;
          break;
          label528:
          localObject2 = com.tencent.mm.ah.n.GT().f(6, paramWXMediaMessage.thumbData);
          break label265;
        }
        v.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sb() + " summerbig new msg inserted to db , local id = " + l);
        localau.x(l);
        localObject2 = new com.tencent.mm.t.f();
        ((com.tencent.mm.t.f)localObject2).field_xml = localau.field_content;
        ((com.tencent.mm.t.f)localObject2).field_title = paramWXMediaMessage.title;
        ((com.tencent.mm.t.f)localObject2).field_type = paramWXMediaMessage.mediaObject.type();
        ((com.tencent.mm.t.f)localObject2).field_description = paramWXMediaMessage.description;
        ((com.tencent.mm.t.f)localObject2).field_msgId = l;
        ((com.tencent.mm.t.f)localObject2).field_source = parama.appName;
        an.bDc().b((com.tencent.mm.sdk.e.c)localObject2);
        if (localObject1 != null)
        {
          ((b)localObject1).field_msgInfoId = l;
          ((b)localObject1).field_status = 101L;
          v.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", new Object[] { Long.valueOf(((b)localObject1).field_msgInfoId), Long.valueOf(((b)localObject1).field_status), Long.valueOf(((b)localObject1).uvp), Integer.valueOf(((com.tencent.mm.t.f)localObject2).field_type) });
          an.abF().c((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
          if (!bf.mA(paramString3)) {
            an.bDe().s(((b)localObject1).field_msgInfoId, paramString3);
          }
          an.bDe().run();
        }
        else
        {
          v.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", new Object[] { localObject1, Long.valueOf(l), paramString3, Integer.valueOf(((com.tencent.mm.t.f)localObject2).field_type) });
          an.bDe();
          am.a.t(l, paramString3);
        }
      }
      label834:
      GMTrace.o(832149913600L, 6200);
      return 0;
      localObject1 = null;
    }
  }
  
  public static int a(f.a parama, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    GMTrace.i(831478824960L, 6195);
    int i = a(parama, paramString1, paramString2, paramString3, paramString4, paramArrayOfByte, null);
    GMTrace.o(831478824960L, 6195);
    return i;
  }
  
  public static int a(f.a parama, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5)
  {
    GMTrace.i(831613042688L, 6196);
    int i = a(parama, paramString1, paramString2, paramString3, paramString4, paramArrayOfByte, paramString5, "");
    GMTrace.o(831613042688L, 6196);
    return i;
  }
  
  public static int a(f.a parama, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, String paramString6)
  {
    GMTrace.i(831747260416L, 6197);
    v.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", new Object[] { paramString4, parama });
    String str = null;
    Object localObject = System.currentTimeMillis();
    int i;
    if (!bf.mA(paramString4))
    {
      paramString4 = a((String)localObject, parama, paramString4);
      str = paramString4;
      if (paramString4 == null)
      {
        i = com.tencent.mm.compatible.util.g.sb();
        GMTrace.o(831747260416L, 6197);
        return 0 - i;
      }
    }
    localObject = new au();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      if ((parama.type != 33) && (parama.type != 36)) {
        break label467;
      }
      i = (int)(d.bIp().density * 215.0F);
      int j = (int)(d.bIp().density * 215.0F);
      paramString4 = com.tencent.mm.ah.n.GT().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, i, j);
      v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " thumbData MsgInfo path:" + paramString4);
      if (!bf.mA(paramString4))
      {
        ((au)localObject).cI(paramString4);
        v.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + paramString4);
      }
    }
    if (str != null) {
      parama.fCN = str.uvp;
    }
    ((au)localObject).setContent(f.a.a(parama, null, null));
    ((au)localObject).dv(1);
    ((au)localObject).cH(paramString3);
    ((au)localObject).z(ay.gk(paramString3));
    ((au)localObject).dw(1);
    ((au)localObject).setType(d(parama));
    if (com.tencent.mm.modelbiz.e.dr(((ce)localObject).field_talker))
    {
      ((au)localObject).cN(com.tencent.mm.modelbiz.a.e.zz());
      v.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { ((ce)localObject).gxv });
    }
    ap.yY();
    long l = com.tencent.mm.u.c.wT().L((au)localObject);
    v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " msginfo insert id: " + l);
    label467:
    boolean bool;
    if (l < 0L)
    {
      v.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + "insert msg failed :" + l);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(831747260416L, 6197);
      return 0 - i;
      if (parama.type == 2) {}
      for (bool = true;; bool = false)
      {
        paramString4 = com.tencent.mm.ah.n.GT().a(6, paramArrayOfByte, bool, Bitmap.CompressFormat.PNG);
        break;
      }
    }
    v.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sb() + " new msg inserted to db , local id = " + l);
    ((au)localObject).x(l);
    paramString3 = new com.tencent.mm.t.f();
    paramString3.field_xml = ((ce)localObject).field_content;
    paramString3.field_appId = paramString1;
    paramString3.field_title = parama.title;
    paramString3.field_type = parama.type;
    paramString3.field_description = parama.description;
    paramString3.field_msgId = l;
    paramString3.field_source = paramString2;
    an.bDc().b(paramString3);
    if (str == null)
    {
      bool = true;
      v.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attInfo is null[%b]", new Object[] { Boolean.valueOf(bool) });
      if (str == null) {
        break label718;
      }
      str.field_msgInfoId = l;
      str.field_status = 101L;
      an.abF().c(str, new String[0]);
      if ((parama.type == 2) || (!bf.mA(paramString5))) {
        an.bDe().s(l, paramString5);
      }
      an.bDe().run();
    }
    for (;;)
    {
      GMTrace.o(831747260416L, 6197);
      return 0;
      bool = false;
      break;
      label718:
      an.bDe();
      am.a.c(l, paramString5, paramString6);
    }
  }
  
  public static b a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    GMTrace.i(831076171776L, 6192);
    b localb = new b();
    localb.field_fileFullPath = paramString1;
    localb.field_appId = paramString2;
    localb.field_sdkVer = paramInt1;
    localb.field_mediaSvrId = paramString3;
    localb.field_totalLen = paramInt2;
    localb.field_status = 101L;
    localb.field_isUpload = false;
    localb.field_createTime = bf.NA();
    localb.field_lastModifyTime = bf.Nz();
    localb.field_msgInfoId = paramLong;
    localb.field_netTimes = 0L;
    GMTrace.o(831076171776L, 6192);
    return localb;
  }
  
  public static b a(String paramString1, f.a parama, String paramString2)
  {
    GMTrace.i(831210389504L, 6193);
    v.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " summerbig buildUploadAttachInfo clientAppDataId:" + paramString1 + " attach file :" + paramString2);
    Object localObject = paramString2.replace("//", "/");
    if (((String)localObject).startsWith(com.tencent.mm.compatible.util.e.hgf))
    {
      v.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", new Object[] { localObject });
      GMTrace.o(831210389504L, 6193);
      return null;
    }
    localObject = new b();
    ((b)localObject).field_totalLen = parama.hhg;
    ((b)localObject).field_fileFullPath = paramString2;
    ((b)localObject).field_sdkVer = parama.sdkVer;
    ((b)localObject).field_appId = parama.appId;
    ((b)localObject).field_clientAppDataId = paramString1;
    ((b)localObject).field_type = parama.type;
    ((b)localObject).field_status = 200L;
    ((b)localObject).field_isUpload = true;
    ((b)localObject).field_createTime = bf.NA();
    ((b)localObject).field_lastModifyTime = bf.Nz();
    ((b)localObject).field_mediaSvrId = bf.NA();
    an.abF().b((com.tencent.mm.sdk.e.c)localObject);
    v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " summerbig buildUploadAttachInfo file:" + ((b)localObject).field_fileFullPath + " rowid:" + ((b)localObject).uvp + " clientAppDataId:" + ((b)localObject).field_clientAppDataId);
    if (((b)localObject).uvp < 0L)
    {
      v.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " summerbig uploadAttach insert appattach info failed :" + ((b)localObject).uvp);
      GMTrace.o(831210389504L, 6193);
      return null;
    }
    GMTrace.o(831210389504L, 6193);
    return (b)localObject;
  }
  
  public static String a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(830941954048L, 6191);
    b localb = new b();
    localb.field_fileFullPath = paramString1;
    localb.field_appId = paramString2;
    localb.field_sdkVer = paramInt1;
    localb.field_mediaSvrId = paramString3;
    localb.field_totalLen = paramInt2;
    localb.field_status = 101L;
    localb.field_isUpload = false;
    localb.field_createTime = bf.NA();
    localb.field_lastModifyTime = bf.Nz();
    localb.field_msgInfoId = paramLong;
    localb.field_netTimes = 0L;
    localb.field_type = paramInt3;
    v.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[] { Boolean.valueOf(an.abF().b(localb)), Long.valueOf(localb.uvp), Long.valueOf(localb.field_totalLen), Long.valueOf(localb.field_type), Integer.valueOf(paramInt4), paramString1, bf.bJP() });
    GMTrace.o(830941954048L, 6191);
    return paramString3;
  }
  
  public static void a(au paramau, a parama)
  {
    GMTrace.i(16266383327232L, 121194);
    Object localObject1 = f.a.ek(paramau.field_content);
    if (localObject1 == null)
    {
      v.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { paramau.field_content });
      GMTrace.o(16266383327232L, 121194);
      return;
    }
    if ((bf.mA(((f.a)localObject1).fCN)) && (!bf.mA(((f.a)localObject1).hhn)))
    {
      v.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { paramau.field_content });
      ((f.a)localObject1).fCN = ((f.a)localObject1).hhn.hashCode();
    }
    String str5 = ((f.a)localObject1).fCN;
    if (!a(paramau, Y(str5, paramau.field_msgId))) {
      if (paramau != null) {
        break label197;
      }
    }
    label197:
    int j;
    String str2;
    String str3;
    String str1;
    String str4;
    Object localObject2;
    for (int i = 0;; i = 0)
    {
      if (i != 0)
      {
        sBR = new ab(paramau.field_msgId, str5, new com.tencent.mm.y.f()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.y.k paramAnonymousk)
          {
            GMTrace.i(16266249109504L, 121193);
            if (this.sBS != null) {
              this.sBS.dD(paramAnonymousInt1, paramAnonymousInt2);
            }
            GMTrace.o(16266249109504L, 121193);
          }
        });
        ap.vd().a(sBR, 0);
      }
      GMTrace.o(16266383327232L, 121194);
      return;
      j = 1;
      str2 = null;
      str3 = null;
      str1 = null;
      str4 = null;
      localObject3 = null;
      localObject2 = Y(str5, paramau.field_msgId);
      localObject4 = f.a.ek(paramau.field_content);
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = ((b)localObject2).field_fileFullPath;
      }
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break;
      }
    }
    localObject1 = localObject3;
    if (localObject4 != null)
    {
      str2 = u.mz(((f.a)localObject4).title);
      str3 = u.mz(((f.a)localObject4).hhh).toLowerCase();
      str1 = u.mz(((f.a)localObject4).filemd5);
      str4 = u.mz(((f.a)localObject4).fOl);
      localObject1 = u.mz(((f.a)localObject4).hhu);
    }
    if (localObject2 == null)
    {
      b(paramau.field_msgId, paramau.field_content, null);
      localObject3 = Y(str5, paramau.field_msgId);
      localObject2 = localObject3;
      i = j;
      if (localObject3 != null)
      {
        l1 = ((b)localObject3).uvp;
        l2 = ((b)localObject3).field_totalLen;
        localObject2 = ((b)localObject3).field_fileFullPath;
        l3 = ((b)localObject3).field_type;
        str6 = ((b)localObject3).field_mediaId;
        l4 = ((b)localObject3).field_msgInfoId;
        bool1 = ((b)localObject3).field_isUpload;
        if (((b)localObject3).field_signature != null) {
          break label587;
        }
        i = -1;
        label428:
        v.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject2, Long.valueOf(l3), str6, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        localObject2 = localObject3;
        i = j;
        if (localObject4 != null) {
          if (((f.a)localObject4).hhk == 0)
          {
            localObject2 = localObject3;
            i = j;
            if (((f.a)localObject4).hhg <= 26214400) {}
          }
          else
          {
            if (u.mA(((b)localObject3).field_signature)) {
              break label599;
            }
          }
        }
      }
      label587:
      label599:
      for (i = 1;; i = 0)
      {
        localObject2 = localObject3;
        if (i == 0) {
          ap.vd().a(new y((b)localObject2, (String)localObject1, str1, str2, str3, str4), 0);
        }
        break;
        i = ((b)localObject3).field_signature.length();
        break label428;
      }
    }
    Object localObject3 = new File(((b)localObject2).field_fileFullPath);
    if ((((b)localObject2).field_status == 199L) && (!((File)localObject3).exists()))
    {
      v.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      b(paramau.field_msgId, paramau.field_content, null);
    }
    long l1 = ((b)localObject2).uvp;
    long l2 = ((b)localObject2).field_totalLen;
    Object localObject4 = ((b)localObject2).field_fileFullPath;
    long l3 = ((b)localObject2).field_type;
    String str6 = ((b)localObject2).field_mediaId;
    long l4 = ((b)localObject2).field_msgInfoId;
    boolean bool1 = ((b)localObject2).field_isUpload;
    boolean bool2 = ((File)localObject3).exists();
    long l5 = ((b)localObject2).field_status;
    if (((b)localObject2).field_signature == null) {}
    for (i = -1;; i = ((b)localObject2).field_signature.length())
    {
      v.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject4, Long.valueOf(l3), str6, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(l5), Integer.valueOf(i) });
      i = j;
      break;
    }
  }
  
  public static boolean a(au paramau, b paramb)
  {
    GMTrace.i(830673518592L, 6189);
    if ((paramb == null) || (!new File(paramb.field_fileFullPath).exists()))
    {
      GMTrace.o(830673518592L, 6189);
      return false;
    }
    if ((paramb.ayY()) || ((paramau.field_isSend == 1) && (paramb.field_isUpload)))
    {
      GMTrace.o(830673518592L, 6189);
      return true;
    }
    GMTrace.o(830673518592L, 6189);
    return false;
  }
  
  private static String aT(byte[] paramArrayOfByte)
  {
    GMTrace.i(832284131328L, 6201);
    if (bf.bm(paramArrayOfByte))
    {
      v.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " attachBuf is null");
      GMTrace.o(832284131328L, 6201);
      return null;
    }
    Object localObject = new StringBuilder();
    ap.yY();
    localObject = com.tencent.mm.u.c.xn() + "ua_" + bf.NA();
    v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " buildUploadAttachInfo file:" + (String)localObject);
    if (com.tencent.mm.a.e.b((String)localObject, paramArrayOfByte, paramArrayOfByte.length) != 0)
    {
      v.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " writeFile error file:" + (String)localObject);
      GMTrace.o(832284131328L, 6201);
      return null;
    }
    GMTrace.o(832284131328L, 6201);
    return (String)localObject;
  }
  
  public static String b(long paramLong, String paramString1, String paramString2)
  {
    GMTrace.i(830405083136L, 6187);
    v.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 });
    f.a locala = f.a.ek(paramString1);
    if (locala == null)
    {
      GMTrace.o(830405083136L, 6187);
      return null;
    }
    if (paramString2 != null) {}
    for (paramString1 = paramString2;; paramString1 = W(com.tencent.mm.compatible.util.e.gSn, locala.title, locala.hhh))
    {
      if ((bf.mA(locala.fCN)) && (!bf.mA(locala.hhn))) {
        locala.fCN = locala.hhn.hashCode();
      }
      int i = locala.sdkVer;
      paramString2 = locala.appId;
      String str1 = locala.fCN;
      int j = locala.hhg;
      int k = locala.type;
      String str2 = locala.hhu;
      paramString1 = a(paramString1, paramLong, i, paramString2, str1, j, k, locala.hhk);
      GMTrace.o(830405083136L, 6187);
      return paramString1;
    }
  }
  
  public static String b(f.a parama, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    GMTrace.i(832418349056L, 6202);
    v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + "mediaMessageToContent sdkver:" + paramWXMediaMessage.sdkVer + " title:" + paramWXMediaMessage.title + " desc:" + paramWXMediaMessage.description + " type:" + paramWXMediaMessage.mediaObject.type());
    parama.sdkVer = paramWXMediaMessage.sdkVer;
    parama.title = paramWXMediaMessage.title;
    parama.description = paramWXMediaMessage.description;
    parama.mediaTagName = paramWXMediaMessage.mediaTagName;
    parama.messageAction = paramWXMediaMessage.messageAction;
    parama.messageExt = paramWXMediaMessage.messageExt;
    paramWXMediaMessage = paramWXMediaMessage.mediaObject;
    parama.type = paramWXMediaMessage.type();
    if (parama.type == 7)
    {
      paramWXMediaMessage = (WXAppExtendObject)paramWXMediaMessage;
      parama.extInfo = paramWXMediaMessage.extInfo;
      if (!bf.bm(paramWXMediaMessage.fileData))
      {
        v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " fileData:" + paramWXMediaMessage.fileData.length);
        parama.hhg = paramWXMediaMessage.fileData.length;
        parama = aT(paramWXMediaMessage.fileData);
        GMTrace.o(832418349056L, 6202);
        return parama;
      }
      parama.hhg = com.tencent.mm.a.e.aN(paramWXMediaMessage.filePath);
      v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " read file:" + paramWXMediaMessage.filePath + " len:" + parama.hhg);
      if (parama.hhg > 0)
      {
        parama.hhh = com.tencent.mm.a.e.aQ(paramWXMediaMessage.filePath);
        parama = paramWXMediaMessage.filePath;
        GMTrace.o(832418349056L, 6202);
        return parama;
      }
      GMTrace.o(832418349056L, 6202);
      return null;
    }
    if (parama.type == 6)
    {
      paramWXMediaMessage = (WXFileObject)paramWXMediaMessage;
      if (!bf.bm(paramWXMediaMessage.fileData))
      {
        v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " fileData:" + paramWXMediaMessage.fileData.length);
        parama.hhg = paramWXMediaMessage.fileData.length;
        parama = aT(paramWXMediaMessage.fileData);
        GMTrace.o(832418349056L, 6202);
        return parama;
      }
      parama.hhg = com.tencent.mm.a.e.aN(paramWXMediaMessage.filePath);
      v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " read file:" + paramWXMediaMessage.filePath + " len:" + parama.hhg);
      if (parama.hhg > 0)
      {
        parama.hhh = com.tencent.mm.a.e.aQ(paramWXMediaMessage.filePath);
        parama = paramWXMediaMessage.filePath;
        GMTrace.o(832418349056L, 6202);
        return parama;
      }
      GMTrace.o(832418349056L, 6202);
      return null;
    }
    if (parama.type == 2)
    {
      paramWXMediaMessage = (WXImageObject)paramWXMediaMessage;
      if (!bf.bm(paramWXMediaMessage.imageData))
      {
        v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " fileData:" + paramWXMediaMessage.imageData.length);
        parama.hhg = paramWXMediaMessage.imageData.length;
        parama = aT(paramWXMediaMessage.imageData);
        GMTrace.o(832418349056L, 6202);
        return parama;
      }
      if (!bf.mA(paramWXMediaMessage.imagePath))
      {
        parama.hhg = com.tencent.mm.a.e.aN(paramWXMediaMessage.imagePath);
        v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " read file:" + paramWXMediaMessage.imagePath + " len:" + parama.hhg);
        if (parama.hhg > 0)
        {
          parama.hhh = com.tencent.mm.a.e.aQ(paramWXMediaMessage.imagePath);
          ap.yY();
          parama = new File(com.tencent.mm.u.c.xn(), "appmsg_img_" + System.currentTimeMillis()).getAbsolutePath();
          paramString = d.Pd(paramWXMediaMessage.imagePath);
          if ((paramString == null) || (paramString.outWidth <= 0) || (paramString.outHeight <= 0))
          {
            boolean bool;
            int i;
            if (paramString == null)
            {
              bool = true;
              if (paramString != null) {
                break label845;
              }
              i = -1;
              label786:
              if (paramString != null) {
                break label853;
              }
            }
            label845:
            label853:
            for (int j = -1;; j = paramString.outHeight)
            {
              v.e("MicroMsg.AppMsgLogic", "options is null! %B, bitmapWidth = %d, bitmapHeight = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
              GMTrace.o(832418349056L, 6202);
              return null;
              bool = false;
              break;
              i = paramString.outWidth;
              break label786;
            }
          }
          if (m.a(paramWXMediaMessage.imagePath, "", true))
          {
            v.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", new Object[] { paramWXMediaMessage.imagePath, parama });
            if (com.tencent.mm.a.e.p(paramWXMediaMessage.imagePath, parama) < 0L)
            {
              v.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", new Object[] { paramWXMediaMessage.imagePath, parama });
              GMTrace.o(832418349056L, 6202);
              return null;
            }
            GMTrace.o(832418349056L, 6202);
            return parama;
          }
          if ((paramString.outWidth > 960) || (paramString.outHeight > 960))
          {
            paramString = new MMBitmapFactory.DecodeResultLogger();
            localBitmap = d.a(paramWXMediaMessage.imagePath, 960, 960, false, paramString, 0);
            if (localBitmap == null) {}
          }
          while (com.tencent.mm.a.e.p(paramWXMediaMessage.imagePath, parama) >= 0L)
          {
            try
            {
              Bitmap localBitmap;
              d.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, parama, true);
              GMTrace.o(832418349056L, 6202);
              return parama;
            }
            catch (IOException parama)
            {
              v.printErrStackTrace("MicroMsg.AppMsgLogic", parama, "", new Object[0]);
              GMTrace.o(832418349056L, 6202);
              return null;
            }
            if (paramString.getDecodeResult() >= 2000)
            {
              parama = MMBitmapFactory.KVStatHelper.getKVStatString(paramWXMediaMessage.imagePath, 6, paramString);
              com.tencent.mm.plugin.report.service.g.oSF.A(12712, parama);
            }
            GMTrace.o(832418349056L, 6202);
            return null;
          }
          GMTrace.o(832418349056L, 6202);
          return null;
        }
        GMTrace.o(832418349056L, 6202);
        return null;
      }
      GMTrace.o(832418349056L, 6202);
      return null;
    }
    if (parama.type == 3)
    {
      paramWXMediaMessage = (WXMusicObject)paramWXMediaMessage;
      parama.url = paramWXMediaMessage.musicUrl;
      parama.hhf = paramWXMediaMessage.musicLowBandUrl;
      parama.hhx = paramWXMediaMessage.musicDataUrl;
      parama.hhy = paramWXMediaMessage.musicLowBandDataUrl;
      GMTrace.o(832418349056L, 6202);
      return null;
    }
    if (parama.type == 4)
    {
      paramWXMediaMessage = (WXVideoObject)paramWXMediaMessage;
      parama.url = paramWXMediaMessage.videoUrl;
      parama.hhf = paramWXMediaMessage.videoLowBandUrl;
      GMTrace.o(832418349056L, 6202);
      return null;
    }
    if (parama.type == 5)
    {
      paramWXMediaMessage = (WXWebpageObject)paramWXMediaMessage;
      parama.url = paramWXMediaMessage.webpageUrl;
      if (!bf.mA(paramWXMediaMessage.extInfo)) {
        parama.extInfo = paramWXMediaMessage.extInfo;
      }
      if (!bf.mA(paramWXMediaMessage.canvasPageXml)) {
        parama.canvasPageXml = paramWXMediaMessage.canvasPageXml;
      }
      GMTrace.o(832418349056L, 6202);
      return null;
    }
    if (parama.type == 36)
    {
      paramWXMediaMessage = (WXMiniProgramObject)paramWXMediaMessage;
      parama.hjC = paramWXMediaMessage.userName;
      parama.hjB = paramWXMediaMessage.path;
      parama.url = paramWXMediaMessage.webpageUrl;
      paramWXMediaMessage = ((com.tencent.mm.plugin.appbrand.i.b)h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(paramWXMediaMessage.userName);
      if (paramWXMediaMessage != null)
      {
        if (paramWXMediaMessage.RG() != null) {
          parama.hjK = paramWXMediaMessage.RG().fWv;
        }
        parama.hjL = paramWXMediaMessage.field_brandIconURL;
        v.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", new Object[] { Integer.valueOf(parama.hjK), parama.hjL });
      }
    }
    do
    {
      for (;;)
      {
        GMTrace.o(832418349056L, 6202);
        return null;
        if (parama.type == 1)
        {
          parama.title = ((WXTextObject)paramWXMediaMessage).text;
          GMTrace.o(832418349056L, 6202);
          return null;
        }
        if (parama.type != 8) {
          break;
        }
        paramWXMediaMessage = (WXEmojiObject)paramWXMediaMessage;
        if (!bf.bm(paramWXMediaMessage.emojiData))
        {
          v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " fileData:" + paramWXMediaMessage.emojiData.length);
          parama.hhg = paramWXMediaMessage.emojiData.length;
          parama = aT(paramWXMediaMessage.emojiData);
          GMTrace.o(832418349056L, 6202);
          return parama;
        }
        if (!bf.mA(paramWXMediaMessage.emojiPath))
        {
          parama.hhg = com.tencent.mm.a.e.aN(paramWXMediaMessage.emojiPath);
          v.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.sd() + " read file:" + paramWXMediaMessage.emojiPath + " len:" + parama.hhg);
          if (parama.hhg > 0)
          {
            parama.hhh = com.tencent.mm.a.e.aQ(paramWXMediaMessage.emojiPath);
            parama = paramWXMediaMessage.emojiPath;
            GMTrace.o(832418349056L, 6202);
            return parama;
          }
          GMTrace.o(832418349056L, 6202);
          return null;
        }
        parama.hhi = paramString;
      }
      if (parama.type == 15)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        parama.thumburl = paramWXMediaMessage.thumburl;
        parama.hhK = paramWXMediaMessage.packageflag;
        parama.hhJ = paramWXMediaMessage.packageid;
        parama.showType = 8;
        parama.url = paramWXMediaMessage.url;
        GMTrace.o(832418349056L, 6202);
        return null;
      }
      if (parama.type == 13)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        parama.thumburl = paramWXMediaMessage.thumburl;
        parama.hhK = paramWXMediaMessage.packageflag;
        parama.hhJ = paramWXMediaMessage.packageid;
        parama.showType = 8;
        parama.url = paramWXMediaMessage.url;
        GMTrace.o(832418349056L, 6202);
        return null;
      }
      if (parama.type == 25)
      {
        paramWXMediaMessage = (WXDesignerSharedObject)paramWXMediaMessage;
        parama.thumburl = paramWXMediaMessage.thumburl;
        parama.url = paramWXMediaMessage.url;
        parama.hjq = paramWXMediaMessage.designerUIN;
        parama.designerName = paramWXMediaMessage.designerName;
        parama.designerRediretctUrl = paramWXMediaMessage.designerRediretctUrl;
        parama.showType = 18;
        GMTrace.o(832418349056L, 6202);
        return null;
      }
    } while ((parama.type != 27) && (parama.type != 26));
    paramWXMediaMessage = (WXEmojiPageSharedObject)paramWXMediaMessage;
    parama.thumburl = paramWXMediaMessage.iconUrl;
    parama.url = paramWXMediaMessage.url;
    parama.tid = paramWXMediaMessage.tid;
    parama.hjr = paramWXMediaMessage.title;
    parama.desc = paramWXMediaMessage.desc;
    parama.iconUrl = paramWXMediaMessage.iconUrl;
    parama.secondUrl = paramWXMediaMessage.secondUrl;
    parama.pageType = paramWXMediaMessage.pageType;
    parama.showType = 20;
    GMTrace.o(832418349056L, 6202);
    return null;
  }
  
  public static int d(f.a parama)
  {
    GMTrace.i(17762508341248L, 132341);
    if (parama == null)
    {
      GMTrace.o(17762508341248L, 132341);
      return 49;
    }
    int i = parama.type;
    int j = parama.showType;
    int k = parama.hhz;
    int m = parama.hhA;
    int n = parama.hiV;
    v.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + j + " atype " + i + ", itemShowType = " + k + ", c2cNewAAType = " + n);
    if ((k == 4) || (m != 0))
    {
      GMTrace.o(17762508341248L, 132341);
      return 318767153;
    }
    if (k == 5)
    {
      GMTrace.o(17762508341248L, 132341);
      return 486539313;
    }
    if (i == 2001)
    {
      if (j == 1)
      {
        GMTrace.o(17762508341248L, 132341);
        return 469762097;
      }
      if (n == 4)
      {
        GMTrace.o(17762508341248L, 132341);
        return 503316529;
      }
      GMTrace.o(17762508341248L, 132341);
      return 436207665;
    }
    switch (j)
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    com.tencent.mm.t.a locala;
    do
    {
      GMTrace.o(17762508341248L, 132341);
      return 49;
      if (i == 21)
      {
        GMTrace.o(17762508341248L, 132341);
        return -1879048185;
      }
      GMTrace.o(17762508341248L, 132341);
      return 285212721;
      if (i == 21)
      {
        GMTrace.o(17762508341248L, 132341);
        return -1879048183;
      }
      GMTrace.o(17762508341248L, 132341);
      return 301989937;
      if (i == 21)
      {
        GMTrace.o(17762508341248L, 132341);
        return -1879048176;
      }
      GMTrace.o(17762508341248L, 132341);
      return -1879048189;
      if (i == 21)
      {
        GMTrace.o(17762508341248L, 132341);
        return -1879048183;
      }
      GMTrace.o(17762508341248L, 132341);
      return -1879048190;
      GMTrace.o(17762508341248L, 132341);
      return -1879048191;
      GMTrace.o(17762508341248L, 132341);
      return -1879048186;
      GMTrace.o(17762508341248L, 132341);
      return 268435505;
      GMTrace.o(17762508341248L, 132341);
      return 16777265;
      GMTrace.o(17762508341248L, 132341);
      return 1048625;
      GMTrace.o(17762508341248L, 132341);
      return 335544369;
      GMTrace.o(17762508341248L, 132341);
      return 402653233;
      GMTrace.o(17762508341248L, 132341);
      return 369098801;
      GMTrace.o(17762508341248L, 132341);
      return 452984881;
      GMTrace.o(17762508341248L, 132341);
      return -1879048186;
      GMTrace.o(17762508341248L, 132341);
      return 419430449;
      GMTrace.o(17762508341248L, 132341);
      return 520093745;
      locala = (com.tencent.mm.t.a)parama.n(com.tencent.mm.t.a.class);
    } while ((locala == null) || (!locala.hgY) || ((parama.hjE != 2) && (parama.hjE != 3)));
    GMTrace.o(17762508341248L, 132341);
    return 553648177;
  }
  
  public static void ed(long paramLong)
  {
    GMTrace.i(14907965702144L, 111073);
    b localb = an.abF().eb(paramLong);
    if (localb != null) {
      v.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.loader.stub.b.deleteFile(localb.field_fileFullPath)), Boolean.valueOf(an.abF().a(localb, new String[] { "msgInfoId" })), Long.valueOf(localb.field_msgInfoId), localb.field_mediaSvrId, localb.field_fileFullPath, bf.bJP() });
    }
    GMTrace.o(14907965702144L, 111073);
  }
  
  public static void ee(long paramLong)
  {
    GMTrace.i(830136647680L, 6185);
    Object localObject1 = an.abF();
    Object localObject2 = " update appattach set status = 198" + " , lastModifyTime = " + bf.Nz() + " where rowid = " + paramLong;
    ((c)localObject1).gUp.eE("appattach", (String)localObject2);
    ((c)localObject1).doNotify();
    localObject1 = new b();
    an.abF().b(paramLong, (com.tencent.mm.sdk.e.c)localObject1);
    if (((b)localObject1).field_msgInfoId <= 0L)
    {
      GMTrace.o(830136647680L, 6185);
      return;
    }
    ap.yY();
    localObject2 = com.tencent.mm.u.c.wT().cA(((b)localObject1).field_msgInfoId);
    if (((ce)localObject2).field_msgId != ((b)localObject1).field_msgInfoId)
    {
      GMTrace.o(830136647680L, 6185);
      return;
    }
    ((au)localObject2).dv(5);
    ap.yY();
    com.tencent.mm.u.c.wT().a(((ce)localObject2).field_msgId, (au)localObject2);
    GMTrace.o(830136647680L, 6185);
  }
  
  public static int wW(int paramInt)
  {
    GMTrace.i(832955219968L, 6206);
    switch (paramInt)
    {
    default: 
      GMTrace.o(832955219968L, 6206);
      return paramInt;
    }
    GMTrace.o(832955219968L, 6206);
    return 49;
  }
  
  public static abstract interface a
  {
    public abstract void dD(int paramInt1, int paramInt2);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */