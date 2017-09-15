package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

public final class c
  extends com.tencent.mm.sandbox.monitor.c
{
  public String fvg;
  public boolean hJL;
  public int kbu;
  public String mKq;
  public b.a uoG;
  private String[] uoM;
  private a uoN;
  public boolean uoO;
  public ad uoP;
  private b.a uoQ;
  
  public c(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    super(paramInt1, paramString1, paramInt2, paramBoolean);
    GMTrace.i(3595156062208L, 26786);
    this.uoN = null;
    this.kbu = 0;
    this.uoO = false;
    this.hJL = false;
    this.uoP = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(3597974634496L, 26807);
        if ((1 == paramAnonymousMessage.what) && (!c.this.hJL))
        {
          new File(c.this.aLu()).delete();
          if (paramAnonymousMessage.arg1 != 0) {
            break label97;
          }
          v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
          c.this.uoG.a(200, 0, (avm)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          GMTrace.o(3597974634496L, 26807);
          return;
          label97:
          if (paramAnonymousMessage.arg1 == 3) {
            c.this.uoG.a(3, -1, (avm)paramAnonymousMessage.obj);
          } else if (paramAnonymousMessage.arg1 == 4) {
            c.this.uoG.a(4, -1, (avm)paramAnonymousMessage.obj);
          }
        }
      }
    };
    this.uoQ = new b.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, avm paramAnonymousavm)
      {
        GMTrace.i(3576768233472L, 26649);
        if (paramAnonymousInt1 != 0)
        {
          v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=" + paramAnonymousInt1);
          if (paramAnonymousInt1 == -2) {
            new File(c.this.aLu()).delete();
          }
          paramAnonymousavm = c.this;
          paramAnonymousavm.kbu += 1;
          c.this.a(c.this.uoG);
          GMTrace.o(3576768233472L, 26649);
          return;
        }
        v.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try
        {
          if (com.tencent.mm.a.e.aN(c.this.aLu()) < c.a(c.this))
          {
            v.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
            c.this.a(c.this.uoG);
            GMTrace.o(3576768233472L, 26649);
            return;
          }
          c localc;
          if (c.this.uoO)
          {
            if (!c.this.fvg.equalsIgnoreCase(g.aV(c.this.aLu())))
            {
              v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
              new File(c.this.aLu()).delete();
              c.this.uoG.a(2, -1, paramAnonymousavm);
              GMTrace.o(3576768233472L, 26649);
              return;
            }
            localc = c.this;
          }
          Message localMessage;
          if (c.b(c.this).equalsIgnoreCase(g.aV(c.this.aLu()))) {
            break label462;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "in genNewAPKInNewThread()");
            com.tencent.mm.sdk.f.e.post(new c.2(localc, paramAnonymousavm), "NetSceneGetUpdatePackFromCDN_genApk");
            GMTrace.o(3576768233472L, 26649);
            return;
          }
          catch (Exception localException2)
          {
            v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exception in genNewAPKInNewThread()");
            v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException2, "", new Object[0]);
            localMessage = Message.obtain();
            localMessage.what = 1;
            localMessage.arg1 = 3;
            localMessage.obj = paramAnonymousavm;
            localException1.uoP.sendMessage(localMessage);
            GMTrace.o(3576768233472L, 26649);
            return;
          }
          localException1 = localException1;
          v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
          v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException1, "", new Object[0]);
          c.this.uoG.a(-1, -1, paramAnonymousavm);
          GMTrace.o(3576768233472L, 26649);
          return;
        }
        v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
        new File(c.this.aLu()).delete();
        c.this.uoG.a(-1, -1, paramAnonymousavm);
        GMTrace.o(3576768233472L, 26649);
        return;
        label462:
        com.tencent.mm.a.e.h(com.tencent.mm.sandbox.monitor.c.uoj, c.c(c.this) + ".temp", c.d(c.this) + ".apk");
        c.this.uoG.a(200, 0, paramAnonymousavm);
        GMTrace.o(3576768233472L, 26649);
      }
      
      public final void cx(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(3576634015744L, 26648);
        v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramAnonymousInt1 + ", offset=" + paramAnonymousInt2);
        c.this.uoG.cx(paramAnonymousInt1, paramAnonymousInt2);
        GMTrace.o(3576634015744L, 26648);
      }
      
      public final void eq(long paramAnonymousLong)
      {
        GMTrace.i(3576902451200L, 26650);
        c.this.uoG.eq(paramAnonymousLong);
        GMTrace.o(3576902451200L, 26650);
      }
      
      public final void er(long paramAnonymousLong)
      {
        GMTrace.i(3577036668928L, 26651);
        c.this.uoG.er(paramAnonymousLong);
        GMTrace.o(3577036668928L, 26651);
      }
    };
    this.uoM = new String[] { paramString2 };
    this.uoO = true;
    this.fvg = paramString3;
    this.mKq = paramString4;
    GMTrace.o(3595156062208L, 26786);
  }
  
  public c(int paramInt1, String paramString, int paramInt2, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramInt1, paramString, paramInt2, paramBoolean);
    GMTrace.i(3595021844480L, 26785);
    this.uoN = null;
    this.kbu = 0;
    this.uoO = false;
    this.hJL = false;
    this.uoP = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(3597974634496L, 26807);
        if ((1 == paramAnonymousMessage.what) && (!c.this.hJL))
        {
          new File(c.this.aLu()).delete();
          if (paramAnonymousMessage.arg1 != 0) {
            break label97;
          }
          v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
          c.this.uoG.a(200, 0, (avm)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          GMTrace.o(3597974634496L, 26807);
          return;
          label97:
          if (paramAnonymousMessage.arg1 == 3) {
            c.this.uoG.a(3, -1, (avm)paramAnonymousMessage.obj);
          } else if (paramAnonymousMessage.arg1 == 4) {
            c.this.uoG.a(4, -1, (avm)paramAnonymousMessage.obj);
          }
        }
      }
    };
    this.uoQ = new b.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, avm paramAnonymousavm)
      {
        GMTrace.i(3576768233472L, 26649);
        if (paramAnonymousInt1 != 0)
        {
          v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=" + paramAnonymousInt1);
          if (paramAnonymousInt1 == -2) {
            new File(c.this.aLu()).delete();
          }
          paramAnonymousavm = c.this;
          paramAnonymousavm.kbu += 1;
          c.this.a(c.this.uoG);
          GMTrace.o(3576768233472L, 26649);
          return;
        }
        v.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try
        {
          if (com.tencent.mm.a.e.aN(c.this.aLu()) < c.a(c.this))
          {
            v.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
            c.this.a(c.this.uoG);
            GMTrace.o(3576768233472L, 26649);
            return;
          }
          c localc;
          if (c.this.uoO)
          {
            if (!c.this.fvg.equalsIgnoreCase(g.aV(c.this.aLu())))
            {
              v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
              new File(c.this.aLu()).delete();
              c.this.uoG.a(2, -1, paramAnonymousavm);
              GMTrace.o(3576768233472L, 26649);
              return;
            }
            localc = c.this;
          }
          Message localMessage;
          if (c.b(c.this).equalsIgnoreCase(g.aV(c.this.aLu()))) {
            break label462;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "in genNewAPKInNewThread()");
            com.tencent.mm.sdk.f.e.post(new c.2(localc, paramAnonymousavm), "NetSceneGetUpdatePackFromCDN_genApk");
            GMTrace.o(3576768233472L, 26649);
            return;
          }
          catch (Exception localException2)
          {
            v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exception in genNewAPKInNewThread()");
            v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException2, "", new Object[0]);
            localMessage = Message.obtain();
            localMessage.what = 1;
            localMessage.arg1 = 3;
            localMessage.obj = paramAnonymousavm;
            localException1.uoP.sendMessage(localMessage);
            GMTrace.o(3576768233472L, 26649);
            return;
          }
          localException1 = localException1;
          v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
          v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException1, "", new Object[0]);
          c.this.uoG.a(-1, -1, paramAnonymousavm);
          GMTrace.o(3576768233472L, 26649);
          return;
        }
        v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
        new File(c.this.aLu()).delete();
        c.this.uoG.a(-1, -1, paramAnonymousavm);
        GMTrace.o(3576768233472L, 26649);
        return;
        label462:
        com.tencent.mm.a.e.h(com.tencent.mm.sandbox.monitor.c.uoj, c.c(c.this) + ".temp", c.d(c.this) + ".apk");
        c.this.uoG.a(200, 0, paramAnonymousavm);
        GMTrace.o(3576768233472L, 26649);
      }
      
      public final void cx(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(3576634015744L, 26648);
        v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramAnonymousInt1 + ", offset=" + paramAnonymousInt2);
        c.this.uoG.cx(paramAnonymousInt1, paramAnonymousInt2);
        GMTrace.o(3576634015744L, 26648);
      }
      
      public final void eq(long paramAnonymousLong)
      {
        GMTrace.i(3576902451200L, 26650);
        c.this.uoG.eq(paramAnonymousLong);
        GMTrace.o(3576902451200L, 26650);
      }
      
      public final void er(long paramAnonymousLong)
      {
        GMTrace.i(3577036668928L, 26651);
        c.this.uoG.er(paramAnonymousLong);
        GMTrace.o(3577036668928L, 26651);
      }
    };
    this.uoM = paramArrayOfString;
    GMTrace.o(3595021844480L, 26785);
  }
  
  private int bHK()
  {
    GMTrace.i(3595827150848L, 26791);
    v.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.kbu + ", curLinkIdx = " + this.kbu / 5);
    int i = this.kbu / 5;
    GMTrace.o(3595827150848L, 26791);
    return i;
  }
  
  public final void a(b.a parama)
  {
    GMTrace.i(3595290279936L, 26787);
    this.uoG = parama;
    if (!h.getExternalStorageState().equals("mounted"))
    {
      v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
      parama.a(-1, -1, null);
      GMTrace.o(3595290279936L, 26787);
      return;
    }
    if (this.hJL)
    {
      v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
      parama.a(-1, -1, null);
      GMTrace.o(3595290279936L, 26787);
      return;
    }
    if ((bHD()) || (bHK() >= this.uoM.length))
    {
      v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.uoM.length);
      if (this.uoO)
      {
        parama.a(1, -1, null);
        GMTrace.o(3595290279936L, 26787);
        return;
      }
      parama.a(-1, -1, null);
      GMTrace.o(3595290279936L, 26787);
      return;
    }
    if (!f.G(this.uol))
    {
      v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
      if (this.uoO)
      {
        parama.a(13, -1, null);
        GMTrace.o(3595290279936L, 26787);
        return;
      }
      parama.a(-1, -1, null);
      GMTrace.o(3595290279936L, 26787);
      return;
    }
    this.uoN = new a(this.uol, com.tencent.mm.a.e.aN(aLu()), this.uoQ);
    this.uoN.execute(new String[] { this.uoM[bHK()] });
    GMTrace.o(3595290279936L, 26787);
  }
  
  protected final String aLu()
  {
    GMTrace.i(3595424497664L, 26788);
    if (this.uoO)
    {
      str = uoj + this.fvg + ".temp";
      GMTrace.o(3595424497664L, 26788);
      return str;
    }
    String str = super.aLu();
    GMTrace.o(3595424497664L, 26788);
    return str;
  }
  
  public final String bHC()
  {
    GMTrace.i(3595558715392L, 26789);
    if (this.uoO)
    {
      str = uoj + this.mKq + ".apk";
      GMTrace.o(3595558715392L, 26789);
      return str;
    }
    String str = uoj + this.uon + ".apk";
    GMTrace.o(3595558715392L, 26789);
    return str;
  }
  
  public final void cancel()
  {
    GMTrace.i(3595692933120L, 26790);
    v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
    this.hJL = true;
    if ((this.uoN != null) && (!this.uoN.isCancelled())) {
      this.uoN.cancel(true);
    }
    GMTrace.o(3595692933120L, 26790);
  }
  
  private final class a
    extends AsyncTask<String, Integer, Integer>
  {
    private int aPh;
    private HttpClient oxW;
    private int size;
    private b.a uoG;
    private HttpPost uoT;
    private HttpResponse uoU;
    private HttpEntity uoV;
    private OutputStream uoW;
    
    public a(int paramInt1, int paramInt2, b.a parama)
    {
      GMTrace.i(3574620749824L, 26633);
      this.oxW = null;
      this.uoT = null;
      this.uoU = null;
      this.uoV = null;
      this.uoW = new OutputStream()
      {
        private ad handler;
        private ByteArrayOutputStream uoX;
        
        public final void write(int paramAnonymousInt)
        {
          GMTrace.i(3594619191296L, 26782);
          throw new IOException("unexpected operation");
        }
        
        public final void write(byte[] paramAnonymousArrayOfByte, final int paramAnonymousInt1, int paramAnonymousInt2)
        {
          GMTrace.i(3594484973568L, 26781);
          this.uoX.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          if ((this.uoX.size() < 131072) && (c.a.a(c.a.this) + this.uoX.size() < c.a.b(c.a.this)))
          {
            GMTrace.o(3594484973568L, 26781);
            return;
          }
          paramAnonymousInt1 = this.uoX.size();
          paramAnonymousInt2 = com.tencent.mm.a.e.a(c.this.aLu(), this.uoX.toByteArray(), paramAnonymousInt1);
          this.uoX.reset();
          if (paramAnonymousInt2 != 0) {
            throw new IOException("appendToFile failed :" + paramAnonymousInt2);
          }
          c.a.a(c.a.this, c.a.a(c.a.this) + paramAnonymousInt1);
          this.handler.post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(3578378846208L, 26661);
              if (c.a.a(c.a.this) <= c.a.b(c.a.this)) {
                c.a.c(c.a.this).cx(c.a.b(c.a.this), c.a.a(c.a.this));
              }
              c.a.c(c.a.this).er(paramAnonymousInt1);
              GMTrace.o(3578378846208L, 26661);
            }
          });
          if (c.this.hJL) {
            throw new IOException("manual force cancel!");
          }
          GMTrace.o(3594484973568L, 26781);
        }
      };
      this.size = paramInt1;
      this.aPh = paramInt2;
      this.uoG = parama;
      GMTrace.o(3574620749824L, 26633);
    }
    
    private Integer C(String... paramVarArgs)
    {
      GMTrace.i(3574754967552L, 26634);
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs == null) || (paramVarArgs.length() == 0))
      {
        GMTrace.o(3574754967552L, 26634);
        return Integer.valueOf(-1);
      }
      v.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + paramVarArgs + ", range=" + this.aPh);
      this.oxW = new DefaultHttpClient();
      this.oxW.getParams().setIntParameter("http.connection.timeout", 15000);
      this.uoT = new HttpPost(paramVarArgs);
      HttpPost localHttpPost = this.uoT;
      StringBuilder localStringBuilder = new StringBuilder("bytes=").append(this.aPh).append("-");
      if (this.size - this.aPh > 1048576) {
        paramVarArgs = Integer.valueOf(this.aPh + 1048576 - 1);
      }
      for (;;)
      {
        localHttpPost.addHeader("RANGE", paramVarArgs);
        try
        {
          this.uoG.eq(50L);
          this.uoU = this.oxW.execute(this.uoT);
          int i = this.uoU.getStatusLine().getStatusCode();
          if ((i != 200) && (i != 206))
          {
            v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:" + i);
            if (i == 416)
            {
              if (this.uoT != null) {
                this.uoT.abort();
              }
              if (this.uoV != null) {}
              try
              {
                this.uoV.consumeContent();
                if (this.oxW != null) {
                  this.oxW.getConnectionManager().shutdown();
                }
                GMTrace.o(3574754967552L, 26634);
                return Integer.valueOf(-2);
                paramVarArgs = "";
              }
              catch (IOException paramVarArgs)
              {
                for (;;)
                {
                  v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
                }
              }
            }
            if (this.uoT != null) {
              this.uoT.abort();
            }
            if (this.uoV != null) {}
            try
            {
              this.uoV.consumeContent();
              if (this.oxW != null) {
                this.oxW.getConnectionManager().shutdown();
              }
              GMTrace.o(3574754967552L, 26634);
              return Integer.valueOf(-1);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          if ((c.this.uoO) && (r.iir) && (Math.random() > 0.2D))
          {
            v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
            if (this.uoT != null) {
              this.uoT.abort();
            }
            if (this.uoV != null) {}
            try
            {
              this.uoV.consumeContent();
              if (this.oxW != null) {
                this.oxW.getConnectionManager().shutdown();
              }
              GMTrace.o(3574754967552L, 26634);
              return Integer.valueOf(-1);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.uoU.getHeaders("Content-Length");
          if (this.aPh > this.size)
          {
            v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
            if (this.uoT != null) {
              this.uoT.abort();
            }
            if (this.uoV != null) {}
            try
            {
              this.uoV.consumeContent();
              if (this.oxW != null) {
                this.oxW.getConnectionManager().shutdown();
              }
              GMTrace.o(3574754967552L, 26634);
              return Integer.valueOf(-2);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.uoV = this.uoU.getEntity();
          this.uoV.writeTo(this.uoW);
          this.uoV.consumeContent();
          if (this.uoT != null) {
            this.uoT.abort();
          }
          if (this.uoV != null) {}
          try
          {
            this.uoV.consumeContent();
            if (this.oxW != null) {
              this.oxW.getConnectionManager().shutdown();
            }
            GMTrace.o(3574754967552L, 26634);
            return Integer.valueOf(0);
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
          try
          {
            this.uoV.consumeContent();
            if (this.oxW != null) {
              this.oxW.getConnectionManager().shutdown();
            }
            throw paramVarArgs;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
            }
          }
        }
        catch (Exception paramVarArgs)
        {
          v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
          v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "exception current in download pack", new Object[0]);
          if (this.uoT != null) {
            this.uoT.abort();
          }
          if (this.uoV != null) {}
          try
          {
            this.uoV.consumeContent();
            if (this.oxW != null) {
              this.oxW.getConnectionManager().shutdown();
            }
            GMTrace.o(3574754967552L, 26634);
            return Integer.valueOf(-1);
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
        }
        finally
        {
          if (this.uoT != null) {
            this.uoT.abort();
          }
          if (this.uoV == null) {}
        }
      }
    }
    
    protected final void onCancelled()
    {
      GMTrace.i(3574889185280L, 26635);
      v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
      if (this.uoT != null) {
        this.uoT.abort();
      }
      if (this.uoV != null) {}
      try
      {
        this.uoV.consumeContent();
        if (this.oxW != null)
        {
          v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
          this.oxW.getConnectionManager().shutdown();
        }
        GMTrace.o(3574889185280L, 26635);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/updater/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */