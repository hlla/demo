package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class avq
  extends ave
{
  public String mut;
  public String muu;
  public int ofk;
  public int tXv;
  public int tXw;
  public int tXx;
  public long tXy;
  public String teo;
  
  public avq()
  {
    GMTrace.i(3687095205888L, 27471);
    GMTrace.o(3687095205888L, 27471);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3687229423616L, 27472);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.teo != null) {
        paramVarArgs.e(2, this.teo);
      }
      paramVarArgs.eO(3, this.tXv);
      paramVarArgs.eO(4, this.ofk);
      paramVarArgs.eO(5, this.tXw);
      if (this.muu != null) {
        paramVarArgs.e(6, this.muu);
      }
      if (this.mut != null) {
        paramVarArgs.e(7, this.mut);
      }
      paramVarArgs.eO(8, this.tXx);
      paramVarArgs.O(9, this.tXy);
      GMTrace.o(3687229423616L, 27472);
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
      if (this.teo != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.teo);
      }
      i = i + a.a.a.a.eL(3, this.tXv) + a.a.a.a.eL(4, this.ofk) + a.a.a.a.eL(5, this.tXw);
      paramInt = i;
      if (this.muu != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.muu);
      }
      i = paramInt;
      if (this.mut != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.mut);
      }
      paramInt = a.a.a.a.eL(8, this.tXx);
      int j = a.a.a.a.N(9, this.tXy);
      GMTrace.o(3687229423616L, 27472);
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
      GMTrace.o(3687229423616L, 27472);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      avq localavq = (avq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3687229423616L, 27472);
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
          localavq.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3687229423616L, 27472);
        return 0;
      case 2: 
        localavq.teo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3687229423616L, 27472);
        return 0;
      case 3: 
        localavq.tXv = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3687229423616L, 27472);
        return 0;
      case 4: 
        localavq.ofk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3687229423616L, 27472);
        return 0;
      case 5: 
        localavq.tXw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3687229423616L, 27472);
        return 0;
      case 6: 
        localavq.muu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3687229423616L, 27472);
        return 0;
      case 7: 
        localavq.mut = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3687229423616L, 27472);
        return 0;
      case 8: 
        localavq.tXx = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3687229423616L, 27472);
        return 0;
      }
      localavq.tXy = ((a.a.a.a.a)localObject1).xky.mM();
      GMTrace.o(3687229423616L, 27472);
      return 0;
    }
    GMTrace.o(3687229423616L, 27472);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/avq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */