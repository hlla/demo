package com.tencent.mm.ui.tools;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Iterator;
import java.util.List;

public final class l
  implements AdapterView.OnItemClickListener
{
  public LayoutInflater Du;
  private DialogInterface.OnDismissListener jqA;
  private Context mContext;
  public k qHC;
  public n.c qHD;
  public n.d qHE;
  public com.tencent.mm.ui.base.l qHF;
  private a wkY;
  public n.a wkZ;
  public n.b wla;
  
  public l(Context paramContext)
  {
    GMTrace.i(2049102053376L, 15267);
    this.mContext = paramContext;
    this.Du = LayoutInflater.from(paramContext);
    this.qHC = new k(paramContext);
    this.qHF = new com.tencent.mm.ui.base.l();
    GMTrace.o(2049102053376L, 15267);
  }
  
  public final void a(View paramView, int paramInt, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    GMTrace.i(2049370488832L, 15269);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).jba))
    {
      v.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
      GMTrace.o(2049370488832L, 15269);
      return;
    }
    this.qHF.clear();
    AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.qHF, paramView, localAdapterContextMenuInfo);
    paramView = this.qHF.vjl.iterator();
    while (paramView.hasNext()) {
      ((m)paramView.next()).vjo = localAdapterContextMenuInfo;
    }
    bkT();
    this.qHE = paramd;
    GMTrace.o(2049370488832L, 15269);
  }
  
  public final void a(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    GMTrace.i(2049236271104L, 15268);
    this.qHE = paramd;
    v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
    if ((paramView instanceof AbsListView))
    {
      v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(1957028691968L, 14581);
          l.this.qHF.clear();
          v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramOnCreateContextMenuListener.onCreateContextMenu(l.this.qHF, paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = l.this.qHF.vjl.iterator();
          while (paramAnonymousView.hasNext()) {
            ((m)paramAnonymousView.next()).vjo = paramAnonymousAdapterView;
          }
          l.this.bkT();
          GMTrace.o(1957028691968L, 14581);
          return true;
        }
      });
      GMTrace.o(2049236271104L, 15268);
      return;
    }
    if ((paramView instanceof MMWebView))
    {
      v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu for webview");
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          GMTrace.i(1959444611072L, 14599);
          v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
          l.this.qHF.clear();
          paramOnCreateContextMenuListener.onCreateContextMenu(l.this.qHF, paramAnonymousView, null);
          l.this.bkT();
          if (l.this.qHF.size() > 0)
          {
            GMTrace.o(1959444611072L, 14599);
            return true;
          }
          GMTrace.o(1959444611072L, 14599);
          return false;
        }
      });
      GMTrace.o(2049236271104L, 15268);
      return;
    }
    v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view");
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        GMTrace.i(1933137936384L, 14403);
        v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
        l.this.qHF.clear();
        paramOnCreateContextMenuListener.onCreateContextMenu(l.this.qHF, paramAnonymousView, null);
        l.this.bkT();
        GMTrace.o(1933137936384L, 14403);
        return true;
      }
    });
    GMTrace.o(2049236271104L, 15268);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    GMTrace.i(17518097858560L, 130520);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).jba))
    {
      v.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
      GMTrace.o(17518097858560L, 130520);
      return;
    }
    this.jqA = paramOnDismissListener;
    this.qHF.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.qHF, paramView, null);
    bkT();
    this.qHE = paramd;
    GMTrace.o(17518097858560L, 130520);
  }
  
  public final void b(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    GMTrace.i(2049504706560L, 15270);
    a(paramView, paramOnCreateContextMenuListener, paramd, null);
    GMTrace.o(2049504706560L, 15270);
  }
  
  public final Dialog bkT()
  {
    GMTrace.i(2050041577472L, 15274);
    if (this.qHD != null)
    {
      this.qHF.clear();
      this.qHF = new com.tencent.mm.ui.base.l();
      this.qHD.a(this.qHF);
    }
    if (this.qHF.bSa())
    {
      v.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
      GMTrace.o(2050041577472L, 15274);
      return null;
    }
    if (this.wkY == null) {
      this.wkY = new a((byte)0);
    }
    this.qHC.khv = this.wkY;
    this.qHC.sTD = this;
    this.qHC.setTitle(this.qHF.Qz);
    this.qHC.setOnDismissListener(this.jqA);
    this.qHC.show();
    k localk = this.qHC;
    GMTrace.o(2050041577472L, 15274);
    return localk;
  }
  
  public final void dismiss()
  {
    GMTrace.i(2049907359744L, 15273);
    if (this.qHC.isShowing()) {
      this.qHC.dismiss();
    }
    GMTrace.o(2049907359744L, 15273);
  }
  
  public final void e(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(2049638924288L, 15271);
    this.qHC.setOnCancelListener(paramOnCancelListener);
    GMTrace.o(2049638924288L, 15271);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    GMTrace.i(2049773142016L, 15272);
    paramAdapterView = (m)this.qHF.vjl.get(paramInt);
    if (paramAdapterView.performClick())
    {
      v.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
      dismiss();
      GMTrace.o(2049773142016L, 15272);
      return;
    }
    if (this.qHE != null) {
      this.qHE.c(paramAdapterView, paramInt);
    }
    dismiss();
    GMTrace.o(2049773142016L, 15272);
  }
  
  private final class a
    extends BaseAdapter
  {
    private a()
    {
      GMTrace.i(2051115319296L, 15282);
      GMTrace.o(2051115319296L, 15282);
    }
    
    public final int getCount()
    {
      GMTrace.i(2051249537024L, 15283);
      int i = l.this.qHF.size();
      GMTrace.o(2051249537024L, 15283);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      GMTrace.i(2051383754752L, 15284);
      GMTrace.o(2051383754752L, 15284);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(2051517972480L, 15285);
      GMTrace.o(2051517972480L, 15285);
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(2051652190208L, 15286);
      MenuItem localMenuItem;
      if (paramView == null)
      {
        paramView = l.this.Du.inflate(a.h.hea, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.iUi = ((TextView)paramView.findViewById(a.g.title));
        paramViewGroup.jiQ = ((ImageView)paramView.findViewById(a.g.icon));
        paramView.setTag(paramViewGroup);
        localMenuItem = l.this.qHF.getItem(paramInt);
        paramViewGroup.iUi.setText(localMenuItem.getTitle());
        Drawable localDrawable = l.this.qHF.getItem(paramInt).getIcon();
        if (localDrawable == null) {
          break label188;
        }
        paramViewGroup.jiQ.setVisibility(0);
        paramViewGroup.jiQ.setImageDrawable(localDrawable);
      }
      for (;;)
      {
        if (l.this.wla != null) {
          l.this.wla.a(paramViewGroup.iUi, localMenuItem);
        }
        GMTrace.o(2051652190208L, 15286);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label188:
        if (l.this.wkZ != null)
        {
          paramViewGroup.jiQ.setVisibility(0);
          l.this.wkZ.a(paramViewGroup.jiQ, localMenuItem);
        }
        else
        {
          paramViewGroup.jiQ.setVisibility(8);
        }
      }
    }
    
    private final class a
    {
      TextView iUi;
      ImageView jiQ;
      
      public a()
      {
        GMTrace.i(1959981481984L, 14603);
        GMTrace.o(1959981481984L, 14603);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */