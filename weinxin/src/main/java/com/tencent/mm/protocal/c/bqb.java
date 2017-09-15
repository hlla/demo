package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bqb
  extends com.tencent.mm.bd.a
{
  public String umI;
  public String umJ;
  
  public bqb()
  {
    GMTrace.i(14306536062976L, 106592);
    GMTrace.o(14306536062976L, 106592);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(14306670280704L, 106593);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.umI != null) {
        paramVarArgs.e(1, this.umI);
      }
      if (this.umJ != null) {
        paramVarArgs.e(2, this.umJ);
      }
      GMTrace.o(14306670280704L, 106593);
      return 0;
    }
    if (paramInt == 1) {
      if (this.umI == null) {
        break label298;
      }
    }
    label298:
    for (paramInt = a.a.a.b.b.a.f(1, this.umI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.umJ != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.umJ);
      }
      GMTrace.o(14306670280704L, 106593);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(14306670280704L, 106593);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        bqb localbqb = (bqb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(14306670280704L, 106593);
          return -1;
        case 1: 
          localbqb.umI = locala.xky.readString();
          GMTrace.o(14306670280704L, 106593);
          return 0;
        }
        localbqb.umJ = locala.xky.readString();
        GMTrace.o(14306670280704L, 106593);
        return 0;
      }
      GMTrace.o(14306670280704L, 106593);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */