package com.tencent.mm.u.a;

import com.tencent.gmtrace.GMTrace;
import java.util.HashMap;

public final class b
{
  public String hoc;
  public String hod;
  public String hoe;
  public String hof;
  public HashMap<String, e> hog;
  
  public b()
  {
    GMTrace.i(692026605568L, 5156);
    this.hog = new HashMap();
    GMTrace.o(692026605568L, 5156);
  }
  
  public final e gu(String paramString)
  {
    GMTrace.i(692160823296L, 5157);
    if ((this.hog != null) && (this.hog.containsKey(paramString)))
    {
      paramString = (e)this.hog.get(paramString);
      GMTrace.o(692160823296L, 5157);
      return paramString;
    }
    GMTrace.o(692160823296L, 5157);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */