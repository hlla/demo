package com.google.android.finsky.bf;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.finsky.utils.FinskyLog;
import com.google.wireless.android.finsky.b.ah;
import java.io.File;

public abstract class b
  extends f
{
  public final String a;
  private final com.google.android.finsky.l.a k;
  private final Context l;
  
  public b(Context paramContext, String paramString1, com.google.android.finsky.l.a parama, String paramString2, ah paramah)
  {
    super(paramString1, paramString2, paramah.c, paramah.g, paramah.h, paramah.d, paramah.b, paramah.k, paramah.j);
    this.l = paramContext;
    this.k = parama;
    this.a = paramah.i;
  }
  
  @TargetApi(21)
  private final File l()
  {
    int i = 0;
    Object localObject1 = this.l.getPackageManager();
    try
    {
      Object localObject2 = ((PackageManager)localObject1).getPackageInfo(this.h, 0);
      localObject1 = ((PackageInfo)localObject2).applicationInfo;
      if ((((PackageInfo)localObject2).splitNames != null) && (((ApplicationInfo)localObject1).splitSourceDirs != null) && (((ApplicationInfo)localObject1).splitPublicSourceDirs != null))
      {
        if ((((PackageInfo)localObject2).splitNames.length == ((ApplicationInfo)localObject1).splitSourceDirs.length) && (((PackageInfo)localObject2).splitNames.length == ((ApplicationInfo)localObject1).splitPublicSourceDirs.length))
        {
          while (i < ((PackageInfo)localObject2).splitNames.length)
          {
            if (this.a.equals(localObject2.splitNames[i]))
            {
              localObject2 = localObject1.splitSourceDirs[i];
              localObject1 = localObject1.splitPublicSourceDirs[i];
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(localObject1))) {
                return new File((String)localObject2);
              }
              return null;
            }
            i += 1;
          }
          return null;
        }
        return null;
      }
      return null;
    }
    catch (NameNotFoundException localNameNotFoundException) {}
    return null;
  }
  
  public final String a(String paramString)
  {
    return paramString;
  }
  
  public final boolean a()
  {
    return com.google.android.finsky.utils.a.d();
  }
  
  public final File b()
  {
    if (!com.google.android.finsky.utils.a.d())
    {
      FinskyLog.e("getSourceFile called for %s (%s) is not supported on pre-L devices.", new Object[] { this.h, this.a });
      return null;
    }
    return l();
  }
  
  public final int c()
  {
    return this.k.a.g(this.h);
  }
  
  public final boolean e()
  {
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bf/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */