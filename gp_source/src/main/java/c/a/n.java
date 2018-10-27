package c.a;

import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

abstract class n
  extends AbstractSet
  implements Iterable, Set
{
  private n(f paramf) {}
  
  public abstract boolean a(Object paramObject);
  
  public boolean add(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean b(Object paramObject);
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return a(paramObject);
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }
  
  public abstract Iterator iterator();
  
  public boolean remove(Object paramObject)
  {
    return b(paramObject);
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    Iterator localIterator = iterator();
    boolean bool = false;
    while (localIterator.hasNext()) {
      if (!paramCollection.contains(localIterator.next()))
      {
        localIterator.remove();
        bool = true;
      }
    }
    return bool;
  }
  
  public int size()
  {
    return this.a.size();
  }
  
  public Object[] toArray()
  {
    Object[] arrayOfObject = new Object[size()];
    Iterator localIterator = iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfObject[i] = localIterator.next();
      i += 1;
    }
    return arrayOfObject;
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    int j = size();
    if (paramArrayOfObject.length < j) {
      paramArrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), j);
    }
    for (;;)
    {
      Iterator localIterator = iterator();
      int i = 0;
      while (i < j)
      {
        paramArrayOfObject[i] = localIterator.next();
        i += 1;
      }
      if (paramArrayOfObject.length > j) {
        paramArrayOfObject[j] = null;
      }
      return paramArrayOfObject;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */