package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class f
  extends AccessibilityNodeProvider
{
  public final e a;
  
  f(e parame)
  {
    this.a = parame;
  }
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    a locala = this.a.a(paramInt);
    if (locala != null) {
      return locala.a;
    }
    return null;
  }
  
  public List findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    return null;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return this.a.a(paramInt1, paramInt2, paramBundle);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */