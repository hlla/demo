package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bcl
  extends com.tencent.mm.bd.a
{
  public int hAw;
  public String hAx;
  public long hAy;
  public int ubT;
  
  public bcl()
  {
    GMTrace.i(13340571074560L, 99395);
    GMTrace.o(13340571074560L, 99395);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13340705292288L, 99396);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.hAw);
      if (this.hAx != null) {
        paramVarArgs.e(2, this.hAx);
      }
      paramVarArgs.O(3, this.hAy);
      paramVarArgs.eO(4, this.ubT);
      GMTrace.o(13340705292288L, 99396);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.hAw) + 0;
      paramInt = i;
      if (this.hAx != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.hAx);
      }
      i = a.a.a.a.N(3, this.hAy);
      int j = a.a.a.a.eL(4, this.ubT);
      GMTrace.o(13340705292288L, 99396);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13340705292288L, 99396);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bcl localbcl = (bcl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13340705292288L, 99396);
        return -1;
      case 1: 
        localbcl.hAw = locala.xky.mL();
        GMTrace.o(13340705292288L, 99396);
        return 0;
      case 2: 
        localbcl.hAx = locala.xky.readString();
        GMTrace.o(13340705292288L, 99396);
        return 0;
      case 3: 
        localbcl.hAy = locala.xky.mM();
        GMTrace.o(13340705292288L, 99396);
        return 0;
      }
      localbcl.ubT = locala.xky.mL();
      GMTrace.o(13340705292288L, 99396);
      return 0;
    }
    GMTrace.o(13340705292288L, 99396);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bcl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */