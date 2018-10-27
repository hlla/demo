package com.google.android.e;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.message.BasicHeader;

public final class b
{
  private static final Pattern a = Pattern.compile("(^|[\\s;,]+)([^()<>@,;:\\\"/\\[\\]\\?={}\\s]+)\\s*=\\s*(\"[^\"]*\"|[^,;\\s\"]+)");
  private static final int b = ".".codePointAt(0);
  private static final String[] c = { "google.com", "googleapis.com" };
  private static final Pattern d;
  
  static
  {
    Pattern.compile("[^()<>@,;:\\\"/\\[\\]\\?={}\\s]+");
    d = Pattern.compile("[^,;\\s\"]+");
  }
  
  private static String a(String paramString)
  {
    if (paramString != null)
    {
      Object localObject = paramString;
      if (!d.matcher(paramString).matches())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("\"");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("\"");
        localObject = ((StringBuilder)localObject).toString();
      }
      return (String)localObject;
    }
    return "\"\"";
  }
  
  private static String a(String paramString1, String paramString2)
  {
    paramString1 = a.matcher(paramString1);
    while (paramString1.find()) {
      if (paramString1.group(2).equals(paramString2))
      {
        paramString1 = paramString1.group();
        paramString2 = paramString1.substring(paramString1.indexOf("=") + 1).trim();
        paramString1 = paramString2;
        if (paramString2.startsWith("\"")) {
          paramString1 = paramString2.substring(1, paramString2.length() - 1);
        }
        return paramString1;
      }
    }
    return null;
  }
  
  public static HttpResponse a(HttpUriRequest paramHttpUriRequest, HttpResponse paramHttpResponse, a parama)
  {
    int j = 0;
    if (b(paramHttpUriRequest, parama))
    {
      paramHttpUriRequest = parama.a();
      Header[] arrayOfHeader = paramHttpResponse.getHeaders("Set-Cookie");
      int k = arrayOfHeader.length;
      int i = 0;
      if (i >= k)
      {
        arrayOfHeader = paramHttpResponse.getHeaders("Set-Cookie2");
        k = arrayOfHeader.length;
        i = j;
        if (i < k)
        {
          if (a(arrayOfHeader[i].getValue(), paramHttpUriRequest) == null) {}
          for (;;)
          {
            i += 1;
            break;
            parama.c();
          }
        }
      }
      else
      {
        if (a(arrayOfHeader[i].getValue(), paramHttpUriRequest) == null) {}
        for (;;)
        {
          i += 1;
          break;
          parama.c();
        }
      }
    }
    return paramHttpResponse;
  }
  
  public static HttpUriRequest a(HttpUriRequest paramHttpUriRequest, a parama)
  {
    if (b(paramHttpUriRequest, parama))
    {
      String str1 = parama.a();
      String str2 = parama.b();
      Header[] arrayOfHeader = paramHttpUriRequest.getHeaders("Cookie");
      int k = arrayOfHeader.length;
      int i = 0;
      int j = 0;
      if (j < k)
      {
        Object localObject = arrayOfHeader[j];
        parama = ((Header)localObject).getValue();
        parama = a.matcher(parama);
        while (parama.find()) {
          if (parama.group(2).equals(str1))
          {
            parama = paramHttpUriRequest;
            if (i == 0)
            {
              parama = paramHttpUriRequest;
              if (!(paramHttpUriRequest instanceof RequestWrapper)) {
                parama = a(paramHttpUriRequest);
              }
            }
            parama.removeHeader((Header)localObject);
            paramHttpUriRequest = ((Header)localObject).getName();
            localObject = ((Header)localObject).getValue();
            localObject = a.matcher((CharSequence)localObject);
            StringBuffer localStringBuffer = new StringBuffer();
            while (((Matcher)localObject).find()) {
              if (((Matcher)localObject).group(2).equals(str1))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(((Matcher)localObject).group(1));
                localStringBuilder.append(str1);
                localStringBuilder.append("=");
                localStringBuilder.append(a(str2));
                ((Matcher)localObject).appendReplacement(localStringBuffer, localStringBuilder.toString());
              }
              else
              {
                ((Matcher)localObject).appendReplacement(localStringBuffer, ((Matcher)localObject).group());
              }
            }
            ((Matcher)localObject).appendTail(localStringBuffer);
            parama.addHeader(new BasicHeader(paramHttpUriRequest, localStringBuffer.toString()));
            paramHttpUriRequest = parama;
            i = 1;
          }
        }
        for (;;)
        {
          j += 1;
          break;
        }
      }
      if (i != 0) {
        return paramHttpUriRequest;
      }
      parama = new StringBuilder();
      parama.append(str1);
      parama.append("=");
      parama.append(a(str2));
      paramHttpUriRequest.addHeader(new BasicHeader("Cookie", parama.toString()));
      return paramHttpUriRequest;
    }
    return paramHttpUriRequest;
  }
  
  private static RequestWrapper a(HttpUriRequest paramHttpUriRequest)
  {
    if ((paramHttpUriRequest instanceof HttpEntityEnclosingRequest)) {}
    for (;;)
    {
      try
      {
        paramHttpUriRequest = new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest)paramHttpUriRequest);
        paramHttpUriRequest.resetHeaders();
        return paramHttpUriRequest;
      }
      catch (ProtocolException paramHttpUriRequest)
      {
        throw new ClientProtocolException(paramHttpUriRequest);
      }
      paramHttpUriRequest = new RequestWrapper(paramHttpUriRequest);
    }
  }
  
  private static boolean b(HttpUriRequest paramHttpUriRequest, a parama)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parama != null)
    {
      parama = c;
      int m = parama.length;
      int i = 0;
      bool1 = bool2;
      if (i < m)
      {
        Object localObject = parama[i];
        String str = paramHttpUriRequest.getURI().getHost();
        if (((String)localObject).length() > str.length()) {}
        int k;
        label133:
        do
        {
          i += 1;
          break;
          if (((String)localObject).equalsIgnoreCase(str)) {
            break label146;
          }
          k = str.length() - 1;
          int j = ((String)localObject).length() - 1;
          for (;;)
          {
            if (j < 0) {
              break label133;
            }
            if (Character.toLowerCase(str.codePointAt(k)) != Character.toLowerCase(((String)localObject).codePointAt(j))) {
              break;
            }
            k -= 1;
            j -= 1;
          }
        } while (str.codePointAt(k) != b);
        label146:
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */