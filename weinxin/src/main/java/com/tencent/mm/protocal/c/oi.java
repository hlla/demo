package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class oi
  extends ave
{
  public String jLx;
  public int jMq;
  public String mrA;
  public long tdE;
  public int ten;
  public int tfd;
  public int tfe;
  public int tff;
  public String tso;
  public String tsp;
  public int tsq;
  public int tsr;
  
  public oi()
  {
    GMTrace.i(3633005461504L, 27068);
    GMTrace.o(3633005461504L, 27068);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3633139679232L, 27069);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.mrA != null) {
        paramVarArgs.e(2, this.mrA);
      }
      paramVarArgs.eO(3, this.ten);
      if (this.tso != null) {
        paramVarArgs.e(4, this.tso);
      }
      if (this.jLx != null) {
        paramVarArgs.e(5, this.jLx);
      }
      paramVarArgs.eO(6, this.tfd);
      paramVarArgs.eO(7, this.tfe);
      paramVarArgs.eO(8, this.tff);
      if (this.tsp != null) {
        paramVarArgs.e(9, this.tsp);
      }
      paramVarArgs.eO(10, this.tsq);
      paramVarArgs.eO(11, this.jMq);
      paramVarArgs.eO(12, this.tsr);
      paramVarArgs.O(13, this.tdE);
      GMTrace.o(3633139679232L, 27069);
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
      if (this.mrA != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.mrA);
      }
      i += a.a.a.a.eL(3, this.ten);
      paramInt = i;
      if (this.tso != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tso);
      }
      i = paramInt;
      if (this.jLx != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.jLx);
      }
      i = i + a.a.a.a.eL(6, this.tfd) + a.a.a.a.eL(7, this.tfe) + a.a.a.a.eL(8, this.tff);
      paramInt = i;
      if (this.tsp != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.tsp);
      }
      i = a.a.a.a.eL(10, this.tsq);
      int j = a.a.a.a.eL(11, this.jMq);
      int k = a.a.a.a.eL(12, this.tsr);
      int m = a.a.a.a.N(13, this.tdE);
      GMTrace.o(3633139679232L, 27069);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3633139679232L, 27069);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      oi localoi = (oi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3633139679232L, 27069);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localoi.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3633139679232L, 27069);
        return 0;
      case 2: 
        localoi.mrA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3633139679232L, 27069);
        return 0;
      case 3: 
        localoi.ten = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3633139679232L, 27069);
        return 0;
      case 4: 
        localoi.tso = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3633139679232L, 27069);
        return 0;
      case 5: 
        localoi.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3633139679232L, 27069);
        return 0;
      case 6: 
        localoi.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3633139679232L, 27069);
        return 0;
      case 7: 
        localoi.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3633139679232L, 27069);
        return 0;
      case 8: 
        localoi.tff = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3633139679232L, 27069);
        return 0;
      case 9: 
        localoi.tsp = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3633139679232L, 27069);
        return 0;
      case 10: 
        localoi.tsq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3633139679232L, 27069);
        return 0;
      case 11: 
        localoi.jMq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3633139679232L, 27069);
        return 0;
      case 12: 
        localoi.tsr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3633139679232L, 27069);
        return 0;
      }
      localoi.tdE = ((a.a.a.a.a)localObject1).xky.mM();
      GMTrace.o(3633139679232L, 27069);
      return 0;
    }
    GMTrace.o(3633139679232L, 27069);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/oi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */