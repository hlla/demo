package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.as.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.protocal.c.amx;
import com.tencent.mm.protocal.c.amy;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.g;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements com.tencent.mm.pluginsdk.b.a
{
  static
  {
    GMTrace.i(419296182272L, 3124);
    b.a(new a(), new String[] { "//fts" });
    GMTrace.o(419296182272L, 3124);
  }
  
  public a()
  {
    GMTrace.i(418893529088L, 3121);
    GMTrace.o(418893529088L, 3121);
  }
  
  public static void init()
  {
    GMTrace.i(419027746816L, 3122);
    GMTrace.o(419027746816L, 3122);
  }
  
  private static void x(Context paramContext, String paramString)
  {
    GMTrace.i(16432544874496L, 122432);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString);
    localTextView.setGravity(19);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(-16711936);
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(R.f.aXs);
    localTextView.setPadding(i, i, i, i);
    g.a(paramContext, null, localTextView, null);
    GMTrace.o(16432544874496L, 122432);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    GMTrace.i(419161964544L, 3123);
    if (!d.In())
    {
      GMTrace.o(419161964544L, 3123);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      GMTrace.o(419161964544L, 3123);
      return true;
    }
    Object localObject1 = paramArrayOfString[1];
    int i = -1;
    switch (((String)localObject1).hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      GMTrace.o(419161964544L, 3123);
      return true;
      if (!((String)localObject1).equals("msbiz")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject1).equals("deletedb")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject1).equals("copydb")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject1).equals("corrupt")) {
        break;
      }
      i = 3;
      break;
      if (!((String)localObject1).equals("clearconfig")) {
        break;
      }
      i = 4;
      break;
      if (!((String)localObject1).equals("info")) {
        break;
      }
      i = 5;
      break;
      if (!((String)localObject1).equals("insert")) {
        break;
      }
      i = 6;
      break;
      localObject1 = com.tencent.mm.as.f.Ir();
      paramArrayOfString = new StringBuilder();
      localObject1 = ((amy)localObject1).jLs.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (amx)((Iterator)localObject1).next();
        paramArrayOfString.append(String.format("%s | %.2f | %s", new Object[] { n.eK(((amx)localObject2).tfa), Double.valueOf(((amx)localObject2).tPT), o.Z("yyyy-MM-dd HH:mm", ((amx)localObject2).tPU / 1000L) }));
        paramArrayOfString.append("\n");
      }
      x(paramContext, paramArrayOfString.toString());
      continue;
      ap.yY();
      c.vr().a(w.a.uGw, Integer.valueOf(0));
      ap.yY();
      paramContext = new File(c.xu(), "FTS5IndexMicroMsg.db");
      if (paramContext.exists()) {
        paramContext.delete();
      }
      Process.killProcess(Process.myPid());
      continue;
      ap.yY();
      paramContext = new File(c.xu(), "FTS5IndexMicroMsg.db");
      paramArrayOfString = new File("/sdcard/IndexMicroMsg.db");
      if (paramArrayOfString.exists()) {
        paramArrayOfString.delete();
      }
      FileOp.p(paramContext.getAbsolutePath(), paramArrayOfString.getAbsolutePath());
      continue;
      paramContext = new com.tencent.mm.plugin.fts.a.a.f();
      paramContext.lYm = 65522;
      ((l)h.j(l.class)).search(10000, paramContext);
      continue;
      paramContext = w.a.uFa;
      paramArrayOfString = w.a.uFb;
      localObject1 = w.a.uFc;
      Object localObject2 = w.a.uFd;
      w.a locala1 = w.a.uFe;
      w.a locala2 = w.a.uFf;
      w.a locala3 = w.a.uFg;
      w.a locala4 = w.a.uFh;
      w.a locala5 = w.a.uFi;
      w.a locala6 = w.a.uFj;
      w.a locala7 = w.a.uFk;
      w.a locala8 = w.a.uFl;
      w.a locala9 = w.a.uFm;
      w.a locala10 = w.a.uFn;
      w.a locala11 = w.a.uFo;
      w.a locala12 = w.a.uFp;
      w.a locala13 = w.a.uFq;
      w.a locala14 = w.a.uFr;
      w.a locala15 = w.a.uFs;
      w.a locala16 = w.a.uFt;
      w.a locala17 = w.a.uFu;
      w.a locala18 = w.a.uFv;
      w.a locala19 = w.a.uFw;
      w.a locala20 = w.a.uFx;
      w.a locala21 = w.a.uFy;
      w.a locala22 = w.a.uFz;
      i = 0;
      while (i < 26)
      {
        w.a locala23 = new w.a[] { paramContext, paramArrayOfString, localObject1, localObject2, locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13, locala14, locala15, locala16, locala17, locala18, locala19, locala20, locala21, locala22 }[i];
        ap.yY();
        c.vr().a(locala23, "");
        i += 1;
      }
      paramArrayOfString = new File(com.tencent.mm.loader.stub.a.hgk, "FTS5IndexMicroMsgInfo.txt");
      if (!paramArrayOfString.exists()) {
        continue;
      }
      try
      {
        x(paramContext, FileOp.aT(paramArrayOfString.getAbsolutePath()));
      }
      catch (IOException paramContext) {}
      continue;
      paramContext = new com.tencent.mm.plugin.fts.a.a.f();
      paramContext.lYm = 65521;
      paramContext.lYp = 100;
      if (paramArrayOfString.length > 2) {}
      try
      {
        paramContext.lYp = Integer.valueOf(paramArrayOfString[2]).intValue();
        ((l)h.j(l.class)).search(10000, paramContext);
      }
      catch (Exception paramArrayOfString)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/console/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */