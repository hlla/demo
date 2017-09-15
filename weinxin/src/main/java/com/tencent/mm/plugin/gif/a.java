package com.tencent.mm.plugin.gif;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.f.b.b;
import java.io.InputStream;

public final class a
  extends Drawable
  implements b
{
  private final Paint fu;
  private ad jrx;
  boolean lp;
  private float mDensity;
  boolean mHK;
  private volatile long mHL;
  private AssetFileDescriptor mHM;
  private final int[] mHN;
  private float mHO;
  private float mHP;
  private boolean mHQ;
  private int[] mHR;
  private int mHS;
  private int mHT;
  private long mHU;
  private long mHV;
  private long mHW;
  private long mHX;
  private long mHY;
  private long mHZ;
  private int mIa;
  private boolean mIb;
  int mIc;
  private int mId;
  e mIe;
  private final Runnable mIf;
  final Runnable mIg;
  private final Runnable mIh;
  final Runnable mIi;
  private final Runnable mIj;
  private final Runnable mIk;
  private final Rect tZ;
  
  private a(AssetFileDescriptor paramAssetFileDescriptor)
  {
    GMTrace.i(12884365017088L, 95996);
    this.lp = true;
    this.mHK = false;
    this.mHM = null;
    this.mHN = new int[6];
    this.mHO = 1.0F;
    this.mHP = 1.0F;
    this.tZ = new Rect();
    this.fu = new Paint(6);
    this.mHS = 0;
    this.mHT = -1;
    this.mHU = 0L;
    this.mHV = 0L;
    this.mHW = 0L;
    this.mHX = 0L;
    this.mHZ = 0L;
    this.mIb = false;
    this.mIc = 0;
    this.mId = 0;
    this.jrx = new ad();
    this.mIf = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12883828146176L, 95992);
        GMTrace.o(12883828146176L, 95992);
      }
    };
    this.mIg = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12890002161664L, 96038);
        if (((a.this.isRunning()) || (a.b(a.this) == 0)) && (SystemClock.uptimeMillis() >= a.c(a.this)))
        {
          a.a(a.this, System.currentTimeMillis());
          a.this.invalidateSelf();
          if (a.a(a.this) != null) {
            a.a(a.this).invalidate();
          }
        }
        GMTrace.o(12890002161664L, 96038);
      }
    };
    this.mIh = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12893491822592L, 96064);
        MMGIFJNI.restoreRemainder(a.d(a.this));
        a.a(a.this, a.e(a.this), a.f(a.this));
        GMTrace.o(12893491822592L, 96064);
      }
    };
    this.mIi = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12883559710720L, 95990);
        MMGIFJNI.reset(a.d(a.this));
        GMTrace.o(12883559710720L, 95990);
      }
    };
    this.mIj = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12883022839808L, 95986);
        MMGIFJNI.saveRemainder(a.d(a.this));
        GMTrace.o(12883022839808L, 95986);
      }
    };
    this.mIk = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12899397402624L, 96108);
        if (a.g(a.this))
        {
          v.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
          GMTrace.o(12899397402624L, 96108);
          return;
        }
        long l = System.currentTimeMillis();
        if (a.b(a.this) + 1 > a.h(a.this) - 1) {
          a.a(a.this, -1);
        }
        a.a(a.this, a.b(a.this) + 1);
        if (MMGIFJNI.drawFramePixels(a.d(a.this), a.i(a.this), a.j(a.this))) {
          a.k(a.this);
        }
        a.b(a.this, System.currentTimeMillis() - l);
        if (a.l(a.this) != 0L)
        {
          a.c(a.this, a.l(a.this) - a.m(a.this) - a.n(a.this));
          if (a.f(a.this) < 0L)
          {
            v.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(a.m(a.this)), Long.valueOf(a.n(a.this)), Long.valueOf(a.f(a.this)), Long.valueOf(a.l(a.this)), Integer.valueOf(a.j(a.this)[5]) });
            g.oSF.a(401L, 0L, 1L, false);
            g.oSF.a(401L, 1L, Math.abs(a.f(a.this)), false);
          }
        }
        a locala = a.this;
        Runnable localRunnable = a.e(a.this);
        if (a.f(a.this) > 0L) {}
        for (l = a.f(a.this);; l = 0L)
        {
          a.a(locala, localRunnable, l);
          if (a.j(a.this)[2] != 1) {
            break;
          }
          a.d(a.this, 5000L);
          GMTrace.o(12899397402624L, 96108);
          return;
        }
        a.d(a.this, a.j(a.this)[4]);
        GMTrace.o(12899397402624L, 96108);
      }
    };
    if (paramAssetFileDescriptor == null) {
      throw new NullPointerException("assert file Descriptor is null.");
    }
    this.mHM = paramAssetFileDescriptor;
    this.mHL = MMGIFJNI.openByFileDescroptor(this.mHM.getFileDescriptor(), paramAssetFileDescriptor.getStartOffset(), this.mHN);
    init();
    GMTrace.o(12884365017088L, 95996);
  }
  
  public a(Resources paramResources, int paramInt)
  {
    this(paramResources.openRawResourceFd(paramInt));
    GMTrace.i(12884096581632L, 95994);
    GMTrace.o(12884096581632L, 95994);
  }
  
  public a(InputStream paramInputStream)
  {
    GMTrace.i(12884499234816L, 95997);
    this.lp = true;
    this.mHK = false;
    this.mHM = null;
    this.mHN = new int[6];
    this.mHO = 1.0F;
    this.mHP = 1.0F;
    this.tZ = new Rect();
    this.fu = new Paint(6);
    this.mHS = 0;
    this.mHT = -1;
    this.mHU = 0L;
    this.mHV = 0L;
    this.mHW = 0L;
    this.mHX = 0L;
    this.mHZ = 0L;
    this.mIb = false;
    this.mIc = 0;
    this.mId = 0;
    this.jrx = new ad();
    this.mIf = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12883828146176L, 95992);
        GMTrace.o(12883828146176L, 95992);
      }
    };
    this.mIg = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12890002161664L, 96038);
        if (((a.this.isRunning()) || (a.b(a.this) == 0)) && (SystemClock.uptimeMillis() >= a.c(a.this)))
        {
          a.a(a.this, System.currentTimeMillis());
          a.this.invalidateSelf();
          if (a.a(a.this) != null) {
            a.a(a.this).invalidate();
          }
        }
        GMTrace.o(12890002161664L, 96038);
      }
    };
    this.mIh = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12893491822592L, 96064);
        MMGIFJNI.restoreRemainder(a.d(a.this));
        a.a(a.this, a.e(a.this), a.f(a.this));
        GMTrace.o(12893491822592L, 96064);
      }
    };
    this.mIi = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12883559710720L, 95990);
        MMGIFJNI.reset(a.d(a.this));
        GMTrace.o(12883559710720L, 95990);
      }
    };
    this.mIj = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12883022839808L, 95986);
        MMGIFJNI.saveRemainder(a.d(a.this));
        GMTrace.o(12883022839808L, 95986);
      }
    };
    this.mIk = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12899397402624L, 96108);
        if (a.g(a.this))
        {
          v.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
          GMTrace.o(12899397402624L, 96108);
          return;
        }
        long l = System.currentTimeMillis();
        if (a.b(a.this) + 1 > a.h(a.this) - 1) {
          a.a(a.this, -1);
        }
        a.a(a.this, a.b(a.this) + 1);
        if (MMGIFJNI.drawFramePixels(a.d(a.this), a.i(a.this), a.j(a.this))) {
          a.k(a.this);
        }
        a.b(a.this, System.currentTimeMillis() - l);
        if (a.l(a.this) != 0L)
        {
          a.c(a.this, a.l(a.this) - a.m(a.this) - a.n(a.this));
          if (a.f(a.this) < 0L)
          {
            v.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(a.m(a.this)), Long.valueOf(a.n(a.this)), Long.valueOf(a.f(a.this)), Long.valueOf(a.l(a.this)), Integer.valueOf(a.j(a.this)[5]) });
            g.oSF.a(401L, 0L, 1L, false);
            g.oSF.a(401L, 1L, Math.abs(a.f(a.this)), false);
          }
        }
        a locala = a.this;
        Runnable localRunnable = a.e(a.this);
        if (a.f(a.this) > 0L) {}
        for (l = a.f(a.this);; l = 0L)
        {
          a.a(locala, localRunnable, l);
          if (a.j(a.this)[2] != 1) {
            break;
          }
          a.d(a.this, 5000L);
          GMTrace.o(12899397402624L, 96108);
          return;
        }
        a.d(a.this, a.j(a.this)[4]);
        GMTrace.o(12899397402624L, 96108);
      }
    };
    if (paramInputStream == null) {
      throw new NullPointerException("input stream is null.");
    }
    this.mHL = MMGIFJNI.openByInputStrem(paramInputStream, this.mHN);
    init();
    GMTrace.o(12884499234816L, 95997);
  }
  
  public a(String paramString)
  {
    GMTrace.i(12884230799360L, 95995);
    this.lp = true;
    this.mHK = false;
    this.mHM = null;
    this.mHN = new int[6];
    this.mHO = 1.0F;
    this.mHP = 1.0F;
    this.tZ = new Rect();
    this.fu = new Paint(6);
    this.mHS = 0;
    this.mHT = -1;
    this.mHU = 0L;
    this.mHV = 0L;
    this.mHW = 0L;
    this.mHX = 0L;
    this.mHZ = 0L;
    this.mIb = false;
    this.mIc = 0;
    this.mId = 0;
    this.jrx = new ad();
    this.mIf = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12883828146176L, 95992);
        GMTrace.o(12883828146176L, 95992);
      }
    };
    this.mIg = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12890002161664L, 96038);
        if (((a.this.isRunning()) || (a.b(a.this) == 0)) && (SystemClock.uptimeMillis() >= a.c(a.this)))
        {
          a.a(a.this, System.currentTimeMillis());
          a.this.invalidateSelf();
          if (a.a(a.this) != null) {
            a.a(a.this).invalidate();
          }
        }
        GMTrace.o(12890002161664L, 96038);
      }
    };
    this.mIh = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12893491822592L, 96064);
        MMGIFJNI.restoreRemainder(a.d(a.this));
        a.a(a.this, a.e(a.this), a.f(a.this));
        GMTrace.o(12893491822592L, 96064);
      }
    };
    this.mIi = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12883559710720L, 95990);
        MMGIFJNI.reset(a.d(a.this));
        GMTrace.o(12883559710720L, 95990);
      }
    };
    this.mIj = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12883022839808L, 95986);
        MMGIFJNI.saveRemainder(a.d(a.this));
        GMTrace.o(12883022839808L, 95986);
      }
    };
    this.mIk = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12899397402624L, 96108);
        if (a.g(a.this))
        {
          v.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
          GMTrace.o(12899397402624L, 96108);
          return;
        }
        long l = System.currentTimeMillis();
        if (a.b(a.this) + 1 > a.h(a.this) - 1) {
          a.a(a.this, -1);
        }
        a.a(a.this, a.b(a.this) + 1);
        if (MMGIFJNI.drawFramePixels(a.d(a.this), a.i(a.this), a.j(a.this))) {
          a.k(a.this);
        }
        a.b(a.this, System.currentTimeMillis() - l);
        if (a.l(a.this) != 0L)
        {
          a.c(a.this, a.l(a.this) - a.m(a.this) - a.n(a.this));
          if (a.f(a.this) < 0L)
          {
            v.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(a.m(a.this)), Long.valueOf(a.n(a.this)), Long.valueOf(a.f(a.this)), Long.valueOf(a.l(a.this)), Integer.valueOf(a.j(a.this)[5]) });
            g.oSF.a(401L, 0L, 1L, false);
            g.oSF.a(401L, 1L, Math.abs(a.f(a.this)), false);
          }
        }
        a locala = a.this;
        Runnable localRunnable = a.e(a.this);
        if (a.f(a.this) > 0L) {}
        for (l = a.f(a.this);; l = 0L)
        {
          a.a(locala, localRunnable, l);
          if (a.j(a.this)[2] != 1) {
            break;
          }
          a.d(a.this, 5000L);
          GMTrace.o(12899397402624L, 96108);
          return;
        }
        a.d(a.this, a.j(a.this)[4]);
        GMTrace.o(12899397402624L, 96108);
      }
    };
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("file path is null.");
    }
    this.mHL = MMGIFJNI.openByFilePath(paramString, this.mHN);
    init();
    GMTrace.o(12884230799360L, 95995);
  }
  
  public a(byte[] paramArrayOfByte)
  {
    GMTrace.i(12884633452544L, 95998);
    this.lp = true;
    this.mHK = false;
    this.mHM = null;
    this.mHN = new int[6];
    this.mHO = 1.0F;
    this.mHP = 1.0F;
    this.tZ = new Rect();
    this.fu = new Paint(6);
    this.mHS = 0;
    this.mHT = -1;
    this.mHU = 0L;
    this.mHV = 0L;
    this.mHW = 0L;
    this.mHX = 0L;
    this.mHZ = 0L;
    this.mIb = false;
    this.mIc = 0;
    this.mId = 0;
    this.jrx = new ad();
    this.mIf = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12883828146176L, 95992);
        GMTrace.o(12883828146176L, 95992);
      }
    };
    this.mIg = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12890002161664L, 96038);
        if (((a.this.isRunning()) || (a.b(a.this) == 0)) && (SystemClock.uptimeMillis() >= a.c(a.this)))
        {
          a.a(a.this, System.currentTimeMillis());
          a.this.invalidateSelf();
          if (a.a(a.this) != null) {
            a.a(a.this).invalidate();
          }
        }
        GMTrace.o(12890002161664L, 96038);
      }
    };
    this.mIh = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12893491822592L, 96064);
        MMGIFJNI.restoreRemainder(a.d(a.this));
        a.a(a.this, a.e(a.this), a.f(a.this));
        GMTrace.o(12893491822592L, 96064);
      }
    };
    this.mIi = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12883559710720L, 95990);
        MMGIFJNI.reset(a.d(a.this));
        GMTrace.o(12883559710720L, 95990);
      }
    };
    this.mIj = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12883022839808L, 95986);
        MMGIFJNI.saveRemainder(a.d(a.this));
        GMTrace.o(12883022839808L, 95986);
      }
    };
    this.mIk = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12899397402624L, 96108);
        if (a.g(a.this))
        {
          v.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
          GMTrace.o(12899397402624L, 96108);
          return;
        }
        long l = System.currentTimeMillis();
        if (a.b(a.this) + 1 > a.h(a.this) - 1) {
          a.a(a.this, -1);
        }
        a.a(a.this, a.b(a.this) + 1);
        if (MMGIFJNI.drawFramePixels(a.d(a.this), a.i(a.this), a.j(a.this))) {
          a.k(a.this);
        }
        a.b(a.this, System.currentTimeMillis() - l);
        if (a.l(a.this) != 0L)
        {
          a.c(a.this, a.l(a.this) - a.m(a.this) - a.n(a.this));
          if (a.f(a.this) < 0L)
          {
            v.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(a.m(a.this)), Long.valueOf(a.n(a.this)), Long.valueOf(a.f(a.this)), Long.valueOf(a.l(a.this)), Integer.valueOf(a.j(a.this)[5]) });
            g.oSF.a(401L, 0L, 1L, false);
            g.oSF.a(401L, 1L, Math.abs(a.f(a.this)), false);
          }
        }
        a locala = a.this;
        Runnable localRunnable = a.e(a.this);
        if (a.f(a.this) > 0L) {}
        for (l = a.f(a.this);; l = 0L)
        {
          a.a(locala, localRunnable, l);
          if (a.j(a.this)[2] != 1) {
            break;
          }
          a.d(a.this, 5000L);
          GMTrace.o(12899397402624L, 96108);
          return;
        }
        a.d(a.this, a.j(a.this)[4]);
        GMTrace.o(12899397402624L, 96108);
      }
    };
    if (paramArrayOfByte == null) {
      throw new NullPointerException("bytes is null.");
    }
    this.mHL = MMGIFJNI.openByByteArray(paramArrayOfByte, this.mHN);
    init();
    GMTrace.o(12884633452544L, 95998);
  }
  
  private float aCN()
  {
    GMTrace.i(12884901888000L, 96000);
    if (this.mDensity == 0.0F)
    {
      this.mDensity = (com.tencent.mm.bg.a.getDensity(aa.getContext()) / 2.0F);
      if (this.mDensity >= 1.0F) {
        break label58;
      }
      this.mDensity = 1.0F;
    }
    for (;;)
    {
      float f = this.mDensity;
      GMTrace.o(12884901888000L, 96000);
      return f;
      label58:
      if (this.mDensity > 2.0F) {
        this.mDensity = 2.0F;
      }
    }
  }
  
  private void init()
  {
    GMTrace.i(12884767670272L, 95999);
    v.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", new Object[] { Long.valueOf(this.mHL) });
    this.mHS = this.mHN[2];
    this.mIa = com.tencent.mm.bg.a.T(aa.getContext(), a.c.kBL);
    if ((this.mHN[0] > 1024) || (this.mHN[1] > 1024))
    {
      v.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.mHN[0]), Integer.valueOf(this.mHN[1]) });
      this.mHR = new int[this.mIa * this.mIa];
      this.mIb = true;
      g.oSF.a(401L, 2L, 1L, false);
      GMTrace.o(12884767670272L, 95999);
      return;
    }
    this.mHR = new int[this.mHN[0] * this.mHN[1]];
    GMTrace.o(12884767670272L, 95999);
  }
  
  final void d(Runnable paramRunnable, long paramLong)
  {
    GMTrace.i(12883962363904L, 95993);
    this.mHZ = (SystemClock.uptimeMillis() + paramLong);
    if (this.jrx != null) {
      this.jrx.postAtTime(paramRunnable, this.mHZ);
    }
    GMTrace.o(12883962363904L, 95993);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    GMTrace.i(12885438758912L, 96004);
    if (this.mHQ)
    {
      this.tZ.set(getBounds());
      this.mHO = (this.tZ.width() / this.mHN[0]);
      this.mHP = (this.tZ.height() / this.mHN[1]);
      this.mHQ = false;
    }
    if (this.fu.getShader() == null)
    {
      if (this.mHX == 0L) {
        this.mHX = System.currentTimeMillis();
      }
      paramCanvas.scale(this.mHO, this.mHP);
      int[] arrayOfInt = this.mHR;
      if (arrayOfInt != null) {
        if (arrayOfInt.length == this.mHN[0] * this.mHN[1]) {
          paramCanvas.drawBitmap(arrayOfInt, 0, this.mHN[0], 0.0F, 0.0F, this.mHN[0], this.mHN[1], true, this.fu);
        }
      }
      for (;;)
      {
        this.mHY = (System.currentTimeMillis() - this.mHX);
        if ((this.mIb) || (this.mHN[2] <= 0)) {
          break label345;
        }
        if (this.mHN[4] < 0) {
          v.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
        }
        if ((this.mIc == 0) || (this.mId <= this.mIc - 1)) {
          break;
        }
        d(this.mIf, 0L);
        GMTrace.o(12885438758912L, 96004);
        return;
        paramCanvas.drawRGB(230, 230, 230);
        v.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(this.mHN[0]), Integer.valueOf(this.mHN[1]) });
        continue;
        v.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
      }
      com.tencent.mm.af.a.a(this.mIk, 0L);
      GMTrace.o(12885438758912L, 96004);
      return;
      label345:
      v.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", new Object[] { Integer.valueOf(this.mHN[2]), Integer.valueOf(this.mHN[4]), Boolean.valueOf(this.mIb) });
      GMTrace.o(12885438758912L, 96004);
      return;
    }
    v.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
    paramCanvas.drawRect(this.tZ, this.fu);
    GMTrace.o(12885438758912L, 96004);
  }
  
  protected final void finalize()
  {
    GMTrace.i(12886512500736L, 96012);
    try
    {
      recycle();
      GMTrace.o(12886512500736L, 96012);
      return;
    }
    catch (Throwable localThrowable)
    {
      super.finalize();
      GMTrace.o(12886512500736L, 96012);
    }
  }
  
  public final int getIntrinsicHeight()
  {
    GMTrace.i(12885170323456L, 96002);
    int i = (int)(this.mHN[1] * aCN());
    GMTrace.o(12885170323456L, 96002);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    GMTrace.i(12885036105728L, 96001);
    int i = (int)(this.mHN[0] * aCN());
    GMTrace.o(12885036105728L, 96001);
    return i;
  }
  
  public final int getOpacity()
  {
    GMTrace.i(12885572976640L, 96005);
    GMTrace.o(12885572976640L, 96005);
    return -2;
  }
  
  public final boolean isRunning()
  {
    GMTrace.i(12885975629824L, 96008);
    boolean bool = this.lp;
    GMTrace.o(12885975629824L, 96008);
    return bool;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    GMTrace.i(12885304541184L, 96003);
    super.onBoundsChange(paramRect);
    this.mHQ = true;
    GMTrace.o(12885304541184L, 96003);
  }
  
  public final void recycle()
  {
    GMTrace.i(12886378283008L, 96011);
    v.d("MicroMsg.GIF.MMGIFDrawable", "recycle");
    this.mHK = true;
    this.lp = false;
    long l = this.mHL;
    this.mHL = 0L;
    MMGIFJNI.recycle(l);
    this.mHR = null;
    if (this.mHM != null) {
      try
      {
        this.mHM.close();
        GMTrace.o(12886378283008L, 96011);
        return;
      }
      catch (Exception localException) {}
    }
    GMTrace.o(12886378283008L, 96011);
  }
  
  public final void setAlpha(int paramInt)
  {
    GMTrace.i(12885707194368L, 96006);
    this.fu.setAlpha(paramInt);
    GMTrace.o(12885707194368L, 96006);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    GMTrace.i(12885841412096L, 96007);
    this.fu.setColorFilter(paramColorFilter);
    GMTrace.o(12885841412096L, 96007);
  }
  
  public final void start()
  {
    GMTrace.i(12886109847552L, 96009);
    this.lp = true;
    com.tencent.mm.af.a.a(this.mIh, 0L);
    GMTrace.o(12886109847552L, 96009);
  }
  
  public final void stop()
  {
    GMTrace.i(12886244065280L, 96010);
    v.d("MicroMsg.GIF.MMGIFDrawable", "stop");
    this.lp = false;
    com.tencent.mm.af.a.a(this.mIj, 300L);
    GMTrace.o(12886244065280L, 96010);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/gif/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */