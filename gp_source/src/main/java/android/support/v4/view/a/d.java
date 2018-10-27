package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public final class d
{
  public final Object a;
  
  public d(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public static d a()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return new d(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 0, 0, 0, true));
    }
    return new d(null);
  }
  
  public static d a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new d(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2));
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return new d(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1));
    }
    return new d(null);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */