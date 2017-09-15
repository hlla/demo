package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.platformtools.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.l.a.a.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;
import junit.framework.Assert;

public final class c
{
  com.tencent.mm.pluginsdk.l.a.a wcJ;
  
  c(com.tencent.mm.pluginsdk.l.a.a parama)
  {
    GMTrace.i(14506252042240L, 108080);
    this.wcJ = parama;
    GMTrace.o(14506252042240L, 108080);
  }
  
  private static Drawable a(Map<String, String> paramMap, Context paramContext)
  {
    GMTrace.i(14506520477696L, 108082);
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      GMTrace.o(14506520477696L, 108082);
      return null;
    }
    Object localObject1 = paramContext.getResources().getDisplayMetrics();
    Object localObject2 = (String)paramMap.get(((DisplayMetrics)localObject1).heightPixels + "x" + ((DisplayMetrics)localObject1).widthPixels);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      new b();
      localObject1 = paramContext.getResources().getDisplayMetrics();
      localObject2 = paramContext.getResources().getConfiguration();
      if (((DisplayMetrics)localObject1).density >= 1.0F) {
        break label206;
      }
      localObject1 = "" + "LDPI";
      localObject3 = new StringBuilder().append((String)localObject1);
      if (((Configuration)localObject2).orientation != 2) {
        break label264;
      }
    }
    label206:
    label264:
    for (localObject1 = "_L";; localObject1 = "_P")
    {
      localObject1 = (String)paramMap.get((String)localObject1);
      if (u.mz((String)localObject1).length() > 0) {
        break label270;
      }
      GMTrace.o(14506520477696L, 108082);
      return null;
      if (((DisplayMetrics)localObject1).density >= 1.5F)
      {
        localObject1 = "" + "HDPI";
        break;
      }
      localObject1 = "" + "MDPI";
      break;
    }
    label270:
    localObject2 = com.tencent.mm.pluginsdk.l.a.a.Mz((String)localObject1);
    if (localObject2 == a.a.sFF)
    {
      GMTrace.o(14506520477696L, 108082);
      return null;
    }
    Object localObject3 = com.tencent.mm.pluginsdk.l.a.a.My((String)localObject1);
    if (u.mz((String)localObject3).length() <= 0)
    {
      GMTrace.o(14506520477696L, 108082);
      return null;
    }
    try
    {
      float f;
      if (localObject2 == a.a.sFD)
      {
        paramMap = paramContext.getAssets().open((String)localObject3);
        f = com.tencent.mm.bg.a.getDensity(paramContext);
        new b();
        paramMap = com.tencent.mm.sdk.platformtools.d.a(paramMap, f);
      }
      while (paramMap == null)
      {
        v.e("MicroMsg.ADListView.Message", "get Bitmap failed type:" + localObject2 + " path:" + (String)localObject3);
        GMTrace.o(14506520477696L, 108082);
        return null;
        f = com.tencent.mm.bg.a.getDensity(paramContext);
        new b();
        localObject1 = com.tencent.mm.sdk.platformtools.d.d((String)localObject3, f);
        paramMap = (Map<String, String>)localObject1;
        if (localObject1 != null)
        {
          ((Bitmap)localObject1).setDensity((int)(160.0F * f));
          paramMap = (Map<String, String>)localObject1;
        }
      }
      localObject1 = paramMap.getNinePatchChunk();
    }
    catch (Exception paramMap)
    {
      v.printErrStackTrace("MicroMsg.ADListView.Message", paramMap, "", new Object[0]);
      GMTrace.o(14506520477696L, 108082);
      return null;
    }
    if ((localObject1 != null) && (NinePatch.isNinePatchChunk((byte[])localObject1)))
    {
      paramMap = new NinePatchDrawable(paramMap, (byte[])localObject1, new Rect(), null);
      GMTrace.o(14506520477696L, 108082);
      return paramMap;
    }
    localObject2 = paramContext.getResources().getDisplayMetrics();
    localObject1 = Bitmap.createScaledBitmap(paramMap, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).widthPixels * paramMap.getHeight() / paramMap.getWidth(), true);
    paramContext = paramMap;
    if (localObject1 != null)
    {
      if (paramMap == localObject1) {
        break label604;
      }
      v.i("MicroMsg.ADListView.Message", "recycle bitmap:%s", new Object[] { paramMap });
      paramMap.recycle();
    }
    for (;;)
    {
      paramMap = new BitmapDrawable(paramContext);
      paramMap.setTargetDensity((DisplayMetrics)localObject2);
      GMTrace.o(14506520477696L, 108082);
      return paramMap;
      label604:
      paramContext = (Context)localObject1;
    }
  }
  
  public final int a(d paramd)
  {
    boolean bool2 = true;
    GMTrace.i(14506386259968L, 108081);
    if (paramd != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramd.wcL == null) {
        break label74;
      }
    }
    Drawable localDrawable;
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      localDrawable = a(this.wcJ.sFB, paramd.wcK.getContext());
      if (localDrawable != null) {
        break label79;
      }
      GMTrace.o(14506386259968L, 108081);
      return -1;
      bool1 = false;
      break;
    }
    label79:
    paramd.wcK.setBackgroundDrawable(localDrawable);
    paramd = paramd.wcL;
    if (this.wcJ.sFw) {}
    for (int i = 0;; i = 8)
    {
      paramd.setVisibility(i);
      GMTrace.o(14506386259968L, 108081);
      return 0;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */