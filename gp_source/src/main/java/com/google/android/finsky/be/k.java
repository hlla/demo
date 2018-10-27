package com.google.android.finsky.be;

import android.os.Bundle;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.bp;

public final class k
{
  public final boolean a;
  public int b;
  public final boolean c;
  public final f d;
  public final com.google.android.finsky.cw.a e;
  private final com.google.android.finsky.f.b f;
  private final com.google.android.finsky.bh.b g;
  
  public k(com.google.android.finsky.f.b paramb, com.google.android.finsky.bh.b paramb1, f paramf, com.google.android.finsky.cw.a parama, com.google.android.finsky.de.a parama1, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.f = paramb;
    this.g = paramb1;
    this.d = paramf;
    this.e = parama;
    this.a = paramBoolean1;
    this.c = paramBoolean2;
    if (paramBundle != null)
    {
      this.b = paramBundle.getInt("DialogClientDownloadWarningModel.downloadNetworkPreference");
      return;
    }
    this.b = com.google.android.finsky.download.a.a(paramf.a(12653638L));
  }
  
  public final long a(Document paramDocument)
  {
    return this.g.a(paramDocument, true);
  }
  
  public final boolean b(Document paramDocument)
  {
    com.google.android.finsky.f.a locala = this.f.a(paramDocument.c().b);
    return (locala.b(paramDocument)) || (locala.a(paramDocument));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */