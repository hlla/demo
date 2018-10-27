package com.google.android.finsky.b;

import android.os.Bundle;
import com.google.android.finsky.b.a.h;
import com.google.android.finsky.b.a.j;
import com.google.android.finsky.ds.a.ka;
import com.google.android.finsky.recyclerview.k;
import java.util.ArrayList;
import java.util.List;

public final class s
  extends k
  implements j
{
  public ka c;
  public List d = new ArrayList();
  public t e;
  public final u f;
  public Bundle g;
  
  public s(u paramu)
  {
    this.f = paramu;
  }
  
  public final h a(int paramInt)
  {
    return (h)this.d.get(paramInt);
  }
  
  public final void a(h paramh)
  {
    f(this.d.indexOf(paramh));
  }
  
  public final int c()
  {
    return this.d.size();
  }
  
  public final int c(int paramInt)
  {
    return ((h)this.d.get(paramInt)).i();
  }
  
  public final void f(int paramInt)
  {
    if (this.f != null)
    {
      ((h)this.d.get(paramInt)).f();
      if (paramInt >= this.d.size() - 1) {
        break label53;
      }
      this.f.a(paramInt + 1);
    }
    label53:
    t localt;
    do
    {
      return;
      localt = this.e;
    } while (localt == null);
    localt.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */