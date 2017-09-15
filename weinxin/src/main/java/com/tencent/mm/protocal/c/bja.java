package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class bja
  extends ave
{
  public String tFy;
  public avt tLq;
  public int tgi;
  public int uhb;
  public LinkedList<biz> uhc;
  public int uhd;
  public LinkedList<Integer> uhe;
  
  public bja()
  {
    GMTrace.i(3679579013120L, 27415);
    this.uhc = new LinkedList();
    this.uhe = new LinkedList();
    GMTrace.o(3679579013120L, 27415);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3679713230848L, 27416);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tgi);
      paramVarArgs.eO(3, this.uhb);
      paramVarArgs.d(4, 8, this.uhc);
      if (this.tFy != null) {
        paramVarArgs.e(5, this.tFy);
      }
      paramVarArgs.eO(6, this.uhd);
      paramVarArgs.c(7, this.uhe);
      if (this.tLq != null)
      {
        paramVarArgs.eQ(8, this.tLq.aUd());
        this.tLq.a(paramVarArgs);
      }
      GMTrace.o(3679713230848L, 27416);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tgi) + a.a.a.a.eL(3, this.uhb) + a.a.a.a.c(4, 8, this.uhc);
      paramInt = i;
      if (this.tFy != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tFy);
      }
      i = paramInt + a.a.a.a.eL(6, this.uhd) + a.a.a.a.b(7, this.uhe);
      paramInt = i;
      if (this.tLq != null) {
        paramInt = i + a.a.a.a.eN(8, this.tLq.aUd());
      }
      GMTrace.o(3679713230848L, 27416);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uhc.clear();
      this.uhe.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3679713230848L, 27416);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bja localbja = (bja)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3679713230848L, 27416);
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
          localbja.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3679713230848L, 27416);
        return 0;
      case 2: 
        localbja.tgi = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3679713230848L, 27416);
        return 0;
      case 3: 
        localbja.uhb = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3679713230848L, 27416);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new biz();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((biz)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbja.uhc.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3679713230848L, 27416);
        return 0;
      case 5: 
        localbja.tFy = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3679713230848L, 27416);
        return 0;
      case 6: 
        localbja.uhd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3679713230848L, 27416);
        return 0;
      case 7: 
        localbja.uhe = new a.a.a.a.a(((a.a.a.a.a)localObject1).chR().sWU, unknownTagHandler).chO();
        GMTrace.o(3679713230848L, 27416);
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
        for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
        localbja.tLq = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3679713230848L, 27416);
      return 0;
    }
    GMTrace.o(3679713230848L, 27416);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */