package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aol
  extends ave
{
  public int tRR;
  public LinkedList<bjm> tRS;
  public int tay;
  
  public aol()
  {
    GMTrace.i(3820910280704L, 28468);
    this.tRS = new LinkedList();
    GMTrace.o(3820910280704L, 28468);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3821044498432L, 28469);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tay);
      paramVarArgs.eO(3, this.tRR);
      paramVarArgs.d(4, 8, this.tRS);
      GMTrace.o(3821044498432L, 28469);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = a.a.a.a.eL(2, this.tay);
      int j = a.a.a.a.eL(3, this.tRR);
      int k = a.a.a.a.c(4, 8, this.tRS);
      GMTrace.o(3821044498432L, 28469);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tRS.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3821044498432L, 28469);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aol localaol = (aol)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3821044498432L, 28469);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localaol.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3821044498432L, 28469);
        return 0;
      case 2: 
        localaol.tay = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3821044498432L, 28469);
        return 0;
      case 3: 
        localaol.tRR = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3821044498432L, 28469);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bjm();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bjm)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
        localaol.tRS.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(3821044498432L, 28469);
      return 0;
    }
    GMTrace.o(3821044498432L, 28469);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */