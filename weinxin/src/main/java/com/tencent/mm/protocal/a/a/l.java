package com.tencent.mm.protocal.a.a;

import com.tencent.gmtrace.GMTrace;

public final class l
  extends com.tencent.mm.bd.a
{
  public int action;
  public int sZf;
  public int sZg;
  public int sZh;
  public int sZi;
  public int sZj;
  public int sZk;
  public int sZl;
  
  public l()
  {
    GMTrace.i(13102200389632L, 97619);
    GMTrace.o(13102200389632L, 97619);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13102334607360L, 97620);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.sZf);
      paramVarArgs.eO(2, this.action);
      paramVarArgs.eO(3, this.sZg);
      paramVarArgs.eO(4, this.sZh);
      paramVarArgs.eO(5, this.sZi);
      paramVarArgs.eO(6, this.sZj);
      paramVarArgs.eO(7, this.sZk);
      paramVarArgs.eO(8, this.sZl);
      GMTrace.o(13102334607360L, 97620);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.sZf);
      int i = a.a.a.a.eL(2, this.action);
      int j = a.a.a.a.eL(3, this.sZg);
      int k = a.a.a.a.eL(4, this.sZh);
      int m = a.a.a.a.eL(5, this.sZi);
      int n = a.a.a.a.eL(6, this.sZj);
      int i1 = a.a.a.a.eL(7, this.sZk);
      int i2 = a.a.a.a.eL(8, this.sZl);
      GMTrace.o(13102334607360L, 97620);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13102334607360L, 97620);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13102334607360L, 97620);
        return -1;
      case 1: 
        locall.sZf = locala.xky.mL();
        GMTrace.o(13102334607360L, 97620);
        return 0;
      case 2: 
        locall.action = locala.xky.mL();
        GMTrace.o(13102334607360L, 97620);
        return 0;
      case 3: 
        locall.sZg = locala.xky.mL();
        GMTrace.o(13102334607360L, 97620);
        return 0;
      case 4: 
        locall.sZh = locala.xky.mL();
        GMTrace.o(13102334607360L, 97620);
        return 0;
      case 5: 
        locall.sZi = locala.xky.mL();
        GMTrace.o(13102334607360L, 97620);
        return 0;
      case 6: 
        locall.sZj = locala.xky.mL();
        GMTrace.o(13102334607360L, 97620);
        return 0;
      case 7: 
        locall.sZk = locala.xky.mL();
        GMTrace.o(13102334607360L, 97620);
        return 0;
      }
      locall.sZl = locala.xky.mL();
      GMTrace.o(13102334607360L, 97620);
      return 0;
    }
    GMTrace.o(13102334607360L, 97620);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */