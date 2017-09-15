package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class dd
  extends com.tencent.mm.bd.a
{
  public int teP;
  public int teQ;
  public int teX;
  public de teY;
  
  public dd()
  {
    GMTrace.i(4031900549120L, 30040);
    GMTrace.o(4031900549120L, 30040);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4032034766848L, 30041);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.teP);
      paramVarArgs.eO(2, this.teQ);
      paramVarArgs.eO(3, this.teX);
      if (this.teY != null)
      {
        paramVarArgs.eQ(4, this.teY.aUd());
        this.teY.a(paramVarArgs);
      }
      GMTrace.o(4032034766848L, 30041);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.teP) + 0 + a.a.a.a.eL(2, this.teQ) + a.a.a.a.eL(3, this.teX);
      paramInt = i;
      if (this.teY != null) {
        paramInt = i + a.a.a.a.eN(4, this.teY.aUd());
      }
      GMTrace.o(4032034766848L, 30041);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4032034766848L, 30041);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      dd localdd = (dd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4032034766848L, 30041);
        return -1;
      case 1: 
        localdd.teP = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4032034766848L, 30041);
        return 0;
      case 2: 
        localdd.teQ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4032034766848L, 30041);
        return 0;
      case 3: 
        localdd.teX = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4032034766848L, 30041);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new de();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((de)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localdd.teY = ((de)localObject1);
        paramInt += 1;
      }
      GMTrace.o(4032034766848L, 30041);
      return 0;
    }
    GMTrace.o(4032034766848L, 30041);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */