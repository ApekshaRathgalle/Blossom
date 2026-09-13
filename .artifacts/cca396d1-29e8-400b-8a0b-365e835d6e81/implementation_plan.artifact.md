# Implementation Plan - Custom Bottom Navigation Bar in Compose

The goal is to implement a custom bottom navigation bar as shown in the screenshot using Jetpack Compose. This includes enabling Compose in the project, generating missing icons, and creating a pixel-perfect Composable.

## User Review Required

> [!IMPORTANT]
> This project currently does not have Jetpack Compose enabled. I will be modifying `build.gradle.kts` and `libs.versions.toml` to enable it.
> Some icons (`ic_focus`, `ic_profile`) are missing from the project drawables and will be generated to match the screenshot.

## Proposed Changes

### Build Configuration

#### [MODIFY] [libs.versions.toml](file:///D:/Android/Blossom/gradle/libs.versions.toml)
- Add Compose BOM and core dependencies (UI, Material3, Graphics, Tooling, Activity-Compose).

#### [MODIFY] [build.gradle.kts](file:///D:/Android/Blossom/app/build.gradle.kts)
- Enable `compose` build feature.
- Set `composeOptions` (if needed, though modern AGP handles this).
- Add Compose dependencies using the BOM.

---

### Resources

#### [NEW] [ic_focus.xml](file:///D:/Android/Blossom/app/src/main/res/drawable/ic_focus.xml)
- Vector drawable for the checkmark-in-circle icon (Focus).

#### [NEW] [ic_profile.xml](file:///D:/Android/Blossom/app/src/main/res/drawable/ic_profile.xml)
- Vector drawable for the person/user icon (Profile).

---

### UI Components

#### [NEW] [BlossomBottomNavigation.kt](file:///D:/Android/Blossom/app/src/main/java/com/example/blossom/ui/navigation/BlossomBottomNavigation.kt)
- Create a `BlossomBottomNavigation` Composable.
- Use a custom layout or a `Row` within a `Surface` with rounded corners and a border/shadow to match the screenshot.
- Implement the central FAB with an offset to achieve the overlapping look.
- Add a `@Preview` for the component using a basic theme wrapper.

## Verification Plan

### Automated Verification
- **Build**: Run `./gradlew assembleDebug` to ensure the project compiles with the new Compose dependencies.
- **Render**: Use `render_compose_preview` to verify the UI matches the screenshot exactly.

### Manual Verification
- Verify that icons are correctly tinted (Pink for selected, Gray for unselected).
- Verify the spacing and rounded corners of the bottom bar.
