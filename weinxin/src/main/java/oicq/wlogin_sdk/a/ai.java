package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ai
  extends a
{
  public int xmA = 0;
  public int xmB = 0;
  public int xmC = 0;
  
  public ai()
  {
    this.xli = 326;
  }
  
  public final Boolean cif()
  {
    if (this.xlS < 12) {
      return Boolean.valueOf(false);
    }
    int i = util.K(this.xlc, this.xlR + 4);
    if (this.xlS < i + 12) {
      return Boolean.valueOf(false);
    }
    this.xmA = i;
    i = util.K(this.xlc, this.xlR + 6 + this.xmA);
    if (this.xlS < this.xmA + 12 + i) {
      return Boolean.valueOf(false);
    }
    this.xmB = i;
    i = util.K(this.xlc, this.xlR + 10 + this.xmA + this.xmB);
    if (this.xlS < this.xmA + 12 + this.xmB + i) {
      return Boolean.valueOf(false);
    }
    this.xmC = i;
    return Boolean.valueOf(true);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */