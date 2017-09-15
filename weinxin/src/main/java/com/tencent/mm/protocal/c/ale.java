package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ale
  extends com.tencent.mm.bd.a
{
  public String fDt;
  public int fEt;
  public String fFN;
  public int jMq;
  public String mPx;
  public String mqJ;
  public String mrm;
  public int pPy;
  public int qJO;
  public String qpn;
  public String tNA;
  public int tNB;
  public int tNC;
  public String tND;
  public String tNE;
  public String tNF;
  public String tNG;
  public String tNH;
  public int tNI;
  public long tNJ;
  public String tNK;
  public String tNL;
  public int tNM;
  public String tNN;
  public String tNO;
  public int tNP;
  public String tNQ;
  public String tNR;
  public int tNv;
  public String tNw;
  public int tNx;
  public int tNy;
  public alg tNz;
  
  public ale()
  {
    GMTrace.i(3808293814272L, 28374);
    GMTrace.o(3808293814272L, 28374);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3808428032000L, 28375);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.mPx != null) {
        paramVarArgs.e(1, this.mPx);
      }
      paramVarArgs.eO(2, this.jMq);
      if (this.mqJ != null) {
        paramVarArgs.e(3, this.mqJ);
      }
      if (this.mrm != null) {
        paramVarArgs.e(4, this.mrm);
      }
      paramVarArgs.eO(5, this.tNv);
      if (this.tNw != null) {
        paramVarArgs.e(6, this.tNw);
      }
      paramVarArgs.eO(7, this.tNx);
      paramVarArgs.eO(8, this.tNy);
      if (this.fDt != null) {
        paramVarArgs.e(9, this.fDt);
      }
      if (this.tNz != null)
      {
        paramVarArgs.eQ(10, this.tNz.aUd());
        this.tNz.a(paramVarArgs);
      }
      if (this.tNA != null) {
        paramVarArgs.e(11, this.tNA);
      }
      paramVarArgs.eO(12, this.tNB);
      paramVarArgs.eO(13, this.pPy);
      paramVarArgs.eO(14, this.tNC);
      if (this.qpn != null) {
        paramVarArgs.e(15, this.qpn);
      }
      paramVarArgs.eO(16, this.fEt);
      if (this.fFN != null) {
        paramVarArgs.e(17, this.fFN);
      }
      if (this.tND != null) {
        paramVarArgs.e(18, this.tND);
      }
      if (this.tNE != null) {
        paramVarArgs.e(19, this.tNE);
      }
      if (this.tNF != null) {
        paramVarArgs.e(20, this.tNF);
      }
      paramVarArgs.eO(21, this.qJO);
      if (this.tNG != null) {
        paramVarArgs.e(22, this.tNG);
      }
      if (this.tNH != null) {
        paramVarArgs.e(23, this.tNH);
      }
      paramVarArgs.eO(24, this.tNI);
      paramVarArgs.O(25, this.tNJ);
      if (this.tNK != null) {
        paramVarArgs.e(26, this.tNK);
      }
      if (this.tNL != null) {
        paramVarArgs.e(27, this.tNL);
      }
      paramVarArgs.eO(28, this.tNM);
      if (this.tNN != null) {
        paramVarArgs.e(29, this.tNN);
      }
      if (this.tNO != null) {
        paramVarArgs.e(30, this.tNO);
      }
      paramVarArgs.eO(31, this.tNP);
      if (this.tNQ != null) {
        paramVarArgs.e(32, this.tNQ);
      }
      if (this.tNR != null) {
        paramVarArgs.e(33, this.tNR);
      }
      GMTrace.o(3808428032000L, 28375);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.mPx != null) {
        paramInt = a.a.a.b.b.a.f(1, this.mPx) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.jMq);
      paramInt = i;
      if (this.mqJ != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.mqJ);
      }
      i = paramInt;
      if (this.mrm != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.mrm);
      }
      i += a.a.a.a.eL(5, this.tNv);
      paramInt = i;
      if (this.tNw != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tNw);
      }
      i = paramInt + a.a.a.a.eL(7, this.tNx) + a.a.a.a.eL(8, this.tNy);
      paramInt = i;
      if (this.fDt != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.fDt);
      }
      i = paramInt;
      if (this.tNz != null) {
        i = paramInt + a.a.a.a.eN(10, this.tNz.aUd());
      }
      paramInt = i;
      if (this.tNA != null) {
        paramInt = i + a.a.a.b.b.a.f(11, this.tNA);
      }
      i = paramInt + a.a.a.a.eL(12, this.tNB) + a.a.a.a.eL(13, this.pPy) + a.a.a.a.eL(14, this.tNC);
      paramInt = i;
      if (this.qpn != null) {
        paramInt = i + a.a.a.b.b.a.f(15, this.qpn);
      }
      i = paramInt + a.a.a.a.eL(16, this.fEt);
      paramInt = i;
      if (this.fFN != null) {
        paramInt = i + a.a.a.b.b.a.f(17, this.fFN);
      }
      i = paramInt;
      if (this.tND != null) {
        i = paramInt + a.a.a.b.b.a.f(18, this.tND);
      }
      paramInt = i;
      if (this.tNE != null) {
        paramInt = i + a.a.a.b.b.a.f(19, this.tNE);
      }
      i = paramInt;
      if (this.tNF != null) {
        i = paramInt + a.a.a.b.b.a.f(20, this.tNF);
      }
      i += a.a.a.a.eL(21, this.qJO);
      paramInt = i;
      if (this.tNG != null) {
        paramInt = i + a.a.a.b.b.a.f(22, this.tNG);
      }
      i = paramInt;
      if (this.tNH != null) {
        i = paramInt + a.a.a.b.b.a.f(23, this.tNH);
      }
      i = i + a.a.a.a.eL(24, this.tNI) + a.a.a.a.N(25, this.tNJ);
      paramInt = i;
      if (this.tNK != null) {
        paramInt = i + a.a.a.b.b.a.f(26, this.tNK);
      }
      i = paramInt;
      if (this.tNL != null) {
        i = paramInt + a.a.a.b.b.a.f(27, this.tNL);
      }
      i += a.a.a.a.eL(28, this.tNM);
      paramInt = i;
      if (this.tNN != null) {
        paramInt = i + a.a.a.b.b.a.f(29, this.tNN);
      }
      i = paramInt;
      if (this.tNO != null) {
        i = paramInt + a.a.a.b.b.a.f(30, this.tNO);
      }
      i += a.a.a.a.eL(31, this.tNP);
      paramInt = i;
      if (this.tNQ != null) {
        paramInt = i + a.a.a.b.b.a.f(32, this.tNQ);
      }
      i = paramInt;
      if (this.tNR != null) {
        i = paramInt + a.a.a.b.b.a.f(33, this.tNR);
      }
      GMTrace.o(3808428032000L, 28375);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3808428032000L, 28375);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ale localale = (ale)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3808428032000L, 28375);
        return -1;
      case 1: 
        localale.mPx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 2: 
        localale.jMq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 3: 
        localale.mqJ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 4: 
        localale.mrm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 5: 
        localale.tNv = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 6: 
        localale.tNw = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 7: 
        localale.tNx = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 8: 
        localale.tNy = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 9: 
        localale.fDt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 10: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alg();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((alg)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localale.tNz = ((alg)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 11: 
        localale.tNA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 12: 
        localale.tNB = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 13: 
        localale.pPy = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 14: 
        localale.tNC = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 15: 
        localale.qpn = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 16: 
        localale.fEt = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 17: 
        localale.fFN = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 18: 
        localale.tND = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 19: 
        localale.tNE = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 20: 
        localale.tNF = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 21: 
        localale.qJO = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 22: 
        localale.tNG = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 23: 
        localale.tNH = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 24: 
        localale.tNI = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 25: 
        localale.tNJ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 26: 
        localale.tNK = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 27: 
        localale.tNL = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 28: 
        localale.tNM = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 29: 
        localale.tNN = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 30: 
        localale.tNO = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 31: 
        localale.tNP = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      case 32: 
        localale.tNQ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3808428032000L, 28375);
        return 0;
      }
      localale.tNR = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3808428032000L, 28375);
      return 0;
    }
    GMTrace.o(3808428032000L, 28375);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */