package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class amq
  extends com.tencent.mm.bd.a
{
  public int tPA;
  public String tPo;
  
  public amq()
  {
    GMTrace.i(13335739236352L, 99359);
    GMTrace.o(13335739236352L, 99359);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13335873454080L, 99360);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tPo != null) {
        paramVarArgs.e(1, this.tPo);
      }
      paramVarArgs.eO(2, this.tPA);
      GMTrace.o(13335873454080L, 99360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tPo == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = a.a.a.b.b.a.f(1, this.tPo) + 0;; paramInt = 0)
    {
      int i = a.a.a.a.eL(2, this.tPA);
      GMTrace.o(13335873454080L, 99360);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(13335873454080L, 99360);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        amq localamq = (amq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(13335873454080L, 99360);
          return -1;
        case 1: 
          localamq.tPo = locala.xky.readString();
          GMTrace.o(13335873454080L, 99360);
          return 0;
        }
        localamq.tPA = locala.xky.mL();
        GMTrace.o(13335873454080L, 99360);
        return 0;
      }
      GMTrace.o(13335873454080L, 99360);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/amq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */