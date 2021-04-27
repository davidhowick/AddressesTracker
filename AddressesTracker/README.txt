Currently there is no console for this application however, I have
developed the app as a REST service - for its future flexibility as a service;
I suggest that this application is tested through Postman or SoapUI.

Run the application by executing this command within the AddressesTracker's main module:
    java -jar target/AddressesTracker-1.0-SNAPSHOT.jar

These are the REST endpoints developed for updating the person and addresses registered:
    http://localhost:8080/api/people/add
    http://localhost:8080/api/people/update
    http://localhost:8080/api/people/remove/{id}
    http://localhost:8080/api/people/count
    http://localhost:8080/api/people/list

    http://localhost:8080/api/address/add
    http://localhost:8080/api/address/remove/{id}
    http://localhost:8080/api/address/update

To access the H2 database please use this URL:
    http://localhost:8080/h2-console/
    user name = sa

The page where I was planning to develop the console was here:
    http://localhost:8080/personhomepage.html

Sample JSON request to person REST service:
Endpoint: http://localhost:8080/api/people/add
JSON request:
    {
	    "firstName": "Michelle",
	    "lastName": "Obama"
    }

Sample JSON request to address REST service:
Endpoint: http://localhost:8080/api/address/add
    {
	    "street": "new street",
	    "city":"Cork",
	    "state": "townland",
	    "postalCode": "DA DAOA"
    }