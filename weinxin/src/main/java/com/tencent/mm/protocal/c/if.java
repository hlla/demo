package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class if
  extends com.tencent.mm.bd.a
{
  public int lcP;
  public int tkZ;
  public int tla;
  public int tlb;
  public int tlc;
  public LinkedList<avu> tld;
  public String tle;
  public avt tlf;
  public int tlg;
  public int tlh;
  public LinkedList<avu> tli;
  public LinkedList<ig> tlj;
  public LinkedList<ig> tlk;
  public int tll;
  public int tlm;
  
  public if()
  {
    GMTrace.i(13580015501312L, 101179);
    this.tld = new LinkedList();
    this.tli = new LinkedList();
    this.tlj = new LinkedList();
    this.tlk = new LinkedList();
    GMTrace.o(13580015501312L, 101179);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13580149719040L, 101180);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tlf == null) {
        throw new b("Not all required fields were included: AuthKey");
      }
      paramVarArgs.eO(1, this.tkZ);
      paramVarArgs.eO(2, this.lcP);
      paramVarArgs.eO(3, this.tla);
      paramVarArgs.eO(4, this.tlb);
      paramVarArgs.eO(5, this.tlc);
      paramVarArgs.d(6, 8, this.tld);
      if (this.tle != null) {
        paramVarArgs.e(7, this.tle);
      }
      if (this.tlf != null)
      {
        paramVarArgs.eQ(8, this.tlf.aUd());
        this.tlf.a(paramVarArgs);
      }
      paramVarArgs.eO(9, this.tlg);
      paramVarArgs.eO(10, this.tlh);
      paramVarArgs.d(11, 8, this.tli);
      paramVarArgs.d(12, 8, this.tlj);
      paramVarArgs.d(13, 8, this.tlk);
      paramVarArgs.eO(14, this.tll);
      paramVarArgs.eO(15, this.tlm);
      GMTrace.o(13580149719040L, 101180);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tkZ) + 0 + a.a.a.a.eL(2, this.lcP) + a.a.a.a.eL(3, this.tla) + a.a.a.a.eL(4, this.tlb) + a.a.a.a.eL(5, this.tlc) + a.a.a.a.c(6, 8, this.tld);
      paramInt = i;
      if (this.tle != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.tle);
      }
      i = paramInt;
      if (this.tlf != null) {
        i = paramInt + a.a.a.a.eN(8, this.tlf.aUd());
      }
      paramInt = a.a.a.a.eL(9, this.tlg);
      int j = a.a.a.a.eL(10, this.tlh);
      int k = a.a.a.a.c(11, 8, this.tli);
      int m = a.a.a.a.c(12, 8, this.tlj);
      int n = a.a.a.a.c(13, 8, this.tlk);
      int i1 = a.a.a.a.eL(14, this.tll);
      int i2 = a.a.a.a.eL(15, this.tlm);
      GMTrace.o(13580149719040L, 101180);
      return i + paramInt + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tld.clear();
      this.tli.clear();
      this.tlj.clear();
      this.tlk.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tlf == null) {
        throw new b("Not all required fields were included: AuthKey");
      }
      GMTrace.o(13580149719040L, 101180);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      if localif = (if)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13580149719040L, 101180);
        return -1;
      case 1: 
        localif.tkZ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13580149719040L, 101180);
        return 0;
      case 2: 
        localif.lcP = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13580149719040L, 101180);
        return 0;
      case 3: 
        localif.tla = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13580149719040L, 101180);
        return 0;
      case 4: 
        localif.tlb = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13580149719040L, 101180);
        return 0;
      case 5: 
        localif.tlc = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13580149719040L, 101180);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localif.tld.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13580149719040L, 101180);
        return 0;
      case 7: 
        localif.tle = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13580149719040L, 101180);
        return 0;
      case 8: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localif.tlf = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13580149719040L, 101180);
        return 0;
      case 9: 
        localif.tlg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13580149719040L, 101180);
        return 0;
      case 10: 
        localif.tlh = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13580149719040L, 101180);
        return 0;
      case 11: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localif.tli.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13580149719040L, 101180);
        return 0;
      case 12: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ig();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ig)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localif.tlj.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13580149719040L, 101180);
        return 0;
      case 13: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ig();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ig)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localif.tlk.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13580149719040L, 101180);
        return 0;
      case 14: 
        localif.tll = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13580149719040L, 101180);
        return 0;
      }
      localif.tlm = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13580149719040L, 101180);
      return 0;
    }
    GMTrace.o(13580149719040L, 101180);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/if.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */