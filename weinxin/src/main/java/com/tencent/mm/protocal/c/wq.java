package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class wq
  extends com.tencent.mm.bd.a
{
  public avu tBH;
  public int tBI;
  public int tBJ;
  public int tBK;
  public int tBL;
  public int tdF;
  
  public wq()
  {
    GMTrace.i(3661862273024L, 27283);
    this.tBK = 1;
    GMTrace.o(3661862273024L, 27283);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3661996490752L, 27284);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tBH == null) {
        throw new b("Not all required fields were included: ChatroomId");
      }
      if (this.tBH != null)
      {
        paramVarArgs.eQ(1, this.tBH.aUd());
        this.tBH.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tdF);
      paramVarArgs.eO(3, this.tBI);
      paramVarArgs.eO(4, this.tBJ);
      paramVarArgs.eO(5, this.tBK);
      paramVarArgs.eO(6, this.tBL);
      GMTrace.o(3661996490752L, 27284);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tBH != null) {
        paramInt = a.a.a.a.eN(1, this.tBH.aUd()) + 0;
      }
      i = a.a.a.a.eL(2, this.tdF);
      int j = a.a.a.a.eL(3, this.tBI);
      int k = a.a.a.a.eL(4, this.tBJ);
      int m = a.a.a.a.eL(5, this.tBK);
      int n = a.a.a.a.eL(6, this.tBL);
      GMTrace.o(3661996490752L, 27284);
      return paramInt + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tBH == null) {
        throw new b("Not all required fields were included: ChatroomId");
      }
      GMTrace.o(3661996490752L, 27284);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      wq localwq = (wq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3661996490752L, 27284);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localwq.tBH = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3661996490752L, 27284);
        return 0;
      case 2: 
        localwq.tdF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3661996490752L, 27284);
        return 0;
      case 3: 
        localwq.tBI = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3661996490752L, 27284);
        return 0;
      case 4: 
        localwq.tBJ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3661996490752L, 27284);
        return 0;
      case 5: 
        localwq.tBK = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3661996490752L, 27284);
        return 0;
      }
      localwq.tBL = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3661996490752L, 27284);
      return 0;
    }
    GMTrace.o(3661996490752L, 27284);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/wq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */