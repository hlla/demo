package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bjq
  extends avm
{
  public int tVz;
  public int uhv;
  public LinkedList<bjn> uhw;
  public int uhx;
  
  public bjq()
  {
    GMTrace.i(3929626640384L, 29278);
    this.uhw = new LinkedList();
    GMTrace.o(3929626640384L, 29278);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3929760858112L, 29279);
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
      paramVarArgs.eO(2, this.uhv);
      paramVarArgs.d(3, 8, this.uhw);
      paramVarArgs.eO(4, this.tVz);
      paramVarArgs.eO(5, this.uhx);
      GMTrace.o(3929760858112L, 29279);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = a.a.a.a.eL(2, this.uhv);
      int j = a.a.a.a.c(3, 8, this.uhw);
      int k = a.a.a.a.eL(4, this.tVz);
      int m = a.a.a.a.eL(5, this.uhx);
      GMTrace.o(3929760858112L, 29279);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uhw.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3929760858112L, 29279);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bjq localbjq = (bjq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3929760858112L, 29279);
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
          localbjq.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3929760858112L, 29279);
        return 0;
      case 2: 
        localbjq.uhv = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3929760858112L, 29279);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjn();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjn)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbjq.uhw.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3929760858112L, 29279);
        return 0;
      case 4: 
        localbjq.tVz = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3929760858112L, 29279);
        return 0;
      }
      localbjq.uhx = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3929760858112L, 29279);
      return 0;
    }
    GMTrace.o(3929760858112L, 29279);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bjq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */