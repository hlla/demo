package android.support.f;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.v4.view.ac;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public final class c
  extends z
{
  private static final Property q;
  private static final Property r;
  private static final Property s;
  private static final Property t;
  private static final Property u;
  private static final String[] v = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  
  static
  {
    new d(PointF.class, "boundsOrigin");
    u = new e(PointF.class, "topLeft");
    r = new f(PointF.class, "bottomRight");
    q = new g(PointF.class, "bottomRight");
    t = new h(PointF.class, "topLeft");
    s = new i(PointF.class, "position");
    new x();
  }
  
  private static void d(ap paramap)
  {
    View localView = paramap.c;
    if ((ac.I(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      paramap.b.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramap.b.put("android:changeBounds:parent", paramap.c.getParent());
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, ap paramap1, ap paramap2)
  {
    Object localObject;
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i;
    if ((paramap1 != null) && (paramap2 != null))
    {
      localObject = paramap1.b;
      paramViewGroup = paramap2.b;
      localObject = (ViewGroup)((Map)localObject).get("android:changeBounds:parent");
      paramViewGroup = (ViewGroup)paramViewGroup.get("android:changeBounds:parent");
      if ((localObject != null) && (paramViewGroup != null))
      {
        localObject = paramap2.c;
        paramViewGroup = (Rect)paramap1.b.get("android:changeBounds:bounds");
        Rect localRect = (Rect)paramap2.b.get("android:changeBounds:bounds");
        j = paramViewGroup.left;
        k = localRect.left;
        m = paramViewGroup.top;
        n = localRect.top;
        i1 = paramViewGroup.right;
        i2 = localRect.right;
        i3 = paramViewGroup.bottom;
        i4 = localRect.bottom;
        i5 = i1 - j;
        i6 = i3 - m;
        i7 = i2 - k;
        i8 = i4 - n;
        paramViewGroup = (Rect)paramap1.b.get("android:changeBounds:clip");
        paramap1 = (Rect)paramap2.b.get("android:changeBounds:clip");
        if (i5 == 0) {
          if (i7 == 0)
          {
            i = 0;
            label214:
            if ((paramViewGroup != null) && (!paramViewGroup.equals(paramap1))) {
              label226:
              i += 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i > 0)
      {
        ba.a((View)localObject, j, m, i1, i3);
        if (i != 2) {
          if (j != k)
          {
            paramViewGroup = this.j.a(j, m, k, n);
            paramViewGroup = u.a(localObject, t, paramViewGroup);
          }
        }
        for (;;)
        {
          if ((((View)localObject).getParent() instanceof ViewGroup))
          {
            paramap1 = (ViewGroup)((View)localObject).getParent();
            au.a(paramap1, true);
            a(new k(paramap1));
          }
          return paramViewGroup;
          if (m != n) {
            break;
          }
          paramViewGroup = this.j.a(i1, i3, i2, i4);
          paramViewGroup = u.a(localObject, q, paramViewGroup);
          continue;
          if (i5 != i7) {}
          while (i6 != i8)
          {
            paramViewGroup = new l((View)localObject);
            paramap1 = this.j.a(j, m, k, n);
            paramap1 = u.a(paramViewGroup, u, paramap1);
            paramap2 = this.j.a(i1, i3, i2, i4);
            paramap2 = u.a(paramViewGroup, r, paramap2);
            paramViewGroup = new AnimatorSet();
            paramViewGroup.playTogether(new Animator[] { paramap1, paramap2 });
            paramViewGroup.addListener(new j());
            break;
          }
          paramViewGroup = this.j.a(j, m, k, n);
          paramViewGroup = u.a(localObject, s, paramViewGroup);
        }
      }
      return null;
      if (paramViewGroup == null)
      {
        if (paramap1 != null) {
          break label226;
        }
        continue;
        if (i8 == 0)
        {
          i = 0;
          break label214;
          if (i6 == 0) {
            break;
          }
        }
        if (j != k) {
          i = 1;
        }
        for (;;)
        {
          if (i1 != i2) {}
          while (i3 != i4)
          {
            i += 1;
            break;
          }
          break;
          if (m != n) {
            i = 1;
          } else {
            i = 0;
          }
        }
        return null;
        return null;
      }
    }
  }
  
  public final void a(ap paramap)
  {
    d(paramap);
  }
  
  public final String[] a()
  {
    return v;
  }
  
  public final void b(ap paramap)
  {
    d(paramap);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */