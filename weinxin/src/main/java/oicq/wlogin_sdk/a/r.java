package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class r
  extends a
{
  int xmm = 0;
  int xmn = 0;
  
  public r()
  {
    this.xli = 278;
  }
  
  public final byte[] a(int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    this.xmm = 10;
    paramArrayOfLong = new byte[this.xmm];
    util.o(paramArrayOfLong, 0, this.xmn);
    util.q(paramArrayOfLong, 1, paramInt1);
    util.q(paramArrayOfLong, 5, paramInt2);
    util.o(paramArrayOfLong, 9, 0);
    super.Ei(this.xli);
    super.H(paramArrayOfLong, this.xmm);
    super.cie();
    return super.cia();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */