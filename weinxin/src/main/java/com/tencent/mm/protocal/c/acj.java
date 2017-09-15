package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class acj
  extends avm
{
  public int jMp;
  public LinkedList<bip> tGA;
  public int tGz;
  
  public acj()
  {
    GMTrace.i(3825205248000L, 28500);
    this.tGA = new LinkedList();
    GMTrace.o(3825205248000L, 28500);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3825339465728L, 28501);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.jMp);
      paramVarArgs.eO(3, this.tGz);
      paramVarArgs.d(4, 8, this.tGA);
      GMTrace.o(3825339465728L, 28501);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = a.a.a.a.eL(2, this.jMp);
      int j = a.a.a.a.eL(3, this.tGz);
      int k = a.a.a.a.c(4, 8, this.tGA);
      GMTrace.o(3825339465728L, 28501);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tGA.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3825339465728L, 28501);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      acj localacj = (acj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3825339465728L, 28501);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localacj.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3825339465728L, 28501);
        return 0;
      case 2: 
        localacj.jMp = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3825339465728L, 28501);
        return 0;
      case 3: 
        localacj.tGz = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3825339465728L, 28501);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bip();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bip)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localacj.tGA.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(3825339465728L, 28501);
      return 0;
    }
    GMTrace.o(3825339465728L, 28501);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/acj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */