package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class sc
  extends com.tencent.mm.bd.a
{
  public LinkedList<String> txO;
  public LinkedList<String> txP;
  
  public sc()
  {
    GMTrace.i(3892314112000L, 29000);
    this.txO = new LinkedList();
    this.txP = new LinkedList();
    GMTrace.o(3892314112000L, 29000);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3892448329728L, 29001);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 1, this.txO);
      paramVarArgs.d(2, 1, this.txP);
      GMTrace.o(3892448329728L, 29001);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.c(1, 1, this.txO);
      int i = a.a.a.a.c(2, 1, this.txP);
      GMTrace.o(3892448329728L, 29001);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.txO.clear();
      this.txP.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3892448329728L, 29001);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      sc localsc = (sc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3892448329728L, 29001);
        return -1;
      case 1: 
        localsc.txO.add(locala.xky.readString());
        GMTrace.o(3892448329728L, 29001);
        return 0;
      }
      localsc.txP.add(locala.xky.readString());
      GMTrace.o(3892448329728L, 29001);
      return 0;
    }
    GMTrace.o(3892448329728L, 29001);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/sc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */