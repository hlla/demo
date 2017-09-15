package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelbiz.a.d;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.k.a;

public final class c
  extends k<com.tencent.mm.modelbiz.a.c>
  implements m.b
{
  private final MMActivity fBZ;
  protected MMSlideDelView.f jUm;
  protected MMSlideDelView.c jUn;
  protected MMSlideDelView.e jUo;
  protected MMSlideDelView.d jUp;
  private final String jZw;
  private com.tencent.mm.ah.a.a.c kuE;
  
  public c(Context paramContext, k.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.modelbiz.a.c());
    GMTrace.i(2968225054720L, 22115);
    this.jUp = MMSlideDelView.bSe();
    this.kuE = null;
    this.uQY = parama;
    this.fBZ = ((MMActivity)paramContext);
    this.jZw = paramString;
    paramContext = new com.tencent.mm.ah.a.a.c.a();
    paramContext.hIw = com.tencent.mm.modelbiz.a.e.iA(this.jZw);
    paramContext.hIt = true;
    paramContext.hIP = true;
    paramContext.hII = R.k.ber;
    this.kuE = paramContext.Hh();
    GMTrace.o(2968225054720L, 22115);
  }
  
  public final void OL()
  {
    GMTrace.i(2968359272448L, 22116);
    aEP();
    d locald = w.DJ();
    Object localObject = this.jZw;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from BizChatInfo");
    localStringBuilder.append(" where brandUserName = '").append((String)localObject).append("'");
    localStringBuilder.append(" and (bitFlag & 8").append(") != 0 ");
    localObject = localStringBuilder.append(" order by ");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" case when length(BizChatInfo.chatNamePY) > 0 then upper(").append("BizChatInfo.chatNamePY) ");
    localStringBuffer.append(" else upper(BizChatInfo.chatName) end asc, ");
    localStringBuffer.append(" upper(BizChatInfo.chatNamePY) asc, ");
    localStringBuffer.append(" upper(BizChatInfo.chatName) asc ");
    ((StringBuilder)localObject).append(localStringBuffer.toString());
    v.d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", new Object[] { localStringBuilder.toString() });
    setCursor(locald.gUp.rawQuery(localStringBuilder.toString(), null));
    if (this.uQY != null) {
      this.uQY.OI();
    }
    super.notifyDataSetChanged();
    GMTrace.o(2968359272448L, 22116);
  }
  
  protected final void OM()
  {
    GMTrace.i(2969433014272L, 22124);
    OL();
    GMTrace.o(2969433014272L, 22124);
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    GMTrace.i(2969567232000L, 22125);
    super.a(paramInt, paramm, paramObject);
    GMTrace.o(2969567232000L, 22125);
  }
  
  public final void a(MMSlideDelView.c paramc)
  {
    GMTrace.i(2968896143360L, 22120);
    this.jUn = paramc;
    GMTrace.o(2968896143360L, 22120);
  }
  
  public final void a(MMSlideDelView.e parame)
  {
    GMTrace.i(2968761925632L, 22119);
    this.jUo = parame;
    GMTrace.o(2968761925632L, 22119);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    GMTrace.i(2968627707904L, 22118);
    this.jUm = paramf;
    GMTrace.o(2968627707904L, 22118);
  }
  
  public final int getItemViewType(int paramInt)
  {
    GMTrace.i(2969030361088L, 22121);
    GMTrace.o(2969030361088L, 22121);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(2969298796544L, 22123);
    com.tencent.mm.modelbiz.a.c localc = (com.tencent.mm.modelbiz.a.c)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = View.inflate(this.fBZ, R.i.daZ, null);
      paramView.ipb = ((ImageView)localView.findViewById(R.h.bqF));
      paramView.jUr = ((TextView)localView.findViewById(R.h.cmf));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      n.GX().a(localc.field_headImageUrl, paramViewGroup.ipb, this.kuE);
      paramViewGroup.jUr.setText(h.c(this.fBZ, localc.field_chatName, (int)paramViewGroup.jUr.getTextSize()));
      GMTrace.o(2969298796544L, 22123);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public final int getViewTypeCount()
  {
    GMTrace.i(2968493490176L, 22117);
    GMTrace.o(2968493490176L, 22117);
    return 1;
  }
  
  public final void onPause()
  {
    GMTrace.i(2969164578816L, 22122);
    if (this.jUp != null) {
      this.jUp.aFa();
    }
    GMTrace.o(2969164578816L, 22122);
  }
  
  public static final class a
  {
    public ImageView ipb;
    public TextView jUr;
    
    public a()
    {
      GMTrace.i(2991310503936L, 22287);
      GMTrace.o(2991310503936L, 22287);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bizchat/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */