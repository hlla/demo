package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class gx
  extends com.tencent.mm.bd.a
{
  public String kfF;
  public String tja;
  public int tjb;
  public String tje;
  public String tjg;
  public String tjo;
  public int ver;
  
  public gx()
  {
    GMTrace.i(3910030852096L, 29132);
    GMTrace.o(3910030852096L, 29132);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3910165069824L, 29133);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tjg != null) {
        paramVarArgs.e(1, this.tjg);
      }
      if (this.kfF != null) {
        paramVarArgs.e(2, this.kfF);
      }
      paramVarArgs.eO(3, this.ver);
      if (this.tja != null) {
        paramVarArgs.e(4, this.tja);
      }
      if (this.tjo != null) {
        paramVarArgs.e(5, this.tjo);
      }
      paramVarArgs.eO(6, this.tjb);
      if (this.tje != null) {
        paramVarArgs.e(7, this.tje);
      }
      GMTrace.o(3910165069824L, 29133);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tjg == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = a.a.a.b.b.a.f(1, this.tjg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kfF != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.kfF);
      }
      i += a.a.a.a.eL(3, this.ver);
      paramInt = i;
      if (this.tja != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tja);
      }
      i = paramInt;
      if (this.tjo != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tjo);
      }
      i += a.a.a.a.eL(6, this.tjb);
      paramInt = i;
      if (this.tje != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.tje);
      }
      GMTrace.o(3910165069824L, 29133);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3910165069824L, 29133);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        gx localgx = (gx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3910165069824L, 29133);
          return -1;
        case 1: 
          localgx.tjg = locala.xky.readString();
          GMTrace.o(3910165069824L, 29133);
          return 0;
        case 2: 
          localgx.kfF = locala.xky.readString();
          GMTrace.o(3910165069824L, 29133);
          return 0;
        case 3: 
          localgx.ver = locala.xky.mL();
          GMTrace.o(3910165069824L, 29133);
          return 0;
        case 4: 
          localgx.tja = locala.xky.readString();
          GMTrace.o(3910165069824L, 29133);
          return 0;
        case 5: 
          localgx.tjo = locala.xky.readString();
          GMTrace.o(3910165069824L, 29133);
          return 0;
        case 6: 
          localgx.tjb = locala.xky.mL();
          GMTrace.o(3910165069824L, 29133);
          return 0;
        }
        localgx.tje = locala.xky.readString();
        GMTrace.o(3910165069824L, 29133);
        return 0;
      }
      GMTrace.o(3910165069824L, 29133);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/gx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */