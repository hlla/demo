package com.google.android.gms.ads.internal.x;

import com.google.android.gms.ads.internal.q.a.a;

@a
final class o
{
  private static Boolean a;
  
  /* Error */
  @android.annotation.TargetApi(19)
  static boolean a(android.webkit.WebView paramWebView)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	com/google/android/gms/ads/internal/x/o:a	Ljava/lang/Boolean;
    //   6: ifnull +15 -> 21
    //   9: getstatic 20	com/google/android/gms/ads/internal/x/o:a	Ljava/lang/Boolean;
    //   12: invokevirtual 26	java/lang/Boolean:booleanValue	()Z
    //   15: istore_1
    //   16: ldc 2
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: aload_0
    //   22: ldc 28
    //   24: aconst_null
    //   25: invokevirtual 34	android/webkit/WebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
    //   28: iconst_1
    //   29: invokestatic 38	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   32: putstatic 20	com/google/android/gms/ads/internal/x/o:a	Ljava/lang/Boolean;
    //   35: goto -26 -> 9
    //   38: astore_0
    //   39: iconst_0
    //   40: invokestatic 38	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   43: putstatic 20	com/google/android/gms/ads/internal/x/o:a	Ljava/lang/Boolean;
    //   46: goto -37 -> 9
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramWebView	android.webkit.WebView
    //   15	5	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   21	35	38	java/lang/IllegalStateException
    //   3	9	49	finally
    //   9	19	49	finally
    //   21	35	49	finally
    //   39	46	49	finally
    //   50	53	49	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/x/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */