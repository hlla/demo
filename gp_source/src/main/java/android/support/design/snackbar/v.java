package android.support.design.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class v
{
  private static v e;
  public y a;
  public final Handler b = new Handler(Looper.getMainLooper(), new w(this));
  public final Object c = new Object();
  public y d;
  
  static v a()
  {
    if (e == null) {
      e = new v();
    }
    return e;
  }
  
  public final void a(x paramx)
  {
    synchronized (this.c)
    {
      if (e(paramx))
      {
        paramx = this.a;
        if (!paramx.c)
        {
          paramx.c = true;
          this.b.removeCallbacksAndMessages(paramx);
        }
      }
      return;
    }
  }
  
  final void a(y paramy)
  {
    int j = paramy.b;
    if (j != -2)
    {
      i = j;
      if (j <= 0) {
        if (j != -1) {
          break label56;
        }
      }
    }
    label56:
    for (int i = 1500;; i = 2750)
    {
      this.b.removeCallbacksAndMessages(paramy);
      Handler localHandler = this.b;
      localHandler.sendMessageDelayed(Message.obtain(localHandler, 0, paramy), i);
      return;
    }
  }
  
  final boolean a(y paramy, int paramInt)
  {
    x localx = (x)paramy.a.get();
    if (localx != null)
    {
      this.b.removeCallbacksAndMessages(paramy);
      localx.a(paramInt);
      return true;
    }
    return false;
  }
  
  final void b()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      this.a = ((y)localObject);
      this.d = null;
      localObject = (x)this.a.a.get();
      if (localObject != null) {
        ((x)localObject).a();
      }
    }
    else
    {
      return;
    }
    this.a = null;
  }
  
  public final void b(x paramx)
  {
    synchronized (this.c)
    {
      if (e(paramx))
      {
        paramx = this.a;
        if (paramx.c) {}
      }
      else
      {
        return;
      }
      paramx.c = false;
      a(paramx);
    }
  }
  
  public final boolean c(x paramx)
  {
    synchronized (this.c)
    {
      boolean bool = e(paramx);
      return bool;
    }
  }
  
  public final boolean d(x paramx)
  {
    boolean bool2 = true;
    Object localObject = this.c;
    boolean bool1 = bool2;
    try
    {
      if (!e(paramx))
      {
        bool1 = bool2;
        if (!f(paramx)) {
          bool1 = false;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  final boolean e(x paramx)
  {
    y localy = this.a;
    return (localy != null) && (localy.a(paramx));
  }
  
  final boolean f(x paramx)
  {
    y localy = this.d;
    return (localy != null) && (localy.a(paramx));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */