package com.google.android.finsky.ae;

import com.google.android.finsky.dfemodel.DfeToc;
import com.google.android.finsky.ratereview.s;
import com.google.wireless.android.finsky.dfe.nano.gn;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public final class a
{
  public Boolean a;
  public boolean b;
  public final s c;
  private final Set d = new HashSet();
  private final com.google.android.finsky.ev.a e;
  
  public a(s params, com.google.android.finsky.ev.a parama)
  {
    this.c = params;
    this.e = parama;
  }
  
  public final boolean a()
  {
    if (this.a == null) {
      this.a = Boolean.valueOf(this.e.a.b.a);
    }
    return this.a.booleanValue();
  }
  
  public final boolean a(String paramString)
  {
    return this.d.contains(paramString);
  }
  
  public final void b(String paramString)
  {
    this.d.add(paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ae/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */