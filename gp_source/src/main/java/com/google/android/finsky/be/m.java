package com.google.android.finsky.be;

import com.google.wireless.android.finsky.dfe.e.a.cl;

final class m
  implements Runnable
{
  m(l paraml) {}
  
  public final void run()
  {
    l locall = this.a;
    cl localcl = locall.b;
    locall.b = null;
    if (localcl != null) {
      locall.a.a(localcl.a);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */