package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bfn
  extends ave
{
  public String hSD;
  public int scene;
  public agg ueq;
  public LinkedList<ch> uer;
  
  public bfn()
  {
    GMTrace.i(3813930958848L, 28416);
    this.uer = new LinkedList();
    GMTrace.o(3813930958848L, 28416);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3814065176576L, 28417);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.hSD != null) {
        paramVarArgs.e(2, this.hSD);
      }
      paramVarArgs.eO(3, this.scene);
      if (this.ueq != null)
      {
        paramVarArgs.eQ(4, this.ueq.aUd());
        this.ueq.a(paramVarArgs);
      }
      paramVarArgs.d(5, 8, this.uer);
      GMTrace.o(3814065176576L, 28417);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt;
      if (this.hSD != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.hSD);
      }
      i += a.a.a.a.eL(3, this.scene);
      paramInt = i;
      if (this.ueq != null) {
        paramInt = i + a.a.a.a.eN(4, this.ueq.aUd());
      }
      i = a.a.a.a.c(5, 8, this.uer);
      GMTrace.o(3814065176576L, 28417);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uer.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3814065176576L, 28417);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bfn localbfn = (bfn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3814065176576L, 28417);
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
          localbfn.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3814065176576L, 28417);
        return 0;
      case 2: 
        localbfn.hSD = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3814065176576L, 28417);
        return 0;
      case 3: 
        localbfn.scene = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3814065176576L, 28417);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new agg();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((agg)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbfn.ueq = ((agg)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3814065176576L, 28417);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ch();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ch)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
        localbfn.uer.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(3814065176576L, 28417);
      return 0;
    }
    GMTrace.o(3814065176576L, 28417);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */