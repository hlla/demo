package com.c.a.a;

import android.os.Handler;
import android.util.SparseArray;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class z
{
  private static z aPC;
  private static final SparseArray<z> aPD = new SparseArray();
  private final ExecutorService aPE;
  private final Handler handler;
  
  private z(Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (this.aPE = null;; this.aPE = Executors.newSingleThreadExecutor())
    {
      this.handler = paramHandler;
      return;
    }
  }
  
  static z b(Handler paramHandler)
  {
    if (paramHandler != null)
    {
      int i = paramHandler.getLooper().hashCode();
      z localz2 = (z)aPD.get(i);
      z localz1 = localz2;
      if (localz2 == null)
      {
        localz1 = new z(paramHandler);
        aPD.put(i, localz1);
      }
      return localz1;
    }
    if (aPC == null) {
      aPC = new z(null);
    }
    return aPC;
  }
  
  final void execute(Runnable paramRunnable)
  {
    if (this.handler != null)
    {
      this.handler.post(paramRunnable);
      return;
    }
    this.aPE.execute(paramRunnable);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */