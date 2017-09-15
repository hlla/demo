package ct;

import com.tencent.map.geolocation.TencentDistanceAnalysis;

public final class cn
  implements TencentDistanceAnalysis
{
  private double a;
  private int b;
  private int c;
  
  public final void a(double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final double getConfidence()
  {
    return this.a;
  }
  
  public final int getGpsCount()
  {
    return this.b;
  }
  
  public final int getNetworkCount()
  {
    return this.c;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */