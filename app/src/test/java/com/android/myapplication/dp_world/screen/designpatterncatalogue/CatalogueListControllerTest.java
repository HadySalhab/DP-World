package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import android.content.Context;

import com.android.myapplication.dp_world.screen.common.views.ScreensNavigator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatalogueListControllerTest {

    // region constants ----------------------------------------------------------------------------
    // endregion constants -------------------------------------------------------------------------

    // region helper fields ------------------------------------------------------------------------
    @Mock
    Context mContextMock;
    @Mock
    ScreensNavigator mScreensNavigatorMock;
    @Mock
    CatalogueViewMvc mViewMvc;
    // endregion helper fields ---------------------------------------------------------------------

    CatalogueListController SUT;

    @Before
    public void setup() throws Exception {
        SUT = new CatalogueListController(mScreensNavigatorMock, mContextMock, backPressDispatcher);
        SUT.bindViewMvc(mViewMvc);
    }

    @Test
    public void onStart_registerToViewMvc() {
        // Arrange
        // Act
        SUT.onStart();
        // Assert
        verify(mViewMvc).registerListener(eq(SUT));
    }

    @Test
    public void onStart_bindCatalogueList() {
        // Arrange
        // Act
        SUT.onStart();
        // Assert
        verify(mViewMvc).bindCatalogueItem(eq(CatalogueItem.values()));
    }
    // region helper methods -----------------------------------------------------------------------

    @Test
    public void onStop_unregisterFromViewMvc() {
        // Arrange
        // Act
        SUT.onStop();
        // Assert
        verify(mViewMvc).unregisterListener(eq(SUT));
    }

    @Test
    public void onNavigateUpClicked_navigateToDesignPatternListScreenAndClearTop() {
        // Arrange
        // Act
        SUT.onNavigateUpClicked();
        // Assert
        verify(mScreensNavigatorMock).navigateToDesignPatternListAndClearTop();
    }

    // endregion helper methods --------------------------------------------------------------------

    // region helper classes -----------------------------------------------------------------------
    // endregion helper classes --------------------------------------------------------------------
}
