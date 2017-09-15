package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class amw
  extends com.tencent.mm.bd.a
{
  public int tPR;
  public int tPS;
  
  public amw()
  {
    GMTrace.i(13098173857792L, 97589);
    GMTrace.o(13098173857792L, 97589);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13098308075520L, 97590);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tPR);
      paramVarArgs.eO(2, this.tPS);
      GMTrace.o(13098308075520L, 97590);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tPR);
      int i = a.a.a.a.eL(2, this.tPS);
      GMTrace.o(13098308075520L, 97590);
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
      GMTrace.o(13098308075520L, 97590);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      amw localamw = (amw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13098308075520L, 97590);
        return -1;
      case 1: 
        localamw.tPR = locala.xky.mL();
        GMTrace.o(13098308075520L, 97590);
        return 0;
      }
      localamw.tPS = locala.xky.mL();
      GMTrace.o(13098308075520L, 97590);
      return 0;
    }
    GMTrace.o(13098308075520L, 97590);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/amw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */