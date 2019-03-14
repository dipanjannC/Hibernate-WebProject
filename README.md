# Hibernate-WebProject

Grizzly -Store(ADMIN & VENDOR) WEB Project Using Hibernate FrameWork


This porject is based upon the basic concepts of Core & advanced(Servlet and JDBC) Java for the Backend,and 
HTML,CSS, BOOTSTRAP,JSP for the Front End.
Following the MODEL VIEW CONTROLLER(MVC) Architechture
Hibernate FrameWork(Advancement)


*************************************************************************************************************************************
KeyNote
*************************************************************************************************************************************
Its a responsive Website,it would redirect to differnt webpages according to the User i.e ADMIN or VENDOR

1. For a user you have 3 straight tries to unlock your profile.
	-Its there is successive falied attempts of a user it will permanently lock the account.

2. The Main Controller is the StoreServlet which is controlling all the operations & redirecting to different Servlets accordingly.

3. Dao Layer is Implemented with Hibernate Framework.
	-Taking the possiblity that you already have a database with some data.
	-It's not creating new Database using Hibernate.
	-It's VALIDATING , so You need to have the database. 

4. The Servlets are using  Service Layer Interfaces to connect to DAO Layer Interfaces such that complete abstraction is achieved.
	-The DAO layer Interfaces interacting with the respective classes which are implementing them.
    
5. Implementation of UserDefined Exceptions are done. 

6. Log4j is imlemented for  logging the error.

**************************************************************************************************************************************

DATABASE- MYSQL
**************************************************************************************************************************************

Database - grizzly_storeDB;

Tables - 
1. user_details - storing the login credentials for all the users , with columns 
	user_name-varchar (as primary key)
	user_password-varchar
	user_role-(as admin or vendor) 
	user_status-varchar (as active or inactive as the account will be inactive after 3 falied attempts of login).
	
Login Credentials-

ADMIN
	1. UserName- dipanjan
   	   Password- paradox

	2. UserName- conan
           Password- sherlocked
 
	3. UserName- paulo
   	   Password- alchemist

VENDOR
	1. UserName- google
	   Password- firebase

	2. UserName- facebook
           Password- cassandra

	3. UserName- amazon
           Password- dynamo


	 	    
2.product_details - storing the data related to products 
	product_id-int (as primary key)
	product_name-varchar 
	product_brand-varchar
	product_category-varchar
	product_description-varchar
	product_rating-double 
	product_price-double 

3.inventory - storing the additional data related to the product  accessable only by the vendor
	product_id-int(as foreign key to the  product_id of product_details table)
	inventory_buffer-int (would be updated only by vendor)
	inventory_stock-int(would be updated only by admin)

*************************************************************************************************************************************

DEVELOPMENT- JAVA & (HTML,CSS,BOOTSTRAP,JSP)
*************************************************************************************************************************************

1.FRONT END 

	-Login.JSP
		This page is taking the user credentials as input and redicting to the #FetchServlet. 
	
	-AdminDisplay.JSP
		This page is displaying view of ADMINS Access with features of adding a new product which 
		would be stored in the PRODUCT_DETAILS table in the DB.

	-VendorDisplay.JSP
		This page is displaying view of VENDORS Access with features of adding a product which 
		would be stored in the INVENTORY table in the DB.

	-ManageStock.JSP
		This page is displaying the content of the product listed in the PRODUCT_DETAILS table in the form
		where the VENDOR can update INVENTORY_STOCK

*************************************************************************************************************************************

2. BACKEND

   There are four packages
	i)com.grizzly.controller- Having all the JAVA Servlet Classes
		-StoreServlet : This is the main Controller , all the opertaions are done through this servlet.

		-LoginServlet : Fetchs the input from the JSP pages and call the DAO Layer functions.
				FUNCTIONALITY : Validates the login credentials and redirects accordingly i.e ADMIN or VENDOR.
 
		-FetchServlet : Fetchs the input from the LoginDAO and call the DAO Layer functions.
				FUNCTIONALITY : Fetches the Details from the Dao Layer as ArrayLists and redirects to the JSP Pages .		
 
	ii)com.grizzly.dao- Having all the JAVA Data Access Object(DAO) Classes
		-DAO interfaces with following methods in it. 
			-LoginDao
			-ProductManagementDao
		
		-HibernateUtil : Used for making the Database connection.	
		-LoginhibernateDaoImpl : Having the Fuctionalties to LOCK and FETCH the User Credentials from the DATABASE.
		-ProductManagementHibernateImpl : Having all the fuctions related to DATABASE.
	
	iii)com.grizzly.pojo - Having all Plain Old JAVA Objects(POJO) Classes.
		-LoginPojo : Login Data values taken as a input from Login.JSP page to check accordingly.
		-ProductDetailsPojo : Product Data values to be played in the AdminDisplay.JSP page i.e when ADMIN accesess.
		-InventoryDetailsPojo : Inventory Data values to be played in the VendorDisplay.JSP page i.e when VENDOR accesess.
		-InventoryPojo : Inventory Data values to be displayed while adding Stock in the ManageStock.JSP page. 
	
	iv)com.grizzly.validation - Having the basic JAVA Classes for Input Validations
		-InputValidation.java :	Checking if the rating inserted while adding product is a Integer or Decimal(upto 1 Decimal place).
		-WebsiteException.java : Java class used to define the UserDefined Servlet.
	
	 v)com.grizzly.service - This the Service layer which is used to interact with the Database Interfaces.
			   INTERFACES:					 CLASSES:
				     -InventoryService				-InventoryService
				     -ProductService				-ProductService
				     -LoginService				-LoginService

				
	vi)com.grizzly.entity -	This is the entity class of the follwing tables.
				-InventoryEntity : Entity class of the "inventory" Table.
				-ProductDetailsEntity : Entity Class of the "product_details" Table.
				-UserDetailsEntity : Entity Class of the "user_details"	Table.


*******************************************************************************************************************************************
                                                             THANK YOU
