package com.google.android.gms.ads.internal.v;

import android.os.Bundle;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;

@a
public final class m
{
  public final Object a = new Object();
  public int b;
  public int c;
  public final String d;
  public final n e;
  
  private m(n paramn, String paramString)
  {
    this.e = paramn;
    this.d = paramString;
  }
  
  public m(String paramString)
  {
    this(bt.A.i.i, paramString);
  }
  
  public final Bundle a()
  {
    synchronized (this.a)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("pmnli", this.b);
      localBundle.putInt("pmnll", this.c);
      return localBundle;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (this != paramObject)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (getClass() == paramObject.getClass())
        {
          paramObject = (m)paramObject;
          String str = this.d;
          if (str == null) {
            break label54;
          }
          bool1 = str.equals(((m)paramObject).d);
        }
      }
      label54:
      do
      {
        return bool1;
        bool1 = bool2;
      } while (((m)paramObject).d != null);
      return true;
    }
    return true;
  }
  
  public final int hashCode()
  {
    String str = this.d;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/v/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */