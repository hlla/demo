package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.gx;
import com.tencent.mm.e.a.pi;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelmulti.d;
import com.tencent.mm.network.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.anr;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w;

public final class f
{
  private static void D(long paramLong)
  {
    GMTrace.i(13468614787072L, 100349);
    v.i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = " + paramLong);
    if ((0x100 & paramLong) != 0L)
    {
      pi localpi = new pi();
      a.uql.m(localpi);
    }
    if ((0xFFFFFFFFFFFFFEFF & paramLong & 0x2) != 0L) {
      new d().a(z.MP(), new com.tencent.mm.y.e()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.y.k paramAnonymousk)
        {
          GMTrace.i(13455998320640L, 100255);
          v.i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          GMTrace.o(13455998320640L, 100255);
        }
      });
    }
    GMTrace.o(13468614787072L, 100349);
  }
  
  public static boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    GMTrace.i(13468480569344L, 100348);
    v.i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      D(2L);
      GMTrace.o(13468480569344L, 100348);
      return true;
    }
    if (paramInt1 != 2)
    {
      GMTrace.o(13468480569344L, 100348);
      return false;
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      GMTrace.o(13468480569344L, 100348);
      return true;
      D(7L);
      continue;
      if ((bf.bm(paramArrayOfByte1)) || (paramArrayOfByte1.length <= 8))
      {
        v.e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
      }
      else
      {
        paramInt1 = com.tencent.mm.a.n.c(paramArrayOfByte1, 0);
        paramInt2 = com.tencent.mm.a.n.c(paramArrayOfByte1, 4);
        v.d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + paramInt1 + " bufLen:" + paramInt2 + " dump:" + bf.A(paramArrayOfByte1, 8));
        if (paramInt2 != paramArrayOfByte1.length - 8)
        {
          v.e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + paramArrayOfByte1.length);
        }
        else
        {
          byte[] arrayOfByte = new byte[paramInt2];
          System.arraycopy(paramArrayOfByte1, 8, arrayOfByte, 0, paramInt2);
          w.b localb = new w.b();
          PByteArray localPByteArray2 = new PByteArray();
          PByteArray localPByteArray1 = new PByteArray();
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          paramArrayOfByte1 = new PInt(0);
          boolean bool1;
          try
          {
            bool1 = MMProtocalJni.unpack(localPByteArray1, arrayOfByte, paramArrayOfByte2, localPByteArray2, localPInt1, localPInt2, paramArrayOfByte1);
            if (paramArrayOfByte1.value != 0)
            {
              paramArrayOfByte2 = new gx();
              paramArrayOfByte2.fMb.fMc = paramArrayOfByte1.value;
              boolean bool2 = a.uql.m(paramArrayOfByte2);
              v.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(paramArrayOfByte1.value), Boolean.valueOf(bool2) });
              paramArrayOfByte1.value = 0;
            }
            if (!bool1) {
              v.e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
            }
          }
          catch (Exception paramArrayOfByte2)
          {
            v.e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", new Object[] { paramArrayOfByte2 });
            v.printErrStackTrace("MicroMsg.NotifySyncMgr", paramArrayOfByte2, "", new Object[0]);
          }
          while (paramArrayOfByte1.value != 0)
          {
            paramArrayOfByte2 = new gx();
            paramArrayOfByte2.fMb.fMc = paramArrayOfByte1.value;
            bool1 = a.uql.m(paramArrayOfByte2);
            v.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(paramArrayOfByte1.value), Boolean.valueOf(bool1) });
            paramArrayOfByte1.value = 0;
            break;
            if (localPInt1.value == -13)
            {
              localb.sXW = localPInt1.value;
              v.e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
              break;
            }
            paramInt2 = localb.y(localPByteArray1.value);
            v.d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
            localb.sXW = paramInt2;
            localb.sXV = arrayOfByte.length;
            paramArrayOfByte2 = bf.PS(aa.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
            arrayOfByte = com.tencent.mm.platformtools.n.a(localb.sYx.tmv);
            if ((bf.bm(arrayOfByte)) || (!ad.h(paramArrayOfByte2, arrayOfByte)))
            {
              v.e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
              break;
            }
            new d(localb, paramInt1, paramLong).a(z.MP(), new com.tencent.mm.y.e()
            {
              public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.y.k paramAnonymousk)
              {
                GMTrace.i(13463380295680L, 100310);
                v.i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                GMTrace.o(13463380295680L, 100310);
              }
            });
          }
          if (paramArrayOfByte1 == null) {}
          for (paramLong = 7L;; paramLong = com.tencent.mm.a.n.c(paramArrayOfByte1, 0))
          {
            D(paramLong);
            break;
          }
          paramArrayOfByte2 = new aa.b();
          try
          {
            paramArrayOfByte2.y(paramArrayOfByte1);
            D(paramArrayOfByte2.sYC);
          }
          catch (Exception paramArrayOfByte1)
          {
            v.printErrStackTrace("MicroMsg.NotifySyncMgr", paramArrayOfByte1, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public static byte[] a(PInt paramPInt, int paramInt)
  {
    GMTrace.i(13468749004800L, 100350);
    String str = dM(paramInt);
    int j = cU(str);
    int i = 1;
    while (i <= j)
    {
      Object localObject3 = str + "/syncResp.bin" + i;
      if (com.tencent.mm.a.e.aO((String)localObject3))
      {
        Object localObject2 = com.tencent.mm.a.e.d((String)localObject3, 0, -1);
        Object localObject1 = localObject2;
        if (bf.bm((byte[])localObject2))
        {
          v.w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
          localObject1 = com.tencent.mm.a.e.d((String)localObject3, 0, -1);
        }
        localObject2 = g.n((p.rA() + paramInt).getBytes());
        localObject3 = com.tencent.mm.a.k.a((byte[])localObject1, ((String)localObject2).getBytes());
        v.i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), v((byte[])localObject1), v((byte[])localObject3), v(((String)localObject2).getBytes()) });
        if (!bf.bm((byte[])localObject3))
        {
          paramPInt.value = i;
          GMTrace.o(13468749004800L, 100350);
          return (byte[])localObject3;
        }
      }
      i += 1;
    }
    GMTrace.o(13468749004800L, 100350);
    return null;
  }
  
  public static void ay(int paramInt1, int paramInt2)
  {
    GMTrace.i(13468883222528L, 100351);
    String str = dM(paramInt2);
    paramInt2 = cU(str);
    b.deleteFile(str + "/syncResp.bin" + paramInt1);
    v.i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == paramInt2)
    {
      b.deleteFile(str + "/syncResp.ini");
      v.i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
    }
    GMTrace.o(13468883222528L, 100351);
  }
  
  public static int cU(String paramString)
  {
    GMTrace.i(13469017440256L, 100352);
    paramString = com.tencent.mm.a.e.d(paramString + "/syncResp.ini", 0, -1);
    if (bf.bm(paramString))
    {
      GMTrace.o(13469017440256L, 100352);
      return 0;
    }
    try
    {
      int i = Integer.parseInt(new String(paramString));
      GMTrace.o(13469017440256L, 100352);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      GMTrace.o(13469017440256L, 100352);
    }
    return 0;
  }
  
  public static String dM(int paramInt)
  {
    GMTrace.i(13469151657984L, 100353);
    String str = g.n(("mm" + paramInt).getBytes());
    str = w.hgg + str + "/pushSyncResp";
    com.tencent.mm.a.e.aS(str);
    GMTrace.o(13469151657984L, 100353);
    return str;
  }
  
  public static String v(byte[] paramArrayOfByte)
  {
    GMTrace.i(13469285875712L, 100354);
    if (bf.bm(paramArrayOfByte))
    {
      GMTrace.o(13469285875712L, 100354);
      return "buf is nullOrNil";
    }
    if (paramArrayOfByte.length == 1)
    {
      paramArrayOfByte = "buf.len is 1: " + Integer.toHexString(paramArrayOfByte[0]);
      GMTrace.o(13469285875712L, 100354);
      return paramArrayOfByte;
    }
    paramArrayOfByte = "buf last two[len:" + paramArrayOfByte.length + "]: %s, %s" + Integer.toHexString(paramArrayOfByte[(paramArrayOfByte.length - 2)] & 0xFF) + ", " + Integer.toHexString(paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF);
    GMTrace.o(13469285875712L, 100354);
    return paramArrayOfByte;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */