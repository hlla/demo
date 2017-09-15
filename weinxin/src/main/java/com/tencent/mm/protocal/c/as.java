package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class as
  extends com.tencent.mm.bd.a
{
  public int jMq;
  public String mrm;
  public int tcg;
  public String tch;
  public String tci;
  public String tcj;
  public aq tck;
  public String tcl;
  public cl tcm;
  public ct tcn;
  public cs tco;
  public cs tcp;
  
  public as()
  {
    GMTrace.i(3904930578432L, 29094);
    GMTrace.o(3904930578432L, 29094);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3905064796160L, 29095);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.jMq);
      if (this.mrm != null) {
        paramVarArgs.e(2, this.mrm);
      }
      paramVarArgs.eO(3, this.tcg);
      if (this.tch != null) {
        paramVarArgs.e(4, this.tch);
      }
      if (this.tci != null) {
        paramVarArgs.e(5, this.tci);
      }
      if (this.tcj != null) {
        paramVarArgs.e(6, this.tcj);
      }
      if (this.tck != null)
      {
        paramVarArgs.eQ(7, this.tck.aUd());
        this.tck.a(paramVarArgs);
      }
      if (this.tcl != null) {
        paramVarArgs.e(8, this.tcl);
      }
      if (this.tcm != null)
      {
        paramVarArgs.eQ(9, this.tcm.aUd());
        this.tcm.a(paramVarArgs);
      }
      if (this.tcn != null)
      {
        paramVarArgs.eQ(10, this.tcn.aUd());
        this.tcn.a(paramVarArgs);
      }
      if (this.tco != null)
      {
        paramVarArgs.eQ(11, this.tco.aUd());
        this.tco.a(paramVarArgs);
      }
      if (this.tcp != null)
      {
        paramVarArgs.eQ(12, this.tcp.aUd());
        this.tcp.a(paramVarArgs);
      }
      GMTrace.o(3905064796160L, 29095);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.jMq) + 0;
      paramInt = i;
      if (this.mrm != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.mrm);
      }
      i = paramInt + a.a.a.a.eL(3, this.tcg);
      paramInt = i;
      if (this.tch != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tch);
      }
      i = paramInt;
      if (this.tci != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tci);
      }
      paramInt = i;
      if (this.tcj != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tcj);
      }
      i = paramInt;
      if (this.tck != null) {
        i = paramInt + a.a.a.a.eN(7, this.tck.aUd());
      }
      paramInt = i;
      if (this.tcl != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.tcl);
      }
      i = paramInt;
      if (this.tcm != null) {
        i = paramInt + a.a.a.a.eN(9, this.tcm.aUd());
      }
      paramInt = i;
      if (this.tcn != null) {
        paramInt = i + a.a.a.a.eN(10, this.tcn.aUd());
      }
      i = paramInt;
      if (this.tco != null) {
        i = paramInt + a.a.a.a.eN(11, this.tco.aUd());
      }
      paramInt = i;
      if (this.tcp != null) {
        paramInt = i + a.a.a.a.eN(12, this.tcp.aUd());
      }
      GMTrace.o(3905064796160L, 29095);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3905064796160L, 29095);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      as localas = (as)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3905064796160L, 29095);
        return -1;
      case 1: 
        localas.jMq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3905064796160L, 29095);
        return 0;
      case 2: 
        localas.mrm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3905064796160L, 29095);
        return 0;
      case 3: 
        localas.tcg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3905064796160L, 29095);
        return 0;
      case 4: 
        localas.tch = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3905064796160L, 29095);
        return 0;
      case 5: 
        localas.tci = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3905064796160L, 29095);
        return 0;
      case 6: 
        localas.tcj = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3905064796160L, 29095);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aq();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aq)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localas.tck = ((aq)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3905064796160L, 29095);
        return 0;
      case 8: 
        localas.tcl = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3905064796160L, 29095);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localas.tcm = ((cl)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3905064796160L, 29095);
        return 0;
      case 10: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ct();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ct)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localas.tcn = ((ct)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3905064796160L, 29095);
        return 0;
      case 11: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cs();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cs)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localas.tco = ((cs)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3905064796160L, 29095);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cs();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cs)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localas.tcp = ((cs)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3905064796160L, 29095);
      return 0;
    }
    GMTrace.o(3905064796160L, 29095);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */