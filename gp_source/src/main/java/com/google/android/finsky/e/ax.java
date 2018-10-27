package com.google.android.finsky.e;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.m;
import com.google.android.finsky.api.DfeServerError;
import com.google.android.volley.DisplayMessageError;

public final class ax
{
  public static int a(String paramString)
  {
    int i;
    if (!TextUtils.isEmpty(paramString)) {
      switch (paramString.hashCode())
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return 0;
      case 27: 
        return 29;
      case 26: 
        return 28;
      case 25: 
        return 27;
      case 24: 
        return 26;
      case 23: 
        return 25;
      case 22: 
        return 24;
      case 21: 
        return 23;
      case 20: 
        return 22;
      case 19: 
        return 20;
      case 18: 
        return 19;
      case 17: 
        return 18;
      case 16: 
        return 17;
      case 15: 
        return 16;
      case 14: 
        return 15;
      case 13: 
        return 14;
      case 12: 
        return 13;
      case 11: 
        return 12;
      case 10: 
        return 11;
      case 9: 
        return 10;
      case 8: 
        return 9;
      case 7: 
        return 8;
      case 6: 
        return 7;
      case 5: 
        return 6;
      case 4: 
        return 5;
      case 3: 
        return 4;
      case 2: 
        return 3;
      case 1: 
        return 2;
      }
      return 1;
      if (!paramString.equals("su_daily_hygiene")) {
        break;
      }
      i = 18;
      continue;
      if (!paramString.equals("self_update_v2")) {
        break;
      }
      i = 14;
      continue;
      if (!paramString.equals("early_update")) {
        break;
      }
      i = 6;
      continue;
      if (!paramString.equals("suicidal_tabsky")) {
        break;
      }
      i = 8;
      continue;
      if (!paramString.equals("webapk_install")) {
        break;
      }
      i = 24;
      continue;
      if (!paramString.equals("maintenance_window")) {
        break;
      }
      i = 26;
      continue;
      if (!paramString.equals("restore")) {
        break;
      }
      i = 9;
      continue;
      if (!paramString.equals("su_notification")) {
        break;
      }
      i = 19;
      continue;
      if (!paramString.equals("device_owner_install")) {
        break;
      }
      i = 25;
      continue;
      if (!paramString.equals("daily_hygiene")) {
        break;
      }
      i = 11;
      continue;
      if (!paramString.equals("isotope_install")) {
        break;
      }
      i = 22;
      continue;
      if (!paramString.equals("rapid_auto_update")) {
        break;
      }
      i = 5;
      continue;
      if (!paramString.equals("restore_vpa")) {
        break;
      }
      i = 10;
      continue;
      if (!paramString.equals("single_install")) {
        break;
      }
      i = 0;
      continue;
      if (!paramString.equals("bulk_update")) {
        break;
      }
      i = 3;
      continue;
      if (!paramString.equals("bulk_install")) {
        break;
      }
      i = 1;
      continue;
      if (!paramString.equals("dependency")) {
        break;
      }
      i = 2;
      continue;
      if (!paramString.equals("gms_core_update_service")) {
        break;
      }
      i = 21;
      continue;
      if (!paramString.equals("content_dependency")) {
        break;
      }
      i = 17;
      continue;
      if (!paramString.equals("tickle")) {
        break;
      }
      i = 7;
      continue;
      if (!paramString.equals("auto_update")) {
        break;
      }
      i = 4;
      continue;
      if (!paramString.equals("wear_auto_update")) {
        break;
      }
      i = 15;
      continue;
      if (!paramString.equals("self_update")) {
        break;
      }
      i = 13;
      continue;
      if (!paramString.equals("package_update_service")) {
        break;
      }
      i = 20;
      continue;
      if (!paramString.equals("wear_auto_install")) {
        break;
      }
      i = 16;
      continue;
      if (!paramString.equals("SplitInstallService")) {
        break;
      }
      i = 27;
      continue;
      if (!paramString.equals("arc_install")) {
        break;
      }
      i = 23;
      continue;
      if (!paramString.equals("wifi_checker")) {
        break;
      }
      i = 12;
    }
  }
  
  public static void a(d paramd, VolleyError paramVolleyError, boolean paramBoolean)
  {
    m localm = paramVolleyError.b;
    int i;
    if (localm != null)
    {
      i = localm.f;
      if (i != 0)
      {
        paramd.a(1409, i);
        if (paramBoolean) {
          paramd.a(paramVolleyError.b.f);
        }
        return;
      }
    }
    if (!(paramVolleyError instanceof AuthFailureError)) {
      if ((paramVolleyError instanceof DisplayMessageError)) {
        if ((paramVolleyError instanceof DfeServerError)) {
          i = 1402;
        }
      }
    }
    for (;;)
    {
      paramd.g(i);
      if (!paramBoolean) {
        break;
      }
      paramd.a(i);
      return;
      i = 1401;
      continue;
      if ((paramVolleyError instanceof NetworkError))
      {
        if ((paramVolleyError instanceof NoConnectionError)) {
          i = 1404;
        } else {
          i = 1403;
        }
      }
      else if (!(paramVolleyError instanceof ParseError))
      {
        if (!(paramVolleyError instanceof ServerError))
        {
          if ((paramVolleyError instanceof TimeoutError)) {
            i = 1407;
          } else {
            i = 1408;
          }
        }
        else {
          i = 1406;
        }
      }
      else
      {
        i = 1405;
        continue;
        i = 1400;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */