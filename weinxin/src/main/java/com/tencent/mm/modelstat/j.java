package com.tencent.mm.modelstat;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;

public final class j
{
  private static final String hWu;
  int fRM;
  public int hVR;
  public int hVS;
  public int hVT;
  public int hVU;
  public int hVV;
  public int hVW;
  public int hVX;
  public int hVY;
  public int hVZ;
  public int hWa;
  public int hWb;
  public int hWc;
  public int hWd;
  public int hWe;
  public int hWf;
  public int hWg;
  public int hWh;
  public int hWi;
  public int hWj;
  public int hWk;
  public int hWl;
  public int hWm;
  public int hWn;
  public int hWo;
  public int hWp;
  public int hWq;
  public int hWr;
  public int hWs;
  public int hWt;
  public int id;
  
  static
  {
    GMTrace.i(1387811307520L, 10340);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetStatInfo:");
    localStringBuilder.append("[mobile in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
    localStringBuilder.append("[wifi in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
    localStringBuilder.append("[text in=%d/%dB, out=%d/%dB]");
    localStringBuilder.append("[image in=%d/%dB, out=%d/%dB]");
    localStringBuilder.append("[voice in=%d/%dB, out=%d/%dB]");
    localStringBuilder.append("[video in=%d/%dB, out=%d/%dB]");
    hWu = localStringBuilder.toString();
    GMTrace.o(1387811307520L, 10340);
  }
  
  public j()
  {
    GMTrace.i(1387408654336L, 10337);
    this.fRM = -2;
    this.id = 0;
    this.hVR = 0;
    this.hVS = 0;
    this.hVT = 0;
    this.hVU = 0;
    this.hVV = 0;
    this.hVW = 0;
    this.hVX = 0;
    this.hVY = 0;
    this.hVZ = 0;
    this.hWa = 0;
    this.hWb = 0;
    this.hWc = 0;
    this.hWd = 0;
    this.hWe = 0;
    this.hWf = 0;
    this.hWg = 0;
    this.hWh = 0;
    this.hWi = 0;
    this.hWj = 0;
    this.hWk = 0;
    this.hWl = 0;
    this.hWm = 0;
    this.hWn = 0;
    this.hWo = 0;
    this.hWp = 0;
    this.hWq = 0;
    this.hWr = 0;
    this.hWs = 0;
    this.hWt = 0;
    GMTrace.o(1387408654336L, 10337);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(1387542872064L, 10338);
    this.id = paramCursor.getInt(0);
    this.hVR = paramCursor.getInt(1);
    this.hVS = paramCursor.getInt(2);
    this.hVT = paramCursor.getInt(3);
    this.hVU = paramCursor.getInt(4);
    this.hVV = paramCursor.getInt(5);
    this.hVW = paramCursor.getInt(6);
    this.hVX = paramCursor.getInt(7);
    this.hVY = paramCursor.getInt(8);
    this.hVZ = paramCursor.getInt(9);
    this.hWa = paramCursor.getInt(10);
    this.hWb = paramCursor.getInt(11);
    this.hWc = paramCursor.getInt(12);
    this.hWd = paramCursor.getInt(13);
    this.hWe = paramCursor.getInt(14);
    this.hWf = paramCursor.getInt(15);
    this.hWg = paramCursor.getInt(16);
    this.hWh = paramCursor.getInt(17);
    this.hWi = paramCursor.getInt(18);
    this.hWj = paramCursor.getInt(19);
    this.hWk = paramCursor.getInt(20);
    this.hWl = paramCursor.getInt(21);
    this.hWm = paramCursor.getInt(22);
    this.hWn = paramCursor.getInt(23);
    this.hWo = paramCursor.getInt(24);
    this.hWp = paramCursor.getInt(25);
    this.hWq = paramCursor.getInt(26);
    this.hWr = paramCursor.getInt(27);
    this.hWs = paramCursor.getInt(28);
    this.hWt = paramCursor.getInt(29);
    GMTrace.o(1387542872064L, 10338);
  }
  
  public final String toString()
  {
    GMTrace.i(1387677089792L, 10339);
    String str = String.format(hWu, new Object[] { Integer.valueOf(this.hWa), Integer.valueOf(this.hWq), Integer.valueOf(this.hWc), Integer.valueOf(this.hWm), Integer.valueOf(this.hWs), Integer.valueOf(this.hWo), Integer.valueOf(this.hWb), Integer.valueOf(this.hWr), Integer.valueOf(this.hWd), Integer.valueOf(this.hWn), Integer.valueOf(this.hWt), Integer.valueOf(this.hWp), Integer.valueOf(this.hVS), Integer.valueOf(this.hVT), Integer.valueOf(this.hWe), Integer.valueOf(this.hWf), Integer.valueOf(this.hVU), Integer.valueOf(this.hVV), Integer.valueOf(this.hWg), Integer.valueOf(this.hWh), Integer.valueOf(this.hVW), Integer.valueOf(this.hVX), Integer.valueOf(this.hWi), Integer.valueOf(this.hWj), Integer.valueOf(this.hVY), Integer.valueOf(this.hVZ), Integer.valueOf(this.hWk), Integer.valueOf(this.hWl) });
    GMTrace.o(1387677089792L, 10339);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelstat/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */