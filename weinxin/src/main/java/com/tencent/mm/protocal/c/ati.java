package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ati
  extends com.tencent.mm.bd.a
{
  public String mqG;
  public int mqO;
  public String mrs;
  public String mtr;
  public int tQC;
  public String tVD;
  public String tVE;
  public int tVF;
  public LinkedList<avu> tVG;
  public String tVH;
  public String tVI;
  public String tVJ;
  public String tVK;
  public String tVL;
  public String tVM;
  public String tVN;
  public int tVO;
  public String tcA;
  public String tcB;
  public bqt tcC;
  public String tcw;
  public String tcx;
  public String tcy;
  public String tcz;
  public String tft;
  
  public ati()
  {
    GMTrace.i(3888824451072L, 28974);
    this.tVG = new LinkedList();
    GMTrace.o(3888824451072L, 28974);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3888958668800L, 28975);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.mqG != null) {
        paramVarArgs.e(1, this.mqG);
      }
      if (this.mtr != null) {
        paramVarArgs.e(2, this.mtr);
      }
      if (this.tcy != null) {
        paramVarArgs.e(3, this.tcy);
      }
      if (this.tVD != null) {
        paramVarArgs.e(4, this.tVD);
      }
      if (this.tcx != null) {
        paramVarArgs.e(5, this.tcx);
      }
      if (this.tcw != null) {
        paramVarArgs.e(6, this.tcw);
      }
      if (this.tVE != null) {
        paramVarArgs.e(7, this.tVE);
      }
      paramVarArgs.eO(8, this.tVF);
      paramVarArgs.d(9, 8, this.tVG);
      if (this.tcz != null) {
        paramVarArgs.e(10, this.tcz);
      }
      if (this.tVH != null) {
        paramVarArgs.e(11, this.tVH);
      }
      if (this.tVI != null) {
        paramVarArgs.e(12, this.tVI);
      }
      paramVarArgs.eO(13, this.tQC);
      if (this.tft != null) {
        paramVarArgs.e(14, this.tft);
      }
      if (this.mrs != null) {
        paramVarArgs.e(15, this.mrs);
      }
      if (this.tcA != null) {
        paramVarArgs.e(16, this.tcA);
      }
      if (this.tVJ != null) {
        paramVarArgs.e(17, this.tVJ);
      }
      if (this.tVK != null) {
        paramVarArgs.e(18, this.tVK);
      }
      if (this.tcB != null) {
        paramVarArgs.e(19, this.tcB);
      }
      if (this.tVL != null) {
        paramVarArgs.e(20, this.tVL);
      }
      if (this.tVM != null) {
        paramVarArgs.e(21, this.tVM);
      }
      if (this.tcC != null)
      {
        paramVarArgs.eQ(22, this.tcC.aUd());
        this.tcC.a(paramVarArgs);
      }
      if (this.tVN != null) {
        paramVarArgs.e(23, this.tVN);
      }
      paramVarArgs.eO(24, this.tVO);
      paramVarArgs.eO(25, this.mqO);
      GMTrace.o(3888958668800L, 28975);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.mqG != null) {
        i = a.a.a.b.b.a.f(1, this.mqG) + 0;
      }
      paramInt = i;
      if (this.mtr != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.mtr);
      }
      i = paramInt;
      if (this.tcy != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tcy);
      }
      paramInt = i;
      if (this.tVD != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tVD);
      }
      i = paramInt;
      if (this.tcx != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tcx);
      }
      paramInt = i;
      if (this.tcw != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tcw);
      }
      i = paramInt;
      if (this.tVE != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.tVE);
      }
      i = i + a.a.a.a.eL(8, this.tVF) + a.a.a.a.c(9, 8, this.tVG);
      paramInt = i;
      if (this.tcz != null) {
        paramInt = i + a.a.a.b.b.a.f(10, this.tcz);
      }
      i = paramInt;
      if (this.tVH != null) {
        i = paramInt + a.a.a.b.b.a.f(11, this.tVH);
      }
      paramInt = i;
      if (this.tVI != null) {
        paramInt = i + a.a.a.b.b.a.f(12, this.tVI);
      }
      i = paramInt + a.a.a.a.eL(13, this.tQC);
      paramInt = i;
      if (this.tft != null) {
        paramInt = i + a.a.a.b.b.a.f(14, this.tft);
      }
      i = paramInt;
      if (this.mrs != null) {
        i = paramInt + a.a.a.b.b.a.f(15, this.mrs);
      }
      paramInt = i;
      if (this.tcA != null) {
        paramInt = i + a.a.a.b.b.a.f(16, this.tcA);
      }
      i = paramInt;
      if (this.tVJ != null) {
        i = paramInt + a.a.a.b.b.a.f(17, this.tVJ);
      }
      paramInt = i;
      if (this.tVK != null) {
        paramInt = i + a.a.a.b.b.a.f(18, this.tVK);
      }
      i = paramInt;
      if (this.tcB != null) {
        i = paramInt + a.a.a.b.b.a.f(19, this.tcB);
      }
      paramInt = i;
      if (this.tVL != null) {
        paramInt = i + a.a.a.b.b.a.f(20, this.tVL);
      }
      i = paramInt;
      if (this.tVM != null) {
        i = paramInt + a.a.a.b.b.a.f(21, this.tVM);
      }
      paramInt = i;
      if (this.tcC != null) {
        paramInt = i + a.a.a.a.eN(22, this.tcC.aUd());
      }
      i = paramInt;
      if (this.tVN != null) {
        i = paramInt + a.a.a.b.b.a.f(23, this.tVN);
      }
      paramInt = a.a.a.a.eL(24, this.tVO);
      int j = a.a.a.a.eL(25, this.mqO);
      GMTrace.o(3888958668800L, 28975);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tVG.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3888958668800L, 28975);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ati localati = (ati)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3888958668800L, 28975);
        return -1;
      case 1: 
        localati.mqG = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 2: 
        localati.mtr = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 3: 
        localati.tcy = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 4: 
        localati.tVD = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 5: 
        localati.tcx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 6: 
        localati.tcw = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 7: 
        localati.tVE = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 8: 
        localati.tVF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localati.tVG.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 10: 
        localati.tcz = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 11: 
        localati.tVH = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 12: 
        localati.tVI = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 13: 
        localati.tQC = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 14: 
        localati.tft = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 15: 
        localati.mrs = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 16: 
        localati.tcA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 17: 
        localati.tVJ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 18: 
        localati.tVK = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 19: 
        localati.tcB = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 20: 
        localati.tVL = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 21: 
        localati.tVM = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 22: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localati.tcC = ((bqt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 23: 
        localati.tVN = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      case 24: 
        localati.tVO = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3888958668800L, 28975);
        return 0;
      }
      localati.mqO = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3888958668800L, 28975);
      return 0;
    }
    GMTrace.o(3888958668800L, 28975);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ati.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */