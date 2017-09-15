package com.tencent.mm.ui.chatting;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.j.a;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ef
{
  public static void a(au paramau, final Context paramContext)
  {
    GMTrace.i(2368942899200L, 17650);
    if (paramContext == null)
    {
      v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
      GMTrace.o(2368942899200L, 17650);
      return;
    }
    if (paramau == null)
    {
      v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
      GMTrace.o(2368942899200L, 17650);
      return;
    }
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      s.eP(paramContext);
      v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
      GMTrace.o(2368942899200L, 17650);
      return;
    }
    a(cB(w.DH().fw(8)), paramContext, new n.d()
    {
      public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        GMTrace.i(2486517628928L, 18526);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        r localr = t.lI(this.hkK.field_imgPath);
        v.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", new Object[] { paramAnonymousMenuItem, this.hkK.field_imgPath });
        final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
        Object localObject = paramContext;
        paramContext.getResources().getString(R.l.dIG);
        localObject = com.tencent.mm.ui.base.g.a((Context)localObject, paramContext.getResources().getString(R.l.dIt), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            GMTrace.i(2181038080000L, 16250);
            locala.woj = true;
            GMTrace.o(2181038080000L, 16250);
          }
        });
        locala.context = paramContext;
        locala.fyw = this.hkK.field_imgPath;
        locala.isG = ((Dialog)localObject);
        locala.userName = paramAnonymousMenuItem;
        locala.wnJ = localr.hZZ;
        locala.hZV = localr.hZV;
        locala.execute(new Object[0]);
        bm.zN().c(bm.hnF, null);
        com.tencent.mm.ui.base.g.bk(paramContext, paramContext.getString(R.l.dIq));
        GMTrace.o(2486517628928L, 18526);
      }
    });
    GMTrace.o(2368942899200L, 17650);
  }
  
  public static void a(au paramau, final Context paramContext, final String paramString, final boolean paramBoolean)
  {
    GMTrace.i(16136057913344L, 120223);
    if (paramContext == null)
    {
      v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
      GMTrace.o(16136057913344L, 120223);
      return;
    }
    if (paramau == null)
    {
      v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
      GMTrace.o(16136057913344L, 120223);
      return;
    }
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      s.eP(paramContext);
      v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
      GMTrace.o(16136057913344L, 120223);
      return;
    }
    a(cB(w.DH().fw(4)), paramContext, new n.d()
    {
      public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        GMTrace.i(2270158651392L, 16914);
        String str = paramAnonymousMenuItem.getTitle();
        paramAnonymousMenuItem = null;
        if (this.hkK.field_msgId > 0L) {
          paramAnonymousMenuItem = com.tencent.mm.ah.n.GT().aj(this.hkK.field_msgId);
        }
        if (((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.hEG <= 0L)) && (this.hkK.field_msgSvrId > 0L)) {
          paramAnonymousMenuItem = com.tencent.mm.ah.n.GT().ai(this.hkK.field_msgSvrId);
        }
        for (;;)
        {
          if (paramAnonymousMenuItem == null)
          {
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
            GMTrace.o(2270158651392L, 16914);
            return;
          }
          if ((paramAnonymousMenuItem.offset >= paramAnonymousMenuItem.hrb) && (paramAnonymousMenuItem.hrb != 0))
          {
            if (this.hkK.field_isSend == 1) {
              if (paramAnonymousMenuItem.GC()) {
                paramAnonymousInt = 1;
              }
            }
            for (;;)
            {
              localObject = m.xL();
              paramAnonymousMenuItem = com.tencent.mm.ah.n.GT().m(com.tencent.mm.ah.e.c(paramAnonymousMenuItem), "", "");
              if (!bf.mA(paramAnonymousMenuItem))
              {
                v.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", new Object[] { str, paramAnonymousMenuItem });
                paramAnonymousMenuItem = new com.tencent.mm.ah.k(4, (String)localObject, str, paramAnonymousMenuItem, paramAnonymousInt, null, 0, "", "", true, R.g.bdI);
                ap.vd().a(paramAnonymousMenuItem, 0);
                bm.zN().c(bm.hnE, null);
              }
              com.tencent.mm.plugin.report.service.g.oSF.i(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), str });
              com.tencent.mm.ui.base.g.bk(paramContext, paramContext.getString(R.l.dIq));
              GMTrace.o(2270158651392L, 16914);
              return;
              paramAnonymousInt = 0;
              continue;
              if (!paramAnonymousMenuItem.GC()) {
                paramAnonymousInt = 0;
              } else if (!com.tencent.mm.a.e.aO(com.tencent.mm.ah.e.a(paramAnonymousMenuItem).hEH)) {
                paramAnonymousInt = 0;
              } else {
                paramAnonymousInt = 1;
              }
            }
          }
          paramAnonymousMenuItem = new Intent(paramContext, ImageGalleryUI.class);
          paramAnonymousMenuItem.putExtra("img_gallery_msg_id", this.hkK.field_msgId);
          paramAnonymousMenuItem.putExtra("img_gallery_msg_svr_id", this.hkK.field_msgSvrId);
          paramAnonymousMenuItem.putExtra("img_gallery_talker", this.hkK.field_talker);
          paramAnonymousMenuItem.putExtra("img_gallery_chatroom_name", this.hkK.field_talker);
          paramAnonymousMenuItem.putExtra("img_gallery_is_restransmit_after_download", true);
          paramAnonymousMenuItem.putExtra("img_gallery_directly_send_name", str);
          paramAnonymousMenuItem.putExtra("start_chatting_ui", false);
          str = this.hkK.field_talker;
          Object localObject = new Bundle();
          if (paramBoolean) {
            paramAnonymousInt = 2;
          }
          for (;;)
          {
            ((Bundle)localObject).putInt("stat_scene", paramAnonymousInt);
            ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(this.hkK.field_msgSvrId));
            ((Bundle)localObject).putString("stat_chat_talker_username", str);
            ((Bundle)localObject).putString("stat_send_msg_user", paramString);
            paramAnonymousMenuItem.putExtra("_stat_obj", (Bundle)localObject);
            paramContext.startActivity(paramAnonymousMenuItem);
            GMTrace.o(2270158651392L, 16914);
            return;
            if (o.eV(str)) {
              paramAnonymousInt = 7;
            } else {
              paramAnonymousInt = 1;
            }
          }
        }
      }
    });
    GMTrace.o(16136057913344L, 120223);
  }
  
  public static void a(au paramau, String paramString, Context paramContext)
  {
    GMTrace.i(2369211334656L, 17652);
    a(paramau, paramString, paramContext, 512);
    GMTrace.o(2369211334656L, 17652);
  }
  
  private static void a(au paramau, final String paramString, final Context paramContext, final int paramInt)
  {
    GMTrace.i(2369613987840L, 17655);
    if (paramContext == null)
    {
      v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
      GMTrace.o(2369613987840L, 17655);
      return;
    }
    if (paramau == null)
    {
      v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
      GMTrace.o(2369613987840L, 17655);
      return;
    }
    List localList = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(localList, paramContext, new n.d()
      {
        public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          GMTrace.i(2316597985280L, 17260);
          paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
          ef.a(paramAnonymousMenuItem, this.hkK, paramString);
          switch (paramInt)
          {
          }
          for (;;)
          {
            com.tencent.mm.ui.base.g.bk(paramContext, paramContext.getString(R.l.dIq));
            GMTrace.o(2316597985280L, 17260);
            return;
            com.tencent.mm.plugin.report.service.g.oSF.i(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(256), paramAnonymousMenuItem });
            continue;
            com.tencent.mm.plugin.report.service.g.oSF.i(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(128), paramAnonymousMenuItem });
            continue;
            com.tencent.mm.plugin.report.service.g.oSF.i(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(512), paramAnonymousMenuItem });
          }
        }
      });
      GMTrace.o(2369613987840L, 17655);
      return;
      localList = cB(w.DH().fw(256));
      continue;
      localList = cB(com.tencent.mm.modelbiz.e.Dv());
      continue;
      localList = cB(w.DH().fw(512));
    }
  }
  
  public static void a(String paramString1, au paramau, String paramString2)
  {
    GMTrace.i(16095389941760L, 119920);
    f.a locala = f.a.ek(bf.PW(paramString2));
    if (locala == null)
    {
      v.w("MicroMsg.LongClickBrandServiceHelper", "send: parse app msg content return null");
      GMTrace.o(16095389941760L, 119920);
      return;
    }
    Object localObject = null;
    paramString2 = (String)localObject;
    if (paramau.field_imgPath != null)
    {
      paramString2 = (String)localObject;
      if (!paramau.field_imgPath.equals("")) {
        paramau = com.tencent.mm.ah.n.GT().v(paramau.field_imgPath, true);
      }
    }
    try
    {
      paramString2 = com.tencent.mm.a.e.c(paramau, 0, com.tencent.mm.a.e.aN(paramau));
      localObject = new b();
      paramau = (au)localObject;
      if (!bf.mA(locala.fCN))
      {
        long l = bf.getLong(locala.fCN, -1L);
        if (l == -1L) {
          break label335;
        }
        an.abF().b(l, (com.tencent.mm.sdk.e.c)localObject);
        paramau = (au)localObject;
        if (((b)localObject).uvp != l)
        {
          localObject = an.abF().LV(locala.fCN);
          if (localObject != null)
          {
            paramau = (au)localObject;
            if (((b)localObject).field_mediaSvrId.equals(locala.fCN)) {}
          }
          else
          {
            paramau = null;
          }
        }
      }
      String str = "";
      localObject = str;
      if (paramau != null)
      {
        localObject = str;
        if (paramau.field_fileFullPath != null)
        {
          localObject = str;
          if (!paramau.field_fileFullPath.equals(""))
          {
            ap.yY();
            localObject = com.tencent.mm.pluginsdk.model.app.l.W(com.tencent.mm.u.c.xn(), locala.title, locala.hhh);
            com.tencent.mm.sdk.platformtools.j.p(paramau.field_fileFullPath, (String)localObject, false);
          }
        }
      }
      paramau = f.a.a(locala);
      paramau.hhj = 3;
      com.tencent.mm.pluginsdk.model.app.l.a(paramau, locala.appId, locala.appName, paramString1, (String)localObject, paramString2, null);
      GMTrace.o(16095389941760L, 119920);
      return;
    }
    catch (Exception paramau)
    {
      for (;;)
      {
        v.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", new Object[] { paramString1, paramau.getLocalizedMessage() });
        paramString2 = (String)localObject;
        continue;
        label335:
        localObject = an.abF().LV(locala.fCN);
        if (localObject != null)
        {
          paramau = (au)localObject;
          if (((b)localObject).field_mediaSvrId.equals(locala.fCN)) {}
        }
        else
        {
          paramau = null;
        }
      }
    }
  }
  
  static void a(List<String> paramList, Context paramContext, n.d paramd)
  {
    GMTrace.i(2369882423296L, 17657);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      v.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
      GMTrace.o(2369882423296L, 17657);
      return;
    }
    com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(paramContext);
    locall.wkZ = new n.a()
    {
      public final void a(ImageView paramAnonymousImageView, MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2196204683264L, 16363);
        a.b.a(paramAnonymousImageView, paramAnonymousMenuItem.getTitle());
        GMTrace.o(2196204683264L, 16363);
      }
    };
    locall.wla = new n.b()
    {
      public final void a(TextView paramAnonymousTextView, MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2120237449216L, 15797);
        if (paramAnonymousTextView != null)
        {
          ap.yY();
          x localx = com.tencent.mm.u.c.wR().Rb(paramAnonymousMenuItem.getTitle());
          if ((localx == null) || ((int)localx.gTG <= 0))
          {
            paramAnonymousTextView.setText(paramAnonymousMenuItem.getTitle());
            GMTrace.o(2120237449216L, 15797);
            return;
          }
          paramAnonymousTextView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.val$context, localx.tK(), paramAnonymousTextView.getTextSize()));
        }
        GMTrace.o(2120237449216L, 15797);
      }
    };
    locall.qHD = new n.c()
    {
      public final void a(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        GMTrace.i(2202781351936L, 16412);
        Iterator localIterator = this.vMr.iterator();
        while (localIterator.hasNext()) {
          paramAnonymousl.add((String)localIterator.next());
        }
        GMTrace.o(2202781351936L, 16412);
      }
    };
    locall.qHE = paramd;
    locall.bkT();
    GMTrace.o(2369882423296L, 17657);
  }
  
  public static void b(au paramau, final Context paramContext)
  {
    GMTrace.i(2369077116928L, 17651);
    if (paramContext == null)
    {
      v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
      GMTrace.o(2369077116928L, 17651);
      return;
    }
    if (paramau == null)
    {
      v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
      GMTrace.o(2369077116928L, 17651);
      return;
    }
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      s.eP(paramContext);
      v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
      GMTrace.o(2369077116928L, 17651);
      return;
    }
    a(cB(w.DH().fw(64)), paramContext, new n.d()
    {
      public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        GMTrace.i(2385183244288L, 17771);
        String str = paramAnonymousMenuItem.getTitle();
        paramAnonymousMenuItem = aj.RC(this.hkK.field_content).fFN;
        if ((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.endsWith("-1"))) {
          paramAnonymousMenuItem = this.hkK.field_imgPath;
        }
        for (;;)
        {
          if (paramAnonymousMenuItem == null)
          {
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
            GMTrace.o(2385183244288L, 17771);
            return;
          }
          v.i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", new Object[] { str, paramAnonymousMenuItem });
          if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().l(paramContext, str, paramAnonymousMenuItem))
          {
            com.tencent.mm.plugin.report.service.g.oSF.i(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
            com.tencent.mm.ui.base.g.bk(paramContext, "");
          }
          com.tencent.mm.plugin.report.service.g.oSF.i(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
          com.tencent.mm.ui.base.g.bk(paramContext, paramContext.getString(R.l.dIq));
          GMTrace.o(2385183244288L, 17771);
          return;
        }
      }
    });
    GMTrace.o(2369077116928L, 17651);
  }
  
  public static void b(au paramau, String paramString, Context paramContext)
  {
    GMTrace.i(2369345552384L, 17653);
    a(paramau, paramString, paramContext, 256);
    GMTrace.o(2369345552384L, 17653);
  }
  
  public static void c(au paramau, String paramString, Context paramContext)
  {
    GMTrace.i(2369479770112L, 17654);
    a(paramau, paramString, paramContext, 128);
    GMTrace.o(2369479770112L, 17654);
  }
  
  static List<String> cB(List<String> paramList)
  {
    GMTrace.i(2369748205568L, 17656);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!com.tencent.mm.modelbiz.e.hZ(str)) {
        localLinkedList.add(str);
      }
    }
    v.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    GMTrace.o(2369748205568L, 17656);
    return localLinkedList;
  }
  
  public static void k(String paramString, final Context paramContext)
  {
    GMTrace.i(2368674463744L, 17648);
    if (paramContext == null)
    {
      v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
      GMTrace.o(2368674463744L, 17648);
      return;
    }
    if (bf.mA(paramString))
    {
      v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
      GMTrace.o(2368674463744L, 17648);
      return;
    }
    a(cB(w.DH().fw(1)), paramContext, new n.d()
    {
      public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        GMTrace.i(2176072024064L, 16213);
        paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
        v.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", new Object[] { paramAnonymousMenuItem, this.hRC });
        com.tencent.mm.modelmulti.j localj = new com.tencent.mm.modelmulti.j(paramAnonymousMenuItem, this.hRC, o.fG(paramAnonymousMenuItem));
        ap.vd().a(localj, 0);
        com.tencent.mm.plugin.report.service.g.oSF.i(10424, new Object[] { Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem });
        com.tencent.mm.ui.base.g.bk(paramContext, paramContext.getString(R.l.dIq));
        GMTrace.o(2176072024064L, 16213);
      }
    });
    GMTrace.o(2368674463744L, 17648);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */