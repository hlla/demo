package com.tencent.mm.kiss.widget.textview;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.InputFilter.LengthFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.MetricAffectingSpan;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public final class d
{
  private static e hai;
  private static final SpannableString haj;
  int gravity;
  CharSequence hak;
  CharSequence hal;
  int ham;
  int han;
  TextPaint hao;
  Layout.Alignment hap;
  TextUtils.TruncateAt haq;
  int har;
  TextDirectionHeuristic has;
  float hat;
  float hau;
  boolean hav;
  InputFilter.LengthFilter haw;
  int maxLength;
  int maxLines;
  int width;
  
  static
  {
    GMTrace.i(434462785536L, 3237);
    hai = new e();
    haj = new SpannableString("");
    GMTrace.o(434462785536L, 3237);
  }
  
  public d()
  {
    GMTrace.i(433791696896L, 3232);
    this.hak = null;
    this.hal = null;
    this.ham = 0;
    this.han = 0;
    this.hao = null;
    this.width = 0;
    this.hap = Layout.Alignment.ALIGN_NORMAL;
    this.gravity = 51;
    this.haq = null;
    this.har = -1;
    this.maxLines = Integer.MAX_VALUE;
    this.has = null;
    this.hat = 0.0F;
    this.hau = 1.0F;
    this.hav = false;
    this.maxLength = -1;
    this.haw = null;
    GMTrace.o(433791696896L, 3232);
  }
  
  private StaticLayout a(CharSequence paramCharSequence, boolean paramBoolean, int paramInt)
  {
    GMTrace.i(434328567808L, 3236);
    if (paramBoolean) {
      paramCharSequence = new StaticLayout(paramCharSequence, this.ham, this.han, this.hao, this.width, this.hap, this.hau, this.hat, this.hav, this.haq, paramInt);
    }
    for (;;)
    {
      GMTrace.o(434328567808L, 3236);
      return paramCharSequence;
      if (Build.VERSION.SDK_INT >= 18)
      {
        if (this.has == null) {
          this.has = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.ham, this.han, this.hao, this.width, this.hap, this.has, this.hau, this.hat, this.hav, this.haq, paramInt, this.maxLines);
      }
      else
      {
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.ham, this.han, this.hao, this.width, this.hap, this.hau, this.hat, this.hav, this.haq, paramInt, this.maxLines);
      }
    }
  }
  
  private d a(Typeface paramTypeface)
  {
    GMTrace.i(434060132352L, 3234);
    this.hao.setTypeface(paramTypeface);
    GMTrace.o(434060132352L, 3234);
    return this;
  }
  
  public static d a(CharSequence paramCharSequence, int paramInt, com.tencent.mm.kiss.widget.textview.a.a parama)
  {
    boolean bool = false;
    GMTrace.i(433925914624L, 3233);
    Object localObject1 = paramCharSequence;
    if (paramCharSequence == null) {
      localObject1 = "";
    }
    int i = ((CharSequence)localObject1).length();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localObject1 = hai.vX();
    paramCharSequence = (CharSequence)localObject1;
    if (localObject1 == null) {
      paramCharSequence = new d();
    }
    paramCharSequence.hak = ((CharSequence)localObject2).toString();
    paramCharSequence.hal = ((CharSequence)localObject2);
    paramCharSequence.ham = 0;
    paramCharSequence.han = i;
    paramCharSequence.width = paramInt;
    paramCharSequence.hao = new TextPaint();
    if (parama.maxLines != -1)
    {
      paramInt = parama.maxLines;
      if (paramInt >= 0) {
        paramCharSequence.maxLines = paramInt;
      }
    }
    if (parama.maxLength != -1)
    {
      paramInt = parama.maxLength;
      if (paramInt >= 0)
      {
        paramCharSequence.maxLength = paramInt;
        paramCharSequence.haw = new InputFilter.LengthFilter(paramCharSequence.maxLength);
      }
    }
    localObject1 = parama.hap;
    if (localObject1 != null) {
      paramCharSequence.hap = ((Layout.Alignment)localObject1);
    }
    if (parama.haq != null)
    {
      localObject1 = parama.haq;
      if (localObject1 != null) {
        paramCharSequence.haq = ((TextUtils.TruncateAt)localObject1);
      }
    }
    paramCharSequence.gravity = parama.gravity;
    if (parama.haS != -1)
    {
      paramInt = parama.haS;
      if (paramInt >= 0) {
        paramCharSequence.har = paramInt;
      }
    }
    if (parama.has != null)
    {
      localObject1 = parama.has;
      if (Build.VERSION.SDK_INT >= 18) {
        paramCharSequence.has = ((TextDirectionHeuristic)localObject1);
      }
    }
    float f1 = parama.hat;
    float f2 = parama.hau;
    paramCharSequence.hat = f1;
    paramCharSequence.hau = f2;
    paramCharSequence.hav = parama.hav;
    if (parama.haT != null)
    {
      if (parama.haU == -1) {
        break label551;
      }
      localObject1 = parama.haT;
      i = parama.haU;
      if (i <= 0) {
        break label525;
      }
      if (localObject1 != null) {
        break label503;
      }
      localObject1 = Typeface.defaultFromStyle(i);
      paramCharSequence.a((Typeface)localObject1);
      if (localObject1 == null) {
        break label515;
      }
      paramInt = ((Typeface)localObject1).getStyle();
      label362:
      paramInt = (paramInt ^ 0xFFFFFFFF) & i;
      localObject1 = paramCharSequence.hao;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      ((TextPaint)localObject1).setFakeBoldText(bool);
      localObject1 = paramCharSequence.hao;
      if ((paramInt & 0x2) == 0) {
        break label520;
      }
      f1 = -0.25F;
      label406:
      ((TextPaint)localObject1).setTextSkewX(f1);
    }
    for (;;)
    {
      if (parama.haV != -1.0F)
      {
        f1 = parama.haV;
        paramCharSequence.hao.setTextSize(f1);
      }
      if (parama.textColor != -1)
      {
        paramInt = parama.textColor;
        paramCharSequence.hao.setColor(paramInt);
      }
      if (parama.linkColor != -1)
      {
        paramInt = parama.linkColor;
        paramCharSequence.hao.linkColor = paramInt;
      }
      if (parama.haA != null) {
        paramCharSequence.hao = parama.haA;
      }
      GMTrace.o(433925914624L, 3233);
      return paramCharSequence;
      label503:
      localObject1 = Typeface.create((Typeface)localObject1, i);
      break;
      label515:
      paramInt = 0;
      break label362;
      label520:
      f1 = 0.0F;
      break label406;
      label525:
      paramCharSequence.hao.setFakeBoldText(false);
      paramCharSequence.hao.setTextSkewX(0.0F);
      paramCharSequence.a((Typeface)localObject1);
      continue;
      label551:
      paramCharSequence.a(parama.haT);
    }
  }
  
  @TargetApi(18)
  public final f vW()
  {
    GMTrace.i(434194350080L, 3235);
    int j;
    Object localObject1;
    if ((this.haq == null) || (this.har <= 0))
    {
      j = this.width;
      if ((this.haq == null) && (this.maxLines == 1)) {
        this.haq = TextUtils.TruncateAt.END;
      }
      if ((this.maxLength > 0) && (this.haw != null))
      {
        localObject1 = this.haw.filter(this.hal, 0, this.hal.length(), haj, 0, 0);
        if (localObject1 != null)
        {
          this.hal = ((CharSequence)localObject1);
          if (this.han > this.hal.length()) {
            this.han = this.hal.length();
          }
        }
      }
      if (h.DEBUG) {
        v.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.hal + " " + this.width);
      }
      if (this.hap == Layout.Alignment.ALIGN_NORMAL) {}
      switch (this.gravity & 0x800007)
      {
      default: 
        this.hap = Layout.Alignment.ALIGN_NORMAL;
        label251:
        this.hao.setAntiAlias(true);
        localObject1 = null;
        if (((this.has != null) && ((!com.tencent.mm.compatible.util.d.eo(18)) || (this.has != TextDirectionHeuristics.FIRSTSTRONG_LTR))) || ((this.maxLines != Integer.MAX_VALUE) && (this.maxLines != -1))) {
          break;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        localObject3 = a(this.hal, bool, j);
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          v.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", new Object[] { localException2.getMessage() });
          int i = 0;
          if (i < 3)
          {
            int k = i;
            Object localObject4 = localObject1;
            try
            {
              SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.hal);
              k = i;
              localObject4 = localObject1;
              MetricAffectingSpan[] arrayOfMetricAffectingSpan = (MetricAffectingSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), MetricAffectingSpan.class);
              if (arrayOfMetricAffectingSpan != null)
              {
                k = i;
                localObject4 = localObject1;
                if (arrayOfMetricAffectingSpan.length > 0)
                {
                  k = i;
                  localObject4 = localObject1;
                  localSpannableStringBuilder.insert(localSpannableStringBuilder.getSpanStart(arrayOfMetricAffectingSpan[0]) - 1, " ");
                  i += 1;
                }
              }
              for (;;)
              {
                k = i;
                localObject4 = localObject1;
                this.hal = localSpannableStringBuilder;
                k = i;
                localObject4 = localObject1;
                localObject1 = a(this.hal, bool, j);
                k = i;
                localObject4 = localObject1;
                v.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", new Object[] { Integer.valueOf(i) });
                break;
                i = 100;
              }
            }
            catch (Exception localException1)
            {
              v.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", new Object[] { localException1.getMessage(), Integer.valueOf(k) });
              i = k;
              Object localObject2 = localObject4;
            }
          }
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        this.hal = this.hal.toString();
        localObject3 = a(this.hal, bool, j);
      }
      localObject1 = new f((StaticLayout)localObject3);
      ((f)localObject1).haz = this.hak;
      ((f)localObject1).text = this.hal;
      ((f)localObject1).maxLength = this.maxLength;
      ((f)localObject1).maxLines = this.maxLines;
      ((f)localObject1).hap = this.hap;
      ((f)localObject1).haq = this.haq;
      ((f)localObject1).haA = this.hao;
      ((f)localObject1).gravity = this.gravity;
      hai.a(this);
      GMTrace.o(434194350080L, 3235);
      return (f)localObject1;
      j = this.har;
      break;
      this.hap = Layout.Alignment.ALIGN_NORMAL;
      break label251;
      this.hap = Layout.Alignment.ALIGN_OPPOSITE;
      break label251;
      this.hap = Layout.Alignment.ALIGN_CENTER;
      break label251;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kiss/widget/textview/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */