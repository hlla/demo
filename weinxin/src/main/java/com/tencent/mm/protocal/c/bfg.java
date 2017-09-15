package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bfg
  extends com.tencent.mm.bd.a
{
  public String tlE;
  public String tsK;
  public int uei;
  public int uej;
  public long uek;
  
  public bfg()
  {
    GMTrace.i(3750445973504L, 27943);
    GMTrace.o(3750445973504L, 27943);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3750580191232L, 27944);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.uei);
      if (this.tlE != null) {
        paramVarArgs.e(2, this.tlE);
      }
      if (this.tsK != null) {
        paramVarArgs.e(3, this.tsK);
      }
      paramVarArgs.eO(4, this.uej);
      paramVarArgs.O(5, this.uek);
      GMTrace.o(3750580191232L, 27944);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.uei) + 0;
      paramInt = i;
      if (this.tlE != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tlE);
      }
      i = paramInt;
      if (this.tsK != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tsK);
      }
      paramInt = a.a.a.a.eL(4, this.uej);
      int j = a.a.a.a.N(5, this.uek);
      GMTrace.o(3750580191232L, 27944);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3750580191232L, 27944);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bfg localbfg = (bfg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3750580191232L, 27944);
        return -1;
      case 1: 
        localbfg.uei = locala.xky.mL();
        GMTrace.o(3750580191232L, 27944);
        return 0;
      case 2: 
        localbfg.tlE = locala.xky.readString();
        GMTrace.o(3750580191232L, 27944);
        return 0;
      case 3: 
        localbfg.tsK = locala.xky.readString();
        GMTrace.o(3750580191232L, 27944);
        return 0;
      case 4: 
        localbfg.uej = locala.xky.mL();
        GMTrace.o(3750580191232L, 27944);
        return 0;
      }
      localbfg.uek = locala.xky.mM();
      GMTrace.o(3750580191232L, 27944);
      return 0;
    }
    GMTrace.o(3750580191232L, 27944);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */