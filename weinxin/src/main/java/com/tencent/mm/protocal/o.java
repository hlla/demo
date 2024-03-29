package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.c;
import com.tencent.mm.a.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class o
{
  public static byte[] NJ(String paramString)
  {
    GMTrace.i(16022778150912L, 119379);
    byte[] arrayOfByte = new byte[16];
    System.arraycopy(paramString.getBytes(), 0, arrayOfByte, 0, 15);
    arrayOfByte[15] = 0;
    paramString = g.o(arrayOfByte);
    v.d("MicroMsg.MMDirectSend", "new direct send: key=%s", new Object[] { bf.bl(paramString) });
    GMTrace.o(16022778150912L, 119379);
    return paramString;
  }
  
  public static final class a
    extends k.d
    implements k.b
  {
    public int fJB;
    public int fRM;
    public int hTc;
    public String sYg;
    public byte[] sYh;
    
    public a()
    {
      GMTrace.i(3606161915904L, 26868);
      this.fJB = 0;
      this.fRM = 0;
      this.hTc = 0;
      this.sYg = "";
      this.sYh = new byte[0];
      GMTrace.o(3606161915904L, 26868);
    }
    
    private byte[] aX(byte[] paramArrayOfByte)
    {
      GMTrace.i(3606430351360L, 26870);
      if (paramArrayOfByte == null)
      {
        GMTrace.o(3606430351360L, 26870);
        return null;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
        localDataOutputStream.writeByte(this.fJB);
        localDataOutputStream.writeByte(this.fRM);
        localDataOutputStream.write(paramArrayOfByte);
        localDataOutputStream.close();
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        GMTrace.o(3606430351360L, 26870);
        return paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          v.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + paramArrayOfByte.getMessage());
        }
      }
    }
    
    private byte[] bHg()
    {
      GMTrace.i(3606296133632L, 26869);
      Object localObject = new ByteArrayOutputStream();
      try
      {
        DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
        localDataOutputStream.writeInt(this.hTc);
        localDataOutputStream.writeShort(this.sYg.getBytes().length);
        localDataOutputStream.write(this.sYg.getBytes());
        localDataOutputStream.writeShort(this.sYh.length);
        localDataOutputStream.write(this.sYh);
        localDataOutputStream.close();
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        GMTrace.o(3606296133632L, 26869);
        return (byte[])localObject;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          v.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + localIOException.getMessage());
        }
      }
    }
    
    public final boolean Cl()
    {
      GMTrace.i(3607101440000L, 26875);
      GMTrace.o(3607101440000L, 26875);
      return false;
    }
    
    public final boolean bHf()
    {
      GMTrace.i(3606967222272L, 26874);
      GMTrace.o(3606967222272L, 26874);
      return true;
    }
    
    public final int getCmdId()
    {
      GMTrace.i(3606833004544L, 26873);
      GMTrace.o(3606833004544L, 26873);
      return 8;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(3606564569088L, 26871);
      byte[] arrayOfByte = bHg();
      PByteArray localPByteArray = new PByteArray();
      c.a(localPByteArray, arrayOfByte, o.NJ(this.sXP));
      arrayOfByte = aX(localPByteArray.value);
      GMTrace.o(3606564569088L, 26871);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(3606698786816L, 26872);
      GMTrace.o(3606698786816L, 26872);
      return 10;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public byte[] content;
    public String deviceID;
    private int fJB;
    private int fRM;
    public String hRv;
    private int hTc;
    
    public b()
    {
      GMTrace.i(3607504093184L, 26878);
      this.hRv = "";
      this.content = new byte[0];
      this.deviceID = "";
      this.fJB = 0;
      this.fRM = 0;
      this.hTc = 0;
      this.hRv = "";
      this.content = new byte[0];
      GMTrace.o(3607504093184L, 26878);
    }
    
    private byte[] aY(byte[] paramArrayOfByte)
    {
      GMTrace.i(3607906746368L, 26881);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2))
      {
        v.e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
        GMTrace.o(3607906746368L, 26881);
        return null;
      }
      byte[] arrayOfByte = new byte[paramArrayOfByte.length - 2];
      try
      {
        paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
        DataInputStream localDataInputStream = new DataInputStream(paramArrayOfByte);
        this.fJB = localDataInputStream.readByte();
        this.fRM = localDataInputStream.readByte();
        localDataInputStream.readFully(arrayOfByte);
        v.d("MicroMsg.MMDirectSend", "cmdId:" + this.fJB + ", flag=" + this.fRM + ", tail len=" + arrayOfByte.length);
        paramArrayOfByte.close();
        GMTrace.o(3607906746368L, 26881);
        return arrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          v.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
        }
      }
    }
    
    public final boolean bHf()
    {
      GMTrace.i(3607772528640L, 26880);
      GMTrace.o(3607772528640L, 26880);
      return true;
    }
    
    public final int getCmdId()
    {
      GMTrace.i(3607638310912L, 26879);
      GMTrace.o(3607638310912L, 26879);
      return 8;
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(3608040964096L, 26882);
      byte[] arrayOfByte1 = o.NJ(this.deviceID);
      PByteArray localPByteArray = new PByteArray();
      int i;
      if (c.b(localPByteArray, aY(paramArrayOfByte), arrayOfByte1) != 0)
      {
        byte[] arrayOfByte2 = new byte[16];
        i = 0;
        while (i < 16)
        {
          arrayOfByte2[i] = 0;
          i += 1;
        }
        if (c.b(localPByteArray, aY(paramArrayOfByte), arrayOfByte2) != 0)
        {
          v.e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", new Object[] { bf.bl(arrayOfByte1) });
          GMTrace.o(3608040964096L, 26882);
          return -1;
        }
      }
      paramArrayOfByte = localPByteArray.value;
      if (paramArrayOfByte == null) {
        v.e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
      }
      for (;;)
      {
        GMTrace.o(3608040964096L, 26882);
        return 0;
        try
        {
          paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
          this.hTc = paramArrayOfByte.readInt();
          v.d("MicroMsg.MMDirectSend", "seq=" + this.hTc);
          i = paramArrayOfByte.readShort();
          if (i >= 0) {
            break label233;
          }
          throw new IOException("sender empty");
        }
        catch (IOException paramArrayOfByte)
        {
          v.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + paramArrayOfByte.getMessage());
        }
        continue;
        label233:
        arrayOfByte1 = new byte[i];
        paramArrayOfByte.readFully(arrayOfByte1);
        this.hRv = new String(arrayOfByte1);
        v.d("MicroMsg.MMDirectSend", "recievers len=" + i + ", sender=" + this.hRv);
        i = paramArrayOfByte.readShort();
        if (i < 0) {
          throw new IOException("content empty");
        }
        this.content = new byte[i];
        paramArrayOfByte.readFully(this.content);
        v.d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */