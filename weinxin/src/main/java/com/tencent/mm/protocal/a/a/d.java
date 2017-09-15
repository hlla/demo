package com.tencent.mm.protocal.a.a;

import com.tencent.gmtrace.GMTrace;

public final class d
  extends com.tencent.mm.bd.a
{
  public int count;
  public int pnv;
  public int sYG;
  public com.tencent.mm.bd.b sYP;
  public int sYQ;
  
  public d()
  {
    GMTrace.i(13102737260544L, 97623);
    GMTrace.o(13102737260544L, 97623);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13102871478272L, 97624);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.sYP == null) {
        throw new a.a.a.b("Not all required fields were included: value");
      }
      paramVarArgs.eO(1, this.sYG);
      if (this.sYP != null) {
        paramVarArgs.b(2, this.sYP);
      }
      paramVarArgs.eO(3, this.sYQ);
      paramVarArgs.eO(4, this.pnv);
      paramVarArgs.eO(5, this.count);
      GMTrace.o(13102871478272L, 97624);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.sYG) + 0;
      paramInt = i;
      if (this.sYP != null) {
        paramInt = i + a.a.a.a.a(2, this.sYP);
      }
      i = a.a.a.a.eL(3, this.sYQ);
      int j = a.a.a.a.eL(4, this.pnv);
      int k = a.a.a.a.eL(5, this.count);
      GMTrace.o(13102871478272L, 97624);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.sYP == null) {
        throw new a.a.a.b("Not all required fields were included: value");
      }
      GMTrace.o(13102871478272L, 97624);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13102871478272L, 97624);
        return -1;
      case 1: 
        locald.sYG = locala.xky.mL();
        GMTrace.o(13102871478272L, 97624);
        return 0;
      case 2: 
        locald.sYP = locala.chR();
        GMTrace.o(13102871478272L, 97624);
        return 0;
      case 3: 
        locald.sYQ = locala.xky.mL();
        GMTrace.o(13102871478272L, 97624);
        return 0;
      case 4: 
        locald.pnv = locala.xky.mL();
        GMTrace.o(13102871478272L, 97624);
        return 0;
      }
      locald.count = locala.xky.mL();
      GMTrace.o(13102871478272L, 97624);
      return 0;
    }
    GMTrace.o(13102871478272L, 97624);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */