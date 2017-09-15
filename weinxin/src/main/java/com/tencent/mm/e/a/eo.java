package com.tencent.mm.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.b.b;

public final class eo
  extends b
{
  public a fIi;
  public b fIj;
  
  public eo()
  {
    this((byte)0);
    GMTrace.i(4213094481920L, 31390);
    GMTrace.o(4213094481920L, 31390);
  }
  
  private eo(byte paramByte)
  {
    GMTrace.i(4213228699648L, 31391);
    this.fIi = new a();
    this.fIj = new b();
    this.uqr = false;
    this.nDP = null;
    GMTrace.o(4213228699648L, 31391);
  }
  
  public static final class a
  {
    public Context context;
    public String[] fCk;
    public int fIk;
    public String[] selectionArgs;
    public Uri uri;
    
    public a()
    {
      GMTrace.i(4276176814080L, 31860);
      this.fIk = 0;
      GMTrace.o(4276176814080L, 31860);
    }
  }
  
  public static final class b
  {
    public Cursor fIl;
    
    public b()
    {
      GMTrace.i(4258057420800L, 31725);
      GMTrace.o(4258057420800L, 31725);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/a/eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */