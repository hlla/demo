package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ru
  extends com.tencent.mm.bd.a
{
  public String desc;
  public String iAN;
  public String title;
  public boolean tvt;
  public boolean tvu;
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
  public rv txD;
  public boolean txE;
  public LinkedList<rl> txF;
  public boolean txG;
  public boolean txH;
  public boolean txa;
  public long txb;
  public boolean txc;
  public int version;
  
  public ru()
  {
    GMTrace.i(3693806092288L, 27521);
    this.txE = false;
    this.txF = new LinkedList();
    this.txG = false;
    this.twP = false;
    this.twR = false;
    this.twW = false;
    this.tvt = false;
    this.tvu = false;
    this.twY = false;
    this.twZ = -1;
    this.txa = false;
    this.twT = false;
    this.txc = false;
    this.twV = false;
    this.txH = false;
    GMTrace.o(3693806092288L, 27521);
  }
  
  public final ru OA(String paramString)
  {
    GMTrace.i(3694611398656L, 27527);
    this.title = paramString;
    this.tvt = true;
    GMTrace.o(3694611398656L, 27527);
    return this;
  }
  
  public final ru OB(String paramString)
  {
    GMTrace.i(3694745616384L, 27528);
    this.desc = paramString;
    this.tvu = true;
    GMTrace.o(3694745616384L, 27528);
    return this;
  }
  
  public final ru Oz(String paramString)
  {
    GMTrace.i(3694477180928L, 27526);
    this.iAN = paramString;
    this.twW = true;
    GMTrace.o(3694477180928L, 27526);
    return this;
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3695685140480L, 27535);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.txD != null)
      {
        paramVarArgs.eQ(1, this.txD.aUd());
        this.txD.a(paramVarArgs);
      }
      paramVarArgs.d(2, 8, this.txF);
      if (this.twO != null)
      {
        paramVarArgs.eQ(3, this.twO.aUd());
        this.twO.a(paramVarArgs);
      }
      if (this.twQ != null)
      {
        paramVarArgs.eQ(4, this.twQ.aUd());
        this.twQ.a(paramVarArgs);
      }
      if (this.iAN != null) {
        paramVarArgs.e(5, this.iAN);
      }
      if (this.title != null) {
        paramVarArgs.e(6, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(7, this.desc);
      }
      if (this.twY == true) {
        paramVarArgs.O(8, this.twX);
      }
      if (this.txa == true) {
        paramVarArgs.eO(91, this.twZ);
      }
      if (this.twS != null)
      {
        paramVarArgs.eQ(10, this.twS.aUd());
        this.twS.a(paramVarArgs);
      }
      if (this.txc == true) {
        paramVarArgs.O(11, this.txb);
      }
      if (this.twU != null)
      {
        paramVarArgs.eQ(12, this.twU.aUd());
        this.twU.a(paramVarArgs);
      }
      if (this.txH == true) {
        paramVarArgs.eO(13, this.version);
      }
      GMTrace.o(3695685140480L, 27535);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.txD != null) {
        paramInt = a.a.a.a.eN(1, this.txD.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.c(2, 8, this.txF);
      paramInt = i;
      if (this.twO != null) {
        paramInt = i + a.a.a.a.eN(3, this.twO.aUd());
      }
      i = paramInt;
      if (this.twQ != null) {
        i = paramInt + a.a.a.a.eN(4, this.twQ.aUd());
      }
      paramInt = i;
      if (this.iAN != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.iAN);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + a.a.a.b.b.a.f(6, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.desc);
      }
      i = paramInt;
      if (this.twY == true) {
        i = paramInt + a.a.a.a.N(8, this.twX);
      }
      paramInt = i;
      if (this.txa == true) {
        paramInt = i + a.a.a.a.eL(91, this.twZ);
      }
      i = paramInt;
      if (this.twS != null) {
        i = paramInt + a.a.a.a.eN(10, this.twS.aUd());
      }
      paramInt = i;
      if (this.txc == true) {
        paramInt = i + a.a.a.a.N(11, this.txb);
      }
      i = paramInt;
      if (this.twU != null) {
        i = paramInt + a.a.a.a.eN(12, this.twU.aUd());
      }
      paramInt = i;
      if (this.txH == true) {
        paramInt = i + a.a.a.a.eL(13, this.version);
      }
      GMTrace.o(3695685140480L, 27535);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.txF.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3695685140480L, 27535);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ru localru = (ru)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3695685140480L, 27535);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rv();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rv)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localru.txD = ((rv)localObject1);
          paramInt += 1;
        }
        localru.txE = true;
        GMTrace.o(3695685140480L, 27535);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localru.txF.add(localObject1);
          paramInt += 1;
        }
        localru.txG = true;
        GMTrace.o(3695685140480L, 27535);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rr();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rr)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localru.twO = ((rr)localObject1);
          paramInt += 1;
        }
        localru.twP = true;
        GMTrace.o(3695685140480L, 27535);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new se();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((se)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localru.twQ = ((se)localObject1);
          paramInt += 1;
        }
        localru.twR = true;
        GMTrace.o(3695685140480L, 27535);
        return 0;
      case 5: 
        localru.iAN = ((a.a.a.a.a)localObject1).xky.readString();
        localru.twW = true;
        GMTrace.o(3695685140480L, 27535);
        return 0;
      case 6: 
        localru.title = ((a.a.a.a.a)localObject1).xky.readString();
        localru.tvt = true;
        GMTrace.o(3695685140480L, 27535);
        return 0;
      case 7: 
        localru.desc = ((a.a.a.a.a)localObject1).xky.readString();
        localru.tvu = true;
        GMTrace.o(3695685140480L, 27535);
        return 0;
      case 8: 
        localru.twX = ((a.a.a.a.a)localObject1).xky.mM();
        localru.twY = true;
        GMTrace.o(3695685140480L, 27535);
        return 0;
      case 91: 
        localru.twZ = ((a.a.a.a.a)localObject1).xky.mL();
        localru.txa = true;
        GMTrace.o(3695685140480L, 27535);
        return 0;
      case 10: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localru.twS = ((rt)localObject1);
          paramInt += 1;
        }
        localru.twT = true;
        GMTrace.o(3695685140480L, 27535);
        return 0;
      case 11: 
        localru.txb = ((a.a.a.a.a)localObject1).xky.mM();
        localru.txc = true;
        GMTrace.o(3695685140480L, 27535);
        return 0;
      case 12: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ry();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ry)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localru.twU = ((ry)localObject1);
          paramInt += 1;
        }
        localru.twV = true;
        GMTrace.o(3695685140480L, 27535);
        return 0;
      }
      localru.version = ((a.a.a.a.a)localObject1).xky.mL();
      localru.txH = true;
      GMTrace.o(3695685140480L, 27535);
      return 0;
    }
    GMTrace.o(3695685140480L, 27535);
    return -1;
  }
  
  public final ru a(rv paramrv)
  {
    GMTrace.i(3693940310016L, 27522);
    this.txD = paramrv;
    this.txE = true;
    GMTrace.o(3693940310016L, 27522);
    return this;
  }
  
  public final ru av(LinkedList<rl> paramLinkedList)
  {
    GMTrace.i(3694074527744L, 27523);
    this.txF = paramLinkedList;
    this.txG = true;
    GMTrace.o(3694074527744L, 27523);
    return this;
  }
  
  public final ru b(rr paramrr)
  {
    GMTrace.i(3694208745472L, 27524);
    this.twO = paramrr;
    this.twP = true;
    GMTrace.o(3694208745472L, 27524);
    return this;
  }
  
  public final ru b(rt paramrt)
  {
    GMTrace.i(3695148269568L, 27531);
    this.twS = paramrt;
    this.twT = true;
    GMTrace.o(3695148269568L, 27531);
    return this;
  }
  
  public final ru b(ry paramry)
  {
    GMTrace.i(3695416705024L, 27533);
    this.twU = paramry;
    this.twV = true;
    GMTrace.o(3695416705024L, 27533);
    return this;
  }
  
  public final ru b(se paramse)
  {
    GMTrace.i(3694342963200L, 27525);
    this.twQ = paramse;
    this.twR = true;
    GMTrace.o(3694342963200L, 27525);
    return this;
  }
  
  public final ru en(long paramLong)
  {
    GMTrace.i(3694879834112L, 27529);
    this.twX = paramLong;
    this.twY = true;
    GMTrace.o(3694879834112L, 27529);
    return this;
  }
  
  public final ru eo(long paramLong)
  {
    GMTrace.i(3695282487296L, 27532);
    this.txb = paramLong;
    this.txc = true;
    GMTrace.o(3695282487296L, 27532);
    return this;
  }
  
  public final ru yc(int paramInt)
  {
    GMTrace.i(3695014051840L, 27530);
    this.twZ = paramInt;
    this.txa = true;
    GMTrace.o(3695014051840L, 27530);
    return this;
  }
  
  public final ru yd(int paramInt)
  {
    GMTrace.i(3695550922752L, 27534);
    this.version = paramInt;
    this.txH = true;
    GMTrace.o(3695550922752L, 27534);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */