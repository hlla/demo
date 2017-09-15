package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.d;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.o;

public abstract class q
  implements View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private int Rj;
  private ViewTreeObserver Rn;
  private ViewGroup Ro;
  private int dividerHeight;
  private View hz;
  private boolean juJ;
  private BaseAdapter khv;
  protected Context mContext;
  private boolean shI;
  private MMListPopupWindow vyJ;
  private int vyK;
  private DialogInterface.OnCancelListener wmA;
  private PopupWindow.OnDismissListener wmB;
  private boolean wmC;
  private View wmD;
  private int wmE;
  private int wmF;
  private int wmG;
  private int wmH;
  private float wmI;
  private float wmJ;
  
  public q(Context paramContext)
  {
    GMTrace.i(1950183587840L, 14530);
    this.juJ = false;
    this.vyK = a.l.hfl;
    this.shI = false;
    this.wmC = true;
    this.wmF = 0;
    this.wmG = 0;
    this.wmH = 0;
    this.wmI = 0.0F;
    this.wmJ = 0.0F;
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.Rj = Math.min(paramContext.getDisplayMetrics().widthPixels * 4 / 5, paramContext.getDimensionPixelSize(a.e.IS));
    ViewGroup localViewGroup;
    if ((this.mContext instanceof Activity))
    {
      localViewGroup = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (localViewGroup.getChildCount() <= 0) {
        break label205;
      }
    }
    label205:
    for (this.hz = localViewGroup.getChildAt(0);; this.hz = localViewGroup)
    {
      this.dividerHeight = BackwardSupportUtil.b.a(this.mContext, 1.0F);
      this.wmF = (paramContext.getDimensionPixelSize(a.e.aXG) * 2);
      this.wmG = paramContext.getDimensionPixelSize(a.e.aXP);
      this.wmH = BackwardSupportUtil.b.a(this.mContext, 36.0F);
      this.khv = aew();
      GMTrace.o(1950183587840L, 14530);
      return;
    }
  }
  
  private boolean aKD()
  {
    GMTrace.i(1950720458752L, 14534);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels)
    {
      GMTrace.o(1950720458752L, 14534);
      return true;
    }
    GMTrace.o(1950720458752L, 14534);
    return false;
  }
  
  private int b(ListAdapter paramListAdapter)
  {
    GMTrace.i(1950988894208L, 14536);
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = paramListAdapter.getCount();
    int j = 0;
    int i = 0;
    View localView = null;
    int k = 0;
    if (j < i2)
    {
      int m = paramListAdapter.getItemViewType(j);
      if (m == i) {
        break label145;
      }
      localView = null;
      i = m;
    }
    label145:
    for (;;)
    {
      if (this.Ro == null) {
        this.Ro = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.Ro);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      GMTrace.o(1950988894208L, 14536);
      return k;
    }
  }
  
  public abstract BaseAdapter aew();
  
  public boolean dL()
  {
    GMTrace.i(1950586241024L, 14533);
    Object localObject1 = new Rect();
    int i;
    int j;
    Object localObject2;
    if ((this.mContext instanceof ActionBarActivity))
    {
      i = ((ActionBarActivity)this.mContext).cO().cP().getHeight();
      i -= this.mContext.getResources().getDimensionPixelSize(a.e.aXG);
      if (!(this.mContext instanceof Activity)) {
        break label981;
      }
      ((Activity)this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
      j = ((Activity)this.mContext).getWindow().getDecorView().getHeight();
      localObject2 = new int[2];
      ((Activity)this.mContext).getWindow().getDecorView().getLocationOnScreen((int[])localObject2);
      if ((j - ((Rect)localObject1).height() < 0) || (localObject2[1] <= 200)) {
        break label891;
      }
      i = j - ((Rect)localObject1).height() + i;
    }
    label159:
    label300:
    label455:
    label527:
    label891:
    label902:
    label908:
    label925:
    label966:
    label978:
    label981:
    for (;;)
    {
      this.shI = aKD();
      if ((this.vyJ == null) || (true == this.wmC)) {
        this.vyJ = new MMListPopupWindow(this.mContext, null, 0);
      }
      this.vyJ.setOnDismissListener(this);
      this.vyJ.Yi = this;
      this.vyJ.setAdapter(this.khv);
      this.vyJ.fe();
      this.vyJ.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.hbE));
      this.vyJ.setAnimationStyle(this.vyK);
      this.vyJ.XX = 0;
      this.vyJ.Yg = this.hz;
      boolean bool;
      if (this.hz != null)
      {
        if (this.Rn != null) {
          break label902;
        }
        bool = true;
        this.Rn = this.hz.getViewTreeObserver();
        v.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          this.Rn.addOnGlobalLayoutListener(this);
        }
      }
      this.vyJ.setVerticalOffset(i);
      this.vyJ.juJ = this.juJ;
      this.vyJ.setContentWidth(Math.min(b(this.khv), this.Rj));
      this.vyJ.ff();
      if ((this.wmI != 0.0F) && (this.wmJ != 0.0F))
      {
        localObject1 = new DisplayMetrics();
        ((Activity)this.mContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
          break label908;
        }
        i = 1;
        localObject1 = new Rect();
        ((Activity)this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
        j = ((Activity)this.mContext).getWindow().getDecorView().getHeight();
        if (j <= ((Rect)localObject1).height()) {
          break label978;
        }
        j = ((Rect)localObject1).height();
      }
      for (;;)
      {
        if (i != 0)
        {
          i = (int)(this.wmJ * j);
          v.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", new Object[] { Float.valueOf(this.wmI), Float.valueOf(this.wmJ), Integer.valueOf(((Rect)localObject1).height()), Integer.valueOf(j), Integer.valueOf(i) });
          i = Math.round(i / this.wmG);
          if ((i <= 0) || (this.khv == null)) {
            break label966;
          }
          j = this.wmG * i + this.wmF;
          if ((j == 0) || (j >= this.khv.getCount() * this.wmG)) {
            break label925;
          }
          j = this.wmG;
          int k = this.wmF;
          int m = this.wmH;
          this.vyJ.XW = ((i - 1) * j + k + m);
        }
        for (;;)
        {
          if ((this.vyJ != null) && (this.wmD != null))
          {
            localObject1 = this.vyJ;
            localObject2 = this.wmD;
            bool = ((MMListPopupWindow)localObject1).iuy.isShowing();
            if (bool) {
              ((MMListPopupWindow)localObject1).Zq();
            }
            ((MMListPopupWindow)localObject1).Ye = ((View)localObject2);
            if (bool) {
              ((MMListPopupWindow)localObject1).show();
            }
            this.vyJ.Yf = this.wmE;
          }
          this.vyJ.show();
          this.vyJ.vja.setOnKeyListener(this);
          this.vyJ.vja.setSelector(new ColorDrawable(this.mContext.getResources().getColor(a.d.transparent)));
          this.vyJ.vja.setDividerHeight(0);
          this.vyJ.vja.setVerticalScrollBarEnabled(true);
          this.vyJ.vja.setHorizontalScrollBarEnabled(false);
          GMTrace.o(1950586241024L, 14533);
          return true;
          localObject2 = this.mContext.getResources().getDisplayMetrics();
          if (((DisplayMetrics)localObject2).widthPixels > ((DisplayMetrics)localObject2).heightPixels)
          {
            i = BackwardSupportUtil.b.a(this.mContext, 40.0F);
            break;
          }
          i = BackwardSupportUtil.b.a(this.mContext, 49.0F);
          break;
          i = ((Rect)localObject1).top + i;
          break label159;
          bool = false;
          break label300;
          i = 0;
          break label455;
          i = (int)(this.wmI * j);
          break label527;
          v.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.khv.getCount() * this.wmG) });
          continue;
          v.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
        }
      }
    }
  }
  
  public final void dismiss()
  {
    GMTrace.i(1950854676480L, 14535);
    if (isShowing()) {
      this.vyJ.dismiss();
    }
    GMTrace.o(1950854676480L, 14535);
  }
  
  public final boolean isShowing()
  {
    GMTrace.i(1951257329664L, 14538);
    if ((this.vyJ != null) && (this.vyJ.iuy.isShowing()))
    {
      GMTrace.o(1951257329664L, 14538);
      return true;
    }
    GMTrace.o(1951257329664L, 14538);
    return false;
  }
  
  public final void lI(boolean paramBoolean)
  {
    GMTrace.i(1950317805568L, 14531);
    this.juJ = paramBoolean;
    if (paramBoolean)
    {
      this.vyK = a.l.hfk;
      GMTrace.o(1950317805568L, 14531);
      return;
    }
    this.vyK = a.l.hfl;
    GMTrace.o(1950317805568L, 14531);
  }
  
  public void onDismiss()
  {
    GMTrace.i(1951123111936L, 14537);
    this.vyJ = null;
    if (this.Rn != null)
    {
      if (!this.Rn.isAlive()) {
        this.Rn = this.hz.getViewTreeObserver();
      }
      this.Rn.removeGlobalOnLayoutListener(this);
      this.Rn = null;
    }
    if (this.wmA != null) {
      this.wmA.onCancel(null);
    }
    if (this.wmB != null) {
      this.wmB.onDismiss();
    }
    GMTrace.o(1951123111936L, 14537);
  }
  
  public void onGlobalLayout()
  {
    GMTrace.i(1951391547392L, 14539);
    v.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.hz.isShown()) });
    if (isShowing())
    {
      View localView = this.hz;
      if ((localView == null) || (!localView.isShown()))
      {
        dismiss();
        GMTrace.o(1951391547392L, 14539);
        return;
      }
      if ((isShowing()) && (this.shI != aKD())) {
        this.vyJ.dismiss();
      }
    }
    GMTrace.o(1951391547392L, 14539);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    GMTrace.i(1951659982848L, 14541);
    dismiss();
    GMTrace.o(1951659982848L, 14541);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(1951525765120L, 14540);
    v.v("MicroMsg.SubMenuHelperBase", "onKey");
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      GMTrace.o(1951525765120L, 14540);
      return true;
    }
    GMTrace.o(1951525765120L, 14540);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */