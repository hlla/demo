package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class aa
  extends a
{
  int xms = 0;
  
  public aa()
  {
    this.xli = 296;
  }
  
  private static int I(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length > paramInt) {
        return paramInt;
      }
      return paramArrayOfByte.length;
    }
    return 0;
  }
  
  public final byte[] a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = I(paramArrayOfByte1, 32);
    int i = I(paramArrayOfByte2, 16);
    this.xms = (j + 11 + 2 + i + 2);
    byte[] arrayOfByte = new byte[this.xms];
    util.p(arrayOfByte, 0, 0);
    util.o(arrayOfByte, 2, paramInt1);
    util.o(arrayOfByte, 3, paramInt2);
    util.o(arrayOfByte, 4, paramInt3);
    util.q(arrayOfByte, 5, 0);
    util.p(arrayOfByte, 9, j);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 11, j);
    paramInt1 = j + 11;
    util.p(arrayOfByte, paramInt1, i);
    paramInt1 += 2;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, i);
    util.p(arrayOfByte, paramInt1 + i, 0);
    super.Ei(this.xli);
    super.H(arrayOfByte, this.xms);
    super.cie();
    return super.cia();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */