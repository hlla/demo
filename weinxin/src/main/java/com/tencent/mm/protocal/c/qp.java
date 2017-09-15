package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class qp
  extends com.tencent.mm.bd.a
{
  public String mqI;
  public long oST;
  public int tuK;
  
  public qp()
  {
    GMTrace.i(4033242726400L, 30050);
    GMTrace.o(4033242726400L, 30050);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4033376944128L, 30051);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.O(1, this.oST);
      if (this.mqI != null) {
        paramVarArgs.e(2, this.mqI);
      }
      paramVarArgs.eO(3, this.tuK);
      GMTrace.o(4033376944128L, 30051);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.N(1, this.oST) + 0;
      paramInt = i;
      if (this.mqI != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.mqI);
      }
      i = a.a.a.a.eL(3, this.tuK);
      GMTrace.o(4033376944128L, 30051);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4033376944128L, 30051);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      qp localqp = (qp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(4033376944128L, 30051);
        return -1;
      case 1: 
        localqp.oST = locala.xky.mM();
        GMTrace.o(4033376944128L, 30051);
        return 0;
      case 2: 
        localqp.mqI = locala.xky.readString();
        GMTrace.o(4033376944128L, 30051);
        return 0;
      }
      localqp.tuK = locala.xky.mL();
      GMTrace.o(4033376944128L, 30051);
      return 0;
    }
    GMTrace.o(4033376944128L, 30051);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/qp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */