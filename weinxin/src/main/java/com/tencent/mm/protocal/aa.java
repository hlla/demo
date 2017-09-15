package com.tencent.mm.protocal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

public final class aa
{
  public static final class a
    extends k.d
    implements k.b
  {
    public byte[] gXz;
    public byte[] hKl;
    public int netType;
    public int sXY;
    public int uin;
    
    public a()
    {
      GMTrace.i(13592095096832L, 101269);
      this.hKl = new byte[0];
      this.uin = 0;
      GMTrace.o(13592095096832L, 101269);
    }
    
    public final boolean Cl()
    {
      GMTrace.i(13592900403200L, 101275);
      GMTrace.o(13592900403200L, 101275);
      return false;
    }
    
    public final boolean bHf()
    {
      GMTrace.i(13592766185472L, 101274);
      GMTrace.o(13592766185472L, 101274);
      return true;
    }
    
    public final void dj(int paramInt)
    {
      GMTrace.i(13592229314560L, 101270);
      this.uin = paramInt;
      GMTrace.o(13592229314560L, 101270);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13592631967744L, 101273);
      GMTrace.o(13592631967744L, 101273);
      return 205;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(13592363532288L, 101271);
      int j = this.uin;
      if (this.hKl == null) {}
      for (int i = -1;; i = this.hKl.length)
      {
        v.d("MicroMsg.MMSyncCheck", "toProtoBuf dksynccheck uin:%d keybuf:%d, stack[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), bf.bJP() });
        if ((this.uin != 0) && (!bf.bm(this.hKl))) {
          break;
        }
        GMTrace.o(13592363532288L, 101271);
        return new byte[0];
      }
      i = (this.uin >> 13 & 0x7FFFF | this.hKl.length << 19) ^ 0x5601F281;
      j = 0x5601F281 ^ (this.hKl.length >> 13 & 0x7FFFF | this.uin << 19);
      byte[] arrayOfByte = new byte[this.hKl.length + 32];
      v.d("MicroMsg.MMSyncCheck", "dksynccheck uin=[%d/%d], keyBufLen=[%d/%d] outBuf=[%d]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(i), Integer.valueOf(this.hKl.length), Integer.valueOf(j), Integer.valueOf(arrayOfByte.length) });
      arrayOfByte[0] = ((byte)(i >> 24 & 0xFF));
      arrayOfByte[1] = ((byte)(i >> 16 & 0xFF));
      arrayOfByte[2] = ((byte)(i >> 8 & 0xFF));
      arrayOfByte[3] = ((byte)(i & 0xFF));
      arrayOfByte[4] = ((byte)(j >> 24 & 0xFF));
      arrayOfByte[5] = ((byte)(j >> 16 & 0xFF));
      arrayOfByte[6] = ((byte)(j >> 8 & 0xFF));
      arrayOfByte[7] = ((byte)(j & 0xFF));
      System.arraycopy(this.hKl, 0, arrayOfByte, 8, this.hKl.length);
      arrayOfByte[(arrayOfByte.length - 24)] = ((byte)(d.sXh >> 24 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 23)] = ((byte)(d.sXh >> 16 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 22)] = ((byte)(d.sXh >> 8 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 21)] = ((byte)(d.sXh & 0xFF));
      String str = Locale.getDefault().toString();
      Object localObject = str;
      if (str.length() > 8) {
        localObject = str.substring(0, 8);
      }
      localObject = ((String)localObject).getBytes();
      System.arraycopy(localObject, 0, arrayOfByte, arrayOfByte.length - 20, localObject.length);
      v.d("MicroMsg.MMSyncCheck", "language:%x" + Arrays.toString((byte[])localObject));
      arrayOfByte[(arrayOfByte.length - 12)] = 0;
      arrayOfByte[(arrayOfByte.length - 11)] = 0;
      arrayOfByte[(arrayOfByte.length - 10)] = 0;
      arrayOfByte[(arrayOfByte.length - 9)] = 2;
      arrayOfByte[(arrayOfByte.length - 8)] = ((byte)(this.netType >> 24 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 7)] = ((byte)(this.netType >> 16 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 6)] = ((byte)(this.netType >> 8 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 5)] = ((byte)(this.netType & 0xFF));
      arrayOfByte[(arrayOfByte.length - 4)] = ((byte)(this.sXY >> 24 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 3)] = ((byte)(this.sXY >> 16 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 2)] = ((byte)(this.sXY >> 8 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 1)] = ((byte)(this.sXY & 0xFF));
      v.d("MicroMsg.MMSyncCheck", "outbuf:%x" + Arrays.toString(arrayOfByte));
      this.gXz = g.o(arrayOfByte);
      GMTrace.o(13592363532288L, 101271);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(13592497750016L, 101272);
      GMTrace.o(13592497750016L, 101272);
      return 0;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    private String fQO;
    public byte[] gXz;
    public long sYC;
    private byte[] sYD;
    
    public b()
    {
      GMTrace.i(13607530135552L, 101384);
      this.fQO = null;
      this.gXz = null;
      this.sYC = 7L;
      GMTrace.o(13607530135552L, 101384);
    }
    
    public final boolean bHf()
    {
      GMTrace.i(13608067006464L, 101388);
      GMTrace.o(13608067006464L, 101388);
      return true;
    }
    
    @TargetApi(9)
    public final String bHh()
    {
      GMTrace.i(13607664353280L, 101385);
      if (this.gXz == null)
      {
        GMTrace.o(13607664353280L, 101385);
        return "";
      }
      Object localObject;
      if (this.fQO == null)
      {
        localObject = MMProtocalJni.aesDecrypt(this.sYD, this.gXz);
        if (bf.bm((byte[])localObject))
        {
          GMTrace.o(13607664353280L, 101385);
          return "";
        }
        if (Build.VERSION.SDK_INT < 9) {
          break label103;
        }
      }
      label103:
      for (this.fQO = new String((byte[])localObject, Charset.forName("UTF-8"));; this.fQO = new String((byte[])localObject))
      {
        localObject = this.fQO;
        GMTrace.o(13607664353280L, 101385);
        return (String)localObject;
      }
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13607932788736L, 101387);
      GMTrace.o(13607932788736L, 101387);
      return 1000000205;
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(13607798571008L, 101386);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 12))
      {
        StringBuilder localStringBuilder = new StringBuilder("dksynccheck err resp buf:");
        if (paramArrayOfByte == null) {}
        for (i = -1;; i = paramArrayOfByte.length)
        {
          v.e("MicroMsg.MMSyncCheck", i);
          GMTrace.o(13607798571008L, 101386);
          return -1;
        }
      }
      this.sYC = (paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24);
      int i = paramArrayOfByte[7] & 0xFF | (paramArrayOfByte[6] & 0xFF) << 8 | (paramArrayOfByte[5] & 0xFF) << 16 | (paramArrayOfByte[4] & 0xFF) << 24;
      int j = paramArrayOfByte[11] & 0xFF | (paramArrayOfByte[10] & 0xFF) << 8 | (paramArrayOfByte[9] & 0xFF) << 16 | (paramArrayOfByte[8] & 0xFF) << 24;
      v.d("MicroMsg.MMSyncCheck", " fromProtoBuf oreh synccheck resp selector:%d, redCode:%d, keyLen:%d", new Object[] { Long.valueOf(this.sYC), Integer.valueOf(i), Integer.valueOf(j) });
      if (i != 62534)
      {
        this.fQO = "";
        GMTrace.o(13607798571008L, 101386);
        return i;
      }
      if ((j != paramArrayOfByte.length - 12) && (j != paramArrayOfByte.length - 12 - 16))
      {
        v.e("MicroMsg.MMSyncCheck", " the key len is invalid keyLen:%d, bufLen:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramArrayOfByte.length) });
        GMTrace.o(13607798571008L, 101386);
        return -1;
      }
      if (j == paramArrayOfByte.length - 12 - 16)
      {
        this.gXz = new byte[16];
        System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 16, this.gXz, 0, 16);
      }
      this.sYD = new byte[j];
      System.arraycopy(paramArrayOfByte, 12, this.sYD, 0, j);
      GMTrace.o(13607798571008L, 101386);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */