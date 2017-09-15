package ct;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONObject;

public final class ci
{
  public static int a = 0;
  private final ck b;
  private final cg c;
  private final ch d;
  
  public ci(ck paramck, cg paramcg, ch paramch)
  {
    this.b = paramck;
    this.c = paramcg;
    this.d = paramch;
  }
  
  private String a(int paramInt1, int paramInt2, String paramString, bk parambk, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (parambk == null) {
      return null;
    }
    label740:
    for (;;)
    {
      try
      {
        String str2;
        String str3;
        String str1;
        bl localbl;
        if (this.c == null)
        {
          bool = true;
          str2 = b.a.a(this.b);
          str3 = b.a.a(this.c, bool);
          str1 = b.a.a(this.d);
          if (!paramBoolean2) {
            continue;
          }
          str1 = "{}";
          localbl = parambk.g();
          if (localbl == null) {
            return null;
          }
        }
        else
        {
          if (a == this.c.e) {
            break label740;
          }
          bool = true;
          a = this.c.e;
          continue;
        }
        Object localObject = new HashMap();
        ((HashMap)localObject).put("imei", localbl.a());
        ((HashMap)localObject).put("imsi", localbl.b());
        ((HashMap)localObject).put("phonenum", b.a.b(localbl.e));
        ((HashMap)localObject).put("qq", b.a.b(localbl.g));
        ((HashMap)localObject).put("mac", localbl.c().toLowerCase(Locale.ENGLISH));
        localbl.a.a();
        String str4 = new JSONObject((Map)localObject).toString();
        if (localbl.n == null)
        {
          localObject = new StringBuilder(100);
          ((StringBuilder)localObject).append(localbl.a()).append("_").append(localbl.b()).append("_").append(localbl.c()).append("_QQGeoLocation");
          localbl.n = b.a.d(((StringBuilder)localObject).toString());
        }
        String str6 = localbl.n;
        cy.a();
        int j = cy.a(parambk.a);
        String str5 = da.b(parambk);
        localObject = localbl.j;
        parambk = (bk)localObject;
        if (localObject != null) {
          parambk = ((String)localObject).replace("\"", "");
        }
        localObject = parambk;
        if (parambk != null) {
          localObject = parambk.replace("|", "");
        }
        localObject = (String)localObject + "_" + localbl.i;
        if (paramBoolean3)
        {
          parambk = localbl.a();
          if (parambk != null)
          {
            i = Math.abs(parambk.hashCode()) % 1000 + 1001;
            StringBuilder localStringBuilder = new StringBuilder("{\"version\":\"");
            if (localbl.q == null)
            {
              parambk = "None";
              parambk = parambk + "\",\"address\":" + paramInt1;
              parambk = parambk + ",\"source\":" + i + ",\"access_token\":\"" + str6 + "\",\"app_name\":\"" + paramString + "\",\"app_label\":\"" + (String)localObject + "\",\"bearing\":1";
              paramString = parambk;
              if (paramInt2 >= 0) {
                paramString = parambk + ",\"control\":" + paramInt2;
              }
              if (paramBoolean1)
              {
                paramString = paramString + ",\"detectgps\":1";
                paramString = paramString + ",\"pstat\":" + j;
                paramString = paramString + ",\"wlan\":" + str5;
                return paramString + ",\"attribute\":" + str4 + ",\"location\":" + str1 + ",\"cells\":" + str3 + ",\"wifis\":" + str2 + "}";
              }
            }
            else
            {
              parambk = localbl.q;
              continue;
            }
            paramString = paramString + ",\"detectgps\":0";
            continue;
          }
        }
        int i = 203;
        continue;
        continue;
        boolean bool = false;
      }
      catch (Exception paramString)
      {
        return null;
      }
    }
  }
  
  @Nullable
  public final ch a()
  {
    return this.d;
  }
  
  public final String a(int paramInt, String paramString, bk parambk, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramBoolean3) {
      return a(paramInt, 1, paramString, parambk, paramBoolean1, paramBoolean2, paramBoolean4);
    }
    return a(paramInt, 0, paramString, parambk, paramBoolean1, paramBoolean2, paramBoolean4);
  }
  
  public final boolean b()
  {
    return this.d != null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */