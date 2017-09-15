package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class rm
  extends com.tencent.mm.bd.a
{
  public String desc;
  public String iAN;
  public String title;
  public boolean tvt;
  public boolean tvu;
  public rn twM;
  public boolean twN;
  public rr twO;
  public boolean twP;
  public se twQ;
  public boolean twR;
  public rt twS;
  public boolean twT;
  public ry twU;
  public boolean twV;
  public boolean twW;
  public long twX;
  public boolean twY;
  public int twZ;
  public boolean txa;
  public long txb;
  public boolean txc;
  
  public rm()
  {
    GMTrace.i(3882784653312L, 28929);
    this.twN = false;
    this.twP = false;
    this.twR = false;
    this.twT = false;
    this.twV = false;
    this.twW = false;
    this.tvt = false;
    this.tvu = false;
    this.twY = false;
    this.twZ = -1;
    this.txa = false;
    this.txc = false;
    GMTrace.o(3882784653312L, 28929);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3883589959680L, 28935);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.twM != null)
      {
        paramVarArgs.eQ(1, this.twM.aUd());
        this.twM.a(paramVarArgs);
      }
      if (this.twO != null)
      {
        paramVarArgs.eQ(2, this.twO.aUd());
        this.twO.a(paramVarArgs);
      }
      if (this.twQ != null)
      {
        paramVarArgs.eQ(3, this.twQ.aUd());
        this.twQ.a(paramVarArgs);
      }
      if (this.twS != null)
      {
        paramVarArgs.eQ(4, this.twS.aUd());
        this.twS.a(paramVarArgs);
      }
      if (this.twU != null)
      {
        paramVarArgs.eQ(5, this.twU.aUd());
        this.twU.a(paramVarArgs);
      }
      if (this.iAN != null) {
        paramVarArgs.e(6, this.iAN);
      }
      if (this.title != null) {
        paramVarArgs.e(7, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(8, this.desc);
      }
      if (this.twY == true) {
        paramVarArgs.O(9, this.twX);
      }
      if (this.txa == true) {
        paramVarArgs.eO(101, this.twZ);
      }
      if (this.txc == true) {
        paramVarArgs.O(11, this.txb);
      }
      GMTrace.o(3883589959680L, 28935);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.twM != null) {
        i = a.a.a.a.eN(1, this.twM.aUd()) + 0;
      }
      paramInt = i;
      if (this.twO != null) {
        paramInt = i + a.a.a.a.eN(2, this.twO.aUd());
      }
      i = paramInt;
      if (this.twQ != null) {
        i = paramInt + a.a.a.a.eN(3, this.twQ.aUd());
      }
      paramInt = i;
      if (this.twS != null) {
        paramInt = i + a.a.a.a.eN(4, this.twS.aUd());
      }
      i = paramInt;
      if (this.twU != null) {
        i = paramInt + a.a.a.a.eN(5, this.twU.aUd());
      }
      paramInt = i;
      if (this.iAN != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.iAN);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.desc);
      }
      i = paramInt;
      if (this.twY == true) {
        i = paramInt + a.a.a.a.N(9, this.twX);
      }
      paramInt = i;
      if (this.txa == true) {
        paramInt = i + a.a.a.a.eL(101, this.twZ);
      }
      i = paramInt;
      if (this.txc == true) {
        i = paramInt + a.a.a.a.N(11, this.txb);
      }
      GMTrace.o(3883589959680L, 28935);
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
      GMTrace.o(3883589959680L, 28935);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      rm localrm = (rm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3883589959680L, 28935);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rn();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rn)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localrm.twM = ((rn)localObject1);
          paramInt += 1;
        }
        localrm.twN = true;
        GMTrace.o(3883589959680L, 28935);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rr();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rr)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localrm.twO = ((rr)localObject1);
          paramInt += 1;
        }
        localrm.twP = true;
        GMTrace.o(3883589959680L, 28935);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new se();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((se)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localrm.twQ = ((se)localObject1);
          paramInt += 1;
        }
        localrm.twR = true;
        GMTrace.o(3883589959680L, 28935);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localrm.twS = ((rt)localObject1);
          paramInt += 1;
        }
        localrm.twT = true;
        GMTrace.o(3883589959680L, 28935);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ry();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ry)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localrm.twU = ((ry)localObject1);
          paramInt += 1;
        }
        localrm.twV = true;
        GMTrace.o(3883589959680L, 28935);
        return 0;
      case 6: 
        localrm.iAN = ((a.a.a.a.a)localObject1).xky.readString();
        localrm.twW = true;
        GMTrace.o(3883589959680L, 28935);
        return 0;
      case 7: 
        localrm.title = ((a.a.a.a.a)localObject1).xky.readString();
        localrm.tvt = true;
        GMTrace.o(3883589959680L, 28935);
        return 0;
      case 8: 
        localrm.desc = ((a.a.a.a.a)localObject1).xky.readString();
        localrm.tvu = true;
        GMTrace.o(3883589959680L, 28935);
        return 0;
      case 9: 
        localrm.twX = ((a.a.a.a.a)localObject1).xky.mM();
        localrm.twY = true;
        GMTrace.o(3883589959680L, 28935);
        return 0;
      case 101: 
        localrm.twZ = ((a.a.a.a.a)localObject1).xky.mL();
        localrm.txa = true;
        GMTrace.o(3883589959680L, 28935);
        return 0;
      }
      localrm.txb = ((a.a.a.a.a)localObject1).xky.mM();
      localrm.txc = true;
      GMTrace.o(3883589959680L, 28935);
      return 0;
    }
    GMTrace.o(3883589959680L, 28935);
    return -1;
  }
  
  public final rm a(rr paramrr)
  {
    GMTrace.i(3883053088768L, 28931);
    this.twO = paramrr;
    this.twP = true;
    GMTrace.o(3883053088768L, 28931);
    return this;
  }
  
  public final rm a(rt paramrt)
  {
    GMTrace.i(3883321524224L, 28933);
    this.twS = paramrt;
    this.twT = true;
    GMTrace.o(3883321524224L, 28933);
    return this;
  }
  
  public final rm a(ry paramry)
  {
    GMTrace.i(3883455741952L, 28934);
    this.twU = paramry;
    this.twV = true;
    GMTrace.o(3883455741952L, 28934);
    return this;
  }
  
  public final rm a(se paramse)
  {
    GMTrace.i(3883187306496L, 28932);
    this.twQ = paramse;
    this.twR = true;
    GMTrace.o(3883187306496L, 28932);
    return this;
  }
  
  public final rm c(rn paramrn)
  {
    GMTrace.i(3882918871040L, 28930);
    this.twM = paramrn;
    this.twN = true;
    GMTrace.o(3882918871040L, 28930);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/rm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */