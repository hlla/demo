package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class as
  extends ag.b
{
  private final long vAB;
  private En_5b8fbb1e.a vAn;
  
  public as()
  {
    super(20);
    GMTrace.i(2307471179776L, 17192);
    this.vAB = 259200000L;
    GMTrace.o(2307471179776L, 17192);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2307605397504L, 17193);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof i)))
    {
      localObject = paramView;
      if (((i)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXA);
      ((View)localObject).setTag(new i(this.klJ).dg((View)localObject));
    }
    GMTrace.o(2307605397504L, 17193);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2307739615232L, 17194);
    final i locali = (i)parama;
    this.vAn = parama1;
    parama1.aI(paramau);
    parama = null;
    String str = paramau.field_content;
    paramString = str;
    if (parama1.vzR)
    {
      int i = paramau.field_content.indexOf(':');
      paramString = str;
      if (i != -1) {
        paramString = paramau.field_content.substring(i + 1);
      }
    }
    if (paramString != null) {
      parama = f.a.B(paramString, paramau.field_reserved);
    }
    com.tencent.mm.pluginsdk.model.app.f localf;
    if (parama != null)
    {
      localf = com.tencent.mm.pluginsdk.model.app.g.cv(parama.appId, parama.fWv);
      if ((localf != null) && (localf.bCM())) {
        b(parama1, parama, paramau);
      }
      if ((localf != null) && (localf.field_appName != null) && (localf.field_appName.trim().length() > 0)) {
        break label456;
      }
      paramString = parama.appName;
      if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.g.bn(paramString))) {
        break label482;
      }
      locali.lLh.setText(com.tencent.mm.pluginsdk.model.app.g.a(parama1.uRf.uRz, localf, paramString));
      locali.lLh.setVisibility(0);
      if ((localf == null) || (!localf.bCM())) {
        break label466;
      }
      a(parama1, locali.lLh, paramau, parama, localf.field_packageName, paramau.field_msgSvrId);
      label259:
      a(parama1, locali.lLh, parama.appId);
      label272:
      if ((parama.gxt != null) && (parama.gxt.length() != 0)) {
        break label495;
      }
      locali.vwP.setVisibility(8);
      label299:
      switch (parama.type)
      {
      default: 
        label320:
        if (!parama1.vvA) {
          if (com.tencent.mm.pluginsdk.model.app.g.g(localf))
          {
            locali.vwQ.setVisibility(0);
            locali.vwP.setVisibility(8);
            c(parama1, locali.vwQ, ds.a(parama, paramau));
          }
        }
        break;
      }
    }
    for (;;)
    {
      locali.vAj.setTag(new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0));
      locali.vAj.setOnClickListener(parama1.vzN.vDb);
      if (this.sWq)
      {
        locali.vAj.setOnLongClickListener(parama1.vzN.vDd);
        locali.vAj.setOnTouchListener(parama1.vzN.vDf);
      }
      GMTrace.o(2307739615232L, 17194);
      return;
      label456:
      paramString = localf.field_appName;
      break;
      label466:
      a(parama1, locali.lLh, parama.appId);
      break label259;
      label482:
      locali.lLh.setVisibility(8);
      break label272;
      label495:
      locali.vwP.setVisibility(0);
      b(parama1, locali.vwP, ds.TE(parama.gxt));
      break label299;
      locali.mdM.setVisibility(0);
      com.tencent.mm.pluginsdk.model.app.b localb = an.abF().LV(parama.fCN);
      str = paramau.field_imgPath;
      paramString = Boolean.valueOf(false);
      if (localb != null)
      {
        str = localb.field_fileFullPath;
        paramString = Boolean.valueOf(true);
      }
      if (n.GT().a(locali.mdM, str, paramString.booleanValue(), com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz), parama.hhr, parama.hhq, true, R.g.bdG, locali.mdS, R.g.bdH, 1, true, null)) {
        break label320;
      }
      if (this.sWq) {
        locali.mdM.setImageResource(R.k.dvn);
      }
      for (;;)
      {
        locali.mdM.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2110976425984L, 15728);
            locali.mdM.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locali.mdM.getWidth(), locali.mdM.getHeight());
            locali.mdS.setLayoutParams(localLayoutParams);
            GMTrace.o(2110976425984L, 15728);
          }
        });
        break;
        locali.mdM.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.bhQ));
      }
      locali.vwQ.setVisibility(8);
      continue;
      locali.vwQ.setVisibility(8);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2307873832960L, 17195);
    if ((paramView == null) || (paramau == null))
    {
      GMTrace.o(2307873832960L, 17195);
      return true;
    }
    int k = ((ds)paramView.getTag()).position;
    com.tencent.mm.pluginsdk.model.app.l.Mf(this.vAn.cQ(paramau.field_content, paramau.field_isSend));
    if (com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.aJ(f.a.ek(this.vAn.cQ(paramau.field_content, paramau.field_isSend)).appId, false))) {
      paramContextMenu.add(k, 111, 0, this.vAn.getString(R.l.eLz));
    }
    if (d.Jr("favorite")) {
      paramContextMenu.add(k, 116, 0, this.vAn.getString(R.l.eFS));
    }
    Object localObject = new dd();
    ((dd)localObject).fGN.fGD = paramau.field_msgId;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    boolean bool = com.tencent.mm.pluginsdk.model.app.g.m(this.vAn.uRf.uRz, 2L);
    if ((((dd)localObject).fGO.fGl) || (bool)) {
      paramContextMenu.add(k, 128, 0, paramView.getContext().getString(R.l.dUm));
    }
    int j;
    int i;
    if ((d.Jr("photoedit")) && (paramau.field_status != 5))
    {
      paramau = paramContextMenu.add(k, 130, 0, paramView.getContext().getString(R.l.dTF));
      localObject = new int[2];
      if (paramView == null) {
        break label394;
      }
      j = paramView.getWidth();
      i = paramView.getHeight();
      paramView.getLocationInWindow((int[])localObject);
    }
    for (;;)
    {
      paramView = new Intent();
      paramView.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", localObject[0]).putExtra("img_gallery_top", localObject[1]);
      paramau.setIntent(paramView);
      if (!this.vAn.bVz()) {
        paramContextMenu.add(k, 100, 0, this.vAn.getString(R.l.dUh));
      }
      GMTrace.o(2307873832960L, 17195);
      return true;
      label394:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, final au paramau)
  {
    Object localObject2 = null;
    GMTrace.i(2308008050688L, 17196);
    Object localObject1 = paramau.field_content;
    if (localObject1 != null) {}
    for (localObject1 = f.a.ek((String)localObject1);; localObject1 = null)
    {
      switch (paramMenuItem.getItemId())
      {
      default: 
        GMTrace.o(2308008050688L, 17196);
        return false;
      case 100: 
        if (localObject1 != null) {
          com.tencent.mm.pluginsdk.model.app.l.ed(paramau.field_msgId);
        }
        ay.L(paramau.field_msgId);
        paramMenuItem = com.tencent.mm.pluginsdk.model.app.g.aJ(((f.a)localObject1).appId, false);
        if ((paramMenuItem != null) && (paramMenuItem.bCM())) {
          a(parama, (f.a)localObject1, paramau, paramMenuItem);
        }
        GMTrace.o(2308008050688L, 17196);
        return false;
      }
      paramMenuItem = (MenuItem)localObject2;
      if (localObject1 != null)
      {
        paramMenuItem = (MenuItem)localObject2;
        if (((f.a)localObject1).fCN != null)
        {
          paramMenuItem = (MenuItem)localObject2;
          if (((f.a)localObject1).fCN.length() > 0)
          {
            localObject1 = an.abF().LV(((f.a)localObject1).fCN);
            paramMenuItem = (MenuItem)localObject2;
            if (localObject1 != null) {
              paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath;
            }
          }
        }
      }
      if (!paramau.bMj()) {
        if ((System.currentTimeMillis() - paramau.field_createTime <= 259200000L) || ((!bf.mA(paramMenuItem)) && (e.aO(paramMenuItem)))) {
          break label304;
        }
      }
      label304:
      for (int i = 1; i != 0; i = 0)
      {
        v.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
        com.tencent.mm.ui.base.g.a(parama.uRf.uRz, parama.uRf.uRz.getString(R.l.esn), parama.uRf.uRz.getString(R.l.dIG), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(14619397586944L, 108923);
            GMTrace.o(14619397586944L, 108923);
          }
        });
        GMTrace.o(2308008050688L, 17196);
        return false;
      }
      new ad().post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14619666022400L, 108925);
          com.tencent.mm.pluginsdk.model.app.l.a(paramau, null);
          GMTrace.o(14619666022400L, 108925);
        }
      });
      localObject1 = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
      ((Intent)localObject1).putExtra("Retr_File_Name", paramMenuItem);
      ((Intent)localObject1).putExtra("Retr_Msg_content", parama.cQ(paramau.field_content, paramau.field_isSend));
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 16);
      ((Intent)localObject1).putExtra("Retr_Msg_Id", paramau.field_msgId);
      parama.startActivity((Intent)localObject1);
      GMTrace.o(2308008050688L, 17196);
      return false;
    }
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2308142268416L, 17197);
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      s.eP(parama.uRf.uRz);
      GMTrace.o(2308142268416L, 17197);
      return true;
    }
    Object localObject1 = null;
    Object localObject2 = parama.cQ(paramau.field_content, paramau.field_isSend);
    if (localObject2 != null) {
      localObject1 = f.a.ek((String)localObject2);
    }
    if (localObject1 == null)
    {
      v.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
      GMTrace.o(2308142268416L, 17197);
      return true;
    }
    localObject2 = new int[2];
    int j;
    int i;
    if (paramView != null)
    {
      paramView.getLocationInWindow((int[])localObject2);
      j = paramView.getWidth();
      i = paramView.getHeight();
    }
    for (;;)
    {
      paramView = com.tencent.mm.pluginsdk.model.app.g.aJ(((f.a)localObject1).appId, true);
      if ((paramView != null) && (paramView.bCM())) {
        a(parama, (f.a)localObject1, c(parama, paramau), paramView, paramau.field_msgSvrId);
      }
      if ((((f.a)localObject1).fCN != null) && (((f.a)localObject1).fCN.length() > 0))
      {
        paramView = an.abF().LV(((f.a)localObject1).fCN);
        if ((paramView == null) || (!paramView.ayY())) {
          if (paramau.field_isSend == 0)
          {
            l1 = paramau.field_msgId;
            paramView = new Intent();
            paramView.setClassName(this.vAn.uRf.uRz, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            paramView.putExtra("app_msg_id", l1);
            this.vAn.startActivity(paramView);
          }
        }
      }
      while ((((f.a)localObject1).url == null) || (((f.a)localObject1).url.length() <= 0))
      {
        for (;;)
        {
          GMTrace.o(2308142268416L, 17197);
          return true;
          paramView = paramView.field_fileFullPath;
          if (!e.aO(paramView))
          {
            v.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(paramau.field_msgId), Long.valueOf(paramau.field_msgSvrId) });
            paramView = new Intent();
            paramView.setClassName(parama.uRf.uRz, "com.tencent.mm.ui.chatting.ResourcesExceedUI");
            paramView.putExtra("clean_view_type", 1);
            parama.startActivity(paramView);
            GMTrace.o(2308142268416L, 17197);
            return true;
          }
          if ((paramView != null) && (!paramView.equals("")) && (e.aO(paramView))) {
            break;
          }
          v.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
        }
        long l1 = paramau.field_msgId;
        long l2 = paramau.field_msgSvrId;
        parama = paramau.field_talker;
        paramView = new Intent(this.vAn.uRf.uRz, ImageGalleryUI.class);
        paramView.putExtra("img_gallery_msg_id", l1);
        paramView.putExtra("img_gallery_talker", parama);
        paramView.putExtra("img_gallery_left", localObject2[0]);
        paramView.putExtra("img_gallery_top", localObject2[1]);
        paramView.putExtra("img_gallery_width", j);
        paramView.putExtra("img_gallery_height", i);
        parama = this.vAn.bTW();
        paramau = a(this.vAn, paramau);
        localObject1 = new Bundle();
        if (this.vAn.vzR) {
          i = 2;
        }
        for (;;)
        {
          ((Bundle)localObject1).putInt("stat_scene", i);
          ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
          ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
          ((Bundle)localObject1).putString("stat_send_msg_user", paramau);
          paramView.putExtra("_stat_obj", (Bundle)localObject1);
          this.vAn.startActivity(paramView);
          break;
          if (o.eV(parama)) {
            i = 7;
          } else {
            i = 1;
          }
        }
      }
      localObject2 = p.s(((f.a)localObject1).url, "message");
      PackageInfo localPackageInfo = ay(parama.uRf.uRz, ((f.a)localObject1).appId);
      if (localPackageInfo == null)
      {
        paramView = null;
        label693:
        if (localPackageInfo != null) {
          break label740;
        }
      }
      label740:
      for (i = 0;; i = localPackageInfo.versionCode)
      {
        a(parama, (String)localObject2, (String)localObject2, paramView, i, ((f.a)localObject1).appId, false, paramau.field_msgId, paramau.field_msgSvrId, paramau);
        break;
        paramView = localPackageInfo.versionName;
        break label693;
      }
      i = 0;
      j = 0;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */