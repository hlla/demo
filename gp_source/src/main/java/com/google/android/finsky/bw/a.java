package com.google.android.finsky.bw;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.a.h;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

public final class a
{
  @TargetApi(19)
  public static void a(Context paramContext, CharSequence paramCharSequence, View paramView, boolean paramBoolean)
  {
    if (a(paramContext)) {
      if (paramBoolean) {
        break label72;
      }
    }
    label72:
    while (Build.VERSION.SDK_INT < 19)
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(16384);
      localAccessibilityEvent.getText().add(paramCharSequence);
      localAccessibilityEvent.setEnabled(true);
      if (paramView != null) {
        new h(localAccessibilityEvent).a.setSource(paramView);
      }
      ((AccessibilityManager)paramContext.getSystemService("accessibility")).sendAccessibilityEvent(localAccessibilityEvent);
      return;
    }
    paramView.setAccessibilityLiveRegion(1);
  }
  
  public static boolean a(Context paramContext)
  {
    return ((AccessibilityManager)paramContext.getSystemService("accessibility")).isTouchExplorationEnabled();
  }
  
  public static boolean b(Context paramContext)
  {
    return ((AccessibilityManager)paramContext.getSystemService("accessibility")).isEnabled();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */