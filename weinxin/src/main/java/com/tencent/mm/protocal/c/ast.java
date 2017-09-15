package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ast
  extends com.tencent.mm.bd.a
{
  public int tVz;
  
  public ast()
  {
    GMTrace.i(3921842012160L, 29220);
    GMTrace.o(3921842012160L, 29220);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3921976229888L, 29221);
    if (paramInt == 0)
    {
      ((a.a.a.c.a)paramVarArgs[0]).eO(1, this.tVz);
      GMTrace.o(3921976229888L, 29221);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tVz);
      GMTrace.o(3921976229888L, 29221);
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
      GMTrace.o(3921976229888L, 29221);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      ast localast = (ast)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3921976229888L, 29221);
        return -1;
      }
      localast.tVz = locala.xky.mL();
      GMTrace.o(3921976229888L, 29221);
      return 0;
    }
    GMTrace.o(3921976229888L, 29221);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */