package com.google.android.finsky.ax.a.a;

import com.google.android.finsky.detailspage.aj;

public final class b
  implements s
{
  public aj a;
  public com.google.android.finsky.ax.a.b.a b;
  public com.google.android.finsky.ax.a.b.b c;
  
  public final r a()
  {
    if (this.b == null) {
      throw new IllegalStateException(String.valueOf(com.google.android.finsky.ax.a.b.a.class.getCanonicalName()).concat(" must be set"));
    }
    if (this.c == null) {
      throw new IllegalStateException(String.valueOf(com.google.android.finsky.ax.a.b.b.class.getCanonicalName()).concat(" must be set"));
    }
    if (this.a == null) {
      throw new IllegalStateException(String.valueOf(aj.class.getCanonicalName()).concat(" must be set"));
    }
    return new a(this);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ax/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */