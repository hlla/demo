package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;

public final class h
  extends d
{
  public h(i parami)
  {
    this.xli = 2064;
    this.xlj = 3;
    this.xll = parami;
  }
  
  public final int l(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    f localf = new f();
    g localg = new g();
    int i = super.G(paramArrayOfByte, paramInt1 + 2);
    super.cib();
    int j = paramInt1 + 5;
    switch (i)
    {
    case 3: 
    case 4: 
    default: 
      k(paramArrayOfByte, j, this.xkX - j - 1);
      return i;
    case 2: 
      paramInt2 = localf.n(paramArrayOfByte, j, this.xkX - j);
      paramInt1 = paramInt2;
      if (paramInt2 >= 0)
      {
        this.xll.xlq = localf;
        paramInt2 = localg.n(paramArrayOfByte, j, this.xkX - j);
        paramInt1 = paramInt2;
        if (paramInt2 >= 0)
        {
          this.xll.xlr = localg;
          return i;
        }
      }
      break;
    case 5: 
      super.k(paramArrayOfByte, j, this.xkX - j - 1);
      return i;
    }
    return paramInt1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/request/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */