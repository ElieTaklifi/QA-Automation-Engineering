# запускаем Selenium Server через Docker неправильно
docker run -d --rm -p 4444:4444 selenium/standalone-chrome:3.141.59

# директория с тестами
cd Autotests/

# запускаем тест через Maven - заменить в команде <USER_NAME>
docker run --rm --network host  --mount type=bind,src=/Users/<USER_NAME>/LearnQA_Docker/Autotests/,target=/usr/src/mymaven -w /usr/src/mymaven  maven:3.6.3-ibmjava-8 mvn -q -Dtest=SimpleTest test

# see logs
docker ps
docker logs [CID]
