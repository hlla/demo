package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class sr
  extends com.tencent.mm.bd.a
{
  public LinkedList<gs> tjh;
  public gq tyW;
  
  public sr()
  {
    GMTrace.i(3842250899456L, 28627);
    this.tjh = new LinkedList();
    GMTrace.o(3842250899456L, 28627);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3842385117184L, 28628);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tyW != null)
      {
        paramVarArgs.eQ(1, this.tyW.aUd());
        this.tyW.a(paramVarArgs);
      }
      paramVarArgs.d(2, 8, this.tjh);
      GMTrace.o(3842385117184L, 28628);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tyW != null) {
        paramInt = a.a.a.a.eN(1, this.tyW.aUd()) + 0;
      }
      i = a.a.a.a.c(2, 8, this.tjh);
      GMTrace.o(3842385117184L, 28628);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tjh.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3842385117184L, 28628);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      sr localsr = (sr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3842385117184L, 28628);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gq();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((gq)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localsr.tyW = ((gq)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3842385117184L, 28628);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new gs();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((gs)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localsr.tjh.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(3842385117184L, 28628);
      return 0;
    }
    GMTrace.o(3842385117184L, 28628);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/sr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */