package b.b.b;

import java.util.Objects;

public final class d
{
  private final Class a;
  
  public d(Class paramClass)
  {
    this.a = paramClass;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof d)) {
        paramObject = (d)paramObject;
      }
    }
    else {
      return (Objects.equals(this.a, ((d)paramObject).a)) && (Objects.equals(null, null));
    }
    return false;
  }
  
  public final int hashCode()
  {
    return (Objects.hashCode(this.a) ^ 0xF4243) * 1000003 ^ Objects.hashCode(null);
  }
  
  public final String toString()
  {
    Class localClass = this.a;
    if (localClass != null) {
      return localClass.getCanonicalName();
    }
    throw new IllegalStateException();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/b/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */