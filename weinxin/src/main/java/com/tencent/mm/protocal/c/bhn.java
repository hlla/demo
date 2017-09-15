package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bhn
  extends ave
{
  public String jLx;
  public LinkedList<alr> tLz;
  public int tgi;
  public String thR;
  public int ufq;
  public int ufr;
  public LinkedList<ajt> ufs;
  
  public bhn()
  {
    GMTrace.i(3716354670592L, 27689);
    this.tLz = new LinkedList();
    this.ufs = new LinkedList();
    GMTrace.o(3716354670592L, 27689);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3716488888320L, 27690);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.jLx != null) {
        paramVarArgs.e(2, this.jLx);
      }
      paramVarArgs.eO(3, this.tgi);
      if (this.thR != null) {
        paramVarArgs.e(4, this.thR);
      }
      paramVarArgs.eO(5, this.ufq);
      paramVarArgs.d(6, 8, this.tLz);
      paramVarArgs.eO(7, this.ufr);
      paramVarArgs.d(8, 8, this.ufs);
      GMTrace.o(3716488888320L, 27690);
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
      if (this.jLx != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.jLx);
      }
      i += a.a.a.a.eL(3, this.tgi);
      paramInt = i;
      if (this.thR != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.thR);
      }
      i = a.a.a.a.eL(5, this.ufq);
      int j = a.a.a.a.c(6, 8, this.tLz);
      int k = a.a.a.a.eL(7, this.ufr);
      int m = a.a.a.a.c(8, 8, this.ufs);
      GMTrace.o(3716488888320L, 27690);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tLz.clear();
      this.ufs.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3716488888320L, 27690);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bhn localbhn = (bhn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3716488888320L, 27690);
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
          localbhn.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3716488888320L, 27690);
        return 0;
      case 2: 
        localbhn.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3716488888320L, 27690);
        return 0;
      case 3: 
        localbhn.tgi = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3716488888320L, 27690);
        return 0;
      case 4: 
        localbhn.thR = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3716488888320L, 27690);
        return 0;
      case 5: 
        localbhn.ufq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3716488888320L, 27690);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alr();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((alr)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbhn.tLz.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3716488888320L, 27690);
        return 0;
      case 7: 
        localbhn.ufr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3716488888320L, 27690);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ajt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ajt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
        localbhn.ufs.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(3716488888320L, 27690);
      return 0;
    }
    GMTrace.o(3716488888320L, 27690);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bhn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */