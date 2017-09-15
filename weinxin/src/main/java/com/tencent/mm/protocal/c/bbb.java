package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bbb
  extends com.tencent.mm.bd.a
{
  public long uav;
  
  public bbb()
  {
    GMTrace.i(3827352731648L, 28516);
    GMTrace.o(3827352731648L, 28516);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3827486949376L, 28517);
    if (paramInt == 0)
    {
      ((a.a.a.c.a)paramVarArgs[0]).O(1, this.uav);
      GMTrace.o(3827486949376L, 28517);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.N(1, this.uav);
      GMTrace.o(3827486949376L, 28517);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3827486949376L, 28517);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bbb localbbb = (bbb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3827486949376L, 28517);
        return -1;
      }
      localbbb.uav = locala.xky.mM();
      GMTrace.o(3827486949376L, 28517);
      return 0;
    }
    GMTrace.o(3827486949376L, 28517);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */