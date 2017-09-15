package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class lg
  extends ave
{
  public long tdE;
  public int tdw;
  public int tfd;
  public String tpP;
  public bjk tpQ;
  
  public lg()
  {
    GMTrace.i(3672733908992L, 27364);
    GMTrace.o(3672733908992L, 27364);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3672868126720L, 27365);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.tpP != null) {
        paramVarArgs.e(2, this.tpP);
      }
      paramVarArgs.eO(3, this.tfd);
      paramVarArgs.eO(4, this.tdw);
      if (this.tpQ != null)
      {
        paramVarArgs.eQ(5, this.tpQ.aUd());
        this.tpQ.a(paramVarArgs);
      }
      paramVarArgs.O(6, this.tdE);
      GMTrace.o(3672868126720L, 27365);
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
      if (this.tpP != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tpP);
      }
      i = i + a.a.a.a.eL(3, this.tfd) + a.a.a.a.eL(4, this.tdw);
      paramInt = i;
      if (this.tpQ != null) {
        paramInt = i + a.a.a.a.eN(5, this.tpQ.aUd());
      }
      i = a.a.a.a.N(6, this.tdE);
      GMTrace.o(3672868126720L, 27365);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3672868126720L, 27365);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      lg locallg = (lg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3672868126720L, 27365);
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
          locallg.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3672868126720L, 27365);
        return 0;
      case 2: 
        locallg.tpP = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3672868126720L, 27365);
        return 0;
      case 3: 
        locallg.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3672868126720L, 27365);
        return 0;
      case 4: 
        locallg.tdw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3672868126720L, 27365);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjk();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjk)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          locallg.tpQ = ((bjk)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3672868126720L, 27365);
        return 0;
      }
      locallg.tdE = ((a.a.a.a.a)localObject1).xky.mM();
      GMTrace.o(3672868126720L, 27365);
      return 0;
    }
    GMTrace.o(3672868126720L, 27365);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/lg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */