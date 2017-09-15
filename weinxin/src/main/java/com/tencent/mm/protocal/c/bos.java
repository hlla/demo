package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bos
  extends com.tencent.mm.bd.a
{
  public String lda;
  public int tMy;
  public aiw tMz;
  public int tcg;
  public long tks;
  public String tzT;
  public LinkedList<String> ulC;
  public LinkedList<lz> ulD;
  
  public bos()
  {
    GMTrace.i(3732192362496L, 27807);
    this.ulC = new LinkedList();
    this.ulD = new LinkedList();
    GMTrace.o(3732192362496L, 27807);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3732326580224L, 27808);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 1, this.ulC);
      paramVarArgs.eO(2, this.tMy);
      if (this.lda != null) {
        paramVarArgs.e(3, this.lda);
      }
      paramVarArgs.eO(4, this.tcg);
      paramVarArgs.O(5, this.tks);
      if (this.tzT != null) {
        paramVarArgs.e(6, this.tzT);
      }
      if (this.tMz != null)
      {
        paramVarArgs.eQ(7, this.tMz.aUd());
        this.tMz.a(paramVarArgs);
      }
      paramVarArgs.d(8, 8, this.ulD);
      GMTrace.o(3732326580224L, 27808);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.c(1, 1, this.ulC) + 0 + a.a.a.a.eL(2, this.tMy);
      paramInt = i;
      if (this.lda != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.lda);
      }
      i = paramInt + a.a.a.a.eL(4, this.tcg) + a.a.a.a.N(5, this.tks);
      paramInt = i;
      if (this.tzT != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tzT);
      }
      i = paramInt;
      if (this.tMz != null) {
        i = paramInt + a.a.a.a.eN(7, this.tMz.aUd());
      }
      paramInt = a.a.a.a.c(8, 8, this.ulD);
      GMTrace.o(3732326580224L, 27808);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ulC.clear();
      this.ulD.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3732326580224L, 27808);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bos localbos = (bos)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3732326580224L, 27808);
        return -1;
      case 1: 
        localbos.ulC.add(((a.a.a.a.a)localObject1).xky.readString());
        GMTrace.o(3732326580224L, 27808);
        return 0;
      case 2: 
        localbos.tMy = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3732326580224L, 27808);
        return 0;
      case 3: 
        localbos.lda = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3732326580224L, 27808);
        return 0;
      case 4: 
        localbos.tcg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3732326580224L, 27808);
        return 0;
      case 5: 
        localbos.tks = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(3732326580224L, 27808);
        return 0;
      case 6: 
        localbos.tzT = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3732326580224L, 27808);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aiw();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aiw)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbos.tMz = ((aiw)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3732326580224L, 27808);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new lz();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((lz)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localbos.ulD.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(3732326580224L, 27808);
      return 0;
    }
    GMTrace.o(3732326580224L, 27808);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */