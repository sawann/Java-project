Запросы -localhost:8090/user
Название бд - postgres
Название таблицы в бд - users
Модель данных: id = int first_name - String last_name - String age - int
Имеются 4 роута:
get localhost:8090/user - возвращает всех пользователей. get localhost:8090/user/{:id} - возвращает определённого пользователя
по id. post localhost:8090/user - создает нового пользователя, принимает json описанной выше структуры. put
localhost:8090/user/{:id} - удаляет определённого пользователя по id.
localhost:8090/user/{:id} - изменяет данные пользователя, принимает json той же структуры. delete
