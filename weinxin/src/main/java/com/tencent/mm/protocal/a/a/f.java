package com.tencent.mm.protocal.a.a;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bd.a
{
  public int ret;
  public int sYJ;
  public int sYK;
  public o sYL;
  public o sYM;
  public int sYN;
  public int sYO;
  public int sYX;
  public o sYY;
  
  public f()
  {
    GMTrace.i(13103542566912L, 97629);
    GMTrace.o(13103542566912L, 97629);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13103676784640L, 97630);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.ret);
      paramVarArgs.eO(2, this.sYJ);
      paramVarArgs.eO(3, this.sYK);
      paramVarArgs.eO(4, this.sYX);
      if (this.sYL != null)
      {
        paramVarArgs.eQ(5, this.sYL.aUd());
        this.sYL.a(paramVarArgs);
      }
      if (this.sYM != null)
      {
        paramVarArgs.eQ(6, this.sYM.aUd());
        this.sYM.a(paramVarArgs);
      }
      if (this.sYY != null)
      {
        paramVarArgs.eQ(7, this.sYY.aUd());
        this.sYY.a(paramVarArgs);
      }
      paramVarArgs.eO(8, this.sYN);
      paramVarArgs.eO(9, this.sYO);
      GMTrace.o(13103676784640L, 97630);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.ret) + 0 + a.a.a.a.eL(2, this.sYJ) + a.a.a.a.eL(3, this.sYK) + a.a.a.a.eL(4, this.sYX);
      paramInt = i;
      if (this.sYL != null) {
        paramInt = i + a.a.a.a.eN(5, this.sYL.aUd());
      }
      i = paramInt;
      if (this.sYM != null) {
        i = paramInt + a.a.a.a.eN(6, this.sYM.aUd());
      }
      paramInt = i;
      if (this.sYY != null) {
        paramInt = i + a.a.a.a.eN(7, this.sYY.aUd());
      }
      i = a.a.a.a.eL(8, this.sYN);
      int j = a.a.a.a.eL(9, this.sYO);
      GMTrace.o(13103676784640L, 97630);
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
      GMTrace.o(13103676784640L, 97630);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13103676784640L, 97630);
        return -1;
      case 1: 
        localf.ret = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13103676784640L, 97630);
        return 0;
      case 2: 
        localf.sYJ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13103676784640L, 97630);
        return 0;
      case 3: 
        localf.sYK = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13103676784640L, 97630);
        return 0;
      case 4: 
        localf.sYX = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13103676784640L, 97630);
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
          localf.sYL = ((o)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13103676784640L, 97630);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localf.sYM = ((o)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13103676784640L, 97630);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localf.sYY = ((o)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13103676784640L, 97630);
        return 0;
      case 8: 
        localf.sYN = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13103676784640L, 97630);
        return 0;
      }
      localf.sYO = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13103676784640L, 97630);
      return 0;
    }
    GMTrace.o(13103676784640L, 97630);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */