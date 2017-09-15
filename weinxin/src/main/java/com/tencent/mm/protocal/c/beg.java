package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class beg
  extends com.tencent.mm.bd.a
{
  public int jMq;
  public int udy;
  public String udz;
  
  public beg()
  {
    GMTrace.i(3654614515712L, 27229);
    GMTrace.o(3654614515712L, 27229);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3654748733440L, 27230);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(2, this.jMq);
      paramVarArgs.eO(3, this.udy);
      if (this.udz != null) {
        paramVarArgs.e(4, this.udz);
      }
      GMTrace.o(3654748733440L, 27230);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(2, this.jMq) + 0 + a.a.a.a.eL(3, this.udy);
      paramInt = i;
      if (this.udz != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.udz);
      }
      GMTrace.o(3654748733440L, 27230);
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
      GMTrace.o(3654748733440L, 27230);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      beg localbeg = (beg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3654748733440L, 27230);
        return -1;
      case 2: 
        localbeg.jMq = locala.xky.mL();
        GMTrace.o(3654748733440L, 27230);
        return 0;
      case 3: 
        localbeg.udy = locala.xky.mL();
        GMTrace.o(3654748733440L, 27230);
        return 0;
      }
      localbeg.udz = locala.xky.readString();
      GMTrace.o(3654748733440L, 27230);
      return 0;
    }
    GMTrace.o(3654748733440L, 27230);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/beg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */