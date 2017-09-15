package ct;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class aq
{
  private Cipher a;
  private Cipher b;
  
  public aq(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new SecretKeySpec(paramArrayOfByte, "AES");
      this.a = Cipher.getInstance("AES/ECB/PKCS5Padding");
      this.a.init(1, paramArrayOfByte);
      this.b = Cipher.getInstance("AES/ECB/PKCS5Padding");
      this.b.init(2, paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = this.a.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */