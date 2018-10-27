package com.google.android.finsky.bq;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.e.af;
import com.google.android.finsky.navigationmanager.c;
import java.util.List;

public abstract interface b
{
  public abstract a a(Context paramContext, Document paramDocument);
  
  public abstract d a();
  
  public abstract d a(String paramString);
  
  public abstract void a(Intent paramIntent, c paramc, af paramaf);
  
  public abstract void a(Fragment paramFragment, a parama, boolean paramBoolean);
  
  public abstract void a(e parame);
  
  public abstract boolean a(q paramq);
  
  public abstract void b(q paramq);
  
  public abstract void b(e parame);
  
  public abstract boolean b();
  
  public abstract List c();
  
  public abstract boolean d();
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bq/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */