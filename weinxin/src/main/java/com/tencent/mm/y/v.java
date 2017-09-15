package com.tencent.mm.y;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.b.a;
import oicq.wlogin_sdk.request.i;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class v
{
  private oicq.wlogin_sdk.request.b htJ;
  private long htK;
  
  public v()
  {
    GMTrace.i(13390500069376L, 99767);
    this.htK = 0L;
    this.htJ = null;
    try
    {
      long l = bf.NA();
      this.htJ = new oicq.wlogin_sdk.request.b(aa.getContext(), com.tencent.mm.protocal.d.sXh);
      util.xnb = 1;
      util.xnc = new a();
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WtloginMgr", "dkstart wtlogin init :%d", new Object[] { Long.valueOf(bf.aA(l)) });
      GMTrace.o(13390500069376L, 99767);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.WtloginMgr", localException, "Failed initializing WtloginMgr.", new Object[0]);
      GMTrace.o(13390500069376L, 99767);
    }
  }
  
  public final byte[] R(long paramLong)
  {
    GMTrace.i(13390902722560L, 99770);
    if (paramLong != this.htK)
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.htK), Long.valueOf(paramLong) });
      GMTrace.o(13390902722560L, 99770);
      return new byte[0];
    }
    try
    {
      byte[] arrayOfByte = this.htJ.ff(paramLong);
      GMTrace.o(13390902722560L, 99770);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg e:%s", new Object[] { localException.getMessage() });
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13390902722560L, 99770);
    }
    return new byte[0];
  }
  
  public final byte[] S(long paramLong)
  {
    GMTrace.i(13391171158016L, 99772);
    if (paramLong != this.htK)
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.htK), Long.valueOf(paramLong) });
      GMTrace.o(13391171158016L, 99772);
      return new byte[0];
    }
    for (;;)
    {
      WloginSigInfo localWloginSigInfo;
      try
      {
        localWloginSigInfo = this.htJ.xkG.y(paramLong, 522017402L);
        if (localWloginSigInfo == null)
        {
          Object localObject1 = null;
          if (localObject1 != null) {
            break;
          }
          GMTrace.o(13391171158016L, 99772);
          return new byte[0];
        }
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf e:%s", new Object[] { localException.getMessage() });
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bf.g(localException) });
        GMTrace.o(13391171158016L, 99772);
        return new byte[0];
      }
      localObject2 = new WUserSigInfo();
      ((WUserSigInfo)localObject2).get_clone(localWloginSigInfo);
    }
    Object localObject2 = ((WUserSigInfo)localObject2)._A2;
    GMTrace.o(13391171158016L, 99772);
    return (byte[])localObject2;
  }
  
  public final void T(long paramLong)
  {
    GMTrace.i(13391305375744L, 99773);
    if (paramLong != this.htK)
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.htK), Long.valueOf(paramLong) });
      GMTrace.o(13391305375744L, 99773);
      return;
    }
    try
    {
      this.htJ.fg(paramLong);
      GMTrace.o(13391305375744L, 99773);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo e:%s", new Object[] { localException.getMessage() });
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13391305375744L, 99773);
    }
  }
  
  public final boolean a(long paramLong, byte[] paramArrayOfByte)
  {
    GMTrace.i(13390768504832L, 99769);
    if (paramLong != this.htK)
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.htK), Long.valueOf(paramLong) });
      GMTrace.o(13390768504832L, 99769);
      return false;
    }
    if (bf.bm(paramArrayOfByte))
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf respBuf is null.");
      GMTrace.o(13390768504832L, 99769);
      return false;
    }
    for (;;)
    {
      try
      {
        oicq.wlogin_sdk.request.b localb = this.htJ;
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
          break label306;
        }
        if (localb.xkM == null)
        {
          break label306;
          com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf buflen:%d ret:%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) });
          if (i == 0)
          {
            GMTrace.o(13390768504832L, 99769);
            return true;
          }
        }
        else
        {
          util.Wp("user:" + localb.xkG._uin + " ResolveSvrData ...");
          i = localb.xkM.F(paramArrayOfByte, paramArrayOfByte.length);
          if (i == 1) {
            localb.fg(localb.xkG._uin);
          }
          util.Wp("user:" + localb.xkG._uin + " ResolveSvrData ret=" + i);
          continue;
        }
        GMTrace.o(13390768504832L, 99769);
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf e:%s", new Object[] { paramArrayOfByte.getMessage() });
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bf.g(paramArrayOfByte) });
        GMTrace.o(13390768504832L, 99769);
        return false;
      }
      return false;
      label306:
      int i = 64519;
    }
  }
  
  public final byte[] a(long paramLong, String paramString, boolean paramBoolean)
  {
    GMTrace.i(13390634287104L, 99768);
    if (r.iiC == 10006) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WtloginMgr", "dkwt isTestWtLogin:%b val:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(r.iiD) });
      if (r.iiC != 10006) {
        break label105;
      }
      if (r.iiD != 1) {
        break;
      }
      r.iiD = 0;
      GMTrace.o(13390634287104L, 99768);
      return new byte[0];
    }
    if (r.iiD == 2)
    {
      GMTrace.o(13390634287104L, 99768);
      return new byte[0];
    }
    for (;;)
    {
      try
      {
        label105:
        this.htK = paramLong;
        byte[] arrayOfByte;
        if (paramBoolean)
        {
          arrayOfByte = null;
          if (bf.bm(arrayOfByte)) {
            break label300;
          }
          bool = true;
          com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf sig:%d uin:%d manualauth:%b  byA1Buf:%b ", new Object[] { Integer.valueOf(8256), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
          paramBoolean = bf.bm(arrayOfByte);
          if (!paramBoolean)
          {
            GMTrace.o(13390634287104L, 99768);
            return arrayOfByte;
          }
        }
        else
        {
          arrayOfByte = this.htJ.a(paramLong, b.a.xkS, "");
          continue;
        }
        paramString = this.htJ.a(paramLong, b.a.xkR, new String(bf.PS(paramString), "ISO-8859-1"));
        GMTrace.o(13390634287104L, 99768);
        return paramString;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf e:%s", new Object[] { paramString.getMessage() });
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bf.g(paramString) });
        GMTrace.o(13390634287104L, 99768);
        return new byte[0];
      }
      label300:
      bool = false;
    }
  }
  
  public final byte[] b(long paramLong, String paramString)
  {
    GMTrace.i(13391036940288L, 99771);
    if (paramLong != this.htK)
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.htK), Long.valueOf(paramLong) });
      GMTrace.o(13391036940288L, 99771);
      return new byte[0];
    }
    if (bf.mA(paramString)) {}
    for (paramString = "****".getBytes();; paramString = paramString.getBytes()) {
      try
      {
        paramString = this.htJ.f(paramLong, paramString);
        GMTrace.o(13391036940288L, 99771);
        return paramString;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg e:%s", new Object[] { paramString.getMessage() });
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bf.g(paramString) });
        GMTrace.o(13391036940288L, 99771);
      }
    }
    return new byte[0];
  }
  
  final class a
    extends oicq.wlogin_sdk.tools.b
  {
    public a()
    {
      GMTrace.i(13398284697600L, 99825);
      GMTrace.o(13398284697600L, 99825);
    }
    
    public final void e(int paramInt, String paramString1, String paramString2)
    {
      GMTrace.i(13398553133056L, 99827);
      if (paramInt == 1)
      {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
        GMTrace.o(13398553133056L, 99827);
        return;
      }
      if (paramInt == 2)
      {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
        GMTrace.o(13398553133056L, 99827);
        return;
      }
      if (paramInt == 0) {
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
      }
      GMTrace.o(13398553133056L, 99827);
    }
    
    public final void o(int paramInt, String paramString)
    {
      GMTrace.i(13398418915328L, 99826);
      e(paramInt, "", paramString);
      GMTrace.o(13398418915328L, 99826);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/y/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */