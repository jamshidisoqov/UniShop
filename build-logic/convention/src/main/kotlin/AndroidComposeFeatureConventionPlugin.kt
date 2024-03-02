import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import uz.uni_team.uni_shop.convention.kotlin
import java.io.File

class AndroidComposeFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("uni_shop.android.library")
                apply("uni_shop.android.library.compose")
                apply("uni_shop.android.koin")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner =
                        "com.google.samples.apps.nowinandroid.core.testing.NiaTestRunner"
                }
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")


            dependencies {


                add("implementation", project(":domain"))
                add("implementation", project(":library:core-ui-resources"))
                add("implementation", project(":library:core-ui"))
                add("implementation", project(":library:framework"))

                //Compose
                add("implementation", libs.findLibrary("androidx.compose.ui").get())
                add("implementation",libs.findLibrary("androidx.compose.ui.graphics").get())
                add("implementation",libs.findLibrary("androidx.compose.ui.preview").get())
                add("implementation",platform(libs.findLibrary("androidx.compose.bom").get()))

                add("implementation", libs.findLibrary("androidx.compose.material3").get())

                //ram compose destination
                add("ksp", libs.findLibrary("raamcosta.compose.destinations.ksp").get())
                add("implementation", libs.findLibrary("raamcosta.compose.destinations.core").get())
                add("implementation", libs.findLibrary("raamcosta.compose.destinations.animations").get())
            }
        }
    }
}
