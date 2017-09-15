package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aof
  extends com.tencent.mm.bd.a
{
  public int tRJ;
  public String tRK;
  public String tRL;
  public int tkk;
  public int tpX;
  
  public aof()
  {
    GMTrace.i(3662801797120L, 27290);
    GMTrace.o(3662801797120L, 27290);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3662936014848L, 27291);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tkk);
      if (this.tRL != null) {
        paramVarArgs.e(3, this.tRL);
      }
      paramVarArgs.eO(4, this.tRJ);
      paramVarArgs.eO(5, this.tpX);
      if (this.tRK != null) {
        paramVarArgs.e(6, this.tRK);
      }
      GMTrace.o(3662936014848L, 27291);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.tkk) + 0;
      paramInt = i;
      if (this.tRL != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.tRL);
      }
      i = paramInt + a.a.a.a.eL(4, this.tRJ) + a.a.a.a.eL(5, this.tpX);
      paramInt = i;
      if (this.tRK != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tRK);
      }
      GMTrace.o(3662936014848L, 27291);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3662936014848L, 27291);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      aof localaof = (aof)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        GMTrace.o(3662936014848L, 27291);
        return -1;
      case 1: 
        localaof.tkk = locala.xky.mL();
        GMTrace.o(3662936014848L, 27291);
        return 0;
      case 3: 
        localaof.tRL = locala.xky.readString();
        GMTrace.o(3662936014848L, 27291);
        return 0;
      case 4: 
        localaof.tRJ = locala.xky.mL();
        GMTrace.o(3662936014848L, 27291);
        return 0;
      case 5: 
        localaof.tpX = locala.xky.mL();
        GMTrace.o(3662936014848L, 27291);
        return 0;
      }
      localaof.tRK = locala.xky.readString();
      GMTrace.o(3662936014848L, 27291);
      return 0;
    }
    GMTrace.o(3662936014848L, 27291);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aof.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */