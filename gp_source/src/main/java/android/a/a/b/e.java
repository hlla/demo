package android.a.a.b;

import java.util.Map.Entry;

public final class e
  implements Map.Entry
{
  public final Object a;
  public e b;
  public e c;
  public final Object d;
  
  e(Object paramObject1, Object paramObject2)
  {
    this.a = paramObject1;
    this.d = paramObject2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof e)) {
        paramObject = (e)paramObject;
      }
    }
    else {
      return (this.a.equals(((e)paramObject).a)) && (this.d.equals(((e)paramObject).d));
    }
    return false;
  }
  
  public final Object getKey()
  {
    return this.a;
  }
  
  public final Object getValue()
  {
    return this.d;
  }
  
  public final Object setValue(Object paramObject)
  {
    throw new UnsupportedOperationException("An entry modification is not supported");
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("=");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/a/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */