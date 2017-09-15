package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class azx
  extends com.tencent.mm.bd.a
{
  public String url;
  
  public azx()
  {
    GMTrace.i(3916204867584L, 29178);
    GMTrace.o(3916204867584L, 29178);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3916339085312L, 29179);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      GMTrace.o(3916339085312L, 29179);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label241;
      }
    }
    label241:
    for (paramInt = a.a.a.b.b.a.f(1, this.url) + 0;; paramInt = 0)
    {
      GMTrace.o(3916339085312L, 29179);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3916339085312L, 29179);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        azx localazx = (azx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3916339085312L, 29179);
          return -1;
        }
        localazx.url = locala.xky.readString();
        GMTrace.o(3916339085312L, 29179);
        return 0;
      }
      GMTrace.o(3916339085312L, 29179);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/azx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */