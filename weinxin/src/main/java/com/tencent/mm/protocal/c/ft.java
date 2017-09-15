package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ft
  extends com.tencent.mm.bd.a
{
  public int tgV;
  public int thA;
  public int thB;
  public int thC;
  
  public ft()
  {
    GMTrace.i(3771115503616L, 28097);
    GMTrace.o(3771115503616L, 28097);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3771249721344L, 28098);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tgV);
      paramVarArgs.eO(2, this.thA);
      paramVarArgs.eO(3, this.thB);
      paramVarArgs.eO(4, this.thC);
      GMTrace.o(3771249721344L, 28098);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tgV);
      int i = a.a.a.a.eL(2, this.thA);
      int j = a.a.a.a.eL(3, this.thB);
      int k = a.a.a.a.eL(4, this.thC);
      GMTrace.o(3771249721344L, 28098);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3771249721344L, 28098);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      ft localft = (ft)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3771249721344L, 28098);
        return -1;
      case 1: 
        localft.tgV = locala.xky.mL();
        GMTrace.o(3771249721344L, 28098);
        return 0;
      case 2: 
        localft.thA = locala.xky.mL();
        GMTrace.o(3771249721344L, 28098);
        return 0;
      case 3: 
        localft.thB = locala.xky.mL();
        GMTrace.o(3771249721344L, 28098);
        return 0;
      }
      localft.thC = locala.xky.mL();
      GMTrace.o(3771249721344L, 28098);
      return 0;
    }
    GMTrace.o(3771249721344L, 28098);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */