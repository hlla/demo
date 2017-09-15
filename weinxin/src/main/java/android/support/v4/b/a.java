package android.support.v4.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class a
{
  static final b tJ = new a();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
    {
      tJ = new e();
      return;
    }
    if (i >= 18)
    {
      tJ = new d();
      return;
    }
    if (i >= 12)
    {
      tJ = new c();
      return;
    }
  }
  
  public static int b(Bitmap paramBitmap)
  {
    return tJ.b(paramBitmap);
  }
  
  static class a
    implements a.b
  {
    public int b(Bitmap paramBitmap)
    {
      return paramBitmap.getRowBytes() * paramBitmap.getHeight();
    }
  }
  
  static abstract interface b
  {
    public abstract int b(Bitmap paramBitmap);
  }
  
  static class c
    extends a.a
  {
    public int b(Bitmap paramBitmap)
    {
      return paramBitmap.getByteCount();
    }
  }
  
  static class d
    extends a.c
  {}
  
  static final class e
    extends a.d
  {
    public final int b(Bitmap paramBitmap)
    {
      return paramBitmap.getAllocationByteCount();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */