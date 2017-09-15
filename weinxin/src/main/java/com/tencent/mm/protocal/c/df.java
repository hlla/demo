package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class df
  extends com.tencent.mm.bd.a
{
  public String tfa;
  
  public df()
  {
    GMTrace.i(3630857977856L, 27052);
    GMTrace.o(3630857977856L, 27052);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3630992195584L, 27053);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tfa != null) {
        paramVarArgs.e(1, this.tfa);
      }
      GMTrace.o(3630992195584L, 27053);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tfa == null) {
        break label241;
      }
    }
    label241:
    for (paramInt = a.a.a.b.b.a.f(1, this.tfa) + 0;; paramInt = 0)
    {
      GMTrace.o(3630992195584L, 27053);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3630992195584L, 27053);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        df localdf = (df)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3630992195584L, 27053);
          return -1;
        }
        localdf.tfa = locala.xky.readString();
        GMTrace.o(3630992195584L, 27053);
        return 0;
      }
      GMTrace.o(3630992195584L, 27053);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */