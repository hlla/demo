package android.support.v7.widget;

import android.graphics.Typeface;
import android.support.v4.content.a.l;
import android.widget.TextView;
import java.lang.ref.WeakReference;

final class ba
  extends l
{
  ba(az paramaz, WeakReference paramWeakReference) {}
  
  public final void a() {}
  
  public final void a(Typeface paramTypeface)
  {
    az localaz = this.a;
    Object localObject = this.b;
    if (localaz.a)
    {
      localaz.c = paramTypeface;
      localObject = (TextView)((WeakReference)localObject).get();
      if (localObject != null) {
        ((TextView)localObject).setTypeface(paramTypeface, localaz.d);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */