package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ae
  extends a
{
  int xmv = 0;
  int xmw = 0;
  
  public ae()
  {
    this.xli = 322;
  }
  
  public final byte[] bP(byte[] paramArrayOfByte)
  {
    this.xmw = (paramArrayOfByte.length + 4);
    byte[] arrayOfByte = new byte[this.xmw];
    util.p(arrayOfByte, 0, this.xmv);
    util.p(arrayOfByte, 2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    super.Ei(this.xli);
    super.H(arrayOfByte, arrayOfByte.length);
    super.cie();
    return super.cia();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */