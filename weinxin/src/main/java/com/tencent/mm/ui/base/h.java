package com.tencent.mm.ui.base;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.a;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.j;
import com.tencent.mm.s.a.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.r;
import java.util.Iterator;
import java.util.List;

public class h
  extends Dialog
  implements DialogInterface
{
  private CheckBox Qb;
  private View joI;
  private View kD;
  private EditText kM;
  private TextView ljS;
  private Button lwR;
  private Context mContext;
  private ImageView mzA;
  private boolean pnV;
  public Button rLu;
  private LinearLayout vge;
  private TextView vgf;
  private TextView vgg;
  private TextView vgh;
  private TextView vgi;
  private View vgj;
  private ViewStub vgk;
  private LinearLayout vgl;
  private ViewGroup vgm;
  private LinearLayout vgn;
  private ViewGroup vgo;
  private View vgp;
  private boolean vgq;
  private boolean vgr;
  private Animation vgs;
  private Animation vgt;
  private Animation vgu;
  private Animation vgv;
  private h.a.c vgw;
  private int[] vgx;
  
  public h(Context paramContext)
  {
    super(paramContext, a.l.foC);
    GMTrace.i(3269678071808L, 24361);
    this.vgq = false;
    this.vgr = false;
    this.vgx = new int[] { a.g.hdi, a.g.hdj, a.g.hdk, a.g.hdl, a.g.hdm, a.g.hdn, a.g.hdo, a.g.hdp, a.g.hdq };
    this.mContext = paramContext;
    this.vge = ((LinearLayout)r.eC(this.mContext).inflate(a.h.hdP, null));
    this.rLu = ((Button)this.vge.findViewById(a.g.cjZ));
    this.lwR = ((Button)this.vge.findViewById(a.g.cjP));
    this.ljS = ((TextView)this.vge.findViewById(a.g.hct));
    this.vgf = ((TextView)this.vge.findViewById(a.g.cjT));
    this.vgg = ((TextView)this.vge.findViewById(a.g.hcs));
    this.vgh = ((TextView)this.vge.findViewById(a.g.cjX));
    this.vgi = ((TextView)this.vge.findViewById(a.g.bEs));
    this.kM = ((EditText)this.vge.findViewById(a.g.bEw));
    this.Qb = ((CheckBox)this.vge.findViewById(a.g.hbX));
    this.mzA = ((ImageView)this.vge.findViewById(a.g.cjW));
    this.joI = this.vge.findViewById(a.g.hcu);
    this.vgk = ((ViewStub)this.vge.findViewById(a.g.hds));
    this.vgl = ((LinearLayout)this.vge.findViewById(a.g.cjU));
    this.vgm = ((ViewGroup)this.vge.findViewById(a.g.hcp));
    this.vgp = this.vge.findViewById(a.g.hcq);
    this.vgn = ((LinearLayout)this.vge.findViewById(a.g.hcr));
    this.vgo = ((ViewGroup)this.vge.findViewById(a.g.hdr));
    setCanceledOnTouchOutside(true);
    this.vgs = AnimationUtils.loadAnimation(aa.getContext(), a.a.aQJ);
    this.vgt = AnimationUtils.loadAnimation(aa.getContext(), a.a.aQJ);
    this.vgu = AnimationUtils.loadAnimation(aa.getContext(), a.a.aQK);
    this.vgv = AnimationUtils.loadAnimation(aa.getContext(), a.a.aQK);
    GMTrace.o(3269678071808L, 24361);
  }
  
  private void cs(List<String> paramList)
  {
    GMTrace.i(3270886031360L, 24370);
    this.vgk.setLayoutResource(a.h.hdG);
    int i;
    String str;
    Object localObject;
    try
    {
      LinearLayout localLinearLayout = (LinearLayout)this.vgk.inflate();
      if (paramList == null) {
        break label137;
      }
      paramList = paramList.iterator();
      i = 0;
      if (!paramList.hasNext()) {
        break label137;
      }
      str = (String)paramList.next();
      if (i > 8)
      {
        GMTrace.o(3270886031360L, 24370);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.vgk.setVisibility(0);
        localObject = null;
      }
    }
    if (localObject != null)
    {
      ImageView localImageView = (ImageView)((LinearLayout)localObject).findViewById(this.vgx[i]);
      if (str != null)
      {
        localImageView.setVisibility(0);
        com.tencent.mm.ui.f.a.a.a(localImageView, str);
        i += 1;
      }
    }
    for (;;)
    {
      break;
      label137:
      GMTrace.o(3270886031360L, 24370);
      return;
    }
  }
  
  private void kE(boolean paramBoolean)
  {
    GMTrace.i(3270349160448L, 24366);
    if (paramBoolean)
    {
      int i = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 8);
      this.vgl.setVisibility(0);
      this.vgl.setPadding(i, i, i, i);
      this.vgl.setBackgroundResource(a.f.hbD);
    }
    GMTrace.o(3270349160448L, 24366);
  }
  
  private void zN(int paramInt)
  {
    GMTrace.i(17802371006464L, 132638);
    if (this.vgf != null) {
      this.vgf.setTextColor(this.vgf.getContext().getResources().getColor(paramInt));
    }
    GMTrace.o(17802371006464L, 132638);
  }
  
  private void zO(int paramInt)
  {
    GMTrace.i(3270751813632L, 24369);
    if (this.vgl != null) {
      this.vgl.setVisibility(paramInt);
    }
    if (this.vgn != null) {
      this.vgn.setVisibility(paramInt);
    }
    if ((this.vgi != null) && (this.vgq)) {
      this.vgi.setVisibility(paramInt);
    }
    if (this.kM != null)
    {
      if (!this.vgr)
      {
        this.kM.setVisibility(8);
        GMTrace.o(3270751813632L, 24369);
        return;
      }
      this.kM.setVisibility(paramInt);
    }
    GMTrace.o(3270751813632L, 24369);
  }
  
  public final void H(View paramView, int paramInt)
  {
    GMTrace.i(3271020249088L, 24371);
    this.kD = paramView;
    if (this.kD != null)
    {
      this.vgl.setVisibility(0);
      this.vgn.setVisibility(0);
      this.vgn.removeAllViews();
      this.vgn.setGravity(1);
      this.vgn.addView(this.kD, new LinearLayout.LayoutParams(paramInt, paramInt));
    }
    GMTrace.o(3271020249088L, 24371);
  }
  
  public final void a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    GMTrace.i(3271557120000L, 24375);
    a(this.mContext.getString(paramInt), true, paramOnClickListener);
    GMTrace.o(3271557120000L, 24375);
  }
  
  public final void a(c paramc)
  {
    GMTrace.i(3272228208640L, 24380);
    if ((paramc.title != null) && (paramc.title.length() > 0)) {
      setTitle(paramc.title);
    }
    int i;
    if (paramc.sFy != 0)
    {
      i = paramc.sFy;
      this.ljS.setTextColor(ColorStateList.valueOf(i));
    }
    if (paramc.ves != 0)
    {
      i = paramc.ves;
      this.ljS.setMaxLines(i);
    }
    if (paramc.vet != 0)
    {
      i = paramc.vet;
      this.vgf.setMaxLines(i);
    }
    if (paramc.sbS != null) {
      H(paramc.sbS, -1);
    }
    if (paramc.veq != null)
    {
      this.vgj = paramc.veq;
      if (this.vgj != null)
      {
        this.vgl.setVisibility(8);
        this.vgi.setVisibility(8);
        this.kM.setVisibility(8);
        this.vgo.removeAllViews();
        this.vgo.addView(this.vgj, new LinearLayout.LayoutParams(-1, -1));
        this.vgo.setVisibility(8);
      }
    }
    if (paramc.ved != null)
    {
      localObject1 = paramc.ved;
      if (this.kD == null)
      {
        this.vgl.setVisibility(0);
        this.mzA.setVisibility(0);
        this.mzA.setBackgroundDrawable((Drawable)localObject1);
      }
    }
    if ((paramc.veg != null) && (paramc.veg.length() > 0)) {
      setMessage(paramc.veg);
    }
    kE(paramc.vem);
    if (paramc.fKq != null)
    {
      localObject1 = paramc.fKq;
      i = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 120);
      this.vgl.setVisibility(0);
      this.mzA.setVisibility(0);
      if ((this.mzA instanceof com.tencent.mm.ui.f.a)) {
        ((com.tencent.mm.ui.f.a)this.mzA).K((String)localObject1, i, i);
      }
      i = paramc.vew;
      this.vgl.setVisibility(i);
      this.mzA.setVisibility(i);
    }
    final Object localObject2;
    if ((!paramc.vey) && (!paramc.vez))
    {
      if ((paramc.veg != null) && (paramc.veg.length() > 0)) {
        setMessage(paramc.veg);
      }
      if ((paramc.veh == null) || (paramc.veh.length() <= 0)) {
        break label1893;
      }
      localObject1 = paramc.veh;
      this.vgl.setVisibility(0);
      this.vgg.setVisibility(0);
      this.vgg.setMaxLines(2);
      this.vgg.setText((CharSequence)localObject1);
      if ((paramc.vei != null) && (paramc.vei.length() > 0))
      {
        localObject2 = paramc.vei;
        if (localObject2 != null)
        {
          this.vgl.setVisibility(0);
          this.vgh.setVisibility(0);
          localObject1 = localObject2;
          if (this.vgw != null)
          {
            localObject1 = this.vgw;
            this.vgh.getContext();
            localObject1 = ((h.a.c)localObject1).a(((CharSequence)localObject2).toString(), this.vgh.getTextSize());
          }
          this.vgh.setText((CharSequence)localObject1);
        }
      }
      if (paramc.vee != null)
      {
        localObject1 = paramc.vee;
        if (this.kD == null)
        {
          this.vgl.setVisibility(0);
          this.mzA.setVisibility(0);
          this.mzA.setImageBitmap((Bitmap)localObject1);
        }
      }
    }
    Object localObject3;
    final Object localObject4;
    Object localObject5;
    if (paramc.vey)
    {
      localObject1 = paramc.vee;
      localObject3 = paramc.veh;
      localObject2 = paramc.vei;
      localObject4 = r.eC(this.mContext).inflate(a.h.hdC, null);
      if (localObject1 != null)
      {
        localObject5 = (ImageView)((View)localObject4).findViewById(a.g.cjW);
        ((ImageView)localObject5).setVisibility(0);
        ((ImageView)localObject5).setImageBitmap((Bitmap)localObject1);
      }
      if (localObject3 != null)
      {
        localObject5 = (TextView)((View)localObject4).findViewById(a.g.hcs);
        ((TextView)localObject5).setVisibility(0);
        localObject1 = localObject3;
        if (this.vgw != null) {
          localObject1 = this.vgw.a(((CharSequence)localObject3).toString(), ((TextView)localObject5).getTextSize());
        }
        ((TextView)localObject5).setText((CharSequence)localObject1);
      }
      if (localObject2 != null)
      {
        localObject3 = (TextView)((View)localObject4).findViewById(a.g.cjX);
        ((TextView)localObject3).setVisibility(0);
        if (this.vgw == null) {
          break label2331;
        }
      }
    }
    label1893:
    label2122:
    label2149:
    label2251:
    label2291:
    label2317:
    label2324:
    label2331:
    for (final Object localObject1 = this.vgw.a(((CharSequence)localObject2).toString(), ((TextView)localObject3).getTextSize());; localObject1 = localException)
    {
      ((TextView)localObject3).setText((CharSequence)localObject1);
      H((View)localObject4, -1);
      for (;;)
      {
        boolean bool;
        if ((paramc.vdV != null) || (paramc.vdX != null))
        {
          localObject5 = paramc.vdV;
          localObject3 = paramc.vdX;
          bool = paramc.vdY;
          localObject4 = paramc.vea;
          this.vgk.setLayoutResource(a.h.hdF);
          localObject1 = null;
        }
        try
        {
          localObject2 = (LinearLayout)this.vgk.inflate();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i1;
            int j;
            float f;
            int k;
            int m;
            this.vgk.setVisibility(0);
            continue;
            if (this.vgn != null)
            {
              this.vgn.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  GMTrace.i(3368193884160L, 25095);
                  if (localObject1 != null) {
                    localObject1.auB();
                  }
                  GMTrace.o(3368193884160L, 25095);
                }
              });
              continue;
              if ((f >= 0.5D) && (f < 1.0F))
              {
                j = (int)(i * f);
                k = i;
                m = j;
              }
              else
              {
                int n;
                if ((f >= 1.0F) && (f < 2.0F))
                {
                  n = (int)(i / f);
                  k = n;
                  m = i;
                  j = i;
                  i = n;
                }
                else if (f >= 2.0F)
                {
                  n = (int)(j * f);
                  k = j;
                  m = j;
                  j = i;
                  i = m;
                  m = n;
                  continue;
                  ((ImageView)localObject1).setVisibility(0);
                  if (i1 == 1)
                  {
                    ((ImageView)localObject1).setImageResource(a.j.heK);
                  }
                  else if (i1 == 2)
                  {
                    ((ImageView)localObject1).setImageResource(a.j.dti);
                    continue;
                    this.kM.setVisibility(8);
                  }
                }
                else
                {
                  j = 0;
                  i = 0;
                  k = 0;
                  m = 0;
                  continue;
                  localObject1 = localException;
                  continue;
                  localObject1 = localException;
                }
              }
            }
          }
        }
        if ((localObject1 != null) && (localObject5 != null))
        {
          localObject2 = (ImageView)((LinearLayout)localObject1).findViewById(a.g.hdh);
          ((ImageView)localObject2).setVisibility(0);
          com.tencent.mm.ui.f.a.a.a((ImageView)localObject2, (String)localObject5);
        }
        if ((localObject1 != null) && (localObject3 != null))
        {
          localObject5 = (TextView)((LinearLayout)localObject1).findViewById(a.g.hdt);
          ((TextView)localObject5).setVisibility(0);
          localObject2 = localObject3;
          if (this.vgw != null) {
            localObject2 = this.vgw.a(((CharSequence)localObject3).toString(), this.ljS.getTextSize());
          }
          ((TextView)localObject5).setText((CharSequence)localObject2);
        }
        if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
        {
          localObject2 = (ImageView)((LinearLayout)localObject1).findViewById(a.g.hcl);
          ((ImageView)localObject2).setVisibility(0);
          zO(0);
          ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              GMTrace.i(3172638654464L, 23638);
              if (localObject4 != null) {
                localObject4.bEL();
              }
              if (localObject2.isSelected())
              {
                h.c(h.this).startAnimation(h.b(h.this));
                h.b(h.this).setAnimationListener(new Animation.AnimationListener()
                {
                  public final void onAnimationEnd(Animation paramAnonymous2Animation)
                  {
                    GMTrace.i(3368999190528L, 25101);
                    h.c(h.this).setVisibility(8);
                    h.a(h.this, 0);
                    GMTrace.o(3368999190528L, 25101);
                  }
                  
                  public final void onAnimationRepeat(Animation paramAnonymous2Animation)
                  {
                    GMTrace.i(3369133408256L, 25102);
                    GMTrace.o(3369133408256L, 25102);
                  }
                  
                  public final void onAnimationStart(Animation paramAnonymous2Animation)
                  {
                    GMTrace.i(3368864972800L, 25100);
                    h.a(h.this, h.d(h.this));
                    GMTrace.o(3368864972800L, 25100);
                  }
                });
                ObjectAnimator.ofFloat(localObject2, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
                localObject2.setSelected(false);
                GMTrace.o(3172638654464L, 23638);
                return;
              }
              h.c(h.this).startAnimation(h.e(h.this));
              h.e(h.this).setAnimationListener(new Animation.AnimationListener()
              {
                public final void onAnimationEnd(Animation paramAnonymous2Animation)
                {
                  GMTrace.i(3269275418624L, 24358);
                  h.c(h.this).setVisibility(0);
                  h.a(h.this, 8);
                  GMTrace.o(3269275418624L, 24358);
                }
                
                public final void onAnimationRepeat(Animation paramAnonymous2Animation)
                {
                  GMTrace.i(3269409636352L, 24359);
                  GMTrace.o(3269409636352L, 24359);
                }
                
                public final void onAnimationStart(Animation paramAnonymous2Animation)
                {
                  GMTrace.i(3269141200896L, 24357);
                  h.a(h.this, h.f(h.this));
                  GMTrace.o(3269141200896L, 24357);
                }
              });
              ObjectAnimator.ofFloat(localObject2, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
              localObject2.setSelected(true);
              GMTrace.o(3172638654464L, 23638);
            }
          });
        }
        if (paramc.veb != null)
        {
          localObject1 = paramc.veb;
          if ((this.vgl == null) || (this.vgl.getVisibility() != 0)) {
            break label2122;
          }
          this.vgl.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              GMTrace.i(3282697191424L, 24458);
              if (localObject1 != null) {
                localObject1.auB();
              }
              GMTrace.o(3282697191424L, 24458);
            }
          });
        }
        if (paramc.vdW != null) {
          cs(paramc.vdW);
        }
        if ((paramc.vef != null) && (!paramc.vef.isRecycled()))
        {
          localObject2 = paramc.vef;
          bool = paramc.ven;
          i1 = paramc.vev;
          if (localObject2 != null)
          {
            kE(false);
            this.vgl.setVisibility(0);
            this.vgl.setGravity(1);
            this.vgl.setPadding(0, 0, 0, 0);
            localObject4 = View.inflate(this.mContext, a.h.hdE, null);
            localObject5 = (ImageView)((View)localObject4).findViewById(a.g.cjW);
            if (!bool) {
              break label2317;
            }
            i = ((Bitmap)localObject2).getWidth();
            j = ((Bitmap)localObject2).getHeight();
            localObject3 = null;
            f = j / i;
            j = com.tencent.mm.bg.a.U(this.mContext, a.e.hbw);
            i = com.tencent.mm.bg.a.U(this.mContext, a.e.hbv);
            if ((f <= 0.0F) || (f >= 0.5D)) {
              break label2149;
            }
            k = (int)(j / f);
            m = j;
            localObject1 = localObject3;
            if (m > 0)
            {
              localObject1 = localObject3;
              if (k > 0)
              {
                localObject1 = localObject3;
                if (localObject2 != null)
                {
                  localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, k, m, true);
                  ((ImageView)localObject5).setLayoutParams(new FrameLayout.LayoutParams(i, j));
                }
              }
            }
            localObject1 = d.a((Bitmap)localObject1, true, com.tencent.mm.bg.a.fromDPToPix(aa.getContext(), 3));
            ((ImageView)localObject5).setImageBitmap((Bitmap)localObject1);
            localObject1 = (ImageView)((View)localObject4).findViewById(a.g.hck);
            if (i1 != 0) {
              break label2251;
            }
            ((ImageView)localObject1).setVisibility(8);
            H((View)localObject4, -2);
          }
        }
        if ((paramc.vdR != null) && (paramc.vdR.length() > 0))
        {
          localObject1 = paramc.vdR;
          if (localObject1 != null)
          {
            this.vgi.setVisibility(0);
            this.vgi.setText((CharSequence)localObject1);
          }
          this.vgq = true;
          i = paramc.veu;
          if (this.vgi != null) {
            this.vgi.setGravity(i);
          }
        }
        if ((paramc.vdS != null) && (paramc.vdS.length() > 0))
        {
          localObject1 = paramc.vdS;
          this.kM.setVisibility(0);
          this.kM.setHint((CharSequence)localObject1);
        }
        if ((paramc.vdT != null) && (paramc.vdT.length() > 0))
        {
          localObject1 = paramc.vdT;
          this.Qb.setVisibility(0);
          this.Qb.setText((CharSequence)localObject1);
        }
        if (paramc.vdU)
        {
          this.vgr = paramc.vdU;
          if (!paramc.vdU) {
            break label2291;
          }
          this.kM.setVisibility(0);
        }
        if ((paramc.vej != null) && (paramc.vej.length() > 0)) {
          a(paramc.vej, paramc.vex, paramc.veo);
        }
        if ((paramc.vek != null) && (paramc.vek.length() > 0)) {
          b(paramc.vek, true, paramc.vep);
        }
        if (paramc.FU != null) {
          setOnCancelListener(paramc.FU);
        }
        if (paramc.FV != null) {
          setOnDismissListener(paramc.FV);
        }
        if (paramc.vec != null) {
          this.vgw = paramc.vec;
        }
        setCancelable(paramc.pnV);
        this.pnV = paramc.pnV;
        if (!this.pnV) {
          super.setCancelable(paramc.vel);
        }
        if (paramc.vdZ)
        {
          localObject1 = r.eC(getContext()).inflate(a.h.hdB, null);
          this.lwR = ((Button)((View)localObject1).findViewById(a.g.cjP));
          this.rLu = ((Button)((View)localObject1).findViewById(a.g.cjZ));
          if ((paramc.vej != null) && (paramc.vej.length() > 0)) {
            a(paramc.vej, paramc.vex, paramc.veo);
          }
          if ((paramc.vek != null) && (paramc.vek.length() > 0)) {
            b(paramc.vek, true, paramc.vep);
          }
          paramc = new LinearLayout.LayoutParams(-1, -1);
          this.vgp.setVisibility(8);
          this.vgm.removeAllViews();
          this.vgm.addView((View)localObject1, paramc);
        }
        GMTrace.o(3272228208640L, 24380);
        return;
        kE(false);
        break;
        if (paramc.vez)
        {
          localObject1 = paramc.vee;
          localObject3 = paramc.veh;
          localObject2 = paramc.vei;
          localObject4 = r.eC(this.mContext).inflate(a.h.hdD, null);
          if (localObject1 != null)
          {
            localObject5 = (ImageView)((View)localObject4).findViewById(a.g.cjW);
            ((ImageView)localObject5).setVisibility(0);
            ((ImageView)localObject5).setImageBitmap((Bitmap)localObject1);
          }
          if (localObject3 != null)
          {
            localObject5 = (TextView)((View)localObject4).findViewById(a.g.hcs);
            ((TextView)localObject5).setVisibility(0);
            localObject1 = localObject3;
            if (this.vgw != null) {
              localObject1 = this.vgw.a(((CharSequence)localObject3).toString(), ((TextView)localObject5).getTextSize());
            }
            ((TextView)localObject5).setText((CharSequence)localObject1);
          }
          if (localObject2 != null)
          {
            localObject3 = (TextView)((View)localObject4).findViewById(a.g.cjX);
            ((TextView)localObject3).setVisibility(0);
            if (this.vgw == null) {
              break label2324;
            }
            localObject1 = this.vgw.a(((CharSequence)localObject2).toString(), ((TextView)localObject3).getTextSize());
            ((TextView)localObject3).setText((CharSequence)localObject1);
          }
          H((View)localObject4, -1);
        }
      }
    }
  }
  
  public final void a(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    GMTrace.i(3271154466816L, 24372);
    if (this.rLu == null)
    {
      GMTrace.o(3271154466816L, 24372);
      return;
    }
    this.rLu.setVisibility(0);
    this.rLu.setText(paramCharSequence);
    this.rLu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(3244445138944L, 24173);
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(h.this, -1);
        }
        if (paramBoolean) {
          h.this.dismiss();
        }
        GMTrace.o(3244445138944L, 24173);
      }
    });
    GMTrace.o(3271154466816L, 24372);
  }
  
  public final void b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    GMTrace.i(16765002186752L, 124909);
    b(this.mContext.getString(paramInt), true, paramOnClickListener);
    GMTrace.o(16765002186752L, 124909);
  }
  
  public final void b(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    GMTrace.i(3271691337728L, 24376);
    if (this.lwR == null)
    {
      GMTrace.o(3271691337728L, 24376);
      return;
    }
    this.lwR.setVisibility(0);
    this.lwR.setText(paramCharSequence);
    this.lwR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(3178141581312L, 23679);
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(h.this, -2);
        }
        if (paramBoolean) {
          h.this.cancel();
        }
        GMTrace.o(3178141581312L, 23679);
      }
    });
    GMTrace.o(3271691337728L, 24376);
  }
  
  public final String bRA()
  {
    GMTrace.i(3270483378176L, 24367);
    if (this.kM == null)
    {
      GMTrace.o(3270483378176L, 24367);
      return null;
    }
    String str = this.kM.getText().toString();
    GMTrace.o(3270483378176L, 24367);
    return str;
  }
  
  public final int bRB()
  {
    GMTrace.i(3270617595904L, 24368);
    if ((this.kM instanceof PasterEditText))
    {
      int i = ((PasterEditText)this.kM).bkb();
      GMTrace.o(3270617595904L, 24368);
      return i;
    }
    GMTrace.o(3270617595904L, 24368);
    return 0;
  }
  
  public void dismiss()
  {
    GMTrace.i(3272496644096L, 24382);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ae.v(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(3180691718144L, 23698);
          h.this.dismiss();
          GMTrace.o(3180691718144L, 23698);
        }
      });
      v.e("MicroMsg.MMAlertDialog", bf.bJP().toString());
      GMTrace.o(3272496644096L, 24382);
      return;
    }
    try
    {
      super.dismiss();
      GMTrace.o(3272496644096L, 24382);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + localException.getMessage());
      GMTrace.o(3272496644096L, 24382);
    }
  }
  
  public final Button getButton(int paramInt)
  {
    GMTrace.i(3272093990912L, 24379);
    switch (paramInt)
    {
    default: 
      GMTrace.o(3272093990912L, 24379);
      return null;
    case -1: 
      localButton = this.rLu;
      GMTrace.o(3272093990912L, 24379);
      return localButton;
    }
    Button localButton = this.lwR;
    GMTrace.o(3272093990912L, 24379);
    return localButton;
  }
  
  public View getContentView()
  {
    GMTrace.i(18742163537920L, 139640);
    LinearLayout localLinearLayout = this.vge;
    GMTrace.o(18742163537920L, 139640);
    return localLinearLayout;
  }
  
  public final void kF(boolean paramBoolean)
  {
    GMTrace.i(3271959773184L, 24378);
    super.setCancelable(false);
    GMTrace.o(3271959773184L, 24378);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3269812289536L, 24362);
    super.onCreate(paramBundle);
    setContentView(this.vge);
    GMTrace.o(3269812289536L, 24362);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    GMTrace.i(3271825555456L, 24377);
    super.setCancelable(paramBoolean);
    this.pnV = paramBoolean;
    setCanceledOnTouchOutside(this.pnV);
    GMTrace.o(3271825555456L, 24377);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    GMTrace.i(3270214942720L, 24365);
    this.vgl.setVisibility(0);
    this.vgf.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.vgw != null)
    {
      localObject = this.vgw;
      this.vgf.getContext();
      localObject = ((h.a.c)localObject).a(paramCharSequence.toString(), this.vgf.getTextSize());
    }
    this.vgf.setText((CharSequence)localObject);
    GMTrace.o(3270214942720L, 24365);
  }
  
  public void setTitle(int paramInt)
  {
    GMTrace.i(3270080724992L, 24364);
    this.joI.setVisibility(0);
    this.ljS.setVisibility(0);
    this.ljS.setMaxLines(2);
    this.ljS.setText(paramInt);
    zN(a.d.hbk);
    GMTrace.o(3270080724992L, 24364);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    GMTrace.i(3269946507264L, 24363);
    this.joI.setVisibility(0);
    this.ljS.setVisibility(0);
    CharSequence localCharSequence = paramCharSequence;
    if (this.vgw != null) {
      localCharSequence = this.vgw.a(paramCharSequence.toString(), this.ljS.getTextSize());
    }
    this.ljS.setMaxLines(2);
    this.ljS.setText(localCharSequence);
    zN(a.d.hbk);
    GMTrace.o(3269946507264L, 24363);
  }
  
  public void show()
  {
    GMTrace.i(3272362426368L, 24381);
    try
    {
      super.show();
      GMTrace.o(3272362426368L, 24381);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      GMTrace.o(3272362426368L, 24381);
    }
  }
  
  public final void zP(int paramInt)
  {
    GMTrace.i(3271288684544L, 24373);
    this.rLu.setTextColor(paramInt);
    GMTrace.o(3271288684544L, 24373);
  }
  
  public final void zQ(int paramInt)
  {
    GMTrace.i(3271422902272L, 24374);
    this.lwR.setTextColor(paramInt);
    GMTrace.o(3271422902272L, 24374);
  }
  
  public static class a
  {
    private Context mContext;
    public c vgH;
    
    public a(Context paramContext)
    {
      GMTrace.i(3361214562304L, 25043);
      this.mContext = paramContext;
      this.vgH = new c();
      GMTrace.o(3361214562304L, 25043);
    }
    
    public final a M(CharSequence paramCharSequence)
    {
      GMTrace.i(16173907312640L, 120505);
      this.vgH.title = paramCharSequence;
      GMTrace.o(16173907312640L, 120505);
      return this;
    }
    
    public final a N(CharSequence paramCharSequence)
    {
      GMTrace.i(3361885650944L, 25048);
      this.vgH.veh = paramCharSequence;
      GMTrace.o(3361885650944L, 25048);
      return this;
    }
    
    public final a SV(String paramString)
    {
      GMTrace.i(3361348780032L, 25044);
      this.vgH.title = paramString;
      GMTrace.o(3361348780032L, 25044);
      return this;
    }
    
    public final a SW(String paramString)
    {
      GMTrace.i(3361617215488L, 25046);
      this.vgH.veg = paramString;
      GMTrace.o(3361617215488L, 25046);
      return this;
    }
    
    public final a SX(String paramString)
    {
      GMTrace.i(3362556739584L, 25053);
      this.vgH.vdS = paramString;
      GMTrace.o(3362556739584L, 25053);
      return this;
    }
    
    public final a SY(String paramString)
    {
      GMTrace.i(3362825175040L, 25055);
      this.vgH.vej = paramString;
      GMTrace.o(3362825175040L, 25055);
      return this;
    }
    
    public final a SZ(String paramString)
    {
      GMTrace.i(3363362045952L, 25059);
      this.vgH.vek = paramString;
      GMTrace.o(3363362045952L, 25059);
      return this;
    }
    
    public h WD()
    {
      GMTrace.i(3364301570048L, 25066);
      h localh = new h(this.mContext);
      localh.a(this.vgH);
      GMTrace.o(3364301570048L, 25066);
      return localh;
    }
    
    public final a a(DialogInterface.OnClickListener paramOnClickListener)
    {
      GMTrace.i(3363093610496L, 25057);
      this.vgH.veo = paramOnClickListener;
      GMTrace.o(3363093610496L, 25057);
      return this;
    }
    
    public final a a(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      GMTrace.i(3363898916864L, 25063);
      this.vgH.FV = paramOnDismissListener;
      GMTrace.o(3363898916864L, 25063);
      return this;
    }
    
    public final a a(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      GMTrace.i(3362288304128L, 25051);
      this.vgH.vef = paramBitmap;
      this.vgH.ven = paramBoolean;
      this.vgH.vev = paramInt;
      GMTrace.o(3362288304128L, 25051);
      return this;
    }
    
    public final a a(String paramString, CharSequence paramCharSequence, Boolean paramBoolean, b paramb)
    {
      GMTrace.i(3362154086400L, 25050);
      this.vgH.vdV = paramString;
      this.vgH.vdX = paramCharSequence;
      this.vgH.vdY = paramBoolean.booleanValue();
      this.vgH.vea = paramb;
      GMTrace.o(3362154086400L, 25050);
      return this;
    }
    
    public final a a(boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
    {
      GMTrace.i(3363227828224L, 25058);
      this.vgH.veo = paramOnClickListener;
      this.vgH.vex = paramBoolean;
      GMTrace.o(3363227828224L, 25058);
      return this;
    }
    
    public final a b(DialogInterface.OnClickListener paramOnClickListener)
    {
      GMTrace.i(3363630481408L, 25061);
      this.vgH.vep = paramOnClickListener;
      GMTrace.o(3363630481408L, 25061);
      return this;
    }
    
    public final a bRC()
    {
      GMTrace.i(3364435787776L, 25067);
      this.vgH.vdZ = true;
      GMTrace.o(3364435787776L, 25067);
      return this;
    }
    
    public final a d(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      GMTrace.i(3363764699136L, 25062);
      this.vgH.FU = paramOnCancelListener;
      GMTrace.o(3363764699136L, 25062);
      return this;
    }
    
    public final a db(View paramView)
    {
      GMTrace.i(3362690957312L, 25054);
      this.vgH.sbS = paramView;
      GMTrace.o(3362690957312L, 25054);
      return this;
    }
    
    public final a kG(boolean paramBoolean)
    {
      GMTrace.i(3362019868672L, 25049);
      this.vgH.vem = paramBoolean;
      GMTrace.o(3362019868672L, 25049);
      return this;
    }
    
    public final a kH(boolean paramBoolean)
    {
      GMTrace.i(3364033134592L, 25064);
      this.vgH.pnV = paramBoolean;
      GMTrace.o(3364033134592L, 25064);
      return this;
    }
    
    public final a kI(boolean paramBoolean)
    {
      GMTrace.i(3364167352320L, 25065);
      this.vgH.vel = paramBoolean;
      GMTrace.o(3364167352320L, 25065);
      return this;
    }
    
    public final a zR(int paramInt)
    {
      GMTrace.i(3361482997760L, 25045);
      this.vgH.title = this.mContext.getString(paramInt);
      GMTrace.o(3361482997760L, 25045);
      return this;
    }
    
    public final a zS(int paramInt)
    {
      GMTrace.i(3361751433216L, 25047);
      this.vgH.veg = this.mContext.getString(paramInt);
      GMTrace.o(3361751433216L, 25047);
      return this;
    }
    
    public final a zT(int paramInt)
    {
      GMTrace.i(3362422521856L, 25052);
      this.vgH.veu = paramInt;
      GMTrace.o(3362422521856L, 25052);
      return this;
    }
    
    public final a zU(int paramInt)
    {
      GMTrace.i(3362959392768L, 25056);
      this.vgH.vej = this.mContext.getString(paramInt);
      GMTrace.o(3362959392768L, 25056);
      return this;
    }
    
    public final a zV(int paramInt)
    {
      GMTrace.i(3363496263680L, 25060);
      this.vgH.vek = this.mContext.getString(paramInt);
      GMTrace.o(3363496263680L, 25060);
      return this;
    }
    
    public static abstract interface a
    {
      public abstract void auB();
    }
    
    public static abstract interface b
    {
      public abstract void bEL();
    }
    
    public static abstract interface c
    {
      public abstract CharSequence a(CharSequence paramCharSequence, float paramFloat);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */