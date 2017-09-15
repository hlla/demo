package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class ll
  extends com.tencent.mm.bd.a
{
  public int tpY;
  public int tpZ;
  public int tqa;
  public LinkedList<lk> tqb;
  public b tqc;
  public aev tqd;
  
  public ll()
  {
    GMTrace.i(13099516035072L, 97599);
    this.tqb = new LinkedList();
    GMTrace.o(13099516035072L, 97599);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13099650252800L, 97600);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tpY);
      paramVarArgs.eO(2, this.tpZ);
      paramVarArgs.eO(3, this.tqa);
      paramVarArgs.d(4, 8, this.tqb);
      if (this.tqc != null) {
        paramVarArgs.b(5, this.tqc);
      }
      if (this.tqd != null)
      {
        paramVarArgs.eQ(6, this.tqd.aUd());
        this.tqd.a(paramVarArgs);
      }
      GMTrace.o(13099650252800L, 97600);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tpY) + 0 + a.a.a.a.eL(2, this.tpZ) + a.a.a.a.eL(3, this.tqa) + a.a.a.a.c(4, 8, this.tqb);
      paramInt = i;
      if (this.tqc != null) {
        paramInt = i + a.a.a.a.a(5, this.tqc);
      }
      i = paramInt;
      if (this.tqd != null) {
        i = paramInt + a.a.a.a.eN(6, this.tqd.aUd());
      }
      GMTrace.o(13099650252800L, 97600);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tqb.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13099650252800L, 97600);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ll localll = (ll)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13099650252800L, 97600);
        return -1;
      case 1: 
        localll.tpY = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13099650252800L, 97600);
        return 0;
      case 2: 
        localll.tpZ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13099650252800L, 97600);
        return 0;
      case 3: 
        localll.tqa = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13099650252800L, 97600);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lk();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((lk)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localll.tqb.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13099650252800L, 97600);
        return 0;
      case 5: 
        localll.tqc = ((a.a.a.a.a)localObject1).chR();
        GMTrace.o(13099650252800L, 97600);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aev();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aev)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localll.tqd = ((aev)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13099650252800L, 97600);
      return 0;
    }
    GMTrace.o(13099650252800L, 97600);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */