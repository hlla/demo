package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class af
  extends com.tencent.mm.bd.a
{
  public int tbc;
  public int tbd;
  public int tbe;
  public LinkedList<ad> tbf;
  public int tbg;
  public LinkedList<ad> tbh;
  
  public af()
  {
    GMTrace.i(18919196721152L, 140959);
    this.tbf = new LinkedList();
    this.tbh = new LinkedList();
    GMTrace.o(18919196721152L, 140959);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(18919330938880L, 140960);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tbc);
      paramVarArgs.eO(2, this.tbe);
      paramVarArgs.d(3, 8, this.tbf);
      paramVarArgs.eO(4, this.tbd);
      paramVarArgs.eO(5, this.tbg);
      paramVarArgs.d(6, 8, this.tbh);
      GMTrace.o(18919330938880L, 140960);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tbc);
      i = a.a.a.a.eL(2, this.tbe);
      int j = a.a.a.a.c(3, 8, this.tbf);
      int k = a.a.a.a.eL(4, this.tbd);
      int m = a.a.a.a.eL(5, this.tbg);
      int n = a.a.a.a.c(6, 8, this.tbh);
      GMTrace.o(18919330938880L, 140960);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tbf.clear();
      this.tbh.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(18919330938880L, 140960);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      af localaf = (af)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(18919330938880L, 140960);
        return -1;
      case 1: 
        localaf.tbc = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(18919330938880L, 140960);
        return 0;
      case 2: 
        localaf.tbe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(18919330938880L, 140960);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ad();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ad)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaf.tbf.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(18919330938880L, 140960);
        return 0;
      case 4: 
        localaf.tbd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(18919330938880L, 140960);
        return 0;
      case 5: 
        localaf.tbg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(18919330938880L, 140960);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ad();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ad)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localaf.tbh.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(18919330938880L, 140960);
      return 0;
    }
    GMTrace.o(18919330938880L, 140960);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */