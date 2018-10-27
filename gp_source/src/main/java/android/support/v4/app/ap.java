package android.support.v4.app;

import java.util.ArrayList;

final class ap
  implements n
{
  public final boolean a;
  public int b;
  public final f c;
  
  public final void a()
  {
    this.b += 1;
  }
  
  public final void b()
  {
    int k = this.b;
    z localz = this.c.j;
    int j = localz.a.size();
    int i = 0;
    if (i >= j)
    {
      localObject = this.c;
      localz = ((f)localObject).j;
      boolean bool2 = this.a;
      if (k <= 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localz.a((f)localObject, bool2, bool1, true);
        return;
      }
    }
    Object localObject = (Fragment)localz.a.get(i);
    ((Fragment)localObject).G();
    if ((0 != 0) && (0 != 0)) {
      throw new NullPointerException();
    }
    if (k <= 0) {}
    for (;;)
    {
      i += 1;
      break;
      ((Fragment)localObject).P();
    }
  }
  
  public final void c()
  {
    f localf = this.c;
    localf.j.a(localf, this.a, false, false);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */