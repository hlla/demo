package android.support.v4.e;

import android.support.v4.g.u;
import android.util.Base64;
import java.util.List;

public final class a
{
  public final List a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  
  public a(String paramString1, String paramString2, String paramString3, List paramList)
  {
    this.c = ((String)u.a(paramString1));
    this.d = ((String)u.a(paramString2));
    this.e = ((String)u.a(paramString3));
    this.a = ((List)u.a(paramList));
    paramString1 = new StringBuilder(this.c);
    paramString1.append("-");
    paramString1.append(this.d);
    paramString1.append("-");
    paramString1.append(this.e);
    this.b = paramString1.toString();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FontRequest {mProviderAuthority: ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", mProviderPackage: ");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(", mQuery: ");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(", mCertificates:");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    int i = 0;
    while (i < this.a.size())
    {
      localStringBuilder.append(" [");
      localObject = (List)this.a.get(i);
      int j = 0;
      while (j < ((List)localObject).size())
      {
        localStringBuilder.append(" \"");
        localStringBuilder.append(Base64.encodeToString((byte[])((List)localObject).get(j), 0));
        localStringBuilder.append("\"");
        j += 1;
      }
      localStringBuilder.append(" ]");
      i += 1;
    }
    localStringBuilder.append("}");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mCertificatesArray: ");
    ((StringBuilder)localObject).append(0);
    localStringBuilder.append(((StringBuilder)localObject).toString());
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */