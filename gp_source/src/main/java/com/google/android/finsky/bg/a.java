package com.google.android.finsky.bg;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.text.Html;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.installer.p;
import com.google.android.finsky.installqueue.g;
import com.google.android.finsky.installqueue.n;
import com.google.android.finsky.installqueue.s;
import com.google.android.finsky.utils.i;
import com.google.android.finsky.utils.j;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public final com.google.android.finsky.waitforwifi.d a;
  private final com.google.android.finsky.l.a b;
  private final com.google.android.finsky.bo.c c;
  private final g d;
  private final p e;
  private final PackageManager f;
  
  public a(com.google.android.finsky.waitforwifi.d paramd, com.google.android.finsky.bo.c paramc, PackageManager paramPackageManager, g paramg, p paramp, com.google.android.finsky.l.a parama)
  {
    this.a = paramd;
    this.c = paramc;
    this.f = paramPackageManager;
    this.d = paramg;
    this.e = paramp;
    this.b = parama;
  }
  
  public static d a(Context paramContext, n paramn, boolean paramBoolean1, boolean paramBoolean2)
  {
    d locald = new d();
    locald.d = Html.fromHtml(paramContext.getString(2131952172));
    locald.c = Html.fromHtml(paramContext.getString(2131952171));
    if (paramBoolean1) {
      locald.f = " ";
    }
    for (locald.a = " ";; locald.a = null)
    {
      int i = paramn.f.f;
      if (i == 1)
      {
        if (paramn.c() > 0L) {
          if (paramn.d() > 0L) {
            if (paramn.c() <= paramn.d()) {
              paramBoolean1 = true;
            }
          }
        }
        for (;;)
        {
          locald.b = paramBoolean1;
          if (locald.b) {}
          for (i = (int)(paramn.c() * 100L / paramn.d());; i = 0)
          {
            locald.e = i;
            if (locald.b)
            {
              locald.g = false;
              if (paramBoolean2) {
                locald.h = 10000;
              }
            }
            for (;;)
            {
              i = paramn.e();
              if (i == 195) {
                locald.a = paramContext.getResources().getString(2131952164);
              }
              for (;;)
              {
                return locald;
                if (i == 196)
                {
                  locald.a = paramContext.getResources().getString(2131952165);
                }
                else if (!locald.b)
                {
                  locald.a = paramContext.getResources().getString(2131952160);
                }
                else if (!paramBoolean2)
                {
                  locald.f = TextUtils.expandTemplate(locald.d, new CharSequence[] { Integer.toString(locald.e) });
                  locald.a = TextUtils.expandTemplate(locald.c, new CharSequence[] { Formatter.formatFileSize(paramContext, paramn.c()), Formatter.formatFileSize(paramContext, paramn.d()) });
                }
              }
              locald.h = 100;
              locald.i = locald.e;
              continue;
              locald.g = true;
            }
          }
          paramBoolean1 = false;
          continue;
          paramBoolean1 = false;
          continue;
          paramBoolean1 = false;
        }
      }
      if (i == 0)
      {
        locald.g = false;
        locald.i = 0;
      }
      for (;;)
      {
        if (i == 4) {
          locald.a = paramContext.getResources().getString(2131952436);
        }
        for (;;)
        {
          return locald;
          if (com.google.android.finsky.ba.a.b(paramContext)) {
            locald.a = paramContext.getResources().getString(2131953472);
          }
        }
        locald.g = true;
      }
      locald.f = null;
    }
  }
  
  public static n a(s params)
  {
    return new n("", null, s.a(params.e), 0, params);
  }
  
  private final String a(String paramString)
  {
    Object localObject = this.e.n(paramString);
    if (localObject == null) {}
    try
    {
      localObject = this.f;
      localObject = ((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(paramString, 0)).toString();
      return (String)localObject;
    }
    catch (NameNotFoundException localNameNotFoundException) {}
    return (String)localObject;
    return paramString;
  }
  
  private static void a(Context paramContext, n paramn, TextView paramTextView1, TextView paramTextView2, ProgressBar paramProgressBar, boolean paramBoolean, e parame)
  {
    if (parame != null) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject1 = a(paramContext, paramn, paramBoolean, bool);
      paramTextView1.setText(((d)localObject1).a);
      paramTextView2.setText(((d)localObject1).f);
      paramProgressBar.setIndeterminate(((d)localObject1).g);
      paramProgressBar.setMax(((d)localObject1).h);
      paramProgressBar.setProgress(((d)localObject1).i);
      Object localObject2;
      if (parame != null)
      {
        localObject2 = parame.b;
        if (localObject2 != null)
        {
          ((ValueAnimator)localObject2).cancel();
          parame.b = null;
        }
        parame.o = false;
        parame.p = false;
        if (paramn.f.f == 1) {
          break label317;
        }
      }
      for (;;)
      {
        paramBoolean = ((d)localObject1).b;
        int i = ((d)localObject1).e;
        localObject2 = ((d)localObject1).d;
        localObject1 = ((d)localObject1).c;
        long l1 = paramn.d();
        if (!paramBoolean)
        {
          parame.l = 0L;
          return;
        }
        long l2 = i.a();
        long l3 = parame.l;
        if ((l3 != 0L) && (i < 100)) {}
        for (parame.c = Math.min(2000L, Math.max(300L, l2 - l3));; parame.c = 2000L)
        {
          parame.l = l2;
          parame.g = false;
          parame.b = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
          parame.b.addUpdateListener(new c(parame, paramProgressBar, (CharSequence)localObject2, paramTextView2, (CharSequence)localObject1, paramContext, l1, paramTextView1));
          parame.b.setInterpolator(e.a);
          parame.b.setDuration(parame.c);
          parame.b.start();
          return;
        }
        label317:
        if (((d)localObject1).b)
        {
          parame.o = true;
          parame.q = parame.j;
          parame.f = ((int)(paramn.c() * 10000L / paramn.d()));
          if ((paramn.e() != 195) && (paramn.e() != 196))
          {
            parame.p = true;
            parame.n = parame.i;
            parame.m = ((d)localObject1).e;
            parame.e = parame.h;
            parame.d = paramn.c();
          }
        }
      }
    }
  }
  
  public static boolean b(s params)
  {
    long l1 = params.a;
    if (l1 > 0L)
    {
      long l2 = params.b;
      if ((l2 > 0L) && (l1 <= l2)) {
        return true;
      }
    }
    return false;
  }
  
  public static int c(s params)
  {
    return (int)(params.a * 100L / params.b);
  }
  
  public final String a(int paramInt, Context paramContext)
  {
    if (this.c.cY().a(12625960L))
    {
      Iterator localIterator = this.b.b().iterator();
      if (localIterator.hasNext())
      {
        String str = ((com.google.android.finsky.l.b)localIterator.next()).d;
        int i = this.d.b(str);
        if (!com.google.android.finsky.utils.b.a(j.a((String)com.google.android.finsky.ag.d.cb.b()), str)) {}
        for (str = a(str);; str = paramContext.getString(2131952169))
        {
          if (i == 3) {
            return paramContext.getString(2131952168, new Object[] { str });
          }
          if (i != 2) {
            break;
          }
          return paramContext.getString(2131952167, new Object[] { str });
        }
      }
    }
    if (paramInt != 196) {
      return paramContext.getString(2131952166);
    }
    return paramContext.getString(2131952165);
  }
  
  public final void a(Context paramContext, n paramn, TextView paramTextView1, TextView paramTextView2, ProgressBar paramProgressBar)
  {
    a(paramContext, paramn, paramTextView1, paramTextView2, paramProgressBar, false, null);
  }
  
  public final void a(Context paramContext, s params, TextView paramTextView1, TextView paramTextView2, ProgressBar paramProgressBar)
  {
    a(paramContext, params, paramTextView1, paramTextView2, paramProgressBar, null);
  }
  
  public final void a(Context paramContext, s params, TextView paramTextView1, TextView paramTextView2, ProgressBar paramProgressBar, e parame)
  {
    a(paramContext, a(params), paramTextView1, paramTextView2, paramProgressBar, true, parame);
  }
  
  public final void a(s params, View paramView1, View paramView2, Document paramDocument, af paramaf, aq paramaq)
  {
    if (params.c == 196)
    {
      paramView2.setVisibility(0);
      paramView1.setOnClickListener(new b(this, paramaf, paramaq, paramDocument, paramView2));
      return;
    }
    paramView2.setVisibility(8);
    paramView1.setOnClickListener(null);
    paramView1.setClickable(false);
    paramView1.setFocusable(false);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bg/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */