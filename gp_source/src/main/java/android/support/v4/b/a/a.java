package android.support.v4.b.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;

public final class a
{
  public final Context a;
  
  private a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public static FingerprintManager b(Context paramContext)
  {
    if (paramContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
      return (FingerprintManager)paramContext.getSystemService(FingerprintManager.class);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */