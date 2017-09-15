package com.tencent.mm.modelbiz.a;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bf;

public final class g
  extends i<com.tencent.mm.e.b.v>
{
  public static final String[] gUn;
  private e gUp;
  private final k<a, g.a.b> htP;
  
  static
  {
    GMTrace.i(4563671187456L, 34002);
    gUn = new String[] { i.a(f.gTF, "BizChatMyUserInfo") };
    GMTrace.o(4563671187456L, 34002);
  }
  
  public g(e parame)
  {
    super(parame, f.gTF, "BizChatMyUserInfo", null);
    GMTrace.i(4562865881088L, 33996);
    this.htP = new k() {};
    this.gUp = parame;
    parame.eE("BizChatMyUserInfo", "CREATE INDEX IF NOT EXISTS bizChatbrandUserNameIndex ON BizChatMyUserInfo ( brandUserName )");
    GMTrace.o(4562865881088L, 33996);
  }
  
  public final boolean a(f paramf)
  {
    GMTrace.i(4563268534272L, 33999);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert");
    boolean bool = super.b(paramf);
    if (bool)
    {
      g.a.b localb = new g.a.b();
      localb.fGj = paramf.field_brandUserName;
      localb.hwL = g.a.a.hwH;
      localb.hwM = paramf;
      this.htP.by(localb);
      this.htP.doNotify();
    }
    for (;;)
    {
      GMTrace.o(4563268534272L, 33999);
      return bool;
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert fail");
    }
  }
  
  public final boolean b(f paramf)
  {
    GMTrace.i(4563402752000L, 34000);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update");
    if (paramf == null)
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.BizChatMyUserInfoStorage", "update wrong argument");
      GMTrace.o(4563402752000L, 34000);
      return false;
    }
    boolean bool = super.a(paramf);
    if (bool)
    {
      g.a.b localb = new g.a.b();
      localb.fGj = paramf.field_brandUserName;
      localb.hwL = g.a.a.hwJ;
      localb.hwM = paramf;
      this.htP.by(localb);
      this.htP.doNotify();
    }
    for (;;)
    {
      GMTrace.o(4563402752000L, 34000);
      return bool;
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update fail");
    }
  }
  
  public final int getCount()
  {
    int i = 0;
    GMTrace.i(4563536969728L, 34001);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage getCount");
    Cursor localCursor = this.gUp.a("SELECT COUNT(*) FROM BizChatMyUserInfo", null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    GMTrace.o(4563536969728L, 34001);
    return i;
  }
  
  public final f iC(String paramString)
  {
    GMTrace.i(4563000098816L, 33997);
    if (bf.mA(paramString))
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.BizChatMyUserInfoStorage", "get： wrong argument");
      GMTrace.o(4563000098816L, 33997);
      return null;
    }
    f localf = new f();
    localf.field_brandUserName = paramString;
    super.b(localf, new String[0]);
    GMTrace.o(4563000098816L, 33997);
    return localf;
  }
  
  public final boolean iD(String paramString)
  {
    GMTrace.i(4563134316544L, 33998);
    if (bf.mA(paramString))
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.BizChatMyUserInfoStorage", "delete wrong argument");
      GMTrace.o(4563134316544L, 33998);
      return false;
    }
    f localf = new f();
    localf.field_brandUserName = paramString;
    boolean bool = super.a(localf, new String[] { "brandUserName" });
    if (bool)
    {
      paramString = new g.a.b();
      paramString.fGj = localf.field_brandUserName;
      paramString.hwL = g.a.a.hwI;
      paramString.hwM = localf;
      this.htP.by(paramString);
      this.htP.doNotify();
    }
    GMTrace.o(4563134316544L, 33998);
    return bool;
  }
  
  public static abstract interface a
  {
    public static enum a
    {
      static
      {
        GMTrace.i(4579374661632L, 34119);
        hwH = 1;
        hwI = 2;
        hwJ = 3;
        hwK = new int[] { hwH, hwI, hwJ };
        GMTrace.o(4579374661632L, 34119);
      }
    }
    
    public static final class b
    {
      public String fGj;
      public int hwL;
      public f hwM;
      
      public b()
      {
        GMTrace.i(4582461669376L, 34142);
        GMTrace.o(4582461669376L, 34142);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */