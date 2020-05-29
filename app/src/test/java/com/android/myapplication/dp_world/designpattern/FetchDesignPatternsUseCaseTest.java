package com.android.myapplication.dp_world.designpattern;

import com.android.myapplication.dp_world.data.AssetStreamReader;
import com.android.myapplication.dp_world.data.designpattern.DesignPatternSchema;
import com.android.myapplication.dp_world.data.designpattern.DesignPatternsResponseSchema;
import com.android.myapplication.dp_world.data.JsonToGsonConverter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FetchDesignPatternsUseCaseTest {

    // region constants ----------------------------------------------------------------------------
    private static final String DESIGN_PATTERN_JSON = "DESIGN_PATTERN_JSON";
    private static final String FILE_NAME = "DesignPatterns.json";
    private static final int ID = 1;
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String CATEGORY = "category";
    private static final String ERROR_MESSAGE = "error_message";
    // endregion constants -------------------------------------------------------------------------

    // region helper fields ------------------------------------------------------------------------
    @Mock
    AssetStreamReader mAssetStreamReaderMock;
    @Mock
    JsonToGsonConverter mJsonToGsonConverterMock;
    @Mock
    FetchDesignPatternsUseCase.Listener mListener1;
    @Mock
    FetchDesignPatternsUseCase.Listener mListener2;
    // endregion helper fields ---------------------------------------------------------------------

    FetchDesignPatternsUseCase SUT;


    @Before
    public void setup() throws Exception {
        SUT = new FetchDesignPatternsUseCase(mAssetStreamReaderMock, mJsonToGsonConverterMock);
    }

    @Test
    public void fetchDesignPatterns_correctFileNamePassedToAssetReader() {
        // Arrange
        // Act
        SUT.fetchDesignPatternsAndNotify();
        // Assert
        verify(mAssetStreamReaderMock).readAssetDataAndNotify(eq(FILE_NAME), any());
    }

    @Test
    public void fetchDesignPattern_success_delegateResultToGsonConverter() {
        // Arrange
        success();
        // Act
        SUT.fetchDesignPatternsAndNotify();
        // Assert
        verify(mJsonToGsonConverterMock).convertToGson(
                eq(DesignPatternsResponseSchema.class),
                eq(DESIGN_PATTERN_JSON));
    }

    @Test
    public void fetchDesignPattern_success_listenersNotifiedWithCorrectData() {
        // Arrange
        success();
        SUT.registerListener(mListener1);
        SUT.registerListener(mListener2);
        // Act
        SUT.fetchDesignPatternsAndNotify();
        // Assert
        verify(mListener1).onDesignPatternsFetched(eq(getDesignPatternList()));
    }

    @Test
    public void fetchDesignPattern_success_unregisteredListenersNotNotified() {
        // Arrange
        success();
        SUT.registerListener(mListener1);
        SUT.registerListener(mListener2);
        SUT.unregisterListener(mListener2);
        // Act
        SUT.fetchDesignPatternsAndNotify();
        // Assert
        verifyNoMoreInteractions(mListener2);
    }

    @Test
    public void fetchDesignPattern_failure_listenersNotifiedOfFailure() {
        // Arrange
        failure();
        SUT.registerListener(mListener1);
        // Act
        SUT.fetchDesignPatternsAndNotify();
        // Assert
        verify(mListener1).onDesignPatternsFetchFailed(eq(ERROR_MESSAGE));
    }

    // region helper methods -----------------------------------------------------------------------
    private void success() {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                AssetStreamReader.Listener listener = (AssetStreamReader.Listener) args[1];
                listener.onDesignPatternDataRead(DESIGN_PATTERN_JSON);
                return null;
            }
        }).when(mAssetStreamReaderMock).readAssetDataAndNotify(
                eq(FILE_NAME),
                any(AssetStreamReader.Listener.class)
        );
        when(mJsonToGsonConverterMock
                .convertToGson(DesignPatternsResponseSchema.class, DESIGN_PATTERN_JSON))
                .thenReturn(getDesignPatternResponseSchema());
    }
    private void failure(){
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                AssetStreamReader.Listener listener = (AssetStreamReader.Listener) args[1];
                listener.onDesignPatternDataReadFailed(ERROR_MESSAGE);
                return null;
            }
        }).when(mAssetStreamReaderMock).readAssetDataAndNotify(
                eq(FILE_NAME),
                any(AssetStreamReader.Listener.class)
        );
    }

    private DesignPatternsResponseSchema getDesignPatternResponseSchema() {
        return new DesignPatternsResponseSchema(getDesignPatternSchemaList());
    }

    private List<DesignPatternSchema> getDesignPatternSchemaList() {
        List<DesignPatternSchema> designPatternSchemaList = new ArrayList<>();
        designPatternSchemaList.add(getDesignPatternSchema());
        return designPatternSchemaList;
    }

    private DesignPatternSchema getDesignPatternSchema() {
        return new DesignPatternSchema(ID, TITLE, DESCRIPTION, CATEGORY);
    }

    private List<DesignPattern> getDesignPatternList() {
        List<DesignPattern> designPatternList = new ArrayList<>();
        DesignPatternsResponseSchema designPatternsResponseSchema = getDesignPatternResponseSchema();
        for (DesignPatternSchema designPatternSchema : designPatternsResponseSchema.getDesignPatterns()) {
            designPatternList.add(
                    new DesignPattern(designPatternSchema.getId(),
                            designPatternSchema.getTitle(),
                            designPatternSchema.getCategory()));
        }
        return designPatternList;
    }
    // endregion helper methods --------------------------------------------------------------------

    // region helper classes -----------------------------------------------------------------------
    // endregion helper classes --------------------------------------------------------------------
}
