package android.support.design.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.internal.o;
import android.support.design.internal.p;
import android.support.design.stateful.ExtendableSavedState;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.i;
import android.support.v4.g.v;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ab;
import android.support.v4.view.ac;
import android.support.v4.widget.ay;
import android.support.v7.widget.ae;
import android.support.v7.widget.am;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.ImageView.ScaleType;

@i(a=FloatingActionButton.Behavior.class)
public class FloatingActionButton
  extends p
  implements ab, ay
{
  public boolean a;
  public int b;
  public final Rect c = new Rect();
  private ColorStateList d;
  private PorterDuff.Mode e;
  private int f;
  private int g;
  private final android.support.design.c.b h;
  private final am i;
  private PorterDuff.Mode j;
  private ColorStateList k;
  private b l;
  private int m;
  private ColorStateList n;
  private int o;
  private final Rect p = new Rect();
  
  public FloatingActionButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968914);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = android.support.design.internal.n.a(paramContext, paramAttributeSet, n.a, paramInt, 2132018428, new int[0]);
    this.d = android.support.design.d.a.a(paramContext, localTypedArray, n.d);
    this.e = o.a(localTypedArray.getInt(n.e, -1), null);
    this.n = android.support.design.d.a.a(paramContext, localTypedArray, n.j);
    this.o = localTypedArray.getInt(n.h, -1);
    this.g = localTypedArray.getDimensionPixelSize(n.g, 0);
    this.f = localTypedArray.getDimensionPixelSize(n.f, 0);
    float f1 = localTypedArray.getDimension(3, 0.0F);
    float f2 = localTypedArray.getDimension(7, 0.0F);
    float f3 = localTypedArray.getDimension(9, 0.0F);
    this.a = localTypedArray.getBoolean(n.k, false);
    this.m = localTypedArray.getDimensionPixelSize(n.i, 0);
    android.support.design.a.e locale = android.support.design.a.e.a(paramContext, localTypedArray, 11);
    paramContext = android.support.design.a.e.a(paramContext, localTypedArray, 6);
    localTypedArray.recycle();
    this.i = new am(this);
    this.i.a(paramAttributeSet, paramInt);
    this.h = new android.support.design.c.b(this);
    e().a(this.d, this.e, this.n, this.f);
    e().a(f1);
    e().b(f2);
    e().c(f3);
    paramAttributeSet = e();
    paramInt = this.m;
    if (paramAttributeSet.q != paramInt)
    {
      paramAttributeSet.q = paramInt;
      paramAttributeSet.b();
    }
    e().y = locale;
    e().o = paramContext;
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private final int a(int paramInt)
  {
    int i2 = this.g;
    int i1 = i2;
    Resources localResources;
    if (i2 == 0) {
      localResources = getResources();
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      i1 = localResources.getDimensionPixelSize(2131165555);
      return i1;
    case -1: 
      if (Math.max(localResources.getConfiguration().screenWidthDp, localResources.getConfiguration().screenHeightDp) < 470) {
        return a(1);
      }
      return a(0);
    }
    return localResources.getDimensionPixelSize(2131165554);
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = paramInt1;
    switch (i2)
    {
    default: 
      throw new IllegalArgumentException();
    case 1073741824: 
      paramInt2 = i1;
    case 0: 
      return paramInt2;
    }
    return Math.min(paramInt1, i1);
  }
  
  private final void d()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      localObject = this.k;
      if (localObject == null) {
        android.support.v4.a.a.a.e(localDrawable);
      }
    }
    else
    {
      return;
    }
    int i1 = ((ColorStateList)localObject).getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode = this.j;
    Object localObject = localMode;
    if (localMode == null) {
      localObject = PorterDuff.Mode.SRC_IN;
    }
    localDrawable.mutate().setColorFilter(ae.a(i1, (PorterDuff.Mode)localObject));
  }
  
  private final b e()
  {
    if (this.l == null) {
      if (Build.VERSION.SDK_INT < 21) {
        break label42;
      }
    }
    label42:
    for (Object localObject = new l(this, new a(this));; localObject = new b(this, new a(this)))
    {
      this.l = ((b)localObject);
      return this.l;
    }
  }
  
  final void a()
  {
    b localb = e();
    if (localb.z.getVisibility() != 0) {
      if (localb.h == 2) {}
    }
    while (localb.h == 1)
    {
      Object localObject = localb.k;
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
      if (localb.j())
      {
        if (localb.z.getVisibility() != 0)
        {
          localb.z.setAlpha(0.0F);
          localb.z.setScaleY(0.0F);
          localb.z.setScaleX(0.0F);
          localb.d(0.0F);
        }
        android.support.design.a.e locale = localb.y;
        localObject = locale;
        if (locale == null)
        {
          if (localb.m == null) {
            localb.m = android.support.design.a.e.a(localb.z.getContext(), 2130837506);
          }
          localObject = localb.m;
        }
        localObject = localb.a((android.support.design.a.e)localObject, 1.0F, 1.0F, 1.0F);
        ((AnimatorSet)localObject).addListener(new d(localb, null));
        ((AnimatorSet)localObject).start();
      }
      do
      {
        return;
        localb.z.a(0, false);
        localb.z.setAlpha(1.0F);
        localb.z.setScaleY(1.0F);
        localb.z.setScaleX(1.0F);
        localb.d(1.0F);
      } while (0 == 0);
      throw new NullPointerException();
    }
  }
  
  final void b()
  {
    b localb = e();
    if (localb.z.getVisibility() == 0) {
      if (localb.h == 1) {}
    }
    while (localb.h == 2)
    {
      Object localObject = localb.k;
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
      if (localb.j())
      {
        android.support.design.a.e locale = localb.o;
        localObject = locale;
        if (locale == null)
        {
          if (localb.l == null) {
            localb.l = android.support.design.a.e.a(localb.z.getContext(), 2130837505);
          }
          localObject = localb.l;
        }
        localObject = localb.a((android.support.design.a.e)localObject, 0.0F, 0.0F, 0.0F);
        ((AnimatorSet)localObject).addListener(new c(localb, null));
        ((AnimatorSet)localObject).start();
      }
      do
      {
        return;
        localb.z.a(4, false);
      } while (0 == 0);
      throw new NullPointerException();
    }
  }
  
  final int c()
  {
    return a(this.o);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    e().a(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return this.d;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.e;
  }
  
  public float getCompatElevation()
  {
    return e().a();
  }
  
  public float getCompatHoveredFocusedTranslationZ()
  {
    return e().p;
  }
  
  public float getCompatPressedTranslationZ()
  {
    return e().s;
  }
  
  public Drawable getContentBackground()
  {
    return e().j;
  }
  
  public int getCustomSize()
  {
    return this.g;
  }
  
  public int getExpandedComponentIdHint()
  {
    return this.h.b;
  }
  
  public android.support.design.a.e getHideMotionSpec()
  {
    return e().o;
  }
  
  @Deprecated
  public int getRippleColor()
  {
    ColorStateList localColorStateList = this.n;
    if (localColorStateList != null) {
      return localColorStateList.getDefaultColor();
    }
    return 0;
  }
  
  public ColorStateList getRippleColorStateList()
  {
    return this.n;
  }
  
  public android.support.design.a.e getShowMotionSpec()
  {
    return e().y;
  }
  
  public int getSize()
  {
    return this.o;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    return getBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    return getBackgroundTintMode();
  }
  
  public ColorStateList getSupportImageTintList()
  {
    return this.k;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    return this.j;
  }
  
  public boolean getUseCompatPadding()
  {
    return this.a;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    e().c();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b localb = e();
    if (localb.f())
    {
      if (localb.r == null) {
        localb.r = new e(localb);
      }
      localb.z.getViewTreeObserver().addOnPreDrawListener(localb.r);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b localb = e();
    if (localb.r != null)
    {
      localb.z.getViewTreeObserver().removeOnPreDrawListener(localb.r);
      localb.r = null;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = c();
    this.b = ((i1 - this.m) / 2);
    e().e();
    paramInt1 = Math.min(a(i1, paramInt1), a(i1, paramInt2));
    setMeasuredDimension(this.c.left + paramInt1 + this.c.right, paramInt1 + this.c.top + this.c.bottom);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ExtendableSavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (ExtendableSavedState)paramParcelable;
        super.onRestoreInstanceState(((AbsSavedState)localObject).e);
        paramParcelable = this.h;
        localObject = (Bundle)((ExtendableSavedState)localObject).a.get("expandableWidgetHelper");
        paramParcelable.a = ((Bundle)localObject).getBoolean("expanded", false);
        paramParcelable.b = ((Bundle)localObject).getInt("expandedComponentIdHint", 0);
      } while (!paramParcelable.a);
      localObject = paramParcelable.c.getParent();
    } while (!(localObject instanceof CoordinatorLayout));
    ((CoordinatorLayout)localObject).a(paramParcelable.c);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    ExtendableSavedState localExtendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
    v localv = localExtendableSavedState.a;
    android.support.design.c.b localb = this.h;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("expanded", localb.a);
    localBundle.putInt("expandedComponentIdHint", localb.b);
    localv.put("expandableWidgetHelper", localBundle);
    return localExtendableSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (paramMotionEvent.getAction() == 0)
    {
      Rect localRect = this.p;
      if (ac.I(this))
      {
        localRect.set(0, 0, getWidth(), getHeight());
        localRect.left += this.c.left;
        localRect.top += this.c.top;
        localRect.right -= this.c.right;
        localRect.bottom -= this.c.bottom;
        if (!this.p.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          return bool;
        }
      }
    }
    bool = super.onTouchEvent(paramMotionEvent);
    return bool;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.d != paramColorStateList)
    {
      this.d = paramColorStateList;
      Object localObject = e();
      Drawable localDrawable = ((b)localObject).x;
      if (localDrawable != null) {
        android.support.v4.a.a.a.a(localDrawable, paramColorStateList);
      }
      localObject = ((b)localObject).i;
      if (localObject != null) {
        ((android.support.design.internal.b)localObject).a(paramColorStateList);
      }
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.e != paramMode)
    {
      this.e = paramMode;
      Drawable localDrawable = e().x;
      if (localDrawable != null) {
        android.support.v4.a.a.a.a(localDrawable, paramMode);
      }
    }
  }
  
  public void setCompatElevation(float paramFloat)
  {
    e().a(paramFloat);
  }
  
  public void setCompatElevationResource(int paramInt)
  {
    setCompatElevation(getResources().getDimension(paramInt));
  }
  
  public void setCompatHoveredFocusedTranslationZ(float paramFloat)
  {
    e().b(paramFloat);
  }
  
  public void setCompatHoveredFocusedTranslationZResource(int paramInt)
  {
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCompatPressedTranslationZ(float paramFloat)
  {
    e().c(paramFloat);
  }
  
  public void setCompatPressedTranslationZResource(int paramInt)
  {
    setCompatPressedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCustomSize(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Custom size must be non-negative");
    }
    this.g = paramInt;
  }
  
  public void setExpandedComponentIdHint(int paramInt)
  {
    this.h.b = paramInt;
  }
  
  public void setHideMotionSpec(android.support.design.a.e parame)
  {
    e().o = parame;
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    setHideMotionSpec(android.support.design.a.e.a(getContext(), paramInt));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    e().b();
  }
  
  public void setImageResource(int paramInt)
  {
    this.i.a(paramInt);
  }
  
  public void setRippleColor(int paramInt)
  {
    setRippleColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.n != paramColorStateList)
    {
      this.n = paramColorStateList;
      e().a(this.n);
    }
  }
  
  public void setShowMotionSpec(android.support.design.a.e parame)
  {
    e().y = parame;
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    setShowMotionSpec(android.support.design.a.e.a(getContext(), paramInt));
  }
  
  public void setSize(int paramInt)
  {
    this.g = 0;
    if (paramInt != this.o)
    {
      this.o = paramInt;
      requestLayout();
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    setBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setBackgroundTintMode(paramMode);
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.k != paramColorStateList)
    {
      this.k = paramColorStateList;
      d();
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.j != paramMode)
    {
      this.j = paramMode;
      d();
    }
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      e().d();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/floatingactionbutton/FloatingActionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */