package com.tencent.mm.ah.a.d;

import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;

public final class b
{
  public Bitmap bitmap;
  public byte[] data;
  public int fFi;
  public String gac;
  public int status;
  
  public b()
  {
    GMTrace.i(13722688946176L, 102242);
    this.status = -1;
    GMTrace.o(13722688946176L, 102242);
  }
  
  public b(Bitmap paramBitmap)
  {
    GMTrace.i(13722823163904L, 102243);
    this.status = 0;
    this.fFi = 0;
    this.bitmap = paramBitmap;
    GMTrace.o(13722823163904L, 102243);
  }
  
  public b(byte[] paramArrayOfByte, String paramString)
  {
    GMTrace.i(13722957381632L, 102244);
    this.data = paramArrayOfByte;
    this.gac = paramString;
    GMTrace.o(13722957381632L, 102244);
  }
  
  public b(byte[] paramArrayOfByte, String paramString, byte paramByte)
  {
    GMTrace.i(13723091599360L, 102245);
    this.data = paramArrayOfByte;
    this.fFi = 2;
    this.gac = paramString;
    GMTrace.o(13723091599360L, 102245);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */