package android.support.v4.widget;

import android.content.Intent;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.Method;

final class aw
  implements ActionMode.Callback
{
  private final ActionMode.Callback a;
  private boolean b;
  private boolean c;
  private Class d;
  private Method e;
  private final TextView f;
  
  aw(ActionMode.Callback paramCallback, TextView paramTextView)
  {
    this.a = paramCallback;
    this.f = paramTextView;
    this.c = false;
  }
  
  private static Intent a()
  {
    return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
  }
  
  public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.a.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.a.onCreateActionMode(paramActionMode, paramMenu);
  }
  
  public final void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.a.onDestroyActionMode(paramActionMode);
  }
  
  /* Error */
  public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	android/support/v4/widget/aw:f	Landroid/widget/TextView;
    //   4: invokevirtual 71	android/widget/TextView:getContext	()Landroid/content/Context;
    //   7: astore 7
    //   9: aload 7
    //   11: invokevirtual 77	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   14: astore 6
    //   16: aload_0
    //   17: getfield 28	android/support/v4/widget/aw:c	Z
    //   20: ifne +45 -> 65
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 28	android/support/v4/widget/aw:c	Z
    //   28: aload_0
    //   29: ldc 79
    //   31: invokestatic 85	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   34: putfield 87	android/support/v4/widget/aw:d	Ljava/lang/Class;
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 87	android/support/v4/widget/aw:d	Ljava/lang/Class;
    //   42: ldc 89
    //   44: iconst_1
    //   45: anewarray 81	java/lang/Class
    //   48: dup
    //   49: iconst_0
    //   50: getstatic 94	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   53: aastore
    //   54: invokevirtual 98	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   57: putfield 100	android/support/v4/widget/aw:e	Ljava/lang/reflect/Method;
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 102	android/support/v4/widget/aw:b	Z
    //   65: aload_0
    //   66: getfield 102	android/support/v4/widget/aw:b	Z
    //   69: ifne +425 -> 494
    //   72: aload_2
    //   73: invokevirtual 106	java/lang/Object:getClass	()Ljava/lang/Class;
    //   76: ldc 89
    //   78: iconst_1
    //   79: anewarray 81	java/lang/Class
    //   82: dup
    //   83: iconst_0
    //   84: getstatic 94	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   87: aastore
    //   88: invokevirtual 98	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   91: astore 5
    //   93: aload_2
    //   94: invokeinterface 112 1 0
    //   99: istore_3
    //   100: iload_3
    //   101: iconst_1
    //   102: isub
    //   103: istore_3
    //   104: iload_3
    //   105: ifge +328 -> 433
    //   108: new 114	java/util/ArrayList
    //   111: dup
    //   112: invokespecial 115	java/util/ArrayList:<init>	()V
    //   115: astore 5
    //   117: aload 7
    //   119: instanceof 117
    //   122: ifeq +305 -> 427
    //   125: aload 6
    //   127: invokestatic 119	android/support/v4/widget/aw:a	()Landroid/content/Intent;
    //   130: iconst_0
    //   131: invokevirtual 125	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
    //   134: invokeinterface 131 1 0
    //   139: astore 8
    //   141: aload 8
    //   143: invokeinterface 137 1 0
    //   148: ifeq +111 -> 259
    //   151: aload 8
    //   153: invokeinterface 141 1 0
    //   158: checkcast 143	android/content/pm/ResolveInfo
    //   161: astore 9
    //   163: aload 7
    //   165: invokevirtual 147	android/content/Context:getPackageName	()Ljava/lang/String;
    //   168: aload 9
    //   170: getfield 151	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   173: getfield 157	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   176: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   179: ifne +75 -> 254
    //   182: aload 9
    //   184: getfield 151	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   187: getfield 166	android/content/pm/ActivityInfo:exported	Z
    //   190: ifeq +59 -> 249
    //   193: aload 9
    //   195: getfield 151	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   198: getfield 169	android/content/pm/ActivityInfo:permission	Ljava/lang/String;
    //   201: ifnull +43 -> 244
    //   204: aload 7
    //   206: aload 9
    //   208: getfield 151	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   211: getfield 169	android/content/pm/ActivityInfo:permission	Ljava/lang/String;
    //   214: invokevirtual 173	android/content/Context:checkSelfPermission	(Ljava/lang/String;)I
    //   217: ifeq +22 -> 239
    //   220: iconst_0
    //   221: istore_3
    //   222: iload_3
    //   223: ifeq -82 -> 141
    //   226: aload 5
    //   228: aload 9
    //   230: invokeinterface 176 2 0
    //   235: pop
    //   236: goto -95 -> 141
    //   239: iconst_1
    //   240: istore_3
    //   241: goto -19 -> 222
    //   244: iconst_1
    //   245: istore_3
    //   246: goto -24 -> 222
    //   249: iconst_0
    //   250: istore_3
    //   251: goto -29 -> 222
    //   254: iconst_1
    //   255: istore_3
    //   256: goto -34 -> 222
    //   259: iconst_0
    //   260: istore 4
    //   262: iload 4
    //   264: aload 5
    //   266: invokeinterface 177 1 0
    //   271: if_icmpge +144 -> 415
    //   274: aload 5
    //   276: iload 4
    //   278: invokeinterface 181 2 0
    //   283: checkcast 143	android/content/pm/ResolveInfo
    //   286: astore 7
    //   288: aload_2
    //   289: iconst_0
    //   290: iconst_0
    //   291: iload 4
    //   293: bipush 100
    //   295: iadd
    //   296: aload 7
    //   298: aload 6
    //   300: invokevirtual 185	android/content/pm/ResolveInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   303: invokeinterface 188 5 0
    //   308: astore 8
    //   310: aload_0
    //   311: getfield 26	android/support/v4/widget/aw:f	Landroid/widget/TextView;
    //   314: astore 9
    //   316: invokestatic 119	android/support/v4/widget/aw:a	()Landroid/content/Intent;
    //   319: astore 10
    //   321: aload 9
    //   323: instanceof 190
    //   326: ifeq +82 -> 408
    //   329: aload 9
    //   331: invokevirtual 193	android/widget/TextView:onCheckIsTextEditor	()Z
    //   334: ifeq +69 -> 403
    //   337: aload 9
    //   339: invokevirtual 196	android/widget/TextView:isEnabled	()Z
    //   342: ifeq +56 -> 398
    //   345: iconst_1
    //   346: istore_3
    //   347: aload 8
    //   349: aload 10
    //   351: ldc -58
    //   353: iload_3
    //   354: iconst_1
    //   355: ixor
    //   356: invokevirtual 202	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   359: aload 7
    //   361: getfield 151	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   364: getfield 157	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   367: aload 7
    //   369: getfield 151	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   372: getfield 205	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   375: invokevirtual 209	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   378: invokeinterface 215 2 0
    //   383: iconst_1
    //   384: invokeinterface 219 2 0
    //   389: iload 4
    //   391: iconst_1
    //   392: iadd
    //   393: istore 4
    //   395: goto -133 -> 262
    //   398: iconst_0
    //   399: istore_3
    //   400: goto -53 -> 347
    //   403: iconst_0
    //   404: istore_3
    //   405: goto -58 -> 347
    //   408: iconst_0
    //   409: istore_3
    //   410: goto -63 -> 347
    //   413: astore 5
    //   415: aload_0
    //   416: getfield 24	android/support/v4/widget/aw:a	Landroid/view/ActionMode$Callback;
    //   419: aload_1
    //   420: aload_2
    //   421: invokeinterface 221 3 0
    //   426: ireturn
    //   427: iconst_0
    //   428: istore 4
    //   430: goto -168 -> 262
    //   433: aload_2
    //   434: iload_3
    //   435: invokeinterface 225 2 0
    //   440: astore 8
    //   442: aload 8
    //   444: invokeinterface 228 1 0
    //   449: ifnonnull +6 -> 455
    //   452: goto +92 -> 544
    //   455: ldc 35
    //   457: aload 8
    //   459: invokeinterface 228 1 0
    //   464: invokevirtual 231	android/content/Intent:getAction	()Ljava/lang/String;
    //   467: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   470: ifeq +74 -> 544
    //   473: aload 5
    //   475: aload_2
    //   476: iconst_1
    //   477: anewarray 4	java/lang/Object
    //   480: dup
    //   481: iconst_0
    //   482: iload_3
    //   483: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   486: aastore
    //   487: invokevirtual 241	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   490: pop
    //   491: goto +53 -> 544
    //   494: aload_0
    //   495: getfield 87	android/support/v4/widget/aw:d	Ljava/lang/Class;
    //   498: aload_2
    //   499: invokevirtual 244	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   502: ifeq -430 -> 72
    //   505: aload_0
    //   506: getfield 100	android/support/v4/widget/aw:e	Ljava/lang/reflect/Method;
    //   509: astore 5
    //   511: goto -418 -> 93
    //   514: astore 5
    //   516: aload_0
    //   517: aconst_null
    //   518: putfield 87	android/support/v4/widget/aw:d	Ljava/lang/Class;
    //   521: aload_0
    //   522: aconst_null
    //   523: putfield 100	android/support/v4/widget/aw:e	Ljava/lang/reflect/Method;
    //   526: aload_0
    //   527: iconst_0
    //   528: putfield 102	android/support/v4/widget/aw:b	Z
    //   531: goto -466 -> 65
    //   534: astore 5
    //   536: goto -121 -> 415
    //   539: astore 5
    //   541: goto -25 -> 516
    //   544: iload_3
    //   545: iconst_1
    //   546: isub
    //   547: istore_3
    //   548: goto -444 -> 104
    //   551: astore 5
    //   553: goto -138 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	0	this	aw
    //   0	556	1	paramActionMode	ActionMode
    //   0	556	2	paramMenu	Menu
    //   99	449	3	i	int
    //   260	169	4	j	int
    //   91	184	5	localObject1	Object
    //   413	61	5	localIllegalAccessException	IllegalAccessException
    //   509	1	5	localMethod	Method
    //   514	1	5	localClassNotFoundException	ClassNotFoundException
    //   534	1	5	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   539	1	5	localNoSuchMethodException1	NoSuchMethodException
    //   551	1	5	localNoSuchMethodException2	NoSuchMethodException
    //   14	285	6	localPackageManager	android.content.pm.PackageManager
    //   7	361	7	localObject2	Object
    //   139	319	8	localObject3	Object
    //   161	177	9	localObject4	Object
    //   319	31	10	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   65	72	413	java/lang/IllegalAccessException
    //   72	93	413	java/lang/IllegalAccessException
    //   93	100	413	java/lang/IllegalAccessException
    //   433	452	413	java/lang/IllegalAccessException
    //   455	491	413	java/lang/IllegalAccessException
    //   494	511	413	java/lang/IllegalAccessException
    //   28	65	514	java/lang/ClassNotFoundException
    //   65	72	534	java/lang/reflect/InvocationTargetException
    //   72	93	534	java/lang/reflect/InvocationTargetException
    //   93	100	534	java/lang/reflect/InvocationTargetException
    //   433	452	534	java/lang/reflect/InvocationTargetException
    //   455	491	534	java/lang/reflect/InvocationTargetException
    //   494	511	534	java/lang/reflect/InvocationTargetException
    //   28	65	539	java/lang/NoSuchMethodException
    //   65	72	551	java/lang/NoSuchMethodException
    //   72	93	551	java/lang/NoSuchMethodException
    //   93	100	551	java/lang/NoSuchMethodException
    //   433	452	551	java/lang/NoSuchMethodException
    //   455	491	551	java/lang/NoSuchMethodException
    //   494	511	551	java/lang/NoSuchMethodException
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */