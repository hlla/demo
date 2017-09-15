package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.b.a;
import com.tencent.mm.plugin.fts.d.b.a.a;
import com.tencent.mm.plugin.fts.d.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.o;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public static CharSequence a(Context paramContext, List<com.tencent.mm.plugin.fts.a.a.d> paramList, String[] paramArrayOfString, List<String> paramList1, TextPaint paramTextPaint, String paramString)
  {
    GMTrace.i(18562580217856L, 138302);
    Arrays.sort(paramArrayOfString, new Comparator() {});
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (i < paramList.size())
    {
      localObject1 = (com.tencent.mm.plugin.fts.a.a.d)paramList.get(i);
      if (((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYc < paramArrayOfString.length)
      {
        localObject2 = paramArrayOfString[localObject1.lYc];
        if (!bf.mA((String)localObject2))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb((String)localObject2);
          if (localObject2 != null)
          {
            localObject3 = ((af)localObject2).field_username;
            localObject4 = o.a((x)localObject2, (String)localObject3);
            switch (((com.tencent.mm.plugin.fts.a.a.d)localObject1).hOZ)
            {
            }
          }
        }
      }
      for (;;)
      {
        if ((!bf.mA(((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYe)) && (((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYe.contains(paramString))) {
          ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYg += 10;
        }
        i += 1;
        break;
        ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYe = com.tencent.mm.plugin.fts.a.d.ch((String)localObject3, ((x)localObject2).pA());
        ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYf = ((String)localObject4);
        continue;
        ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYi = true;
        ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYh = true;
        ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYe = ((af)localObject2).field_nickname;
        if (!((af)localObject2).field_nickname.equals(localObject4))
        {
          ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYf = ((String)localObject4);
          continue;
          ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYi = true;
          ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYh = true;
          ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYe = ((String)localObject4);
          continue;
          ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYe = ((com.tencent.mm.plugin.fts.a.a.d)localObject1).content;
          ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYf = ((String)localObject4);
          continue;
          ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYe = ((af)localObject2).gkA;
          ((com.tencent.mm.plugin.fts.a.a.d)localObject1).lYf = ((String)localObject4);
        }
      }
    }
    Collections.sort(paramList, new Comparator() {});
    i = 0;
    if ((i < paramList.size()) && (i < paramList1.size()))
    {
      paramArrayOfString = (com.tencent.mm.plugin.fts.a.a.d)paramList.get(i);
      localObject1 = com.tencent.mm.pluginsdk.ui.d.h.b(paramContext, paramArrayOfString.lYe, paramTextPaint.getTextSize());
      if (localSpannableStringBuilder.length() > 0) {
        localSpannableStringBuilder.append(", ");
      }
      localObject2 = f.a(a.a((CharSequence)localObject1, paramString, paramList1, paramArrayOfString.lYh, paramArrayOfString.lYi, f.a.maW - 100, paramTextPaint));
      if (bf.mA(paramArrayOfString.lYf))
      {
        localObject3 = new a();
        ((a)localObject3).mbL = ((CharSequence)localObject1);
        ((a)localObject3).mbO = ((List)localObject2);
        ((a)localObject3).lYh = paramArrayOfString.lYh;
        ((a)localObject3).mbN = paramArrayOfString.lYi;
        ((a)localObject3).mbR = (f.a.maW - 100);
        ((a)localObject3).haA = paramTextPaint;
        localSpannableStringBuilder.append(f.b((a)localObject3).mbY);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject3 = TextUtils.concat(new CharSequence[] { com.tencent.mm.pluginsdk.ui.d.h.b(paramContext, paramArrayOfString.lYf, paramTextPaint.getTextSize()), "(" });
        int j = ((CharSequence)localObject3).length();
        localObject4 = ((List)localObject2).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          a.a locala = (a.a)((Iterator)localObject4).next();
          locala.mbS += j;
          locala.mbT += j;
        }
        localObject4 = new a();
        ((a)localObject4).mbL = TextUtils.concat(new CharSequence[] { localObject3, localObject1, ")" });
        ((a)localObject4).mbO = ((List)localObject2);
        ((a)localObject4).lYh = paramArrayOfString.lYh;
        ((a)localObject4).mbN = paramArrayOfString.lYi;
        ((a)localObject4).mbR = (f.a.maW - 100);
        ((a)localObject4).haA = paramTextPaint;
        localSpannableStringBuilder.append(f.b((a)localObject4).mbY);
      }
    }
    GMTrace.o(18562580217856L, 138302);
    return localSpannableStringBuilder;
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(18562043346944L, 138298);
    a(paramContext, paramImageView, paramString1, paramString2, paramInt, true, 0, 0);
    GMTrace.o(18562043346944L, 138298);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(18562177564672L, 138299);
    a(paramContext, paramImageView, paramString1, paramString2, paramInt1, false, paramInt2, paramInt3);
    GMTrace.o(18562177564672L, 138299);
  }
  
  private static void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    GMTrace.i(18562311782400L, 138300);
    h.axX().a(paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
    if ((!bf.mA(paramString1)) || (!bf.mA(paramString2)))
    {
      Bitmap localBitmap = h.axX().a(paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        g.a.a(paramContext.getResources(), localBitmap, paramImageView);
        paramImageView.setVisibility(0);
        GMTrace.o(18562311782400L, 138300);
        return;
      }
      if (paramInt1 > 0) {
        paramImageView.setImageResource(paramInt1);
      }
      for (;;)
      {
        h.axX().a(paramContext, paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
        break;
        paramImageView.setImageResource(j.a.transparent);
      }
    }
    if ((paramInt1 > 0) && ((!bf.mA(paramString1)) || (!bf.mA(paramString2))))
    {
      paramImageView.setImageResource(paramInt1);
      GMTrace.o(18562311782400L, 138300);
      return;
    }
    paramImageView.setVisibility(8);
    GMTrace.o(18562311782400L, 138300);
  }
  
  public static boolean a(CharSequence paramCharSequence, TextView paramTextView)
  {
    GMTrace.i(16711986184192L, 124514);
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
    {
      paramTextView.setText(paramCharSequence, TextView.BufferType.SPANNABLE);
      paramTextView.setVisibility(0);
      GMTrace.o(16711986184192L, 124514);
      return true;
    }
    paramTextView.setVisibility(8);
    GMTrace.o(16711986184192L, 124514);
    return false;
  }
  
  public static boolean a(String paramString, TextView paramTextView)
  {
    GMTrace.i(16712120401920L, 124515);
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramTextView.setText(paramString);
      paramTextView.setVisibility(0);
      GMTrace.o(16712120401920L, 124515);
      return true;
    }
    paramTextView.setVisibility(8);
    GMTrace.o(16712120401920L, 124515);
    return false;
  }
  
  public static String mQ(int paramInt)
  {
    GMTrace.i(18562446000128L, 138301);
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    while (i == 0)
    {
      GMTrace.o(18562446000128L, 138301);
      return null;
      i = j.g.ene;
      continue;
      i = j.g.mbh;
      continue;
      i = j.g.mbl;
      continue;
      i = j.g.emV;
      continue;
      i = j.g.emW;
      continue;
      i = j.g.mbk;
      continue;
      i = j.g.mbi;
      continue;
      i = j.g.mbj;
      continue;
      i = j.g.mbm;
      continue;
      i = j.g.mbn;
    }
    String str = aa.getContext().getString(i);
    GMTrace.o(18562446000128L, 138301);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */