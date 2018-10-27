package com.google.android.gms.ads.internal.w.b.a;

import android.net.Uri;
import android.os.Handler;
import com.google.android.gms.ads.exoplayer1.upstream.d;
import com.google.android.gms.ads.exoplayer1.upstream.g;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.w.a.w;
import com.google.android.gms.ads.internal.w.ac;
import com.google.android.gms.ads.internal.w.ad;
import com.google.android.gms.ads.internal.w.b.k;
import com.google.android.gms.ads.internal.w.b.m;
import com.google.android.gms.common.util.b;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  extends k
{
  public boolean d;
  public String e;
  private boolean f;
  private ByteBuffer g;
  private final Object h;
  private final com.google.android.gms.ads.internal.w.b.c i;
  private final ac j;
  private boolean k;
  
  public a(ad paramad, ac paramac)
  {
    super(paramad);
    this.j = paramac;
    this.i = new com.google.android.gms.ads.internal.w.b.c();
    this.h = new Object();
  }
  
  private final void d()
  {
    int m = this.g.position();
    if (m > 0) {}
    for (boolean bool = true;; bool = false)
    {
      int n = com.google.android.gms.ads.internal.w.a.a.b;
      int i1 = com.google.android.gms.ads.internal.w.a.a.d;
      String str1 = this.e;
      String str2 = b(str1);
      com.google.android.gms.ads.internal.util.client.a.g.post(new m(this, str1, str2, m, bool, n, i1));
      return;
    }
  }
  
  public final void a()
  {
    this.f = true;
  }
  
  public final boolean a(String paramString)
  {
    this.e = paramString;
    String str3 = b(paramString);
    try
    {
      localObject1 = this.b;
      ??? = this.j;
      localObject1 = new g((String)localObject1, ((ac)???).d, ((ac)???).f, true);
      if (!this.j.h) {
        break label570;
      }
      localObject1 = new w(this.a, (d)localObject1, null);
      ((d)localObject1).a(new com.google.android.gms.ads.exoplayer1.upstream.e(Uri.parse(paramString)));
      ??? = (ad)this.c.get();
      if (??? != null) {
        break label557;
      }
    }
    catch (Exception localException2)
    {
      synchronized (this.h)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject4;
          long l3;
          long l5;
          long l6;
          Object localObject5;
          long l1;
          if (!this.f) {
            this.g.put((byte[])localObject5, 0, m);
          }
          if (this.g.remaining() > 0)
          {
            if (this.f) {
              break;
            }
            l4 = ((b)localObject4).a();
            l2 = l1;
            if (l4 - l1 >= l5)
            {
              d();
              l2 = l4;
            }
            l1 = l2;
            if (l4 - l3 <= 1000L * l6) {
              continue;
            }
            localObject1 = "downloadTimeout";
            try
            {
              ??? = new StringBuilder(49);
              ((StringBuilder)???).append("Timeout exceeded. Limit: ");
              ((StringBuilder)???).append(l6);
              ((StringBuilder)???).append(" sec");
              throw new IOException(((StringBuilder)???).toString());
            }
            catch (Exception localException1) {}
          }
          for (;;)
          {
            localObject4 = localException1.getClass().getCanonicalName();
            str2 = localException1.getMessage();
            localObject5 = new StringBuilder(String.valueOf(localObject4).length() + 1 + String.valueOf(str2).length());
            ((StringBuilder)localObject5).append((String)localObject4);
            ((StringBuilder)localObject5).append(":");
            ((StringBuilder)localObject5).append(str2);
            str2 = ((StringBuilder)localObject5).toString();
            localObject4 = new StringBuilder(String.valueOf(paramString).length() + 34 + String.valueOf(str2).length());
            ((StringBuilder)localObject4).append("Failed to preload url ");
            ((StringBuilder)localObject4).append(paramString);
            ((StringBuilder)localObject4).append(" Exception: ");
            ((StringBuilder)localObject4).append(str2);
            com.google.android.gms.ads.internal.util.e.e(((StringBuilder)localObject4).toString());
            a(paramString, str3, (String)localObject1, str2);
            return false;
            d();
            break;
            this.d = true;
            a(paramString, str3, (int)this.i.a(this.g));
            break;
            localException2 = localException2;
            localObject1 = "error";
          }
          localException2.a(str3, this);
        }
      }
    }
    localObject4 = bt.A.l;
    l3 = ((b)localObject4).a();
    l5 = ((Long)n.cr.a()).longValue();
    l6 = ((Long)n.cq.a()).longValue();
    this.g = ByteBuffer.allocate(this.j.c);
    localObject5 = new byte[' '];
    l1 = l3;
    int m = ((d)localObject1).a((byte[])localObject5, 0, Math.min(this.g.remaining(), 8192));
    if (m != -1) {}
    for (;;)
    {
      long l4;
      long l2;
      String str2;
      label557:
      label570:
      String str1 = "externalAbort";
      try
      {
        m = this.g.limit();
        StringBuilder localStringBuilder = new StringBuilder(35);
        localStringBuilder.append("Precache abort at ");
        localStringBuilder.append(m);
        localStringBuilder.append(" bytes");
        throw new IOException(localStringBuilder.toString());
      }
      catch (Exception localException3) {}
    }
    return true;
  }
  
  protected final String b(String paramString)
  {
    String str = String.valueOf("cache:");
    paramString = String.valueOf(super.b(paramString));
    if (paramString.length() == 0) {
      return new String(str);
    }
    return str.concat(paramString);
  }
  
  public final ByteBuffer c()
  {
    synchronized (this.h)
    {
      ByteBuffer localByteBuffer = this.g;
      if ((localByteBuffer != null) && (!this.k))
      {
        localByteBuffer.flip();
        this.k = true;
      }
      this.f = true;
      return this.g;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */