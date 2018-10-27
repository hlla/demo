package android.support.v4.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.content.a.d;
import android.support.v4.content.a.l;
import android.support.v4.e.b;
import android.support.v4.e.r;
import android.util.Log;

public final class e
{
  public static final android.support.v4.g.i a;
  private static final j b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 28) {
      b = new i();
    }
    for (;;)
    {
      a = new android.support.v4.g.i(16);
      return;
      if (Build.VERSION.SDK_INT >= 26)
      {
        b = new h();
      }
      else
      {
        if (Build.VERSION.SDK_INT < 24) {}
        do
        {
          if (Build.VERSION.SDK_INT >= 21)
          {
            b = new f();
            break;
          }
          b = new j();
          break;
          if (g.a == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
          }
        } while (g.a == null);
        b = new g();
      }
    }
  }
  
  public static Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = b.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (paramContext != null)
    {
      paramResources = a(paramResources, paramInt1, paramInt2);
      a.a(paramResources, paramContext);
    }
    return paramContext;
  }
  
  public static Typeface a(Context paramContext, d paramd, Resources paramResources, int paramInt1, int paramInt2, l paraml, Handler paramHandler, boolean paramBoolean)
  {
    boolean bool = true;
    int i;
    if ((paramd instanceof android.support.v4.content.a.g))
    {
      paramd = (android.support.v4.content.a.g)paramd;
      if (paramBoolean) {
        if (paramd.b == 0) {
          if (paramBoolean)
          {
            i = paramd.c;
            label38:
            paramContext = b.a(paramContext, paramd.a, paraml, paramHandler, bool, i, paramInt2);
          }
        }
      }
    }
    for (;;)
    {
      if (paramContext != null) {
        a.a(a(paramResources, paramInt1, paramInt2), paramContext);
      }
      return paramContext;
      i = -1;
      break label38;
      bool = false;
      break;
      if (paraml == null) {
        break;
      }
      bool = false;
      break;
      paramd = b.a(paramContext, (android.support.v4.content.a.e)paramd, paramResources, paramInt2);
      paramContext = paramd;
      if (paraml != null) {
        if (paramd == null)
        {
          paraml.a(-3, paramHandler);
          paramContext = paramd;
        }
        else
        {
          paraml.a(paramd, paramHandler);
          paramContext = paramd;
        }
      }
    }
  }
  
  public static Typeface a(Context paramContext, r[] paramArrayOfr, int paramInt)
  {
    return b.a(paramContext, null, paramArrayOfr, paramInt);
  }
  
  public static String a(Resources paramResources, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramResources.getResourcePackageName(paramInt1));
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */