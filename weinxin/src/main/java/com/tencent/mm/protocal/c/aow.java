package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aow
  extends com.tencent.mm.bd.a
{
  public int tSm;
  public String tSn;
  
  public aow()
  {
    GMTrace.i(4034048032768L, 30056);
    GMTrace.o(4034048032768L, 30056);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4034182250496L, 30057);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tSm);
      if (this.tSn != null) {
        paramVarArgs.e(2, this.tSn);
      }
      GMTrace.o(4034182250496L, 30057);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.tSm) + 0;
      paramInt = i;
      if (this.tSn != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tSn);
      }
      GMTrace.o(4034182250496L, 30057);
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
      GMTrace.o(4034182250496L, 30057);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      aow localaow = (aow)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(4034182250496L, 30057);
        return -1;
      case 1: 
        localaow.tSm = locala.xky.mL();
        GMTrace.o(4034182250496L, 30057);
        return 0;
      }
      localaow.tSn = locala.xky.readString();
      GMTrace.o(4034182250496L, 30057);
      return 0;
    }
    GMTrace.o(4034182250496L, 30057);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */