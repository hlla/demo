package com.tencent.mm.protocal.a.a;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bd.a
{
  public int sZm;
  public int sZn;
  public LinkedList<n> sZo;
  
  public m()
  {
    GMTrace.i(13101663518720L, 97615);
    this.sZo = new LinkedList();
    GMTrace.o(13101663518720L, 97615);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13101797736448L, 97616);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.sZm);
      paramVarArgs.eO(2, this.sZn);
      paramVarArgs.d(3, 8, this.sZo);
      GMTrace.o(13101797736448L, 97616);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.sZm);
      i = a.a.a.a.eL(2, this.sZn);
      int j = a.a.a.a.c(3, 8, this.sZo);
      GMTrace.o(13101797736448L, 97616);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sZo.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13101797736448L, 97616);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13101797736448L, 97616);
        return -1;
      case 1: 
        localm.sZm = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13101797736448L, 97616);
        return 0;
      case 2: 
        localm.sZn = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13101797736448L, 97616);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new n();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((n)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localm.sZo.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(13101797736448L, 97616);
      return 0;
    }
    GMTrace.o(13101797736448L, 97616);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */