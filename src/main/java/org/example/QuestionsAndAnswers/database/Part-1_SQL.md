### How Indexing works and how it helps to improve the performance
* technique used to speed up data retrieval.
* internally index is seperate data structure that stores the indexed column values along with pointers to the actual rows in the table.
* Most Relational Database implements indexing using B-tree and this tree is balanced (all teaf nodes are the same level.)
* searching starts from the root node and intermediate nodes guide the search path leaf nodes stores key values and pointers to the data rows.
* when a query condition is executed instead of scanning every row in the table, the database 
  * searches the index tree
  * navigate down tree using the comparisons
  * reaching the leaf node contain the key
  * uses the stored pointer to directly fetch the required row
  * this reduces search complexity from o(n) to o(log n)
* indexing slightly slows down insert, update and delete operation because the index must also be updated and they require extra storage;
### How indexing improve the performance
* faster select queries by avoiding full table scans
* efficient sorting for order by queries since data is already ordered in the index
* foster join operation when indexing exists on join columns
* redis disk i/o which is main bottleneck in database;

### what is 2PC ?
* TWO PHASE COMMIT : is a distributed transaction protocol used to ensure automicity that is a transaction either commits on all systems or roll back on all.
* why needed : in distributed system a transaction may involves multiple services or databases. if one commits and another fails data becomes inconsistent.
* How ?
  * Phase 1 : prepare:
    * a coordinator ask all partipating nodes : "Can you commit?"
      * each participant check if it can commit, writes changes to log and responds with yes or no
  * Phase 2 : Commit (Decision Phase)
    * if all participants vote YES:
      * coordinator sends commit 
      * all nodes commit the transaction
    * if any participant votes NO :
      * coordinator senda rollback
      * all nodes check the transaction

### what is an index? explain its different types.
* A database index is a data structure taht provides a quick lookup of data in a column or columns of a table. it enhances the speed of operations accessing data from a data base tables at cost of additional writes and memory to mentain the index data structure.
* different types:
  * unique index : helps to mentain data intigrity by ensuring that no two rows of data in a table have identical key values.
  ```sql 
    CREATE UNIQUE INDEX myindex ON students(enroll_no);
  ```
  * non unique index : are not used to enforce contraints on the table with which the are associated. instead non unique indexes are used sololy to improve query performance by maintaining a sorted order of data values that are used frequently.
  * clustered index : are indexes where order of the rows in the database corresponds to the order of the rows in the index. this why only one clustered index can exist in a given table whereas mulitple non clustered indexes can exists in the table.
  * only difference between clustered and non clustered indses is that the databse manager attempts to keep the data in the db in the same order as corresponding keys appear in the clustered index.

