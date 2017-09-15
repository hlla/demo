package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;

public final class h
{
  static LinkedList<e> sRR;
  private static boolean sRS;
  
  static
  {
    GMTrace.i(1220307582976L, 9092);
    sRR = new LinkedList();
    sRS = bf.Hq();
    GMTrace.o(1220307582976L, 9092);
  }
  
  public static String Ne(String paramString)
  {
    GMTrace.i(1220039147520L, 9090);
    if (bf.mA(paramString))
    {
      GMTrace.o(1220039147520L, 9090);
      return paramString;
    }
    n localn = new n(aa.getContext());
    localn.sSz = false;
    localn.sSx = true;
    localn.sSE = true;
    localn.sSF = true;
    localn.sSG = true;
    localn.sSI = 1;
    localn.sSA = false;
    localn.sSC = false;
    localn.sSB = false;
    localn.sSD = false;
    localn.sSH = false;
    localn.sSK = false;
    paramString = localn.a(paramString, 0, false).toString();
    GMTrace.o(1220039147520L, 9090);
    return paramString;
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    GMTrace.i(17439580487680L, 129935);
    paramContext = new n(paramContext);
    paramContext.sSz = true;
    paramContext.sSx = true;
    paramContext.sSy = sRS;
    paramContext.sSI = paramInt2;
    paramContext.sSA = true;
    paramContext.sSC = false;
    paramContext.sSK = true;
    paramContext = paramContext.i(paramTextView);
    if (paramInt2 == 1)
    {
      paramContext.sSB = true;
      paramContext.sSD = true;
    }
    for (;;)
    {
      paramContext = paramContext.a(paramTextView.getText(), paramInt1, paramBoolean);
      GMTrace.o(17439580487680L, 129935);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.sSB = false;
        paramContext.sSD = false;
      }
    }
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence)
  {
    GMTrace.i(1219099623424L, 9083);
    paramContext = e(paramContext, paramCharSequence, 0);
    GMTrace.o(1219099623424L, 9083);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    GMTrace.i(1219368058880L, 9085);
    paramContext = new n(paramContext);
    paramContext.sSz = true;
    paramContext.sSx = true;
    paramContext.sSy = sRS;
    paramContext.sSI = paramInt2;
    paramContext.sSA = true;
    paramContext.sSC = false;
    paramContext.sSK = true;
    if (paramInt2 == 1)
    {
      paramContext.sSB = true;
      paramContext.sSD = true;
    }
    for (;;)
    {
      paramContext = paramContext.a(paramCharSequence, paramInt1, true);
      GMTrace.o(1219368058880L, 9085);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.sSB = false;
        paramContext.sSD = false;
      }
    }
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject)
  {
    GMTrace.i(18728473329664L, 139538);
    paramContext = new n(paramContext);
    paramContext.sSz = true;
    paramContext.sSx = true;
    paramContext.sSy = sRS;
    paramContext.sSG = true;
    paramContext.sSI = 1;
    paramContext.sSA = true;
    paramContext.sSC = false;
    paramContext.sSK = true;
    paramContext.sSL = paramObject;
    paramContext.sSB = true;
    paramContext.sSD = true;
    paramContext = paramContext.a(paramCharSequence, paramInt, false);
    GMTrace.o(18728473329664L, 139538);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject, String paramString)
  {
    GMTrace.i(18727936458752L, 139534);
    paramContext = new n(paramContext);
    paramContext.sSz = true;
    paramContext.sSx = true;
    paramContext.sSI = 1;
    paramContext.sSA = true;
    paramContext.sSC = false;
    paramContext.sSK = true;
    paramContext = paramContext.i(null);
    paramContext.sSL = paramObject;
    paramContext.iCm = paramString;
    paramContext.sSB = true;
    paramContext.sSD = true;
    paramContext = paramContext.a(paramCharSequence, paramInt, true);
    GMTrace.o(18727936458752L, 139534);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, String paramString, Object paramObject)
  {
    GMTrace.i(18728339111936L, 139537);
    paramContext = new n(paramContext);
    paramContext.sSz = true;
    paramContext.sSx = true;
    paramContext.sSy = sRS;
    paramContext.sSG = true;
    paramContext.sSI = 1;
    paramContext.sSA = true;
    paramContext.sSC = false;
    paramContext.sSK = true;
    paramContext.sSL = paramObject;
    paramContext.iCm = paramString;
    paramContext.sSB = true;
    paramContext.sSD = true;
    paramContext = paramContext.a(paramCharSequence, paramInt, true);
    GMTrace.o(18728339111936L, 139537);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(1219904929792L, 9089);
    paramContext = new n(paramContext);
    paramContext.sSz = false;
    paramContext.sSx = true;
    paramContext.sSE = true;
    paramContext.sSF = paramBoolean;
    paramContext.sSG = true;
    paramContext.sSI = 1;
    paramContext.sSA = false;
    paramContext.sSC = false;
    paramContext.sSB = false;
    paramContext.sSD = false;
    paramContext.sSK = false;
    paramContext = paramContext.a(paramCharSequence, paramInt, true);
    GMTrace.o(1219904929792L, 9089);
    return paramContext;
  }
  
  public static SpannableString a(TextView paramTextView, int paramInt, boolean paramBoolean, Object paramObject)
  {
    GMTrace.i(1218025881600L, 9075);
    if (paramTextView == null)
    {
      v.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      GMTrace.o(1218025881600L, 9075);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    paramInt = (int)paramTextView.getTextSize();
    localObject = new n((Context)localObject);
    ((n)localObject).sSz = true;
    ((n)localObject).sSx = true;
    ((n)localObject).sSE = true;
    ((n)localObject).sSG = true;
    ((n)localObject).sSI = 1;
    ((n)localObject).sSA = true;
    ((n)localObject).sSC = false;
    ((n)localObject).sSK = true;
    localObject = ((n)localObject).i(paramTextView);
    ((n)localObject).sSB = true;
    ((n)localObject).sSD = true;
    if (paramObject != null) {
      ((n)localObject).sSL = paramObject;
    }
    paramTextView = ((n)localObject).a(paramTextView.getText(), paramInt, paramBoolean);
    GMTrace.o(1218025881600L, 9075);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, Object paramObject)
  {
    GMTrace.i(1217891663872L, 9074);
    paramTextView = a(paramTextView, 1, true, paramObject);
    GMTrace.o(1217891663872L, 9074);
    return paramTextView;
  }
  
  public static void a(e parame)
  {
    GMTrace.i(1217623228416L, 9072);
    sRR.add(parame);
    GMTrace.o(1217623228416L, 9072);
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    GMTrace.i(1218831187968L, 9081);
    paramContext = e(paramContext, paramCharSequence, (int)paramFloat);
    GMTrace.o(1218831187968L, 9081);
    return paramContext;
  }
  
  public static SpannableString b(TextView paramTextView, Object paramObject)
  {
    GMTrace.i(19010867429376L, 141642);
    if (paramTextView == null)
    {
      v.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      GMTrace.o(19010867429376L, 141642);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new n((Context)localObject);
    ((n)localObject).sSz = true;
    ((n)localObject).sSx = true;
    ((n)localObject).sSy = sRS;
    ((n)localObject).sSI = 1;
    ((n)localObject).sSA = true;
    ((n)localObject).sSC = false;
    ((n)localObject).sSK = true;
    localObject = ((n)localObject).i(paramTextView);
    ((n)localObject).sSL = paramObject;
    ((n)localObject).iCm = null;
    ((n)localObject).sSB = true;
    ((n)localObject).sSD = true;
    paramTextView = ((n)localObject).a(paramTextView.getText(), i, true);
    GMTrace.o(19010867429376L, 141642);
    return paramTextView;
  }
  
  public static void b(e parame)
  {
    GMTrace.i(1217757446144L, 9073);
    sRR.remove(parame);
    GMTrace.o(1217757446144L, 9073);
  }
  
  public static SpannableString c(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    GMTrace.i(1219770712064L, 9088);
    paramContext = a(paramContext, paramCharSequence, (int)paramFloat, false);
    GMTrace.o(1219770712064L, 9088);
    return paramContext;
  }
  
  public static SpannableString c(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    GMTrace.i(1218696970240L, 9080);
    paramContext = e(paramContext, paramCharSequence, paramInt);
    GMTrace.o(1218696970240L, 9080);
    return paramContext;
  }
  
  private static void c(Spannable paramSpannable)
  {
    int i = 0;
    GMTrace.i(18728070676480L, 139535);
    ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ClickableSpan.class);
    while (i < arrayOfClickableSpan.length)
    {
      paramSpannable.removeSpan(arrayOfClickableSpan[i]);
      i += 1;
    }
    GMTrace.o(18728070676480L, 139535);
  }
  
  public static void clearCache()
  {
    GMTrace.i(1220173365248L, 9091);
    v.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
    n.clearCache();
    GMTrace.o(1220173365248L, 9091);
  }
  
  public static SpannableString d(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    GMTrace.i(1218965405696L, 9082);
    paramContext = new n(paramContext);
    paramContext.sSA = false;
    paramContext.sSB = false;
    paramContext.sSx = false;
    paramContext.sSC = false;
    paramContext.sSI = paramInt;
    paramContext.sSz = false;
    paramContext.sSK = false;
    paramContext = paramContext.a(paramCharSequence, 0, true);
    c(paramContext);
    GMTrace.o(1218965405696L, 9082);
    return paramContext;
  }
  
  public static SpannableString d(TextView paramTextView, int paramInt)
  {
    GMTrace.i(1218160099328L, 9076);
    if (paramTextView == null)
    {
      v.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      GMTrace.o(1218160099328L, 9076);
      return paramTextView;
    }
    paramTextView = a(paramTextView.getContext(), paramTextView, (int)paramTextView.getTextSize(), true, paramInt);
    GMTrace.o(1218160099328L, 9076);
    return paramTextView;
  }
  
  private static SpannableString e(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    GMTrace.i(1219233841152L, 9084);
    paramContext = new n(paramContext);
    paramContext.sSA = false;
    paramContext.sSB = false;
    paramContext.sSx = false;
    paramContext.sSC = false;
    paramContext.sSz = false;
    paramContext.sSK = false;
    paramContext = paramContext.a(paramCharSequence, paramInt, true);
    c(paramContext);
    GMTrace.o(1219233841152L, 9084);
    return paramContext;
  }
  
  public static SpannableString f(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    GMTrace.i(18728204894208L, 139536);
    paramContext = new n(paramContext);
    paramContext.sSz = true;
    paramContext.sSx = true;
    paramContext.sSy = sRS;
    paramContext.sSG = true;
    paramContext.sSI = 1;
    paramContext.sSA = true;
    paramContext.sSC = false;
    paramContext.sSK = true;
    paramContext.sSL = null;
    paramContext.sSB = true;
    paramContext.sSD = true;
    paramContext = paramContext.a(paramCharSequence, paramInt, true);
    GMTrace.o(18728204894208L, 139536);
    return paramContext;
  }
  
  public static SpannableString g(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    GMTrace.i(1219636494336L, 9087);
    paramContext = a(paramContext, paramCharSequence, paramInt, true);
    GMTrace.o(1219636494336L, 9087);
    return paramContext;
  }
  
  public static SpannableString h(TextView paramTextView)
  {
    GMTrace.i(17439714705408L, 129936);
    if (paramTextView == null)
    {
      v.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      GMTrace.o(17439714705408L, 129936);
      return paramTextView;
    }
    paramTextView = a(paramTextView.getContext(), paramTextView, (int)paramTextView.getTextSize(), false, 1);
    GMTrace.o(17439714705408L, 129936);
    return paramTextView;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */