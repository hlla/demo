package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bdh
  extends ave
{
  public String mut;
  public String muu;
  public String teo;
  public int ucV;
  public int ucW;
  public LinkedList<bdj> ucX;
  public bdg ucY;
  public int ucZ;
  public LinkedList<bdg> uda;
  
  public bdh()
  {
    GMTrace.i(3936337526784L, 29328);
    this.ucX = new LinkedList();
    this.uda = new LinkedList();
    GMTrace.o(3936337526784L, 29328);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3936471744512L, 29329);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.ucV);
      if (this.muu != null) {
        paramVarArgs.e(3, this.muu);
      }
      if (this.mut != null) {
        paramVarArgs.e(4, this.mut);
      }
      if (this.teo != null) {
        paramVarArgs.e(5, this.teo);
      }
      paramVarArgs.eO(6, this.ucW);
      paramVarArgs.d(7, 8, this.ucX);
      if (this.ucY != null)
      {
        paramVarArgs.eQ(8, this.ucY.aUd());
        this.ucY.a(paramVarArgs);
      }
      paramVarArgs.eO(9, this.ucZ);
      paramVarArgs.d(10, 8, this.uda);
      GMTrace.o(3936471744512L, 29329);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.ucV);
      paramInt = i;
      if (this.muu != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.muu);
      }
      i = paramInt;
      if (this.mut != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.mut);
      }
      paramInt = i;
      if (this.teo != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.teo);
      }
      i = paramInt + a.a.a.a.eL(6, this.ucW) + a.a.a.a.c(7, 8, this.ucX);
      paramInt = i;
      if (this.ucY != null) {
        paramInt = i + a.a.a.a.eN(8, this.ucY.aUd());
      }
      i = a.a.a.a.eL(9, this.ucZ);
      int j = a.a.a.a.c(10, 8, this.uda);
      GMTrace.o(3936471744512L, 29329);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ucX.clear();
      this.uda.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3936471744512L, 29329);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bdh localbdh = (bdh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3936471744512L, 29329);
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
          localbdh.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3936471744512L, 29329);
        return 0;
      case 2: 
        localbdh.ucV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3936471744512L, 29329);
        return 0;
      case 3: 
        localbdh.muu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3936471744512L, 29329);
        return 0;
      case 4: 
        localbdh.mut = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3936471744512L, 29329);
        return 0;
      case 5: 
        localbdh.teo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3936471744512L, 29329);
        return 0;
      case 6: 
        localbdh.ucW = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3936471744512L, 29329);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdj();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdj)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbdh.ucX.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3936471744512L, 29329);
        return 0;
      case 8: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdg();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdg)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbdh.ucY = ((bdg)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3936471744512L, 29329);
        return 0;
      case 9: 
        localbdh.ucZ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3936471744512L, 29329);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bdg();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bdg)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
        localbdh.uda.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(3936471744512L, 29329);
      return 0;
    }
    GMTrace.o(3936471744512L, 29329);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */