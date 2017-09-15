package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class bfe
  extends com.tencent.mm.bd.a
{
  public String username;
  
  public bfe()
  {
    GMTrace.i(3752593457152L, 27959);
    GMTrace.o(3752593457152L, 27959);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3752727674880L, 27960);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.username == null) {
        throw new b("Not all required fields were included: username");
      }
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      GMTrace.o(3752727674880L, 27960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label273;
      }
    }
    label273:
    for (paramInt = a.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      GMTrace.o(3752727674880L, 27960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        if (this.username == null) {
          throw new b("Not all required fields were included: username");
        }
        GMTrace.o(3752727674880L, 27960);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        bfe localbfe = (bfe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3752727674880L, 27960);
          return -1;
        }
        localbfe.username = locala.xky.readString();
        GMTrace.o(3752727674880L, 27960);
        return 0;
      }
      GMTrace.o(3752727674880L, 27960);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */