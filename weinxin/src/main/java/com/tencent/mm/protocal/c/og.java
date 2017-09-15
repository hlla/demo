package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class og
  extends ave
{
  public int jMq;
  public int tjF;
  public aoy tsk;
  public int tsl;
  
  public og()
  {
    GMTrace.i(3944927461376L, 29392);
    GMTrace.o(3944927461376L, 29392);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3945061679104L, 29393);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tsk == null) {
        throw new b("Not all required fields were included: Package");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.tsk != null)
      {
        paramVarArgs.eQ(2, this.tsk.aUd());
        this.tsk.a(paramVarArgs);
      }
      paramVarArgs.eO(3, this.tjF);
      paramVarArgs.eO(4, this.tsl);
      paramVarArgs.eO(5, this.jMq);
      GMTrace.o(3945061679104L, 29393);
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
      if (this.tsk != null) {
        i = paramInt + a.a.a.a.eN(2, this.tsk.aUd());
      }
      paramInt = a.a.a.a.eL(3, this.tjF);
      int j = a.a.a.a.eL(4, this.tsl);
      int k = a.a.a.a.eL(5, this.jMq);
      GMTrace.o(3945061679104L, 29393);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tsk == null) {
        throw new b("Not all required fields were included: Package");
      }
      GMTrace.o(3945061679104L, 29393);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      og localog = (og)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3945061679104L, 29393);
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
          localog.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3945061679104L, 29393);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aoy();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aoy)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localog.tsk = ((aoy)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3945061679104L, 29393);
        return 0;
      case 3: 
        localog.tjF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3945061679104L, 29393);
        return 0;
      case 4: 
        localog.tsl = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3945061679104L, 29393);
        return 0;
      }
      localog.jMq = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3945061679104L, 29393);
      return 0;
    }
    GMTrace.o(3945061679104L, 29393);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/og.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */