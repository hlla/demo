package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.a.a.a;
import android.support.v7.a.a.d;
import android.support.v7.a.a.h;
import android.support.v7.widget.ListPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class k
  implements l, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  static final int Rg = a.h.KL;
  public final LayoutInflater Du;
  public l.a QM;
  public boolean Qh;
  private final a Rh;
  public final boolean Ri;
  private final int Rj;
  private final int Rk;
  private final int Rl;
  public ListPopupWindow Rm;
  private ViewTreeObserver Rn;
  private ViewGroup Ro;
  private boolean Rp;
  private int Rq;
  public int Rr = 0;
  public final f dW;
  public View hz;
  private final Context mContext;
  
  private k(Context paramContext, f paramf, View paramView)
  {
    this(paramContext, paramf, paramView, false, a.a.popupMenuStyle);
  }
  
  public k(Context paramContext, f paramf, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramf, paramView, paramBoolean, paramInt, (byte)0);
  }
  
  private k(Context paramContext, f paramf, View paramView, boolean paramBoolean, int paramInt, byte paramByte)
  {
    this.mContext = paramContext;
    this.Du = LayoutInflater.from(paramContext);
    this.dW = paramf;
    this.Rh = new a(this.dW);
    this.Ri = paramBoolean;
    this.Rk = paramInt;
    this.Rl = 0;
    Resources localResources = paramContext.getResources();
    this.Rj = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(a.d.IS));
    this.hz = paramView;
    paramf.a(this, paramContext);
  }
  
  public final boolean B()
  {
    return false;
  }
  
  public final void a(Context paramContext, f paramf) {}
  
  public final void a(f paramf, boolean paramBoolean)
  {
    if (paramf != this.dW) {}
    do
    {
      return;
      dismiss();
    } while (this.QM == null);
    this.QM.a(paramf, paramBoolean);
  }
  
  public final boolean a(p paramp)
  {
    k localk;
    int i;
    if (paramp.hasVisibleItems())
    {
      localk = new k(this.mContext, paramp, this.hz);
      localk.QM = this.QM;
      int j = paramp.size();
      i = 0;
      if (i >= j) {
        break label120;
      }
      MenuItem localMenuItem = paramp.getItem(i);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {}
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      localk.Qh = bool;
      if (localk.dL())
      {
        if (this.QM != null) {
          this.QM.d(paramp);
        }
        return true;
        i += 1;
        break;
      }
      return false;
    }
  }
  
  public final boolean b(h paramh)
  {
    return false;
  }
  
  public final boolean c(h paramh)
  {
    return false;
  }
  
  public final boolean dL()
  {
    int m = 0;
    this.Rm = new ListPopupWindow(this.mContext, null, this.Rk, this.Rl);
    this.Rm.setOnDismissListener(this);
    this.Rm.Yi = this;
    this.Rm.setAdapter(this.Rh);
    this.Rm.fe();
    View localView = this.hz;
    int i;
    int j;
    if (localView != null)
    {
      if (this.Rn == null) {}
      for (i = 1;; i = 0)
      {
        this.Rn = localView.getViewTreeObserver();
        if (i != 0) {
          this.Rn.addOnGlobalLayoutListener(this);
        }
        this.Rm.Yg = localView;
        this.Rm.Rr = this.Rr;
        if (!this.Rp)
        {
          a locala = this.Rh;
          int n = View.MeasureSpec.makeMeasureSpec(0, 0);
          int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
          int i2 = locala.getCount();
          j = 0;
          int k = 0;
          localView = null;
          i = m;
          m = i;
          if (j < i2)
          {
            m = locala.getItemViewType(j);
            if (m == k) {
              break label340;
            }
            k = m;
            localView = null;
            label199:
            if (this.Ro == null) {
              this.Ro = new FrameLayout(this.mContext);
            }
            localView = locala.getView(j, localView, this.Ro);
            localView.measure(n, i1);
            m = localView.getMeasuredWidth();
            if (m < this.Rj) {
              break;
            }
            m = this.Rj;
          }
          this.Rq = m;
          this.Rp = true;
        }
        this.Rm.setContentWidth(this.Rq);
        this.Rm.ff();
        this.Rm.show();
        this.Rm.XV.setOnKeyListener(this);
        return true;
      }
    }
    return false;
    if (m > i) {
      i = m;
    }
    for (;;)
    {
      j += 1;
      break;
      label340:
      break label199;
    }
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.Rm.dismiss();
    }
  }
  
  public final void f(boolean paramBoolean)
  {
    this.Rp = false;
    if (this.Rh != null) {
      this.Rh.notifyDataSetChanged();
    }
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final boolean isShowing()
  {
    return (this.Rm != null) && (this.Rm.XU.isShowing());
  }
  
  public void onDismiss()
  {
    this.Rm = null;
    this.dW.close();
    if (this.Rn != null)
    {
      if (!this.Rn.isAlive()) {
        this.Rn = this.hz.getViewTreeObserver();
      }
      this.Rn.removeGlobalOnLayoutListener(this);
      this.Rn = null;
    }
  }
  
  public void onGlobalLayout()
  {
    if (isShowing())
    {
      View localView = this.hz;
      if ((localView != null) && (localView.isShown())) {
        break label28;
      }
      dismiss();
    }
    label28:
    while (!isShowing()) {
      return;
    }
    this.Rm.show();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.Rh;
    a.a(paramAdapterView).a(paramAdapterView.ax(paramInt), null, 0);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public final Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  private final class a
    extends BaseAdapter
  {
    private int Qm = -1;
    private f Rs;
    
    public a(f paramf)
    {
      this.Rs = paramf;
      dr();
    }
    
    private void dr()
    {
      h localh = k.this.dW.QI;
      if (localh != null)
      {
        ArrayList localArrayList = k.this.dW.dB();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((h)localArrayList.get(i) == localh)
          {
            this.Qm = i;
            return;
          }
          i += 1;
        }
      }
      this.Qm = -1;
    }
    
    public final h ax(int paramInt)
    {
      if (k.this.Ri) {}
      for (ArrayList localArrayList = this.Rs.dB();; localArrayList = this.Rs.dz())
      {
        int i = paramInt;
        if (this.Qm >= 0)
        {
          i = paramInt;
          if (paramInt >= this.Qm) {
            i = paramInt + 1;
          }
        }
        return (h)localArrayList.get(i);
      }
    }
    
    public final int getCount()
    {
      if (k.this.Ri) {}
      for (ArrayList localArrayList = this.Rs.dB(); this.Qm < 0; localArrayList = this.Rs.dz()) {
        return localArrayList.size();
      }
      return localArrayList.size() - 1;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = k.this.Du.inflate(k.Rg, paramViewGroup, false);
      }
      for (;;)
      {
        paramViewGroup = (m.a)paramView;
        if (k.this.Qh)
        {
          ListMenuItemView localListMenuItemView = (ListMenuItemView)paramView;
          localListMenuItemView.Qh = true;
          localListMenuItemView.Qf = true;
        }
        paramViewGroup.a(ax(paramInt));
        return paramView;
      }
    }
    
    public final void notifyDataSetChanged()
    {
      dr();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/menu/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */