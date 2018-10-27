package com.google.android.finsky.da.a;

import com.google.android.finsky.ag.q;
import com.google.android.finsky.co.a;
import com.google.android.finsky.da.e;
import com.google.android.finsky.dt.b;
import com.google.android.finsky.e.d;
import com.google.android.finsky.e.i;
import com.google.android.finsky.e.u;
import com.google.wireless.android.a.b.a.a.ap;
import com.google.wireless.android.a.b.a.a.bg;

public final class m
  implements com.google.android.finsky.da.f
{
  public i a;
  public e b;
  private final com.google.android.finsky.bo.c c;
  private final a d;
  
  public m(a parama, com.google.android.finsky.bo.c paramc)
  {
    ((k)b.a(k.class)).a(this);
    this.c = paramc;
    this.d = parama;
  }
  
  public final void a(int paramInt)
  {
    if ((this.d.a(paramInt)) && ((!this.c.cY().a(12655438L)) || (paramInt != ((Integer)com.google.android.finsky.ag.c.aK.a()).intValue())))
    {
      Object localObject = new ap().d().a(paramInt);
      localObject = new d(2501).a((ap)localObject).a;
      this.a.cV().a((bg)localObject);
      com.google.android.finsky.ag.c.aK.a(Integer.valueOf(paramInt));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/da/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */