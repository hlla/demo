package android.support.v7.preference;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.eu;

public final class v
  implements Runnable
{
  public v(s params, String paramString) {}
  
  public final void run()
  {
    eu localeu = this.a.a.getAdapter();
    if ((localeu instanceof ac))
    {
      i = ((ac)localeu).a(this.b);
      if (i == -1) {
        localeu.a(new aa(localeu, this.a.a, null, this.b));
      }
    }
    while (localeu == null)
    {
      int i;
      return;
      this.a.a.d(i);
      return;
    }
    throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */