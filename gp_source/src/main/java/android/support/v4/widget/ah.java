package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.widget.ScrollView;

final class ah
  extends b
{
  public final void a(View paramView, a parama)
  {
    super.a(paramView, parama);
    paramView = (NestedScrollView)paramView;
    parama.b(ScrollView.class.getName());
    if (paramView.isEnabled())
    {
      int i = paramView.a();
      if (i > 0)
      {
        parama.j(true);
        if (paramView.getScrollY() > 0) {
          parama.a(8192);
        }
        if (paramView.getScrollY() < i) {
          parama.a(4096);
        }
      }
    }
  }
  
  public final void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramView, paramAccessibilityEvent);
    paramView = (NestedScrollView)paramView;
    paramAccessibilityEvent.setClassName(ScrollView.class.getName());
    if (paramView.a() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramAccessibilityEvent.setScrollable(bool);
      paramAccessibilityEvent.setScrollX(paramView.getScrollX());
      paramAccessibilityEvent.setScrollY(paramView.getScrollY());
      paramAccessibilityEvent.setMaxScrollX(paramView.getScrollX());
      paramAccessibilityEvent.setMaxScrollY(paramView.a());
      return;
    }
  }
  
  public final boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    if (!super.a(paramView, paramInt, paramBundle))
    {
      paramView = (NestedScrollView)paramView;
      if (!paramView.isEnabled()) {}
    }
    else
    {
      switch (paramInt)
      {
      default: 
        bool = false;
        return bool;
      case 4096: 
        paramInt = Math.min(paramView.getHeight() - paramView.getPaddingBottom() - paramView.getPaddingTop() + paramView.getScrollY(), paramView.a());
        if (paramInt != paramView.getScrollY())
        {
          paramView.b(paramInt);
          return true;
        }
        return false;
      }
      paramInt = paramView.getHeight();
      int i = paramView.getPaddingBottom();
      int j = paramView.getPaddingTop();
      paramInt = Math.max(paramView.getScrollY() - (paramInt - i - j), 0);
      if (paramInt != paramView.getScrollY())
      {
        paramView.b(paramInt);
        return true;
      }
      return false;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */