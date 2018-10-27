package android.support.v4.app;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;

final class aw
  implements Runnable
{
  aw(Object paramObject1, bf parambf, View paramView, Fragment paramFragment, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, Object paramObject2) {}
  
  public final void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      this.e.c(localObject, this.g);
      localObject = au.a(this.e, this.a, this.f, this.h, this.g);
      this.b.addAll((Collection)localObject);
    }
    if (this.d != null)
    {
      if (this.c != null)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.g);
        this.e.b(this.c, this.d, (ArrayList)localObject);
      }
      this.d.clear();
      this.d.add(this.g);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */