package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class xd
  extends avm
{
  public int tCj;
  public LinkedList<amb> tCk;
  public LinkedList<Integer> tCl;
  public LinkedList<bjc> tCm;
  
  public xd()
  {
    GMTrace.i(3673807650816L, 27372);
    this.tCk = new LinkedList();
    this.tCl = new LinkedList();
    this.tCm = new LinkedList();
    GMTrace.o(3673807650816L, 27372);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3673941868544L, 27373);
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
      paramVarArgs.eO(2, this.tCj);
      paramVarArgs.d(3, 8, this.tCk);
      paramVarArgs.c(4, this.tCl);
      paramVarArgs.d(5, 8, this.tCm);
      GMTrace.o(3673941868544L, 27373);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = a.a.a.a.eL(2, this.tCj);
      int j = a.a.a.a.c(3, 8, this.tCk);
      int k = a.a.a.a.b(4, this.tCl);
      int m = a.a.a.a.c(5, 8, this.tCm);
      GMTrace.o(3673941868544L, 27373);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tCk.clear();
      this.tCl.clear();
      this.tCm.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new a.a.a.b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3673941868544L, 27373);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      xd localxd = (xd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3673941868544L, 27373);
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
          localxd.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3673941868544L, 27373);
        return 0;
      case 2: 
        localxd.tCj = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3673941868544L, 27373);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new amb();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((amb)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localxd.tCk.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3673941868544L, 27373);
        return 0;
      case 4: 
        localxd.tCl = new a.a.a.a.a(((a.a.a.a.a)localObject1).chR().sWU, unknownTagHandler).chO();
        GMTrace.o(3673941868544L, 27373);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bjc();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bjc)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localxd.tCm.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(3673941868544L, 27373);
      return 0;
    }
    GMTrace.o(3673941868544L, 27373);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/xd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */