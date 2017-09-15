package com.tencent.qqpinyin.voicerecoapi;

public final class a
{
  public static int wNu = 2000;
  private byte[] wNv = null;
  public byte[] wNw = null;
  private int wNx = 0;
  public int wNy = 0;
  public TRSpeexNative wNz = new TRSpeexNative();
  
  public final byte[] E(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.wNx == 0) {
      throw new b(-102);
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      throw new b(-104);
    }
    paramInt = this.wNz.nativeTRSpeexEncode(this.wNx, paramArrayOfByte, 0, paramInt, this.wNv);
    if (paramInt < 0) {
      throw new b(paramInt);
    }
    if (paramInt == 0) {
      return null;
    }
    paramArrayOfByte = new byte[paramInt];
    System.arraycopy(this.wNv, 0, paramArrayOfByte, 0, paramInt);
    return paramArrayOfByte;
  }
  
  public final int cdg()
  {
    int i;
    if (this.wNx != 0) {
      i = -103;
    }
    int j;
    do
    {
      return i;
      j = this.wNz.nativeTRSpeexInit();
      i = j;
    } while (j == -1);
    this.wNx = j;
    this.wNv = new byte[wNu * 10];
    return 0;
  }
  
  public final int cdh()
  {
    if (this.wNx == 0) {
      return -102;
    }
    this.wNv = null;
    int i = this.wNz.nativeTRSpeexRelease(this.wNx);
    this.wNx = 0;
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/qqpinyin/voicerecoapi/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */