package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aor
  extends com.tencent.mm.bd.a
{
  public String fDt;
  public String oog;
  
  public aor()
  {
    GMTrace.i(13334933929984L, 99353);
    GMTrace.o(13334933929984L, 99353);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13335068147712L, 99354);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.oog != null) {
        paramVarArgs.e(1, this.oog);
      }
      if (this.fDt != null) {
        paramVarArgs.e(2, this.fDt);
      }
      GMTrace.o(13335068147712L, 99354);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oog == null) {
        break label298;
      }
    }
    label298:
    for (paramInt = a.a.a.b.b.a.f(1, this.oog) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fDt != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.fDt);
      }
      GMTrace.o(13335068147712L, 99354);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(13335068147712L, 99354);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        aor localaor = (aor)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(13335068147712L, 99354);
          return -1;
        case 1: 
          localaor.oog = locala.xky.readString();
          GMTrace.o(13335068147712L, 99354);
          return 0;
        }
        localaor.fDt = locala.xky.readString();
        GMTrace.o(13335068147712L, 99354);
        return 0;
      }
      GMTrace.o(13335068147712L, 99354);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */