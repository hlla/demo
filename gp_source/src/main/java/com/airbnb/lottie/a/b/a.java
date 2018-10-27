package com.airbnb.lottie.a.b;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public abstract class a
{
  public boolean a = false;
  public final List b = new ArrayList();
  public float c = 0.0F;
  private com.airbnb.lottie.a.a d;
  private final List e;
  
  a(List paramList)
  {
    this.e = paramList;
  }
  
  private final com.airbnb.lottie.a.a b()
  {
    int i = 0;
    if (this.e.isEmpty()) {
      throw new IllegalStateException("There are no keyframes");
    }
    com.airbnb.lottie.a.a locala = this.d;
    if ((locala != null) && (locala.a(this.c))) {
      return this.d;
    }
    locala = (com.airbnb.lottie.a.a)this.e.get(0);
    if (this.c >= locala.a())
    {
      while ((!locala.a(this.c)) && (i < this.e.size()))
      {
        locala = (com.airbnb.lottie.a.a)this.e.get(i);
        i += 1;
      }
      this.d = locala;
      return locala;
    }
    this.d = locala;
    return locala;
  }
  
  public Object a()
  {
    float f2 = 0.0F;
    com.airbnb.lottie.a.a locala1 = b();
    float f1 = f2;
    if (!this.a)
    {
      com.airbnb.lottie.a.a locala2 = b();
      f1 = f2;
      if (locala2.d != null)
      {
        f1 = this.c;
        f2 = locala2.a();
        float f3 = locala2.b();
        float f4 = locala2.a();
        f1 = locala2.d.getInterpolation((f1 - f2) / (f3 - f4));
      }
    }
    return a(locala1, f1);
  }
  
  abstract Object a(com.airbnb.lottie.a.a parama, float paramFloat);
  
  public void a(float paramFloat)
  {
    if (!this.e.isEmpty()) {}
    for (float f1 = ((com.airbnb.lottie.a.a)this.e.get(0)).a();; f1 = 0.0F)
    {
      float f2;
      if (paramFloat >= f1) {
        if (!this.e.isEmpty())
        {
          List localList = this.e;
          f2 = ((com.airbnb.lottie.a.a)localList.get(localList.size() - 1)).b();
          f1 = paramFloat;
          if (paramFloat <= f2) {}
        }
      }
      for (f1 = 1.0F;; f1 = 0.0F)
      {
        if (f1 == this.c) {
          return;
        }
        this.c = f1;
        int i = 0;
        while (i < this.b.size())
        {
          ((b)this.b.get(i)).a();
          i += 1;
        }
        f2 = 1.0F;
        break;
      }
    }
  }
  
  public void a(b paramb)
  {
    this.b.add(paramb);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */