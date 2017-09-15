package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aos
  extends com.tencent.mm.bd.a
{
  public lu tRg;
  
  public aos()
  {
    GMTrace.i(13338423590912L, 99379);
    GMTrace.o(13338423590912L, 99379);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13338557808640L, 99380);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tRg == null) {
        throw new b("Not all required fields were included: Oplog");
      }
      if (this.tRg != null)
      {
        paramVarArgs.eQ(1, this.tRg.aUd());
        this.tRg.a(paramVarArgs);
      }
      GMTrace.o(13338557808640L, 99380);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tRg != null) {
        paramInt = a.a.a.a.eN(1, this.tRg.aUd()) + 0;
      }
      GMTrace.o(13338557808640L, 99380);
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
      if (this.tRg == null) {
        throw new b("Not all required fields were included: Oplog");
      }
      GMTrace.o(13338557808640L, 99380);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aos localaos = (aos)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13338557808640L, 99380);
        return -1;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new lu();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((lu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localaos.tRg = ((lu)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13338557808640L, 99380);
      return 0;
    }
    GMTrace.o(13338557808640L, 99380);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */