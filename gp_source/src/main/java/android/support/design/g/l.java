package android.support.design.g;

import android.support.v4.view.ar;
import java.lang.ref.WeakReference;

public final class l
  implements ar
{
  public int a;
  public int b;
  private final WeakReference c;
  
  public l(c paramc)
  {
    this.c = new WeakReference(paramc);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    boolean bool2 = false;
    c localc = (c)this.c.get();
    boolean bool1;
    if (localc != null)
    {
      paramInt2 = this.b;
      if (paramInt2 != 2) {
        break label83;
      }
      if (this.a == 1) {
        break label77;
      }
      bool1 = false;
    }
    for (;;)
    {
      if (paramInt2 == 2) {
        if (this.a != 0) {}
      }
      for (;;)
      {
        localc.a(paramInt1, paramFloat, bool1, bool2);
        return;
        bool2 = true;
        continue;
        bool2 = true;
      }
      label77:
      bool1 = true;
      continue;
      label83:
      bool1 = true;
    }
  }
  
  public final void d_(int paramInt)
  {
    this.a = this.b;
    this.b = paramInt;
  }
  
  public final void r_(int paramInt)
  {
    boolean bool2 = false;
    c localc = (c)this.c.get();
    boolean bool1;
    if ((localc != null) && (localc.getSelectedTabPosition() != paramInt) && (paramInt < localc.getTabCount()))
    {
      int i = this.b;
      if (i == 0) {
        break label83;
      }
      bool1 = bool2;
      if (i == 2)
      {
        if (this.a == 0) {
          break label78;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      localc.a(localc.j_(paramInt), bool1);
      return;
      label78:
      bool1 = true;
      continue;
      label83:
      bool1 = true;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/g/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */