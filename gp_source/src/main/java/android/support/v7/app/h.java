package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

final class h
  implements f
{
  private final Activity a;
  private j b;
  
  h(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public final Drawable a()
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      TypedArray localTypedArray = b().obtainStyledAttributes(null, new int[] { 16843531 }, 16843470, 0);
      Drawable localDrawable = localTypedArray.getDrawable(0);
      localTypedArray.recycle();
      return localDrawable;
    }
    return i.a(this.a);
  }
  
  public final void a(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      ActionBar localActionBar = this.a.getActionBar();
      if (localActionBar != null) {
        localActionBar.setHomeActionContentDescription(paramInt);
      }
      return;
    }
    this.b = i.a(this.b, this.a, paramInt);
  }
  
  public final void a(Drawable paramDrawable, int paramInt)
  {
    ActionBar localActionBar = this.a.getActionBar();
    if (localActionBar != null)
    {
      if (Build.VERSION.SDK_INT >= 18)
      {
        localActionBar.setHomeAsUpIndicator(paramDrawable);
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
    else {
      return;
    }
    localActionBar.setDisplayShowHomeEnabled(true);
    this.b = i.a(this.a, paramDrawable, paramInt);
    localActionBar.setDisplayShowHomeEnabled(false);
  }
  
  public final Context b()
  {
    ActionBar localActionBar = this.a.getActionBar();
    if (localActionBar != null) {
      return localActionBar.getThemedContext();
    }
    return this.a;
  }
  
  public final boolean c()
  {
    ActionBar localActionBar = this.a.getActionBar();
    return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */