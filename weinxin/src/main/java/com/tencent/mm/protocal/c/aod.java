package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aod
  extends com.tencent.mm.bd.a
{
  public int tRC;
  public String tRD;
  public avt tRE;
  public int tRF;
  public com.tencent.mm.bd.b tgU;
  
  public aod()
  {
    GMTrace.i(3840640286720L, 28615);
    GMTrace.o(3840640286720L, 28615);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3840774504448L, 28616);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tRE == null) {
        throw new a.a.a.b("Not all required fields were included: ClientKey");
      }
      paramVarArgs.eO(1, this.tRC);
      if (this.tgU != null) {
        paramVarArgs.b(2, this.tgU);
      }
      if (this.tRD != null) {
        paramVarArgs.e(3, this.tRD);
      }
      if (this.tRE != null)
      {
        paramVarArgs.eQ(4, this.tRE.aUd());
        this.tRE.a(paramVarArgs);
      }
      paramVarArgs.eO(5, this.tRF);
      GMTrace.o(3840774504448L, 28616);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tRC) + 0;
      paramInt = i;
      if (this.tgU != null) {
        paramInt = i + a.a.a.a.a(2, this.tgU);
      }
      i = paramInt;
      if (this.tRD != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tRD);
      }
      paramInt = i;
      if (this.tRE != null) {
        paramInt = i + a.a.a.a.eN(4, this.tRE.aUd());
      }
      i = a.a.a.a.eL(5, this.tRF);
      GMTrace.o(3840774504448L, 28616);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tRE == null) {
        throw new a.a.a.b("Not all required fields were included: ClientKey");
      }
      GMTrace.o(3840774504448L, 28616);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aod localaod = (aod)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3840774504448L, 28616);
        return -1;
      case 1: 
        localaod.tRC = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3840774504448L, 28616);
        return 0;
      case 2: 
        localaod.tgU = ((a.a.a.a.a)localObject1).chR();
        GMTrace.o(3840774504448L, 28616);
        return 0;
      case 3: 
        localaod.tRD = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3840774504448L, 28616);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaod.tRE = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3840774504448L, 28616);
        return 0;
      }
      localaod.tRF = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3840774504448L, 28616);
      return 0;
    }
    GMTrace.o(3840774504448L, 28616);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */