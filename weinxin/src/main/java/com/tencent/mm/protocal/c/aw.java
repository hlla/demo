package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aw
  extends com.tencent.mm.bd.a
{
  public String mqG;
  public String mrs;
  public String mtr;
  public String tcA;
  public String tcB;
  public bqt tcC;
  public String tcD;
  public String tcw;
  public String tcx;
  public String tcy;
  public String tcz;
  
  public aw()
  {
    GMTrace.i(3982508425216L, 29672);
    GMTrace.o(3982508425216L, 29672);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3982642642944L, 29673);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.mqG != null) {
        paramVarArgs.e(1, this.mqG);
      }
      if (this.tcw != null) {
        paramVarArgs.e(2, this.tcw);
      }
      if (this.tcx != null) {
        paramVarArgs.e(3, this.tcx);
      }
      if (this.mrs != null) {
        paramVarArgs.e(4, this.mrs);
      }
      if (this.mtr != null) {
        paramVarArgs.e(5, this.mtr);
      }
      if (this.tcy != null) {
        paramVarArgs.e(6, this.tcy);
      }
      if (this.tcz != null) {
        paramVarArgs.e(7, this.tcz);
      }
      if (this.tcA != null) {
        paramVarArgs.e(8, this.tcA);
      }
      if (this.tcB != null) {
        paramVarArgs.e(9, this.tcB);
      }
      if (this.tcC != null)
      {
        paramVarArgs.eQ(10, this.tcC.aUd());
        this.tcC.a(paramVarArgs);
      }
      if (this.tcD != null) {
        paramVarArgs.e(11, this.tcD);
      }
      GMTrace.o(3982642642944L, 29673);
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
      if (this.tcw != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tcw);
      }
      i = paramInt;
      if (this.tcx != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tcx);
      }
      paramInt = i;
      if (this.mrs != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.mrs);
      }
      i = paramInt;
      if (this.mtr != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.mtr);
      }
      paramInt = i;
      if (this.tcy != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tcy);
      }
      i = paramInt;
      if (this.tcz != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.tcz);
      }
      paramInt = i;
      if (this.tcA != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.tcA);
      }
      i = paramInt;
      if (this.tcB != null) {
        i = paramInt + a.a.a.b.b.a.f(9, this.tcB);
      }
      paramInt = i;
      if (this.tcC != null) {
        paramInt = i + a.a.a.a.eN(10, this.tcC.aUd());
      }
      i = paramInt;
      if (this.tcD != null) {
        i = paramInt + a.a.a.b.b.a.f(11, this.tcD);
      }
      GMTrace.o(3982642642944L, 29673);
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
      GMTrace.o(3982642642944L, 29673);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aw localaw = (aw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3982642642944L, 29673);
        return -1;
      case 1: 
        localaw.mqG = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3982642642944L, 29673);
        return 0;
      case 2: 
        localaw.tcw = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3982642642944L, 29673);
        return 0;
      case 3: 
        localaw.tcx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3982642642944L, 29673);
        return 0;
      case 4: 
        localaw.mrs = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3982642642944L, 29673);
        return 0;
      case 5: 
        localaw.mtr = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3982642642944L, 29673);
        return 0;
      case 6: 
        localaw.tcy = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3982642642944L, 29673);
        return 0;
      case 7: 
        localaw.tcz = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3982642642944L, 29673);
        return 0;
      case 8: 
        localaw.tcA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3982642642944L, 29673);
        return 0;
      case 9: 
        localaw.tcB = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3982642642944L, 29673);
        return 0;
      case 10: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bqt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaw.tcC = ((bqt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3982642642944L, 29673);
        return 0;
      }
      localaw.tcD = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3982642642944L, 29673);
      return 0;
    }
    GMTrace.o(3982642642944L, 29673);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */