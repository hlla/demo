package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class bnb
  extends com.tencent.mm.bd.a
{
  public int jMq;
  public String tsQ;
  
  public bnb()
  {
    GMTrace.i(3715817799680L, 27685);
    GMTrace.o(3715817799680L, 27685);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3715952017408L, 27686);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tsQ == null) {
        throw new b("Not all required fields were included: MD5");
      }
      paramVarArgs.eO(1, this.jMq);
      if (this.tsQ != null) {
        paramVarArgs.e(2, this.tsQ);
      }
      GMTrace.o(3715952017408L, 27686);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.jMq) + 0;
      paramInt = i;
      if (this.tsQ != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tsQ);
      }
      GMTrace.o(3715952017408L, 27686);
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
      if (this.tsQ == null) {
        throw new b("Not all required fields were included: MD5");
      }
      GMTrace.o(3715952017408L, 27686);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bnb localbnb = (bnb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3715952017408L, 27686);
        return -1;
      case 1: 
        localbnb.jMq = locala.xky.mL();
        GMTrace.o(3715952017408L, 27686);
        return 0;
      }
      localbnb.tsQ = locala.xky.readString();
      GMTrace.o(3715952017408L, 27686);
      return 0;
    }
    GMTrace.o(3715952017408L, 27686);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bnb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */