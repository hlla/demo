package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ajx
  extends com.tencent.mm.bd.a
{
  public String fTE;
  public String tLQ;
  public String tLR;
  public String tLS;
  public String tLT;
  public int tLU;
  public int tLV;
  public String tLW;
  public int tLX;
  public int tLY;
  public String tLZ;
  public int tMa;
  public int tMb;
  public String tMc;
  public int tMd;
  public int tMe;
  public String tMf;
  public String tMg;
  public String tMh;
  public String tMi;
  public String tof;
  public int trX;
  
  public ajx()
  {
    GMTrace.i(4016465510400L, 29925);
    GMTrace.o(4016465510400L, 29925);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4016599728128L, 29926);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.fTE != null) {
        paramVarArgs.e(1, this.fTE);
      }
      if (this.tLQ != null) {
        paramVarArgs.e(20, this.tLQ);
      }
      if (this.tLR != null) {
        paramVarArgs.e(21, this.tLR);
      }
      if (this.tLS != null) {
        paramVarArgs.e(22, this.tLS);
      }
      if (this.tLT != null) {
        paramVarArgs.e(23, this.tLT);
      }
      if (this.tof != null) {
        paramVarArgs.e(31, this.tof);
      }
      paramVarArgs.eO(32, this.tLU);
      paramVarArgs.eO(33, this.tLV);
      if (this.tLW != null) {
        paramVarArgs.e(34, this.tLW);
      }
      paramVarArgs.eO(35, this.tLX);
      paramVarArgs.eO(36, this.tLY);
      if (this.tLZ != null) {
        paramVarArgs.e(37, this.tLZ);
      }
      paramVarArgs.eO(38, this.tMa);
      paramVarArgs.eO(39, this.tMb);
      if (this.tMc != null) {
        paramVarArgs.e(41, this.tMc);
      }
      paramVarArgs.eO(200, this.tMd);
      paramVarArgs.eO(201, this.tMe);
      paramVarArgs.eO(202, this.trX);
      if (this.tMf != null) {
        paramVarArgs.e(203, this.tMf);
      }
      if (this.tMg != null) {
        paramVarArgs.e(204, this.tMg);
      }
      if (this.tMh != null) {
        paramVarArgs.e(205, this.tMh);
      }
      if (this.tMi != null) {
        paramVarArgs.e(206, this.tMi);
      }
      GMTrace.o(4016599728128L, 29926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fTE == null) {
        break label1574;
      }
    }
    label1574:
    for (int i = a.a.a.b.b.a.f(1, this.fTE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tLQ != null) {
        paramInt = i + a.a.a.b.b.a.f(20, this.tLQ);
      }
      i = paramInt;
      if (this.tLR != null) {
        i = paramInt + a.a.a.b.b.a.f(21, this.tLR);
      }
      paramInt = i;
      if (this.tLS != null) {
        paramInt = i + a.a.a.b.b.a.f(22, this.tLS);
      }
      i = paramInt;
      if (this.tLT != null) {
        i = paramInt + a.a.a.b.b.a.f(23, this.tLT);
      }
      paramInt = i;
      if (this.tof != null) {
        paramInt = i + a.a.a.b.b.a.f(31, this.tof);
      }
      i = paramInt + a.a.a.a.eL(32, this.tLU) + a.a.a.a.eL(33, this.tLV);
      paramInt = i;
      if (this.tLW != null) {
        paramInt = i + a.a.a.b.b.a.f(34, this.tLW);
      }
      i = paramInt + a.a.a.a.eL(35, this.tLX) + a.a.a.a.eL(36, this.tLY);
      paramInt = i;
      if (this.tLZ != null) {
        paramInt = i + a.a.a.b.b.a.f(37, this.tLZ);
      }
      i = paramInt + a.a.a.a.eL(38, this.tMa) + a.a.a.a.eL(39, this.tMb);
      paramInt = i;
      if (this.tMc != null) {
        paramInt = i + a.a.a.b.b.a.f(41, this.tMc);
      }
      i = paramInt + a.a.a.a.eL(200, this.tMd) + a.a.a.a.eL(201, this.tMe) + a.a.a.a.eL(202, this.trX);
      paramInt = i;
      if (this.tMf != null) {
        paramInt = i + a.a.a.b.b.a.f(203, this.tMf);
      }
      i = paramInt;
      if (this.tMg != null) {
        i = paramInt + a.a.a.b.b.a.f(204, this.tMg);
      }
      paramInt = i;
      if (this.tMh != null) {
        paramInt = i + a.a.a.b.b.a.f(205, this.tMh);
      }
      i = paramInt;
      if (this.tMi != null) {
        i = paramInt + a.a.a.b.b.a.f(206, this.tMi);
      }
      GMTrace.o(4016599728128L, 29926);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(4016599728128L, 29926);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ajx localajx = (ajx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(4016599728128L, 29926);
          return -1;
        case 1: 
          localajx.fTE = locala.xky.readString();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 20: 
          localajx.tLQ = locala.xky.readString();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 21: 
          localajx.tLR = locala.xky.readString();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 22: 
          localajx.tLS = locala.xky.readString();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 23: 
          localajx.tLT = locala.xky.readString();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 31: 
          localajx.tof = locala.xky.readString();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 32: 
          localajx.tLU = locala.xky.mL();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 33: 
          localajx.tLV = locala.xky.mL();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 34: 
          localajx.tLW = locala.xky.readString();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 35: 
          localajx.tLX = locala.xky.mL();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 36: 
          localajx.tLY = locala.xky.mL();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 37: 
          localajx.tLZ = locala.xky.readString();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 38: 
          localajx.tMa = locala.xky.mL();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 39: 
          localajx.tMb = locala.xky.mL();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 41: 
          localajx.tMc = locala.xky.readString();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 200: 
          localajx.tMd = locala.xky.mL();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 201: 
          localajx.tMe = locala.xky.mL();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 202: 
          localajx.trX = locala.xky.mL();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 203: 
          localajx.tMf = locala.xky.readString();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 204: 
          localajx.tMg = locala.xky.readString();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        case 205: 
          localajx.tMh = locala.xky.readString();
          GMTrace.o(4016599728128L, 29926);
          return 0;
        }
        localajx.tMi = locala.xky.readString();
        GMTrace.o(4016599728128L, 29926);
        return 0;
      }
      GMTrace.o(4016599728128L, 29926);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ajx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */