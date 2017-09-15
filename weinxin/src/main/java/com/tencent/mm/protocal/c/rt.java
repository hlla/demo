package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class rt
  extends com.tencent.mm.bd.a
{
  public String desc;
  public String info;
  public String thumbUrl;
  public String title;
  public boolean tvt;
  public boolean tvu;
  public boolean txA;
  public boolean txB;
  public boolean txC;
  public int type;
  
  public rt()
  {
    GMTrace.i(3698503712768L, 27556);
    this.tvt = false;
    this.tvu = false;
    this.txA = false;
    this.txB = false;
    this.txC = false;
    GMTrace.o(3698503712768L, 27556);
  }
  
  public final rt Ov(String paramString)
  {
    GMTrace.i(3698637930496L, 27557);
    this.title = paramString;
    this.tvt = true;
    GMTrace.o(3698637930496L, 27557);
    return this;
  }
  
  public final rt Ow(String paramString)
  {
    GMTrace.i(3698772148224L, 27558);
    this.desc = paramString;
    this.tvu = true;
    GMTrace.o(3698772148224L, 27558);
    return this;
  }
  
  public final rt Ox(String paramString)
  {
    GMTrace.i(3698906365952L, 27559);
    this.thumbUrl = paramString;
    this.txA = true;
    GMTrace.o(3698906365952L, 27559);
    return this;
  }
  
  public final rt Oy(String paramString)
  {
    GMTrace.i(3699040583680L, 27560);
    this.info = paramString;
    this.txB = true;
    GMTrace.o(3699040583680L, 27560);
    return this;
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3699309019136L, 27562);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.e(3, this.thumbUrl);
      }
      if (this.info != null) {
        paramVarArgs.e(4, this.info);
      }
      if (this.txC == true) {
        paramVarArgs.eO(5, this.type);
      }
      GMTrace.o(3699309019136L, 27562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label532;
      }
    }
    label532:
    for (int i = a.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.thumbUrl);
      }
      paramInt = i;
      if (this.info != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.info);
      }
      i = paramInt;
      if (this.txC == true) {
        i = paramInt + a.a.a.a.eL(5, this.type);
      }
      GMTrace.o(3699309019136L, 27562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3699309019136L, 27562);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        rt localrt = (rt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3699309019136L, 27562);
          return -1;
        case 1: 
          localrt.title = locala.xky.readString();
          localrt.tvt = true;
          GMTrace.o(3699309019136L, 27562);
          return 0;
        case 2: 
          localrt.desc = locala.xky.readString();
          localrt.tvu = true;
          GMTrace.o(3699309019136L, 27562);
          return 0;
        case 3: 
          localrt.thumbUrl = locala.xky.readString();
          localrt.txA = true;
          GMTrace.o(3699309019136L, 27562);
          return 0;
        case 4: 
          localrt.info = locala.xky.readString();
          localrt.txB = true;
          GMTrace.o(3699309019136L, 27562);
          return 0;
        }
        localrt.type = locala.xky.mL();
        localrt.txC = true;
        GMTrace.o(3699309019136L, 27562);
        return 0;
      }
      GMTrace.o(3699309019136L, 27562);
      return -1;
    }
  }
  
  public final rt yb(int paramInt)
  {
    GMTrace.i(3699174801408L, 27561);
    this.type = paramInt;
    this.txC = true;
    GMTrace.o(3699174801408L, 27561);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/rt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */