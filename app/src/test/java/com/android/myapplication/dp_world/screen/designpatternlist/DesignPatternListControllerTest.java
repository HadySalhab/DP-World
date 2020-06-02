package com.android.myapplication.dp_world.screen.designpatternlist;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.designpattern.FetchDesignPatternsUseCase;
import com.android.myapplication.dp_world.screen.common.views.ScreensNavigator;
import com.android.myapplication.dp_world.screen.common.views.ToastHelper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DesignPatternListControllerTest {

    // region constants ----------------------------------------------------------------------------
    private static final int ID = 1;
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String CATEGORY = "category";
    public static final String ERROR_MESSAGE = "ERROR";
    // endregion constants -------------------------------------------------------------------------

    // region helper fields ------------------------------------------------------------------------
    UseCaseTD mUseCaseTD;
    @Mock
    DesignPatternViewMvc mDesignPatternViewMvcMock;
    @Mock
    ToastHelper mToastHelperMock;
    @Mock
    ScreensNavigator mScreensNavigatorMock;
    // endregion helper fields ---------------------------------------------------------------------
    DesignPatternListController SUT;

    @Before
    public void setup() throws Exception {
        mUseCaseTD = new UseCaseTD();
        SUT = new DesignPatternListController(mUseCaseTD, mToastHelperMock, mScreensNavigatorMock, backPressDispatcher);
        SUT.bindViewMvc(mDesignPatternViewMvcMock);
    }

    @Test
    public void onStart_registerToUseCase() {
        // Arrange
        // Act
        SUT.onStart();
        // Assert
        mUseCaseTD.verifyListenerRegistered(SUT);
    }

    @Test
    public void onStart_registerViewMvc() {
        // Arrange
        // Act
        SUT.onStart();
        // Assert
        verify(mDesignPatternViewMvcMock).registerListener(SUT);
    }

    @Test
    public void onStart_fetchDesignPatterns() {
        // Arrange
        // Act
        SUT.onStart();
        // Assert
        Assert.assertThat(mUseCaseTD.getFetchInterraction(), is(1));
    }

    @Test
    public void onStop_unregisterListeners() {
        // Arrange
        // Act
        SUT.onStop();
        // Assert
        mUseCaseTD.verifyListenerNotRegistered(SUT);
        verify(mDesignPatternViewMvcMock).unregisterListener(SUT);
    }

    @Test
    public void onDesignPatternFetched_mvcBindDesignPattern() {
        // Arrange
        success();
        // Act
        SUT.onStart();
        // Assert
        verify(mDesignPatternViewMvcMock).bindDesignPatterns(eq(getDesignPatternList()));
    }

    @Test
    public void onDesignPatternFetchFailed_showToast() {
        // Arrange
        mUseCaseTD.setFailure(true);
        // Act
        SUT.onStart();
        // Assert
        verify(mToastHelperMock).showUseCaseError();
    }

    @Test
    public void onDesignPatternClicked_navigateToCatalogueList() {
        // Arrange
        // Act
        SUT.onStart();
        SUT.onDesignPatternClicked(getDesignPattern());
        // Assert
        verify(mScreensNavigatorMock).toCatalogueList(eq(getDesignPattern().getId()));

    }

    // region helper methods -----------------------------------------------------------------------
    private void success() {
        // mUseCaseTD.fetchDesignPatternsAndNotify();

    }

    private List<DesignPattern> getDesignPatternList() {
        List<DesignPattern> designPatterns = new ArrayList<>();
        designPatterns.add(getDesignPattern());
        return designPatterns;
    }

    private DesignPattern getDesignPattern() {
        return new DesignPattern(ID, TITLE, CATEGORY);
    }
    // endregion helper methods --------------------------------------------------------------------

    // region helper classes -----------------------------------------------------------------------
    private final class UseCaseTD extends FetchDesignPatternsUseCase {
        private int fetchInterraction = 0;
        private boolean mFailure = false;

        public UseCaseTD() {
            super(null, null);
        }

        @Override
        public void fetchDesignPatternsAndNotify() {
            fetchInterraction++;
            for (Listener listener : getListeners()) {
                if (mFailure) {
                    listener.onDesignPatternsFetchFailed(ERROR_MESSAGE);
                } else {
                    listener.onDesignPatternsFetched(getDesignPatternList());
                }
            }
        }

        public void verifyListenerRegistered(DesignPatternListController candidate) {
            for (Listener listener : getListeners()) {
                if (listener == candidate) {
                    return;
                }
            }
            throw new RuntimeException("listener not registered");
        }

        public void verifyListenerNotRegistered(DesignPatternListController candidate) {
            for (Listener listener : getListeners()) {
                if (listener == candidate) {
                    throw new RuntimeException("listener registered");
                }
            }
        }

        public void setFailure(boolean failure) {
            mFailure = failure;
        }

        public int getFetchInterraction() {
            return fetchInterraction;
        }
    }
    // endregion helper classes --------------------------------------------------------------------
}
