package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.a.e;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class b
{
  private static final View.AccessibilityDelegate b = new View.AccessibilityDelegate();
  public final View.AccessibilityDelegate a = new c(this);
  
  public e a(View paramView)
  {
    paramView = b.getAccessibilityNodeProvider(paramView);
    if (paramView != null) {
      return new e(paramView);
    }
    return null;
  }
  
  public void a(View paramView, int paramInt)
  {
    b.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public void a(View paramView, a parama)
  {
    b.onInitializeAccessibilityNodeInfo(paramView, parama.a);
  }
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    b.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    return b.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
  
  public boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return b.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public void b(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    b.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void c(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    b.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
  
  public boolean d(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return b.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */