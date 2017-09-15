package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class nl
  extends com.tencent.mm.bd.a
{
  public avu trN;
  
  public nl()
  {
    GMTrace.i(3866678525952L, 28809);
    GMTrace.o(3866678525952L, 28809);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3866812743680L, 28810);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trN == null) {
        throw new b("Not all required fields were included: MemberName");
      }
      if (this.trN != null)
      {
        paramVarArgs.eQ(1, this.trN.aUd());
        this.trN.a(paramVarArgs);
      }
      GMTrace.o(3866812743680L, 28810);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.trN != null) {
        paramInt = a.a.a.a.eN(1, this.trN.aUd()) + 0;
      }
      GMTrace.o(3866812743680L, 28810);
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
      if (this.trN == null) {
        throw new b("Not all required fields were included: MemberName");
      }
      GMTrace.o(3866812743680L, 28810);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      nl localnl = (nl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3866812743680L, 28810);
        return -1;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avu();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localnl.trN = ((avu)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3866812743680L, 28810);
      return 0;
    }
    GMTrace.o(3866812743680L, 28810);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/nl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */