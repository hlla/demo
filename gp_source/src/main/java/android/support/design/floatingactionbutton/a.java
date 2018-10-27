package android.support.design.floatingactionbutton;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.f.b;

final class a
  implements b
{
  a(FloatingActionButton paramFloatingActionButton) {}
  
  public final float a()
  {
    return this.a.c() / 2.0F;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.c.set(paramInt1, paramInt2, paramInt3, paramInt4);
    FloatingActionButton localFloatingActionButton = this.a;
    int i = localFloatingActionButton.b;
    localFloatingActionButton.setPadding(paramInt1 + i, paramInt2 + i, paramInt3 + i, i + paramInt4);
  }
  
  public final void a(Drawable paramDrawable)
  {
    FloatingActionButton.a(this.a, paramDrawable);
  }
  
  public final boolean b()
  {
    return this.a.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/floatingactionbutton/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */