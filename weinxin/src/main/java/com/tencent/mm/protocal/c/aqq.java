package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aqq
  extends com.tencent.mm.bd.a
{
  public int jLr;
  public LinkedList<aqp> jLs;
  
  public aqq()
  {
    GMTrace.i(13585384210432L, 101219);
    this.jLs = new LinkedList();
    GMTrace.o(13585384210432L, 101219);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13585518428160L, 101220);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.jLr);
      paramVarArgs.d(2, 8, this.jLs);
      GMTrace.o(13585518428160L, 101220);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.jLr);
      i = a.a.a.a.c(2, 8, this.jLs);
      GMTrace.o(13585518428160L, 101220);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.jLs.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13585518428160L, 101220);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aqq localaqq = (aqq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13585518428160L, 101220);
        return -1;
      case 1: 
        localaqq.jLr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13585518428160L, 101220);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aqp();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((aqp)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localaqq.jLs.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(13585518428160L, 101220);
      return 0;
    }
    GMTrace.o(13585518428160L, 101220);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aqq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */