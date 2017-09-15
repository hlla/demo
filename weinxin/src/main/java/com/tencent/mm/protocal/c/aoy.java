package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aoy
  extends com.tencent.mm.bd.a
{
  public int jMk;
  public int jMp;
  public String mqI;
  public int mus;
  public avt tSp;
  public avt tep;
  public String tsH;
  public String ttn;
  
  public aoy()
  {
    GMTrace.i(3918083915776L, 29192);
    GMTrace.o(3918083915776L, 29192);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3918218133504L, 29193);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.mus);
      paramVarArgs.eO(2, this.jMp);
      if (this.mqI != null) {
        paramVarArgs.e(3, this.mqI);
      }
      paramVarArgs.eO(4, this.jMk);
      if (this.tep != null)
      {
        paramVarArgs.eQ(5, this.tep.aUd());
        this.tep.a(paramVarArgs);
      }
      if (this.ttn != null) {
        paramVarArgs.e(6, this.ttn);
      }
      if (this.tSp != null)
      {
        paramVarArgs.eQ(7, this.tSp.aUd());
        this.tSp.a(paramVarArgs);
      }
      if (this.tsH != null) {
        paramVarArgs.e(8, this.tsH);
      }
      GMTrace.o(3918218133504L, 29193);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.mus) + 0 + a.a.a.a.eL(2, this.jMp);
      paramInt = i;
      if (this.mqI != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.mqI);
      }
      i = paramInt + a.a.a.a.eL(4, this.jMk);
      paramInt = i;
      if (this.tep != null) {
        paramInt = i + a.a.a.a.eN(5, this.tep.aUd());
      }
      i = paramInt;
      if (this.ttn != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.ttn);
      }
      paramInt = i;
      if (this.tSp != null) {
        paramInt = i + a.a.a.a.eN(7, this.tSp.aUd());
      }
      i = paramInt;
      if (this.tsH != null) {
        i = paramInt + a.a.a.b.b.a.f(8, this.tsH);
      }
      GMTrace.o(3918218133504L, 29193);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3918218133504L, 29193);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aoy localaoy = (aoy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3918218133504L, 29193);
        return -1;
      case 1: 
        localaoy.mus = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3918218133504L, 29193);
        return 0;
      case 2: 
        localaoy.jMp = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3918218133504L, 29193);
        return 0;
      case 3: 
        localaoy.mqI = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3918218133504L, 29193);
        return 0;
      case 4: 
        localaoy.jMk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3918218133504L, 29193);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaoy.tep = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3918218133504L, 29193);
        return 0;
      case 6: 
        localaoy.ttn = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3918218133504L, 29193);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaoy.tSp = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3918218133504L, 29193);
        return 0;
      }
      localaoy.tsH = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3918218133504L, 29193);
      return 0;
    }
    GMTrace.o(3918218133504L, 29193);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aoy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */