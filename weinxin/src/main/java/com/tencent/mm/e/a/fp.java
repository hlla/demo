package com.tencent.mm.e.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.c.rq;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.y.k;
import java.util.List;

public final class fp
  extends b
{
  public a fKg;
  public b fKh;
  
  public fp()
  {
    this((byte)0);
    GMTrace.i(4345298944000L, 32375);
    GMTrace.o(4345298944000L, 32375);
  }
  
  private fp(byte paramByte)
  {
    GMTrace.i(4345433161728L, 32376);
    this.fKg = new a();
    this.fKh = new b();
    this.uqr = false;
    this.nDP = null;
    GMTrace.o(4345433161728L, 32376);
  }
  
  public static final class a
  {
    public Context context;
    public String desc;
    public k fFX;
    public long fFo;
    public ru fFt;
    public rl fKi;
    public Intent fKj;
    public j.a fKk;
    public Runnable fKl;
    public String fKm;
    public int fKn;
    public int fKo;
    public ad handler;
    public String path;
    public String title;
    public String toUser;
    public int type;
    
    public a()
    {
      GMTrace.i(4354962620416L, 32447);
      this.type = 0;
      this.fKn = 0;
      this.fKo = 0;
      GMTrace.o(4354962620416L, 32447);
    }
  }
  
  public static final class b
  {
    public List fKp;
    public String fKq;
    public rq fKr;
    public e fKs;
    public List fKt;
    public boolean fKu;
    public boolean fKv;
    public boolean fKw;
    public double fKx;
    public String path;
    public int ret;
    public String thumbUrl;
    
    public b()
    {
      GMTrace.i(4200478015488L, 31296);
      this.ret = -1;
      this.fKu = false;
      this.fKv = false;
      this.fKw = false;
      this.fKx = 0.0D;
      GMTrace.o(4200478015488L, 31296);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/a/fp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */