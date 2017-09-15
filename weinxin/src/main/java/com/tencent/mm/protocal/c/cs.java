package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class cs
  extends com.tencent.mm.bd.a
{
  public String tei;
  public String tej;
  public String tek;
  
  public cs()
  {
    GMTrace.i(4026531840000L, 30000);
    GMTrace.o(4026531840000L, 30000);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4026666057728L, 30001);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tei != null) {
        paramVarArgs.e(1, this.tei);
      }
      if (this.tej != null) {
        paramVarArgs.e(2, this.tej);
      }
      if (this.tek != null) {
        paramVarArgs.e(3, this.tek);
      }
      GMTrace.o(4026666057728L, 30001);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tei == null) {
        break label370;
      }
    }
    label370:
    for (int i = a.a.a.b.b.a.f(1, this.tei) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tej != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tej);
      }
      i = paramInt;
      if (this.tek != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tek);
      }
      GMTrace.o(4026666057728L, 30001);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(4026666057728L, 30001);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        cs localcs = (cs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(4026666057728L, 30001);
          return -1;
        case 1: 
          localcs.tei = locala.xky.readString();
          GMTrace.o(4026666057728L, 30001);
          return 0;
        case 2: 
          localcs.tej = locala.xky.readString();
          GMTrace.o(4026666057728L, 30001);
          return 0;
        }
        localcs.tek = locala.xky.readString();
        GMTrace.o(4026666057728L, 30001);
        return 0;
      }
      GMTrace.o(4026666057728L, 30001);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */