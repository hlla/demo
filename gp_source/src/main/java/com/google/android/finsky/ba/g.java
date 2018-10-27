package com.google.android.finsky.ba;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.e;

public final class g
{
  private final Context a;
  private Boolean b = null;
  private Boolean c = null;
  private Boolean d = null;
  private Integer e = null;
  
  public g(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final boolean a()
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool2 = true;
    boolean bool7 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if (this.b == null)
        {
          if ((!c()) || (!e()) || (!a.c(this.a))) {
            continue;
          }
          if (f() == 5) {
            this.b = Boolean.valueOf(bool1);
          }
        }
        else
        {
          bool1 = this.b.booleanValue();
          return bool1;
        }
        bool1 = false;
        continue;
        if (!a.b(this.a)) {
          break label127;
        }
        if (f() == 3)
        {
          bool1 = bool3;
          this.b = Boolean.valueOf(bool1);
          continue;
        }
        bool1 = false;
      }
      finally {}
      continue;
      label127:
      if (c())
      {
        if (f() != 2) {
          break label296;
        }
        bool1 = bool4;
        label145:
        this.b = Boolean.valueOf(bool1);
      }
      else
      {
        if (!a.c(this.a)) {
          break;
        }
        if (f() != 4) {
          break label301;
        }
        bool1 = bool5;
        label177:
        this.b = Boolean.valueOf(bool1);
      }
    }
    if (a.a(this.a)) {
      if (f() != 6) {
        break label306;
      }
    }
    label296:
    label301:
    label306:
    for (bool1 = bool6;; bool1 = false)
    {
      this.b = Boolean.valueOf(bool1);
      break;
      if (e())
      {
        bool1 = bool2;
        if (f() != 1)
        {
          bool1 = bool2;
          if (f() != 2)
          {
            bool1 = bool2;
            if (f() != 0) {
              bool1 = false;
            }
          }
        }
        this.b = Boolean.valueOf(bool1);
        break;
      }
      if (f() == 0) {}
      for (bool1 = bool7;; bool1 = false)
      {
        this.b = Boolean.valueOf(bool1);
        break;
      }
      bool1 = false;
      break label145;
      bool1 = false;
      break label177;
    }
  }
  
  public final boolean b()
  {
    return (f() == 2) && (c());
  }
  
  public final boolean c()
  {
    try
    {
      if (this.d == null) {
        this.d = Boolean.valueOf(e.c(this.a));
      }
      boolean bool = this.d.booleanValue();
      return bool;
    }
    finally {}
  }
  
  public final boolean d()
  {
    return ((f() == 1) || (f() == 5)) && (e());
  }
  
  public final boolean e()
  {
    try
    {
      if (this.c == null) {
        this.c = Boolean.valueOf(this.a.getPackageManager().hasSystemFeature("com.google.android.feature.services_updater"));
      }
      boolean bool = this.c.booleanValue();
      return bool;
    }
    finally {}
  }
  
  public final int f()
  {
    if (this.e == null) {
      this.e = Integer.valueOf(0);
    }
    return this.e.intValue();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ba/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */