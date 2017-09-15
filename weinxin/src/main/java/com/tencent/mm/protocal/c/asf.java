package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class asf
  extends com.tencent.mm.bd.a
{
  public int jLr;
  public int tEI;
  public LinkedList<ase> tUY;
  
  public asf()
  {
    GMTrace.i(3690047995904L, 27493);
    this.tUY = new LinkedList();
    GMTrace.o(3690047995904L, 27493);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3690182213632L, 27494);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tEI);
      paramVarArgs.eO(2, this.jLr);
      paramVarArgs.d(3, 8, this.tUY);
      GMTrace.o(3690182213632L, 27494);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tEI);
      i = a.a.a.a.eL(2, this.jLr);
      int j = a.a.a.a.c(3, 8, this.tUY);
      GMTrace.o(3690182213632L, 27494);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tUY.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3690182213632L, 27494);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      asf localasf = (asf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3690182213632L, 27494);
        return -1;
      case 1: 
        localasf.tEI = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3690182213632L, 27494);
        return 0;
      case 2: 
        localasf.jLr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3690182213632L, 27494);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ase();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ase)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localasf.tUY.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(3690182213632L, 27494);
      return 0;
    }
    GMTrace.o(3690182213632L, 27494);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/asf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */