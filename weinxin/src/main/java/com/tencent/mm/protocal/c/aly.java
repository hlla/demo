package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aly
  extends com.tencent.mm.bd.a
{
  public String jLx;
  public int oSc;
  public int tOR;
  public String trI;
  
  public aly()
  {
    GMTrace.i(3721991815168L, 27731);
    GMTrace.o(3721991815168L, 27731);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3722126032896L, 27732);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trI != null) {
        paramVarArgs.e(1, this.trI);
      }
      if (this.jLx != null) {
        paramVarArgs.e(2, this.jLx);
      }
      paramVarArgs.eO(3, this.tOR);
      paramVarArgs.eO(4, this.oSc);
      GMTrace.o(3722126032896L, 27732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.trI == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = a.a.a.b.b.a.f(1, this.trI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jLx != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.jLx);
      }
      paramInt = a.a.a.a.eL(3, this.tOR);
      int j = a.a.a.a.eL(4, this.oSc);
      GMTrace.o(3722126032896L, 27732);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3722126032896L, 27732);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        aly localaly = (aly)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3722126032896L, 27732);
          return -1;
        case 1: 
          localaly.trI = locala.xky.readString();
          GMTrace.o(3722126032896L, 27732);
          return 0;
        case 2: 
          localaly.jLx = locala.xky.readString();
          GMTrace.o(3722126032896L, 27732);
          return 0;
        case 3: 
          localaly.tOR = locala.xky.mL();
          GMTrace.o(3722126032896L, 27732);
          return 0;
        }
        localaly.oSc = locala.xky.mL();
        GMTrace.o(3722126032896L, 27732);
        return 0;
      }
      GMTrace.o(3722126032896L, 27732);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */