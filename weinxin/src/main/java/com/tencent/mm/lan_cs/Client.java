package com.tencent.mm.lan_cs;

import com.tencent.gmtrace.GMTrace;

public final class Client
{
  public static a hbc;
  
  public static class C2Java
  {
    public C2Java()
    {
      GMTrace.i(1335734829056L, 9952);
      GMTrace.o(1335734829056L, 9952);
    }
    
    public static void onDisconnect(String paramString, int paramInt)
    {
      GMTrace.i(1336003264512L, 9954);
      if (Client.hbc != null) {
        Client.hbc.wh();
      }
      GMTrace.o(1336003264512L, 9954);
    }
    
    public static void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      GMTrace.i(1335869046784L, 9953);
      if (Client.hbc != null) {
        Client.hbc.onRecv(paramString, paramInt, paramArrayOfByte);
      }
      GMTrace.o(1335869046784L, 9953);
    }
  }
  
  public static class Java2C
  {
    public Java2C()
    {
      GMTrace.i(1335332175872L, 9949);
      GMTrace.o(1335332175872L, 9949);
    }
    
    public static native void disconnect();
    
    public static native int send(String paramString, int paramInt, byte[] paramArrayOfByte);
  }
  
  public static abstract interface a
  {
    public abstract void onRecv(String paramString, int paramInt, byte[] paramArrayOfByte);
    
    public abstract void wh();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/lan_cs/Client.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */