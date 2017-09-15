package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class acc
  extends ave
{
  public String mqG;
  public int tCc;
  public int tcg;
  public LinkedList<avu> thh;
  
  public acc()
  {
    GMTrace.i(4018076123136L, 29937);
    this.thh = new LinkedList();
    GMTrace.o(4018076123136L, 29937);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4018210340864L, 29938);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.mqG != null) {
        paramVarArgs.e(2, this.mqG);
      }
      paramVarArgs.eO(3, this.tCc);
      paramVarArgs.d(4, 8, this.thh);
      paramVarArgs.eO(5, this.tcg);
      GMTrace.o(4018210340864L, 29938);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt;
      if (this.mqG != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.mqG);
      }
      paramInt = a.a.a.a.eL(3, this.tCc);
      int j = a.a.a.a.c(4, 8, this.thh);
      int k = a.a.a.a.eL(5, this.tcg);
      GMTrace.o(4018210340864L, 29938);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.thh.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4018210340864L, 29938);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      acc localacc = (acc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(4018210340864L, 29938);
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
          localacc.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4018210340864L, 29938);
        return 0;
      case 2: 
        localacc.mqG = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4018210340864L, 29938);
        return 0;
      case 3: 
        localacc.tCc = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4018210340864L, 29938);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localacc.thh.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(4018210340864L, 29938);
        return 0;
      }
      localacc.tcg = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(4018210340864L, 29938);
      return 0;
    }
    GMTrace.o(4018210340864L, 29938);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/acc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */