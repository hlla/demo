package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bqv
  extends avm
{
  public int unl;
  public String unm;
  
  public bqv()
  {
    GMTrace.i(3990964142080L, 29735);
    GMTrace.o(3990964142080L, 29735);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3991098359808L, 29736);
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
      paramVarArgs.eO(2, this.unl);
      if (this.unm != null) {
        paramVarArgs.e(3, this.unm);
      }
      GMTrace.o(3991098359808L, 29736);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.unl);
      paramInt = i;
      if (this.unm != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.unm);
      }
      GMTrace.o(3991098359808L, 29736);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3991098359808L, 29736);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bqv localbqv = (bqv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3991098359808L, 29736);
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
          localbqv.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3991098359808L, 29736);
        return 0;
      case 2: 
        localbqv.unl = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3991098359808L, 29736);
        return 0;
      }
      localbqv.unm = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3991098359808L, 29736);
      return 0;
    }
    GMTrace.o(3991098359808L, 29736);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bqv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */