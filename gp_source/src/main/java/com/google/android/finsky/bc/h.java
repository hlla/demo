package com.google.android.finsky.bc;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.ac;
import android.support.v4.widget.av;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BulletSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.caverock.androidsvg.SVGParseException;
import com.caverock.androidsvg.au;
import com.caverock.androidsvg.bg;
import com.caverock.androidsvg.cv;
import com.caverock.androidsvg.r;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.w;
import com.google.android.finsky.bw.am;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.ds.a.bv;
import com.google.android.finsky.frameworkviews.FlowLayout;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.play.image.FifeImageView;
import com.google.android.play.image.x;
import com.google.common.a.be;
import com.google.wireless.android.finsky.dfe.e.a.bw;
import com.google.wireless.android.finsky.dfe.e.a.bx;
import com.google.wireless.android.finsky.dfe.e.a.by;
import com.google.wireless.android.finsky.dfe.e.a.cc;
import com.google.wireless.android.finsky.dfe.e.a.cd;
import com.google.wireless.android.finsky.dfe.e.a.cx;
import com.google.wireless.android.finsky.dfe.e.a.dc;
import com.google.wireless.android.finsky.dfe.e.a.dd;
import com.google.wireless.android.finsky.dfe.e.a.df;
import com.google.wireless.android.finsky.dfe.e.a.dg;
import com.google.wireless.android.finsky.dfe.e.a.ee;
import com.google.wireless.android.finsky.dfe.e.a.ef;
import com.google.wireless.android.finsky.dfe.e.a.eh;
import com.google.wireless.android.finsky.dfe.e.a.en;
import com.google.wireless.android.finsky.dfe.e.a.fq;
import com.google.wireless.android.finsky.dfe.e.a.fr;
import com.google.wireless.android.finsky.dfe.e.a.fs;
import com.google.wireless.android.finsky.dfe.e.a.ft;
import com.google.wireless.android.finsky.dfe.e.a.fu;
import com.google.wireless.android.finsky.dfe.e.a.fv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class h
{
  private static final Typeface a = Typeface.create("sans-serif-black", 0);
  private static final Typeface b = Typeface.create("sans-serif-condensed", 0);
  private static final Typeface c;
  private static final Typeface d;
  private static final Typeface e = Typeface.create("sans-serif-thin", 0);
  private final x f;
  private final com.google.android.finsky.bw.l g;
  private final s h;
  private final Handler i;
  
  static
  {
    c = Typeface.create("sans-serif-light", 0);
    d = Typeface.create("sans-serif-medium", 0);
  }
  
  h(x paramx, com.google.android.finsky.bw.l paraml, s params)
  {
    this.f = paramx;
    this.g = paraml;
    this.h = params;
    this.i = new Handler();
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return paramInt2;
    case 6: 
      return 5;
    case 5: 
      return 4;
    case 4: 
      return 3;
    case 3: 
      return 2;
    case 2: 
      return 1;
    }
    return 0;
  }
  
  private static int a(View paramView, float paramFloat, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return (int)TypedValue.applyDimension(a(paramInt, 1), paramFloat, paramView.getResources().getDisplayMetrics());
    case 8: 
      return -1;
    }
    return -2;
  }
  
  private static int a(View paramView, eh parameh)
  {
    if (parameh != null) {
      return a(paramView, parameh.b, parameh.a);
    }
    return 0;
  }
  
  public static PorterDuff.Mode a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return PorterDuff.Mode.SRC_ATOP;
    case 18: 
      return PorterDuff.Mode.XOR;
    case 17: 
      return PorterDuff.Mode.SRC_OVER;
    case 16: 
      return PorterDuff.Mode.SRC_OUT;
    case 15: 
      return PorterDuff.Mode.SRC_IN;
    case 14: 
      return PorterDuff.Mode.SRC_ATOP;
    case 13: 
      return PorterDuff.Mode.SRC;
    case 12: 
      return PorterDuff.Mode.SCREEN;
    case 11: 
      return PorterDuff.Mode.OVERLAY;
    case 10: 
      return PorterDuff.Mode.MULTIPLY;
    case 9: 
      return PorterDuff.Mode.LIGHTEN;
    case 8: 
      return PorterDuff.Mode.DST_OVER;
    case 7: 
      return PorterDuff.Mode.DST_OUT;
    case 6: 
      return PorterDuff.Mode.DST_IN;
    case 5: 
      return PorterDuff.Mode.DST_ATOP;
    case 4: 
      return PorterDuff.Mode.DST;
    case 3: 
      return PorterDuff.Mode.DARKEN;
    case 2: 
      return PorterDuff.Mode.CLEAR;
    }
    return PorterDuff.Mode.ADD;
  }
  
  public static Drawable a(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    paramDrawable = android.support.v4.a.a.a.f(paramDrawable);
    if (paramMode != null) {
      android.support.v4.a.a.a.a(paramDrawable.mutate(), paramMode);
    }
    android.support.v4.a.a.a.a(paramDrawable.mutate(), paramInt);
    return paramDrawable;
  }
  
  public static Drawable a(View paramView, by paramby)
  {
    if ((paramby != null) && (Build.VERSION.SDK_INT >= 23)) {}
    switch (paramby.b)
    {
    default: 
      return null;
    case 2: 
      return a(paramView, paramby, com.google.android.finsky.bs.a.e.intValue());
    }
    return a(paramView, paramby, 2131231400);
  }
  
  @TargetApi(23)
  private static Drawable a(View paramView, by paramby, int paramInt)
  {
    paramView = paramView.getResources().getDrawable(paramInt);
    double d1 = paramby.a;
    if ((d1 != 1.0D) && ((paramView instanceof AnimatedVectorDrawable))) {
      ((AnimatedVectorDrawable)paramView).registerAnimationCallback(new o(d1));
    }
    return paramView;
  }
  
  private static cv a(Context paramContext, fu paramfu)
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = localObject5;
    if (paramfu != null) {}
    for (;;)
    {
      try
      {
        j = paramfu.b;
        if (j != 0) {
          continue;
        }
        if (j != 0) {
          continue;
        }
        j = paramfu.e;
      }
      catch (SVGParseException localSVGParseException)
      {
        int j;
        Object localObject1;
        float f4;
        float f1;
        float f2;
        float f3;
        FinskyLog.e("Malformed svg source", new Object[0]);
        Object localObject2 = null;
        continue;
        switch (j)
        {
        case 55: 
        case 64: 
        case 63: 
        case 62: 
        case 61: 
        case 60: 
        case 59: 
        case 58: 
        case 57: 
        case 29: 
        case 47: 
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 56: 
        default: 
          j = 0;
          break;
        case 54: 
          j = 2131886135;
          break;
        case 53: 
          j = 2131886222;
          break;
        case 52: 
          j = 2131886128;
          break;
        case 46: 
          j = 2131886097;
          break;
        case 45: 
          j = 2131886138;
          break;
        case 44: 
          j = 2131886184;
          break;
        case 43: 
          j = 2131886131;
          break;
        case 42: 
          j = 2131886130;
          break;
        case 41: 
          j = 2131886212;
          break;
        case 40: 
          j = 2131886172;
          break;
        case 39: 
          j = 2131886163;
          break;
        case 38: 
          j = 2131886161;
          break;
        case 37: 
          j = 2131886159;
          break;
        case 36: 
          j = 2131886144;
          break;
        case 35: 
          j = 2131886115;
          break;
        case 34: 
          j = 2131886112;
          break;
        case 33: 
          j = 2131886111;
          break;
        case 32: 
          j = 2131886100;
          break;
        case 31: 
          j = 2131886089;
          break;
        case 30: 
          j = 2131886124;
          break;
        case 28: 
          j = 2131886214;
          break;
        case 27: 
          j = 2131886142;
          break;
        case 26: 
          j = 2131886102;
          break;
        case 25: 
          j = 2131886118;
          break;
        case 24: 
          j = 2131886127;
          break;
        case 23: 
          j = 2131886107;
          break;
        case 22: 
          j = 2131886095;
          break;
        case 21: 
          j = 2131886094;
          break;
        case 20: 
          j = 2131886134;
          break;
        case 19: 
          j = 2131886158;
          break;
        case 18: 
          j = 2131886211;
          break;
        case 17: 
          j = 2131886201;
          break;
        case 16: 
          j = 2131886197;
          break;
        case 15: 
          j = 2131886196;
          break;
        case 14: 
          j = 2131886191;
          break;
        case 13: 
          j = 2131886227;
          break;
        case 12: 
          j = 2131886189;
          break;
        case 11: 
          j = 2131886188;
          break;
        case 10: 
          j = 2131886187;
          break;
        case 9: 
          j = 2131886185;
          break;
        case 8: 
          j = 2131886181;
          break;
        case 7: 
          j = 2131886098;
          break;
        case 6: 
          j = 2131886121;
          break;
        case 5: 
          j = 2131886120;
          break;
        case 4: 
          j = 2131886110;
          break;
        case 3: 
          j = 2131886105;
          break;
        case 2: 
          j = 2131886104;
          break;
        case 1: 
          j = 2131886101;
          continue;
          j = 0;
          continue;
          if (j == 1) {
            continue;
          }
          localObject2 = null;
          continue;
        }
      }
      if (j != 0)
      {
        localObject1 = r.a(paramContext, j);
        localObject3 = localObject5;
        if (localObject1 != null)
        {
          localObject3 = paramfu.c;
          paramfu = (fu)localObject4;
          if (localObject3 != null)
          {
            paramfu = new au();
            if ((((ft)localObject3).a & 0x1) != 0) {
              paramfu.b(((ft)localObject3).b);
            }
            if ((((ft)localObject3).a & 0x2) != 0) {
              paramfu.a(((ft)localObject3).d);
            }
            if ((((ft)localObject3).a & 0x4) != 0) {
              ((r)localObject1).b(((ft)localObject3).i);
            }
            if ((((ft)localObject3).a & 0x8) != 0) {
              ((r)localObject1).c(((ft)localObject3).c);
            }
            j = ((ft)localObject3).a;
            if ((j & 0x10) != 0)
            {
              f4 = ((ft)localObject3).f;
              f1 = ((ft)localObject3).g;
              f2 = ((ft)localObject3).h;
              f3 = ((ft)localObject3).e;
              localObject3 = ((r)localObject1).e;
              if (localObject3 == null) {
                throw new IllegalArgumentException("SVG document is empty");
              }
              ((bg)localObject3).s = new com.caverock.androidsvg.t(f4, f1, f2, f3);
            }
          }
          else
          {
            ((r)localObject1).a(r.a(paramContext.getResources()));
            localObject3 = new cv((r)localObject1, paramfu);
          }
        }
        else
        {
          return (cv)localObject3;
        }
        if (((j & 0x20) != 0) || ((j & 0x40) != 0) || ((j & 0x80) != 0)) {
          continue;
        }
        continue;
      }
      localObject1 = null;
      continue;
      j = 2131886136;
      continue;
      j = 2131886210;
      continue;
      j = 2131886122;
      continue;
      j = 2131886137;
    }
    throw new NullPointerException();
    throw new NullPointerException();
    throw new NullPointerException();
    throw new NullPointerException();
    throw new NullPointerException();
    throw new NullPointerException();
    if (j == 1) {}
    for (localObject1 = paramfu.d;; localObject1 = "")
    {
      localObject1 = r.a((String)localObject1);
      break;
    }
  }
  
  public static void a(TextView paramTextView, View paramView, int paramInt1, String paramString1, int paramInt2, String paramString2, com.google.android.finsky.be.y paramy)
  {
    paramTextView = new p(paramTextView, paramInt2, paramInt1);
    if (!TextUtils.isEmpty(paramString1))
    {
      a(paramTextView, false);
      paramy.a(paramString1, false);
      paramy.a(paramString1, new q(paramTextView));
    }
    if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2))) {
      paramView.setOnClickListener(new m(paramy, paramString1, paramString2));
    }
  }
  
  static void a(p paramp, boolean paramBoolean)
  {
    TextView localTextView = paramp.c;
    Resources localResources = localTextView.getResources();
    if (paramBoolean) {}
    for (paramp = localResources.getDrawable(paramp.b);; paramp = localResources.getDrawable(paramp.a))
    {
      av.b(localTextView, null, null, a(paramp, localTextView.getCurrentTextColor(), null), null);
      return;
    }
  }
  
  public static void a(cx paramcx, FlowLayout paramFlowLayout)
  {
    if (paramcx != null)
    {
      paramFlowLayout.setVerticalGap(a(paramFlowLayout, paramcx.b, 2));
      paramFlowLayout.setHorizontalGap(a(paramFlowLayout, paramcx.a, 2));
    }
  }
  
  private final void a(ef paramef, TextView paramTextView)
  {
    int k;
    if (paramef != null)
    {
      if ((paramef.b & 0x1) != 0) {
        paramTextView.setTextSize(a(paramef.t, 2), paramef.s);
      }
      j = paramef.b;
      if ((j & 0x4) != 0)
      {
        k = paramef.d;
        if ((j & 0x8) == 0) {
          break label1120;
        }
      }
    }
    label1063:
    label1120:
    for (int j = paramef.f;; j = paramTextView.getResources().getColor(2131100048))
    {
      paramTextView.setTextColor(com.google.android.finsky.bw.g.a(k, j));
      Object localObject = c(0);
      if ((paramef.b & 0x10) != 0) {
        localObject = c(paramef.n);
      }
      if ((paramef.b & 0x20) != 0) {
        paramTextView.setTypeface((Typeface)localObject, b(paramef.u));
      }
      for (;;)
      {
        if ((paramef.b & 0x40) != 0) {
          switch (paramef.l)
          {
          default: 
            paramTextView.setEllipsize(null);
          }
        }
        for (;;)
        {
          if ((paramef.b & 0x80) != 0)
          {
            j = paramef.r;
            if (j != 1) {
              break label1063;
            }
            paramTextView.setSingleLine();
          }
          for (;;)
          {
            if ((paramef.b & 0x100) != 0) {
              paramTextView.setAllCaps(paramef.a);
            }
            if ((paramef.b & 0x200) == 0) {}
            for (;;)
            {
              if ((paramef.b & 0x400) != 0) {
                paramTextView.setLineSpacing(0.0F, paramef.q);
              }
              localObject = paramef.o;
              int m = localObject.length;
              if (m <= 0) {}
              for (;;)
              {
                localObject = paramef.j;
                s locals;
                bu localbu1;
                bu[] arrayOfbu;
                if ((localObject != null) || (paramef.k != null) || (paramef.h != null) || (paramef.g != null))
                {
                  locals = this.h;
                  localbu1 = paramef.k;
                  bu localbu2 = paramef.h;
                  bu localbu3 = paramef.g;
                  arrayOfbu = new bu[4];
                  arrayOfbu[0] = localObject;
                  arrayOfbu[1] = localbu1;
                  arrayOfbu[2] = localbu2;
                  arrayOfbu[3] = localbu3;
                  localObject = (com.google.android.play.image.y[])paramTextView.getTag(2131428144);
                  if (localObject == null)
                  {
                    localObject = new com.google.android.play.image.y[4];
                    paramTextView.setTag(2131428144, localObject);
                    m = 0;
                    if (m < 4) {}
                  }
                }
                for (;;)
                {
                  if ((paramef.b & 0x800) != 0) {
                    paramTextView.setCompoundDrawablePadding(a(paramTextView, paramef.i, 2));
                  }
                  localObject = paramef.m;
                  m = localObject.length;
                  if (m <= 0) {}
                  for (;;)
                  {
                    if (paramef.e.length > 0)
                    {
                      k = paramTextView.getPaintFlags();
                      localObject = paramef.e;
                      m = localObject.length;
                      j = 0;
                      while (j < m)
                      {
                        k &= (e(localObject[j]) ^ 0xFFFFFFFF);
                        j += 1;
                      }
                      paramTextView.setPaintFlags(k);
                    }
                    if ((paramef.b & 0x1000) == 0) {}
                    for (;;)
                    {
                      if (((paramef.b & 0x2000) != 0) && (Build.VERSION.SDK_INT >= 17)) {
                        switch (paramef.z)
                        {
                        default: 
                          j = 0;
                        }
                      }
                      for (;;)
                      {
                        paramTextView.setTextAlignment(j);
                        return;
                        j = 1;
                        continue;
                        j = 6;
                        continue;
                        j = 5;
                        continue;
                        j = 3;
                        continue;
                        j = 2;
                        continue;
                        j = 4;
                      }
                      if (Build.VERSION.SDK_INT >= 23) {
                        switch (paramef.c)
                        {
                        default: 
                          paramTextView.setBreakStrategy(0);
                          break;
                        case 2: 
                          paramTextView.setBreakStrategy(2);
                          break;
                        case 1: 
                          paramTextView.setBreakStrategy(1);
                        }
                      }
                    }
                    k = 0;
                    j = 0;
                    while (j < m)
                    {
                      k |= e(localObject[j]);
                      j += 1;
                    }
                    paramTextView.setPaintFlags(k);
                  }
                  localbu1 = arrayOfbu[m];
                  if (localbu1 == null)
                  {
                    j = 0;
                    k = 0;
                  }
                  for (;;)
                  {
                    localbu1 = localObject[m];
                    if ((localbu1 != null) && (localbu1.c() != null)) {
                      if ((arrayOfbu[m] == null) || (!localbu1.c().equals(arrayOfbu[m].g)) || (localbu1.d() != j) || (localbu1.e() != k)) {}
                    }
                    for (;;)
                    {
                      m += 1;
                      break;
                      localbu1.a();
                      localbu1 = arrayOfbu[m];
                      if (localbu1 != null)
                      {
                        localObject[m] = locals.a.a(localbu1.g, j, k, true, new t(paramTextView, m), false);
                        s.a(paramTextView, m, localObject[m].b());
                      }
                      else
                      {
                        s.a(paramTextView, m, null);
                      }
                    }
                    if (localbu1.h)
                    {
                      j = s.a(localbu1.d.b, paramTextView);
                      k = s.a(arrayOfbu[m].d.a, paramTextView);
                    }
                    else
                    {
                      j = 0;
                      k = 0;
                    }
                  }
                  break;
                  if ((paramef.x != null) || (paramef.y != null) || (paramef.w != null) || (paramef.v != null))
                  {
                    localObject = paramTextView.getContext();
                    av.b(paramTextView, a((Context)localObject, paramef.x), a((Context)localObject, paramef.y), a((Context)localObject, paramef.w), a((Context)localObject, paramef.v));
                  }
                }
                k = 0;
                j = 0;
                while (j < m)
                {
                  k |= d(localObject[j]);
                  j += 1;
                }
                paramTextView.setGravity(k);
              }
              if (Build.VERSION.SDK_INT >= 21) {
                paramTextView.setLetterSpacing(paramef.p);
              }
            }
            paramTextView.setMaxLines(j);
          }
          paramTextView.setEllipsize(TruncateAt.MARQUEE);
          continue;
          paramTextView.setEllipsize(TruncateAt.END);
          continue;
          paramTextView.setEllipsize(TruncateAt.MIDDLE);
          continue;
          paramTextView.setEllipsize(TruncateAt.START);
        }
        paramTextView.setTypeface((Typeface)localObject);
      }
    }
  }
  
  private static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 3: 
      return 3;
    case 2: 
      return 2;
    }
    return 1;
  }
  
  private static Typeface c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Typeface.DEFAULT;
    case 9: 
      return b;
    case 8: 
      return a;
    case 7: 
      return d;
    case 6: 
      return c;
    case 5: 
      return e;
    case 4: 
      return Typeface.SERIF;
    case 3: 
      return Typeface.SANS_SERIF;
    case 2: 
      return Typeface.MONOSPACE;
    }
    return Typeface.DEFAULT_BOLD;
  }
  
  private static int d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 14: 
      return 48;
    case 13: 
      return 8388611;
    case 12: 
      return 5;
    case 11: 
      return 3;
    case 10: 
      return 112;
    case 9: 
      return 7;
    case 8: 
      return 119;
    case 7: 
      return 8388613;
    case 6: 
      return 128;
    case 5: 
      return 8;
    case 4: 
      return 16;
    case 3: 
      return 1;
    case 2: 
      return 17;
    }
    return 80;
  }
  
  @TargetApi(19)
  private static int e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 10: 
      return 1024;
    case 9: 
      return 256;
    case 8: 
      return 128;
    case 7: 
      return 64;
    case 6: 
      return 32;
    case 5: 
      return 16;
    case 4: 
      return 8;
    case 3: 
      return 4;
    case 2: 
      return 2;
    }
    return 1;
  }
  
  public final void a(cc paramcc, Button paramButton, d paramd)
  {
    if (paramcc != null)
    {
      if ((paramcc.a & 0x1) != 0) {
        paramButton.setText(paramcc.d);
      }
      bx localbx = paramcc.c;
      if (localbx != null) {
        paramButton.setOnClickListener(new i(paramd, localbx));
      }
      a(paramcc.f, paramButton, paramd);
      a(paramcc.e, paramButton);
      paramd = paramcc.b;
      if ((paramd != null) && ((paramd.a & 0x1) != 0)) {
        break label98;
      }
      if ((paramcc.a & 0x1) != 0) {
        paramButton.setVisibility(0);
      }
    }
    return;
    label98:
    int j;
    switch (paramd.b)
    {
    default: 
      j = 2131231245;
    }
    for (;;)
    {
      paramButton.setBackgroundResource(j);
      break;
      j = 2131231224;
      continue;
      j = 2131231219;
      continue;
      j = 2131231242;
      continue;
      j = 2131231248;
      continue;
      j = 2131231236;
      continue;
      j = 2131231254;
      continue;
      j = 2131231227;
      continue;
      j = 2131231216;
      continue;
      j = 2131231221;
      continue;
      j = 2131231251;
      continue;
      j = 2131231239;
      continue;
      j = 2131231257;
      continue;
      j = 2131231230;
    }
  }
  
  public final void a(dc paramdc, ImageView paramImageView, d paramd)
  {
    a(paramdc, paramImageView, paramd, null);
  }
  
  public final void a(dc paramdc, ImageView paramImageView, d paramd, g paramg)
  {
    Object localObject2;
    Object localObject1;
    if (paramdc != null)
    {
      localObject2 = a(paramImageView, paramdc.a);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a(paramImageView.getContext(), paramdc.f);
      }
      if (localObject1 != null) {
        break label226;
      }
      if (!(paramImageView instanceof FifeImageView)) {
        break label175;
      }
      this.g.a((FifeImageView)paramImageView, paramdc.d, -1);
    }
    for (;;)
    {
      if ((paramdc.b & 0x1) != 0) {
        paramImageView.setContentDescription(paramdc.c);
      }
      a(paramdc.g, paramImageView, paramd, paramg);
      paramdc = paramdc.e;
      if (paramdc == null) {}
      for (;;)
      {
        paramImageView.setVisibility(0);
        if ((localObject1 instanceof Animatable)) {
          ((Animatable)localObject1).start();
        }
        return;
        int j = paramdc.a;
        if ((j & 0x1) != 0) {
          if ((j & 0x2) != 0) {
            paramImageView.setColorFilter(paramdc.b, a(paramdc.c));
          } else {
            paramImageView.setColorFilter(paramdc.b);
          }
        }
      }
      label175:
      localObject2 = paramdc.d.g;
      localObject2 = this.f.b((String)localObject2, 0, 0, new n(paramImageView)).b();
      if (localObject2 != null)
      {
        paramImageView.setImageBitmap((Bitmap)localObject2);
        continue;
        label226:
        paramImageView.setImageDrawable((Drawable)localObject1);
      }
    }
  }
  
  public final void a(df paramdf, EditText paramEditText, d paramd)
  {
    if (paramdf != null) {
      if (TextUtils.isEmpty(paramEditText.getText())) {
        break label749;
      }
    }
    for (;;)
    {
      paramEditText.setHint(paramdf.c);
      dg localdg = paramdf.d;
      if (localdg != null) {
        if (localdg.b.length > 0) {
          break label321;
        }
      }
      int k;
      int m;
      int[] arrayOfInt;
      int j;
      for (;;)
      {
        if (localdg.a.length > 0)
        {
          k = 0;
          m = 0;
          arrayOfInt = localdg.a;
          if (k >= arrayOfInt.length) {
            paramEditText.setImeOptions(m);
          }
        }
        else
        {
          a(paramdf.h, paramEditText, paramd);
          a(paramdf.g, paramEditText);
          paramEditText.setVisibility(0);
          return;
        }
        switch (arrayOfInt[k])
        {
        default: 
          j = 0;
        }
        for (;;)
        {
          m |= j;
          k += 1;
          break;
          j = Integer.MIN_VALUE;
          continue;
          j = 255;
          continue;
          j = 33554432;
          continue;
          j = 268435456;
          continue;
          j = 1073741824;
          continue;
          j = 536870912;
          continue;
          j = 67108864;
          continue;
          j = 134217728;
          continue;
          j = 6;
          continue;
          j = 0;
          continue;
          j = 4;
          continue;
          j = 3;
          continue;
          j = 7;
          continue;
          j = 1;
          continue;
          j = 5;
          continue;
          j = 2;
        }
        label321:
        k = 0;
        m = 0;
        arrayOfInt = localdg.b;
        if (k < arrayOfInt.length) {
          break;
        }
        paramEditText.setInputType(m);
      }
      switch (arrayOfInt[k])
      {
      case 9: 
      default: 
        j = 1;
      }
      for (;;)
      {
        m |= j;
        k += 1;
        break;
        j = 8194;
        continue;
        j = 36;
        continue;
        j = 225;
        continue;
        j = 209;
        continue;
        j = 161;
        continue;
        j = 145;
        continue;
        j = 17;
        continue;
        j = 65;
        continue;
        j = 113;
        continue;
        j = 193;
        continue;
        j = 97;
        continue;
        j = 129;
        continue;
        j = 524288;
        continue;
        j = 131072;
        continue;
        j = 81;
        continue;
        j = 262144;
        continue;
        j = 177;
        continue;
        j = 49;
        continue;
        j = 33;
        continue;
        j = 8192;
        continue;
        j = 16384;
        continue;
        j = 4096;
        continue;
        j = 32768;
        continue;
        j = 65536;
        continue;
        j = 3;
        continue;
        j = 4098;
        continue;
        j = 18;
        continue;
        j = 20;
        continue;
        j = 2;
        continue;
        j = 0;
        continue;
        j = 4;
      }
      label749:
      if (!TextUtils.isEmpty(paramdf.b)) {
        paramEditText.setText(paramdf.b);
      }
    }
  }
  
  public final void a(ee paramee, TextView paramTextView, d paramd, w paramw)
  {
    Object localObject = null;
    if (paramee != null) {
      if (paramee.h.length > 0) {
        break label25;
      }
    }
    for (;;)
    {
      a(paramee, paramTextView, paramd, (be)localObject);
      return;
      label25:
      if (paramw != null)
      {
        localObject = new ArrayList();
        String[] arrayOfString = paramee.h;
        int k = arrayOfString.length;
        int j = 0;
        while (j < k)
        {
          String str = arrayOfString[j];
          if (!paramw.c(str))
          {
            paramTextView.setVisibility(8);
            return;
          }
          ((List)localObject).add(paramw.b(str));
          j += 1;
        }
        localObject = be.a((Collection)localObject);
      }
    }
  }
  
  public final void a(ee paramee, TextView paramTextView, d paramd, be parambe)
  {
    Object localObject1;
    if (paramee != null) {
      if ((paramee.a & 0x1) != 0)
      {
        Object localObject2 = paramee.e;
        localObject1 = localObject2;
        if (parambe != null)
        {
          localObject1 = localObject2;
          if (!parambe.isEmpty()) {
            localObject1 = String.format((String)localObject2, parambe.toArray());
          }
        }
        if (paramee.f.length > 0)
        {
          localObject2 = new SpannableString((CharSequence)localObject1);
          fr[] arrayOffr = paramee.f;
          int m = arrayOffr.length;
          int k = 0;
          if (k < m)
          {
            fr localfr = arrayOffr[k];
            int j = localfr.e;
            if (j == 0) {
              if (j == 0)
              {
                parambe = localfr.a;
                label123:
                parambe = new BulletSpan(a(paramTextView, parambe.a));
              }
            }
            for (;;)
            {
              int n;
              int i1;
              if (parambe != null)
              {
                n = localfr.f;
                i1 = localfr.c;
                switch (localfr.d)
                {
                default: 
                  j = 33;
                }
              }
              for (;;)
              {
                ((SpannableString)localObject2).setSpan(parambe, n, i1, j);
                paramTextView.setText((CharSequence)localObject2);
                k += 1;
                break;
                j = 17;
                continue;
                j = 18;
                continue;
                j = 34;
              }
              parambe = null;
              break label123;
              if (j == 2)
              {
                if (localfr.e().b == 0)
                {
                  parambe = localfr.e();
                  if (parambe.b == 0) {}
                  for (parambe = parambe.a;; parambe = null)
                  {
                    parambe = new AbsoluteSizeSpan(a(paramTextView, parambe));
                    break;
                  }
                }
                if (localfr.e().b == 1)
                {
                  parambe = localfr.e();
                  if (parambe.b == 1) {}
                  for (float f1 = parambe.c;; f1 = 0.0F)
                  {
                    parambe = new RelativeSizeSpan(f1);
                    break;
                  }
                }
                parambe = null;
              }
              else
              {
                if (j == 3)
                {
                  if (j == 3) {}
                  for (parambe = localfr.g;; parambe = null)
                  {
                    parambe = new StyleSpan(b(parambe.a));
                    break;
                  }
                }
                if (j == 1)
                {
                  if (j == 1) {}
                  for (parambe = localfr.b;; parambe = null) {
                    switch (parambe.a)
                    {
                    default: 
                      parambe = null;
                      break;
                    case 1: 
                      parambe = new StrikethroughSpan();
                      break;
                    case 4: 
                      parambe = new UnderlineSpan();
                      if (paramee.e())
                      {
                        paramTextView.setLinkTextColor(paramee.d);
                        break;
                      }
                      break;
                    case 3: 
                      parambe = new SuperscriptSpan();
                      break;
                    case 2: 
                      parambe = new SubscriptSpan();
                      break;
                    }
                  }
                }
                else
                {
                  if (j == 4)
                  {
                    if (j == 4) {}
                    for (parambe = localfr.h;; parambe = null)
                    {
                      localObject1 = new URLSpan(parambe.a);
                      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
                      parambe = (be)localObject1;
                      if (!paramee.e()) {
                        break;
                      }
                      paramTextView.setLinkTextColor(paramee.d);
                      parambe = (be)localObject1;
                      break;
                    }
                  }
                  parambe = null;
                }
              }
            }
          }
        }
        else
        {
          if (!paramee.c) {
            break label704;
          }
          if (!paramee.b) {
            break label695;
          }
          paramTextView.setText(Html.fromHtml((String)localObject1));
          if (paramee.e()) {
            paramTextView.setLinkTextColor(paramee.d);
          }
        }
      }
    }
    for (;;)
    {
      a(paramee.i, paramTextView, paramd);
      a(paramee.g, paramTextView);
      paramTextView.setVisibility(0);
      return;
      label695:
      am.a(paramTextView, (String)localObject1);
      break;
      label704:
      paramTextView.setText((CharSequence)localObject1);
    }
  }
  
  public final void a(en paramen, View paramView, d paramd)
  {
    a(paramen, paramView, paramd, null);
  }
  
  public final void a(en paramen, View paramView, d paramd, g paramg)
  {
    int m = 0;
    Object localObject;
    if (paramen != null)
    {
      localObject = paramen.h;
      if (localObject != null) {
        break label1337;
      }
    }
    for (;;)
    {
      if ((paramen.f & 0x1) != 0) {
        paramView.setTag(paramen.C);
      }
      if (paramView.getLayoutParams() == null) {
        paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      }
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      int j = paramen.f;
      if ((j & 0x4) != 0) {}
      for (;;)
      {
        localLayoutParams.height = a(paramView, paramen.m, paramen.n);
        label790:
        label844:
        label846:
        label855:
        do
        {
          j = paramen.f;
          if ((j & 0x2) != 0) {}
          for (;;)
          {
            localLayoutParams.width = a(paramView, paramen.F, paramen.G);
            do
            {
              if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
              {
                paramd = (ViewGroup.MarginLayoutParams)localLayoutParams;
                if ((paramen.f & 0x8) != 0) {
                  android.support.v4.view.o.a(paramd, a(paramView, paramen.r, 2));
                }
                if ((paramen.f & 0x10) != 0) {
                  paramd.topMargin = a(paramView, paramen.s, 2);
                }
                if ((paramen.f & 0x20) != 0) {
                  android.support.v4.view.o.b(paramd, a(paramView, paramen.q, 2));
                }
                if ((paramen.f & 0x40) != 0) {
                  paramd.bottomMargin = a(paramView, paramen.p, 2);
                }
              }
              if ((paramen.f & 0x1000000) == 0) {}
              for (;;)
              {
                paramd = paramen.l;
                int n = paramd.length;
                if (n <= 0) {}
                for (;;)
                {
                  if (((paramen.f & 0x4000000) == 0) || (!(paramView instanceof LinearLayout))) {}
                  for (;;)
                  {
                    if ((paramen.f & 0x80) != 0) {}
                    for (j = a(paramView, paramen.A, 2);; j = ac.n(paramView))
                    {
                      if ((paramen.f & 0x100) != 0) {}
                      for (k = a(paramView, paramen.B, 2);; k = paramView.getPaddingTop())
                      {
                        if ((paramen.f & 0x200) != 0) {}
                        for (m = a(paramView, paramen.z, 2);; m = ac.o(paramView))
                        {
                          if ((paramen.f & 0x400) != 0) {}
                          for (n = a(paramView, paramen.y, 2);; n = paramView.getPaddingBottom())
                          {
                            ac.a(paramView, j, k, m, n);
                            if ((paramen.f & 0x10000000) != 0) {
                              switch (paramen.d)
                              {
                              case 14: 
                              default: 
                                j = 2131231280;
                              }
                            }
                            for (;;)
                            {
                              paramView.setBackgroundResource(j);
                              if ((paramen.f & 0x800) == 0) {}
                              for (;;)
                              {
                                if ((paramen.f & 0x4000) != 0)
                                {
                                  paramd = paramen.i;
                                  paramView.setContentDescription(paramd);
                                }
                                for (;;)
                                {
                                  if (!paramen.b) {}
                                  do
                                  {
                                    if ((paramen.f & 0x20000) != 0)
                                    {
                                      j = a(paramView, paramen.u, 2);
                                      if (!(paramView instanceof TextView)) {
                                        break label855;
                                      }
                                      ((TextView)paramView).setMinWidth(j);
                                    }
                                    for (;;)
                                    {
                                      if ((paramen.f & 0x40000) != 0)
                                      {
                                        j = a(paramView, paramen.t, 2);
                                        if (!(paramView instanceof TextView)) {
                                          break label846;
                                        }
                                        ((TextView)paramView).setMinHeight(j);
                                      }
                                      for (;;)
                                      {
                                        if (Build.VERSION.SDK_INT < 21) {}
                                        for (;;)
                                        {
                                          if ((paramen.f & 0x200000) != 0) {
                                            paramView.setEnabled(paramen.k);
                                          }
                                          if (!paramen.g) {}
                                          for (;;)
                                          {
                                            paramView.setLayoutParams(localLayoutParams);
                                            if ((paramen.f & 0x8000000) != 0) {
                                              paramView.setAlpha(android.support.v4.d.a.a(paramen.w));
                                            }
                                            return;
                                            if (paramg != null)
                                            {
                                              k = paramg.a.Y();
                                              if ((localLayoutParams != null) && (localLayoutParams.height > 0)) {
                                                j = localLayoutParams.height;
                                              }
                                              for (;;)
                                              {
                                                if ((j == -1) || (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams))) {
                                                  break label790;
                                                }
                                                paramd = (ViewGroup.MarginLayoutParams)localLayoutParams;
                                                m = paramd.topMargin;
                                                paramd.topMargin = ((k - j) / 2 + m);
                                                break;
                                                if ((paramView instanceof ProgressBar))
                                                {
                                                  j = ((ProgressBar)paramView).getIndeterminateDrawable().getIntrinsicHeight();
                                                }
                                                else if ((paramView instanceof ImageView))
                                                {
                                                  paramd = (ImageView)paramView;
                                                  if (paramd.getDrawable() != null) {
                                                    j = paramd.getDrawable().getIntrinsicHeight();
                                                  } else {
                                                    j = -1;
                                                  }
                                                }
                                                else
                                                {
                                                  j = -1;
                                                }
                                              }
                                            }
                                          }
                                          if (((paramen.f & 0x80000) == 0) || (!paramen.v)) {}
                                          for (;;)
                                          {
                                            if ((paramen.f & 0x100000) == 0) {
                                              break label844;
                                            }
                                            paramView.setElevation(a(paramView, paramen.j, 2));
                                            break;
                                            paramView.setStateListAnimator(null);
                                          }
                                        }
                                        paramView.setMinimumHeight(j);
                                      }
                                      paramView.setMinimumWidth(j);
                                    }
                                    localObject = paramd;
                                    if (paramd == null)
                                    {
                                      localObject = paramd;
                                      if ((paramView instanceof TextView)) {
                                        localObject = ((TextView)paramView).getText();
                                      }
                                    }
                                  } while (localObject == null);
                                  paramd = this.i;
                                  localObject = new l(paramView, (CharSequence)localObject);
                                  if ((paramen.f & 0x10000) != 0) {}
                                  for (long l = paramen.a;; l = 0L)
                                  {
                                    paramd.postDelayed((Runnable)localObject, l);
                                    break;
                                  }
                                  paramd = null;
                                }
                                localObject = paramView.getBackground();
                                if (localObject != null)
                                {
                                  j = paramen.e;
                                  if (j != 4)
                                  {
                                    k = paramen.c;
                                    if ((paramen.f & 0x1000) != 0) {}
                                    for (paramd = a(j);; paramd = null)
                                    {
                                      paramView.setBackground(a((Drawable)localObject, k, paramd));
                                      break;
                                    }
                                  }
                                }
                                paramView.setBackgroundColor(paramen.c);
                              }
                              j = 2131231224;
                              continue;
                              j = 2131231278;
                              continue;
                              j = 2131231219;
                              continue;
                              j = 2131231242;
                              continue;
                              j = 2131231248;
                              continue;
                              j = 2131231236;
                              continue;
                              j = 2131231254;
                              continue;
                              j = 2131231227;
                              continue;
                              j = 2131231216;
                              continue;
                              j = 2131231221;
                              continue;
                              j = 2131231251;
                              continue;
                              j = 2131231239;
                              continue;
                              j = 2131231257;
                              continue;
                              j = 2131231230;
                            }
                          }
                        }
                      }
                    }
                    j = m;
                    switch (paramen.x)
                    {
                    default: 
                      j = 1;
                    }
                    ((LinearLayout)paramView).setOrientation(j);
                  }
                  j = 0;
                  int k = 0;
                  while (j < n)
                  {
                    k |= d(paramd[j]);
                    j += 1;
                  }
                  if ((localLayoutParams instanceof LinearLayout.LayoutParams)) {
                    ((LinearLayout.LayoutParams)localLayoutParams).gravity = k;
                  }
                  if ((paramView instanceof LinearLayout)) {
                    ((LinearLayout)paramView).setGravity(k);
                  }
                }
                if ((localLayoutParams instanceof LinearLayout.LayoutParams)) {
                  ((LinearLayout.LayoutParams)localLayoutParams).weight = paramen.o;
                }
              }
            } while ((j & 0x400000) == 0);
          }
        } while ((j & 0x800000) == 0);
      }
      label1337:
      if (paramd != null) {
        paramView.setOnClickListener(new j(paramd, (bx)localObject));
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */