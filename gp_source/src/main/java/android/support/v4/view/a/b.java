package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;

public final class b
{
  public static final b a;
  public static final b b;
  public static final b c;
  public static final b d;
  public final Object e;
  
  static
  {
    Object localObject2 = null;
    c = new b(1, null);
    a = new b(2, null);
    new b(4, null);
    new b(8, null);
    b = new b(16, null);
    d = new b(32, null);
    new b(64, null);
    new b(128, null);
    new b(256, null);
    new b(512, null);
    new b(1024, null);
    new b(2048, null);
    new b(4096, null);
    new b(8192, null);
    new b(16384, null);
    new b(32768, null);
    new b(65536, null);
    new b(131072, null);
    new b(262144, null);
    new b(524288, null);
    new b(1048576, null);
    new b(2097152, null);
    if (Build.VERSION.SDK_INT >= 23) {}
    for (Object localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;; localObject1 = null)
    {
      new b(localObject1);
      if (Build.VERSION.SDK_INT >= 23) {}
      for (localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;; localObject1 = null)
      {
        new b(localObject1);
        if (Build.VERSION.SDK_INT >= 23) {}
        for (localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;; localObject1 = null)
        {
          new b(localObject1);
          if (Build.VERSION.SDK_INT >= 23) {}
          for (localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;; localObject1 = null)
          {
            new b(localObject1);
            if (Build.VERSION.SDK_INT >= 23) {}
            for (localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;; localObject1 = null)
            {
              new b(localObject1);
              if (Build.VERSION.SDK_INT >= 23) {}
              for (localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;; localObject1 = null)
              {
                new b(localObject1);
                if (Build.VERSION.SDK_INT >= 23) {}
                for (localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;; localObject1 = null)
                {
                  new b(localObject1);
                  if (Build.VERSION.SDK_INT >= 24) {}
                  for (localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;; localObject1 = null)
                  {
                    new b(localObject1);
                    if (Build.VERSION.SDK_INT >= 26) {}
                    for (localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;; localObject1 = null)
                    {
                      new b(localObject1);
                      if (Build.VERSION.SDK_INT >= 28) {}
                      for (localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;; localObject1 = null)
                      {
                        new b(localObject1);
                        localObject1 = localObject2;
                        if (Build.VERSION.SDK_INT >= 28) {
                          localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
                        }
                        new b(localObject1);
                        return;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public b(int paramInt, CharSequence paramCharSequence) {}
  
  private b(Object paramObject)
  {
    this.e = paramObject;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */