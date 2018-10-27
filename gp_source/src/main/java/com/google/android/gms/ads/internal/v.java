package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.safebrowsing.SafeBrowsingConfigParcel;
import com.google.android.gms.ads.internal.safebrowsing.k;
import com.google.android.gms.ads.internal.util.n;
import java.util.Iterator;
import java.util.List;

@a
public final class v
{
  public boolean a;
  private AutoClickProtectionConfigurationParcel b;
  private final Context c;
  private k d;
  
  public v(Context paramContext, k paramk, AutoClickProtectionConfigurationParcel paramAutoClickProtectionConfigurationParcel)
  {
    this.c = paramContext;
    this.d = paramk;
    this.b = paramAutoClickProtectionConfigurationParcel;
    if (this.b == null) {
      this.b = new AutoClickProtectionConfigurationParcel();
    }
  }
  
  private final boolean b()
  {
    k localk = this.d;
    if (localk == null) {}
    for (;;)
    {
      if (this.b.a) {}
      do
      {
        return true;
        return false;
      } while (localk.a().b);
    }
  }
  
  public final void a(String paramString)
  {
    String str1;
    if (b())
    {
      str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
      paramString = this.d;
      if (paramString == null) {
        break label35;
      }
      paramString.a(str1, null, 3);
    }
    for (;;)
    {
      return;
      label35:
      paramString = this.b;
      if (paramString.a)
      {
        paramString = paramString.b;
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            String str2 = (String)paramString.next();
            if (!TextUtils.isEmpty(str2))
            {
              str2 = str2.replace("{NAVIGATION_URL}", Uri.encode(str1));
              n localn = bt.A.e;
              n.a(this.c, "", str2);
            }
          }
        }
      }
    }
  }
  
  public final boolean a()
  {
    return (!b()) || (this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */