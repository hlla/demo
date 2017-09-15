package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ayk
  extends com.tencent.mm.bd.a
{
  public String fER;
  public boolean tYL;
  public String tYM;
  public String username;
  
  public ayk()
  {
    GMTrace.i(4029216194560L, 30020);
    GMTrace.o(4029216194560L, 30020);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4029350412288L, 30021);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.an(2, this.tYL);
      if (this.fER != null) {
        paramVarArgs.e(3, this.fER);
      }
      if (this.tYM != null) {
        paramVarArgs.e(4, this.tYM);
      }
      GMTrace.o(4029350412288L, 30021);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label415;
      }
    }
    label415:
    for (paramInt = a.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + (a.a.a.b.b.a.cH(2) + 1);
      paramInt = i;
      if (this.fER != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.fER);
      }
      i = paramInt;
      if (this.tYM != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.tYM);
      }
      GMTrace.o(4029350412288L, 30021);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(4029350412288L, 30021);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ayk localayk = (ayk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(4029350412288L, 30021);
          return -1;
        case 1: 
          localayk.username = locala.xky.readString();
          GMTrace.o(4029350412288L, 30021);
          return 0;
        case 2: 
          localayk.tYL = locala.chQ();
          GMTrace.o(4029350412288L, 30021);
          return 0;
        case 3: 
          localayk.fER = locala.xky.readString();
          GMTrace.o(4029350412288L, 30021);
          return 0;
        }
        localayk.tYM = locala.xky.readString();
        GMTrace.o(4029350412288L, 30021);
        return 0;
      }
      GMTrace.o(4029350412288L, 30021);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ayk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */