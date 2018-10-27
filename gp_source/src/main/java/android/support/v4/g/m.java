package android.support.v4.g;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class m
  implements Set
{
  m(j paramj) {}
  
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
    return this.a.a(paramObject) >= 0;
  }
  
  public final boolean containsAll(Collection paramCollection)
  {
    Map localMap = this.a.b();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!localMap.containsKey(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    return j.a(this, paramObject);
  }
  
  public final int hashCode()
  {
    int i = this.a.a() - 1;
    int j = 0;
    if (i >= 0)
    {
      Object localObject = this.a.a(i, 0);
      if (localObject != null) {}
      for (int k = localObject.hashCode();; k = 0)
      {
        j += k;
        i -= 1;
        break;
      }
    }
    return j;
  }
  
  public final boolean isEmpty()
  {
    return this.a.a() == 0;
  }
  
  public final Iterator iterator()
  {
    return new k(this.a, 0);
  }
  
  public final boolean remove(Object paramObject)
  {
    int i = this.a.a(paramObject);
    if (i >= 0)
    {
      this.a.a(i);
      return true;
    }
    return false;
  }
  
  public final boolean removeAll(Collection paramCollection)
  {
    Map localMap = this.a.b();
    int i = localMap.size();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localMap.remove(paramCollection.next());
    }
    return i != localMap.size();
  }
  
  public final boolean retainAll(Collection paramCollection)
  {
    return j.a(this.a.b(), paramCollection);
  }
  
  public final int size()
  {
    return this.a.a();
  }
  
  public final Object[] toArray()
  {
    return this.a.b(0);
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    return this.a.a(paramArrayOfObject, 0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */