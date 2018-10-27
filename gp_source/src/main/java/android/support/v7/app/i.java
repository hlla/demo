package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.Method;

final class i
{
  private static final int[] a = { 16843531 };
  
  public static Drawable a(Activity paramActivity)
  {
    paramActivity = paramActivity.obtainStyledAttributes(a);
    Drawable localDrawable = paramActivity.getDrawable(0);
    paramActivity.recycle();
    return localDrawable;
  }
  
  public static j a(Activity paramActivity, Drawable paramDrawable, int paramInt)
  {
    j localj = new j(paramActivity);
    if (localj.b != null) {}
    try
    {
      paramActivity = paramActivity.getActionBar();
      localj.b.invoke(paramActivity, new Object[] { paramDrawable });
      localj.a.invoke(paramActivity, new Object[] { Integer.valueOf(paramInt) });
      return localj;
    }
    catch (Exception paramActivity)
    {
      Log.w("ActionBarDrawerToggleHC", "Couldn't set home-as-up indicator via JB-MR2 API", paramActivity);
    }
    paramActivity = localj.c;
    if (paramActivity == null)
    {
      Log.w("ActionBarDrawerToggleHC", "Couldn't set home-as-up indicator");
      return localj;
    }
    paramActivity.setImageDrawable(paramDrawable);
    return localj;
    return localj;
  }
  
  public static j a(j paramj, Activity paramActivity, int paramInt)
  {
    j localj = paramj;
    if (paramj == null) {
      localj = new j(paramActivity);
    }
    if (localj.b != null) {}
    try
    {
      paramj = paramActivity.getActionBar();
      localj.a.invoke(paramj, new Object[] { Integer.valueOf(paramInt) });
      if (Build.VERSION.SDK_INT <= 19) {
        paramj.setSubtitle(paramj.getSubtitle());
      }
      return localj;
    }
    catch (Exception paramj)
    {
      Log.w("ActionBarDrawerToggleHC", "Couldn't set content description via JB-MR2 API", paramj);
    }
    return localj;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */