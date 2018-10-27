package android.support.v4.view.a;

import android.view.accessibility.AccessibilityNodeInfo;

final class g
  extends f
{
  g(e parame)
  {
    super(parame);
  }
  
  public final AccessibilityNodeInfo findFocus(int paramInt)
  {
    a locala = this.a.b(paramInt);
    if (locala != null) {
      return locala.a;
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */