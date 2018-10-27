package android.a.a.b;

import java.util.Iterator;

abstract class g
  implements h, Iterator
{
  private e a;
  private e b;
  
  g(e parame1, e parame2)
  {
    this.a = parame2;
    this.b = parame1;
  }
  
  private final e a()
  {
    e locale1 = this.b;
    e locale2 = this.a;
    if ((locale1 != locale2) && (locale2 != null)) {
      return a(locale1);
    }
    return null;
  }
  
  abstract e a(e parame);
  
  public final void a_(e parame)
  {
    if ((this.a == parame) && (parame == this.b))
    {
      this.b = null;
      this.a = null;
    }
    e locale = this.a;
    if (locale == parame) {
      this.a = b(locale);
    }
    if (this.b == parame) {
      this.b = a();
    }
  }
  
  abstract e b(e parame);
  
  public boolean hasNext()
  {
    return this.b != null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/a/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */