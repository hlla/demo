package com.tencent.mm.modelsfs;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class a
{
  private static boolean hQG;
  private long hQH;
  private String hQI;
  private long hQJ;
  private long mNativePtr;
  
  static
  {
    GMTrace.i(13839458369536L, 103112);
    hQG = false;
    GMTrace.o(13839458369536L, 103112);
  }
  
  public a(long paramLong)
  {
    GMTrace.i(13838384627712L, 103104);
    this.hQH = 0L;
    this.mNativePtr = 0L;
    this.hQJ = 0L;
    this.hQI = String.valueOf(paramLong);
    init();
    GMTrace.o(13838384627712L, 103104);
  }
  
  public a(String paramString)
  {
    GMTrace.i(13838518845440L, 103105);
    this.hQH = 0L;
    this.mNativePtr = 0L;
    this.hQJ = 0L;
    this.hQI = paramString;
    init();
    GMTrace.o(13838518845440L, 103105);
  }
  
  private void init()
  {
    GMTrace.i(13838653063168L, 103106);
    v.i("MicroMsg.EncEngine", "init  key  enckey " + this.hQI + "  hashcode " + hashCode());
    this.mNativePtr = MMIMAGEENCJNI.open(this.hQI);
    try
    {
      v.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
      GMTrace.o(13838653063168L, 103106);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.EncEngine", "exception " + localException.getMessage());
      GMTrace.o(13838653063168L, 103106);
    }
  }
  
  public final long IK()
  {
    GMTrace.i(13838921498624L, 103108);
    this.hQJ = this.hQH;
    long l = this.hQJ;
    GMTrace.o(13838921498624L, 103108);
    return l;
  }
  
  public final void free()
  {
    GMTrace.i(13839324151808L, 103111);
    v.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
    MMIMAGEENCJNI.free(this.mNativePtr);
    this.mNativePtr = 0L;
    GMTrace.o(13839324151808L, 103111);
  }
  
  public final int j(byte[] paramArrayOfByte, int paramInt)
  {
    GMTrace.i(13839055716352L, 103109);
    if (this.mNativePtr == 0L) {
      v.i("MicroMsg.EncEngine", "transFor " + bf.bJP().toString());
    }
    if (hQG) {
      v.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + paramArrayOfByte.length);
    }
    if ((hQG) && (this.hQH < 64L)) {
      v.d("MicroMsg.EncEngine", "dump before _offset " + this.hQH + "  length:" + paramInt + " " + bf.bl(paramArrayOfByte) + " hashcode " + hashCode());
    }
    MMIMAGEENCJNI.transFor(this.mNativePtr, paramArrayOfByte, this.hQH, paramInt);
    if ((hQG) && (this.hQH < 64L)) {
      v.d("MicroMsg.EncEngine", "dump after _offset " + this.hQH + "  length:" + paramInt + " " + bf.bl(paramArrayOfByte) + " hashcode " + hashCode());
    }
    this.hQH += paramInt;
    GMTrace.o(13839055716352L, 103109);
    return paramInt;
  }
  
  public final void reset()
  {
    GMTrace.i(13838787280896L, 103107);
    v.i("MicroMsg.EncEngine", "reset " + bf.bJP());
    free();
    if (this.hQJ == 0L)
    {
      init();
      this.hQH = 0L;
      GMTrace.o(13838787280896L, 103107);
      return;
    }
    init();
    MMIMAGEENCJNI.seek(this.mNativePtr, this.hQJ, 1);
    this.hQH = this.hQJ;
    GMTrace.o(13838787280896L, 103107);
  }
  
  public final void seek(long paramLong)
  {
    GMTrace.i(13839189934080L, 103110);
    this.hQH = paramLong;
    MMIMAGEENCJNI.seek(this.mNativePtr, paramLong, 1);
    GMTrace.o(13839189934080L, 103110);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsfs/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */