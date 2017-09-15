package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;

public final class ahz
  extends com.tencent.mm.bd.a
{
  public int jLr;
  public int tKv;
  public b tKw;
  public int tKx;
  public int tKy;
  public int tsi;
  
  public ahz()
  {
    GMTrace.i(13099247599616L, 97597);
    GMTrace.o(13099247599616L, 97597);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13099381817344L, 97598);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tKv);
      if (this.tKw != null) {
        paramVarArgs.b(2, this.tKw);
      }
      paramVarArgs.eO(3, this.tKx);
      paramVarArgs.eO(4, this.tsi);
      paramVarArgs.eO(5, this.jLr);
      paramVarArgs.eO(6, this.tKy);
      GMTrace.o(13099381817344L, 97598);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.tKv) + 0;
      paramInt = i;
      if (this.tKw != null) {
        paramInt = i + a.a.a.a.a(2, this.tKw);
      }
      i = a.a.a.a.eL(3, this.tKx);
      int j = a.a.a.a.eL(4, this.tsi);
      int k = a.a.a.a.eL(5, this.jLr);
      int m = a.a.a.a.eL(6, this.tKy);
      GMTrace.o(13099381817344L, 97598);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13099381817344L, 97598);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      ahz localahz = (ahz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13099381817344L, 97598);
        return -1;
      case 1: 
        localahz.tKv = locala.xky.mL();
        GMTrace.o(13099381817344L, 97598);
        return 0;
      case 2: 
        localahz.tKw = locala.chR();
        GMTrace.o(13099381817344L, 97598);
        return 0;
      case 3: 
        localahz.tKx = locala.xky.mL();
        GMTrace.o(13099381817344L, 97598);
        return 0;
      case 4: 
        localahz.tsi = locala.xky.mL();
        GMTrace.o(13099381817344L, 97598);
        return 0;
      case 5: 
        localahz.jLr = locala.xky.mL();
        GMTrace.o(13099381817344L, 97598);
        return 0;
      }
      localahz.tKy = locala.xky.mL();
      GMTrace.o(13099381817344L, 97598);
      return 0;
    }
    GMTrace.o(13099381817344L, 97598);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ahz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */