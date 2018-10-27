package com.google.android.finsky.bi;

import com.google.android.finsky.downloadservice.a.d;
import com.google.android.finsky.downloadservice.a.e;
import com.google.android.finsky.downloadservice.a.g;
import com.google.android.finsky.utils.FinskyLog;

public final class a
{
  public static int a(e parame)
  {
    g localg = parame.b;
    if (parame.a.d == 4) {}
    for (boolean bool = true;; bool = false) {
      return a(localg, bool);
    }
  }
  
  public static int a(g paramg, boolean paramBoolean)
  {
    switch (paramg.g)
    {
    default: 
      FinskyLog.e("Unexpected downloadStatus", new Object[0]);
      return 0;
    case 4: 
      switch (paramg.c)
      {
      default: 
        return 16;
      case 7: 
        return 492;
      case 6: 
        return 198;
      case 5: 
        return 495;
      }
      return paramg.e;
    case 5: 
    case 6: 
      return 490;
    case 1: 
      switch (paramg.f)
      {
      default: 
        FinskyLog.e("Unexpected queueing reason", new Object[0]);
        return 0;
      case 3: 
        return 194;
      case 2: 
        if (!paramBoolean) {
          return 196;
        }
        return 195;
      }
      return 190;
    case 3: 
      return 200;
    }
    return 192;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 200) && (paramInt < 300);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bi/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */