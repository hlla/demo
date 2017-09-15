package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bor
  extends com.tencent.mm.bd.a
{
  public long ulA;
  public ho ulB;
  
  public bor()
  {
    GMTrace.i(17827603939328L, 132826);
    GMTrace.o(17827603939328L, 132826);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(17827738157056L, 132827);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.O(1, this.ulA);
      if (this.ulB != null)
      {
        paramVarArgs.eQ(2, this.ulB.aUd());
        this.ulB.a(paramVarArgs);
      }
      GMTrace.o(17827738157056L, 132827);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.N(1, this.ulA) + 0;
      paramInt = i;
      if (this.ulB != null) {
        paramInt = i + a.a.a.a.eN(2, this.ulB.aUd());
      }
      GMTrace.o(17827738157056L, 132827);
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
      GMTrace.o(17827738157056L, 132827);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bor localbor = (bor)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(17827738157056L, 132827);
        return -1;
      case 1: 
        localbor.ulA = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17827738157056L, 132827);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ho();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ho)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localbor.ulB = ((ho)localObject1);
        paramInt += 1;
      }
      GMTrace.o(17827738157056L, 132827);
      return 0;
    }
    GMTrace.o(17827738157056L, 132827);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */