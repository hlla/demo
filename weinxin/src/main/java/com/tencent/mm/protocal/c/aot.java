package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aot
  extends com.tencent.mm.bd.a
{
  public aou tSg;
  public int tgr;
  
  public aot()
  {
    GMTrace.i(13336812978176L, 99367);
    GMTrace.o(13336812978176L, 99367);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13336947195904L, 99368);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tSg == null) {
        throw new b("Not all required fields were included: OplogRet");
      }
      paramVarArgs.eO(1, this.tgr);
      if (this.tSg != null)
      {
        paramVarArgs.eQ(2, this.tSg.aUd());
        this.tSg.a(paramVarArgs);
      }
      GMTrace.o(13336947195904L, 99368);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tgr) + 0;
      paramInt = i;
      if (this.tSg != null) {
        paramInt = i + a.a.a.a.eN(2, this.tSg.aUd());
      }
      GMTrace.o(13336947195904L, 99368);
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
      if (this.tSg == null) {
        throw new b("Not all required fields were included: OplogRet");
      }
      GMTrace.o(13336947195904L, 99368);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aot localaot = (aot)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13336947195904L, 99368);
        return -1;
      case 1: 
        localaot.tgr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13336947195904L, 99368);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aou();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((aou)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localaot.tSg = ((aou)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13336947195904L, 99368);
      return 0;
    }
    GMTrace.o(13336947195904L, 99368);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */