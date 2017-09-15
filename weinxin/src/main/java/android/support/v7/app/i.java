package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class i
  extends Dialog
  implements c
{
  private d Gp;
  
  public i(Context paramContext, int paramInt)
  {
    super(paramContext, i);
    cO().onCreate(null);
    cO().cS();
  }
  
  private d cO()
  {
    if (this.Gp == null) {
      this.Gp = d.a(this, this);
    }
    return this.Gp;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    cO().addContentView(paramView, paramLayoutParams);
  }
  
  public final boolean cZ()
  {
    return cO().requestWindowFeature(1);
  }
  
  public View findViewById(int paramInt)
  {
    return cO().findViewById(paramInt);
  }
  
  public void invalidateOptionsMenu()
  {
    cO().invalidateOptionsMenu();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    cO().cR();
    super.onCreate(paramBundle);
    cO().onCreate(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
    cO().onStop();
  }
  
  public void setContentView(int paramInt)
  {
    cO().setContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    cO().setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    cO().setContentView(paramView, paramLayoutParams);
  }
  
  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
    cO().setTitle(getContext().getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    cO().setTitle(paramCharSequence);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/app/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */