plugins {
    id("uni_shop.android.feature")
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "home")
}

android{
    namespace = "uz.uni_team.home"
}
