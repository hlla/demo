package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bjl
  extends com.tencent.mm.bd.a
{
  public int tfe;
  public int uhn;
  public int uho;
  public avt uhp;
  
  public bjl()
  {
    GMTrace.i(4042369531904L, 30118);
    GMTrace.o(4042369531904L, 30118);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4042503749632L, 30119);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.uhp == null) {
        throw new b("Not all required fields were included: PieceData");
      }
      paramVarArgs.eO(1, this.tfe);
      paramVarArgs.eO(2, this.uhn);
      paramVarArgs.eO(3, this.uho);
      if (this.uhp != null)
      {
        paramVarArgs.eQ(4, this.uhp.aUd());
        this.uhp.a(paramVarArgs);
      }
      GMTrace.o(4042503749632L, 30119);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tfe) + 0 + a.a.a.a.eL(2, this.uhn) + a.a.a.a.eL(3, this.uho);
      paramInt = i;
      if (this.uhp != null) {
        paramInt = i + a.a.a.a.eN(4, this.uhp.aUd());
      }
      GMTrace.o(4042503749632L, 30119);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.uhp == null) {
        throw new b("Not all required fields were included: PieceData");
      }
      GMTrace.o(4042503749632L, 30119);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bjl localbjl = (bjl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4042503749632L, 30119);
        return -1;
      case 1: 
        localbjl.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4042503749632L, 30119);
        return 0;
      case 2: 
        localbjl.uhn = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4042503749632L, 30119);
        return 0;
      case 3: 
        localbjl.uho = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4042503749632L, 30119);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localbjl.uhp = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(4042503749632L, 30119);
      return 0;
    }
    GMTrace.o(4042503749632L, 30119);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bjl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */