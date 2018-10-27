package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.c.b.y;
import com.airbnb.lottie.c.b.z;
import java.util.ArrayList;
import java.util.List;

public final class t
  implements c, b
{
  public final com.airbnb.lottie.a.b.a a;
  public final com.airbnb.lottie.a.b.a b;
  public final com.airbnb.lottie.a.b.a c;
  public final z d;
  private final List e = new ArrayList();
  private String f;
  
  public t(com.airbnb.lottie.c.c.a parama, y paramy)
  {
    this.f = paramy.b;
    this.d = paramy.e;
    this.c = paramy.d.a();
    this.a = paramy.a.a();
    this.b = paramy.c.a();
    parama.a(this.c);
    parama.a(this.a);
    parama.a(this.b);
    this.c.a(this);
    this.a.a(this);
    this.b.a(this);
  }
  
  public final void a()
  {
    int i = 0;
    while (i < this.e.size())
    {
      ((b)this.e.get(i)).a();
      i += 1;
    }
  }
  
  final void a(b paramb)
  {
    this.e.add(paramb);
  }
  
  public final void a(List paramList1, List paramList2) {}
  
  public final String b()
  {
    return this.f;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */