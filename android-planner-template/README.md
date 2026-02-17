# Android Planner Template (Kotlin + Compose)

Минимальный шаблон планера задач с календарной датой и списком дел по времени.

## Что внутри
- Jetpack Compose UI
- Room (Entity + DAO + Database)
- ViewModel + StateFlow
- Экран дня: задачи на выбранную дату, отсортированные по времени
- Добавление быстрых демо-задач

---

## Как перенести в Android Studio и запустить (очень подробно)

### Вариант A (самый простой): открыть готовую папку
1. Скачай/клонируй репозиторий к себе на компьютер.
2. Убедись, что у тебя есть папка:
   - `.../android-planner-template`
3. Открой **Android Studio**.
4. На стартовом экране нажми **Open** (или `File → Open`).
5. Выбери **именно папку `android-planner-template`** (не всю верхнюю папку репозитория).
6. Нажми **OK** и дождись индексации + **Gradle Sync**.

После этого справа/сверху должен появиться модуль `app`.

7. Проверь SDK:
   - `File → Settings → Android SDK`
   - установи **Android SDK Platform 34** и **Android SDK Build-Tools**.
8. Проверь JDK для Gradle:
   - `File → Settings → Build, Execution, Deployment → Build Tools → Gradle`
   - поле **Gradle JDK** = **17**.
9. Создай эмулятор:
   - `Tools → Device Manager → Create device`
   - выбери любой Pixel + образ Android (API 26+).
10. Нажми кнопку **Run ▶** (или `Shift+F10`).

---

### Вариант B: если хочешь «вставить файлы» в свой новый проект
Если ты уже создал новый проект в Android Studio и хочешь перенести код туда:

1. Создай пустой проект **Empty Activity (Jetpack Compose)**.
2. Закрой проект и скопируй из шаблона в свой проект:
   - папку `app/src/main/java/com/example/planner/...`
   - `app/src/main/AndroidManifest.xml`
   - `app/src/main/res/values/themes.xml`
   - `app/build.gradle.kts`
   - `settings.gradle.kts`
   - `build.gradle.kts`
   - `gradle.properties`
3. Открой проект снова в Android Studio.
4. Нажми **Sync Now**.
5. Запусти приложение через **Run ▶**.

> Важно: package name (`com.example.planner`) должен совпадать в `MainActivity` и в `namespace/applicationId`.

---

## Запуск через терминал (без Android Studio)
В шаблоне сейчас нет `./gradlew`, поэтому используется локально установленный `gradle`:

```bash
cd android-planner-template
gradle :app:assembleDebug
```

APK после сборки:
`app/build/outputs/apk/debug/app-debug.apk`

---

## Частые проблемы
- **`AAPT: resource style/Theme.Material3.DayNight.NoActionBar not found`**
  - обновите проект до текущего состояния (в шаблоне тема уже заменена на `Theme.MaterialComponents.DayNight.NoActionBar`);
  - сделайте `File → Sync Project with Gradle Files`.
- **`Plugin com.android.application was not found`**
  - проверь интернет/прокси;
  - убедись, что в `settings.gradle.kts` есть `google()` и `mavenCentral()`.
- **Ошибки Java версии**
  - для Android Gradle Plugin нужен JDK 17.
- **Нет Android SDK**
  - установи SDK Platform 34 и Build-Tools в `SDK Manager`.
- **Кнопка Run серая / нет модуля app**
  - проект открыт не той папкой; открой снова именно `android-planner-template`.

---

## Что добавить дальше
- Экран месячного календаря (Material3 DatePicker/Dialog)
- Редактирование/удаление задачи
- Notification reminders через WorkManager/AlarmManager
- Unit/UI тесты
