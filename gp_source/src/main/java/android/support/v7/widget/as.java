package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ac;
import android.util.AttributeSet;
import android.widget.SeekBar;

final class as
  extends ap
{
  public Drawable b;
  public final SeekBar c;
  private boolean d = false;
  private boolean e = false;
  private ColorStateList f = null;
  private PorterDuff.Mode g = null;
  
  as(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.c = paramSeekBar;
  }
  
  private final void a()
  {
    Drawable localDrawable = this.b;
    if ((localDrawable != null) && ((this.d) || (this.e)))
    {
      this.b = android.support.v4.a.a.a.f(localDrawable.mutate());
      if (this.d) {
        android.support.v4.a.a.a.a(this.b, this.f);
      }
      if (this.e) {
        android.support.v4.a.a.a.a(this.b, this.g);
      }
      if (this.b.isStateful()) {
        this.b.setState(this.c.getDrawableState());
      }
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = hf.a(this.c.getContext(), paramAttributeSet, android.support.v7.a.a.ac, paramInt, 0);
    Drawable localDrawable1 = paramAttributeSet.b(android.support.v7.a.a.ad);
    if (localDrawable1 != null) {
      this.c.setThumb(localDrawable1);
    }
    localDrawable1 = paramAttributeSet.a(android.support.v7.a.a.ae);
    Drawable localDrawable2 = this.b;
    if (localDrawable2 != null) {
      localDrawable2.setCallback(null);
    }
    this.b = localDrawable1;
    if (localDrawable1 != null)
    {
      localDrawable1.setCallback(this.c);
      android.support.v4.a.a.a.b(localDrawable1, ac.h(this.c));
      if (localDrawable1.isStateful()) {
        localDrawable1.setState(this.c.getDrawableState());
      }
      a();
    }
    this.c.invalidate();
    if (paramAttributeSet.g(android.support.v7.a.a.ag))
    {
      this.g = bw.a(paramAttributeSet.a(android.support.v7.a.a.ag, -1), this.g);
      this.e = true;
    }
    if (paramAttributeSet.g(android.support.v7.a.a.af))
    {
      this.f = paramAttributeSet.e(android.support.v7.a.a.af);
      this.d = true;
    }
    paramAttributeSet.c.recycle();
    a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */