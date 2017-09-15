package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bv
  extends com.tencent.mm.bd.a
{
  public int mrC;
  public int ofk;
  public long tdE;
  public int tdF;
  public avu tdG;
  public int tdH;
  public avu tdI;
  public int tdJ;
  
  public bv()
  {
    GMTrace.i(13586323734528L, 101226);
    GMTrace.o(13586323734528L, 101226);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13586457952256L, 101227);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tdG == null) {
        throw new b("Not all required fields were included: ChatRoomId");
      }
      if (this.tdI == null) {
        throw new b("Not all required fields were included: DigestContent");
      }
      if (this.tdG != null)
      {
        paramVarArgs.eQ(1, this.tdG.aUd());
        this.tdG.a(paramVarArgs);
      }
      paramVarArgs.O(2, this.tdE);
      paramVarArgs.eO(3, this.tdF);
      paramVarArgs.eO(4, this.ofk);
      paramVarArgs.eO(5, this.tdH);
      if (this.tdI != null)
      {
        paramVarArgs.eQ(6, this.tdI.aUd());
        this.tdI.a(paramVarArgs);
      }
      paramVarArgs.eO(7, this.tdJ);
      paramVarArgs.eO(8, this.mrC);
      GMTrace.o(13586457952256L, 101227);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tdG != null) {
        paramInt = a.a.a.a.eN(1, this.tdG.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.N(2, this.tdE) + a.a.a.a.eL(3, this.tdF) + a.a.a.a.eL(4, this.ofk) + a.a.a.a.eL(5, this.tdH);
      paramInt = i;
      if (this.tdI != null) {
        paramInt = i + a.a.a.a.eN(6, this.tdI.aUd());
      }
      i = a.a.a.a.eL(7, this.tdJ);
      int j = a.a.a.a.eL(8, this.mrC);
      GMTrace.o(13586457952256L, 101227);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tdG == null) {
        throw new b("Not all required fields were included: ChatRoomId");
      }
      if (this.tdI == null) {
        throw new b("Not all required fields were included: DigestContent");
      }
      GMTrace.o(13586457952256L, 101227);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bv localbv = (bv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13586457952256L, 101227);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbv.tdG = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13586457952256L, 101227);
        return 0;
      case 2: 
        localbv.tdE = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(13586457952256L, 101227);
        return 0;
      case 3: 
        localbv.tdF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13586457952256L, 101227);
        return 0;
      case 4: 
        localbv.ofk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13586457952256L, 101227);
        return 0;
      case 5: 
        localbv.tdH = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13586457952256L, 101227);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbv.tdI = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13586457952256L, 101227);
        return 0;
      case 7: 
        localbv.tdJ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13586457952256L, 101227);
        return 0;
      }
      localbv.mrC = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13586457952256L, 101227);
      return 0;
    }
    GMTrace.o(13586457952256L, 101227);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */