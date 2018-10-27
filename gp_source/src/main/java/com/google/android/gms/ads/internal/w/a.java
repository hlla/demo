package com.google.android.gms.ads.internal.w;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.cache.CacheOffering;
import com.google.android.gms.ads.internal.util.n;
import java.util.HashMap;
import java.util.Map;

@com.google.android.gms.ads.internal.q.a.a
@TargetApi(14)
public final class a
  extends l
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener
{
  private static final Map d = new HashMap();
  public k a;
  private int e;
  private int f = 0;
  private boolean g;
  private int h;
  private int i;
  private MediaPlayer j;
  private int k;
  private final boolean l;
  private ab m;
  private Uri n;
  private int o = 0;
  private int p;
  private final ae q;
  private int r;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      d.put(Integer.valueOf(64532), "MEDIA_ERROR_IO");
      d.put(Integer.valueOf(64529), "MEDIA_ERROR_MALFORMED");
      d.put(Integer.valueOf(64526), "MEDIA_ERROR_UNSUPPORTED");
      d.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
      d.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
    }
    d.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
    Map localMap = d;
    Integer localInteger = Integer.valueOf(1);
    localMap.put(localInteger, "MEDIA_ERROR_UNKNOWN");
    d.put(localInteger, "MEDIA_INFO_UNKNOWN");
    d.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
    d.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
    d.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
    d.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
    d.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
    d.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
    if (Build.VERSION.SDK_INT >= 19)
    {
      d.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
      d.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }
  }
  
  public a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, ae paramae)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    this.q = paramae;
    this.g = paramBoolean1;
    this.l = paramBoolean2;
    this.q.a(this);
  }
  
  private final void a(float paramFloat)
  {
    MediaPlayer localMediaPlayer = this.j;
    if (localMediaPlayer != null) {}
    try
    {
      localMediaPlayer.setVolume(paramFloat, paramFloat);
      return;
    }
    catch (IllegalStateException localIllegalStateException) {}
    com.google.android.gms.ads.internal.util.e.e("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
    return;
  }
  
  private final void a(boolean paramBoolean)
  {
    com.google.android.gms.ads.internal.util.e.a("AdMediaPlayerView release");
    Object localObject = this.m;
    if (localObject != null)
    {
      ((ab)localObject).b();
      this.m = null;
    }
    localObject = this.j;
    if (localObject != null)
    {
      ((MediaPlayer)localObject).reset();
      this.j.release();
      this.j = null;
      b(0);
      if (paramBoolean)
      {
        this.o = 0;
        this.o = 0;
      }
    }
  }
  
  private final void b(int paramInt)
  {
    if (paramInt == 3)
    {
      this.q.c();
      this.c.b();
    }
    for (;;)
    {
      this.f = paramInt;
      return;
      if (this.f == 3)
      {
        this.q.a = false;
        this.c.c();
      }
    }
  }
  
  /* Error */
  private final void e()
  {
    // Byte code:
    //   0: ldc -71
    //   2: invokestatic 151	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: invokevirtual 189	com/google/android/gms/ads/internal/w/a:getSurfaceTexture	()Landroid/graphics/SurfaceTexture;
    //   9: astore_2
    //   10: aload_0
    //   11: getfield 191	com/google/android/gms/ads/internal/w/a:n	Landroid/net/Uri;
    //   14: ifnull +223 -> 237
    //   17: aload_2
    //   18: ifnull +219 -> 237
    //   21: aload_0
    //   22: iconst_0
    //   23: invokespecial 193	com/google/android/gms/ads/internal/w/a:a	(Z)V
    //   26: getstatic 199	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   29: getfield 203	com/google/android/gms/ads/internal/bt:u	Lcom/google/android/gms/ads/internal/overlay/r;
    //   32: astore_1
    //   33: aload_0
    //   34: new 135	android/media/MediaPlayer
    //   37: dup
    //   38: invokespecial 204	android/media/MediaPlayer:<init>	()V
    //   41: putfield 133	com/google/android/gms/ads/internal/w/a:j	Landroid/media/MediaPlayer;
    //   44: aload_0
    //   45: getfield 133	com/google/android/gms/ads/internal/w/a:j	Landroid/media/MediaPlayer;
    //   48: aload_0
    //   49: invokevirtual 208	android/media/MediaPlayer:setOnBufferingUpdateListener	(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V
    //   52: aload_0
    //   53: getfield 133	com/google/android/gms/ads/internal/w/a:j	Landroid/media/MediaPlayer;
    //   56: aload_0
    //   57: invokevirtual 212	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   60: aload_0
    //   61: getfield 133	com/google/android/gms/ads/internal/w/a:j	Landroid/media/MediaPlayer;
    //   64: aload_0
    //   65: invokevirtual 216	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   68: aload_0
    //   69: getfield 133	com/google/android/gms/ads/internal/w/a:j	Landroid/media/MediaPlayer;
    //   72: aload_0
    //   73: invokevirtual 220	android/media/MediaPlayer:setOnInfoListener	(Landroid/media/MediaPlayer$OnInfoListener;)V
    //   76: aload_0
    //   77: getfield 133	com/google/android/gms/ads/internal/w/a:j	Landroid/media/MediaPlayer;
    //   80: aload_0
    //   81: invokevirtual 224	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   84: aload_0
    //   85: getfield 133	com/google/android/gms/ads/internal/w/a:j	Landroid/media/MediaPlayer;
    //   88: aload_0
    //   89: invokevirtual 228	android/media/MediaPlayer:setOnVideoSizeChangedListener	(Landroid/media/MediaPlayer$OnVideoSizeChangedListener;)V
    //   92: aload_0
    //   93: iconst_0
    //   94: putfield 230	com/google/android/gms/ads/internal/w/a:e	I
    //   97: aload_2
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 121	com/google/android/gms/ads/internal/w/a:g	Z
    //   103: ifeq +67 -> 170
    //   106: aload_0
    //   107: new 155	com/google/android/gms/ads/internal/w/ab
    //   110: dup
    //   111: aload_0
    //   112: invokevirtual 234	com/google/android/gms/ads/internal/w/a:getContext	()Landroid/content/Context;
    //   115: invokespecial 235	com/google/android/gms/ads/internal/w/ab:<init>	(Landroid/content/Context;)V
    //   118: putfield 153	com/google/android/gms/ads/internal/w/a:m	Lcom/google/android/gms/ads/internal/w/ab;
    //   121: aload_0
    //   122: getfield 153	com/google/android/gms/ads/internal/w/a:m	Lcom/google/android/gms/ads/internal/w/ab;
    //   125: aload_2
    //   126: aload_0
    //   127: invokevirtual 239	com/google/android/gms/ads/internal/w/a:getWidth	()I
    //   130: aload_0
    //   131: invokevirtual 242	com/google/android/gms/ads/internal/w/a:getHeight	()I
    //   134: invokevirtual 245	com/google/android/gms/ads/internal/w/ab:a	(Landroid/graphics/SurfaceTexture;II)V
    //   137: aload_0
    //   138: getfield 153	com/google/android/gms/ads/internal/w/a:m	Lcom/google/android/gms/ads/internal/w/ab;
    //   141: invokevirtual 248	com/google/android/gms/ads/internal/w/ab:start	()V
    //   144: aload_0
    //   145: getfield 153	com/google/android/gms/ads/internal/w/a:m	Lcom/google/android/gms/ads/internal/w/ab;
    //   148: invokevirtual 250	com/google/android/gms/ads/internal/w/ab:c	()Landroid/graphics/SurfaceTexture;
    //   151: astore_1
    //   152: aload_1
    //   153: ifnonnull +85 -> 238
    //   156: aload_0
    //   157: getfield 153	com/google/android/gms/ads/internal/w/a:m	Lcom/google/android/gms/ads/internal/w/ab;
    //   160: invokevirtual 158	com/google/android/gms/ads/internal/w/ab:b	()V
    //   163: aload_0
    //   164: aconst_null
    //   165: putfield 153	com/google/android/gms/ads/internal/w/a:m	Lcom/google/android/gms/ads/internal/w/ab;
    //   168: aload_2
    //   169: astore_1
    //   170: aload_0
    //   171: getfield 133	com/google/android/gms/ads/internal/w/a:j	Landroid/media/MediaPlayer;
    //   174: aload_0
    //   175: invokevirtual 234	com/google/android/gms/ads/internal/w/a:getContext	()Landroid/content/Context;
    //   178: aload_0
    //   179: getfield 191	com/google/android/gms/ads/internal/w/a:n	Landroid/net/Uri;
    //   182: invokevirtual 254	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   185: getstatic 199	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   188: getfield 258	com/google/android/gms/ads/internal/bt:v	Lcom/google/android/gms/ads/internal/overlay/s;
    //   191: astore_2
    //   192: new 260	android/view/Surface
    //   195: dup
    //   196: aload_1
    //   197: invokespecial 263	android/view/Surface:<init>	(Landroid/graphics/SurfaceTexture;)V
    //   200: astore_1
    //   201: aload_0
    //   202: getfield 133	com/google/android/gms/ads/internal/w/a:j	Landroid/media/MediaPlayer;
    //   205: aload_1
    //   206: invokevirtual 267	android/media/MediaPlayer:setSurface	(Landroid/view/Surface;)V
    //   209: aload_0
    //   210: getfield 133	com/google/android/gms/ads/internal/w/a:j	Landroid/media/MediaPlayer;
    //   213: iconst_3
    //   214: invokevirtual 270	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   217: aload_0
    //   218: getfield 133	com/google/android/gms/ads/internal/w/a:j	Landroid/media/MediaPlayer;
    //   221: iconst_1
    //   222: invokevirtual 273	android/media/MediaPlayer:setScreenOnWhilePlaying	(Z)V
    //   225: aload_0
    //   226: getfield 133	com/google/android/gms/ads/internal/w/a:j	Landroid/media/MediaPlayer;
    //   229: invokevirtual 276	android/media/MediaPlayer:prepareAsync	()V
    //   232: aload_0
    //   233: iconst_1
    //   234: invokespecial 167	com/google/android/gms/ads/internal/w/a:b	(I)V
    //   237: return
    //   238: goto -68 -> 170
    //   241: astore_1
    //   242: aload_0
    //   243: getfield 191	com/google/android/gms/ads/internal/w/a:n	Landroid/net/Uri;
    //   246: invokestatic 281	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   249: astore_2
    //   250: new 283	java/lang/StringBuilder
    //   253: dup
    //   254: aload_2
    //   255: invokestatic 281	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   258: invokevirtual 286	java/lang/String:length	()I
    //   261: bipush 36
    //   263: iadd
    //   264: invokespecial 288	java/lang/StringBuilder:<init>	(I)V
    //   267: astore_3
    //   268: aload_3
    //   269: ldc_w 290
    //   272: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_3
    //   277: aload_2
    //   278: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_3
    //   283: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: aload_1
    //   287: invokestatic 301	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   290: aload_0
    //   291: aload_0
    //   292: getfield 133	com/google/android/gms/ads/internal/w/a:j	Landroid/media/MediaPlayer;
    //   295: iconst_1
    //   296: iconst_0
    //   297: invokevirtual 305	com/google/android/gms/ads/internal/w/a:onError	(Landroid/media/MediaPlayer;II)Z
    //   300: pop
    //   301: return
    //   302: astore_1
    //   303: goto -61 -> 242
    //   306: astore_1
    //   307: goto -65 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	a
    //   32	174	1	localObject1	Object
    //   241	46	1	localIllegalStateException	IllegalStateException
    //   302	1	1	localIOException	java.io.IOException
    //   306	1	1	localIllegalArgumentException	IllegalArgumentException
    //   9	269	2	localObject2	Object
    //   267	16	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   26	97	241	java/lang/IllegalStateException
    //   99	152	241	java/lang/IllegalStateException
    //   156	168	241	java/lang/IllegalStateException
    //   170	237	241	java/lang/IllegalStateException
    //   26	97	302	java/io/IOException
    //   99	152	302	java/io/IOException
    //   156	168	302	java/io/IOException
    //   170	237	302	java/io/IOException
    //   26	97	306	java/lang/IllegalArgumentException
    //   99	152	306	java/lang/IllegalArgumentException
    //   156	168	306	java/lang/IllegalArgumentException
    //   170	237	306	java/lang/IllegalArgumentException
  }
  
  private final void f()
  {
    long l1;
    if ((this.l) && (g()) && (this.j.getCurrentPosition() > 0) && (this.o != 3))
    {
      com.google.android.gms.ads.internal.util.e.a("AdMediaPlayerView nudging MediaPlayer");
      a(0.0F);
      this.j.start();
      int i1 = this.j.getCurrentPosition();
      l1 = bt.A.l.a();
      if ((g()) && (this.j.getCurrentPosition() == i1)) {
        break label100;
      }
    }
    for (;;)
    {
      this.j.pause();
      d();
      return;
      label100:
      if (bt.A.l.a() - l1 <= 250L) {
        break;
      }
    }
  }
  
  private final boolean g()
  {
    if (this.j != null)
    {
      int i1 = this.f;
      if ((i1 != -1) && (i1 != 0) && (i1 != 1)) {
        return true;
      }
    }
    return false;
  }
  
  public final void a()
  {
    com.google.android.gms.ads.internal.util.e.a("AdMediaPlayerView stop");
    MediaPlayer localMediaPlayer = this.j;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
      this.j.release();
      this.j = null;
      b(0);
      this.o = 0;
    }
    this.q.b();
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    ab localab = this.m;
    if (localab != null) {
      localab.a(paramFloat1, paramFloat2);
    }
  }
  
  public final void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(34);
    localStringBuilder.append("AdMediaPlayerView seek ");
    localStringBuilder.append(paramInt);
    com.google.android.gms.ads.internal.util.e.a(localStringBuilder.toString());
    if (g())
    {
      this.j.seekTo(paramInt);
      this.k = 0;
      return;
    }
    this.k = paramInt;
  }
  
  public final void b()
  {
    com.google.android.gms.ads.internal.util.e.a("AdMediaPlayerView play");
    if (g())
    {
      this.j.start();
      b(3);
      this.b.a = true;
      n.a.post(new i(this));
    }
    this.o = 3;
  }
  
  public final void c()
  {
    com.google.android.gms.ads.internal.util.e.a("AdMediaPlayerView pause");
    if ((g()) && (this.j.isPlaying()))
    {
      this.j.pause();
      b(4);
      n.a.post(new j(this));
    }
    this.o = 4;
  }
  
  public final void d()
  {
    a(this.c.a());
  }
  
  public final int getBufferPercentage()
  {
    if (this.j == null) {
      return 0;
    }
    return this.e;
  }
  
  public final int getCurrentPosition()
  {
    if (g()) {
      return this.j.getCurrentPosition();
    }
    return 0;
  }
  
  public final int getCurrentState()
  {
    return this.f;
  }
  
  public final int getDuration()
  {
    if (g()) {
      return this.j.getDuration();
    }
    return -1;
  }
  
  public final String getPlayerName()
  {
    if (!this.g) {}
    for (String str = "";; str = " spherical")
    {
      str = String.valueOf(str);
      if (str.length() == 0) {
        return new String("MediaPlayer");
      }
      return "MediaPlayer".concat(str);
    }
  }
  
  public final int getVideoHeight()
  {
    MediaPlayer localMediaPlayer = this.j;
    if (localMediaPlayer == null) {
      return 0;
    }
    return localMediaPlayer.getVideoHeight();
  }
  
  public final int getVideoWidth()
  {
    MediaPlayer localMediaPlayer = this.j;
    if (localMediaPlayer == null) {
      return 0;
    }
    return localMediaPlayer.getVideoWidth();
  }
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    com.google.android.gms.ads.internal.util.e.a("AdMediaPlayerView completion");
    b(5);
    this.o = 5;
    n.a.post(new d(this));
  }
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (String)d.get(Integer.valueOf(paramInt1));
    String str = (String)d.get(Integer.valueOf(paramInt2));
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramMediaPlayer).length() + 38 + String.valueOf(str).length());
    localStringBuilder.append("AdMediaPlayerView MediaPlayer error: ");
    localStringBuilder.append(paramMediaPlayer);
    localStringBuilder.append(":");
    localStringBuilder.append(str);
    com.google.android.gms.ads.internal.util.e.e(localStringBuilder.toString());
    b(-1);
    this.o = -1;
    n.a.post(new e(this, paramMediaPlayer, str));
    return true;
  }
  
  public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (String)d.get(Integer.valueOf(paramInt1));
    String str = (String)d.get(Integer.valueOf(paramInt2));
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramMediaPlayer).length() + 37 + String.valueOf(str).length());
    localStringBuilder.append("AdMediaPlayerView MediaPlayer info: ");
    localStringBuilder.append(paramMediaPlayer);
    localStringBuilder.append(":");
    localStringBuilder.append(str);
    com.google.android.gms.ads.internal.util.e.a(localStringBuilder.toString());
    return true;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = getDefaultSize(this.r, paramInt1);
    int i4 = getDefaultSize(this.p, paramInt2);
    int i1;
    int i2;
    if (this.r <= 0)
    {
      i1 = i3;
      i2 = i4;
    }
    for (;;)
    {
      setMeasuredDimension(i1, i2);
      ab localab = this.m;
      if (localab != null) {
        localab.a(i1, i2);
      }
      if (Build.VERSION.SDK_INT == 16)
      {
        paramInt1 = this.i;
        if (paramInt1 > 0) {
          break label111;
        }
      }
      for (;;)
      {
        paramInt1 = this.h;
        if (paramInt1 <= 0) {}
        while (paramInt1 == i2)
        {
          this.i = i1;
          this.h = i2;
          return;
        }
        label111:
        do
        {
          f();
          break;
        } while (paramInt1 != i1);
      }
      i2 = i4;
      i1 = i3;
      if (this.p > 0)
      {
        i2 = i4;
        i1 = i3;
        if (this.m == null)
        {
          int i6 = View.MeasureSpec.getMode(paramInt1);
          paramInt1 = View.MeasureSpec.getSize(paramInt1);
          i2 = View.MeasureSpec.getMode(paramInt2);
          paramInt2 = View.MeasureSpec.getSize(paramInt2);
          if (i6 != 1073741824) {}
          while (i2 != 1073741824)
          {
            if (i6 == 1073741824)
            {
              i1 = this.p * paramInt1 / this.r;
              if (i2 != Integer.MIN_VALUE)
              {
                i2 = i1;
                i1 = paramInt1;
                break;
              }
              if (i1 > paramInt2)
              {
                i2 = paramInt2;
                i1 = paramInt1;
                break;
              }
              i2 = i1;
              i1 = paramInt1;
              break;
            }
            if (i2 == 1073741824)
            {
              i3 = this.r * paramInt2 / this.p;
              i2 = paramInt2;
              i1 = i3;
              if (i6 != Integer.MIN_VALUE) {
                break;
              }
              i2 = paramInt2;
              i1 = i3;
              if (i3 <= paramInt1) {
                break;
              }
              i2 = paramInt2;
              i1 = paramInt1;
              break;
            }
            i4 = this.r;
            int i5 = this.p;
            if (i2 != Integer.MIN_VALUE)
            {
              paramInt2 = i5;
              i3 = i4;
            }
            for (;;)
            {
              i2 = paramInt2;
              i1 = i3;
              if (i6 != Integer.MIN_VALUE) {
                break;
              }
              i2 = paramInt2;
              i1 = i3;
              if (i3 <= paramInt1) {
                break;
              }
              i2 = paramInt1 * i5 / i4;
              i1 = paramInt1;
              break;
              if (i5 > paramInt2)
              {
                i3 = paramInt2 * i4 / i5;
              }
              else
              {
                paramInt2 = i5;
                i3 = i4;
              }
            }
          }
          i1 = this.r;
          i2 = i1 * paramInt2;
          i3 = this.p;
          i4 = paramInt1 * i3;
          if (i2 < i4)
          {
            i1 = i2 / i3;
            i2 = paramInt2;
          }
          else if (i2 > i4)
          {
            i2 = i4 / i1;
            i1 = paramInt1;
          }
          else
          {
            i2 = paramInt2;
            i1 = paramInt1;
          }
        }
      }
    }
  }
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    com.google.android.gms.ads.internal.util.e.a("AdMediaPlayerView prepared");
    b(2);
    this.q.a();
    n.a.post(new c(this));
    this.r = paramMediaPlayer.getVideoWidth();
    this.p = paramMediaPlayer.getVideoHeight();
    int i1 = this.k;
    if (i1 != 0) {
      a(i1);
    }
    f();
    i1 = this.r;
    int i2 = this.p;
    paramMediaPlayer = new StringBuilder(62);
    paramMediaPlayer.append("AdMediaPlayerView stream dimensions: ");
    paramMediaPlayer.append(i1);
    paramMediaPlayer.append(" x ");
    paramMediaPlayer.append(i2);
    com.google.android.gms.ads.internal.util.e.d(paramMediaPlayer.toString());
    if (this.o == 3) {
      b();
    }
    d();
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    com.google.android.gms.ads.internal.util.e.a("AdMediaPlayerView surface created");
    e();
    n.a.post(new f(this));
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    com.google.android.gms.ads.internal.util.e.a("AdMediaPlayerView surface destroyed");
    paramSurfaceTexture = this.j;
    if ((paramSurfaceTexture != null) && (this.k == 0)) {
      this.k = paramSurfaceTexture.getCurrentPosition();
    }
    paramSurfaceTexture = this.m;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.b();
    }
    n.a.post(new h(this));
    a(true);
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    int i2 = 0;
    com.google.android.gms.ads.internal.util.e.a("AdMediaPlayerView surface changed");
    int i3 = this.o;
    int i1 = i2;
    if (this.r == paramInt1)
    {
      i1 = i2;
      if (this.p == paramInt2) {
        i1 = 1;
      }
    }
    if (this.j == null) {}
    for (;;)
    {
      paramSurfaceTexture = this.m;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.a(paramInt1, paramInt2);
      }
      n.a.post(new g(this, paramInt1, paramInt2));
      return;
      if ((i3 == 3) && (i1 != 0))
      {
        i1 = this.k;
        if (i1 != 0) {
          a(i1);
        }
        b();
      }
    }
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    this.q.b(this);
    this.b.a(paramSurfaceTexture, this.a);
  }
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(57);
    localStringBuilder.append("AdMediaPlayerView size changed: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" x ");
    localStringBuilder.append(paramInt2);
    com.google.android.gms.ads.internal.util.e.a(localStringBuilder.toString());
    this.r = paramMediaPlayer.getVideoWidth();
    this.p = paramMediaPlayer.getVideoHeight();
    if ((this.r != 0) && (this.p != 0)) {
      requestLayout();
    }
  }
  
  protected final void onWindowVisibilityChanged(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(58);
    localStringBuilder.append("AdMediaPlayerView window visibility changed to ");
    localStringBuilder.append(paramInt);
    com.google.android.gms.ads.internal.util.e.a(localStringBuilder.toString());
    n.a.post(new b(this, paramInt));
    super.onWindowVisibilityChanged(paramInt);
  }
  
  public final void setListener(k paramk)
  {
    this.a = paramk;
  }
  
  public final void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }
  
  public final void setVideoURI(Uri paramUri)
  {
    CacheOffering localCacheOffering = CacheOffering.a(paramUri);
    if (localCacheOffering != null) {
      paramUri = Uri.parse(localCacheOffering.c);
    }
    this.n = paramUri;
    this.k = 0;
    e();
    requestLayout();
    invalidate();
  }
  
  public final String toString()
  {
    String str1 = getClass().getName();
    String str2 = Integer.toHexString(hashCode());
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 1 + String.valueOf(str2).length());
    localStringBuilder.append(str1);
    localStringBuilder.append("@");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */