package com.google.android.gms.ads.internal.w;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.v.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@a
@TargetApi(14)
public final class ab
  extends Thread
  implements SurfaceTexture.OnFrameAvailableListener, aa
{
  private static final float[] a = { -1.0F, -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F };
  private FloatBuffer A = ByteBuffer.allocateDirect(a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private int B;
  private final Object b;
  private EGL10 c;
  private EGLContext d;
  private EGLDisplay e;
  private EGLSurface f;
  private volatile boolean g;
  private int h;
  private float i;
  private final float[] j;
  private int k;
  private final CountDownLatch l;
  private float m;
  private final float[] n;
  private float o;
  private final float[] p;
  private final y q;
  private final float[] r;
  private final float[] s;
  private final float[] t;
  private int u;
  private final float[] v;
  private SurfaceTexture w;
  private SurfaceTexture x;
  private int y;
  private volatile boolean z;
  
  public ab(Context paramContext)
  {
    super("SphericalVideoProcessor");
    this.A.put(a).position(0);
    this.v = new float[9];
    this.j = new float[9];
    this.s = new float[9];
    this.r = new float[9];
    this.p = new float[9];
    this.n = new float[9];
    this.t = new float[9];
    this.i = NaN.0F;
    this.q = new y(paramContext);
    this.q.a = this;
    this.l = new CountDownLatch(1);
    this.b = new Object();
  }
  
  private static int a(int paramInt, String paramString)
  {
    int i1 = GLES20.glCreateShader(paramInt);
    a("createShader");
    if (i1 != 0)
    {
      GLES20.glShaderSource(i1, paramString);
      a("shaderSource");
      GLES20.glCompileShader(i1);
      a("compileShader");
      paramString = new int[1];
      GLES20.glGetShaderiv(i1, 35713, paramString, 0);
      a("getShaderiv");
      if (paramString[0] == 0)
      {
        paramString = new StringBuilder(37);
        paramString.append("Could not compile shader ");
        paramString.append(paramInt);
        paramString.append(":");
        Log.e("SphericalVideoRenderer", paramString.toString());
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(i1));
        GLES20.glDeleteShader(i1);
        a("deleteShader");
        return 0;
      }
    }
    return i1;
  }
  
  private static void a(String paramString)
  {
    int i1 = GLES20.glGetError();
    if (i1 != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 21);
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(i1);
      Log.e("SphericalVideoRenderer", localStringBuilder.toString());
    }
  }
  
  private static void a(float[] paramArrayOfFloat, float paramFloat)
  {
    paramArrayOfFloat[0] = 1.0F;
    paramArrayOfFloat[1] = 0.0F;
    paramArrayOfFloat[2] = 0.0F;
    paramArrayOfFloat[3] = 0.0F;
    double d1 = paramFloat;
    paramArrayOfFloat[4] = ((float)Math.cos(d1));
    paramArrayOfFloat[5] = ((float)-Math.sin(d1));
    paramArrayOfFloat[6] = 0.0F;
    paramArrayOfFloat[7] = ((float)Math.sin(d1));
    paramArrayOfFloat[8] = ((float)Math.cos(d1));
  }
  
  private static void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    paramArrayOfFloat1[0] = (paramArrayOfFloat2[0] * paramArrayOfFloat3[0] + paramArrayOfFloat2[1] * paramArrayOfFloat3[3] + paramArrayOfFloat2[2] * paramArrayOfFloat3[6]);
    paramArrayOfFloat1[1] = (paramArrayOfFloat2[0] * paramArrayOfFloat3[1] + paramArrayOfFloat2[1] * paramArrayOfFloat3[4] + paramArrayOfFloat2[2] * paramArrayOfFloat3[7]);
    paramArrayOfFloat1[2] = (paramArrayOfFloat2[0] * paramArrayOfFloat3[2] + paramArrayOfFloat2[1] * paramArrayOfFloat3[5] + paramArrayOfFloat2[2] * paramArrayOfFloat3[8]);
    paramArrayOfFloat1[3] = (paramArrayOfFloat2[3] * paramArrayOfFloat3[0] + paramArrayOfFloat2[4] * paramArrayOfFloat3[3] + paramArrayOfFloat2[5] * paramArrayOfFloat3[6]);
    paramArrayOfFloat1[4] = (paramArrayOfFloat2[3] * paramArrayOfFloat3[1] + paramArrayOfFloat2[4] * paramArrayOfFloat3[4] + paramArrayOfFloat2[5] * paramArrayOfFloat3[7]);
    paramArrayOfFloat1[5] = (paramArrayOfFloat2[3] * paramArrayOfFloat3[2] + paramArrayOfFloat2[4] * paramArrayOfFloat3[5] + paramArrayOfFloat2[5] * paramArrayOfFloat3[8]);
    paramArrayOfFloat1[6] = (paramArrayOfFloat2[6] * paramArrayOfFloat3[0] + paramArrayOfFloat2[7] * paramArrayOfFloat3[3] + paramArrayOfFloat2[8] * paramArrayOfFloat3[6]);
    paramArrayOfFloat1[7] = (paramArrayOfFloat2[6] * paramArrayOfFloat3[1] + paramArrayOfFloat2[7] * paramArrayOfFloat3[4] + paramArrayOfFloat2[8] * paramArrayOfFloat3[7]);
    paramArrayOfFloat1[8] = (paramArrayOfFloat2[6] * paramArrayOfFloat3[2] + paramArrayOfFloat2[7] * paramArrayOfFloat3[5] + paramArrayOfFloat2[8] * paramArrayOfFloat3[8]);
  }
  
  private static void b(float[] paramArrayOfFloat, float paramFloat)
  {
    double d1 = paramFloat;
    paramArrayOfFloat[0] = ((float)Math.cos(d1));
    paramArrayOfFloat[1] = ((float)-Math.sin(d1));
    paramArrayOfFloat[2] = 0.0F;
    paramArrayOfFloat[3] = ((float)Math.sin(d1));
    paramArrayOfFloat[4] = ((float)Math.cos(d1));
    paramArrayOfFloat[5] = 0.0F;
    paramArrayOfFloat[6] = 0.0F;
    paramArrayOfFloat[7] = 0.0F;
    paramArrayOfFloat[8] = 1.0F;
  }
  
  private final boolean d()
  {
    boolean bool1 = false;
    Object localObject = this.f;
    boolean bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (localObject != EGL10.EGL_NO_SURFACE)
      {
        bool2 = this.c.eglMakeCurrent(this.e, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | this.c.eglDestroySurface(this.e, this.f);
        this.f = null;
      }
    }
    localObject = this.d;
    bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2 | this.c.eglDestroyContext(this.e, (EGLContext)localObject);
      this.d = null;
    }
    localObject = this.e;
    bool2 = bool1;
    if (localObject != null)
    {
      bool2 = this.c.eglTerminate((EGLDisplay)localObject);
      this.e = null;
      bool2 = bool1 | bool2;
    }
    return bool2;
  }
  
  public final void a()
  {
    synchronized (this.b)
    {
      this.b.notifyAll();
      return;
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    int i1 = this.B;
    int i2 = this.h;
    float f1;
    if (i1 > i2)
    {
      f1 = i1;
      paramFloat1 = paramFloat1 * 1.7453293F / f1;
      f1 = 1.7453293F * paramFloat2 / f1;
      paramFloat2 = paramFloat1;
      paramFloat1 = f1;
    }
    for (;;)
    {
      this.m -= paramFloat2;
      this.o -= paramFloat1;
      if (this.o < -1.5707964F) {
        this.o = -1.5707964F;
      }
      if (this.o > 1.5707964F) {
        this.o = 1.5707964F;
      }
      return;
      float f2 = i2;
      f1 = paramFloat1 * 1.7453293F / f2;
      paramFloat1 = 1.7453293F * paramFloat2 / f2;
      paramFloat2 = f1;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    synchronized (this.b)
    {
      this.B = paramInt1;
      this.h = paramInt2;
      this.z = true;
      this.b.notifyAll();
      return;
    }
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.B = paramInt1;
    this.h = paramInt2;
    this.x = paramSurfaceTexture;
  }
  
  public final void b()
  {
    synchronized (this.b)
    {
      this.g = true;
      this.x = null;
      this.b.notifyAll();
      return;
    }
  }
  
  public final SurfaceTexture c()
  {
    if (this.x != null) {}
    try
    {
      this.l.await();
      return this.w;
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public final void onFrameAvailable(SurfaceTexture arg1)
  {
    this.k += 1;
    synchronized (this.b)
    {
      this.b.notifyAll();
      return;
    }
  }
  
  public final void run()
  {
    if (this.x == null)
    {
      e.c("SphericalVideoProcessor started with no output texture.");
      this.l.countDown();
      return;
    }
    this.c = ((EGL10)EGLContext.getEGL());
    this.e = this.c.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    Object localObject1;
    Object localObject4;
    Object localObject5;
    int i1;
    if (this.e != EGL10.EGL_NO_DISPLAY)
    {
      localObject1 = new int[2];
      if (this.c.eglInitialize(this.e, (int[])localObject1))
      {
        localObject1 = new int[1];
        localObject4 = new EGLConfig[1];
        if (this.c.eglChooseConfig(this.e, new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344 }, (EGLConfig[])localObject4, 1, (int[])localObject1)) {
          if (localObject1[0] > 0)
          {
            localObject1 = localObject4[0];
            if (localObject1 != null)
            {
              this.d = this.c.eglCreateContext(this.e, (EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
              localObject4 = this.d;
              if (localObject4 != null) {
                if (localObject4 != EGL10.EGL_NO_CONTEXT)
                {
                  this.f = this.c.eglCreateWindowSurface(this.e, (EGLConfig)localObject1, this.x, null);
                  localObject1 = this.f;
                  if (localObject1 != null) {
                    if (localObject1 != EGL10.EGL_NO_SURFACE)
                    {
                      localObject1 = this.c;
                      localObject4 = this.e;
                      localObject5 = this.f;
                      if (((EGL10)localObject1).eglMakeCurrent((EGLDisplay)localObject4, (EGLSurface)localObject5, (EGLSurface)localObject5, this.d)) {
                        i1 = 1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = n.bM;
      if (!((String)((c)localObject1).a()).equals(((c)localObject1).a)) {}
      for (localObject1 = (String)((c)localObject1).a();; str = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}")
      {
        int i4 = a(35633, (String)localObject1);
        int i3;
        int i2;
        if (i4 != 0)
        {
          localObject1 = n.bL;
          if (!((String)((c)localObject1).a()).equals(((c)localObject1).a))
          {
            localObject1 = (String)((c)localObject1).a();
            int i5 = a(35632, (String)localObject1);
            if (i5 != 0)
            {
              i3 = GLES20.glCreateProgram();
              a("createProgram");
              i2 = i3;
              if (i3 != 0)
              {
                GLES20.glAttachShader(i3, i4);
                a("attachShader");
                GLES20.glAttachShader(i3, i5);
                a("attachShader");
                GLES20.glLinkProgram(i3);
                a("linkProgram");
                localObject1 = new int[1];
                GLES20.glGetProgramiv(i3, 35714, (int[])localObject1, 0);
                a("getProgramiv");
                if (localObject1[0] == 1) {
                  break label1726;
                }
                Log.e("SphericalVideoRenderer", "Could not link program: ");
                Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(i3));
                GLES20.glDeleteProgram(i3);
                a("deleteProgram");
                i2 = 0;
              }
            }
          }
        }
        for (;;)
        {
          this.u = i2;
          GLES20.glUseProgram(this.u);
          a("useProgram");
          i2 = GLES20.glGetAttribLocation(this.u, "aPosition");
          GLES20.glVertexAttribPointer(i2, 3, 5126, false, 12, this.A);
          a("vertexAttribPointer");
          GLES20.glEnableVertexAttribArray(i2);
          a("enableVertexAttribArray");
          localObject1 = new int[1];
          GLES20.glGenTextures(1, (int[])localObject1, 0);
          a("genTextures");
          i2 = localObject1[0];
          GLES20.glBindTexture(36197, i2);
          a("bindTextures");
          GLES20.glTexParameteri(36197, 10240, 9729);
          a("texParameteri");
          GLES20.glTexParameteri(36197, 10241, 9729);
          a("texParameteri");
          GLES20.glTexParameteri(36197, 10242, 33071);
          a("texParameteri");
          GLES20.glTexParameteri(36197, 10243, 33071);
          a("texParameteri");
          this.y = GLES20.glGetUniformLocation(this.u, "uVMat");
          GLES20.glUniformMatrix3fv(this.y, 1, false, new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F }, 0);
          i3 = this.u;
          if (i1 == 0) {}
          while (i3 == 0)
          {
            localObject1 = String.valueOf(GLUtils.getEGLErrorString(this.c.eglGetError()));
            if (((String)localObject1).length() == 0) {}
            for (localObject1 = new String("EGL initialization failed: ");; localObject1 = "EGL initialization failed: ".concat((String)localObject1))
            {
              e.c((String)localObject1);
              bt.A.i.a(new Throwable((String)localObject1), "SphericalVideoProcessor.run.1");
              d();
              this.l.countDown();
              return;
            }
          }
          this.w = new SurfaceTexture(i2);
          this.w.setOnFrameAvailableListener(this);
          this.l.countDown();
          localObject1 = this.q;
          if (((y)localObject1).b == null)
          {
            localObject4 = ((y)localObject1).c.getDefaultSensor(11);
            if (localObject4 != null) {
              break label1657;
            }
            e.c("No Sensor of TYPE_ROTATION_VECTOR");
          }
          for (;;)
          {
            try
            {
              this.z = true;
              if (this.g) {
                break label1631;
              }
              if (this.k > 0)
              {
                this.w.updateTexImage();
                this.k -= 1;
                continue;
              }
            }
            catch (IllegalStateException localIllegalStateException)
            {
              try
              {
                e.e("SphericalVideoProcessor halted unexpectedly.");
                return;
              }
              finally
              {
                float f1;
                float f2;
                float f3;
                float f4;
                boolean bool;
                String str;
                this.q.a();
                this.w.setOnFrameAvailableListener(null);
                this.w = null;
                d();
              }
              if (!this.q.a(this.v)) {
                break label1607;
              }
              if (Float.isNaN(this.i))
              {
                ??? = this.v;
                localObject4 = new float[3];
                localObject4[0] = 0.0F;
                localObject4[1] = 1.0F;
                localObject4[2] = 0.0F;
                localObject5 = new float[3];
                localObject5[0] = (???[0] * localObject4[0] + ???[1] * localObject4[1] + ???[2] * localObject4[2]);
                localObject5[1] = (???[3] * localObject4[0] + ???[4] * localObject4[1] + ???[5] * localObject4[2]);
                f1 = ???[6];
                f2 = localObject4[0];
                f3 = ???[7];
                f4 = localObject4[1];
                localObject5[2] = (???[8] * localObject4[2] + (f1 * f2 + f3 * f4));
                this.i = (-((float)Math.atan2(localObject5[1], localObject5[0]) - 1.5707964F));
              }
              b(this.n, this.i + this.m);
              a(this.j, 1.5707964F);
              a(this.s, this.n, this.j);
              a(this.r, this.v, this.s);
              a(this.p, this.o);
              a(this.t, this.p, this.r);
              GLES20.glUniformMatrix3fv(this.y, 1, false, this.t, 0);
              GLES20.glDrawArrays(5, 0, 4);
              a("drawArrays");
              GLES20.glFinish();
              this.c.eglSwapBuffers(this.e, this.f);
              bool = this.z;
              if (!bool) {
                try
                {
                  synchronized (this.b)
                  {
                    if ((!this.g) && (!this.z) && (this.k == 0)) {
                      this.b.wait();
                    }
                  }
                }
                catch (InterruptedException localInterruptedException) {}
              }
              GLES20.glViewport(0, 0, this.B, this.h);
              a("viewport");
              i1 = GLES20.glGetUniformLocation(this.u, "uFOVx");
              i2 = GLES20.glGetUniformLocation(this.u, "uFOVy");
              i3 = this.B;
              i4 = this.h;
              if (i3 <= i4)
              {
                GLES20.glUniform1f(i1, i3 * 0.87266463F / i4);
                GLES20.glUniform1f(i2, 0.87266463F);
                this.z = false;
                continue;
              }
            }
            finally
            {
              e.c("SphericalVideoProcessor died.", localThrowable);
              bt.A.i.a(localThrowable, "SphericalVideoProcessor.run.2");
              this.q.a();
              this.w.setOnFrameAvailableListener(null);
              this.w = null;
              d();
              return;
            }
            GLES20.glUniform1f(i1, 0.87266463F);
            GLES20.glUniform1f(i2, this.h * 0.87266463F / this.B);
            continue;
            label1607:
            a(this.v, -1.5707964F);
            b(this.n, this.m);
            continue;
            label1631:
            this.q.a();
            this.w.setOnFrameAvailableListener(null);
            this.w = null;
            d();
            return;
            label1657:
            localObject5 = new HandlerThread("OrientationMonitor");
            ((HandlerThread)localObject5).start();
            localThrowable.b = new Handler(((HandlerThread)localObject5).getLooper());
            if (!localThrowable.c.registerListener(localThrowable, localSensor, 0, localThrowable.b))
            {
              e.c("SensorManager.registerListener failed.");
              localThrowable.a();
            }
          }
          label1726:
          GLES20.glValidateProgram(i3);
          a("validateProgram");
          i2 = i3;
          continue;
          i2 = 0;
          continue;
          str = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}";
          break;
          i2 = 0;
        }
      }
      i1 = 0;
      continue;
      i1 = 0;
      continue;
      i1 = 0;
      continue;
      i1 = 0;
      continue;
      i1 = 0;
      continue;
      i1 = 0;
      continue;
      str = null;
      break;
      str = null;
      break;
      i1 = 0;
      continue;
      i1 = 0;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */