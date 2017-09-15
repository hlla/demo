package ct;

import android.location.Location;

public final class ch
  extends cj
{
  public final Location a;
  public final long b;
  public final int c;
  private int d;
  private int e;
  
  public ch(Location paramLocation, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramLocation;
    this.b = paramLong;
    this.d = paramInt1;
    this.c = paramInt2;
    this.e = paramInt3;
  }
  
  public ch(ch paramch)
  {
    if (paramch.a == null) {}
    for (Location localLocation = null;; localLocation = new Location(paramch.a))
    {
      this.a = localLocation;
      this.b = paramch.b;
      this.d = paramch.d;
      this.c = paramch.c;
      this.e = paramch.e;
      return;
    }
  }
  
  public final String toString()
  {
    return "TxGpsInfo [location=" + this.a + ", gpsTime=" + this.b + ", visbleSatelliteNum=" + this.d + ", usedSatelliteNum=" + this.c + ", gpsStatus=" + this.e + "]";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */