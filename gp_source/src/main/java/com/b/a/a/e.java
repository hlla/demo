package com.b.a.a;

import java.util.Iterator;
import java.util.List;

final class e
  implements Iterator
{
  private int a = 0;
  
  e(d paramd) {}
  
  public final boolean hasNext()
  {
    return (this.a < this.b.b.size()) || (this.b.a.hasNext());
  }
  
  public final Object next()
  {
    for (;;)
    {
      if (this.a < this.b.b.size())
      {
        localObject = this.b.b;
        int i = this.a;
        this.a = (i + 1);
        return ((List)localObject).get(i);
      }
      Object localObject = this.b;
      ((d)localObject).b.add(((d)localObject).a.next());
    }
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/b/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */