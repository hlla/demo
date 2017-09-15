package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class tn
  extends avm
{
  public String SSID;
  public String fDt;
  public String jLx;
  public String mPy;
  public String oog;
  public tj tAa;
  public String tAb;
  public int tAc;
  public LinkedList<hl> tAd;
  public String tAe;
  public mz tAf;
  public avt tAg;
  public int tAh;
  public LinkedList<afb> tAi;
  public String tAj;
  public int taG;
  public String tav;
  public String tzX;
  public String tzY;
  public agp tzZ;
  
  public tn()
  {
    GMTrace.i(3925331673088L, 29246);
    this.tAd = new LinkedList();
    this.tAi = new LinkedList();
    GMTrace.o(3925331673088L, 29246);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3925465890816L, 29247);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tzX != null) {
        paramVarArgs.e(2, this.tzX);
      }
      if (this.tzY != null) {
        paramVarArgs.e(3, this.tzY);
      }
      paramVarArgs.eO(4, this.taG);
      if (this.fDt != null) {
        paramVarArgs.e(5, this.fDt);
      }
      if (this.oog != null) {
        paramVarArgs.e(6, this.oog);
      }
      if (this.tzZ != null)
      {
        paramVarArgs.eQ(7, this.tzZ.aUd());
        this.tzZ.a(paramVarArgs);
      }
      if (this.tAa != null)
      {
        paramVarArgs.eQ(8, this.tAa.aUd());
        this.tAa.a(paramVarArgs);
      }
      if (this.jLx != null) {
        paramVarArgs.e(9, this.jLx);
      }
      if (this.tAb != null) {
        paramVarArgs.e(15, this.tAb);
      }
      paramVarArgs.eO(16, this.tAc);
      paramVarArgs.d(17, 8, this.tAd);
      if (this.tAe != null) {
        paramVarArgs.e(18, this.tAe);
      }
      if (this.SSID != null) {
        paramVarArgs.e(20, this.SSID);
      }
      if (this.tav != null) {
        paramVarArgs.e(21, this.tav);
      }
      if (this.tAf != null)
      {
        paramVarArgs.eQ(22, this.tAf.aUd());
        this.tAf.a(paramVarArgs);
      }
      if (this.tAg != null)
      {
        paramVarArgs.eQ(23, this.tAg.aUd());
        this.tAg.a(paramVarArgs);
      }
      paramVarArgs.eO(24, this.tAh);
      paramVarArgs.d(25, 8, this.tAi);
      if (this.mPy != null) {
        paramVarArgs.e(26, this.mPy);
      }
      if (this.tAj != null) {
        paramVarArgs.e(27, this.tAj);
      }
      GMTrace.o(3925465890816L, 29247);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXs != null) {
        i = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      paramInt = i;
      if (this.tzX != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tzX);
      }
      i = paramInt;
      if (this.tzY != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tzY);
      }
      i += a.a.a.a.eL(4, this.taG);
      paramInt = i;
      if (this.fDt != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.fDt);
      }
      i = paramInt;
      if (this.oog != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.oog);
      }
      paramInt = i;
      if (this.tzZ != null) {
        paramInt = i + a.a.a.a.eN(7, this.tzZ.aUd());
      }
      i = paramInt;
      if (this.tAa != null) {
        i = paramInt + a.a.a.a.eN(8, this.tAa.aUd());
      }
      paramInt = i;
      if (this.jLx != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.jLx);
      }
      i = paramInt;
      if (this.tAb != null) {
        i = paramInt + a.a.a.b.b.a.f(15, this.tAb);
      }
      i = i + a.a.a.a.eL(16, this.tAc) + a.a.a.a.c(17, 8, this.tAd);
      paramInt = i;
      if (this.tAe != null) {
        paramInt = i + a.a.a.b.b.a.f(18, this.tAe);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + a.a.a.b.b.a.f(20, this.SSID);
      }
      paramInt = i;
      if (this.tav != null) {
        paramInt = i + a.a.a.b.b.a.f(21, this.tav);
      }
      i = paramInt;
      if (this.tAf != null) {
        i = paramInt + a.a.a.a.eN(22, this.tAf.aUd());
      }
      paramInt = i;
      if (this.tAg != null) {
        paramInt = i + a.a.a.a.eN(23, this.tAg.aUd());
      }
      i = paramInt + a.a.a.a.eL(24, this.tAh) + a.a.a.a.c(25, 8, this.tAi);
      paramInt = i;
      if (this.mPy != null) {
        paramInt = i + a.a.a.b.b.a.f(26, this.mPy);
      }
      i = paramInt;
      if (this.tAj != null) {
        i = paramInt + a.a.a.b.b.a.f(27, this.tAj);
      }
      GMTrace.o(3925465890816L, 29247);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tAd.clear();
      this.tAi.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3925465890816L, 29247);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      tn localtn = (tn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 19: 
      default: 
        GMTrace.o(3925465890816L, 29247);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localtn.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 2: 
        localtn.tzX = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 3: 
        localtn.tzY = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 4: 
        localtn.taG = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 5: 
        localtn.fDt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 6: 
        localtn.oog = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new agp();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((agp)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localtn.tzZ = ((agp)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 8: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tj();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((tj)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localtn.tAa = ((tj)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 9: 
        localtn.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 15: 
        localtn.tAb = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 16: 
        localtn.tAc = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 17: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localtn.tAd.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 18: 
        localtn.tAe = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 20: 
        localtn.SSID = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 21: 
        localtn.tav = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 22: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mz();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mz)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localtn.tAf = ((mz)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 23: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localtn.tAg = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 24: 
        localtn.tAh = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 25: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afb();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afb)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localtn.tAi.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3925465890816L, 29247);
        return 0;
      case 26: 
        localtn.mPy = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3925465890816L, 29247);
        return 0;
      }
      localtn.tAj = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3925465890816L, 29247);
      return 0;
    }
    GMTrace.o(3925465890816L, 29247);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/tn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */