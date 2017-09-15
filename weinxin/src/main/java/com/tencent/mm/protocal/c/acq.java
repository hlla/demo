package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class acq
  extends avm
{
  public bjp tpR;
  public ast tpT;
  
  public acq()
  {
    GMTrace.i(3726555217920L, 27765);
    GMTrace.o(3726555217920L, 27765);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3726689435648L, 27766);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tpR == null) {
        throw new b("Not all required fields were included: TransRes");
      }
      if (this.tpT == null) {
        throw new b("Not all required fields were included: QueryCtx");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tpR != null)
      {
        paramVarArgs.eQ(2, this.tpR.aUd());
        this.tpR.a(paramVarArgs);
      }
      if (this.tpT != null)
      {
        paramVarArgs.eQ(3, this.tpT.aUd());
        this.tpT.a(paramVarArgs);
      }
      GMTrace.o(3726689435648L, 27766);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXs != null) {
        i = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      paramInt = i;
      if (this.tpR != null) {
        paramInt = i + a.a.a.a.eN(2, this.tpR.aUd());
      }
      i = paramInt;
      if (this.tpT != null) {
        i = paramInt + a.a.a.a.eN(3, this.tpT.aUd());
      }
      GMTrace.o(3726689435648L, 27766);
      return i;
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
      if (this.tpR == null) {
        throw new b("Not all required fields were included: TransRes");
      }
      if (this.tpT == null) {
        throw new b("Not all required fields were included: QueryCtx");
      }
      GMTrace.o(3726689435648L, 27766);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      acq localacq = (acq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3726689435648L, 27766);
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
          localacq.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3726689435648L, 27766);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjp();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjp)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localacq.tpR = ((bjp)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3726689435648L, 27766);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ast();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ast)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localacq.tpT = ((ast)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3726689435648L, 27766);
      return 0;
    }
    GMTrace.o(3726689435648L, 27766);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/acq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */