package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.v7.a.a.j;
import android.view.LayoutInflater;

public final class d
  extends ContextWrapper
{
  private LayoutInflater Du;
  public int OC;
  private Resources.Theme OD;
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.OC = paramInt;
  }
  
  private void dg()
  {
    if (this.OD == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.OD = getResources().newTheme();
        Resources.Theme localTheme = getBaseContext().getTheme();
        if (localTheme != null) {
          this.OD.setTo(localTheme);
        }
      }
      this.OD.applyStyle(this.OC, true);
      return;
    }
  }
  
  public final Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.Du == null) {
        this.Du = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      return this.Du;
    }
    return getBaseContext().getSystemService(paramString);
  }
  
  public final Resources.Theme getTheme()
  {
    if (this.OD != null) {
      return this.OD;
    }
    if (this.OC == 0) {
      this.OC = a.j.KW;
    }
    dg();
    return this.OD;
  }
  
  public final void setTheme(int paramInt)
  {
    if (this.OC != paramInt)
    {
      this.OC = paramInt;
      dg();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */