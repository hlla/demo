package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class gs
  extends com.tencent.mm.bd.a
{
  public String kfF;
  public String tjg;
  public int ver;
  
  public gs()
  {
    GMTrace.i(3685216157696L, 27457);
    GMTrace.o(3685216157696L, 27457);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3685350375424L, 27458);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tjg != null) {
        paramVarArgs.e(1, this.tjg);
      }
      if (this.kfF != null) {
        paramVarArgs.e(2, this.kfF);
      }
      paramVarArgs.eO(3, this.ver);
      GMTrace.o(3685350375424L, 27458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tjg == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = a.a.a.b.b.a.f(1, this.tjg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kfF != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.kfF);
      }
      paramInt = a.a.a.a.eL(3, this.ver);
      GMTrace.o(3685350375424L, 27458);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3685350375424L, 27458);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        gs localgs = (gs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3685350375424L, 27458);
          return -1;
        case 1: 
          localgs.tjg = locala.xky.readString();
          GMTrace.o(3685350375424L, 27458);
          return 0;
        case 2: 
          localgs.kfF = locala.xky.readString();
          GMTrace.o(3685350375424L, 27458);
          return 0;
        }
        localgs.ver = locala.xky.mL();
        GMTrace.o(3685350375424L, 27458);
        return 0;
      }
      GMTrace.o(3685350375424L, 27458);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/gs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */