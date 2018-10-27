package android.support.design.floatingactionbutton;

import android.os.Build.VERSION;
import android.support.design.f.a;
import android.support.design.internal.p;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class e
  implements ViewTreeObserver.OnPreDrawListener
{
  e(b paramb) {}
  
  public final boolean onPreDraw()
  {
    b localb = this.a;
    float f = localb.z.getRotation();
    if (localb.u != f)
    {
      localb.u = f;
      if (Build.VERSION.SDK_INT == 19)
      {
        if (localb.u % 90.0F == 0.0F) {
          break label135;
        }
        if (localb.z.getLayerType() != 1) {
          localb.z.setLayerType(1, null);
        }
      }
    }
    for (;;)
    {
      Object localObject = localb.v;
      if (localObject != null)
      {
        f = -localb.u;
        if (((a)localObject).c != f)
        {
          ((a)localObject).c = f;
          ((a)localObject).invalidateSelf();
        }
      }
      localObject = localb.i;
      if (localObject != null)
      {
        f = -localb.u;
        if (f != ((android.support.design.internal.b)localObject).g)
        {
          ((android.support.design.internal.b)localObject).g = f;
          ((android.support.design.internal.b)localObject).invalidateSelf();
        }
      }
      return true;
      label135:
      if (localb.z.getLayerType() != 0) {
        localb.z.setLayerType(0, null);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/floatingactionbutton/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */