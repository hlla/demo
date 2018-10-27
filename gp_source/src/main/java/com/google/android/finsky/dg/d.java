package com.google.android.finsky.dg;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.finsky.ds.a.fa;
import java.io.OutputStream;
import java.util.List;

public abstract interface d
{
  public abstract int a();
  
  public abstract c a(String paramString1, String paramString2, long paramLong);
  
  public abstract void a(OutputStream paramOutputStream);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, long paramLong1, long paramLong2);
  
  public abstract void a(String paramString1, long paramLong, String paramString2, int paramInt1,
                         int paramInt2, fa paramfa);
  
  public abstract void a(String paramString1, long paramLong, String paramString2, int paramInt1,
                         int paramInt2, fa paramfa, int paramInt3, boolean paramBoolean);
  
  public abstract void a(String paramString, Bitmap paramBitmap);
  
  public abstract void a(String paramString, Uri paramUri);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, e parame);
  
  public abstract void a(List paramList);
  
  public abstract boolean a(boolean paramBoolean);
  
  public abstract void b(String paramString);
  
  @Deprecated
  public abstract boolean b();
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */