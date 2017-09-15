package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ct
  extends com.tencent.mm.bd.a
{
  public String tel;
  public String tem;
  
  public ct()
  {
    GMTrace.i(3733266104320L, 27815);
    GMTrace.o(3733266104320L, 27815);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3733400322048L, 27816);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tel != null) {
        paramVarArgs.e(1, this.tel);
      }
      if (this.tem != null) {
        paramVarArgs.e(2, this.tem);
      }
      GMTrace.o(3733400322048L, 27816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tel == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = a.a.a.b.b.a.f(1, this.tel) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tem != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tem);
      }
      GMTrace.o(3733400322048L, 27816);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3733400322048L, 27816);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ct localct = (ct)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3733400322048L, 27816);
          return -1;
        case 1: 
          localct.tel = locala.xky.readString();
          GMTrace.o(3733400322048L, 27816);
          return 0;
        }
        localct.tem = locala.xky.readString();
        GMTrace.o(3733400322048L, 27816);
        return 0;
      }
      GMTrace.o(3733400322048L, 27816);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */