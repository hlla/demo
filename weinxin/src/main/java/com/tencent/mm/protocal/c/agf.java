package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class agf
  extends avm
{
  public int jLr;
  public LinkedList<Integer> tJA;
  
  public agf()
  {
    GMTrace.i(4005728092160L, 29845);
    this.tJA = new LinkedList();
    GMTrace.o(4005728092160L, 29845);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4005862309888L, 29846);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new a.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.jLr);
      paramVarArgs.c(3, this.tJA);
      GMTrace.o(4005862309888L, 29846);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = a.a.a.a.eL(2, this.jLr);
      int j = a.a.a.a.b(3, this.tJA);
      GMTrace.o(4005862309888L, 29846);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tJA.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new a.a.a.b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(4005862309888L, 29846);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      agf localagf = (agf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4005862309888L, 29846);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localagf.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4005862309888L, 29846);
        return 0;
      case 2: 
        localagf.jLr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4005862309888L, 29846);
        return 0;
      }
      localagf.tJA = new a.a.a.a.a(((a.a.a.a.a)localObject1).chR().sWU, unknownTagHandler).chO();
      GMTrace.o(4005862309888L, 29846);
      return 0;
    }
    GMTrace.o(4005862309888L, 29846);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/agf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */