package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class to
  extends com.tencent.mm.bd.a
{
  public int fRM;
  public int tAk;
  public LinkedList<qc> tAl;
  public int tAm;
  
  public to()
  {
    GMTrace.i(4011096801280L, 29885);
    this.tAl = new LinkedList();
    GMTrace.o(4011096801280L, 29885);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4011231019008L, 29886);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tAk);
      paramVarArgs.d(2, 8, this.tAl);
      paramVarArgs.eO(3, this.tAm);
      paramVarArgs.eO(4, this.fRM);
      GMTrace.o(4011231019008L, 29886);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tAk);
      i = a.a.a.a.c(2, 8, this.tAl);
      int j = a.a.a.a.eL(3, this.tAm);
      int k = a.a.a.a.eL(4, this.fRM);
      GMTrace.o(4011231019008L, 29886);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tAl.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4011231019008L, 29886);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      to localto = (to)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4011231019008L, 29886);
        return -1;
      case 1: 
        localto.tAk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4011231019008L, 29886);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qc();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((qc)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localto.tAl.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(4011231019008L, 29886);
        return 0;
      case 3: 
        localto.tAm = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4011231019008L, 29886);
        return 0;
      }
      localto.fRM = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(4011231019008L, 29886);
      return 0;
    }
    GMTrace.o(4011231019008L, 29886);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/to.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */