package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class avw
  extends com.tencent.mm.bd.a
{
  public String mqI;
  public int ofk;
  public String tfX;
  public String trP;
  
  public avw()
  {
    GMTrace.i(13168235511808L, 98111);
    GMTrace.o(13168235511808L, 98111);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13168369729536L, 98112);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.mqI != null) {
        paramVarArgs.e(1, this.mqI);
      }
      if (this.trP != null) {
        paramVarArgs.e(2, this.trP);
      }
      if (this.tfX != null) {
        paramVarArgs.e(3, this.tfX);
      }
      paramVarArgs.eO(4, this.ofk);
      GMTrace.o(13168369729536L, 98112);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mqI == null) {
        break label408;
      }
    }
    label408:
    for (int i = a.a.a.b.b.a.f(1, this.mqI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.trP != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.trP);
      }
      i = paramInt;
      if (this.tfX != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tfX);
      }
      paramInt = a.a.a.a.eL(4, this.ofk);
      GMTrace.o(13168369729536L, 98112);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(13168369729536L, 98112);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        avw localavw = (avw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(13168369729536L, 98112);
          return -1;
        case 1: 
          localavw.mqI = locala.xky.readString();
          GMTrace.o(13168369729536L, 98112);
          return 0;
        case 2: 
          localavw.trP = locala.xky.readString();
          GMTrace.o(13168369729536L, 98112);
          return 0;
        case 3: 
          localavw.tfX = locala.xky.readString();
          GMTrace.o(13168369729536L, 98112);
          return 0;
        }
        localavw.ofk = locala.xky.mL();
        GMTrace.o(13168369729536L, 98112);
        return 0;
      }
      GMTrace.o(13168369729536L, 98112);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/avw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */