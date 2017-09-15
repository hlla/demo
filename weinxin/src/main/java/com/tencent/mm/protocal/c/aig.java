package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aig
  extends com.tencent.mm.bd.a
{
  public String oSl;
  public String tKF;
  
  public aig()
  {
    GMTrace.i(3745882570752L, 27909);
    GMTrace.o(3745882570752L, 27909);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3746016788480L, 27910);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.oSl != null) {
        paramVarArgs.e(1, this.oSl);
      }
      if (this.tKF != null) {
        paramVarArgs.e(2, this.tKF);
      }
      GMTrace.o(3746016788480L, 27910);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oSl == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = a.a.a.b.b.a.f(1, this.oSl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tKF != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tKF);
      }
      GMTrace.o(3746016788480L, 27910);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3746016788480L, 27910);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        aig localaig = (aig)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3746016788480L, 27910);
          return -1;
        case 1: 
          localaig.oSl = locala.xky.readString();
          GMTrace.o(3746016788480L, 27910);
          return 0;
        }
        localaig.tKF = locala.xky.readString();
        GMTrace.o(3746016788480L, 27910);
        return 0;
      }
      GMTrace.o(3746016788480L, 27910);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */