package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class hr
  extends com.tencent.mm.bd.a
{
  public int tki;
  public int tkj;
  public int tkk;
  public LinkedList<hq> tkl;
  public LinkedList<hq> tkm;
  
  public hr()
  {
    GMTrace.i(13581357678592L, 101189);
    this.tkl = new LinkedList();
    this.tkm = new LinkedList();
    GMTrace.o(13581357678592L, 101189);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13581491896320L, 101190);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tki);
      paramVarArgs.eO(2, this.tkj);
      paramVarArgs.eO(5, this.tkk);
      paramVarArgs.d(3, 8, this.tkl);
      paramVarArgs.d(4, 8, this.tkm);
      GMTrace.o(13581491896320L, 101190);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tki);
      i = a.a.a.a.eL(2, this.tkj);
      int j = a.a.a.a.eL(5, this.tkk);
      int k = a.a.a.a.c(3, 8, this.tkl);
      int m = a.a.a.a.c(4, 8, this.tkm);
      GMTrace.o(13581491896320L, 101190);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tkl.clear();
      this.tkm.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13581491896320L, 101190);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      hr localhr = (hr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13581491896320L, 101190);
        return -1;
      case 1: 
        localhr.tki = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13581491896320L, 101190);
        return 0;
      case 2: 
        localhr.tkj = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13581491896320L, 101190);
        return 0;
      case 5: 
        localhr.tkk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13581491896320L, 101190);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hq();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hq)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localhr.tkl.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13581491896320L, 101190);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new hq();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((hq)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localhr.tkm.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(13581491896320L, 101190);
      return 0;
    }
    GMTrace.o(13581491896320L, 101190);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/hr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */