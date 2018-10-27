package android.support.c;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class j
{
  public final Intent a = new Intent("android.intent.action.VIEW");
  private boolean b = true;
  
  public j()
  {
    this(null);
  }
  
  public j(m paramm)
  {
    if (paramm != null) {
      this.a.setPackage(paramm.b.getPackageName());
    }
    Bundle localBundle = new Bundle();
    if (paramm != null) {
      paramm = paramm.a.asBinder();
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 18)
      {
        localBundle.putBinder("android.support.customtabs.extra.SESSION", paramm);
        label78:
        this.a.putExtras(localBundle);
        return;
      }
      if (!android.support.v4.app.i.b) {}
      try
      {
        Method localMethod = Bundle.class.getMethod("putIBinder", new Class[] { String.class, IBinder.class });
        android.support.v4.app.i.a = localMethod;
        localMethod.setAccessible(true);
        android.support.v4.app.i.b = true;
        if (android.support.v4.app.i.a == null) {
          break label78;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          android.support.v4.app.i.a.invoke(localBundle, new Object[] { "android.support.customtabs.extra.SESSION", paramm });
        }
        catch (InvocationTargetException paramm)
        {
          for (;;)
          {
            Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", paramm);
            android.support.v4.app.i.a = null;
            break label78;
            paramm = null;
            break;
            localNoSuchMethodException = localNoSuchMethodException;
            Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", localNoSuchMethodException);
          }
        }
        catch (IllegalAccessException paramm)
        {
          for (;;) {}
        }
        catch (IllegalArgumentException paramm)
        {
          for (;;) {}
        }
      }
    }
  }
  
  public final i a()
  {
    this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.b);
    return new i(this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */