package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ayn
  extends ave
{
  public String mqG;
  public int tYN;
  public String tYO;
  
  public ayn()
  {
    GMTrace.i(3806951636992L, 28364);
    GMTrace.o(3806951636992L, 28364);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3807085854720L, 28365);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.mqG != null) {
        paramVarArgs.e(2, this.mqG);
      }
      paramVarArgs.eO(3, this.tYN);
      if (this.tYO != null) {
        paramVarArgs.e(4, this.tYO);
      }
      GMTrace.o(3807085854720L, 28365);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt;
      if (this.mqG != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.mqG);
      }
      i += a.a.a.a.eL(3, this.tYN);
      paramInt = i;
      if (this.tYO != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tYO);
      }
      GMTrace.o(3807085854720L, 28365);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3807085854720L, 28365);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ayn localayn = (ayn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3807085854720L, 28365);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localayn.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3807085854720L, 28365);
        return 0;
      case 2: 
        localayn.mqG = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3807085854720L, 28365);
        return 0;
      case 3: 
        localayn.tYN = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3807085854720L, 28365);
        return 0;
      }
      localayn.tYO = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3807085854720L, 28365);
      return 0;
    }
    GMTrace.o(3807085854720L, 28365);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ayn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */