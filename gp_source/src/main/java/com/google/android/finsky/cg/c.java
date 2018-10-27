package com.google.android.finsky.cg;

import android.content.Intent;
import android.text.TextUtils;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.installer.b.a.g;
import com.google.android.finsky.installqueue.InstallConstraint;
import com.google.android.finsky.installqueue.InstallRequest;
import com.google.android.finsky.installqueue.k;
import com.google.android.finsky.utils.FinskyLog;

public final class c
{
  private static final String[] O = new String[0];
  public int A = -1;
  public long B;
  public com.google.android.finsky.e.a.a C;
  public byte[] D;
  public Intent E;
  public final String F;
  public int G;
  public int H;
  public String I;
  public String[] J;
  public String K;
  public String L;
  public long M;
  public long N;
  public String a;
  public String b;
  public int c = -1;
  public String d;
  public o e;
  public int f = 1;
  public String[] g;
  public String h;
  public com.google.wireless.android.finsky.b.a i;
  public long j;
  public String k;
  public int l = 0;
  public int m = 1;
  public int n = -1;
  public String o;
  public String p;
  public long q;
  public long r;
  public int s;
  public long t;
  public com.google.android.finsky.e.a.a u;
  public String v = "unknown";
  public com.google.android.finsky.installer.b.a.d w;
  public long x;
  public int y;
  public long z;
  
  c(String paramString)
  {
    this.F = paramString;
  }
  
  public c(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, com.google.wireless.android.finsky.b.a parama, long paramLong1, int paramInt5, String paramString2, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt6, long paramLong3, String paramString7, long paramLong4, int paramInt7, int paramInt8, String paramString8, String[] paramArrayOfString1, String paramString9, String paramString10, byte[] paramArrayOfByte, long paramLong5, o paramo, long paramLong6, long paramLong7, String paramString11, long paramLong8, com.google.android.finsky.e.a.a parama1, com.google.android.finsky.e.a.a parama2, long paramLong9, int paramInt9, Intent paramIntent, String paramString12, String[] paramArrayOfString2, com.google.android.finsky.installer.b.a.d paramd, int paramInt10)
  {
    this.F = paramString1;
    this.f = paramInt1;
    this.n = paramInt2;
    this.m = paramInt3;
    this.A = paramInt4;
    this.i = parama;
    this.j = paramLong1;
    this.y = paramInt5;
    this.o = paramString2;
    this.r = paramLong2;
    this.p = paramString3;
    this.h = paramString4;
    this.b = paramString5;
    this.L = paramString6;
    this.s = paramInt6;
    this.B = paramLong3;
    this.a = paramString7;
    this.q = paramLong4;
    this.H = paramInt7;
    this.G = paramInt8;
    this.k = paramString8;
    this.g = paramArrayOfString1;
    this.d = paramString9;
    this.I = paramString10;
    this.D = paramArrayOfByte;
    this.M = paramLong5;
    this.e = paramo;
    this.t = paramLong6;
    this.z = paramLong7;
    this.K = paramString11;
    this.N = paramLong8;
    this.u = parama1;
    this.C = parama2;
    this.x = paramLong9;
    this.l = paramInt9;
    this.E = paramIntent;
    this.v = paramString12;
    this.J = paramArrayOfString2;
    this.w = paramd;
    this.c = paramInt10;
  }
  
  public final String[] a()
  {
    String[] arrayOfString2 = this.g;
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2 == null) {
      arrayOfString1 = O;
    }
    return arrayOfString1;
  }
  
  public final int b()
  {
    int i1 = this.s;
    if ((i1 & 0x4000) == 0)
    {
      if ((i1 & 0x8000) == 0) {
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  public final boolean c()
  {
    return (this.s & 0x10000000) != 0;
  }
  
  public final com.google.android.finsky.e.a.a d()
  {
    com.google.android.finsky.e.a.a locala2 = this.u;
    com.google.android.finsky.e.a.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new com.google.android.finsky.e.a.a();
    }
    return locala1;
  }
  
  public final com.google.android.finsky.e.a.a e()
  {
    com.google.android.finsky.e.a.a locala2 = this.C;
    com.google.android.finsky.e.a.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new com.google.android.finsky.e.a.a();
    }
    return locala1;
  }
  
  public final com.google.android.finsky.installer.b.a.d f()
  {
    boolean bool2 = false;
    Object localObject1 = this.w;
    if (localObject1 == null) {}
    while (((com.google.android.finsky.installer.b.a.d)localObject1).w == -1)
    {
      Object localObject2 = e();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.google.android.finsky.e.a.a();
      }
      String str = this.F;
      int i1 = this.n;
      if (TextUtils.isEmpty(this.L)) {}
      for (localObject2 = "";; localObject2 = this.L)
      {
        localObject1 = new k((com.google.android.finsky.e.a.a)localObject1, str, i1, (String)localObject2);
        if (TextUtils.isEmpty(this.b)) {}
        for (;;)
        {
          if (TextUtils.isEmpty(this.k)) {}
          for (;;)
          {
            if (TextUtils.isEmpty(this.K)) {}
            for (;;)
            {
              if (TextUtils.isEmpty(this.v)) {}
              for (;;)
              {
                localObject2 = this.E;
                if (localObject2 != null) {
                  ((k)localObject1).a((Intent)localObject2);
                }
                i1 = this.s;
                if ((i1 & 0x4000) == 0) {
                  if ((0x8000 & i1) == 0) {
                    ((k)localObject1).b(3);
                  }
                }
                for (;;)
                {
                  if ((0x1000000 & i1) == 0) {}
                  for (;;)
                  {
                    if ((0x10000 & i1) == 0) {}
                    for (;;)
                    {
                      localObject2 = new com.google.android.finsky.installqueue.d();
                      if ((i1 & 0x800) == 0) {}
                      for (;;)
                      {
                        if ((0x100000 & i1) == 0) {}
                        for (;;)
                        {
                          if ((0x400000 & i1) == 0) {}
                          for (;;)
                          {
                            if ((0x20000 & i1) == 0) {}
                            for (;;)
                            {
                              ((k)localObject1).a(new InstallConstraint[] { ((com.google.android.finsky.installqueue.d)localObject2).b() });
                              localObject1 = ((k)localObject1).a().b;
                              localObject2 = ((com.google.android.finsky.installer.b.a.d)localObject1).x;
                              if ((i1 & 0x10) == 0) {}
                              for (boolean bool1 = true;; bool1 = false)
                              {
                                ((g)localObject2).a(bool1);
                                localObject2 = ((com.google.android.finsky.installer.b.a.d)localObject1).x;
                                if ((i1 & 0x80) == 0) {}
                                for (bool1 = true;; bool1 = false)
                                {
                                  ((g)localObject2).c(bool1);
                                  localObject2 = ((com.google.android.finsky.installer.b.a.d)localObject1).x;
                                  if ((i1 & 0x1 ^ 0x1) == 0) {}
                                  for (bool1 = bool2;; bool1 = true)
                                  {
                                    ((g)localObject2).b(bool1);
                                    return (com.google.android.finsky.installer.b.a.d)localObject1;
                                  }
                                }
                              }
                              ((com.google.android.finsky.installqueue.d)localObject2).b(0);
                            }
                            ((com.google.android.finsky.installqueue.d)localObject2).a();
                          }
                          ((com.google.android.finsky.installqueue.d)localObject2).c(0);
                        }
                        ((com.google.android.finsky.installqueue.d)localObject2).a(2);
                      }
                      ((k)localObject1).c(1);
                    }
                    ((k)localObject1).c(2);
                  }
                  ((k)localObject1).b(2);
                  continue;
                  ((k)localObject1).b(1);
                }
                ((k)localObject1).a(this.v);
              }
              ((k)localObject1).c(this.K);
            }
            ((k)localObject1).d(this.k);
          }
          ((k)localObject1).b(this.b);
        }
      }
    }
    return (com.google.android.finsky.installer.b.a.d)localObject1;
  }
  
  public final String toString()
  {
    boolean bool = true;
    String str = this.F;
    int i1 = this.f;
    int i2 = this.n;
    if (this.i != null) {}
    for (;;)
    {
      return String.format("(packageName=%s,autoUpdate=%d,desiredVersion=%d,hasDeliveryData=%b,installerState=%d,downloadUri=%s,firstDownloadMs=%d,externalReferrer=%s,continueUrl=%s,account=%s)", new Object[] { str, Integer.valueOf(i1), Integer.valueOf(i2), Boolean.valueOf(bool), Integer.valueOf(this.y), this.o, Long.valueOf(this.r), this.p, this.h, FinskyLog.a(this.b) });
      bool = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cg/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */