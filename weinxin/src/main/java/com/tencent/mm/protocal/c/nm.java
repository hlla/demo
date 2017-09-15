package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class nm
  extends com.tencent.mm.bd.a
{
  public int jLr;
  public avu trH;
  public LinkedList<Integer> trO;
  
  public nm()
  {
    GMTrace.i(13336544542720L, 99365);
    this.trO = new LinkedList();
    GMTrace.o(13336544542720L, 99365);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13336678760448L, 99366);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trH == null) {
        throw new a.a.a.b("Not all required fields were included: UserName");
      }
      if (this.trH != null)
      {
        paramVarArgs.eQ(1, this.trH.aUd());
        this.trH.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.jLr);
      paramVarArgs.c(3, this.trO);
      GMTrace.o(13336678760448L, 99366);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.trH != null) {
        paramInt = a.a.a.a.eN(1, this.trH.aUd()) + 0;
      }
      i = a.a.a.a.eL(2, this.jLr);
      int j = a.a.a.a.b(3, this.trO);
      GMTrace.o(13336678760448L, 99366);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.trO.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.trH == null) {
        throw new a.a.a.b("Not all required fields were included: UserName");
      }
      GMTrace.o(13336678760448L, 99366);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      nm localnm = (nm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13336678760448L, 99366);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localnm.trH = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13336678760448L, 99366);
        return 0;
      case 2: 
        localnm.jLr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13336678760448L, 99366);
        return 0;
      }
      localnm.trO = new a.a.a.a.a(((a.a.a.a.a)localObject1).chR().sWU, unknownTagHandler).chO();
      GMTrace.o(13336678760448L, 99366);
      return 0;
    }
    GMTrace.o(13336678760448L, 99366);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/nm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */