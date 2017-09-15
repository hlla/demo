package ct;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public final class aa
{
  public int a = 1;
  public String b = null;
  public byte[] c = null;
  public InputStream d = null;
  public String e;
  public long f;
  public Map g = new HashMap();
  
  public final int a()
  {
    return this.a;
  }
  
  public final String a(String paramString)
  {
    if (this.g != null) {
      return (String)this.g.get(paramString);
    }
    return null;
  }
  
  public final byte[] b()
  {
    return this.c;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */