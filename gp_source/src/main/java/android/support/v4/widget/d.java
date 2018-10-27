package android.support.v4.widget;

import android.os.Build.VERSION;

public abstract interface d
{
  public static final boolean a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 27) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public abstract void setAutoSizeTextTypeWithDefaults(int paramInt);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */