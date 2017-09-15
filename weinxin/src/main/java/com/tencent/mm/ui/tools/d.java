package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.u;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends BaseAdapter
{
  private Context context;
  private List<c> fRA;
  private String isc;
  private List<c> mRL;
  int[] mRN;
  boolean mRO;
  
  public d(Context paramContext, List<c> paramList)
  {
    GMTrace.i(2013802790912L, 15004);
    this.mRL = new ArrayList();
    this.mRO = false;
    this.context = paramContext;
    this.fRA = paramList;
    aEU();
    aEV();
    GMTrace.o(2013802790912L, 15004);
  }
  
  private void aEU()
  {
    GMTrace.i(2013937008640L, 15005);
    int i = 0;
    int j = this.fRA.size();
    while (i < j)
    {
      this.mRL.add(this.fRA.get(i));
      i += 1;
    }
    GMTrace.o(2013937008640L, 15005);
  }
  
  private void aEV()
  {
    GMTrace.i(2014071226368L, 15006);
    this.mRN = new int[this.fRA.size()];
    int j = this.fRA.size();
    int i = 0;
    while (i < j)
    {
      this.mRN[i] = ((c)this.fRA.get(i)).mPF;
      i += 1;
    }
    GMTrace.o(2014071226368L, 15006);
  }
  
  private static String ol(int paramInt)
  {
    GMTrace.i(2014876532736L, 15012);
    if (u.bIB())
    {
      String str = Integer.toString(paramInt) + "劃";
      GMTrace.o(2014876532736L, 15012);
      return str;
    }
    char c = (char)paramInt;
    GMTrace.o(2014876532736L, 15012);
    return String.valueOf(c);
  }
  
  public final int getCount()
  {
    GMTrace.i(2014205444096L, 15007);
    int i = this.fRA.size();
    GMTrace.o(2014205444096L, 15007);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    GMTrace.i(2014339661824L, 15008);
    Object localObject = this.fRA.get(paramInt);
    GMTrace.o(2014339661824L, 15008);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    GMTrace.i(2014473879552L, 15009);
    long l = paramInt;
    GMTrace.o(2014473879552L, 15009);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(2014742315008L, 15011);
    c localc = (c)getItem(paramInt);
    label96:
    int i;
    if (paramView == null) {
      if (!u.bIB())
      {
        paramView = View.inflate(this.context, R.i.cZJ, null);
        paramViewGroup = new a();
        paramViewGroup.mRQ = ((TextView)paramView.findViewById(R.h.bGd));
        paramViewGroup.jXN = ((TextView)paramView.findViewById(R.h.bGf));
        paramViewGroup.mRR = ((TextView)paramView.findViewById(R.h.bGi));
        paramView.setTag(paramViewGroup);
        if (paramInt <= 0) {
          break label214;
        }
        i = this.mRN[(paramInt - 1)];
        label110:
        if (paramInt != 0) {
          break label220;
        }
        paramViewGroup.mRQ.setVisibility(0);
        paramViewGroup.mRQ.setText(ol(this.mRN[paramInt]));
        label138:
        paramViewGroup.jXN.setText(localc.hJn);
        paramViewGroup.mRR.setText(localc.countryCode);
        if (!this.mRO) {
          break label274;
        }
        paramViewGroup.mRR.setVisibility(0);
      }
    }
    for (;;)
    {
      GMTrace.o(2014742315008L, 15011);
      return paramView;
      paramView = View.inflate(this.context, R.i.cZK, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label96;
      label214:
      i = -1;
      break label110;
      label220:
      if ((paramInt > 0) && (this.mRN[paramInt] != i))
      {
        paramViewGroup.mRQ.setVisibility(0);
        paramViewGroup.mRQ.setText(ol(this.mRN[paramInt]));
        break label138;
      }
      paramViewGroup.mRQ.setVisibility(8);
      break label138;
      label274:
      paramViewGroup.mRR.setVisibility(4);
    }
  }
  
  public final void yB(String paramString)
  {
    GMTrace.i(2014608097280L, 15010);
    if (paramString != null)
    {
      this.isc = paramString.trim();
      this.fRA.clear();
      int j = this.mRL.size();
      int i = 0;
      while (i < j)
      {
        if ((((c)this.mRL.get(i)).hJn.toUpperCase().contains(this.isc.toUpperCase())) || (((c)this.mRL.get(i)).mPG.toUpperCase().contains(this.isc.toUpperCase())) || (((c)this.mRL.get(i)).countryCode.contains(this.isc))) {
          this.fRA.add(this.mRL.get(i));
        }
        i += 1;
      }
      aEV();
      super.notifyDataSetChanged();
    }
    GMTrace.o(2014608097280L, 15010);
  }
  
  static final class a
  {
    TextView jXN;
    TextView mRQ;
    TextView mRR;
    
    a()
    {
      GMTrace.i(1956223385600L, 14575);
      GMTrace.o(1956223385600L, 14575);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */