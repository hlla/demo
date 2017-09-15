package com.tencent.mm.plugin.normsg.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public enum d
  implements b
{
  private static b nYb;
  
  static
  {
    GMTrace.i(17560779096064L, 130838);
    nYa = new d("INSTANCE");
    nYc = new d[] { nYa };
    nYb = new a();
    GMTrace.o(17560779096064L, 130838);
  }
  
  private d()
  {
    GMTrace.i(17559839571968L, 130831);
    GMTrace.o(17559839571968L, 130831);
  }
  
  public static void a(b paramb)
  {
    GMTrace.i(17559973789696L, 130832);
    if (paramb != null) {
      nYb = paramb;
    }
    GMTrace.o(17559973789696L, 130832);
  }
  
  public final String BM(String paramString)
  {
    GMTrace.i(18980131569664L, 141413);
    paramString = nYb.BM(paramString);
    GMTrace.o(18980131569664L, 141413);
    return paramString;
  }
  
  public final boolean a(Object paramObject, Class paramClass)
  {
    GMTrace.i(17814853255168L, 132731);
    boolean bool = nYb.a(paramObject, paramClass);
    GMTrace.o(17814853255168L, 132731);
    return bool;
  }
  
  public final String aPc()
  {
    GMTrace.i(17560510660608L, 130836);
    String str = nYb.aPc();
    GMTrace.o(17560510660608L, 130836);
    return str;
  }
  
  public final boolean aPd()
  {
    GMTrace.i(17560644878336L, 130837);
    boolean bool = nYb.aPd();
    GMTrace.o(17560644878336L, 130837);
    return bool;
  }
  
  public final byte[] aPe()
  {
    GMTrace.i(18980400005120L, 141415);
    byte[] arrayOfByte = nYb.aPe();
    GMTrace.o(18980400005120L, 141415);
    return arrayOfByte;
  }
  
  public final String fZ(boolean paramBoolean)
  {
    GMTrace.i(18979997351936L, 141412);
    String str = nYb.fZ(paramBoolean);
    GMTrace.o(18979997351936L, 141412);
    return str;
  }
  
  public final String ga(boolean paramBoolean)
  {
    GMTrace.i(18980265787392L, 141414);
    String str = nYb.ga(paramBoolean);
    GMTrace.o(18980265787392L, 141414);
    return str;
  }
  
  public final String qt(int paramInt)
  {
    GMTrace.i(17560242225152L, 130834);
    String str = nYb.qt(paramInt);
    GMTrace.o(17560242225152L, 130834);
    return str;
  }
  
  private static final class a
    implements b
  {
    public a()
    {
      GMTrace.i(17556484128768L, 130806);
      GMTrace.o(17556484128768L, 130806);
    }
    
    public final String BM(String paramString)
    {
      GMTrace.i(18981607964672L, 141424);
      v.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      GMTrace.o(18981607964672L, 141424);
      return paramString;
    }
    
    public final boolean a(Object paramObject, Class paramClass)
    {
      GMTrace.i(17814987472896L, 132732);
      v.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      GMTrace.o(17814987472896L, 132732);
      return false;
    }
    
    public final String aPc()
    {
      GMTrace.i(18981876400128L, 141426);
      v.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      GMTrace.o(18981876400128L, 141426);
      return "";
    }
    
    public final boolean aPd()
    {
      GMTrace.i(17557020999680L, 130810);
      v.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      GMTrace.o(17557020999680L, 130810);
      return false;
    }
    
    public final byte[] aPe()
    {
      GMTrace.i(18982010617856L, 141427);
      v.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      GMTrace.o(18982010617856L, 141427);
      return new byte[0];
    }
    
    public final String fZ(boolean paramBoolean)
    {
      GMTrace.i(18981473746944L, 141423);
      v.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      GMTrace.o(18981473746944L, 141423);
      return "";
    }
    
    public final String ga(boolean paramBoolean)
    {
      GMTrace.i(18981742182400L, 141425);
      v.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      GMTrace.o(18981742182400L, 141425);
      return "";
    }
    
    public final String qt(int paramInt)
    {
      GMTrace.i(17556752564224L, 130808);
      v.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      GMTrace.o(17556752564224L, 130808);
      return "";
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/normsg/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */