package b.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class a
{
  public static List a(int paramInt)
  {
    if (paramInt != 0) {
      return new ArrayList(paramInt);
    }
    return Collections.emptyList();
  }
  
  public static LinkedHashMap b(int paramInt)
  {
    return new LinkedHashMap(c(paramInt));
  }
  
  static int c(int paramInt)
  {
    if (paramInt < 3) {
      return paramInt + 1;
    }
    if (paramInt < 1073741824) {
      return (int)(paramInt / 0.75F + 1.0F);
    }
    return Integer.MAX_VALUE;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */