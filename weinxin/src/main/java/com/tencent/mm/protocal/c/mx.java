package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class mx
  extends com.tencent.mm.bd.a
{
  public String hAA;
  public String hAB;
  public String hAC;
  public int hAz;
  
  public mx()
  {
    GMTrace.i(13338960461824L, 99383);
    GMTrace.o(13338960461824L, 99383);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13339094679552L, 99384);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.hAz);
      if (this.hAA != null) {
        paramVarArgs.e(2, this.hAA);
      }
      if (this.hAB != null) {
        paramVarArgs.e(3, this.hAB);
      }
      if (this.hAC != null) {
        paramVarArgs.e(4, this.hAC);
      }
      GMTrace.o(13339094679552L, 99384);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.hAz) + 0;
      paramInt = i;
      if (this.hAA != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.hAA);
      }
      i = paramInt;
      if (this.hAB != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.hAB);
      }
      paramInt = i;
      if (this.hAC != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.hAC);
      }
      GMTrace.o(13339094679552L, 99384);
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
      GMTrace.o(13339094679552L, 99384);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      mx localmx = (mx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13339094679552L, 99384);
        return -1;
      case 1: 
        localmx.hAz = locala.xky.mL();
        GMTrace.o(13339094679552L, 99384);
        return 0;
      case 2: 
        localmx.hAA = locala.xky.readString();
        GMTrace.o(13339094679552L, 99384);
        return 0;
      case 3: 
        localmx.hAB = locala.xky.readString();
        GMTrace.o(13339094679552L, 99384);
        return 0;
      }
      localmx.hAC = locala.xky.readString();
      GMTrace.o(13339094679552L, 99384);
      return 0;
    }
    GMTrace.o(13339094679552L, 99384);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/mx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */