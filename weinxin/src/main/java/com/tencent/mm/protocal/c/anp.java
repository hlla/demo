package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class anp
  extends com.tencent.mm.bd.a
{
  public int tKv;
  public int tRa;
  public int tRb;
  public int tRc;
  public int tRd;
  public int tRe;
  public int tRf;
  
  public anp()
  {
    GMTrace.i(13096160591872L, 97574);
    GMTrace.o(13096160591872L, 97574);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13096294809600L, 97575);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tKv);
      paramVarArgs.eO(2, this.tRa);
      paramVarArgs.eO(3, this.tRb);
      paramVarArgs.eO(4, this.tRc);
      paramVarArgs.eO(5, this.tRd);
      paramVarArgs.eO(6, this.tRe);
      paramVarArgs.eO(7, this.tRf);
      GMTrace.o(13096294809600L, 97575);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tKv);
      int i = a.a.a.a.eL(2, this.tRa);
      int j = a.a.a.a.eL(3, this.tRb);
      int k = a.a.a.a.eL(4, this.tRc);
      int m = a.a.a.a.eL(5, this.tRd);
      int n = a.a.a.a.eL(6, this.tRe);
      int i1 = a.a.a.a.eL(7, this.tRf);
      GMTrace.o(13096294809600L, 97575);
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
      GMTrace.o(13096294809600L, 97575);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      anp localanp = (anp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13096294809600L, 97575);
        return -1;
      case 1: 
        localanp.tKv = locala.xky.mL();
        GMTrace.o(13096294809600L, 97575);
        return 0;
      case 2: 
        localanp.tRa = locala.xky.mL();
        GMTrace.o(13096294809600L, 97575);
        return 0;
      case 3: 
        localanp.tRb = locala.xky.mL();
        GMTrace.o(13096294809600L, 97575);
        return 0;
      case 4: 
        localanp.tRc = locala.xky.mL();
        GMTrace.o(13096294809600L, 97575);
        return 0;
      case 5: 
        localanp.tRd = locala.xky.mL();
        GMTrace.o(13096294809600L, 97575);
        return 0;
      case 6: 
        localanp.tRe = locala.xky.mL();
        GMTrace.o(13096294809600L, 97575);
        return 0;
      }
      localanp.tRf = locala.xky.mL();
      GMTrace.o(13096294809600L, 97575);
      return 0;
    }
    GMTrace.o(13096294809600L, 97575);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/anp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */