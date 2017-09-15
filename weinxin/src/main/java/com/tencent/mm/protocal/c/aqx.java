package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aqx
  extends com.tencent.mm.bd.a
{
  public int tTJ;
  public int tTK;
  public String tTL;
  
  public aqx()
  {
    GMTrace.i(16869557796864L, 125688);
    GMTrace.o(16869557796864L, 125688);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(16869692014592L, 125689);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tTJ);
      paramVarArgs.eO(2, this.tTK);
      if (this.tTL != null) {
        paramVarArgs.e(3, this.tTL);
      }
      GMTrace.o(16869692014592L, 125689);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.tTJ) + 0 + a.a.a.a.eL(2, this.tTK);
      paramInt = i;
      if (this.tTL != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.tTL);
      }
      GMTrace.o(16869692014592L, 125689);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(16869692014592L, 125689);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      aqx localaqx = (aqx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(16869692014592L, 125689);
        return -1;
      case 1: 
        localaqx.tTJ = locala.xky.mL();
        GMTrace.o(16869692014592L, 125689);
        return 0;
      case 2: 
        localaqx.tTK = locala.xky.mL();
        GMTrace.o(16869692014592L, 125689);
        return 0;
      }
      localaqx.tTL = locala.xky.readString();
      GMTrace.o(16869692014592L, 125689);
      return 0;
    }
    GMTrace.o(16869692014592L, 125689);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aqx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */