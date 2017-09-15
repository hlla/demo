package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.q;

public final class bp
  extends ag
{
  public bp()
  {
    super(57);
    GMTrace.i(2145873035264L, 15988);
    GMTrace.o(2145873035264L, 15988);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2146007252992L, 15989);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof a)))
    {
      localObject = paramView;
      if (((a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXS);
      ((View)localObject).setTag(new a(this.klJ).jdMethod_do((View)localObject));
    }
    GMTrace.o(2146007252992L, 15989);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2146141470720L, 15990);
    a locala = (a)parama;
    f localf = an.bDc().ec(paramau.field_msgId);
    String str = paramau.field_content;
    if ((localf != null) && (str != null))
    {
      paramString = f.a.B(str, paramau.field_reserved);
      paramau = new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0);
      if ((paramString != null) && ((paramString.showType == 2) || (paramString.hia == 2) || (paramString.hia == 4)))
      {
        a.b.n(locala.hAQ, paramString.hie);
        locala.vBY.H(parama1.getResources().getDimension(R.f.aXH));
        locala.vBY.setTextColor(Color.parseColor("#BF000000"));
        locala.vBY.setEllipsize(TextUtils.TruncateAt.END);
        locala.vBY.bSd();
        locala.vBY.vng = true;
        locala.vBY.setText(h.a(parama1.uRf.uRz, paramString.hid));
      }
      parama.vAj.setOnLongClickListener(parama1.vzN.vDd);
      parama.vAj.setOnTouchListener(parama1.vzN.vDf);
      parama.vAj.setTag(paramau);
      parama.vAj.setOnClickListener(parama1.vzN.vDb);
      GMTrace.o(2146141470720L, 15990);
      return;
    }
    if (localf == null) {}
    for (boolean bool = true;; bool = false)
    {
      v.e("MicrMsg.ChattingItemHardDeviceMsgLike", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(paramau.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2146275688448L, 15991);
    paramContextMenu.add(((ds)paramView.getTag()).position, 100, 0, paramView.getContext().getString(R.l.dUh));
    GMTrace.o(2146275688448L, 15991);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2146409906176L, 15992);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      GMTrace.o(2146409906176L, 15992);
      return false;
      parama = paramau.field_content;
      paramMenuItem = null;
      if (parama != null) {
        paramMenuItem = f.a.ek(parama);
      }
      if (paramMenuItem != null) {
        com.tencent.mm.pluginsdk.model.app.l.ed(paramau.field_msgId);
      }
      ay.L(paramau.field_msgId);
    }
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2146544123904L, 15993);
    v.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
    if (paramau == null)
    {
      v.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
      GMTrace.o(2146544123904L, 15993);
      return false;
    }
    String str = paramau.field_content;
    paramView = f.a.B(str, paramau.field_reserved);
    if (paramView == null)
    {
      v.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
      GMTrace.o(2146544123904L, 15993);
      return false;
    }
    v.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!u.mA(paramView.url))
    {
      paramau = new Intent();
      paramau.putExtra("rawUrl", paramView.url);
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramau);
      GMTrace.o(2146544123904L, 15993);
      return true;
    }
    ap.yY();
    if (c.wR().Rb(paramView.hie).tB()) {
      v.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
    }
    for (;;)
    {
      GMTrace.o(2146544123904L, 15993);
      return false;
      if (paramView.showType == 2)
      {
        if (!u.mA(paramView.hhM))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_rank_info", str);
          localIntent.putExtra("key_rank_semi", paramau.field_reserved);
          localIntent.putExtra("key_rank_title", paramView.hhX);
          localIntent.putExtra("key_champion_info", paramView.hhY);
          localIntent.putExtra("key_champion_coverimg", paramView.hhY);
          localIntent.putExtra("rank_id", paramView.hhM);
          localIntent.putExtra("app_username", paramView.appName);
          localIntent.putExtra("device_type", paramView.hib);
          localIntent.putExtra("key_champioin_username", paramView.hhW);
          localIntent.putExtra("locate_to_username", paramView.hie);
          com.tencent.mm.bb.d.b(parama.uRf.uRz, "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sport.b.d.mJ(30);
          break;
          paramau = new Intent();
          paramau.putExtra("key_is_latest", true);
          paramau.putExtra("app_username", paramView.appName);
          paramau.putExtra("device_type", paramView.hib);
          paramau.putExtra("locate_to_username", paramView.hie);
          com.tencent.mm.bb.d.b(parama.uRf.uRz, "exdevice", ".ui.ExdeviceRankInfoUI", paramau);
        }
      }
      if (paramView.showType == 4)
      {
        paramau = new Intent();
        paramau.putExtra("username", paramView.hie);
        paramau.putExtra("app_username", "gh_43f2581f6fd6");
        com.tencent.mm.bb.d.b(parama.uRf.uRz, "exdevice", ".ui.ExdeviceProfileUI", paramau);
        com.tencent.mm.plugin.sport.b.d.mJ(29);
      }
    }
  }
  
  final class a
    extends ag.a
  {
    protected ImageView hAQ;
    protected NoMeasuredTextView vBY;
    
    public a(int paramInt)
    {
      super();
      GMTrace.i(2222511357952L, 16559);
      GMTrace.o(2222511357952L, 16559);
    }
    
    public final a jdMethod_do(View paramView)
    {
      GMTrace.i(2222645575680L, 16560);
      super.dl(paramView);
      this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
      this.hAQ = ((ImageView)paramView.findViewById(R.h.cbc));
      this.vBY = ((NoMeasuredTextView)paramView.findViewById(R.h.cIx));
      GMTrace.o(2222645575680L, 16560);
      return this;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */