package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class om
  extends ave
{
  public long tdE;
  public int tdw;
  public String teo;
  public int tjF;
  public String trI;
  public int tsu;
  public long tsv;
  
  public om()
  {
    GMTrace.i(4021700001792L, 29964);
    GMTrace.o(4021700001792L, 29964);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4021834219520L, 29965);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tdw);
      paramVarArgs.eO(2, this.tjF);
      paramVarArgs.eO(3, this.tsu);
      if (this.teo != null) {
        paramVarArgs.e(4, this.teo);
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(5, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.O(6, this.tdE);
      if (this.trI != null) {
        paramVarArgs.e(7, this.trI);
      }
      paramVarArgs.O(8, this.tsv);
      GMTrace.o(4021834219520L, 29965);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tdw) + 0 + a.a.a.a.eL(2, this.tjF) + a.a.a.a.eL(3, this.tsu);
      paramInt = i;
      if (this.teo != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.teo);
      }
      i = paramInt;
      if (this.tXb != null) {
        i = paramInt + a.a.a.a.eN(5, this.tXb.aUd());
      }
      i += a.a.a.a.N(6, this.tdE);
      paramInt = i;
      if (this.trI != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.trI);
      }
      i = a.a.a.a.N(8, this.tsv);
      GMTrace.o(4021834219520L, 29965);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4021834219520L, 29965);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      om localom = (om)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4021834219520L, 29965);
        return -1;
      case 1: 
        localom.tdw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4021834219520L, 29965);
        return 0;
      case 2: 
        localom.tjF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4021834219520L, 29965);
        return 0;
      case 3: 
        localom.tsu = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4021834219520L, 29965);
        return 0;
      case 4: 
        localom.teo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4021834219520L, 29965);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localom.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4021834219520L, 29965);
        return 0;
      case 6: 
        localom.tdE = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(4021834219520L, 29965);
        return 0;
      case 7: 
        localom.trI = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4021834219520L, 29965);
        return 0;
      }
      localom.tsv = ((a.a.a.a.a)localObject1).xky.mM();
      GMTrace.o(4021834219520L, 29965);
      return 0;
    }
    GMTrace.o(4021834219520L, 29965);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/om.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */