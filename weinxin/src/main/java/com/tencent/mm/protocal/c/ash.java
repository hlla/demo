package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ash
  extends com.tencent.mm.bd.a
{
  public int jLr;
  public LinkedList<asg> tVa;
  
  public ash()
  {
    GMTrace.i(3806414766080L, 28360);
    this.tVa = new LinkedList();
    GMTrace.o(3806414766080L, 28360);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3806548983808L, 28361);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.jLr);
      paramVarArgs.d(2, 8, this.tVa);
      GMTrace.o(3806548983808L, 28361);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.jLr);
      i = a.a.a.a.c(2, 8, this.tVa);
      GMTrace.o(3806548983808L, 28361);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tVa.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3806548983808L, 28361);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ash localash = (ash)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3806548983808L, 28361);
        return -1;
      case 1: 
        localash.jLr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3806548983808L, 28361);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new asg();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((asg)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localash.tVa.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(3806548983808L, 28361);
      return 0;
    }
    GMTrace.o(3806548983808L, 28361);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */