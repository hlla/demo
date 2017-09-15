package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class aon
  extends com.tencent.mm.bd.a
{
  public String mqG;
  public int mqO;
  public String mrc;
  public String mtr;
  public String tRT;
  public String tRU;
  public String tRV;
  public String tRW;
  public String tRX;
  public String tRY;
  public String tcA;
  public String tcy;
  public String tiO;
  public int tiP;
  
  public aon()
  {
    GMTrace.i(3899024998400L, 29050);
    GMTrace.o(3899024998400L, 29050);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3899159216128L, 29051);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.mqG != null) {
        paramVarArgs.e(1, this.mqG);
      }
      if (this.mtr != null) {
        paramVarArgs.e(2, this.mtr);
      }
      if (this.tRT != null) {
        paramVarArgs.e(3, this.tRT);
      }
      if (this.tcy != null) {
        paramVarArgs.e(4, this.tcy);
      }
      if (this.mrc != null) {
        paramVarArgs.e(5, this.mrc);
      }
      paramVarArgs.eO(6, this.tiP);
      if (this.tRU != null) {
        paramVarArgs.e(7, this.tRU);
      }
      if (this.tcA != null) {
        paramVarArgs.e(8, this.tcA);
      }
      if (this.tiO != null) {
        paramVarArgs.e(9, this.tiO);
      }
      if (this.tRV != null) {
        paramVarArgs.e(10, this.tRV);
      }
      if (this.tRW != null) {
        paramVarArgs.e(11, this.tRW);
      }
      if (this.tRX != null) {
        paramVarArgs.e(12, this.tRX);
      }
      if (this.tRY != null) {
        paramVarArgs.e(13, this.tRY);
      }
      paramVarArgs.eO(14, this.mqO);
      GMTrace.o(3899159216128L, 29051);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mqG == null) {
        break label1062;
      }
    }
    label1062:
    for (int i = a.a.a.b.b.a.f(1, this.mqG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mtr != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.mtr);
      }
      i = paramInt;
      if (this.tRT != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tRT);
      }
      paramInt = i;
      if (this.tcy != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tcy);
      }
      i = paramInt;
      if (this.mrc != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.mrc);
      }
      i += a.a.a.a.eL(6, this.tiP);
      paramInt = i;
      if (this.tRU != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.tRU);
      }
      i = paramInt;
      if (this.tcA != null) {
        i = paramInt + a.a.a.b.b.a.f(8, this.tcA);
      }
      paramInt = i;
      if (this.tiO != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.tiO);
      }
      i = paramInt;
      if (this.tRV != null) {
        i = paramInt + a.a.a.b.b.a.f(10, this.tRV);
      }
      paramInt = i;
      if (this.tRW != null) {
        paramInt = i + a.a.a.b.b.a.f(11, this.tRW);
      }
      i = paramInt;
      if (this.tRX != null) {
        i = paramInt + a.a.a.b.b.a.f(12, this.tRX);
      }
      paramInt = i;
      if (this.tRY != null) {
        paramInt = i + a.a.a.b.b.a.f(13, this.tRY);
      }
      i = a.a.a.a.eL(14, this.mqO);
      GMTrace.o(3899159216128L, 29051);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3899159216128L, 29051);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        aon localaon = (aon)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3899159216128L, 29051);
          return -1;
        case 1: 
          localaon.mqG = locala.xky.readString();
          GMTrace.o(3899159216128L, 29051);
          return 0;
        case 2: 
          localaon.mtr = locala.xky.readString();
          GMTrace.o(3899159216128L, 29051);
          return 0;
        case 3: 
          localaon.tRT = locala.xky.readString();
          GMTrace.o(3899159216128L, 29051);
          return 0;
        case 4: 
          localaon.tcy = locala.xky.readString();
          GMTrace.o(3899159216128L, 29051);
          return 0;
        case 5: 
          localaon.mrc = locala.xky.readString();
          GMTrace.o(3899159216128L, 29051);
          return 0;
        case 6: 
          localaon.tiP = locala.xky.mL();
          GMTrace.o(3899159216128L, 29051);
          return 0;
        case 7: 
          localaon.tRU = locala.xky.readString();
          GMTrace.o(3899159216128L, 29051);
          return 0;
        case 8: 
          localaon.tcA = locala.xky.readString();
          GMTrace.o(3899159216128L, 29051);
          return 0;
        case 9: 
          localaon.tiO = locala.xky.readString();
          GMTrace.o(3899159216128L, 29051);
          return 0;
        case 10: 
          localaon.tRV = locala.xky.readString();
          GMTrace.o(3899159216128L, 29051);
          return 0;
        case 11: 
          localaon.tRW = locala.xky.readString();
          GMTrace.o(3899159216128L, 29051);
          return 0;
        case 12: 
          localaon.tRX = locala.xky.readString();
          GMTrace.o(3899159216128L, 29051);
          return 0;
        case 13: 
          localaon.tRY = locala.xky.readString();
          GMTrace.o(3899159216128L, 29051);
          return 0;
        }
        localaon.mqO = locala.xky.mL();
        GMTrace.o(3899159216128L, 29051);
        return 0;
      }
      GMTrace.o(3899159216128L, 29051);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */