package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ac;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;

final class ab
{
  private int a = -1;
  private hd b;
  private final ae c;
  private hd d;
  private hd e;
  private final View f;
  
  ab(View paramView)
  {
    this.f = paramView;
    this.c = ae.a();
  }
  
  private final void b(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.d == null) {
        this.d = new hd();
      }
      hd localhd = this.d;
      localhd.c = paramColorStateList;
      localhd.a = true;
    }
    for (;;)
    {
      d();
      return;
      this.d = null;
    }
  }
  
  final void a()
  {
    this.a = -1;
    b(null);
    d();
  }
  
  final void a(int paramInt)
  {
    this.a = paramInt;
    Object localObject = this.c;
    if (localObject != null) {}
    for (localObject = ((ae)localObject).b(this.f.getContext(), paramInt);; localObject = null)
    {
      b((ColorStateList)localObject);
      d();
      return;
    }
  }
  
  final void a(ColorStateList paramColorStateList)
  {
    if (this.b == null) {
      this.b = new hd();
    }
    hd localhd = this.b;
    localhd.c = paramColorStateList;
    localhd.a = true;
    d();
  }
  
  final void a(PorterDuff.Mode paramMode)
  {
    if (this.b == null) {
      this.b = new hd();
    }
    hd localhd = this.b;
    localhd.d = paramMode;
    localhd.b = true;
    d();
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = hf.a(this.f.getContext(), paramAttributeSet, a.dQ, paramInt, 0);
    try
    {
      if (paramAttributeSet.g(0))
      {
        this.a = paramAttributeSet.g(0, -1);
        ColorStateList localColorStateList = this.c.b(this.f.getContext(), this.a);
        if (localColorStateList != null) {
          b(localColorStateList);
        }
      }
      if (paramAttributeSet.g(1)) {
        ac.a(this.f, paramAttributeSet.e(1));
      }
      if (paramAttributeSet.g(2)) {
        ac.a(this.f, bw.a(paramAttributeSet.a(2, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.c.recycle();
    }
  }
  
  final ColorStateList b()
  {
    hd localhd = this.b;
    if (localhd != null) {
      return localhd.c;
    }
    return null;
  }
  
  final PorterDuff.Mode c()
  {
    hd localhd = this.b;
    if (localhd != null) {
      return localhd.d;
    }
    return null;
  }
  
  final void d()
  {
    Drawable localDrawable = this.f.getBackground();
    int i;
    hd localhd;
    if (localDrawable != null)
    {
      i = Build.VERSION.SDK_INT;
      if (i <= 21) {
        break label177;
      }
      if (this.d != null)
      {
        if (this.e == null) {
          this.e = new hd();
        }
        localhd = this.e;
        localhd.a();
        Object localObject = ac.C(this.f);
        if (localObject != null)
        {
          localhd.a = true;
          localhd.c = ((ColorStateList)localObject);
        }
        localObject = ac.D(this.f);
        if (localObject != null)
        {
          localhd.b = true;
          localhd.d = ((PorterDuff.Mode)localObject);
        }
        if ((localhd.a) || (localhd.b)) {
          break label164;
        }
      }
    }
    for (;;)
    {
      localhd = this.b;
      if (localhd != null) {
        ae.a(localDrawable, localhd, this.f.getDrawableState());
      }
      do
      {
        return;
        localhd = this.d;
      } while (localhd == null);
      ae.a(localDrawable, localhd, this.f.getDrawableState());
      return;
      label164:
      ae.a(localDrawable, localhd, this.f.getDrawableState());
      return;
      label177:
      if (i == 21) {
        break;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */