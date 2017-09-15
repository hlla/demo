package com.tencent.mm.plugin.sight.decode.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.e.a.qv.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b
{
  private static HashMap<String, WeakReference<Bitmap>> psJ;
  public static Map<String, Integer> psN;
  public boolean hQG;
  public ad jrx;
  public boolean mMh;
  public Surface nHw;
  public int position;
  public volatile b psA;
  public volatile i psB;
  public volatile c psC;
  private k psD;
  public j psE;
  private d psF;
  public boolean psG;
  public boolean psH;
  public boolean psI;
  public boolean psK;
  public double psL;
  boolean psM;
  public double psO;
  public boolean psP;
  public boolean psQ;
  private a psR;
  public e psS;
  public f psT;
  public g psU;
  public int psk;
  public int psl;
  public String psm;
  public String psn;
  public int pso;
  protected int psp;
  public Bitmap psq;
  public Bitmap psr;
  public Bitmap pss;
  public WeakReference<View> pst;
  public WeakReference<TextView> psu;
  public long psv;
  public WeakReference<View> psw;
  public Animation psx;
  public Animation psy;
  private volatile h psz;
  
  static
  {
    GMTrace.i(9235924516864L, 68813);
    psJ = new HashMap();
    psN = new ConcurrentHashMap();
    GMTrace.o(9235924516864L, 68813);
  }
  
  public b(int paramInt, View paramView)
  {
    GMTrace.i(9226931929088L, 68746);
    this.hQG = false;
    this.psk = 0;
    this.psl = 0;
    this.psm = "";
    this.psn = "";
    this.pso = -1;
    this.psp = 41;
    this.psG = true;
    this.psH = true;
    this.psI = false;
    this.psK = false;
    this.mMh = true;
    this.psL = -1.0D;
    this.psM = false;
    this.psO = -1.0D;
    this.psP = false;
    this.psQ = false;
    this.psl = paramInt;
    this.jrx = new ad(Looper.getMainLooper());
    this.psw = new WeakReference(paramView);
    v.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(paramInt) });
    GMTrace.o(9226931929088L, 68746);
  }
  
  public static boolean Eq(String paramString)
  {
    GMTrace.i(9228005670912L, 68754);
    if (bf.mA(paramString))
    {
      GMTrace.o(9228005670912L, 68754);
      return false;
    }
    paramString = (Integer)psN.get(paramString);
    if ((paramString != null) && (2 == paramString.intValue()))
    {
      GMTrace.o(9228005670912L, 68754);
      return false;
    }
    GMTrace.o(9228005670912L, 68754);
    return true;
  }
  
  public static Bitmap a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(9226663493632L, 68744);
    String str = String.format("%s-%s-%s-%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = (WeakReference)psJ.get(str);
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      paramContext = (Bitmap)((WeakReference)localObject).get();
      GMTrace.o(9226663493632L, 68744);
      return paramContext;
    }
    if (paramContext == null)
    {
      v.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
      GMTrace.o(9226663493632L, 68744);
      return null;
    }
    if (paramInt1 <= 0)
    {
      v.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
      GMTrace.o(9226663493632L, 68744);
      return null;
    }
    if ((paramInt2 <= 0) || (paramInt4 <= 0) || (paramInt3 <= 0))
    {
      v.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
      GMTrace.o(9226663493632L, 68744);
      return null;
    }
    long l = bf.NB();
    paramInt3 = paramInt2 * paramInt4 / paramInt3;
    paramContext = (NinePatchDrawable)paramContext.getResources().getDrawable(paramInt1);
    paramContext.setBounds(0, 0, paramInt2, paramInt3);
    localObject = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    paramContext.draw(new Canvas((Bitmap)localObject));
    psJ.put(str, new WeakReference(localObject));
    v.d("MicroMsg.SightPlayController", "create mask bmp use %dms", new Object[] { Long.valueOf(bf.aB(l)) });
    GMTrace.o(9226663493632L, 68744);
    return (Bitmap)localObject;
  }
  
  public static void wl()
  {
    GMTrace.i(9226797711360L, 68745);
    com.tencent.mm.modelvideo.o.b(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(9219684171776L, 68692);
        long l = System.currentTimeMillis();
        try
        {
          SightVideoJNI.freeAll();
          v.i("MicroMsg.SightPlayController", "free all, use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          GMTrace.o(9219684171776L, 68692);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.e("MicroMsg.SightPlayController", "free all sight error");
            v.printErrStackTrace("MicroMsg.SightPlayController", localException, "", new Object[0]);
          }
        }
      }
    }, 0L);
    GMTrace.o(9226797711360L, 68745);
  }
  
  public abstract void A(Bitmap paramBitmap);
  
  public final void a(Surface paramSurface)
  {
    GMTrace.i(9228542541824L, 68758);
    v.v("MicroMsg.SightPlayController", "set play surface %s", new Object[] { paramSurface });
    this.nHw = paramSurface;
    com.tencent.mm.modelvideo.o.b(this.psD, 0L);
    GMTrace.o(9228542541824L, 68758);
  }
  
  public final void ak(String paramString, boolean paramBoolean)
  {
    GMTrace.i(9227871453184L, 68753);
    v.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(hashCode()), paramString, this.psm, Boolean.valueOf(paramBoolean), Integer.valueOf(this.pso), Boolean.valueOf(this.psQ), Boolean.valueOf(this.psH) });
    if (this.psQ)
    {
      gZ(false);
      GMTrace.o(9227871453184L, 68753);
      return;
    }
    if (bbT())
    {
      v.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      clear();
      GMTrace.o(9227871453184L, 68753);
      return;
    }
    if (!this.psH)
    {
      clear();
      GMTrace.o(9227871453184L, 68753);
      return;
    }
    if (paramBoolean)
    {
      this.psn = paramString;
      gZ(false);
      GMTrace.o(9227871453184L, 68753);
      return;
    }
    if (this.psm.equals(paramString))
    {
      this.psn = "ERROR#PATH";
      gZ(false);
      restart();
      GMTrace.o(9227871453184L, 68753);
      return;
    }
    clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.psm = str;
    if (bf.mA(this.psm))
    {
      v.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      z(null);
      GMTrace.o(9227871453184L, 68753);
      return;
    }
    if (!Eq(this.psm))
    {
      v.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      GMTrace.o(9227871453184L, 68753);
      return;
    }
    this.psz = new h();
    com.tencent.mm.modelvideo.o.b(this.psz, 0L);
    GMTrace.o(9227871453184L, 68753);
  }
  
  public int bbR()
  {
    GMTrace.i(9227066146816L, 68747);
    GMTrace.o(9227066146816L, 68747);
    return -1;
  }
  
  public final boolean bbS()
  {
    GMTrace.i(9227334582272L, 68749);
    if (1 == this.psl)
    {
      if ((this.psA != null) && (!this.psA.nBT))
      {
        GMTrace.o(9227334582272L, 68749);
        return true;
      }
      GMTrace.o(9227334582272L, 68749);
      return false;
    }
    if ((this.psC != null) && (!this.psC.nBT) && (this.psA != null) && (!this.psA.nBT))
    {
      GMTrace.o(9227334582272L, 68749);
      return true;
    }
    GMTrace.o(9227334582272L, 68749);
    return false;
  }
  
  public final boolean bbT()
  {
    GMTrace.i(9228139888640L, 68755);
    if (this.psK)
    {
      GMTrace.o(9228139888640L, 68755);
      return false;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (this.psk >= 3)
      {
        v.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
        this.psk = 0;
      }
      GMTrace.o(9228139888640L, 68755);
      return false;
    }
    if (this.psk >= 3)
    {
      GMTrace.o(9228139888640L, 68755);
      return true;
    }
    GMTrace.o(9228139888640L, 68755);
    return false;
  }
  
  protected final void bbU()
  {
    GMTrace.i(9228408324096L, 68757);
    int i = Math.max(1, (int)SightVideoJNI.getVideoRate(this.pso));
    this.psp = (1000 / i);
    v.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.psp) });
    GMTrace.o(9228408324096L, 68757);
  }
  
  public final void bbV()
  {
    GMTrace.i(16048547954688L, 119571);
    if ((this.psw == null) || (-1 == bbR()) || (!this.psG))
    {
      GMTrace.o(16048547954688L, 119571);
      return;
    }
    if ((this.psx == null) && (this.psw.get() != null)) {
      this.psx = AnimationUtils.loadAnimation(((View)this.psw.get()).getContext(), bbR());
    }
    if (this.psF == null) {
      this.psF = new d();
    }
    this.jrx.post(this.psF);
    GMTrace.o(16048547954688L, 119571);
  }
  
  public final c bbW()
  {
    GMTrace.i(9229079412736L, 68762);
    if (this.psR == null) {
      this.psR = new a(this);
    }
    a locala = this.psR;
    GMTrace.o(9229079412736L, 68762);
    return locala;
  }
  
  public final double bbX()
  {
    GMTrace.i(9229213630464L, 68763);
    if (this.pso == -1)
    {
      GMTrace.o(9229213630464L, 68763);
      return 0.0D;
    }
    double d = SightVideoJNI.getVideoDuration(this.pso);
    GMTrace.o(9229213630464L, 68763);
    return d;
  }
  
  public abstract void bp(int paramInt1, int paramInt2);
  
  public final void clear()
  {
    GMTrace.i(9227603017728L, 68751);
    v.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.pso), Boolean.valueOf(bbS()) });
    gZ(true);
    this.psv = 0L;
    sC(this.pso);
    this.pso = -1;
    this.psm = "";
    this.psn = "ERROR#PATH";
    this.pss = null;
    this.psL = 0.0D;
    this.psM = false;
    com.tencent.mm.memory.o.hgM.e(this.psq);
    this.psq = null;
    GMTrace.o(9227603017728L, 68751);
  }
  
  public final void g(TextView paramTextView)
  {
    GMTrace.i(9228676759552L, 68759);
    this.psu = new WeakReference(paramTextView);
    GMTrace.o(9228676759552L, 68759);
  }
  
  public final void gZ(boolean paramBoolean)
  {
    GMTrace.i(9227200364544L, 68748);
    if (this.psz != null)
    {
      com.tencent.mm.modelvideo.o.h(this.psz);
      this.psz.nBT = true;
    }
    if (this.psC != null)
    {
      this.jrx.removeCallbacks(this.psC);
      this.psC.nBT = true;
    }
    if (this.psA != null)
    {
      com.tencent.mm.modelvideo.o.h(this.psA);
      this.psA.nBT = true;
    }
    i locali;
    if (this.psB != null)
    {
      locali = this.psB;
      if (!paramBoolean) {
        break label123;
      }
    }
    label123:
    for (int i = 0;; i = 2)
    {
      locali.type = i;
      com.tencent.mm.modelvideo.o.b(this.psB, 0L);
      GMTrace.o(9227200364544L, 68748);
      return;
    }
  }
  
  public final void restart()
  {
    GMTrace.i(9227468800000L, 68750);
    v.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.psH), this.psm, Integer.valueOf(this.pso) });
    if (!this.psH)
    {
      clear();
      GMTrace.o(9227468800000L, 68750);
      return;
    }
    if (bbS())
    {
      v.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.psm });
      GMTrace.o(9227468800000L, 68750);
      return;
    }
    if (this.pso < 0) {}
    for (boolean bool = true;; bool = false)
    {
      gZ(bool);
      this.psv = 0L;
      if (!bbT()) {
        break;
      }
      v.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", new Object[] { Integer.valueOf(hashCode()) });
      GMTrace.o(9227468800000L, 68750);
      return;
    }
    if (this.pso < 0)
    {
      v.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.psm });
      if (bf.mA(this.psm))
      {
        GMTrace.o(9227468800000L, 68750);
        return;
      }
      if (!Eq(this.psm))
      {
        v.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
        clear();
        GMTrace.o(9227468800000L, 68750);
        return;
      }
      this.psz = new h();
      com.tencent.mm.modelvideo.o.b(this.psz, 0L);
      GMTrace.o(9227468800000L, 68750);
      return;
    }
    if (1 == this.psl)
    {
      this.psA = new b();
      this.psC = null;
      com.tencent.mm.modelvideo.o.b(this.psA, 0L);
      GMTrace.o(9227468800000L, 68750);
      return;
    }
    this.psA = new b();
    this.psC = new c();
    this.psA.pta = this.psC;
    this.psC.ptd = this.psA;
    com.tencent.mm.modelvideo.o.b(this.psA, 0L);
    GMTrace.o(9227468800000L, 68750);
  }
  
  public final void sC(final int paramInt)
  {
    GMTrace.i(9227737235456L, 68752);
    com.tencent.mm.modelvideo.o.b(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(9222502744064L, 68713);
        long l = System.currentTimeMillis();
        SightVideoJNI.freeObj(paramInt);
        v.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - l) });
        GMTrace.o(9222502744064L, 68713);
      }
    }, 0L);
    GMTrace.o(9227737235456L, 68752);
  }
  
  public final void z(Bitmap paramBitmap)
  {
    boolean bool = true;
    GMTrace.i(9228810977280L, 68760);
    if (paramBitmap == null) {}
    for (;;)
    {
      v.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.modelvideo.o.h(this.psD);
      if (this.psD == null) {
        this.psD = new k();
      }
      this.psD.ptg = new WeakReference(paramBitmap);
      com.tencent.mm.modelvideo.o.b(this.psD, 0L);
      GMTrace.o(9228810977280L, 68760);
      return;
      bool = false;
    }
  }
  
  private static final class a
    extends c<qv>
  {
    int lFv;
    int psX;
    int psY;
    WeakReference<b> psZ;
    
    public a(b paramb)
    {
      super();
      GMTrace.i(9237266694144L, 68823);
      this.psX = 0;
      this.psY = 0;
      this.lFv = 0;
      this.psZ = new WeakReference(paramb);
      this.uqt = qv.class.getName().hashCode();
      GMTrace.o(9237266694144L, 68823);
    }
    
    private void a(qv paramqv)
    {
      GMTrace.i(9237400911872L, 68824);
      this.psX = paramqv.fXG.fXJ;
      this.psY = paramqv.fXG.fXH;
      this.lFv = paramqv.fXG.fXI;
      GMTrace.o(9237400911872L, 68824);
    }
    
    private boolean bbY()
    {
      GMTrace.i(9237535129600L, 68825);
      if (this.psZ.get() == null)
      {
        GMTrace.o(9237535129600L, 68825);
        return false;
      }
      int i = ((b)this.psZ.get()).position + this.psX;
      if ((i < this.psY) || (i > this.lFv))
      {
        GMTrace.o(9237535129600L, 68825);
        return false;
      }
      GMTrace.o(9237535129600L, 68825);
      return true;
    }
  }
  
  private final class b
    implements Runnable
  {
    volatile boolean nBT;
    b.c pta;
    
    public b()
    {
      GMTrace.i(9226260840448L, 68741);
      this.nBT = false;
      GMTrace.o(9226260840448L, 68741);
    }
    
    public final void run()
    {
      GMTrace.i(9226395058176L, 68742);
      if ((b.this.psU != null) && (b.this.psU.bca() != null) && (b.this.psU.bca().getVisibility() == 0)) {
        b.this.jrx.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(9221965873152L, 68709);
            b.this.psU.bca().setVisibility(8);
            GMTrace.o(9221965873152L, 68709);
          }
        });
      }
      if (b.this.pso < 0)
      {
        v.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), b.this.psm });
        GMTrace.o(9226395058176L, 68742);
        return;
      }
      if (this.nBT)
      {
        v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
        GMTrace.o(9226395058176L, 68742);
        return;
      }
      if (b.this.psv == 0L)
      {
        if (b.this.psB != null)
        {
          b.this.psB.type = 1;
          b.this.psB.run();
        }
        b.this.psv = System.currentTimeMillis();
      }
      int j = 0;
      int i = j;
      if (b.this.psO != -1.0D)
      {
        if (b.this.psI) {
          break label637;
        }
        i = j;
        if (SightVideoJNI.seekStream(b.this.psO, b.this.pso) > 0)
        {
          if (b.this.psB == null) {
            b.this.psB = new b.i(b.this);
          }
          b.this.psB.type = 4;
          b.this.psB.psO = b.this.psO;
          b.this.psB.run();
          i = 1;
        }
      }
      float f3 = (float)(System.currentTimeMillis() - b.this.psv);
      float f1;
      label381:
      float f2;
      double d;
      b localb;
      if (i != 0)
      {
        f1 = 0.0F;
        f2 = f1;
        if (b.this.psI)
        {
          f2 = f1;
          if (b.this.psP)
          {
            b.this.psP = false;
            f2 = f1;
            if (b.this.psB != null)
            {
              d = b.this.psB.bcd() / 1000.0D;
              f2 = f1;
              if (SightVideoJNI.seekStream(d, b.this.pso) > 0)
              {
                f2 = 0.0F;
                v.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
              }
            }
          }
        }
        if (b.this.hQG) {
          v.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.this.pso), Float.valueOf(f3), Float.valueOf(f2) });
        }
        b.this.psv = System.currentTimeMillis();
        if (f2 < 2.0F) {
          break label828;
        }
        localb = b.this;
      }
      label637:
      label828:
      for (localb.psk += 1;; b.this.psk = Math.max(0, b.this.psk - 1))
      {
        if (!b.this.bbT()) {
          break label851;
        }
        v.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(b.this.psk) });
        b.this.clear();
        GMTrace.o(9226395058176L, 68742);
        return;
        if (b.this.psB != null)
        {
          b.this.psB.type = 4;
          b.this.psB.psO = b.this.psO;
          b.this.psB.run();
          b.this.jrx.postDelayed(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(9238206218240L, 68830);
              b.this.psP = true;
              GMTrace.o(9238206218240L, 68830);
            }
          }, 100L);
          i = j;
          break;
        }
        i = j;
        if (SightVideoJNI.seekStream(b.this.psO, b.this.pso) <= 0) {
          break;
        }
        if (b.this.psB == null) {
          b.this.psB = new b.i(b.this);
        }
        b.this.psB.type = 4;
        b.this.psB.psO = b.this.psO;
        b.this.psB.run();
        i = 1;
        break;
        f1 = f3 / b.this.psp + 0.5F;
        break label381;
      }
      label851:
      int k = 0;
      j = 0;
      int m = 0;
      if (1 == b.this.psl) {
        if ((b.this.nHw != null) && (!b.this.nHw.isValid()))
        {
          v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
          this.nBT = true;
          if (this.pta == null) {
            break label1415;
          }
          this.pta.nBT = true;
          i = 0;
          j = m;
          if (b.this.psB == null) {
            break label2166;
          }
          v.d("MicroMsg.SightPlayController", "voice time is" + b.this.psB.bcd() / 1000.0D);
        }
      }
      label1415:
      label1743:
      label2166:
      for (;;)
      {
        if (1 == j) {
          b.this.jrx.post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(9226126622720L, 68740);
              if (b.this.psS != null) {
                b.this.psS.a(b.this, 0);
              }
              GMTrace.o(9226126622720L, 68740);
            }
          });
        }
        if (this.nBT)
        {
          v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
          if (b.this.psB != null)
          {
            b.this.psB.type = 0;
            b.this.psB.run();
          }
          GMTrace.o(9226395058176L, 68742);
          return;
          i = SightVideoJNI.drawSurfaceFrame(b.this.pso, b.this.nHw, (int)f2, b.this.psr, b.this.mMh);
          if (b.this.psT != null)
          {
            d = SightVideoJNI.getVideoPlayTime(b.this.pso);
            j = (int)d;
            if (j != (int)b.this.psL) {
              b.this.psT.a(b.this, j);
            }
            b.this.psL = d;
          }
          if (i == 0)
          {
            b.this.psO = -1.0D;
            k = 0;
            j = i;
            i = k;
            break;
          }
          if (1 == i)
          {
            b.this.psO = -1.0D;
            k = 1;
            b.this.psv = 0L;
            b.this.bbV();
            j = i;
            i = k;
            break;
          }
          if (-7 == i)
          {
            v.w("MicroMsg.SightPlayController", "surface is null, continue");
            k = 0;
            j = i;
            i = k;
            break;
          }
          v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i) });
          this.nBT = true;
          if (this.pta != null) {
            this.pta.nBT = true;
          }
          b.this.z(null);
          j = i;
          if (b.this.psS != null)
          {
            b.this.psS.a(b.this, -1);
            j = i;
          }
          i = 0;
          break;
          m = SightVideoJNI.drawFrame(b.this.pso, b.this.psq, (int)f2, null, false, b.this.mMh);
          if (b.this.psT != null)
          {
            d = SightVideoJNI.getVideoPlayTime(b.this.pso);
            i = (int)d;
            if (i != (int)b.this.psL) {
              b.this.psT.a(b.this, i);
            }
            b.this.psL = d;
            if (b.this.hQG) {
              v.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
            }
          }
          for (;;)
          {
            if (m != 0) {
              break label1743;
            }
            b.this.psO = -1.0D;
            j = m;
            i = k;
            break;
            if (b.this.hQG)
            {
              d = SightVideoJNI.getVideoPlayTime(b.this.pso);
              if (b.this.hQG) {
                v.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
              }
            }
            else if (b.this.hQG)
            {
              v.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
            }
          }
          if (1 == m)
          {
            b.this.psO = -1.0D;
            i = 1;
            b.this.psv = 0L;
            b.this.bbV();
            j = m;
            continue;
          }
          b.this.psO = -1.0D;
          v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
          this.nBT = true;
          if (this.pta != null) {
            this.pta.nBT = true;
          }
          b.this.jrx.post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(9221697437696L, 68707);
              b.this.A(null);
              GMTrace.o(9221697437696L, 68707);
            }
          });
          j = m;
          i = k;
          if (b.this.psS == null) {
            continue;
          }
          b.this.psS.a(b.this, -1);
          j = m;
          i = k;
          continue;
        }
        long l;
        if (1 == b.this.psl)
        {
          l = b.this.psp - (System.currentTimeMillis() - b.this.psv);
          if (b.this.psv == 0L) {
            com.tencent.mm.modelvideo.o.b(this, b.this.psp * 5);
          }
        }
        for (;;)
        {
          if (b.this.psB != null) {
            v.d("MicroMsg.SightPlayController", "voice time is" + b.this.psB.bcd() / 1000.0D);
          }
          GMTrace.o(9226395058176L, 68742);
          return;
          if (l > 0L)
          {
            com.tencent.mm.modelvideo.o.b(this, l);
          }
          else
          {
            com.tencent.mm.modelvideo.o.b(this, 0L);
            continue;
            if ((i != 0) && (b.this.psU != null))
            {
              i = b.this.psU.bbZ();
              b.this.jrx.post(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(9222234308608L, 68711);
                  if (b.this.psU != null)
                  {
                    View localView = b.this.psU.bca();
                    if (localView != null)
                    {
                      if ((b.this.psy == null) && (b.this.psU.bcb() != -1) && (b.this.psw.get() != null)) {
                        b.this.psy = AnimationUtils.loadAnimation(((View)b.this.psw.get()).getContext(), b.this.psU.bcb());
                      }
                      if (b.this.psy != null) {
                        localView.startAnimation(b.this.psy);
                      }
                      localView.setVisibility(0);
                    }
                  }
                  GMTrace.o(9222234308608L, 68711);
                }
              });
              this.pta.ptc = j;
              b.this.jrx.postDelayed(this.pta, i);
            }
            else
            {
              this.pta.ptc = j;
              b.this.jrx.post(this.pta);
            }
          }
        }
      }
    }
  }
  
  private final class c
    implements Runnable
  {
    volatile boolean nBT;
    int ptc;
    b.b ptd;
    
    public c()
    {
      GMTrace.i(9219281518592L, 68689);
      this.nBT = false;
      v.i("MicroMsg.SightPlayController", "make sure drawJob alive");
      GMTrace.o(9219281518592L, 68689);
    }
    
    public final void run()
    {
      GMTrace.i(9219415736320L, 68690);
      if (this.nBT)
      {
        v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
        GMTrace.o(9219415736320L, 68690);
        return;
      }
      b.this.A(b.this.psq);
      if (b.this.psv == 0L)
      {
        com.tencent.mm.modelvideo.o.b(this.ptd, 0L);
        GMTrace.o(9219415736320L, 68690);
        return;
      }
      long l = b.this.psp - (System.currentTimeMillis() - b.this.psv);
      if (l > 0L)
      {
        com.tencent.mm.modelvideo.o.b(this.ptd, l);
        GMTrace.o(9219415736320L, 68690);
        return;
      }
      com.tencent.mm.modelvideo.o.b(this.ptd, 0L);
      GMTrace.o(9219415736320L, 68690);
    }
  }
  
  private final class d
    implements Runnable
  {
    public d()
    {
      GMTrace.i(9223039614976L, 68717);
      GMTrace.o(9223039614976L, 68717);
    }
    
    public final void run()
    {
      GMTrace.i(9223173832704L, 68718);
      if (b.this.psw.get() == null)
      {
        GMTrace.o(9223173832704L, 68718);
        return;
      }
      ((View)b.this.psw.get()).startAnimation(b.this.psx);
      GMTrace.o(9223173832704L, 68718);
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(b paramb, int paramInt);
  }
  
  public static abstract interface f
  {
    public abstract void a(b paramb, long paramLong);
  }
  
  public static abstract interface g
  {
    public abstract int bbZ();
    
    public abstract View bca();
    
    public abstract int bcb();
  }
  
  private final class h
    implements Runnable
  {
    volatile boolean nBT;
    
    public h()
    {
      GMTrace.i(9236729823232L, 68819);
      this.nBT = false;
      GMTrace.o(9236729823232L, 68819);
    }
    
    public final void run()
    {
      GMTrace.i(9236864040960L, 68820);
      if (b.this.bbT())
      {
        v.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
        GMTrace.o(9236864040960L, 68820);
        return;
      }
      b localb = b.this;
      String str = b.this.psm;
      if (1 == b.this.psl) {}
      for (int i = 0;; i = 1)
      {
        localb.pso = SightVideoJNI.openFile(str, i, 1, false);
        if (b.this.pso >= 0) {
          break;
        }
        v.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.this.pso), b.this.psm });
        b.this.z(null);
        if (b.this.psS != null) {
          b.this.psS.a(b.this, -1);
        }
        GMTrace.o(9236864040960L, 68820);
        return;
      }
      if (((Boolean)h.vI().vr().get(344065, Boolean.valueOf(false))).booleanValue())
      {
        if (b.this.psE == null) {
          b.this.psE = new b.j(b.this);
        }
        b.this.jrx.removeCallbacks(b.this.psE);
        b.this.jrx.post(b.this.psE);
      }
      int j = Math.max(1, SightVideoJNI.getVideoWidth(b.this.pso));
      int k = Math.max(1, SightVideoJNI.getVideoHeight(b.this.pso));
      if (b.this.psl == 0)
      {
        if ((j * k >= 1048576) || (j <= 0) || (k <= 0))
        {
          v.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          GMTrace.o(9236864040960L, 68820);
          return;
        }
        localb = b.this;
        v.d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", new Object[] { Integer.valueOf(localb.hashCode()), Integer.valueOf(j), Integer.valueOf(k) });
        if (localb.psq != null) {
          break label645;
        }
        localb.psq = com.tencent.mm.memory.o.hgM.a(new o.b(j, k));
        v.h("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", new Object[] { localb.psm });
      }
      label645:
      while ((localb.psq.getWidth() == j) && (localb.psq.getHeight() == k))
      {
        b.this.bbU();
        if ((Float.compare(j / k, 5.0F) <= 0) && (Float.compare(k / j, 5.0F) <= 0)) {
          break;
        }
        v.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        if (!bf.mA(b.this.psm)) {
          b.psN.put(b.this.psm, Integer.valueOf(2));
        }
        b.this.psv = 0L;
        b.this.sC(b.this.pso);
        b.this.pso = -1;
        b.this.psm = "";
        b.this.psn = "ERROR#PATH";
        b.this.pss = null;
        this.nBT = true;
        if (b.this.psS != null) {
          b.this.psS.a(b.this, -1);
        }
        GMTrace.o(9236864040960L, 68820);
        return;
      }
      v.w("MicroMsg.SightPlayController", "reset bmp, old value " + localb.psq.getWidth() + "*" + localb.psq.getHeight());
      if ((d.eo(19)) && (localb.psq.getAllocationByteCount() >= k * j * 4)) {}
      for (;;)
      {
        try
        {
          v.w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
          localb.psq.reconfigure(j, k, Bitmap.Config.ARGB_8888);
          i = 1;
        }
        catch (Exception localException)
        {
          v.e("MicroMsg.SightPlayController", "reconfigure failed: %s" + localException.getMessage());
          i = 0;
          continue;
        }
        if (i == 0)
        {
          com.tencent.mm.memory.o.hgM.e(localb.psq);
          localb.psq = com.tencent.mm.memory.o.hgM.a(new o.b(j, k));
        }
        v.h("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", new Object[] { localb.psm });
        break;
        b.this.bp(j, k);
        if (1 == b.this.psl)
        {
          b.this.psA = new b.b(b.this);
          b.this.psC = null;
          if (!this.nBT) {
            com.tencent.mm.modelvideo.o.b(b.this.psA, 0L);
          }
        }
        for (;;)
        {
          if (this.nBT) {
            v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.nBT) });
          }
          GMTrace.o(9236864040960L, 68820);
          return;
          b.this.psA = new b.b(b.this);
          b.this.psC = new b.c(b.this);
          b.this.psA.pta = b.this.psC;
          b.this.psC.ptd = b.this.psA;
          if (!this.nBT) {
            com.tencent.mm.modelvideo.o.b(b.this.psA, 0L);
          }
        }
        i = 0;
      }
    }
  }
  
  private final class i
    implements Runnable
  {
    double psO;
    MediaPlayer pte;
    public int type;
    
    public i()
    {
      GMTrace.i(9236058734592L, 68814);
      this.psO = -1.0D;
      GMTrace.o(9236058734592L, 68814);
    }
    
    private void bcc()
    {
      GMTrace.i(9236192952320L, 68815);
      v.i("MicroMsg.SightPlayController", "stopPlayer");
      try
      {
        if (this.pte != null)
        {
          this.pte.stop();
          this.pte.release();
          this.pte = null;
        }
        GMTrace.o(9236192952320L, 68815);
        return;
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.SightPlayController", localException, "stop play sound error: %s", new Object[] { localException.getMessage() });
        this.pte = null;
        GMTrace.o(9236192952320L, 68815);
      }
    }
    
    public final double bcd()
    {
      GMTrace.i(9236327170048L, 68816);
      if (this.pte == null)
      {
        GMTrace.o(9236327170048L, 68816);
        return 0.0D;
      }
      double d = this.pte.getCurrentPosition();
      GMTrace.o(9236327170048L, 68816);
      return d;
    }
    
    public final void run()
    {
      GMTrace.i(9236461387776L, 68817);
      String str;
      switch (this.type)
      {
      default: 
        str = "unknown";
        v.i("MicroMsg.SightPlayController", "do play sound, operation %s", new Object[] { str });
        switch (this.type)
        {
        }
        break;
      }
      for (;;)
      {
        GMTrace.o(9236461387776L, 68817);
        return;
        str = "start";
        break;
        str = "stop";
        break;
        str = "pause";
        break;
        str = "resume";
        break;
        str = "seek";
        break;
        bcc();
        if (!bf.mA(b.this.psm))
        {
          try
          {
            this.pte = new i();
            this.pte.setDisplay(null);
            this.pte.reset();
            this.pte.setDataSource(b.this.psm);
            this.pte.setAudioStreamType(3);
            this.pte.setOnErrorListener(new MediaPlayer.OnErrorListener()
            {
              public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
              {
                GMTrace.i(9237937782784L, 68828);
                v.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { b.this.psm, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                b.this.clear();
                if (b.this.psS != null) {
                  b.this.psS.a(b.this, -1);
                }
                GMTrace.o(9237937782784L, 68828);
                return true;
              }
            });
            this.pte.prepare();
            this.pte.start();
            GMTrace.o(9236461387776L, 68817);
            return;
          }
          catch (Exception localException1)
          {
            v.printErrStackTrace("MicroMsg.SightPlayController", localException1, "play sound error: %s", new Object[] { localException1.getMessage() });
            v.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[] { b.this.psm });
            b.this.clear();
            if (b.this.psS != null) {
              b.this.psS.a(b.this, -1);
            }
            GMTrace.o(9236461387776L, 68817);
            return;
          }
          bcc();
          GMTrace.o(9236461387776L, 68817);
          return;
          try
          {
            if ((this.pte != null) && (this.pte.isPlaying())) {
              this.pte.pause();
            }
            GMTrace.o(9236461387776L, 68817);
            return;
          }
          catch (Exception localException2)
          {
            v.printErrStackTrace("MicroMsg.SightPlayController", localException2, "pause sound error: %s", new Object[] { localException2.getMessage() });
            bcc();
            GMTrace.o(9236461387776L, 68817);
            return;
          }
          try
          {
            if (this.pte != null) {
              this.pte.start();
            }
            GMTrace.o(9236461387776L, 68817);
            return;
          }
          catch (Exception localException3)
          {
            v.printErrStackTrace("MicroMsg.SightPlayController", localException3, "pause sound error: %s", new Object[] { localException3.getMessage() });
            bcc();
            GMTrace.o(9236461387776L, 68817);
            return;
          }
          try
          {
            v.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[] { Double.valueOf(this.psO) });
            this.pte.seekTo((int)(this.psO * 1000.0D));
            GMTrace.o(9236461387776L, 68817);
            return;
          }
          catch (Exception localException4)
          {
            v.printErrStackTrace("MicroMsg.SightPlayController", localException4, "seek sound error: %s", new Object[] { localException4.getMessage() });
          }
        }
      }
    }
  }
  
  private final class j
    implements Runnable
  {
    public j()
    {
      GMTrace.i(9221160566784L, 68703);
      GMTrace.o(9221160566784L, 68703);
    }
    
    public final void run()
    {
      GMTrace.i(9221294784512L, 68704);
      if ((b.this.pso < 0) || (b.this.psu == null) || (b.this.psu.get() == null))
      {
        GMTrace.o(9221294784512L, 68704);
        return;
      }
      String str = SightVideoJNI.getVideoInfo(b.this.pso);
      ((TextView)b.this.psu.get()).setText(str);
      GMTrace.o(9221294784512L, 68704);
    }
  }
  
  private final class k
    implements Runnable
  {
    WeakReference<Bitmap> ptg;
    
    public k()
    {
      GMTrace.i(9220355260416L, 68697);
      this.ptg = new WeakReference(null);
      GMTrace.o(9220355260416L, 68697);
    }
    
    public final void run()
    {
      boolean bool6 = true;
      boolean bool5 = true;
      GMTrace.i(9220489478144L, 68698);
      boolean bool2;
      label75:
      label88:
      label101:
      final Bitmap localBitmap;
      try
      {
        if ((b.this.nHw != null) && (b.this.nHw.isValid())) {
          break label735;
        }
        i = b.this.hashCode();
        j = hashCode();
        boolean bool3;
        boolean bool4;
        final View localView1;
        if (b.this.nHw == null)
        {
          bool1 = true;
          if (b.this.pst != null) {
            break label279;
          }
          bool2 = true;
          if (this.ptg.get() != null) {
            break label285;
          }
          bool3 = true;
          if (b.this.psr != null) {
            break label291;
          }
          bool4 = true;
          v.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if (b.this.psr != null) {
            break label365;
          }
          localBitmap = (Bitmap)this.ptg.get();
          if (b.this.pst == null) {
            break label297;
          }
          localView1 = (View)b.this.pst.get();
          label205:
          if ((localView1 != null) && (localBitmap != null) && (!localBitmap.isRecycled())) {
            break label314;
          }
          if (localView1 != null) {
            break label303;
          }
          bool1 = true;
          label230:
          if (localBitmap != null) {
            break label308;
          }
        }
        label279:
        label285:
        label291:
        label297:
        label303:
        label308:
        for (bool2 = bool5;; bool2 = false)
        {
          v.e("MicroMsg.SightPlayController", "bgView:%B, thumb:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          GMTrace.o(9220489478144L, 68698);
          return;
          bool1 = false;
          break;
          bool2 = false;
          break label75;
          bool3 = false;
          break label88;
          bool4 = false;
          break label101;
          localView1 = null;
          break label205;
          bool1 = false;
          break label230;
        }
        label314:
        localView1.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(9219952607232L, 68694);
            localView1.setBackgroundDrawable(new BitmapDrawable(localBitmap));
            GMTrace.o(9219952607232L, 68694);
          }
        });
        GMTrace.o(9220489478144L, 68698);
        return;
      }
      catch (Exception localException1)
      {
        v.printErrStackTrace("MicroMsg.SightPlayController", localException1, "", new Object[0]);
        GMTrace.o(9220489478144L, 68698);
        return;
      }
      label365:
      if ((b.this.pss != null) && (b.this.pss.getWidth() == b.this.psr.getWidth()))
      {
        i = b.this.pss.getHeight();
        j = b.this.psr.getHeight();
        if (i == j) {
          break label458;
        }
      }
      label458:
      label520:
      final View localView2;
      try
      {
        b.this.pss = Bitmap.createBitmap(b.this.psr.getWidth(), b.this.psr.getHeight(), Bitmap.Config.ARGB_8888);
        if ((b.this.pss == null) || (this.ptg.get() == null) || (((Bitmap)this.ptg.get()).isRecycled()))
        {
          if (b.this.pss != null) {
            break label906;
          }
          bool1 = true;
          if (this.ptg.get() != null) {
            break label911;
          }
          bool2 = bool6;
          v.e("MicroMsg.SightPlayController", "mThubmBgBmp:%B, thumbRef:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          GMTrace.o(9220489478144L, 68698);
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.SightPlayController", localException2, "try to create thumb bmp error:%s", new Object[] { localException2.getMessage() });
          b.this.pss = null;
        }
        long l = System.nanoTime();
        SightVideoJNI.handleThumb((Bitmap)this.ptg.get(), b.this.pss, b.this.psr);
        v.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
        localBitmap = b.this.pss;
        if (b.this.pst != null) {}
        for (localView2 = (View)b.this.pst.get(); (localView2 == null) || (localBitmap == null); localView2 = null)
        {
          GMTrace.o(9220489478144L, 68698);
          return;
        }
        localView2.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(9219147300864L, 68688);
            localView2.setBackgroundDrawable(new BitmapDrawable(localBitmap));
            GMTrace.o(9219147300864L, 68688);
          }
        });
        GMTrace.o(9220489478144L, 68698);
        return;
      }
      label735:
      int i = b.this.hashCode();
      int j = hashCode();
      if (this.ptg.get() == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        v.d("MicroMsg.SightPlayController", "#0x%x-#0x%x draw thumb, thumb empty ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (b.this.pst != null)
        {
          localView2 = (View)b.this.pst.get();
          if (localView2 != null) {
            localView2.post(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(9222905397248L, 68716);
                v.v("MicroMsg.SightPlayController", "set background drawable null");
                localView2.setBackgroundDrawable(null);
                GMTrace.o(9222905397248L, 68716);
              }
            });
          }
        }
        if (this.ptg.get() == null)
        {
          SightVideoJNI.drawSurfaceColor(b.this.nHw, 0);
          GMTrace.o(9220489478144L, 68698);
          return;
        }
        SightVideoJNI.drawSurfaceThumb(b.this.nHw, (Bitmap)this.ptg.get(), b.this.psr);
        GMTrace.o(9220489478144L, 68698);
        return;
        label906:
        bool1 = false;
        break;
        label911:
        bool2 = false;
        break label520;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/sight/decode/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */