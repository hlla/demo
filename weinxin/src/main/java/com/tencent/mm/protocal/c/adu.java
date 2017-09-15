package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class adu
  extends com.tencent.mm.bd.a
{
  public String fDt;
  public String mqJ;
  public String mtt;
  public String tHH;
  public String tHI;
  
  public adu()
  {
    GMTrace.i(3842787770368L, 28631);
    GMTrace.o(3842787770368L, 28631);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3842921988096L, 28632);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tHH != null) {
        paramVarArgs.e(1, this.tHH);
      }
      if (this.mtt != null) {
        paramVarArgs.e(2, this.mtt);
      }
      if (this.fDt != null) {
        paramVarArgs.e(3, this.fDt);
      }
      if (this.mqJ != null) {
        paramVarArgs.e(4, this.mqJ);
      }
      if (this.tHI != null) {
        paramVarArgs.e(5, this.tHI);
      }
      GMTrace.o(3842921988096L, 28632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tHH == null) {
        break label498;
      }
    }
    label498:
    for (int i = a.a.a.b.b.a.f(1, this.tHH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mtt != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.mtt);
      }
      i = paramInt;
      if (this.fDt != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.fDt);
      }
      paramInt = i;
      if (this.mqJ != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.mqJ);
      }
      i = paramInt;
      if (this.tHI != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tHI);
      }
      GMTrace.o(3842921988096L, 28632);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3842921988096L, 28632);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        adu localadu = (adu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3842921988096L, 28632);
          return -1;
        case 1: 
          localadu.tHH = locala.xky.readString();
          GMTrace.o(3842921988096L, 28632);
          return 0;
        case 2: 
          localadu.mtt = locala.xky.readString();
          GMTrace.o(3842921988096L, 28632);
          return 0;
        case 3: 
          localadu.fDt = locala.xky.readString();
          GMTrace.o(3842921988096L, 28632);
          return 0;
        case 4: 
          localadu.mqJ = locala.xky.readString();
          GMTrace.o(3842921988096L, 28632);
          return 0;
        }
        localadu.tHI = locala.xky.readString();
        GMTrace.o(3842921988096L, 28632);
        return 0;
      }
      GMTrace.o(3842921988096L, 28632);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/adu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */