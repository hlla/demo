package example.com.testglview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;

import com.cmcm.gl.view.GLViewTreeObserver;
import com.cmcm.gl.widget.GLFrameLayout;

/**
 * Created by fqc on 11/13/15.
 */
public class LauncherViewFrameLayout extends GLFrameLayout {

    private int mMaxAlphaByLiveWP = 0x99;
    private float mAlphaByLiveWP;

    private Paint sPaint = new Paint();
    private boolean isAnimationing = false;
//    private LauncherViewHardwareDrawCallback mLauncherViewHardwareDrawCallback;

    public LauncherViewFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
//        setWillNotDraw(false);
        getViewTreeObserver().addOnGlobalLayoutListener(new GLViewTreeObserver
                .OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Log.d("chengjian_la", "onGlobalLayout: w=" + getWidth() + " h=" + getHeight() +
                        "" + " this=" + getViewTreeObserver());
            }
        });
    }

    @Override
    protected boolean fitSystemWindows(Rect insets) {
        Log.d("chengjian_la", "fitSystemWindows: insets=" + insets);
        return super.fitSystemWindows(insets);
    }

//    public void startScreenEffect(float x, float y) {
//
//        int width = this.getWidth();
//        int height = this.getHeight();
//
//        if (!isAnimationing && width != 0 && height != 0) {
//
//            if (mLauncherViewHardwareDrawCallback == null
//                    || mLauncherViewHardwareDrawCallback.width() != width
//                    || mLauncherViewHardwareDrawCallback.height() != height) {
//                mLauncherViewHardwareDrawCallback = new LauncherViewHardwareDrawCallback(width,
//                        height);
//            }
//
//            isAnimationing = true;
//
//            this.setLayerType(LAYER_TYPE_HARDWARE, sPaint);
//
//            this.setHardwareDrawCallback(mLauncherViewHardwareDrawCallback);
//
//            mLauncherViewHardwareDrawCallback.startAnimation(x, y);
//
//        }
//
//
//    }

    public void finishScreenEffect() {

        isAnimationing = false;

        this.setLayerType(LAYER_TYPE_NONE, sPaint);

        this.cleanHardwareDrawCallback();

    }

//    class LauncherViewHardwareDrawCallback implements HardwareDrawCallback {
//
//
//        private final WaveContainer mWaveContainer;
//        private final TextureElement mScreentexture;
//        private final int mWidth;
//        private final int mHeight;
//
//        public LauncherViewHardwareDrawCallback(int width, int height) {
//
//            mWidth = width;
//
//            mHeight = height;
//
//            mWaveContainer = new WaveContainer(width, height);
//
//            mScreentexture = new TextureElement(0, false);
//
//            mWaveContainer.texture(mScreentexture);
//
//        }
//
//        public int width() {
//            return mWidth;
//        }
//
//        public int height() {
//            return mHeight;
//        }
//
//        public void startAnimation(float x, float y) {
//
//            float[] touch = Utils.conversionCoordinatesSG(x, y);
//
//            mWaveContainer.tweenAnimation(touch[0], touch[1]);
//        }
//
//        @Override
//        public void onHardwareDraw(RenderProperties properties, int textureId, int width, int
//                height) {
//
//            MatrixStack.glResetMatrix();
//            System.arraycopy(MatrixStack.rSceneCenterMatrix, 0, MatrixStack.rGLViewVPMatrix, 0, 16);
//
//            mScreentexture.setId(textureId);
//            mWaveContainer.resize(width, height);
//            mWaveContainer.dispatchDraw();
//
//        }
//
//    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);


//        if (true) {
//            Paint paint = new Paint();
//            Shader topShader = new LinearGradient(0, 0, 0, DimenUtil.dp2px(75), new int[]{
//                    0x40000000, 0x00000000}, null,
//                    Shader.TileMode.REPEAT);
//            paint.setShader(topShader);
//            canvas.drawRect(0, 0, getWidth(), DimenUtil.dp2px(75), paint);
//
//            if (SystemUtils.getNavigationBarHeight(this.getContext()) > 0) {
//                Shader bottomShader = new LinearGradient(0, getHeight() - DimenUtil.dp2px(75), 0,
//                        getHeight(), new int[]{
//                        0x00000000, 0x40000000,}, null,
//                        Shader.TileMode.REPEAT);
//                paint.setShader(bottomShader);
//                canvas.drawRect(0, getHeight() - DimenUtil.dp2px(75), getWidth(), getHeight(),
//                        paint);
//            }
//        }
    }

    public void resetBackground() {
        this.invalidate();
    }

    public void setBackgroundWithLiveWallpaper(float alpha) {
        mAlphaByLiveWP = alpha;
        this.invalidate();
    }

//
//    public class WaveContainer extends Rectangle {
//
//        private final Uv[] mUVs;
//
//        private Number3d mNumber3d = new Number3d();
//
//        private float mMaxRadius = 0f;
//
//        public WaveContainer(float width, float height) {
//
//            super(width, height, (int) Math.ceil(width / CanvasInfo.dp(13)), (int) Math.ceil
//                            (height / CanvasInfo.dp(13)), new Color4(255, 255, 255, 255), false,
//                    true,
//                    true, true);
//
//            mMaxRadius = Math.max(width, height) + CanvasInfo.dp(300);
//
//            this.flipVerticalUV();
//
//            this.useVBO(false);
//
//            int max = this.uvs().size();
//
//            mUVs = new Uv[max];
//
//            for (int i = 0; i < max; i++) {
//
//                mUVs[i] = new Uv(uvs().getU(i), uvs().getV(i));
//
//            }
//
//        }
//
//        @Override
//        public void onDrawStart() {
//            super.onDrawStart();
//            FastVertexBuffer vertexBuffer = (FastVertexBuffer) vertices().points();
//            if (vertexBuffer.flush()) {
//                if (useVBO()) {
//                    updatePointsVBO();
//                }
//            }
//
//            FastVertexBuffer normalBuffer = (FastVertexBuffer) vertices().normals();
//            if (normalBuffer.flush()) {
//                if (useVBO()) {
//                    updateNormalVBO();
//                }
//            }
//
//            FastUVBuffer uvBuffer = (FastUVBuffer) vertices().uvs();
//            if (uvBuffer.flush()) {
//                if (useVBO()) {
//                    updateUvsVBO();
//                }
//            }
//
//            FastColorBuffer colorBuffer = (FastColorBuffer) vertices().colors();
//            if (colorBuffer != null && colorBuffer.flush()) {
//                if (useVBO()) {
//                    updateColorVBO();
//                    ;
//                }
//            }
//        }
//
//        private void tweenAnimation(final float _x, final float _y) {
//
//            final float tx = _x - CanvasInfo.dp(1);
//            final float ty = _y + CanvasInfo.dp(9);
//
//            TweenParam tp = new TweenParam() {
//
//                @Override
//                public void onUpdate(float precent) {
//
//                    calculateRipple(precent * mMaxRadius, tx, ty);
//
//                }
//
//                public void onComplete() {
//
//                    CEngine.getRenderMessager().postUIThreadRunnable(new Runnable() {
//                        @Override
//                        public void run() {
//                            finishScreenEffect();
//                        }
//                    });
//
//                }
//            };
//
//            //tp.setEase(Easing.EASE_OUT);
//            Tween.killTween(this);
//            Tween.to(this, 2300, tp);
//
//
//        }
//
//        public void calculateRipple(float radius, float sx, float sy) {
//
//            int max = this.points().size();
//
//            float wavelength = CanvasInfo.dp(120);
//
//            float minLength = CanvasInfo.dp(120);
//
//            for (int i = 0; i < max; i++) {
//
//                mNumber3d.x = this.points().pxX(i);
//
//                mNumber3d.y = this.points().pxY(i);
//
//                float dx = mNumber3d.x - sx;
//
//                float dy = mNumber3d.y - sy;
//
//                float length = (float) Math.sqrt(dx * dx + dy * dy);
//
//                float offset = length - radius;
//
//                if (offset > -wavelength && offset < 0) {
//
//                    float porp = (float) Math.sin(((offset / wavelength) + 1) * Math.PI);
//
//                    float porpLength = length / minLength;
//
//                    porpLength = porpLength > 1f ? 1f : porpLength;
//
//                    float z = porp * 0.010f * porpLength;
//
//                    this.uvs().set(i, mUVs[i].u - z, mUVs[i].v + z);
//
//                    float hlPorp = porp - 0.5f;
//
//                    hlPorp = hlPorp > 0 ? hlPorp : 0;
//
//                    float hl = 1.0f + 0.6f * hlPorp;
//
//                    this.colors().set(i, hl, hl, hl, 1f);
//
//                } else {
//
//                    this.uvs().set(i, mUVs[i]);
//
//                    this.colors().set(i, 1f, 1f, 1f, 1f);
//                }
//
//
//            }
//
//        }
//    }

}
