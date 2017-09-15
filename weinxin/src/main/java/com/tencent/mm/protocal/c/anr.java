package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class anr
  extends com.tencent.mm.bd.a
{
  public int jLP;
  public int tRi;
  public int tRj;
  public int tgr;
  public int tkt;
  public avt tmv;
  public lu tmy;
  
  public anr()
  {
    GMTrace.i(13585115774976L, 101217);
    GMTrace.o(13585115774976L, 101217);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13585249992704L, 101218);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tmy == null) {
        throw new b("Not all required fields were included: CmdList");
      }
      if (this.tmv == null) {
        throw new b("Not all required fields were included: KeyBuf");
      }
      paramVarArgs.eO(1, this.tgr);
      if (this.tmy != null)
      {
        paramVarArgs.eQ(2, this.tmy.aUd());
        this.tmy.a(paramVarArgs);
      }
      paramVarArgs.eO(3, this.tkt);
      if (this.tmv != null)
      {
        paramVarArgs.eQ(4, this.tmv.aUd());
        this.tmv.a(paramVarArgs);
      }
      paramVarArgs.eO(5, this.jLP);
      paramVarArgs.eO(6, this.tRi);
      paramVarArgs.eO(7, this.tRj);
      GMTrace.o(13585249992704L, 101218);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tgr) + 0;
      paramInt = i;
      if (this.tmy != null) {
        paramInt = i + a.a.a.a.eN(2, this.tmy.aUd());
      }
      i = paramInt + a.a.a.a.eL(3, this.tkt);
      paramInt = i;
      if (this.tmv != null) {
        paramInt = i + a.a.a.a.eN(4, this.tmv.aUd());
      }
      i = a.a.a.a.eL(5, this.jLP);
      int j = a.a.a.a.eL(6, this.tRi);
      int k = a.a.a.a.eL(7, this.tRj);
      GMTrace.o(13585249992704L, 101218);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tmy == null) {
        throw new b("Not all required fields were included: CmdList");
      }
      if (this.tmv == null) {
        throw new b("Not all required fields were included: KeyBuf");
      }
      GMTrace.o(13585249992704L, 101218);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      anr localanr = (anr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13585249992704L, 101218);
        return -1;
      case 1: 
        localanr.tgr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13585249992704L, 101218);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((lu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localanr.tmy = ((lu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13585249992704L, 101218);
        return 0;
      case 3: 
        localanr.tkt = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13585249992704L, 101218);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localanr.tmv = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13585249992704L, 101218);
        return 0;
      case 5: 
        localanr.jLP = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13585249992704L, 101218);
        return 0;
      case 6: 
        localanr.tRi = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13585249992704L, 101218);
        return 0;
      }
      localanr.tRj = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13585249992704L, 101218);
      return 0;
    }
    GMTrace.o(13585249992704L, 101218);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/anr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */