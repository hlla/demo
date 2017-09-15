package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class jx
  extends com.tencent.mm.bd.a
{
  public String jLx;
  
  public jx()
  {
    GMTrace.i(3766820536320L, 28065);
    GMTrace.o(3766820536320L, 28065);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3766954754048L, 28066);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.jLx != null) {
        paramVarArgs.e(1, this.jLx);
      }
      GMTrace.o(3766954754048L, 28066);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jLx == null) {
        break label241;
      }
    }
    label241:
    for (paramInt = a.a.a.b.b.a.f(1, this.jLx) + 0;; paramInt = 0)
    {
      GMTrace.o(3766954754048L, 28066);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3766954754048L, 28066);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        jx localjx = (jx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3766954754048L, 28066);
          return -1;
        }
        localjx.jLx = locala.xky.readString();
        GMTrace.o(3766954754048L, 28066);
        return 0;
      }
      GMTrace.o(3766954754048L, 28066);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/jx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */