package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bhr
  extends ave
{
  public int mrC;
  public int tEg;
  public String tIY;
  public int tYv;
  public String tdC;
  public avu tdx;
  public avu tdy;
  public int tfd;
  public int tfe;
  public int tff;
  public String tlA;
  public int tlB;
  public int tlC;
  public int tlD;
  public int tpX;
  public avt tqC;
  public String tsH;
  public int tsY;
  public String tso;
  public int ubQ;
  public String ufA;
  public String ufB;
  public int ufC;
  public int ufD;
  public String ufE;
  public int ufF;
  public int ufG;
  public int ufH;
  public avu ufz;
  
  public bhr()
  {
    GMTrace.i(3686021464064L, 27463);
    GMTrace.o(3686021464064L, 27463);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3686155681792L, 27464);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.ufz == null) {
        throw new b("Not all required fields were included: ClientImgId");
      }
      if (this.tdx == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.tdy == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.ufz != null)
      {
        paramVarArgs.eQ(2, this.ufz.aUd());
        this.ufz.a(paramVarArgs);
      }
      if (this.tdx != null)
      {
        paramVarArgs.eQ(3, this.tdx.aUd());
        this.tdx.a(paramVarArgs);
      }
      if (this.tdy != null)
      {
        paramVarArgs.eQ(4, this.tdy.aUd());
        this.tdy.a(paramVarArgs);
      }
      paramVarArgs.eO(5, this.tfd);
      paramVarArgs.eO(6, this.tfe);
      paramVarArgs.eO(7, this.tff);
      if (this.tqC != null)
      {
        paramVarArgs.eQ(8, this.tqC.aUd());
        this.tqC.a(paramVarArgs);
      }
      paramVarArgs.eO(9, this.mrC);
      if (this.tdC != null) {
        paramVarArgs.e(10, this.tdC);
      }
      paramVarArgs.eO(11, this.tEg);
      paramVarArgs.eO(12, this.tpX);
      paramVarArgs.eO(13, this.ubQ);
      if (this.tso != null) {
        paramVarArgs.e(14, this.tso);
      }
      if (this.ufA != null) {
        paramVarArgs.e(15, this.ufA);
      }
      if (this.ufB != null) {
        paramVarArgs.e(16, this.ufB);
      }
      if (this.tlA != null) {
        paramVarArgs.e(17, this.tlA);
      }
      paramVarArgs.eO(18, this.tlB);
      paramVarArgs.eO(19, this.ufC);
      paramVarArgs.eO(20, this.ufD);
      if (this.ufE != null) {
        paramVarArgs.e(21, this.ufE);
      }
      paramVarArgs.eO(22, this.ufF);
      paramVarArgs.eO(23, this.ufG);
      paramVarArgs.eO(24, this.ufH);
      if (this.tIY != null) {
        paramVarArgs.e(25, this.tIY);
      }
      paramVarArgs.eO(26, this.tsY);
      if (this.tsH != null) {
        paramVarArgs.e(27, this.tsH);
      }
      paramVarArgs.eO(28, this.tlC);
      paramVarArgs.eO(29, this.tlD);
      paramVarArgs.eO(30, this.tYv);
      GMTrace.o(3686155681792L, 27464);
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
      if (this.ufz != null) {
        paramInt = i + a.a.a.a.eN(2, this.ufz.aUd());
      }
      i = paramInt;
      if (this.tdx != null) {
        i = paramInt + a.a.a.a.eN(3, this.tdx.aUd());
      }
      paramInt = i;
      if (this.tdy != null) {
        paramInt = i + a.a.a.a.eN(4, this.tdy.aUd());
      }
      i = paramInt + a.a.a.a.eL(5, this.tfd) + a.a.a.a.eL(6, this.tfe) + a.a.a.a.eL(7, this.tff);
      paramInt = i;
      if (this.tqC != null) {
        paramInt = i + a.a.a.a.eN(8, this.tqC.aUd());
      }
      i = paramInt + a.a.a.a.eL(9, this.mrC);
      paramInt = i;
      if (this.tdC != null) {
        paramInt = i + a.a.a.b.b.a.f(10, this.tdC);
      }
      i = paramInt + a.a.a.a.eL(11, this.tEg) + a.a.a.a.eL(12, this.tpX) + a.a.a.a.eL(13, this.ubQ);
      paramInt = i;
      if (this.tso != null) {
        paramInt = i + a.a.a.b.b.a.f(14, this.tso);
      }
      i = paramInt;
      if (this.ufA != null) {
        i = paramInt + a.a.a.b.b.a.f(15, this.ufA);
      }
      paramInt = i;
      if (this.ufB != null) {
        paramInt = i + a.a.a.b.b.a.f(16, this.ufB);
      }
      i = paramInt;
      if (this.tlA != null) {
        i = paramInt + a.a.a.b.b.a.f(17, this.tlA);
      }
      i = i + a.a.a.a.eL(18, this.tlB) + a.a.a.a.eL(19, this.ufC) + a.a.a.a.eL(20, this.ufD);
      paramInt = i;
      if (this.ufE != null) {
        paramInt = i + a.a.a.b.b.a.f(21, this.ufE);
      }
      i = paramInt + a.a.a.a.eL(22, this.ufF) + a.a.a.a.eL(23, this.ufG) + a.a.a.a.eL(24, this.ufH);
      paramInt = i;
      if (this.tIY != null) {
        paramInt = i + a.a.a.b.b.a.f(25, this.tIY);
      }
      i = paramInt + a.a.a.a.eL(26, this.tsY);
      paramInt = i;
      if (this.tsH != null) {
        paramInt = i + a.a.a.b.b.a.f(27, this.tsH);
      }
      i = a.a.a.a.eL(28, this.tlC);
      int j = a.a.a.a.eL(29, this.tlD);
      int k = a.a.a.a.eL(30, this.tYv);
      GMTrace.o(3686155681792L, 27464);
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
      if (this.ufz == null) {
        throw new b("Not all required fields were included: ClientImgId");
      }
      if (this.tdx == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.tdy == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      GMTrace.o(3686155681792L, 27464);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bhr localbhr = (bhr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3686155681792L, 27464);
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
          localbhr.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbhr.ufz = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbhr.tdx = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3686155681792L, 27464);
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
          localbhr.tdy = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 5: 
        localbhr.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 6: 
        localbhr.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 7: 
        localbhr.tff = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 8: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbhr.tqC = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 9: 
        localbhr.mrC = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 10: 
        localbhr.tdC = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 11: 
        localbhr.tEg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 12: 
        localbhr.tpX = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 13: 
        localbhr.ubQ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 14: 
        localbhr.tso = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 15: 
        localbhr.ufA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 16: 
        localbhr.ufB = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 17: 
        localbhr.tlA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 18: 
        localbhr.tlB = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 19: 
        localbhr.ufC = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 20: 
        localbhr.ufD = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 21: 
        localbhr.ufE = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 22: 
        localbhr.ufF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 23: 
        localbhr.ufG = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 24: 
        localbhr.ufH = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 25: 
        localbhr.tIY = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 26: 
        localbhr.tsY = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 27: 
        localbhr.tsH = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 28: 
        localbhr.tlC = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      case 29: 
        localbhr.tlD = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3686155681792L, 27464);
        return 0;
      }
      localbhr.tYv = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3686155681792L, 27464);
      return 0;
    }
    GMTrace.o(3686155681792L, 27464);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bhr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */