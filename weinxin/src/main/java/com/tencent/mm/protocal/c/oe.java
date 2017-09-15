package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class oe
  extends com.tencent.mm.bd.a
{
  public int tsh;
  public int tsi;
  
  public oe()
  {
    GMTrace.i(13341107945472L, 99399);
    GMTrace.o(13341107945472L, 99399);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13341242163200L, 99400);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tsh);
      paramVarArgs.eO(2, this.tsi);
      GMTrace.o(13341242163200L, 99400);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tsh);
      int i = a.a.a.a.eL(2, this.tsi);
      GMTrace.o(13341242163200L, 99400);
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
      GMTrace.o(13341242163200L, 99400);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      oe localoe = (oe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13341242163200L, 99400);
        return -1;
      case 1: 
        localoe.tsh = locala.xky.mL();
        GMTrace.o(13341242163200L, 99400);
        return 0;
      }
      localoe.tsi = locala.xky.mL();
      GMTrace.o(13341242163200L, 99400);
      return 0;
    }
    GMTrace.o(13341242163200L, 99400);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/oe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */