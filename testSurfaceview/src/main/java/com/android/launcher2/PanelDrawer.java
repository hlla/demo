package com.android.launcher2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

class PanelDrawer
{
  private static final String TAG = "PanelDrawer";
  private static final String sFragmentSource = "precision mediump float;\nvarying vec2 vTextureCoord;\nvarying vec2 vHighlightCoord;\nuniform sampler2D sTexture;\nuniform sampler2D sHighlight;\nuniform float uAlpha;\nuniform float uBackgroundDarken;\nuniform float uBaseDarken;\nvoid main() {\n  vec4 sampled = texture2D(sTexture, vTextureCoord);\n  float highlight = texture2D(sHighlight, vHighlightCoord).a;\n  float highlightMask = sampled.b; \n  float maskedHighlight = highlight*highlightMask; \n  float value = (sampled.g + maskedHighlight)*uAlpha;\n  float alpha = (sampled.r + maskedHighlight)*uAlpha + mix(uBackgroundDarken, uBaseDarken, sampled.b);\n  gl_FragColor = vec4(value, value, value, alpha);\n}\n";
  private static final String sVertexSource = "uniform mat4 uPMatrix;\nuniform mat4 uMVMatrix;\nattribute vec2 aPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec2 vHighlightCoord;\nuniform vec2 uHighlightXMA;\nvoid main() {\n  gl_Position = (uPMatrix*uMVMatrix)*vec4(aPosition,0,1.);\n  vTextureCoord = aTextureCoord;\n  vHighlightCoord.x = (gl_Position.x/gl_Position.w)*uHighlightXMA[0]+uHighlightXMA[1];\n  vHighlightCoord.y = aTextureCoord.y;\n}\n";
  protected int mExpandX;
  protected int mExpandY;
  int mHighlightTexture;
  boolean mIgnoreDarken = false;
  private int mIndiciesBuffer;
  private short[] mIndiciesData;
  private boolean mInitialized = false;
  private int mLastHeight = 0;
  private int mLastWidth = 0;
  private boolean mPaused = true;
  int mProgram;
  float[] mProjectionMatrix;
  private Resources mRes;
  int mTexture;
  protected int mTextureHeight;
  protected int mTextureWidth;
  private int mVerticiesBuffer;
  private float[] mVerticiesData;
  int mViewportHeight;
  int mViewportWidth;
  int maPositionHandle;
  int maTextureCoordHandle;
  int msHighlightHandle;
  int msTextureHandle;
  int muAlpha;
  int muBackgroundDarken;
  int muBaseDarken;
  int muHighlightXMLHandle;
  int muMVMatrixHandle;
  int muPMatrixHandle;
  
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
    Log.e("PanelDrawer", "Could not link program: ");
    Log.e("PanelDrawer", GLES20.glGetProgramInfoLog(j));
    GLES20.glDeleteProgram(j);
    return 0;
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
        Log.e("PanelDrawer", "Could not compile shader " + paramInt + ":");
        Log.e("PanelDrawer", GLES20.glGetShaderInfoLog(j));
        GLES20.glDeleteShader(j);
        i = 0;
      }
    }
    return i;
  }
  
  private int loadTexture(Resources paramResources, int paramInt)
  {
    Object localObject = new int[1];
    GLES20.glGenTextures(1, (int[])localObject, 0);
    int i = localObject[0];
    GLES20.glBindTexture(3553, i);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localObject = BitmapFactory.decodeResource(paramResources, paramInt, localOptions);
    if (localObject != null)
    {
      paramResources = (Resources)localObject;
      if (paramInt == 2130837762) {
        paramResources = ((Bitmap)localObject).extractAlpha();
      }
      this.mTextureWidth = localOptions.outWidth;
      this.mTextureHeight = localOptions.outHeight;
      GLUtils.texImage2D(3553, 0, GLUtils.getInternalFormat(paramResources), paramResources, GLUtils.getType(paramResources), 0);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
    }
    return i;
  }
  
  private void loadVBOs()
  {
    setNinePatch();
    ShortBuffer localShortBuffer = ByteBuffer.allocateDirect(this.mIndiciesData.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
    localShortBuffer.put(this.mIndiciesData).position(0);
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(this.mVerticiesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(this.mVerticiesData).position(0);
    if (this.mVerticiesBuffer == 0)
    {
      int[] arrayOfInt = new int[2];
      GLES20.glGenBuffers(2, arrayOfInt, 0);
      this.mVerticiesBuffer = arrayOfInt[0];
      this.mIndiciesBuffer = arrayOfInt[1];
    }
    GLES20.glBindBuffer(34962, this.mVerticiesBuffer);
    GLES20.glBufferData(34962, localFloatBuffer.capacity() * 4, localFloatBuffer, 35044);
    GLES20.glBindBuffer(34963, this.mIndiciesBuffer);
    GLES20.glBufferData(34963, localShortBuffer.capacity() * 2, localShortBuffer, 35044);
  }
  
  private void reset()
  {
    this.mInitialized = false;
    this.mVerticiesBuffer = 0;
  }
  
  private void setNinePatch()
  {
    int i = this.mLastWidth;
    int j = this.mLastHeight;
    this.mVerticiesData = new float[''];
    this.mIndiciesData = new short[54];
    int k = this.mTextureWidth;
    int m = this.mTextureHeight;
    float f9 = i;
    float f10 = j;
    float f2;
    float f4;
    float f1;
    float f3;
    float f6;
    float f8;
    float f5;
    if (i <= k)
    {
      f2 = 0.0F;
      f4 = k / k;
      f1 = 0.0F;
      f3 = i;
      if (j > m) {
        break label296;
      }
      f6 = 0.0F;
      f8 = m / m;
      f5 = 0.0F;
    }
    for (float f7 = j;; f7 = f10 - (m - this.mExpandY))
    {
      setQuad(0, 0.0F, 0.0F, f1, f5, 0.0F, 0.0F, f2, f6);
      setQuad(1, f1, 0.0F, f3, f5, f2, 0.0F, f4, f6);
      setQuad(2, f3, 0.0F, f9, f5, f4, 0.0F, 1.0F, f6);
      setQuad(3, 0.0F, f5, f1, f7, 0.0F, f6, f2, f8);
      setQuad(4, f1, f5, f3, f7, f2, f6, f4, f8);
      setQuad(5, f3, f5, f9, f7, f4, f6, 1.0F, f8);
      setQuad(6, 0.0F, f7, f1, f10, 0.0F, f8, f2, 1.0F);
      setQuad(7, f1, f7, f3, f10, f2, f8, f4, 1.0F);
      setQuad(8, f3, f7, f9, f10, f4, f8, 1.0F, 1.0F);
      return;
      f4 = this.mExpandX / k;
      f2 = f4;
      f1 = 0.0F + this.mExpandX;
      f3 = f9 - (k - this.mExpandX);
      break;
      label296:
      f8 = this.mExpandY / m;
      f6 = f8;
      f5 = 0.0F + this.mExpandY;
    }
  }
  
  private void setQuad(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    int i = paramInt * 4 * 4;
    setVertex(this.mVerticiesData, i + 0, paramFloat1, paramFloat2, paramFloat5, paramFloat6);
    setVertex(this.mVerticiesData, i + 4, paramFloat3, paramFloat2, paramFloat7, paramFloat6);
    setVertex(this.mVerticiesData, i + 8, paramFloat3, paramFloat4, paramFloat7, paramFloat8);
    setVertex(this.mVerticiesData, i + 12, paramFloat1, paramFloat4, paramFloat5, paramFloat8);
    this.mIndiciesData[(paramInt * 6 + 0)] = ((short)(paramInt * 4 + 0));
    this.mIndiciesData[(paramInt * 6 + 1)] = ((short)(paramInt * 4 + 1));
    this.mIndiciesData[(paramInt * 6 + 2)] = ((short)(paramInt * 4 + 2));
    this.mIndiciesData[(paramInt * 6 + 3)] = ((short)(paramInt * 4 + 0));
    this.mIndiciesData[(paramInt * 6 + 4)] = ((short)(paramInt * 4 + 2));
    this.mIndiciesData[(paramInt * 6 + 5)] = ((short)(paramInt * 4 + 3));
  }
  
  private void setVertex(float[] paramArrayOfFloat, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramArrayOfFloat[(paramInt + 0)] = paramFloat1;
    paramArrayOfFloat[(paramInt + 1)] = paramFloat2;
    paramArrayOfFloat[(paramInt + 2)] = paramFloat3;
    paramArrayOfFloat[(paramInt + 3)] = paramFloat4;
  }
  
  public void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      Log.e("PanelDrawer", paramString + ": glError 0x" + Integer.toHexString(i));
      throw new RuntimeException(paramString + ": glError 0x" + Integer.toHexString(i));
    }
  }
  
  public void compilePrograms()
  {
    this.mProgram = createProgram("uniform mat4 uPMatrix;\nuniform mat4 uMVMatrix;\nattribute vec2 aPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec2 vHighlightCoord;\nuniform vec2 uHighlightXMA;\nvoid main() {\n  gl_Position = (uPMatrix*uMVMatrix)*vec4(aPosition,0,1.);\n  vTextureCoord = aTextureCoord;\n  vHighlightCoord.x = (gl_Position.x/gl_Position.w)*uHighlightXMA[0]+uHighlightXMA[1];\n  vHighlightCoord.y = aTextureCoord.y;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nvarying vec2 vHighlightCoord;\nuniform sampler2D sTexture;\nuniform sampler2D sHighlight;\nuniform float uAlpha;\nuniform float uBackgroundDarken;\nuniform float uBaseDarken;\nvoid main() {\n  vec4 sampled = texture2D(sTexture, vTextureCoord);\n  float highlight = texture2D(sHighlight, vHighlightCoord).a;\n  float highlightMask = sampled.b; \n  float maskedHighlight = highlight*highlightMask; \n  float value = (sampled.g + maskedHighlight)*uAlpha;\n  float alpha = (sampled.r + maskedHighlight)*uAlpha + mix(uBackgroundDarken, uBaseDarken, sampled.b);\n  gl_FragColor = vec4(value, value, value, alpha);\n}\n");
    this.muPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uPMatrix");
    this.muMVMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVMatrix");
    this.maPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
    this.maTextureCoordHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
    this.msTextureHandle = GLES20.glGetUniformLocation(this.mProgram, "sTexture");
    this.msHighlightHandle = GLES20.glGetUniformLocation(this.mProgram, "sHighlight");
    this.muAlpha = GLES20.glGetUniformLocation(this.mProgram, "uAlpha");
    this.muBaseDarken = GLES20.glGetUniformLocation(this.mProgram, "uBaseDarken");
    this.muBackgroundDarken = GLES20.glGetUniformLocation(this.mProgram, "uBackgroundDarken");
    this.muHighlightXMLHandle = GLES20.glGetUniformLocation(this.mProgram, "uHighlightXMA");
  }
  
  public boolean hasLoadedResources()
  {
    return this.mRes != null;
  }
  
  public void loadResourceOnRenderThread()
  {
    compilePrograms();
    this.mHighlightTexture = loadTexture(this.mRes, 2130837762);
    this.mTexture = loadTexture(this.mRes, 2130837761);
    this.mExpandX = this.mRes.getDimensionPixelSize(2131624193);
    this.mExpandY = this.mRes.getDimensionPixelSize(2131624194);
  }
  
  public void loadResources(Resources paramResources)
  {
    this.mRes = paramResources;
  }
  
  public Drawable newDrawable()
  {
    return new PanelDrawable();
  }
  
  public void pause()
  {
    this.mPaused = true;
    reset();
  }
  
  public void resume()
  {
    this.mPaused = false;
  }
  
  public void setViewport(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      Log.e("PanelDrawer", "SetViewport, width or height is invalid");
      return;
    }
    this.mViewportWidth = paramInt1;
    this.mViewportHeight = paramInt2;
    this.mProjectionMatrix = new float[16];
    Matrix.orthoM(this.mProjectionMatrix, 0, 0.0F, paramInt1, paramInt2, 0.0F, -1.0F, 1.0F);
  }
  
  class Functor
    extends DrawGLFunction.Callback
  {
    float mAlpha = 0.0F;
    float mBackgroundDarken;
    float mBaseDarken;
    boolean mBlend;
    int mHeight;
    int mWidth;
    
    Functor(float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      this.mBackgroundDarken = paramFloat1;
      this.mBaseDarken = paramFloat2;
      this.mBlend = paramBoolean;
    }
    
    public void drawGL(float[] paramArrayOfFloat)
    {
      if ((PanelDrawer.this.mRes == null) || (PanelDrawer.this.mPaused)) {
        return;
      }
      if (!PanelDrawer.this.mInitialized)
      {
        PanelDrawer.this.loadResourceOnRenderThread();
        PanelDrawer.access$202(PanelDrawer.this, true);
      }
      if ((PanelDrawer.this.mVerticiesBuffer == 0) || (this.mWidth != PanelDrawer.this.mLastWidth) || (this.mHeight != PanelDrawer.this.mLastHeight))
      {
        PanelDrawer.access$402(PanelDrawer.this, this.mWidth);
        PanelDrawer.access$502(PanelDrawer.this, this.mHeight);
        PanelDrawer.this.loadVBOs();
      }
      if (this.mBlend)
      {
        GLES20.glEnable(3042);
        GLES20.glBlendEquation(32774);
        GLES20.glBlendFunc(1, 771);
        GLES20.glUseProgram(PanelDrawer.this.mProgram);
        GLES20.glBindBuffer(34962, PanelDrawer.this.mVerticiesBuffer);
        GLES20.glBindBuffer(34963, PanelDrawer.this.mIndiciesBuffer);
        GLES20.glEnableVertexAttribArray(PanelDrawer.this.maPositionHandle);
        GLES20.glEnableVertexAttribArray(PanelDrawer.this.maTextureCoordHandle);
        GLES20.glVertexAttribPointer(PanelDrawer.this.maPositionHandle, 2, 5126, false, 16, 0);
        GLES20.glVertexAttribPointer(PanelDrawer.this.maTextureCoordHandle, 2, 5126, false, 16, 8);
        GLES20.glUniformMatrix4fv(PanelDrawer.this.muMVMatrixHandle, 1, false, paramArrayOfFloat, 0);
        GLES20.glUniformMatrix4fv(PanelDrawer.this.muPMatrixHandle, 1, false, PanelDrawer.this.mProjectionMatrix, 0);
        GLES20.glUniform1f(PanelDrawer.this.muAlpha, this.mAlpha);
        if (!this.mBlend) {
          break label458;
        }
        GLES20.glUniform1f(PanelDrawer.this.muBaseDarken, 0.0F);
        GLES20.glUniform1f(PanelDrawer.this.muBackgroundDarken, 0.0F);
      }
      for (;;)
      {
        GLES20.glUniform2f(PanelDrawer.this.muHighlightXMLHandle, 0.5F, 0.5F);
        GLES20.glUniform1i(PanelDrawer.this.msTextureHandle, 0);
        GLES20.glUniform1i(PanelDrawer.this.msHighlightHandle, 1);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, PanelDrawer.this.mTexture);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, PanelDrawer.this.mHighlightTexture);
        GLES20.glActiveTexture(33984);
        GLES20.glDrawElements(4, 54, 5123, 0);
        if (PanelDrawer.this.maTextureCoordHandle != 0) {
          GLES20.glDisableVertexAttribArray(PanelDrawer.this.maTextureCoordHandle);
        }
        if (PanelDrawer.this.maPositionHandle != 0) {
          GLES20.glDisableVertexAttribArray(PanelDrawer.this.maPositionHandle);
        }
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34963, 0);
        return;
        GLES20.glDisable(3042);
        break;
        label458:
        if (PanelDrawer.this.mIgnoreDarken)
        {
          GLES20.glUniform1f(PanelDrawer.this.muBackgroundDarken, 0.0F);
          GLES20.glUniform1f(PanelDrawer.this.muBaseDarken, 0.0F);
        }
        else
        {
          GLES20.glUniform1f(PanelDrawer.this.muBackgroundDarken, this.mBackgroundDarken);
          GLES20.glUniform1f(PanelDrawer.this.muBaseDarken, this.mBaseDarken);
        }
      }
    }
    
    public void set(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
    {
      this.mAlpha = paramFloat1;
      this.mBackgroundDarken = paramFloat2;
      this.mBaseDarken = paramFloat3;
      this.mBlend = paramBoolean;
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
    }
  }
  
  class PanelDrawable
    extends Drawable
  {
    boolean blockDraw = false;
    private int mAlpha = 255;
    private float mBackgroundDarken = 0.0F;
    private float mBaseDarken = 0.0F;
    private boolean mBlend = false;
    private Rect mBounds = new Rect();
    private PanelDrawer.Functor mFunctor = new PanelDrawer.Functor(PanelDrawer.this, this.mBackgroundDarken, this.mBaseDarken, this.mBlend);
    
    PanelDrawable() {}
    
    public void draw(Canvas paramCanvas)
    {
      if (this.blockDraw) {}
      while (this.mAlpha == 0) {
        return;
      }
      int i = this.mBounds.width();
      int j = this.mBounds.height();
      float f = this.mAlpha / 255.0F;
      this.mFunctor.set(i, j, f, this.mBackgroundDarken, this.mBaseDarken, this.mBlend);
      DrawGLFunction.call(paramCanvas, this.mFunctor);
    }
    
    protected void finalize()
      throws Throwable
    {
      super.finalize();
      if (this.mFunctor != null) {
        DrawGLFunction.destroy(this.mFunctor);
      }
    }
    
    public int getAlpha()
    {
      return this.mAlpha;
    }
    
    public float getBaseDarken()
    {
      return this.mBaseDarken;
    }
    
    public int getOpacity()
    {
      return -3;
    }
    
    public boolean getPadding(Rect paramRect)
    {
      paramRect.set(20, 20, 20, 20);
      return true;
    }
    
    public void invalidateSelf()
    {
      if (this.mAlpha != 0) {
        super.invalidateSelf();
      }
    }
    
    public void onBoundsChange(Rect paramRect)
    {
      this.mBounds.set(paramRect);
    }
    
    public void setAlpha(int paramInt)
    {
      if (paramInt != this.mAlpha)
      {
        this.mAlpha = paramInt;
        invalidateSelf();
      }
    }
    
    public void setBackgroundDarken(float paramFloat)
    {
      if (paramFloat == 0.0F) {
        this.mBaseDarken = paramFloat;
      }
      if (paramFloat != this.mBackgroundDarken)
      {
        this.mBackgroundDarken = paramFloat;
        invalidateSelf();
      }
    }
    
    public void setBaseDarken(float paramFloat)
    {
      if (paramFloat != this.mBaseDarken)
      {
        this.mBaseDarken = paramFloat;
        invalidateSelf();
      }
    }
    
    public void setBlend(boolean paramBoolean)
    {
      if (this.mBlend != paramBoolean)
      {
        this.mBlend = paramBoolean;
        invalidateSelf();
      }
    }
    
    public void setColorFilter(ColorFilter paramColorFilter) {}
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/PanelDrawer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */