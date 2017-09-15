package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ux
  extends ave
{
  public LinkedList<afl> tAP;
  public afn tAR;
  public long tAS;
  
  public ux()
  {
    GMTrace.i(3725749911552L, 27759);
    this.tAP = new LinkedList();
    GMTrace.o(3725749911552L, 27759);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3725884129280L, 27760);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.d(2, 8, this.tAP);
      if (this.tAR != null)
      {
        paramVarArgs.eQ(4, this.tAR.aUd());
        this.tAR.a(paramVarArgs);
      }
      paramVarArgs.O(5, this.tAS);
      GMTrace.o(3725884129280L, 27760);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.c(2, 8, this.tAP);
      paramInt = i;
      if (this.tAR != null) {
        paramInt = i + a.a.a.a.eN(4, this.tAR.aUd());
      }
      i = a.a.a.a.N(5, this.tAS);
      GMTrace.o(3725884129280L, 27760);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tAP.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3725884129280L, 27760);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ux localux = (ux)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 3: 
      default: 
        GMTrace.o(3725884129280L, 27760);
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
          localux.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3725884129280L, 27760);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localux.tAP.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3725884129280L, 27760);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afn();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afn)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localux.tAR = ((afn)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3725884129280L, 27760);
        return 0;
      }
      localux.tAS = ((a.a.a.a.a)localObject1).xky.mM();
      GMTrace.o(3725884129280L, 27760);
      return 0;
    }
    GMTrace.o(3725884129280L, 27760);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ux.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */