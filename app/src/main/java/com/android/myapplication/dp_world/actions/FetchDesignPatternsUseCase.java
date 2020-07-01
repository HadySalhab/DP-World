package com.android.myapplication.dp_world.actions;

import com.android.myapplication.dp_world.actions.designpattern.DesignPatternSchema;
import com.android.myapplication.dp_world.actions.designpattern.DesignPatternsResponseSchema;
import com.android.myapplication.dp_world.common.BaseObservable;
import com.android.myapplication.dp_world.designpattern.DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class FetchDesignPatternsUseCase extends BaseObservable<FetchDesignPatternsUseCase.Listener> {
    public interface Listener {
        void onDesignPatternsFetched(List<DesignPattern> designPatterns);

        void onDesignPatternsFetchFailed(String errorMessage);
    }

    private final AssetStreamReader mAssetStreamReader;
    private final JsonToGsonConverter mJsonToGsonConverter;

    public FetchDesignPatternsUseCase(AssetStreamReader assetStreamReader,
                                      JsonToGsonConverter jsonToGsonConverter) {
        mAssetStreamReader = assetStreamReader;
        mJsonToGsonConverter = jsonToGsonConverter;
    }

    public void fetchDesignPatternsAndNotify(String fileName) {
        mAssetStreamReader.readAssetDataAndNotify(fileName, new AssetStreamReader.Listener() {
            @Override
            public void onDesignPatternDataRead(String json) {
                DesignPatternsResponseSchema designPatternsResponseSchema =
                        mJsonToGsonConverter.convertToGson(DesignPatternsResponseSchema.class, json);
                List<DesignPattern> designPatterns = getDesignPatternListFromResult(designPatternsResponseSchema);
                notifySuccess(designPatterns);
            }

            @Override
            public void onDesignPatternDataReadFailed(String message) {
                notifyFailure(message);
            }

        });
    }

    private List<DesignPattern> getDesignPatternListFromResult(DesignPatternsResponseSchema designPatternsResponseSchema) {
        List<DesignPattern> designPatterns = new ArrayList<>();
        for (DesignPatternSchema designPatternSchema : designPatternsResponseSchema.getDesignPatterns()) {
            designPatterns.add(new DesignPattern(
                    designPatternSchema.getId(),
                    designPatternSchema.getTitle(),
                    designPatternSchema.getCategory(),
                    designPatternSchema.getDescription()));
        }
        return designPatterns;
    }

    private void notifySuccess(List<DesignPattern> designPatterns) {
        for (Listener listener : getListeners()) {
            listener.onDesignPatternsFetched(designPatterns);
        }
    }

    private void notifyFailure(String errorMessage) {
        for (Listener listener : getListeners()) {
            listener.onDesignPatternsFetchFailed(errorMessage);
        }
    }
}
