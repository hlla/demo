package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.a;
import android.support.v4.view.af;
import android.support.v4.view.f;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout
  extends ViewGroup
  implements h
{
  static final c BZ;
  private static final boolean Bw;
  private static final boolean Bx;
  private static final int[] ym;
  private int BA;
  private int BB = -1728053248;
  private float BC;
  private Paint BD = new Paint();
  final u BE;
  final u BF;
  private final f BG;
  private final f BH;
  int BI;
  private int BJ = 3;
  private int BK = 3;
  private int BL = 3;
  private int BM = 3;
  private boolean BN;
  boolean BO;
  private Drawable BP;
  private Drawable BQ;
  CharSequence BR;
  CharSequence BS;
  private Object BT;
  private Drawable BU = null;
  private Drawable BV = null;
  private Drawable BW = null;
  private Drawable BX = null;
  private final ArrayList<View> BY;
  private final b By = new b();
  private float Bz;
  List<Object> eE;
  private boolean hp;
  private Drawable hq;
  private boolean pd;
  private float xC;
  private float xD;
  private boolean yW = true;
  
  static
  {
    boolean bool2 = true;
    ym = new int[] { 16842931 };
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = true;
      Bw = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label65;
      }
    }
    label65:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Bx = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label70;
      }
      BZ = new d();
      return;
      bool1 = false;
      break;
    }
    label70:
    BZ = new e();
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResources().getDisplayMetrics().density;
    this.BA = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    this.BG = new f(3);
    this.BH = new f(5);
    this.BE = u.a(this, 1.0F, this.BG);
    this.BE.EW = 1;
    this.BE.EU = f2;
    this.BG.Ck = this.BE;
    this.BF = u.a(this, 1.0F, this.BH);
    this.BF.EW = 2;
    this.BF.EU = f2;
    this.BH.Ck = this.BF;
    setFocusableInTouchMode(true);
    z.i(this, 1);
    z.a(this, new a());
    af.b(this);
    if (z.aa(this))
    {
      BZ.aB(this);
      this.hq = BZ.l(paramContext);
    }
    this.Bz = (f1 * 10.0F);
    this.BY = new ArrayList();
  }
  
  static float au(View paramView)
  {
    return LayoutParams.a((LayoutParams)paramView.getLayoutParams());
  }
  
  private static boolean aw(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).gravity == 0;
  }
  
  static boolean ax(View paramView)
  {
    int i = f.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, z.J(paramView));
    if ((i & 0x3) != 0) {
      return true;
    }
    return (i & 0x5) != 0;
  }
  
  private void ay(View paramView)
  {
    if (!ax(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.yW)
    {
      LayoutParams.a(localLayoutParams, 1.0F);
      LayoutParams.a(localLayoutParams, 1);
      d(paramView, true);
    }
    for (;;)
    {
      invalidate();
      return;
      LayoutParams.b(localLayoutParams, 2);
      if (m(paramView, 3)) {
        this.BE.e(paramView, 0, paramView.getTop());
      } else {
        this.BF.e(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      }
    }
  }
  
  private static boolean c(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable == null) || (!android.support.v4.b.a.a.c(paramDrawable))) {
      return false;
    }
    android.support.v4.b.a.a.b(paramDrawable, paramInt);
    return true;
  }
  
  private View cm()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((LayoutParams.b((LayoutParams)localView.getLayoutParams()) & 0x1) == 1) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  private View cn()
  {
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      View localView = getChildAt(i);
      if (ax(localView))
      {
        if (!ax(localView)) {
          throw new IllegalArgumentException("View " + localView + " is not a drawer");
        }
        if (LayoutParams.a((LayoutParams)localView.getLayoutParams()) > 0.0F) {}
        for (int j = 1; j != 0; j = 0) {
          return localView;
        }
      }
      i += 1;
    }
    return null;
  }
  
  private void m(int paramInt1, int paramInt2)
  {
    int i = f.getAbsoluteGravity(paramInt2, z.J(this));
    Object localObject;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 != 0)
      {
        if (i == 3)
        {
          localObject = this.BE;
          label67:
          ((u)localObject).cancel();
        }
      }
      else {
        switch (paramInt1)
        {
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        this.BJ = paramInt1;
        break;
        this.BK = paramInt1;
        break;
        this.BL = paramInt1;
        break;
        this.BM = paramInt1;
        break;
        localObject = this.BF;
        break label67;
        localObject = af(i);
      } while (localObject == null);
      ay((View)localObject);
      return;
      localObject = af(i);
    } while (localObject == null);
    az((View)localObject);
  }
  
  private void t(boolean paramBoolean)
  {
    int m = getChildCount();
    int j = 0;
    int i = 0;
    if (j < m)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      boolean bool = i;
      int k;
      if (ax(localView)) {
        if (paramBoolean)
        {
          bool = i;
          if (!LayoutParams.c(localLayoutParams)) {}
        }
        else
        {
          k = localView.getWidth();
          if (!m(localView, 3)) {
            break label116;
          }
          i |= this.BE.e(localView, -k, localView.getTop());
        }
      }
      for (;;)
      {
        LayoutParams.a(localLayoutParams, false);
        k = i;
        j += 1;
        i = k;
        break;
        label116:
        i |= this.BF.e(localView, getWidth(), localView.getTop());
      }
    }
    this.BG.cl();
    this.BH.cl();
    if (i != 0) {
      invalidate();
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (getDescendantFocusability() == 393216) {
      return;
    }
    int m = getChildCount();
    int j = 0;
    int i = 0;
    View localView;
    if (j < m)
    {
      localView = getChildAt(j);
      int k;
      if (ax(localView))
      {
        if (!ax(localView)) {
          throw new IllegalArgumentException("View " + localView + " is not a drawer");
        }
        if ((LayoutParams.b((LayoutParams)localView.getLayoutParams()) & 0x1) == 1)
        {
          k = 1;
          label106:
          if (k == 0) {
            break label147;
          }
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          i = 1;
        }
      }
      label147:
      for (;;)
      {
        j += 1;
        break;
        k = 0;
        break label106;
        this.BY.add(localView);
      }
    }
    if (i == 0)
    {
      j = this.BY.size();
      i = 0;
      while (i < j)
      {
        localView = (View)this.BY.get(i);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i += 1;
      }
    }
    this.BY.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((cm() != null) || (ax(paramView))) {
      z.i(paramView, 4);
    }
    for (;;)
    {
      if (!Bw) {
        z.a(paramView, this.By);
      }
      return;
      z.i(paramView, 1);
    }
  }
  
  final View af(int paramInt)
  {
    int i = f.getAbsoluteGravity(paramInt, z.J(this));
    int j = getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      View localView = getChildAt(paramInt);
      if ((av(localView) & 0x7) == (i & 0x7)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  public final int at(View paramView)
  {
    if (!ax(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    int i = ((LayoutParams)paramView.getLayoutParams()).gravity;
    int j = z.J(this);
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      if (this.BJ != 3) {
        return this.BJ;
      }
      if (j == 0) {}
      for (i = this.BL; i != 3; i = this.BM) {
        return i;
      }
      if (this.BK != 3) {
        return this.BK;
      }
      if (j == 0) {}
      for (i = this.BM; i != 3; i = this.BL) {
        return i;
      }
      if (this.BL != 3) {
        return this.BL;
      }
      if (j == 0) {}
      for (i = this.BJ; i != 3; i = this.BK) {
        return i;
      }
      if (this.BM != 3) {
        return this.BM;
      }
      if (j == 0) {}
      for (i = this.BK; i != 3; i = this.BJ) {
        return i;
      }
    }
  }
  
  final int av(View paramView)
  {
    return f.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, z.J(this));
  }
  
  public final void az(View paramView)
  {
    if (!ax(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.yW)
    {
      LayoutParams.a(localLayoutParams, 0.0F);
      LayoutParams.a(localLayoutParams, 0);
    }
    for (;;)
    {
      invalidate();
      return;
      LayoutParams.b(localLayoutParams, 4);
      if (m(paramView, 3)) {
        this.BE.e(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        this.BF.e(paramView, getWidth(), paramView.getTop());
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    int j = getChildCount();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f = Math.max(f, LayoutParams.a((LayoutParams)getChildAt(i).getLayoutParams()));
      i += 1;
    }
    this.BC = f;
    if ((this.BE.cH() | this.BF.cH())) {
      z.F(this);
    }
  }
  
  final void d(View paramView, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (((!paramBoolean) && (!ax(localView))) || ((paramBoolean) && (localView == paramView))) {
        z.i(localView, 1);
      }
      for (;;)
      {
        i += 1;
        break;
        z.i(localView, 4);
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i2 = getHeight();
    boolean bool1 = aw(paramView);
    int j = 0;
    int n = 0;
    int i = getWidth();
    int i3 = paramCanvas.save();
    int k = i;
    int m;
    View localView;
    if (bool1)
    {
      int i4 = getChildCount();
      m = 0;
      j = n;
      if (m < i4)
      {
        localView = getChildAt(m);
        if ((localView != paramView) && (localView.getVisibility() == 0))
        {
          Drawable localDrawable = localView.getBackground();
          if (localDrawable != null) {
            if (localDrawable.getOpacity() == -1)
            {
              k = 1;
              label105:
              if ((k == 0) || (!ax(localView)) || (localView.getHeight() < i2)) {
                break label215;
              }
              if (!m(localView, 3)) {
                break label193;
              }
              k = localView.getRight();
              if (k <= j) {
                break label558;
              }
              j = k;
            }
          }
        }
      }
    }
    label193:
    label215:
    label558:
    for (;;)
    {
      n = j;
      k = i;
      for (;;)
      {
        m += 1;
        i = k;
        j = n;
        break;
        k = 0;
        break label105;
        k = 0;
        break label105;
        int i1 = localView.getLeft();
        k = i1;
        n = j;
        if (i1 >= i)
        {
          k = i;
          n = j;
        }
      }
      paramCanvas.clipRect(j, 0, i, getHeight());
      k = i;
      boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i3);
      if ((this.BC > 0.0F) && (bool1))
      {
        i = (int)(((this.BB & 0xFF000000) >>> 24) * this.BC);
        m = this.BB;
        this.BD.setColor(i << 24 | m & 0xFFFFFF);
        paramCanvas.drawRect(j, 0.0F, k, getHeight(), this.BD);
      }
      do
      {
        return bool2;
        if ((this.BP != null) && (m(paramView, 3)))
        {
          i = this.BP.getIntrinsicWidth();
          j = paramView.getRight();
          k = this.BE.EV;
          f = Math.max(0.0F, Math.min(j / k, 1.0F));
          this.BP.setBounds(j, paramView.getTop(), i + j, paramView.getBottom());
          this.BP.setAlpha((int)(255.0F * f));
          this.BP.draw(paramCanvas);
          return bool2;
        }
      } while ((this.BQ == null) || (!m(paramView, 5)));
      i = this.BQ.getIntrinsicWidth();
      j = paramView.getLeft();
      k = getWidth();
      m = this.BF.EV;
      float f = Math.max(0.0F, Math.min((k - j) / m, 1.0F));
      this.BQ.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
      this.BQ.setAlpha((int)(255.0F * f));
      this.BQ.draw(paramCanvas);
      return bool2;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  final void i(View paramView, float paramFloat)
  {
    paramView = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == LayoutParams.a(paramView)) {}
    for (;;)
    {
      return;
      LayoutParams.a(paramView, paramFloat);
      if (this.eE != null)
      {
        int i = this.eE.size() - 1;
        while (i >= 0)
        {
          this.eE.get(i);
          i -= 1;
        }
      }
    }
  }
  
  public final void k(Object paramObject, boolean paramBoolean)
  {
    this.BT = paramObject;
    this.hp = paramBoolean;
    if ((!paramBoolean) && (getBackground() == null)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setWillNotDraw(paramBoolean);
      requestLayout();
      return;
    }
  }
  
  final boolean m(View paramView, int paramInt)
  {
    return (av(paramView) & paramInt) == paramInt;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.yW = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.yW = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.hp) && (this.hq != null))
    {
      int i = BZ.G(this.BT);
      if (i > 0)
      {
        this.hq.setBounds(0, 0, getWidth(), i);
        this.hq.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int i = o.d(paramMotionEvent);
    boolean bool2 = this.BE.j(paramMotionEvent);
    boolean bool3 = this.BF.j(paramMotionEvent);
    label63:
    int j;
    label85:
    label113:
    float f1;
    float f2;
    switch (i)
    {
    default: 
      i = 0;
      if ((!(bool3 | bool2)) && (i == 0))
      {
        j = getChildCount();
        i = 0;
        if (i >= j) {
          break label373;
        }
        if (!LayoutParams.c((LayoutParams)getChildAt(i).getLayoutParams())) {
          break;
        }
        i = 1;
        if ((i == 0) && (!this.BO)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.xC = f1;
      this.xD = f2;
      if (this.BC > 0.0F)
      {
        paramMotionEvent = this.BE.r((int)f1, (int)f2);
        if ((paramMotionEvent == null) || (!aw(paramMotionEvent))) {}
      }
      break;
    }
    for (i = 1;; i = 0)
    {
      this.BN = false;
      this.BO = false;
      break label63;
      paramMotionEvent = this.BE;
      int k = paramMotionEvent.EL.length;
      j = 0;
      label214:
      if (j < k) {
        if (paramMotionEvent.an(j))
        {
          f1 = paramMotionEvent.EN[j] - paramMotionEvent.EL[j];
          f2 = paramMotionEvent.EO[j] - paramMotionEvent.EM[j];
          if (f1 * f1 + f2 * f2 > paramMotionEvent.iE * paramMotionEvent.iE)
          {
            i = 1;
            label286:
            if (i == 0) {
              break label331;
            }
          }
        }
      }
      for (i = 1; i != 0; i = 0)
      {
        this.BG.cl();
        this.BH.cl();
        i = 0;
        break label63;
        i = 0;
        break label286;
        i = 0;
        break label286;
        label331:
        j += 1;
        break label214;
      }
      t(true);
      this.BN = false;
      this.BO = false;
      break;
      i += 1;
      break label85;
      label373:
      i = 0;
      break label113;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (cn() != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        android.support.v4.view.g.b(paramKeyEvent);
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      paramKeyEvent = cn();
      if ((paramKeyEvent != null) && (at(paramKeyEvent) == 0)) {
        t(false);
      }
      if (paramKeyEvent != null) {
        bool = true;
      }
      return bool;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.pd = true;
    int m = paramInt3 - paramInt1;
    int n = getChildCount();
    paramInt3 = 0;
    while (paramInt3 < n)
    {
      View localView = getChildAt(paramInt3);
      LayoutParams localLayoutParams;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (aw(localView)) {
          localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
        }
      }
      else
      {
        paramInt3 += 1;
        continue;
      }
      int i1 = localView.getMeasuredWidth();
      int i2 = localView.getMeasuredHeight();
      int i;
      float f;
      label163:
      int j;
      if (m(localView, 3))
      {
        paramInt1 = -i1;
        i = (int)(i1 * LayoutParams.a(localLayoutParams)) + paramInt1;
        f = (i1 + i) / i1;
        if (f == LayoutParams.a(localLayoutParams)) {
          break label310;
        }
        j = 1;
        label177:
        switch (localLayoutParams.gravity & 0x70)
        {
        default: 
          localView.layout(i, localLayoutParams.topMargin, i1 + i, i2 + localLayoutParams.topMargin);
          label237:
          if (j != 0) {
            i(localView, f);
          }
          if (LayoutParams.a(localLayoutParams) <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i = m - (int)(i1 * LayoutParams.a(localLayoutParams));
        f = (m - i) / i1;
        break label163;
        label310:
        j = 0;
        break label177;
        paramInt1 = paramInt4 - paramInt2;
        localView.layout(i, paramInt1 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), i1 + i, paramInt1 - localLayoutParams.bottomMargin);
        break label237;
        int i3 = paramInt4 - paramInt2;
        int k = (i3 - i2) / 2;
        if (k < localLayoutParams.topMargin) {
          paramInt1 = localLayoutParams.topMargin;
        }
        for (;;)
        {
          localView.layout(i, paramInt1, i1 + i, i2 + paramInt1);
          break;
          paramInt1 = k;
          if (k + i2 > i3 - localLayoutParams.bottomMargin) {
            paramInt1 = i3 - localLayoutParams.bottomMargin - i2;
          }
        }
      }
    }
    this.pd = false;
    this.yW = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    int j;
    int i;
    if (i1 == 1073741824)
    {
      j = k;
      if (n == 1073741824) {}
    }
    else if (isInEditMode())
    {
      i = k;
      if (i1 != Integer.MIN_VALUE)
      {
        i = k;
        if (i1 == 0) {
          i = 300;
        }
      }
      j = i;
      if (n == Integer.MIN_VALUE) {
        break label614;
      }
      j = i;
      if (n != 0) {
        break label614;
      }
      k = 300;
    }
    for (m = i;; m = j)
    {
      setMeasuredDimension(m, k);
      label146:
      Object localObject1;
      int i2;
      int i3;
      Object localObject2;
      if ((this.BT != null) && (z.aa(this)))
      {
        n = 1;
        int i4 = z.J(this);
        i = 0;
        j = 0;
        int i5 = getChildCount();
        i1 = 0;
        if (i1 >= i5) {
          break label613;
        }
        localObject1 = getChildAt(i1);
        i2 = j;
        i3 = i;
        if (((View)localObject1).getVisibility() != 8)
        {
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          if (n != 0)
          {
            i2 = f.getAbsoluteGravity(((LayoutParams)localObject2).gravity, i4);
            if (!z.aa((View)localObject1)) {
              break label322;
            }
            BZ.a((View)localObject1, this.BT, i2);
          }
        }
      }
      for (;;)
      {
        if (!aw((View)localObject1)) {
          break label341;
        }
        ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(m - ((LayoutParams)localObject2).leftMargin - ((LayoutParams)localObject2).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(k - ((LayoutParams)localObject2).topMargin - ((LayoutParams)localObject2).bottomMargin, 1073741824));
        i3 = i;
        i2 = j;
        i1 += 1;
        j = i2;
        i = i3;
        break label146;
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        n = 0;
        break;
        label322:
        BZ.a((ViewGroup.MarginLayoutParams)localObject2, this.BT, i2);
      }
      label341:
      if (ax((View)localObject1))
      {
        if ((Bx) && (z.X((View)localObject1) != this.Bz)) {
          z.g((View)localObject1, this.Bz);
        }
        i3 = av((View)localObject1) & 0x7;
        if (i3 == 3)
        {
          i2 = 1;
          if (((i2 == 0) || (i == 0)) && ((i2 != 0) || (j == 0))) {
            break label497;
          }
          localObject2 = new StringBuilder("Child drawer has absolute gravity ");
          if ((i3 & 0x3) != 3) {
            break label471;
          }
          localObject1 = "LEFT";
        }
        for (;;)
        {
          throw new IllegalStateException((String)localObject1 + " but this DrawerLayout already has a drawer view along that edge");
          i2 = 0;
          break;
          label471:
          if ((i3 & 0x5) == 5) {
            localObject1 = "RIGHT";
          } else {
            localObject1 = Integer.toHexString(i3);
          }
        }
        label497:
        if (i2 != 0) {
          i = 1;
        }
        for (;;)
        {
          ((View)localObject1).measure(getChildMeasureSpec(paramInt1, this.BA + ((LayoutParams)localObject2).leftMargin + ((LayoutParams)localObject2).rightMargin, ((LayoutParams)localObject2).width), getChildMeasureSpec(paramInt2, ((LayoutParams)localObject2).topMargin + ((LayoutParams)localObject2).bottomMargin, ((LayoutParams)localObject2).height));
          i2 = j;
          i3 = i;
          break;
          j = 1;
        }
      }
      throw new IllegalStateException("Child " + localObject1 + " at index " + i1 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
      label613:
      return;
      label614:
      k = m;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getSuperState());
      if (paramParcelable.Ce != 0)
      {
        View localView = af(paramParcelable.Ce);
        if (localView != null) {
          ay(localView);
        }
      }
      if (paramParcelable.Cf != 3) {
        m(paramParcelable.Cf, 3);
      }
      if (paramParcelable.Cg != 3) {
        m(paramParcelable.Cg, 5);
      }
      if (paramParcelable.Ch != 3) {
        m(paramParcelable.Ch, 8388611);
      }
    } while (paramParcelable.Ci == 3);
    m(paramParcelable.Ci, 8388613);
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    Drawable localDrawable;
    if (!Bx)
    {
      paramInt = z.J(this);
      if (paramInt != 0) {
        break label77;
      }
      if (this.BU == null) {
        break label101;
      }
      c(this.BU, paramInt);
      localDrawable = this.BU;
      this.BP = localDrawable;
      paramInt = z.J(this);
      if (paramInt != 0) {
        break label109;
      }
      if (this.BV == null) {
        break label133;
      }
      c(this.BV, paramInt);
      localDrawable = this.BV;
    }
    for (;;)
    {
      this.BQ = localDrawable;
      return;
      label77:
      if (this.BV != null)
      {
        c(this.BV, paramInt);
        localDrawable = this.BV;
        break;
      }
      label101:
      localDrawable = this.BW;
      break;
      label109:
      if (this.BU != null)
      {
        c(this.BU, paramInt);
        localDrawable = this.BU;
      }
      else
      {
        label133:
        localDrawable = this.BX;
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    int m = getChildCount();
    int i = 0;
    for (;;)
    {
      LayoutParams localLayoutParams;
      int j;
      if (i < m)
      {
        localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
        if (LayoutParams.b(localLayoutParams) != 1) {
          break label119;
        }
        j = 1;
        if (LayoutParams.b(localLayoutParams) != 2) {
          break label124;
        }
      }
      label119:
      label124:
      for (int k = 1;; k = 0)
      {
        if ((j == 0) && (k == 0)) {
          break label129;
        }
        localSavedState.Ce = localLayoutParams.gravity;
        localSavedState.Cf = this.BJ;
        localSavedState.Cg = this.BK;
        localSavedState.Ch = this.BL;
        localSavedState.Ci = this.BM;
        return localSavedState;
        j = 0;
        break;
      }
      label129:
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.BE.k(paramMotionEvent);
    this.BF.k(paramMotionEvent);
    float f1;
    float f2;
    boolean bool;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return true;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.xC = f1;
      this.xD = f2;
      this.BN = false;
      this.BO = false;
      return true;
    case 1: 
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = this.BE.r((int)f2, (int)f1);
      if ((paramMotionEvent != null) && (aw(paramMotionEvent)))
      {
        f2 -= this.xC;
        f1 -= this.xD;
        int i = this.BE.iE;
        if (f2 * f2 + f1 * f1 < i * i)
        {
          paramMotionEvent = cm();
          if (paramMotionEvent != null) {
            if (at(paramMotionEvent) == 2) {
              bool = true;
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      t(bool);
      this.BN = false;
      return true;
      bool = false;
      continue;
      t(true);
      this.BN = false;
      this.BO = false;
      return true;
      bool = true;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.BN = paramBoolean;
    if (paramBoolean) {
      t(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.pd) {
      super.requestLayout();
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private float Cb;
    private boolean Cc;
    private int Cd;
    public int gravity = 0;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.bX());
      this.gravity = paramContext.getInt(0, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.gravity = paramLayoutParams.gravity;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  protected static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int Ce = 0;
    int Cf;
    int Cg;
    int Ch;
    int Ci;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.Ce = paramParcel.readInt();
      this.Cf = paramParcel.readInt();
      this.Cg = paramParcel.readInt();
      this.Ch = paramParcel.readInt();
      this.Ci = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.Ce);
      paramParcel.writeInt(this.Cf);
      paramParcel.writeInt(this.Cg);
      paramParcel.writeInt(this.Ch);
      paramParcel.writeInt(this.Ci);
    }
  }
  
  final class a
    extends android.support.v4.view.a
  {
    private final Rect gG = new Rect();
    
    a() {}
    
    public final void a(View paramView, b paramb)
    {
      if (DrawerLayout.co()) {
        super.a(paramView, paramb);
      }
      for (;;)
      {
        paramb.setClassName(DrawerLayout.class.getName());
        paramb.setFocusable(false);
        paramb.setFocused(false);
        paramb.a(b.a.zM);
        paramb.a(b.a.zN);
        return;
        Object localObject1 = b.a(paramb);
        super.a(paramView, (b)localObject1);
        paramb.setSource(paramView);
        Object localObject2 = z.K(paramView);
        if ((localObject2 instanceof View)) {
          paramb.setParent((View)localObject2);
        }
        localObject2 = this.gG;
        ((b)localObject1).getBoundsInParent((Rect)localObject2);
        paramb.setBoundsInParent((Rect)localObject2);
        ((b)localObject1).getBoundsInScreen((Rect)localObject2);
        paramb.setBoundsInScreen((Rect)localObject2);
        paramb.setVisibleToUser(((b)localObject1).isVisibleToUser());
        paramb.setPackageName(((b)localObject1).getPackageName());
        paramb.setClassName(((b)localObject1).getClassName());
        paramb.setContentDescription(((b)localObject1).getContentDescription());
        paramb.setEnabled(((b)localObject1).isEnabled());
        paramb.setClickable(((b)localObject1).isClickable());
        paramb.setFocusable(((b)localObject1).isFocusable());
        paramb.setFocused(((b)localObject1).isFocused());
        paramb.setAccessibilityFocused(((b)localObject1).isAccessibilityFocused());
        paramb.setSelected(((b)localObject1).isSelected());
        paramb.setLongClickable(((b)localObject1).isLongClickable());
        paramb.addAction(((b)localObject1).getActions());
        ((b)localObject1).recycle();
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          localObject1 = paramView.getChildAt(i);
          if (DrawerLayout.aA((View)localObject1)) {
            paramb.addChild((View)localObject1);
          }
          i += 1;
        }
      }
    }
    
    public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramAccessibilityEvent = paramAccessibilityEvent.getText();
        paramView = DrawerLayout.a(DrawerLayout.this);
        int i;
        if (paramView != null)
        {
          i = DrawerLayout.this.av(paramView);
          paramView = DrawerLayout.this;
          i = f.getAbsoluteGravity(i, z.J(paramView));
          if (i != 3) {
            break label73;
          }
          paramView = paramView.BR;
        }
        for (;;)
        {
          if (paramView != null) {
            paramAccessibilityEvent.add(paramView);
          }
          return true;
          label73:
          if (i == 5) {
            paramView = paramView.BS;
          } else {
            paramView = null;
          }
        }
      }
      return super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if ((DrawerLayout.co()) || (DrawerLayout.aA(paramView))) {
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
  }
  
  final class b
    extends android.support.v4.view.a
  {
    b() {}
    
    public final void a(View paramView, b paramb)
    {
      super.a(paramView, paramb);
      if (!DrawerLayout.aA(paramView)) {
        paramb.setParent(null);
      }
    }
  }
  
  static abstract interface c
  {
    public abstract int G(Object paramObject);
    
    public abstract void a(View paramView, Object paramObject, int paramInt);
    
    public abstract void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt);
    
    public abstract void aB(View paramView);
    
    public abstract Drawable l(Context paramContext);
  }
  
  static final class d
    implements DrawerLayout.c
  {
    public final int G(Object paramObject)
    {
      return g.G(paramObject);
    }
    
    public final void a(View paramView, Object paramObject, int paramInt)
    {
      g.a(paramView, paramObject, paramInt);
    }
    
    public final void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt)
    {
      g.a(paramMarginLayoutParams, paramObject, paramInt);
    }
    
    public final void aB(View paramView)
    {
      g.aB(paramView);
    }
    
    public final Drawable l(Context paramContext)
    {
      return g.l(paramContext);
    }
  }
  
  static final class e
    implements DrawerLayout.c
  {
    public final int G(Object paramObject)
    {
      return 0;
    }
    
    public final void a(View paramView, Object paramObject, int paramInt) {}
    
    public final void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt) {}
    
    public final void aB(View paramView) {}
    
    public final Drawable l(Context paramContext)
    {
      return null;
    }
  }
  
  private final class f
    extends u.a
  {
    final int Cj;
    u Ck;
    private final Runnable Cl = new Runnable()
    {
      public final void run()
      {
        int k = 0;
        Object localObject2 = DrawerLayout.f.this;
        int m = ((DrawerLayout.f)localObject2).Ck.EV;
        int i;
        Object localObject1;
        int j;
        if (((DrawerLayout.f)localObject2).Cj == 3)
        {
          i = 1;
          if (i == 0) {
            break label227;
          }
          localObject1 = ((DrawerLayout.f)localObject2).Ca.af(3);
          if (localObject1 == null) {
            break label222;
          }
          j = -((View)localObject1).getWidth();
          label56:
          j += m;
        }
        for (;;)
        {
          label61:
          if ((localObject1 != null) && (((i != 0) && (((View)localObject1).getLeft() < j)) || ((i == 0) && (((View)localObject1).getLeft() > j) && (((DrawerLayout.f)localObject2).Ca.at((View)localObject1) == 0))))
          {
            DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)((View)localObject1).getLayoutParams();
            ((DrawerLayout.f)localObject2).Ck.e((View)localObject1, j, ((View)localObject1).getTop());
            DrawerLayout.LayoutParams.a(localLayoutParams, true);
            ((DrawerLayout.f)localObject2).Ca.invalidate();
            ((DrawerLayout.f)localObject2).cp();
            localObject1 = ((DrawerLayout.f)localObject2).Ca;
            if (!((DrawerLayout)localObject1).BO)
            {
              long l = SystemClock.uptimeMillis();
              localObject2 = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
              j = ((DrawerLayout)localObject1).getChildCount();
              i = k;
              for (;;)
              {
                if (i < j)
                {
                  ((DrawerLayout)localObject1).getChildAt(i).dispatchTouchEvent((MotionEvent)localObject2);
                  i += 1;
                  continue;
                  i = 0;
                  break;
                  label222:
                  j = 0;
                  break label56;
                  label227:
                  localObject1 = ((DrawerLayout.f)localObject2).Ca.af(5);
                  j = ((DrawerLayout.f)localObject2).Ca.getWidth() - m;
                  break label61;
                }
              }
              ((MotionEvent)localObject2).recycle();
              ((DrawerLayout)localObject1).BO = true;
            }
          }
        }
      }
    };
    
    public f(int paramInt)
    {
      this.Cj = paramInt;
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      paramFloat2 = DrawerLayout.au(paramView);
      int k = paramView.getWidth();
      int i;
      if (DrawerLayout.this.m(paramView, 3)) {
        if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
          i = 0;
        }
      }
      for (;;)
      {
        this.Ck.q(i, paramView.getTop());
        DrawerLayout.this.invalidate();
        return;
        i = -k;
        continue;
        int j = DrawerLayout.this.getWidth();
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (paramFloat2 <= 0.5F) {}
          }
        }
        else
        {
          i = j - k;
        }
      }
    }
    
    public final void a(View paramView, int paramInt1, int paramInt2)
    {
      paramInt2 = paramView.getWidth();
      float f;
      if (DrawerLayout.this.m(paramView, 3))
      {
        f = (paramInt2 + paramInt1) / paramInt2;
        DrawerLayout.this.i(paramView, f);
        if (f != 0.0F) {
          break label76;
        }
      }
      label76:
      for (paramInt1 = 4;; paramInt1 = 0)
      {
        paramView.setVisibility(paramInt1);
        DrawerLayout.this.invalidate();
        return;
        f = (DrawerLayout.this.getWidth() - paramInt1) / paramInt2;
        break;
      }
    }
    
    public final boolean b(View paramView, int paramInt)
    {
      return (DrawerLayout.ax(paramView)) && (DrawerLayout.this.m(paramView, this.Cj)) && (DrawerLayout.this.at(paramView) == 0);
    }
    
    public final int c(View paramView, int paramInt)
    {
      return paramView.getTop();
    }
    
    public final void cl()
    {
      DrawerLayout.this.removeCallbacks(this.Cl);
    }
    
    final void cp()
    {
      int i = 3;
      if (this.Cj == 3) {
        i = 5;
      }
      View localView = DrawerLayout.this.af(i);
      if (localView != null) {
        DrawerLayout.this.az(localView);
      }
    }
    
    public final void cq()
    {
      DrawerLayout.this.postDelayed(this.Cl, 160L);
    }
    
    public final int d(View paramView, int paramInt)
    {
      if (DrawerLayout.this.m(paramView, 3)) {
        return Math.max(-paramView.getWidth(), Math.min(paramInt, 0));
      }
      int i = DrawerLayout.this.getWidth();
      return Math.max(i - paramView.getWidth(), Math.min(paramInt, i));
    }
    
    public final void f(View paramView, int paramInt)
    {
      DrawerLayout.LayoutParams.a((DrawerLayout.LayoutParams)paramView.getLayoutParams(), false);
      cp();
    }
    
    public final void j(int paramInt)
    {
      DrawerLayout localDrawerLayout = DrawerLayout.this;
      View localView = this.Ck.EY;
      int i = localDrawerLayout.BE.EK;
      int j = localDrawerLayout.BF.EK;
      if ((i == 1) || (j == 1)) {
        i = 1;
      }
      DrawerLayout.LayoutParams localLayoutParams;
      while ((localView != null) && (paramInt == 0))
      {
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (DrawerLayout.LayoutParams.a(localLayoutParams) != 0.0F) {
          break label260;
        }
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if ((DrawerLayout.LayoutParams.b(localLayoutParams) & 0x1) == 1)
        {
          DrawerLayout.LayoutParams.a(localLayoutParams, 0);
          if (localDrawerLayout.eE != null)
          {
            paramInt = localDrawerLayout.eE.size() - 1;
            for (;;)
            {
              if (paramInt >= 0)
              {
                localDrawerLayout.eE.get(paramInt);
                paramInt -= 1;
                continue;
                if ((i == 2) || (j == 2))
                {
                  i = 2;
                  break;
                }
                i = 0;
                break;
              }
            }
          }
          localDrawerLayout.d(localView, false);
          if (localDrawerLayout.hasWindowFocus())
          {
            localView = localDrawerLayout.getRootView();
            if (localView != null) {
              localView.sendAccessibilityEvent(32);
            }
          }
        }
      }
      while (i != localDrawerLayout.BI)
      {
        localDrawerLayout.BI = i;
        if (localDrawerLayout.eE == null) {
          break;
        }
        paramInt = localDrawerLayout.eE.size() - 1;
        while (paramInt >= 0)
        {
          localDrawerLayout.eE.get(paramInt);
          paramInt -= 1;
        }
        label260:
        if (DrawerLayout.LayoutParams.a(localLayoutParams) == 1.0F)
        {
          localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
          if ((DrawerLayout.LayoutParams.b(localLayoutParams) & 0x1) == 0)
          {
            DrawerLayout.LayoutParams.a(localLayoutParams, 1);
            if (localDrawerLayout.eE != null)
            {
              paramInt = localDrawerLayout.eE.size() - 1;
              while (paramInt >= 0)
              {
                localDrawerLayout.eE.get(paramInt);
                paramInt -= 1;
              }
            }
            localDrawerLayout.d(localView, true);
            if (localDrawerLayout.hasWindowFocus()) {
              localDrawerLayout.sendAccessibilityEvent(32);
            }
            localView.requestFocus();
          }
        }
      }
    }
    
    public final void n(int paramInt1, int paramInt2)
    {
      if ((paramInt1 & 0x1) == 1) {}
      for (View localView = DrawerLayout.this.af(3);; localView = DrawerLayout.this.af(5))
      {
        if ((localView != null) && (DrawerLayout.this.at(localView) == 0)) {
          this.Ck.n(localView, paramInt2);
        }
        return;
      }
    }
    
    public final int s(View paramView)
    {
      if (DrawerLayout.ax(paramView)) {
        return paramView.getWidth();
      }
      return 0;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/widget/DrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */