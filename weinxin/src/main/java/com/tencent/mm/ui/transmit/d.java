package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.k;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.n;
import java.util.Iterator;
import java.util.List;

public final class d
  implements com.tencent.mm.plugin.messenger.a.c
{
  public d()
  {
    GMTrace.i(3046473990144L, 22698);
    GMTrace.o(3046473990144L, 22698);
  }
  
  public final void A(String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(3046608207872L, 22699);
    if ((paramString1 == null) || (paramString2 == null))
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", new Object[] { paramString1, paramString2 });
      GMTrace.o(3046608207872L, 22699);
      return;
    }
    paramString1 = new com.tencent.mm.modelmulti.j(paramString1, paramString2, paramInt);
    ap.vd().a(paramString1, 0);
    GMTrace.o(3046608207872L, 22699);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, bdq parambdq, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    GMTrace.i(3046876643328L, 22701);
    if (paramContext == null)
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.SendMsgMgr", "send vedio context is null");
      GMTrace.o(3046876643328L, 22701);
      return;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", new Object[] { paramString1, paramString2 });
      GMTrace.o(3046876643328L, 22701);
      return;
    }
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      Toast.makeText(paramContext, R.l.eBr, 1).show();
      GMTrace.o(3046876643328L, 22701);
      return;
    }
    final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
    paramContext.getResources().getString(R.l.dIG);
    p localp = g.a(paramContext, paramContext.getResources().getString(R.l.dIt), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(3015201259520L, 22465);
        locala.woj = true;
        GMTrace.o(3015201259520L, 22465);
      }
    });
    locala.context = paramContext;
    locala.fyw = paramString2;
    locala.wok = paramString3;
    locala.isG = localp;
    locala.userName = paramString1;
    locala.fUO = paramString4;
    locala.won = false;
    if (62 == paramInt1) {
      locala.hYh = 11;
    }
    if (paramInt1 > 0) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      locala.wnJ = paramInt1;
      locala.hZV = paramInt2;
      locala.wol = false;
      locala.woo = parambdq;
      locala.execute(new Object[0]);
      GMTrace.o(3046876643328L, 22701);
      return;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    GMTrace.i(3046742425600L, 22700);
    a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, null, false, false, paramString4);
    GMTrace.o(3046742425600L, 22700);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    GMTrace.i(3047145078784L, 22703);
    if (paramString1 == null)
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
      GMTrace.o(3047145078784L, 22703);
      return;
    }
    com.tencent.mm.sdk.platformtools.v.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", new Object[] { paramString2 });
    f.a locala = f.a.ek(bf.PW(paramString2));
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
      GMTrace.o(3047145078784L, 22703);
      return;
    }
    Object localObject = new b();
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SendMsgMgr", "content.attachid %s", new Object[] { locala.fCN });
    paramString2 = (String)localObject;
    if (!bf.mA(locala.fCN))
    {
      long l = bf.getLong(locala.fCN, -1L);
      if (l == -1L) {
        break label418;
      }
      an.abF().b(l, (com.tencent.mm.sdk.e.c)localObject);
      paramString2 = (String)localObject;
      if (((b)localObject).uvp != l)
      {
        localObject = an.abF().LV(locala.fCN);
        if (localObject != null)
        {
          paramString2 = (String)localObject;
          if (((b)localObject).field_mediaSvrId.equals(locala.fCN)) {}
        }
        else
        {
          paramString2 = null;
        }
        if (paramString2 != null) {
          break label378;
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", new Object[] { locala.fCN });
      }
    }
    for (;;)
    {
      String str = "";
      localObject = str;
      if (paramString2 != null)
      {
        localObject = str;
        if (paramString2.field_fileFullPath != null)
        {
          localObject = str;
          if (!paramString2.field_fileFullPath.equals(""))
          {
            ap.yY();
            localObject = l.W(com.tencent.mm.u.c.xn(), locala.title, locala.hhh);
            com.tencent.mm.sdk.platformtools.j.p(paramString2.field_fileFullPath, (String)localObject, false);
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", new Object[] { paramString2.field_fileFullPath, localObject, Integer.valueOf(e.aN(paramString2.field_fileFullPath)) });
          }
        }
      }
      paramString2 = f.a.a(locala);
      paramString2.hhj = 3;
      l.a(paramString2, locala.appId, locala.appName, paramString1, (String)localObject, paramArrayOfByte, paramString3);
      GMTrace.o(3047145078784L, 22703);
      return;
      label378:
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", new Object[] { locala.fCN, Long.valueOf(paramString2.uvp), paramString2.field_fileFullPath });
      continue;
      label418:
      localObject = an.abF().LV(locala.fCN);
      if (localObject != null)
      {
        paramString2 = (String)localObject;
        if (((b)localObject).field_mediaSvrId.equals(locala.fCN)) {}
      }
      else
      {
        paramString2 = null;
      }
      if (paramString2 == null) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", new Object[] { locala.fCN });
      } else {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", new Object[] { locala.fCN, Long.valueOf(paramString2.uvp), paramString2.field_fileFullPath });
      }
    }
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    GMTrace.i(3047010861056L, 22702);
    if ((paramString1 == null) || (paramString2 == null))
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", new Object[] { paramString1, paramString2 });
      GMTrace.o(3047010861056L, 22702);
      return;
    }
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      Toast.makeText(paramContext, R.l.eBr, 1).show();
      GMTrace.o(3047010861056L, 22702);
      return;
    }
    paramContext = new k(4, m.xL(), paramString1, paramString2, paramInt, null, 0, paramString3, paramString4, true, R.g.bdI);
    ap.vd().a(paramContext, 0);
    bm.zN().c(bm.hnE, null);
    GMTrace.o(3047010861056L, 22702);
  }
  
  public final void cM(String paramString1, String paramString2)
  {
    GMTrace.i(3047413514240L, 22705);
    paramString2 = bf.f(bf.ap(paramString2, "").split(","));
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        String str = (String)paramString2.next();
        nv localnv = new nv();
        localnv.fUQ.fUR = str;
        localnv.fUQ.content = paramString1;
        localnv.fUQ.type = o.fG(str);
        localnv.fUQ.flags = 0;
        a.uql.m(localnv);
      }
    }
    GMTrace.o(3047413514240L, 22705);
  }
  
  public final void k(String paramString1, String paramString2, boolean paramBoolean)
  {
    GMTrace.i(3047279296512L, 22704);
    if (paramBoolean)
    {
      paramString1 = new com.tencent.mm.modelmulti.j(bf.ap(paramString2, ""), com.tencent.mm.ui.contact.v.TR(paramString1), 42);
      ap.vd().a(paramString1, 0);
      GMTrace.o(3047279296512L, 22704);
      return;
    }
    paramString2 = bf.f(bf.ap(paramString2, "").split(","));
    paramString1 = com.tencent.mm.ui.contact.v.TR(paramString1);
    int i = 0;
    while (i < paramString2.size())
    {
      com.tencent.mm.modelmulti.j localj = new com.tencent.mm.modelmulti.j((String)paramString2.get(i), paramString1, 42);
      ap.vd().a(localj, 0);
      i += 1;
    }
    GMTrace.o(3047279296512L, 22704);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/transmit/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */