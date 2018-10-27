package com.google.android.finsky.i.a;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.e.i;
import com.google.android.finsky.utils.FinskyLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements com.google.android.finsky.i.a
{
  public boolean a = false;
  public final com.google.android.finsky.bm.a b;
  public final i c;
  public final Handler d = new Handler(Looper.getMainLooper());
  public final boolean e;
  public int f = 0;
  public boolean g = false;
  public int h;
  public int i;
  public final Runnable j = new b(this);
  private final List k = new ArrayList();
  private boolean l = true;
  
  public a(Application paramApplication, com.google.android.finsky.bm.a parama, i parami, boolean paramBoolean)
  {
    this.b = parama;
    this.c = parami;
    this.e = paramBoolean;
    paramApplication.registerActivityLifecycleCallbacks(new c(this));
  }
  
  public final void a()
  {
    StringWriter localStringWriter = new StringWriter();
    com.google.e.a.a.a.a.a.a(new Throwable(), new PrintWriter(localStringWriter));
    FinskyLog.a("Exit with status: %d, called from : %s", new Object[] { Integer.valueOf(0), localStringWriter.toString().substring(0, Math.min(localStringWriter.getBuffer().length(), ((Integer)d.aZ.b()).intValue())) });
    System.exit(0);
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.k.add(paramRunnable);
  }
  
  public final boolean b()
  {
    return this.l;
  }
  
  final void c()
  {
    this.d.removeCallbacks(this.j);
    if (this.i <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.l = bool;
      if (!this.l) {
        break;
      }
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext())
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        this.d.post(localRunnable);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/i/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */