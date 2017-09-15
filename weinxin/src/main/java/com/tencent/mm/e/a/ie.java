package com.tencent.mm.e.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.g.c;
import com.tencent.mm.sdk.b.b;

public final class ie
  extends b
{
  public b fNA;
  public a fNz;
  
  public ie()
  {
    this((byte)0);
    GMTrace.i(4205175635968L, 31331);
    GMTrace.o(4205175635968L, 31331);
  }
  
  private ie(byte paramByte)
  {
    GMTrace.i(4205309853696L, 31332);
    this.fNz = new a();
    this.fNA = new b();
    this.uqr = false;
    this.nDP = null;
    GMTrace.o(4205309853696L, 31332);
  }
  
  public static final class a
  {
    public String appId;
    public Context context;
    public Bundle fFl;
    public WXMediaMessage fNB;
    public g.c fNC;
    public int showType;
    
    public a()
    {
      GMTrace.i(4249870139392L, 31664);
      GMTrace.o(4249870139392L, 31664);
    }
  }
  
  public static final class b
  {
    public boolean fND;
    
    public b()
    {
      GMTrace.i(15355447607296L, 114407);
      GMTrace.o(15355447607296L, 114407);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/a/ie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */