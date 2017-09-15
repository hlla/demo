package com.tencent.mm.q;

import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public final class b
{
  SparseArray<a> gUM;
  HashMap<w.a, a> gUN;
  SparseArray<b> gUO;
  HashMap<w.a, b> gUP;
  private Random gUQ;
  t gUR;
  
  public b()
  {
    GMTrace.i(14594701524992L, 108739);
    this.gUM = new SparseArray();
    this.gUN = new HashMap();
    this.gUO = new SparseArray();
    this.gUP = new HashMap();
    this.gUQ = new Random();
    this.gUR = null;
    GMTrace.o(14594701524992L, 108739);
  }
  
  private a b(w.a parama)
  {
    GMTrace.i(14595506831360L, 108745);
    String str = (String)this.gUR.get(parama, null);
    if (str == null)
    {
      GMTrace.o(14595506831360L, 108745);
      return null;
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length != 3)
    {
      v.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[] { str });
      GMTrace.o(14595506831360L, 108745);
      return null;
    }
    try
    {
      parama = a(parama, Integer.valueOf(arrayOfString[0]).intValue(), unescape(arrayOfString[1]), unescape(arrayOfString[2]));
      GMTrace.o(14595506831360L, 108745);
      return parama;
    }
    catch (Exception parama)
    {
      v.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bf.g(parama) });
      v.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[] { str });
      GMTrace.o(14595506831360L, 108745);
    }
    return null;
  }
  
  private b c(w.a parama)
  {
    GMTrace.i(14595775266816L, 108747);
    String str = (String)this.gUR.get(parama, null);
    if (str == null)
    {
      parama = d(parama);
      GMTrace.o(14595775266816L, 108747);
      return parama;
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length % 2 != 0)
    {
      v.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[] { str });
      GMTrace.o(14595775266816L, 108747);
      return null;
    }
    try
    {
      parama = d(parama);
      int i = 0;
      while (i < arrayOfString.length)
      {
        parama.gUV.put(arrayOfString[i], unescape(arrayOfString[(i + 1)]));
        i += 2;
      }
      GMTrace.o(14595775266816L, 108747);
      return parama;
    }
    catch (Exception parama)
    {
      v.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bf.g(parama) });
      v.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[] { str });
      GMTrace.o(14595775266816L, 108747);
    }
    return null;
  }
  
  private static String dP(String paramString)
  {
    GMTrace.i(14594835742720L, 108740);
    paramString = paramString.replaceAll("\\|", "%7C");
    GMTrace.o(14594835742720L, 108740);
    return paramString;
  }
  
  private a eG(int paramInt)
  {
    GMTrace.i(14595372613632L, 108744);
    String str = (String)this.gUR.get(paramInt, null);
    if (str == null)
    {
      GMTrace.o(14595372613632L, 108744);
      return null;
    }
    Object localObject = str.split("\\|");
    if (localObject.length != 3)
    {
      v.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[] { str });
      GMTrace.o(14595372613632L, 108744);
      return null;
    }
    try
    {
      localObject = a(paramInt, Integer.valueOf(localObject[0]).intValue(), unescape(localObject[1]), unescape(localObject[2]));
      GMTrace.o(14595372613632L, 108744);
      return (a)localObject;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bf.g(localException) });
      v.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[] { str });
      GMTrace.o(14595372613632L, 108744);
    }
    return null;
  }
  
  private b eH(int paramInt)
  {
    GMTrace.i(14595641049088L, 108746);
    Object localObject = (String)this.gUR.get(paramInt, null);
    if (localObject == null)
    {
      localObject = eI(paramInt);
      GMTrace.o(14595641049088L, 108746);
      return (b)localObject;
    }
    String[] arrayOfString = ((String)localObject).split("\\|");
    if (arrayOfString.length % 2 != 0)
    {
      v.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[] { localObject });
      GMTrace.o(14595641049088L, 108746);
      return null;
    }
    try
    {
      b localb = eI(paramInt);
      paramInt = 0;
      while (paramInt < arrayOfString.length)
      {
        localb.gUU.put(Integer.valueOf(arrayOfString[paramInt]).intValue(), unescape(arrayOfString[(paramInt + 1)]));
        paramInt += 2;
      }
      GMTrace.o(14595641049088L, 108746);
      return localb;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bf.g(localException) });
      v.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[] { localObject });
      GMTrace.o(14595641049088L, 108746);
    }
    return null;
  }
  
  private static String unescape(String paramString)
  {
    GMTrace.i(14594969960448L, 108741);
    paramString = paramString.replaceAll("%7C", "|");
    GMTrace.o(14594969960448L, 108741);
    return paramString;
  }
  
  final a a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    GMTrace.i(14596312137728L, 108751);
    a locala = new a();
    locala.gUI = paramInt1;
    locala.type = paramInt2;
    locala.value = paramString1;
    locala.fGM = paramString2;
    GMTrace.o(14596312137728L, 108751);
    return locala;
  }
  
  final a a(w.a parama, int paramInt, String paramString1, String paramString2)
  {
    GMTrace.i(14596446355456L, 108752);
    a locala = new a();
    locala.gUJ = parama;
    locala.type = paramInt;
    locala.value = paramString1;
    locala.fGM = paramString2;
    GMTrace.o(14596446355456L, 108752);
    return locala;
  }
  
  public final a a(w.a parama1, w.a parama2, int paramInt)
  {
    GMTrace.i(16744735309824L, 124758);
    v.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", new Object[] { parama1, parama2, Integer.valueOf(paramInt) });
    a locala = e(parama1);
    if (locala == null)
    {
      v.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      GMTrace.o(16744735309824L, 124758);
      return null;
    }
    if ((locala.type & paramInt) == 0)
    {
      v.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
      GMTrace.o(16744735309824L, 124758);
      return null;
    }
    parama2 = f(parama2);
    if (parama2 != null)
    {
      String str = (String)parama2.gUV.get(parama1.name());
      if ((str != null) && (str.equals(locala.fGM)))
      {
        GMTrace.o(16744735309824L, 124758);
        return null;
      }
      if (str == null)
      {
        str = uj();
        parama2.gUV.put(parama1.name(), str);
        a(parama2);
      }
      GMTrace.o(16744735309824L, 124758);
      return locala;
    }
    v.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
    GMTrace.o(16744735309824L, 124758);
    return null;
  }
  
  final void a(a parama)
  {
    GMTrace.i(14595104178176L, 108742);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(parama.type);
    localStringBuffer.append("|");
    localStringBuffer.append(dP(parama.value));
    localStringBuffer.append("|");
    localStringBuffer.append(dP(parama.fGM));
    if (parama.gUJ != null)
    {
      this.gUR.a(parama.gUJ, localStringBuffer.toString());
      GMTrace.o(14595104178176L, 108742);
      return;
    }
    this.gUR.set(parama.gUI, localStringBuffer.toString());
    GMTrace.o(14595104178176L, 108742);
  }
  
  final void a(b paramb)
  {
    GMTrace.i(14595238395904L, 108743);
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1;
    if (paramb.gUL != null)
    {
      localObject1 = paramb.gUV.entrySet().iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (String)((Map.Entry)localObject2).getValue();
        if (i != 0) {
          localStringBuffer.append("|");
        }
        localStringBuffer.append(str);
        localStringBuffer.append("|");
        localStringBuffer.append(dP((String)localObject2));
        i += 1;
      }
      this.gUR.a(paramb.gUL, localStringBuffer.toString());
      GMTrace.o(14595238395904L, 108743);
      return;
    }
    int i = 0;
    while (i < paramb.gUU.size())
    {
      int j = paramb.gUU.keyAt(i);
      localObject1 = (String)paramb.gUU.get(j);
      if (i != 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append(j);
      localStringBuffer.append("|");
      localStringBuffer.append(dP((String)localObject1));
      i += 1;
    }
    this.gUR.set(paramb.gUT, localStringBuffer.toString());
    GMTrace.o(14595238395904L, 108743);
  }
  
  final b d(w.a parama)
  {
    GMTrace.i(14596177920000L, 108750);
    b localb = new b();
    localb.gUL = parama;
    GMTrace.o(14596177920000L, 108750);
    return localb;
  }
  
  public final a e(w.a parama)
  {
    GMTrace.i(14596714790912L, 108754);
    a locala2 = (a)this.gUN.get(parama);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = b(parama);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.gUN.put(parama, locala2);
        locala1 = locala2;
      }
    }
    GMTrace.o(14596714790912L, 108754);
    return locala1;
  }
  
  final b eI(int paramInt)
  {
    GMTrace.i(14596043702272L, 108749);
    b localb = new b();
    localb.gUT = paramInt;
    GMTrace.o(14596043702272L, 108749);
    return localb;
  }
  
  public final a eJ(int paramInt)
  {
    GMTrace.i(14596580573184L, 108753);
    a locala2 = (a)this.gUM.get(paramInt);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = eG(paramInt);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.gUM.put(paramInt, locala2);
        locala1 = locala2;
      }
    }
    GMTrace.o(14596580573184L, 108753);
    return locala1;
  }
  
  final b eK(int paramInt)
  {
    GMTrace.i(14596849008640L, 108755);
    b localb2 = (b)this.gUO.get(paramInt);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = eH(paramInt);
      if (localb1 == null)
      {
        v.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
        GMTrace.o(14596849008640L, 108755);
        return null;
      }
      this.gUO.put(paramInt, localb1);
    }
    GMTrace.o(14596849008640L, 108755);
    return localb1;
  }
  
  final b f(w.a parama)
  {
    GMTrace.i(16744601092096L, 124757);
    b localb2 = (b)this.gUP.get(parama);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = c(parama);
      if (localb1 == null)
      {
        v.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
        GMTrace.o(16744601092096L, 124757);
        return null;
      }
      this.gUP.put(parama, localb1);
    }
    GMTrace.o(16744601092096L, 124757);
    return localb1;
  }
  
  public final a p(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(14596983226368L, 108756);
    v.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    a locala = eJ(paramInt1);
    if (locala == null)
    {
      v.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      GMTrace.o(14596983226368L, 108756);
      return null;
    }
    if ((locala.type & paramInt3) == 0)
    {
      v.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
      GMTrace.o(14596983226368L, 108756);
      return null;
    }
    b localb = eK(paramInt2);
    if (localb != null)
    {
      String str = (String)localb.gUU.get(paramInt1);
      if ((str != null) && (str.equals(locala.fGM)))
      {
        GMTrace.o(14596983226368L, 108756);
        return null;
      }
      if (str == null)
      {
        str = uj();
        localb.gUU.put(paramInt1, str);
        a(localb);
      }
      GMTrace.o(14596983226368L, 108756);
      return locala;
    }
    v.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
    GMTrace.o(14596983226368L, 108756);
    return null;
  }
  
  final String uj()
  {
    GMTrace.i(14595909484544L, 108748);
    String str = String.format("%d%04d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.gUQ.nextInt(Math.abs(this.gUQ.nextInt(Integer.MAX_VALUE))) % 10000) });
    GMTrace.o(14595909484544L, 108748);
    return str;
  }
  
  public final class a
  {
    String fGM;
    int gUI;
    w.a gUJ;
    int type;
    public String value;
    
    public a()
    {
      GMTrace.i(14594030436352L, 108734);
      GMTrace.o(14594030436352L, 108734);
    }
  }
  
  public final class b
  {
    w.a gUL;
    int gUT;
    SparseArray<String> gUU;
    HashMap<String, String> gUV;
    
    public b()
    {
      GMTrace.i(14593493565440L, 108730);
      this.gUU = new SparseArray();
      this.gUV = new HashMap();
      GMTrace.o(14593493565440L, 108730);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/q/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */