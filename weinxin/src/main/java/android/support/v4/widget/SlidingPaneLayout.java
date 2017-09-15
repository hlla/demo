package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.e;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout
  extends ViewGroup
{
  static final d DL = new e();
  private Drawable DA;
  private final int DB;
  private boolean DC;
  private View DD;
  private float DE;
  private float DF;
  private int DG;
  private int DH;
  private final u DI;
  private boolean DJ;
  private final ArrayList<b> DK = new ArrayList();
  private int Dx = -858993460;
  private int Dy;
  private Drawable Dz;
  private final Rect gG = new Rect();
  private float xC;
  private float xD;
  private boolean yK;
  private boolean yW = true;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 17)
    {
      DL = new g();
      return;
    }
    if (i >= 16)
    {
      DL = new f();
      return;
    }
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.DB = ((int)(32.0F * f + 0.5F));
    ViewConfiguration.get(paramContext);
    setWillNotDraw(false);
    z.a(this, new a());
    z.i(this, 1);
    this.DI = u.a(this, 0.5F, new c());
    this.DI.EU = (f * 400.0F);
  }
  
  private void A(float paramFloat)
  {
    boolean bool = cD();
    Object localObject = (LayoutParams)this.DD.getLayoutParams();
    int i;
    label43:
    int j;
    if (((LayoutParams)localObject).DP) {
      if (bool)
      {
        i = ((LayoutParams)localObject).rightMargin;
        if (i > 0) {
          break label177;
        }
        i = 1;
        int n = getChildCount();
        j = 0;
        label52:
        if (j >= n) {
          return;
        }
        localObject = getChildAt(j);
        if (localObject != this.DD)
        {
          int k = (int)((1.0F - this.DF) * this.DH);
          this.DF = paramFloat;
          int m = k - (int)((1.0F - paramFloat) * this.DH);
          k = m;
          if (bool) {
            k = -m;
          }
          ((View)localObject).offsetLeftAndRight(k);
          if (i != 0) {
            if (!bool) {
              break label182;
            }
          }
        }
      }
    }
    label177:
    label182:
    for (float f = this.DF - 1.0F;; f = 1.0F - this.DF)
    {
      a((View)localObject, f, this.Dy);
      j += 1;
      break label52;
      i = ((LayoutParams)localObject).leftMargin;
      break;
      i = 0;
      break label43;
    }
  }
  
  private void a(View paramView, float paramFloat, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (localLayoutParams.DQ == null) {
        localLayoutParams.DQ = new Paint();
      }
      localLayoutParams.DQ.setColorFilter(new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (z.I(paramView) != 2) {
        z.a(paramView, 2, localLayoutParams.DQ);
      }
      aF(paramView);
    }
    while (z.I(paramView) == 0)
    {
      int i;
      return;
    }
    if (localLayoutParams.DQ != null) {
      localLayoutParams.DQ.setColorFilter(null);
    }
    paramView = new b(paramView);
    this.DK.add(paramView);
    z.a(this, paramView);
  }
  
  private void aF(View paramView)
  {
    DL.b(this, paramView);
  }
  
  private boolean cC()
  {
    boolean bool = false;
    if ((this.yW) || (z(0.0F)))
    {
      this.DJ = false;
      bool = true;
    }
    return bool;
  }
  
  private boolean cD()
  {
    return z.J(this) == 1;
  }
  
  private boolean z(float paramFloat)
  {
    if (!this.DC) {
      return false;
    }
    boolean bool = cD();
    LayoutParams localLayoutParams = (LayoutParams)this.DD.getLayoutParams();
    int j;
    int k;
    if (bool)
    {
      i = getPaddingRight();
      j = localLayoutParams.rightMargin;
      k = this.DD.getWidth();
    }
    for (int i = (int)(getWidth() - (j + i + this.DG * paramFloat + k)); this.DI.e(this.DD, i, this.DD.getTop()); i = (int)(localLayoutParams.leftMargin + i + this.DG * paramFloat))
    {
      cB();
      z.F(this);
      return true;
      i = getPaddingLeft();
    }
    return false;
  }
  
  final void aE(View paramView)
  {
    boolean bool = cD();
    int i;
    int j;
    label31:
    int k;
    label63:
    int i1;
    int n;
    int m;
    label92:
    int i2;
    label101:
    Object localObject;
    if (bool)
    {
      i = getWidth() - getPaddingRight();
      if (!bool) {
        break label244;
      }
      j = getPaddingLeft();
      int i4 = getPaddingTop();
      int i5 = getHeight();
      int i6 = getPaddingBottom();
      if (paramView == null) {
        break label303;
      }
      if (!z.L(paramView)) {
        break label257;
      }
      k = 1;
      if (k == 0) {
        break label303;
      }
      i1 = paramView.getLeft();
      n = paramView.getRight();
      m = paramView.getTop();
      k = paramView.getBottom();
      int i7 = getChildCount();
      i2 = 0;
      if (i2 >= i7) {
        return;
      }
      localObject = getChildAt(i2);
      if (localObject == paramView) {
        return;
      }
      if (!bool) {
        break label318;
      }
      i3 = j;
      label130:
      int i8 = Math.max(i3, ((View)localObject).getLeft());
      int i9 = Math.max(i4, ((View)localObject).getTop());
      if (!bool) {
        break label324;
      }
      i3 = i;
      label162:
      i3 = Math.min(i3, ((View)localObject).getRight());
      int i10 = Math.min(i5 - i6, ((View)localObject).getBottom());
      if ((i8 < i1) || (i9 < m) || (i3 > n) || (i10 > k)) {
        break label330;
      }
    }
    label244:
    label257:
    label303:
    label318:
    label324:
    label330:
    for (int i3 = 4;; i3 = 0)
    {
      ((View)localObject).setVisibility(i3);
      i2 += 1;
      break label101;
      i = getPaddingLeft();
      break;
      j = getWidth() - getPaddingRight();
      break label31;
      if (Build.VERSION.SDK_INT < 18)
      {
        localObject = paramView.getBackground();
        if (localObject != null)
        {
          if (((Drawable)localObject).getOpacity() == -1)
          {
            k = 1;
            break label63;
          }
          k = 0;
          break label63;
        }
      }
      k = 0;
      break label63;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      break label92;
      i3 = i;
      break label130;
      i3 = j;
      break label162;
    }
  }
  
  final boolean aG(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView = (LayoutParams)paramView.getLayoutParams();
    return (this.DC) && (paramView.DP) && (this.DE > 0.0F);
  }
  
  final void cB()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i += 1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if (this.DI.cH())
    {
      if (!this.DC) {
        this.DI.abort();
      }
    }
    else {
      return;
    }
    z.F(this);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    if (cD())
    {
      localDrawable = this.DA;
      if (getChildCount() <= 1) {
        break label53;
      }
    }
    label53:
    for (View localView = getChildAt(1);; localView = null)
    {
      if ((localView != null) && (localDrawable != null)) {
        break label59;
      }
      return;
      localDrawable = this.Dz;
      break;
    }
    label59:
    int k = localView.getTop();
    int m = localView.getBottom();
    int n = localDrawable.getIntrinsicWidth();
    int j;
    int i;
    if (cD())
    {
      j = localView.getRight();
      i = j + n;
    }
    for (;;)
    {
      localDrawable.setBounds(j, k, i, m);
      localDrawable.draw(paramCanvas);
      return;
      i = localView.getLeft();
      j = i - n;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save(2);
    if ((this.DC) && (!localLayoutParams.DO) && (this.DD != null))
    {
      paramCanvas.getClipBounds(this.gG);
      if (!cD()) {
        break label168;
      }
      this.gG.left = Math.max(this.gG.left, this.DD.getRight());
    }
    boolean bool;
    for (;;)
    {
      paramCanvas.clipRect(this.gG);
      if (Build.VERSION.SDK_INT >= 11) {
        break label216;
      }
      if ((!localLayoutParams.DP) || (this.DE <= 0.0F)) {
        break label228;
      }
      if (!paramView.isDrawingCacheEnabled()) {
        paramView.setDrawingCacheEnabled(true);
      }
      Bitmap localBitmap = paramView.getDrawingCache();
      if (localBitmap == null) {
        break;
      }
      paramCanvas.drawBitmap(localBitmap, paramView.getLeft(), paramView.getTop(), localLayoutParams.DQ);
      bool = false;
      paramCanvas.restoreToCount(i);
      return bool;
      label168:
      this.gG.right = Math.min(this.gG.right, this.DD.getLeft());
    }
    new StringBuilder("drawChild: child view ").append(paramView).append(" returned null drawing cache");
    for (;;)
    {
      label216:
      bool = super.drawChild(paramCanvas, paramView, paramLong);
      break;
      label228:
      if (paramView.isDrawingCacheEnabled()) {
        paramView.setDrawingCacheEnabled(false);
      }
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
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
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
    int j = this.DK.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.DK.get(i)).run();
      i += 1;
    }
    this.DK.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = o.d(paramMotionEvent);
    if ((!this.DC) && (i == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null) {
        if (u.f(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label104;
        }
      }
    }
    label104:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.DJ = bool1;
      if ((this.DC) && ((!this.yK) || (i == 0))) {
        break;
      }
      this.DI.cancel();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    if ((i == 3) || (i == 1))
    {
      this.DI.cancel();
      return false;
    }
    switch (i)
    {
    }
    label160:
    float f1;
    float f2;
    do
    {
      for (i = 0;; i = 1)
      {
        if (!this.DI.j(paramMotionEvent))
        {
          bool1 = bool2;
          if (i == 0) {
            break;
          }
        }
        return true;
        this.yK = false;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.xC = f1;
        this.xD = f2;
        if ((!u.f(this.DD, (int)f1, (int)f2)) || (!aG(this.DD))) {
          break label160;
        }
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      f2 = Math.abs(f2 - this.xC);
      f1 = Math.abs(f1 - this.xD);
    } while ((f2 <= this.DI.iE) || (f1 <= f2));
    this.DI.cancel();
    this.yK = true;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = cD();
    label35:
    label46:
    int m;
    float f;
    label82:
    label93:
    LayoutParams localLayoutParams;
    int i1;
    int j;
    int i;
    if (bool)
    {
      this.DI.EW = 2;
      int k = paramInt3 - paramInt1;
      if (!bool) {
        break label352;
      }
      paramInt1 = getPaddingRight();
      if (!bool) {
        break label360;
      }
      paramInt3 = getPaddingLeft();
      int n = getPaddingTop();
      m = getChildCount();
      if (this.yW)
      {
        if ((!this.DC) || (!this.DJ)) {
          break label369;
        }
        f = 1.0F;
        this.DE = f;
      }
      paramInt4 = 0;
      paramInt2 = paramInt1;
      if (paramInt4 >= m) {
        break label442;
      }
      View localView = getChildAt(paramInt4);
      if (localView.getVisibility() == 8) {
        break label551;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      i1 = localView.getMeasuredWidth();
      j = 0;
      if (!localLayoutParams.DO) {
        break label390;
      }
      i = localLayoutParams.leftMargin;
      int i2 = localLayoutParams.rightMargin;
      i2 = Math.min(paramInt1, k - paramInt3 - this.DB) - paramInt2 - (i + i2);
      this.DG = i2;
      if (!bool) {
        break label375;
      }
      i = localLayoutParams.rightMargin;
      label202:
      if (paramInt2 + i + i2 + i1 / 2 <= k - paramInt3) {
        break label385;
      }
      paramBoolean = true;
      label224:
      localLayoutParams.DP = paramBoolean;
      i2 = (int)(i2 * this.DE);
      paramInt2 += i + i2;
      this.DE = (i2 / this.DG);
      i = j;
      if (!bool) {
        break label426;
      }
      j = k - paramInt2 + i;
      i = j - i1;
      label287:
      localView.layout(i, n, j, localView.getMeasuredHeight() + n);
      i = localView.getWidth() + paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
    for (;;)
    {
      i = paramInt4 + 1;
      paramInt4 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = paramInt4;
      paramInt4 = i;
      break label93;
      this.DI.EW = 1;
      break;
      label352:
      paramInt1 = getPaddingLeft();
      break label35;
      label360:
      paramInt3 = getPaddingRight();
      break label46;
      label369:
      f = 0.0F;
      break label82;
      label375:
      i = localLayoutParams.leftMargin;
      break label202;
      label385:
      paramBoolean = false;
      break label224;
      label390:
      if ((this.DC) && (this.DH != 0)) {}
      for (paramInt2 = (int)((1.0F - this.DE) * this.DH);; paramInt2 = 0)
      {
        i = paramInt2;
        paramInt2 = paramInt1;
        break;
        label426:
        i = paramInt2 - i;
        j = i + i1;
        break label287;
        label442:
        if (this.yW)
        {
          if (!this.DC) {
            break label517;
          }
          if (this.DH != 0) {
            A(this.DE);
          }
          if (((LayoutParams)this.DD.getLayoutParams()).DP) {
            a(this.DD, this.DE, this.Dx);
          }
        }
        for (;;)
        {
          aE(this.DD);
          this.yW = false;
          return;
          label517:
          paramInt1 = 0;
          while (paramInt1 < m)
          {
            a(getChildAt(paramInt1), 0.0F, this.Dx);
            paramInt1 += 1;
          }
        }
      }
      label551:
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (k != 1073741824) {
      if (isInEditMode())
      {
        if ((k == Integer.MIN_VALUE) || (k != 0)) {
          break label1069;
        }
        i = j;
        j = 300;
      }
    }
    for (;;)
    {
      label93:
      boolean bool1;
      int i2;
      int i3;
      int i1;
      float f1;
      label129:
      View localView;
      LayoutParams localLayoutParams;
      int m;
      switch (i)
      {
      default: 
        paramInt1 = 0;
        k = -1;
        bool1 = false;
        i2 = j - getPaddingLeft() - getPaddingRight();
        i3 = getChildCount();
        this.DD = null;
        i1 = 0;
        paramInt2 = i2;
        f1 = 0.0F;
        if (i1 < i3)
        {
          localView = getChildAt(i1);
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (localView.getVisibility() == 8)
          {
            localLayoutParams.DP = false;
            m = paramInt2;
            paramInt2 = paramInt1;
            paramInt1 = m;
          }
        }
        break;
      }
      for (;;)
      {
        i1 += 1;
        m = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = m;
        break label129;
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        if (j != 0) {
          break label1069;
        }
        if (isInEditMode())
        {
          if (j != 0) {
            break label1069;
          }
          paramInt2 = Integer.MIN_VALUE;
          j = i;
          paramInt1 = 300;
          i = paramInt2;
          break;
        }
        throw new IllegalStateException("Height must not be UNSPECIFIED");
        paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
        k = paramInt1;
        break label93;
        k = getPaddingTop();
        m = getPaddingBottom();
        paramInt2 = 0;
        k = paramInt1 - k - m;
        paramInt1 = paramInt2;
        break label93;
        float f2 = f1;
        if (localLayoutParams.weight > 0.0F)
        {
          f2 = f1 + localLayoutParams.weight;
          if (localLayoutParams.width == 0) {}
        }
        else
        {
          m = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
          label364:
          int n;
          label384:
          int i4;
          if (localLayoutParams.width == -2)
          {
            m = View.MeasureSpec.makeMeasureSpec(i2 - m, Integer.MIN_VALUE);
            if (localLayoutParams.height != -2) {
              break label526;
            }
            n = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
            localView.measure(m, n);
            n = localView.getMeasuredWidth();
            i4 = localView.getMeasuredHeight();
            m = paramInt1;
            if (i == Integer.MIN_VALUE)
            {
              m = paramInt1;
              if (i4 > paramInt1) {
                m = Math.min(i4, k);
              }
            }
            paramInt1 = paramInt2 - n;
            if (paramInt1 >= 0) {
              break label564;
            }
          }
          label526:
          label564:
          for (boolean bool2 = true;; bool2 = false)
          {
            localLayoutParams.DO = bool2;
            if (localLayoutParams.DO) {
              this.DD = localView;
            }
            f1 = f2;
            bool1 = bool2 | bool1;
            paramInt2 = m;
            break;
            if (localLayoutParams.width == -1)
            {
              m = View.MeasureSpec.makeMeasureSpec(i2 - m, 1073741824);
              break label364;
            }
            m = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
            break label364;
            if (localLayoutParams.height == -1)
            {
              n = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
              break label384;
            }
            n = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
            break label384;
          }
          if ((bool1) || (f1 > 0.0F))
          {
            i1 = i2 - this.DB;
            m = 0;
            if (m < i3)
            {
              localView = getChildAt(m);
              if (localView.getVisibility() != 8)
              {
                localLayoutParams = (LayoutParams)localView.getLayoutParams();
                if (localView.getVisibility() != 8)
                {
                  if ((localLayoutParams.width != 0) || (localLayoutParams.weight <= 0.0F)) {
                    break label755;
                  }
                  i = 1;
                  label659:
                  if (i == 0) {
                    break label761;
                  }
                  n = 0;
                  label667:
                  if ((!bool1) || (localView == this.DD)) {
                    break label825;
                  }
                  if ((localLayoutParams.width < 0) && ((n > i1) || (localLayoutParams.weight > 0.0F)))
                  {
                    if (i == 0) {
                      break label809;
                    }
                    if (localLayoutParams.height != -2) {
                      break label771;
                    }
                    i = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
                    label731:
                    localView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), i);
                  }
                }
              }
              for (;;)
              {
                m += 1;
                break;
                label755:
                i = 0;
                break label659;
                label761:
                n = localView.getMeasuredWidth();
                break label667;
                label771:
                if (localLayoutParams.height == -1)
                {
                  i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                  break label731;
                }
                i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                break label731;
                label809:
                i = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                break label731;
                label825:
                if (localLayoutParams.weight > 0.0F)
                {
                  if (localLayoutParams.width == 0) {
                    if (localLayoutParams.height == -2) {
                      i = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
                    }
                  }
                  for (;;)
                  {
                    if (!bool1) {
                      break label971;
                    }
                    i4 = localLayoutParams.leftMargin;
                    i4 = i2 - (localLayoutParams.rightMargin + i4);
                    int i5 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                    if (n == i4) {
                      break;
                    }
                    localView.measure(i5, i);
                    break;
                    if (localLayoutParams.height == -1)
                    {
                      i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                    }
                    else
                    {
                      i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                      continue;
                      i = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                    }
                  }
                  label971:
                  i4 = Math.max(0, paramInt2);
                  localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.weight * i4 / f1) + n, 1073741824), i);
                }
              }
            }
          }
          setMeasuredDimension(j, getPaddingTop() + paramInt1 + getPaddingBottom());
          this.DC = bool1;
          if ((this.DI.EK != 0) && (!bool1)) {
            this.DI.abort();
          }
          return;
        }
        m = paramInt1;
        f1 = f2;
        paramInt1 = paramInt2;
        paramInt2 = m;
      }
      label1069:
      paramInt2 = j;
      j = i;
      i = paramInt2;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.DR) {
      if ((this.yW) || (z(1.0F))) {
        this.DJ = true;
      }
    }
    for (;;)
    {
      this.DJ = paramParcelable.DR;
      return;
      cC();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    boolean bool;
    if (this.DC) {
      if ((!this.DC) || (this.DE == 1.0F)) {
        bool = true;
      }
    }
    for (;;)
    {
      localSavedState.DR = bool;
      return localSavedState;
      bool = false;
      continue;
      bool = this.DJ;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.yW = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.DC) {
      return super.onTouchEvent(paramMotionEvent);
    }
    this.DI.k(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.xC = f1;
      this.xD = f2;
      continue;
      if (aG(this.DD))
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        float f3 = f1 - this.xC;
        float f4 = f2 - this.xD;
        int i = this.DI.iE;
        if ((f3 * f3 + f4 * f4 < i * i) && (u.f(this.DD, (int)f1, (int)f2))) {
          cC();
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.DC)) {
      if (paramView1 != this.DD) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.DJ = bool;
      return;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int[] xQ = { 16843137 };
    boolean DO;
    boolean DP;
    Paint DQ;
    public float weight = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, xQ);
      this.weight = paramContext.getFloat(0, 0.0F);
      paramContext.recycle();
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
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    boolean DR;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.DR = bool;
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.DR) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  final class a
    extends a
  {
    private final Rect gG = new Rect();
    
    a() {}
    
    private boolean aH(View paramView)
    {
      return SlidingPaneLayout.this.aG(paramView);
    }
    
    public final void a(View paramView, b paramb)
    {
      b localb = b.a(paramb);
      super.a(paramView, localb);
      Rect localRect = this.gG;
      localb.getBoundsInParent(localRect);
      paramb.setBoundsInParent(localRect);
      localb.getBoundsInScreen(localRect);
      paramb.setBoundsInScreen(localRect);
      paramb.setVisibleToUser(localb.isVisibleToUser());
      paramb.setPackageName(localb.getPackageName());
      paramb.setClassName(localb.getClassName());
      paramb.setContentDescription(localb.getContentDescription());
      paramb.setEnabled(localb.isEnabled());
      paramb.setClickable(localb.isClickable());
      paramb.setFocusable(localb.isFocusable());
      paramb.setFocused(localb.isFocused());
      paramb.setAccessibilityFocused(localb.isAccessibilityFocused());
      paramb.setSelected(localb.isSelected());
      paramb.setLongClickable(localb.isLongClickable());
      paramb.addAction(localb.getActions());
      int i = b.zK.C(localb.zL);
      b.zK.d(paramb.zL, i);
      localb.recycle();
      paramb.setClassName(SlidingPaneLayout.class.getName());
      paramb.setSource(paramView);
      paramView = z.K(paramView);
      if ((paramView instanceof View)) {
        paramb.setParent((View)paramView);
      }
      int j = SlidingPaneLayout.this.getChildCount();
      i = 0;
      while (i < j)
      {
        paramView = SlidingPaneLayout.this.getChildAt(i);
        if ((!aH(paramView)) && (paramView.getVisibility() == 0))
        {
          z.i(paramView, 1);
          paramb.addChild(paramView);
        }
        i += 1;
      }
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (!aH(paramView)) {
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
  }
  
  private final class b
    implements Runnable
  {
    final View DN;
    
    b(View paramView)
    {
      this.DN = paramView;
    }
    
    public final void run()
    {
      if (this.DN.getParent() == SlidingPaneLayout.this)
      {
        z.a(this.DN, 0, null);
        SlidingPaneLayout.a(SlidingPaneLayout.this, this.DN);
      }
      SlidingPaneLayout.g(SlidingPaneLayout.this).remove(this);
    }
  }
  
  private final class c
    extends u.a
  {
    public c() {}
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
      int i;
      int j;
      if (SlidingPaneLayout.e(SlidingPaneLayout.this))
      {
        i = SlidingPaneLayout.this.getPaddingRight();
        j = localLayoutParams.rightMargin + i;
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.c(SlidingPaneLayout.this) <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.f(SlidingPaneLayout.this);
        }
        j = SlidingPaneLayout.d(SlidingPaneLayout.this).getWidth();
        i = SlidingPaneLayout.this.getWidth() - i - j;
      }
      for (;;)
      {
        SlidingPaneLayout.b(SlidingPaneLayout.this).q(i, paramView.getTop());
        SlidingPaneLayout.this.invalidate();
        return;
        i = SlidingPaneLayout.this.getPaddingLeft();
        j = localLayoutParams.leftMargin + i;
        if (paramFloat1 <= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.c(SlidingPaneLayout.this) <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.f(SlidingPaneLayout.this);
        }
      }
    }
    
    public final void a(View paramView, int paramInt1, int paramInt2)
    {
      SlidingPaneLayout.a(SlidingPaneLayout.this, paramInt1);
      SlidingPaneLayout.this.invalidate();
    }
    
    public final boolean b(View paramView, int paramInt)
    {
      if (SlidingPaneLayout.a(SlidingPaneLayout.this)) {
        return false;
      }
      return ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).DO;
    }
    
    public final int c(View paramView, int paramInt)
    {
      return paramView.getTop();
    }
    
    public final int d(View paramView, int paramInt)
    {
      paramView = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.d(SlidingPaneLayout.this).getLayoutParams();
      if (SlidingPaneLayout.e(SlidingPaneLayout.this))
      {
        i = SlidingPaneLayout.this.getWidth();
        j = SlidingPaneLayout.this.getPaddingRight();
        i -= paramView.rightMargin + j + SlidingPaneLayout.d(SlidingPaneLayout.this).getWidth();
        j = SlidingPaneLayout.f(SlidingPaneLayout.this);
        return Math.max(Math.min(paramInt, i), i - j);
      }
      int i = SlidingPaneLayout.this.getPaddingLeft();
      i = paramView.leftMargin + i;
      int j = SlidingPaneLayout.f(SlidingPaneLayout.this);
      return Math.min(Math.max(paramInt, i), j + i);
    }
    
    public final void f(View paramView, int paramInt)
    {
      SlidingPaneLayout.this.cB();
    }
    
    public final void j(int paramInt)
    {
      if (SlidingPaneLayout.b(SlidingPaneLayout.this).EK == 0)
      {
        if (SlidingPaneLayout.c(SlidingPaneLayout.this) == 0.0F)
        {
          SlidingPaneLayout.this.aE(SlidingPaneLayout.d(SlidingPaneLayout.this));
          localSlidingPaneLayout = SlidingPaneLayout.this;
          SlidingPaneLayout.d(SlidingPaneLayout.this);
          localSlidingPaneLayout.sendAccessibilityEvent(32);
          SlidingPaneLayout.a(SlidingPaneLayout.this, false);
        }
      }
      else {
        return;
      }
      SlidingPaneLayout localSlidingPaneLayout = SlidingPaneLayout.this;
      SlidingPaneLayout.d(SlidingPaneLayout.this);
      localSlidingPaneLayout.sendAccessibilityEvent(32);
      SlidingPaneLayout.a(SlidingPaneLayout.this, true);
    }
    
    public final void n(int paramInt1, int paramInt2)
    {
      SlidingPaneLayout.b(SlidingPaneLayout.this).n(SlidingPaneLayout.d(SlidingPaneLayout.this), paramInt2);
    }
    
    public final int s(View paramView)
    {
      return SlidingPaneLayout.f(SlidingPaneLayout.this);
    }
  }
  
  static abstract interface d
  {
    public abstract void b(SlidingPaneLayout paramSlidingPaneLayout, View paramView);
  }
  
  static class e
    implements SlidingPaneLayout.d
  {
    public void b(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      z.b(paramSlidingPaneLayout, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    }
  }
  
  static final class f
    extends SlidingPaneLayout.e
  {
    private Method DS;
    private Field DT;
    
    f()
    {
      try
      {
        this.DS = View.class.getDeclaredMethod("getDisplayList", null);
        try
        {
          this.DT = View.class.getDeclaredField("mRecreateDisplayList");
          this.DT.setAccessible(true);
          return;
        }
        catch (NoSuchFieldException localNoSuchFieldException) {}
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
    }
    
    public final void b(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      if ((this.DS != null) && (this.DT != null)) {}
      try
      {
        this.DT.setBoolean(paramView, true);
        this.DS.invoke(paramView, null);
        super.b(paramSlidingPaneLayout, paramView);
        return;
        paramView.invalidate();
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  static final class g
    extends SlidingPaneLayout.e
  {
    public final void b(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      z.a(paramView, ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).DQ);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/widget/SlidingPaneLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */