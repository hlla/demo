package android.support.v4.content;

import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

final class g
  implements f
{
  public final HashMap a = new HashMap();
  private final String b;
  
  g(String paramString)
  {
    this.b = paramString;
  }
  
  /* Error */
  public final Uri a(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 32	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 20	android/support/v4/content/g:a	Ljava/util/HashMap;
    //   9: invokevirtual 36	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   12: invokeinterface 42 1 0
    //   17: astore 4
    //   19: aconst_null
    //   20: astore_1
    //   21: aload 4
    //   23: invokeinterface 48 1 0
    //   28: ifeq +74 -> 102
    //   31: aload 4
    //   33: invokeinterface 52 1 0
    //   38: checkcast 54	java/util/Map$Entry
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 57 1 0
    //   48: checkcast 28	java/io/File
    //   51: invokevirtual 60	java/io/File:getPath	()Ljava/lang/String;
    //   54: astore 5
    //   56: aload_3
    //   57: aload 5
    //   59: invokevirtual 66	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   62: ifeq -41 -> 21
    //   65: aload_1
    //   66: ifnull +31 -> 97
    //   69: aload 5
    //   71: invokevirtual 70	java/lang/String:length	()I
    //   74: aload_1
    //   75: invokeinterface 57 1 0
    //   80: checkcast 28	java/io/File
    //   83: invokevirtual 60	java/io/File:getPath	()Ljava/lang/String;
    //   86: invokevirtual 70	java/lang/String:length	()I
    //   89: if_icmple -68 -> 21
    //   92: aload_2
    //   93: astore_1
    //   94: goto -73 -> 21
    //   97: aload_2
    //   98: astore_1
    //   99: goto -78 -> 21
    //   102: aload_1
    //   103: ifnonnull +36 -> 139
    //   106: new 72	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   113: astore_1
    //   114: aload_1
    //   115: ldc 75
    //   117: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_1
    //   122: aload_3
    //   123: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: new 81	java/lang/IllegalArgumentException
    //   130: dup
    //   131: aload_1
    //   132: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokespecial 86	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   138: athrow
    //   139: aload_1
    //   140: invokeinterface 57 1 0
    //   145: checkcast 28	java/io/File
    //   148: invokevirtual 60	java/io/File:getPath	()Ljava/lang/String;
    //   151: astore_2
    //   152: aload_2
    //   153: ldc 88
    //   155: invokevirtual 91	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   158: ifeq +87 -> 245
    //   161: aload_3
    //   162: aload_2
    //   163: invokevirtual 70	java/lang/String:length	()I
    //   166: invokevirtual 95	java/lang/String:substring	(I)Ljava/lang/String;
    //   169: astore_2
    //   170: new 72	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   177: astore_3
    //   178: aload_3
    //   179: aload_1
    //   180: invokeinterface 98 1 0
    //   185: checkcast 62	java/lang/String
    //   188: invokestatic 104	android/net/Uri:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   191: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_3
    //   196: bipush 47
    //   198: invokevirtual 107	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_3
    //   203: aload_2
    //   204: ldc 88
    //   206: invokestatic 110	android/net/Uri:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   209: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_3
    //   214: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: astore_1
    //   218: new 112	android/net/Uri$Builder
    //   221: dup
    //   222: invokespecial 113	android/net/Uri$Builder:<init>	()V
    //   225: ldc 115
    //   227: invokevirtual 119	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   230: aload_0
    //   231: getfield 22	android/support/v4/content/g:b	Ljava/lang/String;
    //   234: invokevirtual 122	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   237: aload_1
    //   238: invokevirtual 125	android/net/Uri$Builder:encodedPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   241: invokevirtual 129	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   244: areturn
    //   245: aload_3
    //   246: aload_2
    //   247: invokevirtual 70	java/lang/String:length	()I
    //   250: iconst_1
    //   251: iadd
    //   252: invokevirtual 95	java/lang/String:substring	(I)Ljava/lang/String;
    //   255: astore_2
    //   256: goto -86 -> 170
    //   259: astore_2
    //   260: new 72	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   267: astore_2
    //   268: aload_2
    //   269: ldc -125
    //   271: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload_2
    //   276: aload_1
    //   277: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: new 81	java/lang/IllegalArgumentException
    //   284: dup
    //   285: aload_2
    //   286: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokespecial 86	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   292: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	g
    //   0	293	1	paramFile	File
    //   41	215	2	localObject1	Object
    //   259	1	2	localIOException	IOException
    //   267	19	2	localStringBuilder	StringBuilder
    //   4	242	3	localObject2	Object
    //   17	15	4	localIterator	java.util.Iterator
    //   54	16	5	str	String
    // Exception table:
    //   from	to	target	type
    //   0	5	259	java/io/IOException
  }
  
  public final File a(Uri paramUri)
  {
    Object localObject2 = paramUri.getEncodedPath();
    int i = ((String)localObject2).indexOf('/', 1);
    Object localObject1 = Uri.decode(((String)localObject2).substring(1, i));
    localObject2 = Uri.decode(((String)localObject2).substring(i + 1));
    localObject1 = (File)this.a.get(localObject1);
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Unable to find configured root for ");
      ((StringBuilder)localObject1).append(paramUri);
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    paramUri = new File((File)localObject1, (String)localObject2);
    try
    {
      localObject2 = paramUri.getCanonicalFile();
      if (!((File)localObject2).getPath().startsWith(((File)localObject1).getPath())) {
        throw new SecurityException("Resolved path jumped beyond configured root");
      }
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to resolve canonical path for ");
      localStringBuilder.append(paramUri);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (File)localObject2;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */