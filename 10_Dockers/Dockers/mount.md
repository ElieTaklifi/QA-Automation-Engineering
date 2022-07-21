#### bind
```docker run -it --mount type=bind,src=$(pwd)/dir_for_bind/,target=/bind/ ubuntu bash```

#### volume
```docker run -it --mount type=volume,src=my_volume,target=/volume/ ubuntu bash```