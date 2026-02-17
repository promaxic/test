# Android Planner Template (Kotlin + Compose)

Минимальный шаблон планера задач с календарной датой и списком дел по времени.

## Что внутри
- Jetpack Compose UI
- Room (Entity + DAO + Database)
- ViewModel + StateFlow
- Экран дня: задачи на выбранную дату, отсортированные по времени
- Добавление быстрых демо-задач

## Как запустить
1. Откройте папку `android-planner-template` в Android Studio.
2. Дождитесь Gradle Sync.
3. Запустите приложение на эмуляторе (API 26+).

## Что добавить дальше
- Экран месячного календаря (Material3 DatePicker/Dialog)
- Редактирование/удаление задачи
- Notification reminders через WorkManager/AlarmManager
- Unit/UI тесты
