package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class gt
  extends com.tencent.mm.bd.a
{
  public LinkedList<gs> tjh;
  
  public gt()
  {
    GMTrace.i(3968281346048L, 29566);
    this.tjh = new LinkedList();
    GMTrace.o(3968281346048L, 29566);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3968415563776L, 29567);
    if (paramInt == 0)
    {
      ((a.a.a.c.a)paramVarArgs[0]).d(1, 8, this.tjh);
      GMTrace.o(3968415563776L, 29567);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.c(1, 8, this.tjh);
      GMTrace.o(3968415563776L, 29567);
      return paramInt + 0;
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
      GMTrace.o(3968415563776L, 29567);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      gt localgt = (gt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3968415563776L, 29567);
        return -1;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new gs();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((gs)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localgt.tjh.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(3968415563776L, 29567);
      return 0;
    }
    GMTrace.o(3968415563776L, 29567);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/gt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */