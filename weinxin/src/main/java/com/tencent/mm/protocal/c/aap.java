package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aap
  extends ave
{
  public int tES;
  public int tay;
  public avu trH;
  
  public aap()
  {
    GMTrace.i(3871510364160L, 28845);
    GMTrace.o(3871510364160L, 28845);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3871644581888L, 28846);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trH == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.trH != null)
      {
        paramVarArgs.eQ(2, this.trH.aUd());
        this.trH.a(paramVarArgs);
      }
      paramVarArgs.eO(3, this.tES);
      paramVarArgs.eO(4, this.tay);
      GMTrace.o(3871644581888L, 28846);
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
      if (this.trH != null) {
        i = paramInt + a.a.a.a.eN(2, this.trH.aUd());
      }
      paramInt = a.a.a.a.eL(3, this.tES);
      int j = a.a.a.a.eL(4, this.tay);
      GMTrace.o(3871644581888L, 28846);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.trH == null) {
        throw new b("Not all required fields were included: UserName");
      }
      GMTrace.o(3871644581888L, 28846);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aap localaap = (aap)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3871644581888L, 28846);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localaap.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3871644581888L, 28846);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localaap.trH = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3871644581888L, 28846);
        return 0;
      case 3: 
        localaap.tES = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3871644581888L, 28846);
        return 0;
      }
      localaap.tay = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3871644581888L, 28846);
      return 0;
    }
    GMTrace.o(3871644581888L, 28846);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */