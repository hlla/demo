package com.tencent.mm.y;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.k.a;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class q
  extends k.a
{
  private final k fFX;
  final ad handler;
  private final com.tencent.mm.network.e hsm;
  private final e hsr;
  private final long htb;
  private p htc;
  private j htd;
  private boolean hte;
  private boolean htf;
  Runnable htg;
  
  public q(p paramp, j paramj, k paramk, e parame, com.tencent.mm.network.e parame1)
  {
    GMTrace.i(13404190277632L, 99869);
    this.htb = 330000L;
    this.hte = false;
    this.htf = false;
    this.htg = new Runnable()
    {
      public final void run()
      {
        int k = 0;
        int j = 0;
        GMTrace.i(13399895310336L, 99837);
        int i;
        if ((q.a(q.this)) || (q.b(q.this)))
        {
          if (q.c(q.this) == null)
          {
            i = 0;
            if (q.c(q.this) != null) {
              break label102;
            }
          }
          for (;;)
          {
            v.e("MicroMsg.RemoteOnGYNetEnd", "time exceed But removeCallbacks failed hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            GMTrace.o(13399895310336L, 99837);
            return;
            i = q.c(q.this).hashCode();
            break;
            label102:
            j = q.c(q.this).getType();
          }
        }
        final boolean bool1 = q.a(q.this);
        final boolean bool2 = q.b(q.this);
        if (q.c(q.this) == null)
        {
          i = 0;
          if (q.c(q.this) != null) {
            break label256;
          }
        }
        label256:
        for (j = k;; j = q.c(q.this).getType())
        {
          v.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          q.d(q.this);
          com.tencent.mm.sdk.f.e.post(new Runnable()
          {
            public final void run()
            {
              int j = 0;
              GMTrace.i(13399626874880L, 99835);
              q.e(q.this).hw("push process's network haven't callback in 5.5min!!!! cancelStatus:" + bool1 + " hasCallbackStatus:" + bool2);
              int i;
              if (q.c(q.this) == null)
              {
                i = 0;
                if (q.c(q.this) != null) {
                  break label135;
                }
              }
              for (;;)
              {
                v.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback . kill push fin. hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                GMTrace.o(13399626874880L, 99835);
                return;
                i = q.c(q.this).hashCode();
                break;
                label135:
                j = q.c(q.this).getType();
              }
            }
          }, "RemoteOnGYNetEnd_killPush");
          q.g(q.this).a(-1, 3, -1, "time exceed, force to callback", q.f(q.this), null);
          GMTrace.o(13399895310336L, 99837);
          return;
          i = q.c(q.this).hashCode();
          break;
        }
      }
    };
    this.htc = paramp;
    this.htd = paramj;
    this.fFX = paramk;
    this.hsr = parame;
    if (Looper.myLooper() == null) {}
    for (paramp = new ad(Looper.getMainLooper());; paramp = new ad())
    {
      this.handler = paramp;
      this.hsm = parame1;
      GMTrace.o(13404190277632L, 99869);
      return;
    }
  }
  
  public final void a(final int paramInt1, final int paramInt2, final int paramInt3, final String paramString, com.tencent.mm.network.q paramq, final byte[] paramArrayOfByte)
  {
    GMTrace.i(13404458713088L, 99871);
    v.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.hte), Integer.valueOf(this.fFX.hashCode()), Integer.valueOf(this.htc.hashCode()) });
    this.fFX.hso = -1;
    if (this.hte)
    {
      GMTrace.o(13404458713088L, 99871);
      return;
    }
    if (!this.htf)
    {
      this.htf = true;
      this.handler.removeCallbacks(this.htg);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13424054501376L, 100017);
          if (q.a(q.this))
          {
            v.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", new Object[] { Integer.valueOf(paramInt1) });
            GMTrace.o(13424054501376L, 100017);
            return;
          }
          int k = paramInt2;
          int m = paramInt3;
          int i = k;
          int j = m;
          if (10016 == r.iiC)
          {
            i = k;
            j = m;
            if (!bf.mA(r.iiE))
            {
              v.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", new Object[] { r.iiE });
              String[] arrayOfString = r.iiE.split(",");
              i = k;
              j = m;
              if (arrayOfString != null)
              {
                i = k;
                j = m;
                if (arrayOfString.length == 3)
                {
                  i = k;
                  j = m;
                  if (bf.getInt(arrayOfString[0], -1) == q.c(q.this).getType())
                  {
                    k = bf.getInt(arrayOfString[1], 0);
                    j = bf.getInt(arrayOfString[2], 0);
                    i = k;
                    if (k == 999)
                    {
                      v.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", new Object[] { r.iiE });
                      GMTrace.o(13424054501376L, 100017);
                      return;
                    }
                  }
                }
              }
            }
          }
          v.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(q.a(q.this)), Integer.valueOf(q.c(q.this).hashCode()) });
          q.g(q.this).a(paramInt1, i, j, paramString, q.f(q.this), paramArrayOfByte);
          if ((q.c(q.this).BL()) && (!q.c(q.this).hss))
          {
            v.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", new Object[] { Integer.valueOf(q.c(q.this).getType()) });
            v.bIF();
          }
          GMTrace.o(13424054501376L, 100017);
        }
      });
      GMTrace.o(13404458713088L, 99871);
      return;
    }
    GMTrace.o(13404458713088L, 99871);
  }
  
  public final void cancel()
  {
    GMTrace.i(13404324495360L, 99870);
    this.hte = true;
    this.handler.removeCallbacks(this.htg);
    GMTrace.o(13404324495360L, 99870);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/y/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */