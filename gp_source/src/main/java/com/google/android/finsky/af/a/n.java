package com.google.android.finsky.af.a;

import com.google.android.finsky.af.a;
import com.google.android.finsky.af.e;
import java.util.concurrent.Executor;

final class n
  extends j
{
  public e a;
  public e b;
  
  n(e parame, a parama, Executor paramExecutor)
  {
    super(new q(), paramExecutor);
    this.a = parame;
    parame.a(new r(this, parama));
  }
  
  n(e parame, com.google.common.base.n paramn, Executor paramExecutor)
  {
    super(new o(), paramExecutor);
    this.a = parame;
    parame.a(new p(this, paramn));
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    boolean bool = super.cancel(paramBoolean);
    if (bool)
    {
      e locale = this.b;
      if (locale != null)
      {
        locale.cancel(paramBoolean);
        this.b = null;
      }
      locale = this.a;
      if (locale != null)
      {
        locale.cancel(paramBoolean);
        this.a = null;
      }
    }
    return bool;
  }
  
  public final void run() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/af/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */