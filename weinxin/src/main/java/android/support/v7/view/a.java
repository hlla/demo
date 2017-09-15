package android.support.v7.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.support.v7.a.a.b;

public final class a
{
  public Context mContext;
  
  private a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static a n(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public final boolean de()
  {
    if (this.mContext.getApplicationInfo().targetSdkVersion >= 16) {
      return this.mContext.getResources().getBoolean(a.b.IL);
    }
    return this.mContext.getResources().getBoolean(a.b.IM);
  }
  
  public final boolean df()
  {
    return this.mContext.getApplicationInfo().targetSdkVersion < 14;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */