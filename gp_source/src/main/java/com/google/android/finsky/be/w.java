package com.google.android.finsky.be;

import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public final class w
{
  public x a;
  public final Bundle b = new Bundle();
  public Set c = new HashSet();
  
  public w(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("DialogUserInputModel"))) {
      this.b.putAll(paramBundle.getBundle("DialogUserInputModel"));
    }
  }
  
  public final void a()
  {
    x localx = this.a;
    if (localx != null) {
      localx.b();
    }
  }
  
  public final void a(String paramString)
  {
    this.b.remove(paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.b.putString(paramString1, paramString2);
  }
  
  public final String b(String paramString)
  {
    return this.b.getString(paramString);
  }
  
  public final boolean c(String paramString)
  {
    return this.b.containsKey(paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */