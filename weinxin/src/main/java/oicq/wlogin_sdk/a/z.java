package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class z
  extends a
{
  public int xmq = 0;
  public int xmr = 0;
  
  public z()
  {
    this.xli = 293;
  }
  
  public final Boolean cif()
  {
    if (this.xlS < 2) {
      return Boolean.valueOf(false);
    }
    this.xmq = util.K(this.xlc, this.xlR);
    if (this.xlS < this.xmq + 2 + 2) {
      return Boolean.valueOf(false);
    }
    this.xmr = util.K(this.xlc, this.xlR + 2 + this.xmq);
    return Boolean.valueOf(true);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */