package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.ICallBack;
import com.tencent.mm.a.n;
import com.tencent.mm.a.o;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class ae
  implements StnLogic.ICallBack
{
  private static WakerLock ift;
  private static int ifu;
  private static int ifv;
  private static byte[] ifw;
  private static byte[] ifx;
  
  static
  {
    GMTrace.i(13646453276672L, 101674);
    ift = null;
    ifu = 1000000205;
    ifv = 205;
    GMTrace.o(13646453276672L, 101674);
  }
  
  public ae()
  {
    GMTrace.i(13644305793024L, 101658);
    GMTrace.o(13644305793024L, 101658);
  }
  
  private static int a(ByteArrayOutputStream paramByteArrayOutputStream1, ByteArrayOutputStream paramByteArrayOutputStream2)
  {
    GMTrace.i(13646050623488L, 101671);
    if (z.MP() == null)
    {
      GMTrace.o(13646050623488L, 101671);
      return 0;
    }
    try
    {
      byte[] arrayOfByte = z.MP().My();
      if (arrayOfByte != null)
      {
        paramByteArrayOutputStream1.write(arrayOfByte);
        ifw = arrayOfByte;
      }
      arrayOfByte = z.MP().gXz;
      if (arrayOfByte != null)
      {
        paramByteArrayOutputStream2.write(arrayOfByte);
        ifx = arrayOfByte;
      }
      int i = z.MP().idW.uH();
      GMTrace.o(13646050623488L, 101671);
      return i;
    }
    catch (Exception localException)
    {
      v.e("StnCallBack", exception2String(localException));
      if ((ifw == null) || (ifx == null)) {}
    }
    try
    {
      paramByteArrayOutputStream1.write(ifw);
      paramByteArrayOutputStream2.write(ifx);
      GMTrace.o(13646050623488L, 101671);
      return 0;
    }
    catch (IOException paramByteArrayOutputStream1)
    {
      for (;;) {}
    }
  }
  
  private static String exception2String(Exception paramException)
  {
    GMTrace.i(13644440010752L, 101659);
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    paramException = localStringWriter.toString();
    GMTrace.o(13644440010752L, 101659);
    return paramException;
  }
  
  public final int buf2Resp(int paramInt1, Object paramObject, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt2)
  {
    GMTrace.i(13645111099392L, 101664);
    if (z.MQ() == null)
    {
      GMTrace.o(13645111099392L, 101664);
      return -1;
    }
    try
    {
      paramInt1 = z.MQ().a(paramInt1, paramArrayOfByte, paramArrayOfInt);
      GMTrace.o(13645111099392L, 101664);
      return paramInt1;
    }
    catch (Exception paramObject)
    {
      v.e("StnCallBack", exception2String((Exception)paramObject));
      new StringBuilder().append(paramObject.getClass().getSimpleName()).append(":").append(paramObject.getStackTrace()[0]).append(", ").append(paramObject.getStackTrace()[1]);
      GMTrace.o(13645111099392L, 101664);
    }
    return -1;
  }
  
  public final int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream paramByteArrayOutputStream1, ByteArrayOutputStream paramByteArrayOutputStream2, int[] paramArrayOfInt)
  {
    GMTrace.i(13645647970304L, 101668);
    paramArrayOfInt[0] = ifv;
    paramArrayOfInt[1] = ifu;
    if ((a(paramByteArrayOutputStream1, paramByteArrayOutputStream2) == 0) || (paramByteArrayOutputStream1.size() == 0) || (paramByteArrayOutputStream2.size() == 0))
    {
      requestDoSync();
      i = StnLogic.ECHECK_NEXT;
      GMTrace.o(13645647970304L, 101668);
      return i;
    }
    int i = StnLogic.ECHECK_NOW;
    GMTrace.o(13645647970304L, 101668);
    return i;
  }
  
  public final boolean isLogoned()
  {
    GMTrace.i(13646319058944L, 101673);
    if (z.MP() == null)
    {
      GMTrace.o(13646319058944L, 101673);
      return false;
    }
    try
    {
      boolean bool = z.MP().idW.BY();
      GMTrace.o(13646319058944L, 101673);
      return bool;
    }
    catch (Exception localException)
    {
      v.e("StnCallBack", exception2String(localException));
      new StringBuilder().append(localException.getClass().getSimpleName()).append(":").append(localException.getStackTrace()[0]).append(", ").append(localException.getStackTrace()[1]);
      GMTrace.o(13646319058944L, 101673);
    }
    return false;
  }
  
  public final boolean makesureAuthed()
  {
    GMTrace.i(13644574228480L, 101660);
    if (z.MP() == null)
    {
      GMTrace.o(13644574228480L, 101660);
      return false;
    }
    try
    {
      boolean bool = z.MP().Mx();
      GMTrace.o(13644574228480L, 101660);
      return bool;
    }
    catch (Exception localException)
    {
      v.e("StnCallBack", exception2String(localException));
      new StringBuilder().append(localException.getClass().getSimpleName()).append(":").append(localException.getStackTrace()[0]).append(", ").append(localException.getStackTrace()[1]);
      GMTrace.o(13644574228480L, 101660);
    }
    return false;
  }
  
  public final boolean onLongLinkIdentifyResp(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    GMTrace.i(13645782188032L, 101669);
    ByteArrayOutputStream localByteArrayOutputStream;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null)) {
      localByteArrayOutputStream = new ByteArrayOutputStream();
    }
    try
    {
      localByteArrayOutputStream.write(paramArrayOfByte1);
      localByteArrayOutputStream.write(paramArrayOfByte2);
      onPush(ifu, localByteArrayOutputStream.toByteArray());
      GMTrace.o(13645782188032L, 101669);
      return true;
    }
    catch (IOException paramArrayOfByte1)
    {
      for (;;) {}
    }
  }
  
  public final String[] onNewDns(String paramString)
  {
    GMTrace.i(13644708446208L, 101661);
    GMTrace.o(13644708446208L, 101661);
    return new String[0];
  }
  
  public final void onPush(final int paramInt, final byte[] paramArrayOfByte)
  {
    GMTrace.i(13644842663936L, 101662);
    if (z.MR() == null)
    {
      GMTrace.o(13644842663936L, 101662);
      return;
    }
    try
    {
      if (ift == null) {
        ift = new WakerLock(z.getContext());
      }
      ift.lock(1000L, "StnLogic.onNotify");
      z.MN().post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13692489957376L, 102017);
          z.MR().onPush(paramInt, paramArrayOfByte);
          GMTrace.o(13692489957376L, 102017);
        }
      });
      GMTrace.o(13644842663936L, 101662);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      v.e("StnCallBack", exception2String(paramArrayOfByte));
      new StringBuilder().append(paramArrayOfByte.getClass().getSimpleName()).append(":").append(paramArrayOfByte.getStackTrace()[0]).append(", ").append(paramArrayOfByte.getStackTrace()[1]);
      GMTrace.o(13644842663936L, 101662);
    }
  }
  
  public final int onTaskEnd(final int paramInt1, final Object paramObject, final int paramInt2, final int paramInt3)
  {
    GMTrace.i(13645245317120L, 101665);
    if (z.MQ() == null)
    {
      GMTrace.o(13645245317120L, 101665);
      return 0;
    }
    i = 0;
    try
    {
      j = z.MQ().gV(paramInt1);
      i = j;
      z.MN().post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13712891052032L, 102169);
          y localy = z.MQ();
          int i1 = paramInt1;
          int j = paramInt2;
          int m = paramInt3;
          int n = -1;
          for (;;)
          {
            int i2;
            int i;
            int k;
            q localq;
            k localk;
            synchronized (localy.ieR)
            {
              i2 = localy.gW(i1);
              if (-1 == i2)
              {
                v.e("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onGYNetEnd GET FROM QUEUE failed. native:[%d,%d] taskId:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i1) });
                GMTrace.o(13712891052032L, 102169);
                return;
              }
              i = 0;
              long l;
              switch (j)
              {
              default: 
                v.f("MicroMsg.MMNativeNetTaskAdapter", "c2JavaErrorType not exits c_errType:%d", new Object[] { Integer.valueOf(j) });
                break label2053;
                k = i;
                j = m;
                if (!z.ML().ifj)
                {
                  k = i;
                  j = m;
                  if (i == 1)
                  {
                    v.i("MicroMsg.MMNativeNetTaskAdapter", "network not available");
                    k = 2;
                    j = -1;
                  }
                }
                localq = localy.ieR[i2].ieV;
                localk = localy.ieR[i2].ieW;
                l = localy.ieR[i2].startTime;
                localy.ieR[i2] = null;
                if (k == 0) {
                  i = k;
                }
                break;
              case 0: 
              case 1: 
              case 2: 
              case 3: 
              case 4: 
              case 5: 
              case 6: 
              case 7: 
              case 8: 
              case 9: 
                try
                {
                  if (localq.Cn().Cq() == 0) {
                    break;
                  }
                  i = 4;
                  k = localq.Cn().Cq();
                  j = 4;
                  i = k;
                }
                catch (RemoteException localRemoteException5)
                {
                  s locals;
                  byte[] arrayOfByte;
                  h localh;
                  k = n;
                  continue;
                }
                try
                {
                  k = localq.getType();
                  try
                  {
                    locals = z.MP();
                    arrayOfByte = localq.Cn().BX();
                    try
                    {
                      v.d("MicroMsg.AutoAuth", "summerauth onGYNetEnd threadId: 0" + " errType: " + j + " errCode: " + i + " errMsg: " + null + " rr: " + localq + " type: " + localq.getType() + " netIdGetCertBeforeAutoAuth: " + locals.iea);
                      if (i == 0) {
                        continue;
                      }
                      locals.idR += 1;
                      localh = localq.Cn();
                      m = localq.getType();
                      switch (m)
                      {
                      }
                    }
                    catch (RemoteException localRemoteException1)
                    {
                      v.e("MicroMsg.AutoAuth", "exception:%s", new Object[] { bf.g(localRemoteException1) });
                      continue;
                    }
                    m = localq.BM();
                    v.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onTaskEnd type:%d time:%d hash[%d,%d] [%d,%d]", new Object[] { Integer.valueOf(k), Long.valueOf(bf.aA(l)), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) });
                    if ((4 == j) && ((-1 == i) || (-2 == i) || (-24 == i) || (-34 == i))) {
                      z.MN().post(new y.1(localy, k, i));
                    }
                    try
                    {
                      String str1 = localq.Cn().Cp();
                      if ((str1 == null) || (str1.length() <= 0)) {
                        break label1978;
                      }
                      localk.a(i2, j, i, str1, localq, localq.Cn().BX());
                      GMTrace.o(13712891052032L, 102169);
                      return;
                    }
                    catch (Exception localException)
                    {
                      v.e("MicroMsg.MMNativeNetTaskAdapter", "onGYNetEnd cb %s", new Object[] { localException.getMessage() });
                      v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", new Object[] { bf.g(localException), Integer.valueOf(i1) });
                      GMTrace.o(13712891052032L, 102169);
                      return;
                    }
                    i = 0;
                  }
                  catch (RemoteException localRemoteException2)
                  {
                    m = j;
                    j = i;
                    i = m;
                  }
                  i = 2;
                }
                catch (RemoteException localRemoteException6)
                {
                  m = i;
                  k = n;
                  i = j;
                  j = m;
                  continue;
                  m = j;
                  n = i;
                  break label1941;
                }
                i = 2;
                break label2053;
                i = 1;
                break label2053;
                i = 1;
                break label2053;
                i = 1;
                break label2053;
                i = 1;
                break label2053;
                if ((62534 == m) || (62533 == m))
                {
                  i = 4;
                }
                else if (55535 == m)
                {
                  i = 6;
                }
                else
                {
                  i = 5;
                  break label2053;
                  i = 4;
                  break label2053;
                  i = 1;
                  break label2053;
                  if (localq.getType() == 10) {
                    continue;
                  }
                  locals.idR = 0;
                  continue;
                  v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", new Object[] { bf.g(localRemoteException2), Integer.valueOf(i1) });
                  m = 0;
                  n = j;
                  j = i;
                  i = n;
                  continue;
                  v.i("MicroMsg.AutoAuth", "summerauth end type: %d, ret:[%d,%d][%s]", new Object[] { Integer.valueOf(localq.getType()), Integer.valueOf(j), Integer.valueOf(i), null });
                  if ((localh.Cq() != 0) || (j != 0) || (i != 0)) {
                    if (localq.getType() == 126) {
                      v.e("MicroMsg.AutoAuth", "net.end: reg err: type=" + localq.getType() + " err=" + j + "," + i + " errmsg=" + null);
                    }
                  }
                }
                break;
              }
            }
            switch (i)
            {
            default: 
              break;
            case -213: 
            case -205: 
            case -100: 
              com.tencent.mm.sdk.platformtools.aa.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
              if (i == 65323)
              {
                c.oRz.a(148L, 31L, 1L, false);
              }
              else if (i == -100)
              {
                c.oRz.a(148L, 32L, 1L, false);
              }
              else if (i == 65331)
              {
                c.oRz.a(148L, 33L, 1L, false);
                continue;
                m = localq.Co();
                v.i("MicroMsg.AutoAuth", "summerauth accinfo doAuthEnd type:%d, ret:%d loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(localq.getType()), Integer.valueOf(m), Integer.valueOf(locals.hSe) });
                String str2;
                Object localObject3;
                if (m == 2)
                {
                  if (localq.getType() == 702)
                  {
                    c.oRz.a(148L, 34L, 1L, false);
                    locals.hSe += 1;
                    if (locals.hSe > 1)
                    {
                      v.w("MicroMsg.AutoAuth", "summerauth loginDecodeFailedTry beyond 1 no more try!");
                      locals.c(j, i, "auth_decode_failed_" + bf.ap(null, ""));
                    }
                    else
                    {
                      for (;;)
                      {
                        try
                        {
                          m = localh.uH();
                          Object localObject2 = localh.Cr();
                          if (bf.bm((byte[])localObject2))
                          {
                            localObject2 = "";
                            if (!bf.bm(arrayOfByte)) {
                              break label1475;
                            }
                            str2 = "";
                            if (!locals.e((String)localObject2, str2, m)) {
                              break label1485;
                            }
                            locals.idW.htw = arrayOfByte;
                            localq.a(locals.idX, 0, 0);
                          }
                        }
                        catch (RemoteException localRemoteException3)
                        {
                          v.printErrStackTrace("MicroMsg.AutoAuth", localRemoteException3, "summerauth save serverid aak failed 1 cookie:" + bf.bo(arrayOfByte), new Object[0]);
                          v.bIF();
                          throw localRemoteException3;
                        }
                        localObject3 = bf.bo(localRemoteException3);
                        continue;
                        label1475:
                        str2 = bf.bo(arrayOfByte);
                        continue;
                        label1485:
                        v.w("MicroMsg.AutoAuth", "summerauth save serverid aak failed 1");
                      }
                    }
                  }
                }
                else
                {
                  locals.hSe = 0;
                  g localg = localq.Cm();
                  try
                  {
                    v.i("MicroMsg.AutoAuth", "summerauth accinfo %d: username:%s, wxusername:%s, ticket:%s, session:%s, uin:%d", new Object[] { Integer.valueOf(localq.getType()), localg.getUserName(), localh.Cv(), bf.Qi(bf.bl(localh.Cr())), bf.Qi(bf.bl(localh.vc())), Integer.valueOf(localh.uH()) });
                    m = localh.uH();
                    localObject3 = localh.Cr();
                    if (bf.bm((byte[])localObject3))
                    {
                      localObject3 = "";
                      label1633:
                      if (!bf.bm(arrayOfByte)) {
                        break label1769;
                      }
                      str2 = "";
                      label1646:
                      if (!locals.e((String)localObject3, str2, m)) {
                        break label1779;
                      }
                      locals.idW.htw = arrayOfByte;
                      locals.idW.username = localg.getUserName();
                      locals.idW.idH = localh.Cv();
                      locals.idW.i(localh.vc(), localh.uH());
                      locals.idW.idG = localh.BZ();
                      o.getString(localh.uH());
                    }
                    for (;;)
                    {
                      v.i("MicroMsg.AutoAuth", "summerauth decode and save ok!");
                      break;
                      localObject3 = bf.bo((byte[])localObject3);
                      break label1633;
                      label1769:
                      str2 = bf.bo(arrayOfByte);
                      break label1646;
                      label1779:
                      c.oRz.a(148L, 35L, 1L, false);
                      v.w("MicroMsg.AutoAuth", "summerauth save serverid aak failed 2");
                    }
                    if (j != 0) {
                      break label1899;
                    }
                  }
                  catch (RemoteException localRemoteException4)
                  {
                    v.printErrStackTrace("MicroMsg.AutoAuth", localRemoteException4, "summerauth save serverid aak failed 2 cookie:" + bf.bo(arrayOfByte), new Object[0]);
                    v.bIF();
                    throw localRemoteException4;
                  }
                  if (i == 0)
                  {
                    ac.G(localq.Cn().Cs(), localq.Cn().Ct(), localq.Cn().Cu());
                    locals.idZ = SystemClock.elapsedRealtime();
                  }
                  label1899:
                  if ((r.iiC == 10003) && (r.iiD > 0))
                  {
                    if (r.iiD <= 1) {
                      r.iiD = 0;
                    }
                    m = 4;
                    n = 0;
                    ac.G("", "", 0);
                    label1941:
                    if (locals.iea != -1)
                    {
                      if ((m == 0) && (n == 0)) {
                        locals.a(localq, 0, 0);
                      }
                      locals.iea = -1;
                      continue;
                      label1978:
                      localk.a(i2, j, i, null, localq, localq.Cn().BX());
                      GMTrace.o(13712891052032L, 102169);
                    }
                  }
                  else
                  {
                    i = j;
                    j = k;
                    continue;
                    label2053:
                    if (i == 0) {
                      m = 0;
                    }
                    if (i == 3) {
                      m = -1;
                    }
                  }
                }
              }
              break;
            }
          }
        }
      });
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        v.e("StnCallBack", exception2String((Exception)paramObject));
        new StringBuilder().append(paramObject.getClass().getSimpleName()).append(":").append(paramObject.getStackTrace()[0]).append(", ").append(paramObject.getStackTrace()[1]);
        int j = i;
      }
    }
    GMTrace.o(13645245317120L, 101665);
    return j;
  }
  
  public final void reportConnectInfo(int paramInt1, int paramInt2)
  {
    GMTrace.i(13645513752576L, 101667);
    try
    {
      z.MM().gX(paramInt1);
      GMTrace.o(13645513752576L, 101667);
      return;
    }
    catch (Exception localException)
    {
      v.e("StnCallBack", "reportConnectInfo :%s", new Object[] { bf.g(localException) });
      GMTrace.o(13645513752576L, 101667);
    }
  }
  
  public final boolean req2Buf(int paramInt1, Object paramObject, ByteArrayOutputStream paramByteArrayOutputStream, int[] paramArrayOfInt, int paramInt2)
  {
    GMTrace.i(13644976881664L, 101663);
    if (z.MQ() == null)
    {
      GMTrace.o(13644976881664L, 101663);
      return false;
    }
    try
    {
      boolean bool = z.MQ().a(paramInt1, paramByteArrayOutputStream, paramArrayOfInt, paramInt2);
      GMTrace.o(13644976881664L, 101663);
      return bool;
    }
    catch (Exception paramObject)
    {
      v.e("StnCallBack", exception2String((Exception)paramObject));
      new StringBuilder().append(paramObject.getClass().getSimpleName()).append(":").append(paramObject.getStackTrace()[0]).append(", ").append(paramObject.getStackTrace()[1]);
      GMTrace.o(13644976881664L, 101663);
    }
    return false;
  }
  
  public final void requestDoSync()
  {
    GMTrace.i(13646184841216L, 101672);
    if (z.MR() == null)
    {
      GMTrace.o(13646184841216L, 101672);
      return;
    }
    try
    {
      z.MN().post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13699603496960L, 102070);
          z.MR().onPush(24, n.cP(7));
          GMTrace.o(13699603496960L, 102070);
        }
      });
      GMTrace.o(13646184841216L, 101672);
      return;
    }
    catch (Exception localException)
    {
      v.e("StnCallBack", exception2String(localException));
      new StringBuilder().append(localException.getClass().getSimpleName()).append(":").append(localException.getStackTrace()[0]).append(", ").append(localException.getStackTrace()[1]);
      GMTrace.o(13646184841216L, 101672);
    }
  }
  
  public final String[] requestNetCheckShortLinkHosts()
  {
    GMTrace.i(13645916405760L, 101670);
    GMTrace.o(13645916405760L, 101670);
    return new String[0];
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */