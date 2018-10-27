package android.support.v7.view;

import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.lang.reflect.Method;

final class j
  implements MenuItem.OnMenuItemClickListener
{
  private static final Class[] a = { MenuItem.class };
  private Method b;
  private Object c;
  
  public j(Object paramObject, String paramString)
  {
    this.c = paramObject;
    Class localClass = paramObject.getClass();
    try
    {
      this.b = localClass.getMethod(paramString, a);
      return;
    }
    catch (Exception paramObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Couldn't resolve menu item onClick handler ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" in class ");
      localStringBuilder.append(localClass.getName());
      paramString = new InflateException(localStringBuilder.toString());
      paramString.initCause((Throwable)paramObject);
      throw paramString;
    }
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    try
    {
      if (this.b.getReturnType() != Boolean.TYPE)
      {
        this.b.invoke(this.c, new Object[] { paramMenuItem });
        return true;
      }
      boolean bool = ((Boolean)this.b.invoke(this.c, new Object[] { paramMenuItem })).booleanValue();
      return bool;
    }
    catch (Exception paramMenuItem)
    {
      throw new RuntimeException(paramMenuItem);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */