package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.m;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.support.v7.a.a.k;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.view.c;
import android.support.v7.view.menu.f.a;
import android.support.v7.view.menu.l.a;
import android.support.v7.view.menu.p;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private boolean RC;
  private boolean RD;
  private Context Rx;
  ActionMenuView Ry;
  private int Ta;
  l.a Tc;
  f.a Td;
  private final h Um;
  TextView aeH;
  TextView aeI;
  ImageButton aeJ;
  private ImageView aeK;
  private Drawable aeL;
  private CharSequence aeM;
  private ImageButton aeN;
  View aeO;
  int aeP;
  int aeQ;
  private int aeR;
  private int aeS;
  private int aeT;
  private int aeU;
  private int aeV;
  private int aeW;
  final ag aeX = new ag();
  public CharSequence aeY;
  CharSequence aeZ;
  private int afa;
  private int afb;
  private final ArrayList<View> afc = new ArrayList();
  final ArrayList<View> afd = new ArrayList();
  private final int[] afe = new int[2];
  private b aff;
  private final ActionMenuView.d afg = new ActionMenuView.d()
  {
    public final boolean ee()
    {
      if (Toolbar.a(Toolbar.this) != null) {
        return Toolbar.a(Toolbar.this).ee();
      }
      return false;
    }
  };
  private aq afh;
  private ActionMenuPresenter afi;
  a afj;
  boolean afk;
  private final Runnable afl = new Runnable()
  {
    public final void run()
    {
      Toolbar.this.showOverflowMenu();
    }
  };
  private int tW = 8388627;
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ap.a(getContext(), paramAttributeSet, a.k.dD, paramInt);
    this.aeP = paramContext.getResourceId(a.k.NR, 0);
    this.aeQ = paramContext.getResourceId(a.k.NJ, 0);
    paramInt = a.k.Nv;
    int i = this.tW;
    this.tW = paramContext.aeG.getInteger(paramInt, i);
    this.aeR = 48;
    paramInt = paramContext.getDimensionPixelOffset(a.k.NQ, 0);
    this.aeW = paramInt;
    this.aeV = paramInt;
    this.aeU = paramInt;
    this.aeT = paramInt;
    paramInt = paramContext.getDimensionPixelOffset(a.k.NO, -1);
    if (paramInt >= 0) {
      this.aeT = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(a.k.NN, -1);
    if (paramInt >= 0) {
      this.aeU = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(a.k.NP, -1);
    if (paramInt >= 0) {
      this.aeV = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(a.k.NM, -1);
    if (paramInt >= 0) {
      this.aeW = paramInt;
    }
    this.aeS = paramContext.getDimensionPixelSize(a.k.NE, -1);
    paramInt = paramContext.getDimensionPixelOffset(a.k.NB, Integer.MIN_VALUE);
    i = paramContext.getDimensionPixelOffset(a.k.Ny, Integer.MIN_VALUE);
    int j = paramContext.getDimensionPixelSize(a.k.Nz, 0);
    int k = paramContext.getDimensionPixelSize(a.k.NA, 0);
    paramAttributeSet = this.aeX;
    paramAttributeSet.abK = false;
    if (j != Integer.MIN_VALUE)
    {
      paramAttributeSet.abI = j;
      paramAttributeSet.abF = j;
    }
    if (k != Integer.MIN_VALUE)
    {
      paramAttributeSet.abJ = k;
      paramAttributeSet.abG = k;
    }
    if ((paramInt != Integer.MIN_VALUE) || (i != Integer.MIN_VALUE)) {
      this.aeX.ac(paramInt, i);
    }
    this.aeL = paramContext.getDrawable(a.k.Nx);
    this.aeM = paramContext.getText(a.k.Nw);
    paramAttributeSet = paramContext.getText(a.k.NL);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(a.k.NI);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.Rx = getContext();
    setPopupTheme(paramContext.getResourceId(a.k.NH, 0));
    paramAttributeSet = paramContext.getDrawable(a.k.NG);
    if (paramAttributeSet != null) {
      setNavigationIcon(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(a.k.NF);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setNavigationContentDescription(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(a.k.NC);
    if (paramAttributeSet != null) {
      setLogo(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(a.k.ND);
    if (!TextUtils.isEmpty(paramAttributeSet))
    {
      if (!TextUtils.isEmpty(paramAttributeSet)) {
        gV();
      }
      if (this.aeK != null) {
        this.aeK.setContentDescription(paramAttributeSet);
      }
    }
    if (paramContext.hasValue(a.k.NS))
    {
      paramInt = paramContext.bH(a.k.NS);
      this.afa = paramInt;
      if (this.aeH != null) {
        this.aeH.setTextColor(paramInt);
      }
    }
    if (paramContext.hasValue(a.k.NK))
    {
      paramInt = paramContext.bH(a.k.NK);
      this.afb = paramInt;
      if (this.aeI != null) {
        this.aeI.setTextColor(paramInt);
      }
    }
    paramContext.aeG.recycle();
    this.Um = h.ey();
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int j = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int k = Math.max(0, i) + Math.max(0, j);
    paramArrayOfInt[0] = Math.max(0, -i);
    paramArrayOfInt[1] = Math.max(0, -j);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + k + paramInt2, localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
    return paramView.getMeasuredWidth() + k;
  }
  
  private int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.leftMargin - paramArrayOfInt[0];
    paramInt1 = Math.max(0, i) + paramInt1;
    paramArrayOfInt[0] = Math.max(0, -i);
    paramInt2 = p(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i, paramView.getMeasuredHeight() + paramInt2);
    return localLayoutParams.rightMargin + i + paramInt1;
  }
  
  private void a(List<View> paramList, int paramInt)
  {
    int i = 1;
    int j = 0;
    if (z.J(this) == 1) {}
    int m;
    int k;
    View localView;
    LayoutParams localLayoutParams;
    for (;;)
    {
      m = getChildCount();
      k = android.support.v4.view.f.getAbsoluteGravity(paramInt, z.J(this));
      paramList.clear();
      paramInt = j;
      if (i == 0) {
        break;
      }
      paramInt = m - 1;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.afo == 0) && (bs(localView)) && (bI(localLayoutParams.gravity) == k)) {
          paramList.add(localView);
        }
        paramInt -= 1;
      }
      i = 0;
    }
    while (paramInt < m)
    {
      localView = getChildAt(paramInt);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams.afo == 0) && (bs(localView)) && (bI(localLayoutParams.gravity) == k)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
  }
  
  private int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i);
    paramArrayOfInt[1] = Math.max(0, -i);
    paramInt2 = p(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (localLayoutParams.leftMargin + i);
  }
  
  private int bI(int paramInt)
  {
    int j = z.J(this);
    int i = android.support.v4.view.f.getAbsoluteGravity(paramInt, j) & 0x7;
    paramInt = i;
    switch (i)
    {
    case 2: 
    case 4: 
    default: 
      if (j == 1) {
        paramInt = 5;
      }
      break;
    case 1: 
    case 3: 
    case 5: 
      return paramInt;
    }
    return 3;
  }
  
  private boolean bs(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  private static int bt(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = android.support.v4.view.l.a(paramView);
    return android.support.v4.view.l.b(paramView) + i;
  }
  
  private static int bu(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = paramView.topMargin;
    return paramView.bottomMargin + i;
  }
  
  private boolean bv(View paramView)
  {
    return (paramView.getParent() == this) || (this.afd.contains(paramView));
  }
  
  private void e(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = new LayoutParams();
    }
    for (;;)
    {
      ((LayoutParams)localObject).afo = 1;
      if ((!paramBoolean) || (this.aeO == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.afd.add(paramView);
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = f((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (LayoutParams)localObject;
      }
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private static LayoutParams f(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ActionBar.LayoutParams)) {
      return new LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  private void gV()
  {
    if (this.aeK == null) {
      this.aeK = new ImageView(getContext());
    }
  }
  
  private void gW()
  {
    if (this.Ry == null)
    {
      this.Ry = new ActionMenuView(getContext());
      this.Ry.setPopupTheme(this.Ta);
      this.Ry.Th = this.afg;
      this.Ry.a(this.Tc, this.Td);
      LayoutParams localLayoutParams = new LayoutParams();
      localLayoutParams.gravity = (0x800005 | this.aeR & 0x70);
      this.Ry.setLayoutParams(localLayoutParams);
      e(this.Ry, false);
    }
  }
  
  private void gX()
  {
    if (this.aeJ == null)
    {
      this.aeJ = new ImageButton(getContext(), null, a.a.IK);
      LayoutParams localLayoutParams = new LayoutParams();
      localLayoutParams.gravity = (0x800003 | this.aeR & 0x70);
      this.aeJ.setLayoutParams(localLayoutParams);
    }
  }
  
  protected static LayoutParams gY()
  {
    return new LayoutParams();
  }
  
  private void i(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + 0, localMarginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824)
    {
      paramInt1 = paramInt2;
      if (paramInt4 >= 0)
      {
        paramInt1 = paramInt4;
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt4);
        }
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
    paramView.measure(i, paramInt1);
  }
  
  private int p(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int k = paramView.getMeasuredHeight();
    int j;
    int i;
    int m;
    if (paramInt > 0)
    {
      paramInt = (k - paramInt) / 2;
      j = localLayoutParams.gravity & 0x70;
      i = j;
      switch (j)
      {
      default: 
        i = this.tW & 0x70;
      }
      switch (i)
      {
      default: 
        i = getPaddingTop();
        j = getPaddingBottom();
        m = getHeight();
        paramInt = (m - i - j - k) / 2;
        if (paramInt < localLayoutParams.topMargin) {
          paramInt = localLayoutParams.topMargin;
        }
        break;
      }
    }
    for (;;)
    {
      return paramInt + i;
      paramInt = 0;
      break;
      return getPaddingTop() - paramInt;
      return getHeight() - getPaddingBottom() - k - localLayoutParams.bottomMargin - paramInt;
      j = m - j - k - paramInt - i;
      if (j < localLayoutParams.bottomMargin) {
        paramInt = Math.max(0, paramInt - (localLayoutParams.bottomMargin - j));
      }
    }
  }
  
  public final void a(android.support.v7.view.menu.f paramf, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramf == null) && (this.Ry == null)) {}
    android.support.v7.view.menu.f localf;
    do
    {
      return;
      gW();
      localf = this.Ry.dW;
    } while (localf == paramf);
    if (localf != null)
    {
      localf.b(this.afi);
      localf.b(this.afj);
    }
    if (this.afj == null) {
      this.afj = new a();
    }
    paramActionMenuPresenter.SK = true;
    if (paramf != null)
    {
      paramf.a(paramActionMenuPresenter, this.Rx);
      paramf.a(this.afj, this.Rx);
    }
    for (;;)
    {
      this.Ry.setPopupTheme(this.Ta);
      this.Ry.a(paramActionMenuPresenter);
      this.afi = paramActionMenuPresenter;
      return;
      paramActionMenuPresenter.a(this.Rx, null);
      this.afj.a(this.Rx, null);
      paramActionMenuPresenter.f(true);
      this.afj.f(true);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public final void collapseActionView()
  {
    if (this.afj == null) {}
    for (android.support.v7.view.menu.h localh = null;; localh = this.afj.afn)
    {
      if (localh != null) {
        localh.collapseActionView();
      }
      return;
    }
  }
  
  public final u gZ()
  {
    if (this.afh == null) {
      this.afh = new aq(this);
    }
    return this.afh;
  }
  
  public final Menu getMenu()
  {
    gW();
    if (this.Ry.dW == null)
    {
      android.support.v7.view.menu.f localf = (android.support.v7.view.menu.f)this.Ry.getMenu();
      if (this.afj == null) {
        this.afj = new a();
      }
      this.Ry.Tb.SK = true;
      localf.a(this.afj, this.Rx);
    }
    return this.Ry.getMenu();
  }
  
  public final CharSequence getNavigationContentDescription()
  {
    if (this.aeJ != null) {
      return this.aeJ.getContentDescription();
    }
    return null;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    if (this.Ry != null)
    {
      ActionMenuView localActionMenuView = this.Ry;
      if ((localActionMenuView.Tb != null) && (localActionMenuView.Tb.isOverflowMenuShowing())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.afl);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = o.d(paramMotionEvent);
    if (i == 9) {
      this.RD = false;
    }
    if (!this.RD)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.RD = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.RD = false;
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k;
    int i1;
    int i4;
    int i;
    int i2;
    int i3;
    int i5;
    int[] arrayOfInt;
    int n;
    if (z.J(this) == 1)
    {
      k = 1;
      i1 = getWidth();
      i4 = getHeight();
      i = getPaddingLeft();
      i2 = getPaddingRight();
      i3 = getPaddingTop();
      i5 = getPaddingBottom();
      paramInt4 = i1 - i2;
      arrayOfInt = this.afe;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      n = z.U(this);
      if (!bs(this.aeJ)) {
        break label1721;
      }
      if (k == 0) {
        break label888;
      }
      paramInt4 = b(this.aeJ, paramInt4, arrayOfInt, n);
      paramInt1 = i;
    }
    for (;;)
    {
      label111:
      paramInt2 = paramInt4;
      paramInt3 = paramInt1;
      if (bs(this.aeN))
      {
        if (k != 0)
        {
          paramInt2 = b(this.aeN, paramInt4, arrayOfInt, n);
          paramInt3 = paramInt1;
        }
      }
      else
      {
        label151:
        paramInt1 = paramInt2;
        paramInt4 = paramInt3;
        if (bs(this.Ry))
        {
          if (k == 0) {
            break label927;
          }
          paramInt4 = a(this.Ry, paramInt3, arrayOfInt, n);
          paramInt1 = paramInt2;
        }
        label191:
        arrayOfInt[0] = Math.max(0, this.aeX.abF - paramInt4);
        arrayOfInt[1] = Math.max(0, this.aeX.abG - (i1 - i2 - paramInt1));
        paramInt3 = Math.max(paramInt4, this.aeX.abF);
        paramInt4 = Math.min(paramInt1, i1 - i2 - this.aeX.abG);
        paramInt2 = paramInt4;
        paramInt1 = paramInt3;
        if (bs(this.aeO))
        {
          if (k == 0) {
            break label948;
          }
          paramInt2 = b(this.aeO, paramInt4, arrayOfInt, n);
          paramInt1 = paramInt3;
        }
        label305:
        if (!bs(this.aeK)) {
          break label1715;
        }
        if (k == 0) {
          break label969;
        }
        paramInt2 = b(this.aeK, paramInt2, arrayOfInt, n);
        paramInt3 = paramInt1;
      }
      for (;;)
      {
        label338:
        paramBoolean = bs(this.aeH);
        boolean bool = bs(this.aeI);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (LayoutParams)this.aeH.getLayoutParams();
          paramInt1 = ((LayoutParams)localObject1).topMargin;
          paramInt4 = this.aeH.getMeasuredHeight();
          paramInt1 = ((LayoutParams)localObject1).bottomMargin + (paramInt1 + paramInt4) + 0;
        }
        int j;
        if (bool)
        {
          localObject1 = (LayoutParams)this.aeI.getLayoutParams();
          paramInt4 = ((LayoutParams)localObject1).topMargin;
          j = this.aeI.getMeasuredHeight();
        }
        for (int m = ((LayoutParams)localObject1).bottomMargin + (paramInt4 + j) + paramInt1;; m = paramInt1)
        {
          label476:
          Object localObject2;
          if (!paramBoolean)
          {
            paramInt4 = paramInt2;
            paramInt1 = paramInt3;
            if (!bool) {}
          }
          else
          {
            if (!paramBoolean) {
              break label987;
            }
            localObject1 = this.aeH;
            if (!bool) {
              break label996;
            }
            localObject2 = this.aeI;
            label487:
            localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
            localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (this.aeH.getMeasuredWidth() <= 0)) && ((!bool) || (this.aeI.getMeasuredWidth() <= 0))) {
              break label1005;
            }
            j = 1;
            label539:
            switch (this.tW & 0x70)
            {
            default: 
              paramInt1 = (i4 - i3 - i5 - m) / 2;
              if (paramInt1 < ((LayoutParams)localObject1).topMargin + this.aeV) {
                paramInt1 = ((LayoutParams)localObject1).topMargin + this.aeV;
              }
              break;
            }
          }
          label611:
          label616:
          label632:
          label888:
          label927:
          label948:
          label969:
          label987:
          label996:
          label1005:
          label1125:
          label1683:
          label1700:
          label1706:
          for (;;)
          {
            paramInt1 = i3 + paramInt1;
            if (k != 0) {
              if (j != 0)
              {
                paramInt4 = this.aeT;
                paramInt4 -= arrayOfInt[1];
                paramInt2 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1700;
                }
                localObject1 = (LayoutParams)this.aeH.getLayoutParams();
                paramInt4 = paramInt2 - this.aeH.getMeasuredWidth();
                k = this.aeH.getMeasuredHeight() + paramInt1;
                this.aeH.layout(paramInt4, paramInt1, paramInt2, k);
                m = this.aeU;
                paramInt1 = k + ((LayoutParams)localObject1).bottomMargin;
                paramInt4 -= m;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (LayoutParams)this.aeI.getLayoutParams();
                paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1;
                k = this.aeI.getMeasuredWidth();
                m = this.aeI.getMeasuredHeight();
                this.aeI.layout(paramInt2 - k, paramInt1, paramInt2, m + paramInt1);
                paramInt1 = this.aeU;
                k = ((LayoutParams)localObject1).bottomMargin;
              }
              for (paramInt1 = paramInt2 - paramInt1;; paramInt1 = paramInt2)
              {
                if (j != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt2)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt3;
                  a(this.afc, 3);
                  paramInt3 = this.afc.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = a((View)this.afc.get(paramInt2), paramInt1, arrayOfInt, n);
                      paramInt2 += 1;
                      continue;
                      k = 0;
                      break;
                      paramInt1 = a(this.aeJ, i, arrayOfInt, n);
                      break label111;
                      paramInt3 = a(this.aeN, paramInt1, arrayOfInt, n);
                      paramInt2 = paramInt4;
                      break label151;
                      paramInt1 = b(this.Ry, paramInt2, arrayOfInt, n);
                      paramInt4 = paramInt3;
                      break label191;
                      paramInt1 = a(this.aeO, paramInt3, arrayOfInt, n);
                      paramInt2 = paramInt4;
                      break label305;
                      paramInt3 = a(this.aeK, paramInt1, arrayOfInt, n);
                      break label338;
                      localObject1 = this.aeI;
                      break label476;
                      localObject2 = this.aeH;
                      break label487;
                      j = 0;
                      break label539;
                      paramInt1 = getPaddingTop();
                      paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1 + this.aeV;
                      break label616;
                      paramInt4 = i4 - i5 - m - paramInt1 - i3;
                      if (paramInt4 >= ((LayoutParams)localObject1).bottomMargin + this.aeW) {
                        break label1706;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (((LayoutParams)localObject2).bottomMargin + this.aeW - paramInt4));
                      break label611;
                      paramInt1 = i4 - i5 - ((LayoutParams)localObject2).bottomMargin - this.aeW - m;
                      break label616;
                      paramInt4 = 0;
                      break label632;
                      if (j != 0)
                      {
                        paramInt4 = this.aeT;
                        paramInt4 -= arrayOfInt[0];
                        paramInt3 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1683;
                        }
                        localObject1 = (LayoutParams)this.aeH.getLayoutParams();
                        k = this.aeH.getMeasuredWidth() + paramInt3;
                        paramInt4 = this.aeH.getMeasuredHeight() + paramInt1;
                        this.aeH.layout(paramInt3, paramInt1, k, paramInt4);
                        m = this.aeU;
                        paramInt1 = ((LayoutParams)localObject1).bottomMargin;
                        k += m;
                        paramInt1 += paramInt4;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (bool)
                    {
                      localObject1 = (LayoutParams)this.aeI.getLayoutParams();
                      paramInt4 = paramInt1 + ((LayoutParams)localObject1).topMargin;
                      paramInt1 = this.aeI.getMeasuredWidth() + paramInt3;
                      m = this.aeI.getMeasuredHeight();
                      this.aeI.layout(paramInt3, paramInt4, paramInt1, m + paramInt4);
                      paramInt4 = this.aeU;
                      m = ((LayoutParams)localObject1).bottomMargin;
                    }
                    for (m = paramInt4 + paramInt1;; m = paramInt3)
                    {
                      paramInt4 = paramInt2;
                      paramInt1 = paramInt3;
                      if (j == 0) {
                        break;
                      }
                      paramInt1 = Math.max(k, m);
                      paramInt4 = paramInt2;
                      break;
                      paramInt4 = 0;
                      break label1125;
                      a(this.afc, 5);
                      j = this.afc.size();
                      paramInt3 = 0;
                      paramInt2 = paramInt4;
                      while (paramInt3 < j)
                      {
                        paramInt2 = b((View)this.afc.get(paramInt3), paramInt2, arrayOfInt, n);
                        paramInt3 += 1;
                      }
                      a(this.afc, 1);
                      localObject1 = this.afc;
                      k = arrayOfInt[0];
                      j = arrayOfInt[1];
                      m = ((List)localObject1).size();
                      paramInt4 = 0;
                      paramInt3 = 0;
                      while (paramInt4 < m)
                      {
                        localObject2 = (View)((List)localObject1).get(paramInt4);
                        LayoutParams localLayoutParams = (LayoutParams)((View)localObject2).getLayoutParams();
                        k = localLayoutParams.leftMargin - k;
                        j = localLayoutParams.rightMargin - j;
                        i3 = Math.max(0, k);
                        i4 = Math.max(0, j);
                        k = Math.max(0, -k);
                        j = Math.max(0, -j);
                        i5 = ((View)localObject2).getMeasuredWidth();
                        paramInt4 += 1;
                        paramInt3 += i5 + i3 + i4;
                      }
                      paramInt4 = (i1 - i - i2) / 2 + i - paramInt3 / 2;
                      paramInt3 = paramInt4 + paramInt3;
                      if (paramInt4 < paramInt1) {}
                      for (;;)
                      {
                        paramInt4 = this.afc.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = a((View)this.afc.get(paramInt1), paramInt2, arrayOfInt, n);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt4;
                        if (paramInt3 > paramInt2) {
                          paramInt1 = paramInt4 - (paramInt3 - paramInt2);
                        }
                      }
                      this.afc.clear();
                      return;
                    }
                    k = paramInt3;
                  }
                }
              }
              paramInt4 = paramInt2;
            }
          }
        }
        label1715:
        paramInt3 = paramInt1;
      }
      label1721:
      paramInt1 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.afe;
    int n;
    int i1;
    int i;
    int m;
    int k;
    if (at.bw(this))
    {
      n = 0;
      i1 = 1;
      i = 0;
      if (!bs(this.aeJ)) {
        break label1057;
      }
      i(this.aeJ, paramInt1, 0, paramInt2, this.aeS);
      i = this.aeJ.getMeasuredWidth() + bt(this.aeJ);
      m = Math.max(0, this.aeJ.getMeasuredHeight() + bu(this.aeJ));
      k = at.combineMeasuredStates(0, z.N(this.aeJ));
    }
    for (;;)
    {
      int i2 = i;
      i = k;
      int j = m;
      if (bs(this.aeN))
      {
        i(this.aeN, paramInt1, 0, paramInt2, this.aeS);
        i2 = this.aeN.getMeasuredWidth() + bt(this.aeN);
        j = Math.max(m, this.aeN.getMeasuredHeight() + bu(this.aeN));
        i = at.combineMeasuredStates(k, z.N(this.aeN));
      }
      Object localObject2 = this.aeX;
      label206:
      int i3;
      if (((ag)localObject2).gd)
      {
        k = ((ag)localObject2).abG;
        i3 = Math.max(k, i2) + 0;
        localObject1[i1] = Math.max(0, k - i2);
        i1 = 0;
        k = i;
        m = j;
        if (bs(this.Ry))
        {
          i(this.Ry, paramInt1, i3, paramInt2, this.aeS);
          i1 = this.Ry.getMeasuredWidth() + bt(this.Ry);
          m = Math.max(j, this.Ry.getMeasuredHeight() + bu(this.Ry));
          k = at.combineMeasuredStates(i, z.N(this.Ry));
        }
        localObject2 = this.aeX;
        if (!((ag)localObject2).gd) {
          break label668;
        }
        i = ((ag)localObject2).abF;
        label340:
        i2 = i3 + Math.max(i, i1);
        localObject1[n] = Math.max(0, i - i1);
        n = i2;
        i = k;
        j = m;
        if (bs(this.aeO))
        {
          n = i2 + a(this.aeO, paramInt1, i2, paramInt2, 0, (int[])localObject1);
          j = Math.max(m, this.aeO.getMeasuredHeight() + bu(this.aeO));
          i = at.combineMeasuredStates(k, z.N(this.aeO));
        }
        k = n;
        i1 = i;
        m = j;
        if (bs(this.aeK))
        {
          k = n + a(this.aeK, paramInt1, n, paramInt2, 0, (int[])localObject1);
          m = Math.max(j, this.aeK.getMeasuredHeight() + bu(this.aeK));
          i1 = at.combineMeasuredStates(i, z.N(this.aeK));
        }
        i2 = getChildCount();
        n = 0;
        i = i1;
        j = m;
        m = n;
        i1 = k;
        label542:
        if (m >= i2) {
          break label677;
        }
        localObject2 = getChildAt(m);
        if ((((LayoutParams)((View)localObject2).getLayoutParams()).afo != 0) || (!bs((View)localObject2))) {
          break label1044;
        }
        i1 += a((View)localObject2, paramInt1, i1, paramInt2, 0, (int[])localObject1);
        k = Math.max(j, ((View)localObject2).getMeasuredHeight() + bu((View)localObject2));
        j = at.combineMeasuredStates(i, z.N((View)localObject2));
      }
      for (i = k;; i = k)
      {
        m += 1;
        k = i;
        i = j;
        j = k;
        break label542;
        n = 1;
        i1 = 0;
        break;
        k = ((ag)localObject2).abF;
        break label206;
        label668:
        i = ((ag)localObject2).abG;
        break label340;
        label677:
        n = 0;
        m = 0;
        int i4 = this.aeV + this.aeW;
        int i5 = this.aeT + this.aeU;
        k = i;
        if (bs(this.aeH))
        {
          a(this.aeH, paramInt1, i1 + i5, paramInt2, i4, (int[])localObject1);
          k = this.aeH.getMeasuredWidth();
          n = bt(this.aeH) + k;
          m = this.aeH.getMeasuredHeight() + bu(this.aeH);
          k = at.combineMeasuredStates(i, z.N(this.aeH));
        }
        i3 = m;
        i2 = n;
        i = k;
        if (bs(this.aeI))
        {
          i2 = Math.max(n, a(this.aeI, paramInt1, i1 + i5, paramInt2, i4 + m, (int[])localObject1));
          i3 = m + (this.aeI.getMeasuredHeight() + bu(this.aeI));
          i = at.combineMeasuredStates(k, z.N(this.aeI));
        }
        k = Math.max(j, i3);
        j = getPaddingLeft();
        i3 = getPaddingRight();
        m = getPaddingTop();
        n = getPaddingBottom();
        j = z.resolveSizeAndState(Math.max(i2 + i1 + (j + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i);
        paramInt2 = z.resolveSizeAndState(Math.max(k + (m + n), getSuggestedMinimumHeight()), paramInt2, i << 16);
        if (!this.afk) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 != 0) {
            paramInt2 = 0;
          }
          setMeasuredDimension(j, paramInt2);
          return;
          i = getChildCount();
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= i) {
              break label1039;
            }
            localObject1 = getChildAt(paramInt1);
            if ((bs((View)localObject1)) && (((View)localObject1).getMeasuredWidth() > 0) && (((View)localObject1).getMeasuredHeight() > 0))
            {
              paramInt1 = 0;
              break;
            }
            paramInt1 += 1;
          }
          label1039:
          paramInt1 = 1;
        }
        label1044:
        k = j;
        j = i;
      }
      label1057:
      k = 0;
      m = 0;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (this.Ry != null) {}
    for (paramParcelable = this.Ry.dW;; paramParcelable = null)
    {
      if ((localSavedState.afp != 0) && (this.afj != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(localSavedState.afp);
        if (paramParcelable != null) {
          m.b(paramParcelable);
        }
      }
      if (!localSavedState.afq) {
        break;
      }
      removeCallbacks(this.afl);
      post(this.afl);
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    ag localag = this.aeX;
    if (paramInt == 1) {
      if (bool != localag.gd)
      {
        localag.gd = bool;
        if (!localag.abK) {
          break label164;
        }
        if (!bool) {
          break label109;
        }
        if (localag.wd == Integer.MIN_VALUE) {
          break label93;
        }
        paramInt = localag.wd;
        label63:
        localag.abF = paramInt;
        if (localag.abH == Integer.MIN_VALUE) {
          break label101;
        }
      }
    }
    label93:
    label101:
    for (paramInt = localag.abH;; paramInt = localag.abJ)
    {
      localag.abG = paramInt;
      return;
      bool = false;
      break;
      paramInt = localag.abI;
      break label63;
    }
    label109:
    if (localag.abH != Integer.MIN_VALUE)
    {
      paramInt = localag.abH;
      localag.abF = paramInt;
      if (localag.wd == Integer.MIN_VALUE) {
        break label156;
      }
    }
    label156:
    for (paramInt = localag.wd;; paramInt = localag.abJ)
    {
      localag.abG = paramInt;
      return;
      paramInt = localag.abI;
      break;
    }
    label164:
    localag.abF = localag.abI;
    localag.abG = localag.abJ;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.afj != null) && (this.afj.afn != null)) {
      localSavedState.afp = this.afj.afn.getItemId();
    }
    localSavedState.afq = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = o.d(paramMotionEvent);
    if (i == 0) {
      this.RC = false;
    }
    if (!this.RC)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.RC = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.RC = false;
    }
    return true;
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      gV();
      if (!bv(this.aeK)) {
        e(this.aeK, true);
      }
    }
    for (;;)
    {
      if (this.aeK != null) {
        this.aeK.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.aeK != null) && (bv(this.aeK)))
      {
        removeView(this.aeK);
        this.afd.remove(this.aeK);
      }
    }
  }
  
  public final void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      gX();
    }
    if (this.aeJ != null) {
      this.aeJ.setContentDescription(paramCharSequence);
    }
  }
  
  public final void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      gX();
      if (!bv(this.aeJ)) {
        e(this.aeJ, true);
      }
    }
    for (;;)
    {
      if (this.aeJ != null) {
        this.aeJ.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.aeJ != null) && (bv(this.aeJ)))
      {
        removeView(this.aeJ);
        this.afd.remove(this.aeJ);
      }
    }
  }
  
  public final void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    gX();
    this.aeJ.setOnClickListener(paramOnClickListener);
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
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.aeI == null)
      {
        Context localContext = getContext();
        this.aeI = new TextView(localContext);
        this.aeI.setSingleLine();
        this.aeI.setEllipsize(TextUtils.TruncateAt.END);
        if (this.aeQ != 0) {
          this.aeI.setTextAppearance(localContext, this.aeQ);
        }
        if (this.afb != 0) {
          this.aeI.setTextColor(this.afb);
        }
      }
      if (!bv(this.aeI)) {
        e(this.aeI, true);
      }
    }
    for (;;)
    {
      if (this.aeI != null) {
        this.aeI.setText(paramCharSequence);
      }
      this.aeZ = paramCharSequence;
      return;
      if ((this.aeI != null) && (bv(this.aeI)))
      {
        removeView(this.aeI);
        this.afd.remove(this.aeI);
      }
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.aeH == null)
      {
        Context localContext = getContext();
        this.aeH = new TextView(localContext);
        this.aeH.setSingleLine();
        this.aeH.setEllipsize(TextUtils.TruncateAt.END);
        if (this.aeP != 0) {
          this.aeH.setTextAppearance(localContext, this.aeP);
        }
        if (this.afa != 0) {
          this.aeH.setTextColor(this.afa);
        }
      }
      if (!bv(this.aeH)) {
        e(this.aeH, true);
      }
    }
    for (;;)
    {
      if (this.aeH != null) {
        this.aeH.setText(paramCharSequence);
      }
      this.aeY = paramCharSequence;
      return;
      if ((this.aeH != null) && (bv(this.aeH)))
      {
        removeView(this.aeH);
        this.afd.remove(this.aeH);
      }
    }
  }
  
  public final boolean showOverflowMenu()
  {
    if (this.Ry != null)
    {
      ActionMenuView localActionMenuView = this.Ry;
      if ((localActionMenuView.Tb != null) && (localActionMenuView.Tb.showOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    int afo = 0;
    
    public LayoutParams()
    {
      super(-2);
      this.gravity = 8388627;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ActionBar.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.afo = paramLayoutParams.afo;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.leftMargin = paramMarginLayoutParams.leftMargin;
      this.topMargin = paramMarginLayoutParams.topMargin;
      this.rightMargin = paramMarginLayoutParams.rightMargin;
      this.bottomMargin = paramMarginLayoutParams.bottomMargin;
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int afp;
    boolean afq;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.afp = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.afq = bool;
        return;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.afp);
      if (this.afq) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  private final class a
    implements android.support.v7.view.menu.l
  {
    android.support.v7.view.menu.h afn;
    android.support.v7.view.menu.f dW;
    
    public a() {}
    
    public final boolean B()
    {
      return false;
    }
    
    public final void a(Context paramContext, android.support.v7.view.menu.f paramf)
    {
      if ((this.dW != null) && (this.afn != null)) {
        this.dW.h(this.afn);
      }
      this.dW = paramf;
    }
    
    public final void a(android.support.v7.view.menu.f paramf, boolean paramBoolean) {}
    
    public final boolean a(p paramp)
    {
      return false;
    }
    
    public final boolean b(android.support.v7.view.menu.h paramh)
    {
      Toolbar.b(Toolbar.this);
      if (Toolbar.c(Toolbar.this).getParent() != Toolbar.this) {
        Toolbar.this.addView(Toolbar.c(Toolbar.this));
      }
      Toolbar.this.aeO = paramh.getActionView();
      this.afn = paramh;
      if (Toolbar.this.aeO.getParent() != Toolbar.this)
      {
        localObject = Toolbar.gY();
        ((Toolbar.LayoutParams)localObject).gravity = (0x800003 | Toolbar.d(Toolbar.this) & 0x70);
        ((Toolbar.LayoutParams)localObject).afo = 2;
        Toolbar.this.aeO.setLayoutParams((ViewGroup.LayoutParams)localObject);
        Toolbar.this.addView(Toolbar.this.aeO);
      }
      Object localObject = Toolbar.this;
      int i = ((Toolbar)localObject).getChildCount() - 1;
      while (i >= 0)
      {
        View localView = ((Toolbar)localObject).getChildAt(i);
        if ((((Toolbar.LayoutParams)localView.getLayoutParams()).afo != 2) && (localView != ((Toolbar)localObject).Ry))
        {
          ((Toolbar)localObject).removeViewAt(i);
          ((Toolbar)localObject).afd.add(localView);
        }
        i -= 1;
      }
      Toolbar.this.requestLayout();
      paramh.I(true);
      if ((Toolbar.this.aeO instanceof c)) {
        ((c)Toolbar.this.aeO).onActionViewExpanded();
      }
      return true;
    }
    
    public final boolean c(android.support.v7.view.menu.h paramh)
    {
      if ((Toolbar.this.aeO instanceof c)) {
        ((c)Toolbar.this.aeO).onActionViewCollapsed();
      }
      Toolbar.this.removeView(Toolbar.this.aeO);
      Toolbar.this.removeView(Toolbar.c(Toolbar.this));
      Toolbar.this.aeO = null;
      Toolbar localToolbar = Toolbar.this;
      int i = localToolbar.afd.size() - 1;
      while (i >= 0)
      {
        localToolbar.addView((View)localToolbar.afd.get(i));
        i -= 1;
      }
      localToolbar.afd.clear();
      this.afn = null;
      Toolbar.this.requestLayout();
      paramh.I(false);
      return true;
    }
    
    public final void f(boolean paramBoolean)
    {
      int k = 0;
      int j;
      int m;
      int i;
      if (this.afn != null)
      {
        j = k;
        if (this.dW != null)
        {
          m = this.dW.size();
          i = 0;
        }
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (this.dW.getItem(i) == this.afn) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            c(this.afn);
          }
          return;
        }
        i += 1;
      }
    }
    
    public final int getId()
    {
      return 0;
    }
    
    public final void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public final Parcelable onSaveInstanceState()
    {
      return null;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean ee();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/Toolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */