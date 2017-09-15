package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bdg
  extends com.tencent.mm.bd.a
{
  public String mqI;
  public String ucU;
  
  public bdg()
  {
    GMTrace.i(3852719882240L, 28705);
    GMTrace.o(3852719882240L, 28705);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3852854099968L, 28706);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.mqI != null) {
        paramVarArgs.e(1, this.mqI);
      }
      if (this.ucU != null) {
        paramVarArgs.e(2, this.ucU);
      }
      GMTrace.o(3852854099968L, 28706);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mqI == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = a.a.a.b.b.a.f(1, this.mqI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ucU != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.ucU);
      }
      GMTrace.o(3852854099968L, 28706);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3852854099968L, 28706);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        bdg localbdg = (bdg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3852854099968L, 28706);
          return -1;
        case 1: 
          localbdg.mqI = locala.xky.readString();
          GMTrace.o(3852854099968L, 28706);
          return 0;
        }
        localbdg.ucU = locala.xky.readString();
        GMTrace.o(3852854099968L, 28706);
        return 0;
      }
      GMTrace.o(3852854099968L, 28706);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bdg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */