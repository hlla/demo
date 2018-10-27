package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.a.e;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

final class c
  extends View.AccessibilityDelegate
{
  private final b a;
  
  c(b paramb)
  {
    this.a = paramb;
  }
  
  public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return this.a.d(paramView, paramAccessibilityEvent);
  }
  
  public final AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    paramView = this.a.a(paramView);
    if (paramView != null) {
      return (AccessibilityNodeProvider)paramView.a;
    }
    return null;
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.a.a(paramView, paramAccessibilityEvent);
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.a.a(paramView, a.a(paramAccessibilityNodeInfo));
  }
  
  public final void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.a.b(paramView, paramAccessibilityEvent);
  }
  
  public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return this.a.a(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return this.a.a(paramView, paramInt, paramBundle);
  }
  
  public final void sendAccessibilityEvent(View paramView, int paramInt)
  {
    this.a.a(paramView, paramInt);
  }
  
  public final void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.a.c(paramView, paramAccessibilityEvent);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */