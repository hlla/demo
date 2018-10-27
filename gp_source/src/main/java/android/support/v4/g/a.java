package android.support.v4.g;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
  extends v
  implements Map
{
  private j c;
  
  public a() {}
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  public a(v paramv)
  {
    super(paramv);
  }
  
  private final j a()
  {
    if (this.c == null) {
      this.c = new b(this);
    }
    return this.c;
  }
  
  public Set entrySet()
  {
    j localj = a();
    if (localj.a == null) {
      localj.a = new l(localj);
    }
    return localj.a;
  }
  
  public Set keySet()
  {
    return a().d();
  }
  
  public void putAll(Map paramMap)
  {
    a(this.b + paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public Collection values()
  {
    j localj = a();
    if (localj.b == null) {
      localj.b = new o(localj);
    }
    return localj.b;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */