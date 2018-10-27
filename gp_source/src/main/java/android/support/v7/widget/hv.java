package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;

public final class hv
  extends Resources
{
  public static boolean a = false;
  private final WeakReference b;
  
  public hv(Context paramContext, Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.b = new WeakReference(paramContext);
  }
  
  public static boolean a()
  {
    return (a) && (Build.VERSION.SDK_INT <= 20);
  }
  
  final Drawable a(int paramInt)
  {
    return super.getDrawable(paramInt);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    Context localContext = (Context)this.b.get();
    if (localContext != null) {
      return ae.a().a(localContext, this, paramInt);
    }
    return super.getDrawable(paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */