package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class od
  extends com.tencent.mm.bd.a
{
  public int tsd;
  public oe tse;
  public int tsf;
  public oe tsg;
  
  public od()
  {
    GMTrace.i(13341376380928L, 99401);
    GMTrace.o(13341376380928L, 99401);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13341510598656L, 99402);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tse == null) {
        throw new b("Not all required fields were included: NightTime");
      }
      if (this.tsg == null) {
        throw new b("Not all required fields were included: AllDayTime");
      }
      paramVarArgs.eO(1, this.tsd);
      if (this.tse != null)
      {
        paramVarArgs.eQ(2, this.tse.aUd());
        this.tse.a(paramVarArgs);
      }
      paramVarArgs.eO(3, this.tsf);
      if (this.tsg != null)
      {
        paramVarArgs.eQ(4, this.tsg.aUd());
        this.tsg.a(paramVarArgs);
      }
      GMTrace.o(13341510598656L, 99402);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tsd) + 0;
      paramInt = i;
      if (this.tse != null) {
        paramInt = i + a.a.a.a.eN(2, this.tse.aUd());
      }
      i = paramInt + a.a.a.a.eL(3, this.tsf);
      paramInt = i;
      if (this.tsg != null) {
        paramInt = i + a.a.a.a.eN(4, this.tsg.aUd());
      }
      GMTrace.o(13341510598656L, 99402);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tse == null) {
        throw new b("Not all required fields were included: NightTime");
      }
      if (this.tsg == null) {
        throw new b("Not all required fields were included: AllDayTime");
      }
      GMTrace.o(13341510598656L, 99402);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      od localod = (od)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13341510598656L, 99402);
        return -1;
      case 1: 
        localod.tsd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13341510598656L, 99402);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new oe();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((oe)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localod.tse = ((oe)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13341510598656L, 99402);
        return 0;
      case 3: 
        localod.tsf = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13341510598656L, 99402);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new oe();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((oe)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localod.tsg = ((oe)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13341510598656L, 99402);
      return 0;
    }
    GMTrace.o(13341510598656L, 99402);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/od.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */