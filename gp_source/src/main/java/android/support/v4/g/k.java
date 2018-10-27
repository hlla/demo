package android.support.v4.g;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class k
  implements Iterator
{
  private boolean a = false;
  private int b;
  private final int c;
  private int d;
  
  k(j paramj, int paramInt)
  {
    this.c = paramInt;
    this.d = paramj.a();
  }
  
  public final boolean hasNext()
  {
    return this.b < this.d;
  }
  
  public final Object next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    Object localObject = this.e.a(this.b, this.c);
    this.b += 1;
    this.a = true;
    return localObject;
  }
  
  public final void remove()
  {
    if (!this.a) {
      throw new IllegalStateException();
    }
    this.b -= 1;
    this.d -= 1;
    this.a = false;
    this.e.a(this.b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */