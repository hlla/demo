package com.tencent.mm.aw.a;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.qq.wx.voice.vad.EVadNative;
import com.qq.wx.voice.vad.MMVoipVadNative;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.d;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Map;

public class c
{
  private static final String TAG;
  public static SharedPreferences hgn;
  private ad handler;
  private boolean idi;
  private int idj;
  private boolean idk;
  private boolean idl;
  private long idm;
  private int idn;
  private boolean ido;
  private a idp;
  private com.qq.wx.voice.vad.a idq;
  public a idr;
  private short[] ids;
  
  static
  {
    GMTrace.i(4383550996480L, 32660);
    TAG = c.class.getSimpleName();
    hgn = aa.bIO();
    GMTrace.o(4383550996480L, 32660);
  }
  
  public c()
  {
    this(3500, 16000, hgn.getInt("sil_time", 1000), hgn.getFloat("s_n_ration", 2.5F), hgn.getInt("s_window", 500), hgn.getInt("s_length", 350), hgn.getInt("s_delay_time", 550), true, true);
    GMTrace.i(4382879907840L, 32655);
    GMTrace.o(4382879907840L, 32655);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(4383014125568L, 32656);
    this.idi = true;
    this.idj = 3;
    this.idk = false;
    this.idl = false;
    this.idm = 0L;
    this.idn = 3500;
    this.ido = false;
    this.handler = new ad(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(4382343036928L, 32651);
        if (paramAnonymousMessage.what != 0)
        {
          GMTrace.o(4382343036928L, 32651);
          return;
        }
        if (c.this.idr != null) {
          c.this.idr.LU();
        }
        GMTrace.o(4382343036928L, 32651);
      }
    };
    this.idp = null;
    this.idq = null;
    this.idn = paramInt1;
    this.idq = new com.qq.wx.voice.vad.a();
    int i = 0;
    paramInt2 = i;
    Object localObject;
    if (aa.bIR())
    {
      localObject = com.tencent.mm.u.c.c.Az().dX("100235");
      paramInt2 = i;
      if (((com.tencent.mm.storage.c)localObject).isValid()) {
        paramInt2 = bf.getInt((String)((com.tencent.mm.storage.c)localObject).bKA().get("MMVoipVadOn"), 0);
      }
    }
    v.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt2 == 0)
    {
      com.qq.wx.voice.vad.a.ag(false);
      localObject = this.idq;
      if (!com.qq.wx.voice.vad.a.aJa) {
        break label295;
      }
      ((com.qq.wx.voice.vad.a)localObject).aIX = ((com.qq.wx.voice.vad.a)localObject).aIZ.Init(16000, paramInt3, paramFloat, paramInt4, paramInt5);
      label206:
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad Init handle = " + ((com.qq.wx.voice.vad.a)localObject).aIX);
      }
      if (((com.qq.wx.voice.vad.a)localObject).aIX != 0L) {
        break label321;
      }
      paramInt2 = 1;
      label250:
      if (paramInt2 != 1)
      {
        localObject = this.idq;
        if (((com.qq.wx.voice.vad.a)localObject).aIX != 0L) {
          break label326;
        }
        paramInt2 = 1;
      }
    }
    for (;;)
    {
      if (paramInt2 != 1) {
        break label398;
      }
      throw new b("Init ERROR");
      com.qq.wx.voice.vad.a.ag(true);
      break;
      label295:
      ((com.qq.wx.voice.vad.a)localObject).aIX = ((com.qq.wx.voice.vad.a)localObject).aIY.Init(16000, paramInt3, paramFloat, paramInt4, paramInt5);
      break label206;
      label321:
      paramInt2 = 0;
      break label250;
      label326:
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad Reset handle = " + ((com.qq.wx.voice.vad.a)localObject).aIX);
      }
      if (com.qq.wx.voice.vad.a.aJa) {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).aIZ.Reset(((com.qq.wx.voice.vad.a)localObject).aIX);
      } else {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).aIY.Reset(((com.qq.wx.voice.vad.a)localObject).aIX);
      }
    }
    label398:
    this.idp = new a(paramInt6 * 16);
    this.ids = new short['ྠ'];
    this.handler.removeMessages(0);
    this.handler.sendEmptyMessageDelayed(0, paramInt1);
    this.idk = paramBoolean1;
    this.idl = paramBoolean2;
    GMTrace.o(4383014125568L, 32656);
  }
  
  public static String LZ()
  {
    GMTrace.i(4382745690112L, 32654);
    String str = String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[] { "sil_time", Integer.valueOf(hgn.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(hgn.getFloat("s_n_ration", 2.5F)), "s_window", Integer.valueOf(hgn.getInt("s_window", 500)), "s_length", Integer.valueOf(hgn.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(hgn.getInt("s_delay_time", 550)) });
    GMTrace.o(4382745690112L, 32654);
    return str;
  }
  
  public final void c(short[] paramArrayOfShort, int paramInt)
  {
    GMTrace.i(4383148343296L, 32657);
    v.d(TAG, "input() called with: voice = [%s], length = [%s]", new Object[] { paramArrayOfShort, Integer.valueOf(paramInt) });
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0) || (paramInt <= 0) || (paramInt > paramArrayOfShort.length))
    {
      GMTrace.o(4383148343296L, 32657);
      return;
    }
    if (this.ido)
    {
      v.i(TAG, "VoiceSilentDetectAPI is released.");
      GMTrace.o(4383148343296L, 32657);
      return;
    }
    Object localObject = this.idq;
    int i;
    if (((com.qq.wx.voice.vad.a)localObject).aIX == 0L) {
      i = 1;
    }
    long l;
    for (;;)
    {
      v.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.idj), Boolean.valueOf(this.idk), Boolean.valueOf(this.idl) });
      if (!this.idk) {
        break label487;
      }
      if (!this.idl) {
        break label431;
      }
      l = System.currentTimeMillis();
      if (this.idr != null) {
        this.idr.LT();
      }
      this.idm = l;
      if (!this.ido) {
        break;
      }
      GMTrace.o(4383148343296L, 32657);
      return;
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad AddData handle = " + ((com.qq.wx.voice.vad.a)localObject).aIX);
      }
      if (com.qq.wx.voice.vad.a.aJa) {
        i = ((com.qq.wx.voice.vad.a)localObject).aIZ.AddData(((com.qq.wx.voice.vad.a)localObject).aIX, paramArrayOfShort, paramInt);
      } else {
        i = ((com.qq.wx.voice.vad.a)localObject).aIY.AddData(((com.qq.wx.voice.vad.a)localObject).aIX, paramArrayOfShort, paramInt);
      }
    }
    int j = this.idp.idg;
    int m = this.ids.length;
    if (j > 0) {
      if (m <= j) {
        break label1233;
      }
    }
    label431:
    label487:
    label586:
    label930:
    label1089:
    label1099:
    label1187:
    label1215:
    label1221:
    label1226:
    label1233:
    for (int k = j;; k = m)
    {
      this.idp.b(this.ids, k);
      int n = j - k;
      j = n;
      if (this.idr == null) {
        break;
      }
      this.idr.a(this.ids, k);
      j = n;
      break;
      this.idl = false;
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessageDelayed(0, this.idn);
      for (;;)
      {
        this.idi = false;
        this.idj = i;
        if (!this.ido) {
          break;
        }
        GMTrace.o(4383148343296L, 32657);
        return;
        if ((this.idj == 3) && (i == 2)) {
          this.idk = false;
        }
        if ((this.idj != 3) || (i != 3))
        {
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.idn);
        }
      }
      if ((this.idj == 3) && (i == 2))
      {
        this.idj = i;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.idn);
        l = System.currentTimeMillis();
        if (this.idr != null) {
          this.idr.LT();
        }
        this.idm = l;
        if (this.ido)
        {
          GMTrace.o(4383148343296L, 32657);
          return;
        }
        i = this.idp.idg;
        k = this.ids.length;
        if (i > 0) {
          if (k <= i) {
            break label1226;
          }
        }
      }
      for (j = i;; j = k)
      {
        this.idp.b(this.ids, j);
        m = i - j;
        i = m;
        if (this.idr == null) {
          break label586;
        }
        this.idr.a(this.ids, j);
        i = m;
        break label586;
        this.idi = false;
        break;
        if ((this.idj == 2) && (i == 3))
        {
          this.idj = i;
          this.idi = true;
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.idn);
          l = System.currentTimeMillis();
          if (this.idr != null) {
            this.idr.LS();
          }
          this.idm = l;
          if (!this.ido) {
            break;
          }
          GMTrace.o(4383148343296L, 32657);
          return;
        }
        if ((this.idj == 3) && (i == 3))
        {
          this.idi = true;
          break;
        }
        if ((this.idj != 2) || (i != 2)) {
          break;
        }
        this.idi = false;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.idn);
        break;
        localObject = this.idp;
        if (paramArrayOfShort.length >= 0) {
          if (paramInt <= paramArrayOfShort.length + 0) {
            break label1221;
          }
        }
        for (i = paramArrayOfShort.length + 0;; i = paramInt)
        {
          if (i != 0)
          {
            j = ((a)localObject).idh.length - ((a)localObject).idg;
            if (i > j)
            {
              j = i - j;
              if (j != 0)
              {
                if (j >= ((a)localObject).idg) {
                  break label1089;
                }
                if (j > ((a)localObject).idh.length - ((a)localObject).ide) {
                  break label1099;
                }
                ((a)localObject).ide += j;
                if (((a)localObject).ide >= ((a)localObject).idh.length) {
                  ((a)localObject).ide = 0;
                }
                ((a)localObject).idg -= j;
              }
            }
            if (i <= ((a)localObject).idh.length) {
              break label1215;
            }
            j = i - ((a)localObject).idh.length + 0;
            i = ((a)localObject).idh.length;
          }
          for (;;)
          {
            if (i <= ((a)localObject).idh.length - ((a)localObject).idf)
            {
              System.arraycopy(paramArrayOfShort, j, ((a)localObject).idh, ((a)localObject).idf, i);
              ((a)localObject).idf += i;
              if (((a)localObject).idf < ((a)localObject).idh.length) {}
            }
            for (((a)localObject).idf = 0;; ((a)localObject).idf = m)
            {
              ((a)localObject).idg = (i + ((a)localObject).idg);
              v.d(TAG, "isSilent %s", new Object[] { Boolean.valueOf(this.idi) });
              if (!this.idi) {
                break label1187;
              }
              GMTrace.o(4383148343296L, 32657);
              return;
              j = ((a)localObject).idg;
              break;
              ((a)localObject).ide = (j - (((a)localObject).idh.length - ((a)localObject).ide));
              break label930;
              k = ((a)localObject).idh.length - ((a)localObject).idf;
              System.arraycopy(paramArrayOfShort, j, ((a)localObject).idh, ((a)localObject).idf, k);
              m = i - k;
              System.arraycopy(paramArrayOfShort, j + k, ((a)localObject).idh, 0, m);
            }
            if (this.idr != null) {
              this.idr.a(paramArrayOfShort, paramInt);
            }
            GMTrace.o(4383148343296L, 32657);
            return;
            j = 0;
          }
        }
      }
    }
  }
  
  public final void release()
  {
    GMTrace.i(4383282561024L, 32658);
    v.d(TAG, "released");
    this.ido = true;
    this.idk = false;
    this.idl = false;
    if (this.idq != null)
    {
      com.qq.wx.voice.vad.a locala = this.idq;
      int i;
      if (locala.aIX == 0L) {
        i = 1;
      }
      while (i == 1)
      {
        throw new b();
        if (com.qq.wx.voice.vad.a.DEBUG) {
          System.out.println("EVad Release handle = " + locala.aIX);
        }
        if (com.qq.wx.voice.vad.a.aJa) {
          i = locala.aIZ.Release(locala.aIX);
        } else {
          i = locala.aIY.Release(locala.aIX);
        }
      }
      this.idq = null;
    }
    this.idp = null;
    this.ids = null;
    if (this.handler != null)
    {
      this.handler.removeMessages(0);
      this.handler = null;
    }
    this.idr = null;
    GMTrace.o(4383282561024L, 32658);
  }
  
  public static abstract interface a
  {
    public abstract void LS();
    
    public abstract void LT();
    
    public abstract void LU();
    
    public abstract void a(short[] paramArrayOfShort, int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/aw/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */