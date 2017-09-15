package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bjf
  extends ave
{
  public String tGF;
  public int tWA;
  public int tWy;
  public avt thY;
  public bjl uhg;
  
  public bjf()
  {
    GMTrace.i(3704006639616L, 27597);
    GMTrace.o(3704006639616L, 27597);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3704140857344L, 27598);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.uhg == null) {
        throw new b("Not all required fields were included: Piece");
      }
      if (this.thY == null) {
        throw new b("Not all required fields were included: RandomEncryKey");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.uhg != null)
      {
        paramVarArgs.eQ(2, this.uhg.aUd());
        this.uhg.a(paramVarArgs);
      }
      paramVarArgs.eO(3, this.tWy);
      paramVarArgs.eO(4, this.tWA);
      if (this.tGF != null) {
        paramVarArgs.e(5, this.tGF);
      }
      if (this.thY != null)
      {
        paramVarArgs.eQ(6, this.thY.aUd());
        this.thY.a(paramVarArgs);
      }
      GMTrace.o(3704140857344L, 27598);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt;
      if (this.uhg != null) {
        i = paramInt + a.a.a.a.eN(2, this.uhg.aUd());
      }
      i = i + a.a.a.a.eL(3, this.tWy) + a.a.a.a.eL(4, this.tWA);
      paramInt = i;
      if (this.tGF != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tGF);
      }
      i = paramInt;
      if (this.thY != null) {
        i = paramInt + a.a.a.a.eN(6, this.thY.aUd());
      }
      GMTrace.o(3704140857344L, 27598);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.uhg == null) {
        throw new b("Not all required fields were included: Piece");
      }
      if (this.thY == null) {
        throw new b("Not all required fields were included: RandomEncryKey");
      }
      GMTrace.o(3704140857344L, 27598);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bjf localbjf = (bjf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3704140857344L, 27598);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbjf.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3704140857344L, 27598);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbjf.uhg = ((bjl)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3704140857344L, 27598);
        return 0;
      case 3: 
        localbjf.tWy = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3704140857344L, 27598);
        return 0;
      case 4: 
        localbjf.tWA = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3704140857344L, 27598);
        return 0;
      case 5: 
        localbjf.tGF = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3704140857344L, 27598);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
        localbjf.thY = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3704140857344L, 27598);
      return 0;
    }
    GMTrace.o(3704140857344L, 27598);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bjf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */