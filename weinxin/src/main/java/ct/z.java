package ct;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class z
{
  public boolean a = false;
  public boolean b = true;
  public String c = null;
  public String d = null;
  public int[] e = null;
  public String f = "";
  public String g = null;
  public boolean h = true;
  public boolean i = true;
  public byte[] j = null;
  public long k = 0L;
  public long l = 0L;
  public int m = 32768;
  public int n = 10000;
  public int o = 3;
  public boolean p = true;
  public String q = "";
  private Map r = new HashMap();
  private volatile boolean s = false;
  
  public z(String paramString, int[] paramArrayOfInt)
  {
    this.c = paramString;
    this.e = paramArrayOfInt;
    if ((this.e != null) && (this.e[0] != -1)) {}
    for (this.f = (this.c + ":" + this.e[0]);; this.f = this.c)
    {
      this.q = be.b(this.c);
      this.k = System.currentTimeMillis();
      return;
    }
  }
  
  public final void a()
  {
    this.m = 32768;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    this.r.put(paramString1, paramString2);
  }
  
  public final Map b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.r);
    return localHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */