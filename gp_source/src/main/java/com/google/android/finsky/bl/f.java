package com.google.android.finsky.bl;

import android.content.Context;
import com.android.volley.r;
import com.google.android.finsky.api.i;
import com.google.android.play.image.x;

public final class f
  extends com.google.android.libraries.play.entertainment.a
{
  private final b.a b;
  private final b.a c;
  private final b.a d;
  private final b.a e;
  
  public f(Context paramContext, b.a parama1, b.a parama2, b.a parama3, b.a parama4)
  {
    super(paramContext);
    this.b = parama1;
    this.c = parama2;
    this.e = parama3;
    this.d = parama4;
  }
  
  protected final com.google.android.libraries.play.entertainment.c.a a()
  {
    return new com.google.android.libraries.play.entertainment.b.b();
  }
  
  protected final com.google.android.libraries.play.entertainment.a.a b()
  {
    return new com.google.android.libraries.play.entertainment.b.a();
  }
  
  protected final com.google.android.libraries.play.entertainment.bitmap.a c()
  {
    ((x)com.google.android.libraries.play.entertainment.e.b.a((x)this.b.a())).a();
    return new b();
  }
  
  protected final com.google.android.libraries.play.entertainment.d.a d()
  {
    new a(f(), (r)com.google.android.libraries.play.entertainment.e.b.a((r)this.c.a()));
    com.google.android.libraries.play.entertainment.d.b localb = f();
    com.google.android.libraries.play.entertainment.e.b.a((r)this.e.a());
    com.google.android.libraries.play.entertainment.e.b.a((i)this.d.a());
    new e(localb);
    return new c(f());
  }
  
  protected final com.google.android.libraries.play.entertainment.d.b e()
  {
    return new d();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bl/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */