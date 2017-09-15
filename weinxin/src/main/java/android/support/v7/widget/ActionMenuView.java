package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.view.menu.f.b;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.l.a;
import android.support.v7.view.menu.m;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView
  extends LinearLayoutCompat
  implements f.b, m
{
  private Context Rx;
  boolean SC;
  private int SL;
  private int Ta;
  ActionMenuPresenter Tb;
  private l.a Tc;
  private f.a Td;
  private boolean Te;
  private int Tf;
  private int Tg;
  d Th;
  f dW;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.Xa = false;
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.SL = ((int)(56.0F * f));
    this.Tg = ((int)(f * 4.0F));
    this.Rx = paramContext;
    this.Ta = 0;
  }
  
  private boolean aB(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 0) {
      return false;
    }
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool1 = bool2;
    if (paramInt < getChildCount())
    {
      bool1 = bool2;
      if ((localView1 instanceof a)) {
        bool1 = ((a)localView1).dn() | false;
      }
    }
    if ((paramInt > 0) && ((localView2 instanceof a))) {
      return ((a)localView2).dm() | bool1;
    }
    return bool1;
  }
  
  private LayoutParams b(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected static LayoutParams c(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof LayoutParams)) {}
      for (paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);; paramLayoutParams = new LayoutParams(paramLayoutParams))
      {
        if (paramLayoutParams.gravity <= 0) {
          paramLayoutParams.gravity = 16;
        }
        return paramLayoutParams;
      }
    }
    return eb();
  }
  
  static int d(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = false;
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView))
    {
      localActionMenuItemView = (ActionMenuItemView)paramView;
      if ((localActionMenuItemView == null) || (!localActionMenuItemView.hasText())) {
        break label184;
      }
      paramInt4 = 1;
      label57:
      if ((paramInt2 <= 0) || ((paramInt4 != 0) && (paramInt2 < 2))) {
        break label190;
      }
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, Integer.MIN_VALUE), i);
      int j = paramView.getMeasuredWidth();
      paramInt3 = j / paramInt1;
      paramInt2 = paramInt3;
      if (j % paramInt1 != 0) {
        paramInt2 = paramInt3 + 1;
      }
      paramInt3 = paramInt2;
      if (paramInt4 != 0)
      {
        paramInt3 = paramInt2;
        if (paramInt2 >= 2) {}
      }
    }
    label184:
    label190:
    for (paramInt3 = 2;; paramInt3 = 0)
    {
      boolean bool1 = bool2;
      if (!localLayoutParams.Tj)
      {
        bool1 = bool2;
        if (paramInt4 != 0) {
          bool1 = true;
        }
      }
      localLayoutParams.Tm = bool1;
      localLayoutParams.Tk = paramInt3;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 * paramInt1, 1073741824), i);
      return paramInt3;
      localActionMenuItemView = null;
      break;
      paramInt4 = 0;
      break label57;
    }
  }
  
  private static LayoutParams eb()
  {
    LayoutParams localLayoutParams = new LayoutParams();
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  public static LayoutParams ec()
  {
    LayoutParams localLayoutParams = eb();
    localLayoutParams.Tj = true;
    return localLayoutParams;
  }
  
  public final void a(f paramf)
  {
    this.dW = paramf;
  }
  
  public final void a(l.a parama, f.a parama1)
  {
    this.Tc = parama;
    this.Td = parama1;
  }
  
  public final void a(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.Tb = paramActionMenuPresenter;
    this.Tb.a(this);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public final void dismissPopupMenus()
  {
    if (this.Tb != null) {
      this.Tb.dY();
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public final boolean f(h paramh)
  {
    return this.dW.a(paramh, null, 0);
  }
  
  public final Menu getMenu()
  {
    ActionMenuPresenter localActionMenuPresenter;
    if (this.dW == null)
    {
      localObject = getContext();
      this.dW = new f((Context)localObject);
      this.dW.a(new c());
      this.Tb = new ActionMenuPresenter((Context)localObject);
      this.Tb.dX();
      localActionMenuPresenter = this.Tb;
      if (this.Tc == null) {
        break label108;
      }
    }
    label108:
    for (Object localObject = this.Tc;; localObject = new b())
    {
      localActionMenuPresenter.dV = ((l.a)localObject);
      this.dW.a(this.Tb, this.Rx);
      this.Tb.a(this);
      return this.dW;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    if (this.Tb != null)
    {
      this.Tb.f(false);
      if (this.Tb.isOverflowMenuShowing())
      {
        this.Tb.hideOverflowMenu();
        this.Tb.showOverflowMenu();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dismissPopupMenus();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.Te)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i1 = getChildCount();
    int n = (paramInt4 - paramInt2) / 2;
    int i2 = this.Xk;
    paramInt2 = 0;
    paramInt4 = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
    int j = 0;
    paramBoolean = at.bw(this);
    int i = 0;
    label68:
    View localView;
    LayoutParams localLayoutParams;
    int k;
    int m;
    if (i < i1)
    {
      localView = getChildAt(i);
      if (localView.getVisibility() == 8) {
        break label665;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.Tj)
      {
        k = localView.getMeasuredWidth();
        j = k;
        if (aB(i)) {
          j = k + i2;
        }
        int i3 = localView.getMeasuredHeight();
        if (paramBoolean)
        {
          m = getPaddingLeft() + localLayoutParams.leftMargin;
          k = m + j;
          label168:
          int i4 = n - i3 / 2;
          localView.layout(m, i4, k, i3 + i4);
          k = paramInt4 - j;
          j = 1;
          paramInt4 = paramInt2;
          paramInt2 = k;
        }
      }
    }
    for (;;)
    {
      k = i + 1;
      i = paramInt4;
      paramInt4 = paramInt2;
      paramInt2 = i;
      i = k;
      break label68;
      k = getWidth() - getPaddingRight() - localLayoutParams.rightMargin;
      m = k - j;
      break label168;
      k = localView.getMeasuredWidth();
      m = localLayoutParams.leftMargin;
      paramInt4 -= localLayoutParams.rightMargin + (k + m);
      aB(i);
      k = paramInt2 + 1;
      paramInt2 = paramInt4;
      paramInt4 = k;
      continue;
      if ((i1 == 1) && (j == 0))
      {
        localView = getChildAt(0);
        paramInt2 = localView.getMeasuredWidth();
        paramInt4 = localView.getMeasuredHeight();
        paramInt1 = (paramInt3 - paramInt1) / 2 - paramInt2 / 2;
        paramInt3 = n - paramInt4 / 2;
        localView.layout(paramInt1, paramInt3, paramInt2 + paramInt1, paramInt4 + paramInt3);
        return;
      }
      if (j != 0)
      {
        paramInt1 = 0;
        label386:
        paramInt1 = paramInt2 - paramInt1;
        if (paramInt1 <= 0) {
          break label537;
        }
        paramInt1 = paramInt4 / paramInt1;
        label399:
        paramInt3 = Math.max(0, paramInt1);
        if (!paramBoolean) {
          break label542;
        }
        paramInt1 = getWidth() - getPaddingRight();
        paramInt2 = 0;
        label422:
        if (paramInt2 < i1)
        {
          localView = getChildAt(paramInt2);
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if ((localView.getVisibility() == 8) || (localLayoutParams.Tj)) {
            break label662;
          }
          paramInt1 -= localLayoutParams.rightMargin;
          paramInt4 = localView.getMeasuredWidth();
          i = localView.getMeasuredHeight();
          j = n - i / 2;
          localView.layout(paramInt1 - paramInt4, j, paramInt1, i + j);
          paramInt1 -= localLayoutParams.leftMargin + paramInt4 + paramInt3;
        }
      }
      label537:
      label542:
      label549:
      label659:
      label662:
      for (;;)
      {
        paramInt2 += 1;
        break label422;
        break;
        paramInt1 = 1;
        break label386;
        paramInt1 = 0;
        break label399;
        paramInt1 = getPaddingLeft();
        paramInt2 = 0;
        if (paramInt2 < i1)
        {
          localView = getChildAt(paramInt2);
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if ((localView.getVisibility() == 8) || (localLayoutParams.Tj)) {
            break label659;
          }
          paramInt1 += localLayoutParams.leftMargin;
          paramInt4 = localView.getMeasuredWidth();
          i = localView.getMeasuredHeight();
          j = n - i / 2;
          localView.layout(paramInt1, j, paramInt1 + paramInt4, i + j);
          paramInt1 = localLayoutParams.rightMargin + paramInt4 + paramInt3 + paramInt1;
        }
        for (;;)
        {
          paramInt2 += 1;
          break label549;
          break;
        }
      }
      label665:
      k = paramInt2;
      paramInt2 = paramInt4;
      paramInt4 = k;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.Te;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    int i;
    int j;
    int i7;
    int i6;
    int i4;
    int i8;
    int i9;
    for (boolean bool1 = true;; bool1 = false)
    {
      this.Te = bool1;
      if (bool2 != this.Te) {
        this.Tf = 0;
      }
      i = View.MeasureSpec.getSize(paramInt1);
      if ((this.Te) && (this.dW != null) && (i != this.Tf))
      {
        this.Tf = i;
        this.dW.h(true);
      }
      j = getChildCount();
      if ((!this.Te) || (j <= 0)) {
        break label1304;
      }
      i7 = View.MeasureSpec.getMode(paramInt2);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      i6 = View.MeasureSpec.getSize(paramInt2);
      i = getPaddingLeft();
      j = getPaddingRight();
      i4 = getPaddingTop() + getPaddingBottom();
      i8 = getChildMeasureSpec(paramInt2, i4, -2);
      i9 = paramInt1 - (i + j);
      paramInt1 = i9 / this.SL;
      paramInt2 = this.SL;
      if (paramInt1 != 0) {
        break;
      }
      setMeasuredDimension(i9, 0);
      return;
    }
    int i10 = this.SL + i9 % paramInt2 / paramInt1;
    paramInt2 = 0;
    int n = 0;
    int m = 0;
    int i1 = 0;
    int k = 0;
    long l1 = 0L;
    int i11 = getChildCount();
    int i2 = 0;
    Object localObject;
    LayoutParams localLayoutParams;
    label351:
    label369:
    int i3;
    label407:
    label418:
    long l2;
    if (i2 < i11)
    {
      localObject = getChildAt(i2);
      if (((View)localObject).getVisibility() == 8) {
        break label1438;
      }
      bool1 = localObject instanceof ActionMenuItemView;
      i1 += 1;
      if (bool1) {
        ((View)localObject).setPadding(this.Tg, 0, this.Tg, 0);
      }
      localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.To = false;
      localLayoutParams.Tl = 0;
      localLayoutParams.Tk = 0;
      localLayoutParams.Tm = false;
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
      if ((bool1) && (((ActionMenuItemView)localObject).hasText()))
      {
        bool1 = true;
        localLayoutParams.Tn = bool1;
        if (!localLayoutParams.Tj) {
          break label512;
        }
        i = 1;
        i3 = d((View)localObject, i10, i, i8, i4);
        n = Math.max(n, i3);
        if (!localLayoutParams.Tm) {
          break label1431;
        }
        i = m + 1;
        if (!localLayoutParams.Tj) {
          break label1424;
        }
        j = 1;
        paramInt1 -= i3;
        m = Math.max(paramInt2, ((View)localObject).getMeasuredHeight());
        if (i3 != 1) {
          break label1386;
        }
        l2 = 1 << i2;
        paramInt2 = m;
        k = paramInt1;
        m = i;
        i3 = j;
        l1 = l2 | l1;
        paramInt1 = i1;
        j = k;
        i = paramInt2;
        k = i3;
        paramInt2 = n;
      }
    }
    for (;;)
    {
      i2 += 1;
      i1 = paramInt1;
      paramInt1 = j;
      n = paramInt2;
      paramInt2 = i;
      break;
      bool1 = false;
      break label351;
      label512:
      i = paramInt1;
      break label369;
      long l3;
      if ((k != 0) && (i1 == 2))
      {
        i3 = 1;
        i = 0;
        i2 = paramInt1;
        paramInt1 = i;
        l3 = l1;
        if (m <= 0) {
          break label863;
        }
        l3 = l1;
        if (i2 <= 0) {
          break label863;
        }
        i = Integer.MAX_VALUE;
        l2 = 0L;
        j = 0;
        i4 = 0;
        label573:
        if (i4 >= i11) {
          break label697;
        }
        localObject = (LayoutParams)getChildAt(i4).getLayoutParams();
        if (!((LayoutParams)localObject).Tm) {
          break label1371;
        }
        if (((LayoutParams)localObject).Tk >= i) {
          break label660;
        }
        j = ((LayoutParams)localObject).Tk;
        l2 = 1 << i4;
        i = 1;
      }
      for (;;)
      {
        int i5 = i4 + 1;
        i4 = j;
        j = i;
        i = i4;
        i4 = i5;
        break label573;
        i3 = 0;
        break;
        label660:
        if (((LayoutParams)localObject).Tk == i)
        {
          l2 |= 1 << i4;
          i5 = j + 1;
          j = i;
          i = i5;
          continue;
          label697:
          l1 |= l2;
          l3 = l1;
          if (j <= i2)
          {
            j = 0;
            paramInt1 = i2;
            label721:
            if (j < i11)
            {
              localObject = getChildAt(j);
              localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
              if ((1 << j & l2) == 0L)
              {
                if (localLayoutParams.Tk != i + 1) {
                  break label1368;
                }
                l1 |= 1 << j;
              }
            }
          }
          label863:
          label1029:
          label1032:
          label1140:
          label1208:
          label1211:
          label1214:
          label1304:
          label1362:
          label1368:
          for (;;)
          {
            j += 1;
            break label721;
            if ((i3 != 0) && (localLayoutParams.Tn) && (paramInt1 == 1)) {
              ((View)localObject).setPadding(this.Tg + i10, 0, this.Tg, 0);
            }
            localLayoutParams.Tk += 1;
            localLayoutParams.To = true;
            paramInt1 -= 1;
            continue;
            i = 1;
            i2 = paramInt1;
            paramInt1 = i;
            break;
            float f2;
            float f1;
            if ((k == 0) && (i1 == 1))
            {
              i = 1;
              if ((i2 <= 0) || (l3 == 0L) || ((i2 >= i1 - 1) && (i == 0) && (n <= 1))) {
                break label1211;
              }
              float f3 = Long.bitCount(l3);
              f2 = f3;
              if (i != 0) {
                break label1362;
              }
              f1 = f3;
              if ((1L & l3) != 0L)
              {
                f1 = f3;
                if (!((LayoutParams)getChildAt(0).getLayoutParams()).Tn) {
                  f1 = f3 - 0.5F;
                }
              }
              f2 = f1;
              if ((1 << i11 - 1 & l3) == 0L) {
                break label1362;
              }
              f2 = f1;
              if (((LayoutParams)getChildAt(i11 - 1).getLayoutParams()).Tn) {
                break label1362;
              }
            }
            for (f1 -= 0.5F;; f1 = f2)
            {
              if (f1 > 0.0F)
              {
                i = (int)(i2 * i10 / f1);
                j = 0;
                k = paramInt1;
                if (j >= i11) {
                  break label1214;
                }
                if ((1 << j & l3) == 0L) {
                  break label1208;
                }
                localObject = getChildAt(j);
                localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
                if (!(localObject instanceof ActionMenuItemView)) {
                  break label1140;
                }
                localLayoutParams.Tl = i;
                localLayoutParams.To = true;
                if ((j == 0) && (!localLayoutParams.Tn)) {
                  localLayoutParams.leftMargin = (-i / 2);
                }
                paramInt1 = 1;
              }
              for (;;)
              {
                j += 1;
                break label1032;
                i = 0;
                break;
                i = 0;
                break label1029;
                if (localLayoutParams.Tj)
                {
                  localLayoutParams.Tl = i;
                  localLayoutParams.To = true;
                  localLayoutParams.rightMargin = (-i / 2);
                  paramInt1 = 1;
                }
                else
                {
                  if (j != 0) {
                    localLayoutParams.leftMargin = (i / 2);
                  }
                  if (j != i11 - 1) {
                    localLayoutParams.rightMargin = (i / 2);
                  }
                }
              }
              k = paramInt1;
              if (k != 0)
              {
                paramInt1 = 0;
                while (paramInt1 < i11)
                {
                  localObject = getChildAt(paramInt1);
                  localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
                  if (localLayoutParams.To)
                  {
                    i = localLayoutParams.Tk;
                    ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.Tl + i * i10, 1073741824), i8);
                  }
                  paramInt1 += 1;
                }
              }
              if (i7 != 1073741824) {}
              for (;;)
              {
                setMeasuredDimension(i9, paramInt2);
                return;
                i = 0;
                while (i < j)
                {
                  localObject = (LayoutParams)getChildAt(i).getLayoutParams();
                  ((LayoutParams)localObject).rightMargin = 0;
                  ((LayoutParams)localObject).leftMargin = 0;
                  i += 1;
                }
                super.onMeasure(paramInt1, paramInt2);
                return;
                paramInt2 = i6;
              }
            }
          }
        }
        else
        {
          label1371:
          i5 = i;
          i = j;
          j = i5;
        }
      }
      label1386:
      paramInt2 = i1;
      k = n;
      n = m;
      i1 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = k;
      m = i;
      k = j;
      i = n;
      j = i1;
      continue;
      label1424:
      j = k;
      break label418;
      label1431:
      i = m;
      break label407;
      label1438:
      i = paramInt2;
      j = paramInt1;
      paramInt2 = n;
      paramInt1 = i1;
    }
  }
  
  public final void setPopupTheme(int paramInt)
  {
    if (this.Ta != paramInt)
    {
      this.Ta = paramInt;
      if (paramInt == 0) {
        this.Rx = getContext();
      }
    }
    else
    {
      return;
    }
    this.Rx = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public static class LayoutParams
    extends LinearLayoutCompat.LayoutParams
  {
    @ViewDebug.ExportedProperty
    public boolean Tj;
    @ViewDebug.ExportedProperty
    public int Tk;
    @ViewDebug.ExportedProperty
    public int Tl;
    @ViewDebug.ExportedProperty
    public boolean Tm;
    @ViewDebug.ExportedProperty
    public boolean Tn;
    boolean To;
    
    public LayoutParams()
    {
      super(-2);
      this.Tj = false;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.Tj = paramLayoutParams.Tj;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean dm();
    
    public abstract boolean dn();
  }
  
  private final class b
    implements l.a
  {
    public b() {}
    
    public final void a(f paramf, boolean paramBoolean) {}
    
    public final boolean d(f paramf)
    {
      return false;
    }
  }
  
  private final class c
    implements f.a
  {
    public c() {}
    
    public final boolean a(f paramf, MenuItem paramMenuItem)
    {
      return (ActionMenuView.b(ActionMenuView.this) != null) && (ActionMenuView.b(ActionMenuView.this).ee());
    }
    
    public final void b(f paramf)
    {
      if (ActionMenuView.c(ActionMenuView.this) != null) {
        ActionMenuView.c(ActionMenuView.this).b(paramf);
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean ee();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/ActionMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */