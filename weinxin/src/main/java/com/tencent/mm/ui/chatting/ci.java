package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ag.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.y.n;

final class ci
  extends ag.b
{
  public com.tencent.mm.y.e hTN;
  public En_5b8fbb1e.a vAn;
  
  public ci()
  {
    super(33);
    GMTrace.i(2210431762432L, 16469);
    GMTrace.o(2210431762432L, 16469);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2210565980160L, 16470);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof ei)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYw);
      ((View)localObject).setTag(new ei(this.klJ).du((View)localObject));
    }
    GMTrace.o(2210565980160L, 16470);
    return (View)localObject;
  }
  
  public final void a(final ag.a parama, final int paramInt, En_5b8fbb1e.a parama1, final au paramau, String paramString)
  {
    GMTrace.i(2210700197888L, 16471);
    ei localei = (ei)parama;
    this.vAn = parama1;
    Object localObject2 = an.bDc().ec(paramau.field_msgId);
    Object localObject1 = paramau.field_content;
    paramString = null;
    parama = paramString;
    if (localObject2 != null)
    {
      parama = paramString;
      if (localObject1 != null) {
        parama = f.a.B((String)localObject1, paramau.field_reserved);
      }
    }
    if (parama != null) {
      localei.ipd.setText(parama.description);
    }
    v.d("MicroMsg.ChattingItemVoiceRemindsys", "content sys " + paramau.field_content);
    localObject1 = com.tencent.mm.plugin.subapp.c.e.Hi((String)localObject1);
    if ((localObject1 != null) && (((com.tencent.mm.plugin.subapp.c.e)localObject1).qRE != null) && (((com.tencent.mm.plugin.subapp.c.e)localObject1).qRE.length() > 0) && (((com.tencent.mm.plugin.subapp.c.e)localObject1).qRF > 0) && (this.hTN == null) && (parama != null) && (bf.mA(paramau.field_imgPath)))
    {
      localObject2 = com.tencent.mm.plugin.subapp.c.k.lv(m.xL());
      paramString = h.at((String)localObject2, false);
      paramau.cI((String)localObject2);
      ap.yY();
      com.tencent.mm.u.c.wT().a(paramau.field_msgId, paramau);
      long l = paramau.field_msgId;
      int i = parama.sdkVer;
      localObject2 = parama.appId;
      String str = ((com.tencent.mm.plugin.subapp.c.e)localObject1).qRE;
      int j = ((com.tencent.mm.plugin.subapp.c.e)localObject1).qRF;
      int k = parama.type;
      localObject1 = parama.hhu;
      parama = l.a(paramString, l, i, (String)localObject2, str, j, k, parama.hhk);
      if (parama != null)
      {
        paramString = ap.vd();
        localObject1 = new com.tencent.mm.y.e()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.y.k paramAnonymousk)
          {
            GMTrace.i(2153255010304L, 16043);
            v.d("MicroMsg.ChattingItemVoiceRemindsys", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousk.getType());
            boolean bool = false;
            if (com.tencent.mm.u.ag.a.hlD != null) {
              bool = com.tencent.mm.u.ag.a.hlD.K(paramau.field_msgId);
            }
            if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((ab)paramAnonymousk).getMediaId().equals(parama))) {
              ci.this.vAn.vzN.vCX.b(paramInt, paramau);
            }
            ap.vd().b(221, ci.this.hTN);
            ci.this.hTN = null;
            GMTrace.o(2153255010304L, 16043);
          }
        };
        this.hTN = ((com.tencent.mm.y.e)localObject1);
        paramString.a(221, (com.tencent.mm.y.e)localObject1);
        parama = new ab(parama);
        parama.bCX();
        ap.vd().a(parama, 0);
      }
    }
    localei.ipd.setTag(new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0));
    localei.ipd.setOnClickListener(parama1.vzN.vDb);
    ap.yY();
    if (com.tencent.mm.u.c.isSDCardAvailable()) {
      localei.ipd.setOnLongClickListener(parama1.vzN.vDd);
    }
    GMTrace.o(2210700197888L, 16471);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2210834415616L, 16472);
    int i = ((ds)paramView.getTag()).position;
    if (!this.vAn.bVz()) {
      paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
    }
    GMTrace.o(2210834415616L, 16472);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2210968633344L, 16473);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2210968633344L, 16473);
      return false;
    }
    parama = paramau.field_content;
    paramMenuItem = null;
    if (parama != null) {
      paramMenuItem = f.a.ek(parama);
    }
    if (paramMenuItem != null) {
      l.ed(paramau.field_msgId);
    }
    ay.L(paramau.field_msgId);
    GMTrace.o(2210968633344L, 16473);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2211102851072L, 16474);
    GMTrace.o(2211102851072L, 16474);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */