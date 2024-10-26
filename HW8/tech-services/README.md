### Java Spring HW 3.1    
1. Return all records    
GET http://localhost:8080/api/v1/services/all    

 2. Add record
 POST http://localhost:8080/api/v1/services/create
 Payload sample:    
 {
    "id": 1,
    "name": "service 1"
 }
 Validation included    

 3. Fetch record by id    
 http://localhost:8080/api/v1/services/1
 Validation included    
