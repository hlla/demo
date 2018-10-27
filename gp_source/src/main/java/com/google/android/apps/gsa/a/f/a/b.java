package com.google.android.apps.gsa.a.f.a;

import com.google.android.apps.gsa.a.e.j;
import com.google.common.base.aq;
import com.google.common.base.x;
import java.util.concurrent.Executor;

final class b
  implements Executor
{
  private final com.google.android.apps.gsa.a.f.a a;
  private final com.google.android.apps.gsa.a.d.d b;
  private final j c;
  
  b(com.google.android.apps.gsa.a.f.a parama, com.google.android.apps.gsa.a.d.d paramd, j paramj)
  {
    this.a = parama;
    this.b = paramd;
    this.c = paramj;
  }
  
  public final void execute(Runnable paramRunnable)
  {
    com.google.android.apps.gsa.a.d.a locala = (com.google.android.apps.gsa.a.d.a)com.google.android.apps.gsa.a.d.b.a.get();
    com.google.android.apps.gsa.a.d.b.a.set(null);
    locala = (com.google.android.apps.gsa.a.d.a)x.a(locala);
    paramRunnable = new d(locala, paramRunnable, this.b);
    this.b.a(paramRunnable);
    try
    {
      this.c.b(locala);
      this.a.a(paramRunnable);
      return;
    }
    finally
    {
      this.b.b(paramRunnable);
      aq.a(localThrowable);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/apps/gsa/a/f/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */