#KTrucker
##API can be accssed at http://www.ktrucker.tk/api/   
which is hosted on EC2 and connected to live database MySQL on RDS

###A simple Angular app is included for my testing purpose
http://ktrucker.s3-website-us-west-2.amazonaws.com/

###Listed below are accsesebile URLs for GET, POST and put

###Alerts
**To view all Alerts : /api/alerts/
**To view Alerts for specific vehicle : /api/alerts/WA1CMAFE6BD002500
**To view Alerts within last '2' hours for 'HIGH' severity : /api/alerts/?severity=HIGH&within=2

###Vehicles
**To view all Vehicles : /api/vehicles/
**To specific Vehicles : /api/vehicles/WA1CMAFE6BD002500
**To ingest Vehicles from mocker: PUT: /api/vehicles/

###Readings
**To view all Readings : /api/readings/
**To specific Vehicles within last 30 minutes : /api/readings/WA1CMAFE6BD002500?within=30
**To ingest Readings from mocker: Post: /api/readings/


## trucker-seed
seed for the Webservices & Cloud project

### For the final module submission, update following urls for your app:
**`Jenkins URL`**: `http://ec2-<somehost>.amazonaws.com/jenkins`    
**`Swagger URL`**: `http://ec2-<somehost>.amazonaws.com/swagger`