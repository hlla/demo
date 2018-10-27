package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.g.a;
import android.view.View;
import java.util.ArrayList;

final class ay
  implements Runnable
{
  ay(bf parambf, a parama, Object paramObject1, az paramaz, ArrayList paramArrayList1, View paramView, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayList paramArrayList2, Object paramObject2, Rect paramRect) {}
  
  public final void run()
  {
    Object localObject1 = au.a(this.d, this.h, this.b, this.c);
    if (localObject1 != null)
    {
      this.k.addAll(((a)localObject1).values());
      this.k.add(this.i);
    }
    au.a(this.f, this.j, this.g, (a)localObject1, false);
    Object localObject2 = this.b;
    if (localObject2 != null)
    {
      this.d.a(localObject2, this.l, this.k);
      localObject1 = au.a((a)localObject1, this.c, this.a, this.g);
      if (localObject1 != null) {
        bf.a((View)localObject1, this.e);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */