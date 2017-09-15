package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class abz
  extends avm
{
  public int tfd;
  public int tfe;
  public int tff;
  public avt tqC;
  
  public abz()
  {
    GMTrace.i(3633810767872L, 27074);
    GMTrace.o(3633810767872L, 27074);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3633944985600L, 27075);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tfd);
      paramVarArgs.eO(3, this.tfe);
      paramVarArgs.eO(4, this.tff);
      if (this.tqC != null)
      {
        paramVarArgs.eQ(5, this.tqC.aUd());
        this.tqC.a(paramVarArgs);
      }
      GMTrace.o(3633944985600L, 27075);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tfd) + a.a.a.a.eL(3, this.tfe) + a.a.a.a.eL(4, this.tff);
      paramInt = i;
      if (this.tqC != null) {
        paramInt = i + a.a.a.a.eN(5, this.tqC.aUd());
      }
      GMTrace.o(3633944985600L, 27075);
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
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      GMTrace.o(3633944985600L, 27075);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      abz localabz = (abz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3633944985600L, 27075);
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
          localabz.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3633944985600L, 27075);
        return 0;
      case 2: 
        localabz.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3633944985600L, 27075);
        return 0;
      case 3: 
        localabz.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3633944985600L, 27075);
        return 0;
      case 4: 
        localabz.tff = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3633944985600L, 27075);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localabz.tqC = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3633944985600L, 27075);
      return 0;
    }
    GMTrace.o(3633944985600L, 27075);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/abz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */