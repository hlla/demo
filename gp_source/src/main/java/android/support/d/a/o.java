package android.support.d.a;

import android.graphics.Matrix;
import android.support.v4.g.a;
import android.support.v4.g.v;
import java.util.ArrayList;

final class o
  extends p
{
  public int a;
  public final ArrayList b = new ArrayList();
  public String c = null;
  public final Matrix d = new Matrix();
  public float e = 0.0F;
  public float f = 0.0F;
  public float g = 0.0F;
  public float h = 1.0F;
  public float i = 1.0F;
  public final Matrix j = new Matrix();
  public int[] k;
  public float l = 0.0F;
  public float m = 0.0F;
  
  public o()
  {
    super((byte)0);
  }
  
  public o(o paramo, a parama)
  {
    super((byte)0);
    this.g = paramo.g;
    this.e = paramo.e;
    this.f = paramo.f;
    this.h = paramo.h;
    this.i = paramo.i;
    this.l = paramo.l;
    this.m = paramo.m;
    this.k = paramo.k;
    this.c = paramo.c;
    this.a = paramo.a;
    Object localObject = this.c;
    if (localObject != null) {
      parama.put(localObject, this);
    }
    this.d.set(paramo.d);
    localObject = paramo.b;
    int n = 0;
    while (n < ((ArrayList)localObject).size())
    {
      paramo = ((ArrayList)localObject).get(n);
      if ((paramo instanceof o))
      {
        paramo = (o)paramo;
        this.b.add(new o(paramo, parama));
        n += 1;
      }
      else
      {
        if ((paramo instanceof n)) {}
        for (paramo = new n((n)paramo);; paramo = new m((m)paramo))
        {
          this.b.add(paramo);
          String str = paramo.p;
          if (str == null) {
            break;
          }
          parama.put(str, paramo);
          break;
          if (!(paramo instanceof m)) {
            break label320;
          }
        }
        label320:
        throw new IllegalStateException("Unknown object in the tree!");
      }
    }
  }
  
  final void a()
  {
    this.d.reset();
    this.d.postTranslate(-this.e, -this.f);
    this.d.postScale(this.h, this.i);
    this.d.postRotate(this.g, 0.0F, 0.0F);
    this.d.postTranslate(this.l + this.e, this.m + this.f);
  }
  
  public final boolean a(int[] paramArrayOfInt)
  {
    int n = 0;
    boolean bool = false;
    while (n < this.b.size())
    {
      bool |= ((p)this.b.get(n)).a(paramArrayOfInt);
      n += 1;
    }
    return (byte)bool;
  }
  
  public final boolean b()
  {
    boolean bool2 = false;
    int n = 0;
    for (;;)
    {
      bool1 = bool2;
      if (n >= this.b.size()) {
        return bool1;
      }
      if (((p)this.b.get(n)).b()) {
        break;
      }
      n += 1;
    }
    boolean bool1 = true;
    return bool1;
  }
  
  public final String getGroupName()
  {
    return this.c;
  }
  
  public final Matrix getLocalMatrix()
  {
    return this.d;
  }
  
  public final float getPivotX()
  {
    return this.e;
  }
  
  public final float getPivotY()
  {
    return this.f;
  }
  
  public final float getRotation()
  {
    return this.g;
  }
  
  public final float getScaleX()
  {
    return this.h;
  }
  
  public final float getScaleY()
  {
    return this.i;
  }
  
  public final float getTranslateX()
  {
    return this.l;
  }
  
  public final float getTranslateY()
  {
    return this.m;
  }
  
  public final void setPivotX(float paramFloat)
  {
    if (paramFloat != this.e)
    {
      this.e = paramFloat;
      a();
    }
  }
  
  public final void setPivotY(float paramFloat)
  {
    if (paramFloat != this.f)
    {
      this.f = paramFloat;
      a();
    }
  }
  
  public final void setRotation(float paramFloat)
  {
    if (paramFloat != this.g)
    {
      this.g = paramFloat;
      a();
    }
  }
  
  public final void setScaleX(float paramFloat)
  {
    if (paramFloat != this.h)
    {
      this.h = paramFloat;
      a();
    }
  }
  
  public final void setScaleY(float paramFloat)
  {
    if (paramFloat != this.i)
    {
      this.i = paramFloat;
      a();
    }
  }
  
  public final void setTranslateX(float paramFloat)
  {
    if (paramFloat != this.l)
    {
      this.l = paramFloat;
      a();
    }
  }
  
  public final void setTranslateY(float paramFloat)
  {
    if (paramFloat != this.m)
    {
      this.m = paramFloat;
      a();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */