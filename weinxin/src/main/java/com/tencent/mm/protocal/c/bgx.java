package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bgx
  extends ave
{
  public String jLx;
  public int jMq;
  public String mrA;
  public int ten;
  public int tfd;
  public int tfe;
  public int tff;
  public avt tqC;
  public String tsQ;
  public String ueY;
  
  public bgx()
  {
    GMTrace.i(3889898192896L, 28982);
    GMTrace.o(3889898192896L, 28982);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3890032410624L, 28983);
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
      if (this.mrA != null) {
        paramVarArgs.e(2, this.mrA);
      }
      paramVarArgs.eO(3, this.ten);
      if (this.ueY != null) {
        paramVarArgs.e(4, this.ueY);
      }
      if (this.jLx != null) {
        paramVarArgs.e(5, this.jLx);
      }
      paramVarArgs.eO(6, this.tfd);
      paramVarArgs.eO(7, this.tfe);
      paramVarArgs.eO(8, this.tff);
      if (this.tqC != null)
      {
        paramVarArgs.eQ(9, this.tqC.aUd());
        this.tqC.a(paramVarArgs);
      }
      paramVarArgs.eO(10, this.jMq);
      if (this.tsQ != null) {
        paramVarArgs.e(11, this.tsQ);
      }
      GMTrace.o(3890032410624L, 28983);
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
      if (this.mrA != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.mrA);
      }
      i += a.a.a.a.eL(3, this.ten);
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.ueY);
      }
      i = paramInt;
      if (this.jLx != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.jLx);
      }
      i = i + a.a.a.a.eL(6, this.tfd) + a.a.a.a.eL(7, this.tfe) + a.a.a.a.eL(8, this.tff);
      paramInt = i;
      if (this.tqC != null) {
        paramInt = i + a.a.a.a.eN(9, this.tqC.aUd());
      }
      i = paramInt + a.a.a.a.eL(10, this.jMq);
      paramInt = i;
      if (this.tsQ != null) {
        paramInt = i + a.a.a.b.b.a.f(11, this.tsQ);
      }
      GMTrace.o(3890032410624L, 28983);
      return paramInt;
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
      GMTrace.o(3890032410624L, 28983);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bgx localbgx = (bgx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3890032410624L, 28983);
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
          localbgx.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3890032410624L, 28983);
        return 0;
      case 2: 
        localbgx.mrA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3890032410624L, 28983);
        return 0;
      case 3: 
        localbgx.ten = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3890032410624L, 28983);
        return 0;
      case 4: 
        localbgx.ueY = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3890032410624L, 28983);
        return 0;
      case 5: 
        localbgx.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3890032410624L, 28983);
        return 0;
      case 6: 
        localbgx.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3890032410624L, 28983);
        return 0;
      case 7: 
        localbgx.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3890032410624L, 28983);
        return 0;
      case 8: 
        localbgx.tff = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3890032410624L, 28983);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbgx.tqC = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3890032410624L, 28983);
        return 0;
      case 10: 
        localbgx.jMq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3890032410624L, 28983);
        return 0;
      }
      localbgx.tsQ = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3890032410624L, 28983);
      return 0;
    }
    GMTrace.o(3890032410624L, 28983);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */