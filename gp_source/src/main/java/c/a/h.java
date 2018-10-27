package c.a;

import java.util.ConcurrentModificationException;
import java.util.Map.Entry;

final class h
  implements Map.Entry
{
  private final int a;
  private Object b;
  private Object d;
  
  h(f paramf, Object paramObject1, Object paramObject2, int paramInt)
  {
    this.b = paramObject1;
    this.d = paramObject2;
    this.a = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      if (getKey() == null) {
        break label89;
      }
      bool1 = bool2;
      if (!getKey().equals(((Map.Entry)paramObject).getKey())) {}
    }
    for (;;)
    {
      if (getValue() != null)
      {
        bool1 = bool2;
        if (getValue().equals(((Map.Entry)paramObject).getValue())) {
          bool1 = true;
        }
      }
      label89:
      do
      {
        return bool1;
        if (((Map.Entry)paramObject).getValue() == null) {
          break;
        }
        return false;
        bool1 = bool2;
      } while (((Map.Entry)paramObject).getKey() != null);
    }
  }
  
  public final Object getKey()
  {
    return this.b;
  }
  
  public final Object getValue()
  {
    return this.d;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (getKey() != null) {}
    for (int i = getKey().hashCode();; i = 0)
    {
      if (getValue() != null) {
        j = getValue().hashCode();
      }
      return i ^ j;
    }
  }
  
  public final Object setValue(Object paramObject)
  {
    Object[] arrayOfObject = this.c.c;
    int i = this.a;
    Object localObject1 = arrayOfObject[i];
    Object localObject2 = this.d;
    if (localObject1 != localObject2) {
      throw new ConcurrentModificationException();
    }
    arrayOfObject[i] = paramObject;
    this.d = localObject2;
    return localObject2;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */