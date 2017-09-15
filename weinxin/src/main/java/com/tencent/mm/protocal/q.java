package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.protocal.c.po;
import com.tencent.mm.protocal.c.pp;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.r;

public final class q
{
  public static final class a
    extends k.d
    implements k.b
  {
    public final po sYk;
    
    public a()
    {
      GMTrace.i(4085453422592L, 30439);
      this.sYk = new po();
      dj(0);
      this.sYk.tub = new pn();
      this.sYk.tub.ttZ = new kw();
      this.sYk.tua = new pp();
      GMTrace.o(4085453422592L, 30439);
    }
    
    public final byte[] zh()
    {
      GMTrace.i(4085587640320L, 30440);
      this.sXU = ac.bHi();
      this.sYk.tub.tXb = k.a(this);
      this.sYk.tua.thY = new avt().bb(bf.bJG());
      this.sXT = this.sYk.tua.thY.tXD.toByteArray();
      this.sXS = new k.a()
      {
        public final boolean a(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt2)
        {
          GMTrace.i(3614483415040L, 26930);
          paramAnonymousArrayOfByte2 = (k.b)jdField_this;
          long l = jdField_this.sXM;
          if ((com.tencent.mm.sdk.a.b.bIk()) && (l == 0L)) {
            l = d.sXg;
          }
          for (;;)
          {
            ac localac = jdField_this.sXU;
            if (paramAnonymousInt1 == 722)
            {
              v.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
              po localpo = ((q.a)jdField_this).sYk;
              Object localObject = r.a(l, localpo.tua, localpo.tub);
              if (localObject == null)
              {
                GMTrace.o(3614483415040L, 26930);
                return false;
              }
              localpo = localObject[0];
              localObject = localObject[1];
              if (MMProtocalJni.packHybrid(paramAnonymousPByteArray, paramAnonymousArrayOfByte1, jdField_this.sXP, (int)l, paramAnonymousArrayOfByte2.zi(), localac.ver, localpo, (byte[])localObject, localac.sYE.getBytes(), localac.sYF.getBytes(), jdField_this.sXT, paramAnonymousInt2))
              {
                v.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2) });
                GMTrace.o(3614483415040L, 26930);
                return true;
              }
            }
            GMTrace.o(3614483415040L, 26930);
            return false;
          }
        }
      };
      byte[] arrayOfByte = this.sYk.toByteArray();
      GMTrace.o(4085587640320L, 30440);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(4085721858048L, 30441);
      GMTrace.o(4085721858048L, 30441);
      return 722;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public final kx sYn;
    
    public b()
    {
      GMTrace.i(3610993754112L, 26904);
      this.sYn = new kx();
      GMTrace.o(3610993754112L, 26904);
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(3611127971840L, 26905);
      this.sYn.aD(paramArrayOfByte);
      int i = this.sYn.tXs.tgr;
      GMTrace.o(3611127971840L, 26905);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */