package com.android.myapplication.dp_world.actions;

import android.content.res.AssetManager;

import com.android.myapplication.dp_world.common.Constants;
import com.techyourchance.threadposter.BackgroundThreadPoster;
import com.techyourchance.threadposter.UiThreadPoster;

import java.io.IOException;
import java.io.InputStream;

public class AssetStreamReader {

    public interface Listener {
        void onDesignPatternDataRead(String json);

        void onDesignPatternDataReadFailed(String message);
    }

    private final AssetManager mAssetManager;
    private final BackgroundThreadPoster mBackgroundThreadPoster;
    private final UiThreadPoster mUiThreadPoster;
    private final Object Lock = new Object();

    public AssetStreamReader(AssetManager assetManager, BackgroundThreadPoster backgroundThreadPoster, UiThreadPoster uiThreadPoster) {
        mAssetManager = assetManager;
        mBackgroundThreadPoster = backgroundThreadPoster;
        mUiThreadPoster = uiThreadPoster;
    }

    public void readAssetDataAndNotify(String fileName, Listener listener) {
        synchronized (Lock) {
            mBackgroundThreadPoster.post(() -> {
                String json;
                try {
                    json = readData(fileName);
                    notifySuccess(json, listener);
                } catch (IOException ioe) {
                    notifyFailure(ioe.getMessage(), listener);
                }
            });
        }
    }

    private void notifySuccess(String json, Listener listener) {
        mUiThreadPoster.post(() -> {
            listener.onDesignPatternDataRead(json);
        });
    }

    private void notifyFailure(String errorMessage, Listener listener) {
        mUiThreadPoster.post(() -> {
            listener.onDesignPatternDataReadFailed(errorMessage);
        });
    }

    private String readData(String fileName) throws IOException {
        try {
            InputStream inputStream = mAssetManager.open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            return new String(buffer, Constants.CHARSET_NAME);
        } catch (IOException ioException) {
            throw ioException;
        }
    }
}
