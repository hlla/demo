package com.tencent.mm.plugin.wear.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.e.a.rr.b;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.c.bnb;
import com.tencent.mm.protocal.c.bns;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public final class h
{
  public static byte[] G(Bitmap paramBitmap)
  {
    GMTrace.i(9172439531520L, 68340);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    GMTrace.o(9172439531520L, 68340);
    return paramBitmap;
  }
  
  public static final Bitmap IE(String paramString)
  {
    GMTrace.i(9172036878336L, 68337);
    Bitmap localBitmap = a.b.bDS().bf(paramString);
    if (localBitmap == null)
    {
      com.tencent.mm.x.n.Bl();
      paramString = com.tencent.mm.x.d.r(paramString, false);
      v.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", new Object[] { paramString });
    }
    for (paramString = com.tencent.mm.x.d.hn(paramString);; paramString = localBitmap)
    {
      GMTrace.o(9172036878336L, 68337);
      return paramString;
      v.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", new Object[] { paramString });
    }
  }
  
  public static String IF(String paramString)
  {
    GMTrace.i(9172171096064L, 68338);
    ap.yY();
    x localx = com.tencent.mm.u.c.wR().Rb(paramString);
    String str;
    if (o.dH(paramString))
    {
      str = aa.getContext().getString(R.l.dVj);
      paramString = com.tencent.mm.u.n.a(localx, paramString);
      if ((localx.field_username.equals(paramString)) || (bf.mA(paramString))) {
        break label82;
      }
    }
    for (;;)
    {
      GMTrace.o(9172171096064L, 68338);
      return paramString;
      paramString = com.tencent.mm.u.n.a(localx, paramString);
      continue;
      label82:
      paramString = str;
    }
  }
  
  public static byte[] IG(String paramString)
  {
    GMTrace.i(9172842184704L, 68343);
    paramString = "lib" + paramString + ".so";
    paramString = FileOp.c(new File(new File(com.tencent.mm.loader.stub.a.hgf, "lib"), paramString).getAbsolutePath(), 0, -1);
    GMTrace.o(9172842184704L, 68343);
    return paramString;
  }
  
  public static bns R(au paramau)
  {
    GMTrace.i(9172305313792L, 68339);
    bns localbns = new bns();
    localbns.ukW = paramau.field_msgId;
    localbns.ulb = paramau.field_createTime;
    localbns.mrC = 1;
    localbns.ulc = true;
    Object localObject2;
    Object localObject1;
    label100:
    int i;
    if (paramau.field_isSend == 1)
    {
      localbns.tLN = IF(m.xL());
      localbns.ukV = m.xL();
      localObject2 = null;
      if (paramau.isSystem())
      {
        localObject1 = aa.getContext().getString(R.l.eEy);
        localbns.mrC = 3;
        paramau = (au)localObject1;
        if (localObject1 == null) {
          paramau = aa.getContext().getString(R.l.eEx);
        }
        localbns.oog = paramau;
        GMTrace.o(9172305313792L, 68339);
        return localbns;
      }
    }
    else if (o.dH(paramau.field_talker))
    {
      localObject1 = paramau.field_talker;
      i = ay.gh(paramau.field_content);
      if (i == -1) {
        break label1550;
      }
      localObject2 = paramau.field_content.substring(0, i).trim();
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break label1550;
      }
      localObject1 = localObject2;
    }
    label1199:
    label1305:
    label1359:
    label1448:
    label1453:
    label1466:
    label1547:
    label1550:
    for (;;)
    {
      localbns.tLN = IF((String)localObject1);
      localbns.ukV = ((String)localObject1);
      break;
      localbns.tLN = IF(paramau.field_talker);
      localbns.ukV = paramau.field_talker;
      break;
      if (paramau.bLX())
      {
        localObject1 = aa.getContext().getString(R.l.eEe);
        localbns.mrC = 4;
        break label100;
      }
      if (paramau.bMa())
      {
        if ((o.dH(paramau.field_talker)) && (paramau.field_isSend != 1))
        {
          i = ay.gh(paramau.field_content);
          if (i != -1)
          {
            localObject1 = paramau.field_content.substring(i + 1).trim();
            break label100;
          }
          localObject1 = paramau.field_content;
          break label100;
        }
        localObject1 = paramau.field_content;
        break label100;
      }
      if (paramau.bLP())
      {
        localObject1 = aa.getContext().getString(R.l.eEA);
        localbns.mrC = 6;
        localbns.ulc = q.C(paramau);
        float f = q.aw(new com.tencent.mm.modelvoice.n(paramau.field_content).time);
        localbns.uld = new com.tencent.mm.bd.b(aa.getContext().getString(R.l.elS, new Object[] { Integer.valueOf((int)f) }).getBytes());
        break label100;
      }
      if (paramau.bMb())
      {
        localObject1 = aa.getContext().getString(R.l.eEz);
        break label100;
      }
      if (paramau.bMc())
      {
        localObject1 = aa.getContext().getString(R.l.eEw);
        break label100;
      }
      if (paramau.bLQ())
      {
        f.a locala = f.a.ek(paramau.field_content);
        localObject1 = localObject2;
        if (locala == null) {
          break label100;
        }
        if (locala.hiM.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
        {
          localbns.mrC = 5;
          if (paramau.field_isSend == 1)
          {
            localObject1 = locala.hiG;
            break label100;
          }
          localObject1 = locala.hiF;
          break label100;
        }
        if (paramau.field_isSend == 1) {}
        for (paramau = locala.hiG;; paramau = locala.hiF)
        {
          localObject1 = aa.getContext().getString(R.l.eDY, new Object[] { paramau });
          break;
        }
      }
      if (paramau.bLR())
      {
        localObject1 = aa.getContext().getString(R.l.eDX);
        localbns.mrC = 5;
        break label100;
      }
      if (paramau.axH())
      {
        paramau = f.a.ek(paramau.field_content);
        localObject1 = localObject2;
        if (paramau == null) {
          break label100;
        }
        switch (paramau.type)
        {
        case 7: 
        case 9: 
        case 11: 
        case 12: 
        case 14: 
        case 17: 
        case 18: 
        default: 
          localObject1 = localObject2;
          break;
        case 2: 
          localObject1 = String.format(aa.getContext().getString(R.l.eEe), new Object[0]);
          break;
        case 5: 
          localObject1 = String.format(aa.getContext().getString(R.l.eDP), new Object[] { bf.ap(paramau.title, "") });
          break;
        case 3: 
          localObject1 = String.format(aa.getContext().getString(R.l.eDS), new Object[] { bf.ap(paramau.title, "") });
          break;
        case 6: 
          localObject1 = String.format(aa.getContext().getString(R.l.eDO), new Object[] { bf.ap(paramau.title, "") });
          break;
        case 4: 
          localObject1 = String.format(aa.getContext().getString(R.l.eDW), new Object[] { bf.ap(paramau.title, "") });
          break;
        case 19: 
          localObject1 = String.format(aa.getContext().getString(R.l.eDU), new Object[] { bf.ap(paramau.title, "") });
          break;
        case 15: 
          localObject1 = String.format(aa.getContext().getString(R.l.eDN), new Object[] { bf.ap(paramau.title, "") });
          break;
        case 10: 
          localObject1 = String.format(aa.getContext().getString(R.l.eDT), new Object[] { bf.ap(paramau.title, "") });
          break;
        case 13: 
          localObject1 = String.format(aa.getContext().getString(R.l.eDR), new Object[] { bf.ap(paramau.title, "") });
          break;
        case 20: 
          localObject1 = String.format(aa.getContext().getString(R.l.eDV), new Object[] { bf.ap(paramau.title, "") });
          break;
        case 16: 
          localObject1 = String.format(aa.getContext().getString(R.l.eDZ), new Object[] { bf.ap(paramau.title, "") });
          break;
        case 8: 
          localObject1 = aa.getContext().getString(R.l.eEa, new Object[] { bf.ap(paramau.title, "") });
          break;
        }
      }
      if (paramau.bMd())
      {
        localObject1 = aa.getContext().getString(R.l.eEb);
        if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr() == null) {
          break label1547;
        }
        paramau = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(paramau.field_imgPath);
        if (bf.mA(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ua(paramau.EQ())))
        {
          localObject1 = aa.getContext().getString(R.l.eEb);
          localObject2 = new bnb();
          ((bnb)localObject2).tsQ = paramau.EQ();
          if (!paramau.isGif()) {
            break label1305;
          }
          ((bnb)localObject2).jMq = 1;
        }
      }
      try
      {
        for (;;)
        {
          localbns.uld = new com.tencent.mm.bd.b(((bnb)localObject2).toByteArray());
          localbns.mrC = 2;
          break;
          localObject1 = "[" + ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ua(paramau.EQ()) + "]";
          break label1199;
          ((bnb)localObject2).jMq = 2;
        }
        if (paramau.bLZ())
        {
          localObject1 = aa.getContext().getString(R.l.eEf);
          break label100;
        }
        if ((!paramau.bLT()) && (!paramau.bLU()))
        {
          if (paramau.field_type == 64)
          {
            i = 1;
            if (i == 0) {
              break label1466;
            }
          }
        }
        else if (!paramau.field_content.equals(au.uIb))
        {
          paramau = paramau.field_content;
          localObject1 = new rr();
          ((rr)localObject1).fYy.fJB = 1;
          ((rr)localObject1).fYy.content = paramau;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
          if (((rr)localObject1).fYz.type != 3) {
            break label1448;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1453;
          }
          localObject1 = aa.getContext().getString(R.l.eEC);
          break;
          i = 0;
          break label1359;
        }
        localObject1 = aa.getContext().getString(R.l.eEB);
        break label100;
        if (paramau.bLY())
        {
          ap.yY();
          paramau = com.tencent.mm.u.c.wT().At(paramau.field_content);
          localObject1 = String.format(aa.getContext().getString(R.l.eDZ), new Object[] { paramau.getDisplayName() });
          break label100;
        }
        localObject1 = localObject2;
        if (paramau.field_type != -1879048186) {
          break label100;
        }
        localObject1 = aa.getContext().getString(R.l.eDQ);
      }
      catch (IOException paramau)
      {
        for (;;) {}
      }
      break label100;
    }
  }
  
  public static boolean bvF()
  {
    boolean bool = true;
    GMTrace.i(9172573749248L, 68341);
    PackageManager localPackageManager = aa.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
      GMTrace.o(9172573749248L, 68341);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        bool = false;
      }
    }
  }
  
  public static boolean bvG()
  {
    boolean bool = true;
    GMTrace.i(9172707966976L, 68342);
    PackageManager localPackageManager = aa.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app", 1);
      GMTrace.o(9172707966976L, 68342);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        bool = false;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/wear/model/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */