package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;

public final class c
{
  private static final b nL = new b();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      nL = new a();
      return;
    }
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    return nL.a(paramContext, paramString1, paramString2);
  }
  
  public static String permissionToOp(String paramString)
  {
    return nL.permissionToOp(paramString);
  }
  
  private static final class a
    extends c.b
  {
    public final int a(Context paramContext, String paramString1, String paramString2)
    {
      return ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOp(paramString1, paramString2);
    }
    
    public final String permissionToOp(String paramString)
    {
      return AppOpsManager.permissionToOp(paramString);
    }
  }
  
  private static class b
  {
    public int a(Context paramContext, String paramString1, String paramString2)
    {
      return 1;
    }
    
    public String permissionToOp(String paramString)
    {
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */