package c.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class q
  extends ak
  implements Externalizable, Iterable, Set
{
  public final boolean add(Object paramObject)
  {
    boolean bool = false;
    int i = b(paramObject);
    if (i >= 0)
    {
      Object[] arrayOfObject = this.g;
      Object localObject = arrayOfObject[i];
      arrayOfObject[i] = paramObject;
      if (localObject == d) {
        bool = true;
      }
      a(bool);
      return true;
    }
    return false;
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    int i = paramCollection.size();
    a(i);
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    for (;;)
    {
      int j = i - 1;
      if (i <= 0) {
        break;
      }
      if (add(paramCollection.next()))
      {
        bool = true;
        i = j;
      }
      else
      {
        i = j;
      }
    }
    return bool;
  }
  
  public final void clear()
  {
    super.clear();
    Object[] arrayOfObject = this.g;
    Arrays.fill(arrayOfObject, 0, arrayOfObject.length, d);
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
  
  protected final void d(int paramInt)
  {
    Object[] arrayOfObject = this.g;
    int i = arrayOfObject.length;
    this.g = new Object[paramInt];
    Arrays.fill(this.g, d);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt <= 0) {
        break;
      }
      if (arrayOfObject[i] != d)
      {
        if (arrayOfObject[i] != e)
        {
          Object localObject = arrayOfObject[i];
          paramInt = b(localObject);
          if (paramInt < 0) {
            b(this.g[(-paramInt - 1)], localObject);
          }
          this.g[paramInt] = localObject;
          paramInt = i;
        }
        else
        {
          paramInt = i;
        }
      }
      else {
        paramInt = i;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Set))
    {
      paramObject = (Set)paramObject;
      bool1 = bool2;
      if (((Set)paramObject).size() == size()) {
        bool1 = containsAll((Collection)paramObject);
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    s locals = new s(this);
    a(locals);
    return locals.a;
  }
  
  public final Iterator iterator()
  {
    return new al(this);
  }
  
  public final void readExternal(ObjectInput paramObjectInput)
  {
    paramObjectInput.readByte();
    int i = paramObjectInput.readInt();
    c(i);
    while (i > 0)
    {
      add(paramObjectInput.readObject());
      i -= 1;
    }
  }
  
  public final boolean remove(Object paramObject)
  {
    int i = a(paramObject);
    if (i >= 0)
    {
      b(i);
      return true;
    }
    return false;
  }
  
  public final boolean removeAll(Collection paramCollection)
  {
    int i = paramCollection.size();
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    for (;;)
    {
      int j = i - 1;
      if (i <= 0) {
        break;
      }
      if (remove(paramCollection.next()))
      {
        bool = true;
        i = j;
      }
      else
      {
        i = j;
      }
    }
    return bool;
  }
  
  public final boolean retainAll(Collection paramCollection)
  {
    int i = size();
    Iterator localIterator = iterator();
    boolean bool = false;
    for (;;)
    {
      int j = i - 1;
      if (i <= 0) {
        break;
      }
      if (!paramCollection.contains(localIterator.next()))
      {
        localIterator.remove();
        bool = true;
        i = j;
      }
      else
      {
        i = j;
      }
    }
    return bool;
  }
  
  public final Object[] toArray()
  {
    Object[] arrayOfObject = new Object[size()];
    a(new aq(arrayOfObject));
    return arrayOfObject;
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    int i = size();
    if (paramArrayOfObject.length < i) {
      paramArrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), i);
    }
    for (;;)
    {
      a(new aq(paramArrayOfObject));
      if (paramArrayOfObject.length > i) {
        paramArrayOfObject[i] = null;
      }
      return paramArrayOfObject;
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("{");
    a(new r(localStringBuffer));
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
  
  public final void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeByte(0);
    paramObjectOutput.writeInt(this.b);
    paramObjectOutput = new c(paramObjectOutput);
    if (!a(paramObjectOutput)) {
      throw paramObjectOutput.a;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */