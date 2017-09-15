package oicq.wlogin_sdk.request;

import java.lang.reflect.Array;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.ab;
import oicq.wlogin_sdk.a.ac;
import oicq.wlogin_sdk.a.ad;
import oicq.wlogin_sdk.a.af;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.ai;
import oicq.wlogin_sdk.a.ak;
import oicq.wlogin_sdk.a.al;
import oicq.wlogin_sdk.a.am;
import oicq.wlogin_sdk.a.ap;
import oicq.wlogin_sdk.a.e;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.j;
import oicq.wlogin_sdk.a.l;
import oicq.wlogin_sdk.a.m;
import oicq.wlogin_sdk.a.n;
import oicq.wlogin_sdk.a.o;
import oicq.wlogin_sdk.a.p;
import oicq.wlogin_sdk.a.q;
import oicq.wlogin_sdk.a.s;
import oicq.wlogin_sdk.a.t;
import oicq.wlogin_sdk.a.u;
import oicq.wlogin_sdk.a.v;
import oicq.wlogin_sdk.a.w;
import oicq.wlogin_sdk.a.x;
import oicq.wlogin_sdk.a.z;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class d
{
  protected static int xle = 0;
  int xkW = 4096;
  int xkX = 0;
  int xkY = 27;
  int xkZ = 0;
  public int xla = 15;
  protected int xlb = 0;
  protected byte[] xlc = new byte[this.xkW];
  protected int xld = 8001;
  protected int xlf = 0;
  protected int xlg = 0;
  protected int xlh = 0;
  protected int xli = 0;
  protected int xlj = 0;
  byte xlk;
  protected i xll;
  
  private int a(s params)
  {
    long l3 = 4294967295L;
    o localo = new o();
    p localp = new p();
    l locall = new l();
    q localq = new q();
    e locale = new e();
    t localt = new t();
    oicq.wlogin_sdk.a.d locald = new oicq.wlogin_sdk.a.d();
    m localm = new m();
    u localu = new u();
    Object localObject10 = new w();
    Object localObject9 = new x();
    j localj = new j();
    Object localObject6 = new h();
    n localn = new n();
    Object localObject8 = new z();
    Object localObject1 = new v();
    Object localObject2 = new ad();
    Object localObject3 = new ab();
    Object localObject4 = new af();
    Object localObject5 = new ap();
    ak localak = new ak();
    Object localObject7 = new al();
    am localam = new am();
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte3 = null;
    byte[] arrayOfByte4 = null;
    byte[] arrayOfByte5 = null;
    byte[] arrayOfByte6 = null;
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte7 = null;
    byte[] arrayOfByte8 = null;
    ac localac = new ac();
    byte[] arrayOfByte9 = params.cid();
    int i = arrayOfByte9.length;
    localo.n(arrayOfByte9, 2, i);
    localp.n(arrayOfByte9, 2, i);
    locall.n(arrayOfByte9, 2, i);
    localq.n(arrayOfByte9, 2, i);
    int j = localt.n(arrayOfByte9, 2, i);
    if (j < 0) {
      return j;
    }
    if (locale.n(arrayOfByte9, 2, i) >= 0) {
      arrayOfByte1 = locale.cid();
    }
    if (localj.n(arrayOfByte9, 2, i) >= 0) {
      util.a(this.xll.xkU, localj.cid());
    }
    if (locald.n(arrayOfByte9, 2, i) >= 0) {
      arrayOfByte2 = locald.cid();
    }
    if (localm.n(arrayOfByte9, 2, i) >= 0) {
      arrayOfByte3 = localm.cid();
    }
    if (localu.n(arrayOfByte9, 2, i) >= 0) {
      arrayOfByte4 = localu.cid();
    }
    if (((a)localObject10).n(arrayOfByte9, 2, i) >= 0) {
      arrayOfByte5 = ((a)localObject10).cid();
    }
    if (((a)localObject9).n(arrayOfByte9, 2, i) >= 0) {
      arrayOfByte6 = ((a)localObject9).cid();
    }
    if (((a)localObject8).n(arrayOfByte9, 2, i) >= 0)
    {
      arrayOfByte7 = new byte[((z)localObject8).xmq];
      System.arraycopy(((z)localObject8).xlc, ((z)localObject8).xlR + 2, arrayOfByte7, 0, arrayOfByte7.length);
      arrayOfByte8 = new byte[((z)localObject8).xmr];
      System.arraycopy(((z)localObject8).xlc, ((z)localObject8).xlR + 2 + ((z)localObject8).xmq + 2, arrayOfByte8, 0, arrayOfByte8.length);
    }
    label636:
    long l1;
    if (((a)localObject7).n(arrayOfByte9, 2, i) >= 0)
    {
      localObject10 = new h();
      localObject9 = new n();
      localObject8 = new am();
      params = new ah();
      localObject7 = ((a)localObject7).cid();
      j = localObject7.length;
      if (((a)localObject10).n((byte[])localObject7, 2, j) < 0)
      {
        params = null;
        if ((params == null) || (params.length <= 0)) {
          break label1362;
        }
        this.xll.xlO = ((byte[])params.clone());
        util.fp("fast data:", util.bU(params));
      }
    }
    else
    {
      params = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 7, 0 });
      if (localac.n(arrayOfByte9, 2, i) >= 0) {
        params[0] = localac.cid();
      }
      j = localn.n(arrayOfByte9, 2, i);
      if ((((a)localObject6).n(arrayOfByte9, 2, i) >= 0) && (j >= 0))
      {
        this.xll.xln = localn.cid();
        this.xll.xlM = bJ(((a)localObject6).cid());
        params[1] = ((byte[])this.xll.xlM.clone());
      }
      if (((a)localObject3).n(arrayOfByte9, 2, i) >= 0)
      {
        localObject6 = new byte[((ab)localObject3).xmt];
        System.arraycopy(((ab)localObject3).xlc, ((ab)localObject3).xlR + 2, localObject6, 0, localObject6.length);
        params[2] = localObject6;
      }
      if (((a)localObject4).n(arrayOfByte9, 2, i) >= 0) {
        params[3] = ((a)localObject4).cid();
      }
      if (((a)localObject5).n(arrayOfByte9, 2, i) >= 0) {
        params[4] = ((a)localObject5).cid();
      }
      if (localak.n(arrayOfByte9, 2, i) >= 0) {
        params[5] = localak.cid();
      }
      if (localam.n(arrayOfByte9, 2, i) >= 0) {
        params[6] = localam.cid();
      }
      if (((a)localObject1).n(arrayOfByte9, 2, i) < 0) {
        break label1398;
      }
      if (this.xll.xlu != -1L) {
        break label1375;
      }
      l1 = util.L(((v)localObject1).xlc, ((v)localObject1).xlR);
      label918:
      l3 = 0xFFFFFFFF & util.L(((v)localObject1).xlc, ((v)localObject1).xlR + 4);
    }
    for (;;)
    {
      if ((((a)localObject2).n(arrayOfByte9, 2, i) >= 0) && (((ad)localObject2).cig() != 0)) {}
      for (long l2 = ((ad)localObject2).cig();; l2 = 2160000L)
      {
        if (l2 < l1) {
          l2 = l1;
        }
        for (;;)
        {
          localObject1 = this.xll;
          long l4 = this.xll._uin;
          long l5 = this.xll.xls;
          long l6 = i.cic();
          long l7 = i.cic();
          long l8 = i.cic();
          localObject2 = new byte[2];
          System.arraycopy(localt.xlc, localt.xlR, localObject2, 0, 2);
          localObject3 = new byte[1];
          System.arraycopy(localt.xlc, localt.xlR + 2, localObject3, 0, 1);
          localObject4 = new byte[1];
          System.arraycopy(localt.xlc, localt.xlR + 2 + 1, localObject4, 0, 1);
          localObject5 = new byte[localt.xmo];
          System.arraycopy(localt.xlc, localt.xlR + 2 + 1 + 1 + 1, localObject5, 0, localt.xmo);
          ((i)localObject1).a(l4, l5, l3, l6, l1 + l7, l2 + l8, (byte[])localObject2, (byte[])localObject3, (byte[])localObject4, (byte[])localObject5, locall.cid(), localo.cid(), localq.cid(), localp.cid(), arrayOfByte1, arrayOfByte3, arrayOfByte2, arrayOfByte4, arrayOfByte5, arrayOfByte6, arrayOfByte7, arrayOfByte8, params);
          return 0;
          if (((a)localObject9).n((byte[])localObject7, 2, j) < 0)
          {
            params = null;
            break;
          }
          if (((a)localObject8).n((byte[])localObject7, 2, j) < 0)
          {
            params = null;
            break;
          }
          localObject7 = ((a)localObject10).cia();
          localObject9 = ((a)localObject9).cia();
          localObject8 = ((a)localObject8).cia();
          localObject10 = params.bQ(this.xll.xlw);
          params = new byte[localObject7.length + 3 + localObject9.length + localObject8.length + localObject10.length];
          params[0] = 64;
          util.p(params, 1, 4);
          System.arraycopy(localObject7, 0, params, 3, localObject7.length);
          j = localObject7.length + 3;
          System.arraycopy(localObject9, 0, params, j, localObject9.length);
          j = localObject9.length + j;
          System.arraycopy(localObject8, 0, params, j, localObject8.length);
          System.arraycopy(localObject10, 0, params, j + localObject8.length, localObject10.length);
          break;
          label1362:
          this.xll.xlO = new byte[0];
          break label636;
          label1375:
          l1 = this.xll.xlu;
          break label918;
        }
      }
      label1398:
      l1 = 3600L;
    }
  }
  
  public final int F(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 64534;
    int j = 0;
    if (paramInt <= this.xla + 2) {
      i = 64527;
    }
    for (;;)
    {
      return i;
      this.xlb = (paramInt - this.xla - 2);
      if (paramInt > this.xkW)
      {
        this.xkW = (paramInt + 128);
        this.xlc = new byte[this.xkW];
      }
      this.xkX = paramInt;
      System.arraycopy(paramArrayOfByte, 0, this.xlc, 0, paramInt);
      paramArrayOfByte = this.xlc;
      paramInt = this.xla + 1;
      paramArrayOfByte = oicq.wlogin_sdk.tools.d.decrypt(paramArrayOfByte, paramInt, this.xlb, this.xll.xlp);
      if (paramArrayOfByte == null) {}
      for (paramInt = 64534; paramInt >= 0; paramInt = j)
      {
        return l(this.xlc, this.xla + 1, this.xlb);
        this.xlb = paramArrayOfByte.length;
        if (paramArrayOfByte.length + this.xla + 2 > this.xkW)
        {
          this.xkW = (paramArrayOfByte.length + this.xla + 2);
          byte[] arrayOfByte = new byte[this.xkW];
          System.arraycopy(this.xlc, 0, arrayOfByte, 0, this.xkX);
          this.xlc = arrayOfByte;
        }
        this.xkX = 0;
        System.arraycopy(paramArrayOfByte, 0, this.xlc, paramInt, paramArrayOfByte.length);
        paramInt = this.xkX;
        int k = this.xla;
        this.xkX = (paramArrayOfByte.length + (k + 2) + paramInt);
      }
    }
  }
  
  public final int G(byte[] paramArrayOfByte, int paramInt)
  {
    this.xlk = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte)
  {
    paramInt3 = paramArrayOfByte.length;
    int i = xle + 1;
    xle = i;
    this.xkX = 0;
    util.o(this.xlc, this.xkX, 2);
    this.xkX += 1;
    util.p(this.xlc, this.xkX, this.xkY + 2 + paramInt3);
    this.xkX += 2;
    util.p(this.xlc, this.xkX, paramInt1);
    this.xkX += 2;
    util.p(this.xlc, this.xkX, paramInt2);
    this.xkX += 2;
    util.p(this.xlc, this.xkX, i);
    this.xkX += 2;
    util.q(this.xlc, this.xkX, (int)paramLong);
    this.xkX += 4;
    util.o(this.xlc, this.xkX, 3);
    this.xkX += 1;
    util.o(this.xlc, this.xkX, 0);
    this.xkX += 1;
    util.o(this.xlc, this.xkX, paramInt4);
    this.xkX += 1;
    util.q(this.xlc, this.xkX, paramInt5);
    this.xkX += 4;
    util.q(this.xlc, this.xkX, paramInt6);
    this.xkX += 4;
    util.q(this.xlc, this.xkX, paramInt7);
    this.xkX += 4;
    if (this.xkX + paramInt3 + 1 > this.xkW)
    {
      this.xkW = (this.xkX + paramInt3 + 1 + 128);
      byte[] arrayOfByte = new byte[this.xkW];
      System.arraycopy(this.xlc, 0, arrayOfByte, 0, this.xkX);
      this.xlc = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.xlc, this.xkX, paramInt3);
    this.xkX = (paramInt3 + this.xkX);
    util.o(this.xlc, this.xkX, 3);
    this.xkX += 1;
  }
  
  public final byte[] bJ(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + this.xll.xln.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    System.arraycopy(this.xll.xln, 0, arrayOfByte, paramArrayOfByte.length, this.xll.xln.length);
    return arrayOfByte;
  }
  
  public final byte[] bK(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 16)) {
      return null;
    }
    paramArrayOfByte = (byte[])paramArrayOfByte.clone();
    int i = paramArrayOfByte.length - 16;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    this.xll.xln = new byte[16];
    System.arraycopy(paramArrayOfByte, i, this.xll.xln, 0, 16);
    return arrayOfByte;
  }
  
  public final byte[] cia()
  {
    byte[] arrayOfByte = new byte[this.xkX];
    System.arraycopy(this.xlc, 0, arrayOfByte, 0, this.xkX);
    return arrayOfByte;
  }
  
  public final void cib()
  {
    this.xll.xlL.cih();
  }
  
  final byte[] j(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.p(arrayOfByte, 0, paramInt1);
    util.p(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.b(arrayOfByte, arrayOfByte.length, this.xll.xlp);
    arrayOfByte = new byte[paramArrayOfByte.length + this.xll.xlp.length];
    System.arraycopy(this.xll.xlp, 0, arrayOfByte, 0, this.xll.xlp.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.xll.xlp.length, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public final void k(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ai localai = new ai();
    if (localai.n(paramArrayOfByte, paramInt1, paramInt2) >= 0)
    {
      paramArrayOfByte = this.xll.xlL;
      byte[] arrayOfByte = new byte[localai.xmA];
      System.arraycopy(localai.xlc, localai.xlR + 6, arrayOfByte, 0, localai.xmA);
      paramArrayOfByte.title = new String(arrayOfByte);
      paramArrayOfByte = this.xll.xlL;
      arrayOfByte = new byte[localai.xmB];
      System.arraycopy(localai.xlc, localai.xlR + 8 + localai.xmA, arrayOfByte, 0, localai.xmB);
      paramArrayOfByte.message = new String(arrayOfByte);
      paramArrayOfByte = this.xll.xlL;
      arrayOfByte = new byte[localai.xmC];
      System.arraycopy(localai.xlc, localai.xlR + 12 + localai.xmA + localai.xmB, arrayOfByte, 0, localai.xmC);
      paramArrayOfByte.xmJ = new String(arrayOfByte);
      return;
    }
    this.xll.xlL.cih();
  }
  
  public int l(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    f localf = new f();
    g localg = new g();
    s locals = new s();
    int i;
    if ((this.xli == 2064) && (this.xlj == 9)) {
      i = 0;
    }
    while (paramInt2 < 5)
    {
      return 64527;
      if ((this.xli == 2064) && (this.xlj == 10)) {
        i = 1;
      } else if ((this.xli == 2064) && (this.xlj == 2)) {
        i = 2;
      } else if ((this.xli == 2064) && (this.xlj == 13)) {
        i = 4;
      } else {
        return 64524;
      }
    }
    int j = G(paramArrayOfByte, paramInt1 + 2);
    cib();
    int k = paramInt1 + 5;
    switch (j)
    {
    default: 
      k(paramArrayOfByte, k, this.xkX - k - 1);
      return j;
    case 0: 
      if (i == 1) {
        if (this.xll.xlo == null) {
          return 64530;
        }
      }
      for (paramInt1 = locals.b(paramArrayOfByte, k, this.xkX - k - 1, this.xll.xlo); paramInt1 < 0; paramInt1 = locals.b(paramArrayOfByte, k, this.xkX - k - 1, this.xll.xln))
      {
        util.Wp("119 can not decrypt, ret=" + paramInt1);
        return paramInt1;
      }
      paramInt1 = a(locals);
      if (paramInt1 < 0)
      {
        util.Wp("parse 119 failed, ret=" + paramInt1);
        return paramInt1;
      }
      return 0;
    case 1: 
      k(paramArrayOfByte, k, this.xkX - k - 1);
      return j;
    }
    paramInt2 = localf.n(paramArrayOfByte, k, this.xkX - k - 1);
    paramInt1 = paramInt2;
    if (paramInt2 >= 0)
    {
      this.xll.xlq = localf;
      paramInt2 = localg.n(paramArrayOfByte, k, this.xkX - k - 1);
      paramInt1 = paramInt2;
      if (paramInt2 >= 0)
      {
        this.xll.xlr = localg;
        return j;
      }
    }
    return paramInt1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/request/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */