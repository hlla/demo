package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bjo
  extends ave
{
  public avu tWY;
  public int the;
  public int tjF;
  public int tkk;
  public avt tqC;
  public String ufm;
  public int ufo;
  public int uhr;
  public LinkedList<avu> uhs;
  public int uht;
  
  public bjo()
  {
    GMTrace.i(3775947341824L, 28133);
    this.uhs = new LinkedList();
    GMTrace.o(3775947341824L, 28133);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3776081559552L, 28134);
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
      if (this.tqC != null)
      {
        paramVarArgs.eQ(2, this.tqC.aUd());
        this.tqC.a(paramVarArgs);
      }
      paramVarArgs.eO(3, this.tjF);
      if (this.ufm != null) {
        paramVarArgs.e(4, this.ufm);
      }
      paramVarArgs.eO(5, this.the);
      paramVarArgs.eO(6, this.ufo);
      paramVarArgs.eO(7, this.tkk);
      paramVarArgs.eO(8, this.uhr);
      paramVarArgs.d(9, 8, this.uhs);
      if (this.tWY != null)
      {
        paramVarArgs.eQ(10, this.tWY.aUd());
        this.tWY.a(paramVarArgs);
      }
      paramVarArgs.eO(11, this.uht);
      GMTrace.o(3776081559552L, 28134);
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
      if (this.tqC != null) {
        i = paramInt + a.a.a.a.eN(2, this.tqC.aUd());
      }
      i += a.a.a.a.eL(3, this.tjF);
      paramInt = i;
      if (this.ufm != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.ufm);
      }
      i = paramInt + a.a.a.a.eL(5, this.the) + a.a.a.a.eL(6, this.ufo) + a.a.a.a.eL(7, this.tkk) + a.a.a.a.eL(8, this.uhr) + a.a.a.a.c(9, 8, this.uhs);
      paramInt = i;
      if (this.tWY != null) {
        paramInt = i + a.a.a.a.eN(10, this.tWY.aUd());
      }
      i = a.a.a.a.eL(11, this.uht);
      GMTrace.o(3776081559552L, 28134);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uhs.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      GMTrace.o(3776081559552L, 28134);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bjo localbjo = (bjo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3776081559552L, 28134);
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
          localbjo.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3776081559552L, 28134);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbjo.tqC = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3776081559552L, 28134);
        return 0;
      case 3: 
        localbjo.tjF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3776081559552L, 28134);
        return 0;
      case 4: 
        localbjo.ufm = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3776081559552L, 28134);
        return 0;
      case 5: 
        localbjo.the = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3776081559552L, 28134);
        return 0;
      case 6: 
        localbjo.ufo = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3776081559552L, 28134);
        return 0;
      case 7: 
        localbjo.tkk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3776081559552L, 28134);
        return 0;
      case 8: 
        localbjo.uhr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3776081559552L, 28134);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbjo.uhs.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3776081559552L, 28134);
        return 0;
      case 10: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbjo.tWY = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3776081559552L, 28134);
        return 0;
      }
      localbjo.uht = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3776081559552L, 28134);
      return 0;
    }
    GMTrace.o(3776081559552L, 28134);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bjo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */