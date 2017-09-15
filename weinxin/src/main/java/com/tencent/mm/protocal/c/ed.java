package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ed
  extends ave
{
  public long jLL;
  public int tcg;
  public int tgl;
  public LinkedList<md> tgm;
  public String tgn;
  public String tgo;
  public String tgp;
  public String tgq;
  
  public ed()
  {
    GMTrace.i(3972307877888L, 29596);
    this.tgm = new LinkedList();
    GMTrace.o(3972307877888L, 29596);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3972442095616L, 29597);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tgl);
      paramVarArgs.d(3, 8, this.tgm);
      if (this.tgn != null) {
        paramVarArgs.e(4, this.tgn);
      }
      if (this.tgo != null) {
        paramVarArgs.e(5, this.tgo);
      }
      paramVarArgs.eO(6, this.tcg);
      paramVarArgs.O(7, this.jLL);
      if (this.tgp != null) {
        paramVarArgs.e(8, this.tgp);
      }
      if (this.tgq != null) {
        paramVarArgs.e(9, this.tgq);
      }
      GMTrace.o(3972442095616L, 29597);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tgl) + a.a.a.a.c(3, 8, this.tgm);
      paramInt = i;
      if (this.tgn != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tgn);
      }
      i = paramInt;
      if (this.tgo != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tgo);
      }
      i = i + a.a.a.a.eL(6, this.tcg) + a.a.a.a.N(7, this.jLL);
      paramInt = i;
      if (this.tgp != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.tgp);
      }
      i = paramInt;
      if (this.tgq != null) {
        i = paramInt + a.a.a.b.b.a.f(9, this.tgq);
      }
      GMTrace.o(3972442095616L, 29597);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tgm.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3972442095616L, 29597);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ed localed = (ed)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3972442095616L, 29597);
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
          localed.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3972442095616L, 29597);
        return 0;
      case 2: 
        localed.tgl = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3972442095616L, 29597);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new md();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((md)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localed.tgm.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3972442095616L, 29597);
        return 0;
      case 4: 
        localed.tgn = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3972442095616L, 29597);
        return 0;
      case 5: 
        localed.tgo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3972442095616L, 29597);
        return 0;
      case 6: 
        localed.tcg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3972442095616L, 29597);
        return 0;
      case 7: 
        localed.jLL = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(3972442095616L, 29597);
        return 0;
      case 8: 
        localed.tgp = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3972442095616L, 29597);
        return 0;
      }
      localed.tgq = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3972442095616L, 29597);
      return 0;
    }
    GMTrace.o(3972442095616L, 29597);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */