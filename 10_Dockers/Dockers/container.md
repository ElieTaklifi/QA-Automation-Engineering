#### help
```docker container --help```

#### Запустить контейнер ubuntu и перейти в нее
```docker run -it ubuntu bash```

#### Список запущенных контейнеров
```docker container ls```

```docker ps # алиас для предыдушей записи```

#### Список всех контейнеров
```docker ps -a```

#### Удалить контейнер (если он остановлен)
```docker container rm [CID]```

#### Удалить все остановленные контейнеры
```docker container prune```

#### Запустить открепленный контейнер с именем
```docker run -it --name ubuntu_1 -d ubuntu bash```

#### Перейти в контейнер
```docker attach [CID]```

#### Выйти из контейнера не останавливая его
```CTRL+P``` , ```CTRL+Q```

#### Остановить контейнер
```docker container stop [CIP]```

#### Запустить контейнер
```docker container start [CIP]```

#### Запустить контейнер с кдалением его из списка после остановки
```docker run -it --rm --name ubuntu_1 -d ubuntu bash```