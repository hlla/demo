package com.airbnb.lottie.a.b;

import com.airbnb.lottie.c.a.i;
import com.airbnb.lottie.c.a.q;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public final List a;
  public final List b;
  public final List c;
  
  public h(List paramList)
  {
    this.b = paramList;
    this.a = new ArrayList(paramList.size());
    this.c = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      this.a.add(((com.airbnb.lottie.c.b.h)paramList.get(i)).b.a());
      i locali = ((com.airbnb.lottie.c.b.h)paramList.get(i)).c;
      this.c.add(locali.a());
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */