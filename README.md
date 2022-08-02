# DeYandexCloud

Данный проект представляет собой реализацию архитектуры аналитического решения (DeYandexCloud/Architecture):

На просторах kaggle взят датасет продаж магазина и из него создана база postgres (схема DeYandexCloud/DbSchema, dump DeYandexCloud/Store101_db.bak).

Далее база перенесена в yandex cloud, в котором весь проект собран и реализован.

В сервисе Yandex Managed Service for PostgreSQL создана база postgres.

Создан кластер Yandex Data Proc с hadoop, spark, hive.

Процесс загрузки данных из базы на кластер реализован с помощью spark-shell (DeYandexCloud/EL).

Создание витрины (DeYandexCloud/Datamart) на кластере и ее загрузка в созданную для нее отдельную базу (также в Yandex Managed Service for PostgreSQL) реализован тоже с помощью spark-shell (DeYandexCloud/DatamartDwh).

К базе, в которой находится витрина был подключен BI сервис Yandex DataLens, и с помощью которого были созданы дашборды:

DeYandexCloud/DashboardPS - продажи и прибыль по годам
DeYandexCloud/DashboardRegionCategory - продажи в разрезе регионов и категорий
DeYandexCloud/DashboardSegment - продажи по сегментам.

Таким образом, реализован полный цикл проекта от создания исходной базы до построения аналитических дашбордов, помогающих бизнес-пользователям принимать решения.
