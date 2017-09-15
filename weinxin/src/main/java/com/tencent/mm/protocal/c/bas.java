package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bas
  extends com.tencent.mm.bd.a
{
  public String jLx;
  public int tLn;
  public String uah;
  public int uai;
  public String uaj;
  public int uak;
  
  public bas()
  {
    GMTrace.i(16867947184128L, 125676);
    GMTrace.o(16867947184128L, 125676);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(16868081401856L, 125677);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.uah != null) {
        paramVarArgs.e(1, this.uah);
      }
      paramVarArgs.eO(2, this.uai);
      if (this.jLx != null) {
        paramVarArgs.e(3, this.jLx);
      }
      if (this.uaj != null) {
        paramVarArgs.e(4, this.uaj);
      }
      paramVarArgs.eO(5, this.tLn);
      paramVarArgs.eO(6, this.uak);
      GMTrace.o(16868081401856L, 125677);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uah == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = a.a.a.b.b.a.f(1, this.uah) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.eL(2, this.uai);
      paramInt = i;
      if (this.jLx != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.jLx);
      }
      i = paramInt;
      if (this.uaj != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.uaj);
      }
      paramInt = a.a.a.a.eL(5, this.tLn);
      int j = a.a.a.a.eL(6, this.uak);
      GMTrace.o(16868081401856L, 125677);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(16868081401856L, 125677);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        bas localbas = (bas)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(16868081401856L, 125677);
          return -1;
        case 1: 
          localbas.uah = locala.xky.readString();
          GMTrace.o(16868081401856L, 125677);
          return 0;
        case 2: 
          localbas.uai = locala.xky.mL();
          GMTrace.o(16868081401856L, 125677);
          return 0;
        case 3: 
          localbas.jLx = locala.xky.readString();
          GMTrace.o(16868081401856L, 125677);
          return 0;
        case 4: 
          localbas.uaj = locala.xky.readString();
          GMTrace.o(16868081401856L, 125677);
          return 0;
        case 5: 
          localbas.tLn = locala.xky.mL();
          GMTrace.o(16868081401856L, 125677);
          return 0;
        }
        localbas.uak = locala.xky.mL();
        GMTrace.o(16868081401856L, 125677);
        return 0;
      }
      GMTrace.o(16868081401856L, 125677);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */