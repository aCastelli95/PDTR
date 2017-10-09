#!/bin/bash
#Nos dejara la terminal con la imagen del docker corriendo.


sudo docker run -itd -v /home/alan/Documentos/PDTR/P3:/pdytr/ -p 5901:5901 -p 6901:6901 --name pdytr gmaron/pdytr
sudo docker exec --user root -it pdytr bash

