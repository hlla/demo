package android.support.design.b;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;

final class c
{
  public static final boolean a;
  public GradientDrawable b;
  public boolean c = false;
  public ColorStateList d;
  public PorterDuff.Mode e;
  public final Rect f = new Rect();
  public final Paint g = new Paint(1);
  public GradientDrawable h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public GradientDrawable n;
  public final a o;
  public final RectF p = new RectF();
  public ColorStateList q;
  public GradientDrawable r;
  public ColorStateList s;
  public GradientDrawable t;
  public int u;
  public Drawable v;
  public Drawable w;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public c(a parama)
  {
    this.o = parama;
  }
  
  final InsetDrawable a(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, this.k, this.m, this.l, this.j);
  }
  
  final void a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      android.support.v4.a.a.a.a((Drawable)localObject, this.d);
      localObject = this.e;
      if (localObject != null) {
        android.support.v4.a.a.a.a(this.b, (PorterDuff.Mode)localObject);
      }
    }
  }
  
  @TargetApi(21)
  final Drawable b()
  {
    this.b = new GradientDrawable();
    this.b.setCornerRadius(this.i + 1.0E-5F);
    this.b.setColor(-1);
    a();
    this.t = new GradientDrawable();
    this.t.setCornerRadius(this.i + 1.0E-5F);
    this.t.setColor(0);
    this.t.setStroke(this.u, this.s);
    InsetDrawable localInsetDrawable = a(new LayerDrawable(new Drawable[] { this.b, this.t }));
    this.n = new GradientDrawable();
    this.n.setCornerRadius(this.i + 1.0E-5F);
    this.n.setColor(-1);
    return new b(android.support.design.e.a.a(this.q), localInsetDrawable, this.n);
  }
  
  final void c()
  {
    if ((a) && (this.t != null)) {
      this.o.a(b());
    }
    while (a) {
      return;
    }
    this.o.invalidate();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */