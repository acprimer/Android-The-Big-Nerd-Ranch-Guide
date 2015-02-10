package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.criminal_intent;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.R;

public class CrimeCameraFragment extends Fragment {
    private static final String TAG = "CrimeCameraFragment";
    public static final String EXTRA_PHOTO_FILENAME = "photo.filename";

    private Camera mCamara;
    private SurfaceView mSurfaceView;
    private View mProgressContainer;

    private Camera.ShutterCallback mShutterCallback = new Camera.ShutterCallback() {
        @Override
        public void onShutter() {
            mProgressContainer.setVisibility(View.VISIBLE);
        }
    };

    private Camera.PictureCallback mJpegCallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            String filename = UUID.randomUUID().toString() + ".jpg";
            FileOutputStream os = null;
            boolean success = true;
            try {
                os = getActivity().openFileOutput(filename, Context.MODE_PRIVATE);
                os.write(data);
            } catch (Exception e) {
                Log.e(TAG, "Error writing to file " + filename, e);
                success = false;
            } finally {
                try {
                    if (os != null) {
                        os.close();
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Error writing to file " + filename, e);
                    success = false;
                }
            }
            if (success) {
                Intent intent = new Intent();
                intent.putExtra(EXTRA_PHOTO_FILENAME, filename);
                getActivity().setResult(Activity.RESULT_OK, intent);
            } else {
                getActivity().setResult(Activity.RESULT_CANCELED);
            }
            getActivity().finish();
        }
    };

    @SuppressWarnings("deprecation")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_camera, container, false);
        Button btnTakePicture = (Button) view.findViewById(R.id.crime_camera_take_picture_btn);
        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCamara != null) {
                    mCamara.takePicture(mShutterCallback, null, mJpegCallback);
                }
            }
        });
        mSurfaceView = (SurfaceView) view.findViewById(R.id.crime_camera_surfaceview);
        SurfaceHolder holder = mSurfaceView.getHolder();
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (mCamara != null) {
                        mCamara.setPreviewDisplay(holder);
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Error setting up preview display", e);
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                if (mCamara == null) {
                    return;
                }
                Camera.Parameters parameters = mCamara.getParameters();
                Camera.Size size = getBestSupportedSize(parameters.getSupportedPictureSizes(), width, height);
//                parameters.setPreviewSize(size.width, size.height);
                size = getBestSupportedSize(parameters.getSupportedPictureSizes(), width, height);
                parameters.setPictureSize(size.width, size.height);
                mCamara.setParameters(parameters);
                try {
                    mCamara.startPreview();
                } catch (Exception e) {
                    Log.e(TAG, "Could not start preview", e);
                    mCamara.release();
                    mCamara = null;
                }
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if (mCamara != null) {
                    mCamara.stopPreview();
                }
            }
        });

        mProgressContainer = view.findViewById(R.id.crime_camera_progress_container);
        mProgressContainer.setVisibility(View.INVISIBLE);

        return view;
    }

    private Camera.Size getBestSupportedSize(List<Camera.Size> sizes, int width, int height) {
        Camera.Size bestSize = sizes.get(0);
        int largestArea = bestSize.width * bestSize.height;
        for (Camera.Size size : sizes) {
            int area = size.width * size.height;
            if (area > largestArea) {
                bestSize = size;
                largestArea = area;
            }
        }
        return bestSize;
    }

    @TargetApi(9)
    @Override
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mCamara = Camera.open(0);
        } else {
            mCamara = Camera.open();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mCamara != null) {
            mCamara.release();
            mCamara = null;
        }
    }
}
