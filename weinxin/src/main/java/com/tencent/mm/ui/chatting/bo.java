package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.q;

public final class bo
  extends ag
{
  private En_5b8fbb1e.a vAn;
  
  public bo()
  {
    super(52);
    GMTrace.i(2224658841600L, 16575);
    GMTrace.o(2224658841600L, 16575);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2224793059328L, 16576);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof a)))
    {
      localObject = paramView;
      if (((a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXT);
      ((View)localObject).setTag(new a(this.klJ).dn((View)localObject));
    }
    GMTrace.o(2224793059328L, 16576);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2224927277056L, 16577);
    this.vAn = parama1;
    a locala = (a)parama;
    Object localObject1 = an.bDc().ec(paramau.field_msgId);
    Object localObject2 = paramau.field_content;
    if ((localObject1 != null) && (localObject2 != null)) {
      paramString = f.a.B((String)localObject2, paramau.field_reserved);
    }
    for (;;)
    {
      ds localds = new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0);
      HardDeviceChattingItemView localHardDeviceChattingItemView = (HardDeviceChattingItemView)parama.vAj;
      int j;
      int k;
      int i;
      if ((paramString != null) && ((paramString.showType == 1) || (paramString.hia == 1))) {
        if (u.mA(paramString.hhV))
        {
          localObject2 = paramString.hhR;
          Object localObject3 = paramString.hhS;
          if (!bf.mA((String)localObject2))
          {
            localObject1 = localObject3;
            paramau = (au)localObject2;
            if (!bf.mA((String)localObject3)) {}
          }
          else
          {
            v.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", new Object[] { localObject2, localObject3 });
            paramau = "#ffffff";
            localObject1 = "#ffffff";
          }
          localObject2 = new StateListDrawable();
          localObject3 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject3);
          localObject1 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842908 }, (Drawable)localObject1);
          localObject1 = new ColorDrawable(Color.parseColor(paramau));
          ((StateListDrawable)localObject2).addState(new int[] { 16842766 }, (Drawable)localObject1);
          paramau = new ColorDrawable(Color.parseColor(paramau));
          ((StateListDrawable)localObject2).addState(new int[0], paramau);
          localHardDeviceChattingItemView.setBackgroundDrawable((Drawable)localObject2);
          paramString.hhV = "#ffffff";
          paramau = paramString.hhT;
          localObject1 = paramString.hhU;
          j = R.e.white;
          k = R.e.white;
          i = k;
          paramInt = j;
          if (!u.mA(paramau))
          {
            i = k;
            paramInt = j;
            if (!u.mA((String)localObject1)) {
              paramInt = j;
            }
          }
        }
      }
      try
      {
        i = Color.parseColor(paramau);
        paramInt = i;
        j = Color.parseColor((String)localObject1);
        paramInt = i;
        i = j;
        paramau = new StateListDrawable();
        localObject1 = new ColorDrawable(i);
        paramau.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(i);
        paramau.addState(new int[] { 16842908 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        paramau.addState(new int[] { 16842766 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        paramau.addState(new int[0], (Drawable)localObject1);
        locala.vBV.setBackgroundDrawable(paramau);
        paramau = paramString.hhV;
        if (locala != null)
        {
          i = R.e.white;
          paramInt = i;
          if (u.mA(paramau)) {}
        }
      }
      catch (IllegalArgumentException paramau)
      {
        try
        {
          paramInt = Color.parseColor(paramau);
          locala.vBS.setTextColor(paramInt);
          locala.vBT.setTextColor(paramInt);
          locala.vBQ.setTextColor(paramInt);
          locala.vBR.setTextColor(paramInt);
          locala.vBU.setTextColor(paramInt);
          locala.vBS.setText(paramString.hhN);
          locala.vBT.setText(paramString.hhL);
          locala.vBQ.setText(paramString.hhP);
          locala.vBR.setText(paramString.hhO);
          locala.vBU.setText(paramString.hhQ);
          if (!u.mA(paramString.hhW))
          {
            locala.vBW.setVisibility(0);
            a.b.n(locala.vBW, paramString.hhW);
            parama.vAj.setOnLongClickListener(parama1.vzN.vDd);
            parama.vAj.setOnTouchListener(parama1.vzN.vDf);
            parama.vAj.setTag(localds);
            parama.vAj.setOnClickListener(parama1.vzN.vDb);
            GMTrace.o(2224927277056L, 16577);
            return;
            if (localObject1 == null) {}
            for (boolean bool = true;; bool = false)
            {
              v.e("MicroMsg.ChattingItemHardDeviceMsg", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), localObject2, Long.valueOf(paramau.field_msgId), paramString });
              paramString = null;
              break;
            }
            paramau = paramau;
            v.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
            i = k;
          }
        }
        catch (IllegalArgumentException paramau)
        {
          for (;;)
          {
            v.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
            paramInt = i;
            continue;
            locala.vBW.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2225061494784L, 16578);
    paramContextMenu.add(((ds)paramView.getTag()).position, 100, 0, this.vAn.getString(R.l.dUh));
    GMTrace.o(2225061494784L, 16578);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2225195712512L, 16579);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      GMTrace.o(2225195712512L, 16579);
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
    GMTrace.i(2225329930240L, 16580);
    String str = paramau.field_content;
    paramView = f.a.B(str, paramau.field_reserved);
    if (paramView == null)
    {
      v.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
      GMTrace.o(2225329930240L, 16580);
      return false;
    }
    v.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!u.mA(paramView.url))
    {
      paramau = new Intent();
      paramau.putExtra("rawUrl", paramView.url);
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramau);
      GMTrace.o(2225329930240L, 16580);
      return true;
    }
    int i;
    if (!u.mA(paramView.hhM))
    {
      i = paramView.hic;
      if (System.currentTimeMillis() - i * 1000L >= 2592000000L)
      {
        i = 1;
        if (i != 0) {
          break label333;
        }
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
        com.tencent.mm.bb.d.b(parama.uRf.uRz, "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        com.tencent.mm.plugin.sport.b.d.mJ(28);
      }
    }
    for (;;)
    {
      GMTrace.o(2225329930240L, 16580);
      return true;
      i = 0;
      break;
      label333:
      com.tencent.mm.bb.d.w(parama.uRf.uRz, "exdevice", ".ui.ExdeviceExpireUI");
    }
  }
  
  final class a
    extends ag.a
  {
    protected TextView vBQ;
    protected TextView vBR;
    protected TextView vBS;
    protected TextView vBT;
    protected TextView vBU;
    protected TextView vBV;
    protected ImageView vBW;
    
    public a(int paramInt)
    {
      super();
      GMTrace.i(2230430203904L, 16618);
      GMTrace.o(2230430203904L, 16618);
    }
    
    public final a dn(View paramView)
    {
      GMTrace.i(2230564421632L, 16619);
      super.dl(paramView);
      this.vBQ = ((TextView)paramView.findViewById(R.h.cGu));
      this.vBS = ((TextView)paramView.findViewById(R.h.cva));
      this.vBR = ((TextView)paramView.findViewById(R.h.cGv));
      this.vBT = ((TextView)paramView.findViewById(R.h.cvb));
      this.vBU = ((TextView)paramView.findViewById(R.h.cMq));
      this.vBV = ((TextView)paramView.findViewById(R.h.bVE));
      this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
      this.vBW = ((ImageView)paramView.findViewById(R.h.cMm));
      GMTrace.o(2230564421632L, 16619);
      return this;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */