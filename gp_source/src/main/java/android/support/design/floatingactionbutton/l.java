package android.support.design.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.design.internal.d;
import android.support.design.internal.p;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class l
  extends b
{
  private InsetDrawable A;
  
  l(p paramp, android.support.design.f.b paramb)
  {
    super(paramp, paramb);
  }
  
  private final Animator a(float paramFloat1, float paramFloat2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.z, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.z, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(a);
    return localAnimatorSet;
  }
  
  public final float a()
  {
    return this.z.getElevation();
  }
  
  final void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Build.VERSION.SDK_INT == 21) {
      this.z.refreshDrawableState();
    }
    for (;;)
    {
      if (this.w.b()) {
        e();
      }
      return;
      StateListAnimator localStateListAnimator = new StateListAnimator();
      localStateListAnimator.addState(g, a(paramFloat1, paramFloat3));
      localStateListAnimator.addState(f, a(paramFloat1, paramFloat2));
      localStateListAnimator.addState(d, a(paramFloat1, paramFloat2));
      localStateListAnimator.addState(e, a(paramFloat1, paramFloat2));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this.z, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 24)) {
        localArrayList.add(ObjectAnimator.ofFloat(this.z, View.TRANSLATION_Z, new float[] { this.z.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(this.z, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
      localAnimatorSet.setInterpolator(a);
      localStateListAnimator.addState(c, localAnimatorSet);
      localStateListAnimator.addState(b, a(0.0F, 0.0F));
      this.z.setStateListAnimator(localStateListAnimator);
    }
  }
  
  final void a(ColorStateList paramColorStateList)
  {
    Drawable localDrawable = this.t;
    if ((localDrawable instanceof RippleDrawable))
    {
      ((RippleDrawable)localDrawable).setColor(android.support.design.e.a.a(paramColorStateList));
      return;
    }
    super.a(paramColorStateList);
  }
  
  final void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.x = android.support.v4.a.a.a.f(h());
    android.support.v4.a.a.a.a(this.x, paramColorStateList1);
    if (paramMode != null) {
      android.support.v4.a.a.a.a(this.x, paramMode);
    }
    if (paramInt > 0) {
      this.i = a(paramInt, paramColorStateList1);
    }
    for (paramColorStateList1 = new LayerDrawable(new Drawable[] { this.i, this.x });; paramColorStateList1 = this.x)
    {
      this.t = new RippleDrawable(android.support.design.e.a.a(paramColorStateList2), paramColorStateList1, null);
      paramColorStateList1 = this.t;
      this.j = paramColorStateList1;
      this.w.a(paramColorStateList1);
      return;
      this.i = null;
    }
  }
  
  final void a(Rect paramRect)
  {
    if (this.w.b())
    {
      float f1 = this.w.a();
      float f2 = a() + this.s;
      int i = (int)Math.ceil(android.support.design.f.a.b(f2, f1, false));
      int j = (int)Math.ceil(android.support.design.f.a.a(f2, f1, false));
      paramRect.set(i, j, i, j);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  final void a(int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT == 21)
    {
      if (!this.z.isEnabled()) {
        break label92;
      }
      this.z.setElevation(this.n);
      if (this.z.isPressed()) {
        this.z.setTranslationZ(this.s);
      }
    }
    else
    {
      return;
    }
    if ((this.z.isFocused()) || (this.z.isHovered()))
    {
      this.z.setTranslationZ(this.p);
      return;
    }
    this.z.setTranslationZ(0.0F);
    return;
    label92:
    this.z.setElevation(0.0F);
    this.z.setTranslationZ(0.0F);
  }
  
  final void b(Rect paramRect)
  {
    if (this.w.b())
    {
      this.A = new InsetDrawable(this.t, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.w.a(this.A);
      return;
    }
    this.w.a(this.t);
  }
  
  final void c() {}
  
  final void d()
  {
    e();
  }
  
  final boolean f()
  {
    return false;
  }
  
  final android.support.design.internal.b g()
  {
    return new d();
  }
  
  final GradientDrawable i()
  {
    return new m();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/floatingactionbutton/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */