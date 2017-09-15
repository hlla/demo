package ct;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class ac
{
  private ab a;
  private ad b;
  private ae c;
  private List d;
  private int e = 0;
  private int f = 0;
  private s g;
  private String h;
  private s i;
  private int j;
  private int k;
  private boolean l = false;
  private z m;
  private boolean n;
  private String o;
  private ag p;
  private aa q;
  private long r;
  private boolean s = false;
  
  public ac(z paramz)
  {
    new Object();
    this.a = af.a();
    this.m = ((z)paramz);
    this.m.l = System.currentTimeMillis();
  }
  
  private int a(a parama, Exception paramException)
  {
    this.p.p = paramException.getClass().getSimpleName();
    this.p.q = (parama + "##" + this.q.a + "##" + be.a(paramException));
    if (this.p.q.contains("Permission"))
    {
      this.q.a = -18;
      return 0;
    }
    if (bc.e())
    {
      if (i.b("info.3g.qq.com"))
      {
        if ((paramException instanceof EOFException)) {
          return -31;
        }
        if ((paramException instanceof IOException)) {
          return -30;
        }
        if ((paramException instanceof SocketException)) {
          return -12;
        }
        if ((paramException instanceof IllegalStateException)) {
          return -22;
        }
        if ((paramException instanceof SSLPeerUnverifiedException)) {
          return -23;
        }
        return -3;
      }
      return -17;
    }
    return -4;
  }
  
  /* Error */
  private void a(aa paramaa)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: getfield 105	ct/aa:a	I
    //   6: istore_3
    //   7: aload_0
    //   8: getfield 73	ct/ac:p	Lct/ag;
    //   11: aload_1
    //   12: getfield 155	ct/aa:e	Ljava/lang/String;
    //   15: putfield 158	ct/ag:t	Ljava/lang/String;
    //   18: aload_0
    //   19: getfield 73	ct/ac:p	Lct/ag;
    //   22: aload_1
    //   23: getfield 160	ct/aa:f	J
    //   26: putfield 162	ct/ag:o	J
    //   29: iload_3
    //   30: lookupswitch	default:+551->581, 200:+91->121, 204:+530->560, 301:+398->428, 302:+398->428, 303:+398->428, 408:+530->560, 502:+530->560, 503:+530->560, 504:+530->560
    //   112: aload_0
    //   113: getfield 101	ct/ac:q	Lct/aa;
    //   116: iload_3
    //   117: putfield 105	ct/aa:a	I
    //   120: return
    //   121: aload_1
    //   122: getfield 165	ct/aa:d	Ljava/io/InputStream;
    //   125: astore_1
    //   126: aload_0
    //   127: getfield 73	ct/ac:p	Lct/ag;
    //   130: iconst_1
    //   131: putfield 167	ct/ag:m	Z
    //   134: aload_0
    //   135: getfield 61	ct/ac:m	Lct/z;
    //   138: getfield 169	ct/z:h	Z
    //   141: ifeq +265 -> 406
    //   144: aload_0
    //   145: getfield 61	ct/ac:m	Lct/z;
    //   148: getfield 171	ct/z:m	I
    //   151: istore_3
    //   152: iload_3
    //   153: newarray <illegal type>
    //   155: astore 5
    //   157: iload_2
    //   158: iload_3
    //   159: if_icmpge +93 -> 252
    //   162: aload_1
    //   163: aload 5
    //   165: iload_2
    //   166: iload_3
    //   167: iload_2
    //   168: isub
    //   169: invokevirtual 177	java/io/InputStream:read	([BII)I
    //   172: istore 4
    //   174: iload 4
    //   176: iconst_m1
    //   177: if_icmpeq +75 -> 252
    //   180: iload_2
    //   181: iload 4
    //   183: iadd
    //   184: istore_2
    //   185: goto -28 -> 157
    //   188: astore 5
    //   190: aload_1
    //   191: invokevirtual 180	java/io/InputStream:close	()V
    //   194: aload_0
    //   195: getfield 101	ct/ac:q	Lct/aa;
    //   198: bipush -8
    //   200: putfield 105	ct/aa:a	I
    //   203: aload_0
    //   204: getfield 73	ct/ac:p	Lct/ag;
    //   207: new 89	java/lang/StringBuilder
    //   210: dup
    //   211: ldc -74
    //   213: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: iload_3
    //   217: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: putfield 118	ct/ag:q	Ljava/lang/String;
    //   226: aload_0
    //   227: getfield 73	ct/ac:p	Lct/ag;
    //   230: iload_3
    //   231: i2l
    //   232: putfield 162	ct/ag:o	J
    //   235: aload_0
    //   236: iconst_1
    //   237: putfield 48	ct/ac:l	Z
    //   240: return
    //   241: astore_1
    //   242: aload_0
    //   243: getstatic 188	ct/ac$a:a	Lct/ac$a;
    //   246: aload_1
    //   247: invokespecial 190	ct/ac:a	(Lct/ac$a;Ljava/lang/Exception;)I
    //   250: pop
    //   251: return
    //   252: iload_2
    //   253: iload_3
    //   254: if_icmplt +62 -> 316
    //   257: aload_0
    //   258: getfield 101	ct/ac:q	Lct/aa;
    //   261: iconst_m1
    //   262: putfield 105	ct/aa:a	I
    //   265: aload_0
    //   266: getfield 73	ct/ac:p	Lct/ag;
    //   269: new 89	java/lang/StringBuilder
    //   272: dup
    //   273: ldc -64
    //   275: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   278: iload_2
    //   279: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: putfield 118	ct/ag:q	Ljava/lang/String;
    //   288: aload_1
    //   289: invokevirtual 180	java/io/InputStream:close	()V
    //   292: aload_0
    //   293: getfield 101	ct/ac:q	Lct/aa;
    //   296: getfield 105	ct/aa:a	I
    //   299: ifne +285 -> 584
    //   302: aload_0
    //   303: getfield 73	ct/ac:p	Lct/ag;
    //   306: iconst_0
    //   307: putfield 194	ct/ag:r	I
    //   310: aload_0
    //   311: iconst_1
    //   312: putfield 48	ct/ac:l	Z
    //   315: return
    //   316: aload_0
    //   317: getfield 101	ct/ac:q	Lct/aa;
    //   320: iload_2
    //   321: newarray <illegal type>
    //   323: putfield 197	ct/aa:c	[B
    //   326: aload 5
    //   328: iconst_0
    //   329: aload_0
    //   330: getfield 101	ct/ac:q	Lct/aa;
    //   333: getfield 197	ct/aa:c	[B
    //   336: iconst_0
    //   337: iload_2
    //   338: invokestatic 201	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   341: aload_0
    //   342: getfield 101	ct/ac:q	Lct/aa;
    //   345: iconst_0
    //   346: putfield 105	ct/aa:a	I
    //   349: aload_0
    //   350: getfield 73	ct/ac:p	Lct/ag;
    //   353: invokestatic 67	java/lang/System:currentTimeMillis	()J
    //   356: putfield 204	ct/ag:D	J
    //   359: goto -71 -> 288
    //   362: astore 5
    //   364: aload_1
    //   365: invokevirtual 180	java/io/InputStream:close	()V
    //   368: aload_0
    //   369: getfield 101	ct/ac:q	Lct/aa;
    //   372: bipush -8
    //   374: putfield 105	ct/aa:a	I
    //   377: aload_0
    //   378: getfield 73	ct/ac:p	Lct/ag;
    //   381: new 89	java/lang/StringBuilder
    //   384: dup
    //   385: ldc -74
    //   387: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: iload_3
    //   391: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   394: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: putfield 118	ct/ag:q	Ljava/lang/String;
    //   400: aload_0
    //   401: iconst_1
    //   402: putfield 48	ct/ac:l	Z
    //   405: return
    //   406: invokestatic 208	ct/bd:b	()V
    //   409: aload_0
    //   410: getfield 101	ct/ac:q	Lct/aa;
    //   413: aload_1
    //   414: putfield 165	ct/aa:d	Ljava/io/InputStream;
    //   417: aload_0
    //   418: getfield 101	ct/ac:q	Lct/aa;
    //   421: iconst_0
    //   422: putfield 105	ct/aa:a	I
    //   425: goto -133 -> 292
    //   428: aload_0
    //   429: getfield 101	ct/ac:q	Lct/aa;
    //   432: bipush -21
    //   434: putfield 105	ct/aa:a	I
    //   437: aload_0
    //   438: iconst_1
    //   439: putfield 50	ct/ac:s	Z
    //   442: new 89	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   449: astore_1
    //   450: aload_0
    //   451: getfield 73	ct/ac:p	Lct/ag;
    //   454: astore 5
    //   456: aload 5
    //   458: aload_1
    //   459: aload 5
    //   461: getfield 210	ct/ag:k	Ljava/lang/String;
    //   464: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc -44
    //   469: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_0
    //   473: getfield 101	ct/ac:q	Lct/aa;
    //   476: getfield 214	ct/aa:b	Ljava/lang/String;
    //   479: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: putfield 210	ct/ag:k	Ljava/lang/String;
    //   488: aload_0
    //   489: getfield 73	ct/ac:p	Lct/ag;
    //   492: iconst_1
    //   493: putfield 216	ct/ag:j	Z
    //   496: aload_0
    //   497: getfield 218	ct/ac:h	Ljava/lang/String;
    //   500: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   503: ifeq +18 -> 521
    //   506: aload_0
    //   507: aconst_null
    //   508: putfield 218	ct/ac:h	Ljava/lang/String;
    //   511: aload_0
    //   512: getfield 101	ct/ac:q	Lct/aa;
    //   515: bipush -6
    //   517: putfield 105	ct/aa:a	I
    //   520: return
    //   521: aload_0
    //   522: getfield 61	ct/ac:m	Lct/z;
    //   525: getfield 225	ct/z:p	Z
    //   528: ifne +56 -> 584
    //   531: invokestatic 208	ct/bd:b	()V
    //   534: aload_0
    //   535: getfield 101	ct/ac:q	Lct/aa;
    //   538: aload_0
    //   539: getfield 218	ct/ac:h	Ljava/lang/String;
    //   542: putfield 214	ct/aa:b	Ljava/lang/String;
    //   545: aload_0
    //   546: getfield 101	ct/ac:q	Lct/aa;
    //   549: bipush -7
    //   551: putfield 105	ct/aa:a	I
    //   554: aload_0
    //   555: iconst_1
    //   556: putfield 48	ct/ac:l	Z
    //   559: return
    //   560: aload_0
    //   561: getfield 101	ct/ac:q	Lct/aa;
    //   564: iload_3
    //   565: putfield 105	ct/aa:a	I
    //   568: return
    //   569: astore_1
    //   570: goto -376 -> 194
    //   573: astore_1
    //   574: goto -206 -> 368
    //   577: astore_1
    //   578: goto -286 -> 292
    //   581: goto -469 -> 112
    //   584: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	ac
    //   0	585	1	paramaa	aa
    //   1	337	2	i1	int
    //   6	559	3	i2	int
    //   172	12	4	i3	int
    //   155	9	5	arrayOfByte	byte[]
    //   188	139	5	localOutOfMemoryError1	OutOfMemoryError
    //   362	1	5	localOutOfMemoryError2	OutOfMemoryError
    //   454	6	5	localag	ag
    // Exception table:
    //   from	to	target	type
    //   152	157	188	java/lang/OutOfMemoryError
    //   2	29	241	java/lang/Exception
    //   112	120	241	java/lang/Exception
    //   121	152	241	java/lang/Exception
    //   152	157	241	java/lang/Exception
    //   162	174	241	java/lang/Exception
    //   194	240	241	java/lang/Exception
    //   257	288	241	java/lang/Exception
    //   292	315	241	java/lang/Exception
    //   316	326	241	java/lang/Exception
    //   326	359	241	java/lang/Exception
    //   368	405	241	java/lang/Exception
    //   406	425	241	java/lang/Exception
    //   428	520	241	java/lang/Exception
    //   521	559	241	java/lang/Exception
    //   560	568	241	java/lang/Exception
    //   316	326	362	java/lang/OutOfMemoryError
    //   190	194	569	java/lang/Exception
    //   364	368	573	java/lang/Exception
    //   288	292	577	java/lang/Exception
  }
  
  private void a(Map paramMap)
  {
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).putAll(this.m.b());
    ((HashMap)localObject1).putAll(paramMap);
    paramMap = new URL(this.o);
    Object localObject2 = bc.g();
    if ((localObject2 != null) && (this.e > 1)) {}
    Object localObject3;
    for (paramMap = (HttpURLConnection)paramMap.openConnection((Proxy)localObject2);; paramMap = (HttpURLConnection)paramMap.openConnection())
    {
      paramMap.setConnectTimeout(this.c.b * 1000);
      paramMap.setReadTimeout(this.c.a * 1000);
      paramMap.setUseCaches(false);
      paramMap.setDoInput(true);
      paramMap.setInstanceFollowRedirects(false);
      localObject2 = ((HashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        paramMap.addRequestProperty((String)localObject3, (String)((HashMap)localObject1).get(localObject3));
      }
    }
    paramMap.setDoOutput(true);
    localObject1 = this.m.j;
    if (localObject1 != null) {}
    try
    {
      this.p.A = System.currentTimeMillis();
      paramMap.setRequestMethod("POST");
      paramMap.getOutputStream().write((byte[])localObject1);
      paramMap.getOutputStream().flush();
      paramMap.getOutputStream().close();
      this.p.B = System.currentTimeMillis();
      try
      {
        if ((Build.VERSION.SDK != null) && (Build.VERSION.SDK_INT < 8)) {
          System.setProperty("http.keepAlive", "false");
        }
        this.p.z = System.currentTimeMillis();
        int i1 = paramMap.getResponseCode();
        this.p.C = System.currentTimeMillis();
        if (i1 == -1) {
          throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        this.q.a = paramMap.getResponseCode();
        try
        {
          localObject1 = paramMap.getInputStream();
          this.q.d = ((InputStream)localObject1);
          paramMap.getContentEncoding();
          this.q.f = paramMap.getContentLength();
          this.q.e = paramMap.getContentType();
          this.h = paramMap.getHeaderField("Location");
          this.q.b = paramMap.getHeaderField("Location");
          paramMap = paramMap.getHeaderFields().entrySet().iterator();
          while (paramMap.hasNext())
          {
            localObject3 = (Map.Entry)paramMap.next();
            if (((Map.Entry)localObject3).getKey() != null)
            {
              localObject1 = this.q;
              localObject2 = (String)((Map.Entry)localObject3).getKey();
              localObject3 = (String)((List)((Map.Entry)localObject3).getValue()).get(0);
              ((aa)localObject1).g.put(localObject2, localObject3);
            }
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            InputStream localInputStream = paramMap.getErrorStream();
          }
          a(this.q);
          return;
        }
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public final aa a()
  {
    this.b = new ad(this.m);
    this.c = new ae(bc.c());
    this.d = this.b.c;
    this.i = this.b.a;
    this.j = (this.d.size() - 1);
    this.k = this.d.size();
    if ((this.e <= this.m.o) && (!this.l))
    {
      if (!this.s)
      {
        this.p = new ag();
        this.p.x = this.m.k;
        this.p.y = this.m.l;
        this.p.l = this.e;
        this.p.f = (this.m.q + "-" + this.e);
      }
      if (this.e > 0) {
        this.p.F = System.currentTimeMillis();
      }
      this.r = System.currentTimeMillis();
      this.q = new aa();
      for (;;)
      {
        try
        {
          int i1 = this.e;
          int i2 = this.k;
          this.g = ((s)this.d.get(i1 % i2));
          if (System.currentTimeMillis() - this.m.l > this.m.n)
          {
            this.g = ((s)this.d.get(this.d.size() - 1));
            this.n = true;
            this.c.b = 10;
            this.c.a = 10;
            this.l = true;
          }
          if (!TextUtils.isEmpty(this.h)) {
            continue;
          }
          s locals = this.g;
          if (!this.m.a) {
            continue;
          }
          str2 = this.m.d;
          this.o = str2;
          this.p.b = this.o;
          if (this.e % this.k < this.j)
          {
            this.m.a("Host", this.m.f);
            this.m.a("x-tx-host", this.m.f);
          }
          this.m.a("Halley-sdk", " sdk:" + p.g + "key:" + this.m.q + "-" + this.e);
          if ((bc.d) && (this.e > 1)) {
            this.m.a("X-Online-Host", this.m.f);
          }
          a(this.m.b());
          if (!TextUtils.isEmpty(this.h)) {
            continue;
          }
          this.f = 0;
          this.e += 1;
        }
        catch (Exception localException)
        {
          String str2;
          String str1;
          String str3;
          bd.d();
          this.q.a = a(a.b, localException);
          if (!TextUtils.isEmpty(this.h)) {
            continue;
          }
          this.f = 0;
          this.e += 1;
          System.currentTimeMillis();
          continue;
          this.f += 1;
          if (this.f <= 6) {
            continue;
          }
          this.e += 1;
          this.f = 0;
          this.q.a = -5;
          continue;
          this.f += 1;
          if (this.f <= 6) {
            continue;
          }
          this.e += 1;
          this.f = 0;
          this.q.a = -5;
          continue;
        }
        finally
        {
          if (!TextUtils.isEmpty(this.h)) {
            continue;
          }
          this.f = 0;
          this.e += 1;
          System.currentTimeMillis();
          throw ((Throwable)localObject);
          this.f += 1;
          if (this.f <= 6) {
            continue;
          }
          this.e += 1;
          this.f = 0;
          this.q.a = -5;
          continue;
          this.p.c = 0L;
          continue;
        }
        System.currentTimeMillis();
        System.currentTimeMillis();
        this.p.E = System.currentTimeMillis();
        try
        {
          this.p.g = this.b.b;
          this.p.i = this.i;
          this.p.m = false;
          this.p.h = this.g;
          this.p.a = this.m.c;
          this.p.e = this.m.a;
          this.p.d = this.m.o;
          if (this.e == this.m.o) {
            this.p.m = true;
          }
          this.p.s = this.n;
          this.p.n = this.q.a;
          this.p.k = this.h;
          if (this.m.j == null) {
            continue;
          }
          this.p.c = this.m.j.length;
          if ((this.p.m) && (this.p.n != 0)) {
            this.p.r = 1;
          }
          this.p.w = this.m.i;
          this.p.G = (this.p.y - this.p.x);
          this.p.H = (this.p.z - this.p.y);
          this.p.I = (this.p.B - this.p.A);
          this.p.J = (this.p.C - this.p.z);
          this.p.K = (this.p.D - this.p.C);
          this.p.L = (this.p.E - this.p.y);
          new StringBuilder("taskKey:").append(this.p.f).append(";\ncreateWaitTime:").append(this.p.G).append(";\npreTime:").append(this.p.H).append(";\ndnsTime:0;\nconnectTime:").append(this.p.I).append(";\nreqResTime:").append(this.p.J).append(";\nwaitTime:0;\nreadDataTime:").append(this.p.K).append(";\ntotalTime:").append(this.p.L).append(";\ncostTimeReq:0");
          bd.a();
          if (this.q.a == -21) {
            break;
          }
          this.a.a(this.p);
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
        break;
        if (!this.m.a)
        {
          if (localOutOfMemoryError.b != -1)
          {
            str1 = "http://" + localOutOfMemoryError.a + ":" + localOutOfMemoryError.b;
            str3 = this.m.g;
            str2 = str1;
            if (TextUtils.isEmpty(str3)) {
              continue;
            }
            if (str3.startsWith("/")) {
              str2 = str1 + str3;
            }
          }
          else
          {
            str1 = "http://" + str1.a;
            continue;
          }
        }
        else
        {
          if (str1.b != -1)
          {
            str1 = "https://" + str1.a + ":443";
            continue;
          }
          str1 = "https://" + str1.a;
          continue;
        }
        str2 = str1 + "/" + str3;
        continue;
        this.o = this.h;
        this.h = null;
      }
    }
    return this.q;
  }
  
  public static enum a
  {
    static
    {
      a = new a("READDATAEXC", 1);
      b = new a("UNKNOWEXC", 2);
      a locala = c;
      locala = a;
      locala = b;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */