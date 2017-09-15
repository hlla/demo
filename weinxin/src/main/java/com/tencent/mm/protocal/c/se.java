package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class se
  extends com.tencent.mm.bd.a
{
  public String canvasPageXml;
  public String desc;
  public int hhl;
  public String thumbUrl;
  public String title;
  public boolean tvt;
  public boolean tvu;
  public boolean twF;
  public boolean txA;
  public String tyf;
  public boolean tyg;
  public int tyh;
  public boolean tyi;
  public boolean tyj;
  
  public se()
  {
    GMTrace.i(3650453766144L, 27198);
    this.tvt = false;
    this.tvu = false;
    this.tyg = false;
    this.txA = false;
    this.tyi = false;
    this.tyj = false;
    this.twF = false;
    GMTrace.o(3650453766144L, 27198);
  }
  
  public final se OP(String paramString)
  {
    GMTrace.i(3650587983872L, 27199);
    this.title = paramString;
    this.tvt = true;
    GMTrace.o(3650587983872L, 27199);
    return this;
  }
  
  public final se OQ(String paramString)
  {
    GMTrace.i(3650722201600L, 27200);
    this.desc = paramString;
    this.tvu = true;
    GMTrace.o(3650722201600L, 27200);
    return this;
  }
  
  public final se OR(String paramString)
  {
    GMTrace.i(3650856419328L, 27201);
    this.tyf = paramString;
    this.tyg = true;
    GMTrace.o(3650856419328L, 27201);
    return this;
  }
  
  public final se OS(String paramString)
  {
    GMTrace.i(3650990637056L, 27202);
    this.thumbUrl = paramString;
    this.txA = true;
    GMTrace.o(3650990637056L, 27202);
    return this;
  }
  
  public final se OT(String paramString)
  {
    GMTrace.i(3651393290240L, 27205);
    this.canvasPageXml = paramString;
    this.twF = true;
    GMTrace.o(3651393290240L, 27205);
    return this;
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3651527507968L, 27206);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.tyf != null) {
        paramVarArgs.e(3, this.tyf);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.e(4, this.thumbUrl);
      }
      if (this.tyi == true) {
        paramVarArgs.eO(5, this.tyh);
      }
      if (this.tyj == true) {
        paramVarArgs.eO(6, this.hhl);
      }
      if (this.canvasPageXml != null) {
        paramVarArgs.e(7, this.canvasPageXml);
      }
      GMTrace.o(3651527507968L, 27206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label676;
      }
    }
    label676:
    for (int i = a.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.tyf != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tyf);
      }
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.thumbUrl);
      }
      i = paramInt;
      if (this.tyi == true) {
        i = paramInt + a.a.a.a.eL(5, this.tyh);
      }
      paramInt = i;
      if (this.tyj == true) {
        paramInt = i + a.a.a.a.eL(6, this.hhl);
      }
      i = paramInt;
      if (this.canvasPageXml != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.canvasPageXml);
      }
      GMTrace.o(3651527507968L, 27206);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3651527507968L, 27206);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        se localse = (se)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3651527507968L, 27206);
          return -1;
        case 1: 
          localse.title = locala.xky.readString();
          localse.tvt = true;
          GMTrace.o(3651527507968L, 27206);
          return 0;
        case 2: 
          localse.desc = locala.xky.readString();
          localse.tvu = true;
          GMTrace.o(3651527507968L, 27206);
          return 0;
        case 3: 
          localse.tyf = locala.xky.readString();
          localse.tyg = true;
          GMTrace.o(3651527507968L, 27206);
          return 0;
        case 4: 
          localse.thumbUrl = locala.xky.readString();
          localse.txA = true;
          GMTrace.o(3651527507968L, 27206);
          return 0;
        case 5: 
          localse.tyh = locala.xky.mL();
          localse.tyi = true;
          GMTrace.o(3651527507968L, 27206);
          return 0;
        case 6: 
          localse.hhl = locala.xky.mL();
          localse.tyj = true;
          GMTrace.o(3651527507968L, 27206);
          return 0;
        }
        localse.canvasPageXml = locala.xky.readString();
        localse.twF = true;
        GMTrace.o(3651527507968L, 27206);
        return 0;
      }
      GMTrace.o(3651527507968L, 27206);
      return -1;
    }
  }
  
  public final se yf(int paramInt)
  {
    GMTrace.i(3651124854784L, 27203);
    this.tyh = paramInt;
    this.tyi = true;
    GMTrace.o(3651124854784L, 27203);
    return this;
  }
  
  public final se yg(int paramInt)
  {
    GMTrace.i(3651259072512L, 27204);
    this.hhl = paramInt;
    this.tyj = true;
    GMTrace.o(3651259072512L, 27204);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/se.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */