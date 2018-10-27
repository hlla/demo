package com.google.android.finsky.av;

import com.google.android.finsky.ds.a.fa;
import java.util.ArrayList;
import java.util.Collection;

public final class i
{
  public String a;
  public final Collection b = new ArrayList();
  
  public final h a()
  {
    return new h(this);
  }
  
  public final i a(String paramString, fa paramfa)
  {
    if ((paramfa != null) && (paramfa.d != null)) {
      this.b.add(new j(paramString, paramfa));
    }
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/av/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */