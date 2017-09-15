package com.tencent.b.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Locale;
import java.util.TimeZone;

final class b
{
  static a aPV;
  Integer aPW = null;
  String aPX = null;
  
  public b(Context paramContext)
  {
    try
    {
      Q(paramContext);
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null) {
        this.aPW = Integer.valueOf(localTelephonyManager.getNetworkType());
      }
      this.aPX = s.ab(paramContext);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static a Q(Context paramContext)
  {
    try
    {
      if (aPV == null) {
        aPV = new a(paramContext.getApplicationContext());
      }
      paramContext = aPV;
      return paramContext;
    }
    finally {}
  }
  
  static final class a
  {
    String aPY;
    String aPZ = "2.21";
    DisplayMetrics aQa;
    int aQb = Build.VERSION.SDK_INT;
    String aQc = Build.MANUFACTURER;
    String aQd = Locale.getDefault().getLanguage();
    String aQe = "WX";
    String aQf;
    String aQg;
    int aQh = 0;
    String aQi = null;
    String aQj = null;
    Context ctx = null;
    String imsi;
    String model = Build.MODEL;
    String packageName = null;
    String timezone;
    
    public a(Context paramContext)
    {
      this.ctx = paramContext.getApplicationContext();
      try
      {
        this.aPY = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
        this.aQa = new DisplayMetrics();
        ((WindowManager)this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.aQa);
        if (s.k(paramContext, "android.permission.READ_PHONE_STATE"))
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            this.aQf = paramContext.getSimOperator();
            this.imsi = paramContext.getSubscriberId();
          }
        }
        this.timezone = TimeZone.getDefault().getID();
        this.aQg = s.aa(this.ctx);
        this.packageName = this.ctx.getPackageName();
        this.aQj = s.nU();
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/b/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */