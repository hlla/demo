package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.d.b.a.a;
import com.tencent.mm.plugin.fts.d.b.a.b;
import com.tencent.mm.plugin.fts.d.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
{
  private static List<String> Y(String paramString, boolean paramBoolean)
  {
    GMTrace.i(18560298516480L, 138285);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      String str;
      if (d.f(c))
      {
        str = SpellMap.d(c);
        if ((str != null) && (str.length() > 1)) {
          if (paramBoolean) {
            localArrayList.add(str.substring(0, 1).toLowerCase());
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(str);
        continue;
        localArrayList.add("");
        continue;
        localArrayList.add("");
      }
    }
    GMTrace.o(18560298516480L, 138285);
    return localArrayList;
  }
  
  private static b a(SpannableString paramSpannableString, a.a parama, com.tencent.mm.plugin.fts.d.b.a parama1)
  {
    GMTrace.i(18560164298752L, 138284);
    if ((parama1.mbR > 0.0F) && (parama1.haA != null))
    {
      paramSpannableString = c(paramSpannableString, parama, parama1);
      GMTrace.o(18560164298752L, 138284);
      return paramSpannableString;
    }
    paramSpannableString = b(paramSpannableString, parama, parama1);
    GMTrace.o(18560164298752L, 138284);
    return paramSpannableString;
  }
  
  public static final b a(String paramString1, String paramString2, com.tencent.mm.plugin.fts.d.b.a parama)
  {
    GMTrace.i(18559761645568L, 138281);
    parama = b(parama);
    parama.mbY = TextUtils.concat(new CharSequence[] { paramString1, parama.mbY, paramString2 });
    GMTrace.o(18559761645568L, 138281);
    return parama;
  }
  
  public static final List<a.a> a(com.tencent.mm.plugin.fts.d.b.a parama)
  {
    GMTrace.i(18559895863296L, 138282);
    ArrayList localArrayList = new ArrayList();
    if (!parama.isAvailable())
    {
      GMTrace.o(18559895863296L, 138282);
      return localArrayList;
    }
    String str = SpellMap.mx(parama.mbL.toString().toLowerCase());
    Object localObject1 = new ArrayList();
    if (parama.lYh) {
      localObject1 = Y(str, parama.mbN);
    }
    for (;;)
    {
      Object localObject2;
      if (!bf.mA(parama.mbM))
      {
        localObject2 = new a.a();
        if (parama.lYh) {
          a((List)localObject1, parama.mbM, (a.a)localObject2);
        }
        while (((a.a)localObject2).isAvailable())
        {
          localArrayList.add(localObject2);
          GMTrace.o(18559895863296L, 138282);
          return localArrayList;
          a(str, parama.mbM, (a.a)localObject2);
        }
      }
      if (parama.mbO.size() > 0)
      {
        localObject2 = parama.mbO.iterator();
        label251:
        label263:
        while (((Iterator)localObject2).hasNext())
        {
          a.a locala = (a.a)((Iterator)localObject2).next();
          if ((!locala.isAvailable()) && (!bf.mA(locala.mbM)))
          {
            if (!parama.lYh) {
              break label251;
            }
            a((List)localObject1, locala.mbM, locala);
          }
          for (;;)
          {
            if (!locala.isAvailable()) {
              break label263;
            }
            localArrayList.add(locala);
            break;
            a(str, locala.mbM, locala);
          }
        }
      }
      GMTrace.o(18559895863296L, 138282);
      return localArrayList;
    }
  }
  
  private static void a(String paramString1, String paramString2, a.a parama)
  {
    GMTrace.i(18560432734208L, 138286);
    parama.mbM = SpellMap.mx(paramString2.toLowerCase());
    int i = paramString1.indexOf(parama.mbM);
    if (i >= 0)
    {
      parama.mbS = i;
      parama.mbT = (i + parama.mbM.length());
    }
    GMTrace.o(18560432734208L, 138286);
  }
  
  private static void a(List<String> paramList, String paramString, a.a parama)
  {
    GMTrace.i(18560566951936L, 138287);
    parama.mbM = SpellMap.mx(paramString.toLowerCase());
    int i = 0;
    if (i < paramList.size())
    {
      paramString = (String)paramList.get(i);
      int j;
      if (!bf.mA(paramString))
      {
        if (paramString.startsWith(parama.mbM))
        {
          if (parama.mbS < 0) {
            parama.mbS = i;
          }
          parama.mbT = (i + 1);
          GMTrace.o(18560566951936L, 138287);
          return;
        }
        if (parama.mbM.startsWith(paramString)) {
          j = i + 1;
        }
      }
      for (;;)
      {
        if ((j < paramList.size()) && (!bf.mA((String)paramList.get(j))))
        {
          paramString = paramString + (String)paramList.get(j);
          if ((parama.mbM.length() > paramString.length()) && (parama.mbM.startsWith(paramString))) {
            break label231;
          }
          if ((parama.mbM.length() <= paramString.length()) && (paramString.startsWith(parama.mbM)))
          {
            parama.mbS = i;
            parama.mbT = (j + 1);
          }
        }
        i += 1;
        break;
        label231:
        j += 1;
      }
    }
    GMTrace.o(18560566951936L, 138287);
  }
  
  private static b b(SpannableString paramSpannableString, a.a parama, com.tencent.mm.plugin.fts.d.b.a parama1)
  {
    GMTrace.i(18560701169664L, 138288);
    b localb = new b();
    if (parama1.mbP == a.b.mbV) {
      parama1 = new BackgroundColorSpan(parama1.mbQ);
    }
    try
    {
      for (;;)
      {
        paramSpannableString.setSpan(parama1, parama.mbS, parama.mbT, 33);
        localb.mbY = paramSpannableString;
        localb.aMA = 0;
        GMTrace.o(18560701169664L, 138288);
        return localb;
        parama1 = new ForegroundColorSpan(parama1.mbQ);
      }
    }
    catch (Exception parama1)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.FTS.FTSUIHighlightLogic", parama1, "setSpan %s", new Object[] { parama.toString() });
        localb.mbY = paramSpannableString;
        localb.aMA = -1;
      }
    }
  }
  
  public static final b b(com.tencent.mm.plugin.fts.d.b.a parama)
  {
    GMTrace.i(18560030081024L, 138283);
    Object localObject4 = parama;
    parama = new b();
    if (!((com.tencent.mm.plugin.fts.d.b.a)localObject4).isAvailable())
    {
      parama.mbY = bf.ap(((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbL.toString(), "");
      parama.aMA = -1;
      GMTrace.o(18560030081024L, 138283);
      return parama;
    }
    Object localObject1;
    Object localObject7;
    Object localObject5;
    if ((((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbL instanceof SpannableString))
    {
      localObject1 = (SpannableString)((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbL;
      localObject7 = SpellMap.mx(((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbL.toString().toLowerCase());
      localObject5 = new ArrayList();
      if (!((com.tencent.mm.plugin.fts.d.b.a)localObject4).lYh) {
        break label1097;
      }
      localObject5 = Y((String)localObject7, ((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbN);
    }
    label252:
    label291:
    label352:
    label1091:
    label1094:
    label1097:
    for (;;)
    {
      if (!bf.mA(((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbM))
      {
        Object localObject2 = new a.a();
        if (((com.tencent.mm.plugin.fts.d.b.a)localObject4).lYh) {
          a((List)localObject5, ((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbM, (a.a)localObject2);
        }
        for (;;)
        {
          if (!((a.a)localObject2).isAvailable()) {
            break label252;
          }
          try
          {
            localObject2 = a((SpannableString)localObject1, (a.a)localObject2, (com.tencent.mm.plugin.fts.d.b.a)localObject4);
            parama = (com.tencent.mm.plugin.fts.d.b.a)localObject2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              parama.mbY = ((CharSequence)localObject1);
              parama.aMA = 0;
            }
          }
          GMTrace.o(18560030081024L, 138283);
          return parama;
          localObject1 = new SpannableString(((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbL);
          break;
          a((String)localObject7, ((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbM, (a.a)localObject2);
        }
      }
      parama.aMA = -1;
      parama.mbY = ((CharSequence)localObject1);
      Object localObject3;
      Object localObject6;
      if (((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbO.size() > 0)
      {
        localObject3 = null;
        Iterator localIterator = ((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbO.iterator();
        if (localIterator.hasNext())
        {
          localObject6 = (a.a)localIterator.next();
          if ((!((a.a)localObject6).isAvailable()) && (!bf.mA(((a.a)localObject6).mbM)))
          {
            if (((com.tencent.mm.plugin.fts.d.b.a)localObject4).lYh) {
              a((List)localObject5, ((a.a)localObject6).mbM, (a.a)localObject6);
            }
          }
          else
          {
            if ((!((a.a)localObject6).isAvailable()) || (localObject3 != null)) {
              break label1094;
            }
            localObject3 = localObject6;
          }
        }
      }
      for (;;)
      {
        break label291;
        a((String)localObject7, ((a.a)localObject6).mbM, (a.a)localObject6);
        break label352;
        if (localObject3 == null)
        {
          GMTrace.o(18560030081024L, 138283);
          return parama;
        }
        if ((((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbR > 0.0F) && (((com.tencent.mm.plugin.fts.d.b.a)localObject4).haA != null))
        {
          localObject5 = new com.tencent.mm.plugin.fts.d.b.a();
          for (;;)
          {
            try
            {
              f1 = ((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbR - ((com.tencent.mm.plugin.fts.d.b.a)localObject4).haA.getTextSize() * 2.0F;
              f2 = ((com.tencent.mm.plugin.fts.d.b.a)localObject4).haA.measureText("…");
              f3 = ((com.tencent.mm.plugin.fts.d.b.a)localObject4).haA.measureText((CharSequence)localObject1, 0, ((a.a)localObject3).mbS);
              f4 = ((com.tencent.mm.plugin.fts.d.b.a)localObject4).haA.measureText((CharSequence)localObject1, ((a.a)localObject3).mbS, ((a.a)localObject3).mbT);
              f5 = ((com.tencent.mm.plugin.fts.d.b.a)localObject4).haA.measureText((CharSequence)localObject1, ((a.a)localObject3).mbT, ((SpannableString)localObject1).length());
              if (f3 + f4 + f5 >= f1) {
                continue;
              }
              parama = (com.tencent.mm.plugin.fts.d.b.a)localObject1;
            }
            catch (Exception parama)
            {
              float f2;
              float f3;
              float f4;
              float f5;
              ((com.tencent.mm.plugin.fts.d.b.a)localObject5).mbL = ((CharSequence)localObject1);
              continue;
              if (f2 + f4 + f5 >= f1) {
                continue;
              }
              localObject6 = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject6).append(TextUtils.ellipsize(((SpannableString)localObject1).subSequence(0, ((a.a)localObject3).mbS), ((com.tencent.mm.plugin.fts.d.b.a)localObject4).haA, f1 - f4 - f5, TextUtils.TruncateAt.START));
              ((SpannableStringBuilder)localObject6).append(parama);
              ((SpannableStringBuilder)localObject6).append((CharSequence)localObject1, ((a.a)localObject3).mbT, ((SpannableString)localObject1).length());
              parama = new SpannableString((CharSequence)localObject6);
              continue;
              if (f2 + (f2 + f4) < f1) {
                continue;
              }
              localObject3 = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject3).append(TextUtils.ellipsize(parama, ((com.tencent.mm.plugin.fts.d.b.a)localObject4).haA, f1, TextUtils.TruncateAt.END));
              parama = new SpannableString((CharSequence)localObject3);
              continue;
              localObject6 = new SpannableStringBuilder();
              float f1 = (f1 - f4) / 2.0F;
              localObject7 = ((SpannableString)localObject1).subSequence(0, ((a.a)localObject3).mbS);
              localObject3 = ((SpannableString)localObject1).subSequence(((a.a)localObject3).mbT, ((SpannableString)localObject1).length());
              ((SpannableStringBuilder)localObject6).append(TextUtils.ellipsize((CharSequence)localObject7, ((com.tencent.mm.plugin.fts.d.b.a)localObject4).haA, f1, TextUtils.TruncateAt.START));
              ((SpannableStringBuilder)localObject6).append(parama);
              ((SpannableStringBuilder)localObject6).append(TextUtils.ellipsize((CharSequence)localObject3, ((com.tencent.mm.plugin.fts.d.b.a)localObject4).haA, f1, TextUtils.TruncateAt.END));
              parama = new SpannableString((CharSequence)localObject6);
              continue;
              localObject4 = localObject5;
            }
            ((com.tencent.mm.plugin.fts.d.b.a)localObject5).mbL = parama;
            ((com.tencent.mm.plugin.fts.d.b.a)localObject5).lYh = ((com.tencent.mm.plugin.fts.d.b.a)localObject4).lYh;
            ((com.tencent.mm.plugin.fts.d.b.a)localObject5).mbN = ((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbN;
            parama = ((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbO.iterator();
            if (!parama.hasNext()) {
              continue;
            }
            localObject1 = (a.a)parama.next();
            localObject3 = new a.a();
            ((a.a)localObject3).mbM = ((a.a)localObject1).mbM;
            ((com.tencent.mm.plugin.fts.d.b.a)localObject5).mbO.add(localObject3);
            continue;
            parama = new SpannableString(((SpannableString)localObject1).subSequence(((a.a)localObject3).mbS, ((a.a)localObject3).mbT));
            if (f3 + f4 + f2 >= f1) {
              continue;
            }
            localObject6 = new SpannableStringBuilder((CharSequence)localObject1, 0, ((a.a)localObject3).mbS);
            ((SpannableStringBuilder)localObject6).append(parama);
            ((SpannableStringBuilder)localObject6).append(TextUtils.ellipsize(((SpannableString)localObject1).subSequence(((a.a)localObject3).mbT, ((SpannableString)localObject1).length()), ((com.tencent.mm.plugin.fts.d.b.a)localObject4).haA, f1 - f3 - f4, TextUtils.TruncateAt.END));
            parama = new SpannableString((CharSequence)localObject6);
          }
          break;
        }
        localObject5 = ((com.tencent.mm.plugin.fts.d.b.a)localObject4).mbO.iterator();
        localObject3 = parama;
        if (((Iterator)localObject5).hasNext())
        {
          localObject3 = (a.a)((Iterator)localObject5).next();
          if (!((a.a)localObject3).isAvailable()) {
            break label1091;
          }
          localObject3 = a((SpannableString)localObject1, (a.a)localObject3, (com.tencent.mm.plugin.fts.d.b.a)localObject4);
          if (((b)localObject3).aMA != 0) {
            break label1091;
          }
          parama = (com.tencent.mm.plugin.fts.d.b.a)localObject3;
        }
        for (;;)
        {
          break;
          localObject3 = parama;
          GMTrace.o(18560030081024L, 138283);
          return (b)localObject3;
        }
      }
    }
  }
  
  private static b c(SpannableString paramSpannableString, a.a parama, com.tencent.mm.plugin.fts.d.b.a parama1)
  {
    GMTrace.i(18560835387392L, 138289);
    b localb = new b();
    float f1 = parama1.mbR - parama1.haA.getTextSize() * 2.0F;
    float f2 = parama1.haA.measureText("…");
    float f3 = parama1.haA.measureText(paramSpannableString, 0, parama.mbS);
    float f4 = parama1.haA.measureText(paramSpannableString, parama.mbS, parama.mbT);
    float f5 = parama1.haA.measureText(paramSpannableString, parama.mbT, paramSpannableString.length());
    if (f3 + f4 + f5 < f1)
    {
      paramSpannableString = b(paramSpannableString, parama, parama1);
      GMTrace.o(18560835387392L, 138289);
      return paramSpannableString;
    }
    Object localObject;
    SpannableString localSpannableString;
    if (parama1.mbP == a.b.mbV)
    {
      localObject = new BackgroundColorSpan(parama1.mbQ);
      localSpannableString = new SpannableString(paramSpannableString.subSequence(parama.mbS, parama.mbT));
    }
    for (;;)
    {
      try
      {
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        if (f3 + f4 + f2 >= f1) {
          break label342;
        }
        localObject = new SpannableStringBuilder(paramSpannableString, 0, parama.mbS);
        ((SpannableStringBuilder)localObject).append(localSpannableString);
        ((SpannableStringBuilder)localObject).append(TextUtils.ellipsize(paramSpannableString.subSequence(parama.mbT, paramSpannableString.length()), parama1.haA, f1 - f3 - f4, TextUtils.TruncateAt.END));
        localb.mbY = ((CharSequence)localObject);
        localb.aMA = 0;
        GMTrace.o(18560835387392L, 138289);
        return localb;
      }
      catch (Exception parama1)
      {
        v.printErrStackTrace("MicroMsg.FTS.FTSUIHighlightLogic", parama1, "setSpan %s", new Object[] { parama.toString() });
        localb.aMA = -1;
        localb.mbY = paramSpannableString;
        GMTrace.o(18560835387392L, 138289);
        return localb;
      }
      localObject = new ForegroundColorSpan(parama1.mbQ);
      break;
      label342:
      if (f2 + f4 + f5 < f1)
      {
        localObject = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject).append(TextUtils.ellipsize(paramSpannableString.subSequence(0, parama.mbS), parama1.haA, f1 - f4 - f5, TextUtils.TruncateAt.START));
        ((SpannableStringBuilder)localObject).append(localSpannableString);
        ((SpannableStringBuilder)localObject).append(paramSpannableString, parama.mbT, paramSpannableString.length());
        localb.mbY = ((CharSequence)localObject);
      }
      else if (f2 + f4 + f2 >= f1)
      {
        paramSpannableString = new SpannableStringBuilder();
        paramSpannableString.append(TextUtils.ellipsize(localSpannableString, parama1.haA, f1, TextUtils.TruncateAt.END));
        localb.mbY = paramSpannableString;
      }
      else
      {
        localObject = new SpannableStringBuilder();
        f1 = (f1 - f4) / 2.0F;
        CharSequence localCharSequence = paramSpannableString.subSequence(0, parama.mbS);
        paramSpannableString = paramSpannableString.subSequence(parama.mbT, paramSpannableString.length());
        ((SpannableStringBuilder)localObject).append(TextUtils.ellipsize(localCharSequence, parama1.haA, f1, TextUtils.TruncateAt.START));
        ((SpannableStringBuilder)localObject).append(localSpannableString);
        ((SpannableStringBuilder)localObject).append(TextUtils.ellipsize(paramSpannableString, parama1.haA, f1, TextUtils.TruncateAt.END));
        localb.mbY = ((CharSequence)localObject);
      }
    }
  }
  
  public static final class a
  {
    public static int maW;
    
    static
    {
      GMTrace.i(18561909129216L, 138297);
      maW = 0;
      Context localContext = aa.getContext();
      maW = com.tencent.mm.bg.a.dO(localContext) - com.tencent.mm.bg.a.T(localContext, j.b.mbg) * 2 - com.tencent.mm.bg.a.T(localContext, j.b.aXA) - com.tencent.mm.bg.a.T(localContext, j.b.mbg);
      GMTrace.o(18561909129216L, 138297);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */