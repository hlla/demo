package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class g
  extends a
{
  public int xmc = 0;
  public int xmd = 0;
  public int xme = 0;
  public int xmf = 0;
  
  public g()
  {
    this.xli = 261;
  }
  
  public final Boolean cif()
  {
    if (this.xlS < 2) {
      return Boolean.valueOf(false);
    }
    this.xmd = util.K(this.xlc, this.xlR);
    if (this.xlS < this.xmd + 2 + 2) {
      return Boolean.valueOf(false);
    }
    this.xmc = util.K(this.xlc, this.xlR + 2 + this.xmd);
    if (this.xlS < this.xmd + 2 + 2 + this.xmc) {
      return Boolean.valueOf(false);
    }
    this.xmf = (this.xlR + 2);
    this.xme = (this.xmd + 2 + 2 + this.xlR);
    return Boolean.valueOf(true);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */