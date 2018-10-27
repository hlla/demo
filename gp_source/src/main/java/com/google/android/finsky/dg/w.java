package com.google.android.finsky.dg;

import android.content.pm.PackageInstaller.Session;
import java.io.FilterOutputStream;
import java.io.OutputStream;

final class w
  extends FilterOutputStream
{
  public final PackageInstaller.Session a;
  public final OutputStream b;
  
  public w(OutputStream paramOutputStream, PackageInstaller.Session paramSession)
  {
    super(paramOutputStream);
    this.b = paramOutputStream;
    this.a = paramSession;
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.b.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */