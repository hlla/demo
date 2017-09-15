package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class da
  extends com.tencent.mm.bd.a
{
  public com.tencent.mm.bd.b teO;
  
  public da()
  {
    GMTrace.i(3690316431360L, 27495);
    GMTrace.o(3690316431360L, 27495);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3690450649088L, 27496);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.teO == null) {
        throw new a.a.a.b("Not all required fields were included: Cookies");
      }
      if (this.teO != null) {
        paramVarArgs.b(1, this.teO);
      }
      GMTrace.o(3690450649088L, 27496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.teO == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = a.a.a.a.a(1, this.teO) + 0;; paramInt = 0)
    {
      GMTrace.o(3690450649088L, 27496);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        if (this.teO == null) {
          throw new a.a.a.b("Not all required fields were included: Cookies");
        }
        GMTrace.o(3690450649088L, 27496);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        da localda = (da)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3690450649088L, 27496);
          return -1;
        }
        localda.teO = locala.chR();
        GMTrace.o(3690450649088L, 27496);
        return 0;
      }
      GMTrace.o(3690450649088L, 27496);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */