package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class dr
  extends com.tencent.mm.bd.a
{
  public int lcP;
  public String tcc;
  public int tfA;
  public avt tfB;
  public bme tfC;
  public bpk tfD;
  public avt tfE;
  public avt tfF;
  public String tfG;
  public avt tfH;
  public String tfI;
  public azz tfJ;
  public String tfK;
  public int tfL;
  public int tfM;
  public int tfN;
  public int tfO;
  public or tfx;
  public avt tfy;
  public avt tfz;
  
  public dr()
  {
    GMTrace.i(13584310468608L, 101211);
    GMTrace.o(13584310468608L, 101211);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13584444686336L, 101212);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tfx == null) {
        throw new b("Not all required fields were included: SvrPubECDHKey");
      }
      if (this.tfy == null) {
        throw new b("Not all required fields were included: SessionKey");
      }
      if (this.tfz == null) {
        throw new b("Not all required fields were included: AutoAuthKey");
      }
      paramVarArgs.eO(1, this.lcP);
      if (this.tfx != null)
      {
        paramVarArgs.eQ(2, this.tfx.aUd());
        this.tfx.a(paramVarArgs);
      }
      if (this.tfy != null)
      {
        paramVarArgs.eQ(3, this.tfy.aUd());
        this.tfy.a(paramVarArgs);
      }
      if (this.tfz != null)
      {
        paramVarArgs.eQ(4, this.tfz.aUd());
        this.tfz.a(paramVarArgs);
      }
      paramVarArgs.eO(5, this.tfA);
      if (this.tfB != null)
      {
        paramVarArgs.eQ(6, this.tfB.aUd());
        this.tfB.a(paramVarArgs);
      }
      if (this.tfC != null)
      {
        paramVarArgs.eQ(7, this.tfC.aUd());
        this.tfC.a(paramVarArgs);
      }
      if (this.tfD != null)
      {
        paramVarArgs.eQ(8, this.tfD.aUd());
        this.tfD.a(paramVarArgs);
      }
      if (this.tfE != null)
      {
        paramVarArgs.eQ(9, this.tfE.aUd());
        this.tfE.a(paramVarArgs);
      }
      if (this.tfF != null)
      {
        paramVarArgs.eQ(10, this.tfF.aUd());
        this.tfF.a(paramVarArgs);
      }
      if (this.tfG != null) {
        paramVarArgs.e(11, this.tfG);
      }
      if (this.tfH != null)
      {
        paramVarArgs.eQ(12, this.tfH.aUd());
        this.tfH.a(paramVarArgs);
      }
      if (this.tfI != null) {
        paramVarArgs.e(14, this.tfI);
      }
      if (this.tfJ != null)
      {
        paramVarArgs.eQ(15, this.tfJ.aUd());
        this.tfJ.a(paramVarArgs);
      }
      if (this.tfK != null) {
        paramVarArgs.e(16, this.tfK);
      }
      paramVarArgs.eO(17, this.tfL);
      paramVarArgs.eO(18, this.tfM);
      paramVarArgs.eO(19, this.tfN);
      if (this.tcc != null) {
        paramVarArgs.e(20, this.tcc);
      }
      paramVarArgs.eO(21, this.tfO);
      GMTrace.o(13584444686336L, 101212);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.lcP) + 0;
      paramInt = i;
      if (this.tfx != null) {
        paramInt = i + a.a.a.a.eN(2, this.tfx.aUd());
      }
      i = paramInt;
      if (this.tfy != null) {
        i = paramInt + a.a.a.a.eN(3, this.tfy.aUd());
      }
      paramInt = i;
      if (this.tfz != null) {
        paramInt = i + a.a.a.a.eN(4, this.tfz.aUd());
      }
      i = paramInt + a.a.a.a.eL(5, this.tfA);
      paramInt = i;
      if (this.tfB != null) {
        paramInt = i + a.a.a.a.eN(6, this.tfB.aUd());
      }
      i = paramInt;
      if (this.tfC != null) {
        i = paramInt + a.a.a.a.eN(7, this.tfC.aUd());
      }
      paramInt = i;
      if (this.tfD != null) {
        paramInt = i + a.a.a.a.eN(8, this.tfD.aUd());
      }
      i = paramInt;
      if (this.tfE != null) {
        i = paramInt + a.a.a.a.eN(9, this.tfE.aUd());
      }
      paramInt = i;
      if (this.tfF != null) {
        paramInt = i + a.a.a.a.eN(10, this.tfF.aUd());
      }
      i = paramInt;
      if (this.tfG != null) {
        i = paramInt + a.a.a.b.b.a.f(11, this.tfG);
      }
      paramInt = i;
      if (this.tfH != null) {
        paramInt = i + a.a.a.a.eN(12, this.tfH.aUd());
      }
      i = paramInt;
      if (this.tfI != null) {
        i = paramInt + a.a.a.b.b.a.f(14, this.tfI);
      }
      paramInt = i;
      if (this.tfJ != null) {
        paramInt = i + a.a.a.a.eN(15, this.tfJ.aUd());
      }
      i = paramInt;
      if (this.tfK != null) {
        i = paramInt + a.a.a.b.b.a.f(16, this.tfK);
      }
      i = i + a.a.a.a.eL(17, this.tfL) + a.a.a.a.eL(18, this.tfM) + a.a.a.a.eL(19, this.tfN);
      paramInt = i;
      if (this.tcc != null) {
        paramInt = i + a.a.a.b.b.a.f(20, this.tcc);
      }
      i = a.a.a.a.eL(21, this.tfO);
      GMTrace.o(13584444686336L, 101212);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tfx == null) {
        throw new b("Not all required fields were included: SvrPubECDHKey");
      }
      if (this.tfy == null) {
        throw new b("Not all required fields were included: SessionKey");
      }
      if (this.tfz == null) {
        throw new b("Not all required fields were included: AutoAuthKey");
      }
      GMTrace.o(13584444686336L, 101212);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      dr localdr = (dr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 13: 
      default: 
        GMTrace.o(13584444686336L, 101212);
        return -1;
      case 1: 
        localdr.lcP = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new or();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((or)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdr.tfx = ((or)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13584444686336L, 101212);
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
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdr.tfy = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdr.tfz = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 5: 
        localdr.tfA = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdr.tfB = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bme();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bme)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdr.tfC = ((bme)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 8: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpk();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpk)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdr.tfD = ((bpk)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdr.tfE = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13584444686336L, 101212);
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
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdr.tfF = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 11: 
        localdr.tfG = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 12: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdr.tfH = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 14: 
        localdr.tfI = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 15: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azz();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azz)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdr.tfJ = ((azz)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 16: 
        localdr.tfK = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 17: 
        localdr.tfL = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 18: 
        localdr.tfM = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 19: 
        localdr.tfN = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13584444686336L, 101212);
        return 0;
      case 20: 
        localdr.tcc = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13584444686336L, 101212);
        return 0;
      }
      localdr.tfO = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13584444686336L, 101212);
      return 0;
    }
    GMTrace.o(13584444686336L, 101212);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */