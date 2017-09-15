package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class afl
  extends com.tencent.mm.bd.a
{
  public double hQF;
  public int major;
  public int minor;
  public String mpX;
  
  public afl()
  {
    GMTrace.i(3966670733312L, 29554);
    GMTrace.o(3966670733312L, 29554);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3966804951040L, 29555);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.mpX != null) {
        paramVarArgs.e(1, this.mpX);
      }
      paramVarArgs.eO(2, this.major);
      paramVarArgs.eO(3, this.minor);
      paramVarArgs.a(4, this.hQF);
      GMTrace.o(3966804951040L, 29555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mpX == null) {
        break label390;
      }
    }
    label390:
    for (paramInt = a.a.a.b.b.a.f(1, this.mpX) + 0;; paramInt = 0)
    {
      int i = a.a.a.a.eL(2, this.major);
      int j = a.a.a.a.eL(3, this.minor);
      int k = a.a.a.b.b.a.cH(4);
      GMTrace.o(3966804951040L, 29555);
      return paramInt + i + j + (k + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3966804951040L, 29555);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        afl localafl = (afl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3966804951040L, 29555);
          return -1;
        case 1: 
          localafl.mpX = locala.xky.readString();
          GMTrace.o(3966804951040L, 29555);
          return 0;
        case 2: 
          localafl.major = locala.xky.mL();
          GMTrace.o(3966804951040L, 29555);
          return 0;
        case 3: 
          localafl.minor = locala.xky.mL();
          GMTrace.o(3966804951040L, 29555);
          return 0;
        }
        localafl.hQF = locala.xky.readDouble();
        GMTrace.o(3966804951040L, 29555);
        return 0;
      }
      GMTrace.o(3966804951040L, 29555);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/afl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */