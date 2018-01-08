package com.android.launcher2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Handler;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class ShadowGen
{
  private static float fovydiff;
  private static int mAppIconSize = -1;
  private static int mAppShadowOffsetY;
  private static int mFolderIconSize = -1;
  private static int mFolderShadowOffsetY;
  private static ShadowGen sInstance;
  private FolderGenThread mFolderGenThread;
  private LinkedList<QueuedBitmap> mFolderQueue = new LinkedList();
  private GenThread mGenThread;
  private LinkedList<QueuedBitmap> mQueue = new LinkedList();
  
  static
  {
    fovydiff = 0.0F;
    sInstance = new ShadowGen();
    System.loadLibrary("drawglfunction");
  }
  
  private void Folderstart()
  {
    this.mFolderGenThread = new FolderGenThread();
    this.mFolderGenThread.setDaemon(true);
    this.mFolderGenThread.setPriority(10);
    this.mFolderGenThread.setName("FolderGenThread");
    this.mFolderGenThread.start();
  }
  
  public static ShadowGen getInstance()
  {
    return sInstance;
  }
  
  public static native boolean nCompositeLayer(Bitmap paramBitmap1, int paramInt, Bitmap paramBitmap2);
  
  public static native boolean nExtractLayers(Bitmap[] paramArrayOfBitmap, int paramInt);
  
  private void start()
  {
    this.mGenThread = new GenThread();
    this.mGenThread.setDaemon(true);
    this.mGenThread.setPriority(10);
    this.mGenThread.setName("ShadowGen");
    this.mGenThread.start();
  }
  
  public void onDestroy()
  {
    synchronized (this.mQueue)
    {
      this.mQueue.clear();
    }
    synchronized (this.mFolderQueue)
    {
      this.mFolderQueue.clear();
      return;
      localObject1 = finally;
      throw ((Throwable)localObject1);
    }
  }
  
  public void queueBitmap(Bitmap arg1, GeneratedCallback paramGeneratedCallback, Handler paramHandler, Resources paramResources, boolean paramBoolean)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler();
    }
    if (mAppIconSize == -1)
    {
      mAppIconSize = paramResources.getDimensionPixelSize(2131624134);
      mAppShadowOffsetY = paramResources.getInteger(2131492895);
    }
    if (mFolderIconSize == -1)
    {
      mFolderIconSize = FolderIconHelper.getFolderWidth();
      mFolderShadowOffsetY = paramResources.getInteger(2131492896);
    }
    paramHandler = new QueuedBitmap(null);
    paramHandler.setBitmap(???);
    ??? = new CallbackEntry(null);
    ???.callback = paramGeneratedCallback;
    ???.handler = localHandler;
    paramHandler.callbacks.add(???);
    if (paramBoolean) {}
    for (;;)
    {
      synchronized (this.mFolderQueue)
      {
        this.mFolderQueue.add(paramHandler);
        this.mFolderQueue.notify();
        if (this.mFolderGenThread == null) {
          Folderstart();
        }
        if (this.mGenThread == null) {
          start();
        }
        return;
      }
      synchronized (this.mQueue)
      {
        this.mQueue.add(paramHandler);
        this.mQueue.notify();
      }
    }
  }
  
  public void startInBackground(Resources paramResources)
  {
    if (mAppIconSize == -1)
    {
      mAppIconSize = paramResources.getDimensionPixelSize(2131624134);
      mAppShadowOffsetY = paramResources.getInteger(2131492895);
    }
    if (mFolderIconSize == -1)
    {
      mFolderIconSize = FolderIconHelper.getFolderWidth();
      mFolderShadowOffsetY = paramResources.getInteger(2131492896);
    }
    if (this.mGenThread == null) {
      start();
    }
  }
  
  private static class CallbackEntry
  {
    ShadowGen.GeneratedCallback callback;
    Handler handler;
    
    public void post(final Bitmap paramBitmap)
    {
      this.handler.post(new Runnable()
      {
        public void run()
        {
          ShadowGen.CallbackEntry.this.callback.onShadowGenerated(paramBitmap);
        }
      });
    }
  }
  
  private class FolderGenThread
    extends Thread
  {
    private static final int BITMAP_PROCESS_BLK_SIZE = 4;
    static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    static final int EGL_OPENGL_ES2_BIT = 4;
    private static final String TAG = "ShadowGen$FolderGenThread";
    private static final String sFragmentSource = "precision mediump float;\nvarying vec3 vPosition;\nuniform sampler2D sTexture;\nvec4 light_intersect(vec3 worldPosition, sampler2D texture, float lightRadius, float angle) {\n    vec3 lightCenter = vec3(0., 15., 200.);\n\n    float s = sin(angle);\n    float c = cos(angle);\n\n    vec3 lightPos = lightCenter + vec3(c*lightRadius, s*lightRadius, 0.);\n\n    vec3 lightDir = normalize(worldPosition - lightPos);\n    float d = 0. - worldPosition.z / lightDir.z;\n    vec3 plane = lightDir*d + worldPosition;\n\n    return texture2D(texture, plane.xy*vec2(1, -1) + vec2(.5,.5));\n}\nvoid shadow(out vec4 alpha, in vec3 worldPosition, in sampler2D texture) {\n    vec4 shadow = vec4(0., 0., 0., 0.);\n        shadow = light_intersect(worldPosition, texture, 0., radians(0.));\n    shadow = shadow/(1.);\n\n    alpha = shadow*shadow;\n}\nvoid main() {\n    vec4 alpha;\n    vec3 worldPosition = vPosition;\n\n    shadow(alpha, worldPosition, sTexture);\n\n    gl_FragColor = alpha*.13;\n}\n";
    private static final String sVertexSource = "attribute vec2 aPosition;\nvarying vec3 vPosition;\nuniform mat4 uProjMat;\nuniform mat4 uModMat;\nvoid main() {\n  vPosition = (uModMat * vec4(aPosition,0,1.)).xyz;\n  gl_Position = (uProjMat * uModMat) * vec4(aPosition,0,1.);\n}\n";
    private boolean mContinue = true;
    private EGL10 mEgl;
    private EGLConfig mEglConfig;
    private EGLContext mEglContext;
    private EGLDisplay mEglDisplay;
    private EGLSurface mEglSurface;
    int mProgram;
    private int mShadowHeight;
    private int mShadowWidth;
    private Bitmap mTmpTex;
    int maPositionHandle;
    int muModMatHandle;
    int muProjMatHandle;
    
    FolderGenThread() {}
    
    private void checkCurrent()
    {
      if (((!this.mEglContext.equals(this.mEgl.eglGetCurrentContext())) || (!this.mEglSurface.equals(this.mEgl.eglGetCurrentSurface(12377)))) && (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext))) {
        throw new RuntimeException("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
      }
    }
    
    private void checkEglError()
    {
      int i = this.mEgl.eglGetError();
      if (i != 12288) {
        Log.e("ShadowGen$FolderGenThread", "EGL error = 0x" + Integer.toHexString(i));
      }
    }
    
    private void checkGlError()
    {
      checkGlError("");
    }
    
    private void checkGlError(String paramString)
    {
      int i = GLES20.glGetError();
      if (i != 0) {
        Log.e("ShadowGen$FolderGenThread", "GL error = 0x" + Integer.toHexString(i) + " at " + paramString);
      }
    }
    
    private EGLConfig chooseEglConfig()
    {
      int[] arrayOfInt1 = new int[1];
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      int[] arrayOfInt2 = getConfig();
      if (!this.mEgl.eglChooseConfig(this.mEglDisplay, arrayOfInt2, arrayOfEGLConfig, 1, arrayOfInt1)) {
        throw new IllegalArgumentException("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
      }
      if (arrayOfInt1[0] > 0) {
        return arrayOfEGLConfig[0];
      }
      return null;
    }
    
    private int createProgram(String paramString1, String paramString2)
    {
      int k = loadShader(35633, paramString1);
      int i;
      if (k == 0) {
        i = 0;
      }
      int j;
      do
      {
        int m;
        do
        {
          return i;
          m = loadShader(35632, paramString2);
          if (m == 0) {
            return 0;
          }
          j = GLES20.glCreateProgram();
          i = j;
        } while (j == 0);
        GLES20.glAttachShader(j, k);
        checkGlError("glAttachShader");
        GLES20.glAttachShader(j, m);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(j);
        paramString1 = new int[1];
        GLES20.glGetProgramiv(j, 35714, paramString1, 0);
        i = j;
      } while (paramString1[0] == 1);
      Log.e("ShadowGen$FolderGenThread", "Could not link program: ");
      Log.e("ShadowGen$FolderGenThread", GLES20.glGetProgramInfoLog(j));
      GLES20.glDeleteProgram(j);
      return 0;
    }
    
    private void doBitmaps(ShadowGen.QueuedBitmap[] paramArrayOfQueuedBitmap, Bitmap[] paramArrayOfBitmap)
    {
      this.mTmpTex.eraseColor(0);
      int j = 0;
      int i = 0;
      for (;;)
      {
        if ((i >= paramArrayOfQueuedBitmap.length) || (paramArrayOfQueuedBitmap[i] == null))
        {
          GLUtils.texImage2D(3553, 0, this.mTmpTex, 0);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          GLES20.glClear(16384);
          GLES20.glDrawArrays(6, 0, 4);
          i = 0;
          while (i <= j)
          {
            paramArrayOfBitmap[i] = Bitmap.createBitmap(this.mShadowWidth, this.mShadowHeight, Bitmap.Config.ALPHA_8);
            i += 1;
          }
        }
        ShadowGen.nCompositeLayer(paramArrayOfQueuedBitmap[i].getBitmap(), i, this.mTmpTex);
        j = i;
        i += 1;
      }
      ShadowGen.nExtractLayers(paramArrayOfBitmap, j + 1);
    }
    
    private void finishGL()
    {
      this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
      this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
    }
    
    private int[] getConfig()
    {
      return new int[] { 12352, 4, 12324, 0, 12323, 0, 12322, 0, 12321, 8, 12325, 0, 12326, 0, 12344 };
    }
    
    private void initGL()
    {
      this.mEgl = ((EGL10)EGLContext.getEGL());
      this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
        throw new RuntimeException("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
      }
      int[] arrayOfInt = new int[2];
      if (!this.mEgl.eglInitialize(this.mEglDisplay, arrayOfInt)) {
        throw new RuntimeException("eglInitialize failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
      }
      this.mEglConfig = chooseEglConfig();
      if (this.mEglConfig == null) {
        throw new RuntimeException("eglConfig not initialized");
      }
      this.mEglContext = createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
      int i = this.mShadowWidth;
      int j = this.mShadowHeight;
      this.mEglSurface = this.mEgl.eglCreatePbufferSurface(this.mEglDisplay, this.mEglConfig, new int[] { 12375, i, 12374, j, 12344 });
      if ((this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE))
      {
        i = this.mEgl.eglGetError();
        if (i == 12299) {
          Log.e("ShadowGen$FolderGenThread", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
        }
      }
      while (this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext))
      {
        return;
        throw new RuntimeException("createWindowSurface failed " + GLUtils.getEGLErrorString(i));
      }
      throw new RuntimeException("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
    }
    
    private int loadShader(int paramInt, String paramString)
    {
      int j = GLES20.glCreateShader(paramInt);
      int i = j;
      if (j != 0)
      {
        GLES20.glShaderSource(j, paramString);
        GLES20.glCompileShader(j);
        paramString = new int[1];
        GLES20.glGetShaderiv(j, 35713, paramString, 0);
        i = j;
        if (paramString[0] == 0)
        {
          Log.e("ShadowGen$FolderGenThread", "Could not compile shader " + paramInt + ":");
          Log.e("ShadowGen$FolderGenThread", GLES20.glGetShaderInfoLog(j));
          GLES20.glDeleteShader(j);
          i = 0;
        }
      }
      return i;
    }
    
    private void notifyCallbacks(ShadowGen.QueuedBitmap[] paramArrayOfQueuedBitmap, Bitmap[] paramArrayOfBitmap)
    {
      int i = 0;
      for (;;)
      {
        if ((i >= paramArrayOfQueuedBitmap.length) || (paramArrayOfQueuedBitmap[i] == null)) {
          return;
        }
        Iterator localIterator = paramArrayOfQueuedBitmap[i].callbacks.iterator();
        while (localIterator.hasNext()) {
          ((ShadowGen.CallbackEntry)localIterator.next()).post(paramArrayOfBitmap[i]);
        }
        paramArrayOfQueuedBitmap[i] = null;
        paramArrayOfBitmap[i] = null;
        i += 1;
      }
    }
    
    public void compilePrograms()
    {
      this.mProgram = createProgram("attribute vec2 aPosition;\nvarying vec3 vPosition;\nuniform mat4 uProjMat;\nuniform mat4 uModMat;\nvoid main() {\n  vPosition = (uModMat * vec4(aPosition,0,1.)).xyz;\n  gl_Position = (uProjMat * uModMat) * vec4(aPosition,0,1.);\n}\n", "precision mediump float;\nvarying vec3 vPosition;\nuniform sampler2D sTexture;\nvec4 light_intersect(vec3 worldPosition, sampler2D texture, float lightRadius, float angle) {\n    vec3 lightCenter = vec3(0., 15., 200.);\n\n    float s = sin(angle);\n    float c = cos(angle);\n\n    vec3 lightPos = lightCenter + vec3(c*lightRadius, s*lightRadius, 0.);\n\n    vec3 lightDir = normalize(worldPosition - lightPos);\n    float d = 0. - worldPosition.z / lightDir.z;\n    vec3 plane = lightDir*d + worldPosition;\n\n    return texture2D(texture, plane.xy*vec2(1, -1) + vec2(.5,.5));\n}\nvoid shadow(out vec4 alpha, in vec3 worldPosition, in sampler2D texture) {\n    vec4 shadow = vec4(0., 0., 0., 0.);\n        shadow = light_intersect(worldPosition, texture, 0., radians(0.));\n    shadow = shadow/(1.);\n\n    alpha = shadow*shadow;\n}\nvoid main() {\n    vec4 alpha;\n    vec3 worldPosition = vPosition;\n\n    shadow(alpha, worldPosition, sTexture);\n\n    gl_FragColor = alpha*.13;\n}\n");
      this.muProjMatHandle = GLES20.glGetUniformLocation(this.mProgram, "uProjMat");
      this.muModMatHandle = GLES20.glGetUniformLocation(this.mProgram, "uModMat");
      this.maPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
      GLES20.glReleaseShaderCompiler();
    }
    
    EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    }
    
    public void run()
    {
      ??? = new float[16];
      Matrix.orthoM((float[])???, 0, -1.0F, 1.0F, -1.0F, 1.0F, 0.1F, 10.0F);
      Matrix.scaleM((float[])???, 0, 1.0F, -1.0F, 1.0F);
      Object localObject2 = new float[16];
      Matrix.setIdentityM((float[])localObject2, 0);
      Matrix.translateM((float[])localObject2, 0, 0.0F, 0.0F, -0.1F * ShadowGen.mFolderShadowOffsetY);
      Object localObject3 = new float[4];
      Object localObject4 = new float[4];
      Matrix.multiplyMV((float[])localObject3, 0, (float[])???, 0, new float[] { -0.5F, 0.5F, 0.2F, 0.98F }, 0);
      Matrix.multiplyMV((float[])localObject4, 0, (float[])???, 0, new float[] { 0.5F, -0.5F, 0.2F, 0.98F }, 0);
      float f1 = localObject3[0] / localObject3[3];
      float f2 = localObject3[1] / localObject3[3];
      float f3 = localObject4[0] / localObject4[3];
      float f4 = localObject4[1] / localObject4[3];
      this.mShadowWidth = ((int)(2.0F * (ShadowGen.mFolderIconSize / (f3 - f1))));
      this.mShadowHeight = ((int)(2.0F * (ShadowGen.mFolderIconSize / (f4 - f2))));
      initGL();
      compilePrograms();
      GLES20.glDisable(2884);
      localObject3 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
      ((FloatBuffer)localObject3).put(new float[] { -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F, -1.0F, -1.0F }).position(0);
      localObject4 = new int[1];
      GLES20.glGenBuffers(1, (int[])localObject4, 0);
      GLES20.glBindBuffer(34962, localObject4[0]);
      GLES20.glBufferData(34962, ((FloatBuffer)localObject3).capacity() * 4, (Buffer)localObject3, 35044);
      GLES20.glUseProgram(this.mProgram);
      GLES20.glEnableVertexAttribArray(this.maPositionHandle);
      GLES20.glVertexAttribPointer(this.maPositionHandle, 2, 5126, false, 0, 0);
      GLES20.glUniformMatrix4fv(this.muProjMatHandle, 1, false, (float[])???, 0);
      GLES20.glUniformMatrix4fv(this.muModMatHandle, 1, false, (float[])localObject2, 0);
      localObject2 = new ShadowGen.QueuedBitmap[4];
      localObject3 = new Bitmap[4];
      checkCurrent();
      localObject4 = new int[1];
      GLES20.glGenTextures(1, (int[])localObject4, 0);
      GLES20.glBindTexture(3553, localObject4[0]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      this.mTmpTex = Bitmap.createBitmap(ShadowGen.mFolderIconSize / 2 + 2, ShadowGen.mFolderIconSize / 2 + 2, Bitmap.Config.ARGB_8888);
      if (this.mContinue) {}
      int i;
      for (;;)
      {
        synchronized (ShadowGen.this.mFolderQueue)
        {
          boolean bool = ShadowGen.this.mFolderQueue.isEmpty();
          if (!bool) {
            break label652;
          }
          try
          {
            ShadowGen.this.mFolderQueue.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            this.mContinue = false;
            break label652;
          }
          if (i < localObject2.length)
          {
            if (ShadowGen.this.mFolderQueue.size() <= 0) {
              break label667;
            }
            localObject2[i] = ((ShadowGen.QueuedBitmap)ShadowGen.this.mFolderQueue.removeFirst());
          }
        }
        doBitmaps(arrayOfQueuedBitmap, (Bitmap[])localObject3);
        notifyCallbacks(arrayOfQueuedBitmap, (Bitmap[])localObject3);
        break;
        GLES20.glDeleteTextures(1, (int[])localObject4, 0);
        finishGL();
        return;
        label652:
        i = 0;
      }
      for (;;)
      {
        i += 1;
        break;
        label667:
        arrayOfQueuedBitmap[i] = null;
      }
    }
  }
  
  private class GenThread
    extends Thread
  {
    private static final int BITMAP_PROCESS_BLK_SIZE = 4;
    static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    static final int EGL_OPENGL_ES2_BIT = 4;
    private static final String TAG = "ShadowGen$GenThread";
    private static final String sFragmentSource = "precision mediump float;\nvarying vec3 vPosition;\nuniform sampler2D sTexture;\nvec4 light_intersect(vec3 worldPosition, sampler2D texture, float lightRadius, float angle) {\n    vec3 lightCenter = vec3(0., 15., 200.);\n\n    float s = sin(angle);\n    float c = cos(angle);\n\n    vec3 lightPos = lightCenter + vec3(c*lightRadius, s*lightRadius, 0.);\n\n    vec3 lightDir = normalize(worldPosition - lightPos);\n    float d = 0. - worldPosition.z / lightDir.z;\n    vec3 plane = lightDir*d + worldPosition;\n\n    return texture2D(texture, plane.xy*vec2(1, -1) + vec2(.5,.5));\n}\nvoid shadow(out vec4 alpha, in vec3 worldPosition, in sampler2D texture) {\n    vec4 shadow = vec4(0., 0., 0., 0.);\n        shadow = light_intersect(worldPosition, texture, 0., radians(0.));\n    shadow = shadow/(1.);\n\n    alpha = shadow*shadow;\n}\nvoid main() {\n    vec4 alpha;\n    vec3 worldPosition = vPosition;\n\n    shadow(alpha, worldPosition, sTexture);\n\n    gl_FragColor = alpha*.13;\n}\n";
    private static final String sVertexSource = "attribute vec2 aPosition;\nvarying vec3 vPosition;\nuniform mat4 uProjMat;\nuniform mat4 uModMat;\nvoid main() {\n  vPosition = (uModMat * vec4(aPosition,0,1.)).xyz;\n  gl_Position = (uProjMat * uModMat) * vec4(aPosition,0,1.);\n}\n";
    private boolean mContinue = true;
    private EGL10 mEgl;
    private EGLConfig mEglConfig;
    private EGLContext mEglContext;
    private EGLDisplay mEglDisplay;
    private EGLSurface mEglSurface;
    int mProgram;
    private int mShadowHeight;
    private int mShadowWidth;
    private Bitmap mTmpTex;
    int maPositionHandle;
    int muModMatHandle;
    int muProjMatHandle;
    
    GenThread() {}
    
    private void checkCurrent()
    {
      if (((!this.mEglContext.equals(this.mEgl.eglGetCurrentContext())) || (!this.mEglSurface.equals(this.mEgl.eglGetCurrentSurface(12377)))) && (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext))) {
        throw new RuntimeException("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
      }
    }
    
    private void checkEglError()
    {
      int i = this.mEgl.eglGetError();
      if (i != 12288) {
        Log.e("ShadowGen$GenThread", "EGL error = 0x" + Integer.toHexString(i));
      }
    }
    
    private void checkGlError()
    {
      checkGlError("");
    }
    
    private void checkGlError(String paramString)
    {
      int i = GLES20.glGetError();
      if (i != 0) {
        Log.e("ShadowGen$GenThread", "GL error = 0x" + Integer.toHexString(i) + " at " + paramString);
      }
    }
    
    private EGLConfig chooseEglConfig()
    {
      int[] arrayOfInt1 = new int[1];
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      int[] arrayOfInt2 = getConfig();
      if (!this.mEgl.eglChooseConfig(this.mEglDisplay, arrayOfInt2, arrayOfEGLConfig, 1, arrayOfInt1)) {
        throw new IllegalArgumentException("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
      }
      if (arrayOfInt1[0] > 0) {
        return arrayOfEGLConfig[0];
      }
      return null;
    }
    
    private int createProgram(String paramString1, String paramString2)
    {
      int k = loadShader(35633, paramString1);
      int i;
      if (k == 0) {
        i = 0;
      }
      int j;
      do
      {
        int m;
        do
        {
          return i;
          m = loadShader(35632, paramString2);
          if (m == 0) {
            return 0;
          }
          j = GLES20.glCreateProgram();
          i = j;
        } while (j == 0);
        GLES20.glAttachShader(j, k);
        checkGlError("glAttachShader");
        GLES20.glAttachShader(j, m);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(j);
        paramString1 = new int[1];
        GLES20.glGetProgramiv(j, 35714, paramString1, 0);
        i = j;
      } while (paramString1[0] == 1);
      Log.e("ShadowGen$GenThread", "Could not link program: ");
      Log.e("ShadowGen$GenThread", GLES20.glGetProgramInfoLog(j));
      GLES20.glDeleteProgram(j);
      return 0;
    }
    
    private void doBitmaps(ShadowGen.QueuedBitmap[] paramArrayOfQueuedBitmap, Bitmap[] paramArrayOfBitmap)
    {
      this.mTmpTex.eraseColor(0);
      int j = 0;
      int i = 0;
      for (;;)
      {
        if ((i >= paramArrayOfQueuedBitmap.length) || (paramArrayOfQueuedBitmap[i] == null))
        {
          GLUtils.texImage2D(3553, 0, this.mTmpTex, 0);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          GLES20.glClear(16384);
          GLES20.glDrawArrays(6, 0, 4);
          i = 0;
          while (i <= j)
          {
            paramArrayOfBitmap[i] = Bitmap.createBitmap(this.mShadowWidth, this.mShadowHeight, Bitmap.Config.ALPHA_8);
            i += 1;
          }
        }
        ShadowGen.nCompositeLayer(paramArrayOfQueuedBitmap[i].getBitmap(), i, this.mTmpTex);
        j = i;
        i += 1;
      }
      ShadowGen.nExtractLayers(paramArrayOfBitmap, j + 1);
    }
    
    private void finishGL()
    {
      this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
      this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
    }
    
    private int[] getConfig()
    {
      return new int[] { 12352, 4, 12324, 0, 12323, 0, 12322, 0, 12321, 8, 12325, 0, 12326, 0, 12344 };
    }
    
    private void initGL()
    {
      this.mEgl = ((EGL10)EGLContext.getEGL());
      this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
        throw new RuntimeException("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
      }
      int[] arrayOfInt = new int[2];
      if (!this.mEgl.eglInitialize(this.mEglDisplay, arrayOfInt)) {
        throw new RuntimeException("eglInitialize failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
      }
      this.mEglConfig = chooseEglConfig();
      if (this.mEglConfig == null) {
        throw new RuntimeException("eglConfig not initialized");
      }
      this.mEglContext = createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
      int i = this.mShadowWidth;
      int j = this.mShadowHeight;
      this.mEglSurface = this.mEgl.eglCreatePbufferSurface(this.mEglDisplay, this.mEglConfig, new int[] { 12375, i, 12374, j, 12344 });
      if ((this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE))
      {
        i = this.mEgl.eglGetError();
        if (i == 12299) {
          Log.e("ShadowGen$GenThread", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
        }
      }
      while (this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext))
      {
        return;
        throw new RuntimeException("createWindowSurface failed " + GLUtils.getEGLErrorString(i));
      }
      throw new RuntimeException("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
    }
    
    private int loadShader(int paramInt, String paramString)
    {
      int j = GLES20.glCreateShader(paramInt);
      int i = j;
      if (j != 0)
      {
        GLES20.glShaderSource(j, paramString);
        GLES20.glCompileShader(j);
        paramString = new int[1];
        GLES20.glGetShaderiv(j, 35713, paramString, 0);
        i = j;
        if (paramString[0] == 0)
        {
          Log.e("ShadowGen$GenThread", "Could not compile shader " + paramInt + ":");
          Log.e("ShadowGen$GenThread", GLES20.glGetShaderInfoLog(j));
          GLES20.glDeleteShader(j);
          i = 0;
        }
      }
      return i;
    }
    
    private void notifyCallbacks(ShadowGen.QueuedBitmap[] paramArrayOfQueuedBitmap, Bitmap[] paramArrayOfBitmap)
    {
      int i = 0;
      for (;;)
      {
        if ((i >= paramArrayOfQueuedBitmap.length) || (paramArrayOfQueuedBitmap[i] == null)) {
          return;
        }
        Iterator localIterator = paramArrayOfQueuedBitmap[i].callbacks.iterator();
        while (localIterator.hasNext()) {
          ((ShadowGen.CallbackEntry)localIterator.next()).post(paramArrayOfBitmap[i]);
        }
        paramArrayOfQueuedBitmap[i] = null;
        paramArrayOfBitmap[i] = null;
        i += 1;
      }
    }
    
    public void compilePrograms()
    {
      this.mProgram = createProgram("attribute vec2 aPosition;\nvarying vec3 vPosition;\nuniform mat4 uProjMat;\nuniform mat4 uModMat;\nvoid main() {\n  vPosition = (uModMat * vec4(aPosition,0,1.)).xyz;\n  gl_Position = (uProjMat * uModMat) * vec4(aPosition,0,1.);\n}\n", "precision mediump float;\nvarying vec3 vPosition;\nuniform sampler2D sTexture;\nvec4 light_intersect(vec3 worldPosition, sampler2D texture, float lightRadius, float angle) {\n    vec3 lightCenter = vec3(0., 15., 200.);\n\n    float s = sin(angle);\n    float c = cos(angle);\n\n    vec3 lightPos = lightCenter + vec3(c*lightRadius, s*lightRadius, 0.);\n\n    vec3 lightDir = normalize(worldPosition - lightPos);\n    float d = 0. - worldPosition.z / lightDir.z;\n    vec3 plane = lightDir*d + worldPosition;\n\n    return texture2D(texture, plane.xy*vec2(1, -1) + vec2(.5,.5));\n}\nvoid shadow(out vec4 alpha, in vec3 worldPosition, in sampler2D texture) {\n    vec4 shadow = vec4(0., 0., 0., 0.);\n        shadow = light_intersect(worldPosition, texture, 0., radians(0.));\n    shadow = shadow/(1.);\n\n    alpha = shadow*shadow;\n}\nvoid main() {\n    vec4 alpha;\n    vec3 worldPosition = vPosition;\n\n    shadow(alpha, worldPosition, sTexture);\n\n    gl_FragColor = alpha*.13;\n}\n");
      this.muProjMatHandle = GLES20.glGetUniformLocation(this.mProgram, "uProjMat");
      this.muModMatHandle = GLES20.glGetUniformLocation(this.mProgram, "uModMat");
      this.maPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
      GLES20.glReleaseShaderCompiler();
    }
    
    EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    }
    
    public void run()
    {
      ??? = new float[16];
      Matrix.orthoM((float[])???, 0, -1.0F, 1.0F, -1.0F, 1.0F, 0.1F, 10.0F);
      Matrix.scaleM((float[])???, 0, 1.0F, -1.0F, 1.0F);
      Object localObject2 = new float[16];
      Matrix.setIdentityM((float[])localObject2, 0);
      Matrix.translateM((float[])localObject2, 0, 0.0F, 0.0F, -0.1F * ShadowGen.mAppShadowOffsetY);
      Object localObject3 = new float[4];
      Object localObject4 = new float[4];
      Matrix.multiplyMV((float[])localObject3, 0, (float[])???, 0, new float[] { -0.5F, 0.5F, 0.2F, 0.98F }, 0);
      Matrix.multiplyMV((float[])localObject4, 0, (float[])???, 0, new float[] { 0.5F, -0.5F, 0.2F, 0.98F }, 0);
      float f1 = localObject3[0] / localObject3[3];
      float f2 = localObject3[1] / localObject3[3];
      float f3 = localObject4[0] / localObject4[3];
      float f4 = localObject4[1] / localObject4[3];
      this.mShadowWidth = ((int)(2.0F * (ShadowGen.mAppIconSize / (f3 - f1))));
      this.mShadowHeight = ((int)(2.0F * (ShadowGen.mAppIconSize / (f4 - f2))));
      initGL();
      compilePrograms();
      GLES20.glDisable(2884);
      localObject3 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
      ((FloatBuffer)localObject3).put(new float[] { -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F, -1.0F, -1.0F }).position(0);
      localObject4 = new int[1];
      GLES20.glGenBuffers(1, (int[])localObject4, 0);
      GLES20.glBindBuffer(34962, localObject4[0]);
      GLES20.glBufferData(34962, ((FloatBuffer)localObject3).capacity() * 4, (Buffer)localObject3, 35044);
      GLES20.glUseProgram(this.mProgram);
      GLES20.glEnableVertexAttribArray(this.maPositionHandle);
      GLES20.glVertexAttribPointer(this.maPositionHandle, 2, 5126, false, 0, 0);
      GLES20.glUniformMatrix4fv(this.muProjMatHandle, 1, false, (float[])???, 0);
      GLES20.glUniformMatrix4fv(this.muModMatHandle, 1, false, (float[])localObject2, 0);
      localObject2 = new ShadowGen.QueuedBitmap[4];
      localObject3 = new Bitmap[4];
      checkCurrent();
      localObject4 = new int[1];
      GLES20.glGenTextures(1, (int[])localObject4, 0);
      GLES20.glBindTexture(3553, localObject4[0]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      this.mTmpTex = Bitmap.createBitmap(ShadowGen.mAppIconSize / 2 + 2, ShadowGen.mAppIconSize / 2 + 2, Bitmap.Config.ARGB_8888);
      if (this.mContinue) {}
      int i;
      for (;;)
      {
        synchronized (ShadowGen.this.mQueue)
        {
          boolean bool = ShadowGen.this.mQueue.isEmpty();
          if (!bool) {
            break label652;
          }
          try
          {
            ShadowGen.this.mQueue.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            this.mContinue = false;
            break label652;
          }
          if (i < localObject2.length)
          {
            if (ShadowGen.this.mQueue.size() <= 0) {
              break label667;
            }
            localObject2[i] = ((ShadowGen.QueuedBitmap)ShadowGen.this.mQueue.removeFirst());
          }
        }
        doBitmaps(arrayOfQueuedBitmap, (Bitmap[])localObject3);
        notifyCallbacks(arrayOfQueuedBitmap, (Bitmap[])localObject3);
        break;
        GLES20.glDeleteTextures(1, (int[])localObject4, 0);
        finishGL();
        return;
        label652:
        i = 0;
      }
      for (;;)
      {
        i += 1;
        break;
        label667:
        arrayOfQueuedBitmap[i] = null;
      }
    }
  }
  
  public static abstract interface GeneratedCallback
  {
    public abstract void onShadowGenerated(Bitmap paramBitmap);
  }
  
  private static class QueuedBitmap
  {
    private Bitmap bitmap;
    ArrayList<ShadowGen.CallbackEntry> callbacks = new ArrayList();
    
    Bitmap getBitmap()
    {
      return this.bitmap;
    }
    
    void setBitmap(Bitmap paramBitmap)
    {
      this.bitmap = paramBitmap;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/ShadowGen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */