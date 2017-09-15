package com.c.a.a;

import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

abstract class d
{
  boolean aJi;
  private Collection<WeakReference<m>> aJj;
  private a aJk;
  boolean isReady;
  private Handler mHandler;
  private Context ty;
  
  private void b(Context paramContext, m... paramVarArgs)
  {
    this.ty = paramContext;
    if (paramVarArgs == null) {
      this.aJj = null;
    }
    for (;;)
    {
      O(paramContext);
      return;
      this.aJj = new LinkedList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        m localm = paramVarArgs[i];
        this.aJj.add(new WeakReference(localm));
        i += 1;
      }
    }
  }
  
  abstract void O(Context paramContext);
  
  abstract void P(Context paramContext);
  
  abstract void a(Context paramContext, Handler paramHandler, a parama);
  
  final void a(Context paramContext, m... paramVarArgs)
  {
    if (paramContext == null) {
      try
      {
        throw new Exception("Module: context cannot be null");
      }
      finally {}
    }
    nh();
    b(paramContext.getApplicationContext(), paramVarArgs);
    this.isReady = true;
  }
  
  void a(Handler paramHandler, a parama)
  {
    try
    {
      stop();
      this.mHandler = paramHandler;
      this.aJk = parama;
      a(this.ty, this.mHandler, this.aJk);
      this.aJi = true;
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  final void c(p paramp)
  {
    if (!this.aJi) {}
    for (;;)
    {
      return;
      if (this.aJj != null)
      {
        Iterator localIterator = this.aJj.iterator();
        while (localIterator.hasNext())
        {
          m localm = (m)((WeakReference)localIterator.next()).get();
          if (localm != null) {
            localm.a(paramp);
          }
        }
      }
    }
  }
  
  abstract void ne();
  
  final void nh()
  {
    try
    {
      if (this.isReady)
      {
        stop();
        ne();
        this.isReady = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void stop()
  {
    try
    {
      if (this.aJi)
      {
        P(this.ty);
        this.mHandler = null;
        this.aJk = null;
        this.aJi = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  static class a
  {
    final long aJl;
    
    a(long paramLong)
    {
      this.aJl = Math.max(paramLong, 0L);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */