package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bbv
  extends com.tencent.mm.bd.a
{
  public int tXe;
  public int ubr;
  public LinkedList<bbc> ubs;
  public int ubt;
  public int ubu;
  
  public bbv()
  {
    GMTrace.i(3696356229120L, 27540);
    this.ubs = new LinkedList();
    GMTrace.o(3696356229120L, 27540);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3696490446848L, 27541);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.ubr);
      paramVarArgs.d(2, 8, this.ubs);
      paramVarArgs.eO(3, this.ubt);
      paramVarArgs.eO(4, this.tXe);
      paramVarArgs.eO(5, this.ubu);
      GMTrace.o(3696490446848L, 27541);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.ubr);
      i = a.a.a.a.c(2, 8, this.ubs);
      int j = a.a.a.a.eL(3, this.ubt);
      int k = a.a.a.a.eL(4, this.tXe);
      int m = a.a.a.a.eL(5, this.ubu);
      GMTrace.o(3696490446848L, 27541);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ubs.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3696490446848L, 27541);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bbv localbbv = (bbv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3696490446848L, 27541);
        return -1;
      case 1: 
        localbbv.ubr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3696490446848L, 27541);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bbc();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bbc)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbbv.ubs.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3696490446848L, 27541);
        return 0;
      case 3: 
        localbbv.ubt = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3696490446848L, 27541);
        return 0;
      case 4: 
        localbbv.tXe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3696490446848L, 27541);
        return 0;
      }
      localbbv.ubu = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3696490446848L, 27541);
      return 0;
    }
    GMTrace.o(3696490446848L, 27541);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */