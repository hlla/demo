package com.tencent.mm.ui.chatting;

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
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class ba
  extends ag.c
{
  public En_5b8fbb1e.a vAn;
  
  public ba()
  {
    super(21);
    GMTrace.i(2260897628160L, 16845);
    GMTrace.o(2260897628160L, 16845);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2261031845888L, 16846);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof i)))
    {
      localObject = paramView;
      if (((i)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYf);
      ((View)localObject).setTag(new i(this.klJ).dg((View)localObject));
    }
    GMTrace.o(2261031845888L, 16846);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2261166063616L, 16847);
    final i locali = (i)parama;
    this.vAn = parama1;
    parama1.aI(paramau);
    parama = null;
    String str = paramau.field_content;
    if (str != null) {
      parama = f.a.B(str, paramau.field_reserved);
    }
    Object localObject;
    label192:
    label205:
    label228:
    int i;
    if (parama != null)
    {
      localObject = com.tencent.mm.pluginsdk.model.app.g.cv(parama.appId, parama.fWv);
      if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.f)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.f)localObject).field_appName.trim().length() <= 0))
      {
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.g.bn(paramString))) {
          break label433;
        }
        locali.lLh.setText(com.tencent.mm.pluginsdk.model.app.g.a(parama1.uRf.uRz, (com.tencent.mm.pluginsdk.model.app.f)localObject, paramString));
        locali.lLh.setVisibility(0);
        if ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.f)localObject).bCM())) {
          break label417;
        }
        a(parama1, locali.lLh, paramau, parama, ((com.tencent.mm.pluginsdk.model.app.f)localObject).field_packageName, paramau.field_msgSvrId);
        a(parama1, locali.lLh, parama.appId);
      }
    }
    else
    {
      switch (parama.type)
      {
      default: 
        locali.vAj.setTag(new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0));
        locali.vAj.setOnClickListener(parama1.vzN.vDb);
        if (this.sWq)
        {
          locali.vAj.setOnLongClickListener(parama1.vzN.vDd);
          locali.vAj.setOnTouchListener(parama1.vzN.vDf);
        }
        i = com.tencent.mm.pluginsdk.model.app.l.Mf(str);
        if ((i == -1) || (i >= 100) || (parama.hhg <= 0) || (paramau.field_status == 5))
        {
          locali.lJd.setVisibility(8);
          locali.mdM.setAlpha(255);
          locali.mdM.setBackgroundDrawable(null);
        }
        break;
      }
    }
    for (;;)
    {
      a(paramInt, locali, paramau, parama1.vzN.hrv, parama1.vvA, parama1.vzN.vDb);
      GMTrace.o(2261166063616L, 16847);
      return;
      paramString = ((com.tencent.mm.pluginsdk.model.app.f)localObject).field_appName;
      break;
      label417:
      a(parama1, locali.lLh, parama.appId);
      break label192;
      label433:
      locali.lLh.setVisibility(8);
      break label205;
      locali.mdM.setVisibility(0);
      com.tencent.mm.pluginsdk.model.app.b localb = an.abF().LV(parama.fCN);
      localObject = paramau.field_imgPath;
      paramString = Boolean.valueOf(false);
      if (localb != null)
      {
        localObject = localb.field_fileFullPath;
        paramString = Boolean.valueOf(true);
      }
      if (n.GT().a(locali.mdM, (String)localObject, paramString.booleanValue(), com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz), parama.hht, parama.hhs, true, R.g.bdI, locali.mdS, R.g.bdJ, 0, true, null)) {
        break label228;
      }
      if (this.sWq) {
        locali.mdM.setImageResource(R.k.dvo);
      }
      for (;;)
      {
        locali.mdM.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2144799293440L, 15980);
            locali.mdM.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locali.mdM.getWidth(), locali.mdM.getHeight());
            locali.mdS.setLayoutParams(localLayoutParams);
            GMTrace.o(2144799293440L, 15980);
          }
        });
        break;
        locali.mdM.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.bhQ));
      }
      locali.lJd.setVisibility(0);
      locali.vwO.setText(i + "%");
      locali.mdM.setAlpha(64);
      locali.mdM.setBackgroundResource(R.g.bju);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2261300281344L, 16848);
    int k = ((ds)paramView.getTag()).position;
    Object localObject = paramau.field_content;
    localObject = f.a.ek(this.vAn.cQ((String)localObject, paramau.field_isSend));
    if ((localObject != null) && (com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.aJ(((f.a)localObject).appId, false)))) {
      paramContextMenu.add(k, 111, 0, this.vAn.getString(R.l.eLz));
    }
    if (d.Jr("favorite")) {
      paramContextMenu.add(k, 116, 0, this.vAn.getString(R.l.eFS));
    }
    localObject = new dd();
    ((dd)localObject).fGN.fGD = paramau.field_msgId;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    boolean bool = com.tencent.mm.pluginsdk.model.app.g.m(this.vAn.uRf.uRz, 2L);
    if ((((dd)localObject).fGO.fGl) || (bool)) {
      paramContextMenu.add(k, 128, 0, paramView.getContext().getString(R.l.dUm));
    }
    if ((d.Jr("photoedit")) && (paramau.field_status != 5))
    {
      localObject = paramContextMenu.add(k, 130, 0, paramView.getContext().getString(R.l.dTF));
      int j = 0;
      int i = 0;
      int[] arrayOfInt = new int[2];
      if (paramView != null)
      {
        j = paramView.getWidth();
        i = paramView.getHeight();
        paramView.getLocationInWindow(arrayOfInt);
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
      ((MenuItem)localObject).setIntent(localIntent);
    }
    if ((!paramau.bLN()) && (paramau.bMf()) && ((paramau.field_status == 2) || (paramau.gxz == 1)) && (ao(paramau)) && (Tm(paramau.field_talker))) {
      paramContextMenu.add(k, 123, 0, paramView.getContext().getString(R.l.dUp));
    }
    if (!this.vAn.bVz()) {
      paramContextMenu.add(k, 100, 0, this.vAn.getString(R.l.dUh));
    }
    GMTrace.o(2261300281344L, 16848);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    Object localObject2 = null;
    GMTrace.i(2261434499072L, 16849);
    Object localObject1 = paramau.field_content;
    if (localObject1 != null) {}
    for (localObject1 = f.a.ek((String)localObject1);; localObject1 = null)
    {
      switch (paramMenuItem.getItemId())
      {
      default: 
        GMTrace.o(2261434499072L, 16849);
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
        GMTrace.o(2261434499072L, 16849);
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
      localObject1 = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
      ((Intent)localObject1).putExtra("Retr_Msg_content", paramau.field_content);
      ((Intent)localObject1).putExtra("Retr_File_Name", paramMenuItem);
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 16);
      ((Intent)localObject1).putExtra("Retr_Msg_Id", paramau.field_msgId);
      parama.startActivity((Intent)localObject1);
      GMTrace.o(2261434499072L, 16849);
      return false;
    }
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, final au paramau)
  {
    GMTrace.i(2261568716800L, 16850);
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      s.eP(parama.uRf.uRz);
      GMTrace.o(2261568716800L, 16850);
      return true;
    }
    if ((((ds)paramView.getTag()).klJ == 5) && (paramau.field_isSend == 1))
    {
      if (paramau != null) {
        com.tencent.mm.ui.base.g.b(this.vAn.uRf.uRz, this.vAn.getString(R.l.dVd), "", this.vAn.getString(R.l.dIn), this.vAn.getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2394712702976L, 17842);
            com.tencent.mm.pluginsdk.model.app.l.V(paramau);
            ay.L(paramau.field_msgId);
            ba.this.vAn.bVv();
            GMTrace.o(2394712702976L, 17842);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2386659639296L, 17782);
            GMTrace.o(2386659639296L, 17782);
          }
        });
      }
      GMTrace.o(2261568716800L, 16850);
      return true;
    }
    Object localObject1 = null;
    Object localObject2 = paramau.field_content;
    if (localObject2 != null) {
      localObject1 = f.a.ek((String)localObject2);
    }
    if (localObject1 == null)
    {
      v.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
      GMTrace.o(2261568716800L, 16850);
      return true;
    }
    localObject2 = new int[2];
    int i;
    if (paramView != null)
    {
      paramView.getLocationInWindow((int[])localObject2);
      i = paramView.getWidth();
    }
    for (int j = paramView.getHeight();; j = 0)
    {
      paramView = com.tencent.mm.pluginsdk.model.app.g.aJ(((f.a)localObject1).appId, false);
      if ((paramView != null) && (paramView.bCM())) {
        a(parama, (f.a)localObject1, m.xL(), paramView, paramau.field_msgSvrId);
      }
      label607:
      PackageInfo localPackageInfo;
      if ((((f.a)localObject1).fCN != null) && (((f.a)localObject1).fCN.length() > 0))
      {
        paramView = an.abF().LV(((f.a)localObject1).fCN);
        if (paramView != null)
        {
          ap.yY();
          if (!com.tencent.mm.u.c.isSDCardAvailable()) {
            s.eP(parama.uRf.uRz);
          }
          for (;;)
          {
            GMTrace.o(2261568716800L, 16850);
            return true;
            if (paramau.field_isSend == 1)
            {
              paramView = paramView.field_fileFullPath;
              if (!e.aO(paramView)) {
                break label607;
              }
              if ((paramView != null) && (!paramView.equals("")) && (e.aO(paramView))) {
                break;
              }
              v.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
            }
          }
          long l1 = paramau.field_msgId;
          long l2 = paramau.field_msgSvrId;
          parama = paramau.field_talker;
          paramView = new Intent(this.vAn.uRf.uRz, ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", i);
          paramView.putExtra("img_gallery_height", j);
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
          v.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(paramau.field_msgId), Long.valueOf(paramau.field_msgSvrId) });
          paramView = new Intent();
          paramView.setClassName(parama.uRf.uRz, "com.tencent.mm.ui.chatting.ResourcesExceedUI");
          paramView.putExtra("clean_view_type", 1);
          parama.startActivity(paramView);
          GMTrace.o(2261568716800L, 16850);
          return true;
        }
      }
      else if ((((f.a)localObject1).url != null) && (((f.a)localObject1).url.length() > 0))
      {
        localObject2 = p.s(((f.a)localObject1).url, "message");
        localPackageInfo = ay(parama.uRf.uRz, ((f.a)localObject1).appId);
        if (localPackageInfo != null) {
          break label794;
        }
        paramView = null;
        if (localPackageInfo != null) {
          break label803;
        }
      }
      label794:
      label803:
      for (i = 0;; i = localPackageInfo.versionCode)
      {
        a(parama, (String)localObject2, (String)localObject2, paramView, i, ((f.a)localObject1).appId, false, paramau.field_msgId, paramau.field_msgSvrId, paramau);
        GMTrace.o(2261568716800L, 16850);
        return false;
        paramView = localPackageInfo.versionName;
        break;
      }
      i = 0;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */