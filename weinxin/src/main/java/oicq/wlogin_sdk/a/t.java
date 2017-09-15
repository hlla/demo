package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class t
  extends a
{
  public int xmo = 0;
  
  public t()
  {
    this.xli = 282;
  }
  
  public final Boolean cif()
  {
    if (this.xlS < 5) {
      return Boolean.valueOf(false);
    }
    int i = util.J(this.xlc, this.xlR + 2 + 1 + 1);
    if (this.xlS < i + 5) {
      return Boolean.valueOf(false);
    }
    this.xmo = i;
    return Boolean.valueOf(true);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */