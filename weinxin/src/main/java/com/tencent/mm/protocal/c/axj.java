package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class axj
  extends ave
{
  public String hAo;
  public cu tYs;
  public String tYt;
  public String tYu;
  public int tYv;
  public int tfg;
  public int tlC;
  public String tsH;
  public int tsY;
  
  public axj()
  {
    GMTrace.i(3725481476096L, 27757);
    GMTrace.o(3725481476096L, 27757);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3725615693824L, 27758);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tYs == null) {
        throw new b("Not all required fields were included: Msg");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.tYs != null)
      {
        paramVarArgs.eQ(2, this.tYs.aUd());
        this.tYs.a(paramVarArgs);
      }
      if (this.tYt != null) {
        paramVarArgs.e(3, this.tYt);
      }
      paramVarArgs.eO(4, this.tsY);
      if (this.tsH != null) {
        paramVarArgs.e(5, this.tsH);
      }
      paramVarArgs.eO(6, this.tfg);
      if (this.hAo != null) {
        paramVarArgs.e(7, this.hAo);
      }
      if (this.tYu != null) {
        paramVarArgs.e(8, this.tYu);
      }
      paramVarArgs.eO(9, this.tYv);
      paramVarArgs.eO(10, this.tlC);
      GMTrace.o(3725615693824L, 27758);
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
      if (this.tYs != null) {
        paramInt = i + a.a.a.a.eN(2, this.tYs.aUd());
      }
      i = paramInt;
      if (this.tYt != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tYt);
      }
      i += a.a.a.a.eL(4, this.tsY);
      paramInt = i;
      if (this.tsH != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tsH);
      }
      i = paramInt + a.a.a.a.eL(6, this.tfg);
      paramInt = i;
      if (this.hAo != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.hAo);
      }
      i = paramInt;
      if (this.tYu != null) {
        i = paramInt + a.a.a.b.b.a.f(8, this.tYu);
      }
      paramInt = a.a.a.a.eL(9, this.tYv);
      int j = a.a.a.a.eL(10, this.tlC);
      GMTrace.o(3725615693824L, 27758);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tYs == null) {
        throw new b("Not all required fields were included: Msg");
      }
      GMTrace.o(3725615693824L, 27758);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      axj localaxj = (axj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3725615693824L, 27758);
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
          localaxj.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3725615693824L, 27758);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localaxj.tYs = ((cu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3725615693824L, 27758);
        return 0;
      case 3: 
        localaxj.tYt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3725615693824L, 27758);
        return 0;
      case 4: 
        localaxj.tsY = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3725615693824L, 27758);
        return 0;
      case 5: 
        localaxj.tsH = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3725615693824L, 27758);
        return 0;
      case 6: 
        localaxj.tfg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3725615693824L, 27758);
        return 0;
      case 7: 
        localaxj.hAo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3725615693824L, 27758);
        return 0;
      case 8: 
        localaxj.tYu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3725615693824L, 27758);
        return 0;
      case 9: 
        localaxj.tYv = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3725615693824L, 27758);
        return 0;
      }
      localaxj.tlC = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3725615693824L, 27758);
      return 0;
    }
    GMTrace.o(3725615693824L, 27758);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/axj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */