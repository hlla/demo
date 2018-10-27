package android.support.d.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class s
  extends Drawable.ConstantState
{
  public boolean a;
  public boolean b;
  public boolean c;
  public Bitmap d;
  public int e;
  public ColorStateList f;
  public PorterDuff.Mode g;
  public int h;
  public Paint i;
  public ColorStateList j = null;
  public PorterDuff.Mode k = l.a;
  public r l;
  
  public s()
  {
    this.l = new r();
  }
  
  public s(s params)
  {
    if (params != null)
    {
      this.h = params.h;
      this.l = new r(params.l);
      Paint localPaint = params.l.d;
      if (localPaint != null) {
        this.l.d = new Paint(localPaint);
      }
      localPaint = params.l.h;
      if (localPaint != null) {
        this.l.h = new Paint(localPaint);
      }
      this.j = params.j;
      this.k = params.k;
      this.a = params.a;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.d.eraseColor(0);
    Canvas localCanvas = new Canvas(this.d);
    r localr = this.l;
    localr.a(localr.f, r.a, localCanvas, paramInt1, paramInt2, null);
  }
  
  public final int getChangingConfigurations()
  {
    return this.h;
  }
  
  public final Drawable newDrawable()
  {
    return new l(this);
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    return new l(this);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */