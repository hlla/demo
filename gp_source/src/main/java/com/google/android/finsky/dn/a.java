package com.google.android.finsky.dn;

import android.text.TextUtils;
import com.google.android.finsky.utils.FinskyLog;
import java.util.HashMap;
import java.util.Map;

public abstract class a
{
  public final Map a = new HashMap();
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      FinskyLog.e("Found empty / null Phenotype experiment feature name", new Object[0]);
    }
    if (TextUtils.isEmpty(paramString2)) {
      FinskyLog.e("Found empty / null Phenotype experiment flag name", new Object[0]);
    }
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 2 + String.valueOf(paramString2).length());
    localStringBuilder.append(paramString1);
    localStringBuilder.append("__");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public abstract void a();
  
  protected void a(a parama)
  {
    parama.a();
    this.a.putAll(parama.a);
  }
  
  public final void a(String paramString1, String paramString2, Object paramObject)
  {
    this.a.put(a(paramString1, paramString2), paramObject);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */