package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class wx
  extends com.tencent.mm.bd.a
  implements bad
{
  public int tBV;
  public int tBW;
  public int tBX;
  public LinkedList<bdo> tBY;
  public LinkedList<bdo> tBZ;
  public LinkedList<bdo> tCa;
  public int tgr;
  public int tqe;
  public int tqf;
  public int tqg;
  public LinkedList<bdo> tqh;
  public LinkedList<bdo> tqi;
  public LinkedList<bdo> tqj;
  public int tqk;
  public int tql;
  public int tqm;
  public aew tqn;
  
  public wx()
  {
    GMTrace.i(13095757938688L, 97571);
    this.tqh = new LinkedList();
    this.tqi = new LinkedList();
    this.tqj = new LinkedList();
    this.tBY = new LinkedList();
    this.tBZ = new LinkedList();
    this.tCa = new LinkedList();
    GMTrace.o(13095757938688L, 97571);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13096026374144L, 97573);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tgr);
      paramVarArgs.eO(2, this.tqe);
      paramVarArgs.eO(3, this.tqf);
      paramVarArgs.eO(4, this.tqg);
      paramVarArgs.d(5, 8, this.tqh);
      paramVarArgs.d(6, 8, this.tqi);
      paramVarArgs.d(7, 8, this.tqj);
      paramVarArgs.eO(8, this.tqk);
      paramVarArgs.eO(9, this.tql);
      paramVarArgs.eO(10, this.tqm);
      paramVarArgs.eO(11, this.tBV);
      paramVarArgs.eO(12, this.tBW);
      paramVarArgs.eO(13, this.tBX);
      paramVarArgs.d(14, 8, this.tBY);
      paramVarArgs.d(15, 8, this.tBZ);
      paramVarArgs.d(16, 8, this.tCa);
      if (this.tqn != null)
      {
        paramVarArgs.eQ(17, this.tqn.aUd());
        this.tqn.a(paramVarArgs);
      }
      GMTrace.o(13096026374144L, 97573);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tgr) + 0 + a.a.a.a.eL(2, this.tqe) + a.a.a.a.eL(3, this.tqf) + a.a.a.a.eL(4, this.tqg) + a.a.a.a.c(5, 8, this.tqh) + a.a.a.a.c(6, 8, this.tqi) + a.a.a.a.c(7, 8, this.tqj) + a.a.a.a.eL(8, this.tqk) + a.a.a.a.eL(9, this.tql) + a.a.a.a.eL(10, this.tqm) + a.a.a.a.eL(11, this.tBV) + a.a.a.a.eL(12, this.tBW) + a.a.a.a.eL(13, this.tBX) + a.a.a.a.c(14, 8, this.tBY) + a.a.a.a.c(15, 8, this.tBZ) + a.a.a.a.c(16, 8, this.tCa);
      paramInt = i;
      if (this.tqn != null) {
        paramInt = i + a.a.a.a.eN(17, this.tqn.aUd());
      }
      GMTrace.o(13096026374144L, 97573);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tqh.clear();
      this.tqi.clear();
      this.tqj.clear();
      this.tBY.clear();
      this.tBZ.clear();
      this.tCa.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13096026374144L, 97573);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      wx localwx = (wx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13096026374144L, 97573);
        return -1;
      case 1: 
        localwx.tgr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 2: 
        localwx.tqe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 3: 
        localwx.tqf = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 4: 
        localwx.tqg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdo();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdo)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localwx.tqh.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdo();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdo)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localwx.tqi.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdo();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdo)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localwx.tqj.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 8: 
        localwx.tqk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 9: 
        localwx.tql = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 10: 
        localwx.tqm = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 11: 
        localwx.tBV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 12: 
        localwx.tBW = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 13: 
        localwx.tBX = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 14: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdo();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdo)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localwx.tBY.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 15: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdo();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdo)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localwx.tBZ.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13096026374144L, 97573);
        return 0;
      case 16: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdo();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdo)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localwx.tCa.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13096026374144L, 97573);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aew();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aew)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localwx.tqn = ((aew)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13096026374144L, 97573);
      return 0;
    }
    GMTrace.o(13096026374144L, 97573);
    return -1;
  }
  
  public final int getRet()
  {
    GMTrace.i(13095892156416L, 97572);
    int i = this.tgr;
    GMTrace.o(13095892156416L, 97572);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/wx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */