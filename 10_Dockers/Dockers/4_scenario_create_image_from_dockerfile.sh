docker build -t python_counter .

docker image ls

docker run --rm python_counter

docker rmi python_counter # the same as 'docker image rm python_counter'