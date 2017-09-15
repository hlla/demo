package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bdr
  extends com.tencent.mm.bd.a
{
  public int oSb;
  public String udp;
  
  public bdr()
  {
    GMTrace.i(13573573050368L, 101131);
    GMTrace.o(13573573050368L, 101131);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13573707268096L, 101132);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.oSb);
      if (this.udp != null) {
        paramVarArgs.e(2, this.udp);
      }
      GMTrace.o(13573707268096L, 101132);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.oSb) + 0;
      paramInt = i;
      if (this.udp != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.udp);
      }
      GMTrace.o(13573707268096L, 101132);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13573707268096L, 101132);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bdr localbdr = (bdr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13573707268096L, 101132);
        return -1;
      case 1: 
        localbdr.oSb = locala.xky.mL();
        GMTrace.o(13573707268096L, 101132);
        return 0;
      }
      localbdr.udp = locala.xky.readString();
      GMTrace.o(13573707268096L, 101132);
      return 0;
    }
    GMTrace.o(13573707268096L, 101132);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bdr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */