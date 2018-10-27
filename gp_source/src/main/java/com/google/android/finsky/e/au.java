package com.google.android.finsky.e;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public final class au
  implements ah
{
  public af a;
  public final a b;
  public boolean c;
  public af d;
  private final List e = new ArrayList();
  
  public au(af paramaf, a parama)
  {
    this.b = parama;
    this.d = paramaf.a();
    this.a = paramaf;
  }
  
  private static void b(Bundle paramBundle, String paramString, af paramaf)
  {
    Bundle localBundle = new Bundle();
    paramaf.a(localBundle);
    paramBundle.putBundle(paramString, localBundle);
  }
  
  public final af a(Bundle paramBundle, String paramString, af paramaf)
  {
    paramBundle = paramBundle.getBundle(paramString);
    if (paramBundle != null) {
      paramaf = this.b.a(paramBundle);
    }
    return paramaf;
  }
  
  public final void a()
  {
    this.a = this.d.a();
    this.c = true;
    b(this.a);
  }
  
  public final void a(Bundle paramBundle)
  {
    this.d = a(paramBundle, "RestorableLoggingContextManager.KEY_SAVED_LOGGING_CONTEXT", this.d);
    this.a = a(paramBundle, "RestorableLoggingContextManager.KEY_ACTIVE_LOGGING_CONTEXT", this.a);
    b(this.a);
  }
  
  public final void a(af paramaf)
  {
    this.a = paramaf;
    b(this.a);
  }
  
  public final void a(ah paramah)
  {
    if (!this.e.contains(paramah)) {
      this.e.add(paramah);
    }
  }
  
  public final void b(Bundle paramBundle)
  {
    b(paramBundle, "RestorableLoggingContextManager.KEY_SAVED_LOGGING_CONTEXT", this.d);
    b(paramBundle, "RestorableLoggingContextManager.KEY_ACTIVE_LOGGING_CONTEXT", this.a);
  }
  
  public final void b(af paramaf)
  {
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      ((ah)this.e.get(i)).a(paramaf);
      i -= 1;
    }
  }
  
  public final void b(ah paramah)
  {
    this.e.remove(paramah);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */