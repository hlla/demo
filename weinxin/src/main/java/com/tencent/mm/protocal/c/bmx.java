package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bmx
  extends com.tencent.mm.bd.a
{
  public String path;
  public String username;
  
  public bmx()
  {
    GMTrace.i(3960228282368L, 29506);
    GMTrace.o(3960228282368L, 29506);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3960362500096L, 29507);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.e(2, this.path);
      }
      GMTrace.o(3960362500096L, 29507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = a.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.path);
      }
      GMTrace.o(3960362500096L, 29507);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3960362500096L, 29507);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        bmx localbmx = (bmx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3960362500096L, 29507);
          return -1;
        case 1: 
          localbmx.username = locala.xky.readString();
          GMTrace.o(3960362500096L, 29507);
          return 0;
        }
        localbmx.path = locala.xky.readString();
        GMTrace.o(3960362500096L, 29507);
        return 0;
      }
      GMTrace.o(3960362500096L, 29507);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bmx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */