package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.aa;
import oicq.wlogin_sdk.a.ae;
import oicq.wlogin_sdk.a.ag;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.aj;
import oicq.wlogin_sdk.a.an;
import oicq.wlogin_sdk.a.b;
import oicq.wlogin_sdk.a.c;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.k;
import oicq.wlogin_sdk.a.r;
import oicq.wlogin_sdk.a.y;
import oicq.wlogin_sdk.tools.util;

public final class j
  extends d
{
  public j(i parami)
  {
    this.xli = 2064;
    this.xlj = 9;
    this.xll = parami;
  }
  
  public final byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte3)
  {
    paramInt3 = this.xll.xlv;
    this.xll._uin = paramLong2;
    byte[] arrayOfByte3 = super.bK(paramArrayOfByte2);
    if (arrayOfByte3 == null) {
      return null;
    }
    byte[] arrayOfByte4 = this.xll.xlw;
    byte[] arrayOfByte1 = this.xll.xlq.cid();
    byte[] arrayOfByte2 = this.xll.xlA;
    Object localObject1 = new an();
    Object localObject2 = new b();
    Object localObject6 = new h();
    Object localObject5 = new r();
    Object localObject3 = new c();
    Object localObject4 = new oicq.wlogin_sdk.a.i();
    Object localObject8 = new oicq.wlogin_sdk.a.j();
    Object localObject7 = new k();
    f localf = new f();
    y localy = new y();
    aa localaa = new aa();
    ae localae = new ae();
    ag localag = new ag();
    paramArrayOfByte2 = new ah();
    aj localaj = new aj();
    localObject1 = ((an)localObject1).a(522017402L, paramInt3, paramLong2, 0);
    localObject2 = ((b)localObject2).g(paramLong2, paramArrayOfByte1);
    this.xll.xlM = super.bJ(arrayOfByte3);
    int i = arrayOfByte3.length;
    if (((a)localObject6).xlR + i > ((a)localObject6).xkW)
    {
      ((a)localObject6).xkW = (((a)localObject6).xlR + i + 128);
      paramArrayOfByte1 = new byte[((a)localObject6).xkW];
      System.arraycopy(((a)localObject6).xlc, 0, paramArrayOfByte1, 0, ((a)localObject6).xlR);
      ((a)localObject6).xlc = paramArrayOfByte1;
    }
    ((a)localObject6).xkX = (((a)localObject6).xlR + i);
    System.arraycopy(arrayOfByte3, 0, ((a)localObject6).xlc, ((a)localObject6).xlR, i);
    ((a)localObject6).xlS = i;
    util.p(((a)localObject6).xlc, 0, ((a)localObject6).xli);
    util.p(((a)localObject6).xlc, 2, ((a)localObject6).xlS);
    arrayOfByte3 = ((a)localObject6).cia();
    util.fp("req2 a1:", util.bU(arrayOfByte3));
    localObject3 = ((c)localObject3).a(522017402L, 1L, paramInt3, 8256);
    localObject4 = ((oicq.wlogin_sdk.a.i)localObject4).x(0, 1, 102400, 1);
    localObject5 = ((r)localObject5).a(paramInt1, paramInt2, null);
    localObject6 = paramArrayOfByte2.bQ(this.xll.xlw);
    paramInt1 = 7;
    paramArrayOfByte1 = new byte[0];
    paramArrayOfByte2 = new byte[0];
    if (paramArrayOfByte3.length > 0)
    {
      paramArrayOfByte1 = ((oicq.wlogin_sdk.a.j)localObject8).bN(paramArrayOfByte3);
      paramInt1 = 8;
    }
    if (arrayOfByte4.length > 0) {
      paramArrayOfByte2 = ((k)localObject7).bO(arrayOfByte4);
    }
    paramArrayOfByte3 = util.cii();
    arrayOfByte4 = util.cij();
    paramInt2 = this.xll.xlz;
    localObject7 = this.xll.xly;
    localObject8 = this.xll.xlB;
    paramArrayOfByte3 = localag.a(paramArrayOfByte2, localy.a(paramArrayOfByte3, arrayOfByte4, paramInt2, (byte[])localObject7, new byte[0], (byte[])localObject8), localaa.a(this.xll.xlH, this.xll.xlI, this.xll.xlJ, this.xll.xlF, this.xll.xlw), localaj.a(522017402L, this.xll.xlD, this.xll.xlE), this.xll.xln);
    arrayOfByte2 = localae.bP(arrayOfByte2);
    paramInt1 = paramInt1 + 1 + 1;
    if (arrayOfByte1.length > 0)
    {
      paramArrayOfByte2 = localf.bM(arrayOfByte1);
      paramInt1 += 1;
    }
    for (;;)
    {
      arrayOfByte1 = new byte[localObject1.length + localObject2.length + arrayOfByte3.length + localObject5.length + localObject3.length + localObject4.length + paramArrayOfByte1.length + paramArrayOfByte3.length + paramArrayOfByte2.length + arrayOfByte2.length + 0 + localObject6.length];
      System.arraycopy(localObject1, 0, arrayOfByte1, 0, localObject1.length);
      paramInt2 = localObject1.length + 0;
      System.arraycopy(localObject2, 0, arrayOfByte1, paramInt2, localObject2.length);
      paramInt2 += localObject2.length;
      System.arraycopy(arrayOfByte3, 0, arrayOfByte1, paramInt2, arrayOfByte3.length);
      paramInt2 += arrayOfByte3.length;
      System.arraycopy(localObject5, 0, arrayOfByte1, paramInt2, localObject5.length);
      paramInt2 += localObject5.length;
      System.arraycopy(localObject3, 0, arrayOfByte1, paramInt2, localObject3.length);
      paramInt2 += localObject3.length;
      System.arraycopy(localObject4, 0, arrayOfByte1, paramInt2, localObject4.length);
      paramInt2 += localObject4.length;
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte1, paramInt2, paramArrayOfByte1.length);
      paramInt2 = paramArrayOfByte1.length + paramInt2;
      System.arraycopy(paramArrayOfByte3, 0, arrayOfByte1, paramInt2, paramArrayOfByte3.length);
      paramInt2 += paramArrayOfByte3.length;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt2, arrayOfByte2.length);
      paramInt2 += arrayOfByte2.length;
      System.arraycopy(new byte[0], 0, arrayOfByte1, paramInt2, 0);
      paramInt2 += 0;
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte1, paramInt2, paramArrayOfByte2.length);
      System.arraycopy(localObject6, 0, arrayOfByte1, paramInt2 + paramArrayOfByte2.length, localObject6.length);
      paramArrayOfByte1 = super.j(arrayOfByte1, this.xlj, paramInt1);
      a(this.xld, this.xli, xle, paramLong2, this.xlf, this.xlg, paramInt3, this.xlh, paramArrayOfByte1);
      return super.cia();
      paramArrayOfByte2 = new byte[0];
    }
  }
  
  public final byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte4)
  {
    paramInt3 = this.xll.xlv;
    this.xll._uin = paramLong2;
    util.fp("IMEI", util.bU(this.xll.xlw));
    byte[] arrayOfByte4 = this.xll.xln;
    byte[] arrayOfByte3 = this.xll.xlw;
    byte[] arrayOfByte1 = this.xll.xlq.cid();
    byte[] arrayOfByte2 = this.xll.xlA;
    Object localObject1 = new an();
    Object localObject2 = new b();
    Object localObject3 = new h();
    Object localObject5 = new r();
    c localc = new c();
    Object localObject4 = new oicq.wlogin_sdk.a.i();
    Object localObject8 = new oicq.wlogin_sdk.a.j();
    Object localObject6 = new k();
    f localf = new f();
    y localy = new y();
    aa localaa = new aa();
    ae localae = new ae();
    ag localag = new ag();
    Object localObject7 = new ah();
    aj localaj = new aj();
    localObject1 = ((an)localObject1).a(522017402L, paramInt3, paramLong2, 0);
    localObject2 = ((b)localObject2).g(paramLong2, paramArrayOfByte1);
    paramArrayOfByte3 = ((h)localObject3).a(522017402L, paramInt3, paramLong2, paramArrayOfByte2, paramArrayOfByte1, paramArrayOfByte3, arrayOfByte4, this.xll.xlI, this.xll.xlw);
    this.xll.xlM = super.bJ(((a)localObject3).cid());
    localObject3 = localc.a(522017402L, 1L, paramInt3, 8256);
    localObject4 = ((oicq.wlogin_sdk.a.i)localObject4).x(0, 1, 102400, 1);
    localObject5 = ((r)localObject5).a(paramInt1, paramInt2, null);
    localObject7 = ((ah)localObject7).bQ(this.xll.xlw);
    paramInt1 = 7;
    paramArrayOfByte1 = new byte[0];
    paramArrayOfByte2 = new byte[0];
    if (paramArrayOfByte4.length > 0)
    {
      paramArrayOfByte1 = ((oicq.wlogin_sdk.a.j)localObject8).bN(paramArrayOfByte4);
      paramInt1 = 8;
    }
    if (arrayOfByte3.length > 0) {
      paramArrayOfByte2 = ((k)localObject6).bO(arrayOfByte3);
    }
    paramArrayOfByte4 = util.cii();
    arrayOfByte3 = util.cij();
    paramInt2 = this.xll.xlz;
    localObject6 = this.xll.xly;
    localObject8 = this.xll.xlB;
    paramArrayOfByte4 = localag.a(paramArrayOfByte2, localy.a(paramArrayOfByte4, arrayOfByte3, paramInt2, (byte[])localObject6, new byte[0], (byte[])localObject8), localaa.a(this.xll.xlH, this.xll.xlI, this.xll.xlJ, this.xll.xlF, this.xll.xlw), localaj.a(522017402L, this.xll.xlD, this.xll.xlE), this.xll.xln);
    arrayOfByte2 = localae.bP(arrayOfByte2);
    paramInt1 = paramInt1 + 1 + 1;
    if (arrayOfByte1.length > 0)
    {
      paramArrayOfByte2 = localf.bM(arrayOfByte1);
      paramInt1 += 1;
    }
    for (;;)
    {
      arrayOfByte1 = new byte[localObject1.length + localObject2.length + paramArrayOfByte3.length + localObject5.length + localObject3.length + localObject4.length + paramArrayOfByte1.length + paramArrayOfByte4.length + paramArrayOfByte2.length + arrayOfByte2.length + 0 + localObject7.length];
      System.arraycopy(localObject1, 0, arrayOfByte1, 0, localObject1.length);
      paramInt2 = localObject1.length + 0;
      System.arraycopy(localObject2, 0, arrayOfByte1, paramInt2, localObject2.length);
      paramInt2 += localObject2.length;
      System.arraycopy(paramArrayOfByte3, 0, arrayOfByte1, paramInt2, paramArrayOfByte3.length);
      paramInt2 += paramArrayOfByte3.length;
      System.arraycopy(localObject5, 0, arrayOfByte1, paramInt2, localObject5.length);
      paramInt2 += localObject5.length;
      System.arraycopy(localObject3, 0, arrayOfByte1, paramInt2, localObject3.length);
      paramInt2 += localObject3.length;
      System.arraycopy(localObject4, 0, arrayOfByte1, paramInt2, localObject4.length);
      paramInt2 += localObject4.length;
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte1, paramInt2, paramArrayOfByte1.length);
      paramInt2 = paramArrayOfByte1.length + paramInt2;
      System.arraycopy(paramArrayOfByte4, 0, arrayOfByte1, paramInt2, paramArrayOfByte4.length);
      paramInt2 += paramArrayOfByte4.length;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt2, arrayOfByte2.length);
      paramInt2 += arrayOfByte2.length;
      System.arraycopy(new byte[0], 0, arrayOfByte1, paramInt2, 0);
      paramInt2 += 0;
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte1, paramInt2, paramArrayOfByte2.length);
      System.arraycopy(localObject7, 0, arrayOfByte1, paramArrayOfByte2.length + paramInt2, localObject7.length);
      paramArrayOfByte1 = super.j(arrayOfByte1, this.xlj, paramInt1);
      a(this.xld, this.xli, xle, paramLong2, this.xlf, this.xlg, paramInt3, this.xlh, paramArrayOfByte1);
      return super.cia();
      paramArrayOfByte2 = new byte[0];
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/request/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */