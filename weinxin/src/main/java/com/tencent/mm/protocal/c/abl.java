package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class abl
  extends avm
{
  public int jLr;
  public LinkedList<avu> jLs;
  public avt tFA;
  public int tFB;
  public String tFx;
  
  public abl()
  {
    GMTrace.i(4001164689408L, 29811);
    this.jLs = new LinkedList();
    GMTrace.o(4001164689408L, 29811);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4001298907136L, 29812);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.jLr);
      paramVarArgs.d(3, 8, this.jLs);
      if (this.tFx != null) {
        paramVarArgs.e(4, this.tFx);
      }
      if (this.tFA != null)
      {
        paramVarArgs.eQ(5, this.tFA.aUd());
        this.tFA.a(paramVarArgs);
      }
      paramVarArgs.eO(6, this.tFB);
      GMTrace.o(4001298907136L, 29812);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.jLr) + a.a.a.a.c(3, 8, this.jLs);
      paramInt = i;
      if (this.tFx != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tFx);
      }
      i = paramInt;
      if (this.tFA != null) {
        i = paramInt + a.a.a.a.eN(5, this.tFA.aUd());
      }
      paramInt = a.a.a.a.eL(6, this.tFB);
      GMTrace.o(4001298907136L, 29812);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.jLs.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(4001298907136L, 29812);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      abl localabl = (abl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(4001298907136L, 29812);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localabl.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4001298907136L, 29812);
        return 0;
      case 2: 
        localabl.jLr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4001298907136L, 29812);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localabl.jLs.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(4001298907136L, 29812);
        return 0;
      case 4: 
        localabl.tFx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4001298907136L, 29812);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localabl.tFA = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4001298907136L, 29812);
        return 0;
      }
      localabl.tFB = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(4001298907136L, 29812);
      return 0;
    }
    GMTrace.o(4001298907136L, 29812);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/abl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */