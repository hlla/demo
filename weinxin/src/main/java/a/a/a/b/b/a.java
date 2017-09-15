package a.a.a.b.b;

import java.io.UnsupportedEncodingException;

public final class a
{
  private final int aIo;
  private final byte[] buffer;
  private int position;
  
  public a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.aIo = (paramInt2 + 0);
  }
  
  public static int cH(int paramInt)
  {
    return cJ(a.a.a.b.a.au(paramInt, 0));
  }
  
  public static int cJ(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int f(int paramInt, String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramInt = cH(paramInt);
      int i = cJ(paramString.length);
      int j = paramString.length;
      return j + (paramInt + i);
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("UTF-8 not supported.");
    }
  }
  
  public final void at(int paramInt1, int paramInt2)
  {
    cI(a.a.a.b.a.au(paramInt1, paramInt2));
  }
  
  public final void cG(int paramInt)
  {
    int i = (byte)paramInt;
    byte[] arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = (paramInt + 1);
    arrayOfByte[paramInt] = i;
  }
  
  public final void cI(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        cG(paramInt);
        return;
      }
      cG(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public final void j(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    int j;
    int i;
    do
    {
      do
      {
        return;
        j = paramArrayOfByte.length;
      } while (paramArrayOfByte == null);
      if (this.aIo - this.position >= j)
      {
        System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, j);
        this.position = (j + this.position);
        return;
      }
      i = this.aIo - this.position;
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, i);
      j -= i;
      this.position = this.aIo;
    } while (j > this.aIo);
    System.arraycopy(paramArrayOfByte, i + 0, this.buffer, 0, j);
    this.position = j;
  }
  
  public final void n(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        cG((int)paramLong);
        return;
      }
      cG((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/a/a/a/b/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */