package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class by
  extends com.tencent.mm.bd.a
{
  public ajg tdL;
  
  public by()
  {
    GMTrace.i(13338692026368L, 99381);
    GMTrace.o(13338692026368L, 99381);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13338826244096L, 99382);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tdL != null)
      {
        paramVarArgs.eQ(1, this.tdL.aUd());
        this.tdL.a(paramVarArgs);
      }
      GMTrace.o(13338826244096L, 99382);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tdL != null) {
        paramInt = a.a.a.a.eN(1, this.tdL.aUd()) + 0;
      }
      GMTrace.o(13338826244096L, 99382);
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
      GMTrace.o(13338826244096L, 99382);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      by localby = (by)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13338826244096L, 99382);
        return -1;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ajg();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ajg)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localby.tdL = ((ajg)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13338826244096L, 99382);
      return 0;
    }
    GMTrace.o(13338826244096L, 99382);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */