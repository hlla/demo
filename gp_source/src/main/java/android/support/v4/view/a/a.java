package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public final class a
{
  public final AccessibilityNodeInfo a;
  public int b = -1;
  
  private a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.a = paramAccessibilityNodeInfo;
  }
  
  public static a a(a parama)
  {
    return a(AccessibilityNodeInfo.obtain(parama.a));
  }
  
  public static a a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return new a(paramAccessibilityNodeInfo);
  }
  
  public final void a()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.a.setDismissable(true);
    }
  }
  
  public final void a(int paramInt)
  {
    this.a.addAction(paramInt);
  }
  
  public final void a(Rect paramRect)
  {
    this.a.getBoundsInParent(paramRect);
  }
  
  public final void a(View paramView)
  {
    this.a.setParent(paramView);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.a.setPackageName(paramCharSequence);
  }
  
  public final void a(Object paramObject)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAccessibilityNodeInfo = this.a;
      if (paramObject == null) {
        break label34;
      }
    }
    label34:
    for (paramObject = (AccessibilityNodeInfo.CollectionItemInfo)((d)paramObject).a;; paramObject = null)
    {
      localAccessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)paramObject);
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a.setCheckable(paramBoolean);
  }
  
  public final boolean a(b paramb)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.removeAction((AccessibilityNodeInfo.AccessibilityAction)paramb.e);
    }
    return false;
  }
  
  public final void b(Rect paramRect)
  {
    this.a.setBoundsInParent(paramRect);
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    this.a.setClassName(paramCharSequence);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.a.setChecked(paramBoolean);
  }
  
  public final void c(Rect paramRect)
  {
    this.a.getBoundsInScreen(paramRect);
  }
  
  public final void c(CharSequence paramCharSequence)
  {
    this.a.setText(paramCharSequence);
  }
  
  public final void c(boolean paramBoolean)
  {
    this.a.setFocusable(paramBoolean);
  }
  
  public final void d(Rect paramRect)
  {
    this.a.setBoundsInScreen(paramRect);
  }
  
  public final void d(CharSequence paramCharSequence)
  {
    this.a.setContentDescription(paramCharSequence);
  }
  
  public final void d(boolean paramBoolean)
  {
    this.a.setFocused(paramBoolean);
  }
  
  public final void e(boolean paramBoolean)
  {
    this.a.setVisibleToUser(paramBoolean);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (this != paramObject)
    {
      boolean bool1 = bool2;
      AccessibilityNodeInfo localAccessibilityNodeInfo;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (getClass() == paramObject.getClass())
        {
          paramObject = (a)paramObject;
          localAccessibilityNodeInfo = this.a;
          if (localAccessibilityNodeInfo != null) {
            break label55;
          }
          bool1 = bool2;
          if (((a)paramObject).a != null) {}
        }
      }
      label55:
      while (localAccessibilityNodeInfo.equals(((a)paramObject).a))
      {
        bool1 = true;
        return bool1;
      }
      return false;
    }
    return true;
  }
  
  public final void f(boolean paramBoolean)
  {
    this.a.setAccessibilityFocused(paramBoolean);
  }
  
  public final void g(boolean paramBoolean)
  {
    this.a.setClickable(paramBoolean);
  }
  
  public final void h(boolean paramBoolean)
  {
    this.a.setLongClickable(paramBoolean);
  }
  
  public final int hashCode()
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = this.a;
    if (localAccessibilityNodeInfo != null) {
      return localAccessibilityNodeInfo.hashCode();
    }
    return 0;
  }
  
  public final void i(boolean paramBoolean)
  {
    this.a.setEnabled(paramBoolean);
  }
  
  public final void j(boolean paramBoolean)
  {
    this.a.setScrollable(paramBoolean);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(super.toString());
    Object localObject = new Rect();
    a((Rect)localObject);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("; boundsInParent: ");
    localStringBuilder2.append(localObject);
    localStringBuilder1.append(localStringBuilder2.toString());
    c((Rect)localObject);
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("; boundsInScreen: ");
    localStringBuilder2.append(localObject);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("; packageName: ");
    localStringBuilder1.append(this.a.getPackageName());
    localStringBuilder1.append("; className: ");
    localStringBuilder1.append(this.a.getClassName());
    localStringBuilder1.append("; text: ");
    localStringBuilder1.append(this.a.getText());
    localStringBuilder1.append("; contentDescription: ");
    localStringBuilder1.append(this.a.getContentDescription());
    localStringBuilder1.append("; viewId: ");
    if (Build.VERSION.SDK_INT >= 18) {}
    for (localObject = this.a.getViewIdResourceName();; localObject = null)
    {
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append("; checkable: ");
      localStringBuilder1.append(this.a.isCheckable());
      localStringBuilder1.append("; checked: ");
      localStringBuilder1.append(this.a.isChecked());
      localStringBuilder1.append("; focusable: ");
      localStringBuilder1.append(this.a.isFocusable());
      localStringBuilder1.append("; focused: ");
      localStringBuilder1.append(this.a.isFocused());
      localStringBuilder1.append("; selected: ");
      localStringBuilder1.append(this.a.isSelected());
      localStringBuilder1.append("; clickable: ");
      localStringBuilder1.append(this.a.isClickable());
      localStringBuilder1.append("; longClickable: ");
      localStringBuilder1.append(this.a.isLongClickable());
      localStringBuilder1.append("; enabled: ");
      localStringBuilder1.append(this.a.isEnabled());
      localStringBuilder1.append("; password: ");
      localStringBuilder1.append(this.a.isPassword());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("; scrollable: ");
      ((StringBuilder)localObject).append(this.a.isScrollable());
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localStringBuilder1.append("; [");
      int i = this.a.getActions();
      if (i != 0)
      {
        int j = 1 << Integer.numberOfTrailingZeros(i);
        i = (j ^ 0xFFFFFFFF) & i;
        switch (j)
        {
        default: 
          localObject = "ACTION_UNKNOWN";
        }
        for (;;)
        {
          localStringBuilder1.append((String)localObject);
          if (i != 0)
          {
            localStringBuilder1.append(", ");
            break;
          }
          break;
          localObject = "ACTION_SET_SELECTION";
          continue;
          localObject = "ACTION_CUT";
          continue;
          localObject = "ACTION_PASTE";
          continue;
          localObject = "ACTION_COPY";
          continue;
          localObject = "ACTION_SCROLL_BACKWARD";
          continue;
          localObject = "ACTION_SCROLL_FORWARD";
          continue;
          localObject = "ACTION_PREVIOUS_HTML_ELEMENT";
          continue;
          localObject = "ACTION_NEXT_HTML_ELEMENT";
          continue;
          localObject = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
          continue;
          localObject = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
          continue;
          localObject = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
          continue;
          localObject = "ACTION_ACCESSIBILITY_FOCUS";
          continue;
          localObject = "ACTION_LONG_CLICK";
          continue;
          localObject = "ACTION_CLICK";
          continue;
          localObject = "ACTION_CLEAR_SELECTION";
          continue;
          localObject = "ACTION_SELECT";
          continue;
          localObject = "ACTION_CLEAR_FOCUS";
          continue;
          localObject = "ACTION_FOCUS";
        }
      }
      localStringBuilder1.append("]");
      return localStringBuilder1.toString();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */