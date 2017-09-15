package com.tencent.mm.ui.g.a;

import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public final class a
{
  c wdR;
  
  public a(c paramc)
  {
    GMTrace.i(2911987826688L, 21696);
    this.wdR = paramc;
    GMTrace.o(2911987826688L, 21696);
  }
  
  public static abstract interface a
  {
    public abstract void SM(String paramString);
    
    public abstract void a(FileNotFoundException paramFileNotFoundException);
    
    public abstract void a(IOException paramIOException);
    
    public abstract void a(MalformedURLException paramMalformedURLException);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/g/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */