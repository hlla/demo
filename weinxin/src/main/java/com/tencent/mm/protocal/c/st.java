package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class st
  extends com.tencent.mm.bd.a
{
  public int tyY;
  public int tyZ;
  
  public st()
  {
    GMTrace.i(3734876717056L, 27827);
    GMTrace.o(3734876717056L, 27827);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3735010934784L, 27828);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tyY);
      paramVarArgs.eO(2, this.tyZ);
      GMTrace.o(3735010934784L, 27828);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tyY);
      int i = a.a.a.a.eL(2, this.tyZ);
      GMTrace.o(3735010934784L, 27828);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3735010934784L, 27828);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      st localst = (st)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3735010934784L, 27828);
        return -1;
      case 1: 
        localst.tyY = locala.xky.mL();
        GMTrace.o(3735010934784L, 27828);
        return 0;
      }
      localst.tyZ = locala.xky.mL();
      GMTrace.o(3735010934784L, 27828);
      return 0;
    }
    GMTrace.o(3735010934784L, 27828);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/st.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */