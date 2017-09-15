package com.tencent.mm.plugin.report.service;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class c
  extends com.tencent.mm.bd.a
{
  public boolean oSd;
  public int oSk;
  public String oSl;
  public boolean oSm;
  
  public c()
  {
    GMTrace.i(13111327195136L, 97687);
    GMTrace.o(13111327195136L, 97687);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13111461412864L, 97688);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.oSl == null) {
        throw new b("Not all required fields were included: Value");
      }
      paramVarArgs.eO(1, this.oSk);
      if (this.oSl != null) {
        paramVarArgs.e(2, this.oSl);
      }
      paramVarArgs.an(3, this.oSm);
      paramVarArgs.an(4, this.oSd);
      GMTrace.o(13111461412864L, 97688);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.oSk) + 0;
      paramInt = i;
      if (this.oSl != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.oSl);
      }
      i = a.a.a.b.b.a.cH(3);
      int j = a.a.a.b.b.a.cH(4);
      GMTrace.o(13111461412864L, 97688);
      return paramInt + (i + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.oSl == null) {
        throw new b("Not all required fields were included: Value");
      }
      GMTrace.o(13111461412864L, 97688);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13111461412864L, 97688);
        return -1;
      case 1: 
        localc.oSk = locala.xky.mL();
        GMTrace.o(13111461412864L, 97688);
        return 0;
      case 2: 
        localc.oSl = locala.xky.readString();
        GMTrace.o(13111461412864L, 97688);
        return 0;
      case 3: 
        localc.oSm = locala.chQ();
        GMTrace.o(13111461412864L, 97688);
        return 0;
      }
      localc.oSd = locala.chQ();
      GMTrace.o(13111461412864L, 97688);
      return 0;
    }
    GMTrace.o(13111461412864L, 97688);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/service/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */