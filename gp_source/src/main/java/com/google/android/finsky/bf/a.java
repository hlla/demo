package com.google.android.finsky.bf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import java.io.File;

public abstract class a
  extends f
{
  private final com.google.android.finsky.l.a a;
  private final Context k;
  
  public a(Context paramContext, com.google.android.finsky.l.a parama, String paramString1, String paramString2, com.google.wireless.android.finsky.b.a parama1)
  {
    super(paramString1, paramString2, parama1.e, parama1.j, parama1.k, parama1.f, g.a(parama1), parama1.o, parama1.n);
    this.a = parama;
    this.k = paramContext;
  }
  
  public final String a(String paramString)
  {
    return paramString;
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final File b()
  {
    Object localObject2 = null;
    Object localObject1 = this.k.getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getApplicationInfo(this.h, 0);
      String str1 = ((ApplicationInfo)localObject1).sourceDir;
      String str2 = ((ApplicationInfo)localObject1).publicSourceDir;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str1))
      {
        localObject1 = localObject2;
        if (str1.equals(str2)) {
          localObject1 = new File(str1);
        }
      }
      return (File)localObject1;
    }
    catch (NameNotFoundException localNameNotFoundException) {}
    return null;
  }
  
  public final int c()
  {
    return this.a.a.g(this.h);
  }
  
  public final boolean d()
  {
    return false;
  }
  
  public final boolean e()
  {
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bf/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */