package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.app.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class am
  extends ContextWrapper
{
  private static final ArrayList<WeakReference<am>> aeB = new ArrayList();
  private Resources Cu;
  private final Resources.Theme OD;
  
  private am(Context paramContext)
  {
    super(paramContext);
    if (ar.hd())
    {
      this.OD = getResources().newTheme();
      this.OD.setTo(paramContext.getTheme());
      return;
    }
    this.OD = null;
  }
  
  public static Context p(Context paramContext)
  {
    int i;
    Object localObject;
    int j;
    if (((paramContext instanceof am)) || ((paramContext.getResources() instanceof ao)) || ((paramContext.getResources() instanceof ar)))
    {
      i = 0;
      localObject = paramContext;
      if (i != 0)
      {
        j = aeB.size();
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= j) {
        break label122;
      }
      localObject = (WeakReference)aeB.get(i);
      if (localObject != null) {}
      for (localObject = (am)((WeakReference)localObject).get();; localObject = null)
      {
        if ((localObject == null) || (((am)localObject).getBaseContext() != paramContext)) {
          break label115;
        }
        return (Context)localObject;
        if ((d.cT()) && (Build.VERSION.SDK_INT > 20))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      label115:
      i += 1;
    }
    label122:
    paramContext = new am(paramContext);
    aeB.add(new WeakReference(paramContext));
    return paramContext;
  }
  
  public final Resources getResources()
  {
    if (this.Cu == null) {
      if (this.OD != null) {
        break label37;
      }
    }
    label37:
    for (Object localObject = new ao(this, super.getResources());; localObject = new ar(this, super.getResources()))
    {
      this.Cu = ((Resources)localObject);
      return this.Cu;
    }
  }
  
  public final Resources.Theme getTheme()
  {
    if (this.OD == null) {
      return super.getTheme();
    }
    return this.OD;
  }
  
  public final void setTheme(int paramInt)
  {
    if (this.OD == null)
    {
      super.setTheme(paramInt);
      return;
    }
    this.OD.applyStyle(paramInt, true);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */