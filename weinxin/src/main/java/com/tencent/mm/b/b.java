package com.tencent.mm.b;

import com.tencent.gmtrace.GMTrace;

public final class b
  extends com.tencent.mm.bd.a
{
  public String apkMd5;
  public int fuN;
  public String fuO;
  public int fuP;
  public String fuQ;
  public String fuR;
  public boolean fuS;
  public int fuT;
  public boolean fuU;
  
  public b()
  {
    GMTrace.i(14019310125056L, 104452);
    GMTrace.o(14019310125056L, 104452);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(14019444342784L, 104453);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.apkMd5 == null) {
        throw new a.a.a.b("Not all required fields were included: apkMd5");
      }
      if (this.apkMd5 != null) {
        paramVarArgs.e(1, this.apkMd5);
      }
      paramVarArgs.eP(2, this.fuN);
      if (this.fuO != null) {
        paramVarArgs.e(3, this.fuO);
      }
      paramVarArgs.eP(4, this.fuP);
      if (this.fuQ != null) {
        paramVarArgs.e(5, this.fuQ);
      }
      if (this.fuR != null) {
        paramVarArgs.e(6, this.fuR);
      }
      paramVarArgs.an(7, this.fuS);
      paramVarArgs.eP(8, this.fuT);
      paramVarArgs.an(9, this.fuU);
      GMTrace.o(14019444342784L, 104453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.apkMd5 == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = a.a.a.a.f(1, this.apkMd5) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.eM(2, this.fuN);
      paramInt = i;
      if (this.fuO != null) {
        paramInt = i + a.a.a.a.f(3, this.fuO);
      }
      i = paramInt + a.a.a.a.eM(4, this.fuP);
      paramInt = i;
      if (this.fuQ != null) {
        paramInt = i + a.a.a.a.f(5, this.fuQ);
      }
      i = paramInt;
      if (this.fuR != null) {
        i = paramInt + a.a.a.a.f(6, this.fuR);
      }
      paramInt = a.a.a.a.Ef(7);
      int j = a.a.a.a.eM(8, this.fuT);
      int k = a.a.a.a.Ef(9);
      GMTrace.o(14019444342784L, 104453);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs);; paramInt = com.tencent.mm.bd.a.a(paramVarArgs))
        {
          if (paramInt <= 0)
          {
            if (this.apkMd5 != null) {
              break;
            }
            throw new a.a.a.b("Not all required fields were included: apkMd5");
          }
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(14019444342784L, 104453);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(14019444342784L, 104453);
          return -1;
        case 1: 
          localb.apkMd5 = locala.chP();
          GMTrace.o(14019444342784L, 104453);
          return 0;
        case 2: 
          localb.fuN = locala.chN();
          GMTrace.o(14019444342784L, 104453);
          return 0;
        case 3: 
          localb.fuO = locala.chP();
          GMTrace.o(14019444342784L, 104453);
          return 0;
        case 4: 
          localb.fuP = locala.chN();
          GMTrace.o(14019444342784L, 104453);
          return 0;
        case 5: 
          localb.fuQ = locala.chP();
          GMTrace.o(14019444342784L, 104453);
          return 0;
        case 6: 
          localb.fuR = locala.chP();
          GMTrace.o(14019444342784L, 104453);
          return 0;
        case 7: 
          localb.fuS = locala.chQ();
          GMTrace.o(14019444342784L, 104453);
          return 0;
        case 8: 
          localb.fuT = locala.chN();
          GMTrace.o(14019444342784L, 104453);
          return 0;
        }
        localb.fuU = locala.chQ();
        GMTrace.o(14019444342784L, 104453);
        return 0;
      }
      GMTrace.o(14019444342784L, 104453);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */