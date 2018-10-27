package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class av
  implements View.OnClickListener
{
  private final View a;
  private final String b;
  private Context c;
  private Method d;
  
  public av(View paramView, String paramString)
  {
    this.a = paramView;
    this.b = paramString;
  }
  
  public final void onClick(View paramView)
  {
    Object localObject;
    if (this.d == null)
    {
      localObject = this.a.getContext();
      if (localObject == null)
      {
        int i = this.a.getId();
        if (i == -1) {
          break label235;
        }
        paramView = new StringBuilder();
        paramView.append(" with id '");
        paramView.append(this.a.getContext().getResources().getResourceEntryName(i));
        paramView.append("'");
      }
    }
    for (paramView = paramView.toString();; paramView = "")
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not find method ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("(View) in a parent or ancestor Context for android:onClick ");
      ((StringBuilder)localObject).append("attribute defined on view ");
      ((StringBuilder)localObject).append(this.a.getClass());
      ((StringBuilder)localObject).append(paramView);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
      try
      {
        if (!((Context)localObject).isRestricted())
        {
          localMethod = localObject.getClass().getMethod(this.b, new Class[] { View.class });
          if (localMethod != null) {
            break label203;
          }
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Method localMethod;
        for (;;) {}
      }
      if ((localObject instanceof ContextWrapper))
      {
        localObject = ((ContextWrapper)localObject).getBaseContext();
        break;
      }
      localObject = null;
      break;
      label203:
      this.d = localMethod;
      this.c = ((Context)localObject);
      try
      {
        this.d.invoke(this.c, new Object[] { paramView });
        return;
      }
      catch (IllegalAccessException paramView)
      {
        throw new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
      }
      catch (InvocationTargetException paramView)
      {
        label235:
        throw new IllegalStateException("Could not execute method for android:onClick", paramView);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */