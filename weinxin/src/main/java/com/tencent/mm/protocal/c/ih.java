package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ih
  extends ave
{
  public String mut;
  public String muu;
  public int tcg;
  public String tdC;
  public int teq;
  public String tlA;
  public int tlB;
  public int tlC;
  public int tlD;
  public String tlp;
  public int tlq;
  public int tlr;
  public avt tls;
  public float tlt;
  public float tlu;
  public String tlv;
  public int tlw;
  public int tlx;
  public int tly;
  public int tlz;
  
  public ih()
  {
    GMTrace.i(3721454944256L, 27727);
    GMTrace.o(3721454944256L, 27727);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3721589161984L, 27728);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tlp != null) {
        paramVarArgs.e(1, this.tlp);
      }
      if (this.muu != null) {
        paramVarArgs.e(2, this.muu);
      }
      if (this.mut != null) {
        paramVarArgs.e(3, this.mut);
      }
      paramVarArgs.eO(4, this.tlq);
      paramVarArgs.eO(5, this.tlr);
      if (this.tdC != null) {
        paramVarArgs.e(6, this.tdC);
      }
      if (this.tls != null)
      {
        paramVarArgs.eQ(7, this.tls.aUd());
        this.tls.a(paramVarArgs);
      }
      paramVarArgs.eO(8, this.tcg);
      paramVarArgs.n(9, this.tlt);
      paramVarArgs.n(10, this.tlu);
      if (this.tlv != null) {
        paramVarArgs.e(11, this.tlv);
      }
      paramVarArgs.eO(12, this.tlw);
      paramVarArgs.eO(13, this.tlx);
      paramVarArgs.eO(14, this.tly);
      paramVarArgs.eO(15, this.tlz);
      if (this.tlA != null) {
        paramVarArgs.e(16, this.tlA);
      }
      paramVarArgs.eO(17, this.tlB);
      paramVarArgs.eO(18, this.tlC);
      paramVarArgs.eO(19, this.tlD);
      paramVarArgs.eO(20, this.teq);
      GMTrace.o(3721589161984L, 27728);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tlp != null) {
        i = a.a.a.b.b.a.f(1, this.tlp) + 0;
      }
      paramInt = i;
      if (this.muu != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.muu);
      }
      i = paramInt;
      if (this.mut != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.mut);
      }
      i = i + a.a.a.a.eL(4, this.tlq) + a.a.a.a.eL(5, this.tlr);
      paramInt = i;
      if (this.tdC != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tdC);
      }
      i = paramInt;
      if (this.tls != null) {
        i = paramInt + a.a.a.a.eN(7, this.tls.aUd());
      }
      i = i + a.a.a.a.eL(8, this.tcg) + (a.a.a.b.b.a.cH(9) + 4) + (a.a.a.b.b.a.cH(10) + 4);
      paramInt = i;
      if (this.tlv != null) {
        paramInt = i + a.a.a.b.b.a.f(11, this.tlv);
      }
      i = paramInt + a.a.a.a.eL(12, this.tlw) + a.a.a.a.eL(13, this.tlx) + a.a.a.a.eL(14, this.tly) + a.a.a.a.eL(15, this.tlz);
      paramInt = i;
      if (this.tlA != null) {
        paramInt = i + a.a.a.b.b.a.f(16, this.tlA);
      }
      i = a.a.a.a.eL(17, this.tlB);
      int j = a.a.a.a.eL(18, this.tlC);
      int k = a.a.a.a.eL(19, this.tlD);
      int m = a.a.a.a.eL(20, this.teq);
      GMTrace.o(3721589161984L, 27728);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3721589161984L, 27728);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ih localih = (ih)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3721589161984L, 27728);
        return -1;
      case 1: 
        localih.tlp = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 2: 
        localih.muu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 3: 
        localih.mut = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 4: 
        localih.tlq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 5: 
        localih.tlr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 6: 
        localih.tdC = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localih.tls = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 8: 
        localih.tcg = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 9: 
        localih.tlt = ((a.a.a.a.a)localObject1).xky.readFloat();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 10: 
        localih.tlu = ((a.a.a.a.a)localObject1).xky.readFloat();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 11: 
        localih.tlv = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 12: 
        localih.tlw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 13: 
        localih.tlx = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 14: 
        localih.tly = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 15: 
        localih.tlz = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 16: 
        localih.tlA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 17: 
        localih.tlB = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 18: 
        localih.tlC = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      case 19: 
        localih.tlD = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3721589161984L, 27728);
        return 0;
      }
      localih.teq = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3721589161984L, 27728);
      return 0;
    }
    GMTrace.o(3721589161984L, 27728);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */