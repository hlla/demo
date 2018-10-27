package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.os.Bundle;

public class e
{
  public final Object a;
  
  public e()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.a = new g(this);
      return;
    }
    this.a = new f(this);
  }
  
  public e(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public a a(int paramInt)
  {
    return null;
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  public a b(int paramInt)
  {
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */