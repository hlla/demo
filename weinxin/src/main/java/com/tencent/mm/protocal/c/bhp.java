package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bhp
  extends ave
{
  public int mtN;
  public int tfd;
  public int tfe;
  public int tff;
  public avt tqC;
  public avu uft;
  public avu ufu;
  public int ufv;
  public int ufw;
  public int ufx;
  public int ufy;
  
  public bhp()
  {
    GMTrace.i(3794066735104L, 28268);
    GMTrace.o(3794066735104L, 28268);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3794200952832L, 28269);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.uft == null) {
        throw new b("Not all required fields were included: ClientMediaId");
      }
      if (this.ufu == null) {
        throw new b("Not all required fields were included: DataMD5");
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.uft != null)
      {
        paramVarArgs.eQ(2, this.uft.aUd());
        this.uft.a(paramVarArgs);
      }
      if (this.ufu != null)
      {
        paramVarArgs.eQ(3, this.ufu.aUd());
        this.ufu.a(paramVarArgs);
      }
      paramVarArgs.eO(4, this.tfd);
      paramVarArgs.eO(5, this.tfe);
      paramVarArgs.eO(6, this.tff);
      if (this.tqC != null)
      {
        paramVarArgs.eQ(7, this.tqC.aUd());
        this.tqC.a(paramVarArgs);
      }
      paramVarArgs.eO(8, this.mtN);
      paramVarArgs.eO(9, this.ufv);
      paramVarArgs.eO(10, this.ufw);
      paramVarArgs.eO(11, this.ufx);
      paramVarArgs.eO(12, this.ufy);
      GMTrace.o(3794200952832L, 28269);
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
      if (this.uft != null) {
        paramInt = i + a.a.a.a.eN(2, this.uft.aUd());
      }
      i = paramInt;
      if (this.ufu != null) {
        i = paramInt + a.a.a.a.eN(3, this.ufu.aUd());
      }
      i = i + a.a.a.a.eL(4, this.tfd) + a.a.a.a.eL(5, this.tfe) + a.a.a.a.eL(6, this.tff);
      paramInt = i;
      if (this.tqC != null) {
        paramInt = i + a.a.a.a.eN(7, this.tqC.aUd());
      }
      i = a.a.a.a.eL(8, this.mtN);
      int j = a.a.a.a.eL(9, this.ufv);
      int k = a.a.a.a.eL(10, this.ufw);
      int m = a.a.a.a.eL(11, this.ufx);
      int n = a.a.a.a.eL(12, this.ufy);
      GMTrace.o(3794200952832L, 28269);
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
      if (this.uft == null) {
        throw new b("Not all required fields were included: ClientMediaId");
      }
      if (this.ufu == null) {
        throw new b("Not all required fields were included: DataMD5");
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      GMTrace.o(3794200952832L, 28269);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bhp localbhp = (bhp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3794200952832L, 28269);
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
          localbhp.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3794200952832L, 28269);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbhp.uft = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3794200952832L, 28269);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbhp.ufu = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3794200952832L, 28269);
        return 0;
      case 4: 
        localbhp.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3794200952832L, 28269);
        return 0;
      case 5: 
        localbhp.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3794200952832L, 28269);
        return 0;
      case 6: 
        localbhp.tff = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3794200952832L, 28269);
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
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbhp.tqC = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3794200952832L, 28269);
        return 0;
      case 8: 
        localbhp.mtN = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3794200952832L, 28269);
        return 0;
      case 9: 
        localbhp.ufv = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3794200952832L, 28269);
        return 0;
      case 10: 
        localbhp.ufw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3794200952832L, 28269);
        return 0;
      case 11: 
        localbhp.ufx = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3794200952832L, 28269);
        return 0;
      }
      localbhp.ufy = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3794200952832L, 28269);
      return 0;
    }
    GMTrace.o(3794200952832L, 28269);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bhp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */