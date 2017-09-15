package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a.d;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.z;
import android.support.v7.widget.h;
import android.support.v7.widget.i;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;

@CoordinatorLayout.b(a.class)
public class FloatingActionButton
  extends VisibilityAwareImageButton
{
  private ColorStateList hL;
  private PorterDuff.Mode hM;
  private int hN;
  private int hO;
  private int hP;
  private int hQ;
  private boolean hR;
  private final Rect hS = new Rect();
  private i hT;
  private l hU;
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    t.g(paramContext);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.bV, paramInt, a.h.aQ);
    this.hL = localTypedArray.getColorStateList(a.i.bW);
    switch (localTypedArray.getInt(a.i.bX, -1))
    {
    default: 
      paramContext = null;
    }
    for (;;)
    {
      this.hM = paramContext;
      this.hO = localTypedArray.getColor(a.i.cc, 0);
      this.hP = localTypedArray.getInt(a.i.ca, 0);
      this.hN = localTypedArray.getDimensionPixelSize(a.i.bY, 0);
      float f1 = localTypedArray.getDimension(a.i.bZ, 0.0F);
      float f2 = localTypedArray.getDimension(a.i.cb, 0.0F);
      this.hR = localTypedArray.getBoolean(a.i.cd, false);
      localTypedArray.recycle();
      this.hT = new i(this, h.ey());
      this.hT.a(paramAttributeSet, paramInt);
      paramInt = (int)getResources().getDimension(a.d.ag);
      this.hQ = ((T() - paramInt) / 2);
      U().a(this.hL, this.hM, this.hO, this.hN);
      paramContext = U();
      if (paramContext.is != f1)
      {
        paramContext.is = f1;
        paramContext.i(f1);
      }
      paramContext = U();
      if (paramContext.it != f2)
      {
        paramContext.it = f2;
        paramContext.j(f2);
      }
      U().ab();
      return;
      paramContext = PorterDuff.Mode.SRC_OVER;
      continue;
      paramContext = PorterDuff.Mode.SRC_IN;
      continue;
      paramContext = PorterDuff.Mode.SRC_ATOP;
      continue;
      paramContext = PorterDuff.Mode.MULTIPLY;
      continue;
      paramContext = PorterDuff.Mode.SCREEN;
    }
  }
  
  private l U()
  {
    int i;
    Object localObject;
    if (this.hU == null)
    {
      i = Build.VERSION.SDK_INT;
      if (i < 21) {
        break label44;
      }
      localObject = new m(this, new b());
    }
    for (;;)
    {
      this.hU = ((l)localObject);
      return this.hU;
      label44:
      if (i >= 14) {
        localObject = new k(this, new b());
      } else {
        localObject = new j(this, new b());
      }
    }
  }
  
  private static int resolveAdjustedSize(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    case 0: 
    default: 
      return paramInt1;
    case -2147483648: 
      return Math.min(paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  final int T()
  {
    switch (this.hP)
    {
    default: 
      return getResources().getDimensionPixelSize(a.d.aj);
    }
    return getResources().getDimensionPixelSize(a.d.ah);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    U().b(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return this.hL;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.hM;
  }
  
  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    U().X();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    l locall = U();
    if (locall.Z())
    {
      if (locall.ix == null) {
        locall.ix = new l.1(locall);
      }
      locall.iv.getViewTreeObserver().addOnPreDrawListener(locall.ix);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    l locall = U();
    if (locall.ix != null)
    {
      locall.iv.getViewTreeObserver().removeOnPreDrawListener(locall.ix);
      locall.ix = null;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = T();
    paramInt1 = Math.min(resolveAdjustedSize(i, paramInt1), resolveAdjustedSize(i, paramInt2));
    setMeasuredDimension(this.hS.left + paramInt1 + this.hS.right, paramInt1 + this.hS.top + this.hS.bottom);
  }
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setBackgroundResource(int paramInt) {}
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.hL != paramColorStateList)
    {
      this.hL = paramColorStateList;
      U().setBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.hM != paramMode)
    {
      this.hM = paramMode;
      U().setBackgroundTintMode(paramMode);
    }
  }
  
  public void setImageResource(int paramInt)
  {
    this.hT.setImageResource(paramInt);
  }
  
  public static final class a
    extends CoordinatorLayout.Behavior<FloatingActionButton>
  {
    private static final boolean hV;
    private Rect gG;
    private u hW;
    private float hX;
    
    static
    {
      if (Build.VERSION.SDK_INT >= 11) {}
      for (boolean bool = true;; bool = false)
      {
        hV = bool;
        return;
      }
    }
    
    private boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      int i = 0;
      if (((CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams()).hy != paramAppBarLayout.getId()) {
        return false;
      }
      if (paramFloatingActionButton.lP != 0) {
        return false;
      }
      if (this.gG == null) {
        this.gG = new Rect();
      }
      Rect localRect = this.gG;
      x.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
      int j = localRect.bottom;
      int k = paramAppBarLayout.G();
      int m = z.U(paramAppBarLayout);
      if (m != 0)
      {
        i = m * 2 + k;
        if (j > i) {
          break label140;
        }
        FloatingActionButton.a(paramFloatingActionButton);
      }
      for (;;)
      {
        return true;
        m = paramAppBarLayout.getChildCount();
        if (m <= 0) {
          break;
        }
        i = z.U(paramAppBarLayout.getChildAt(m - 1)) * 2 + k;
        break;
        label140:
        FloatingActionButton.b(paramFloatingActionButton);
      }
    }
  }
  
  private final class b
    implements p
  {
    public b() {}
    
    public final float V()
    {
      return FloatingActionButton.this.T() / 2.0F;
    }
    
    public final boolean W()
    {
      return FloatingActionButton.e(FloatingActionButton.this);
    }
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      FloatingActionButton.c(FloatingActionButton.this).set(paramInt1, paramInt2, paramInt3, paramInt4);
      FloatingActionButton.this.setPadding(FloatingActionButton.d(FloatingActionButton.this) + paramInt1, FloatingActionButton.d(FloatingActionButton.this) + paramInt2, FloatingActionButton.d(FloatingActionButton.this) + paramInt3, FloatingActionButton.d(FloatingActionButton.this) + paramInt4);
    }
    
    public final void setBackgroundDrawable(Drawable paramDrawable)
    {
      FloatingActionButton.a(FloatingActionButton.this, paramDrawable);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/FloatingActionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */