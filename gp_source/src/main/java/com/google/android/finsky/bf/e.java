package com.google.android.finsky.bf;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class e
  extends a
{
  private final File a;
  
  public e(Context paramContext, com.google.android.finsky.l.a parama, String paramString1, String paramString2, String paramString3, com.google.wireless.android.finsky.b.a parama1)
  {
    super(paramContext, parama, paramString2, paramString3, parama1);
    this.a = new File(paramString1, "base");
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
  
  public final boolean f()
  {
    return true;
  }
  
  public final OutputStream g()
  {
    this.a.delete();
    return new FileOutputStream(this.a);
  }
  
  public final void h()
  {
    this.a.delete();
  }
  
  public final File i()
  {
    return this.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bf/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */