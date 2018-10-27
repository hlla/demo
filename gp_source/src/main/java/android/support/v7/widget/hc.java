package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class hc
  extends ContextWrapper
{
  private static final Object a = new Object();
  private static ArrayList d;
  private final Resources b;
  private final Resources.Theme c;
  
  private hc(Context paramContext)
  {
    super(paramContext);
    if (hv.a())
    {
      this.b = new hv(this, paramContext.getResources());
      this.c = this.b.newTheme();
      this.c.setTo(paramContext.getTheme());
      return;
    }
    this.b = new he(this, paramContext.getResources());
    this.c = null;
  }
  
  public static Context a(Context paramContext)
  {
    if ((!(paramContext instanceof hc)) && (!(paramContext.getResources() instanceof he)) && (!(paramContext.getResources() instanceof hv)) && ((Build.VERSION.SDK_INT < 21) || (hv.a()))) {}
    for (;;)
    {
      int i;
      Object localObject1;
      synchronized (a)
      {
        if (d != null)
        {
          i = d.size() - 1;
          if (i < 0)
          {
            i = d.size() - 1;
            break label198;
            paramContext = new hc(paramContext);
            d.add(new WeakReference(paramContext));
            return paramContext;
            localObject1 = (WeakReference)d.get(i);
            if (localObject1 == null) {
              break label218;
            }
            localObject1 = (hc)((WeakReference)localObject1).get();
            break label207;
            if (((hc)localObject1).getBaseContext() != paramContext) {
              break label211;
            }
            return (Context)localObject1;
          }
          else
          {
            localObject1 = (WeakReference)d.get(i);
            if (localObject1 == null)
            {
              d.remove(i);
              break label223;
            }
            if (((WeakReference)localObject1).get() == null) {
              continue;
            }
            break label223;
          }
        }
        else
        {
          d = new ArrayList();
        }
      }
      label198:
      if (i < 0)
      {
        continue;
        return paramContext;
      }
      else
      {
        for (;;)
        {
          label207:
          if (localObject1 != null) {
            break label221;
          }
          label211:
          i -= 1;
          break label198;
          break;
          label218:
          localObject1 = null;
        }
        label221:
        continue;
        label223:
        i -= 1;
      }
    }
  }
  
  public final AssetManager getAssets()
  {
    return this.b.getAssets();
  }
  
  public final Resources getResources()
  {
    return this.b;
  }
  
  public final Resources.Theme getTheme()
  {
    Resources.Theme localTheme2 = this.c;
    Resources.Theme localTheme1 = localTheme2;
    if (localTheme2 == null) {
      localTheme1 = super.getTheme();
    }
    return localTheme1;
  }
  
  public final void setTheme(int paramInt)
  {
    Resources.Theme localTheme = this.c;
    if (localTheme == null)
    {
      super.setTheme(paramInt);
      return;
    }
    localTheme.applyStyle(paramInt, true);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/hc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */