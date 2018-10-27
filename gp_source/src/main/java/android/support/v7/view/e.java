package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import com.google.d.a.a.a.a.a.d;
import com.google.d.a.a.a.a.a.g;

public final class e
  extends ContextWrapper
{
  public int a;
  private LayoutInflater b;
  private Resources.Theme c;
  
  public e()
  {
    super(null);
  }
  
  public e(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramInt;
  }
  
  public e(Context paramContext, Resources.Theme paramTheme)
  {
    super(paramContext);
    this.c = paramTheme;
  }
  
  private final void a()
  {
    if (this.c == null)
    {
      this.c = getResources().newTheme();
      Resources.Theme localTheme = getBaseContext().getTheme();
      if (localTheme != null) {
        this.c.setTo(localTheme);
      }
    }
    this.c.applyStyle(this.a, true);
  }
  
  public final Context createConfigurationContext(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new g(super.createConfigurationContext(paramConfiguration));
    }
    return null;
  }
  
  public final AssetManager getAssets()
  {
    return getResources().getAssets();
  }
  
  public final Resources getResources()
  {
    return d.b(this);
  }
  
  public final Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.b == null) {
        this.b = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      return this.b;
    }
    return getBaseContext().getSystemService(paramString);
  }
  
  public final Resources.Theme getTheme()
  {
    Resources.Theme localTheme2 = this.c;
    Resources.Theme localTheme1 = localTheme2;
    if (localTheme2 == null)
    {
      if (this.a == 0) {
        this.a = 2132018171;
      }
      a();
      localTheme1 = this.c;
    }
    return localTheme1;
  }
  
  public final void setTheme(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      a();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */