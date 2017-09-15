package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.ao;
import oicq.wlogin_sdk.a.f;

public final class g
  extends d
{
  public g(i parami)
  {
    this.xli = 2064;
    this.xlj = 2;
    this.xll = parami;
  }
  
  public final byte[] bL(byte[] paramArrayOfByte)
  {
    int k = this.xll.xlv;
    byte[] arrayOfByte1 = this.xll.xlq.cid();
    Object localObject = this.xll.xlr;
    byte[] arrayOfByte2 = new byte[((oicq.wlogin_sdk.a.g)localObject).xmd];
    int i;
    if (((oicq.wlogin_sdk.a.g)localObject).xmd <= 0)
    {
      localObject = new f();
      ao localao = new ao();
      localObject = ((f)localObject).bM(arrayOfByte1);
      paramArrayOfByte = localao.m(paramArrayOfByte, arrayOfByte2);
      arrayOfByte2 = new byte[localObject.length + paramArrayOfByte.length];
      if (arrayOfByte1.length <= 0) {
        break label209;
      }
      System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
      i = localObject.length + 0;
    }
    for (int j = 1;; j = 0)
    {
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, i, paramArrayOfByte.length);
      paramArrayOfByte = super.j(arrayOfByte2, this.xlj, j + 1);
      a(this.xld, this.xli, xle, this.xll._uin, this.xlf, this.xlg, k, this.xlh, paramArrayOfByte);
      return super.cia();
      System.arraycopy(((oicq.wlogin_sdk.a.g)localObject).xlc, ((oicq.wlogin_sdk.a.g)localObject).xmf, arrayOfByte2, 0, ((oicq.wlogin_sdk.a.g)localObject).xmd);
      break;
      label209:
      i = 0;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/request/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */