package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class tm
  extends ave
{
  public String jLx;
  public int tay;
  public int tcg;
  public int tdn;
  public avt tfH;
  public avu tzJ;
  public avu tzK;
  public avu tzL;
  public avu tzM;
  public String tzN;
  public int tzO;
  public String tzP;
  public avt tzQ;
  public int tzR;
  public int tzS;
  public String tzT;
  public int tzU;
  public int tzV;
  public int tzW;
  
  public tm()
  {
    GMTrace.i(3980092506112L, 29654);
    GMTrace.o(3980092506112L, 29654);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3980226723840L, 29655);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tay);
      if (this.tfH != null)
      {
        paramVarArgs.eQ(3, this.tfH.aUd());
        this.tfH.a(paramVarArgs);
      }
      if (this.tzJ != null)
      {
        paramVarArgs.eQ(4, this.tzJ.aUd());
        this.tzJ.a(paramVarArgs);
      }
      if (this.tzK != null)
      {
        paramVarArgs.eQ(5, this.tzK.aUd());
        this.tzK.a(paramVarArgs);
      }
      if (this.tzL != null)
      {
        paramVarArgs.eQ(6, this.tzL.aUd());
        this.tzL.a(paramVarArgs);
      }
      if (this.tzM != null)
      {
        paramVarArgs.eQ(7, this.tzM.aUd());
        this.tzM.a(paramVarArgs);
      }
      if (this.tzN != null) {
        paramVarArgs.e(8, this.tzN);
      }
      paramVarArgs.eO(9, this.tzO);
      paramVarArgs.eO(10, this.tcg);
      if (this.jLx != null) {
        paramVarArgs.e(11, this.jLx);
      }
      if (this.tzP != null) {
        paramVarArgs.e(12, this.tzP);
      }
      if (this.tzQ != null)
      {
        paramVarArgs.eQ(13, this.tzQ.aUd());
        this.tzQ.a(paramVarArgs);
      }
      paramVarArgs.eO(14, this.tzR);
      paramVarArgs.eO(15, this.tzS);
      paramVarArgs.eO(16, this.tdn);
      if (this.tzT != null) {
        paramVarArgs.e(17, this.tzT);
      }
      paramVarArgs.eO(18, this.tzU);
      paramVarArgs.eO(19, this.tzV);
      paramVarArgs.eO(20, this.tzW);
      GMTrace.o(3980226723840L, 29655);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tay);
      paramInt = i;
      if (this.tfH != null) {
        paramInt = i + a.a.a.a.eN(3, this.tfH.aUd());
      }
      i = paramInt;
      if (this.tzJ != null) {
        i = paramInt + a.a.a.a.eN(4, this.tzJ.aUd());
      }
      paramInt = i;
      if (this.tzK != null) {
        paramInt = i + a.a.a.a.eN(5, this.tzK.aUd());
      }
      i = paramInt;
      if (this.tzL != null) {
        i = paramInt + a.a.a.a.eN(6, this.tzL.aUd());
      }
      paramInt = i;
      if (this.tzM != null) {
        paramInt = i + a.a.a.a.eN(7, this.tzM.aUd());
      }
      i = paramInt;
      if (this.tzN != null) {
        i = paramInt + a.a.a.b.b.a.f(8, this.tzN);
      }
      i = i + a.a.a.a.eL(9, this.tzO) + a.a.a.a.eL(10, this.tcg);
      paramInt = i;
      if (this.jLx != null) {
        paramInt = i + a.a.a.b.b.a.f(11, this.jLx);
      }
      i = paramInt;
      if (this.tzP != null) {
        i = paramInt + a.a.a.b.b.a.f(12, this.tzP);
      }
      paramInt = i;
      if (this.tzQ != null) {
        paramInt = i + a.a.a.a.eN(13, this.tzQ.aUd());
      }
      i = paramInt + a.a.a.a.eL(14, this.tzR) + a.a.a.a.eL(15, this.tzS) + a.a.a.a.eL(16, this.tdn);
      paramInt = i;
      if (this.tzT != null) {
        paramInt = i + a.a.a.b.b.a.f(17, this.tzT);
      }
      i = a.a.a.a.eL(18, this.tzU);
      int j = a.a.a.a.eL(19, this.tzV);
      int k = a.a.a.a.eL(20, this.tzW);
      GMTrace.o(3980226723840L, 29655);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3980226723840L, 29655);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      tm localtm = (tm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3980226723840L, 29655);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localtm.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 2: 
        localtm.tay = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localtm.tfH = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localtm.tzJ = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localtm.tzK = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localtm.tzL = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localtm.tzM = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 8: 
        localtm.tzN = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 9: 
        localtm.tzO = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 10: 
        localtm.tcg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 11: 
        localtm.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 12: 
        localtm.tzP = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 13: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localtm.tzQ = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 14: 
        localtm.tzR = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 15: 
        localtm.tzS = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 16: 
        localtm.tdn = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 17: 
        localtm.tzT = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 18: 
        localtm.tzU = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3980226723840L, 29655);
        return 0;
      case 19: 
        localtm.tzV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3980226723840L, 29655);
        return 0;
      }
      localtm.tzW = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3980226723840L, 29655);
      return 0;
    }
    GMTrace.o(3980226723840L, 29655);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/tm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */