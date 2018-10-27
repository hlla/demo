package android.support.v7.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.support.v4.view.p;
import android.support.v7.view.menu.t;
import android.support.v7.view.menu.v;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

final class k
{
  public CharSequence A;
  public CharSequence B;
  public CharSequence C;
  public boolean D;
  public Menu E;
  public int a;
  public int b;
  public boolean c;
  public int d;
  public int e;
  public boolean f;
  public d g;
  public String h;
  public String i;
  public int j;
  public boolean k;
  public int l;
  public char m;
  public int n;
  public int o;
  public boolean p;
  public CharSequence q;
  public boolean r;
  public int s;
  public ColorStateList t = null;
  public PorterDuff.Mode u = null;
  public int v;
  public String w;
  public int x;
  public char y;
  public int z;
  
  public k(i parami, Menu paramMenu)
  {
    this.E = paramMenu;
    a();
  }
  
  static char a(String paramString)
  {
    char c1 = '\000';
    if (paramString != null) {
      c1 = paramString.charAt(0);
    }
    return c1;
  }
  
  final Object a(String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfClass = this.F.c.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramArrayOfClass = paramArrayOfClass.newInstance(paramArrayOfObject);
      return paramArrayOfClass;
    }
    catch (Exception paramArrayOfClass)
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("Cannot instantiate class: ");
      paramArrayOfObject.append(paramString);
      Log.w("SupportMenuInflater", paramArrayOfObject.toString(), paramArrayOfClass);
    }
    return null;
  }
  
  public final void a()
  {
    this.d = 0;
    this.a = 0;
    this.e = 0;
    this.b = 0;
    this.f = true;
    this.c = true;
  }
  
  final void a(MenuItem paramMenuItem)
  {
    int i1 = 1;
    Object localObject = paramMenuItem.setChecked(this.p).setVisible(this.D).setEnabled(this.r);
    if (this.o > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.B).setIcon(this.s);
      int i2 = this.z;
      if (i2 >= 0) {
        paramMenuItem.setShowAsAction(i2);
      }
      if (this.w != null)
      {
        if (this.F.c.isRestricted()) {
          throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        }
        localObject = this.F;
        if (((i)localObject).d == null) {
          ((i)localObject).d = i.a(((i)localObject).c);
        }
        paramMenuItem.setOnMenuItemClickListener(new j(((i)localObject).d, this.w));
      }
      bool = paramMenuItem instanceof t;
      if (this.o < 2) {}
      label410:
      do
      {
        for (;;)
        {
          localObject = this.i;
          if (localObject != null) {
            paramMenuItem.setActionView((View)a((String)localObject, i.a, this.F.b));
          }
          for (;;)
          {
            i2 = this.j;
            if (i2 <= 0) {}
            for (;;)
            {
              localObject = this.g;
              if (localObject != null) {
                p.a(paramMenuItem, (d)localObject);
              }
              localObject = this.q;
              bool = paramMenuItem instanceof b;
              if (bool) {
                ((b)paramMenuItem).a((CharSequence)localObject);
              }
              for (;;)
              {
                localObject = this.C;
                if (!bool) {
                  if (Build.VERSION.SDK_INT >= 26) {
                    paramMenuItem.setTooltipText((CharSequence)localObject);
                  }
                }
                for (;;)
                {
                  char c1 = this.m;
                  i1 = this.l;
                  if (!bool) {
                    if (Build.VERSION.SDK_INT >= 26) {
                      paramMenuItem.setAlphabeticShortcut(c1, i1);
                    }
                  }
                  for (;;)
                  {
                    c1 = this.y;
                    i1 = this.x;
                    if (!bool) {
                      if (Build.VERSION.SDK_INT >= 26) {
                        paramMenuItem.setNumericShortcut(c1, i1);
                      }
                    }
                    for (;;)
                    {
                      localObject = this.u;
                      if (localObject == null) {}
                      for (;;)
                      {
                        localObject = this.t;
                        if (localObject != null)
                        {
                          if (!bool) {
                            break label410;
                          }
                          ((b)paramMenuItem).setIconTintList((ColorStateList)localObject);
                        }
                        while (Build.VERSION.SDK_INT < 26) {
                          return;
                        }
                        paramMenuItem.setIconTintList((ColorStateList)localObject);
                        return;
                        if (bool) {
                          ((b)paramMenuItem).setIconTintMode((PorterDuff.Mode)localObject);
                        } else if (Build.VERSION.SDK_INT >= 26) {
                          paramMenuItem.setIconTintMode((PorterDuff.Mode)localObject);
                        }
                      }
                      ((b)paramMenuItem).setNumericShortcut(c1, i1);
                    }
                    ((b)paramMenuItem).setAlphabeticShortcut(c1, i1);
                  }
                  ((b)paramMenuItem).b((CharSequence)localObject);
                }
                if (Build.VERSION.SDK_INT >= 26) {
                  paramMenuItem.setContentDescription((CharSequence)localObject);
                }
              }
              if (i1 != 0) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
              } else {
                paramMenuItem.setActionView(i2);
              }
            }
            i1 = 0;
          }
          if (!bool) {
            break;
          }
          ((t)paramMenuItem).a(true);
        }
      } while (!(paramMenuItem instanceof v));
      localObject = (v)paramMenuItem;
      for (;;)
      {
        try
        {
          if (((v)localObject).e == null) {
            break label648;
          }
          ((v)localObject).e.invoke(((v)localObject).d, new Object[] { Boolean.valueOf(true) });
        }
        catch (Exception localException)
        {
          Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
        }
        break;
        label648:
        localException.e = ((b)localException.d).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
      }
    }
  }
  
  public final SubMenu b()
  {
    this.k = true;
    SubMenu localSubMenu = this.E.addSubMenu(this.d, this.v, this.n, this.A);
    a(localSubMenu.getItem());
    return localSubMenu;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */