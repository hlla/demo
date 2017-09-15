package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ad
  extends a
{
  public int xmu = 0;
  
  public ad()
  {
    this.xli = 312;
  }
  
  public final Boolean cif()
  {
    if (this.xlS < 4) {
      return Boolean.valueOf(false);
    }
    this.xmu = util.L(this.xlc, this.xlR);
    if (this.xlS < this.xmu * 10 + 4) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public final int cig()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.xmu) {
        return 0;
      }
      if (util.K(this.xlc, this.xlR + 4 + i * 10) == 266) {
        return util.L(this.xlc, i * 10 + (this.xlR + 4) + 2);
      }
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */