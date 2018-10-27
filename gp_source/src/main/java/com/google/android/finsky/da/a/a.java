package com.google.android.finsky.da.a;

import android.os.Handler;
import android.os.Looper;
import com.google.android.finsky.da.e;
import com.google.android.finsky.da.f;
import java.util.HashSet;
import java.util.Set;

public final class a
  implements e, f
{
  public final e a;
  public final e b;
  private final Set c = new HashSet();
  private final Handler d = new Handler(Looper.getMainLooper());
  
  public a(e parame1, e parame2)
  {
    this.a = parame1;
    this.b = parame2;
  }
  
  public final int a()
  {
    return this.a.a() + this.b.a();
  }
  
  public final void a(int paramInt)
  {
    Object localObject = this.c;
    localObject = (f[])((Set)localObject).toArray(new f[((Set)localObject).size()]);
    this.d.post(new b(this, (f[])localObject));
  }
  
  public final void a(f paramf)
  {
    this.c.add(paramf);
  }
  
  public final void b(f paramf)
  {
    this.c.remove(paramf);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/da/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */