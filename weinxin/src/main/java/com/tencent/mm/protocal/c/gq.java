package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class gq
  extends com.tencent.mm.bd.a
{
  public String name;
  public String tiZ;
  public String tja;
  public int tjb;
  public int tjc;
  public String tjd;
  public String tje;
  public int type;
  public int ver;
  
  public gq()
  {
    GMTrace.i(3775678906368L, 28131);
    GMTrace.o(3775678906368L, 28131);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3775813124096L, 28132);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tiZ != null) {
        paramVarArgs.e(1, this.tiZ);
      }
      paramVarArgs.eO(2, this.type);
      if (this.tja != null) {
        paramVarArgs.e(3, this.tja);
      }
      if (this.name != null) {
        paramVarArgs.e(4, this.name);
      }
      paramVarArgs.eO(5, this.ver);
      paramVarArgs.eO(6, this.tjb);
      paramVarArgs.eO(7, this.tjc);
      if (this.tjd != null) {
        paramVarArgs.e(8, this.tjd);
      }
      if (this.tje != null) {
        paramVarArgs.e(9, this.tje);
      }
      GMTrace.o(3775813124096L, 28132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tiZ == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = a.a.a.b.b.a.f(1, this.tiZ) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.eL(2, this.type);
      paramInt = i;
      if (this.tja != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.tja);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.name);
      }
      i = i + a.a.a.a.eL(5, this.ver) + a.a.a.a.eL(6, this.tjb) + a.a.a.a.eL(7, this.tjc);
      paramInt = i;
      if (this.tjd != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.tjd);
      }
      i = paramInt;
      if (this.tje != null) {
        i = paramInt + a.a.a.b.b.a.f(9, this.tje);
      }
      GMTrace.o(3775813124096L, 28132);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3775813124096L, 28132);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        gq localgq = (gq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3775813124096L, 28132);
          return -1;
        case 1: 
          localgq.tiZ = locala.xky.readString();
          GMTrace.o(3775813124096L, 28132);
          return 0;
        case 2: 
          localgq.type = locala.xky.mL();
          GMTrace.o(3775813124096L, 28132);
          return 0;
        case 3: 
          localgq.tja = locala.xky.readString();
          GMTrace.o(3775813124096L, 28132);
          return 0;
        case 4: 
          localgq.name = locala.xky.readString();
          GMTrace.o(3775813124096L, 28132);
          return 0;
        case 5: 
          localgq.ver = locala.xky.mL();
          GMTrace.o(3775813124096L, 28132);
          return 0;
        case 6: 
          localgq.tjb = locala.xky.mL();
          GMTrace.o(3775813124096L, 28132);
          return 0;
        case 7: 
          localgq.tjc = locala.xky.mL();
          GMTrace.o(3775813124096L, 28132);
          return 0;
        case 8: 
          localgq.tjd = locala.xky.readString();
          GMTrace.o(3775813124096L, 28132);
          return 0;
        }
        localgq.tje = locala.xky.readString();
        GMTrace.o(3775813124096L, 28132);
        return 0;
      }
      GMTrace.o(3775813124096L, 28132);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/gq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */