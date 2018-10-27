package android.support.constraint.a.a;

import android.support.constraint.a.b;
import android.support.constraint.a.h;
import java.util.ArrayList;

public final class j
  extends f
{
  public int ac = 0;
  public int ad = -1;
  public int ae = -1;
  public float af = -1.0F;
  private a ag = this.M;
  
  public j()
  {
    new l();
    this.a.clear();
    this.a.add(this.ag);
  }
  
  public final a a(e parame)
  {
    switch (k.a[parame.ordinal()])
    {
    }
    do
    {
      do
      {
        return null;
      } while (this.ac != 1);
      return this.ag;
    } while (this.ac != 0);
    return this.ag;
  }
  
  public final void a(android.support.constraint.a.e parame)
  {
    Object localObject3 = (i)this.J;
    Object localObject2;
    Object localObject1;
    if (localObject3 != null)
    {
      localObject2 = ((f)localObject3).a(e.f);
      localObject1 = ((f)localObject3).a(e.g);
      if (this.ac != 0) {
        break label218;
      }
      localObject2 = ((f)localObject3).a(e.h);
      localObject1 = ((f)localObject3).a(e.b);
    }
    label218:
    for (;;)
    {
      if (this.ad != -1) {
        parame.a(android.support.constraint.a.e.a(parame, parame.a(this.ag), parame.a(localObject2), this.ad, false));
      }
      do
      {
        return;
        if (this.ae != -1)
        {
          parame.a(android.support.constraint.a.e.a(parame, parame.a(this.ag), parame.a(localObject1), -this.ae, false));
          return;
        }
      } while (this.af == -1.0F);
      localObject3 = parame.a(this.ag);
      localObject2 = parame.a(localObject2);
      localObject1 = parame.a(localObject1);
      float f = this.af;
      b localb = parame.b();
      localb.d.a((h)localObject3, -1.0F);
      localb.d.a((h)localObject2, 1.0F - f);
      localb.d.a((h)localObject1, f);
      parame.a(localb);
      return;
    }
  }
  
  public final void e(int paramInt)
  {
    if (this.ac != paramInt)
    {
      this.ac = paramInt;
      this.a.clear();
      if (this.ac != 1) {
        break label49;
      }
    }
    label49:
    for (this.ag = this.x;; this.ag = this.M)
    {
      this.a.add(this.ag);
      return;
    }
  }
  
  public final ArrayList l()
  {
    return this.a;
  }
  
  public final void n()
  {
    int i;
    if (this.J != null)
    {
      i = android.support.constraint.a.e.b(this.ag);
      if (this.ac == 1)
      {
        this.aa = i;
        this.ab = 0;
        b(this.J.f());
        a(0);
      }
    }
    else
    {
      return;
    }
    this.aa = 0;
    this.ab = i;
    a(this.J.c());
    b(0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */