package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class lz
  extends com.tencent.mm.bd.a
{
  public String arH;
  public long tqA;
  public String tqB;
  
  public lz()
  {
    GMTrace.i(4027874017280L, 30010);
    GMTrace.o(4027874017280L, 30010);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4028008235008L, 30011);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.arH == null) {
        throw new b("Not all required fields were included: key");
      }
      if (this.arH != null) {
        paramVarArgs.e(1, this.arH);
      }
      paramVarArgs.O(2, this.tqA);
      if (this.tqB != null) {
        paramVarArgs.e(3, this.tqB);
      }
      GMTrace.o(4028008235008L, 30011);
      return 0;
    }
    if (paramInt == 1) {
      if (this.arH == null) {
        break label390;
      }
    }
    label390:
    for (paramInt = a.a.a.b.b.a.f(1, this.arH) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.N(2, this.tqA);
      paramInt = i;
      if (this.tqB != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.tqB);
      }
      GMTrace.o(4028008235008L, 30011);
      return paramInt;
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
        GMTrace.o(4028008235008L, 30011);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        lz locallz = (lz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(4028008235008L, 30011);
          return -1;
        case 1: 
          locallz.arH = locala.xky.readString();
          GMTrace.o(4028008235008L, 30011);
          return 0;
        case 2: 
          locallz.tqA = locala.xky.mM();
          GMTrace.o(4028008235008L, 30011);
          return 0;
        }
        locallz.tqB = locala.xky.readString();
        GMTrace.o(4028008235008L, 30011);
        return 0;
      }
      GMTrace.o(4028008235008L, 30011);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/lz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */