package ct;

import android.location.Location;
import android.os.Bundle;

public final class bu
{
  public static final Bundle a = new Bundle();
  public static final Location b = new Location("EMPTY");
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://lbs.map.qq.com/loc");
    localStringBuilder.append("?");
    localStringBuilder.append("c=1");
    localStringBuilder.append("&mars=").append(paramInt1);
    localStringBuilder.append("&obs=").append(paramInt2);
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */