package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class ry
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
  
  public ry()
  {
    GMTrace.i(3704543510528L, 27601);
    this.tvt = false;
    this.tvu = false;
    this.txA = false;
    this.txB = false;
    GMTrace.o(3704543510528L, 27601);
  }
  
  public final ry OL(String paramString)
  {
    GMTrace.i(3704677728256L, 27602);
    this.title = paramString;
    this.tvt = true;
    GMTrace.o(3704677728256L, 27602);
    return this;
  }
  
  public final ry OM(String paramString)
  {
    GMTrace.i(3704811945984L, 27603);
    this.desc = paramString;
    this.tvu = true;
    GMTrace.o(3704811945984L, 27603);
    return this;
  }
  
  public final ry ON(String paramString)
  {
    GMTrace.i(3704946163712L, 27604);
    this.thumbUrl = paramString;
    this.txA = true;
    GMTrace.o(3704946163712L, 27604);
    return this;
  }
  
  public final ry OO(String paramString)
  {
    GMTrace.i(3705080381440L, 27605);
    this.info = paramString;
    this.txB = true;
    GMTrace.o(3705080381440L, 27605);
    return this;
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3705214599168L, 27606);
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
      GMTrace.o(3705214599168L, 27606);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label458;
      }
    }
    label458:
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
      GMTrace.o(3705214599168L, 27606);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3705214599168L, 27606);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        ry localry = (ry)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3705214599168L, 27606);
          return -1;
        case 1: 
          localry.title = locala.xky.readString();
          localry.tvt = true;
          GMTrace.o(3705214599168L, 27606);
          return 0;
        case 2: 
          localry.desc = locala.xky.readString();
          localry.tvu = true;
          GMTrace.o(3705214599168L, 27606);
          return 0;
        case 3: 
          localry.thumbUrl = locala.xky.readString();
          localry.txA = true;
          GMTrace.o(3705214599168L, 27606);
          return 0;
        }
        localry.info = locala.xky.readString();
        localry.txB = true;
        GMTrace.o(3705214599168L, 27606);
        return 0;
      }
      GMTrace.o(3705214599168L, 27606);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */