package com.qq.wx.voice.vad;

import java.io.PrintStream;

public final class a
{
  public static boolean DEBUG = false;
  public static boolean aJa = false;
  public long aIX = 0L;
  public EVadNative aIY = new EVadNative();
  public MMVoipVadNative aIZ = new MMVoipVadNative();
  
  public static void ag(boolean paramBoolean)
  {
    aJa = paramBoolean;
    if (paramBoolean)
    {
      System.loadLibrary("MMVoipVadEmbed");
      if (DEBUG) {
        System.out.println("EVad loadLib MMVoipVadEmbed");
      }
    }
    do
    {
      return;
      System.loadLibrary("EVadEmbed");
    } while (!DEBUG);
    System.out.println("EVad loadLib EVadEmbed");
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/qq/wx/voice/vad/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */