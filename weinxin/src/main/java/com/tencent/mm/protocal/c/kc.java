package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class kc
  extends ave
{
  public String hNH;
  public String mut;
  public String muu;
  public int tfg;
  public String tlA;
  public String toA;
  public String toB;
  public long toz;
  
  public kc()
  {
    GMTrace.i(3960496717824L, 29508);
    GMTrace.o(3960496717824L, 29508);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3960630935552L, 29509);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.muu != null) {
        paramVarArgs.e(2, this.muu);
      }
      if (this.mut != null) {
        paramVarArgs.e(3, this.mut);
      }
      paramVarArgs.O(4, this.toz);
      if (this.tlA != null) {
        paramVarArgs.e(5, this.tlA);
      }
      if (this.toA != null) {
        paramVarArgs.e(6, this.toA);
      }
      paramVarArgs.eO(7, this.tfg);
      if (this.toB != null) {
        paramVarArgs.e(8, this.toB);
      }
      if (this.hNH != null) {
        paramVarArgs.e(9, this.hNH);
      }
      GMTrace.o(3960630935552L, 29509);
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
      if (this.muu != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.muu);
      }
      i = paramInt;
      if (this.mut != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.mut);
      }
      i += a.a.a.a.N(4, this.toz);
      paramInt = i;
      if (this.tlA != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.tlA);
      }
      i = paramInt;
      if (this.toA != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.toA);
      }
      i += a.a.a.a.eL(7, this.tfg);
      paramInt = i;
      if (this.toB != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.toB);
      }
      i = paramInt;
      if (this.hNH != null) {
        i = paramInt + a.a.a.b.b.a.f(9, this.hNH);
      }
      GMTrace.o(3960630935552L, 29509);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3960630935552L, 29509);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      kc localkc = (kc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3960630935552L, 29509);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localkc.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3960630935552L, 29509);
        return 0;
      case 2: 
        localkc.muu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3960630935552L, 29509);
        return 0;
      case 3: 
        localkc.mut = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3960630935552L, 29509);
        return 0;
      case 4: 
        localkc.toz = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(3960630935552L, 29509);
        return 0;
      case 5: 
        localkc.tlA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3960630935552L, 29509);
        return 0;
      case 6: 
        localkc.toA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3960630935552L, 29509);
        return 0;
      case 7: 
        localkc.tfg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3960630935552L, 29509);
        return 0;
      case 8: 
        localkc.toB = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3960630935552L, 29509);
        return 0;
      }
      localkc.hNH = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3960630935552L, 29509);
      return 0;
    }
    GMTrace.o(3960630935552L, 29509);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/kc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */