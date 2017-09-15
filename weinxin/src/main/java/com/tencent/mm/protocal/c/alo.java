package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class alo
  extends avm
{
  public int jMq;
  public int ofk;
  public int tOK;
  public int tOL;
  public long tdE;
  public int tdw;
  public avu tdy;
  public int tgr;
  
  public alo()
  {
    GMTrace.i(13339765768192L, 99389);
    GMTrace.o(13339765768192L, 99389);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13339899985920L, 99390);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tdy == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      paramVarArgs.eO(1, this.tgr);
      if (this.tdy != null)
      {
        paramVarArgs.eQ(2, this.tdy.aUd());
        this.tdy.a(paramVarArgs);
      }
      paramVarArgs.eO(3, this.tdw);
      paramVarArgs.eO(4, this.tOK);
      paramVarArgs.eO(5, this.ofk);
      paramVarArgs.eO(6, this.tOL);
      paramVarArgs.eO(7, this.jMq);
      paramVarArgs.O(8, this.tdE);
      GMTrace.o(13339899985920L, 99390);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tgr) + 0;
      paramInt = i;
      if (this.tdy != null) {
        paramInt = i + a.a.a.a.eN(2, this.tdy.aUd());
      }
      i = a.a.a.a.eL(3, this.tdw);
      int j = a.a.a.a.eL(4, this.tOK);
      int k = a.a.a.a.eL(5, this.ofk);
      int m = a.a.a.a.eL(6, this.tOL);
      int n = a.a.a.a.eL(7, this.jMq);
      int i1 = a.a.a.a.N(8, this.tdE);
      GMTrace.o(13339899985920L, 99390);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tdy == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      GMTrace.o(13339899985920L, 99390);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      alo localalo = (alo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13339899985920L, 99390);
        return -1;
      case 1: 
        localalo.tgr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13339899985920L, 99390);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localalo.tdy = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13339899985920L, 99390);
        return 0;
      case 3: 
        localalo.tdw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13339899985920L, 99390);
        return 0;
      case 4: 
        localalo.tOK = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13339899985920L, 99390);
        return 0;
      case 5: 
        localalo.ofk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13339899985920L, 99390);
        return 0;
      case 6: 
        localalo.tOL = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13339899985920L, 99390);
        return 0;
      case 7: 
        localalo.jMq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13339899985920L, 99390);
        return 0;
      }
      localalo.tdE = ((a.a.a.a.a)localObject1).xky.mM();
      GMTrace.o(13339899985920L, 99390);
      return 0;
    }
    GMTrace.o(13339899985920L, 99390);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/alo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */