package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.a.a;

public abstract class e
{
  public String gWE;
  public a gZo;
  public Application gZp;
  
  public e(String paramString, Application paramApplication)
  {
    GMTrace.i(18796253282304L, 140043);
    this.gWE = paramString;
    this.gZo = new a();
    this.gZp = paramApplication;
    GMTrace.o(18796253282304L, 140043);
  }
  
  public final boolean ej(String paramString)
  {
    GMTrace.i(18796387500032L, 140044);
    if ((this.gWE != null) && (this.gWE.equals(getPackageName() + paramString)))
    {
      GMTrace.o(18796387500032L, 140044);
      return true;
    }
    GMTrace.o(18796387500032L, 140044);
    return false;
  }
  
  public abstract String getPackageName();
  
  public String toString()
  {
    GMTrace.i(13521765007360L, 100745);
    if (this.gWE != null)
    {
      str = this.gWE;
      GMTrace.o(13521765007360L, 100745);
      return str;
    }
    String str = super.toString();
    GMTrace.o(13521765007360L, 100745);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kernel/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */