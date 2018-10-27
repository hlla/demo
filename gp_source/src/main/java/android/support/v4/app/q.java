package android.support.v4.app;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.io.PrintWriter;

final class q
  extends u
{
  public q(o paramo)
  {
    super(paramo);
  }
  
  public final View a(int paramInt)
  {
    return this.e.findViewById(paramInt);
  }
  
  public final void a(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    localo = this.e;
    localo.d = true;
    if (paramInt == -1) {}
    try
    {
      a.a(localo, paramIntent, -1, null);
      return;
    }
    finally
    {
      localo.d = false;
    }
    o.b(paramInt);
    a.a(localo, paramIntent, (localo.a(paramFragment) + 1 << 16) + (char)paramInt, null);
    localo.d = false;
  }
  
  public final void a(Fragment paramFragment, String[] paramArrayOfString)
  {
    o localo = this.e;
    o.b(200);
    try
    {
      localo.c = true;
      a.a(localo, paramArrayOfString, (localo.a(paramFragment) + 1 << 16) + 200);
      return;
    }
    finally
    {
      localo.c = false;
    }
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.e.dump(paramString, null, paramPrintWriter, paramArrayOfString);
  }
  
  public final boolean a()
  {
    Window localWindow = this.e.getWindow();
    return (localWindow != null) && (localWindow.peekDecorView() != null);
  }
  
  public final boolean b()
  {
    return this.e.isFinishing() ^ true;
  }
  
  public final LayoutInflater c()
  {
    return this.e.getLayoutInflater().cloneInContext(this.e);
  }
  
  public final void d()
  {
    this.e.u_();
  }
  
  public final boolean e()
  {
    return this.e.getWindow() != null;
  }
  
  public final int f()
  {
    Window localWindow = this.e.getWindow();
    if (localWindow != null) {
      return localWindow.getAttributes().windowAnimations;
    }
    return 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */