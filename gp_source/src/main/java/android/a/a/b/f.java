package android.a.a.b;

import java.util.Iterator;

public final class f
  implements h, Iterator
{
  private boolean a = true;
  private e b;
  
  f(b paramb) {}
  
  public final void a_(e parame)
  {
    e locale = this.b;
    if (parame == locale)
    {
      this.b = locale.c;
      if (this.b != null) {
        break label33;
      }
    }
    label33:
    for (boolean bool = true;; bool = false)
    {
      this.a = bool;
      return;
    }
  }
  
  public final boolean hasNext()
  {
    if (this.a) {
      if (this.c.e == null) {}
    }
    e locale;
    do
    {
      return true;
      return false;
      locale = this.b;
    } while ((locale != null) && (locale.b != null));
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/a/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */