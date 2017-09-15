package com.tencent.mm.modelbiz.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelbiz.n;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;

public final class b
  extends i<a>
  implements m.b
{
  public static final String[] gUn;
  public com.tencent.mm.sdk.e.e gUp;
  final k<a, b.a.b> htP;
  
  static
  {
    GMTrace.i(4576153436160L, 34095);
    gUn = new String[] { i.a(a.gTF, "BizChatConversation") };
    GMTrace.o(4576153436160L, 34095);
  }
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.gTF, "BizChatConversation", null);
    GMTrace.i(4573603299328L, 34076);
    this.htP = new k() {};
    this.gUp = parame;
    parame.eE("BizChatConversation", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatConversation ( bizChatId )");
    parame.eE("BizChatConversation", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatConversation ( brandUserName )");
    parame.eE("BizChatConversation", "CREATE INDEX IF NOT EXISTS unreadCountIndex ON BizChatConversation ( unReadCount )");
    int j = 0;
    Cursor localCursor = parame.a("PRAGMA table_info( BizChatConversation)", null, 2);
    do
    {
      i = j;
      if (!localCursor.moveToNext()) {
        break;
      }
      i = localCursor.getColumnIndex("name");
    } while ((i < 0) || (!"flag".equalsIgnoreCase(localCursor.getString(i))));
    int i = 1;
    localCursor.close();
    if (i == 0) {
      parame.eE("BizChatConversation", "update BizChatConversation set flag = lastMsgTime");
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().a(this);
    GMTrace.o(4573603299328L, 34076);
  }
  
  public static long a(a parama, int paramInt, long paramLong)
  {
    GMTrace.i(4575213912064L, 34088);
    if (parama == null)
    {
      GMTrace.o(4575213912064L, 34088);
      return 0L;
    }
    if (paramLong != 0L) {}
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        paramLong = a(parama, paramLong);
        GMTrace.o(4575213912064L, 34088);
        return paramLong;
        paramLong = bf.NA();
      }
    }
    paramLong = a(parama, paramLong);
    GMTrace.o(4575213912064L, 34088);
    return paramLong | 0x4000000000000000;
    paramLong = a(parama, paramLong);
    GMTrace.o(4575213912064L, 34088);
    return paramLong & 0xBFFFFFFFFFFFFFFF;
    paramLong = a(parama, paramLong);
    GMTrace.o(4575213912064L, 34088);
    return paramLong & 0x4000000000000000;
  }
  
  private static long a(a parama, long paramLong)
  {
    GMTrace.i(4575348129792L, 34089);
    long l = parama.field_flag;
    GMTrace.o(4575348129792L, 34089);
    return l & 0xFF00000000000000 | 0xFFFFFFFFFFFFFF & paramLong;
  }
  
  public static void a(a parama, int paramInt1, int paramInt2)
  {
    GMTrace.i(4574945476608L, 34086);
    if (parama.field_msgCount == 0)
    {
      String str = parama.field_brandUserName;
      long l = parama.field_bizChatId;
      parama.field_msgCount = ((n)com.tencent.mm.kernel.h.h(n.class)).wU().ah(str, l);
      v.i("MicroMsg.BizConversationStorage", "getMsgCount from message table");
    }
    for (;;)
    {
      v.i("MicroMsg.BizConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[] { Integer.valueOf(parama.field_msgCount), Long.valueOf(parama.field_bizChatId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      GMTrace.o(4574945476608L, 34086);
      return;
      if (paramInt1 > 0)
      {
        parama.field_msgCount -= paramInt1;
        if (parama.field_msgCount < 0)
        {
          v.e("MicroMsg.BizConversationStorage", "msg < 0 ,some path must be ignore!");
          parama.field_msgCount = 0;
        }
      }
      else if (paramInt2 > 0)
      {
        parama.field_msgCount += paramInt2;
      }
    }
  }
  
  public static boolean c(a parama)
  {
    GMTrace.i(4575616565248L, 34091);
    if (parama == null)
    {
      v.e("MicroMsg.BizConversationStorage", "isPlacedTop failed, conversation null");
      GMTrace.o(4575616565248L, 34091);
      return false;
    }
    if (a(parama, 4, 0L) != 0L)
    {
      GMTrace.o(4575616565248L, 34091);
      return true;
    }
    GMTrace.o(4575616565248L, 34091);
    return false;
  }
  
  public final a U(long paramLong)
  {
    GMTrace.i(4574274387968L, 34081);
    a locala = new a();
    locala.field_bizChatId = paramLong;
    super.b(locala, new String[0]);
    GMTrace.o(4574274387968L, 34081);
    return locala;
  }
  
  public final boolean V(long paramLong)
  {
    GMTrace.i(4574408605696L, 34082);
    a locala = U(paramLong);
    boolean bool = super.a(locala, new String[] { "bizChatId" });
    if (bool)
    {
      b.a.b localb = new b.a.b();
      localb.hwo = locala.field_bizChatId;
      localb.fGj = locala.field_brandUserName;
      localb.hwn = b.a.a.hwk;
      localb.hwp = locala;
      this.htP.by(localb);
      this.htP.doNotify();
    }
    GMTrace.o(4574408605696L, 34082);
    return bool;
  }
  
  public final boolean W(long paramLong)
  {
    GMTrace.i(4575079694336L, 34087);
    a locala = U(paramLong);
    if ((locala.field_unReadCount == 0) && (locala.field_bizChatId == paramLong))
    {
      GMTrace.o(4575079694336L, 34087);
      return true;
    }
    locala.field_unReadCount = 0;
    locala.field_atCount = 0;
    b(locala);
    GMTrace.o(4575079694336L, 34087);
    return true;
  }
  
  public final boolean X(long paramLong)
  {
    GMTrace.i(4575482347520L, 34090);
    boolean bool = c(U(paramLong));
    GMTrace.o(4575482347520L, 34090);
    return bool;
  }
  
  public final boolean Y(long paramLong)
  {
    GMTrace.i(4575750782976L, 34092);
    U(paramLong);
    a locala = U(paramLong);
    boolean bool = this.gUp.eE("BizChatConversation", "update BizChatConversation set flag = " + a(locala, 2, 0L) + " where bizChatId = " + locala.field_bizChatId);
    if (bool)
    {
      locala = U(locala.field_bizChatId);
      b.a.b localb = new b.a.b();
      localb.hwo = locala.field_bizChatId;
      localb.fGj = locala.field_brandUserName;
      localb.hwn = b.a.a.hwl;
      localb.hwp = locala;
      this.htP.by(localb);
      this.htP.doNotify();
    }
    GMTrace.o(4575750782976L, 34092);
    return bool;
  }
  
  public final boolean Z(long paramLong)
  {
    GMTrace.i(4575885000704L, 34093);
    a locala = U(paramLong);
    boolean bool = this.gUp.eE("BizChatConversation", "update BizChatConversation set flag = " + a(locala, 3, locala.field_lastMsgTime) + " where bizChatId = " + locala.field_bizChatId);
    if (bool)
    {
      locala = U(locala.field_bizChatId);
      b.a.b localb = new b.a.b();
      localb.hwo = locala.field_bizChatId;
      localb.fGj = locala.field_brandUserName;
      localb.hwn = b.a.a.hwl;
      localb.hwp = locala;
      this.htP.by(localb);
      this.htP.doNotify();
    }
    GMTrace.o(4575885000704L, 34093);
    return bool;
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    GMTrace.i(4574140170240L, 34080);
    v.i("MicroMsg.BizConversationStorage", "onNotifyChange");
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      GMTrace.o(4574140170240L, 34080);
      return;
    }
    paramm = (String)paramObject;
    if ((com.tencent.mm.modelbiz.e.dr(paramm)) && (!com.tencent.mm.u.o.eU(paramm))) {
      e.u(paramm, true);
    }
    GMTrace.o(4574140170240L, 34080);
  }
  
  public final void a(a parama)
  {
    GMTrace.i(4574005952512L, 34079);
    if (this.htP != null) {
      this.htP.remove(parama);
    }
    GMTrace.o(4574005952512L, 34079);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    GMTrace.i(4573871734784L, 34078);
    this.htP.a(parama, paramLooper);
    GMTrace.o(4573871734784L, 34078);
  }
  
  public final boolean a(a parama)
  {
    GMTrace.i(4574542823424L, 34083);
    v.d("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert");
    if (parama == null)
    {
      v.w("MicroMsg.BizConversationStorage", "insert wrong argument");
      GMTrace.o(4574542823424L, 34083);
      return false;
    }
    boolean bool = super.b(parama);
    v.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert res:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      b.a.b localb = new b.a.b();
      localb.hwo = parama.field_bizChatId;
      localb.fGj = parama.field_brandUserName;
      localb.hwn = b.a.a.hwj;
      localb.hwp = parama;
      this.htP.by(localb);
      this.htP.doNotify();
    }
    GMTrace.o(4574542823424L, 34083);
    return bool;
  }
  
  public final boolean b(a parama)
  {
    GMTrace.i(4574677041152L, 34084);
    if (parama == null)
    {
      v.w("MicroMsg.BizConversationStorage", "update wrong argument");
      GMTrace.o(4574677041152L, 34084);
      return false;
    }
    boolean bool = super.a(parama);
    v.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage update res:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      e.g(w.DJ().aa(parama.field_bizChatId));
      b.a.b localb = new b.a.b();
      localb.hwo = parama.field_bizChatId;
      localb.fGj = parama.field_brandUserName;
      localb.hwn = b.a.a.hwl;
      localb.hwp = parama;
      this.htP.by(localb);
      this.htP.doNotify();
    }
    GMTrace.o(4574677041152L, 34084);
    return bool;
  }
  
  protected final void finalize()
  {
    GMTrace.i(4573737517056L, 34077);
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().b(this);
    GMTrace.o(4573737517056L, 34077);
  }
  
  public final Cursor ip(String paramString)
  {
    GMTrace.i(4574811258880L, 34085);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from BizChatConversation");
    localStringBuilder.append(" where brandUserName = '").append(paramString).append("'");
    localStringBuilder.append(" order by flag desc , ").append("lastMsgTime desc");
    v.d("MicroMsg.BizConversationStorage", "getBizChatConversationCursor: sql:%s", new Object[] { localStringBuilder.toString() });
    paramString = this.gUp.rawQuery(localStringBuilder.toString(), null);
    GMTrace.o(4574811258880L, 34085);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public static enum a
    {
      static
      {
        GMTrace.i(4576421871616L, 34097);
        hwj = 1;
        hwk = 2;
        hwl = 3;
        hwm = new int[] { hwj, hwk, hwl };
        GMTrace.o(4576421871616L, 34097);
      }
    }
    
    public static final class b
    {
      public String fGj;
      public int hwn;
      public long hwo;
      public a hwp;
      
      public b()
      {
        GMTrace.i(4582595887104L, 34143);
        GMTrace.o(4582595887104L, 34143);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */