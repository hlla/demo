package com.google.android.finsky.bd;

import android.view.View;
import android.widget.Button;
import com.google.android.finsky.bc.b.b;
import com.google.android.finsky.dialogbuilderlayout.i;
import com.google.wireless.android.finsky.dfe.e.a.et;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
  implements b
{
  public Map a;
  public e b;
  public final i c;
  public View d;
  public f e;
  public Integer f;
  public g g;
  public Integer h;
  public String i;
  public Integer j;
  public String k;
  public List l;
  private final et m;
  
  public d(i parami)
  {
    this.c = parami;
    this.m = new et();
  }
  
  public final void a()
  {
    this.f = Integer.valueOf(0);
    f localf = this.e;
    if (localf != null)
    {
      localf.a(this.f.intValue());
      this.f = null;
    }
  }
  
  public final void a(int paramInt)
  {
    Map localMap = this.a;
    if (localMap == null) {
      switch (paramInt)
      {
      default: 
        this.m.a(0);
      }
    }
    for (;;)
    {
      this.c.a(this.m);
      return;
      this.m.a(2);
      continue;
      this.m.a(1);
      continue;
      if (localMap.isEmpty()) {
        break;
      }
      localMap = this.a;
      Integer localInteger = Integer.valueOf(paramInt);
      if (!localMap.containsKey(localInteger)) {
        break;
      }
      this.m.a(((Integer)this.a.get(localInteger)).intValue());
    }
  }
  
  public final void a(View paramView)
  {
    this.d = paramView;
    paramView = this.g;
    if (paramView != null)
    {
      paramView.a(this.d);
      this.d = null;
    }
  }
  
  public final void a(Button paramButton, int paramInt)
  {
    f localf = this.e;
    if (localf != null)
    {
      localf.a(paramButton, paramInt);
      return;
    }
    if (this.l == null) {
      this.l = new ArrayList();
    }
    this.l.add(new h(paramButton, paramInt));
  }
  
  public final void a(String paramString)
  {
    this.i = paramString;
    paramString = this.g;
    if (paramString != null)
    {
      paramString.a(this.i);
      this.i = null;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (this.h = Integer.valueOf(8);; this.h = Integer.valueOf(0))
    {
      g localg = this.g;
      if (localg != null)
      {
        localg.b(this.h.intValue());
        this.h = null;
      }
      return;
    }
  }
  
  public final void b()
  {
    this.c.X();
  }
  
  public final void b(int paramInt)
  {
    this.j = Integer.valueOf(paramInt);
    g localg = this.g;
    if (localg != null)
    {
      localg.a(this.j.intValue());
      this.j = null;
    }
  }
  
  public final void b(String paramString)
  {
    this.k = paramString;
    paramString = this.b;
    if (paramString != null)
    {
      paramString.a(this.c.af, this.k);
      this.k = null;
    }
    this.c.W();
  }
  
  public final void c()
  {
    g localg = this.g;
    if (localg != null) {
      localg.c();
    }
  }
  
  public final void d()
  {
    f localf = this.e;
    if (localf != null) {
      localf.c();
    }
    while (this.l == null) {
      return;
    }
    this.l = null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bd/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */