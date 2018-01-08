package com.android.launcher2;

import android.content.Context;
import android.graphics.Canvas;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class BlendedDarkenView
  extends View
{
  private static final boolean DEBUGGABLE = ;
  private static final String TAG = "BlendedDarkenView";
  private static int mIndiciesBuffer = 0;
  private static short[] mIndiciesData;
  private static int mProgram = 0;
  private static int mVerticiesBuffer = 0;
  private static float[] mVerticiesData;
  private static int maPositionHandle = 0;
  private static int muAlpha = 0;
  private static final String sFragmentSource = "precision mediump float;\nuniform float uAlpha;\nvoid main() {\n  gl_FragColor = vec4(uAlpha);\n}\n";
  private static final String sVertexSource = "attribute vec2 aPosition;\nvoid main() {\n  gl_Position = vec4(aPosition,0,1.);\n}\n";
  private boolean loaded = false;
  final Drawer mDrawer = new Drawer();
  
  public BlendedDarkenView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BlendedDarkenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void compilePrograms()
  {
    mProgram = createProgram("attribute vec2 aPosition;\nvoid main() {\n  gl_Position = vec4(aPosition,0,1.);\n}\n", "precision mediump float;\nuniform float uAlpha;\nvoid main() {\n  gl_FragColor = vec4(uAlpha);\n}\n");
    maPositionHandle = GLES20.glGetAttribLocation(mProgram, "aPosition");
    muAlpha = GLES20.glGetUniformLocation(mProgram, "uAlpha");
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
      GLES20.glAttachShader(j, m);
      GLES20.glLinkProgram(j);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(j, 35714, paramString1, 0);
      i = j;
    } while (paramString1[0] == 1);
    if (DEBUGGABLE)
    {
      Log.e("BlendedDarkenView", "Could not link program: ");
      Log.e("BlendedDarkenView", GLES20.glGetProgramInfoLog(j));
    }
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
        if (DEBUGGABLE)
        {
          Log.e("BlendedDarkenView", "Could not compile shader " + paramInt + ":");
          Log.e("BlendedDarkenView", GLES20.glGetShaderInfoLog(j));
        }
        GLES20.glDeleteShader(j);
        i = 0;
      }
    }
    return i;
  }
  
  private void loadVBOs()
  {
    mVerticiesData = new float[8];
    mIndiciesData = new short[6];
    setVertex(mVerticiesData, 0, -1.0F, 1.0F);
    setVertex(mVerticiesData, 2, 1.0F, 1.0F);
    setVertex(mVerticiesData, 4, 1.0F, -1.0F);
    setVertex(mVerticiesData, 6, -1.0F, -1.0F);
    mIndiciesData[0] = 0;
    mIndiciesData[1] = 1;
    mIndiciesData[2] = 2;
    mIndiciesData[3] = 0;
    mIndiciesData[4] = 2;
    mIndiciesData[5] = 3;
    ShortBuffer localShortBuffer = ByteBuffer.allocateDirect(mIndiciesData.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
    localShortBuffer.put(mIndiciesData).position(0);
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(mVerticiesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(mVerticiesData).position(0);
    if (mVerticiesBuffer == 0)
    {
      int[] arrayOfInt = new int[2];
      GLES20.glGenBuffers(2, arrayOfInt, 0);
      mVerticiesBuffer = arrayOfInt[0];
      mIndiciesBuffer = arrayOfInt[1];
    }
    GLES20.glBindBuffer(34962, mVerticiesBuffer);
    GLES20.glBufferData(34962, localFloatBuffer.capacity() * 4, localFloatBuffer, 35044);
    GLES20.glBindBuffer(34963, mIndiciesBuffer);
    GLES20.glBufferData(34963, localShortBuffer.capacity() * 2, localShortBuffer, 35044);
  }
  
  private void setVertex(float[] paramArrayOfFloat, int paramInt, float paramFloat1, float paramFloat2)
  {
    paramArrayOfFloat[(paramInt + 0)] = paramFloat1;
    paramArrayOfFloat[(paramInt + 1)] = paramFloat2;
  }
  
  public void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      if (DEBUGGABLE) {
        Log.e("BlendedDarkenView", paramString + ": glError 0x" + Integer.toHexString(i));
      }
      throw new RuntimeException(paramString + ": glError 0x" + Integer.toHexString(i));
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    DrawGLFunction.call(paramCanvas, this.mDrawer);
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    DrawGLFunction.destroy(this.mDrawer);
  }
  
  public float getAlpha()
  {
    return this.mDrawer.mAlpha;
  }
  
  public boolean onSetAlpha(int paramInt)
  {
    if (paramInt == 255) {}
    while (this.mDrawer == null) {
      return true;
    }
    Drawer.access$002(this.mDrawer, paramInt / 255.0F);
    return true;
  }
  
  class Drawer
    extends DrawGLFunction.Callback
  {
    private float mAlpha = 0.0F;
    
    Drawer() {}
    
    public void drawGL(float[] paramArrayOfFloat)
    {
      if (this.mAlpha == 0.0F) {
        return;
      }
      if (!BlendedDarkenView.this.loaded)
      {
        BlendedDarkenView.this.compilePrograms();
        BlendedDarkenView.this.loadVBOs();
        BlendedDarkenView.access$102(BlendedDarkenView.this, true);
      }
      GLES20.glEnable(3042);
      GLES20.glBlendEquation(32779);
      GLES20.glBlendFunc(770, 771);
      GLES20.glUseProgram(BlendedDarkenView.mProgram);
      GLES20.glBindBuffer(34962, BlendedDarkenView.mVerticiesBuffer);
      GLES20.glBindBuffer(34963, BlendedDarkenView.mIndiciesBuffer);
      GLES20.glEnableVertexAttribArray(BlendedDarkenView.maPositionHandle);
      GLES20.glVertexAttribPointer(BlendedDarkenView.maPositionHandle, 2, 5126, false, 0, 0);
      GLES20.glUniform1f(BlendedDarkenView.muAlpha, this.mAlpha * 1.85F);
      GLES20.glDrawElements(4, 6, 5123, 0);
      if (BlendedDarkenView.maPositionHandle != 0) {
        GLES20.glDisableVertexAttribArray(BlendedDarkenView.maPositionHandle);
      }
      GLES20.glBindBuffer(34962, 0);
      GLES20.glBindBuffer(34963, 0);
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/BlendedDarkenView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */