package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;

public final class bk
  extends com.tencent.mm.bd.a
{
  public String hnA;
  public long hnB;
  public int key;
  
  public bk()
  {
    GMTrace.i(690013339648L, 5141);
    GMTrace.o(690013339648L, 5141);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(690147557376L, 5142);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.key);
      if (this.hnA != null) {
        paramVarArgs.e(2, this.hnA);
      }
      paramVarArgs.O(3, this.hnB);
      GMTrace.o(690147557376L, 5142);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.key) + 0;
      paramInt = i;
      if (this.hnA != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.hnA);
      }
      i = a.a.a.a.N(3, this.hnB);
      GMTrace.o(690147557376L, 5142);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(690147557376L, 5142);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bk localbk = (bk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(690147557376L, 5142);
        return -1;
      case 1: 
        localbk.key = locala.xky.mL();
        GMTrace.o(690147557376L, 5142);
        return 0;
      case 2: 
        localbk.hnA = locala.xky.readString();
        GMTrace.o(690147557376L, 5142);
        return 0;
      }
      localbk.hnB = locala.xky.mM();
      GMTrace.o(690147557376L, 5142);
      return 0;
    }
    GMTrace.o(690147557376L, 5142);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */