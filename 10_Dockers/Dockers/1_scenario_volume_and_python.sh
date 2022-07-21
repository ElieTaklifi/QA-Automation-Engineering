# стартуем Ubuntu с подключением тома
docker run -it --rm --mount type=volume,src=python_program,target=/volume/ ubuntu bash

# внутри контейнера
cd /volume/
echo "for i in range(1, 6): print(i)" > counter.py
cat counter.py
exit

# запустим образ python
docker run --rm --mount type=volume,src=python_program,target=/src/,readonly python python /src/counter.py
