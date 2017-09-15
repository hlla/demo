package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class eb
  extends com.tencent.mm.bd.a
{
  public long endTime;
  public long startTime;
  
  public eb()
  {
    GMTrace.i(17868674564096L, 133132);
    GMTrace.o(17868674564096L, 133132);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(17868808781824L, 133133);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.O(1, this.startTime);
      paramVarArgs.O(2, this.endTime);
      GMTrace.o(17868808781824L, 133133);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.N(1, this.startTime);
      int i = a.a.a.a.N(2, this.endTime);
      GMTrace.o(17868808781824L, 133133);
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
      GMTrace.o(17868808781824L, 133133);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      eb localeb = (eb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(17868808781824L, 133133);
        return -1;
      case 1: 
        localeb.startTime = locala.xky.mM();
        GMTrace.o(17868808781824L, 133133);
        return 0;
      }
      localeb.endTime = locala.xky.mM();
      GMTrace.o(17868808781824L, 133133);
      return 0;
    }
    GMTrace.o(17868808781824L, 133133);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */