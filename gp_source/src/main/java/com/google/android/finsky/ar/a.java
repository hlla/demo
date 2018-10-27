package com.google.android.finsky.ar;

import android.content.res.Resources;
import com.google.android.finsky.ds.a.by;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static final TimeZone a = TimeZone.getTimeZone("UTC");
  
  public static long a(by paramby)
  {
    Calendar localCalendar = Calendar.getInstance(a);
    return TimeUnit.MILLISECONDS.toSeconds(paramby.c - localCalendar.getTimeInMillis());
  }
  
  public static String a(Resources paramResources, long paramLong)
  {
    int i = (int)TimeUnit.SECONDS.toDays(paramLong);
    int j = (int)TimeUnit.SECONDS.toHours(paramLong);
    if (i >= 2) {
      return paramResources.getString(2131953242, new Object[] { Integer.valueOf(i) });
    }
    if (j >= 24) {
      return paramResources.getString(2131953244);
    }
    if (j >= 2) {
      return paramResources.getString(2131953241, new Object[] { Integer.valueOf(j) });
    }
    if (j <= 0) {
      return paramResources.getString(2131953243);
    }
    return paramResources.getString(2131953240);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ar/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */