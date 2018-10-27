package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.a.a;
import android.support.v4.view.ac;
import android.support.v4.view.k;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

final class s
  extends android.support.v4.view.b
{
  private final Rect b = new Rect();
  
  s(DrawerLayout paramDrawerLayout) {}
  
  public final void a(View paramView, a parama)
  {
    if (DrawerLayout.a)
    {
      super.a(paramView, parama);
      parama.b(DrawerLayout.class.getName());
      parama.c(false);
      parama.d(false);
      parama.a(android.support.v4.view.a.b.c);
      parama.a(android.support.v4.view.a.b.a);
      return;
    }
    Object localObject1 = a.a(parama);
    super.a(paramView, (a)localObject1);
    parama.a.setSource(paramView);
    Object localObject2 = ac.j(paramView);
    if ((localObject2 instanceof View)) {
      parama.a((View)localObject2);
    }
    localObject2 = this.b;
    ((a)localObject1).a((Rect)localObject2);
    parama.b((Rect)localObject2);
    ((a)localObject1).c((Rect)localObject2);
    parama.d((Rect)localObject2);
    parama.e(((a)localObject1).a.isVisibleToUser());
    parama.a(((a)localObject1).a.getPackageName());
    parama.b(((a)localObject1).a.getClassName());
    parama.d(((a)localObject1).a.getContentDescription());
    parama.i(((a)localObject1).a.isEnabled());
    parama.g(((a)localObject1).a.isClickable());
    parama.c(((a)localObject1).a.isFocusable());
    parama.d(((a)localObject1).a.isFocused());
    parama.f(((a)localObject1).a.isAccessibilityFocused());
    boolean bool = ((a)localObject1).a.isSelected();
    parama.a.setSelected(bool);
    parama.h(((a)localObject1).a.isLongClickable());
    parama.a(((a)localObject1).a.getActions());
    ((a)localObject1).a.recycle();
    paramView = (ViewGroup)paramView;
    int j = paramView.getChildCount();
    int i = 0;
    label296:
    if (i < j)
    {
      localObject1 = paramView.getChildAt(i);
      if (DrawerLayout.h((View)localObject1)) {
        break label324;
      }
    }
    for (;;)
    {
      i += 1;
      break label296;
      break;
      label324:
      parama.a.addChild((View)localObject1);
    }
  }
  
  public final void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
  }
  
  public final boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if ((DrawerLayout.a) || (DrawerLayout.h(paramView))) {
      return super.a(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    return false;
  }
  
  public final boolean d(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent = paramAccessibilityEvent.getText();
      paramView = this.c.c();
      int i;
      if (paramView != null)
      {
        i = this.c.c(paramView);
        paramView = this.c;
        i = k.a(i, ac.h(paramView));
        if (i != 3) {
          break label73;
        }
        paramView = paramView.l;
      }
      for (;;)
      {
        if (paramView != null) {
          paramAccessibilityEvent.add(paramView);
        }
        return true;
        label73:
        if (i == 5) {
          paramView = paramView.m;
        } else {
          paramView = null;
        }
      }
    }
    return super.d(paramView, paramAccessibilityEvent);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */