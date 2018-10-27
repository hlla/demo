package com.google.android.finsky.bf;

import android.content.Context;
import com.google.wireless.android.finsky.b.ah;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class k
  extends b
{
  private final File k = new File(paramString3, this.a);
  
  public k(Context paramContext, String paramString1, com.google.android.finsky.l.a parama, String paramString2, String paramString3, ah paramah)
  {
    super(paramContext, paramString1, parama, paramString2, paramah);
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    paramOutputStream.flush();
    paramOutputStream.close();
  }
  
  public final boolean a(boolean paramBoolean)
  {
    return true;
  }
  
  public final boolean d()
  {
    return com.google.android.finsky.utils.a.d() ^ true;
  }
  
  public final boolean f()
  {
    return true;
  }
  
  public final OutputStream g()
  {
    this.k.delete();
    return new FileOutputStream(this.k);
  }
  
  public final void h()
  {
    this.k.delete();
  }
  
  public final File i()
  {
    return this.k;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bf/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */