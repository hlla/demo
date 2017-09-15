package com.tencent.mm.y;

import android.os.RemoteException;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.c;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class o
  implements c
{
  private final d hsY;
  
  public o(d paramd)
  {
    GMTrace.i(13425799331840L, 100030);
    this.hsY = paramd;
    GMTrace.o(13425799331840L, 100030);
  }
  
  private String getUsername()
  {
    GMTrace.i(13426336202752L, 100034);
    try
    {
      String str = this.hsY.getUsername();
      GMTrace.o(13426336202752L, 100034);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(localRemoteException) });
      GMTrace.o(13426336202752L, 100034);
    }
    return null;
  }
  
  public final int A(byte[] paramArrayOfByte)
  {
    GMTrace.i(13427946815488L, 100046);
    try
    {
      int i = this.hsY.A(paramArrayOfByte);
      GMTrace.o(13427946815488L, 100046);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      v.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bf.g(paramArrayOfByte) });
      GMTrace.o(13427946815488L, 100046);
    }
    return -6;
  }
  
  public final byte[] BX()
  {
    GMTrace.i(13425933549568L, 100031);
    try
    {
      byte[] arrayOfByte = this.hsY.BX();
      GMTrace.o(13425933549568L, 100031);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(localRemoteException) });
      GMTrace.o(13425933549568L, 100031);
    }
    return null;
  }
  
  public final boolean BY()
  {
    GMTrace.i(13426470420480L, 100035);
    try
    {
      boolean bool = this.hsY.BY();
      GMTrace.o(13426470420480L, 100035);
      return bool;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13426470420480L, 100035);
    }
    return false;
  }
  
  public final byte[] BZ()
  {
    GMTrace.i(13427409944576L, 100042);
    try
    {
      byte[] arrayOfByte = this.hsY.BZ();
      GMTrace.o(13427409944576L, 100042);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(localRemoteException) });
      GMTrace.o(13427409944576L, 100042);
    }
    return null;
  }
  
  public final boolean Ca()
  {
    GMTrace.i(13427678380032L, 100044);
    try
    {
      boolean bool = this.hsY.Ca();
      GMTrace.o(13427678380032L, 100044);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(localRemoteException) });
      GMTrace.o(13427678380032L, 100044);
    }
    return true;
  }
  
  public final byte[] Cb()
  {
    GMTrace.i(13427812597760L, 100045);
    try
    {
      byte[] arrayOfByte = this.hsY.Cb();
      GMTrace.o(13427812597760L, 100045);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13427812597760L, 100045);
    }
    return null;
  }
  
  public final void aY(boolean paramBoolean)
  {
    GMTrace.i(13427544162304L, 100043);
    try
    {
      this.hsY.aY(paramBoolean);
      GMTrace.o(13427544162304L, 100043);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(localRemoteException) });
      GMTrace.o(13427544162304L, 100043);
    }
  }
  
  public final void dj(int paramInt)
  {
    GMTrace.i(13428081033216L, 100047);
    try
    {
      this.hsY.dj(paramInt);
      GMTrace.o(13428081033216L, 100047);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13428081033216L, 100047);
    }
  }
  
  public final void h(String paramString, byte[] paramArrayOfByte)
  {
    GMTrace.i(13427141509120L, 100040);
    try
    {
      this.hsY.h(paramString, paramArrayOfByte);
      GMTrace.o(13427141509120L, 100040);
      return;
    }
    catch (RemoteException paramString)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(paramString) });
      GMTrace.o(13427141509120L, 100040);
    }
  }
  
  public final byte[] hu(String paramString)
  {
    GMTrace.i(13427275726848L, 100041);
    try
    {
      paramString = this.hsY.hu(paramString);
      GMTrace.o(13427275726848L, 100041);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(paramString) });
      GMTrace.o(13427275726848L, 100041);
    }
    return null;
  }
  
  public final void i(byte[] paramArrayOfByte, int paramInt)
  {
    GMTrace.i(13426738855936L, 100037);
    try
    {
      this.hsY.i(paramArrayOfByte, paramInt);
      GMTrace.o(13426738855936L, 100037);
      return;
    }
    catch (RemoteException paramArrayOfByte)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(paramArrayOfByte) });
      GMTrace.o(13426738855936L, 100037);
    }
  }
  
  public final void reset()
  {
    GMTrace.i(13426873073664L, 100038);
    try
    {
      this.hsY.reset();
      GMTrace.o(13426873073664L, 100038);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(localRemoteException) });
      GMTrace.o(13426873073664L, 100038);
    }
  }
  
  public final void setUsername(String paramString)
  {
    GMTrace.i(13426604638208L, 100036);
    try
    {
      this.hsY.setUsername(paramString);
      GMTrace.o(13426604638208L, 100036);
      return;
    }
    catch (RemoteException paramString)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(paramString) });
      GMTrace.o(13426604638208L, 100036);
    }
  }
  
  public final String toString()
  {
    GMTrace.i(13427007291392L, 100039);
    String str = "RAccInfo:\n" + "|-uin     =" + uH() + "\n";
    str = str + "|-user    =" + getUsername() + "\n";
    str = str + "|-session =" + vc() + "\n";
    str = str + "|-ecdhkey =" + bf.bl(BZ()) + "\n";
    str = str + "`-cookie  =" + bf.bl(BX());
    GMTrace.o(13427007291392L, 100039);
    return str;
  }
  
  public final int uH()
  {
    GMTrace.i(13426201985024L, 100033);
    try
    {
      int i = this.hsY.uH();
      GMTrace.o(13426201985024L, 100033);
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(localRemoteException) });
      GMTrace.o(13426201985024L, 100033);
    }
    return 0;
  }
  
  public final byte[] vc()
  {
    GMTrace.i(13426067767296L, 100032);
    try
    {
      byte[] arrayOfByte = this.hsY.vc();
      GMTrace.o(13426067767296L, 100032);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      v.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bf.g(localRemoteException) });
      GMTrace.o(13426067767296L, 100032);
    }
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/y/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */