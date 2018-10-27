package android.support.v4.app;

import android.a.b.j;
import android.a.b.n;
import android.a.b.o;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.g.v;
import android.support.v4.view.m;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.google.d.a.a.a.a.a.d;
import com.google.d.a.a.a.a.a.g;

public class cq
  extends Activity
  implements n, m
{
  private o a;
  
  public cq()
  {
    new v();
    this.a = new o(this);
  }
  
  public final j P_()
  {
    return this.a;
  }
  
  public final boolean a(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public Context createConfigurationContext(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new g(super.createConfigurationContext(paramConfiguration));
    }
    return null;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView == null) || (!android.support.v4.view.ac.a(localView, paramKeyEvent))) {
      return android.support.v4.view.l.a(this, localView, this, paramKeyEvent);
    }
    return true;
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView == null) || (!android.support.v4.view.ac.a(localView, paramKeyEvent))) {
      return super.dispatchKeyShortcutEvent(paramKeyEvent);
    }
    return true;
  }
  
  public AssetManager getAssets()
  {
    return d.c(this);
  }
  
  public Resources getResources()
  {
    return d.b(this);
  }
  
  public Resources.Theme getTheme()
  {
    return d.d(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getFragmentManager();
    if (paramBundle.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramBundle.beginTransaction().add(new android.a.b.ac(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramBundle.executePendingTransactions();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    this.a.a(android.a.b.l.a);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    d.a(this, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */