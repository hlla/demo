package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class avf
  extends com.tencent.mm.bd.a
{
  public int sEc;
  public int tDn;
  public int tII;
  public int tUe;
  public avi tXc;
  public avh tXd;
  public int tXe;
  public String tXf;
  public int tXg;
  public int tXh;
  public int tXi;
  public int tla;
  
  public avf()
  {
    GMTrace.i(3940900929536L, 29362);
    GMTrace.o(3940900929536L, 29362);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3941035147264L, 29363);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXf == null) {
        throw new b("Not all required fields were included: SampleId");
      }
      paramVarArgs.eO(1, this.tUe);
      if (this.tXc != null)
      {
        paramVarArgs.eQ(2, this.tXc.aUd());
        this.tXc.a(paramVarArgs);
      }
      if (this.tXd != null)
      {
        paramVarArgs.eQ(3, this.tXd.aUd());
        this.tXd.a(paramVarArgs);
      }
      paramVarArgs.eO(4, this.tDn);
      paramVarArgs.eO(5, this.tXe);
      if (this.tXf != null) {
        paramVarArgs.e(6, this.tXf);
      }
      paramVarArgs.eO(7, this.tla);
      paramVarArgs.eO(8, this.tXg);
      paramVarArgs.eO(9, this.sEc);
      paramVarArgs.eO(10, this.tXh);
      paramVarArgs.eO(11, this.tXi);
      paramVarArgs.eO(12, this.tII);
      GMTrace.o(3941035147264L, 29363);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tUe) + 0;
      paramInt = i;
      if (this.tXc != null) {
        paramInt = i + a.a.a.a.eN(2, this.tXc.aUd());
      }
      i = paramInt;
      if (this.tXd != null) {
        i = paramInt + a.a.a.a.eN(3, this.tXd.aUd());
      }
      i = i + a.a.a.a.eL(4, this.tDn) + a.a.a.a.eL(5, this.tXe);
      paramInt = i;
      if (this.tXf != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tXf);
      }
      i = a.a.a.a.eL(7, this.tla);
      int j = a.a.a.a.eL(8, this.tXg);
      int k = a.a.a.a.eL(9, this.sEc);
      int m = a.a.a.a.eL(10, this.tXh);
      int n = a.a.a.a.eL(11, this.tXi);
      int i1 = a.a.a.a.eL(12, this.tII);
      GMTrace.o(3941035147264L, 29363);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXf == null) {
        throw new b("Not all required fields were included: SampleId");
      }
      GMTrace.o(3941035147264L, 29363);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      avf localavf = (avf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3941035147264L, 29363);
        return -1;
      case 1: 
        localavf.tUe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3941035147264L, 29363);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avi();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avi)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localavf.tXc = ((avi)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3941035147264L, 29363);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avh();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avh)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localavf.tXd = ((avh)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3941035147264L, 29363);
        return 0;
      case 4: 
        localavf.tDn = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3941035147264L, 29363);
        return 0;
      case 5: 
        localavf.tXe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3941035147264L, 29363);
        return 0;
      case 6: 
        localavf.tXf = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3941035147264L, 29363);
        return 0;
      case 7: 
        localavf.tla = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3941035147264L, 29363);
        return 0;
      case 8: 
        localavf.tXg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3941035147264L, 29363);
        return 0;
      case 9: 
        localavf.sEc = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3941035147264L, 29363);
        return 0;
      case 10: 
        localavf.tXh = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3941035147264L, 29363);
        return 0;
      case 11: 
        localavf.tXi = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3941035147264L, 29363);
        return 0;
      }
      localavf.tII = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3941035147264L, 29363);
      return 0;
    }
    GMTrace.o(3941035147264L, 29363);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/avf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */