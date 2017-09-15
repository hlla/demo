package com.tencent.mm.bi;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.gy;
import com.tencent.mm.e.a.gy.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.m.a.a;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.s;
import java.util.ArrayList;

public class e
{
  private static e uwI;
  private String[] uwJ;
  private String[] uwK;
  private String[] uwL;
  private ArrayList<com.tencent.mm.storage.a.u> uwM;
  private SparseArray<com.tencent.mm.storage.a.u> uwN;
  
  static
  {
    GMTrace.i(4516694982656L, 33652);
    uwI = null;
    GMTrace.o(4516694982656L, 33652);
  }
  
  public e(Context paramContext)
  {
    GMTrace.i(4515487023104L, 33643);
    this.uwM = new ArrayList();
    this.uwN = new SparseArray();
    this.uwJ = paramContext.getResources().getStringArray(a.a.aSi);
    this.uwK = paramContext.getResources().getStringArray(a.a.aSj);
    this.uwL = paramContext.getResources().getStringArray(a.a.aSk);
    this.uwM.clear();
    this.uwN.clear();
    bKs();
    GMTrace.o(4515487023104L, 33643);
  }
  
  private void bKs()
  {
    int k = 0;
    GMTrace.i(4515621240832L, 33644);
    if ((this.uwJ != null) && (this.uwK != null))
    {
      int m = this.uwJ.length;
      int j = 0;
      int i = 0;
      com.tencent.mm.storage.a.u localu;
      while (j < m)
      {
        localu = new com.tencent.mm.storage.a.u(i, this.uwJ[j]);
        this.uwM.add(localu);
        this.uwN.put(i, localu);
        j += 1;
        i += 1;
      }
      m = this.uwK.length;
      j = k;
      while (j < m)
      {
        localu = new com.tencent.mm.storage.a.u(i, this.uwK[j]);
        this.uwM.add(localu);
        this.uwN.put(i, localu);
        j += 1;
        i += 1;
      }
    }
    GMTrace.o(4515621240832L, 33644);
  }
  
  public static e bKt()
  {
    GMTrace.i(4516023894016L, 33647);
    if (uwI == null) {}
    try
    {
      uwI = new e(aa.getContext());
      e locale = uwI;
      GMTrace.o(4516023894016L, 33647);
      return locale;
    }
    finally {}
  }
  
  public void YS()
  {
    GMTrace.i(4515755458560L, 33645);
    v.d("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo");
    this.uwM.clear();
    ArrayList localArrayList1 = ((PluginEmoji)h.j(PluginEmoji.class)).getEmojiMgr().alz();
    if ((localArrayList1 != null) && (!localArrayList1.isEmpty()))
    {
      ArrayList localArrayList2 = ((PluginEmoji)h.j(PluginEmoji.class)).getEmojiMgr().aly();
      int k = localArrayList1.size();
      int j = 0;
      int i = 0;
      if (j < k)
      {
        com.tencent.mm.storage.a.u localu = (com.tencent.mm.storage.a.u)localArrayList1.get(j);
        String str = localu.field_key;
        if ((str.startsWith("[")) && (!localArrayList2.contains(str))) {
          v.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", new Object[] { str });
        }
        for (;;)
        {
          j += 1;
          break;
          this.uwM.add(localu);
          this.uwN.put(i, localu);
          i += 1;
        }
      }
      GMTrace.o(4515755458560L, 33645);
      return;
    }
    bKs();
    GMTrace.o(4515755458560L, 33645);
  }
  
  public int YT()
  {
    GMTrace.i(4515889676288L, 33646);
    if (this.uwM == null)
    {
      GMTrace.o(4515889676288L, 33646);
      return 0;
    }
    int i = this.uwM.size();
    GMTrace.o(4515889676288L, 33646);
    return i;
  }
  
  public String getText(int paramInt)
  {
    GMTrace.i(4516292329472L, 33649);
    if (paramInt < 0)
    {
      v.w("MicroMsg.MergerSmileyManager", "get text, error index");
      GMTrace.o(4516292329472L, 33649);
      return "";
    }
    Object localObject = (com.tencent.mm.storage.a.u)this.uwM.get(paramInt);
    if (localObject != null)
    {
      s locals = f.bKu().QA(((com.tencent.mm.storage.a.u)localObject).field_key);
      if (locals != null)
      {
        if ((com.tencent.mm.sdk.platformtools.u.bIA()) && (!bf.mA(locals.field_cnValue)))
        {
          localObject = locals.field_cnValue;
          GMTrace.o(4516292329472L, 33649);
          return (String)localObject;
        }
        if ((com.tencent.mm.sdk.platformtools.u.bIB()) && (!bf.mA(locals.field_twValue)))
        {
          localObject = locals.field_twValue;
          GMTrace.o(4516292329472L, 33649);
          return (String)localObject;
        }
      }
      localObject = ((com.tencent.mm.storage.a.u)localObject).field_key;
      GMTrace.o(4516292329472L, 33649);
      return (String)localObject;
    }
    GMTrace.o(4516292329472L, 33649);
    return "";
  }
  
  public Drawable iL(int paramInt)
  {
    GMTrace.i(4516158111744L, 33648);
    if (this.uwN == null)
    {
      v.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
      GMTrace.o(4516158111744L, 33648);
      return null;
    }
    Object localObject1 = (com.tencent.mm.storage.a.u)this.uwN.get(paramInt);
    if (localObject1 == null)
    {
      v.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
      GMTrace.o(4516158111744L, 33648);
      return null;
    }
    Object localObject2 = f.bKu().QA(((com.tencent.mm.storage.a.u)localObject1).field_key);
    if (localObject2 != null)
    {
      f.bKu();
      paramInt = ((s)localObject2).field_position;
      if (paramInt >= 0) {}
      for (localObject1 = b.bKo().iL(paramInt);; localObject1 = f.Qz(((s)localObject2).field_fileName))
      {
        GMTrace.o(4516158111744L, 33648);
        return (Drawable)localObject1;
      }
    }
    localObject2 = b.bKo();
    localObject1 = ((com.tencent.mm.storage.a.u)localObject1).field_key;
    if (bf.mA((String)localObject1))
    {
      v.i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
      localObject1 = null;
    }
    for (;;)
    {
      localObject1 = b.bKo().a((c)localObject1);
      break;
      paramInt = ((String)localObject1).codePointAt(0);
      if (((b)localObject2).yu(paramInt) != null) {
        localObject1 = ((b)localObject2).yu(paramInt);
      } else {
        localObject1 = ((b)localObject2).dO(paramInt, 0);
      }
    }
  }
  
  public String iM(int paramInt)
  {
    GMTrace.i(4516560764928L, 33651);
    if (paramInt < 0)
    {
      v.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
      GMTrace.o(4516560764928L, 33651);
      return "";
    }
    Object localObject1 = new gy();
    a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
    if (((gy)localObject1).fMe.fFP == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      Object localObject2 = bKt().uwK[paramInt].split(" ");
      localObject1 = Character.toChars(Integer.decode(localObject2[0]).intValue());
      localObject2 = Character.toChars(Integer.decode(localObject2[1]).intValue());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((char[])localObject1);
      localStringBuilder.append((char[])localObject2);
      localObject1 = localStringBuilder.toString();
      GMTrace.o(4516560764928L, 33651);
      return (String)localObject1;
    }
    localObject1 = bKt().uwK[paramInt];
    GMTrace.o(4516560764928L, 33651);
    return (String)localObject1;
  }
  
  public String iN(int paramInt)
  {
    GMTrace.i(4516426547200L, 33650);
    if (paramInt < 0)
    {
      v.w("MicroMsg.MergerSmileyManager", "get text, error index");
      GMTrace.o(4516426547200L, 33650);
      return "";
    }
    Object localObject = (com.tencent.mm.storage.a.u)this.uwM.get(paramInt);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.storage.a.u)localObject).field_key;
      GMTrace.o(4516426547200L, 33650);
      return (String)localObject;
    }
    GMTrace.o(4516426547200L, 33650);
    return "";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bi/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */