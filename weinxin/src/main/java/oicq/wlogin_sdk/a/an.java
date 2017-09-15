package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class an
  extends a
{
  int xmE = 22;
  int xmF = 1;
  int xmG = 1536;
  
  public an()
  {
    this.xli = 24;
  }
  
  public final byte[] a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    byte[] arrayOfByte = new byte[this.xmE];
    util.p(arrayOfByte, 0, this.xmF);
    util.q(arrayOfByte, 2, this.xmG);
    util.q(arrayOfByte, 6, (int)paramLong1);
    util.q(arrayOfByte, 10, paramInt1);
    util.q(arrayOfByte, 14, (int)paramLong2);
    util.p(arrayOfByte, 18, 0);
    util.p(arrayOfByte, 20, 0);
    super.Ei(this.xli);
    super.H(arrayOfByte, this.xmE);
    super.cie();
    return super.cia();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */