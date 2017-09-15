package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class aou
  extends com.tencent.mm.bd.a
{
  public int jLr;
  public LinkedList<Integer> tCl;
  public LinkedList<aor> tSh;
  
  public aou()
  {
    GMTrace.i(13337349849088L, 99371);
    this.tCl = new LinkedList();
    this.tSh = new LinkedList();
    GMTrace.o(13337349849088L, 99371);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13337484066816L, 99372);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.jLr);
      paramVarArgs.c(2, this.tCl);
      paramVarArgs.d(3, 8, this.tSh);
      GMTrace.o(13337484066816L, 99372);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.jLr);
      i = a.a.a.a.b(2, this.tCl);
      int j = a.a.a.a.c(3, 8, this.tSh);
      GMTrace.o(13337484066816L, 99372);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tCl.clear();
      this.tSh.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13337484066816L, 99372);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aou localaou = (aou)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13337484066816L, 99372);
        return -1;
      case 1: 
        localaou.jLr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13337484066816L, 99372);
        return 0;
      case 2: 
        localaou.tCl = new a.a.a.a.a(((a.a.a.a.a)localObject1).chR().sWU, unknownTagHandler).chO();
        GMTrace.o(13337484066816L, 99372);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aor();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((aor)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localaou.tSh.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(13337484066816L, 99372);
      return 0;
    }
    GMTrace.o(13337484066816L, 99372);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */