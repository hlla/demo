package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ap
  extends com.tencent.mm.bd.a
{
  public String hAq;
  public int jLP;
  public String jLx;
  public String jMD;
  public int tbS;
  public String tbT;
  public String tbU;
  public int tbV;
  public int tbW;
  public String tbX;
  public int tbY;
  public String tbZ;
  public String tca;
  public int tcb;
  public String tcc;
  
  public ap()
  {
    GMTrace.i(13576391622656L, 101152);
    GMTrace.o(13576391622656L, 101152);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13576525840384L, 101153);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.jLx != null) {
        paramVarArgs.e(1, this.jLx);
      }
      if (this.jMD != null) {
        paramVarArgs.e(2, this.jMD);
      }
      paramVarArgs.eO(3, this.tbS);
      if (this.tbT != null) {
        paramVarArgs.e(4, this.tbT);
      }
      if (this.tbU != null) {
        paramVarArgs.e(5, this.tbU);
      }
      if (this.hAq != null) {
        paramVarArgs.e(6, this.hAq);
      }
      paramVarArgs.eO(8, this.jLP);
      paramVarArgs.eO(9, this.tbV);
      paramVarArgs.eO(10, this.tbW);
      if (this.tbX != null) {
        paramVarArgs.e(11, this.tbX);
      }
      paramVarArgs.eO(12, this.tbY);
      if (this.tbZ != null) {
        paramVarArgs.e(13, this.tbZ);
      }
      if (this.tca != null) {
        paramVarArgs.e(14, this.tca);
      }
      paramVarArgs.eO(15, this.tcb);
      if (this.tcc != null) {
        paramVarArgs.e(16, this.tcc);
      }
      GMTrace.o(13576525840384L, 101153);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jLx == null) {
        break label1041;
      }
    }
    label1041:
    for (paramInt = a.a.a.b.b.a.f(1, this.jLx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jMD != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.jMD);
      }
      i += a.a.a.a.eL(3, this.tbS);
      paramInt = i;
      if (this.tbT != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tbT);
      }
      i = paramInt;
      if (this.tbU != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tbU);
      }
      paramInt = i;
      if (this.hAq != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.hAq);
      }
      i = paramInt + a.a.a.a.eL(8, this.jLP) + a.a.a.a.eL(9, this.tbV) + a.a.a.a.eL(10, this.tbW);
      paramInt = i;
      if (this.tbX != null) {
        paramInt = i + a.a.a.b.b.a.f(11, this.tbX);
      }
      i = paramInt + a.a.a.a.eL(12, this.tbY);
      paramInt = i;
      if (this.tbZ != null) {
        paramInt = i + a.a.a.b.b.a.f(13, this.tbZ);
      }
      i = paramInt;
      if (this.tca != null) {
        i = paramInt + a.a.a.b.b.a.f(14, this.tca);
      }
      i += a.a.a.a.eL(15, this.tcb);
      paramInt = i;
      if (this.tcc != null) {
        paramInt = i + a.a.a.b.b.a.f(16, this.tcc);
      }
      GMTrace.o(13576525840384L, 101153);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(13576525840384L, 101153);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          GMTrace.o(13576525840384L, 101153);
          return -1;
        case 1: 
          localap.jLx = locala.xky.readString();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        case 2: 
          localap.jMD = locala.xky.readString();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        case 3: 
          localap.tbS = locala.xky.mL();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        case 4: 
          localap.tbT = locala.xky.readString();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        case 5: 
          localap.tbU = locala.xky.readString();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        case 6: 
          localap.hAq = locala.xky.readString();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        case 8: 
          localap.jLP = locala.xky.mL();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        case 9: 
          localap.tbV = locala.xky.mL();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        case 10: 
          localap.tbW = locala.xky.mL();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        case 11: 
          localap.tbX = locala.xky.readString();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        case 12: 
          localap.tbY = locala.xky.mL();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        case 13: 
          localap.tbZ = locala.xky.readString();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        case 14: 
          localap.tca = locala.xky.readString();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        case 15: 
          localap.tcb = locala.xky.mL();
          GMTrace.o(13576525840384L, 101153);
          return 0;
        }
        localap.tcc = locala.xky.readString();
        GMTrace.o(13576525840384L, 101153);
        return 0;
      }
      GMTrace.o(13576525840384L, 101153);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */