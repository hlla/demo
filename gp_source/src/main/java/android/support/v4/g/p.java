package android.support.v4.g;

import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.Objects;

public final class p
{
  public static int a(Object... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return Objects.hash(paramVarArgs);
    }
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (Build.VERSION.SDK_INT < 19)
    {
      boolean bool1 = bool2;
      if (paramObject1 != paramObject2)
      {
        if (paramObject1 == null) {
          break label39;
        }
        bool1 = bool3;
        if (!paramObject1.equals(paramObject2)) {}
      }
      label39:
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
    }
    return Objects.equals(paramObject1, paramObject2);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */