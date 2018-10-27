package android.support.design.internal;

import android.support.v4.view.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

final class a
  extends b
{
  a(CheckableImageButton paramCheckableImageButton) {}
  
  public final void a(View paramView, android.support.v4.view.a.a parama)
  {
    super.a(paramView, parama);
    parama.a(true);
    parama.b(this.b.isChecked());
  }
  
  public final void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setChecked(this.b.isChecked());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */