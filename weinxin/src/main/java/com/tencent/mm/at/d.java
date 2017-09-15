package com.tencent.mm.at;

import com.tencent.gmtrace.GMTrace;

public final class d
{
  String hQE;
  double hQF;
  double latitude;
  double longitude;
  
  public d()
  {
    GMTrace.i(4403415220224L, 32808);
    GMTrace.o(4403415220224L, 32808);
  }
  
  public final String toString()
  {
    GMTrace.i(4403549437952L, 32809);
    String str = "gspType:" + this.hQE + " longitude: " + this.longitude + " latitude: " + this.latitude + " distance: " + this.hQF;
    GMTrace.o(4403549437952L, 32809);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/at/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */