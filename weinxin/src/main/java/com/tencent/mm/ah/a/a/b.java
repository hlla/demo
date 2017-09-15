package com.tencent.mm.ah.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.a.b.d;
import com.tencent.mm.ah.a.c.j;
import com.tencent.mm.ah.a.c.k;
import com.tencent.mm.ah.a.c.l;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b
{
  public static final int hIc;
  public final Resources hId;
  public final int hIe;
  public final int hIf;
  public final c hIg;
  public final l hIh;
  public final com.tencent.mm.ah.a.c.a hIi;
  public final com.tencent.mm.ah.a.c.b hIj;
  public final com.tencent.mm.ah.a.c.f hIk;
  public final j hIl;
  public final k hIm;
  public final com.tencent.mm.ah.a.c.e hIn;
  public final com.tencent.mm.ah.a.c.h hIo;
  public final Executor hIp;
  public final String packageName;
  
  static
  {
    GMTrace.i(13726178607104L, 102268);
    hIc = Runtime.getRuntime().availableProcessors();
    GMTrace.o(13726178607104L, 102268);
  }
  
  public b(a parama)
  {
    GMTrace.i(13725910171648L, 102266);
    this.packageName = parama.context.getPackageName();
    this.hId = parama.context.getResources();
    this.hIe = parama.hIe;
    this.hIf = parama.hIf;
    this.hIg = parama.hIg;
    this.hIh = parama.hIh;
    this.hIi = parama.hIi;
    this.hIj = parama.hIj;
    this.hIk = parama.hIk;
    this.hIl = parama.hIl;
    this.hIo = parama.hIo;
    this.hIp = parama.hIp;
    this.hIm = parama.hIq;
    this.hIn = parama.hIn;
    GMTrace.o(13725910171648L, 102266);
  }
  
  public static b aX(Context paramContext)
  {
    GMTrace.i(13726044389376L, 102267);
    paramContext = new a(paramContext).Hg();
    GMTrace.o(13726044389376L, 102267);
    return paramContext;
  }
  
  public static final class a
  {
    public Context context;
    public int hIe;
    public int hIf;
    public c hIg;
    public l hIh;
    public com.tencent.mm.ah.a.c.a hIi;
    public com.tencent.mm.ah.a.c.b hIj;
    public com.tencent.mm.ah.a.c.f hIk;
    public j hIl;
    public com.tencent.mm.ah.a.c.e hIn;
    public com.tencent.mm.ah.a.c.h hIo;
    public Executor hIp;
    public k hIq;
    
    public a(Context paramContext)
    {
      GMTrace.i(13727655002112L, 102279);
      this.hIe = b.hIc;
      this.hIf = 5;
      this.hIg = null;
      this.hIh = null;
      this.hIi = null;
      this.hIj = null;
      this.hIk = null;
      this.hIl = null;
      this.hIq = null;
      this.hIn = null;
      this.hIo = null;
      this.context = paramContext.getApplicationContext();
      GMTrace.o(13727655002112L, 102279);
    }
    
    public final b Hg()
    {
      GMTrace.i(13727789219840L, 102280);
      if (this.hIg == null) {
        this.hIg = new c.a().Hh();
      }
      if (this.hIh == null) {
        this.hIh = new com.tencent.mm.ah.a.b.f();
      }
      if (this.hIi == null) {
        this.hIi = new com.tencent.mm.ah.a.b.a();
      }
      if (this.hIj == null) {
        this.hIj = new com.tencent.mm.ah.a.b.b();
      }
      if (this.hIk == null) {
        this.hIk = new d();
      }
      if (this.hIl == null) {
        this.hIl = new com.tencent.mm.ah.a.b.h();
      }
      if (this.hIo == null) {
        this.hIo = a.aN(this.hIe, this.hIf);
      }
      if (this.hIp == null) {
        this.hIp = Executors.newSingleThreadExecutor();
      }
      if (this.hIq == null) {
        this.hIq = new com.tencent.mm.ah.a.b.e();
      }
      if (this.hIn == null) {
        this.hIn = new com.tencent.mm.ah.a.b.c();
      }
      b localb = new b(this);
      GMTrace.o(13727789219840L, 102280);
      return localb;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */