package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bfd
  extends com.tencent.mm.bd.a
{
  public int state;
  public String tpJ;
  public LinkedList<bfc> uec;
  public int ued;
  public int uee;
  public avi uef;
  public int ueg;
  public LinkedList<bfb> ueh;
  
  public bfd()
  {
    GMTrace.i(15352092164096L, 114382);
    this.uec = new LinkedList();
    this.ueh = new LinkedList();
    GMTrace.o(15352092164096L, 114382);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15352226381824L, 114383);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tpJ == null) {
        throw new b("Not all required fields were included: patchid");
      }
      if (this.tpJ != null) {
        paramVarArgs.e(1, this.tpJ);
      }
      paramVarArgs.eO(2, this.state);
      paramVarArgs.d(3, 8, this.uec);
      paramVarArgs.eO(4, this.ued);
      paramVarArgs.eO(5, this.uee);
      if (this.uef != null)
      {
        paramVarArgs.eQ(6, this.uef.aUd());
        this.uef.a(paramVarArgs);
      }
      paramVarArgs.eO(7, this.ueg);
      paramVarArgs.d(8, 8, this.ueh);
      GMTrace.o(15352226381824L, 114383);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tpJ != null) {
        paramInt = a.a.a.b.b.a.f(1, this.tpJ) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.state) + a.a.a.a.c(3, 8, this.uec) + a.a.a.a.eL(4, this.ued) + a.a.a.a.eL(5, this.uee);
      paramInt = i;
      if (this.uef != null) {
        paramInt = i + a.a.a.a.eN(6, this.uef.aUd());
      }
      i = a.a.a.a.eL(7, this.ueg);
      int j = a.a.a.a.c(8, 8, this.ueh);
      GMTrace.o(15352226381824L, 114383);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uec.clear();
      this.ueh.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tpJ == null) {
        throw new b("Not all required fields were included: patchid");
      }
      GMTrace.o(15352226381824L, 114383);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bfd localbfd = (bfd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(15352226381824L, 114383);
        return -1;
      case 1: 
        localbfd.tpJ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(15352226381824L, 114383);
        return 0;
      case 2: 
        localbfd.state = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(15352226381824L, 114383);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bfc();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bfc)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbfd.uec.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(15352226381824L, 114383);
        return 0;
      case 4: 
        localbfd.ued = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(15352226381824L, 114383);
        return 0;
      case 5: 
        localbfd.uee = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(15352226381824L, 114383);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avi();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avi)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbfd.uef = ((avi)localObject1);
          paramInt += 1;
        }
        GMTrace.o(15352226381824L, 114383);
        return 0;
      case 7: 
        localbfd.ueg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(15352226381824L, 114383);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bfb();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bfb)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localbfd.ueh.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(15352226381824L, 114383);
      return 0;
    }
    GMTrace.o(15352226381824L, 114383);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */