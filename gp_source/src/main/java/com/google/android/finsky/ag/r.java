package com.google.android.finsky.ag;

import android.accounts.Account;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class r
{
  public static final p a;
  public static final q b;
  public static final q c;
  public static final q d;
  public static final q e;
  public static final p f;
  public static final q g;
  public static final q h;
  public static final q i;
  public static final q j;
  public static final f k;
  private static final String[] l = new String[0];
  
  static
  {
    Object localObject = new f("vending_preferences");
    k = (f)localObject;
    d = ((f)localObject).a("cached_gl_extensions", null);
    f localf = k;
    localObject = Boolean.valueOf(false);
    e = localf.a("gl_driver_crashed", (Boolean)localObject);
    g = k.a("last_build_fingerprint", null);
    c = k.a("finsky_backed_up", (Boolean)localObject);
    j = k.a("finsky_restored_android_id", null);
    localf = k;
    Boolean localBoolean = Boolean.valueOf(true);
    h = localf.a("notify_updates", localBoolean);
    i = k.a("notify_updates_completion", localBoolean);
    f = k.b("IAB_VERSION_", Integer.valueOf(0));
    k.a("update_over_wifi_only", (Boolean)localObject);
    k.a("auto_update_default", (Boolean)localObject);
    b = k.a("auto_add_shortcuts", localBoolean);
    a = k.b("account_exists_", (Boolean)localObject);
  }
  
  public static boolean a(Account[] paramArrayOfAccount, String paramString)
  {
    boolean bool2 = false;
    int n = paramArrayOfAccount.length;
    int m = 0;
    for (;;)
    {
      bool1 = bool2;
      if (m >= n) {
        break label40;
      }
      if (paramArrayOfAccount[m].name.equals(paramString)) {
        break;
      }
      m += 1;
    }
    boolean bool1 = true;
    label40:
    return bool1;
  }
  
  public static String[] a(Account[] paramArrayOfAccount)
  {
    int n = paramArrayOfAccount.length;
    Object localObject1 = null;
    int m = 0;
    if (m < n)
    {
      Account localAccount = paramArrayOfAccount[m];
      if (a.b(localAccount.name).b()) {}
      for (;;)
      {
        m += 1;
        break;
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(1);
        }
        ((List)localObject2).add(localAccount.name);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null) {
      return (String[])((List)localObject1).toArray(new String[((List)localObject1).size()]);
    }
    return l;
  }
  
  public static String[] b(Account[] paramArrayOfAccount)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = k.a().getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith("account_exists_"))
      {
        str = str.substring(15);
        if (!a(paramArrayOfAccount, str)) {
          localArrayList.add(str);
        }
      }
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ag/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */