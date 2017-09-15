package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ol
  extends avm
{
  public long tdE;
  public int tdw;
  public int tfd;
  public int tfe;
  public avt tqC;
  
  public ol()
  {
    GMTrace.i(3774336729088L, 28121);
    GMTrace.o(3774336729088L, 28121);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3774470946816L, 28122);
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
      paramVarArgs.eO(2, this.tdw);
      paramVarArgs.eO(3, this.tfd);
      paramVarArgs.eO(4, this.tfe);
      if (this.tqC != null)
      {
        paramVarArgs.eQ(5, this.tqC.aUd());
        this.tqC.a(paramVarArgs);
      }
      paramVarArgs.O(6, this.tdE);
      GMTrace.o(3774470946816L, 28122);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tdw) + a.a.a.a.eL(3, this.tfd) + a.a.a.a.eL(4, this.tfe);
      paramInt = i;
      if (this.tqC != null) {
        paramInt = i + a.a.a.a.eN(5, this.tqC.aUd());
      }
      i = a.a.a.a.N(6, this.tdE);
      GMTrace.o(3774470946816L, 28122);
      return paramInt + i;
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
      GMTrace.o(3774470946816L, 28122);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ol localol = (ol)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3774470946816L, 28122);
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
          localol.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3774470946816L, 28122);
        return 0;
      case 2: 
        localol.tdw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3774470946816L, 28122);
        return 0;
      case 3: 
        localol.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3774470946816L, 28122);
        return 0;
      case 4: 
        localol.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3774470946816L, 28122);
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
          localol.tqC = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3774470946816L, 28122);
        return 0;
      }
      localol.tdE = ((a.a.a.a.a)localObject1).xky.mM();
      GMTrace.o(3774470946816L, 28122);
      return 0;
    }
    GMTrace.o(3774470946816L, 28122);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */