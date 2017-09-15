package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class adt
  extends com.tencent.mm.bd.a
{
  public String tHF;
  public String tHG;
  public String tti;
  
  public adt()
  {
    GMTrace.i(3728165830656L, 27777);
    GMTrace.o(3728165830656L, 27777);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3728300048384L, 27778);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tti != null) {
        paramVarArgs.e(1, this.tti);
      }
      if (this.tHF != null) {
        paramVarArgs.e(2, this.tHF);
      }
      if (this.tHG != null) {
        paramVarArgs.e(3, this.tHG);
      }
      GMTrace.o(3728300048384L, 27778);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tti == null) {
        break label370;
      }
    }
    label370:
    for (int i = a.a.a.b.b.a.f(1, this.tti) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tHF != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tHF);
      }
      i = paramInt;
      if (this.tHG != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tHG);
      }
      GMTrace.o(3728300048384L, 27778);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3728300048384L, 27778);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        adt localadt = (adt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3728300048384L, 27778);
          return -1;
        case 1: 
          localadt.tti = locala.xky.readString();
          GMTrace.o(3728300048384L, 27778);
          return 0;
        case 2: 
          localadt.tHF = locala.xky.readString();
          GMTrace.o(3728300048384L, 27778);
          return 0;
        }
        localadt.tHG = locala.xky.readString();
        GMTrace.o(3728300048384L, 27778);
        return 0;
      }
      GMTrace.o(3728300048384L, 27778);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/adt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */