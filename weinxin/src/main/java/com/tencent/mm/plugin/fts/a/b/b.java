package com.tencent.mm.plugin.fts.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.fts.a.a.i;
import java.util.Comparator;

public final class b
  implements Comparator<i>
{
  public static final b lYM;
  
  static
  {
    GMTrace.i(18640560717824L, 138883);
    lYM = new b();
    GMTrace.o(18640560717824L, 138883);
  }
  
  public b()
  {
    GMTrace.i(18640158064640L, 138880);
    GMTrace.o(18640158064640L, 138880);
  }
  
  private static boolean g(char paramChar)
  {
    GMTrace.i(18640292282368L, 138881);
    if ((paramChar >= 'a') && (paramChar <= 'z'))
    {
      GMTrace.o(18640292282368L, 138881);
      return true;
    }
    GMTrace.o(18640292282368L, 138881);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */