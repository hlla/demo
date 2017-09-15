package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public final class MMGridPaperGridView
  extends GridView
{
  private int mCount;
  int mIndex;
  private AdapterView.OnItemClickListener qSP;
  private j viA;
  private AdapterView.OnItemLongClickListener viB;
  private int viu;
  private int viv;
  private int viw;
  private int vix;
  private boolean viy;
  a viz;
  
  public MMGridPaperGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3184449814528L, 23726);
    this.vix = -1;
    this.viy = false;
    this.qSP = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(3309003866112L, 24654);
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          v.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
          GMTrace.o(3309003866112L, 24654);
          return;
        }
        GMTrace.o(3309003866112L, 24654);
      }
    };
    this.viB = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(3268201676800L, 24350);
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          v.w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
          GMTrace.o(3268201676800L, 24350);
          return false;
        }
        GMTrace.o(3268201676800L, 24350);
        return false;
      }
    };
    GMTrace.o(3184449814528L, 23726);
  }
  
  public MMGridPaperGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(3184315596800L, 23725);
    this.vix = -1;
    this.viy = false;
    this.qSP = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(3309003866112L, 24654);
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          v.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
          GMTrace.o(3309003866112L, 24654);
          return;
        }
        GMTrace.o(3309003866112L, 24654);
      }
    };
    this.viB = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(3268201676800L, 24350);
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          v.w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
          GMTrace.o(3268201676800L, 24350);
          return false;
        }
        GMTrace.o(3268201676800L, 24350);
        return false;
      }
    };
    GMTrace.o(3184315596800L, 23725);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, j paramj)
  {
    GMTrace.i(3184584032256L, 23727);
    if (paramj == null) {}
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.MMGridPaperGridView", "index[%d], rows[%d], columns[%d], adapter is null[%B]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
      this.mIndex = paramInt1;
      this.viu = paramInt2;
      this.viv = paramInt3;
      this.viA = paramj;
      this.mCount = (this.viu * this.viv);
      this.viw = (this.mIndex * this.mCount);
      if ((this.viA != null) && (this.viA.getCount() - this.viw < this.mCount)) {
        this.mCount = (this.viA.getCount() - this.viw);
      }
      if (getAdapter() == null)
      {
        v.w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
        this.viz = new a((byte)0);
        setAdapter(this.viz);
      }
      setNumColumns(this.viv);
      setColumnWidth(3);
      setOnItemClickListener(this.qSP);
      setOnItemLongClickListener(this.viB);
      GMTrace.o(3184584032256L, 23727);
      return;
    }
  }
  
  private final class a
    extends BaseAdapter
  {
    private a()
    {
      GMTrace.i(3186865733632L, 23744);
      GMTrace.o(3186865733632L, 23744);
    }
    
    public final int getCount()
    {
      GMTrace.i(3187402604544L, 23748);
      if ((MMGridPaperGridView.c(MMGridPaperGridView.this) < 0) || (MMGridPaperGridView.a(MMGridPaperGridView.this) == null))
      {
        GMTrace.o(3187402604544L, 23748);
        return 0;
      }
      int i = MMGridPaperGridView.c(MMGridPaperGridView.this);
      GMTrace.o(3187402604544L, 23748);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      GMTrace.i(3187536822272L, 23749);
      if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
      {
        GMTrace.o(3187536822272L, 23749);
        return null;
      }
      Object localObject = MMGridPaperGridView.a(MMGridPaperGridView.this).getItem(MMGridPaperGridView.b(MMGridPaperGridView.this) + paramInt);
      GMTrace.o(3187536822272L, 23749);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(3187671040000L, 23750);
      if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
      {
        GMTrace.o(3187671040000L, 23750);
        return 0L;
      }
      long l = MMGridPaperGridView.a(MMGridPaperGridView.this).getItemId(MMGridPaperGridView.b(MMGridPaperGridView.this) + paramInt);
      GMTrace.o(3187671040000L, 23750);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      GMTrace.i(3187134169088L, 23746);
      GMTrace.o(3187134169088L, 23746);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(3187805257728L, 23751);
      long l = bf.NB();
      int i = MMGridPaperGridView.d(MMGridPaperGridView.this);
      boolean bool;
      if (paramView == null)
      {
        bool = true;
        v.v("MicroMsg.MMGridPaperGridView", "getView:index[%d], pos[%d], converrView is null[%B], parent is [%s], mClearMode[%B]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Boolean.valueOf(bool), paramViewGroup.toString(), Boolean.valueOf(MMGridPaperGridView.e(MMGridPaperGridView.this)) });
        if (MMGridPaperGridView.e(MMGridPaperGridView.this)) {
          paramView = null;
        }
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) != null) {
          break label222;
        }
        paramView = null;
        label108:
        if (paramView == null) {
          break label246;
        }
        bool = true;
        label115:
        Assert.assertTrue(bool);
        if ((-1 == MMGridPaperGridView.f(MMGridPaperGridView.this)) || (MMGridPaperGridView.b(MMGridPaperGridView.this) + paramInt != MMGridPaperGridView.f(MMGridPaperGridView.this))) {
          break label252;
        }
        paramView.setVisibility(4);
      }
      for (;;)
      {
        v.v("MicroMsg.MMGridPaperGridView", "get View ok: use %d ms, hidden index[%d], cur global index[%d]", new Object[] { Long.valueOf(bf.aB(l)), Integer.valueOf(MMGridPaperGridView.f(MMGridPaperGridView.this)), Integer.valueOf(MMGridPaperGridView.b(MMGridPaperGridView.this) + paramInt) });
        GMTrace.o(3187805257728L, 23751);
        return paramView;
        bool = false;
        break;
        label222:
        paramView = MMGridPaperGridView.a(MMGridPaperGridView.this).c(MMGridPaperGridView.b(MMGridPaperGridView.this) + paramInt, paramView);
        break label108;
        label246:
        bool = false;
        break label115;
        label252:
        paramView.setVisibility(0);
      }
    }
    
    public final int getViewTypeCount()
    {
      GMTrace.i(3187268386816L, 23747);
      GMTrace.o(3187268386816L, 23747);
      return 1;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      GMTrace.i(3186999951360L, 23745);
      if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
      {
        GMTrace.o(3186999951360L, 23745);
        return false;
      }
      GMTrace.o(3186999951360L, 23745);
      return true;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/MMGridPaperGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */