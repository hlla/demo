package com.tencent.mm.protocal.a.a;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bd.a
{
  public int ret;
  public int sYJ;
  public int sYK;
  public o sYL;
  public o sYM;
  public int sYN;
  public int sYO;
  public int sZc;
  
  public h()
  {
    GMTrace.i(13103274131456L, 97627);
    GMTrace.o(13103274131456L, 97627);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13103408349184L, 97628);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.ret);
      paramVarArgs.eO(2, this.sYJ);
      paramVarArgs.eO(3, this.sYK);
      if (this.sYL != null)
      {
        paramVarArgs.eQ(4, this.sYL.aUd());
        this.sYL.a(paramVarArgs);
      }
      if (this.sYM != null)
      {
        paramVarArgs.eQ(5, this.sYM.aUd());
        this.sYM.a(paramVarArgs);
      }
      paramVarArgs.eO(6, this.sYN);
      paramVarArgs.eO(7, this.sZc);
      paramVarArgs.eO(8, this.sYO);
      GMTrace.o(13103408349184L, 97628);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.ret) + 0 + a.a.a.a.eL(2, this.sYJ) + a.a.a.a.eL(3, this.sYK);
      paramInt = i;
      if (this.sYL != null) {
        paramInt = i + a.a.a.a.eN(4, this.sYL.aUd());
      }
      i = paramInt;
      if (this.sYM != null) {
        i = paramInt + a.a.a.a.eN(5, this.sYM.aUd());
      }
      paramInt = a.a.a.a.eL(6, this.sYN);
      int j = a.a.a.a.eL(7, this.sZc);
      int k = a.a.a.a.eL(8, this.sYO);
      GMTrace.o(13103408349184L, 97628);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13103408349184L, 97628);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13103408349184L, 97628);
        return -1;
      case 1: 
        localh.ret = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13103408349184L, 97628);
        return 0;
      case 2: 
        localh.sYJ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13103408349184L, 97628);
        return 0;
      case 3: 
        localh.sYK = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13103408349184L, 97628);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localh.sYL = ((o)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13103408349184L, 97628);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localh.sYM = ((o)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13103408349184L, 97628);
        return 0;
      case 6: 
        localh.sYN = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13103408349184L, 97628);
        return 0;
      case 7: 
        localh.sZc = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13103408349184L, 97628);
        return 0;
      }
      localh.sYO = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13103408349184L, 97628);
      return 0;
    }
    GMTrace.o(13103408349184L, 97628);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */