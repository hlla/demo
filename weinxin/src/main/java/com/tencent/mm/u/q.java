package com.tencent.mm.u;

import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class q
{
  private static q hli;
  private Map<String, c> hlj;
  
  private q()
  {
    GMTrace.i(639950127104L, 4768);
    this.hlj = new a((byte)0);
    GMTrace.o(639950127104L, 4768);
  }
  
  public static String fQ(String paramString)
  {
    GMTrace.i(640486998016L, 4772);
    paramString = "SessionId@" + paramString + "#" + System.nanoTime();
    GMTrace.o(640486998016L, 4772);
    return paramString;
  }
  
  public static q yC()
  {
    GMTrace.i(639815909376L, 4767);
    if (hli == null) {}
    try
    {
      if (hli == null) {
        hli = new q();
      }
      q localq = hli;
      GMTrace.o(639815909376L, 4767);
      return localq;
    }
    finally {}
  }
  
  public final b fO(String paramString)
  {
    GMTrace.i(640084344832L, 4769);
    paramString = (c)this.hlj.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.hll;
      GMTrace.o(640084344832L, 4769);
      return paramString;
    }
    GMTrace.o(640084344832L, 4769);
    return null;
  }
  
  public final b fP(String paramString)
  {
    GMTrace.i(640352780288L, 4771);
    paramString = (c)this.hlj.remove(paramString);
    if (paramString != null)
    {
      paramString = paramString.hll;
      GMTrace.o(640352780288L, 4771);
      return paramString;
    }
    GMTrace.o(640352780288L, 4771);
    return null;
  }
  
  public final b n(String paramString, boolean paramBoolean)
  {
    GMTrace.i(640218562560L, 4770);
    c localc2 = (c)this.hlj.get(paramString);
    c localc1 = localc2;
    if (localc2 == null)
    {
      if (!paramBoolean)
      {
        GMTrace.o(640218562560L, 4770);
        return null;
      }
      localc1 = new c();
      this.hlj.put(paramString, localc1);
    }
    paramString = localc1.hll;
    GMTrace.o(640218562560L, 4770);
    return paramString;
  }
  
  public String toString()
  {
    GMTrace.i(18978789392384L, 141403);
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DataCenter \nDataStore size : ").append(this.hlj.size());
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(this.hlj.entrySet());
    Iterator localIterator = localLinkedHashSet.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry != null)
      {
        c localc = (c)localEntry.getValue();
        if (localc != null)
        {
          ((StringBuilder)localObject).append("\nDataStore id : ").append((String)localEntry.getKey());
          ((StringBuilder)localObject).append(", CT : ").append(localc.hlm).append("ms");
          ((StringBuilder)localObject).append(", TTL : ").append((l - localc.hlm) / 1000L).append("s");
        }
      }
    }
    localLinkedHashSet.clear();
    localObject = ((StringBuilder)localObject).toString();
    GMTrace.o(18978789392384L, 141403);
    return (String)localObject;
  }
  
  private static final class a<K, V>
    extends ConcurrentHashMap<K, V>
  {
    private a()
    {
      GMTrace.i(680752316416L, 5072);
      GMTrace.o(680752316416L, 5072);
    }
    
    public final boolean containsValue(Object paramObject)
    {
      GMTrace.i(681289187328L, 5076);
      if (paramObject == null)
      {
        GMTrace.o(681289187328L, 5076);
        return false;
      }
      boolean bool = super.containsValue(paramObject);
      GMTrace.o(681289187328L, 5076);
      return bool;
    }
    
    public final V get(Object paramObject)
    {
      GMTrace.i(680886534144L, 5073);
      if (paramObject == null)
      {
        GMTrace.o(680886534144L, 5073);
        return null;
      }
      paramObject = super.get(paramObject);
      GMTrace.o(680886534144L, 5073);
      return (V)paramObject;
    }
    
    public final V put(K paramK, V paramV)
    {
      GMTrace.i(681020751872L, 5074);
      if (paramK == null)
      {
        GMTrace.o(681020751872L, 5074);
        return null;
      }
      if (paramV == null)
      {
        paramK = super.remove(paramK);
        GMTrace.o(681020751872L, 5074);
        return paramK;
      }
      paramK = super.put(paramK, paramV);
      GMTrace.o(681020751872L, 5074);
      return paramK;
    }
    
    public final V remove(Object paramObject)
    {
      GMTrace.i(681154969600L, 5075);
      if (paramObject == null)
      {
        GMTrace.o(681154969600L, 5075);
        return null;
      }
      paramObject = super.remove(paramObject);
      GMTrace.o(681154969600L, 5075);
      return (V)paramObject;
    }
  }
  
  public static final class b
  {
    public Map<String, Object> hlk;
    
    public b()
    {
      GMTrace.i(619146379264L, 4613);
      this.hlk = new q.a((byte)0);
      GMTrace.o(619146379264L, 4613);
    }
    
    public final b H(String paramString1, String paramString2)
    {
      GMTrace.i(619683250176L, 4617);
      if (!TextUtils.isEmpty(paramString1)) {
        this.hlk.put(paramString1, paramString2);
      }
      GMTrace.o(619683250176L, 4617);
      return this;
    }
    
    public final boolean containsKey(String paramString)
    {
      GMTrace.i(619280596992L, 4614);
      boolean bool = this.hlk.containsKey(paramString);
      GMTrace.o(619280596992L, 4614);
      return bool;
    }
    
    public final boolean fR(String paramString)
    {
      GMTrace.i(619817467904L, 4618);
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = this.hlk.get(paramString);
        if (!(paramString instanceof Boolean)) {}
      }
      for (boolean bool = ((Boolean)paramString).booleanValue();; bool = false)
      {
        GMTrace.o(619817467904L, 4618);
        return bool;
      }
    }
    
    public final <T> T fS(String paramString)
    {
      GMTrace.i(15681730904064L, 116838);
      paramString = get(paramString);
      if (paramString != null)
      {
        GMTrace.o(15681730904064L, 116838);
        return paramString;
      }
      GMTrace.o(15681730904064L, 116838);
      return null;
    }
    
    public final Object get(String paramString)
    {
      GMTrace.i(619951685632L, 4619);
      paramString = this.hlk.get(paramString);
      GMTrace.o(619951685632L, 4619);
      return paramString;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      GMTrace.i(620220121088L, 4621);
      boolean bool = paramBoolean;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = this.hlk.get(paramString);
        bool = paramBoolean;
        if ((paramString instanceof Boolean)) {
          bool = ((Boolean)paramString).booleanValue();
        }
      }
      GMTrace.o(620220121088L, 4621);
      return bool;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      GMTrace.i(14301167353856L, 106552);
      int i = paramInt;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = this.hlk.get(paramString);
        i = paramInt;
        if ((paramString instanceof Integer)) {
          i = ((Integer)paramString).intValue();
        }
      }
      GMTrace.o(14301167353856L, 106552);
      return i;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      GMTrace.i(620354338816L, 4622);
      String str = paramString2;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = this.hlk.get(paramString1);
        str = paramString2;
        if ((paramString1 instanceof String)) {
          str = (String)paramString1;
        }
      }
      GMTrace.o(620354338816L, 4622);
      return str;
    }
    
    public final b l(String paramString, Object paramObject)
    {
      GMTrace.i(619414814720L, 4615);
      if (!TextUtils.isEmpty(paramString)) {
        this.hlk.put(paramString, paramObject);
      }
      GMTrace.o(619414814720L, 4615);
      return this;
    }
    
    public final b o(String paramString, boolean paramBoolean)
    {
      GMTrace.i(619549032448L, 4616);
      if (!TextUtils.isEmpty(paramString)) {
        this.hlk.put(paramString, Boolean.valueOf(paramBoolean));
      }
      GMTrace.o(619549032448L, 4616);
      return this;
    }
    
    public final void recycle()
    {
      GMTrace.i(620622774272L, 4624);
      this.hlk.clear();
      GMTrace.o(620622774272L, 4624);
    }
    
    public final Set<String> yD()
    {
      GMTrace.i(15681596686336L, 116837);
      Set localSet = this.hlk.keySet();
      GMTrace.o(15681596686336L, 116837);
      return localSet;
    }
  }
  
  private static final class c
  {
    q.b hll;
    long hlm;
    
    c()
    {
      GMTrace.i(664780406784L, 4953);
      this.hll = new q.b();
      this.hlm = System.currentTimeMillis();
      GMTrace.o(664780406784L, 4953);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */