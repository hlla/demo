package com.google.android.gms.c;

import java.io.IOException;
import java.lang.reflect.Array;

public final class az<M extends ay<M>, T>
{
  protected final boolean aCA;
  protected final Class<T> aCz;
  public final int tag;
  protected final int type;
  
  private int ae(Object paramObject)
  {
    int i = bh.cu(this.tag);
    switch (this.type)
    {
    default: 
      throw new IllegalArgumentException("Unknown type " + this.type);
    case 10: 
      paramObject = (be)paramObject;
      return ax.cn(i) * 2 + ((be)paramObject).lH();
    }
    return ax.b(i, (be)paramObject);
  }
  
  private void b(Object paramObject, ax paramax)
  {
    for (;;)
    {
      try
      {
        paramax.co(this.tag);
        switch (this.type)
        {
        case 10: 
          throw new IllegalArgumentException("Unknown type " + this.type);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException((Throwable)paramObject);
      }
      paramObject = (be)paramObject;
      int i = bh.cu(this.tag);
      ((be)paramObject).a(paramax);
      paramax.am(i, 4);
      return;
      paramax.b((be)paramObject);
      return;
    }
  }
  
  final void a(Object paramObject, ax paramax)
  {
    if (this.aCA)
    {
      int j = Array.getLength(paramObject);
      int i = 0;
      while (i < j)
      {
        Object localObject = Array.get(paramObject, i);
        if (localObject != null) {
          b(localObject, paramax);
        }
        i += 1;
      }
    }
    b(paramObject, paramax);
  }
  
  final int ad(Object paramObject)
  {
    int i = 0;
    if (this.aCA)
    {
      int m = Array.getLength(paramObject);
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        k = i;
        if (Array.get(paramObject, j) != null) {
          k = i + ae(Array.get(paramObject, j));
        }
        j += 1;
        i = k;
      }
    }
    int k = ae(paramObject);
    return k;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */