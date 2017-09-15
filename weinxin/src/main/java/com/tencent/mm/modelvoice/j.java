package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.qqpinyin.voicerecoapi.TRSpeexNative;
import java.io.FileInputStream;

public final class j
  implements d
{
  public b fBq;
  private int fRh;
  public String fyw;
  public com.tencent.qqpinyin.voicerecoapi.a ibA;
  private int ibB;
  int ibC;
  public boolean ibD;
  public byte[] ibE;
  public int ibF;
  public FileInputStream ibG;
  public int ibH;
  public String ibf;
  public String ibg;
  public MediaPlayer.OnCompletionListener ibp;
  public MediaPlayer.OnErrorListener ibq;
  public AudioTrack ibt;
  public d.a ibu;
  public d.b ibv;
  private int ibw;
  private int ibx;
  private int iby;
  private Runnable ibz;
  public int status;
  
  public j()
  {
    GMTrace.i(560493232128L, 4176);
    this.fyw = "";
    this.ibu = null;
    this.ibv = null;
    this.status = 0;
    this.ibw = 2;
    this.ibx = 16000;
    this.fRh = 1;
    this.iby = 20;
    this.ibA = null;
    this.ibC = 0;
    this.ibD = false;
    this.ibf = "";
    this.ibg = "";
    this.ibE = new byte[com.tencent.qqpinyin.voicerecoapi.a.wNu];
    this.ibF = 0;
    this.ibG = null;
    this.ibH = 314;
    this.ibp = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        GMTrace.i(559151054848L, 4166);
        if (j.this.fBq != null) {
          j.this.fBq.rY();
        }
        try
        {
          j.this.status = 0;
          if (j.this.ibt != null)
          {
            j.this.ibt.stop();
            j.this.ibt.release();
            j.this.ibt = null;
          }
          try
          {
            j.this.join();
            GMTrace.o(559151054848L, 4166);
            return;
          }
          catch (InterruptedException paramAnonymousMediaPlayer)
          {
            v.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bf.g(paramAnonymousMediaPlayer) });
            GMTrace.o(559151054848L, 4166);
            return;
          }
          return;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          v.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bf.g(paramAnonymousMediaPlayer) });
          v.e("MicroMsg.SpeexPlayer", "setCompletion File[" + j.this.fyw + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          GMTrace.o(559151054848L, 4166);
        }
      }
    };
    this.ibq = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(537542000640L, 4005);
        v.d("MicroMsg.SpeexPlayer", "onError");
        if (j.this.fBq != null) {
          j.this.fBq.rY();
        }
        if (j.this.ibv != null) {
          j.this.ibv.onError();
        }
        for (;;)
        {
          try
          {
            j.this.status = -1;
            if (j.this.ibt != null)
            {
              j.this.ibt.stop();
              j.this.ibt.release();
              j.this.ibt = null;
            }
          }
          catch (Exception paramAnonymousMediaPlayer)
          {
            v.e("MicroMsg.SpeexPlayer", "setErrorListener File[" + j.this.fyw + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
            continue;
          }
          try
          {
            j.this.join();
            GMTrace.o(537542000640L, 4005);
            return false;
          }
          catch (InterruptedException paramAnonymousMediaPlayer)
          {
            v.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bf.g(paramAnonymousMediaPlayer) });
          }
        }
      }
    };
    this.ibA = new com.tencent.qqpinyin.voicerecoapi.a();
    com.tencent.qqpinyin.voicerecoapi.a locala = this.ibA;
    if (locala.wNy != 0) {
      i = -103;
    }
    for (;;)
    {
      if (i != 0) {
        v.e("speex", "res: " + i);
      }
      GMTrace.o(560493232128L, 4176);
      return;
      int j = locala.wNz.nativeTRSpeexDecodeInit();
      if ((j == -1) || (j == -100) || (j == -101) || (j == -102))
      {
        i = j;
      }
      else
      {
        locala.wNy = j;
        locala.wNw = new byte[com.tencent.qqpinyin.voicerecoapi.a.wNu * 15];
      }
    }
  }
  
  public j(Context paramContext)
  {
    this();
    GMTrace.i(560627449856L, 4177);
    this.fBq = new b(paramContext);
    GMTrace.o(560627449856L, 4177);
  }
  
  private boolean D(String paramString, boolean paramBoolean)
  {
    GMTrace.i(561432756224L, 4183);
    if (this.status != 0)
    {
      v.e("MicroMsg.SpeexPlayer", "startPlay error status:" + this.status);
      GMTrace.o(561432756224L, 4183);
      return false;
    }
    v.i("MicroMsg.SpeexPlayer", "startPlay");
    this.status = 1;
    this.fyw = paramString;
    try
    {
      bw(paramBoolean);
      GMTrace.o(561432756224L, 4183);
      return true;
    }
    catch (Exception paramString)
    {
      try
      {
        bw(true);
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.SpeexPlayer", "startPlay File[" + this.fyw + "] failed");
        v.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bf.g(paramString) });
        this.status = -1;
        GMTrace.o(561432756224L, 4183);
      }
    }
    return false;
  }
  
  private void bw(boolean paramBoolean)
  {
    GMTrace.i(561566973952L, 4184);
    if (!com.tencent.mm.a.e.aO(this.fyw))
    {
      GMTrace.o(561566973952L, 4184);
      return;
    }
    int i;
    if (paramBoolean) {
      i = 3;
    }
    for (;;)
    {
      int j = i;
      try
      {
        if (p.gQT.gND)
        {
          p.gQT.dump();
          j = i;
          if (p.gQT.gNK == 1) {
            j = 3;
          }
        }
        this.ibB = AudioTrack.getMinBufferSize(this.ibx, this.ibw, 2);
        if (this.ibt != null)
        {
          this.ibt.stop();
          this.ibt.release();
          this.ibt = null;
        }
        this.ibt = new c(j, this.ibx, this.ibw, 2, this.ibB * 8);
        this.ibH = (this.ibx / 1000 * this.fRh * this.iby * 2);
        if (this.fBq != null) {
          this.fBq.requestFocus();
        }
        AudioTrack localAudioTrack = this.ibt;
        if (localAudioTrack != null) {}
        try
        {
          this.ibt.play();
          this.ibz = new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: ldc2_w 35
              //   3: sipush 4211
              //   6: invokestatic 25	com/tencent/gmtrace/GMTrace:i	(JI)V
              //   9: bipush -16
              //   11: invokestatic 42	android/os/Process:setThreadPriority	(I)V
              //   14: aload_0
              //   15: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   18: new 44	java/io/FileInputStream
              //   21: dup
              //   22: aload_0
              //   23: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   26: getfield 48	com/tencent/mm/modelvoice/j:fyw	Ljava/lang/String;
              //   29: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
              //   32: putfield 55	com/tencent/mm/modelvoice/j:ibG	Ljava/io/FileInputStream;
              //   35: aload_0
              //   36: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   39: getfield 59	com/tencent/mm/modelvoice/j:status	I
              //   42: iconst_1
              //   43: if_icmpeq +14 -> 57
              //   46: aload_0
              //   47: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   50: getfield 59	com/tencent/mm/modelvoice/j:status	I
              //   53: iconst_2
              //   54: if_icmpne +718 -> 772
              //   57: aload_0
              //   58: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   61: aload_0
              //   62: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   65: getfield 55	com/tencent/mm/modelvoice/j:ibG	Ljava/io/FileInputStream;
              //   68: aload_0
              //   69: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   72: getfield 63	com/tencent/mm/modelvoice/j:ibE	[B
              //   75: invokevirtual 67	java/io/FileInputStream:read	([B)I
              //   78: putfield 70	com/tencent/mm/modelvoice/j:ibF	I
              //   81: aload_0
              //   82: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   85: getfield 70	com/tencent/mm/modelvoice/j:ibF	I
              //   88: iconst_m1
              //   89: if_icmpeq +561 -> 650
              //   92: aload_0
              //   93: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   96: getfield 74	com/tencent/mm/modelvoice/j:ibA	Lcom/tencent/qqpinyin/voicerecoapi/a;
              //   99: astore 4
              //   101: aload_0
              //   102: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   105: getfield 63	com/tencent/mm/modelvoice/j:ibE	[B
              //   108: astore_3
              //   109: aload_0
              //   110: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   113: getfield 70	com/tencent/mm/modelvoice/j:ibF	I
              //   116: istore_1
              //   117: aload 4
              //   119: getfield 79	com/tencent/qqpinyin/voicerecoapi/a:wNy	I
              //   122: ifne +203 -> 325
              //   125: new 81	com/tencent/qqpinyin/voicerecoapi/b
              //   128: dup
              //   129: bipush -102
              //   131: invokespecial 83	com/tencent/qqpinyin/voicerecoapi/b:<init>	(I)V
              //   134: athrow
              //   135: astore_3
              //   136: ldc 85
              //   138: ldc 87
              //   140: iconst_1
              //   141: anewarray 4	java/lang/Object
              //   144: dup
              //   145: iconst_0
              //   146: aload_3
              //   147: invokestatic 93	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
              //   150: aastore
              //   151: invokestatic 99	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   154: aload_0
              //   155: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   158: getfield 103	com/tencent/mm/modelvoice/j:ibq	Landroid/media/MediaPlayer$OnErrorListener;
              //   161: ifnull +19 -> 180
              //   164: aload_0
              //   165: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   168: getfield 103	com/tencent/mm/modelvoice/j:ibq	Landroid/media/MediaPlayer$OnErrorListener;
              //   171: aconst_null
              //   172: iconst_0
              //   173: iconst_0
              //   174: invokeinterface 109 4 0
              //   179: pop
              //   180: aload_0
              //   181: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   184: iconst_0
              //   185: putfield 59	com/tencent/mm/modelvoice/j:status	I
              //   188: aload_0
              //   189: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   192: getfield 55	com/tencent/mm/modelvoice/j:ibG	Ljava/io/FileInputStream;
              //   195: ifnull +21 -> 216
              //   198: aload_0
              //   199: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   202: getfield 55	com/tencent/mm/modelvoice/j:ibG	Ljava/io/FileInputStream;
              //   205: invokevirtual 112	java/io/FileInputStream:close	()V
              //   208: aload_0
              //   209: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   212: aconst_null
              //   213: putfield 55	com/tencent/mm/modelvoice/j:ibG	Ljava/io/FileInputStream;
              //   216: aload_0
              //   217: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   220: getfield 74	com/tencent/mm/modelvoice/j:ibA	Lcom/tencent/qqpinyin/voicerecoapi/a;
              //   223: astore_3
              //   224: aload_3
              //   225: getfield 79	com/tencent/qqpinyin/voicerecoapi/a:wNy	I
              //   228: ifne +586 -> 814
              //   231: bipush -102
              //   233: istore_1
              //   234: aload_0
              //   235: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   238: getfield 59	com/tencent/mm/modelvoice/j:status	I
              //   241: iconst_3
              //   242: if_icmpeq +48 -> 290
              //   245: aload_0
              //   246: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   249: getfield 116	com/tencent/mm/modelvoice/j:ibu	Lcom/tencent/mm/modelvoice/d$a;
              //   252: ifnull +15 -> 267
              //   255: aload_0
              //   256: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   259: getfield 116	com/tencent/mm/modelvoice/j:ibu	Lcom/tencent/mm/modelvoice/d$a;
              //   262: invokeinterface 121 1 0
              //   267: aload_0
              //   268: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   271: getfield 125	com/tencent/mm/modelvoice/j:ibp	Landroid/media/MediaPlayer$OnCompletionListener;
              //   274: ifnull +16 -> 290
              //   277: aload_0
              //   278: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   281: getfield 125	com/tencent/mm/modelvoice/j:ibp	Landroid/media/MediaPlayer$OnCompletionListener;
              //   284: aconst_null
              //   285: invokeinterface 131 2 0
              //   290: iload_1
              //   291: ifeq +24 -> 315
              //   294: ldc 85
              //   296: new 133	java/lang/StringBuilder
              //   299: dup
              //   300: ldc -121
              //   302: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
              //   305: iload_1
              //   306: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
              //   309: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   312: invokestatic 147	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
              //   315: ldc2_w 35
              //   318: sipush 4211
              //   321: invokestatic 28	com/tencent/gmtrace/GMTrace:o	(JI)V
              //   324: return
              //   325: aload_3
              //   326: ifnull +8 -> 334
              //   329: aload_3
              //   330: arraylength
              //   331: ifne +13 -> 344
              //   334: new 81	com/tencent/qqpinyin/voicerecoapi/b
              //   337: dup
              //   338: bipush -104
              //   340: invokespecial 83	com/tencent/qqpinyin/voicerecoapi/b:<init>	(I)V
              //   343: athrow
              //   344: aload 4
              //   346: getfield 151	com/tencent/qqpinyin/voicerecoapi/a:wNz	Lcom/tencent/qqpinyin/voicerecoapi/TRSpeexNative;
              //   349: aload 4
              //   351: getfield 79	com/tencent/qqpinyin/voicerecoapi/a:wNy	I
              //   354: aload_3
              //   355: iconst_0
              //   356: iload_1
              //   357: aload 4
              //   359: getfield 154	com/tencent/qqpinyin/voicerecoapi/a:wNw	[B
              //   362: invokevirtual 160	com/tencent/qqpinyin/voicerecoapi/TRSpeexNative:nativeTRSpeexDecode	(I[BII[B)I
              //   365: istore_1
              //   366: iload_1
              //   367: ifge +472 -> 839
              //   370: new 81	com/tencent/qqpinyin/voicerecoapi/b
              //   373: dup
              //   374: iload_1
              //   375: invokespecial 83	com/tencent/qqpinyin/voicerecoapi/b:<init>	(I)V
              //   378: athrow
              //   379: aload_0
              //   380: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   383: iconst_0
              //   384: putfield 59	com/tencent/mm/modelvoice/j:status	I
              //   387: goto -352 -> 35
              //   390: iload_1
              //   391: newarray <illegal type>
              //   393: astore_3
              //   394: aload 4
              //   396: getfield 154	com/tencent/qqpinyin/voicerecoapi/a:wNw	[B
              //   399: iconst_0
              //   400: aload_3
              //   401: iconst_0
              //   402: iload_1
              //   403: invokestatic 166	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
              //   406: goto +439 -> 845
              //   409: aload_3
              //   410: arraylength
              //   411: istore_1
              //   412: iconst_0
              //   413: istore_2
              //   414: iload_1
              //   415: aload_0
              //   416: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   419: getfield 169	com/tencent/mm/modelvoice/j:ibH	I
              //   422: if_icmplt +96 -> 518
              //   425: aload_0
              //   426: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   429: getfield 59	com/tencent/mm/modelvoice/j:status	I
              //   432: iconst_1
              //   433: if_icmpne +85 -> 518
              //   436: aload_0
              //   437: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   440: getfield 173	com/tencent/mm/modelvoice/j:ibD	Z
              //   443: ifeq +12 -> 455
              //   446: ldc2_w 174
              //   449: invokestatic 181	java/lang/Thread:sleep	(J)V
              //   452: goto -38 -> 414
              //   455: aload_0
              //   456: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   459: getfield 185	com/tencent/mm/modelvoice/j:ibt	Landroid/media/AudioTrack;
              //   462: ifnull -48 -> 414
              //   465: aload_0
              //   466: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   469: getfield 173	com/tencent/mm/modelvoice/j:ibD	Z
              //   472: ifne -58 -> 414
              //   475: aload_0
              //   476: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   479: getfield 185	com/tencent/mm/modelvoice/j:ibt	Landroid/media/AudioTrack;
              //   482: aload_3
              //   483: iload_2
              //   484: aload_0
              //   485: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   488: getfield 169	com/tencent/mm/modelvoice/j:ibH	I
              //   491: invokevirtual 191	android/media/AudioTrack:write	([BII)I
              //   494: pop
              //   495: iload_2
              //   496: aload_0
              //   497: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   500: getfield 169	com/tencent/mm/modelvoice/j:ibH	I
              //   503: iadd
              //   504: istore_2
              //   505: iload_1
              //   506: aload_0
              //   507: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   510: getfield 169	com/tencent/mm/modelvoice/j:ibH	I
              //   513: isub
              //   514: istore_1
              //   515: goto -101 -> 414
              //   518: iload_1
              //   519: aload_0
              //   520: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   523: getfield 169	com/tencent/mm/modelvoice/j:ibH	I
              //   526: if_icmpge +31 -> 557
              //   529: iload_1
              //   530: ifle +27 -> 557
              //   533: aload_0
              //   534: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   537: getfield 185	com/tencent/mm/modelvoice/j:ibt	Landroid/media/AudioTrack;
              //   540: ifnull +17 -> 557
              //   543: aload_0
              //   544: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   547: getfield 185	com/tencent/mm/modelvoice/j:ibt	Landroid/media/AudioTrack;
              //   550: aload_3
              //   551: iload_2
              //   552: iload_1
              //   553: invokevirtual 191	android/media/AudioTrack:write	([BII)I
              //   556: pop
              //   557: aload_0
              //   558: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   561: getfield 59	com/tencent/mm/modelvoice/j:status	I
              //   564: iconst_2
              //   565: if_icmpne +151 -> 716
              //   568: aload_0
              //   569: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   572: getfield 194	com/tencent/mm/modelvoice/j:ibg	Ljava/lang/String;
              //   575: astore_3
              //   576: aload_3
              //   577: monitorenter
              //   578: ldc 85
              //   580: ldc -60
              //   582: invokestatic 199	com/tencent/mm/sdk/platformtools/v:v	(Ljava/lang/String;Ljava/lang/String;)V
              //   585: aload_0
              //   586: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   589: getfield 194	com/tencent/mm/modelvoice/j:ibg	Ljava/lang/String;
              //   592: invokevirtual 202	java/lang/Object:notify	()V
              //   595: ldc 85
              //   597: ldc -52
              //   599: invokestatic 199	com/tencent/mm/sdk/platformtools/v:v	(Ljava/lang/String;Ljava/lang/String;)V
              //   602: aload_3
              //   603: monitorexit
              //   604: aload_0
              //   605: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   608: getfield 207	com/tencent/mm/modelvoice/j:ibf	Ljava/lang/String;
              //   611: astore_3
              //   612: aload_3
              //   613: monitorenter
              //   614: ldc 85
              //   616: ldc -47
              //   618: invokestatic 199	com/tencent/mm/sdk/platformtools/v:v	(Ljava/lang/String;Ljava/lang/String;)V
              //   621: aload_0
              //   622: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   625: getfield 207	com/tencent/mm/modelvoice/j:ibf	Ljava/lang/String;
              //   628: invokevirtual 212	java/lang/Object:wait	()V
              //   631: ldc 85
              //   633: ldc -42
              //   635: invokestatic 199	com/tencent/mm/sdk/platformtools/v:v	(Ljava/lang/String;Ljava/lang/String;)V
              //   638: aload_3
              //   639: monitorexit
              //   640: goto -605 -> 35
              //   643: astore 4
              //   645: aload_3
              //   646: monitorexit
              //   647: aload 4
              //   649: athrow
              //   650: aload_0
              //   651: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   654: iconst_0
              //   655: putfield 59	com/tencent/mm/modelvoice/j:status	I
              //   658: goto -101 -> 557
              //   661: astore 4
              //   663: ldc 85
              //   665: ldc 87
              //   667: iconst_1
              //   668: anewarray 4	java/lang/Object
              //   671: dup
              //   672: iconst_0
              //   673: aload 4
              //   675: invokestatic 93	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
              //   678: aastore
              //   679: invokestatic 99	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   682: goto -80 -> 602
              //   685: astore 4
              //   687: aload_3
              //   688: monitorexit
              //   689: aload 4
              //   691: athrow
              //   692: astore 4
              //   694: ldc 85
              //   696: ldc 87
              //   698: iconst_1
              //   699: anewarray 4	java/lang/Object
              //   702: dup
              //   703: iconst_0
              //   704: aload 4
              //   706: invokestatic 93	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
              //   709: aastore
              //   710: invokestatic 99	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   713: goto -75 -> 638
              //   716: aload_0
              //   717: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   720: getfield 194	com/tencent/mm/modelvoice/j:ibg	Ljava/lang/String;
              //   723: astore_3
              //   724: aload_3
              //   725: monitorenter
              //   726: aload_0
              //   727: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   730: getfield 194	com/tencent/mm/modelvoice/j:ibg	Ljava/lang/String;
              //   733: invokevirtual 202	java/lang/Object:notify	()V
              //   736: aload_3
              //   737: monitorexit
              //   738: goto -703 -> 35
              //   741: astore 4
              //   743: aload_3
              //   744: monitorexit
              //   745: aload 4
              //   747: athrow
              //   748: astore 4
              //   750: ldc 85
              //   752: ldc 87
              //   754: iconst_1
              //   755: anewarray 4	java/lang/Object
              //   758: dup
              //   759: iconst_0
              //   760: aload 4
              //   762: invokestatic 93	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
              //   765: aastore
              //   766: invokestatic 99	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   769: goto -33 -> 736
              //   772: aload_0
              //   773: getfield 14	com/tencent/mm/modelvoice/j$3:ibI	Lcom/tencent/mm/modelvoice/j;
              //   776: getfield 59	com/tencent/mm/modelvoice/j:status	I
              //   779: iconst_3
              //   780: if_icmpeq -592 -> 188
              //   783: ldc2_w 215
              //   786: invokestatic 181	java/lang/Thread:sleep	(J)V
              //   789: goto -601 -> 188
              //   792: astore_3
              //   793: ldc 85
              //   795: ldc 87
              //   797: iconst_1
              //   798: anewarray 4	java/lang/Object
              //   801: dup
              //   802: iconst_0
              //   803: aload_3
              //   804: invokestatic 93	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
              //   807: aastore
              //   808: invokestatic 99	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   811: goto -603 -> 208
              //   814: aload_3
              //   815: aconst_null
              //   816: putfield 154	com/tencent/qqpinyin/voicerecoapi/a:wNw	[B
              //   819: aload_3
              //   820: getfield 151	com/tencent/qqpinyin/voicerecoapi/a:wNz	Lcom/tencent/qqpinyin/voicerecoapi/TRSpeexNative;
              //   823: aload_3
              //   824: getfield 79	com/tencent/qqpinyin/voicerecoapi/a:wNy	I
              //   827: invokevirtual 220	com/tencent/qqpinyin/voicerecoapi/TRSpeexNative:nativeTRSpeexDecodeRelease	(I)I
              //   830: istore_1
              //   831: aload_3
              //   832: iconst_0
              //   833: putfield 79	com/tencent/qqpinyin/voicerecoapi/a:wNy	I
              //   836: goto -602 -> 234
              //   839: iload_1
              //   840: ifne -450 -> 390
              //   843: aconst_null
              //   844: astore_3
              //   845: aload_3
              //   846: ifnull -467 -> 379
              //   849: iload_1
              //   850: ifne -441 -> 409
              //   853: goto -474 -> 379
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	856	0	this	3
              //   116	734	1	i	int
              //   413	139	2	j	int
              //   108	1	3	arrayOfByte	byte[]
              //   135	12	3	localException1	Exception
              //   792	40	3	localIOException	java.io.IOException
              //   844	2	3	localObject2	Object
              //   99	296	4	locala	com.tencent.qqpinyin.voicerecoapi.a
              //   643	5	4	localObject3	Object
              //   661	13	4	localException2	Exception
              //   685	5	4	localObject4	Object
              //   692	13	4	localException3	Exception
              //   741	5	4	localObject5	Object
              //   748	13	4	localException4	Exception
              // Exception table:
              //   from	to	target	type
              //   9	35	135	java/lang/Exception
              //   35	57	135	java/lang/Exception
              //   57	135	135	java/lang/Exception
              //   329	334	135	java/lang/Exception
              //   334	344	135	java/lang/Exception
              //   344	366	135	java/lang/Exception
              //   370	379	135	java/lang/Exception
              //   379	387	135	java/lang/Exception
              //   390	406	135	java/lang/Exception
              //   409	412	135	java/lang/Exception
              //   414	452	135	java/lang/Exception
              //   455	515	135	java/lang/Exception
              //   518	529	135	java/lang/Exception
              //   533	557	135	java/lang/Exception
              //   557	578	135	java/lang/Exception
              //   604	614	135	java/lang/Exception
              //   647	650	135	java/lang/Exception
              //   650	658	135	java/lang/Exception
              //   689	692	135	java/lang/Exception
              //   716	726	135	java/lang/Exception
              //   745	748	135	java/lang/Exception
              //   772	789	135	java/lang/Exception
              //   614	638	643	finally
              //   638	640	643	finally
              //   645	647	643	finally
              //   694	713	643	finally
              //   578	602	661	java/lang/Exception
              //   578	602	685	finally
              //   602	604	685	finally
              //   663	682	685	finally
              //   687	689	685	finally
              //   614	638	692	java/lang/Exception
              //   726	736	741	finally
              //   736	738	741	finally
              //   743	745	741	finally
              //   750	769	741	finally
              //   726	736	748	java/lang/Exception
              //   198	208	792	java/io/IOException
            }
          };
          com.tencent.mm.sdk.f.e.post(this.ibz, "SpeexPlayer_play");
          GMTrace.o(561566973952L, 4184);
          return;
        }
        catch (Exception localException1)
        {
          v.e("MicroMsg.SpeexPlayer", "audioTrack error:%s", new Object[] { localException1.getMessage() });
          GMTrace.o(561566973952L, 4184);
          return;
        }
        i = 0;
      }
      catch (Exception localException2)
      {
        if (this.fBq != null) {
          this.fBq.rY();
        }
        v.e("MicroMsg.SpeexPlayer", "playImp : fail, exception = " + localException2.getMessage());
        v.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bf.g(localException2) });
        GMTrace.o(561566973952L, 4184);
      }
    }
  }
  
  public final boolean C(String paramString, boolean paramBoolean)
  {
    GMTrace.i(561164320768L, 4181);
    paramBoolean = D(paramString, paramBoolean);
    GMTrace.o(561164320768L, 4181);
    return paramBoolean;
  }
  
  public final void a(d.a parama)
  {
    GMTrace.i(560761667584L, 4178);
    this.ibu = parama;
    GMTrace.o(560761667584L, 4178);
  }
  
  public final void a(d.b paramb)
  {
    GMTrace.i(560895885312L, 4179);
    this.ibv = paramb;
    GMTrace.o(560895885312L, 4179);
  }
  
  /* Error */
  public final boolean ao(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc2_w 288
    //   3: ldc_w 290
    //   6: invokestatic 60	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: getfield 70	com/tencent/mm/modelvoice/j:status	I
    //   13: iconst_1
    //   14: if_icmpeq +14 -> 28
    //   17: ldc2_w 288
    //   20: ldc_w 290
    //   23: invokestatic 139	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_0
    //   29: iconst_2
    //   30: putfield 70	com/tencent/mm/modelvoice/j:status	I
    //   33: aload_0
    //   34: getfield 88	com/tencent/mm/modelvoice/j:ibg	Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: monitorenter
    //   42: ldc -85
    //   44: ldc_w 292
    //   47: invokestatic 295	com/tencent/mm/sdk/platformtools/v:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: invokestatic 301	java/lang/System:currentTimeMillis	()J
    //   53: lstore_2
    //   54: aload_0
    //   55: getfield 88	com/tencent/mm/modelvoice/j:ibg	Ljava/lang/String;
    //   58: invokevirtual 304	java/lang/Object:wait	()V
    //   61: ldc -85
    //   63: new 117	java/lang/StringBuilder
    //   66: dup
    //   67: ldc_w 306
    //   70: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: invokestatic 301	java/lang/System:currentTimeMillis	()J
    //   76: lload_2
    //   77: lsub
    //   78: invokevirtual 309	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   81: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 295	com/tencent/mm/sdk/platformtools/v:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_0
    //   88: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   91: ifnull +15 -> 106
    //   94: iload_1
    //   95: ifeq +11 -> 106
    //   98: aload_0
    //   99: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   102: invokevirtual 271	com/tencent/mm/compatible/util/b:rY	()Z
    //   105: pop
    //   106: aload 4
    //   108: monitorexit
    //   109: ldc2_w 288
    //   112: ldc_w 290
    //   115: invokestatic 139	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   118: iconst_1
    //   119: ireturn
    //   120: astore 5
    //   122: ldc -85
    //   124: ldc -66
    //   126: iconst_1
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload 5
    //   134: invokestatic 196	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   137: aastore
    //   138: invokestatic 199	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload_0
    //   142: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   145: ifnull +15 -> 160
    //   148: iload_1
    //   149: ifeq +11 -> 160
    //   152: aload_0
    //   153: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   156: invokevirtual 271	com/tencent/mm/compatible/util/b:rY	()Z
    //   159: pop
    //   160: aload 4
    //   162: monitorexit
    //   163: ldc2_w 288
    //   166: ldc_w 290
    //   169: invokestatic 139	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   172: iconst_0
    //   173: ireturn
    //   174: astore 5
    //   176: aload_0
    //   177: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   180: ifnull +15 -> 195
    //   183: iload_1
    //   184: ifeq +11 -> 195
    //   187: aload_0
    //   188: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   191: invokevirtual 271	com/tencent/mm/compatible/util/b:rY	()Z
    //   194: pop
    //   195: aload 5
    //   197: athrow
    //   198: astore 5
    //   200: aload 4
    //   202: monitorexit
    //   203: aload 5
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	j
    //   0	206	1	paramBoolean	boolean
    //   53	24	2	l	long
    //   37	164	4	str	String
    //   120	13	5	localException	Exception
    //   174	22	5	localObject1	Object
    //   198	6	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   42	87	120	java/lang/Exception
    //   42	87	174	finally
    //   122	141	174	finally
    //   87	94	198	finally
    //   98	106	198	finally
    //   106	109	198	finally
    //   141	148	198	finally
    //   152	160	198	finally
    //   160	163	198	finally
    //   176	183	198	finally
    //   187	195	198	finally
    //   195	198	198	finally
    //   200	203	198	finally
  }
  
  public final void aq(boolean paramBoolean)
  {
    int j = 3;
    GMTrace.i(561030103040L, 4180);
    this.ibD = true;
    int i;
    if (this.fRh == 2)
    {
      this.ibw = 3;
      this.ibB = AudioTrack.getMinBufferSize(this.ibx, this.ibw, 2);
      if (this.ibt != null)
      {
        this.ibt.stop();
        this.ibt.release();
        this.ibt = null;
      }
      if (!paramBoolean) {
        break label162;
      }
      i = 3;
      if (!p.gQT.gND) {
        break label192;
      }
      p.gQT.dump();
      if (p.gQT.gNK != 1) {
        break label192;
      }
      i = j;
    }
    label162:
    label192:
    for (;;)
    {
      this.ibt = new c(i, this.ibx, this.ibw, 2, this.ibB * 8);
      try
      {
        this.ibt.play();
        this.ibD = false;
        GMTrace.o(561030103040L, 4180);
        return;
        this.ibw = 2;
        break;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.e("MicroMsg.SpeexPlayer", "audioTrack error:%s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public final void b(b.a parama)
  {
    GMTrace.i(17481456418816L, 130247);
    if ((parama != null) && (this.fBq != null)) {
      this.fBq.a(parama);
    }
    GMTrace.o(17481456418816L, 130247);
  }
  
  public final boolean c(String paramString, boolean paramBoolean, int paramInt)
  {
    GMTrace.i(561298538496L, 4182);
    paramBoolean = D(paramString, paramBoolean);
    GMTrace.o(561298538496L, 4182);
    return paramBoolean;
  }
  
  public final int getStatus()
  {
    GMTrace.i(560359014400L, 4175);
    int i = this.status;
    GMTrace.o(560359014400L, 4175);
    return i;
  }
  
  public final boolean isPlaying()
  {
    GMTrace.i(561969627136L, 4187);
    if (this.status == 1)
    {
      GMTrace.o(561969627136L, 4187);
      return true;
    }
    GMTrace.o(561969627136L, 4187);
    return false;
  }
  
  public final void join()
  {
    GMTrace.i(16085457829888L, 119846);
    if (this.ibz != null)
    {
      com.tencent.mm.sdk.f.e.Q(this.ibz);
      this.ibz = null;
    }
    GMTrace.o(16085457829888L, 119846);
  }
  
  /* Error */
  public final boolean oR()
  {
    // Byte code:
    //   0: ldc2_w 339
    //   3: sipush 4186
    //   6: invokestatic 60	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: getfield 70	com/tencent/mm/modelvoice/j:status	I
    //   13: iconst_2
    //   14: if_icmpeq +14 -> 28
    //   17: ldc2_w 339
    //   20: sipush 4186
    //   23: invokestatic 139	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 70	com/tencent/mm/modelvoice/j:status	I
    //   33: aload_0
    //   34: getfield 86	com/tencent/mm/modelvoice/j:ibf	Ljava/lang/String;
    //   37: astore_1
    //   38: aload_1
    //   39: monitorenter
    //   40: ldc -85
    //   42: ldc_w 342
    //   45: invokestatic 295	com/tencent/mm/sdk/platformtools/v:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_0
    //   49: getfield 86	com/tencent/mm/modelvoice/j:ibf	Ljava/lang/String;
    //   52: invokevirtual 345	java/lang/Object:notify	()V
    //   55: ldc -85
    //   57: ldc_w 347
    //   60: invokestatic 295	com/tencent/mm/sdk/platformtools/v:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   67: ifnull +11 -> 78
    //   70: aload_0
    //   71: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   74: invokevirtual 249	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   77: pop
    //   78: aload_1
    //   79: monitorexit
    //   80: ldc2_w 339
    //   83: sipush 4186
    //   86: invokestatic 139	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   89: iconst_1
    //   90: ireturn
    //   91: astore_2
    //   92: ldc -85
    //   94: ldc -66
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_2
    //   103: invokestatic 196	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 199	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_0
    //   111: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   114: ifnull +11 -> 125
    //   117: aload_0
    //   118: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   121: invokevirtual 249	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   124: pop
    //   125: aload_1
    //   126: monitorexit
    //   127: ldc2_w 339
    //   130: sipush 4186
    //   133: invokestatic 139	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_2
    //   139: aload_0
    //   140: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   143: ifnull +11 -> 154
    //   146: aload_0
    //   147: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   150: invokevirtual 249	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   153: pop
    //   154: aload_2
    //   155: athrow
    //   156: astore_2
    //   157: aload_1
    //   158: monitorexit
    //   159: aload_2
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	j
    //   37	121	1	str	String
    //   91	12	2	localException	Exception
    //   138	17	2	localObject1	Object
    //   156	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	63	91	java/lang/Exception
    //   40	63	138	finally
    //   92	110	138	finally
    //   63	78	156	finally
    //   78	80	156	finally
    //   110	125	156	finally
    //   125	127	156	finally
    //   139	154	156	finally
    //   154	156	156	finally
    //   157	159	156	finally
  }
  
  public final double oU()
  {
    GMTrace.i(562238062592L, 4189);
    GMTrace.o(562238062592L, 4189);
    return 0.0D;
  }
  
  /* Error */
  public final boolean pd()
  {
    // Byte code:
    //   0: ldc2_w 353
    //   3: sipush 4188
    //   6: invokestatic 60	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: ldc -85
    //   11: new 117	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 356
    //   18: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 70	com/tencent/mm/modelvoice/j:status	I
    //   25: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 136	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_0
    //   35: getfield 70	com/tencent/mm/modelvoice/j:status	I
    //   38: iconst_1
    //   39: if_icmpeq +47 -> 86
    //   42: aload_0
    //   43: getfield 70	com/tencent/mm/modelvoice/j:status	I
    //   46: iconst_2
    //   47: if_icmpeq +39 -> 86
    //   50: ldc -85
    //   52: new 117	java/lang/StringBuilder
    //   55: dup
    //   56: ldc_w 358
    //   59: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 70	com/tencent/mm/modelvoice/j:status	I
    //   66: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 136	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: ldc2_w 353
    //   78: sipush 4188
    //   81: invokestatic 139	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   84: iconst_0
    //   85: ireturn
    //   86: aload_0
    //   87: iconst_3
    //   88: putfield 70	com/tencent/mm/modelvoice/j:status	I
    //   91: aload_0
    //   92: getfield 86	com/tencent/mm/modelvoice/j:ibf	Ljava/lang/String;
    //   95: astore_1
    //   96: aload_1
    //   97: monitorenter
    //   98: aload_0
    //   99: getfield 86	com/tencent/mm/modelvoice/j:ibf	Ljava/lang/String;
    //   102: invokevirtual 345	java/lang/Object:notify	()V
    //   105: aload_0
    //   106: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   109: ifnull +11 -> 120
    //   112: aload_0
    //   113: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   116: invokevirtual 271	com/tencent/mm/compatible/util/b:rY	()Z
    //   119: pop
    //   120: aload_1
    //   121: monitorexit
    //   122: ldc2_w 353
    //   125: sipush 4188
    //   128: invokestatic 139	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   131: iconst_1
    //   132: ireturn
    //   133: astore_2
    //   134: ldc -85
    //   136: ldc -66
    //   138: iconst_1
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_2
    //   145: invokestatic 196	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   148: aastore
    //   149: invokestatic 199	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_0
    //   153: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   156: ifnull +11 -> 167
    //   159: aload_0
    //   160: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   163: invokevirtual 271	com/tencent/mm/compatible/util/b:rY	()Z
    //   166: pop
    //   167: aload_1
    //   168: monitorexit
    //   169: ldc2_w 353
    //   172: sipush 4188
    //   175: invokestatic 139	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   178: iconst_0
    //   179: ireturn
    //   180: astore_2
    //   181: aload_0
    //   182: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   185: ifnull +11 -> 196
    //   188: aload_0
    //   189: getfield 163	com/tencent/mm/modelvoice/j:fBq	Lcom/tencent/mm/compatible/util/b;
    //   192: invokevirtual 271	com/tencent/mm/compatible/util/b:rY	()Z
    //   195: pop
    //   196: aload_2
    //   197: athrow
    //   198: astore_2
    //   199: aload_1
    //   200: monitorexit
    //   201: aload_2
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	j
    //   95	105	1	str	String
    //   133	12	2	localException	Exception
    //   180	17	2	localObject1	Object
    //   198	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   98	105	133	java/lang/Exception
    //   98	105	180	finally
    //   134	152	180	finally
    //   105	120	198	finally
    //   120	122	198	finally
    //   152	167	198	finally
    //   167	169	198	finally
    //   181	196	198	finally
    //   196	198	198	finally
    //   199	201	198	finally
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvoice/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */