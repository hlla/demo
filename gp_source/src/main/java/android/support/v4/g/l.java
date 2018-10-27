package android.support.v4.g;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class l
  implements Set
{
  l(j paramj) {}
  
  public final boolean addAll(Collection paramCollection)
  {
    int i = this.a.a();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramCollection.next();
      this.a.a(localEntry.getKey(), localEntry.getValue());
    }
    return i != this.a.a();
  }
  
  public final void clear()
  {
    this.a.c();
  }
  
  public final boolean contains(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      int i = this.a.a(((Map.Entry)paramObject).getKey());
      bool1 = bool2;
      if (i >= 0) {
        bool1 = e.a(this.a.a(i, 1), ((Map.Entry)paramObject).getValue());
      }
    }
    return bool1;
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
  
  public final boolean equals(Object paramObject)
  {
    return j.a(this, paramObject);
  }
  
  public final int hashCode()
  {
    int j = this.a.a() - 1;
    int i = 0;
    if (j >= 0)
    {
      Object localObject1 = this.a.a(j, 0);
      Object localObject2 = this.a.a(j, 1);
      if (localObject1 != null) {}
      for (int k = localObject1.hashCode();; k = 0)
      {
        if (localObject2 != null) {}
        for (int m = localObject2.hashCode();; m = 0)
        {
          j -= 1;
          i += (m ^ k);
          break;
        }
      }
    }
    return i;
  }
  
  public final boolean isEmpty()
  {
    return this.a.a() == 0;
  }
  
  public final Iterator iterator()
  {
    return new n(this.a);
  }
  
  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean removeAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean retainAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final int size()
  {
    return this.a.a();
  }
  
  public final Object[] toArray()
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */