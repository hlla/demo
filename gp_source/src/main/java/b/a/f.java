package b.a;

import java.util.Collections;
import java.util.Map;

public final class f
  implements d
{
  private final Map a;
  
  static
  {
    e.a(Collections.emptyMap());
  }
  
  f(Map paramMap)
  {
    this.a = Collections.unmodifiableMap(paramMap);
  }
  
  public static g a(int paramInt)
  {
    return new g(paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */