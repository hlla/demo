package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class pm
  extends com.tencent.mm.bd.a
{
  public String mtt;
  public String tfq;
  public String ttA;
  public String ttE;
  public int ttV;
  public String ttW;
  public String ttX;
  public String ttY;
  public String ttn;
  public String tto;
  public String ttp;
  public String ttq;
  public int ttr;
  public int tts;
  public String ttv;
  public int ttw;
  public String ttx;
  public String tty;
  public String ttz;
  
  public pm()
  {
    GMTrace.i(3874463154176L, 28867);
    GMTrace.o(3874463154176L, 28867);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3874597371904L, 28868);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tfq != null) {
        paramVarArgs.e(1, this.tfq);
      }
      if (this.mtt != null) {
        paramVarArgs.e(2, this.mtt);
      }
      if (this.ttn != null) {
        paramVarArgs.e(3, this.ttn);
      }
      if (this.tto != null) {
        paramVarArgs.e(4, this.tto);
      }
      if (this.ttp != null) {
        paramVarArgs.e(5, this.ttp);
      }
      if (this.ttq != null) {
        paramVarArgs.e(6, this.ttq);
      }
      paramVarArgs.eO(7, this.ttr);
      paramVarArgs.eO(8, this.tts);
      if (this.ttv != null) {
        paramVarArgs.e(9, this.ttv);
      }
      paramVarArgs.eO(10, this.ttw);
      if (this.ttx != null) {
        paramVarArgs.e(11, this.ttx);
      }
      paramVarArgs.eO(12, this.ttV);
      if (this.ttA != null) {
        paramVarArgs.e(13, this.ttA);
      }
      if (this.tty != null) {
        paramVarArgs.e(14, this.tty);
      }
      if (this.ttz != null) {
        paramVarArgs.e(15, this.ttz);
      }
      if (this.ttW != null) {
        paramVarArgs.e(16, this.ttW);
      }
      if (this.ttE != null) {
        paramVarArgs.e(17, this.ttE);
      }
      if (this.ttX != null) {
        paramVarArgs.e(18, this.ttX);
      }
      if (this.ttY != null) {
        paramVarArgs.e(19, this.ttY);
      }
      GMTrace.o(3874597371904L, 28868);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tfq == null) {
        break label1358;
      }
    }
    label1358:
    for (int i = a.a.a.b.b.a.f(1, this.tfq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mtt != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.mtt);
      }
      i = paramInt;
      if (this.ttn != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.ttn);
      }
      paramInt = i;
      if (this.tto != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tto);
      }
      i = paramInt;
      if (this.ttp != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.ttp);
      }
      paramInt = i;
      if (this.ttq != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.ttq);
      }
      i = paramInt + a.a.a.a.eL(7, this.ttr) + a.a.a.a.eL(8, this.tts);
      paramInt = i;
      if (this.ttv != null) {
        paramInt = i + a.a.a.b.b.a.f(9, this.ttv);
      }
      i = paramInt + a.a.a.a.eL(10, this.ttw);
      paramInt = i;
      if (this.ttx != null) {
        paramInt = i + a.a.a.b.b.a.f(11, this.ttx);
      }
      i = paramInt + a.a.a.a.eL(12, this.ttV);
      paramInt = i;
      if (this.ttA != null) {
        paramInt = i + a.a.a.b.b.a.f(13, this.ttA);
      }
      i = paramInt;
      if (this.tty != null) {
        i = paramInt + a.a.a.b.b.a.f(14, this.tty);
      }
      paramInt = i;
      if (this.ttz != null) {
        paramInt = i + a.a.a.b.b.a.f(15, this.ttz);
      }
      i = paramInt;
      if (this.ttW != null) {
        i = paramInt + a.a.a.b.b.a.f(16, this.ttW);
      }
      paramInt = i;
      if (this.ttE != null) {
        paramInt = i + a.a.a.b.b.a.f(17, this.ttE);
      }
      i = paramInt;
      if (this.ttX != null) {
        i = paramInt + a.a.a.b.b.a.f(18, this.ttX);
      }
      paramInt = i;
      if (this.ttY != null) {
        paramInt = i + a.a.a.b.b.a.f(19, this.ttY);
      }
      GMTrace.o(3874597371904L, 28868);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3874597371904L, 28868);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        pm localpm = (pm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3874597371904L, 28868);
          return -1;
        case 1: 
          localpm.tfq = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 2: 
          localpm.mtt = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 3: 
          localpm.ttn = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 4: 
          localpm.tto = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 5: 
          localpm.ttp = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 6: 
          localpm.ttq = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 7: 
          localpm.ttr = locala.xky.mL();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 8: 
          localpm.tts = locala.xky.mL();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 9: 
          localpm.ttv = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 10: 
          localpm.ttw = locala.xky.mL();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 11: 
          localpm.ttx = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 12: 
          localpm.ttV = locala.xky.mL();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 13: 
          localpm.ttA = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 14: 
          localpm.tty = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 15: 
          localpm.ttz = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 16: 
          localpm.ttW = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 17: 
          localpm.ttE = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        case 18: 
          localpm.ttX = locala.xky.readString();
          GMTrace.o(3874597371904L, 28868);
          return 0;
        }
        localpm.ttY = locala.xky.readString();
        GMTrace.o(3874597371904L, 28868);
        return 0;
      }
      GMTrace.o(3874597371904L, 28868);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/pm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */