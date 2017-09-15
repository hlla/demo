package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class atb
  extends com.tencent.mm.bd.a
{
  public String tVA;
  public String tVB;
  
  public atb()
  {
    GMTrace.i(13578270670848L, 101166);
    GMTrace.o(13578270670848L, 101166);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13578404888576L, 101167);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tVA != null) {
        paramVarArgs.e(1, this.tVA);
      }
      if (this.tVB != null) {
        paramVarArgs.e(2, this.tVB);
      }
      GMTrace.o(13578404888576L, 101167);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tVA == null) {
        break label298;
      }
    }
    label298:
    for (paramInt = a.a.a.b.b.a.f(1, this.tVA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tVB != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tVB);
      }
      GMTrace.o(13578404888576L, 101167);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(13578404888576L, 101167);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        atb localatb = (atb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(13578404888576L, 101167);
          return -1;
        case 1: 
          localatb.tVA = locala.xky.readString();
          GMTrace.o(13578404888576L, 101167);
          return 0;
        }
        localatb.tVB = locala.xky.readString();
        GMTrace.o(13578404888576L, 101167);
        return 0;
      }
      GMTrace.o(13578404888576L, 101167);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/atb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */