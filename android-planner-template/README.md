# Android Planner Template (Kotlin + Compose)

Минимальный шаблон планера задач с календарной датой и списком дел по времени.

## Что внутри
- Jetpack Compose UI
- Room (Entity + DAO + Database)
- ViewModel + StateFlow
- Экран дня: задачи на выбранную дату, отсортированные по времени
- Добавление быстрых демо-задач

## Быстрый запуск в Android Studio (рекомендуется)
1. Откройте Android Studio (Giraffe+).
2. `File` → `Open...` → выберите папку `android-planner-template`.
3. Дождитесь `Gradle Sync`.
4. Создайте/выберите эмулятор (API 26+).
5. Нажмите `Run` ▶.

## Запуск через терминал (без Android Studio)
> В шаблоне сейчас **нет Gradle Wrapper** (`./gradlew`), поэтому используйте установленный локально `gradle`.

```bash
cd android-planner-template
gradle :app:assembleDebug
```

После сборки APK будет в:
`app/build/outputs/apk/debug/app-debug.apk`

## Частые проблемы
- **`Plugin com.android.application was not found`**
  - проверьте интернет/прокси;
  - убедитесь, что в `settings.gradle.kts` есть `google()` и `mavenCentral()`.
- **Ошибки Java версии**
  - для Android Gradle Plugin используйте JDK 17 (в Android Studio: `Settings → Build Tools → Gradle → Gradle JDK`).
- **Нет Android SDK**
  - установите SDK Platform 34 и Build-Tools через `SDK Manager`.

## Что добавить дальше
- Экран месячного календаря (Material3 DatePicker/Dialog)
- Редактирование/удаление задачи
- Notification reminders через WorkManager/AlarmManager
- Unit/UI тесты
