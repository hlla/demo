package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class mz
  extends com.tencent.mm.bd.a
{
  public long trG;
  
  public mz()
  {
    GMTrace.i(3768431149056L, 28077);
    GMTrace.o(3768431149056L, 28077);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3768565366784L, 28078);
    if (paramInt == 0)
    {
      ((a.a.a.c.a)paramVarArgs[0]).O(1, this.trG);
      GMTrace.o(3768565366784L, 28078);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.N(1, this.trG);
      GMTrace.o(3768565366784L, 28078);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3768565366784L, 28078);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      mz localmz = (mz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3768565366784L, 28078);
        return -1;
      }
      localmz.trG = locala.xky.mM();
      GMTrace.o(3768565366784L, 28078);
      return 0;
    }
    GMTrace.o(3768565366784L, 28078);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/mz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */