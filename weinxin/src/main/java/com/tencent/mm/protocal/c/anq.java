package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class anq
  extends com.tencent.mm.bd.a
{
  public lu tRg;
  public int tRh;
  public int tcg;
  public String tfX;
  public int tmu;
  public avt tmv;
  
  public anq()
  {
    GMTrace.i(13578002235392L, 101164);
    GMTrace.o(13578002235392L, 101164);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13578136453120L, 101165);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tRg == null) {
        throw new b("Not all required fields were included: Oplog");
      }
      if (this.tmv == null) {
        throw new b("Not all required fields were included: KeyBuf");
      }
      if (this.tRg != null)
      {
        paramVarArgs.eQ(1, this.tRg.aUd());
        this.tRg.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tmu);
      if (this.tmv != null)
      {
        paramVarArgs.eQ(3, this.tmv.aUd());
        this.tmv.a(paramVarArgs);
      }
      paramVarArgs.eO(4, this.tcg);
      if (this.tfX != null) {
        paramVarArgs.e(5, this.tfX);
      }
      paramVarArgs.eO(6, this.tRh);
      GMTrace.o(13578136453120L, 101165);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tRg != null) {
        paramInt = a.a.a.a.eN(1, this.tRg.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tmu);
      paramInt = i;
      if (this.tmv != null) {
        paramInt = i + a.a.a.a.eN(3, this.tmv.aUd());
      }
      i = paramInt + a.a.a.a.eL(4, this.tcg);
      paramInt = i;
      if (this.tfX != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tfX);
      }
      i = a.a.a.a.eL(6, this.tRh);
      GMTrace.o(13578136453120L, 101165);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tRg == null) {
        throw new b("Not all required fields were included: Oplog");
      }
      if (this.tmv == null) {
        throw new b("Not all required fields were included: KeyBuf");
      }
      GMTrace.o(13578136453120L, 101165);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      anq localanq = (anq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13578136453120L, 101165);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((lu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localanq.tRg = ((lu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13578136453120L, 101165);
        return 0;
      case 2: 
        localanq.tmu = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13578136453120L, 101165);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localanq.tmv = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13578136453120L, 101165);
        return 0;
      case 4: 
        localanq.tcg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13578136453120L, 101165);
        return 0;
      case 5: 
        localanq.tfX = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13578136453120L, 101165);
        return 0;
      }
      localanq.tRh = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13578136453120L, 101165);
      return 0;
    }
    GMTrace.o(13578136453120L, 101165);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/anq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */