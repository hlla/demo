package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class agp
  extends com.tencent.mm.bd.a
{
  public int tJO;
  public int tJP;
  public int tJQ;
  public int tzH;
  
  public agp()
  {
    GMTrace.i(3906541191168L, 29106);
    GMTrace.o(3906541191168L, 29106);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3906675408896L, 29107);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tzH);
      paramVarArgs.eO(2, this.tJO);
      paramVarArgs.eO(3, this.tJP);
      paramVarArgs.eO(4, this.tJQ);
      GMTrace.o(3906675408896L, 29107);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tzH);
      int i = a.a.a.a.eL(2, this.tJO);
      int j = a.a.a.a.eL(3, this.tJP);
      int k = a.a.a.a.eL(4, this.tJQ);
      GMTrace.o(3906675408896L, 29107);
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
      GMTrace.o(3906675408896L, 29107);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      agp localagp = (agp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3906675408896L, 29107);
        return -1;
      case 1: 
        localagp.tzH = locala.xky.mL();
        GMTrace.o(3906675408896L, 29107);
        return 0;
      case 2: 
        localagp.tJO = locala.xky.mL();
        GMTrace.o(3906675408896L, 29107);
        return 0;
      case 3: 
        localagp.tJP = locala.xky.mL();
        GMTrace.o(3906675408896L, 29107);
        return 0;
      }
      localagp.tJQ = locala.xky.mL();
      GMTrace.o(3906675408896L, 29107);
      return 0;
    }
    GMTrace.o(3906675408896L, 29107);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/agp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */