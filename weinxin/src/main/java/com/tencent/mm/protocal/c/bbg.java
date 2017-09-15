package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bbg
  extends com.tencent.mm.bd.a
{
  public int ofk;
  public String tLN;
  public LinkedList<avu> tOe;
  public int tPi;
  public int tPn;
  public int tQD;
  public int tZZ;
  public LinkedList<bbb> tdT;
  public String tfa;
  public long tkR;
  public int uaA;
  public LinkedList<baw> uaB;
  public int uaC;
  public int uaD;
  public LinkedList<baw> uaE;
  public int uaF;
  public int uaG;
  public LinkedList<baw> uaH;
  public int uaI;
  public String uaJ;
  public long uaK;
  public int uaL;
  public LinkedList<avu> uaM;
  public int uaN;
  public avt uaO;
  public bbv uaP;
  public aqx uaQ;
  public bas uaR;
  public avt uax;
  public int uay;
  public int uaz;
  
  public bbg()
  {
    GMTrace.i(3789234896896L, 28232);
    this.uaB = new LinkedList();
    this.uaE = new LinkedList();
    this.uaH = new LinkedList();
    this.tdT = new LinkedList();
    this.uaM = new LinkedList();
    this.tOe = new LinkedList();
    GMTrace.o(3789234896896L, 28232);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3789369114624L, 28233);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.uax == null) {
        throw new b("Not all required fields were included: ObjectDesc");
      }
      paramVarArgs.O(1, this.tkR);
      if (this.tfa != null) {
        paramVarArgs.e(2, this.tfa);
      }
      if (this.tLN != null) {
        paramVarArgs.e(3, this.tLN);
      }
      paramVarArgs.eO(4, this.ofk);
      if (this.uax != null)
      {
        paramVarArgs.eQ(5, this.uax.aUd());
        this.uax.a(paramVarArgs);
      }
      paramVarArgs.eO(6, this.uay);
      paramVarArgs.eO(7, this.uaz);
      paramVarArgs.eO(8, this.uaA);
      paramVarArgs.d(9, 8, this.uaB);
      paramVarArgs.eO(10, this.uaC);
      paramVarArgs.eO(11, this.uaD);
      paramVarArgs.d(12, 8, this.uaE);
      paramVarArgs.eO(13, this.uaF);
      paramVarArgs.eO(14, this.uaG);
      paramVarArgs.d(15, 8, this.uaH);
      paramVarArgs.eO(16, this.tPn);
      paramVarArgs.eO(17, this.uaI);
      paramVarArgs.eO(18, this.tQD);
      paramVarArgs.d(19, 8, this.tdT);
      paramVarArgs.eO(20, this.tZZ);
      if (this.uaJ != null) {
        paramVarArgs.e(21, this.uaJ);
      }
      paramVarArgs.O(22, this.uaK);
      paramVarArgs.eO(23, this.uaL);
      paramVarArgs.d(24, 8, this.uaM);
      paramVarArgs.eO(25, this.tPi);
      paramVarArgs.eO(26, this.uaN);
      paramVarArgs.d(27, 8, this.tOe);
      if (this.uaO != null)
      {
        paramVarArgs.eQ(28, this.uaO.aUd());
        this.uaO.a(paramVarArgs);
      }
      if (this.uaP != null)
      {
        paramVarArgs.eQ(29, this.uaP.aUd());
        this.uaP.a(paramVarArgs);
      }
      if (this.uaQ != null)
      {
        paramVarArgs.eQ(30, this.uaQ.aUd());
        this.uaQ.a(paramVarArgs);
      }
      if (this.uaR != null)
      {
        paramVarArgs.eQ(31, this.uaR.aUd());
        this.uaR.a(paramVarArgs);
      }
      GMTrace.o(3789369114624L, 28233);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.N(1, this.tkR) + 0;
      paramInt = i;
      if (this.tfa != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tfa);
      }
      i = paramInt;
      if (this.tLN != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tLN);
      }
      i += a.a.a.a.eL(4, this.ofk);
      paramInt = i;
      if (this.uax != null) {
        paramInt = i + a.a.a.a.eN(5, this.uax.aUd());
      }
      i = paramInt + a.a.a.a.eL(6, this.uay) + a.a.a.a.eL(7, this.uaz) + a.a.a.a.eL(8, this.uaA) + a.a.a.a.c(9, 8, this.uaB) + a.a.a.a.eL(10, this.uaC) + a.a.a.a.eL(11, this.uaD) + a.a.a.a.c(12, 8, this.uaE) + a.a.a.a.eL(13, this.uaF) + a.a.a.a.eL(14, this.uaG) + a.a.a.a.c(15, 8, this.uaH) + a.a.a.a.eL(16, this.tPn) + a.a.a.a.eL(17, this.uaI) + a.a.a.a.eL(18, this.tQD) + a.a.a.a.c(19, 8, this.tdT) + a.a.a.a.eL(20, this.tZZ);
      paramInt = i;
      if (this.uaJ != null) {
        paramInt = i + a.a.a.b.b.a.f(21, this.uaJ);
      }
      i = paramInt + a.a.a.a.N(22, this.uaK) + a.a.a.a.eL(23, this.uaL) + a.a.a.a.c(24, 8, this.uaM) + a.a.a.a.eL(25, this.tPi) + a.a.a.a.eL(26, this.uaN) + a.a.a.a.c(27, 8, this.tOe);
      paramInt = i;
      if (this.uaO != null) {
        paramInt = i + a.a.a.a.eN(28, this.uaO.aUd());
      }
      i = paramInt;
      if (this.uaP != null) {
        i = paramInt + a.a.a.a.eN(29, this.uaP.aUd());
      }
      paramInt = i;
      if (this.uaQ != null) {
        paramInt = i + a.a.a.a.eN(30, this.uaQ.aUd());
      }
      i = paramInt;
      if (this.uaR != null) {
        i = paramInt + a.a.a.a.eN(31, this.uaR.aUd());
      }
      GMTrace.o(3789369114624L, 28233);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uaB.clear();
      this.uaE.clear();
      this.uaH.clear();
      this.tdT.clear();
      this.uaM.clear();
      this.tOe.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.uax == null) {
        throw new b("Not all required fields were included: ObjectDesc");
      }
      GMTrace.o(3789369114624L, 28233);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bbg localbbg = (bbg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3789369114624L, 28233);
        return -1;
      case 1: 
        localbbg.tkR = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 2: 
        localbbg.tfa = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 3: 
        localbbg.tLN = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 4: 
        localbbg.ofk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbbg.uax = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 6: 
        localbbg.uay = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 7: 
        localbbg.uaz = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 8: 
        localbbg.uaA = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new baw();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((baw)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbbg.uaB.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 10: 
        localbbg.uaC = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 11: 
        localbbg.uaD = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 12: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new baw();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((baw)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbbg.uaE.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 13: 
        localbbg.uaF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 14: 
        localbbg.uaG = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 15: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new baw();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((baw)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbbg.uaH.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 16: 
        localbbg.tPn = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 17: 
        localbbg.uaI = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 18: 
        localbbg.tQD = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 19: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bbb();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bbb)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbbg.tdT.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 20: 
        localbbg.tZZ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 21: 
        localbbg.uaJ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 22: 
        localbbg.uaK = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 23: 
        localbbg.uaL = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 24: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbbg.uaM.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 25: 
        localbbg.tPi = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 26: 
        localbbg.uaN = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 27: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbbg.tOe.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 28: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbbg.uaO = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 29: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bbv();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bbv)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbbg.uaP = ((bbv)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3789369114624L, 28233);
        return 0;
      case 30: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aqx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aqx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbbg.uaQ = ((aqx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3789369114624L, 28233);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bas();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bas)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localbbg.uaR = ((bas)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3789369114624L, 28233);
      return 0;
    }
    GMTrace.o(3789369114624L, 28233);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */