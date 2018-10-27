package com.google.android.finsky.be;

import android.content.Context;
import com.android.volley.VolleyError;
import com.google.android.finsky.api.o;
import com.google.android.finsky.ds.a.jy;
import com.google.protobuf.nano.b;
import com.google.wireless.android.finsky.dfe.e.a.bx;
import com.google.wireless.android.finsky.dfe.e.a.cc;
import com.google.wireless.android.finsky.dfe.e.a.cd;
import com.google.wireless.android.finsky.dfe.e.a.cg;
import com.google.wireless.android.finsky.dfe.e.a.ch;
import com.google.wireless.android.finsky.dfe.e.a.co;
import com.google.wireless.android.finsky.dfe.e.a.dr;
import com.google.wireless.android.finsky.dfe.e.a.dw;
import com.google.wireless.android.finsky.dfe.e.a.dx;
import com.google.wireless.android.finsky.dfe.e.a.dy;
import com.google.wireless.android.finsky.dfe.e.a.dz;
import com.google.wireless.android.finsky.dfe.e.a.ed;
import com.google.wireless.android.finsky.dfe.e.a.ee;
import com.google.wireless.android.finsky.dfe.e.a.ef;
import com.google.wireless.android.finsky.dfe.e.a.en;
import com.google.wireless.android.finsky.dfe.e.a.fd;

public final class ab
  implements aa
{
  private final int a;
  private final Context b;
  private final jy c;
  private final int d;
  
  public ab(Context paramContext, jy paramjy)
  {
    this.b = paramContext;
    this.d = 770;
    this.a = 771;
    this.c = paramjy;
  }
  
  public final dy a(VolleyError paramVolleyError, boolean paramBoolean)
  {
    dy localdy = new dy();
    localdy.h = new dz().a(16.0F).b(16.0F).d();
    Object localObject1 = new fd();
    localdy.a(fd.d, localObject1);
    ((fd)localObject1).a = new ch[2];
    ((fd)localObject1).a[0] = new ch();
    Object localObject2 = new ed();
    ((ed)localObject2).b = new ee();
    ((ed)localObject2).b.a(this.b.getString(2131952215));
    ((ed)localObject2).b.g = new ef();
    ((ed)localObject2).b.g.a(20.0F).c(6).b(-14606047);
    localObject1.a[0].a((ed)localObject2);
    localObject1.a[0].y = new en();
    localObject1.a[0].y.d();
    ((fd)localObject1).a[1] = new ch();
    localObject2 = new ed();
    ((ed)localObject2).b = new ee();
    ((ed)localObject2).b.a(o.a(this.b, paramVolleyError));
    ((ed)localObject2).b.g = new ef();
    ((ed)localObject2).b.g.a(14.0F);
    localObject1.a[1].a((ed)localObject2);
    ((fd)localObject1).b = new co[1];
    ((fd)localObject1).b[0] = new co();
    paramVolleyError = new dw();
    paramVolleyError.b = new cc();
    paramVolleyError.b.a(this.b.getString(2131952812));
    paramVolleyError.b.e = new ef();
    paramVolleyError.b.e.b(-1);
    paramVolleyError.b.e.c(7);
    localObject2 = paramVolleyError.b;
    bx localbx = new bx();
    if (paramBoolean) {
      localbx.k = new dx();
    }
    for (;;)
    {
      localbx.i = new dr();
      localbx.i.a(this.a);
      ((cc)localObject2).c = localbx;
      paramVolleyError.b.b = new cd();
      localObject2 = paramVolleyError.b.b;
      ((cd)localObject2).b = 7;
      ((cd)localObject2).a |= 0x1;
      localObject1 = localObject1.b[0];
      ((co)localObject1).d = -1;
      ((co)localObject1).d = 1;
      ((co)localObject1).f = paramVolleyError;
      localdy.c = new dr();
      localdy.c.a(this.d);
      return localdy;
      localbx.c = new cg();
      localbx.c.f = this.c;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */