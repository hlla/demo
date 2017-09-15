package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class aqh
  extends com.tencent.mm.bd.a
{
  public String tTs;
  
  public aqh()
  {
    GMTrace.i(13340302639104L, 99393);
    GMTrace.o(13340302639104L, 99393);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13340436856832L, 99394);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tTs == null) {
        throw new b("Not all required fields were included: PhoneNum");
      }
      if (this.tTs != null) {
        paramVarArgs.e(1, this.tTs);
      }
      GMTrace.o(13340436856832L, 99394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tTs == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = a.a.a.b.b.a.f(1, this.tTs) + 0;; paramInt = 0)
    {
      GMTrace.o(13340436856832L, 99394);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        if (this.tTs == null) {
          throw new b("Not all required fields were included: PhoneNum");
        }
        GMTrace.o(13340436856832L, 99394);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        aqh localaqh = (aqh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(13340436856832L, 99394);
          return -1;
        }
        localaqh.tTs = locala.xky.readString();
        GMTrace.o(13340436856832L, 99394);
        return 0;
      }
      GMTrace.o(13340436856832L, 99394);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aqh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */