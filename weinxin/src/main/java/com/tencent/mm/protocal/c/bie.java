package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bie
  extends ave
{
  public String mut;
  public String muu;
  public int tNn;
  public String tdC;
  public long tdE;
  public int tdw;
  public String teo;
  public int the;
  public int tjF;
  public avt tqC;
  public int tsY;
  public int tsu;
  public int tsw;
  public int tsx;
  public int ugf;
  public int ugg;
  
  public bie()
  {
    GMTrace.i(3649380024320L, 27190);
    GMTrace.o(3649380024320L, 27190);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3649514242048L, 27191);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.muu != null) {
        paramVarArgs.e(1, this.muu);
      }
      if (this.mut != null) {
        paramVarArgs.e(2, this.mut);
      }
      paramVarArgs.eO(3, this.tjF);
      paramVarArgs.eO(4, this.tsu);
      if (this.teo != null) {
        paramVarArgs.e(5, this.teo);
      }
      paramVarArgs.eO(6, this.tdw);
      paramVarArgs.eO(7, this.tsw);
      if (this.tqC != null)
      {
        paramVarArgs.eQ(8, this.tqC.aUd());
        this.tqC.a(paramVarArgs);
      }
      paramVarArgs.eO(9, this.the);
      if (this.tXb != null)
      {
        paramVarArgs.eQ(10, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(11, this.tsx);
      if (this.tdC != null) {
        paramVarArgs.e(12, this.tdC);
      }
      paramVarArgs.eO(13, this.tNn);
      paramVarArgs.eO(14, this.ugf);
      paramVarArgs.eO(15, this.ugg);
      paramVarArgs.O(16, this.tdE);
      paramVarArgs.eO(17, this.tsY);
      GMTrace.o(3649514242048L, 27191);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.muu != null) {
        paramInt = a.a.a.b.b.a.f(1, this.muu) + 0;
      }
      i = paramInt;
      if (this.mut != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.mut);
      }
      i = i + a.a.a.a.eL(3, this.tjF) + a.a.a.a.eL(4, this.tsu);
      paramInt = i;
      if (this.teo != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.teo);
      }
      i = paramInt + a.a.a.a.eL(6, this.tdw) + a.a.a.a.eL(7, this.tsw);
      paramInt = i;
      if (this.tqC != null) {
        paramInt = i + a.a.a.a.eN(8, this.tqC.aUd());
      }
      i = paramInt + a.a.a.a.eL(9, this.the);
      paramInt = i;
      if (this.tXb != null) {
        paramInt = i + a.a.a.a.eN(10, this.tXb.aUd());
      }
      i = paramInt + a.a.a.a.eL(11, this.tsx);
      paramInt = i;
      if (this.tdC != null) {
        paramInt = i + a.a.a.b.b.a.f(12, this.tdC);
      }
      i = a.a.a.a.eL(13, this.tNn);
      int j = a.a.a.a.eL(14, this.ugf);
      int k = a.a.a.a.eL(15, this.ugg);
      int m = a.a.a.a.N(16, this.tdE);
      int n = a.a.a.a.eL(17, this.tsY);
      GMTrace.o(3649514242048L, 27191);
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
      GMTrace.o(3649514242048L, 27191);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bie localbie = (bie)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3649514242048L, 27191);
        return -1;
      case 1: 
        localbie.muu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 2: 
        localbie.mut = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 3: 
        localbie.tjF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 4: 
        localbie.tsu = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 5: 
        localbie.teo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 6: 
        localbie.tdw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 7: 
        localbie.tsw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3649514242048L, 27191);
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
          localbie.tqC = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 9: 
        localbie.the = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 10: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbie.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 11: 
        localbie.tsx = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 12: 
        localbie.tdC = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 13: 
        localbie.tNn = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 14: 
        localbie.ugf = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 15: 
        localbie.ugg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3649514242048L, 27191);
        return 0;
      case 16: 
        localbie.tdE = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(3649514242048L, 27191);
        return 0;
      }
      localbie.tsY = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3649514242048L, 27191);
      return 0;
    }
    GMTrace.o(3649514242048L, 27191);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */