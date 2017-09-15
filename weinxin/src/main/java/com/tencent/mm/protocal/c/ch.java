package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ch
  extends com.tencent.mm.bd.a
{
  public String signature;
  public String tdU;
  
  public ch()
  {
    GMTrace.i(3944390590464L, 29388);
    GMTrace.o(3944390590464L, 29388);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3944524808192L, 29389);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.signature != null) {
        paramVarArgs.e(1, this.signature);
      }
      if (this.tdU != null) {
        paramVarArgs.e(2, this.tdU);
      }
      GMTrace.o(3944524808192L, 29389);
      return 0;
    }
    if (paramInt == 1) {
      if (this.signature == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = a.a.a.b.b.a.f(1, this.signature) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tdU != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tdU);
      }
      GMTrace.o(3944524808192L, 29389);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3944524808192L, 29389);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ch localch = (ch)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3944524808192L, 29389);
          return -1;
        case 1: 
          localch.signature = locala.xky.readString();
          GMTrace.o(3944524808192L, 29389);
          return 0;
        }
        localch.tdU = locala.xky.readString();
        GMTrace.o(3944524808192L, 29389);
        return 0;
      }
      GMTrace.o(3944524808192L, 29389);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */