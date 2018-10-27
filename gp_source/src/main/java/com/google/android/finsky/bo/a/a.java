package com.google.android.finsky.bo.a;

import android.support.v4.g.h;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.bo.f;

public final class a
  implements com.google.android.finsky.bo.a
{
  public b.a a;
  public com.google.android.finsky.bo.c b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public a()
  {
    ((b)com.google.android.finsky.dt.b.a(b.class)).a(this);
    if (((Boolean)com.google.android.finsky.ag.c.au.a()).booleanValue()) {
      this.c = true;
    }
  }
  
  public final void a(h paramh1, h paramh2) {}
  
  public final void a(boolean paramBoolean)
  {
    this.e = true;
    boolean bool;
    if (this.d) {
      bool = true;
    }
    for (;;)
    {
      this.d = bool;
      com.google.android.finsky.ag.c.au.a(Boolean.valueOf(true));
      if ((paramBoolean) || (!this.b.cY().a(12655434L))) {
        com.google.android.finsky.ag.c.as.a(Boolean.valueOf(paramBoolean));
      }
      ((com.google.android.finsky.i.c)this.a.a()).a();
      return;
      if (!paramBoolean) {
        bool = false;
      } else {
        bool = true;
      }
    }
  }
  
  public final boolean a()
  {
    return this.c;
  }
  
  public final void b()
  {
    if ((!this.d) && (this.b.cY().a(12655434L))) {
      com.google.android.finsky.ag.c.as.a(Boolean.valueOf(false));
    }
    this.c = false;
    if ((!this.b.cY().a(12644215L)) || (!this.e)) {
      com.google.android.finsky.ag.c.au.a(Boolean.valueOf(false));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bo/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */