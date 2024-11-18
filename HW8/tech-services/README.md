### Java Spring HW 8    
1. How to run HW 8
- Start up the database with test data    
$ cd etc/docker    
$ docker compose up    
    
- Open in browser the SQL client of your choice adminer/pgadmin    
Please refer to settings described at docker-compose.yml    
    
- Please note pgadmin settings:     
In order to pgadmin been able to address DB located at docker, please add following at creation of connection:    
$hostname/address: host.docker.internal       

2. Please refer to DB structure at sql files (data.sql, scheme.sql) located at:     
$ cd src/main/resources

3. Please import Postman client collection and refer for provided API    



