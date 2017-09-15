package ct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ak
  extends bh
{
  private static ArrayList k;
  private static Map l;
  private String a = "";
  private String b = "";
  private ArrayList c = null;
  private String d = "";
  private String e = "";
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private String i = "";
  private Map j = null;
  
  public ak() {}
  
  public ak(String paramString1, String paramString2, ArrayList paramArrayList, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, Map paramMap)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayList;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramString5;
    this.j = paramMap;
  }
  
  public final void a(bf parambf)
  {
    this.a = parambf.a(0, true);
    this.b = parambf.a(1, true);
    if (k == null)
    {
      k = new ArrayList();
      k.add("");
    }
    this.c = ((ArrayList)parambf.a(k, 2, true));
    this.d = parambf.a(3, false);
    this.e = parambf.a(4, false);
    this.f = parambf.a(this.f, 5, false);
    this.g = parambf.a(this.g, 6, false);
    this.h = parambf.a(this.h, 7, false);
    this.i = parambf.a(8, false);
    if (l == null)
    {
      l = new HashMap();
      l.put("", "");
    }
    this.j = ((Map)parambf.a(l, 9, false));
  }
  
  public final void a(bg parambg)
  {
    parambg.a(this.a, 0);
    parambg.a(this.b, 1);
    parambg.a(this.c, 2);
    if (this.d != null) {
      parambg.a(this.d, 3);
    }
    if (this.e != null) {
      parambg.a(this.e, 4);
    }
    parambg.a(this.f, 5);
    parambg.a(this.g, 6);
    parambg.a(this.h, 7);
    if (this.i != null) {
      parambg.a(this.i, 8);
    }
    if (this.j != null) {
      parambg.a(this.j, 9);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */