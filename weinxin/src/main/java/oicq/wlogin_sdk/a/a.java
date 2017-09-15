package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public int xkW = 128;
  public int xkX = 0;
  int xlQ = 0;
  public int xlR = 4;
  public int xlS = 0;
  public byte[] xlc = new byte[this.xkW];
  public int xli = 0;
  
  private static int m(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = paramArrayOfByte.length;
    for (;;)
    {
      if (paramInt1 >= j) {}
      do
      {
        int i = -1;
        do
        {
          return i;
          if (paramInt1 + 2 > j) {
            break;
          }
          i = paramInt1;
        } while (util.K(paramArrayOfByte, paramInt1) == paramInt2);
        paramInt1 += 2;
      } while (paramInt1 + 2 > j);
      paramInt1 += util.K(paramArrayOfByte, paramInt1) + 2;
    }
  }
  
  public final void Ei(int paramInt)
  {
    util.p(this.xlc, this.xkX, paramInt);
    this.xkX += 2;
    util.p(this.xlc, this.xkX, 0);
    this.xkX += 2;
  }
  
  public final void H(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > this.xkW - this.xlR)
    {
      this.xkW = (this.xlR + paramInt + 64);
      byte[] arrayOfByte = new byte[this.xkW];
      System.arraycopy(this.xlc, 0, arrayOfByte, 0, this.xkX);
      this.xlc = arrayOfByte;
    }
    this.xlS = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.xlc, this.xkX, paramInt);
    this.xkX += paramInt;
  }
  
  public final int b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    int i = m(paramArrayOfByte1, paramInt1, this.xli);
    if (i < 0) {}
    byte[] arrayOfByte;
    do
    {
      do
      {
        return -1;
        paramInt1 = paramInt2 - (i - paramInt1);
        arrayOfByte = new byte[paramInt1];
        System.arraycopy(paramArrayOfByte1, i, arrayOfByte, 0, paramInt1);
      } while (this.xlR >= paramInt1);
      this.xlS = util.K(arrayOfByte, 2);
    } while (this.xlR + this.xlS > paramInt1);
    paramArrayOfByte1 = d.decrypt(arrayOfByte, this.xlR, this.xlS, paramArrayOfByte2);
    if (paramArrayOfByte1 == null) {
      return 64521;
    }
    if (this.xlR + paramArrayOfByte1.length > this.xkW)
    {
      this.xkW = (this.xlR + paramArrayOfByte1.length);
      this.xlc = new byte[this.xkW];
    }
    this.xkX = 0;
    System.arraycopy(arrayOfByte, 0, this.xlc, 0, this.xlR);
    this.xkX += this.xlR;
    System.arraycopy(paramArrayOfByte1, 0, this.xlc, this.xkX, paramArrayOfByte1.length);
    this.xkX += paramArrayOfByte1.length;
    this.xlS = paramArrayOfByte1.length;
    if (!cif().booleanValue()) {
      return 64531;
    }
    return 0;
  }
  
  public final byte[] cia()
  {
    byte[] arrayOfByte = new byte[this.xkX];
    System.arraycopy(this.xlc, 0, arrayOfByte, 0, this.xkX);
    return arrayOfByte;
  }
  
  public final byte[] cid()
  {
    byte[] arrayOfByte = new byte[this.xlS];
    System.arraycopy(this.xlc, this.xlR, arrayOfByte, 0, this.xlS);
    return arrayOfByte;
  }
  
  public final void cie()
  {
    util.p(this.xlc, 2, this.xkX - this.xlR);
  }
  
  public Boolean cif()
  {
    return Boolean.valueOf(true);
  }
  
  public final int n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = m(paramArrayOfByte, paramInt1, this.xli);
    if (i < 0) {}
    do
    {
      do
      {
        return -1;
        paramInt1 = paramInt2 - (i - paramInt1);
      } while (this.xlR >= paramInt1);
      this.xlS = util.K(paramArrayOfByte, i + 2);
    } while (this.xlR + this.xlS > paramInt1);
    paramInt1 = this.xlR + this.xlS;
    if (paramInt1 > this.xkW)
    {
      this.xkW = (paramInt1 + 128);
      this.xlc = new byte[this.xkW];
    }
    this.xkX = paramInt1;
    System.arraycopy(paramArrayOfByte, i, this.xlc, 0, paramInt1);
    this.xli = util.K(paramArrayOfByte, i);
    this.xlS = (paramInt1 - this.xlR);
    if (!cif().booleanValue()) {
      return 64531;
    }
    return this.xlR + i + this.xlS;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */