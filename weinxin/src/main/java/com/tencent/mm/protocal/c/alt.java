package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class alt
  extends com.tencent.mm.bd.a
{
  public int hAl;
  public String hAm;
  public String hAn;
  public String hAo;
  public String hAu;
  public String jLx;
  public int jMq;
  public int tOP;
  public int tOQ;
  public String tov;
  public String tow;
  
  public alt()
  {
    GMTrace.i(3804804153344L, 28348);
    GMTrace.o(3804804153344L, 28348);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3804938371072L, 28349);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.jLx != null) {
        paramVarArgs.e(1, this.jLx);
      }
      paramVarArgs.eO(2, this.jMq);
      paramVarArgs.eO(3, this.hAl);
      if (this.hAn != null) {
        paramVarArgs.e(4, this.hAn);
      }
      if (this.hAm != null) {
        paramVarArgs.e(5, this.hAm);
      }
      if (this.hAo != null) {
        paramVarArgs.e(6, this.hAo);
      }
      paramVarArgs.eO(7, this.tOP);
      paramVarArgs.eO(8, this.tOQ);
      if (this.hAu != null) {
        paramVarArgs.e(9, this.hAu);
      }
      if (this.tov != null) {
        paramVarArgs.e(10, this.tov);
      }
      if (this.tow != null) {
        paramVarArgs.e(11, this.tow);
      }
      GMTrace.o(3804938371072L, 28349);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jLx == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = a.a.a.b.b.a.f(1, this.jLx) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.eL(2, this.jMq) + a.a.a.a.eL(3, this.hAl);
      paramInt = i;
      if (this.hAn != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.hAn);
      }
      i = paramInt;
      if (this.hAm != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.hAm);
      }
      paramInt = i;
      if (this.hAo != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.hAo);
      }
      i = paramInt + a.a.a.a.eL(7, this.tOP) + a.a.a.a.eL(8, this.tOQ);
      paramInt = i;
      if (this.hAu != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.hAu);
      }
      i = paramInt;
      if (this.tov != null) {
        i = paramInt + a.a.a.b.b.a.f(10, this.tov);
      }
      paramInt = i;
      if (this.tow != null) {
        paramInt = i + a.a.a.b.b.a.f(11, this.tow);
      }
      GMTrace.o(3804938371072L, 28349);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3804938371072L, 28349);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        alt localalt = (alt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3804938371072L, 28349);
          return -1;
        case 1: 
          localalt.jLx = locala.xky.readString();
          GMTrace.o(3804938371072L, 28349);
          return 0;
        case 2: 
          localalt.jMq = locala.xky.mL();
          GMTrace.o(3804938371072L, 28349);
          return 0;
        case 3: 
          localalt.hAl = locala.xky.mL();
          GMTrace.o(3804938371072L, 28349);
          return 0;
        case 4: 
          localalt.hAn = locala.xky.readString();
          GMTrace.o(3804938371072L, 28349);
          return 0;
        case 5: 
          localalt.hAm = locala.xky.readString();
          GMTrace.o(3804938371072L, 28349);
          return 0;
        case 6: 
          localalt.hAo = locala.xky.readString();
          GMTrace.o(3804938371072L, 28349);
          return 0;
        case 7: 
          localalt.tOP = locala.xky.mL();
          GMTrace.o(3804938371072L, 28349);
          return 0;
        case 8: 
          localalt.tOQ = locala.xky.mL();
          GMTrace.o(3804938371072L, 28349);
          return 0;
        case 9: 
          localalt.hAu = locala.xky.readString();
          GMTrace.o(3804938371072L, 28349);
          return 0;
        case 10: 
          localalt.tov = locala.xky.readString();
          GMTrace.o(3804938371072L, 28349);
          return 0;
        }
        localalt.tow = locala.xky.readString();
        GMTrace.o(3804938371072L, 28349);
        return 0;
      }
      GMTrace.o(3804938371072L, 28349);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/alt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */