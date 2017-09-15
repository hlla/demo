package com.tencent.mm.ap;

import com.tencent.gmtrace.GMTrace;

public final class g
  extends com.tencent.mm.bd.a
{
  public int hND;
  public int hNO;
  public int hNP;
  
  public g()
  {
    GMTrace.i(12948923744256L, 96477);
    GMTrace.o(12948923744256L, 96477);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(12949057961984L, 96478);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.hND);
      paramVarArgs.eO(2, this.hNO);
      paramVarArgs.eO(3, this.hNP);
      GMTrace.o(12949057961984L, 96478);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.hND);
      int i = a.a.a.a.eL(2, this.hNO);
      int j = a.a.a.a.eL(3, this.hNP);
      GMTrace.o(12949057961984L, 96478);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(12949057961984L, 96478);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(12949057961984L, 96478);
        return -1;
      case 1: 
        localg.hND = locala.xky.mL();
        GMTrace.o(12949057961984L, 96478);
        return 0;
      case 2: 
        localg.hNO = locala.xky.mL();
        GMTrace.o(12949057961984L, 96478);
        return 0;
      }
      localg.hNP = locala.xky.mL();
      GMTrace.o(12949057961984L, 96478);
      return 0;
    }
    GMTrace.o(12949057961984L, 96478);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */