# Employee-Address-Application
##### :purple_square: Its a API Based Web Application
## :one: Frameworks and Languages Used -
    1. SpringBoot
    2. JAVA
    3. Postman
    4. SQL
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## :two: Dataflow (Functions Used In)
### :purple_square: 1. Model - Model is used to Iniitialize the required attributes and create the accessable constructors and methods
#### :o: Employee.java
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;

}
```

#### :o: Address.java
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;
    private String street;
    private String city;
    private String zipcode;
}
```
##### To See Model
:white_check_mark: [Employee-Address-Model](https://github.com/Anushri-glitch/Emplyee-Address-Application/tree/master/Employee-Address-Application/src/main/java/com/Shrishti/EmployeeAddressApplication/model)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

### :purple_square: 2. Service - This Layer is used to write the logic of our CRUD operaions.
#### :o: EmployeeService.java
```java
@Service
public class EmployeeService {

    @Autowired
    IEmployeeDao employeeDao;

    public String createEmployee(List<Employee> employee) {
        employeeDao.saveAll(employee);
        return "Employee Created!!!";
    }
}
```

#### :o: AddressService.java
```java
@Service
public class AddressService {

    @Autowired
    IAddressDao addressDao;

    @Autowired
    IEmployeeDao employeeDao;


    public String createAddress(Address address) {
        addressDao.save(address);
        return "Address saved";
    }

}
```

#### To See Service
:white_check_mark: [EmployeeAddress-Service](https://github.com/Anushri-glitch/Emplyee-Address-Application/tree/master/Employee-Address-Application/src/main/java/com/Shrishti/EmployeeAddressApplication/service)
----------------------------------------------------------------------------------------------------------------------------------------------------

### :purple_square: 3. Controller - This Controller is used to like UI between Model and Service and also for CRUD Mappings.
#### :o: EmployeeController.java
```java
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //Create Employee
    @PostMapping(value = "/employee")
    public String createEmployee(@RequestBody List<Employee> employee){
        return employeeService.createEmployee(employee);
    }
}
```

#### :o: AddressController.java
```java
@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping(value = "address")
    public String createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @GetMapping(value = "address")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }
}
```

#### To See Controller
:white_check_mark: [EmployeeAddress-Controller](https://github.com/Anushri-glitch/Emplyee-Address-Application/tree/master/Employee-Address-Application/src/main/java/com/Shrishti/EmployeeAddressApplication/controller)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
### :purple_square: 3. Repository : data access object (DAO) is an object that provides an abstract interface to some type of database or other persistence mechanisms.
#### :o: IEmployeeDao.java
```java
@Repository
public interface IEmployeeDao extends JpaRepository<Employee,Integer> {
}
```

#### :o: IAddressDao.java
```java
@Repository
public interface IAddressDao extends JpaRepository<Address,Integer> {
}
```
#### To See Repository
:white_check_mark: [EmployeeAddress-DAO](https://github.com/Anushri-glitch/Emplyee-Address-Application/tree/master/Employee-Address-Application/src/main/java/com/Shrishti/EmployeeAddressApplication/repository)
-------------------------------------------------------------------------------------------------------------------------------------------------------
## :three: DataStructures Used in Project
    1. ResponseEntity
    2. List
-------------------------------------------------------------------------------------------------------------------------------------------------------
## :four: DataBase Response In project

:arrow_right: Employee table
 ```sql
 select * from employee;
+-------------+------------+------------+---------+
| employee_id | first_name | last_name  | address |
+-------------+------------+------------+---------+
|          53 | Neha       | Gupta      |       2 |
|         102 | Anushka    | Srivastava |      52 |
|         103 | Neha       | Gupta      |      53 |
+-------------+------------+------------+---------+
```
:arrow_right: Address Table 
```sql
select * from address;
+------------+-----------+------------+---------+
| address_id | city      | street     | zipcode |
+------------+-----------+------------+---------+
|          1 | Allahabad | Rajrookpur | 211016  |
|          2 | Banaras   | ring rode  | 211016  |
|         52 | Allahabad | Rajrookpur | 211016  |
|         53 | Lucknow   | Hajratganj | 211016  |
+------------+-----------+------------+---------+
```
----------------------------------------------------------------------------------------------------------------------------------------------------------
## :five: Project Summary
### :o: Project result 
#### :purple_square: SAVE EMPLOYEE : http://localhost:8080/employee
![Screenshot (788)](https://user-images.githubusercontent.com/47708011/236824811-648d9119-b61d-403e-8c83-8c78566eccbe.png)

#### :purple_square: FIND All EMPLOYEES : http://localhost:8080/employee
![Screenshot (789)](https://user-images.githubusercontent.com/47708011/236825054-6614b006-9659-41ee-bedb-0e24931e2b8d.png)

#### :purple_square: FIND EMPLOYEE BY ID : http://localhost:8080/employeeId
![Screenshot (798)](https://user-images.githubusercontent.com/47708011/236825714-388a9185-487d-4c5f-922b-439dcadd9041.png)

#### :purple_square: UPDATE EMPLOYEE : http://localhost:8080/employee
![Screenshot (790)](https://user-images.githubusercontent.com/47708011/236825981-0086490b-c829-48e0-a5bf-19a5a3717fa5.png)

#### :purple_square: DELETE EMPLOYEE : http://localhost:8080/employee
![Screenshot (791)](https://user-images.githubusercontent.com/47708011/236826279-6db1cdea-d5ec-43a2-9769-d60c211a87f5.png)

#### :purple_square: SAVE ADDRESS : http://localhost:8080/address
SAVE ADDRESS operation already perform in SAVE EMPLOYEE!! 

#### :purple_square: FIND ALL ADDRESSES : http://localhost:8080/address
![Screenshot (792)](https://user-images.githubusercontent.com/47708011/236827067-959ae91c-0d3d-4f4c-80f8-e6cb1be98bf6.png)

#### :purple_square: FIND ADDRESS BY ID : http://localhost:8080/addressId
![Screenshot (794)](https://user-images.githubusercontent.com/47708011/236827395-718317ef-527e-411c-9055-be7da12584db.png)

#### :purple_square: UPDATE EVENT : http://localhost:8080/address
![Screenshot (781)](https://user-images.githubusercontent.com/47708011/235762056-d3361eee-b747-426a-9c6d-665084ecbb16.png)

#### :purple_square: DELETE EVENT : http://localhost:8080/eventD/eventId/{eventId}
----------------------------------------------------------------------------------------------------------------------------------------------------------
