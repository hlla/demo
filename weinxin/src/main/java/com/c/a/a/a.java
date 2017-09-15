package com.c.a.a;

import android.content.Context;
import android.os.Handler;

abstract class a
  extends d
  implements m
{
  private final d[] aJb;
  private final Handler[] aJc;
  private final d.a[] aJd;
  
  a(d... paramVarArgs)
  {
    this.aJb = paramVarArgs;
    this.aJc = new Handler[this.aJb.length];
    this.aJd = new d.a[this.aJc.length];
  }
  
  final void O(Context paramContext)
  {
    int i = 0;
    d[] arrayOfd = this.aJb;
    int j = arrayOfd.length;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      d locald = arrayOfd[i];
      try
      {
        locald.a(paramContext, new m[] { this });
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  final void P(Context paramContext)
  {
    paramContext = this.aJb;
    int j = paramContext.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      paramContext[i].stop();
      i += 1;
    }
  }
  
  void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    a(paramHandler, this.aJc);
    a(parama, this.aJd);
    int i = 0;
    for (;;)
    {
      if (i >= this.aJb.length) {
        return;
      }
      try
      {
        this.aJb[i].a(this.aJc[i], this.aJd[i]);
        i += 1;
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
    }
  }
  
  abstract void a(Handler paramHandler, Handler[] paramArrayOfHandler);
  
  abstract void a(d.a parama, d.a[] paramArrayOfa);
  
  final void ne()
  {
    d[] arrayOfd = this.aJb;
    int j = arrayOfd.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      arrayOfd[i].nh();
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */