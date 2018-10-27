package android.support.v7.widget;

import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

final class gp
{
  public Method a;
  public Method b;
  private Method c;
  
  gp()
  {
    try
    {
      this.b = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      this.b.setAccessible(true);
      try
      {
        this.a = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
        this.a.setAccessible(true);
        try
        {
          this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
          this.c.setAccessible(true);
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException1) {}
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        for (;;) {}
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      for (;;) {}
    }
  }
  
  final void a(AutoCompleteTextView paramAutoCompleteTextView)
  {
    Method localMethod = this.c;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramAutoCompleteTextView, new Object[] { Boolean.valueOf(true) });
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/gp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */