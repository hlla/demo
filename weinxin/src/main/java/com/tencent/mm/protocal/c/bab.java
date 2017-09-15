package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bab
  extends com.tencent.mm.bd.a
{
  public int jMp;
  public com.tencent.mm.bd.b tZH;
  
  public bab()
  {
    GMTrace.i(3678236835840L, 27405);
    GMTrace.o(3678236835840L, 27405);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3678371053568L, 27406);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tZH == null) {
        throw new a.a.a.b("Not all required fields were included: Signature");
      }
      paramVarArgs.eO(1, this.jMp);
      if (this.tZH != null) {
        paramVarArgs.b(2, this.tZH);
      }
      GMTrace.o(3678371053568L, 27406);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.jMp) + 0;
      paramInt = i;
      if (this.tZH != null) {
        paramInt = i + a.a.a.a.a(2, this.tZH);
      }
      GMTrace.o(3678371053568L, 27406);
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
      if (this.tZH == null) {
        throw new a.a.a.b("Not all required fields were included: Signature");
      }
      GMTrace.o(3678371053568L, 27406);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bab localbab = (bab)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3678371053568L, 27406);
        return -1;
      case 1: 
        localbab.jMp = locala.xky.mL();
        GMTrace.o(3678371053568L, 27406);
        return 0;
      }
      localbab.tZH = locala.chR();
      GMTrace.o(3678371053568L, 27406);
      return 0;
    }
    GMTrace.o(3678371053568L, 27406);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */