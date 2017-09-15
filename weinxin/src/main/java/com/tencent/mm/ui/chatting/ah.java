package com.tencent.mm.ui.chatting;

import android.app.Activity;
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
import com.tencent.mm.plugin.report.service.g;
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

final class ah
  extends ag.b
{
  private En_5b8fbb1e.a vAn;
  
  public ah()
  {
    super(59);
    GMTrace.i(2396054880256L, 17852);
    GMTrace.o(2396054880256L, 17852);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2396189097984L, 17853);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof e)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXx);
      ((View)localObject).setTag(new e(this.klJ).de((View)localObject));
    }
    GMTrace.o(2396189097984L, 17853);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2396323315712L, 17854);
    this.vAn = parama1;
    e locale = (e)parama;
    paramString = paramau.field_content;
    if (paramString != null) {}
    for (f.a locala = f.a.B(paramString, paramau.field_reserved);; locala = null)
    {
      sd localsd;
      boolean bool1;
      int i;
      int j;
      label243:
      label276:
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
          break label569;
        }
        paramString = locale.vAj;
        if (paramau.field_isSend != 1) {
          break label563;
        }
        bool1 = true;
        paramString.setBackgroundResource(v.c(locala, bool1));
        locale.vwu.setTypeface(Typeface.defaultFromStyle(1));
        i = parama1.uRf.uRz.getResources().getDimensionPixelSize(R.f.aXQ);
        j = parama1.uRf.uRz.getResources().getDimensionPixelSize(R.f.aYX);
        locale.vAj.setPadding(j, 0, i, 0);
        if (paramau.field_isSend != 1) {
          break label680;
        }
        paramString = locala.hiG;
        if (!bf.mA(paramString)) {
          break label690;
        }
        paramString = locala.description;
        locale.vwu.setSingleLine(false);
        locale.vwu.setMaxLines(3);
        locale.vwu.setText(h.c(parama1.uRf.uRz, paramString, locale.vwy));
        locale.vwu.setTextSize(0, locale.vwy);
        if (!bool2) {
          break label708;
        }
        localObject = locale.vwv;
        paramString = parama1.uRf.uRz;
        if (paramau.field_isSend != 1) {
          break label702;
        }
        bool1 = true;
        label349:
        paramString = h.b(paramString, v.b(locala, bool1), locale.vwv.getTextSize());
        label371:
        ((TextView)localObject).setText(paramString);
        paramString = locala.hiJ;
        if (!bf.mA(paramString)) {
          break label1033;
        }
        paramString = locala.title;
      }
      label563:
      label569:
      label608:
      label670:
      label680:
      label690:
      label702:
      label708:
      label926:
      label1033:
      for (;;)
      {
        localObject = (b)locala.n(b.class);
        locale.vww.setText(paramString);
        if (!bf.mA(((b)localObject).hha)) {
          n.GX().a("", locale.vwt);
        }
        for (i = parama1.getResources().getIdentifier(((b)localObject).hha, "drawable", aa.getPackageName());; i = 0)
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
            GMTrace.o(2396323315712L, 17854);
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
                break label670;
              }
            }
            for (i = locale.maxSize;; i = locale.vwy)
            {
              locale.vwy = i;
              break;
              bool1 = false;
              break label608;
            }
            paramString = locala.hiF;
            break label243;
            locale.vwu.setSingleLine(true);
            break label276;
            bool1 = false;
            break label349;
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
              break label371;
            }
            paramString = locala.hiI;
            break label371;
            if ("1001".equals(locala.hiL))
            {
              if (paramau.field_isSend == 1) {}
              for (bool1 = true;; bool1 = false)
              {
                i = v.a(locala, bool1);
                if (i <= 0) {
                  break label926;
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
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2396457533440L, 17855);
    paramContextMenu.add(((ds)paramView.getTag()).position, 100, 0, this.vAn.getString(R.l.dUh));
    GMTrace.o(2396457533440L, 17855);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2396591751168L, 17856);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2396591751168L, 17856);
      return false;
    }
    ay.L(paramau.field_msgId);
    GMTrace.o(2396591751168L, 17856);
    return true;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2396725968896L, 17857);
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
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ChattingItemAppMsgC2CFrom", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(bf.mA(paramau)), Boolean.valueOf(bf.mA(paramView.hiU)) });
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
        GMTrace.o(2396725968896L, 17857);
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
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ChattingItemAppMsgC2CFrom", "native url not match:" + paramView.hiM + ", go webview:" + paramau);
        if (!bf.mA(paramau))
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", paramau);
          d.b(parama.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramView);
          continue;
          label364:
          if (!bf.mA(paramView.hiU))
          {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ChattingItemAppMsgC2CFrom", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.hiU, Integer.valueOf(paramView.hiV), paramView.fOl });
            paramau = new Intent();
            paramau.putExtra("bill_no", paramView.hiU);
            paramau.putExtra("launcher_user_name", paramView.fOl);
            paramau.putExtra("enter_scene", 1);
            paramau.putExtra("chatroom", parama.bTW());
            d.b(parama.uRf.uRz, "aa", ".ui.PaylistAAUI", paramau);
            if (v.e(paramView).sZL == 2) {
              g.oSF.i(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
            } else {
              g.oSF.i(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(3) });
            }
          }
          else if (!bf.mA(paramau))
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


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */