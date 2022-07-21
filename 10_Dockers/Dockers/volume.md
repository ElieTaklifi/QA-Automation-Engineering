#### Создать volume с названием my_volume
```docker volume create my_volume```

#### Показать список volume
```docker volume ls```

#### Удалить volume с именем my_volume (если он не подключен к запущенному контейнеру)
```docker volume rm my_volume```

#### Удалить все volume, которые не используются
```docker volume prune```