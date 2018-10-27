package com.google.android.gms.ads.internal.w.a;

import com.google.android.gms.ads.exoplayer1.upstream.d;
import com.google.android.gms.ads.exoplayer1.upstream.e;
import com.google.android.gms.ads.internal.q.a.a;

@a
final class y
  implements d
{
  private final long a;
  private long b;
  private final d c;
  private final d d;
  
  y(d paramd1, int paramInt, d paramd2)
  {
    this.c = paramd1;
    this.a = paramInt;
    this.d = paramd2;
  }
  
  public final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = this.b;
    long l2 = this.a;
    int i;
    if (l1 < l2)
    {
      l1 = Math.min(paramInt2, l2 - l1);
      i = this.c.a(paramArrayOfByte, paramInt1, (int)l1);
      this.b += i;
    }
    for (;;)
    {
      int j = i;
      if (this.b >= this.a)
      {
        paramInt1 = this.d.a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
        this.b += paramInt1;
        j = i + paramInt1;
      }
      return j;
      i = 0;
    }
  }
  
  public final long a(e parame)
  {
    e locale2 = null;
    long l4 = -1L;
    long l2 = parame.e;
    long l1 = this.a;
    long l3;
    if (l2 < l1)
    {
      l3 = parame.d;
      if (l3 != -1L) {
        l1 = Math.min(l3, l1 - l2);
      }
    }
    for (e locale1 = new e(parame.f, l2, l1);; locale1 = null)
    {
      l1 = parame.d;
      if ((l1 == -1L) || (l1 + parame.e > this.a))
      {
        l2 = Math.max(this.a, parame.e);
        l1 = parame.d;
        if (l1 == -1L) {
          break label240;
        }
      }
      label240:
      for (l1 = Math.min(l1, parame.e + l1 - this.a);; l1 = -1L)
      {
        locale2 = new e(parame.f, l2, l1);
        if (locale1 != null) {}
        for (l1 = this.c.a(locale1);; l1 = 0L)
        {
          if (locale2 != null) {}
          for (l2 = this.d.a(locale2);; l2 = 0L)
          {
            this.b = parame.e;
            l3 = l4;
            if (l1 != -1L)
            {
              l3 = l4;
              if (l2 != -1L) {
                l3 = l1 + l2;
              }
            }
            return l3;
          }
        }
      }
      l1 -= l2;
      break;
    }
  }
  
  public final void a()
  {
    this.c.a();
    this.d.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */