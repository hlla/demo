package com.android.launcher2;

import android.content.BroadcastReceiver;

public class UninstallShortcutReceiver
  extends BroadcastReceiver
{
  private static final String ACTION_UNINSTALL_SHORTCUT = "com.android.launcher.action.UNINSTALL_SHORTCUT";
  
  /* Error */
  public void onReceive(android.content.Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 8
    //   2: aload_2
    //   3: invokevirtual 23	android/content/Intent:getAction	()Ljava/lang/String;
    //   6: invokevirtual 29	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aload_2
    //   14: ldc 31
    //   16: invokevirtual 35	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   19: checkcast 19	android/content/Intent
    //   22: astore 9
    //   24: aload_2
    //   25: ldc 37
    //   27: invokevirtual 41	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 7
    //   32: aload_2
    //   33: ldc 43
    //   35: iconst_1
    //   36: invokevirtual 47	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   39: istore 5
    //   41: aload 9
    //   43: ifnull -31 -> 12
    //   46: aload 7
    //   48: ifnull -36 -> 12
    //   51: aload_1
    //   52: invokevirtual 53	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   55: getstatic 59	com/android/launcher2/LauncherSettings$Favorites:CONTENT_URI	Landroid/net/Uri;
    //   58: iconst_2
    //   59: anewarray 25	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: ldc 61
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: ldc 63
    //   71: aastore
    //   72: ldc 65
    //   74: iconst_1
    //   75: anewarray 25	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: aload 7
    //   82: aastore
    //   83: aconst_null
    //   84: invokevirtual 71	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore_2
    //   88: aload_2
    //   89: ldc 63
    //   91: invokeinterface 77 2 0
    //   96: istore_3
    //   97: aload_2
    //   98: ldc 61
    //   100: invokeinterface 77 2 0
    //   105: istore 4
    //   107: new 79	java/util/ArrayList
    //   110: dup
    //   111: bipush 10
    //   113: invokespecial 82	java/util/ArrayList:<init>	(I)V
    //   116: astore 8
    //   118: aload_2
    //   119: invokeinterface 86 1 0
    //   124: istore 6
    //   126: iload 6
    //   128: ifeq +56 -> 184
    //   131: aload_2
    //   132: iload_3
    //   133: invokeinterface 90 2 0
    //   138: ifnull -20 -> 118
    //   141: aload 9
    //   143: aload_2
    //   144: iload_3
    //   145: invokeinterface 90 2 0
    //   150: iconst_0
    //   151: invokestatic 94	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
    //   154: invokevirtual 98	android/content/Intent:filterEquals	(Landroid/content/Intent;)Z
    //   157: ifeq -39 -> 118
    //   160: aload 8
    //   162: aload_2
    //   163: iload 4
    //   165: invokeinterface 102 2 0
    //   170: invokestatic 108	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   173: invokeinterface 113 2 0
    //   178: pop
    //   179: iload 5
    //   181: ifne -63 -> 118
    //   184: aload_2
    //   185: invokeinterface 116 1 0
    //   190: aload 8
    //   192: invokeinterface 119 1 0
    //   197: ifne -185 -> 12
    //   200: aconst_null
    //   201: astore_2
    //   202: aload_1
    //   203: invokevirtual 123	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   206: checkcast 125	com/android/launcher2/LauncherApplication
    //   209: astore 9
    //   211: aload 9
    //   213: ifnull +9 -> 222
    //   216: aload 9
    //   218: invokevirtual 129	com/android/launcher2/LauncherApplication:getLauncher	()Lcom/android/launcher2/Launcher;
    //   221: astore_2
    //   222: aload_1
    //   223: aload 8
    //   225: iconst_1
    //   226: invokestatic 135	com/android/launcher2/LauncherModel:deleteItemsFromDatabase	(Landroid/content/Context;Ljava/util/List;Z)V
    //   229: aload_2
    //   230: ifnull +39 -> 269
    //   233: aload_2
    //   234: invokevirtual 140	com/android/launcher2/Launcher:getBaseContext	()Landroid/content/Context;
    //   237: aload_1
    //   238: ldc -115
    //   240: iconst_1
    //   241: anewarray 143	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: aload 7
    //   248: aastore
    //   249: invokevirtual 146	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   252: iconst_0
    //   253: invokestatic 152	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   256: invokevirtual 155	android/widget/Toast:show	()V
    //   259: return
    //   260: astore_1
    //   261: aload_2
    //   262: invokeinterface 116 1 0
    //   267: aload_1
    //   268: athrow
    //   269: aload_1
    //   270: aload_1
    //   271: ldc -115
    //   273: iconst_1
    //   274: anewarray 143	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: aload 7
    //   281: aastore
    //   282: invokevirtual 146	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   285: iconst_0
    //   286: invokestatic 152	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   289: invokevirtual 155	android/widget/Toast:show	()V
    //   292: return
    //   293: astore 10
    //   295: goto -177 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	UninstallShortcutReceiver
    //   0	298	1	paramContext	android.content.Context
    //   0	298	2	paramIntent	android.content.Intent
    //   96	49	3	i	int
    //   105	59	4	j	int
    //   39	141	5	bool1	boolean
    //   124	3	6	bool2	boolean
    //   30	250	7	str	String
    //   116	108	8	localArrayList	java.util.ArrayList
    //   22	195	9	localObject	Object
    //   293	1	10	localURISyntaxException	java.net.URISyntaxException
    // Exception table:
    //   from	to	target	type
    //   118	126	260	finally
    //   131	179	260	finally
    //   131	179	293	java/net/URISyntaxException
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/UninstallShortcutReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */