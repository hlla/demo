package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aev
  extends com.tencent.mm.bd.a
{
  public int tIw;
  
  public aev()
  {
    GMTrace.i(13096965898240L, 97580);
    GMTrace.o(13096965898240L, 97580);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13097100115968L, 97581);
    if (paramInt == 0)
    {
      ((a.a.a.c.a)paramVarArgs[0]).eO(1, this.tIw);
      GMTrace.o(13097100115968L, 97581);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tIw);
      GMTrace.o(13097100115968L, 97581);
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
      GMTrace.o(13097100115968L, 97581);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      aev localaev = (aev)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13097100115968L, 97581);
        return -1;
      }
      localaev.tIw = locala.xky.mL();
      GMTrace.o(13097100115968L, 97581);
      return 0;
    }
    GMTrace.o(13097100115968L, 97581);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */