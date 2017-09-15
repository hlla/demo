package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bhl
  extends ave
{
  public String jLx;
  public int tfg;
  public int tfj;
  public int the;
  public int tjF;
  public avt tqC;
  public String ufm;
  public int ufn;
  public int ufo;
  
  public bhl()
  {
    GMTrace.i(4039416741888L, 30096);
    GMTrace.o(4039416741888L, 30096);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4039550959616L, 30097);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.jLx != null) {
        paramVarArgs.e(2, this.jLx);
      }
      if (this.tqC != null)
      {
        paramVarArgs.eQ(3, this.tqC.aUd());
        this.tqC.a(paramVarArgs);
      }
      paramVarArgs.eO(4, this.tjF);
      if (this.ufm != null) {
        paramVarArgs.e(5, this.ufm);
      }
      paramVarArgs.eO(6, this.the);
      paramVarArgs.eO(7, this.ufn);
      paramVarArgs.eO(8, this.tfj);
      paramVarArgs.eO(9, this.ufo);
      paramVarArgs.eO(10, this.tfg);
      GMTrace.o(4039550959616L, 30097);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXb != null) {
        i = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      paramInt = i;
      if (this.jLx != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.jLx);
      }
      i = paramInt;
      if (this.tqC != null) {
        i = paramInt + a.a.a.a.eN(3, this.tqC.aUd());
      }
      i += a.a.a.a.eL(4, this.tjF);
      paramInt = i;
      if (this.ufm != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.ufm);
      }
      i = a.a.a.a.eL(6, this.the);
      int j = a.a.a.a.eL(7, this.ufn);
      int k = a.a.a.a.eL(8, this.tfj);
      int m = a.a.a.a.eL(9, this.ufo);
      int n = a.a.a.a.eL(10, this.tfg);
      GMTrace.o(4039550959616L, 30097);
      return paramInt + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      GMTrace.o(4039550959616L, 30097);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bhl localbhl = (bhl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(4039550959616L, 30097);
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
          localbhl.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4039550959616L, 30097);
        return 0;
      case 2: 
        localbhl.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4039550959616L, 30097);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbhl.tqC = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4039550959616L, 30097);
        return 0;
      case 4: 
        localbhl.tjF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4039550959616L, 30097);
        return 0;
      case 5: 
        localbhl.ufm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4039550959616L, 30097);
        return 0;
      case 6: 
        localbhl.the = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4039550959616L, 30097);
        return 0;
      case 7: 
        localbhl.ufn = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4039550959616L, 30097);
        return 0;
      case 8: 
        localbhl.tfj = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4039550959616L, 30097);
        return 0;
      case 9: 
        localbhl.ufo = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4039550959616L, 30097);
        return 0;
      }
      localbhl.tfg = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(4039550959616L, 30097);
      return 0;
    }
    GMTrace.o(4039550959616L, 30097);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bhl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */