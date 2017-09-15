package com.tencent.mm.protocal.a.a;

import com.tencent.gmtrace.GMTrace;

public final class n
  extends com.tencent.mm.bd.a
{
  public int sYG;
  public int sZp;
  public int sZq;
  public int sZr;
  public int sZs;
  public int sZt;
  public int sZu;
  
  public n()
  {
    GMTrace.i(13102468825088L, 97621);
    GMTrace.o(13102468825088L, 97621);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13102603042816L, 97622);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.sYG);
      paramVarArgs.eO(2, this.sZp);
      paramVarArgs.eO(3, this.sZq);
      paramVarArgs.eO(4, this.sZr);
      paramVarArgs.eO(5, this.sZs);
      paramVarArgs.eO(6, this.sZt);
      paramVarArgs.eO(7, this.sZu);
      GMTrace.o(13102603042816L, 97622);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.sYG);
      int i = a.a.a.a.eL(2, this.sZp);
      int j = a.a.a.a.eL(3, this.sZq);
      int k = a.a.a.a.eL(4, this.sZr);
      int m = a.a.a.a.eL(5, this.sZs);
      int n = a.a.a.a.eL(6, this.sZt);
      int i1 = a.a.a.a.eL(7, this.sZu);
      GMTrace.o(13102603042816L, 97622);
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
      GMTrace.o(13102603042816L, 97622);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13102603042816L, 97622);
        return -1;
      case 1: 
        localn.sYG = locala.xky.mL();
        GMTrace.o(13102603042816L, 97622);
        return 0;
      case 2: 
        localn.sZp = locala.xky.mL();
        GMTrace.o(13102603042816L, 97622);
        return 0;
      case 3: 
        localn.sZq = locala.xky.mL();
        GMTrace.o(13102603042816L, 97622);
        return 0;
      case 4: 
        localn.sZr = locala.xky.mL();
        GMTrace.o(13102603042816L, 97622);
        return 0;
      case 5: 
        localn.sZs = locala.xky.mL();
        GMTrace.o(13102603042816L, 97622);
        return 0;
      case 6: 
        localn.sZt = locala.xky.mL();
        GMTrace.o(13102603042816L, 97622);
        return 0;
      }
      localn.sZu = locala.xky.mL();
      GMTrace.o(13102603042816L, 97622);
      return 0;
    }
    GMTrace.o(13102603042816L, 97622);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */