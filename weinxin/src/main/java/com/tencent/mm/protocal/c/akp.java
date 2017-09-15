package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class akp
  extends com.tencent.mm.bd.a
{
  public boolean tMF;
  public boolean tMG;
  public int tMH;
  public int tMI;
  public String tMJ;
  public boolean tMK;
  
  public akp()
  {
    GMTrace.i(3958617669632L, 29494);
    GMTrace.o(3958617669632L, 29494);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3958751887360L, 29495);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.an(1, this.tMF);
      paramVarArgs.an(2, this.tMG);
      paramVarArgs.eO(3, this.tMH);
      paramVarArgs.eO(4, this.tMI);
      if (this.tMJ != null) {
        paramVarArgs.e(5, this.tMJ);
      }
      paramVarArgs.an(6, this.tMK);
      GMTrace.o(3958751887360L, 29495);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.b.b.a.cH(1) + 1 + 0 + (a.a.a.b.b.a.cH(2) + 1) + a.a.a.a.eL(3, this.tMH) + a.a.a.a.eL(4, this.tMI);
      paramInt = i;
      if (this.tMJ != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tMJ);
      }
      i = a.a.a.b.b.a.cH(6);
      GMTrace.o(3958751887360L, 29495);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3958751887360L, 29495);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      akp localakp = (akp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3958751887360L, 29495);
        return -1;
      case 1: 
        localakp.tMF = locala.chQ();
        GMTrace.o(3958751887360L, 29495);
        return 0;
      case 2: 
        localakp.tMG = locala.chQ();
        GMTrace.o(3958751887360L, 29495);
        return 0;
      case 3: 
        localakp.tMH = locala.xky.mL();
        GMTrace.o(3958751887360L, 29495);
        return 0;
      case 4: 
        localakp.tMI = locala.xky.mL();
        GMTrace.o(3958751887360L, 29495);
        return 0;
      case 5: 
        localakp.tMJ = locala.xky.readString();
        GMTrace.o(3958751887360L, 29495);
        return 0;
      }
      localakp.tMK = locala.chQ();
      GMTrace.o(3958751887360L, 29495);
      return 0;
    }
    GMTrace.o(3958751887360L, 29495);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/akp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */