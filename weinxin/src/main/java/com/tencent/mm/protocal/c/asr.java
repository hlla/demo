package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class asr
  extends com.tencent.mm.bd.a
{
  public String iTn;
  public int mse;
  
  public asr()
  {
    GMTrace.i(13170651430912L, 98129);
    GMTrace.o(13170651430912L, 98129);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13170785648640L, 98130);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.iTn == null) {
        throw new b("Not all required fields were included: jsonData");
      }
      paramVarArgs.eO(1, this.mse);
      if (this.iTn != null) {
        paramVarArgs.e(2, this.iTn);
      }
      GMTrace.o(13170785648640L, 98130);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.mse) + 0;
      paramInt = i;
      if (this.iTn != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.iTn);
      }
      GMTrace.o(13170785648640L, 98130);
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
      if (this.iTn == null) {
        throw new b("Not all required fields were included: jsonData");
      }
      GMTrace.o(13170785648640L, 98130);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      asr localasr = (asr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13170785648640L, 98130);
        return -1;
      case 1: 
        localasr.mse = locala.xky.mL();
        GMTrace.o(13170785648640L, 98130);
        return 0;
      }
      localasr.iTn = locala.xky.readString();
      GMTrace.o(13170785648640L, 98130);
      return 0;
    }
    GMTrace.o(13170785648640L, 98130);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/asr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */