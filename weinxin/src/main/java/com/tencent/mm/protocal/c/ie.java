package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ie
  extends com.tencent.mm.bd.a
{
  public int tkT;
  public int tkU;
  public int tkV;
  public int tkW;
  public int tkX;
  public int tkY;
  
  public ie()
  {
    GMTrace.i(14518063202304L, 108168);
    GMTrace.o(14518063202304L, 108168);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(14518197420032L, 108169);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tkT);
      paramVarArgs.eO(2, this.tkU);
      paramVarArgs.eO(3, this.tkV);
      paramVarArgs.eO(4, this.tkW);
      paramVarArgs.eO(5, this.tkX);
      paramVarArgs.eO(6, this.tkY);
      GMTrace.o(14518197420032L, 108169);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tkT);
      int i = a.a.a.a.eL(2, this.tkU);
      int j = a.a.a.a.eL(3, this.tkV);
      int k = a.a.a.a.eL(4, this.tkW);
      int m = a.a.a.a.eL(5, this.tkX);
      int n = a.a.a.a.eL(6, this.tkY);
      GMTrace.o(14518197420032L, 108169);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(14518197420032L, 108169);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      ie localie = (ie)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(14518197420032L, 108169);
        return -1;
      case 1: 
        localie.tkT = locala.xky.mL();
        GMTrace.o(14518197420032L, 108169);
        return 0;
      case 2: 
        localie.tkU = locala.xky.mL();
        GMTrace.o(14518197420032L, 108169);
        return 0;
      case 3: 
        localie.tkV = locala.xky.mL();
        GMTrace.o(14518197420032L, 108169);
        return 0;
      case 4: 
        localie.tkW = locala.xky.mL();
        GMTrace.o(14518197420032L, 108169);
        return 0;
      case 5: 
        localie.tkX = locala.xky.mL();
        GMTrace.o(14518197420032L, 108169);
        return 0;
      }
      localie.tkY = locala.xky.mL();
      GMTrace.o(14518197420032L, 108169);
      return 0;
    }
    GMTrace.o(14518197420032L, 108169);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */