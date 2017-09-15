package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.f;
import com.tencent.mm.bg.a;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.WWMediaConversation;
import com.tencent.wework.api.model.WWMediaFile;
import com.tencent.wework.api.model.WWMediaImage;
import com.tencent.wework.api.model.WWMediaLink;
import com.tencent.wework.api.model.WWMediaLocation;
import com.tencent.wework.api.model.WWMediaMergedConvs;
import com.tencent.wework.api.model.WWMediaMessage;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;
import com.tencent.wework.api.model.WWMediaText;
import com.tencent.wework.api.model.WWMediaVideo;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public final class eg
{
  private static WWMediaMessage.WWMediaObject a(x paramx, List<au> paramList, boolean paramBoolean)
  {
    GMTrace.i(2188554272768L, 16306);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    Object localObject2 = paramx.field_username;
    paramx = com.tencent.mm.sdk.platformtools.aa.getContext();
    if (paramBoolean) {
      paramx = paramx.getString(R.l.eIx);
    }
    for (;;)
    {
      localWWMediaMergedConvs.title = paramx;
      paramList = paramList.iterator();
      label51:
      Object localObject1;
      if (paramList.hasNext())
      {
        localObject1 = (au)paramList.next();
        localObject2 = new WWMediaConversation();
        if (((ce)localObject1).field_isSend == 1)
        {
          paramx = m.xL();
          label93:
          ((WWMediaConversation)localObject2).name = com.tencent.mm.u.n.eJ(paramx);
        }
      }
      try
      {
        paramx = com.tencent.mm.x.b.a(paramx, false, -1);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramx.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
        ((WWMediaConversation)localObject2).xjV = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.close();
        ((WWMediaConversation)localObject2).date = ((ce)localObject1).field_createTime;
        ((WWMediaConversation)localObject2).xjW = c((au)localObject1, paramBoolean);
        if (!((WWMediaConversation)localObject2).checkArgs()) {
          break label51;
        }
        localWWMediaMergedConvs.xjY.add(localObject2);
        break label51;
        localObject1 = m.xN();
        localObject2 = com.tencent.mm.u.n.eJ((String)localObject2);
        if (((String)localObject1).equals(localObject2))
        {
          paramx = paramx.getString(R.l.eiU, new Object[] { localObject1 });
          continue;
        }
        paramx = paramx.getString(R.l.eiT, new Object[] { localObject1, localObject2 });
        continue;
        if (!paramBoolean)
        {
          paramx = ((ce)localObject1).field_talker;
          break label93;
        }
        paramx = ay.gi(((ce)localObject1).field_content);
        break label93;
        GMTrace.o(2188554272768L, 16306);
        return localWWMediaMergedConvs;
      }
      catch (Exception paramx)
      {
        for (;;) {}
      }
    }
  }
  
  public static void a(Context paramContext, x paramx, List<au> paramList, boolean paramBoolean)
  {
    GMTrace.i(2188285837312L, 16304);
    IWWAPI localIWWAPI = WWAPIFactory.hM(paramContext);
    if ((paramList.size() == 1) && (((au)paramList.get(0)).field_type != 48)) {}
    for (paramContext = c((au)paramList.get(0), paramBoolean);; paramContext = a(paramx, paramList, paramBoolean))
    {
      localIWWAPI.a(paramContext);
      GMTrace.o(2188285837312L, 16304);
      return;
    }
  }
  
  private static WWMediaMessage.WWMediaObject c(au paramau, boolean paramBoolean)
  {
    GMTrace.i(2188420055040L, 16305);
    int i = paramau.field_type;
    if (i == 1)
    {
      paramau = new WWMediaText(aa.q(paramau.field_content, paramau.field_isSend, paramBoolean));
      GMTrace.o(2188420055040L, 16305);
      return paramau;
    }
    if (i == 3) {
      if (paramau.field_msgId <= 0L) {
        break label415;
      }
    }
    label415:
    for (Object localObject1 = com.tencent.mm.ah.n.GT().aj(paramau.field_msgId);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((d)localObject1).hEG > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (paramau.field_msgSvrId > 0L) {
          localObject2 = com.tencent.mm.ah.n.GT().ai(paramau.field_msgSvrId);
        }
      }
      if (localObject2 == null)
      {
        GMTrace.o(2188420055040L, 16305);
        return null;
      }
      paramau = com.tencent.mm.ah.n.GT().m(com.tencent.mm.ah.e.c((d)localObject2), "", "");
      localObject1 = new WWMediaImage();
      ((WWMediaImage)localObject1).filePath = paramau;
      v.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { ((WWMediaImage)localObject1).filePath });
      GMTrace.o(2188420055040L, 16305);
      return (WWMediaMessage.WWMediaObject)localObject1;
      if (i == 43)
      {
        localObject1 = new WWMediaVideo();
        paramau = t.lI(paramau.field_imgPath);
        o.KW();
        ((WWMediaVideo)localObject1).filePath = s.lw(paramau.getFileName());
        v.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { ((WWMediaVideo)localObject1).filePath });
        GMTrace.o(2188420055040L, 16305);
        return (WWMediaMessage.WWMediaObject)localObject1;
      }
      if (i == 48)
      {
        localObject1 = new WWMediaLocation();
        paramau = aa.q(paramau.field_content, paramau.field_isSend, paramBoolean);
        ap.yY();
        paramau = com.tencent.mm.u.c.wT().Au(paramau);
        ((WWMediaLocation)localObject1).title = paramau.nbU;
        ((WWMediaLocation)localObject1).hCm = paramau.label;
        ((WWMediaLocation)localObject1).longitude = paramau.mZo;
        ((WWMediaLocation)localObject1).latitude = paramau.mZn;
        ((WWMediaLocation)localObject1).xjX = paramau.fNU;
        GMTrace.o(2188420055040L, 16305);
        return (WWMediaMessage.WWMediaObject)localObject1;
      }
      if ((i == 49) || (i == 268435505))
      {
        paramau = d(paramau, paramBoolean);
        GMTrace.o(2188420055040L, 16305);
        return paramau;
      }
      v.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
      GMTrace.o(2188420055040L, 16305);
      return null;
    }
  }
  
  private static WWMediaMessage.WWMediaObject d(au paramau, boolean paramBoolean)
  {
    GMTrace.i(2188688490496L, 16307);
    Object localObject3 = paramau.field_content;
    Object localObject1 = localObject3;
    if (paramBoolean)
    {
      int i = paramau.field_content.indexOf(':');
      localObject1 = localObject3;
      if (i != -1) {
        localObject1 = paramau.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = f.a.B((String)localObject1, paramau.field_reserved);; localObject2 = null)
    {
      if (localObject1 == null)
      {
        GMTrace.o(2188688490496L, 16307);
        return null;
      }
      switch (((f.a)localObject1).type)
      {
      case 3: 
      case 4: 
      default: 
        GMTrace.o(2188688490496L, 16307);
        return null;
      case 5: 
        localObject3 = new WWMediaLink();
        ((WWMediaLink)localObject3).webpageUrl = ((f.a)localObject1).url;
        ((WWMediaLink)localObject3).title = ((f.a)localObject1).title;
        ((WWMediaLink)localObject3).description = ((f.a)localObject1).description;
        localObject1 = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, a.getDensity(null), false);
      }
      try
      {
        Object localObject4 = new ByteArrayOutputStream();
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject4);
        ((WWMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
        ((ByteArrayOutputStream)localObject4).close();
        try
        {
          paramau = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, a.getDensity(null), false);
          localObject1 = new ByteArrayOutputStream();
          paramau.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
          ((WWMediaLink)localObject3).thumbData = ((ByteArrayOutputStream)localObject1).toByteArray();
          ((ByteArrayOutputStream)localObject1).close();
          GMTrace.o(2188688490496L, 16307);
          return (WWMediaMessage.WWMediaObject)localObject3;
          if ((((f.a)localObject1).fCN != null) && (((f.a)localObject1).fCN.length() > 0))
          {
            localObject1 = an.abF().LV(((f.a)localObject1).fCN);
            if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.model.app.b)localObject1).ayY()))
            {
              localObject1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath;
              if (!com.tencent.mm.a.e.aO((String)localObject1))
              {
                v.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { localObject1, Long.valueOf(paramau.field_msgId), Long.valueOf(paramau.field_msgSvrId) });
                GMTrace.o(2188688490496L, 16307);
                return null;
              }
              paramau = new WWMediaImage();
              paramau.filePath = ((String)localObject1);
              v.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { paramau.filePath });
              GMTrace.o(2188688490496L, 16307);
              return paramau;
            }
          }
          GMTrace.o(2188688490496L, 16307);
          return null;
          localObject4 = l.Mg(((f.a)localObject1).fCN);
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = an.abF().eb(paramau.field_msgId);
          }
          paramau = new WWMediaFile();
          paramau.fyw = ((f.a)localObject1).title;
          paramau.filePath = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath;
          GMTrace.o(2188688490496L, 16307);
          return paramau;
        }
        catch (Exception paramau)
        {
          for (;;) {}
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */