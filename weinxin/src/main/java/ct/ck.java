package ct;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ck
  extends cj
{
  public static final ck a = new ck(Collections.emptyList(), 0L);
  private final List<ScanResult> b;
  private final long c;
  
  public ck(List<ScanResult> paramList, long paramLong)
  {
    this.c = paramLong;
    this.b = new ArrayList(paramList);
  }
  
  public final List<ScanResult> a()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public final boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 - this.c < paramLong2;
  }
  
  public final boolean a(ck paramck)
  {
    paramck = paramck.b;
    List localList = this.b;
    if ((paramck == null) || (localList == null)) {}
    while ((paramck.size() == 0) || (localList.size() == 0) || (b.a.a(paramck, localList))) {
      return false;
    }
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */