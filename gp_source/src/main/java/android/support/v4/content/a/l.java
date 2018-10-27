package android.support.v4.content.a;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

public abstract class l
{
  public abstract void a();
  
  public final void a(int paramInt, Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    localHandler.post(new n(this));
  }
  
  public abstract void a(Typeface paramTypeface);
  
  public final void a(Typeface paramTypeface, Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    localHandler.post(new m(this, paramTypeface));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */