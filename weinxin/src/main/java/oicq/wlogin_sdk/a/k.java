package oicq.wlogin_sdk.a;

public final class k
  extends a
{
  int xml = 0;
  
  public k()
  {
    this.xli = 265;
  }
  
  public final byte[] bO(byte[] paramArrayOfByte)
  {
    this.xml = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.xml];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.Ei(this.xli);
    super.H(arrayOfByte, this.xml);
    super.cie();
    return super.cia();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */