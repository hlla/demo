package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bpj
  extends com.tencent.mm.bd.a
{
  public String tFx;
  public String tFy;
  
  public bpj()
  {
    GMTrace.i(13577465364480L, 101160);
    GMTrace.o(13577465364480L, 101160);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13577599582208L, 101161);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tFx != null) {
        paramVarArgs.e(1, this.tFx);
      }
      if (this.tFy != null) {
        paramVarArgs.e(2, this.tFy);
      }
      GMTrace.o(13577599582208L, 101161);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label298;
      }
    }
    label298:
    for (paramInt = a.a.a.b.b.a.f(1, this.tFx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tFy != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tFy);
      }
      GMTrace.o(13577599582208L, 101161);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(13577599582208L, 101161);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        bpj localbpj = (bpj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(13577599582208L, 101161);
          return -1;
        case 1: 
          localbpj.tFx = locala.xky.readString();
          GMTrace.o(13577599582208L, 101161);
          return 0;
        }
        localbpj.tFy = locala.xky.readString();
        GMTrace.o(13577599582208L, 101161);
        return 0;
      }
      GMTrace.o(13577599582208L, 101161);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bpj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */