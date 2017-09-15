package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.sd;
import com.tencent.mm.e.a.sd.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.b;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;

final class ak
  extends ag.c
{
  private En_5b8fbb1e.a vAn;
  
  public ak()
  {
    super(60);
    GMTrace.i(2128693166080L, 15860);
    GMTrace.o(2128693166080L, 15860);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2128827383808L, 15861);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof e)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYc);
      ((View)localObject).setTag(new e(this.klJ).de((View)localObject));
    }
    GMTrace.o(2128827383808L, 15861);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2128961601536L, 15862);
    this.vAn = parama1;
    e locale = (e)parama;
    paramString = paramau.field_content;
    if (paramString != null) {}
    for (f.a locala = f.a.B(paramString, paramau.field_reserved);; locala = null)
    {
      sd localsd;
      boolean bool1;
      int j;
      label239:
      label272:
      Object localObject;
      if (locala != null)
      {
        boolean bool2 = "1001".equals(locala.hiL);
        localsd = new sd();
        if ((!bf.mA(locala.hiM)) && (!bool2))
        {
          localsd.fZt.fZv = locala.hiM;
          com.tencent.mm.sdk.b.a.uql.m(localsd);
        }
        e.I(locale.vAj, locale.vwx);
        if (!"1001".equals(locala.hiL)) {
          break label570;
        }
        paramString = locale.vAj;
        if (paramau.field_isSend != 1) {
          break label564;
        }
        bool1 = true;
        paramString.setBackgroundResource(v.c(locala, bool1));
        locale.vwu.setTypeface(Typeface.defaultFromStyle(1));
        i = com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 13);
        j = parama1.uRf.uRz.getResources().getDimensionPixelSize(R.f.aXy);
        locale.vAj.setPadding(j, 0, i, 0);
        if (paramau.field_isSend != 1) {
          break label681;
        }
        paramString = locala.hiG;
        if (!bf.mA(paramString)) {
          break label691;
        }
        paramString = locala.description;
        locale.vwu.setSingleLine(false);
        locale.vwu.setMaxLines(3);
        locale.vwu.setText(h.c(parama1.uRf.uRz, paramString, locale.vwy));
        locale.vwu.setTextSize(0, locale.vwy);
        if (!bool2) {
          break label709;
        }
        localObject = locale.vwv;
        paramString = parama1.uRf.uRz;
        if (paramau.field_isSend != 1) {
          break label703;
        }
        bool1 = true;
        label345:
        paramString = h.b(paramString, v.b(locala, bool1), locale.vwv.getTextSize());
        label367:
        ((TextView)localObject).setText(paramString);
        localObject = locala.hiJ;
        paramString = (String)localObject;
        if (bf.mA((String)localObject)) {
          paramString = locala.title;
        }
        locale.vww.setText(paramString);
        paramString = (b)locala.n(b.class);
        if (bf.mA(paramString.hha)) {
          break label1028;
        }
        n.GX().a("", locale.vwt);
      }
      label564:
      label570:
      label609:
      label671:
      label681:
      label691:
      label703:
      label709:
      label927:
      label1028:
      for (int i = parama1.getResources().getIdentifier(paramString.hha, "drawable", aa.getPackageName());; i = 0)
      {
        if (i != 0) {
          locale.vwt.setImageResource(i);
        }
        for (;;)
        {
          parama.vAj.setOnClickListener(parama1.vzN.vDb);
          parama.vAj.setOnLongClickListener(parama1.vzN.vDd);
          parama.vAj.setOnTouchListener(parama1.vzN.vDf);
          parama1 = new ds(paramau, this.vAn.vvA, paramInt, null, 0, (byte)0);
          parama.vAj.setTag(parama1);
          GMTrace.o(2128961601536L, 15862);
          return;
          bool1 = false;
          break;
          paramString = locale.vAj;
          i = localsd.fZu.fZw;
          j = localsd.fZu.fZx;
          if (paramau.field_isSend == 1)
          {
            bool1 = true;
            paramString.setBackgroundResource(v.s(i, j, bool1));
            locale.vwu.setTypeface(Typeface.defaultFromStyle(0));
            if (locale.vwy <= locale.maxSize) {
              break label671;
            }
          }
          for (i = locale.maxSize;; i = locale.vwy)
          {
            locale.vwy = i;
            break;
            bool1 = false;
            break label609;
          }
          paramString = locala.hiF;
          break label239;
          locale.vwu.setSingleLine(true);
          break label272;
          bool1 = false;
          break label345;
          if (!bf.mA(locala.hiM))
          {
            localObject = locale.vwv;
            i = localsd.fZu.fZw;
            j = localsd.fZu.fZx;
            if (paramau.field_isSend == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              paramString = v.a(i, j, bool1, locala);
              break;
            }
          }
          localObject = locale.vwv;
          if (paramau.field_isSend == 1)
          {
            paramString = locala.hiH;
            break label367;
          }
          paramString = locala.hiI;
          break label367;
          if ("1001".equals(locala.hiL))
          {
            if (paramau.field_isSend == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              i = v.a(locala, bool1);
              if (i <= 0) {
                break label927;
              }
              locale.vwt.setImageResource(i);
              break;
            }
          }
          i = localsd.fZu.fZw;
          j = localsd.fZu.fZx;
          if (paramau.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            i = v.t(i, j, bool1);
            break;
          }
          localObject = locala.hiE;
          paramString = (String)localObject;
          if (bf.mA((String)localObject)) {
            paramString = locala.thumburl;
          }
          locale.vwt.setImageBitmap(null);
          if (!bf.mA(paramString))
          {
            localObject = new c.a();
            ap.yY();
            ((c.a)localObject).hIw = com.tencent.mm.u.c.xc();
            ((c.a)localObject).hIt = true;
            ((c.a)localObject).hIP = true;
            localObject = ((c.a)localObject).Hh();
            n.GX().a(paramString, locale.vwt, (com.tencent.mm.ah.a.a.c)localObject);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2129095819264L, 15863);
    paramContextMenu.add(((ds)paramView.getTag()).position, 100, 0, this.vAn.getString(R.l.dUh));
    GMTrace.o(2129095819264L, 15863);
    return false;
  }
  
  public final boolean a(final MenuItem paramMenuItem, final En_5b8fbb1e.a parama, final au paramau)
  {
    GMTrace.i(2129230036992L, 15864);
    switch (paramMenuItem.getItemId())
    {
    case 101: 
    case 102: 
    default: 
      GMTrace.o(2129230036992L, 15864);
      return false;
    case 100: 
      ay.L(paramau.field_msgId);
      GMTrace.o(2129230036992L, 15864);
      return true;
    }
    final String str1 = paramau.field_content;
    paramMenuItem = null;
    if (str1 != null) {
      paramMenuItem = f.a.B(str1, paramau.field_reserved);
    }
    if (paramMenuItem != null)
    {
      paramau = paramau.field_talker;
      str1 = paramMenuItem.hiF;
      final String str2 = paramMenuItem.hiG;
      final String str3 = paramMenuItem.hiH;
      final String str4 = paramMenuItem.hiI;
      final String str5 = paramMenuItem.hiD;
      final String str6 = paramMenuItem.hiK;
      paramMenuItem = paramMenuItem.hiL;
      com.tencent.mm.ui.base.g.b(parama.uRf.uRz, parama.getString(R.l.dVd), parama.getString(R.l.dIk), parama.getString(R.l.dVe), parama.getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2246938984448L, 16741);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("key_scene", 1);
          paramAnonymousDialogInterface.putExtra("key_receiver", paramau);
          paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
          paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
          paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
          paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
          paramAnonymousDialogInterface.putExtra("key_url", str5);
          paramAnonymousDialogInterface.putExtra("key_templateid", str6);
          paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
          d.b(parama.bOZ(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
          GMTrace.o(2246938984448L, 16741);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2216203124736L, 16512);
          GMTrace.o(2216203124736L, 16512);
        }
      });
    }
    GMTrace.o(2129230036992L, 15864);
    return true;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2129364254720L, 15865);
    paramView = paramau.field_content;
    if (paramView != null) {}
    for (paramView = f.a.B(paramView, paramau.field_reserved);; paramView = null)
    {
      if (paramView != null)
      {
        if (!bf.mA(paramView.hiD)) {
          break label185;
        }
        paramau = paramView.url;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(bf.mA(paramau)), Boolean.valueOf(bf.mA(paramView.hiU)) });
        if (bf.mA(paramView.hiM)) {
          break label364;
        }
        if (!paramView.hiM.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
          break label193;
        }
        paramau = new Intent();
        paramau.putExtra("key_way", 1);
        paramau.putExtra("key_native_url", paramView.hiM);
        paramau.putExtra("key_username", parama.bTW());
        paramau.putExtra("key_static_from_scene", 100002);
        d.b(parama.uRf.uRz, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", paramau);
      }
      for (;;)
      {
        GMTrace.o(2129364254720L, 15865);
        return true;
        label185:
        paramau = paramView.hiD;
        break;
        label193:
        if (paramView.hiM.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
        {
          paramau = new Intent();
          if (parama.vzR) {}
          for (int i = 0;; i = 1)
          {
            paramau.putExtra("key_way", i);
            paramau.putExtra("key_native_url", paramView.hiM);
            paramau.putExtra("key_username", parama.bTW());
            d.b(parama.uRf.uRz, "luckymoney", ".ui.En_fba4b94f", paramau);
            break;
          }
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + paramView.hiM + ", go webview:" + paramau);
        if (!bf.mA(paramau))
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", paramau);
          d.b(parama.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramView);
          continue;
          label364:
          if (!bf.mA(paramView.hiU))
          {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.hiU, Integer.valueOf(paramView.hiV), paramView.fOl });
            paramau = new Intent();
            paramau.putExtra("bill_no", paramView.hiU);
            paramau.putExtra("launcher_user_name", paramView.fOl);
            paramau.putExtra("enter_scene", 1);
            paramau.putExtra("chatroom", parama.bTW());
            d.b(parama.uRf.uRz, "aa", ".ui.PaylistAAUI", paramau);
            com.tencent.mm.plugin.report.service.g.oSF.i(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
          }
          else if ((!bf.mA(paramau)) && (!bf.mA(paramau)))
          {
            paramView = new Intent();
            paramView.putExtra("rawUrl", paramau);
            d.b(parama.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramView);
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */