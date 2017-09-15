package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class biv
  extends ave
{
  public avu tGC;
  public int tYY;
  public int tay;
  public avt tgM;
  public String tio;
  public avu tis;
  public avt tit;
  public String ugO;
  public avu ugP;
  
  public biv()
  {
    GMTrace.i(13342450122752L, 99409);
    GMTrace.o(13342450122752L, 99409);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13342584340480L, 99410);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tay);
      if (this.ugO != null) {
        paramVarArgs.e(3, this.ugO);
      }
      if (this.tio != null) {
        paramVarArgs.e(4, this.tio);
      }
      if (this.tGC != null)
      {
        paramVarArgs.eQ(5, this.tGC.aUd());
        this.tGC.a(paramVarArgs);
      }
      if (this.ugP != null)
      {
        paramVarArgs.eQ(6, this.ugP.aUd());
        this.ugP.a(paramVarArgs);
      }
      if (this.tis != null)
      {
        paramVarArgs.eQ(7, this.tis.aUd());
        this.tis.a(paramVarArgs);
      }
      if (this.tit != null)
      {
        paramVarArgs.eQ(8, this.tit.aUd());
        this.tit.a(paramVarArgs);
      }
      paramVarArgs.eO(9, this.tYY);
      if (this.tgM != null)
      {
        paramVarArgs.eQ(10, this.tgM.aUd());
        this.tgM.a(paramVarArgs);
      }
      GMTrace.o(13342584340480L, 99410);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tay);
      paramInt = i;
      if (this.ugO != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.ugO);
      }
      i = paramInt;
      if (this.tio != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.tio);
      }
      paramInt = i;
      if (this.tGC != null) {
        paramInt = i + a.a.a.a.eN(5, this.tGC.aUd());
      }
      i = paramInt;
      if (this.ugP != null) {
        i = paramInt + a.a.a.a.eN(6, this.ugP.aUd());
      }
      paramInt = i;
      if (this.tis != null) {
        paramInt = i + a.a.a.a.eN(7, this.tis.aUd());
      }
      i = paramInt;
      if (this.tit != null) {
        i = paramInt + a.a.a.a.eN(8, this.tit.aUd());
      }
      i += a.a.a.a.eL(9, this.tYY);
      paramInt = i;
      if (this.tgM != null) {
        paramInt = i + a.a.a.a.eN(10, this.tgM.aUd());
      }
      GMTrace.o(13342584340480L, 99410);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13342584340480L, 99410);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      biv localbiv = (biv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13342584340480L, 99410);
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
          localbiv.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13342584340480L, 99410);
        return 0;
      case 2: 
        localbiv.tay = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13342584340480L, 99410);
        return 0;
      case 3: 
        localbiv.ugO = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13342584340480L, 99410);
        return 0;
      case 4: 
        localbiv.tio = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13342584340480L, 99410);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbiv.tGC = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13342584340480L, 99410);
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
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbiv.ugP = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13342584340480L, 99410);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbiv.tis = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13342584340480L, 99410);
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
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbiv.tit = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13342584340480L, 99410);
        return 0;
      case 9: 
        localbiv.tYY = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13342584340480L, 99410);
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
        localbiv.tgM = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13342584340480L, 99410);
      return 0;
    }
    GMTrace.o(13342584340480L, 99410);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/biv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */