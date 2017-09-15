package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class amp
  extends com.tencent.mm.bd.a
{
  public int mse;
  public String oSl;
  
  public amp()
  {
    GMTrace.i(13334128623616L, 99347);
    GMTrace.o(13334128623616L, 99347);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13334262841344L, 99348);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.mse);
      if (this.oSl != null) {
        paramVarArgs.e(2, this.oSl);
      }
      GMTrace.o(13334262841344L, 99348);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.mse) + 0;
      paramInt = i;
      if (this.oSl != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.oSl);
      }
      GMTrace.o(13334262841344L, 99348);
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
      GMTrace.o(13334262841344L, 99348);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      amp localamp = (amp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13334262841344L, 99348);
        return -1;
      case 1: 
        localamp.mse = locala.xky.mL();
        GMTrace.o(13334262841344L, 99348);
        return 0;
      }
      localamp.oSl = locala.xky.readString();
      GMTrace.o(13334262841344L, 99348);
      return 0;
    }
    GMTrace.o(13334262841344L, 99348);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/amp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */