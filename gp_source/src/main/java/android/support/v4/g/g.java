package android.support.v4.g;

import android.util.Log;
import java.io.Writer;

public final class g
  extends Writer
{
  private StringBuilder a = new StringBuilder(128);
  private final String b;
  
  public g(String paramString)
  {
    this.b = paramString;
  }
  
  private final void a()
  {
    if (this.a.length() > 0)
    {
      Log.d(this.b, this.a.toString());
      StringBuilder localStringBuilder = this.a;
      localStringBuilder.delete(0, localStringBuilder.length());
    }
  }
  
  public final void close()
  {
    a();
  }
  
  public final void flush()
  {
    a();
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        a();
      }
      for (;;)
      {
        i += 1;
        break;
        this.a.append(c);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */