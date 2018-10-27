package android.a.b;

import java.lang.reflect.Method;

final class c
{
  public final int a;
  public final Method b;
  
  c(int paramInt, Method paramMethod)
  {
    this.a = paramInt;
    this.b = paramMethod;
    this.b.setAccessible(true);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject != null) && (getClass() == paramObject.getClass())) {
        paramObject = (c)paramObject;
      }
    }
    else {
      return (this.a == ((c)paramObject).a) && (this.b.getName().equals(((c)paramObject).b.getName()));
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.a * 31 + this.b.getName().hashCode();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */