package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class lt
  extends com.tencent.mm.bd.a
{
  public int tqs;
  public avt tqt;
  
  public lt()
  {
    GMTrace.i(13582968291328L, 101201);
    GMTrace.o(13582968291328L, 101201);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13583102509056L, 101202);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tqt == null) {
        throw new b("Not all required fields were included: CmdBuf");
      }
      paramVarArgs.eO(1, this.tqs);
      if (this.tqt != null)
      {
        paramVarArgs.eQ(2, this.tqt.aUd());
        this.tqt.a(paramVarArgs);
      }
      GMTrace.o(13583102509056L, 101202);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tqs) + 0;
      paramInt = i;
      if (this.tqt != null) {
        paramInt = i + a.a.a.a.eN(2, this.tqt.aUd());
      }
      GMTrace.o(13583102509056L, 101202);
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
      if (this.tqt == null) {
        throw new b("Not all required fields were included: CmdBuf");
      }
      GMTrace.o(13583102509056L, 101202);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      lt locallt = (lt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13583102509056L, 101202);
        return -1;
      case 1: 
        locallt.tqs = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13583102509056L, 101202);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        locallt.tqt = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13583102509056L, 101202);
      return 0;
    }
    GMTrace.o(13583102509056L, 101202);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/lt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */