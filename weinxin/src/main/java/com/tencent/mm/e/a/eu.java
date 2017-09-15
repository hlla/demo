package com.tencent.mm.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.b.b;

public final class eu
  extends b
{
  public a fIP;
  public b fIQ;
  
  public eu()
  {
    this((byte)0);
    GMTrace.i(4359123369984L, 32478);
    GMTrace.o(4359123369984L, 32478);
  }
  
  private eu(byte paramByte)
  {
    GMTrace.i(4359257587712L, 32479);
    this.fIP = new a();
    this.fIQ = new b();
    this.uqr = false;
    this.nDP = null;
    GMTrace.o(4359257587712L, 32479);
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
      GMTrace.i(4374692626432L, 32594);
      this.fIk = 0;
      GMTrace.o(4374692626432L, 32594);
    }
  }
  
  public static final class b
  {
    public Cursor fIl;
    
    public b()
    {
      GMTrace.i(4311073423360L, 32120);
      GMTrace.o(4311073423360L, 32120);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/a/eu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */