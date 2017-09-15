package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.v4.b.a.a;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
final class m
  extends k
{
  private InsetDrawable iz;
  private final Interpolator mInterpolator;
  
  m(VisibilityAwareImageButton paramVisibilityAwareImageButton, p paramp)
  {
    super(paramVisibilityAwareImageButton, paramp);
    if (paramVisibilityAwareImageButton.isInEditMode()) {}
    for (paramVisibilityAwareImageButton = null;; paramVisibilityAwareImageButton = AnimationUtils.loadInterpolator(this.iv.getContext(), 17563661))
    {
      this.mInterpolator = paramVisibilityAwareImageButton;
      return;
    }
  }
  
  private Animator a(Animator paramAnimator)
  {
    paramAnimator.setInterpolator(this.mInterpolator);
    return paramAnimator;
  }
  
  final void X() {}
  
  final boolean Z()
  {
    return false;
  }
  
  final void a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    this.in = a.g(ad());
    a.a(this.in, paramColorStateList);
    if (paramMode != null) {
      a.a(this.in, paramMode);
    }
    if (paramInt2 > 0) {
      this.iq = a(paramInt2, paramColorStateList);
    }
    for (paramColorStateList = new LayerDrawable(new Drawable[] { this.iq, this.in });; paramColorStateList = this.in)
    {
      this.io = new RippleDrawable(ColorStateList.valueOf(paramInt1), paramColorStateList, null);
      this.ir = this.io;
      this.iw.setBackgroundDrawable(this.io);
      return;
      this.iq = null;
    }
  }
  
  final d ac()
  {
    return new e();
  }
  
  final void b(Rect paramRect)
  {
    if (this.iw.W())
    {
      float f1 = this.iw.V();
      float f2 = this.iv.getElevation() + this.it;
      int i = (int)Math.ceil(o.b(f2, f1, false));
      int j = (int)Math.ceil(o.a(f2, f1, false));
      paramRect.set(i, j, i, j);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  final void b(int[] paramArrayOfInt) {}
  
  final void c(Rect paramRect)
  {
    if (this.iw.W())
    {
      this.iz = new InsetDrawable(this.io, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.iw.setBackgroundDrawable(this.iz);
      return;
    }
    this.iw.setBackgroundDrawable(this.io);
  }
  
  public final void i(float paramFloat)
  {
    this.iv.setElevation(paramFloat);
    if (this.iw.W()) {
      ab();
    }
  }
  
  final void j(float paramFloat)
  {
    StateListAnimator localStateListAnimator = new StateListAnimator();
    localStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, a(ObjectAnimator.ofFloat(this.iv, "translationZ", new float[] { paramFloat })));
    localStateListAnimator.addState(iu, a(ObjectAnimator.ofFloat(this.iv, "translationZ", new float[] { paramFloat })));
    localStateListAnimator.addState(EMPTY_STATE_SET, a(ObjectAnimator.ofFloat(this.iv, "translationZ", new float[] { 0.0F })));
    this.iv.setStateListAnimator(localStateListAnimator);
    if (this.iw.W()) {
      ab();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */