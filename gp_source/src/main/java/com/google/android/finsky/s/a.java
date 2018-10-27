package com.google.android.finsky.s;

import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.dh.b;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.e.af;
import com.google.android.finsky.installqueue.k;

public final class a
{
  public final com.google.android.finsky.autoupdatev2.d a;
  public com.google.android.finsky.installqueue.d b;
  public final Document c;
  public int d;
  public int e;
  public k f;
  public int g;
  @Deprecated
  public int h;
  @Deprecated
  public final af i;
  public int j;
  public final b k;
  public int l;
  
  public a(Document paramDocument, b paramb, com.google.android.finsky.autoupdatev2.d paramd, af paramaf)
  {
    this.c = paramDocument;
    this.k = paramb;
    this.a = paramd;
    this.i = paramaf;
    this.f = new k(paramaf, paramDocument);
    this.b = new com.google.android.finsky.installqueue.d();
  }
  
  public final String toString()
  {
    o localo = this.c.U();
    return String.format("%s v:%d", new Object[] { localo.t, Integer.valueOf(localo.D) });
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/s/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */