package com.tencent.mm.ui.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.x;

public final class c
  implements b.h
{
  private Bitmap bitmap;
  private Context context;
  private ImageView fMP;
  private ProgressBar fMR;
  private View ipa;
  private View neg;
  private TextView qEa;
  private TextView qEb;
  private View qkq;
  public o sOK;
  public boolean sOL;
  private long vdd;
  private ImageView vde;
  private String vdf;
  private boolean vdg;
  private boolean vdh;
  public a vdi;
  public ad vdj;
  
  public c(Context paramContext, View paramView1, View paramView2, boolean paramBoolean)
  {
    GMTrace.i(18814372675584L, 140178);
    this.vdd = 0L;
    this.ipa = null;
    this.qEa = null;
    this.qEb = null;
    this.fMP = null;
    this.vde = null;
    this.fMR = null;
    this.vdf = null;
    this.bitmap = null;
    this.sOL = true;
    this.vdg = false;
    this.vdh = false;
    this.vdj = null;
    this.context = paramContext;
    this.qkq = paramView1;
    this.neg = paramView2;
    this.vdh = paramBoolean;
    this.ipa = View.inflate(this.context, R.i.cXl, null);
    this.qEa = ((TextView)this.ipa.findViewById(R.h.bXb));
    this.qEb = ((TextView)this.ipa.findViewById(R.h.bXc));
    this.fMP = ((ImageView)this.ipa.findViewById(R.h.bWO));
    this.vde = ((ImageView)this.ipa.findViewById(R.h.bMn));
    this.fMR = ((ProgressBar)this.ipa.findViewById(R.h.bWX));
    this.sOK = new o(this.ipa, -2, -2, true);
    this.sOK.setBackgroundDrawable(new ColorDrawable(0));
    this.sOK.setOutsideTouchable(true);
    this.sOK.setFocusable(false);
    this.ipa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(17887196610560L, 133270);
        if (c.this.vdi != null) {
          c.this.vdi.bRo();
        }
        c.this.sOK.dismiss();
        GMTrace.o(17887196610560L, 133270);
      }
    });
    this.vdj = new ad(this.context.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(17882096336896L, 133232);
        c.this.bRn();
        GMTrace.o(17882096336896L, 133232);
      }
    };
    GMTrace.o(18814372675584L, 140178);
  }
  
  public final void Ba()
  {
    GMTrace.i(17881156812800L, 133225);
    v.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
    this.fMR.setVisibility(0);
    this.fMP.setVisibility(8);
    this.vde.setVisibility(8);
    GMTrace.o(17881156812800L, 133225);
  }
  
  public final void Bb()
  {
    GMTrace.i(17881425248256L, 133227);
    v.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
    this.vde.setVisibility(0);
    this.fMR.setVisibility(8);
    this.fMP.setVisibility(8);
    GMTrace.o(17881425248256L, 133227);
  }
  
  public final String Bc()
  {
    GMTrace.i(17881559465984L, 133228);
    String str = b.aM(this);
    GMTrace.o(17881559465984L, 133228);
    return str;
  }
  
  public final void bRn()
  {
    GMTrace.i(17881827901440L, 133230);
    if ((this.fMP == null) || (this.sOK == null) || (this.qkq == null) || (this.neg == null))
    {
      v.e("MicroMsg.AppBrandServiceImageBubble", "these references include null reference");
      GMTrace.o(17881827901440L, 133230);
      return;
    }
    int i;
    label76:
    int k;
    label86:
    int j;
    label95:
    int n;
    int m;
    Object localObject;
    if (this.bitmap != null)
    {
      v.d("MicroMsg.AppBrandServiceImageBubble", "bitmap is null,return");
      i = 1;
      if (i != 0) {
        break label284;
      }
      Ba();
      if (!this.sOL) {
        break label295;
      }
      k = 83;
      if (!this.sOL) {
        break label301;
      }
      j = 0;
      n = j.aD(this.context);
      m = this.neg.getHeight();
      i = m;
      if (this.vdh)
      {
        i = m;
        if (m < n) {
          i = m + n;
        }
      }
      n = j;
      m = i;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = x.bQv();
        if (!this.sOL) {
          break label307;
        }
        j = 0;
      }
    }
    for (;;)
    {
      m = i + ((Rect)localObject).bottom;
      v.i("MicroMsg.AppBrandServiceImageBubble", "bubble navbar height %s %s", new Object[] { Integer.valueOf(((Rect)localObject).right), Integer.valueOf(((Rect)localObject).bottom) });
      n = j;
      this.sOK.showAtLocation(this.qkq, k, n, m);
      if (this.vdd > 0L)
      {
        localObject = new ai(new ai.a()
        {
          public final boolean oQ()
          {
            GMTrace.i(17884780691456L, 133252);
            c localc = c.this;
            v.d("MicroMsg.AppBrandServiceImageBubble", "hide");
            if (localc.sOK != null) {
              localc.sOK.dismiss();
            }
            GMTrace.o(17884780691456L, 133252);
            return false;
          }
        }, false);
        long l = this.vdd;
        ((ai)localObject).v(l, l);
      }
      GMTrace.o(17881827901440L, 133230);
      return;
      i = 0;
      break;
      label284:
      h(this.bitmap);
      break label76;
      label295:
      k = 85;
      break label86;
      label301:
      j = 10;
      break label95;
      label307:
      j += ((Rect)localObject).right;
    }
  }
  
  public final void h(Bitmap paramBitmap)
  {
    GMTrace.i(17881291030528L, 133226);
    v.d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
    if (paramBitmap == null)
    {
      v.w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
      GMTrace.o(17881291030528L, 133226);
      return;
    }
    this.bitmap = paramBitmap;
    this.fMR.setVisibility(8);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.fMP.setVisibility(0);
      this.fMP.setImageBitmap(paramBitmap);
      this.vde.setVisibility(8);
      GMTrace.o(17881291030528L, 133226);
      return;
    }
    this.vde.setVisibility(0);
    this.fMP.setVisibility(8);
    GMTrace.o(17881291030528L, 133226);
  }
  
  public static abstract interface a
  {
    public abstract void bRo();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */