package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.k;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r;

public final class m
  extends q
{
  public LayoutInflater Du;
  public n.c qHD;
  public n.d qHE;
  public l qHF;
  public boolean qxx;
  public n.a wkZ;
  public n.b wla;
  private a wle;
  
  public m(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(1910992011264L, 14238);
    this.qxx = true;
    this.Du = r.eC(paramContext);
    this.qHF = new l();
    GMTrace.o(1910992011264L, 14238);
  }
  
  protected final BaseAdapter aew()
  {
    GMTrace.i(1911394664448L, 14241);
    if (this.wle == null) {
      this.wle = new a((byte)0);
    }
    a locala = this.wle;
    GMTrace.o(1911394664448L, 14241);
    return locala;
  }
  
  public final boolean dL()
  {
    GMTrace.i(1911126228992L, 14239);
    if (this.qHD != null) {
      this.qHD.a(this.qHF);
    }
    if ((this.qHF.Qz != null) && (this.qHF.Qz.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.qxx = bool;
      bool = super.dL();
      GMTrace.o(1911126228992L, 14239);
      return bool;
    }
  }
  
  public final CharSequence getTitle()
  {
    GMTrace.i(16088679055360L, 119870);
    if ((this.qHF.Qz == null) || (this.qHF.Qz.length() == 0))
    {
      localObject = this.mContext.getResources().getString(a.k.heS);
      GMTrace.o(16088679055360L, 119870);
      return (CharSequence)localObject;
    }
    Object localObject = this.qHF.Qz;
    GMTrace.o(16088679055360L, 119870);
    return (CharSequence)localObject;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    GMTrace.i(1911260446720L, 14240);
    if ((this.qxx) && (paramInt == 0))
    {
      GMTrace.o(1911260446720L, 14240);
      return;
    }
    int i = paramInt;
    if (this.qxx) {
      i = paramInt - 1;
    }
    if (this.qHE != null) {
      this.qHE.c(this.qHF.getItem(i), i);
    }
    dismiss();
    GMTrace.o(1911260446720L, 14240);
  }
  
  private final class a
    extends BaseAdapter
  {
    private a()
    {
      GMTrace.i(1948572975104L, 14518);
      GMTrace.o(1948572975104L, 14518);
    }
    
    public final int getCount()
    {
      GMTrace.i(1948707192832L, 14519);
      if (m.this.qxx)
      {
        i = m.this.qHF.size();
        GMTrace.o(1948707192832L, 14519);
        return i + 1;
      }
      int i = m.this.qHF.size();
      GMTrace.o(1948707192832L, 14519);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      GMTrace.i(1948841410560L, 14520);
      GMTrace.o(1948841410560L, 14520);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(1948975628288L, 14521);
      GMTrace.o(1948975628288L, 14521);
      return 0L;
    }
    
    public final int getItemViewType(int paramInt)
    {
      GMTrace.i(1949109846016L, 14522);
      if (m.this.qxx)
      {
        if (paramInt == 0)
        {
          GMTrace.o(1949109846016L, 14522);
          return 0;
        }
        GMTrace.o(1949109846016L, 14522);
        return 1;
      }
      GMTrace.o(1949109846016L, 14522);
      return 1;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(1949378281472L, 14524);
      if ((m.this.qxx) && (paramInt == 0)) {
        if (paramView == null)
        {
          paramView = m.this.Du.inflate(a.h.hev, paramViewGroup, false);
          paramViewGroup = new a();
          paramViewGroup.iUi = ((TextView)paramView.findViewById(a.g.title));
          paramViewGroup.jiQ = ((ImageView)paramView.findViewById(a.g.icon));
          paramView.setTag(paramViewGroup);
          paramViewGroup.iUi.setText(m.this.getTitle());
        }
      }
      for (;;)
      {
        GMTrace.o(1949378281472L, 14524);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        int i = paramInt;
        if (m.this.qxx) {
          i = paramInt - 1;
        }
        label212:
        MenuItem localMenuItem;
        if (paramView == null)
        {
          paramView = m.this.Du.inflate(a.h.dji, paramViewGroup, false);
          paramViewGroup = new a();
          paramViewGroup.iUi = ((TextView)paramView.findViewById(a.g.title));
          paramViewGroup.jiQ = ((ImageView)paramView.findViewById(a.g.icon));
          paramViewGroup.qkq = paramView.findViewById(a.g.cze);
          paramView.setTag(paramViewGroup);
          localMenuItem = m.this.qHF.getItem(i);
          paramViewGroup.iUi.setText(localMenuItem.getTitle());
          if (localMenuItem.getIcon() == null) {
            break label341;
          }
          paramViewGroup.jiQ.setVisibility(0);
          paramViewGroup.jiQ.setImageDrawable(localMenuItem.getIcon());
        }
        for (;;)
        {
          if (m.this.wla != null) {
            m.this.wla.a(paramViewGroup.iUi, localMenuItem);
          }
          if (i != m.this.qHF.size() - 1) {
            break label392;
          }
          paramViewGroup.qkq.setBackgroundResource(a.f.bkn);
          break;
          paramViewGroup = (a)paramView.getTag();
          break label212;
          label341:
          if (m.this.wkZ != null)
          {
            paramViewGroup.jiQ.setVisibility(0);
            m.this.wkZ.a(paramViewGroup.jiQ, localMenuItem);
          }
          else
          {
            paramViewGroup.jiQ.setVisibility(8);
          }
        }
        label392:
        paramViewGroup.qkq.setBackgroundResource(a.f.bkm);
      }
    }
    
    public final int getViewTypeCount()
    {
      GMTrace.i(1949244063744L, 14523);
      if (m.this.qxx)
      {
        GMTrace.o(1949244063744L, 14523);
        return 2;
      }
      GMTrace.o(1949244063744L, 14523);
      return 1;
    }
    
    private final class a
    {
      TextView iUi;
      ImageView jiQ;
      View qkq;
      
      public a()
      {
        GMTrace.i(1995012308992L, 14864);
        GMTrace.o(1995012308992L, 14864);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */