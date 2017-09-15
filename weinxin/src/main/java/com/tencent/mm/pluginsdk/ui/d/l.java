package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class l
  extends ClickableSpan
{
  private WeakReference<View> fh;
  String iCm;
  private int jjm;
  boolean mEnable;
  public boolean nHh;
  private Context sSk;
  private int sSp;
  f sSq;
  private i sSr;
  
  public l()
  {
    GMTrace.i(1206751592448L, 8991);
    this.nHh = false;
    this.sSq = null;
    this.sSr = null;
    this.mEnable = true;
    this.fh = null;
    this.sSk = null;
    GMTrace.o(1206751592448L, 8991);
  }
  
  public l(int paramInt, i parami)
  {
    GMTrace.i(1206885810176L, 8992);
    this.nHh = false;
    this.sSq = null;
    this.sSr = null;
    this.mEnable = true;
    this.fh = null;
    this.sSk = null;
    int j;
    if (parami != null)
    {
      j = parami.linkColor;
      i = parami.backgroundColor;
    }
    for (;;)
    {
      if ((j == 0) && (i == 0)) {
        vA(paramInt);
      }
      for (;;)
      {
        this.sSq = new f();
        this.sSr = parami;
        GMTrace.o(1206885810176L, 8992);
        return;
        dI(j, i);
      }
      j = 0;
    }
  }
  
  public final void dI(int paramInt1, int paramInt2)
  {
    GMTrace.i(1207154245632L, 8994);
    this.sSp = paramInt1;
    this.jjm = paramInt2;
    GMTrace.o(1207154245632L, 8994);
  }
  
  public void onClick(View paramView)
  {
    GMTrace.i(1207288463360L, 8995);
    Object localObject2;
    Object localObject1;
    f localf;
    i locali;
    if ((this.sSq != null) && (this.sSr != null) && (this.mEnable))
    {
      localObject2 = this.sSq;
      if (this.sSk == null) {
        break label96;
      }
      localObject1 = this.sSk;
      ((f)localObject2).mContext = ((Context)localObject1);
      localf = this.sSq;
      locali = this.sSr;
      if (locali != null) {
        break label104;
      }
      v.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
    }
    for (;;)
    {
      this.sSq.mContext = null;
      GMTrace.o(1207288463360L, 8995);
      return;
      label96:
      localObject1 = paramView.getContext();
      break;
      label104:
      v.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", new Object[] { Integer.valueOf(locali.type) });
      if (localf.mContext != null) {
        break label144;
      }
      v.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
    }
    label144:
    if ((h.sRR != null) && (h.sRR.size() > 0))
    {
      int i = h.sRR.size();
      localObject1 = (e)h.sRR.getLast();
      v.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      au localau;
      if ((paramView != null) && ((paramView.getTag() instanceof c)))
      {
        localau = ((c)paramView.getTag()).fTa;
        if (localau != null)
        {
          localObject2 = localau.field_talker;
          paramView = (View)localObject2;
          if (!((String)localObject2).endsWith("@chatroom")) {}
        }
      }
      for (paramView = ay.gi(localau.field_content);; paramView = null)
      {
        locali.username = paramView;
        if (!TextUtils.isEmpty(localf.iCm)) {
          locali.iCm = localf.iCm;
        }
        b.a.sRB.a(localf.mContext, locali, (e)localObject1);
        locali.iCm = null;
        break;
      }
      localObject1 = null;
    }
  }
  
  public final void setContext(Context paramContext)
  {
    GMTrace.i(1207556898816L, 8997);
    this.sSk = paramContext;
    this.sSq.mContext = paramContext;
    GMTrace.o(1207556898816L, 8997);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    GMTrace.i(1207422681088L, 8996);
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.sSp);
    paramTextPaint.setUnderlineText(false);
    if (this.nHh)
    {
      paramTextPaint.bgColor = this.jjm;
      GMTrace.o(1207422681088L, 8996);
      return;
    }
    paramTextPaint.bgColor = 0;
    GMTrace.o(1207422681088L, 8996);
  }
  
  public void vA(int paramInt)
  {
    GMTrace.i(1207020027904L, 8993);
    Context localContext = aa.getContext();
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(1207020027904L, 8993);
      return;
      dI(localContext.getResources().getColor(a.a.kBJ), -5908174);
      GMTrace.o(1207020027904L, 8993);
      return;
      dI(localContext.getResources().getColor(a.a.aUA), localContext.getResources().getColor(a.a.aVR));
      GMTrace.o(1207020027904L, 8993);
      return;
      dI(localContext.getResources().getColor(a.a.kBK), localContext.getResources().getColor(a.a.aVR));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/d/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */