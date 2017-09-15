package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ad
  extends com.tencent.mm.bd.a
{
  public String taX;
  public int taY;
  public int taZ;
  public int tba;
  public int tbb;
  
  public ad()
  {
    GMTrace.i(18919465156608L, 140961);
    GMTrace.o(18919465156608L, 140961);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(18919599374336L, 140962);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.taX != null) {
        paramVarArgs.e(1, this.taX);
      }
      paramVarArgs.eO(2, this.taY);
      paramVarArgs.eO(3, this.taZ);
      paramVarArgs.eO(4, this.tba);
      paramVarArgs.eO(5, this.tbb);
      GMTrace.o(18919599374336L, 140962);
      return 0;
    }
    if (paramInt == 1) {
      if (this.taX == null) {
        break label431;
      }
    }
    label431:
    for (paramInt = a.a.a.b.b.a.f(1, this.taX) + 0;; paramInt = 0)
    {
      int i = a.a.a.a.eL(2, this.taY);
      int j = a.a.a.a.eL(3, this.taZ);
      int k = a.a.a.a.eL(4, this.tba);
      int m = a.a.a.a.eL(5, this.tbb);
      GMTrace.o(18919599374336L, 140962);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(18919599374336L, 140962);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(18919599374336L, 140962);
          return -1;
        case 1: 
          localad.taX = locala.xky.readString();
          GMTrace.o(18919599374336L, 140962);
          return 0;
        case 2: 
          localad.taY = locala.xky.mL();
          GMTrace.o(18919599374336L, 140962);
          return 0;
        case 3: 
          localad.taZ = locala.xky.mL();
          GMTrace.o(18919599374336L, 140962);
          return 0;
        case 4: 
          localad.tba = locala.xky.mL();
          GMTrace.o(18919599374336L, 140962);
          return 0;
        }
        localad.tbb = locala.xky.mL();
        GMTrace.o(18919599374336L, 140962);
        return 0;
      }
      GMTrace.o(18919599374336L, 140962);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */