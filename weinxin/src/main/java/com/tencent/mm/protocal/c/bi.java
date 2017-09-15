package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bi
  extends com.tencent.mm.bd.a
{
  public int tdd;
  public String username;
  
  public bi()
  {
    GMTrace.i(3966939168768L, 29556);
    GMTrace.o(3966939168768L, 29556);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3967073386496L, 29557);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.eO(2, this.tdd);
      GMTrace.o(3967073386496L, 29557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label290;
      }
    }
    label290:
    for (paramInt = a.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = a.a.a.a.eL(2, this.tdd);
      GMTrace.o(3967073386496L, 29557);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3967073386496L, 29557);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        bi localbi = (bi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3967073386496L, 29557);
          return -1;
        case 1: 
          localbi.username = locala.xky.readString();
          GMTrace.o(3967073386496L, 29557);
          return 0;
        }
        localbi.tdd = locala.xky.mL();
        GMTrace.o(3967073386496L, 29557);
        return 0;
      }
      GMTrace.o(3967073386496L, 29557);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */