package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public final class bf
{
  private final Object a;
  
  private bf(Object paramObject)
  {
    this.a = paramObject;
  }
  
  static bf a(Object paramObject)
  {
    if (paramObject != null) {
      return new bf(paramObject);
    }
    return null;
  }
  
  static Object a(bf parambf)
  {
    if (parambf != null) {
      return parambf.a;
    }
    return null;
  }
  
  public final int a()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.a).getSystemWindowInsetLeft();
    }
    return 0;
  }
  
  public final bf a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new bf(((WindowInsets)this.a).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return null;
  }
  
  public final int b()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.a).getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int c()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.a).getSystemWindowInsetRight();
    }
    return 0;
  }
  
  public final int d()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.a).getSystemWindowInsetBottom();
    }
    return 0;
  }
  
  public final boolean e()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.a).isConsumed();
    }
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (this != paramObject)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (getClass() == paramObject.getClass())
        {
          paramObject = (bf)paramObject;
          Object localObject = this.a;
          if (localObject == null) {
            break label54;
          }
          bool1 = localObject.equals(((bf)paramObject).a);
        }
      }
      label54:
      do
      {
        return bool1;
        bool1 = bool2;
      } while (((bf)paramObject).a != null);
      return true;
    }
    return true;
  }
  
  public final int hashCode()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return localObject.hashCode();
    }
    return 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */