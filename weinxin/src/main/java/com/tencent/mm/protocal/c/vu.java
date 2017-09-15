package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class vu
  extends avm
{
  public if tnA;
  public int tnB;
  public ie tnC;
  public ie tnD;
  public if tnv;
  public if tnw;
  public if tnx;
  public avt tny;
  public avt tnz;
  
  public vu()
  {
    GMTrace.i(3877147508736L, 28887);
    GMTrace.o(3877147508736L, 28887);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3877281726464L, 28888);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tnv == null) {
        throw new b("Not all required fields were included: DnsInfo");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tnv != null)
      {
        paramVarArgs.eQ(2, this.tnv.aUd());
        this.tnv.a(paramVarArgs);
      }
      if (this.tnw != null)
      {
        paramVarArgs.eQ(3, this.tnw.aUd());
        this.tnw.a(paramVarArgs);
      }
      if (this.tnx != null)
      {
        paramVarArgs.eQ(4, this.tnx.aUd());
        this.tnx.a(paramVarArgs);
      }
      if (this.tny != null)
      {
        paramVarArgs.eQ(5, this.tny.aUd());
        this.tny.a(paramVarArgs);
      }
      if (this.tnz != null)
      {
        paramVarArgs.eQ(6, this.tnz.aUd());
        this.tnz.a(paramVarArgs);
      }
      if (this.tnA != null)
      {
        paramVarArgs.eQ(7, this.tnA.aUd());
        this.tnA.a(paramVarArgs);
      }
      paramVarArgs.eO(8, this.tnB);
      if (this.tnC != null)
      {
        paramVarArgs.eQ(9, this.tnC.aUd());
        this.tnC.a(paramVarArgs);
      }
      if (this.tnD != null)
      {
        paramVarArgs.eQ(10, this.tnD.aUd());
        this.tnD.a(paramVarArgs);
      }
      GMTrace.o(3877281726464L, 28888);
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
      if (this.tnv != null) {
        paramInt = i + a.a.a.a.eN(2, this.tnv.aUd());
      }
      i = paramInt;
      if (this.tnw != null) {
        i = paramInt + a.a.a.a.eN(3, this.tnw.aUd());
      }
      paramInt = i;
      if (this.tnx != null) {
        paramInt = i + a.a.a.a.eN(4, this.tnx.aUd());
      }
      i = paramInt;
      if (this.tny != null) {
        i = paramInt + a.a.a.a.eN(5, this.tny.aUd());
      }
      paramInt = i;
      if (this.tnz != null) {
        paramInt = i + a.a.a.a.eN(6, this.tnz.aUd());
      }
      i = paramInt;
      if (this.tnA != null) {
        i = paramInt + a.a.a.a.eN(7, this.tnA.aUd());
      }
      i += a.a.a.a.eL(8, this.tnB);
      paramInt = i;
      if (this.tnC != null) {
        paramInt = i + a.a.a.a.eN(9, this.tnC.aUd());
      }
      i = paramInt;
      if (this.tnD != null) {
        i = paramInt + a.a.a.a.eN(10, this.tnD.aUd());
      }
      GMTrace.o(3877281726464L, 28888);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tnv == null) {
        throw new b("Not all required fields were included: DnsInfo");
      }
      GMTrace.o(3877281726464L, 28888);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      vu localvu = (vu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3877281726464L, 28888);
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
          localvu.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3877281726464L, 28888);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new if();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((if)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localvu.tnv = ((if)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3877281726464L, 28888);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new if();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((if)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localvu.tnw = ((if)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3877281726464L, 28888);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new if();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((if)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localvu.tnx = ((if)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3877281726464L, 28888);
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
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localvu.tny = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3877281726464L, 28888);
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
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localvu.tnz = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3877281726464L, 28888);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new if();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((if)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localvu.tnA = ((if)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3877281726464L, 28888);
        return 0;
      case 8: 
        localvu.tnB = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3877281726464L, 28888);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ie();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ie)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localvu.tnC = ((ie)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3877281726464L, 28888);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ie();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ie)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localvu.tnD = ((ie)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3877281726464L, 28888);
      return 0;
    }
    GMTrace.o(3877281726464L, 28888);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/vu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */