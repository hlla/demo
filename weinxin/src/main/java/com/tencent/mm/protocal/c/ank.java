package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ank
  extends ave
{
  public String jLx;
  public String lda;
  public avt tQE;
  public avt tQF;
  
  public ank()
  {
    GMTrace.i(13581089243136L, 101187);
    GMTrace.o(13581089243136L, 101187);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13581223460864L, 101188);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tQE == null) {
        throw new b("Not all required fields were included: CurrentSynckey");
      }
      if (this.tQF == null) {
        throw new b("Not all required fields were included: MaxSynckey");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.jLx != null) {
        paramVarArgs.e(2, this.jLx);
      }
      if (this.tQE != null)
      {
        paramVarArgs.eQ(3, this.tQE.aUd());
        this.tQE.a(paramVarArgs);
      }
      if (this.tQF != null)
      {
        paramVarArgs.eQ(4, this.tQF.aUd());
        this.tQF.a(paramVarArgs);
      }
      if (this.lda != null) {
        paramVarArgs.e(5, this.lda);
      }
      GMTrace.o(13581223460864L, 101188);
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
      if (this.tQE != null) {
        i = paramInt + a.a.a.a.eN(3, this.tQE.aUd());
      }
      paramInt = i;
      if (this.tQF != null) {
        paramInt = i + a.a.a.a.eN(4, this.tQF.aUd());
      }
      i = paramInt;
      if (this.lda != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.lda);
      }
      GMTrace.o(13581223460864L, 101188);
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
      if (this.tQE == null) {
        throw new b("Not all required fields were included: CurrentSynckey");
      }
      if (this.tQF == null) {
        throw new b("Not all required fields were included: MaxSynckey");
      }
      GMTrace.o(13581223460864L, 101188);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ank localank = (ank)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13581223460864L, 101188);
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
          localank.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13581223460864L, 101188);
        return 0;
      case 2: 
        localank.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13581223460864L, 101188);
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
          localank.tQE = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13581223460864L, 101188);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localank.tQF = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13581223460864L, 101188);
        return 0;
      }
      localank.lda = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(13581223460864L, 101188);
      return 0;
    }
    GMTrace.o(13581223460864L, 101188);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */