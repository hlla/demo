package ct;

import java.util.HashMap;
import java.util.Map;

public final class bj
  extends bh
{
  private static byte[] k = null;
  private static Map l = null;
  public short a = 3;
  public int b = 0;
  public String c = null;
  public String d = null;
  public byte[] e;
  private byte f = 0;
  private int g = 0;
  private int h = 0;
  private Map i;
  private Map j;
  
  public final void a(bf parambf)
  {
    try
    {
      this.a = parambf.a(this.a, 1, true);
      this.f = parambf.a(this.f, 2, true);
      this.g = parambf.a(this.g, 3, true);
      this.b = parambf.a(this.b, 4, true);
      this.c = parambf.a(5, true);
      this.d = parambf.a(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      this.e = ((byte[])parambf.b(7, true));
      this.h = parambf.a(this.h, 8, true);
      HashMap localHashMap;
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.i = ((Map)parambf.a(l, 9, true));
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.j = ((Map)parambf.a(l, 10, true));
      return;
    }
    catch (Exception parambf)
    {
      throw new RuntimeException(parambf);
    }
  }
  
  public final void a(bg parambg)
  {
    parambg.a(this.a, 1);
    parambg.a(this.f, 2);
    parambg.a(this.g, 3);
    parambg.a(this.b, 4);
    parambg.a(this.c, 5);
    parambg.a(this.d, 6);
    parambg.a(this.e, 7);
    parambg.a(this.h, 8);
    parambg.a(this.i, 9);
    parambg.a(this.j, 10);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */