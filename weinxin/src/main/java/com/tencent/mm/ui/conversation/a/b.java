package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.l.a.a;
import com.tencent.mm.ui.k;
import java.util.ArrayList;

public final class b
  extends k<c>
{
  private ArrayList<c> uZb;
  a wcI;
  
  public b(Context paramContext)
  {
    super(paramContext, null);
    GMTrace.i(14500614897664L, 108038);
    this.uZb = new ArrayList();
    this.wcI = null;
    OM();
    GMTrace.o(14500614897664L, 108038);
  }
  
  public final c BL(int paramInt)
  {
    GMTrace.i(14501151768576L, 108042);
    c localc = (c)this.uZb.get(paramInt);
    GMTrace.o(14501151768576L, 108042);
    return localc;
  }
  
  public final void OL()
  {
    GMTrace.i(14500883333120L, 108040);
    this.uZb.clear();
    if (this.wcI == null)
    {
      GMTrace.o(14500883333120L, 108040);
      return;
    }
    c localc = new c(this.wcI);
    this.uZb.add(localc);
    notifyDataSetChanged();
    GMTrace.o(14500883333120L, 108040);
  }
  
  protected final void OM()
  {
    GMTrace.i(14500749115392L, 108039);
    OL();
    GMTrace.o(14500749115392L, 108039);
  }
  
  public final int getCount()
  {
    GMTrace.i(14501017550848L, 108041);
    int i = this.uZb.size();
    GMTrace.o(14501017550848L, 108041);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(14501285986304L, 108043);
    c localc = (c)this.uZb.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.context, R.i.cTz, null);
      paramView = new d();
      paramView.wcK = localView;
      paramView.wcL = ((Button)localView.findViewById(R.h.bnl));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    while (localc.a(paramViewGroup) != 0)
    {
      GMTrace.o(14501285986304L, 108043);
      return null;
      paramViewGroup = (d)paramView.getTag();
      localView = paramView;
    }
    GMTrace.o(14501285986304L, 108043);
    return localView;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */