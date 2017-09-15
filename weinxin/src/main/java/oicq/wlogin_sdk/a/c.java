package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class c
  extends a
{
  int xlY = 1;
  int xlZ = util.xne;
  int xma = 22;
  
  public c()
  {
    this.xli = 256;
  }
  
  public final byte[] a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[this.xma];
    util.p(arrayOfByte, 0, this.xlY);
    util.q(arrayOfByte, 2, this.xlZ);
    util.q(arrayOfByte, 6, (int)paramLong1);
    util.q(arrayOfByte, 10, 1);
    util.q(arrayOfByte, 14, paramInt1);
    util.q(arrayOfByte, 18, paramInt2);
    super.Ei(this.xli);
    super.H(arrayOfByte, this.xma);
    super.cie();
    return super.cia();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */