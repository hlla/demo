package com.google.android.finsky.bf;

import com.google.android.finsky.dc.a;
import com.google.wireless.android.finsky.b.d;
import com.google.wireless.android.finsky.b.z;
import java.io.File;
import java.io.OutputStream;

public abstract class f
{
  public final com.google.wireless.android.finsky.b.f b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final z g;
  public final String h;
  public final d i;
  public final long j;
  
  public f(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, com.google.wireless.android.finsky.b.f paramf, d paramd, z paramz)
  {
    this.h = paramString2;
    this.j = paramLong;
    this.e = paramString3;
    this.f = paramString4;
    this.d = paramString5;
    this.b = paramf;
    this.i = paramd;
    this.c = paramString1;
    this.g = paramz;
  }
  
  public abstract String a(String paramString);
  
  public abstract void a(OutputStream paramOutputStream);
  
  public abstract boolean a();
  
  public abstract boolean a(boolean paramBoolean);
  
  public abstract File b();
  
  public abstract int c();
  
  public abstract boolean d();
  
  public abstract boolean e();
  
  @Deprecated
  public abstract boolean f();
  
  public abstract OutputStream g();
  
  public abstract void h();
  
  public File i()
  {
    return null;
  }
  
  public a j()
  {
    return null;
  }
  
  public boolean k()
  {
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bf/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */