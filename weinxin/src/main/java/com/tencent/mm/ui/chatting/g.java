package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.a.d.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.t.f.a;
import com.tencent.mm.ui.MMImageView;

final class g
  extends ag.a
{
  public static final int vwE;
  public TextView ipc;
  public TextView ipd;
  public MMImageView vwA;
  public TextView vwB;
  public View vwC;
  public boolean vwD;
  public int vwx;
  
  static
  {
    GMTrace.i(2182917128192L, 16264);
    vwE = (int)com.tencent.mm.bg.a.getDensity(MMApplicationLike.applicationLike.getApplication()) * 64;
    GMTrace.o(2182917128192L, 16264);
  }
  
  public g(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2182514475008L, 16261);
    this.vwx = 0;
    GMTrace.o(2182514475008L, 16261);
  }
  
  public final void a(final Context paramContext, f.a parama, final String paramString, boolean paramBoolean)
  {
    GMTrace.i(2182782910464L, 16263);
    I(this.vAj, this.vwx);
    Object localObject;
    switch (parama.type)
    {
    default: 
      if (parama == null) {
        break label723;
      }
      this.ipc.setText(parama.description);
      this.ipd.setText(parama.hip);
      this.vwA.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = n.GX();
        parama = n.GT().v(paramString, true);
        paramString = this.vwA;
        localObject = new c.a();
        ((c.a)localObject).hIy = 1;
        localObject = ((c.a)localObject).aO(vwE, vwE);
        ((c.a)localObject).hII = R.k.dtk;
        ((c.a)localObject).hIQ = true;
        paramContext.a(parama, paramString, ((c.a)localObject).Hh());
        GMTrace.o(2182782910464L, 16263);
        return;
      }
      break;
    case 16: 
      if (parama == null) {
        break label723;
      }
      this.ipc.setText(parama.description);
      this.ipd.setText(parama.hip);
      this.vwA.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = n.GX();
        parama = n.GT().v(paramString, true);
        paramString = this.vwA;
        localObject = new c.a();
        ((c.a)localObject).hIy = 1;
        localObject = ((c.a)localObject).aO(vwE, vwE);
        ((c.a)localObject).hII = R.k.dtk;
        ((c.a)localObject).hIQ = true;
        paramContext.a(parama, paramString, ((c.a)localObject).Hh());
        GMTrace.o(2182782910464L, 16263);
        return;
      }
      this.vwA.setImageResource(R.g.bhM);
      GMTrace.o(2182782910464L, 16263);
      return;
    case 34: 
      if ((parama.title != null) && (parama.title.length() > 0))
      {
        this.ipc.setVisibility(0);
        this.ipc.setText(parama.title);
        if (!bf.mA(parama.hiy))
        {
          this.ipc.setTextColor(bf.aF(parama.hiy, paramContext.getResources().getColor(R.e.black)));
          this.ipd.setMaxLines(2);
          this.ipd.setVisibility(0);
          this.ipd.setText(parama.description);
          if (bf.mA(parama.hiz)) {
            break label623;
          }
          this.ipd.setTextColor(bf.aF(parama.hiz, paramContext.getResources().getColor(R.e.aUf)));
          label443:
          if (bf.mA(parama.hiu)) {
            break label643;
          }
          this.vwB.setText(parama.hiu);
        }
      }
      for (;;)
      {
        if (paramBoolean)
        {
          paramString = n.GT().a(paramString, com.tencent.mm.bg.a.getDensity(paramContext), false);
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            localObject = d.a(paramString, false, paramString.getWidth() / 2);
            this.vwA.setImageBitmap((Bitmap)localObject);
          }
          if (!bf.mA(parama.hix))
          {
            paramString = n.GX();
            parama = parama.hix;
            localObject = new ImageView(paramContext);
            c.a locala = new c.a();
            locala.hIt = true;
            paramString.a(parama, (ImageView)localObject, locala.Hh(), new com.tencent.mm.ah.a.c.g()
            {
              public final void a(final String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
              {
                GMTrace.i(2284519948288L, 17021);
                if (paramAnonymousb.bitmap != null)
                {
                  paramAnonymousString = paramAnonymousb.bitmap;
                  g.this.vwC.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                  {
                    public final boolean onPreDraw()
                    {
                      GMTrace.i(2249220685824L, 16758);
                      g.this.vwC.getViewTreeObserver().removeOnPreDrawListener(this);
                      int j = g.this.vwC.getHeight();
                      int k = g.this.vwC.getWidth();
                      int i = j;
                      if (j == 0) {
                        i = com.tencent.mm.bg.a.T(g.1.this.val$context, R.f.aZe);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.bg.a.T(g.1.this.val$context, R.f.aZf);
                      }
                      if (g.this.vwD) {}
                      for (Object localObject = d.a(paramAnonymousString, R.g.bdF, j, i);; localObject = d.a(paramAnonymousString, R.g.bdQ, j, i))
                      {
                        localObject = new BitmapDrawable((Bitmap)localObject);
                        g.this.vwC.setBackgroundDrawable((Drawable)localObject);
                        GMTrace.o(2249220685824L, 16758);
                        return true;
                      }
                    }
                  });
                }
                GMTrace.o(2284519948288L, 17021);
              }
              
              public final void jL(String paramAnonymousString)
              {
                GMTrace.i(2284385730560L, 17020);
                GMTrace.o(2284385730560L, 17020);
              }
            });
            GMTrace.o(2182782910464L, 16263);
            return;
            this.ipc.setTextColor(paramContext.getResources().getColor(R.e.black));
            break;
            this.ipc.setVisibility(8);
            break;
            label623:
            this.ipd.setTextColor(paramContext.getResources().getColor(R.e.aUf));
            break label443;
            label643:
            this.vwB.setText(R.l.dTT);
            continue;
          }
          this.vwC.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              GMTrace.i(2295525801984L, 17103);
              g.this.vwC.getViewTreeObserver().removeOnPreDrawListener(this);
              int i = com.tencent.mm.bg.a.fromDPToPix(paramContext, 24);
              Bitmap localBitmap = paramString;
              if (localBitmap != null)
              {
                localObject = localBitmap;
                if (!localBitmap.isRecycled()) {}
              }
              else
              {
                localObject = d.U(paramContext.getResources().getColor(R.e.aTo), i, i);
              }
              int j = ((Bitmap)localObject).getHeight();
              if (i > j)
              {
                i = j;
                localObject = d.c(d.N(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                j = g.this.vwC.getHeight();
                int k = g.this.vwC.getWidth();
                i = j;
                if (j == 0) {
                  i = com.tencent.mm.bg.a.T(paramContext, R.f.aZe);
                }
                j = k;
                if (k == 0) {
                  j = com.tencent.mm.bg.a.T(paramContext, R.f.aZf);
                }
                if (!g.this.vwD) {
                  break label222;
                }
              }
              label222:
              for (Object localObject = d.a((Bitmap)localObject, R.g.bdF, j, i);; localObject = d.a((Bitmap)localObject, R.g.bdQ, j, i))
              {
                localObject = new BitmapDrawable((Bitmap)localObject);
                g.this.vwC.setBackgroundDrawable((Drawable)localObject);
                GMTrace.o(2295525801984L, 17103);
                return true;
                break;
              }
            }
          });
          GMTrace.o(2182782910464L, 16263);
          return;
        }
      }
      this.vwA.setImageBitmap(BitmapFactory.decodeResource(paramContext.getResources(), R.g.bhM));
      GMTrace.o(2182782910464L, 16263);
      return;
    }
    this.vwA.setImageResource(R.g.bhM);
    label723:
    GMTrace.o(2182782910464L, 16263);
  }
  
  public final g o(View paramView, boolean paramBoolean)
  {
    GMTrace.i(2182648692736L, 16262);
    super.dl(paramView);
    this.vwD = paramBoolean;
    this.kvw = ((TextView)this.mgy.findViewById(R.h.bBt));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = this.mgy.findViewById(R.h.bAQ);
    this.phd = ((TextView)this.mgy.findViewById(R.h.bBz));
    this.vwA = ((MMImageView)this.mgy.findViewById(R.h.bpY));
    this.ipc = ((TextView)this.mgy.findViewById(R.h.bpZ));
    this.ipd = ((TextView)this.mgy.findViewById(R.h.bpX));
    this.vwB = ((TextView)this.mgy.findViewById(R.h.bpV));
    this.vwC = this.mgy.findViewById(R.h.bpW);
    this.vwx = ag.eU(aa.getContext());
    GMTrace.o(2182648692736L, 16262);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */