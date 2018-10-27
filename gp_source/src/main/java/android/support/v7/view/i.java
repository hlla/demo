package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import org.xmlpull.v1.XmlPullParser;

public final class i
  extends MenuInflater
{
  public static final Class[] a;
  private static final Class[] e;
  public final Object[] b;
  public Context c;
  public Object d;
  private final Object[] f;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    a = arrayOfClass;
    e = arrayOfClass;
  }
  
  public i(Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
    this.b = new Object[] { paramContext };
    this.f = this.b;
  }
  
  static Object a(Object paramObject)
  {
    while ((!(paramObject instanceof Activity)) && ((paramObject instanceof ContextWrapper))) {
      paramObject = ((ContextWrapper)paramObject).getBaseContext();
    }
    return paramObject;
  }
  
  private final void a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  /* Error */
  public final void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_2
    //   6: instanceof 64
    //   9: ifeq +40 -> 49
    //   12: aload_0
    //   13: getfield 31	android/support/v7/view/i:c	Landroid/content/Context;
    //   16: invokevirtual 68	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   19: iload_1
    //   20: invokevirtual 74	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   23: astore 5
    //   25: aload 5
    //   27: astore_3
    //   28: aload_0
    //   29: aload_3
    //   30: aload_3
    //   31: invokestatic 80	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   34: aload_2
    //   35: invokespecial 82	android/support/v7/view/i:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   38: aload_3
    //   39: ifnull +9 -> 48
    //   42: aload_3
    //   43: invokeinterface 87 1 0
    //   48: return
    //   49: aload_0
    //   50: iload_1
    //   51: aload_2
    //   52: invokespecial 89	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   55: return
    //   56: astore_2
    //   57: new 91	android/view/InflateException
    //   60: dup
    //   61: ldc 93
    //   63: aload_2
    //   64: invokespecial 96	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: athrow
    //   68: astore_2
    //   69: aload_3
    //   70: astore 4
    //   72: aload_2
    //   73: astore_3
    //   74: aload 4
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +9 -> 87
    //   81: aload_2
    //   82: invokeinterface 87 1 0
    //   87: aload_3
    //   88: athrow
    //   89: astore_2
    //   90: new 91	android/view/InflateException
    //   93: dup
    //   94: ldc 93
    //   96: aload_2
    //   97: invokespecial 96	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   100: athrow
    //   101: astore 4
    //   103: aload_3
    //   104: astore_2
    //   105: aload 4
    //   107: astore_3
    //   108: goto -31 -> 77
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_2
    //   114: goto -37 -> 77
    //   117: astore 4
    //   119: aload_3
    //   120: astore_2
    //   121: aload 4
    //   123: astore_3
    //   124: goto -47 -> 77
    //   127: astore_2
    //   128: aload 4
    //   130: astore_3
    //   131: goto -41 -> 90
    //   134: astore_2
    //   135: goto -78 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	i
    //   0	138	1	paramInt	int
    //   0	138	2	paramMenu	Menu
    //   4	104	3	localObject1	Object
    //   111	9	3	localObject2	Object
    //   123	8	3	localObject3	Object
    //   1	74	4	localObject4	Object
    //   101	5	4	localObject5	Object
    //   117	12	4	localObject6	Object
    //   23	3	5	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   28	38	56	org/xmlpull/v1/XmlPullParserException
    //   57	68	68	finally
    //   28	38	89	java/io/IOException
    //   90	101	101	finally
    //   12	25	111	finally
    //   28	38	117	finally
    //   12	25	127	java/io/IOException
    //   12	25	134	org/xmlpull/v1/XmlPullParserException
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */