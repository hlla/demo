package com.tencent.c.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.c.d.a.c;
import com.tencent.c.d.a.e;
import com.tencent.c.d.b.d.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public Context mContext = null;
  public b wOF;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.wOF = new b(paramContext);
  }
  
  public static com.tencent.c.c.b.b a(Context paramContext, com.tencent.c.a.a parama, int paramInt)
  {
    if (parama == null) {
      return null;
    }
    com.tencent.c.c.b.b localb = new com.tencent.c.c.b.b();
    localb.wPo = paramInt;
    localb.wPp = null;
    localb.wPq = parama.fwG;
    Object localObject = parama.wOC;
    if (localObject == null)
    {
      localObject = null;
      localb.wPr = ((byte[])localObject);
      paramContext = com.tencent.c.e.a.bs(paramContext, parama.fwG);
      if (paramContext.size() > 1)
      {
        localb.wPG = new ArrayList();
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          localObject = (byte[])paramContext.next();
          localb.wPG.add(localObject);
        }
      }
    }
    else
    {
      int i = ((String)localObject).length() / 2;
      byte[] arrayOfByte = new byte[i];
      char[] arrayOfChar = ((String)localObject).toCharArray();
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfByte;
        if (paramInt >= i) {
          break;
        }
        int j = paramInt * 2;
        int k = (byte)"0123456789ABCDEF".indexOf(arrayOfChar[j]);
        arrayOfByte[paramInt] = ((byte)((byte)"0123456789ABCDEF".indexOf(arrayOfChar[(j + 1)]) | k << 4));
        paramInt += 1;
      }
    }
    localb.wPs = parama.fileSize;
    localb.wPt = parama.wOB;
    localb.wPu = parama.versionCode;
    localb.wPv = parama.versionName;
    localb.wPw = 0;
    if (parama.mnt == 1) {
      localb.wPw |= 0x1;
    }
    localb.wPw |= 0x2;
    if ((!parama.wOD.startsWith("/data")) && (!parama.wOD.startsWith("/system"))) {
      localb.wPw |= 0x4;
    }
    localb.wPx = com.tencent.c.e.a.Vc(parama.wOD);
    localb.wPy = 0;
    localb.wPz = 0;
    localb.wPA = 0;
    localb.wPB = null;
    localb.wPC = 0;
    localb.wPD = false;
    localb.wPE = 0;
    localb.wPF = 0;
    return localb;
  }
  
  public static com.tencent.c.c.b.d cdu()
  {
    com.tencent.c.c.b.d locald = new com.tencent.c.c.b.d();
    for (;;)
    {
      int i;
      try
      {
        locald.wPW = Build.FINGERPRINT;
        locald.wPX = com.tencent.c.e.d.cdC();
        locald.hvM = Build.BRAND;
        locald.model = Build.MODEL;
        locald.wPY = Build.VERSION.SDK_INT;
        locald.wPZ = Build.CPU_ABI;
        locald.platform = com.tencent.c.e.d.Vd("ro.board.platform");
        if (com.tencent.c.d.a.f.cdy())
        {
          i = 2;
          locald.cze = i;
          return locald;
        }
        Object localObject2 = com.tencent.c.d.b.d.cdz();
        if (!((Collection)localObject2).isEmpty()) {
          break label358;
        }
        i = 1;
        if (i != 0) {
          break label372;
        }
        Object localObject1 = new ArrayList(3);
        ((List)localObject1).add(new com.tencent.c.d.a.g());
        ((List)localObject1).add(new com.tencent.c.d.a.d());
        if (com.tencent.c.d.b.f.cdA()) {
          ((List)localObject1).add(new c());
        }
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          d.a locala = (d.a)((Iterator)localObject2).next();
          if (locala == null) {
            continue;
          }
          Iterator localIterator = ((List)localObject1).iterator();
          if (localIterator.hasNext())
          {
            ((com.tencent.c.d.a.b)localIterator.next()).a(locala);
            continue;
          }
          continue;
        }
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label372;
        }
        if (!((com.tencent.c.d.a.b)((Iterator)localObject1).next()).cdw()) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        return locald;
      }
      if (e.cdx())
      {
        i = 1;
      }
      else
      {
        if (!com.tencent.c.d.a.a.UY("/system/bin/debuggerd"))
        {
          i = 1;
        }
        else if (!com.tencent.c.d.a.a.UY("/system/bin/debuggerd64"))
        {
          i = 1;
        }
        else if (!com.tencent.c.d.a.a.UY("/system/bin/ddexe"))
        {
          i = 1;
        }
        else if (!com.tencent.c.d.a.a.UZ("/system/etc/install-recovery.sh"))
        {
          i = 1;
        }
        else if (!com.tencent.c.d.a.a.UZ("/system/bin/install-recovery.sh"))
        {
          i = 1;
        }
        else
        {
          com.tencent.c.e.g.Ve("BootScriptChecker : everything seems ok");
          i = 0;
          break label377;
          i = 0;
          continue;
          label358:
          i = 0;
          continue;
          for (;;)
          {
            if (i == 0) {
              break label375;
            }
            i = 2;
            break;
            label372:
            i = 0;
          }
          label375:
          continue;
        }
        label377:
        if (i != 0) {
          i = 1;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */