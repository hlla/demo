package oicq.wlogin_sdk.a;

public final class j
  extends a
{
  int xmk = 0;
  
  public j()
  {
    this.xli = 264;
  }
  
  public final byte[] bN(byte[] paramArrayOfByte)
  {
    this.xmk = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.xmk];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.Ei(this.xli);
    super.H(arrayOfByte, this.xmk);
    super.cie();
    return super.cia();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */