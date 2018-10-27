package android.a.a.b;

import java.util.HashMap;

public final class a
  extends b
{
  public HashMap a = new HashMap();
  
  protected final e a(Object paramObject)
  {
    return (e)this.a.get(paramObject);
  }
  
  public final Object a(Object paramObject1, Object paramObject2)
  {
    e locale = a(paramObject1);
    if (locale != null) {
      return locale.d;
    }
    this.a.put(paramObject1, b(paramObject1, paramObject2));
    return null;
  }
  
  public final Object b(Object paramObject)
  {
    Object localObject = super.b(paramObject);
    this.a.remove(paramObject);
    return localObject;
  }
  
  public final boolean c(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */