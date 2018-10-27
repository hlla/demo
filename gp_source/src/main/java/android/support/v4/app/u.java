package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public class u
  extends s
{
  public final Activity a;
  public final Context b;
  public final z c = new z();
  public final Handler d;
  
  private u(Activity paramActivity, Context paramContext, Handler paramHandler)
  {
    this.a = paramActivity;
    this.b = ((Context)android.support.v4.g.u.a(paramContext, "context == null"));
    this.d = ((Handler)android.support.v4.g.u.a(paramHandler, "handler == null"));
  }
  
  u(o paramo)
  {
    this(paramo, paramo, paramo.b);
  }
  
  public View a(int paramInt)
  {
    return null;
  }
  
  public void a(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    if (paramInt != -1) {
      throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }
    this.b.startActivity(paramIntent);
  }
  
  public void a(Fragment paramFragment, String[] paramArrayOfString) {}
  
  public void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public boolean a()
  {
    return true;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public LayoutInflater c()
  {
    return LayoutInflater.from(this.b);
  }
  
  public void d() {}
  
  public boolean e()
  {
    return true;
  }
  
  public int f()
  {
    return 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */