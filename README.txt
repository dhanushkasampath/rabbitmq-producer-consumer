Use this command to run the docker of rabbitmq
docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management

After this command image will be pulled and run

Then call this url
http://localhost:15672/#/

default username and password: guest and guest