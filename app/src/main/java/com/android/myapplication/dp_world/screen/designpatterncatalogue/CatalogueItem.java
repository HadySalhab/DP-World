package com.android.myapplication.dp_world.screen.designpatterncatalogue;

public enum CatalogueItem {
    INTENT("Intent"),
    PROBLEM("Problem"),
    SOLUTION("Solution"),
    STEPS("Steps"),
    EXAMPLES("Examples"),
    PITFALLS("Pitfalls"),
    UML("UML"),
    IMPLEMENTATION("Implementation");

    private String mName;

    CatalogueItem(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
