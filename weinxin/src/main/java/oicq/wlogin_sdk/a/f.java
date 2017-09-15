package oicq.wlogin_sdk.a;

public final class f
  extends a
{
  int xmb = 0;
  
  public f()
  {
    this.xli = 260;
  }
  
  public final byte[] bM(byte[] paramArrayOfByte)
  {
    this.xmb = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.xmb];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.Ei(this.xli);
    super.H(arrayOfByte, this.xmb);
    super.cie();
    return super.cia();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */