package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.af;
import android.support.v4.widget.ay;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class am
{
  private hd a;
  private hd b;
  private final ImageView c;
  
  public am(ImageView paramImageView)
  {
    this.c = paramImageView;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = android.support.v7.b.a.a.b(this.c.getContext(), paramInt);
      if (localDrawable != null) {
        bw.b(localDrawable);
      }
      this.c.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      d();
      return;
      this.c.setImageDrawable(null);
    }
  }
  
  final void a(ColorStateList paramColorStateList)
  {
    if (this.a == null) {
      this.a = new hd();
    }
    hd localhd = this.a;
    localhd.c = paramColorStateList;
    localhd.a = true;
    d();
  }
  
  final void a(PorterDuff.Mode paramMode)
  {
    if (this.a == null) {
      this.a = new hd();
    }
    hd localhd = this.a;
    localhd.d = paramMode;
    localhd.b = true;
    d();
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    int i = 1;
    hf localhf = hf.a(this.c.getContext(), paramAttributeSet, android.support.v7.a.a.ab, paramInt, 0);
    for (;;)
    {
      try
      {
        localObject = this.c.getDrawable();
        paramAttributeSet = (AttributeSet)localObject;
        if (localObject != null) {
          break label275;
        }
        paramInt = localhf.g(1, -1);
        paramAttributeSet = (AttributeSet)localObject;
        if (paramInt == -1) {
          break label275;
        }
        localObject = android.support.v7.b.a.a.b(this.c.getContext(), paramInt);
        paramAttributeSet = (AttributeSet)localObject;
        if (localObject == null) {
          break label275;
        }
        this.c.setImageDrawable((Drawable)localObject);
        paramAttributeSet = (AttributeSet)localObject;
      }
      finally
      {
        Object localObject;
        localhf.c.recycle();
      }
      if (localhf.g(2)) {
        af.a(this.c, localhf.e(2));
      }
      if (localhf.g(3))
      {
        paramAttributeSet = this.c;
        localObject = bw.a(localhf.a(3, -1), null);
        paramInt = Build.VERSION.SDK_INT;
        if (paramInt >= 21) {
          continue;
        }
        if ((paramAttributeSet instanceof ay)) {
          ((ay)paramAttributeSet).setSupportImageTintMode((PorterDuff.Mode)localObject);
        }
      }
      localhf.c.recycle();
      return;
      paramAttributeSet.setImageTintMode((PorterDuff.Mode)localObject);
      if (Build.VERSION.SDK_INT == 21)
      {
        localObject = paramAttributeSet.getDrawable();
        if (paramAttributeSet.getImageTintList() != null)
        {
          if (paramAttributeSet.getImageTintMode() != null)
          {
            paramInt = i;
            if ((localObject != null) && (paramInt != 0))
            {
              if (((Drawable)localObject).isStateful()) {
                ((Drawable)localObject).setState(paramAttributeSet.getDrawableState());
              }
              paramAttributeSet.setImageDrawable((Drawable)localObject);
            }
          }
          else
          {
            paramInt = 0;
            continue;
          }
        }
        else
        {
          paramInt = 0;
          continue;
        }
        continue;
        label275:
        while (paramAttributeSet != null)
        {
          bw.b(paramAttributeSet);
          break;
        }
      }
    }
  }
  
  final boolean a()
  {
    Drawable localDrawable = this.c.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  final ColorStateList b()
  {
    hd localhd = this.a;
    if (localhd != null) {
      return localhd.c;
    }
    return null;
  }
  
  final PorterDuff.Mode c()
  {
    hd localhd = this.a;
    if (localhd != null) {
      return localhd.d;
    }
    return null;
  }
  
  final void d()
  {
    Drawable localDrawable = this.c.getDrawable();
    if (localDrawable != null) {
      bw.b(localDrawable);
    }
    int i;
    if (localDrawable != null)
    {
      i = Build.VERSION.SDK_INT;
      if (i <= 21) {
        break label52;
      }
    }
    label52:
    while (i != 21)
    {
      localObject = this.a;
      if (localObject != null) {
        ae.a(localDrawable, (hd)localObject, this.c.getDrawableState());
      }
      return;
    }
    if (this.b == null) {
      this.b = new hd();
    }
    hd localhd = this.b;
    localhd.a();
    Object localObject = this.c;
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = ((ImageView)localObject).getImageTintList();
    }
    for (;;)
    {
      if (localObject == null) {}
      for (;;)
      {
        localObject = this.c;
        if (Build.VERSION.SDK_INT >= 21) {
          localObject = ((ImageView)localObject).getImageTintMode();
        }
        for (;;)
        {
          if (localObject != null)
          {
            localhd.b = true;
            localhd.d = ((PorterDuff.Mode)localObject);
          }
          if ((!localhd.a) && (!localhd.b)) {
            break;
          }
          ae.a(localDrawable, localhd, this.c.getDrawableState());
          return;
          if ((localObject instanceof ay)) {
            localObject = ((ay)localObject).getSupportImageTintMode();
          } else {
            localObject = null;
          }
        }
        localhd.a = true;
        localhd.c = ((ColorStateList)localObject);
      }
      if ((localObject instanceof ay)) {
        localObject = ((ay)localObject).getSupportImageTintList();
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */