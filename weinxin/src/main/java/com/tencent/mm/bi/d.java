package com.tencent.mm.bi;

import com.tencent.gmtrace.GMTrace;

public final class d
  extends com.tencent.mm.bd.a
{
  public int max;
  public int rNq;
  
  public d()
  {
    GMTrace.i(4518037159936L, 33662);
    GMTrace.o(4518037159936L, 33662);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4518171377664L, 33663);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.rNq);
      paramVarArgs.eO(2, this.max);
      GMTrace.o(4518171377664L, 33663);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.rNq);
      int i = a.a.a.a.eL(2, this.max);
      GMTrace.o(4518171377664L, 33663);
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
      GMTrace.o(4518171377664L, 33663);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(4518171377664L, 33663);
        return -1;
      case 1: 
        locald.rNq = locala.xky.mL();
        GMTrace.o(4518171377664L, 33663);
        return 0;
      }
      locald.max = locala.xky.mL();
      GMTrace.o(4518171377664L, 33663);
      return 0;
    }
    GMTrace.o(4518171377664L, 33663);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bi/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */