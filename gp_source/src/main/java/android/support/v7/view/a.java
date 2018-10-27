package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class a
{
  public Context a;
  
  private a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public final int a()
  {
    Configuration localConfiguration = this.a.getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    if ((localConfiguration.smallestScreenWidthDp <= 600) && (i <= 600)) {
      if (i > 960) {
        break label112;
      }
    }
    for (;;)
    {
      if (i <= 720) {}
      label93:
      while (j <= 960)
      {
        if (i < 500) {
          if (i > 640) {
            break label93;
          }
        }
        for (;;)
        {
          if (i <= 480) {}
          while (j <= 640)
          {
            if (i < 360) {
              return 2;
            }
            return 3;
          }
          do
          {
            return 4;
          } while (j > 480);
        }
      }
      label112:
      do
      {
        return 5;
      } while (j > 720);
    }
  }
  
  public final boolean b()
  {
    return this.a.getResources().getBoolean(2131034112);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */