package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

final class he
  extends gc
{
  private final WeakReference a;
  
  public he(Context paramContext, Resources paramResources)
  {
    super(paramResources);
    this.a = new WeakReference(paramContext);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    Drawable localDrawable = super.getDrawable(paramInt);
    Context localContext = (Context)this.a.get();
    if ((localDrawable != null) && (localContext != null))
    {
      ae.a();
      ae.a(localContext, paramInt, localDrawable);
    }
    return localDrawable;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/he.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */