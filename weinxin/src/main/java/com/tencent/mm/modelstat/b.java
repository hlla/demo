package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.ny;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

public final class b
{
  public static b hTV;
  public log_13835 hTU;
  private com.tencent.mm.sdk.b.c hTW;
  private int hTX;
  private int hTY;
  private boolean hasInit;
  public Object lock;
  
  static
  {
    GMTrace.i(1400293556224L, 10433);
    hTV = new b();
    GMTrace.o(1400293556224L, 10433);
  }
  
  private b()
  {
    GMTrace.i(1398011854848L, 10416);
    this.lock = new Object();
    this.hTW = new com.tencent.mm.sdk.b.c() {};
    this.hTX = 1;
    this.hTY = 1;
    this.hasInit = false;
    a.uql.a(this.hTW);
    GMTrace.o(1398011854848L, 10416);
  }
  
  private String JT()
  {
    GMTrace.i(16173773094912L, 120504);
    if (this.hTU == null)
    {
      GMTrace.o(16173773094912L, 120504);
      return "";
    }
    Object localObject1 = ",";
    Object localObject4 = new LinkedList();
    for (;;)
    {
      Object localObject5;
      synchronized (this.lock)
      {
        ((LinkedList)localObject4).addAll(this.hTU.oplist_);
        Iterator localIterator = ((LinkedList)localObject4).iterator();
        int i = 1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject5 = (IMBehavior)localIterator.next();
        ??? = localObject1;
        if (i == 0) {
          ??? = (String)localObject1 + "|";
        }
        localObject1 = (String)??? + ((IMBehavior)localObject5).opType + "#";
        if (((IMBehavior)localObject5).opType == 1)
        {
          StringBuilder localStringBuilder = new StringBuilder().append((String)localObject1);
          localObject5 = ((IMBehavior)localObject5).chattingOp;
          ??? = "";
          if (((IMBehaviorChattingOP)localObject5).changeUnread != 0) {
            ??? = "" + "changeUnread=" + ((IMBehaviorChattingOP)localObject5).changeUnread;
          }
          localObject1 = ???;
          if (((IMBehaviorChattingOP)localObject5).changeTop != 0) {
            localObject1 = (String)??? + "changeTop=" + ((IMBehaviorChattingOP)localObject5).changeTop;
          }
          localObject4 = localObject1;
          if (((IMBehaviorChattingOP)localObject5).changeNotifyStatus != 0) {
            localObject4 = (String)localObject1 + "changeNotifyStatus=" + ((IMBehaviorChattingOP)localObject5).changeNotifyStatus;
          }
          ??? = localObject4;
          if (((IMBehaviorChattingOP)localObject5).changeSaveAddress != 0) {
            ??? = (String)localObject4 + "changeSaveAddress=" + ((IMBehaviorChattingOP)localObject5).changeSaveAddress;
          }
          localObject1 = ???;
          localObject4 = localStringBuilder;
          if (((IMBehaviorChattingOP)localObject5).expose != 0)
          {
            localObject1 = (String)??? + "expose=" + ((IMBehaviorChattingOP)localObject5).expose;
            localObject4 = localStringBuilder;
          }
          localObject1 = (String)localObject1;
          i = 0;
        }
      }
      localObject4 = new StringBuilder().append(str);
      localObject2 = ((IMBehavior)localObject5).msgOp;
      if (((IMBehaviorMsgOP)localObject2).msgType == 49) {
        localObject2 = String.format(Locale.US, "msgType=%d&msgOpType=%d&appMsgInnerType=%d&count=%d", new Object[] { Integer.valueOf(((IMBehaviorMsgOP)localObject2).msgType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).msgOpType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).appMsgInnerType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).count) });
      } else {
        localObject2 = String.format(Locale.US, "msgType=%d&msgOpType=%d&count=%d", new Object[] { Integer.valueOf(((IMBehaviorMsgOP)localObject2).msgType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).msgOpType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).count) });
      }
    }
    Object localObject2 = (String)localObject2 + "," + this.hTU.currChatName_;
    GMTrace.o(16173773094912L, 120504);
    return (String)localObject2;
  }
  
  public final void A(String arg1, boolean paramBoolean)
  {
    int i = 1;
    GMTrace.i(1398414508032L, 10419);
    if (!JU())
    {
      GMTrace.o(1398414508032L, 10419);
      return;
    }
    IMBehavior localIMBehavior = new IMBehavior();
    localIMBehavior.opType = 1;
    localIMBehavior.chattingOp = new IMBehaviorChattingOP();
    IMBehaviorChattingOP localIMBehaviorChattingOP = localIMBehavior.chattingOp;
    if (paramBoolean) {}
    for (;;)
    {
      localIMBehaviorChattingOP.changeUnread = i;
      qg();
      if (ba(???)) {
        break;
      }
      GMTrace.o(1398414508032L, 10419);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.hTU.oplist_.add(localIMBehavior);
      qg();
      GMTrace.o(1398414508032L, 10419);
      return;
    }
  }
  
  public final void B(String paramString, boolean paramBoolean)
  {
    int i = 1;
    GMTrace.i(1398682943488L, 10421);
    if (!JU())
    {
      GMTrace.o(1398682943488L, 10421);
      return;
    }
    if (!ba(paramString))
    {
      GMTrace.o(1398682943488L, 10421);
      return;
    }
    paramString = new IMBehavior();
    paramString.opType = 1;
    paramString.chattingOp = new IMBehaviorChattingOP();
    ??? = paramString.chattingOp;
    if (paramBoolean) {}
    for (;;)
    {
      ((IMBehaviorChattingOP)???).changeSaveAddress = i;
      synchronized (this.lock)
      {
        this.hTU.oplist_.add(paramString);
        GMTrace.o(1398682943488L, 10421);
        return;
        i = 2;
      }
    }
  }
  
  public final boolean JU()
  {
    GMTrace.i(1400159338496L, 10432);
    if (!this.hasInit)
    {
      this.hasInit = true;
      com.tencent.mm.storage.c localc = com.tencent.mm.u.c.c.Az().dX("100148");
      if (localc.isValid()) {
        this.hTX = bf.getInt((String)localc.bKA().get("needUploadData"), 1);
      }
      localc = com.tencent.mm.u.c.c.Az().dX("100149");
      if (localc.isValid()) {
        this.hTY = bf.getInt((String)localc.bKA().get("needUploadData"), 1);
      }
    }
    if ((this.hTX != 0) || (this.hTY != 0))
    {
      GMTrace.o(1400159338496L, 10432);
      return true;
    }
    GMTrace.o(1400159338496L, 10432);
    return false;
  }
  
  public final void a(final au paramau, final int paramInt)
  {
    GMTrace.i(14592554041344L, 108723);
    new ad(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1387274436608L, 10336);
        b.this.b(paramau, paramInt);
        GMTrace.o(1387274436608L, 10336);
      }
    });
    GMTrace.o(14592554041344L, 108723);
  }
  
  public final void a(au arg1, b paramb, int paramInt)
  {
    GMTrace.i(14592419823616L, 108722);
    if (!ba(???.field_talker))
    {
      GMTrace.o(14592419823616L, 108722);
      return;
    }
    IMBehavior localIMBehavior1 = new IMBehavior();
    localIMBehavior1.opType = 2;
    localIMBehavior1.msgOp = new IMBehaviorMsgOP();
    localIMBehavior1.msgOp.msgType = (???.field_type & 0xFFFF);
    if (???.axH()) {
      localIMBehavior1.msgOp.appMsgInnerType = paramInt;
    }
    localIMBehavior1.msgOp.msgOpType = paramb.value;
    localIMBehavior1.msgOp.count = 1;
    synchronized (this.lock)
    {
      if (localIMBehavior1.opType == a.hUc.value)
      {
        this.hTU.oplist_.add(localIMBehavior1);
        GMTrace.o(14592419823616L, 108722);
        return;
      }
      paramb = this.hTU.oplist_.iterator();
      while (paramb.hasNext())
      {
        IMBehavior localIMBehavior2 = (IMBehavior)paramb.next();
        if (localIMBehavior2.opType == a.hUd.value)
        {
          IMBehaviorMsgOP localIMBehaviorMsgOP1 = localIMBehavior2.msgOp;
          IMBehaviorMsgOP localIMBehaviorMsgOP2 = localIMBehavior1.msgOp;
          if ((localIMBehaviorMsgOP1.msgOpType == localIMBehaviorMsgOP2.msgOpType) && (localIMBehaviorMsgOP1.msgType == localIMBehaviorMsgOP2.msgType) && (localIMBehaviorMsgOP1.appMsgInnerType == localIMBehaviorMsgOP2.appMsgInnerType)) {}
          for (paramInt = 1; paramInt != 0; paramInt = 0)
          {
            paramb = localIMBehavior2.msgOp;
            paramb.count += 1;
            GMTrace.o(14592419823616L, 108722);
            return;
          }
        }
      }
      this.hTU.oplist_.add(localIMBehavior1);
      GMTrace.o(14592419823616L, 108722);
      return;
    }
  }
  
  public final void a(au paramau, boolean paramBoolean)
  {
    GMTrace.i(1399622467584L, 10428);
    if (!JU())
    {
      GMTrace.o(1399622467584L, 10428);
      return;
    }
    if (!paramau.bMa())
    {
      GMTrace.o(1399622467584L, 10428);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.hUn;; localb = b.hUo)
    {
      a(paramau, localb, 0);
      GMTrace.o(1399622467584L, 10428);
      return;
    }
  }
  
  public final void b(au paramau, int paramInt)
  {
    GMTrace.i(16087336878080L, 119860);
    if (!JU())
    {
      GMTrace.o(16087336878080L, 119860);
      return;
    }
    a(paramau, b.hUi, paramInt);
    GMTrace.o(16087336878080L, 119860);
  }
  
  public final void b(boolean paramBoolean1, String arg2, boolean paramBoolean2)
  {
    int i = 1;
    GMTrace.i(1398548725760L, 10420);
    if (!JU())
    {
      GMTrace.o(1398548725760L, 10420);
      return;
    }
    IMBehavior localIMBehavior = new IMBehavior();
    localIMBehavior.opType = 1;
    localIMBehavior.chattingOp = new IMBehaviorChattingOP();
    IMBehaviorChattingOP localIMBehaviorChattingOP = localIMBehavior.chattingOp;
    if (paramBoolean2) {}
    for (;;)
    {
      localIMBehaviorChattingOP.changeTop = i;
      if (paramBoolean1) {
        qg();
      }
      if (ba(???)) {
        break;
      }
      GMTrace.o(1398548725760L, 10420);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.hTU.oplist_.add(localIMBehavior);
      if (paramBoolean1) {
        qg();
      }
      GMTrace.o(1398548725760L, 10420);
      return;
    }
  }
  
  public final boolean ba(String paramString)
  {
    GMTrace.i(1398146072576L, 10417);
    if (bf.mA(paramString))
    {
      paramString = bf.bJP().toString();
      v.e("MicroMsg.ChattingOperationUitl", "check error:%s", new Object[] { paramString });
      log_13913 locallog_13913 = new log_13913();
      locallog_13913.scene_ = 1;
      locallog_13913.error_ = paramString;
      g.oSF.b(13913, locallog_13913);
      GMTrace.o(1398146072576L, 10417);
      return false;
    }
    if ((this.hTU != null) && (!this.hTU.currChatName_.equals(paramString))) {
      qg();
    }
    if (this.hTU == null)
    {
      this.hTU = new log_13835();
      this.hTU.currChatName_ = paramString;
    }
    GMTrace.o(1398146072576L, 10417);
    return true;
  }
  
  public final void c(au paramau, int paramInt)
  {
    GMTrace.i(14592688259072L, 108724);
    if (!JU())
    {
      GMTrace.o(14592688259072L, 108724);
      return;
    }
    a(paramau, b.hUj, paramInt);
    GMTrace.o(14592688259072L, 108724);
  }
  
  public final void d(au paramau, int paramInt)
  {
    GMTrace.i(14592822476800L, 108725);
    if (!JU())
    {
      GMTrace.o(14592822476800L, 108725);
      return;
    }
    a(paramau, b.hUl, paramInt);
    GMTrace.o(14592822476800L, 108725);
  }
  
  public final void e(au paramau, int paramInt)
  {
    GMTrace.i(14592956694528L, 108726);
    if (!JU())
    {
      GMTrace.o(14592956694528L, 108726);
      return;
    }
    a(paramau, b.hUh, paramInt);
    GMTrace.o(14592956694528L, 108726);
  }
  
  public final void f(final au paramau)
  {
    GMTrace.i(1398951378944L, 10423);
    new ad(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(14593359347712L, 108729);
        b.this.b(paramau, 0);
        GMTrace.o(14593359347712L, 108729);
      }
    });
    GMTrace.o(1398951378944L, 10423);
  }
  
  public final void qg()
  {
    GMTrace.i(1398280290304L, 10418);
    if (!JU())
    {
      GMTrace.o(1398280290304L, 10418);
      return;
    }
    synchronized (this.lock)
    {
      if ((this.hTU != null) && (!this.hTU.oplist_.isEmpty()))
      {
        i = 1;
        if (i != 0)
        {
          if (this.hTY != 0)
          {
            v.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
            g.oSF.b(13835, this.hTU);
          }
          if (this.hTX != 0)
          {
            ??? = JT();
            v.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", new Object[] { ??? });
            g.oSF.A(13748, (String)???);
          }
        }
        this.hTU = null;
        GMTrace.o(1398280290304L, 10418);
        return;
      }
      int i = 0;
    }
  }
  
  public final void t(au paramau)
  {
    GMTrace.i(1399085596672L, 10424);
    if (!JU())
    {
      GMTrace.o(1399085596672L, 10424);
      return;
    }
    a(paramau, b.hUj, 0);
    GMTrace.o(1399085596672L, 10424);
  }
  
  public final void u(au paramau)
  {
    GMTrace.i(1399219814400L, 10425);
    if (!JU())
    {
      GMTrace.o(1399219814400L, 10425);
      return;
    }
    a(paramau, b.hUl, 0);
    GMTrace.o(1399219814400L, 10425);
  }
  
  public final void v(au paramau)
  {
    GMTrace.i(1399354032128L, 10426);
    if (!JU())
    {
      GMTrace.o(1399354032128L, 10426);
      return;
    }
    a(paramau, b.hUh, 0);
    GMTrace.o(1399354032128L, 10426);
  }
  
  public final void w(au paramau)
  {
    GMTrace.i(1399488249856L, 10427);
    if (!JU())
    {
      GMTrace.o(1399488249856L, 10427);
      return;
    }
    a(paramau, b.hUm, 0);
    GMTrace.o(1399488249856L, 10427);
  }
  
  public final void x(au paramau)
  {
    GMTrace.i(1399756685312L, 10429);
    if (!JU())
    {
      GMTrace.o(1399756685312L, 10429);
      return;
    }
    if (!paramau.bMa())
    {
      GMTrace.o(1399756685312L, 10429);
      return;
    }
    a(paramau, b.hUp, 0);
    GMTrace.o(1399756685312L, 10429);
  }
  
  public final void y(au paramau)
  {
    GMTrace.i(1399890903040L, 10430);
    if (!JU())
    {
      GMTrace.o(1399890903040L, 10430);
      return;
    }
    a(paramau, b.hUq, 0);
    GMTrace.o(1399890903040L, 10430);
  }
  
  public static enum a
  {
    public int value;
    
    static
    {
      GMTrace.i(1376805453824L, 10258);
      hUc = new a("OP_Chatting", 0, 1);
      hUd = new a("OP_Msg", 1, 2);
      hUe = new a[] { hUc, hUd };
      GMTrace.o(1376805453824L, 10258);
    }
    
    private a(int paramInt)
    {
      GMTrace.i(1376671236096L, 10257);
      this.value = 0;
      this.value = paramInt;
      GMTrace.o(1376671236096L, 10257);
    }
  }
  
  public static enum b
  {
    public int value;
    
    static
    {
      GMTrace.i(1402038386688L, 10446);
      hUf = new b("UnKnownType", 0, 0);
      hUg = new b("expourse", 1, 1);
      hUh = new b("click", 2, 2);
      hUi = new b("send", 3, 3);
      hUj = new b("fav", 4, 4);
      hUk = new b("revoke", 5, 5);
      hUl = new b("delete", 6, 6);
      hUm = new b("voiceToText", 7, 7);
      hUn = new b("translate", 8, 8);
      hUo = new b("translateHidden", 9, 9);
      hUp = new b("doubleClickText", 10, 10);
      hUq = new b("imageSaveToLocal", 11, 11);
      hUr = new b("playMusic", 12, 12);
      hUs = new b("stopMusic", 13, 13);
      hUt = new b[] { hUf, hUg, hUh, hUi, hUj, hUk, hUl, hUm, hUn, hUo, hUp, hUq, hUr, hUs };
      GMTrace.o(1402038386688L, 10446);
    }
    
    private b(int paramInt)
    {
      GMTrace.i(1401904168960L, 10445);
      this.value = 0;
      this.value = paramInt;
      GMTrace.o(1401904168960L, 10445);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelstat/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */