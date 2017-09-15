package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.e.a.cl;
import com.tencent.mm.e.a.ik;
import com.tencent.mm.e.a.ik.b;
import com.tencent.mm.e.a.nw;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.qk.b;
import com.tencent.mm.e.a.rq;
import com.tencent.mm.e.a.rq.a;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.e.a.rr.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.storage.au.c;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ag.b.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.d.a;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.Map;
import junit.framework.Assert;

class cw
  implements View.OnClickListener
{
  public static boolean vDR;
  public En_5b8fbb1e.a vAn;
  
  static
  {
    GMTrace.i(2108426289152L, 15709);
    vDR = false;
    GMTrace.o(2108426289152L, 15709);
  }
  
  public cw(En_5b8fbb1e.a parama, String paramString)
  {
    GMTrace.i(2106144587776L, 15692);
    this.vAn = parama;
    parama = new ik();
    parama.fNV.fNQ = 0;
    parama.fNV.aQd = com.tencent.mm.sdk.platformtools.u.bID();
    if (com.tencent.mm.u.o.dH(paramString)) {}
    for (parama.fNV.fNX = true;; parama.fNV.fNX = false)
    {
      com.tencent.mm.sdk.b.a.uql.m(parama);
      GMTrace.o(2106144587776L, 15692);
      return;
    }
  }
  
  private void a(long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    GMTrace.i(2107755200512L, 15704);
    Intent localIntent = new Intent(this.vAn.uRf.uRz, ImageGalleryUI.class);
    localIntent.putExtra("img_gallery_msg_id", paramLong1);
    localIntent.putExtra("show_search_chat_content_result", this.vAn.vzI);
    localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
    localIntent.putExtra("key_is_biz_chat", this.vAn.sLe);
    localIntent.putExtra("key_biz_chat_id", this.vAn.bVG());
    localIntent.putExtra("img_gallery_talker", paramString1);
    localIntent.putExtra("img_gallery_chatroom_name", paramString2);
    localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
    localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
    localIntent.putExtra("img_gallery_width", paramInt1);
    localIntent.putExtra("img_gallery_height", paramInt2);
    localIntent.putExtra("img_gallery_enter_from_chatting_ui", this.vAn.vHr);
    localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", x.em(paramString1));
    paramString2 = this.vAn.bTW();
    paramArrayOfInt = new Bundle();
    if (this.vAn.vzR) {
      paramInt1 = 2;
    }
    for (;;)
    {
      paramArrayOfInt.putInt("stat_scene", paramInt1);
      paramArrayOfInt.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
      paramArrayOfInt.putString("stat_chat_talker_username", paramString2);
      paramArrayOfInt.putString("stat_send_msg_user", paramString1);
      localIntent.putExtra("_stat_obj", paramArrayOfInt);
      this.vAn.startActivity(localIntent);
      this.vAn.overridePendingTransition(0, 0);
      GMTrace.o(2107755200512L, 15704);
      return;
      if (com.tencent.mm.u.o.eV(paramString2)) {
        paramInt1 = 7;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  private static void a(View paramView, ds paramds)
  {
    GMTrace.i(14924742918144L, 111198);
    if ((paramView instanceof MMTextView))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.d.a.a.bXu();
      com.tencent.mm.ui.chatting.d.a.a.a(paramView.getText(), paramds.fTa);
    }
    GMTrace.o(14924742918144L, 111198);
  }
  
  private void a(ds paramds)
  {
    GMTrace.i(2106413023232L, 15694);
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.eP(this.vAn.uRf.uRz);
      GMTrace.o(2106413023232L, 15694);
      return;
    }
    this.vAn.vzN.vCX.b(paramds.position, paramds.fTa);
    GMTrace.o(2106413023232L, 15694);
  }
  
  private void b(ds paramds)
  {
    GMTrace.i(16304501161984L, 121478);
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      GMTrace.o(16304501161984L, 121478);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(paramds.fTa.field_imgPath);
    if ((localObject == null) || (((com.tencent.mm.storage.a.c)localObject).bCM()))
    {
      GMTrace.o(16304501161984L, 121478);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", paramds.fTa.field_imgPath);
    localIntent.putExtra("custom_to_talker_name", paramds.fTa.field_talker);
    if ((((com.tencent.mm.storage.a.c)localObject).field_catalog != com.tencent.mm.storage.a.a.uJd) && (((com.tencent.mm.storage.a.c)localObject).field_catalog != com.tencent.mm.storage.a.a.uJc) && (((com.tencent.mm.storage.a.c)localObject).field_catalog != com.tencent.mm.storage.a.a.uJb)) {
      localIntent.putExtra("custom_smiley_preview_productid", ((com.tencent.mm.storage.a.c)localObject).field_groupId);
    }
    localIntent.putExtra("msg_id", paramds.fTa.field_msgSvrId);
    localIntent.putExtra("msg_content", paramds.fTa.field_content);
    String str = paramds.fTa.field_talker;
    localObject = str;
    if (com.tencent.mm.u.o.dH(str)) {
      localObject = ay.gi(paramds.fTa.field_content);
    }
    localIntent.putExtra("msg_sender", (String)localObject);
    com.tencent.mm.bb.d.b(this.vAn.uRf.uRz, "emoji", ".ui.CustomSmileyPreviewUI", localIntent);
    com.tencent.mm.plugin.report.service.g.oSF.i(11592, new Object[] { Integer.valueOf(0) });
    GMTrace.o(16304501161984L, 121478);
  }
  
  private void c(final ds paramds)
  {
    GMTrace.i(14924877135872L, 111199);
    if (com.tencent.mm.n.a.aH(this.vAn.uRf.uRz))
    {
      GMTrace.o(14924877135872L, 111199);
      return;
    }
    Object localObject = new rq();
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    if ((!paramds.fTa.field_talker.equals(((rq)localObject).fYu.fJC)) && ((((rq)localObject).fYu.fYw) || (((rq)localObject).fYu.fYx)))
    {
      if (((rq)localObject).fYu.fYv) {}
      for (int i = R.l.dPQ;; i = R.l.dPR)
      {
        Toast.makeText(this.vAn.uRf.uRz, i, 0).show();
        v.i("MicroMsg.ChattingListClickListener", "voip is running, can't do this");
        GMTrace.o(14924877135872L, 111199);
        return;
      }
    }
    localObject = new qk();
    ((qk)localObject).fXk.fXm = true;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((qk)localObject).fXl.fXo;
    if (!com.tencent.mm.platformtools.u.mA((String)localObject))
    {
      v.v("MicroMsg.ChattingListClickListener", "Talkroom is on: " + (String)localObject);
      com.tencent.mm.ui.base.g.b(this.vAn.uRf.uRz, this.vAn.uRf.uRz.getString(R.l.eXr), "", this.vAn.uRf.uRz.getString(R.l.dHL), this.vAn.uRf.uRz.getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2167884742656L, 16152);
          qk localqk = new qk();
          localqk.fXk.fXn = true;
          com.tencent.mm.sdk.b.a.uql.m(localqk);
          cw.this.d(paramds);
          paramAnonymousDialogInterface.dismiss();
          GMTrace.o(2167884742656L, 16152);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2159563243520L, 16090);
          paramAnonymousDialogInterface.dismiss();
          GMTrace.o(2159563243520L, 16090);
        }
      });
      GMTrace.o(14924877135872L, 111199);
      return;
    }
    d(paramds);
    GMTrace.o(14924877135872L, 111199);
  }
  
  private void e(ds paramds)
  {
    int i = 3;
    GMTrace.i(2107620982784L, 15703);
    if (com.tencent.mm.n.a.aH(this.vAn.uRf.uRz))
    {
      GMTrace.o(2107620982784L, 15703);
      return;
    }
    Object localObject = new rq();
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    if ((!paramds.fTa.field_talker.equals(((rq)localObject).fYu.fJC)) && ((((rq)localObject).fYu.fYw) || (((rq)localObject).fYu.fYx)))
    {
      if (((rq)localObject).fYu.fYv) {}
      for (i = R.l.dPQ;; i = R.l.dPR)
      {
        Toast.makeText(this.vAn.uRf.uRz, i, 0).show();
        v.i("MicroMsg.ChattingListClickListener", "voip is running, can't do this");
        GMTrace.o(2107620982784L, 15703);
        return;
      }
    }
    paramds.fTa.dv(6);
    ap.yY();
    com.tencent.mm.u.c.wT().a(paramds.fTa.field_msgId, paramds.fTa);
    this.vAn.bVM();
    localObject = new rr();
    ((rr)localObject).fYy.fJB = 5;
    ((rr)localObject).fYy.fJC = paramds.fTa.field_talker;
    ((rr)localObject).fYy.context = this.vAn.uRf.uRz;
    ((rr)localObject).fYy.fYt = 4;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    localObject = com.tencent.mm.plugin.report.service.g.oSF;
    if ((paramds.fTa.gxv == null) || (paramds.fTa.gxv.length() <= 0)) {
      i = 1;
    }
    ((com.tencent.mm.plugin.report.service.g)localObject).i(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(i) });
    GMTrace.o(2107620982784L, 15703);
  }
  
  private void f(ds paramds)
  {
    GMTrace.i(14642751471616L, 109097);
    au localau = paramds.fTa;
    Object localObject1 = localau.field_content;
    int i;
    if (localau.field_isSend == 0)
    {
      i = 1;
      paramds = "";
      if (i != 0) {
        paramds = localau.field_talker;
      }
      if ((!com.tencent.mm.u.o.dH(localau.field_talker)) || (i == 0) || (this.vAn.sLe)) {
        break label489;
      }
      i = ay.gh((String)localObject1);
      if (i == -1) {
        break label489;
      }
      paramds = ((String)localObject1).substring(0, i).trim();
      localObject1 = ((String)localObject1).substring(i + 1).trim();
    }
    label489:
    for (;;)
    {
      ap.yY();
      au.b localb = com.tencent.mm.u.c.wT().Au((String)localObject1);
      localObject1 = paramds;
      if (!com.tencent.mm.platformtools.u.mA(paramds))
      {
        localObject1 = paramds;
        if (com.tencent.mm.u.o.dH(paramds)) {
          localObject1 = "";
        }
      }
      Object localObject2 = new ik();
      ((ik)localObject2).fNV.fNQ = 1;
      ((ik)localObject2).fNV.fCQ = localau;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
      paramds = ((ik)localObject2).fNW.fNY;
      if (((com.tencent.mm.platformtools.u.mA(((ik)localObject2).fNW.fNZ)) && (com.tencent.mm.platformtools.u.mA(paramds))) || ("err_not_started".equals(paramds)))
      {
        v.e("MicroMsg.ChattingListClickListener", "location not valid or subcore not started");
        GMTrace.o(14642751471616L, 109097);
        return;
        i = 0;
        break;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("kMsgId", localau.field_msgId);
      ((Intent)localObject2).putExtra("map_view_type", 1);
      ((Intent)localObject2).putExtra("kwebmap_slat", localb.mZn);
      ((Intent)localObject2).putExtra("kwebmap_lng", localb.mZo);
      ((Intent)localObject2).putExtra("kwebmap_scale", localb.fNU);
      ((Intent)localObject2).putExtra("kPoiName", localb.nbU);
      ((Intent)localObject2).putExtra("kisUsername", com.tencent.mm.u.n.eK((String)localObject1));
      ((Intent)localObject2).putExtra("Kwebmap_locaion", paramds);
      ap.yY();
      ((Intent)localObject2).putExtra("kimg_path", com.tencent.mm.u.c.xb());
      ((Intent)localObject2).putExtra("map_talker_name", localau.field_talker);
      ((Intent)localObject2).putExtra("view_type_key", 0);
      ((Intent)localObject2).putExtra("kwebmap_from_to", true);
      ((Intent)localObject2).putExtra("kPoi_url", localb.sAk);
      ((Intent)localObject2).putExtra("soso_street_view_url", com.tencent.mm.platformtools.u.ap(localau.field_reserved, ""));
      com.tencent.mm.plugin.report.service.g.oSF.i(12809, new Object[] { Integer.valueOf(2), "" });
      com.tencent.mm.bb.d.a(this.vAn, "location", ".ui.RedirectUI", (Intent)localObject2, 2002);
      GMTrace.o(14642751471616L, 109097);
      return;
    }
  }
  
  private void h(final r paramr)
  {
    GMTrace.i(2106949894144L, 15698);
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.eP(this.vAn.uRf.uRz);
      GMTrace.o(2106949894144L, 15698);
      return;
    }
    if (paramr.status == 198)
    {
      t.lG(paramr.getFileName());
      GMTrace.o(2106949894144L, 15698);
      return;
    }
    if ((!com.tencent.mm.network.aa.bn(this.vAn.uRf.uRz)) && (!En_5b8fbb1e.a.vDR))
    {
      En_5b8fbb1e.a.vDR = true;
      com.tencent.mm.ui.base.g.a(this.vAn.uRf.uRz, R.l.eZZ, R.l.dIG, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2175400935424L, 16208);
          cw.this.u(paramr.hZW, paramr.getFileName());
          GMTrace.o(2175400935424L, 16208);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2379009228800L, 17725);
          GMTrace.o(2379009228800L, 17725);
        }
      });
      GMTrace.o(2106949894144L, 15698);
      return;
    }
    u(paramr.hZW, paramr.getFileName());
    GMTrace.o(2106949894144L, 15698);
  }
  
  public final void a(au paramau, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(16447443042304L, 122543);
    Intent localIntent = new Intent(this.vAn.uRf.uRz, ImageGalleryUI.class);
    localIntent.putExtra("img_gallery_msg_id", paramLong1);
    localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
    localIntent.putExtra("show_search_chat_content_result", this.vAn.vzI);
    localIntent.putExtra("key_is_biz_chat", this.vAn.sLe);
    localIntent.putExtra("key_biz_chat_id", this.vAn.bVG());
    localIntent.putExtra("img_gallery_talker", paramString1);
    localIntent.putExtra("img_gallery_chatroom_name", paramString2);
    localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
    localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
    localIntent.putExtra("img_gallery_width", paramInt1);
    localIntent.putExtra("img_gallery_height", paramInt2);
    localIntent.putExtra("img_gallery_enter_from_chatting_ui", this.vAn.vHr);
    localIntent.putExtra("img_gallery_enter_PhotoEditUI", paramBoolean);
    localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", x.em(paramString1));
    paramString2 = this.vAn.bTW();
    if (paramau.field_isSend == 1) {
      paramString1 = this.vAn.vzN.hrv;
    }
    paramau = new Bundle();
    if (this.vAn.vzR) {
      paramInt1 = 2;
    }
    for (;;)
    {
      paramau.putInt("stat_scene", paramInt1);
      paramau.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
      paramau.putString("stat_chat_talker_username", paramString2);
      paramau.putString("stat_send_msg_user", paramString1);
      localIntent.putExtra("_stat_obj", paramau);
      this.vAn.startActivity(localIntent);
      this.vAn.overridePendingTransition(0, 0);
      GMTrace.o(16447443042304L, 122543);
      return;
      if (com.tencent.mm.u.o.eV(paramString2)) {
        paramInt1 = 7;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  public final void d(ds paramds)
  {
    int i = 3;
    GMTrace.i(2107486765056L, 15702);
    paramds.fTa.dv(6);
    ap.yY();
    com.tencent.mm.u.c.wT().a(paramds.fTa.field_msgId, paramds.fTa);
    this.vAn.bVM();
    Object localObject = new rr();
    ((rr)localObject).fYy.fJB = 5;
    ((rr)localObject).fYy.fJC = paramds.fTa.field_talker;
    ((rr)localObject).fYy.context = this.vAn.uRf.uRz;
    ((rr)localObject).fYy.fYt = 2;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    localObject = com.tencent.mm.plugin.report.service.g.oSF;
    if ((paramds.fTa.gxv == null) || (paramds.fTa.gxv.length() <= 0)) {
      i = 1;
    }
    ((com.tencent.mm.plugin.report.service.g)localObject).i(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
    GMTrace.o(2107486765056L, 15702);
  }
  
  public void onClick(final View paramView)
  {
    GMTrace.i(2106278805504L, 15693);
    Object localObject3 = (ds)paramView.getTag();
    int j = 0;
    int k = 0;
    Object localObject1;
    label632:
    label748:
    Object localObject4;
    Object localObject5;
    switch (((ds)localObject3).klJ)
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      localObject1 = ((ds)localObject3).fTa;
      if (localObject1 == null)
      {
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      break;
    case 1: 
    case 9: 
      paramView = ((ds)localObject3).userName;
      if ((paramView == null) || (paramView.equals("")))
      {
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      if (this.vAn.sNz)
      {
        localObject1 = this.vAn.uRf.uRz;
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramView);
        ((Intent)localObject2).putExtra("Contact_Encryptusername", true);
        ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
        ((Intent)localObject2).putExtra("Contact_IsLbsChattingProfile", true);
        com.tencent.mm.bb.d.b((Context)localObject1, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      if (this.vAn.sLe)
      {
        paramView = this.vAn.vtp.iq(paramView);
        if (paramView != null)
        {
          if ((paramView == null) || (com.tencent.mm.platformtools.u.mA(paramView.field_profileUrl)))
          {
            if (paramView == null) {}
            for (bool = true;; bool = false)
            {
              v.w("MicroMsg.ChattingListClickListener", "onClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
              GMTrace.o(2106278805504L, 15693);
              return;
            }
          }
          v.i("MicroMsg.ChattingListClickListener", "onClick Url:%s", new Object[] { paramView.field_profileUrl });
          w.DN().Y(paramView.field_userId, paramView.field_brandUserName);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", paramView.field_profileUrl);
          ((Intent)localObject1).putExtra("useJs", true);
          com.tencent.mm.bb.d.b(this.vAn.bOZ(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Contact_User", paramView);
      if ((((ds)localObject3).klJ == 9) && (!com.tencent.mm.platformtools.u.mA(((ds)localObject3).vLf))) {
        ((Intent)localObject1).putExtra("Contact_BIZ_KF_WORKER_ID", ((ds)localObject3).vLf);
      }
      ap.yY();
      localObject2 = com.tencent.mm.u.c.wR().Rb(paramView);
      if ((localObject2 != null) && ((int)((com.tencent.mm.j.a)localObject2).gTG > 0) && (((x)localObject2).ty()))
      {
        com.tencent.mm.ui.contact.e.a((Intent)localObject1, paramView);
        if (com.tencent.mm.u.o.dH(this.vAn.fOB.getUsername()))
        {
          ap.yY();
          localObject2 = com.tencent.mm.u.c.xa().fW(this.vAn.fOB.getUsername());
          ((Intent)localObject1).putExtra("Contact_RoomNickname", ((com.tencent.mm.storage.q)localObject2).eK(paramView));
          ((Intent)localObject1).putExtra("Contact_Scene", 14);
          ((Intent)localObject1).putExtra("Contact_ChatRoomId", this.vAn.fOB.getUsername());
          ((Intent)localObject1).putExtra("room_name", this.vAn.fOB.getUsername());
          if (((com.tencent.mm.storage.q)localObject2).field_roomowner != null) {
            break label748;
          }
          bool = false;
          ((Intent)localObject1).putExtra("Is_RoomOwner", bool);
        }
        if (((ds)localObject3).fTa != null) {
          switch (((ds)localObject3).fTa.getType())
          {
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.bb.d.b(this.vAn.aYw(), "profile", ".ui.ContactInfoUI", (Intent)localObject1, 213);
        GMTrace.o(2106278805504L, 15693);
        return;
        if (!this.vAn.vzS) {
          break;
        }
        ag.a.hlA.a(paramView, "", new ag.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            GMTrace.i(2513226956800L, 18725);
            GMTrace.o(2513226956800L, 18725);
          }
        });
        break;
        bool = ((com.tencent.mm.storage.q)localObject2).field_roomowner.equals(m.xL());
        break label632;
        ((Intent)localObject1).putExtra("Contact_Scene", 34);
        ((Intent)localObject1).putExtra("Contact_IsLBSFriend", true);
      }
    case 6: 
      v.d("MicroMsg.ChattingListClickListener", "edw timestamp, onClick = " + System.currentTimeMillis());
      if (s.a(((ds)localObject3).fZv, this.vAn.aYw(), null, this.vAn.bTW()))
      {
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      localObject1 = ((ds)localObject3).userName;
      localObject2 = ((ds)localObject3).vLc;
      if ((localObject1 == null) || (((String)localObject1).equals("")))
      {
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      paramView = new Intent();
      paramView.putExtra("rawUrl", (String)localObject1);
      paramView.putExtra("shortUrl", (String)localObject1);
      paramView.putExtra("webpageTitle", (String)localObject2);
      localObject1 = new Bundle();
      localObject2 = ((ds)localObject3).fTa;
      if (localObject2 != null)
      {
        if (((au)localObject2).bLV())
        {
          localObject4 = bg.q(((au)localObject2).pM(), "msg");
          if (localObject4 != null)
          {
            localObject4 = dj.ai((Map)localObject4);
            if (!com.tencent.mm.platformtools.u.mA(((dj)localObject4).hih))
            {
              paramView.putExtra("KTemplateId", ((dj)localObject4).hih);
              v.d("MicroMsg.ChattingListClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", new Object[] { ((dj)localObject4).hih, ((ds)localObject3).fUH });
              com.tencent.mm.plugin.report.service.g.oSF.i(11608, new Object[] { ((dj)localObject4).hih, ((ds)localObject3).fUH, Integer.valueOf(0) });
            }
          }
        }
        ap.yY();
        localObject4 = com.tencent.mm.u.c.wR().Rb(((au)localObject2).pL());
        i = k;
        if (localObject4 != null)
        {
          i = k;
          if (((x)localObject4).bKU())
          {
            i = 4;
            v.d("MicroMsg.ChattingListClickListener", "hakon click biz msg %s", new Object[] { ((x)localObject4).getUsername() });
          }
        }
        paramView.putExtra("msg_id", ((au)localObject2).pH());
        paramView.putExtra("KPublisherId", "msg_" + Long.toString(((au)localObject2).pI()));
        paramView.putExtra("pre_username", ((au)localObject2).pL());
        paramView.putExtra("prePublishId", "msg_" + Long.toString(((au)localObject2).pI()));
        paramView.putExtra("preUsername", ag.a((au)localObject2, ((ds)localObject3).vvA, this.vAn.sLe));
        paramView.putExtra("preChatName", this.vAn.bTW());
        paramView.putExtra("preChatTYPE", com.tencent.mm.u.p.G(ag.a((au)localObject2, ((ds)localObject3).vvA, this.vAn.sLe), this.vAn.bTW()));
        paramView.putExtra("preMsgIndex", ((ds)localObject3).rWg);
        localObject2 = ((ds)localObject3).vLi;
        j = i;
        if (localObject2 != null)
        {
          paramView.putExtras((Bundle)localObject2);
          j = i;
        }
      }
      ((Bundle)localObject1).putInt("snsWebSource", j);
      paramView.putExtra("jsapiargs", (Bundle)localObject1);
      paramView.putExtra("geta8key_username", this.vAn.bTW());
      if (!com.tencent.mm.platformtools.u.mA(((ds)localObject3).fUH))
      {
        paramView.putExtra("srcUsername", ((ds)localObject3).fUH);
        paramView.putExtra("srcDisplayname", ((ds)localObject3).fUI);
        paramView.putExtra("mode", 1);
      }
      paramView.putExtra("message_id", ((ds)localObject3).rWf);
      paramView.putExtra("message_index", ((ds)localObject3).rWg);
      paramView.putExtra("from_scence", 1);
      com.tencent.mm.bb.d.b(this.vAn.aYw(), "webview", ".ui.tools.WebViewUI", paramView);
      if (!com.tencent.mm.platformtools.u.mA(this.vAn.bTW()))
      {
        ap.yY();
        if (com.tencent.mm.u.c.wR().Rb(this.vAn.bTW()).gkz == 1)
        {
          ap.yY();
          com.tencent.mm.u.c.wW().Rp(this.vAn.bTW());
        }
      }
      GMTrace.o(2106278805504L, 15693);
      return;
    case 7: 
      paramView = new Intent();
      paramView.putExtra("geta8key_username", this.vAn.bTW());
      paramView.putExtra("rawUrl", ((ds)localObject3).gxt);
      com.tencent.mm.bb.d.b(this.vAn.aYw(), "webview", ".ui.tools.WebViewUI", paramView);
      GMTrace.o(2106278805504L, 15693);
      return;
    case 8: 
      if (((ds)localObject3).fTa == null)
      {
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      localObject1 = ((ds)localObject3).fFR;
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ud(((ds)localObject3).gxt);
      }
      if (TextUtils.isEmpty(paramView))
      {
        paramView = new Intent();
        paramView.putExtra("geta8key_username", this.vAn.bTW());
        paramView.putExtra("rawUrl", ((ds)localObject3).gxt);
        com.tencent.mm.bb.d.b(this.vAn.aYw(), "webview", ".ui.tools.WebViewUI", paramView);
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("extra_id", paramView);
      ((Intent)localObject1).putExtra("extra_name", ((ds)localObject3).title);
      if (((ds)localObject3).vLd)
      {
        ((Intent)localObject1).putExtra("download_entrance_scene", 20);
        ((Intent)localObject1).putExtra("preceding_scence", 3);
        ((Intent)localObject1).putExtra("reward_tip", true);
        com.tencent.mm.plugin.report.service.g.oSF.i(12953, new Object[] { Integer.valueOf(1), paramView });
      }
      for (;;)
      {
        com.tencent.mm.bb.d.b(this.vAn.aYw(), "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject1);
        GMTrace.o(2106278805504L, 15693);
        return;
        if (((ds)localObject3).vLe)
        {
          ((Intent)localObject1).putExtra("download_entrance_scene", 25);
          ((Intent)localObject1).putExtra("preceding_scence", 9);
          ((Intent)localObject1).putExtra("reward_tip", true);
        }
        else
        {
          ((Intent)localObject1).putExtra("download_entrance_scene", 22);
          ((Intent)localObject1).putExtra("preceding_scence", 122);
          com.tencent.mm.plugin.report.service.g.oSF.i(10993, new Object[] { Integer.valueOf(2), paramView });
        }
      }
    case 10: 
      if (((ds)localObject3).fTa == null)
      {
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      i = ((ds)localObject3).designerUIN;
      paramView = ((ds)localObject3).designerName;
      localObject1 = ((ds)localObject3).designerRediretctUrl;
      if (i != 0)
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("geta8key_username", this.vAn.bTW());
        ((Intent)localObject2).putExtra("rawUrl", ((ds)localObject3).gxt);
        ((Intent)localObject2).putExtra("uin", i);
        ((Intent)localObject2).putExtra("name", paramView);
        ((Intent)localObject2).putExtra("rediret_url", (String)localObject1);
        ((Intent)localObject2).putExtra("extra_scence", 22);
        com.tencent.mm.bb.d.b(this.vAn.aYw(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", (Intent)localObject2);
      }
      GMTrace.o(2106278805504L, 15693);
      return;
    case 11: 
      com.tencent.mm.ui.base.g.b(this.vAn.aYw(), this.vAn.getString(R.l.eci), "", this.vAn.getString(R.l.eck), this.vAn.getString(R.l.ech), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2301834035200L, 17150);
          paramAnonymousDialogInterface = new cl();
          paramAnonymousDialogInterface.fFK.fFL = true;
          com.tencent.mm.sdk.b.a.uql.m(paramAnonymousDialogInterface);
          GMTrace.o(2301834035200L, 17150);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2196741554176L, 16367);
          paramAnonymousDialogInterface = new cl();
          paramAnonymousDialogInterface.fFK.fFL = false;
          com.tencent.mm.sdk.b.a.uql.m(paramAnonymousDialogInterface);
          GMTrace.o(2196741554176L, 16367);
        }
      });
      GMTrace.o(2106278805504L, 15693);
      return;
    case 12: 
      if (((ds)localObject3).fTa == null)
      {
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      i = ((ds)localObject3).tid;
      paramView = ((ds)localObject3).hjr;
      localObject1 = ((ds)localObject3).desc;
      localObject2 = ((ds)localObject3).iconUrl;
      localObject4 = ((ds)localObject3).secondUrl;
      if (i != 0)
      {
        localObject5 = new Intent();
        ((Intent)localObject5).putExtra("geta8key_username", this.vAn.bTW());
        ((Intent)localObject5).putExtra("rawUrl", ((ds)localObject3).gxt);
        ((Intent)localObject5).putExtra("topic_id", i);
        ((Intent)localObject5).putExtra("topic_name", paramView);
        ((Intent)localObject5).putExtra("topic_desc", (String)localObject1);
        ((Intent)localObject5).putExtra("topic_icon_url", (String)localObject2);
        ((Intent)localObject5).putExtra("topic_ad_url", (String)localObject4);
        ((Intent)localObject5).putExtra("extra_scence", 22);
        com.tencent.mm.bb.d.b(this.vAn.aYw(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject5);
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      v.i("MicroMsg.ChattingListClickListener", "topic id is zero.");
      GMTrace.o(2106278805504L, 15693);
      return;
    case 13: 
      if (((ds)localObject3).fTa == null)
      {
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      i = ((ds)localObject3).tid;
      paramView = ((ds)localObject3).hjr;
      localObject1 = ((ds)localObject3).desc;
      localObject2 = ((ds)localObject3).iconUrl;
      localObject4 = ((ds)localObject3).secondUrl;
      j = ((ds)localObject3).pageType;
      if (i != 0)
      {
        localObject5 = new Intent();
        ((Intent)localObject5).putExtra("geta8key_username", this.vAn.bTW());
        ((Intent)localObject5).putExtra("rawUrl", ((ds)localObject3).gxt);
        ((Intent)localObject5).putExtra("set_id", i);
        ((Intent)localObject5).putExtra("set_title", paramView);
        ((Intent)localObject5).putExtra("set_iconURL", (String)localObject2);
        ((Intent)localObject5).putExtra("set_desc", (String)localObject1);
        ((Intent)localObject5).putExtra("headurl", (String)localObject4);
        ((Intent)localObject5).putExtra("pageType", j);
        com.tencent.mm.bb.d.b(this.vAn.aYw(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject5);
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      v.i("MicroMsg.ChattingListClickListener", "topic id is zero.");
      GMTrace.o(2106278805504L, 15693);
      return;
    }
    Object localObject2 = this.vAn.vzN;
    int i = ((au)localObject1).getType();
    if (((au)localObject1).pJ() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = ((cv)localObject2).ai(i, bool);
      if ((localObject2 == null) || (!((ag)localObject2).a(paramView, this.vAn, (au)localObject1))) {
        break;
      }
      if (((au)localObject1).axH()) {
        com.tencent.mm.modelstat.b.hTV.e((au)localObject1, com.tencent.mm.t.g.g((au)localObject1));
      }
      GMTrace.o(2106278805504L, 15693);
      return;
    }
    if ((((ds)localObject3).klJ == 5) && (((au)localObject1).pJ() == 1))
    {
      paramView = ((ds)localObject3).fTa;
      if ((paramView != null) && (paramView.gxu == 80))
      {
        v.w("MicroMsg.ChattingListClickListener", "[dealClickStateBtn] %s", new Object[] { paramView.pN() });
        com.tencent.mm.ui.base.g.z(this.vAn.aYw(), this.vAn.aYw().getString(R.l.enP), this.vAn.aYw().getString(R.l.cIz));
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      com.tencent.mm.ui.base.g.b(this.vAn.aYw(), this.vAn.getString(R.l.dVd), "", this.vAn.getString(R.l.dIn), this.vAn.getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2202512916480L, 16410);
          paramView.bMk();
          ap.yY();
          com.tencent.mm.u.c.wT().a(paramView.field_msgId, paramView);
          if (paramView.bLP())
          {
            cw.this.vAn.az(paramView);
            GMTrace.o(2202512916480L, 16410);
            return;
          }
          if (paramView.bLX())
          {
            cw.this.vAn.aA(paramView);
            GMTrace.o(2202512916480L, 16410);
            return;
          }
          if (paramView.bMd())
          {
            cw.this.vAn.aB(paramView);
            GMTrace.o(2202512916480L, 16410);
            return;
          }
          if (paramView.bMa())
          {
            cw.this.vAn.aC(paramView);
            GMTrace.o(2202512916480L, 16410);
            return;
          }
          if (paramView.bLZ())
          {
            cw.this.vAn.aF(paramView);
            GMTrace.o(2202512916480L, 16410);
            return;
          }
          if (paramView.bMe())
          {
            cw.this.vAn.aE(paramView);
            GMTrace.o(2202512916480L, 16410);
            return;
          }
          if (paramView.bLY())
          {
            cw.this.vAn.aD(paramView);
            GMTrace.o(2202512916480L, 16410);
            return;
          }
          v.e("MicroMsg.ChattingListClickListener", "uknown msg type");
          GMTrace.o(2202512916480L, 16410);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2236335783936L, 16662);
          GMTrace.o(2236335783936L, 16662);
        }
      });
      GMTrace.o(2106278805504L, 15693);
      return;
    }
    v.i("MicroMsg.ChattingListClickListener", "CreateTime:" + ((au)localObject1).pK());
    if (((au)localObject1).bLP())
    {
      com.tencent.mm.modelstat.b.hTV.v(((ds)localObject3).fTa);
      if ((y.aJ(this.vAn.aYw())) || (com.tencent.mm.al.a.aH(this.vAn.aYw())))
      {
        v.d("MicroMsg.ChattingListClickListener", "voip is running, not play voice");
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      ap.yY();
      if (!com.tencent.mm.u.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.s.eP(this.vAn.aYw());
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      if ((localObject3 != null) && (((ds)localObject3).fTa != null))
      {
        paramView = new com.tencent.mm.modelvoice.n(((ds)localObject3).fTa.pM());
        if ((com.tencent.mm.platformtools.u.mA(((ds)localObject3).fTa.pM())) || (paramView.time == 0L))
        {
          Toast.makeText(this.vAn.aYw(), R.l.dTg, 0).show();
          GMTrace.o(2106278805504L, 15693);
          return;
        }
        if ((this.vAn.vzN != null) && (this.vAn.vzN.vCX != null))
        {
          this.vAn.vzN.vCX.a(((ds)localObject3).position, ((ds)localObject3).fTa);
          if (((ds)localObject3).fTa.bMq()) {
            com.tencent.mm.plugin.report.service.g.oSF.i(14220, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      }
      GMTrace.o(2106278805504L, 15693);
      return;
    }
    if (((au)localObject1).getType() == 35) {
      i = 1;
    }
    while (i != 0)
    {
      ap.yY();
      paramView = com.tencent.mm.u.c.wT().Ar(((ds)localObject3).fTa.pM());
      if (com.tencent.mm.platformtools.u.mz(paramView.oxJ).length() > 0)
      {
        com.tencent.mm.bb.d.b(this.vAn.aYw(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", ((ds)localObject3).fTa.pH()));
        GMTrace.o(2106278805504L, 15693);
        return;
        i = 0;
      }
      else
      {
        if (com.tencent.mm.platformtools.u.mz(paramView.bMA()).length() > 0)
        {
          paramView = new Intent("android.intent.action.VIEW", Uri.parse(paramView.bMA()));
          com.tencent.mm.bb.d.b(this.vAn.aYw(), "webview", ".ui.tools.WebViewUI", paramView);
        }
        GMTrace.o(2106278805504L, 15693);
        return;
      }
    }
    if (((au)localObject1).bLX())
    {
      com.tencent.mm.modelstat.b.hTV.v(((ds)localObject3).fTa);
      localObject4 = ((ds)localObject3).fTa;
      com.tencent.mm.modelstat.a.a((au)localObject4, com.tencent.mm.modelstat.a.a.hTS);
      localObject5 = new int[2];
      i = 0;
      j = 0;
      if (paramView != null)
      {
        paramView.getLocationInWindow((int[])localObject5);
        i = paramView.getWidth();
        j = paramView.getHeight();
      }
      if (((au)localObject4).pJ() == 1)
      {
        paramView = com.tencent.mm.ah.n.GT().aj(((au)localObject4).pH());
        if (paramView.Gz() != 0L) {
          break label7463;
        }
      }
      paramView = com.tencent.mm.ah.n.GT().ai(((au)localObject4).pI());
    }
    label3993:
    label4464:
    label4467:
    label4679:
    label4930:
    label4936:
    label6136:
    label6155:
    label6175:
    label7453:
    label7463:
    for (;;)
    {
      localObject1 = bg.q(((au)localObject4).pM(), "msg");
      if (localObject1 != null) {
        Long.valueOf(com.tencent.mm.platformtools.u.ap((String)((Map)localObject1).get(".msg.img.$hdlength"), "0")).longValue();
      }
      ap.yY();
      if (!com.tencent.mm.u.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.s.eP(this.vAn.aYw());
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      if (((au)localObject4).pJ() == 1)
      {
        localObject1 = com.tencent.mm.ah.e.c(paramView);
        if (com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GT().m((String)localObject1, "", "")))
        {
          a((au)localObject4, paramView.Gy(), paramView.pI(), ((ds)localObject3).userName, ((ds)localObject3).chatroomName, (int[])localObject5, i, j, false);
          GMTrace.o(2106278805504L, 15693);
          return;
        }
        localObject1 = paramView.GA();
        if (com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GT().m((String)localObject1, "", "")))
        {
          a((au)localObject4, paramView.Gy(), paramView.pI(), ((ds)localObject3).userName, ((ds)localObject3).chatroomName, (int[])localObject5, i, j, false);
          GMTrace.o(2106278805504L, 15693);
          return;
        }
        a(((au)localObject4).pH(), ((au)localObject4).pI(), ((ds)localObject3).userName, ((ds)localObject3).chatroomName, (int[])localObject5, i, j);
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      if (paramView.GB())
      {
        localObject2 = paramView.GA();
        localObject1 = localObject2;
        if (paramView.GC())
        {
          com.tencent.mm.ah.d locald = com.tencent.mm.ah.e.a(paramView);
          localObject1 = localObject2;
          if (locald != null)
          {
            localObject1 = localObject2;
            if (locald.Gz() > 0L)
            {
              localObject1 = localObject2;
              if (locald.GB())
              {
                localObject1 = localObject2;
                if (com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GT().m(locald.GA(), "", ""))) {
                  localObject1 = locald.GA();
                }
              }
            }
          }
        }
        com.tencent.mm.ah.n.GT().m((String)localObject1, "", "");
        a((au)localObject4, paramView.Gy(), paramView.pI(), ((ds)localObject3).userName, ((ds)localObject3).chatroomName, (int[])localObject5, i, j, false);
        GMTrace.o(2106278805504L, 15693);
        return;
      }
      if (paramView.status == -1)
      {
        v.i("MicroMsg.ChattingListClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.Gz()) });
        paramView.dv(0);
        paramView.fRM = 256;
        com.tencent.mm.ah.n.GT().a(Long.valueOf(paramView.Gz()), paramView);
      }
      a(((au)localObject4).pH(), ((au)localObject4).pI(), ((ds)localObject3).userName, ((ds)localObject3).chatroomName, (int[])localObject5, i, j);
      GMTrace.o(2106278805504L, 15693);
      return;
      if (((au)localObject1).bLY())
      {
        localObject2 = ((ds)localObject3).userName;
        paramView = ((au)localObject1).pM();
        bool = ((ds)localObject3).vvA;
        if (((au)localObject1).pJ() == 0)
        {
          i = 1;
          if ((!bool) || (i == 0)) {
            break label4464;
          }
          paramView = ay.gj(paramView);
          ap.yY();
          paramView = com.tencent.mm.u.c.wT().At(paramView);
          if (paramView == null) {
            break label7453;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("Contact_User", paramView.bMu());
          ((Intent)localObject1).putExtra("Contact_Alias", paramView.gtH);
          ((Intent)localObject1).putExtra("Contact_Nick", paramView.fER);
          ((Intent)localObject1).putExtra("Contact_QuanPin", paramView.hBN);
          ((Intent)localObject1).putExtra("Contact_PyInitial", paramView.hBM);
          ((Intent)localObject1).putExtra("Contact_Uin", paramView.bMw());
          ((Intent)localObject1).putExtra("Contact_Mobile_MD5", paramView.bMv());
          ((Intent)localObject1).putExtra("Contact_full_Mobile_MD5", paramView.bMy());
          ((Intent)localObject1).putExtra("Contact_QQNick", paramView.bMx());
          ((Intent)localObject1).putExtra("User_From_Fmessage", false);
          ((Intent)localObject1).putExtra("Contact_Scene", paramView.bzw());
          ((Intent)localObject1).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject1).putExtra("Contact_RemarkName", paramView.hBR);
          ((Intent)localObject1).putExtra("Contact_VUser_Info_Flag", paramView.bMz());
          ((Intent)localObject1).putExtra("Contact_VUser_Info", paramView.gkw);
          ((Intent)localObject1).putExtra("Contact_BrandIconURL", paramView.orr);
          ((Intent)localObject1).putExtra("Contact_Province", paramView.getProvince());
          ((Intent)localObject1).putExtra("Contact_City", paramView.getCity());
          ((Intent)localObject1).putExtra("Contact_Sex", paramView.gkh);
          ((Intent)localObject1).putExtra("Contact_Signature", paramView.signature);
          ((Intent)localObject1).putExtra("Contact_ShowUserName", true);
          ((Intent)localObject1).putExtra("Contact_KSnsIFlag", 0);
          ((Intent)localObject1).putExtra("Contact_Source_FMessage", 17);
          ((Intent)localObject1).putExtra("source_from_user_name", (String)localObject2);
          ((Intent)localObject1).putExtra("source_from_nick_name", com.tencent.mm.u.n.eJ((String)localObject2));
          ((Intent)localObject1).putExtra(d.a.uMI, paramView.uIm);
          if ((paramView.bMz() & 0x8) > 0)
          {
            if (!com.tencent.mm.platformtools.u.mA((String)localObject2))
            {
              ap.yY();
              if (com.tencent.mm.u.c.wR().Rb((String)localObject2).bKU()) {
                break label4467;
              }
            }
            ((Intent)localObject1).putExtra("Contact_Scene", 17);
            com.tencent.mm.plugin.report.service.g.oSF.A(10298, paramView.bMu() + ",17");
          }
        }
        for (;;)
        {
          com.tencent.mm.bb.d.b(this.vAn.aYw(), "profile", ".ui.ContactInfoUI", (Intent)localObject1);
          com.tencent.mm.bc.a.xP(paramView.bzw());
          GMTrace.o(2106278805504L, 15693);
          return;
          i = 0;
          break;
          break label3993;
          ((Intent)localObject1).putExtra("Contact_Scene", 41);
          com.tencent.mm.plugin.report.service.g.oSF.A(10298, paramView.bMu() + ",41");
        }
      }
      else
      {
        if (((au)localObject1).getType() == 37)
        {
          paramView = ((au)localObject1).pM();
          v.w("MicroMsg.ChattingListClickListener", "dealClickVerifyMsgEvent : " + paramView);
          if ((paramView == null) || (paramView.length() <= 0))
          {
            GMTrace.o(2106278805504L, 15693);
            return;
          }
          ap.yY();
          localObject2 = com.tencent.mm.u.c.wT().As(paramView);
          if (localObject2 != null)
          {
            if (((au.d)localObject2).bMu().length() <= 0) {
              break label4930;
            }
            bool = true;
            Assert.assertTrue(bool);
            ap.yY();
            paramView = com.tencent.mm.u.c.wR().Rb(((au.d)localObject2).bMu());
            localObject3 = new Intent();
            if ((paramView == null) || (paramView.tJ() <= 0) || (!paramView.ty())) {
              break label4936;
            }
            ((Intent)localObject3).putExtra("Contact_User", paramView.getUsername());
            com.tencent.mm.ui.contact.e.a((Intent)localObject3, paramView.getUsername());
            localObject1 = ((au.d)localObject2).content;
            paramView = (View)localObject1;
            if (com.tencent.mm.platformtools.u.mz((String)localObject1).length() <= 0) {
              switch (((au.d)localObject2).bzw())
              {
              }
            }
          }
          for (paramView = this.vAn.getString(R.l.dTw);; paramView = this.vAn.getString(R.l.dTA))
          {
            ((Intent)localObject3).putExtra("Contact_Content", paramView);
            ((Intent)localObject3).putExtra("Contact_verify_Scene", ((au.d)localObject2).bzw());
            ((Intent)localObject3).putExtra("Contact_Uin", ((au.d)localObject2).oty);
            ((Intent)localObject3).putExtra("Contact_QQNick", ((au.d)localObject2).hBO);
            ((Intent)localObject3).putExtra("Contact_Mobile_MD5", ((au.d)localObject2).bMv());
            ((Intent)localObject3).putExtra("User_From_Fmessage", true);
            ((Intent)localObject3).putExtra("Contact_from_msgType", 37);
            ((Intent)localObject3).putExtra("Contact_KSnsIFlag", ((au.d)localObject2).bMB());
            ((Intent)localObject3).putExtra("Contact_KSnsBgUrl", ((au.d)localObject2).bMC());
            com.tencent.mm.bb.d.b(this.vAn.aYw(), "profile", ".ui.ContactInfoUI", (Intent)localObject3);
            com.tencent.mm.bc.a.xP(((au.d)localObject2).bzw());
            GMTrace.o(2106278805504L, 15693);
            return;
            bool = false;
            break;
            ((Intent)localObject3).putExtra("Verify_ticket", ((au.d)localObject2).orn);
            ((Intent)localObject3).putExtra("User_Verify", true);
            ((Intent)localObject3).putExtra("Contact_User", ((au.d)localObject2).bMu());
            ((Intent)localObject3).putExtra("Contact_Alias", ((au.d)localObject2).gtH);
            ((Intent)localObject3).putExtra("Contact_Nick", ((au.d)localObject2).fER);
            ((Intent)localObject3).putExtra("Contact_QuanPin", ((au.d)localObject2).hBN);
            ((Intent)localObject3).putExtra("Contact_PyInitial", ((au.d)localObject2).hBM);
            ((Intent)localObject3).putExtra("Contact_Sex", ((au.d)localObject2).gkh);
            ((Intent)localObject3).putExtra("Contact_Signature", ((au.d)localObject2).signature);
            ((Intent)localObject3).putExtra("Contact_Scene", ((au.d)localObject2).bzw());
            ((Intent)localObject3).putExtra("Contact_FMessageCard", true);
            ((Intent)localObject3).putExtra("Contact_City", ((au.d)localObject2).getCity());
            ((Intent)localObject3).putExtra("Contact_Province", ((au.d)localObject2).getProvince());
            ((Intent)localObject3).putExtra("Contact_Mobile_MD5", ((au.d)localObject2).bMv());
            ((Intent)localObject3).putExtra("Contact_full_Mobile_MD5", ((au.d)localObject2).uIj);
            ((Intent)localObject3).putExtra("Contact_KSnsIFlag", ((au.d)localObject2).bMB());
            ((Intent)localObject3).putExtra("Contact_KSnsBgUrl", ((au.d)localObject2).bMC());
            break label4679;
          }
        }
        if (((au)localObject1).getType() == 40)
        {
          paramView = ((au)localObject1).pM();
          ap.yY();
          localObject2 = com.tencent.mm.u.c.wT().At(paramView);
          if ((localObject2 != null) && (((au.a)localObject2).bMu().length() > 0))
          {
            com.tencent.mm.bc.a.xP(((au.a)localObject2).bzw());
            ap.yY();
            localObject3 = com.tencent.mm.u.c.wR().Rb(((au.a)localObject2).bMu());
            if ((localObject3 != null) && (((x)localObject3).tJ() > 0) && (((x)localObject3).ty()))
            {
              com.tencent.mm.ui.contact.e.a(this.vAn.aYw(), (x)localObject3, (au.a)localObject2);
              GMTrace.o(2106278805504L, 15693);
              return;
            }
            if ((((au.a)localObject2).bMw() <= 0L) && ((!com.tencent.mm.platformtools.u.mA(((au.a)localObject2).bMv())) || (!com.tencent.mm.platformtools.u.mA(((au.a)localObject2).bMy()))))
            {
              localObject1 = com.tencent.mm.modelfriend.af.FZ().jb(((au.a)localObject2).bMv());
              if ((localObject1 != null) && (((com.tencent.mm.modelfriend.b)localObject1).EQ() != null))
              {
                paramView = (View)localObject1;
                if (((com.tencent.mm.modelfriend.b)localObject1).EQ().length() > 0) {}
              }
              else
              {
                localObject1 = com.tencent.mm.modelfriend.af.FZ().jb(((au.a)localObject2).bMy());
                if ((localObject1 != null) && (((com.tencent.mm.modelfriend.b)localObject1).EQ() != null))
                {
                  paramView = (View)localObject1;
                  if (((com.tencent.mm.modelfriend.b)localObject1).EQ().length() > 0) {}
                }
                else
                {
                  if ((localObject3 != null) && (((x)localObject3).tJ() > 0)) {
                    com.tencent.mm.ui.contact.e.a(this.vAn.aYw(), (x)localObject3, (au.a)localObject2);
                  }
                  for (;;)
                  {
                    v.e("MicroMsg.ChattingListClickListener", "error : this is not the mobile contact, MD5 = " + ((au.a)localObject2).bMv() + " fullMD5:" + ((au.a)localObject2).bMy());
                    GMTrace.o(2106278805504L, 15693);
                    return;
                    com.tencent.mm.ui.contact.e.a(this.vAn.aYw(), (au.a)localObject2);
                  }
                }
              }
              if ((paramView.getUsername() == null) || (paramView.getUsername().length() <= 0))
              {
                paramView.username = ((au.a)localObject2).bMu();
                paramView.fRM = 128;
                if (com.tencent.mm.modelfriend.af.FZ().a(paramView.EQ(), paramView) == -1)
                {
                  v.e("MicroMsg.ChattingListClickListener", "update mobile contact username failed");
                  GMTrace.o(2106278805504L, 15693);
                  return;
                }
              }
              com.tencent.mm.ui.contact.e.a(this.vAn.aYw(), (au.a)localObject2);
              GMTrace.o(2106278805504L, 15693);
              return;
            }
            com.tencent.mm.ui.contact.e.a(this.vAn.aYw(), (au.a)localObject2);
          }
          GMTrace.o(2106278805504L, 15693);
          return;
        }
        if ((((au)localObject1).bMb()) || (((au)localObject1).bMc()))
        {
          com.tencent.mm.modelstat.b.hTV.v(((ds)localObject3).fTa);
          com.tencent.mm.modelstat.a.a(((ds)localObject3).fTa, com.tencent.mm.modelstat.a.a.hTS);
          if (2 == ((ds)localObject3).klJ)
          {
            if ((y.aJ(this.vAn.aYw())) || (com.tencent.mm.al.a.aH(this.vAn.aYw())))
            {
              v.i("MicroMsg.ChattingListClickListener", "Voip or multitalk is running, can't do this");
              GMTrace.o(2106278805504L, 15693);
              return;
            }
            localObject1 = ((ds)localObject3).fTa;
            localObject4 = new int[2];
            j = 0;
            i = 0;
            if (paramView != null)
            {
              paramView.getLocationInWindow((int[])localObject4);
              j = paramView.getWidth();
              i = paramView.getHeight();
            }
            long l1 = ((au)localObject1).pH();
            long l2 = ((au)localObject1).pI();
            paramView = ((ds)localObject3).userName;
            localObject5 = ((ds)localObject3).chatroomName;
            localObject2 = new Intent(this.vAn.aYw(), ImageGalleryUI.class);
            ((Intent)localObject2).putExtra("show_search_chat_content_result", this.vAn.vzI);
            ((Intent)localObject2).putExtra("img_gallery_msg_id", l1);
            ((Intent)localObject2).putExtra("key_is_biz_chat", this.vAn.sLe);
            ((Intent)localObject2).putExtra("key_biz_chat_id", this.vAn.bVG());
            ((Intent)localObject2).putExtra("img_gallery_msg_svr_id", l2);
            ((Intent)localObject2).putExtra("img_gallery_talker", paramView);
            ((Intent)localObject2).putExtra("img_gallery_chatroom_name", (String)localObject5);
            ((Intent)localObject2).putExtra("img_gallery_left", localObject4[0]);
            ((Intent)localObject2).putExtra("img_gallery_top", localObject4[1]);
            ((Intent)localObject2).putExtra("img_gallery_width", j);
            ((Intent)localObject2).putExtra("img_gallery_height", i);
            ((Intent)localObject2).putExtra("img_gallery_enter_from_chatting_ui", this.vAn.vHr);
            localObject4 = this.vAn.bTW();
            if (((au)localObject1).pJ() == 1)
            {
              paramView = this.vAn.vzN.hrv;
              localObject5 = new Bundle();
              if (!this.vAn.vzR) {
                break label6136;
              }
              i = 2;
            }
            for (;;)
            {
              ((Bundle)localObject5).putInt("stat_scene", i);
              ((Bundle)localObject5).putString("stat_msg_id", "msg_" + Long.toString(l2));
              ((Bundle)localObject5).putString("stat_chat_talker_username", (String)localObject4);
              ((Bundle)localObject5).putString("stat_send_msg_user", paramView);
              ((Intent)localObject2).putExtra("_stat_obj", (Bundle)localObject5);
              this.vAn.startActivity((Intent)localObject2);
              this.vAn.overridePendingTransition(0, 0);
              if ((!((au)localObject1).bMc()) || (((ds)localObject3).userName == null)) {
                break label6175;
              }
              a.a(a.a.vvb, (au)localObject1);
              if (!((ds)localObject3).userName.toLowerCase().endsWith("@chatroom")) {
                break label6155;
              }
              com.tencent.mm.plugin.report.service.g.oSF.i(11444, new Object[] { Integer.valueOf(2) });
              GMTrace.o(2106278805504L, 15693);
              return;
              break;
              if (com.tencent.mm.u.o.eV((String)localObject4)) {
                i = 7;
              } else {
                i = 1;
              }
            }
            com.tencent.mm.plugin.report.service.g.oSF.i(11444, new Object[] { Integer.valueOf(1) });
            GMTrace.o(2106278805504L, 15693);
            return;
          }
          paramView = ((ds)localObject3).fTa;
          if (paramView.pJ() == 0)
          {
            localObject1 = ((ds)localObject3).fTa;
            localObject2 = t.lI(((au)localObject1).pN());
            v.i("MicroMsg.ChattingListClickListener", "videoReceiverEvent video status:" + ((r)localObject2).getStatus() + " is sender:" + ((au)localObject1).pJ());
          }
          switch (((ds)localObject3).klJ)
          {
          default: 
            if (paramView.pJ() == 1)
            {
              paramView = ((ds)localObject3).fTa;
              localObject1 = com.tencent.mm.modelvideo.o.KW().lt(paramView.pN());
              i = ((r)localObject1).getStatus();
              v.i("MicroMsg.ChattingListClickListener", " videoSendEvent status : " + i);
              switch (((ds)localObject3).klJ)
              {
              }
            }
            break;
          }
          for (;;)
          {
            GMTrace.o(2106278805504L, 15693);
            return;
            ap.yY();
            if (!com.tencent.mm.u.c.isSDCardAvailable())
            {
              com.tencent.mm.ui.base.s.eP(this.vAn.aYw());
              break;
            }
            t.lF(((au)localObject1).pN());
            break;
            h((r)localObject2);
            break;
            ap.yY();
            if (!com.tencent.mm.u.c.isSDCardAvailable())
            {
              com.tencent.mm.ui.base.s.eP(this.vAn.aYw());
              GMTrace.o(2106278805504L, 15693);
              return;
            }
            if (i == 112)
            {
              v.i("MicroMsg.ChattingListClickListener", "this video come from pc weixin, user pause recv now.");
              t.lF(paramView.pN());
              GMTrace.o(2106278805504L, 15693);
              return;
            }
            localObject1 = paramView.pN();
            localObject2 = t.lI((String)localObject1);
            if (localObject2 == null)
            {
              v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + (String)localObject1);
              com.tencent.mm.compatible.util.g.sb();
            }
            for (;;)
            {
              v.d("MicroMsg.ChattingListClickListener", "pause video, publish SendMsgFailEvent");
              localObject1 = new nw();
              ((nw)localObject1).fUS.fCQ = paramView;
              com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
              GMTrace.o(2106278805504L, 15693);
              return;
              if ((((r)localObject2).getStatus() != 104) && (((r)localObject2).getStatus() != 103))
              {
                v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " get status failed: " + (String)localObject1 + " status:" + ((r)localObject2).getStatus());
                com.tencent.mm.compatible.util.g.sb();
              }
              else
              {
                ((r)localObject2).status = 105;
                ((r)localObject2).at(bf.Nz());
                ((r)localObject2).gN(1280);
                if (!t.e((r)localObject2))
                {
                  v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " update failed: " + (String)localObject1);
                  com.tencent.mm.compatible.util.g.sb();
                }
              }
            }
            ap.yY();
            if (!com.tencent.mm.u.c.isSDCardAvailable())
            {
              com.tencent.mm.ui.base.s.eP(this.vAn.aYw());
              GMTrace.o(2106278805504L, 15693);
              return;
            }
            if (i == 113)
            {
              v.i("MicroMsg.ChattingListClickListener", "this video come from pc weixin, user restart now.");
              h((r)localObject1);
              GMTrace.o(2106278805504L, 15693);
              return;
            }
            if (((r)localObject1).Lj())
            {
              v.e("MicroMsg.ChattingListClickListener", "this video come from gallery, but it is illegal.");
              paramView = this.vAn.aYw().getString(R.l.eZX);
              if (i == 142) {
                paramView = this.vAn.aYw().getString(R.l.eZX);
              }
              for (;;)
              {
                com.tencent.mm.ui.base.g.z(this.vAn.aYw(), paramView, this.vAn.aYw().getString(R.l.cIz));
                GMTrace.o(2106278805504L, 15693);
                return;
                if (i == 141) {
                  paramView = this.vAn.aYw().getString(R.l.eZY);
                } else if (i == 140) {
                  paramView = this.vAn.aYw().getString(R.l.eZW);
                }
              }
            }
            paramView.bMk();
            ap.yY();
            com.tencent.mm.u.c.wT().a(paramView.pH(), paramView);
            if (((r)localObject1).getStatus() == 198)
            {
              t.lH(paramView.pN());
              GMTrace.o(2106278805504L, 15693);
              return;
            }
            t.lD(paramView.pN());
          }
        }
        if (((au)localObject1).bMd())
        {
          b((ds)localObject3);
          GMTrace.o(2106278805504L, 15693);
          return;
        }
        if (((au)localObject1).getType() == 48)
        {
          f((ds)localObject3);
          GMTrace.o(2106278805504L, 15693);
          return;
        }
        if (((au)localObject1).bLT())
        {
          paramView = ((au)localObject1).pM();
          localObject2 = new rr();
          ((rr)localObject2).fYy.fJB = 1;
          ((rr)localObject2).fYy.content = paramView;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
          if (((rr)localObject2).fYz.type == 2) {}
          for (i = 1; (i != 0) || (((au)localObject1).pM().equals(au.uIc)); i = 0)
          {
            c((ds)localObject3);
            GMTrace.o(2106278805504L, 15693);
            return;
          }
          paramView = ((au)localObject1).pM();
          localObject2 = new rr();
          ((rr)localObject2).fYy.fJB = 1;
          ((rr)localObject2).fYy.content = paramView;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
          if (((rr)localObject2).fYz.type == 3) {}
          for (i = 1; (i != 0) || (((au)localObject1).pM().equals(au.uIb)); i = 0)
          {
            e((ds)localObject3);
            GMTrace.o(2106278805504L, 15693);
            return;
          }
        }
        if (((au)localObject1).bMe())
        {
          ap.yY();
          if (com.tencent.mm.u.c.isSDCardAvailable())
          {
            paramView = ((ds)localObject3).fTa;
            ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.vAn.aYw(), paramView);
            com.tencent.mm.plugin.report.service.g.oSF.i(11592, new Object[] { Integer.valueOf(0) });
          }
          GMTrace.o(2106278805504L, 15693);
          return;
        }
        if (((au)localObject1).bLS())
        {
          if (this.vAn != null)
          {
            com.tencent.mm.plugin.report.service.g.oSF.A(10221, "1");
            paramView = new Intent();
            paramView.addFlags(67108864);
            com.tencent.mm.bb.d.b(this.vAn.aYw(), "shake", ".ui.ShakeReportUI", paramView);
          }
          GMTrace.o(2106278805504L, 15693);
          return;
        }
        if (((au)localObject1).bMg())
        {
          a((ds)localObject3);
          GMTrace.o(2106278805504L, 15693);
          return;
        }
        if (((au)localObject1).bMa())
        {
          a(paramView, (ds)localObject3);
          GMTrace.o(2106278805504L, 15693);
          return;
        }
        v.e("MicroMsg.ChattingListClickListener", "uknown msg type");
      }
      GMTrace.o(2106278805504L, 15693);
      return;
    }
  }
  
  public final void u(long paramLong, String paramString)
  {
    GMTrace.i(2107084111872L, 15699);
    this.vAn.eI(paramLong);
    t.lE(paramString);
    GMTrace.o(2107084111872L, 15699);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */