package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.a.c;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class l
{
  static final int[] EMPTY_STATE_SET = new int[0];
  static final int[] PRESSED_ENABLED_STATE_SET = { 16842919, 16842910 };
  static final int[] iu = { 16842908, 16842910 };
  private final Rect gG = new Rect();
  Drawable in;
  Drawable io;
  d iq;
  Drawable ir;
  float is;
  float it;
  final VisibilityAwareImageButton iv;
  final p iw;
  ViewTreeObserver.OnPreDrawListener ix;
  
  l(VisibilityAwareImageButton paramVisibilityAwareImageButton, p paramp)
  {
    this.iv = paramVisibilityAwareImageButton;
    this.iw = paramp;
  }
  
  static GradientDrawable ad()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  abstract void X();
  
  boolean Z()
  {
    return false;
  }
  
  final d a(int paramInt, ColorStateList paramColorStateList)
  {
    Resources localResources = this.iv.getResources();
    d locald = ac();
    int i = localResources.getColor(a.c.ae);
    int j = localResources.getColor(a.c.ad);
    int k = localResources.getColor(a.c.ab);
    int m = localResources.getColor(a.c.ac);
    locald.fy = i;
    locald.fz = j;
    locald.fA = k;
    locald.fB = m;
    float f = paramInt;
    if (locald.fx != f)
    {
      locald.fx = f;
      locald.fu.setStrokeWidth(f * 1.3333F);
      locald.fE = true;
      locald.invalidateSelf();
    }
    locald.c(paramColorStateList);
    return locald;
  }
  
  abstract void a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2);
  
  abstract void a(a parama, boolean paramBoolean);
  
  void aa() {}
  
  final void ab()
  {
    Rect localRect = this.gG;
    b(localRect);
    c(localRect);
    this.iw.c(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  d ac()
  {
    return new d();
  }
  
  abstract void b(Rect paramRect);
  
  abstract void b(a parama, boolean paramBoolean);
  
  abstract void b(int[] paramArrayOfInt);
  
  void c(Rect paramRect) {}
  
  abstract void i(float paramFloat);
  
  abstract void j(float paramFloat);
  
  abstract void setBackgroundTintList(ColorStateList paramColorStateList);
  
  abstract void setBackgroundTintMode(PorterDuff.Mode paramMode);
  
  static abstract interface a {}
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */