package com.google.android.finsky.e;

import android.content.Context;
import com.google.android.finsky.cy.e;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.libraries.performance.primes.bz;
import com.google.android.play.b.a.s;
import com.google.android.play.b.v;
import com.google.android.play.utils.f;
import com.google.wireless.android.a.b.a.a.bg;
import f.a.a.a.a.b.bx;

public final class x
  implements v
{
  public Context a;
  public i b;
  public aj c;
  
  public x()
  {
    ((b)com.google.android.finsky.dt.b.a(b.class)).a(this);
  }
  
  public final void a(s params)
  {
    int j = 0;
    int i = 0;
    Object localObject;
    if (this.c != null)
    {
      localObject = params.c;
      if (((bx)localObject).j != null)
      {
        localObject = ((bx)localObject).d;
        if (!((String)localObject).equals(ar.b.toString())) {
          if (!((String)localObject).equals(ar.a.toString())) {
            FinskyLog.e("Unknown jank event name: %s", new Object[] { localObject });
          }
        }
        for (;;)
        {
          this.c.a(i, params.c.j);
          this.c = null;
          return;
          i = 3;
          continue;
          i = 1;
        }
      }
    }
    switch (f.a(e.a(this.a)))
    {
    default: 
      i = j;
    }
    for (;;)
    {
      params.b = i;
      params.a |= 0x1;
      localObject = this.b.cV();
      bg localbg = new d(9).a;
      localbg.aB = params;
      ((u)localObject).a(localbg, null, -1L);
      return;
      i = 4;
      continue;
      i = 1;
      continue;
      i = 8;
      continue;
      i = 2;
      continue;
      i = 7;
      continue;
      i = 3;
      continue;
      i = 6;
      continue;
      i = 5;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */