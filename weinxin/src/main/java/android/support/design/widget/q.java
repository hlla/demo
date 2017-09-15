package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class q
{
  private static q jv;
  b jw;
  b jx;
  private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback()
  {
    public final boolean handleMessage(Message arg1)
    {
      switch (???.what)
      {
      default: 
        return false;
      }
      q localq = q.this;
      q.b localb = (q.b)???.obj;
      synchronized (localq.mLock)
      {
        if ((localq.jw == localb) || (localq.jx == localb)) {
          localq.a(localb);
        }
        return true;
      }
    }
  });
  final Object mLock = new Object();
  
  static q am()
  {
    if (jv == null) {
      jv = new q();
    }
    return jv;
  }
  
  public final void a(a parama)
  {
    synchronized (this.mLock)
    {
      if (d(parama)) {
        this.mHandler.removeCallbacksAndMessages(this.jw);
      }
      return;
    }
  }
  
  final boolean a(b paramb)
  {
    if ((a)paramb.jz.get() != null)
    {
      this.mHandler.removeCallbacksAndMessages(paramb);
      return true;
    }
    return false;
  }
  
  public final void b(a parama)
  {
    synchronized (this.mLock)
    {
      if (d(parama)) {
        b(this.jw);
      }
      return;
    }
  }
  
  final void b(b paramb)
  {
    if (paramb.duration == -2) {
      return;
    }
    int i = 2750;
    if (paramb.duration > 0) {
      i = paramb.duration;
    }
    for (;;)
    {
      this.mHandler.removeCallbacksAndMessages(paramb);
      this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 0, paramb), i);
      return;
      if (paramb.duration == -1) {
        i = 1500;
      }
    }
  }
  
  public final boolean c(a parama)
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!d(parama))
        {
          if (!e(parama)) {
            break label40;
          }
          break label35;
          return bool;
        }
      }
      label35:
      boolean bool = true;
      continue;
      label40:
      bool = false;
    }
  }
  
  final boolean d(a parama)
  {
    return (this.jw != null) && (this.jw.f(parama));
  }
  
  final boolean e(a parama)
  {
    return (this.jx != null) && (this.jx.f(parama));
  }
  
  static abstract interface a {}
  
  private static final class b
  {
    public int duration;
    public final WeakReference<q.a> jz;
    
    final boolean f(q.a parama)
    {
      return (parama != null) && (this.jz.get() == parama);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */