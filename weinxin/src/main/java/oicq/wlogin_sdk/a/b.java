package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class b
  extends a
{
  int xlT = 4;
  int xlU = 14;
  int xlV = 1;
  int xlW = 20;
  byte[] xlX = new byte[2];
  
  public b()
  {
    this.xli = 1;
  }
  
  public final Boolean cif()
  {
    if (this.xlS < 20) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public final byte[] g(long paramLong, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[this.xlW];
    util.p(arrayOfByte, 0, this.xlV);
    util.q(arrayOfByte, 2, util.cik());
    util.q(arrayOfByte, 6, (int)paramLong);
    util.c(arrayOfByte, 10, util.cim());
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 14, paramArrayOfByte.length);
    util.p(arrayOfByte, paramArrayOfByte.length + 14, 0);
    super.Ei(this.xli);
    super.H(arrayOfByte, this.xlW);
    super.cie();
    return super.cia();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */