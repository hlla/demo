package com.google.android.finsky.ao;

import com.google.android.finsky.volley.f;

public final class a
{
  public static boolean a(com.android.volley.a parama)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parama != null)
    {
      if (!(parama instanceof f)) {
        break label27;
      }
      bool1 = ((f)parama).b("cache_and_sync_marker_cache_key");
    }
    label27:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (parama.a("cache_and_sync_marker_cache_key") == null);
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ao/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */