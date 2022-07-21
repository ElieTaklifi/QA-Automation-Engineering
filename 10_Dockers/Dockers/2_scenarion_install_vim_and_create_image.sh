docker run -it --mount type=volume,src=my_volume,target=/volume/ ubuntu bash

# apt-get update
# apt-get install apt-file -y
# apt-file update
# apt-get install vim -y
# vim test.txt
# exit

# Выставить название своего репозитория вместо <REPO_NAME>
docker commit [CID] <REPO_NAME>/ubuntu_with_vim # example: docker commit a11462f3663f nizkopal/ubuntu_with_vim

# see new image
docker image ls

# run new image
docker run -it --rm --mount type=volume,src=my_volume,target=/volume/  <REPO_NAME>/ubuntu_with_vim bash

# auth
docker login # enter login and password

# push to Docker Hub
docker push <REPO_NAME>/ubuntu_with_vim
