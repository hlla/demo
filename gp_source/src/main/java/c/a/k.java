package c.a;

import java.util.Map;

final class k
  implements an
{
  private final Map a;
  
  k(Map paramMap)
  {
    this.a = paramMap;
  }
  
  public final boolean a(Object paramObject1, Object paramObject2)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (paramObject2 != null) {}
    while (this.a.containsKey(paramObject1))
    {
      paramObject1 = this.a.get(paramObject1);
      if (paramObject1 == paramObject2) {
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        if (paramObject1 != null)
        {
          if (paramObject1.equals(paramObject2)) {
            bool1 = bool2;
          }
        }
        else {
          bool1 = false;
        }
      }
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */