package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import junit.framework.Assert;

public abstract class n
  extends BaseAdapter
{
  public int scene;
  private SparseArray<a> uxh;
  public l vWg;
  private boolean vWh;
  boolean vWi;
  
  public n(l paraml, boolean paramBoolean, int paramInt)
  {
    this(paraml, paramBoolean, paramInt, false);
    GMTrace.i(1718523789312L, 12804);
    GMTrace.o(1718523789312L, 12804);
  }
  
  public n(l paraml, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    GMTrace.i(16857746636800L, 125600);
    this.vWg = paraml;
    this.vWh = paramBoolean1;
    this.uxh = new SparseArray();
    this.scene = paramInt;
    this.vWi = paramBoolean2;
    GMTrace.o(16857746636800L, 125600);
  }
  
  public final a BG(int paramInt)
  {
    GMTrace.i(1718926442496L, 12807);
    a locala = null;
    if (this.uxh.indexOfKey(paramInt) >= 0) {
      locala = (a)this.uxh.get(paramInt);
    }
    for (;;)
    {
      GMTrace.o(1718926442496L, 12807);
      return locala;
      if ((paramInt >= 0) && (paramInt < getCount()))
      {
        locala = hf(paramInt);
        if (locala != null)
        {
          locala.jYD = c(locala);
          this.uxh.put(paramInt, locala);
          v.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", new Object[] { Integer.valueOf(locala.klJ), Integer.valueOf(paramInt) });
        }
        else
        {
          v.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
      else
      {
        v.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
  }
  
  public boolean BH(int paramInt)
  {
    GMTrace.i(1720134402048L, 12816);
    GMTrace.o(1720134402048L, 12816);
    return false;
  }
  
  public boolean bcI()
  {
    GMTrace.i(1718658007040L, 12805);
    boolean bool = this.vWh;
    GMTrace.o(1718658007040L, 12805);
    return bool;
  }
  
  protected boolean c(a parama)
  {
    GMTrace.i(1719194877952L, 12809);
    GMTrace.o(1719194877952L, 12809);
    return false;
  }
  
  public final void clearCache()
  {
    GMTrace.i(1719865966592L, 12814);
    if (this.uxh != null) {
      this.uxh.clear();
    }
    GMTrace.o(1719865966592L, 12814);
  }
  
  public void finish()
  {
    GMTrace.i(1720000184320L, 12815);
    clearCache();
    GMTrace.o(1720000184320L, 12815);
  }
  
  public long getItemId(int paramInt)
  {
    GMTrace.i(1719329095680L, 12810);
    GMTrace.o(1719329095680L, 12810);
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    GMTrace.i(1719463313408L, 12811);
    if (BG(paramInt) != null)
    {
      paramInt = BG(paramInt).klJ;
      GMTrace.o(1719463313408L, 12811);
      return paramInt;
    }
    v.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    GMTrace.o(1719463313408L, 12811);
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(1719731748864L, 12813);
    a locala = BG(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.Oc().a(this.vWg.getActivity(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    Assert.assertNotNull(paramView);
    if (!locala.vYk)
    {
      locala.br(this.vWg.getActivity());
      locala.vYk = true;
    }
    locala.vWh = bcI();
    locala.Oc().a(this.vWg.getActivity(), paramView, locala, this.vWg.b(locala), this.vWg.a(locala));
    GMTrace.o(1719731748864L, 12813);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    GMTrace.i(1719597531136L, 12812);
    GMTrace.o(1719597531136L, 12812);
    return 8;
  }
  
  public abstract a hf(int paramInt);
  
  public final void lv(boolean paramBoolean)
  {
    GMTrace.i(1718792224768L, 12806);
    this.vWh = paramBoolean;
    notifyDataSetChanged();
    GMTrace.o(1718792224768L, 12806);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */