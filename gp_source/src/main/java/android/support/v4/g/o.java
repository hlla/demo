package android.support.v4.g;

import java.util.Collection;
import java.util.Iterator;

final class o
  implements Collection
{
  o(j paramj) {}
  
  public final boolean add(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void clear()
  {
    this.a.c();
  }
  
  public final boolean contains(Object paramObject)
  {
    return this.a.b(paramObject) >= 0;
  }
  
  public final boolean containsAll(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final boolean isEmpty()
  {
    return this.a.a() == 0;
  }
  
  public final Iterator iterator()
  {
    return new k(this.a, 1);
  }
  
  public final boolean remove(Object paramObject)
  {
    int i = this.a.b(paramObject);
    if (i >= 0)
    {
      this.a.a(i);
      return true;
    }
    return false;
  }
  
  public final boolean removeAll(Collection paramCollection)
  {
    int i = 0;
    int j = this.a.a();
    boolean bool = false;
    while (i < j)
    {
      int m = i;
      int k = j;
      if (paramCollection.contains(this.a.a(i, 1)))
      {
        this.a.a(i);
        m = i - 1;
        k = j - 1;
        bool = true;
      }
      i = m + 1;
      j = k;
    }
    return bool;
  }
  
  public final boolean retainAll(Collection paramCollection)
  {
    int i = 0;
    int j = this.a.a();
    boolean bool = false;
    while (i < j)
    {
      int m = i;
      int k = j;
      if (!paramCollection.contains(this.a.a(i, 1)))
      {
        this.a.a(i);
        m = i - 1;
        k = j - 1;
        bool = true;
      }
      i = m + 1;
      j = k;
    }
    return bool;
  }
  
  public final int size()
  {
    return this.a.a();
  }
  
  public final Object[] toArray()
  {
    return this.a.b(1);
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    return this.a.a(paramArrayOfObject, 1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */