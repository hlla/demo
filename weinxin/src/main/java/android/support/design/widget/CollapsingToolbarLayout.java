package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.e;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.ap;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.util.List;

public class CollapsingToolbarLayout
  extends FrameLayout
{
  private ap eD;
  private View gA;
  private View gB;
  private int gC;
  private int gD;
  private int gE;
  private int gF;
  private final Rect gG = new Rect();
  private final f gH;
  private boolean gI;
  private boolean gJ;
  private Drawable gK;
  private Drawable gL;
  int gM;
  boolean gN;
  u gO;
  private AppBarLayout.a gP;
  private int gQ;
  private boolean gx = true;
  private int gy;
  private Toolbar gz;
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    t.g(paramContext);
    this.gH = new f(this);
    this.gH.a(a.ew);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.bu, paramInt, a.h.aO);
    this.gH.m(paramAttributeSet.getInt(a.i.by, 8388691));
    this.gH.n(paramAttributeSet.getInt(a.i.bv, 8388627));
    paramInt = paramAttributeSet.getDimensionPixelSize(a.i.bz, 0);
    this.gF = paramInt;
    this.gE = paramInt;
    this.gD = paramInt;
    this.gC = paramInt;
    if (paramAttributeSet.hasValue(a.i.bC)) {
      this.gC = paramAttributeSet.getDimensionPixelSize(a.i.bC, 0);
    }
    if (paramAttributeSet.hasValue(a.i.bB)) {
      this.gE = paramAttributeSet.getDimensionPixelSize(a.i.bB, 0);
    }
    if (paramAttributeSet.hasValue(a.i.bD)) {
      this.gD = paramAttributeSet.getDimensionPixelSize(a.i.bD, 0);
    }
    if (paramAttributeSet.hasValue(a.i.bA)) {
      this.gF = paramAttributeSet.getDimensionPixelSize(a.i.bA, 0);
    }
    this.gI = paramAttributeSet.getBoolean(a.i.bH, true);
    paramContext = paramAttributeSet.getText(a.i.bG);
    this.gH.setText(paramContext);
    this.gH.p(a.h.aK);
    this.gH.o(a.h.aJ);
    if (paramAttributeSet.hasValue(a.i.bE)) {
      this.gH.p(paramAttributeSet.getResourceId(a.i.bE, 0));
    }
    if (paramAttributeSet.hasValue(a.i.bw)) {
      this.gH.o(paramAttributeSet.getResourceId(a.i.bw, 0));
    }
    paramContext = paramAttributeSet.getDrawable(a.i.bx);
    if (this.gK != paramContext)
    {
      if (this.gK != null) {
        this.gK.setCallback(null);
      }
      if (paramContext != null)
      {
        paramContext = paramContext.mutate();
        this.gK = paramContext;
        if (this.gK != null)
        {
          this.gK.setBounds(0, 0, getWidth(), getHeight());
          this.gK.setCallback(this);
          this.gK.setAlpha(this.gM);
        }
        android.support.v4.view.z.F(this);
      }
    }
    else
    {
      Drawable localDrawable = paramAttributeSet.getDrawable(a.i.bF);
      if (this.gL != localDrawable)
      {
        if (this.gL != null) {
          this.gL.setCallback(null);
        }
        paramContext = (Context)localObject;
        if (localDrawable != null) {
          paramContext = localDrawable.mutate();
        }
        this.gL = paramContext;
        if (this.gL != null)
        {
          if (this.gL.isStateful()) {
            this.gL.setState(getDrawableState());
          }
          android.support.v4.b.a.a.b(this.gL, android.support.v4.view.z.J(this));
          paramContext = this.gL;
          if (getVisibility() != 0) {
            break label581;
          }
        }
      }
    }
    label581:
    for (boolean bool = true;; bool = false)
    {
      paramContext.setVisible(bool, false);
      this.gL.setCallback(this);
      this.gL.setAlpha(this.gM);
      android.support.v4.view.z.F(this);
      this.gy = paramAttributeSet.getResourceId(a.i.bI, -1);
      paramAttributeSet.recycle();
      setWillNotDraw(false);
      android.support.v4.view.z.b(this, new android.support.v4.view.t()
      {
        public final ap a(View paramAnonymousView, ap paramAnonymousap)
        {
          return CollapsingToolbarLayout.a(CollapsingToolbarLayout.this, paramAnonymousap);
        }
      });
      return;
      paramContext = null;
      break;
    }
  }
  
  private LayoutParams Q()
  {
    return new LayoutParams(super.generateDefaultLayoutParams());
  }
  
  private static int j(View paramView)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      int i = paramView.getHeight();
      int j = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
      return ((ViewGroup.MarginLayoutParams)localObject).bottomMargin + (i + j);
    }
    return paramView.getHeight();
  }
  
  private static z k(View paramView)
  {
    z localz2 = (z)paramView.getTag(a.e.aw);
    z localz1 = localz2;
    if (localz2 == null)
    {
      localz1 = new z(paramView);
      paramView.setTag(a.e.aw, localz1);
    }
    return localz1;
  }
  
  final void P()
  {
    if (!this.gx) {
      return;
    }
    this.gz = null;
    this.gA = null;
    if (this.gy != -1)
    {
      this.gz = ((Toolbar)findViewById(this.gy));
      if (this.gz != null)
      {
        Object localObject2 = this.gz;
        for (localObject1 = ((View)localObject2).getParent(); (localObject1 != this) && (localObject1 != null); localObject1 = ((ViewParent)localObject1).getParent()) {
          if ((localObject1 instanceof View)) {
            localObject2 = (View)localObject1;
          }
        }
        this.gA = ((View)localObject2);
      }
    }
    int i;
    if (this.gz == null)
    {
      int j = getChildCount();
      i = 0;
      if (i >= j) {
        break label252;
      }
      localObject1 = getChildAt(i);
      if (!(localObject1 instanceof Toolbar)) {
        break label245;
      }
    }
    label245:
    label252:
    for (Object localObject1 = (Toolbar)localObject1;; localObject1 = null)
    {
      this.gz = ((Toolbar)localObject1);
      if ((!this.gI) && (this.gB != null))
      {
        localObject1 = this.gB.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.gB);
        }
      }
      if ((this.gI) && (this.gz != null))
      {
        if (this.gB == null) {
          this.gB = new View(getContext());
        }
        if (this.gB.getParent() == null) {
          this.gz.addView(this.gB, -1, -1);
        }
      }
      this.gx = false;
      return;
      i += 1;
      break;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    P();
    if ((this.gz == null) && (this.gK != null) && (this.gM > 0))
    {
      this.gK.mutate().setAlpha(this.gM);
      this.gK.draw(paramCanvas);
    }
    if ((this.gI) && (this.gJ)) {
      this.gH.draw(paramCanvas);
    }
    if ((this.gL != null) && (this.gM > 0)) {
      if (this.eD == null) {
        break label153;
      }
    }
    label153:
    for (int i = this.eD.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.gL.setBounds(0, -this.gQ, getWidth(), i - this.gQ);
        this.gL.mutate().setAlpha(this.gM);
        this.gL.draw(paramCanvas);
      }
      return;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    P();
    if ((paramView == this.gz) && (this.gK != null) && (this.gM > 0))
    {
      this.gK.mutate().setAlpha(this.gM);
      this.gK.draw(paramCanvas);
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.gL;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.gK;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool2) {
      invalidate();
    }
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if ((localObject instanceof AppBarLayout))
    {
      if (this.gP == null) {
        this.gP = new a();
      }
      localObject = (AppBarLayout)localObject;
      AppBarLayout.a locala = this.gP;
      if ((locala != null) && (!((AppBarLayout)localObject).eE.contains(locala))) {
        ((AppBarLayout)localObject).eE.add(locala);
      }
    }
    android.support.v4.view.z.Z(this);
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = getParent();
    if ((this.gP != null) && ((localObject instanceof AppBarLayout)))
    {
      localObject = (AppBarLayout)localObject;
      AppBarLayout.a locala = this.gP;
      if (locala != null) {
        ((AppBarLayout)localObject).eE.remove(locala);
      }
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 1;
    int k = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.gI) && (this.gB != null))
    {
      if ((!android.support.v4.view.z.al(this.gB)) || (this.gB.getVisibility() != 0)) {
        break label308;
      }
      paramBoolean = true;
      this.gJ = paramBoolean;
      if (this.gJ) {
        if ((this.gA == null) || (this.gA == this)) {
          break label417;
        }
      }
    }
    label154:
    label171:
    label308:
    label319:
    label328:
    label417:
    for (int i = ((LayoutParams)this.gA.getLayoutParams()).bottomMargin;; i = 0)
    {
      x.a(this, this.gB, this.gG);
      this.gH.b(this.gG.left, paramInt4 - this.gG.height() - i, this.gG.right, paramInt4 - i);
      Object localObject;
      int m;
      int n;
      if (android.support.v4.view.z.J(this) == 1)
      {
        localObject = this.gH;
        if (j == 0) {
          break label319;
        }
        i = this.gE;
        m = this.gG.bottom;
        n = this.gD;
        if (j == 0) {
          break label328;
        }
      }
      for (j = this.gC;; j = this.gE)
      {
        ((f)localObject).a(i, m + n, paramInt3 - paramInt1 - j, paramInt4 - paramInt2 - this.gF);
        this.gH.N();
        paramInt2 = getChildCount();
        paramInt1 = k;
        while (paramInt1 < paramInt2)
        {
          localObject = getChildAt(paramInt1);
          if ((this.eD != null) && (!android.support.v4.view.z.aa((View)localObject)))
          {
            paramInt3 = this.eD.getSystemWindowInsetTop();
            if (((View)localObject).getTop() < paramInt3) {
              android.support.v4.view.z.j((View)localObject, paramInt3);
            }
          }
          k((View)localObject).ay();
          paramInt1 += 1;
        }
        paramBoolean = false;
        break;
        j = 0;
        break label154;
        i = this.gC;
        break label171;
      }
      if (this.gz != null)
      {
        if ((this.gI) && (TextUtils.isEmpty(this.gH.mText))) {
          this.gH.setText(this.gz.aeY);
        }
        if ((this.gA == null) || (this.gA == this)) {
          setMinimumHeight(j(this.gz));
        }
      }
      else
      {
        return;
      }
      setMinimumHeight(j(this.gA));
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    P();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.gK != null) {
      this.gK.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  final void r(int paramInt)
  {
    if (paramInt != this.gM)
    {
      if ((this.gK != null) && (this.gz != null)) {
        android.support.v4.view.z.F(this.gz);
      }
      this.gM = paramInt;
      android.support.v4.view.z.F(this);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.gL != null) && (this.gL.isVisible() != bool)) {
        this.gL.setVisible(bool, false);
      }
      if ((this.gK != null) && (this.gK.isVisible() != bool)) {
        this.gK.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.gK) || (paramDrawable == this.gL);
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    int gS = 0;
    float gT = 0.5F;
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.bq);
      this.gS = paramContext.getInt(a.i.br, 0);
      this.gT = paramContext.getFloat(a.i.bt, 0.5F);
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(FrameLayout.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  private final class a
    implements AppBarLayout.a
  {
    public a() {}
    
    public final void a(AppBarLayout paramAppBarLayout, int paramInt)
    {
      int k = 255;
      int n = 1;
      int m = 0;
      CollapsingToolbarLayout.b(CollapsingToolbarLayout.this, paramInt);
      int i;
      int i1;
      label60:
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (CollapsingToolbarLayout.a(CollapsingToolbarLayout.this) != null)
      {
        i = CollapsingToolbarLayout.a(CollapsingToolbarLayout.this).getSystemWindowInsetTop();
        i1 = paramAppBarLayout.F();
        int i2 = CollapsingToolbarLayout.this.getChildCount();
        j = 0;
        if (j >= i2) {
          break label193;
        }
        localObject1 = CollapsingToolbarLayout.this.getChildAt(j);
        localObject2 = (CollapsingToolbarLayout.LayoutParams)((View)localObject1).getLayoutParams();
        localObject3 = CollapsingToolbarLayout.l((View)localObject1);
        switch (((CollapsingToolbarLayout.LayoutParams)localObject2).gS)
        {
        }
      }
      for (;;)
      {
        j += 1;
        break label60;
        i = 0;
        break;
        if (CollapsingToolbarLayout.this.getHeight() - i + paramInt >= ((View)localObject1).getHeight())
        {
          ((z)localObject3).f(-paramInt);
          continue;
          float f = -paramInt;
          ((z)localObject3).f(Math.round(((CollapsingToolbarLayout.LayoutParams)localObject2).gT * f));
        }
      }
      label193:
      boolean bool;
      if ((CollapsingToolbarLayout.b(CollapsingToolbarLayout.this) != null) || (CollapsingToolbarLayout.c(CollapsingToolbarLayout.this) != null))
      {
        localObject2 = CollapsingToolbarLayout.this;
        if (CollapsingToolbarLayout.this.getHeight() + paramInt >= android.support.v4.view.z.U(CollapsingToolbarLayout.this) * 2 + i) {
          break label489;
        }
        bool = true;
        if ((!android.support.v4.view.z.aj((View)localObject2)) || (((CollapsingToolbarLayout)localObject2).isInEditMode())) {
          break label495;
        }
        j = n;
        label266:
        if (((CollapsingToolbarLayout)localObject2).gN != bool)
        {
          if (j == 0) {
            break label537;
          }
          j = m;
          if (bool) {
            j = 255;
          }
          ((CollapsingToolbarLayout)localObject2).P();
          if (((CollapsingToolbarLayout)localObject2).gO != null) {
            break label509;
          }
          ((CollapsingToolbarLayout)localObject2).gO = aa.av();
          ((CollapsingToolbarLayout)localObject2).gO.setDuration(600);
          localObject3 = ((CollapsingToolbarLayout)localObject2).gO;
          if (j <= ((CollapsingToolbarLayout)localObject2).gM) {
            break label501;
          }
          localObject1 = a.eu;
          label349:
          ((u)localObject3).setInterpolator((Interpolator)localObject1);
          ((CollapsingToolbarLayout)localObject2).gO.a(new CollapsingToolbarLayout.2((CollapsingToolbarLayout)localObject2));
        }
      }
      for (;;)
      {
        ((CollapsingToolbarLayout)localObject2).gO.e(((CollapsingToolbarLayout)localObject2).gM, j);
        ((CollapsingToolbarLayout)localObject2).gO.ll.start();
        ((CollapsingToolbarLayout)localObject2).gN = bool;
        if ((CollapsingToolbarLayout.c(CollapsingToolbarLayout.this) != null) && (i > 0)) {
          android.support.v4.view.z.F(CollapsingToolbarLayout.this);
        }
        j = CollapsingToolbarLayout.this.getHeight();
        k = android.support.v4.view.z.U(CollapsingToolbarLayout.this);
        CollapsingToolbarLayout.d(CollapsingToolbarLayout.this).e(Math.abs(paramInt) / (j - k - i));
        if (Math.abs(paramInt) != i1) {
          break label562;
        }
        android.support.v4.view.z.g(paramAppBarLayout, paramAppBarLayout.eB);
        return;
        label489:
        bool = false;
        break;
        label495:
        j = 0;
        break label266;
        label501:
        localObject1 = a.ev;
        break label349;
        label509:
        if (((CollapsingToolbarLayout)localObject2).gO.ll.isRunning()) {
          ((CollapsingToolbarLayout)localObject2).gO.ll.cancel();
        }
      }
      label537:
      if (bool) {}
      for (int j = k;; j = 0)
      {
        ((CollapsingToolbarLayout)localObject2).r(j);
        break;
      }
      label562:
      android.support.v4.view.z.g(paramAppBarLayout, 0.0F);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/CollapsingToolbarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */