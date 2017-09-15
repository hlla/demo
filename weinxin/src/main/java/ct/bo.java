package ct;

import android.os.Bundle;

public abstract class bo
{
  private String a;
  private String b;
  private boolean c;
  
  public bo(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = true;
  }
  
  public void a() {}
  
  protected abstract boolean a(Bundle paramBundle);
  
  public final boolean b(Bundle paramBundle)
  {
    if (!this.c) {
      return false;
    }
    return a(paramBundle);
  }
  
  public String toString()
  {
    return "[name=" + this.a + ",desc=" + this.b + ",enabled=" + this.c + "]";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */