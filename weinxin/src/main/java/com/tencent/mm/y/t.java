package com.tencent.mm.y;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import com.tencent.mm.e.a.gx;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.atb;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.axh;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.protocal.c.wm;
import com.tencent.mm.protocal.h.a;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.r.b;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class t
  extends h.a
{
  private static a htx;
  private k.e htv;
  private byte[] htw;
  private int type;
  
  public t(k.e parame, int paramInt)
  {
    GMTrace.i(13401103269888L, 99846);
    this.htv = parame;
    this.type = paramInt;
    GMTrace.o(13401103269888L, 99846);
  }
  
  public static void a(a parama)
  {
    GMTrace.i(13400969052160L, 99845);
    htx = parama;
    GMTrace.o(13400969052160L, 99845);
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PInt paramPInt, avm paramavm)
  {
    GMTrace.i(13401371705344L, 99848);
    PByteArray localPByteArray2 = new PByteArray();
    paramPInt.value = -1;
    PByteArray localPByteArray1 = new PByteArray();
    PInt localPInt1 = new PInt(0);
    PInt localPInt2 = new PInt(0);
    for (;;)
    {
      try
      {
        boolean bool1 = MMProtocalJni.unpack(localPByteArray1, paramArrayOfByte1, paramArrayOfByte2, localPByteArray2, paramPInt, localPInt1, localPInt2);
        v.i("MicroMsg.RemoteResp", "bufToRespNoRSA unpack ret[%b], noticeid[%d]", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(localPInt2.value) });
        if (localPInt2.value != 0)
        {
          paramArrayOfByte1 = new gx();
          paramArrayOfByte1.fMb.fMc = localPInt2.value;
          boolean bool2 = a.uql.m(paramArrayOfByte1);
          v.i("MicroMsg.RemoteResp", "summerdiz bufToRespNoRSA publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt2.value), Boolean.valueOf(bool2) });
        }
        if (!bool1) {
          continue;
        }
        if ((paramPInt.value == -13) || (paramPInt.value == -102) || (paramPInt.value == 62535))
        {
          v.e("MicroMsg.RemoteResp", "unpack failed. error:%d", new Object[] { Integer.valueOf(paramPInt.value) });
          GMTrace.o(13401371705344L, 99848);
          return null;
        }
        int i = paramPInt.value;
        if (i != 62534) {
          continue;
        }
        try
        {
          paramArrayOfByte1 = new String(localPByteArray1.value);
          v.i("MicroMsg.RemoteResp", "bufToRespNoRSA -3002 ERR_IDCDISASTER, errStr:%s", new Object[] { paramArrayOfByte1 });
          new ad(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(13420296404992L, 99989);
              if ((!bf.mA(this.hty)) && (t.Cw() != null)) {
                t.Cw().bq(this.hty);
              }
              GMTrace.o(13420296404992L, 99989);
            }
          });
          GMTrace.o(13401371705344L, 99848);
          return null;
        }
        catch (Exception paramArrayOfByte1)
        {
          v.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
        }
      }
      catch (Exception paramArrayOfByte1)
      {
        v.printErrStackTrace("MicroMsg.RemoteResp", paramArrayOfByte1, "parseFrom unbuild exception, check now!", new Object[0]);
        v.e("MicroMsg.RemoteResp", "exception:%s", new Object[] { bf.g(paramArrayOfByte1) });
        continue;
      }
      GMTrace.o(13401371705344L, 99848);
      return null;
      v.i("MicroMsg.RemoteResp", "fuckwifi bufToRespNoRSA using protobuf ok jtype:%d enType:%d ", new Object[] { Integer.valueOf(110), Integer.valueOf(localPInt1.value) });
      paramavm.aD(localPByteArray1.value);
      paramArrayOfByte1 = localPByteArray1.value;
      GMTrace.o(13401371705344L, 99848);
      return paramArrayOfByte1;
      v.e("MicroMsg.RemoteResp", "unpack failed.");
    }
  }
  
  public final byte[] BX()
  {
    GMTrace.i(13401505923072L, 99849);
    byte[] arrayOfByte = this.htw;
    GMTrace.o(13401505923072L, 99849);
    return arrayOfByte;
  }
  
  public final byte[] BZ()
  {
    GMTrace.i(13402445447168L, 99856);
    byte[] arrayOfByte = new byte[0];
    switch (this.type)
    {
    }
    for (;;)
    {
      GMTrace.o(13402445447168L, 99856);
      return arrayOfByte;
      arrayOfByte = ((i.g)this.htv).sXH;
      continue;
      arrayOfByte = ((y.b)this.htv).sXH;
    }
  }
  
  public final String Cp()
  {
    GMTrace.i(13401640140800L, 99850);
    String str = this.htv.sXX;
    GMTrace.o(13401640140800L, 99850);
    return str;
  }
  
  public final int Cq()
  {
    GMTrace.i(13401908576256L, 99852);
    int i = this.htv.sXW;
    GMTrace.o(13401908576256L, 99852);
    return i;
  }
  
  public final byte[] Cr()
  {
    GMTrace.i(13402311229440L, 99855);
    switch (this.type)
    {
    }
    for (;;)
    {
      Object localObject = new byte[0];
      for (;;)
      {
        GMTrace.o(13402311229440L, 99855);
        return (byte[])localObject;
        if (((i.g)this.htv).sXG.ueM.tfz == null) {
          break;
        }
        localObject = ((i.g)this.htv).sXG.ueM.tfz.tXD.toByteArray();
        continue;
        localObject = ((y.b)this.htv).sYz.tQZ;
        if ((localObject == null) || (((axh)localObject).tfz == null)) {
          break label146;
        }
        localObject = ((axh)localObject).tfz.tXD.toByteArray();
      }
      label146:
      v.d("MicroMsg.RemoteResp", "summerauth MMFunc_NewReg SecAuthRegKeySect is null");
    }
  }
  
  public final String Cs()
  {
    GMTrace.i(13402579664896L, 99857);
    if (this.type == 381)
    {
      Object localObject = ((r.b)this.htv).sYp.tBy;
      if (localObject != null)
      {
        localObject = bf.mz(((atb)localObject).tVB);
        GMTrace.o(13402579664896L, 99857);
        return (String)localObject;
      }
    }
    GMTrace.o(13402579664896L, 99857);
    return "";
  }
  
  public final String Ct()
  {
    GMTrace.i(13402713882624L, 99858);
    if (this.type == 381)
    {
      Object localObject = ((r.b)this.htv).sYp.tBy;
      if (localObject != null)
      {
        localObject = bf.mz(((atb)localObject).tVA);
        GMTrace.o(13402713882624L, 99858);
        return (String)localObject;
      }
    }
    GMTrace.o(13402713882624L, 99858);
    return "";
  }
  
  public final int Cu()
  {
    GMTrace.i(13402848100352L, 99859);
    if (this.type == 381)
    {
      int i = ((r.b)this.htv).sYp.tAK;
      GMTrace.o(13402848100352L, 99859);
      return i;
    }
    GMTrace.o(13402848100352L, 99859);
    return 0;
  }
  
  public final String Cv()
  {
    GMTrace.i(13403116535808L, 99861);
    switch (this.type)
    {
    default: 
      GMTrace.o(13403116535808L, 99861);
      return "";
    case 701: 
    case 702: 
      str = ((i.g)this.htv).idH;
      GMTrace.o(13403116535808L, 99861);
      return str;
    }
    String str = ((y.b)this.htv).sYz.jLx;
    GMTrace.o(13403116535808L, 99861);
    return str;
  }
  
  public final boolean a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    GMTrace.i(13401237487616L, 99847);
    PByteArray localPByteArray1 = new PByteArray();
    if (!(this.htv instanceof k.c))
    {
      v.f("MicroMsg.RemoteResp", "all protocal should implemented with protobuf");
      GMTrace.o(13401237487616L, 99847);
      return false;
    }
    PByteArray localPByteArray2 = new PByteArray();
    PInt localPInt2 = new PInt(0);
    k.c localc = (k.c)this.htv;
    PInt localPInt3 = new PInt(0);
    PInt localPInt1 = new PInt(0);
    boolean bool;
    int i;
    try
    {
      if (localc.bHf())
      {
        paramInt = localc.y(paramArrayOfByte1);
        v.d("MicroMsg.RemoteResp", "rawData using protobuf ok");
        this.htv.sXW = paramInt;
        if (!bf.mA(r.iiF)) {
          this.htv.sXX = r.iiF;
        }
        GMTrace.o(13401237487616L, 99847);
        return true;
      }
      bool = MMProtocalJni.unpack(localPByteArray2, paramArrayOfByte1, paramArrayOfByte2, localPByteArray1, localPInt2, localPInt3, localPInt1);
      v.i("MicroMsg.RemoteResp", "bufToResp unpack ret[%b], jType[%d], noticeid[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), Integer.valueOf(localPInt1.value) });
      if (bool)
      {
        if ((paramInt != 701) && (paramInt != 702) && (10001 == r.iiC) && (r.iiD > 0))
        {
          if (r.iiD == 2) {
            ac.G("", "", 0);
          }
          r.iiD = 0;
          localPInt2.value = -13;
          v.w("MicroMsg.RemoteResp", "dkcert dktest set session timeout once !");
        }
        if ((localPInt2.value == -13) || (localPInt2.value == -102) || (localPInt2.value == 62535) || (localPInt2.value == 62534) || (localPInt2.value == 62533))
        {
          this.htv.sXW = localPInt2.value;
          i = localPInt2.value;
          if (i == 62534) {}
          try
          {
            this.htv.sXX = new String(localPByteArray2.value);
            v.i("MicroMsg.RemoteResp", "jType [%d], ret value[%d], noticeId[%s], msg[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localPInt2.value), localPInt1, this.htv.sXX });
            this.htv.sXV = paramArrayOfByte1.length;
            this.htw = localPByteArray1.value;
            if (!bf.mA(r.iiF)) {
              this.htv.sXX = r.iiF;
            }
            if (localPInt1.value != 0)
            {
              paramArrayOfByte1 = new gx();
              paramArrayOfByte1.fMb.fMc = localPInt1.value;
              if ((paramInt == 701) && (this.htv.sXW == 0))
              {
                v.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent MMFunc_ManualAuth ok [%d]", new Object[] { Integer.valueOf(localPInt1.value) });
                paramArrayOfByte1.fMb.fMd = true;
              }
              bool = a.uql.m(paramArrayOfByte1);
              v.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt1.value), Boolean.valueOf(bool) });
              localPInt1.value = 0;
            }
            GMTrace.o(13401237487616L, 99847);
            return true;
          }
          catch (Exception paramArrayOfByte2)
          {
            for (;;)
            {
              v.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
            }
          }
          if (localPInt1.value == 0) {}
        }
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      v.printErrStackTrace("MicroMsg.RemoteResp", paramArrayOfByte1, "from Protobuf unbuild exception, check now!", new Object[0]);
      v.e("MicroMsg.RemoteResp", "exception:%s", new Object[] { bf.g(paramArrayOfByte1) });
    }
    for (;;)
    {
      paramArrayOfByte1 = new gx();
      paramArrayOfByte1.fMb.fMc = localPInt1.value;
      bool = a.uql.m(paramArrayOfByte1);
      v.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt1.value), Boolean.valueOf(bool) });
      localPInt1.value = 0;
      GMTrace.o(13401237487616L, 99847);
      return false;
      i = localc.y(localPByteArray2.value);
      v.i("MicroMsg.RemoteResp", "bufToResp using protobuf ok jType:%d, enType:%d errCode:%d, len:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localPInt3.value), Integer.valueOf(i), Integer.valueOf(localPByteArray2.value.length) });
      this.htv.sXW = i;
      break;
      v.e("MicroMsg.RemoteResp", "unpack return false jType[%d]", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  public final void ft(int paramInt)
  {
    GMTrace.i(13402042793984L, 99853);
    this.htv.sXW = paramInt;
    GMTrace.o(13402042793984L, 99853);
  }
  
  public final int getCmdId()
  {
    GMTrace.i(13403250753536L, 99862);
    int i = this.htv.getCmdId();
    GMTrace.o(13403250753536L, 99862);
    return i;
  }
  
  public final void hA(String paramString)
  {
    GMTrace.i(13401774358528L, 99851);
    this.htv.sXX = paramString;
    GMTrace.o(13401774358528L, 99851);
  }
  
  public final int uH()
  {
    GMTrace.i(13402982318080L, 99860);
    switch (this.type)
    {
    default: 
      GMTrace.o(13402982318080L, 99860);
      return 0;
    case 701: 
    case 702: 
      i = ((i.g)this.htv).sXG.ueM.lcP;
      GMTrace.o(13402982318080L, 99860);
      return i;
    }
    int i = ((y.b)this.htv).sYz.lcP;
    GMTrace.o(13402982318080L, 99860);
    return i;
  }
  
  public final byte[] vc()
  {
    GMTrace.i(13402177011712L, 99854);
    byte[] arrayOfByte = new byte[0];
    switch (this.type)
    {
    }
    for (;;)
    {
      GMTrace.o(13402177011712L, 99854);
      return arrayOfByte;
      arrayOfByte = ((i.g)this.htv).idE;
      continue;
      arrayOfByte = ((y.b)this.htv).idE;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bq(String paramString);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/y/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */