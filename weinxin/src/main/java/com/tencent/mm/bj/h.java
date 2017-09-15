package com.tencent.mm.bj;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class h
{
  private ai fyz;
  public g uKd;
  private BlockingQueue<a> uKv;
  private String uvu;
  
  public h(g paramg, String paramString)
  {
    GMTrace.i(13559614406656L, 101027);
    this.uvu = null;
    this.fyz = new ai(Looper.getMainLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(13564714680320L, 101065);
        if (!h.this.uKd.isOpen())
        {
          GMTrace.o(13564714680320L, 101065);
          return false;
        }
        h.this.bNE();
        GMTrace.o(13564714680320L, 101065);
        return false;
      }
    }, false);
    this.uKv = new LinkedBlockingQueue();
    this.uKd = paramg;
    this.uvu = paramString;
    GMTrace.o(13559614406656L, 101027);
  }
  
  final int a(a parama)
  {
    GMTrace.i(13559882842112L, 101029);
    this.uKv.add(parama);
    if (this.uKv.size() >= 40) {
      bNE();
    }
    if (this.fyz.bJg()) {
      this.fyz.v(60000L, 60000L);
    }
    GMTrace.o(13559882842112L, 101029);
    return 0;
  }
  
  public final int bNE()
  {
    GMTrace.i(13559748624384L, 101028);
    v.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", new Object[] { this.uvu, Boolean.valueOf(this.uKd.inTransaction()), Integer.valueOf(this.uKv.size()) });
    if (this.uKv.isEmpty())
    {
      GMTrace.o(13559748624384L, 101028);
      return 0;
    }
    long l;
    if (!this.uKd.inTransaction()) {
      l = this.uKd.cs(Thread.currentThread().getId());
    }
    for (;;)
    {
      if (!this.uKv.isEmpty())
      {
        a locala = (a)this.uKv.poll();
        if (locala == null) {
          v.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", new Object[] { this.uvu });
        } else if ((this.uKd == null) || (!this.uKd.isOpen())) {
          v.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", new Object[] { this.uvu });
        } else if (locala.utu == 2) {
          this.uKd.insert(this.uvu, locala.uvq, locala.values);
        } else if (locala.utu == 5) {
          this.uKd.delete(this.uvu, locala.uKx, locala.uKy);
        } else if (locala.utu == 1) {
          this.uKd.eE(this.uvu, locala.uvs);
        } else if (locala.utu == 4) {
          this.uKd.replace(this.uvu, locala.uvq, locala.values);
        } else if (locala.utu == 3) {
          this.uKd.update(this.uvu, locala.values, locala.uKx, locala.uKy);
        }
      }
      else
      {
        if (l > 0L) {
          this.uKd.aD(l);
        }
        GMTrace.o(13559748624384L, 101028);
        return 0;
        l = 0L;
      }
    }
  }
  
  public static final class a
  {
    public String uKx;
    public String[] uKy;
    public int utu;
    public String uvq;
    public String uvs;
    public ContentValues values;
    
    public a()
    {
      GMTrace.i(13564983115776L, 101067);
      GMTrace.o(13564983115776L, 101067);
    }
    
    public final void G(String[] paramArrayOfString)
    {
      GMTrace.i(13565117333504L, 101068);
      if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
      {
        GMTrace.o(13565117333504L, 101068);
        return;
      }
      this.uKy = new String[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        this.uKy[i] = new String(paramArrayOfString[i]);
        i += 1;
      }
      GMTrace.o(13565117333504L, 101068);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bj/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */