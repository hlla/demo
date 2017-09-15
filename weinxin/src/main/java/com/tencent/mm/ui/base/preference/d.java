package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.ui.r;
import java.util.HashMap;
import junit.framework.Assert;

final class d
  extends BaseAdapter
{
  private final Context context;
  protected int opj;
  private final int style;
  protected String value;
  protected final HashMap<CharSequence, c> values;
  protected CharSequence[] voC;
  protected CharSequence[] voD;
  
  public d(Context paramContext)
  {
    GMTrace.i(3210488053760L, 23920);
    this.opj = -1;
    this.values = new HashMap();
    this.context = paramContext;
    this.style = 1;
    GMTrace.o(3210488053760L, 23920);
  }
  
  protected final void bSL()
  {
    int i = 0;
    GMTrace.i(3210622271488L, 23921);
    if (this.voC == null) {
      this.voC = new CharSequence[0];
    }
    if (this.voD == null) {
      this.voD = new CharSequence[0];
    }
    if (this.voC.length == this.voD.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.voD.length)
      {
        c localc = new c(this.voC[i], 1048576 + i);
        this.values.put(this.voD[i], localc);
        i += 1;
      }
    }
    GMTrace.o(3210622271488L, 23921);
  }
  
  public final int getCount()
  {
    GMTrace.i(3210756489216L, 23922);
    int i = this.voD.length;
    GMTrace.o(3210756489216L, 23922);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    GMTrace.i(3210890706944L, 23923);
    GMTrace.o(3210890706944L, 23923);
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    GMTrace.i(3211024924672L, 23924);
    GMTrace.o(3211024924672L, 23924);
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(3211159142400L, 23925);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = r.eC(this.context).inflate(a.h.diR, null);
      paramView = new a();
      paramView.opk = ((TextView)paramViewGroup.findViewById(a.g.text));
      paramView.opl = ((CheckBox)paramViewGroup.findViewById(a.g.bBW));
      paramView.opm = ((RadioButton)paramViewGroup.findViewById(a.g.cuU));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    paramView.opk.setText(this.voC[paramInt]);
    switch (this.style)
    {
    default: 
      paramView.opl.setVisibility(8);
      paramView.opm.setVisibility(8);
    }
    for (;;)
    {
      GMTrace.o(3211159142400L, 23925);
      return paramViewGroup;
      paramView.opl.setVisibility(8);
      paramView.opm.setVisibility(0);
      paramView.opm.setChecked(this.voD[paramInt].equals(this.value));
      continue;
      paramView.opl.setVisibility(0);
      paramView.opm.setVisibility(8);
      paramView.opl.setChecked(this.voD[paramInt].equals(this.value));
    }
  }
  
  static final class a
  {
    TextView opk;
    CheckBox opl;
    RadioButton opm;
    
    a()
    {
      GMTrace.i(3208609005568L, 23906);
      GMTrace.o(3208609005568L, 23906);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/preference/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */