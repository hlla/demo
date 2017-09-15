package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.View;

final class f
{
  private final h Um;
  private an Up;
  private an Uq;
  private an Ur;
  private final View mView;
  
  f(View paramView, h paramh)
  {
    this.mView = paramView;
    this.Um = paramh;
  }
  
  final void a(PorterDuff.Mode paramMode)
  {
    if (this.Uq == null) {
      this.Uq = new an();
    }
    this.Uq.nl = paramMode;
    this.Uq.aeD = true;
    ev();
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.mView.getContext().obtainStyledAttributes(paramAttributeSet, a.k.dF, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(a.k.NT))
      {
        ColorStateList localColorStateList = this.Um.e(this.mView.getContext(), paramAttributeSet.getResourceId(a.k.NT, -1));
        if (localColorStateList != null) {
          f(localColorStateList);
        }
      }
      if (paramAttributeSet.hasValue(a.k.NU)) {
        z.a(this.mView, paramAttributeSet.getColorStateList(a.k.NU));
      }
      if (paramAttributeSet.hasValue(a.k.NV)) {
        z.a(this.mView, w.aQ(paramAttributeSet.getInt(a.k.NV, -1)));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  final void aK(int paramInt)
  {
    if (this.Um != null) {}
    for (ColorStateList localColorStateList = this.Um.e(this.mView.getContext(), paramInt);; localColorStateList = null)
    {
      f(localColorStateList);
      return;
    }
  }
  
  final ColorStateList bL()
  {
    if (this.Uq != null) {
      return this.Uq.aeC;
    }
    return null;
  }
  
  final PorterDuff.Mode bM()
  {
    if (this.Uq != null) {
      return this.Uq.nl;
    }
    return null;
  }
  
  final void d(ColorStateList paramColorStateList)
  {
    if (this.Uq == null) {
      this.Uq = new an();
    }
    this.Uq.aeC = paramColorStateList;
    this.Uq.aeE = true;
    ev();
  }
  
  final void ev()
  {
    int i = 0;
    Drawable localDrawable = this.mView.getBackground();
    if (localDrawable != null)
    {
      if (Build.VERSION.SDK_INT != 21) {
        break label148;
      }
      if (this.Ur == null) {
        this.Ur = new an();
      }
      an localan = this.Ur;
      localan.aeC = null;
      localan.aeE = false;
      localan.nl = null;
      localan.aeD = false;
      Object localObject = z.af(this.mView);
      if (localObject != null)
      {
        localan.aeE = true;
        localan.aeC = ((ColorStateList)localObject);
      }
      localObject = z.ag(this.mView);
      if (localObject != null)
      {
        localan.aeD = true;
        localan.nl = ((PorterDuff.Mode)localObject);
      }
      if ((localan.aeE) || (localan.aeD))
      {
        h.a(localDrawable, localan, this.mView.getDrawableState());
        i = 1;
      }
      if (i == 0) {
        break label148;
      }
    }
    label148:
    do
    {
      return;
      if (this.Uq != null)
      {
        h.a(localDrawable, this.Uq, this.mView.getDrawableState());
        return;
      }
    } while (this.Up == null);
    h.a(localDrawable, this.Up, this.mView.getDrawableState());
  }
  
  final void f(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.Up == null) {
        this.Up = new an();
      }
      this.Up.aeC = paramColorStateList;
      this.Up.aeE = true;
    }
    for (;;)
    {
      ev();
      return;
      this.Up = null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */