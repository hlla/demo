package ct;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class t
{
  String a;
  Map b;
  
  public t(String paramString)
  {
    this.a = paramString;
    this.b = new HashMap();
  }
  
  public final void a(a parama)
  {
    this.b.put(parama.a, parama);
  }
  
  public static final class a
  {
    String a;
    public String b;
    public List c;
    public s d;
    long e;
    
    public a(String paramString1, long paramLong, String paramString2)
    {
      this.a = paramString1;
      this.e = paramLong;
      this.b = paramString2;
      this.c = new ArrayList();
    }
    
    public a(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
    {
      this.a = paramString1;
      this.e = paramLong;
      this.b = paramString3;
      this.c = a(paramString2);
      if (!TextUtils.isEmpty(paramString4))
      {
        paramString1 = paramString4.split(":");
        if ((paramString1 == null) || (paramString1.length <= 0)) {}
      }
      for (paramString1 = new s(paramString1[0], Integer.parseInt(paramString1[1]));; paramString1 = null)
      {
        this.d = paramString1;
        return;
      }
    }
    
    private static ArrayList a(String paramString)
    {
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split(",");
        if ((paramString != null) && (paramString.length > 0))
        {
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            String[] arrayOfString = paramString[i].split(":");
            if ((arrayOfString != null) && (arrayOfString.length > 0)) {
              localArrayList.add(new s(arrayOfString[0], Integer.parseInt(arrayOfString[1])));
            }
            i += 1;
          }
        }
      }
      return localArrayList;
    }
    
    public final String a()
    {
      Object localObject = this.c;
      if ((localObject == null) || (((List)localObject).size() == 0)) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append(((s)((Iterator)localObject).next()).a());
        localStringBuilder.append(",");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      return localStringBuilder.toString();
    }
    
    public final boolean b()
    {
      return System.currentTimeMillis() - this.e > b.a.b().b.e * 60 * 1000;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */