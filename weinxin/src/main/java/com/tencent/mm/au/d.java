package com.tencent.mm.au;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class d
  implements com.tencent.mm.y.e
{
  public static int chatType;
  private static d hTy;
  public static final f<Integer, a> hjT;
  private int hNz;
  public boolean hpu;
  
  static
  {
    GMTrace.i(3500800999424L, 26083);
    hjT = new f(5);
    chatType = 0;
    GMTrace.o(3500800999424L, 26083);
  }
  
  public d()
  {
    GMTrace.i(3499861475328L, 26076);
    this.hpu = false;
    this.hNz = 3;
    GMTrace.o(3499861475328L, 26076);
  }
  
  public static d JL()
  {
    GMTrace.i(3499995693056L, 26077);
    if (hTy == null) {
      hTy = new d();
    }
    d locald = hTy;
    GMTrace.o(3499995693056L, 26077);
    return locald;
  }
  
  public static void JM()
  {
    GMTrace.i(3500398346240L, 26080);
    h.vJ();
    h.vI().vr().set(16646145, Integer.valueOf(0));
    GMTrace.o(3500398346240L, 26080);
  }
  
  public static void JN()
  {
    GMTrace.i(3500532563968L, 26081);
    h.vJ();
    Integer localInteger2 = Integer.valueOf(bf.f((Integer)h.vI().vr().get(16646145, null)));
    Integer localInteger1 = localInteger2;
    if (localInteger2.intValue() < 0) {
      localInteger1 = Integer.valueOf(0);
    }
    h.vJ();
    h.vI().vr().set(16646145, Integer.valueOf(localInteger1.intValue() + 1));
    GMTrace.o(3500532563968L, 26081);
  }
  
  public static String getPrefix()
  {
    GMTrace.i(3499593039872L, 26074);
    switch (chatType)
    {
    default: 
      GMTrace.o(3499593039872L, 26074);
      return "single_";
    case 0: 
      GMTrace.o(3499593039872L, 26074);
      return "single_";
    case 1: 
      GMTrace.o(3499593039872L, 26074);
      return "chatroom_";
    }
    GMTrace.o(3499593039872L, 26074);
    return "app_";
  }
  
  public static int kO(String paramString)
  {
    int i = 5;
    GMTrace.i(3499727257600L, 26075);
    if ((paramString == null) || (paramString.length() == 0))
    {
      GMTrace.o(3499727257600L, 26075);
      return 5;
    }
    if ((!paramString.startsWith("single")) || (paramString.startsWith("chatroom"))) {
      i = 7;
    }
    if (paramString.startsWith("app")) {
      i = 8;
    }
    v.d("upload", "type " + i);
    GMTrace.o(3499727257600L, 26075);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(3500264128512L, 26079);
    if ((!(paramk instanceof com.tencent.mm.y.m)) || (((com.tencent.mm.y.m)paramk).BQ() != 9))
    {
      v.d("upload", "another scene");
      GMTrace.o(3500264128512L, 26079);
      return;
    }
    if (paramk.getType() == 159)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label103;
      }
      h.vJ();
      h.vI().vr().set(81944, Long.valueOf(bf.Nz()));
    }
    for (;;)
    {
      release();
      GMTrace.o(3500264128512L, 26079);
      return;
      label103:
      paramInt1 = this.hNz - 1;
      this.hNz = paramInt1;
      if (paramInt1 < 0)
      {
        h.vJ();
        h.vI().vr().set(81944, Long.valueOf((bf.NA() - 86400000L + 3600000L) / 1000L));
        this.hNz = 3;
      }
    }
  }
  
  public final void release()
  {
    GMTrace.i(3500129910784L, 26078);
    this.hpu = false;
    h.vd().b(159, this);
    GMTrace.o(3500129910784L, 26078);
  }
  
  public static final class a
  {
    public int gkh;
    public int hTA;
    public int hTB;
    public int hTC;
    public int hTD;
    public int hTE;
    public int hTF;
    public int hTG;
    public int hTH;
    public int hTI;
    public Random hTJ;
    public List<String> hTK;
    public String hTz;
    
    public a()
    {
      GMTrace.i(3500935217152L, 26084);
      this.hTz = "BeiJing;GuangZhou;ShangHai;";
      this.gkh = 0;
      this.hTA = 0;
      this.hTB = 2;
      this.hTC = 2;
      this.hTD = 2;
      this.hTE = 10240;
      this.hTF = 10240000;
      this.hTG = 100;
      this.hTH = 100;
      this.hTI = 100;
      this.hTJ = new Random();
      this.hTK = null;
      GMTrace.o(3500935217152L, 26084);
    }
    
    public static a JR()
    {
      GMTrace.i(3501472088064L, 26088);
      v.d("upload", "parseFromFile");
      Object localObject1 = com.tencent.mm.ap.t.Id();
      localObject1 = com.tencent.mm.ap.n.HZ() + ((com.tencent.mm.ap.n)localObject1).aS(1, 9);
      int i = com.tencent.mm.a.e.aN((String)localObject1);
      if (i == -1)
      {
        v.e("upload", "read file failed " + i + (String)localObject1);
        GMTrace.o(3501472088064L, 26088);
        return null;
      }
      Object localObject3 = com.tencent.mm.a.e.c((String)localObject1, 0, i);
      if (localObject3 == null)
      {
        v.e("upload", "read file failed " + i + (String)localObject1);
        GMTrace.o(3501472088064L, 26088);
        return null;
      }
      localObject1 = new String((byte[])localObject3);
      if (bf.mA((String)localObject1))
      {
        GMTrace.o(3501472088064L, 26088);
        return null;
      }
      i = ((String)localObject1).indexOf('<');
      int k;
      if (i > 0)
      {
        localObject1 = ((String)localObject1).substring(i);
        k = ((String)localObject1).hashCode();
        localObject3 = (a)d.hjT.get(Integer.valueOf(k));
        if (localObject3 != null)
        {
          GMTrace.o(3501472088064L, 26088);
          return (a)localObject3;
        }
        localObject3 = bg.q((String)localObject1, "Config");
        if (localObject3 == null)
        {
          v.e("upload", "parse msg failed");
          GMTrace.o(3501472088064L, 26088);
          return null;
        }
      }
      for (;;)
      {
        a locala;
        StringBuilder localStringBuilder;
        int j;
        try
        {
          locala = new a();
          i = 0;
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0)
          {
            localObject1 = "";
            localObject1 = (String)((Map)localObject3).get(localObject1 + ".$key");
            v.d("upload", "key " + (String)localObject1);
            if (localObject1 == null) {
              break label1183;
            }
            if (!((String)localObject1).equals("region")) {
              continue;
            }
            localStringBuilder = new StringBuilder(".Config.Item");
            if (i == 0)
            {
              localObject1 = "";
              locala.hTz = ((String)((Map)localObject3).get(localObject1));
              if ((locala.hTz == null) || (locala.hTz.length() <= 0)) {
                break label1503;
              }
              localObject1 = locala.hTz.split(";");
              locala.hTK = new ArrayList();
              if ((localObject1 == null) || (localObject1.length <= 0)) {
                break label1503;
              }
              j = 0;
              if (j >= localObject1.length) {
                break label1503;
              }
              if ((localObject1[j] == null) || (localObject1[j].length() <= 0)) {
                break label1496;
              }
              locala.hTK.add(localObject1[j]);
              break label1496;
            }
          }
          else
          {
            localObject1 = Integer.valueOf(i);
            continue;
          }
          localObject1 = Integer.valueOf(i);
          continue;
          if (((String)localObject1).equals("sex"))
          {
            localStringBuilder = new StringBuilder(".Config.Item");
            if (i == 0)
            {
              localObject1 = "";
              locala.gkh = bf.getInt((String)((Map)localObject3).get(localObject1), 0);
            }
            else
            {
              localObject1 = Integer.valueOf(i);
              continue;
            }
          }
          else if (((String)localObject1).equals("rate"))
          {
            localStringBuilder = new StringBuilder(".Config.Item");
            if (i == 0)
            {
              localObject1 = "";
              locala.hTA = bf.getInt((String)((Map)localObject3).get(localObject1), 0);
            }
          }
        }
        catch (Exception localException)
        {
          v.e("upload", "exception:%s", new Object[] { bf.g(localException) });
          GMTrace.o(3501472088064L, 26088);
          return null;
        }
        Object localObject2 = Integer.valueOf(i);
        continue;
        if (((String)localObject2).equals("minsize"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.hTE = bf.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("maxsize"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.hTF = bf.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.hTG = bf.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.hTH = bf.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.hTI = bf.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.hTB = bf.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.hTC = bf.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.hTD = bf.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
          label1183:
          v.d("upload", "sex " + locala.gkh);
          v.d("upload", "rate_single " + locala.hTB);
          v.d("upload", "rate_chatroom " + locala.hTC);
          v.d("upload", "rate_app " + locala.hTD);
          v.d("upload", "rate " + locala.hTA);
          v.d("upload", "minsize " + locala.hTE);
          v.d("upload", "maxsize " + locala.hTF);
          v.d("upload", "daycount_single " + locala.hTG);
          v.d("upload", "daycount_chatroom " + locala.hTH);
          v.d("upload", "daycount_app " + locala.hTI);
          v.d("upload", "region " + locala.hTz);
          d.hjT.k(Integer.valueOf(k), locala);
          GMTrace.o(3501472088064L, 26088);
          return locala;
          break;
          label1496:
          j += 1;
          continue;
        }
        label1503:
        i += 1;
      }
    }
    
    public final boolean JO()
    {
      GMTrace.i(3501069434880L, 26085);
      Object localObject2 = com.tencent.mm.u.m.yr();
      Object localObject1;
      int i;
      if ("  getRegionCode " + localObject2 != null)
      {
        localObject1 = ((af)localObject2).gkx;
        v.d("upload", (String)localObject1);
        localObject1 = ((af)localObject2).gkx;
        if ((localObject1 != null) && (((String)localObject1).length() > 0) && (this.hTK != null) && (this.hTK.size() > 0))
        {
          localObject1 = ((String)localObject1).split("_");
          if ((localObject1 != null) && (localObject1.length > 0)) {
            i = 0;
          }
        }
      }
      else
      {
        for (;;)
        {
          if (i >= localObject1.length) {
            break label200;
          }
          if ((localObject1[i] != null) && (localObject1[i].length() > 0))
          {
            localObject2 = this.hTK.iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext()) {
                if (((String)((Iterator)localObject2).next()).trim().toLowerCase().equals(localObject1[i].trim().toLowerCase()))
                {
                  v.d("upload", "isInRegion");
                  GMTrace.o(3501069434880L, 26085);
                  return true;
                  localObject1 = "";
                  break;
                }
              }
            }
          }
          i += 1;
        }
      }
      label200:
      GMTrace.o(3501069434880L, 26085);
      return false;
    }
    
    public final int JP()
    {
      GMTrace.i(3501203652608L, 26086);
      switch (d.chatType)
      {
      default: 
        i = this.hTB;
        GMTrace.o(3501203652608L, 26086);
        return i;
      case 0: 
        i = this.hTB;
        GMTrace.o(3501203652608L, 26086);
        return i;
      case 1: 
        i = this.hTC;
        GMTrace.o(3501203652608L, 26086);
        return i;
      }
      int i = this.hTD;
      GMTrace.o(3501203652608L, 26086);
      return i;
    }
    
    public final int JQ()
    {
      GMTrace.i(3501337870336L, 26087);
      switch (d.chatType)
      {
      default: 
        i = this.hTG;
        GMTrace.o(3501337870336L, 26087);
        return i;
      case 0: 
        i = this.hTG;
        GMTrace.o(3501337870336L, 26087);
        return i;
      case 1: 
        i = this.hTH;
        GMTrace.o(3501337870336L, 26087);
        return i;
      }
      int i = this.hTI;
      GMTrace.o(3501337870336L, 26087);
      return i;
    }
  }
  
  public static final class b
  {
    public String hQT;
    public int hTq;
    public int hTr;
    public int sampleRate;
    
    public b()
    {
      GMTrace.i(3499458822144L, 26073);
      this.hQT = "";
      this.sampleRate = 0;
      this.hTq = 0;
      this.hTr = 0;
      GMTrace.o(3499458822144L, 26073);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/au/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */