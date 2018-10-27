package c.a;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class e
  extends z
  implements Iterator
{
  private final ak d;
  
  public e(ak paramak)
  {
    super(paramak);
    this.d = paramak;
  }
  
  protected final int a()
  {
    if (this.a != this.b.size()) {
      throw new ConcurrentModificationException();
    }
    Object[] arrayOfObject = this.d.g;
    int i = this.c;
    int j;
    for (;;)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      if (arrayOfObject[j] != ak.d)
      {
        if (arrayOfObject[j] != ak.e) {
          break;
        }
        i = j;
      }
      else
      {
        i = j;
      }
    }
    return j;
  }
  
  protected abstract Object a(int paramInt);
  
  public Object next()
  {
    int i = a();
    this.c = i;
    if (i < 0) {
      throw new NoSuchElementException();
    }
    return a(this.c);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */