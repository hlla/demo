package c.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
  extends ak
  implements Externalizable, Map
{
  public transient Object[] c;
  
  private final boolean a(an paraman)
  {
    Object[] arrayOfObject1 = this.g;
    Object[] arrayOfObject2 = this.c;
    int i = arrayOfObject1.length;
    for (;;)
    {
      int j = i - 1;
      if (i <= 0) {
        break;
      }
      if (arrayOfObject1[j] != d)
      {
        if (arrayOfObject1[j] != e)
        {
          if (paraman.a(arrayOfObject1[j], arrayOfObject2[j])) {
            i = j;
          } else {
            return false;
          }
        }
        else {
          i = j;
        }
      }
      else {
        i = j;
      }
    }
    return true;
  }
  
  protected final void b(int paramInt)
  {
    this.c[paramInt] = null;
    super.b(paramInt);
  }
  
  protected final int c(int paramInt)
  {
    paramInt = super.c(paramInt);
    this.c = new Object[paramInt];
    return paramInt;
  }
  
  public final void clear()
  {
    if (size() != 0)
    {
      super.clear();
      Object[] arrayOfObject = this.g;
      Arrays.fill(arrayOfObject, 0, arrayOfObject.length, d);
      arrayOfObject = this.c;
      Arrays.fill(arrayOfObject, 0, arrayOfObject.length, null);
    }
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return contains(paramObject);
  }
  
  public final boolean containsValue(Object paramObject)
  {
    boolean bool2 = true;
    Object[] arrayOfObject1 = this.g;
    Object[] arrayOfObject2 = this.c;
    int j;
    boolean bool1;
    if (paramObject == null)
    {
      i = arrayOfObject2.length;
      for (;;)
      {
        j = i - 1;
        if (i <= 0) {
          break;
        }
        if (arrayOfObject1[j] != d)
        {
          if (arrayOfObject1[j] != e)
          {
            bool1 = bool2;
            if (paramObject == arrayOfObject2[j]) {
              break label81;
            }
            i = j;
          }
          else
          {
            i = j;
          }
        }
        else {
          i = j;
        }
      }
      bool1 = false;
      label81:
      return bool1;
    }
    int i = arrayOfObject2.length;
    for (;;)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      if (arrayOfObject1[j] != d)
      {
        if (arrayOfObject1[j] != e)
        {
          Object localObject = arrayOfObject2[j];
          bool1 = bool2;
          if (paramObject == localObject) {
            break label81;
          }
          bool1 = bool2;
          if (paramObject.equals(localObject)) {
            break label81;
          }
          i = j;
          continue;
        }
        i = j;
        continue;
      }
      i = j;
    }
  }
  
  protected final void d(int paramInt)
  {
    Object[] arrayOfObject1 = this.g;
    int i = arrayOfObject1.length;
    Object[] arrayOfObject2 = this.c;
    this.g = new Object[paramInt];
    Arrays.fill(this.g, d);
    this.c = new Object[paramInt];
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt <= 0) {
        break;
      }
      if (arrayOfObject1[i] != d)
      {
        if (arrayOfObject1[i] != e)
        {
          Object localObject = arrayOfObject1[i];
          paramInt = b(localObject);
          if (paramInt < 0) {
            b(this.g[(-paramInt - 1)], localObject);
          }
          this.g[paramInt] = localObject;
          this.c[paramInt] = arrayOfObject2[i];
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
  
  public final Set entrySet()
  {
    return new i(this);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      bool1 = bool2;
      if (((Map)paramObject).size() == size()) {
        bool1 = a(new k((Map)paramObject));
      }
    }
    return bool1;
  }
  
  public final Object get(Object paramObject)
  {
    int i = a(paramObject);
    if (i >= 0) {
      return this.c[i];
    }
    return null;
  }
  
  public final int hashCode()
  {
    l locall = new l(this);
    a(locall);
    return locall.a;
  }
  
  public final Set keySet()
  {
    return new m(this);
  }
  
  public final Object put(Object paramObject1, Object paramObject2)
  {
    boolean bool = true;
    int j = b(paramObject1);
    Object localObject1;
    if (j < 0)
    {
      j = -j - 1;
      localObject1 = this.c[j];
    }
    for (int i = 0;; i = 1)
    {
      Object[] arrayOfObject = this.g;
      Object localObject2 = arrayOfObject[j];
      arrayOfObject[j] = paramObject1;
      this.c[j] = paramObject2;
      if (i != 0) {
        if (localObject2 != d) {
          break label81;
        }
      }
      for (;;)
      {
        a(bool);
        return localObject1;
        label81:
        bool = false;
      }
      localObject1 = null;
    }
  }
  
  public final void putAll(Map paramMap)
  {
    a(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public final void readExternal(ObjectInput paramObjectInput)
  {
    paramObjectInput.readByte();
    int i = paramObjectInput.readInt();
    c(i);
    while (i > 0)
    {
      put(paramObjectInput.readObject(), paramObjectInput.readObject());
      i -= 1;
    }
  }
  
  public final Object remove(Object paramObject)
  {
    int i = a(paramObject);
    if (i >= 0)
    {
      paramObject = this.c[i];
      b(i);
      return paramObject;
    }
    return null;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("{");
    a(new g(localStringBuffer));
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
  
  public final Collection values()
  {
    return new o(this);
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */