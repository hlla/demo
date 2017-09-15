package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.bg.a;
import com.tencent.mm.bi.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.List;

public final class h
  extends BaseAdapter
{
  private List<String> ipq;
  private Context mContext;
  private List<String> sLK;
  
  public h(Context paramContext, List<String> paramList1, List<String> paramList2)
  {
    GMTrace.i(967709818880L, 7210);
    this.mContext = paramContext;
    this.ipq = paramList2;
    this.sLK = paramList1;
    GMTrace.o(967709818880L, 7210);
  }
  
  private static a cQ(View paramView)
  {
    GMTrace.i(968380907520L, 7215);
    a locala = new a();
    locala.ipb = ((ImageView)paramView.findViewById(R.h.bza));
    locala.kxz = ((TextView)paramView.findViewById(R.h.bzd));
    paramView.setTag(locala);
    GMTrace.o(968380907520L, 7215);
    return locala;
  }
  
  public final int getCount()
  {
    GMTrace.i(967844036608L, 7211);
    int i = this.ipq.size();
    GMTrace.o(967844036608L, 7211);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    GMTrace.i(967978254336L, 7212);
    Object localObject = this.ipq.get(paramInt);
    GMTrace.o(967978254336L, 7212);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    GMTrace.i(968112472064L, 7213);
    long l = paramInt;
    GMTrace.o(968112472064L, 7213);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(968246689792L, 7214);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, R.i.cXb, null);
      paramViewGroup = cQ(paramView);
    }
    label247:
    label261:
    for (;;)
    {
      int i = this.ipq.size();
      if ((paramInt >= 0) && (paramInt < this.ipq.size()) && (paramInt < this.sLK.size()))
      {
        paramViewGroup.ipb.setVisibility(0);
        paramViewGroup.kxz.setVisibility(0);
        a.b.a(paramViewGroup.ipb, (String)this.sLK.get(paramInt));
        paramViewGroup.kxz.setText((CharSequence)this.ipq.get(paramInt));
        paramViewGroup.kxz.setText(g.bKx().d(this.mContext, (CharSequence)this.ipq.get(paramInt), paramViewGroup.kxz.getTextSize()));
        if ((this.ipq.size() <= 12) || (paramInt < this.ipq.size() - i % 4)) {
          break label247;
        }
        paramViewGroup.kxz.setPadding(0, 0, 0, a.T(this.mContext, R.f.aWT));
      }
      for (;;)
      {
        GMTrace.o(968246689792L, 7214);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        if (paramViewGroup != null) {
          break label261;
        }
        paramViewGroup = cQ(paramView);
        break;
        paramViewGroup.kxz.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  private static final class a
  {
    public ImageView ipb;
    public TextView kxz;
    
    public a()
    {
      GMTrace.i(947845595136L, 7062);
      GMTrace.o(947845595136L, 7062);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/applet/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */