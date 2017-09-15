package com.tencent.mm.y;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.zero.a.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.akr;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.ann;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.dw;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.g.a;
import com.tencent.mm.protocal.i.a;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.c.a;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.r.a;
import com.tencent.mm.protocal.y.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class r
  extends g.a
{
  private static e htn;
  private k.d hsi;
  private byte[] hto;
  private int type;
  
  public r(k.d paramd, int paramInt)
  {
    GMTrace.i(13420833275904L, 99993);
    this.hsi = paramd;
    this.type = paramInt;
    GMTrace.o(13420833275904L, 99993);
  }
  
  public static void a(e parame)
  {
    GMTrace.i(13420699058176L, 99992);
    htn = parame;
    GMTrace.o(13420699058176L, 99992);
  }
  
  public static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, k.d paramd, ByteArrayOutputStream paramByteArrayOutputStream, boolean paramBoolean)
  {
    GMTrace.i(13420967493632L, 99994);
    int i;
    if (bf.bm(paramArrayOfByte1))
    {
      if (paramArrayOfByte1 == null) {}
      for (i = -1;; i = paramArrayOfByte1.length)
      {
        v.e("MicroMsg.RemoteReq", "reqToBufNoRSA session is null :%d", new Object[] { Integer.valueOf(i) });
        GMTrace.o(13420967493632L, 99994);
        return false;
      }
    }
    PByteArray localPByteArray = new PByteArray();
    try
    {
      k.b localb = (k.b)paramd;
      byte[] arrayOfByte = localb.zh();
      if (arrayOfByte == null)
      {
        GMTrace.o(13420967493632L, 99994);
        return false;
      }
      if (localb.bHf())
      {
        paramByteArrayOutputStream.write(arrayOfByte);
        GMTrace.o(13420967493632L, 99994);
        return true;
      }
      ac localac = ac.bHi();
      i = 6;
      if (paramBoolean) {
        i = 7;
      }
      if (MMProtocalJni.pack(arrayOfByte, localPByteArray, paramArrayOfByte1, paramArrayOfByte2, paramd.sXP, paramd.sXM, localb.zi(), localac.ver, localac.sYE.getBytes(), localac.sYF.getBytes(), paramArrayOfByte3, i))
      {
        v.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(localPByteArray.value.length), Integer.valueOf(i) });
        paramByteArrayOutputStream.write(localPByteArray.value);
        GMTrace.o(13420967493632L, 99994);
        return true;
      }
      GMTrace.o(13420967493632L, 99994);
      return false;
    }
    catch (Exception paramArrayOfByte1)
    {
      v.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + paramArrayOfByte1.getMessage());
      v.printErrStackTrace("MicroMsg.RemoteReq", paramArrayOfByte1, "", new Object[0]);
      GMTrace.o(13420967493632L, 99994);
    }
    return false;
  }
  
  public static byte[][] a(long paramLong, com.tencent.mm.bd.a parama1, com.tencent.mm.bd.a parama2)
  {
    GMTrace.i(13421235929088L, 99996);
    if (paramLong == 0L) {
      v.w("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray autoauth uin is invalid!");
    }
    try
    {
      parama1 = parama1.toByteArray();
      if (bf.bm(parama1))
      {
        v.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqDataBuf is null and ret false");
        GMTrace.o(13421235929088L, 99996);
        return null;
      }
    }
    catch (IOException parama1)
    {
      for (;;)
      {
        v.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqData toProtoBuf exception:%s", new Object[] { bf.g(parama1) });
        parama1 = null;
      }
      try
      {
        parama2 = parama2.toByteArray();
        if (bf.bm(parama2))
        {
          v.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqDataBuf is null and ret false");
          GMTrace.o(13421235929088L, 99996);
          return null;
        }
      }
      catch (IOException parama2)
      {
        for (;;)
        {
          v.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqData toProtoBuf exception:%s", new Object[] { bf.g(parama2) });
          parama2 = null;
        }
        GMTrace.o(13421235929088L, 99996);
      }
    }
    return tmp143_139;
  }
  
  public final void B(byte[] paramArrayOfByte)
  {
    GMTrace.i(13421504364544L, 99998);
    k.d locald = this.hsi;
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      locald.aMt = paramArrayOfByte;
      GMTrace.o(13421504364544L, 99998);
      return;
      paramArrayOfByte = new byte[0];
    }
  }
  
  public final byte[] Cf()
  {
    GMTrace.i(13421370146816L, 99997);
    byte[] arrayOfByte = this.hto;
    GMTrace.o(13421370146816L, 99997);
    return arrayOfByte;
  }
  
  public final String Cg()
  {
    GMTrace.i(13422443888640L, 100005);
    String str = this.hsi.sXO;
    GMTrace.o(13422443888640L, 100005);
    return str;
  }
  
  public final String Ch()
  {
    GMTrace.i(13422578106368L, 100006);
    String str = this.hsi.sXP;
    GMTrace.o(13422578106368L, 100006);
    return str;
  }
  
  public final int Ci()
  {
    GMTrace.i(13422980759552L, 100009);
    int i = this.hsi.sXQ;
    GMTrace.o(13422980759552L, 100009);
    return i;
  }
  
  public final byte[] Cj()
  {
    GMTrace.i(13423114977280L, 100010);
    v.d("MicroMsg.RemoteReq", "dkrsa getpass type:%d", new Object[] { Integer.valueOf(this.type) });
    switch (this.type)
    {
    default: 
      if (htn != null)
      {
        arrayOfByte = htn.a(this.hsi, this.type);
        if (arrayOfByte != null)
        {
          GMTrace.o(13423114977280L, 100010);
          return arrayOfByte;
        }
      }
      break;
    case 701: 
      arrayOfByte = ((i.d)this.hsi).sXD.tMP.thY.tXD.toByteArray();
      GMTrace.o(13423114977280L, 100010);
      return arrayOfByte;
    case 702: 
      arrayOfByte = ((i.a)this.hsi).sXB.tga.tgc.tXD.toByteArray();
      GMTrace.o(13423114977280L, 100010);
      return arrayOfByte;
    case 381: 
      arrayOfByte = ((r.a)this.hsi).sYo.thY.tXD.toByteArray();
      GMTrace.o(13423114977280L, 100010);
      return arrayOfByte;
    case 126: 
      arrayOfByte = ((y.a)this.hsi).sYy.thY.tXD.toByteArray();
      GMTrace.o(13423114977280L, 100010);
      return arrayOfByte;
    }
    if (this.hsi.sXT != null)
    {
      arrayOfByte = this.hsi.sXT;
      GMTrace.o(13423114977280L, 100010);
      return arrayOfByte;
    }
    byte[] arrayOfByte = vc();
    GMTrace.o(13423114977280L, 100010);
    return arrayOfByte;
  }
  
  public final String Ck()
  {
    GMTrace.i(13423383412736L, 100012);
    switch (this.type)
    {
    default: 
      GMTrace.o(13423383412736L, 100012);
      return "";
    }
    String str = ((i.d)this.hsi).sXD.tMP.tio;
    GMTrace.o(13423383412736L, 100012);
    return str;
  }
  
  public final boolean Cl()
  {
    GMTrace.i(13423786065920L, 100015);
    boolean bool = this.hsi.Cl();
    GMTrace.o(13423786065920L, 100015);
    return bool;
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(13421101711360L, 99995);
    PByteArray localPByteArray = new PByteArray();
    v.d("MicroMsg.RemoteReq", "reqToBuf jType: %d, stack: %s", new Object[] { Integer.valueOf(paramInt1), bf.bJP() });
    switch (paramInt1)
    {
    default: 
      if (!(this.hsi instanceof k.b))
      {
        v.f("MicroMsg.RemoteReq", "all protocal should implemented with protobuf");
        GMTrace.o(13421101711360L, 99995);
        return false;
      }
      break;
    case 268369922: 
      try
      {
        this.hto = ((k.b)this.hsi).zh();
        this.hsi.sXV = this.hto.length;
        GMTrace.o(13421101711360L, 99995);
        return true;
      }
      catch (Exception paramArrayOfByte1)
      {
        v.printErrStackTrace("MicroMsg.RemoteReq", paramArrayOfByte1, "", new Object[0]);
        GMTrace.o(13421101711360L, 99995);
        return false;
      }
    }
    k.b localb;
    byte[] arrayOfByte2;
    long l;
    ac localac;
    byte[] arrayOfByte1;
    label287:
    int i;
    try
    {
      localb = (k.b)this.hsi;
      arrayOfByte2 = localb.zh();
      if (arrayOfByte2 == null)
      {
        GMTrace.o(13421101711360L, 99995);
        return false;
      }
      if (localb.bHf())
      {
        this.hto = arrayOfByte2;
        this.hsi.sXV = this.hto.length;
        GMTrace.o(13421101711360L, 99995);
        return true;
      }
      l = this.hsi.sXM;
      if ((!com.tencent.mm.sdk.a.b.bIk()) || (l != 0L)) {
        break label1192;
      }
      l = d.sXg;
      localac = this.hsi.sXU;
      arrayOfByte1 = paramArrayOfByte1;
      if (localac.bHl()) {
        break label1195;
      }
      arrayOfByte1 = new byte[0];
    }
    catch (Exception paramArrayOfByte1)
    {
      label537:
      v.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + paramArrayOfByte1.getMessage());
      v.printErrStackTrace("MicroMsg.RemoteReq", paramArrayOfByte1, "", new Object[0]);
      GMTrace.o(13421101711360L, 99995);
      return false;
    }
    if (paramInt2 != 0)
    {
      if ((localac.bHl()) && (bf.bm(arrayOfByte1)))
      {
        v.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", new Object[] { Integer.valueOf(paramInt1) });
        GMTrace.o(13421101711360L, 99995);
        return false;
        paramArrayOfByte1 = ((i.d)this.hsi).sXD;
        paramArrayOfByte1 = a(l, paramArrayOfByte1.tMP, paramArrayOfByte1.tMQ);
        paramInt2 = 1;
        break label1223;
        v.d("MicroMsg.RemoteReq", "summerauth reqToBuf rsaReqData uin[%d]", new Object[] { Long.valueOf(l) });
        if (l == 0L) {
          if (i.c.a.sXC != null) {
            break label537;
          }
        }
        for (paramInt2 = -1;; paramInt2 = i.c.a.sXC.zd())
        {
          h.vJ();
          h.vG();
          i = com.tencent.mm.kernel.a.uH();
          v.w("MicroMsg.RemoteReq", "summerauth autoauth uin[%d] is invalid! uinForProtocal[%d] accountUin[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt2), Integer.valueOf(i) });
          c.oRz.a(148L, 54L, 1L, true);
          if (paramInt2 != 0) {
            c.oRz.a(148L, 55L, 1L, true);
          }
          if (i != 0) {
            c.oRz.a(148L, 56L, 1L, true);
          }
          paramArrayOfByte1 = ((i.a)this.hsi).sXB;
          paramArrayOfByte1 = a(l, paramArrayOfByte1.tga, paramArrayOfByte1.tgb);
          paramInt2 = 1;
          break;
        }
      }
      if (paramArrayOfByte1 == null)
      {
        GMTrace.o(13421101711360L, 99995);
        return false;
      }
      paramArrayOfByte3 = paramArrayOfByte1[0];
      paramArrayOfByte1 = paramArrayOfByte1[1];
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if (MMProtocalJni.packHybrid(localPByteArray, paramArrayOfByte2, this.hsi.sXP, (int)l, localb.zi(), localac.ver, paramArrayOfByte3, paramArrayOfByte1, localac.sYE.getBytes(), localac.sYF.getBytes(), Cj(), i))
      {
        v.d("MicroMsg.RemoteReq", "MMEncryptCheckResUpdate reqToBuf packHybrid EncryptCheckResUpdate using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(localPByteArray.value.length), Integer.valueOf(i) });
        this.hto = localPByteArray.value;
      }
      for (;;)
      {
        this.hsi.sXV = this.hto.length;
        GMTrace.o(13421101711360L, 99995);
        return true;
        if (MMProtocalJni.packDoubleHybrid(localPByteArray, paramArrayOfByte2, this.hsi.sXP, (int)l, localb.zi(), localac.ver, paramArrayOfByte3, paramArrayOfByte1, localac.sYE.getBytes(), localac.sYF.getBytes(), Cj(), i))
        {
          v.d("MicroMsg.RemoteReq", "summer reqToBuf packDoubleHybrid AutoAuth using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(localPByteArray.value.length), Integer.valueOf(i) });
          this.hto = localPByteArray.value;
        }
      }
      if (this.hsi.sXS != null)
      {
        paramInt2 = 6;
        if (paramBoolean) {
          paramInt2 = 7;
        }
        if (this.hsi.sXS.a(localPByteArray, paramInt1, paramArrayOfByte2, paramArrayOfByte3, paramInt2))
        {
          this.hto = localPByteArray.value;
          this.hsi.sXV = this.hto.length;
          v.d("MicroMsg.RemoteReq", "reqToBuf using req.getReqPackControl() ok, len:%d", new Object[] { Integer.valueOf(localPByteArray.value.length) });
        }
        GMTrace.o(13421101711360L, 99995);
        return true;
      }
      if ((paramInt1 != 775) && (localac.bHl()) && (bf.bm(arrayOfByte1)))
      {
        v.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", new Object[] { Integer.valueOf(paramInt1) });
        GMTrace.o(13421101711360L, 99995);
        return false;
      }
      if (paramInt1 == 775) {}
      for (paramInt2 = i & 0xFFFFFFFD & 0xFFFFFFFB;; paramInt2 = i)
      {
        v.d("MicroMsg.RemoteReq", "dkrsa use session :%s  type:%d, flag:%d, ecdh:[%s]", new Object[] { arrayOfByte1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bf.bl(paramArrayOfByte3) });
        if (MMProtocalJni.pack(arrayOfByte2, localPByteArray, arrayOfByte1, paramArrayOfByte2, this.hsi.sXP, (int)l, localb.zi(), localac.ver, localac.sYE.getBytes(), localac.sYF.getBytes(), paramArrayOfByte3, paramInt2))
        {
          v.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(localPByteArray.value.length), Integer.valueOf(paramInt2) });
          this.hto = localPByteArray.value;
        }
        this.hsi.sXV = this.hto.length;
        break;
      }
      label1192:
      break;
      label1195:
      paramArrayOfByte1 = null;
      switch (paramInt1)
      {
      }
      paramInt2 = 0;
      label1223:
      i = 6;
      if (!paramBoolean) {
        break label287;
      }
      i = 7;
      break label287;
    }
  }
  
  public final void dj(int paramInt)
  {
    GMTrace.i(13421772800000L, 100000);
    this.hsi.dj(paramInt);
    GMTrace.o(13421772800000L, 100000);
  }
  
  public final void fr(int paramInt)
  {
    GMTrace.i(13422041235456L, 100002);
    this.hsi.sXN = paramInt;
    GMTrace.o(13422041235456L, 100002);
  }
  
  public final void fs(int paramInt)
  {
    GMTrace.i(13422846541824L, 100008);
    this.hsi.sXQ = paramInt;
    GMTrace.o(13422846541824L, 100008);
  }
  
  public final int getClientVersion()
  {
    GMTrace.i(13422175453184L, 100003);
    int i = this.hsi.sXN;
    GMTrace.o(13422175453184L, 100003);
    return i;
  }
  
  public final int getCmdId()
  {
    GMTrace.i(13423651848192L, 100014);
    int i = this.hsi.getCmdId();
    GMTrace.o(13423651848192L, 100014);
    return i;
  }
  
  public final String getPassword()
  {
    GMTrace.i(13423249195008L, 100011);
    switch (this.type)
    {
    default: 
      GMTrace.o(13423249195008L, 100011);
      return "";
    case 701: 
      str = ((i.d)this.hsi).sXD.tMP.tie;
      GMTrace.o(13423249195008L, 100011);
      return str;
    }
    String str = ((y.a)this.hsi).sYy.tie;
    GMTrace.o(13423249195008L, 100011);
    return str;
  }
  
  public final String getUserName()
  {
    GMTrace.i(13423517630464L, 100013);
    switch (this.type)
    {
    default: 
      GMTrace.o(13423517630464L, 100013);
      return "";
    case 702: 
      str = ((i.a)this.hsi).username;
      GMTrace.o(13423517630464L, 100013);
      return str;
    case 701: 
      str = ((i.d)this.hsi).sXD.tMP.jLx;
      GMTrace.o(13423517630464L, 100013);
      return str;
    }
    String str = ((y.a)this.hsi).sYy.jLx;
    GMTrace.o(13423517630464L, 100013);
    return str;
  }
  
  public final void hx(String paramString)
  {
    GMTrace.i(13422309670912L, 100004);
    this.hsi.sXO = paramString;
    GMTrace.o(13422309670912L, 100004);
  }
  
  public final void hy(String paramString)
  {
    GMTrace.i(13422712324096L, 100007);
    this.hsi.sXP = paramString;
    GMTrace.o(13422712324096L, 100007);
  }
  
  public final int uH()
  {
    GMTrace.i(13421907017728L, 100001);
    int i = this.hsi.sXM;
    GMTrace.o(13421907017728L, 100001);
    return i;
  }
  
  public final byte[] vc()
  {
    GMTrace.i(13421638582272L, 99999);
    byte[] arrayOfByte = this.hsi.aMt;
    GMTrace.o(13421638582272L, 99999);
    return arrayOfByte;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/y/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */