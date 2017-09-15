package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class adw
  extends com.tencent.mm.bd.a
{
  public String tHJ;
  public int tHK;
  public int tHL;
  
  public adw()
  {
    GMTrace.i(13339497332736L, 99387);
    GMTrace.o(13339497332736L, 99387);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13339631550464L, 99388);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tHJ != null) {
        paramVarArgs.e(1, this.tHJ);
      }
      paramVarArgs.eO(2, this.tHK);
      paramVarArgs.eO(3, this.tHL);
      GMTrace.o(13339631550464L, 99388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tHJ == null) {
        break label333;
      }
    }
    label333:
    for (paramInt = a.a.a.b.b.a.f(1, this.tHJ) + 0;; paramInt = 0)
    {
      int i = a.a.a.a.eL(2, this.tHK);
      int j = a.a.a.a.eL(3, this.tHL);
      GMTrace.o(13339631550464L, 99388);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(13339631550464L, 99388);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        adw localadw = (adw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(13339631550464L, 99388);
          return -1;
        case 1: 
          localadw.tHJ = locala.xky.readString();
          GMTrace.o(13339631550464L, 99388);
          return 0;
        case 2: 
          localadw.tHK = locala.xky.mL();
          GMTrace.o(13339631550464L, 99388);
          return 0;
        }
        localadw.tHL = locala.xky.mL();
        GMTrace.o(13339631550464L, 99388);
        return 0;
      }
      GMTrace.o(13339631550464L, 99388);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/adw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */