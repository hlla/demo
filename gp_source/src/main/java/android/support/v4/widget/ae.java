package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.a.e;
import android.support.v4.view.ac;
import android.view.View;
import android.view.accessibility.AccessibilityManager;

final class ae
  extends e
{
  ae(ab paramab) {}
  
  public final a a(int paramInt)
  {
    return a.a(this.b.a(paramInt));
  }
  
  public final boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool2 = false;
    ab localab = this.b;
    boolean bool1;
    switch (paramInt1)
    {
    default: 
      switch (paramInt2)
      {
      default: 
        bool1 = localab.b(paramInt1, paramInt2);
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              return ac.a(localab.c, paramInt2, paramBundle);
              return localab.b(paramInt1);
              bool1 = bool2;
            } while (!localab.e.isEnabled());
            bool1 = bool2;
          } while (!localab.e.isTouchExplorationEnabled());
          paramInt2 = localab.b;
          bool1 = bool2;
        } while (paramInt2 == paramInt1);
        if (paramInt2 == Integer.MIN_VALUE) {}
        for (;;)
        {
          localab.b = paramInt1;
          localab.c.invalidate();
          localab.a(paramInt1, 32768);
          return true;
          localab.b(paramInt2);
        }
        return localab.c(paramInt1);
        if (localab.c.isFocused()) {
          break;
        }
        bool1 = bool2;
      } while (!localab.c.requestFocus());
      paramInt2 = localab.d;
      bool1 = bool2;
    } while (paramInt2 == paramInt1);
    if (paramInt2 == Integer.MIN_VALUE) {}
    for (;;)
    {
      localab.d = paramInt1;
      localab.a(paramInt1, 8);
      return true;
      localab.c(paramInt2);
    }
  }
  
  public final a b(int paramInt)
  {
    if (paramInt != 2) {}
    for (paramInt = this.b.d;; paramInt = this.b.b)
    {
      if (paramInt != Integer.MIN_VALUE) {
        return a(paramInt);
      }
      return null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */