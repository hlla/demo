package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class en
  extends com.tencent.mm.bd.a
{
  public avu tgX;
  public int tgr;
  
  public en()
  {
    GMTrace.i(13573304614912L, 101129);
    GMTrace.o(13573304614912L, 101129);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13573438832640L, 101130);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tgX == null) {
        throw new b("Not all required fields were included: ErrMsg");
      }
      paramVarArgs.eO(1, this.tgr);
      if (this.tgX != null)
      {
        paramVarArgs.eQ(2, this.tgX.aUd());
        this.tgX.a(paramVarArgs);
      }
      GMTrace.o(13573438832640L, 101130);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tgr) + 0;
      paramInt = i;
      if (this.tgX != null) {
        paramInt = i + a.a.a.a.eN(2, this.tgX.aUd());
      }
      GMTrace.o(13573438832640L, 101130);
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
      if (this.tgX == null) {
        throw new b("Not all required fields were included: ErrMsg");
      }
      GMTrace.o(13573438832640L, 101130);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      en localen = (en)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13573438832640L, 101130);
        return -1;
      case 1: 
        localen.tgr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13573438832640L, 101130);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avu();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localen.tgX = ((avu)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13573438832640L, 101130);
      return 0;
    }
    GMTrace.o(13573438832640L, 101130);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */