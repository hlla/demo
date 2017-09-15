package com.tencent.mm.bi;

import com.tencent.gmtrace.GMTrace;

public final class c
  extends com.tencent.mm.bd.a
{
  public int hrc;
  public int size;
  public int uwD;
  public int uwE;
  public int uwF;
  public int uwG;
  public int uwH;
  
  public c()
  {
    GMTrace.i(4522332127232L, 33694);
    this.uwG = -1;
    GMTrace.o(4522332127232L, 33694);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4522466344960L, 33695);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.uwD);
      paramVarArgs.eO(2, this.uwE);
      paramVarArgs.eO(3, this.uwF);
      paramVarArgs.eO(41, this.uwG);
      paramVarArgs.eO(5, this.uwH);
      paramVarArgs.eO(6, this.hrc);
      paramVarArgs.eO(7, this.size);
      GMTrace.o(4522466344960L, 33695);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.uwD);
      int i = a.a.a.a.eL(2, this.uwE);
      int j = a.a.a.a.eL(3, this.uwF);
      int k = a.a.a.a.eL(41, this.uwG);
      int m = a.a.a.a.eL(5, this.uwH);
      int n = a.a.a.a.eL(6, this.hrc);
      int i1 = a.a.a.a.eL(7, this.size);
      GMTrace.o(4522466344960L, 33695);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4522466344960L, 33695);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(4522466344960L, 33695);
        return -1;
      case 1: 
        localc.uwD = locala.xky.mL();
        GMTrace.o(4522466344960L, 33695);
        return 0;
      case 2: 
        localc.uwE = locala.xky.mL();
        GMTrace.o(4522466344960L, 33695);
        return 0;
      case 3: 
        localc.uwF = locala.xky.mL();
        GMTrace.o(4522466344960L, 33695);
        return 0;
      case 41: 
        localc.uwG = locala.xky.mL();
        GMTrace.o(4522466344960L, 33695);
        return 0;
      case 5: 
        localc.uwH = locala.xky.mL();
        GMTrace.o(4522466344960L, 33695);
        return 0;
      case 6: 
        localc.hrc = locala.xky.mL();
        GMTrace.o(4522466344960L, 33695);
        return 0;
      }
      localc.size = locala.xky.mL();
      GMTrace.o(4522466344960L, 33695);
      return 0;
    }
    GMTrace.o(4522466344960L, 33695);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bi/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */