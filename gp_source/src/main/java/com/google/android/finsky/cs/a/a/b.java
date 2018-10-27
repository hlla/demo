package com.google.android.finsky.cs.a.a;

import com.google.android.finsky.activities.MainActivity;

public final class b
  implements bw
{
  public MainActivity a;
  public com.google.android.finsky.cs.a.b.a b;
  
  public final bv a()
  {
    if (this.b == null) {
      throw new IllegalStateException(String.valueOf(com.google.android.finsky.cs.a.b.a.class.getCanonicalName()).concat(" must be set"));
    }
    if (this.a == null) {
      throw new IllegalStateException(String.valueOf(MainActivity.class.getCanonicalName()).concat(" must be set"));
    }
    return new a(this);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cs/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */