package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bhz
  extends ave
{
  public String mut;
  public String muu;
  public String tIW;
  public String tIY;
  public int tNg;
  public int tNh;
  public avt tNi;
  public int tNj;
  public int tYv;
  public String tdC;
  public String teo;
  public int teq;
  public String tlA;
  public int tlB;
  public int tlC;
  public int tlD;
  public int tsY;
  public int tss;
  public int ufF;
  public int ufG;
  public int ufH;
  public int ufN;
  public int ufO;
  public avt ufP;
  public int ufQ;
  public int ufR;
  public String ufS;
  public int ufT;
  public String ufU;
  public String ufV;
  public int ufW;
  public String ufX;
  public String ufY;
  public String ufZ;
  public String uga;
  public String ugb;
  public String ugc;
  public String ugd;
  public String uge;
  
  public bhz()
  {
    GMTrace.i(3839298109440L, 28605);
    GMTrace.o(3839298109440L, 28605);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3839432327168L, 28606);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tNi == null) {
        throw new b("Not all required fields were included: ThumbData");
      }
      if (this.ufP == null) {
        throw new b("Not all required fields were included: VideoData");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.teo != null) {
        paramVarArgs.e(2, this.teo);
      }
      if (this.muu != null) {
        paramVarArgs.e(3, this.muu);
      }
      if (this.mut != null) {
        paramVarArgs.e(4, this.mut);
      }
      paramVarArgs.eO(5, this.tNg);
      paramVarArgs.eO(6, this.tNh);
      if (this.tNi != null)
      {
        paramVarArgs.eQ(7, this.tNi.aUd());
        this.tNi.a(paramVarArgs);
      }
      paramVarArgs.eO(8, this.ufN);
      paramVarArgs.eO(9, this.ufO);
      if (this.ufP != null)
      {
        paramVarArgs.eQ(10, this.ufP.aUd());
        this.ufP.a(paramVarArgs);
      }
      paramVarArgs.eO(11, this.ufQ);
      paramVarArgs.eO(12, this.tss);
      paramVarArgs.eO(13, this.tNj);
      paramVarArgs.eO(14, this.ufR);
      if (this.tdC != null) {
        paramVarArgs.e(15, this.tdC);
      }
      if (this.ufS != null) {
        paramVarArgs.e(16, this.ufS);
      }
      if (this.tlA != null) {
        paramVarArgs.e(17, this.tlA);
      }
      paramVarArgs.eO(18, this.tlB);
      if (this.tIW != null) {
        paramVarArgs.e(19, this.tIW);
      }
      paramVarArgs.eO(20, this.ufF);
      paramVarArgs.eO(21, this.ufG);
      paramVarArgs.eO(22, this.ufH);
      if (this.tIY != null) {
        paramVarArgs.e(23, this.tIY);
      }
      paramVarArgs.eO(24, this.ufT);
      paramVarArgs.eO(25, this.tsY);
      if (this.ufU != null) {
        paramVarArgs.e(26, this.ufU);
      }
      if (this.ufV != null) {
        paramVarArgs.e(27, this.ufV);
      }
      paramVarArgs.eO(28, this.ufW);
      if (this.ufX != null) {
        paramVarArgs.e(29, this.ufX);
      }
      if (this.ufY != null) {
        paramVarArgs.e(30, this.ufY);
      }
      if (this.ufZ != null) {
        paramVarArgs.e(31, this.ufZ);
      }
      if (this.uga != null) {
        paramVarArgs.e(32, this.uga);
      }
      if (this.ugb != null) {
        paramVarArgs.e(33, this.ugb);
      }
      if (this.ugc != null) {
        paramVarArgs.e(34, this.ugc);
      }
      if (this.ugd != null) {
        paramVarArgs.e(35, this.ugd);
      }
      paramVarArgs.eO(36, this.tYv);
      if (this.uge != null) {
        paramVarArgs.e(37, this.uge);
      }
      paramVarArgs.eO(38, this.tlC);
      paramVarArgs.eO(39, this.tlD);
      paramVarArgs.eO(40, this.teq);
      GMTrace.o(3839432327168L, 28606);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXb != null) {
        i = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      paramInt = i;
      if (this.teo != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.teo);
      }
      i = paramInt;
      if (this.muu != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.muu);
      }
      paramInt = i;
      if (this.mut != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.mut);
      }
      i = paramInt + a.a.a.a.eL(5, this.tNg) + a.a.a.a.eL(6, this.tNh);
      paramInt = i;
      if (this.tNi != null) {
        paramInt = i + a.a.a.a.eN(7, this.tNi.aUd());
      }
      i = paramInt + a.a.a.a.eL(8, this.ufN) + a.a.a.a.eL(9, this.ufO);
      paramInt = i;
      if (this.ufP != null) {
        paramInt = i + a.a.a.a.eN(10, this.ufP.aUd());
      }
      i = paramInt + a.a.a.a.eL(11, this.ufQ) + a.a.a.a.eL(12, this.tss) + a.a.a.a.eL(13, this.tNj) + a.a.a.a.eL(14, this.ufR);
      paramInt = i;
      if (this.tdC != null) {
        paramInt = i + a.a.a.b.b.a.f(15, this.tdC);
      }
      i = paramInt;
      if (this.ufS != null) {
        i = paramInt + a.a.a.b.b.a.f(16, this.ufS);
      }
      paramInt = i;
      if (this.tlA != null) {
        paramInt = i + a.a.a.b.b.a.f(17, this.tlA);
      }
      i = paramInt + a.a.a.a.eL(18, this.tlB);
      paramInt = i;
      if (this.tIW != null) {
        paramInt = i + a.a.a.b.b.a.f(19, this.tIW);
      }
      i = paramInt + a.a.a.a.eL(20, this.ufF) + a.a.a.a.eL(21, this.ufG) + a.a.a.a.eL(22, this.ufH);
      paramInt = i;
      if (this.tIY != null) {
        paramInt = i + a.a.a.b.b.a.f(23, this.tIY);
      }
      i = paramInt + a.a.a.a.eL(24, this.ufT) + a.a.a.a.eL(25, this.tsY);
      paramInt = i;
      if (this.ufU != null) {
        paramInt = i + a.a.a.b.b.a.f(26, this.ufU);
      }
      i = paramInt;
      if (this.ufV != null) {
        i = paramInt + a.a.a.b.b.a.f(27, this.ufV);
      }
      i += a.a.a.a.eL(28, this.ufW);
      paramInt = i;
      if (this.ufX != null) {
        paramInt = i + a.a.a.b.b.a.f(29, this.ufX);
      }
      i = paramInt;
      if (this.ufY != null) {
        i = paramInt + a.a.a.b.b.a.f(30, this.ufY);
      }
      paramInt = i;
      if (this.ufZ != null) {
        paramInt = i + a.a.a.b.b.a.f(31, this.ufZ);
      }
      i = paramInt;
      if (this.uga != null) {
        i = paramInt + a.a.a.b.b.a.f(32, this.uga);
      }
      paramInt = i;
      if (this.ugb != null) {
        paramInt = i + a.a.a.b.b.a.f(33, this.ugb);
      }
      i = paramInt;
      if (this.ugc != null) {
        i = paramInt + a.a.a.b.b.a.f(34, this.ugc);
      }
      paramInt = i;
      if (this.ugd != null) {
        paramInt = i + a.a.a.b.b.a.f(35, this.ugd);
      }
      i = paramInt + a.a.a.a.eL(36, this.tYv);
      paramInt = i;
      if (this.uge != null) {
        paramInt = i + a.a.a.b.b.a.f(37, this.uge);
      }
      i = a.a.a.a.eL(38, this.tlC);
      int j = a.a.a.a.eL(39, this.tlD);
      int k = a.a.a.a.eL(40, this.teq);
      GMTrace.o(3839432327168L, 28606);
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
      if (this.tNi == null) {
        throw new b("Not all required fields were included: ThumbData");
      }
      if (this.ufP == null) {
        throw new b("Not all required fields were included: VideoData");
      }
      GMTrace.o(3839432327168L, 28606);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bhz localbhz = (bhz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3839432327168L, 28606);
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
          localbhz.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 2: 
        localbhz.teo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 3: 
        localbhz.muu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 4: 
        localbhz.mut = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 5: 
        localbhz.tNg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 6: 
        localbhz.tNh = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbhz.tNi = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 8: 
        localbhz.ufN = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 9: 
        localbhz.ufO = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 10: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbhz.ufP = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 11: 
        localbhz.ufQ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 12: 
        localbhz.tss = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 13: 
        localbhz.tNj = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 14: 
        localbhz.ufR = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 15: 
        localbhz.tdC = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 16: 
        localbhz.ufS = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 17: 
        localbhz.tlA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 18: 
        localbhz.tlB = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 19: 
        localbhz.tIW = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 20: 
        localbhz.ufF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 21: 
        localbhz.ufG = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 22: 
        localbhz.ufH = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 23: 
        localbhz.tIY = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 24: 
        localbhz.ufT = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 25: 
        localbhz.tsY = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 26: 
        localbhz.ufU = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 27: 
        localbhz.ufV = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 28: 
        localbhz.ufW = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 29: 
        localbhz.ufX = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 30: 
        localbhz.ufY = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 31: 
        localbhz.ufZ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 32: 
        localbhz.uga = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 33: 
        localbhz.ugb = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 34: 
        localbhz.ugc = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 35: 
        localbhz.ugd = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 36: 
        localbhz.tYv = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 37: 
        localbhz.uge = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 38: 
        localbhz.tlC = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      case 39: 
        localbhz.tlD = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3839432327168L, 28606);
        return 0;
      }
      localbhz.teq = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3839432327168L, 28606);
      return 0;
    }
    GMTrace.o(3839432327168L, 28606);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bhz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */