package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h
  extends a
{
  int xmg = 1;
  int xmh = 1;
  int xmi = 69;
  
  public h()
  {
    this.xli = 262;
    if (util.xne <= 2)
    {
      this.xmg = 1;
      this.xmi = 69;
      return;
    }
    this.xmg = 2;
    this.xmi = 90;
  }
  
  public final byte[] a(long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2, byte[] paramArrayOfByte5)
  {
    if (util.xne <= 2)
    {
      paramArrayOfByte5 = new byte[this.xmi];
      util.p(paramArrayOfByte5, 0, this.xmg);
      util.q(paramArrayOfByte5, 2, util.cik());
      util.q(paramArrayOfByte5, 6, this.xmh);
      util.q(paramArrayOfByte5, 10, (int)paramLong1);
      util.q(paramArrayOfByte5, 14, paramInt1);
      util.b(paramArrayOfByte5, 18, paramLong2);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, 26, paramArrayOfByte1.length);
      paramInt1 = paramArrayOfByte1.length + 26;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte2.length);
      paramInt1 += paramArrayOfByte2.length;
      util.o(paramArrayOfByte5, paramInt1, 1);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte3.length);
      System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt1 + paramArrayOfByte3.length, paramArrayOfByte4.length);
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.b(paramArrayOfByte1, 16, paramLong2);
      paramArrayOfByte1 = c.bS(paramArrayOfByte1);
      paramArrayOfByte1 = d.b(paramArrayOfByte5, paramArrayOfByte5.length, paramArrayOfByte1);
      this.xmi = paramArrayOfByte1.length;
      super.Ei(this.xli);
      super.H(paramArrayOfByte1, this.xmi);
      super.cie();
      return super.cia();
    }
    byte[] arrayOfByte = new byte[this.xmi];
    util.p(arrayOfByte, 0, this.xmg);
    util.q(arrayOfByte, 2, util.cik());
    util.q(arrayOfByte, 6, this.xmh);
    util.q(arrayOfByte, 10, (int)paramLong1);
    util.q(arrayOfByte, 14, paramInt1);
    util.b(arrayOfByte, 18, paramLong2);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 26, paramArrayOfByte1.length);
    paramInt1 = paramArrayOfByte1.length + 26;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    util.o(arrayOfByte, paramInt1, 1);
    paramInt1 += 1;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt1, paramArrayOfByte3.length);
    paramInt1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt1, paramArrayOfByte4.length);
    paramInt1 += paramArrayOfByte4.length;
    util.q(arrayOfByte, paramInt1, 0);
    paramInt1 += 4;
    util.o(arrayOfByte, paramInt1, paramInt2);
    if ((paramArrayOfByte5 == null) || (paramArrayOfByte5.length <= 0))
    {
      paramArrayOfByte1 = new byte[16];
      util.q(paramArrayOfByte1, 0, util.cik());
      util.q(paramArrayOfByte1, 4, util.cik());
      util.q(paramArrayOfByte1, 8, util.cik());
      util.q(paramArrayOfByte1, 12, util.cik());
    }
    for (;;)
    {
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.b(paramArrayOfByte1, 16, paramLong2);
      paramArrayOfByte1 = c.bS(paramArrayOfByte1);
      paramArrayOfByte1 = d.b(arrayOfByte, arrayOfByte.length, paramArrayOfByte1);
      this.xmi = paramArrayOfByte1.length;
      super.Ei(this.xli);
      super.H(paramArrayOfByte1, this.xmi);
      super.cie();
      return cia();
      System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt1 + 1, paramArrayOfByte5.length);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */