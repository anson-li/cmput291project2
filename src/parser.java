/**
* Phase 1: Preparing Data Files
*
* Write a program that reads reviews from standard input and construct the following four files.
* Before constructing these files, escape every double quote " in the input by replacing it with &quot; 
* and escape every backslash (\) by replacing it with double backslash (\\). 
* Backslash is escaped since Berkeley DB does not like it in the input; double quote is also escaped so 
* the symbol can be used to encode the character strings.
*
* reviews.txt: This file has one row for each review record. The fields are ordered as given in the input, 
* and the consecutive fields are separated by a comma. The fields product title, profile name (of the reviewer), 
* review summary and review text are placed inside quotations to avoid a possible mixup in the separator character, 
* for example when a comma appears inside a text field. The first field is the record number (or record id) which is assigned 
* sequentially to input records with the first record assigned id 1. Here is this file for our sample file with 10 records.
*
* pterms.txt: This file includes terms of length 3 or more characters extracted from product titles; a term is a consecutive 
* sequence of alphanumeric and underscore '_' characters, i.e [0-9a-zA-Z_] or the character class \w in Perl or Python. 
* The format of the file is as follows: for every term T in a product title of a review with id I, there is a row in 
* this file of the form T',I where T' is the lowercase form of T. That means, terms must be converted to all lowercase before 
* writing them in this file. Here is the respective file for our sample file with 10 records.
*
* rterms.txt: This file includes terms of length 3 or more characters extracted from the fields review summary and 
* review text. The file format and the way a term is defined is the as given above for the filepterms.txt. 
* Here is the respective file for our sample file with 10 records.
*
* scores.txt: This file includes one line for each review record in the form of sc:I where sc is the review score 
* and I is the review id. Here is the respective file for our sample file with 10 records.
*
* These files can also be found at directory ~drafiei/291/pub on the lab machines. 
* In the same directory, you would also find larger size files (such as 1k and 10k records) that you may want to use 
* in the testings of your programs.
**/

import com.sleepycat.db.*

public class parser {

public static void main(String[] args){

	try {

		// demo code
		//database configuration
		DatabaseConfig dbConfig = new DatabaseConfig();
		dbConfig.setType(DatabaseType.BTREE);
		dbConfig.setAllowCreate(true);
		dbConfig.setSortedDuplicates(true); // setting flag for apllowing duplicates
		
		//Create a database 
		Database std_db = new Database("alphabets.db", null, dbConfig);
		OperationStatus oprStatus;

		//Inserting Data into a database
		DatabaseEntry key = new DatabaseEntry();
		DatabaseEntry data = new DatabaseEntry();

		//Other variables
		String id = "1";
		String name="I";
		data.setData(name.getBytes());
		data.setSize(name.length()); 
		key.setData(id.getBytes()); 
		key.setSize(id.length());
		oprStatus = std_db.put(null, key, data);

		id = "1";
		name="J";
		data.setData(name.getBytes());
		data.setSize(name.length()); 
		key.setData(id.getBytes()); 
		key.setSize(id.length());
		oprStatus = std_db.put(null, key, data);

		id = "1";
		name="K";
		data.setData(name.getBytes());
		data.setSize(name.length()); 
		key.setData(id.getBytes()); 
		key.setSize(id.length());
		oprStatus = std_db.put(null, key, data);

		// Closing the connection
    		std_db.close();

  } // end of try 

  catch (Exception ex) 
   { ex.getMessage();} 

}