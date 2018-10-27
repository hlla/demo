package com.google.android.finsky.bc.b;

import android.support.v4.g.a;
import android.support.v4.g.v;
import android.support.v7.view.e;
import android.view.LayoutInflater;
import com.google.wireless.android.finsky.dfe.e.a.dt;

public final class d
{
  private final LayoutInflater a;
  private final int b;
  private final a c = new a();
  
  public d(LayoutInflater paramLayoutInflater)
  {
    this(paramLayoutInflater, 0);
  }
  
  public d(LayoutInflater paramLayoutInflater, int paramInt)
  {
    this.b = paramInt;
    this.a = paramLayoutInflater;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2132017889;
    case 6: 
      return 2132017891;
    case 5: 
      return 2132017893;
    case 4: 
      return 2132017895;
    case 3: 
      return 2132017892;
    case 2: 
      return 2132017894;
    }
    return 2132017890;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 5: 
    default: 
      return 1;
    case 6: 
      return 3;
    case 4: 
      return 4;
    case 2: 
      return 5;
    }
    return 2;
  }
  
  public final LayoutInflater a(dt paramdt)
  {
    int i = this.b;
    if (paramdt != null) {
      i = paramdt.a;
    }
    a locala = this.c;
    paramdt = Integer.valueOf(i);
    if (!locala.containsKey(paramdt))
    {
      locala = this.c;
      LayoutInflater localLayoutInflater = this.a;
      locala.put(paramdt, localLayoutInflater.cloneInContext(new e(localLayoutInflater.getContext(), a(i))));
    }
    return (LayoutInflater)this.c.get(paramdt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */