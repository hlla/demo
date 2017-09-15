package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class bfb
  extends com.tencent.mm.bd.a
{
  public String arH;
  public String value;
  
  public bfb()
  {
    GMTrace.i(18982279053312L, 141429);
    GMTrace.o(18982279053312L, 141429);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(18982413271040L, 141430);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.arH == null) {
        throw new b("Not all required fields were included: key");
      }
      if (this.value == null) {
        throw new b("Not all required fields were included: value");
      }
      if (this.arH != null) {
        paramVarArgs.e(1, this.arH);
      }
      if (this.value != null) {
        paramVarArgs.e(2, this.value);
      }
      GMTrace.o(18982413271040L, 141430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.arH == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = a.a.a.b.b.a.f(1, this.arH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.value != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.value);
      }
      GMTrace.o(18982413271040L, 141430);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        if (this.arH == null) {
          throw new b("Not all required fields were included: key");
        }
        if (this.value == null) {
          throw new b("Not all required fields were included: value");
        }
        GMTrace.o(18982413271040L, 141430);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        bfb localbfb = (bfb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(18982413271040L, 141430);
          return -1;
        case 1: 
          localbfb.arH = locala.xky.readString();
          GMTrace.o(18982413271040L, 141430);
          return 0;
        }
        localbfb.value = locala.xky.readString();
        GMTrace.o(18982413271040L, 141430);
        return 0;
      }
      GMTrace.o(18982413271040L, 141430);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */