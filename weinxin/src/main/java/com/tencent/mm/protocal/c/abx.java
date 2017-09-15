package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class abx
  extends avm
{
  public int tFO;
  public String tFP;
  public int tFQ;
  public String tFR;
  public int tFS;
  public LinkedList<avu> tFT;
  public String tFU;
  public int tFV;
  public String tFW;
  public int tFX;
  public avt tFY;
  
  public abx()
  {
    GMTrace.i(3918620786688L, 29196);
    this.tFT = new LinkedList();
    GMTrace.o(3918620786688L, 29196);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3918755004416L, 29197);
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
      paramVarArgs.eO(2, this.tFO);
      if (this.tFP != null) {
        paramVarArgs.e(3, this.tFP);
      }
      paramVarArgs.eO(4, this.tFQ);
      if (this.tFR != null) {
        paramVarArgs.e(5, this.tFR);
      }
      paramVarArgs.eO(6, this.tFS);
      paramVarArgs.d(7, 8, this.tFT);
      if (this.tFU != null) {
        paramVarArgs.e(8, this.tFU);
      }
      paramVarArgs.eO(9, this.tFV);
      if (this.tFW != null) {
        paramVarArgs.e(10, this.tFW);
      }
      paramVarArgs.eO(11, this.tFX);
      if (this.tFY != null)
      {
        paramVarArgs.eQ(12, this.tFY.aUd());
        this.tFY.a(paramVarArgs);
      }
      GMTrace.o(3918755004416L, 29197);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tFO);
      paramInt = i;
      if (this.tFP != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.tFP);
      }
      i = paramInt + a.a.a.a.eL(4, this.tFQ);
      paramInt = i;
      if (this.tFR != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tFR);
      }
      i = paramInt + a.a.a.a.eL(6, this.tFS) + a.a.a.a.c(7, 8, this.tFT);
      paramInt = i;
      if (this.tFU != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.tFU);
      }
      i = paramInt + a.a.a.a.eL(9, this.tFV);
      paramInt = i;
      if (this.tFW != null) {
        paramInt = i + a.a.a.b.b.a.f(10, this.tFW);
      }
      i = paramInt + a.a.a.a.eL(11, this.tFX);
      paramInt = i;
      if (this.tFY != null) {
        paramInt = i + a.a.a.a.eN(12, this.tFY.aUd());
      }
      GMTrace.o(3918755004416L, 29197);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tFT.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3918755004416L, 29197);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      abx localabx = (abx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3918755004416L, 29197);
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
          localabx.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3918755004416L, 29197);
        return 0;
      case 2: 
        localabx.tFO = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3918755004416L, 29197);
        return 0;
      case 3: 
        localabx.tFP = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3918755004416L, 29197);
        return 0;
      case 4: 
        localabx.tFQ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3918755004416L, 29197);
        return 0;
      case 5: 
        localabx.tFR = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3918755004416L, 29197);
        return 0;
      case 6: 
        localabx.tFS = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3918755004416L, 29197);
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
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localabx.tFT.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3918755004416L, 29197);
        return 0;
      case 8: 
        localabx.tFU = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3918755004416L, 29197);
        return 0;
      case 9: 
        localabx.tFV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3918755004416L, 29197);
        return 0;
      case 10: 
        localabx.tFW = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3918755004416L, 29197);
        return 0;
      case 11: 
        localabx.tFX = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3918755004416L, 29197);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localabx.tFY = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3918755004416L, 29197);
      return 0;
    }
    GMTrace.o(3918755004416L, 29197);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/abx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */