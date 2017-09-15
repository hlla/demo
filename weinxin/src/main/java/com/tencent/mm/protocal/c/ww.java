package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class ww
  extends com.tencent.mm.bd.a
{
  public int tBV;
  public int tBW;
  public int tBX;
  public int tpY;
  public int tpZ;
  public int tqa;
  public b tqc;
  public aev tqd;
  
  public ww()
  {
    GMTrace.i(13097502769152L, 97584);
    GMTrace.o(13097502769152L, 97584);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13097636986880L, 97585);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tpY);
      paramVarArgs.eO(2, this.tpZ);
      paramVarArgs.eO(3, this.tqa);
      if (this.tqc != null) {
        paramVarArgs.b(4, this.tqc);
      }
      paramVarArgs.eO(5, this.tBV);
      paramVarArgs.eO(6, this.tBW);
      paramVarArgs.eO(7, this.tBX);
      if (this.tqd != null)
      {
        paramVarArgs.eQ(8, this.tqd.aUd());
        this.tqd.a(paramVarArgs);
      }
      GMTrace.o(13097636986880L, 97585);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tpY) + 0 + a.a.a.a.eL(2, this.tpZ) + a.a.a.a.eL(3, this.tqa);
      paramInt = i;
      if (this.tqc != null) {
        paramInt = i + a.a.a.a.a(4, this.tqc);
      }
      i = paramInt + a.a.a.a.eL(5, this.tBV) + a.a.a.a.eL(6, this.tBW) + a.a.a.a.eL(7, this.tBX);
      paramInt = i;
      if (this.tqd != null) {
        paramInt = i + a.a.a.a.eN(8, this.tqd.aUd());
      }
      GMTrace.o(13097636986880L, 97585);
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
      GMTrace.o(13097636986880L, 97585);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ww localww = (ww)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13097636986880L, 97585);
        return -1;
      case 1: 
        localww.tpY = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13097636986880L, 97585);
        return 0;
      case 2: 
        localww.tpZ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13097636986880L, 97585);
        return 0;
      case 3: 
        localww.tqa = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13097636986880L, 97585);
        return 0;
      case 4: 
        localww.tqc = ((a.a.a.a.a)localObject1).chR();
        GMTrace.o(13097636986880L, 97585);
        return 0;
      case 5: 
        localww.tBV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13097636986880L, 97585);
        return 0;
      case 6: 
        localww.tBW = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13097636986880L, 97585);
        return 0;
      case 7: 
        localww.tBX = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13097636986880L, 97585);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aev();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((aev)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localww.tqd = ((aev)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13097636986880L, 97585);
      return 0;
    }
    GMTrace.o(13097636986880L, 97585);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ww.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */