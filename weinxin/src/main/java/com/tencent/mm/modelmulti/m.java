package com.tencent.mm.modelmulti;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.gx;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.anr;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;

public final class m
{
  public static boolean Hw()
  {
    GMTrace.i(13438147362816L, 100122);
    h.vJ();
    if (bf.mz((String)h.vI().vr().get(8195, null)).length() > 0)
    {
      h.vJ();
      if (bf.f((Integer)h.vI().vr().get(15, null)) != 0) {
        break label92;
      }
    }
    label92:
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(13438147362816L, 100122);
      return bool;
    }
  }
  
  public static void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    GMTrace.i(13438281580544L, 100123);
    w.b localb = new w.b();
    PByteArray localPByteArray2 = new PByteArray();
    PByteArray localPByteArray1 = new PByteArray();
    PInt localPInt2 = new PInt();
    PInt localPInt3 = new PInt();
    PInt localPInt1 = new PInt(0);
    try
    {
      bool1 = MMProtocalJni.unpack(localPByteArray1, paramArrayOfByte1, paramArrayOfByte2, localPByteArray2, localPInt2, localPInt3, localPInt1);
      v.i("MicroMsg.NewSyncMgr", "summerdiz dealWithPushResp unpack ret[%b], noticeid[%d]", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(localPInt1.value) });
      if (localPInt1.value != 0)
      {
        paramArrayOfByte2 = new gx();
        paramArrayOfByte2.fMb.fMc = localPInt1.value;
        boolean bool2 = com.tencent.mm.sdk.b.a.uql.m(paramArrayOfByte2);
        v.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt1.value), Boolean.valueOf(bool2) });
        localPInt1.value = 0;
      }
      if (!bool1)
      {
        v.e("MicroMsg.NewSyncMgr", "unpack push resp failed");
        GMTrace.o(13438281580544L, 100123);
        return;
      }
      if (localPInt2.value == -13)
      {
        localb.sXW = localPInt2.value;
        v.e("MicroMsg.NewSyncMgr", "unpack push resp failed session timeout");
        GMTrace.o(13438281580544L, 100123);
        return;
      }
      int i = localb.y(localPByteArray1.value);
      v.d("MicroMsg.NewSyncMgr", "bufToResp using protobuf ok");
      localb.sXW = i;
      localb.sXV = paramArrayOfByte1.length;
      h.vJ();
      paramArrayOfByte1 = bf.PS(bf.mz((String)h.vI().vr().get(8195, null)));
      paramArrayOfByte2 = n.a(localb.sYx.tmv);
      h.vJ();
      h.vG().aF(localb.sYx.jLP, localb.sYx.tRi);
      com.tencent.mm.kernel.a.eM(localb.sYx.jLP);
      if ((bf.bm(paramArrayOfByte2)) || (!ad.h(paramArrayOfByte1, paramArrayOfByte2)))
      {
        v.e("MicroMsg.NewSyncMgr", "compareKeybuf syncKey failed");
        GMTrace.o(13438281580544L, 100123);
        return;
      }
      ((b)h.h(b.class)).Hz().a(localb, paramInt, paramLong);
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        boolean bool1;
        v.e("MicroMsg.NewSyncMgr", "unpack push resp failed: %s", new Object[] { paramArrayOfByte1 });
        v.printErrStackTrace("MicroMsg.NewSyncMgr", paramArrayOfByte1, "", new Object[0]);
      }
    }
    if (localPInt1.value != 0)
    {
      paramArrayOfByte1 = new gx();
      paramArrayOfByte1.fMb.fMc = localPInt1.value;
      bool1 = com.tencent.mm.sdk.b.a.uql.m(paramArrayOfByte1);
      v.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt1.value), Boolean.valueOf(bool1) });
      localPInt1.value = 0;
    }
    GMTrace.o(13438281580544L, 100123);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */