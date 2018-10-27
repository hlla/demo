package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.l;
import android.support.v4.view.m;
import android.support.v7.view.b;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public class at
  extends Dialog
  implements y
{
  private z a;
  private final m b = new au(this);
  
  public at(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public at(Context paramContext, int paramInt)
  {
    super(paramContext, i);
    a().a(null);
    a().l();
  }
  
  public final void K_() {}
  
  public final b L_()
  {
    return null;
  }
  
  public final z a()
  {
    if (this.a == null) {
      this.a = new aa(getContext(), getWindow(), this);
    }
    return this.a;
  }
  
  final boolean a(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a().b(paramView, paramLayoutParams);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    return l.a(this.b, localView, this, paramKeyEvent);
  }
  
  public View findViewById(int paramInt)
  {
    return a().a(paramInt);
  }
  
  public final void i() {}
  
  public void invalidateOptionsMenu()
  {
    a().h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    a().k();
    super.onCreate(paramBundle);
    a().a(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
    a().f();
  }
  
  public void setContentView(int paramInt)
  {
    a().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    a().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a().a(paramView, paramLayoutParams);
  }
  
  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
    a().a(getContext().getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    a().a(paramCharSequence);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */